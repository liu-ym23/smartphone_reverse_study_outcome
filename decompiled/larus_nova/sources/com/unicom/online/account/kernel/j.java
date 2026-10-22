package com.unicom.online.account.kernel;

import android.content.Context;
import com.amap.api.col.s.ce;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes41.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f462059a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f462060b;

    static {
        f462059a = ce.f26395j;
        f462060b = Boolean.TRUE;
    }

    public j() {
    }

    private static String a() {
        Enumeration<NetworkInterface> r100 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L16
    L4:
        if (r100.hasMoreElements() == false) goto L26;
        Enumeration<InetAddress> r101 = r100.nextElement().getInetAddresses();     // Catch: SocketException -> L16
    L7:
        if (r101.hasMoreElements() == false) goto L4;
        InetAddress r102 = r101.nextElement();     // Catch: SocketException -> L16
        if (r102.isLoopbackAddress() == true) goto L7;
        if ((r102 instanceof Inet4Address) == false) goto L7;
        return r102.getHostAddress();
    L26:
        return null;
    L14:
        return null;
    }

    public static String a(Context r100, String r101, String r102) {
        String r103 = c(r100, r101, r102);     // Catch: Exception -> L8
        if (an.b(r103).booleanValue() == false) goto L6;
        return m.a(r100, r103);
    L6:
        return null;
    L11:
        return null;
    }

    public static void a(Context r100) {
        if (r100 == null) goto L5;
        m.d(r100, "accessCode");
        return;
    }

    public static boolean a(Context r100, String r101, String r102, String r103) {
        if (an.b(r103).booleanValue() == false) goto L8;
        String r104 = c(r100, r101, r102);
        if (an.b(r104).booleanValue() == true) goto L7;
        return false;
    L7:
        return m.a(r100, r104, r103);
    L8:
        return false;
    }

    public static void b(Context r100, String r101, String r102) {
        if (r100 == null) goto L5;
        m.d(r100, "accessCode" + r101 + r102);
        return;
    }

    private static String c(Context r100, String r101, String r102) {
        String r103 = al.a(r100);
        String r104 = a();
        if (an.b(r104).booleanValue() == true) goto L5;
        return null;
    L5:
        return "accessCode" + r101 + r102 + r103 + r104;
    }
}
