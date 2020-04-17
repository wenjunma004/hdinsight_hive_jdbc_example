package com.microsoft.hdinsight;
/**
 * HiveClient.java - a demo class how to connect normal cluster.
 * @author  Wenjun Ma
 * @version 1.0
 */
import java.sql.*;

public class HiveClient {

    private static String HiveDriverName = "org.apache.hive.jdbc.HiveDriver";
    private static String jdbcUrl = "jdbc:hive2://zk0-wenjml.e5hngsuf0p5etjvfhkh113wsyd.xx.internal.cloudapp.net:2181,zk2-wenjml.e5hngsuf0p5etjvfhkh113wsyd.xx.internal.cloudapp.net:2181,zk4-wenjml.e5hngsuf0p5etjvfhkh113wsyd.xx.internal.cloudapp.net:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2-interactive";
    private static String userName = "admin";
    private static String userPass = "$Amsung762";

    public static void main(String[] args) throws Exception {
        Class.forName(HiveDriverName);
        Connection con = DriverManager.getConnection(jdbcUrl, userName, userPass);
        System.out.println("\n Got Connection: " + con);
        System.out.println("\n Run show tables command and listing 'default' Database tables of hive.");
        Statement stmt = con.createStatement();
        String sql = "show tables";
        System.out.println("\n Executing Query: " + sql);
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n -----------------Result start------------------");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        System.out.println("\n -----------------Result start------------------");
    }
}
