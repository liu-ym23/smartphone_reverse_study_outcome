package com.cmic.ida.sdk;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes22.dex */
public class x0 {
    public static String[] a(boolean r110) {
        String[] r100 = {"", ""};
        StringBuilder r101 = new StringBuilder();
        StringBuilder r102 = new StringBuilder();
        Enumeration<NetworkInterface> r103 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L35
    L5:
        if (r103.hasMoreElements() == false) goto L28;
        NetworkInterface r104 = r103.nextElement();     // Catch: Exception -> L35
        if (r110 == false) goto L11;
        if (r104.getName().toLowerCase().contains("wlan") == true) goto L5;
    L11:
        Enumeration<InetAddress> r105 = r104.getInetAddresses();     // Catch: Exception -> L35
    L13:
        if (r105.hasMoreElements() == false) goto L5;
        InetAddress r106 = r105.nextElement();     // Catch: Exception -> L35
        if (r106.isLoopbackAddress() == true) goto L13;
        if (r106.isLinkLocalAddress() == true) goto L13;
        String r107 = r106.getHostAddress();     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r107) == true) goto L13;
        if ((r106 instanceof Inet6Address) == true) goto L23;
        if ((r106 instanceof Inet4Address) == false) goto L13;
        r102.append(r107);     // Catch: Exception -> L35
        r102.append(",");     // Catch: Exception -> L35
        goto L13
    L23:
        r101.append(r107);     // Catch: Exception -> L35
        r101.append(",");     // Catch: Exception -> L35
        goto L13
    L28:
        if (TextUtils.isEmpty(r101) == true) goto L31;
        r101 = r101.delete(r101.length() - 1, r101.length());     // Catch: Exception -> L35
    L31:
        if (TextUtils.isEmpty(r102) == true) goto L33;
        r102 = r102.delete(r102.length() - 1, r102.length());     // Catch: Exception -> L35
    L33:
        r100[0] = r102.toString();     // Catch: Exception -> L35
        r100[1] = r101.toString();     // Catch: Exception -> L35
        u.a("UmcIPUtils", "onlyMobileDataIp " + r110 + " IPV6 ip：" + r101.toString());     // Catch: Exception -> L35
        u.a("UmcIPUtils", "onlyMobileDataIp " + r110 + " IPV4 ip：" + r102.toString());     // Catch: Exception -> L35
        return r100;
    L35:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }
}
