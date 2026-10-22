package com.bytedance.dora.wlan.p2p;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
public final class u {
    public static byte[] a() {
        String r100 = b();     // Catch: Exception -> L15
        if (r100 == null) goto L17;
        pk4.j.d("DoraWifiP2pUtils", "generateDynamicGcIp: GO IP=".concat(r100));     // Catch: Exception -> L15
        String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L15
        if (r101.length != 4) goto L17;
        byte[] r102 = new byte[4];     // Catch: Exception -> L15
        int r103 = 0;
    L8:
        if (r103 >= 4) goto L10;
        r102[r103] = (byte) CastIntegerProtector.parseInt(r101[r103]);     // Catch: Exception -> L15
        r103 = r103 + 1;     // Catch: Exception -> L15
        goto L8
    L10:
        int r104 = r102[3] & UByte.MAX_VALUE;     // Catch: Exception -> L15
        SecureRandom r105 = new SecureRandom();     // Catch: Exception -> L15
    L11:
        int r106 = r105.nextInt(253) + 2;     // Catch: Exception -> L15
        if (r106 == r104) goto L11;
        r102[3] = (byte) r106;     // Catch: Exception -> L15
        pk4.j.d("DoraWifiP2pUtils", "generateDynamicGcIp: generated dynamic GC IP=" + (r102[0] & UByte.MAX_VALUE) + "." + (r102[1] & UByte.MAX_VALUE) + "." + (r102[2] & UByte.MAX_VALUE) + "." + (r102[3] & UByte.MAX_VALUE));     // Catch: Exception -> L15
        return r102;
    L17:
        pk4.j.d("DoraWifiP2pUtils", "generateDynamicGcIp: fallback to 192.168.49.2");
        return new byte[]{-64, -88, 49, 2};
    L15:
        e = move-exception;
        pk4.j.c("DoraWifiP2pUtils", "generateDynamicGcIp failed", e);
        goto L17
    }

    public static String b() {
        Enumeration<NetworkInterface> r100 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L49
        if (r100 != null) goto L6;
        return null;
    L6:
        Iterator r101 = Collections.list(r100).iterator();     // Catch: Exception -> L49
        String r102 = null;
    L7:
        if (r101.hasNext() == false) goto L48;
        NetworkInterface r103 = (NetworkInterface) r101.next();     // Catch: Exception -> L49
        if (r103.isLoopback() == true) goto L7;
        if (r103.isUp() == false) goto L7;
        if (r103.isVirtual() == true) goto L7;
        String r104 = r103.getName();     // Catch: Exception -> L49
        if (r104.startsWith("p2p") == false) goto L19;
    L24:
        boolean r105 = true;
    L25:
        boolean r106 = r104.contains("p2p");     // Catch: Exception -> L49
        if (r105 == true) goto L29;
        if (r106 == false) goto L7;
    L29:
        Iterator r107 = Collections.list(r103.getInetAddresses()).iterator();     // Catch: Exception -> L49
    L31:
        if (r107.hasNext() == false) goto L7;
        InetAddress r108 = (InetAddress) r107.next();     // Catch: Exception -> L49
        if (r108.isLinkLocalAddress() == true) goto L31;
        if ((r108 instanceof Inet4Address) == false) goto L31;
        String r109 = r108.getHostAddress();     // Catch: Exception -> L49
        if (r109 == null) goto L31;
        if (r109.contains(GXTemplateKey.GAIAX_PE) == false) goto L44;
        r109 = r109.split(GXTemplateKey.GAIAX_PE)[0];     // Catch: Exception -> L49
    L44:
        if (r109.startsWith("192.168.49.") == true) goto L45;
        if (r102 != null) goto L31;
        r102 = r109;
        goto L31
    L45:
        return r109;
    L19:
        if (r104.equals("wlan1") == true) goto L24;
        if (r104.equals("swlan0") == true) goto L24;
        r105 = false;
        goto L25
    L48:
        return r102;
    L49:
        e = move-exception;
        pk4.j.c("DoraWifiP2pUtils", "Failed to get Wi-Fi P2P IP address", e);
        return null;
    }

    public static String c(Object r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.toString().replace("\n", ",");
    }
}
