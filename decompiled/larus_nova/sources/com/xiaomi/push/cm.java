package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463253a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cq f323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f324a;

    private static synchronized String a() {
        monitor-enter(cm.class);
        String r100 = f324a;     // Catch: Throwable -> L7
        monitor-exit(cm.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private static int a(Context r100) {
        au r101 = at.m8812a();     // Catch: Exception -> L26
        if (r101 != null) goto L6;
        b(null);     // Catch: Exception -> L26
        return -1;
    L6:
        if (r101.a() != 0) goto L16;
        String r102 = r101.m8824b();     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L12:
        String r103 = null;
    L13:
        b(r103);     // Catch: Exception -> L26
        return 0;
    L10:
        if ("UNKNOWN".equalsIgnoreCase(r102) == true) goto L12;
        r103 = "M-" + r102;     // Catch: Exception -> L26
        goto L13
    L16:
        if (r101.a() != 1) goto L18;
    L22:
        b("WIFI-ID-UNKNOWN");     // Catch: Exception -> L26
        return 1;
    L18:
        if (r101.a() == 6) goto L22;
        b(null);     // Catch: Exception -> L26
        return -1;
    L26:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("DisconnectStatsHelper getNetType occurred error: " + e.getMessage());
        b(null);
        return -1;
    }

    private static synchronized void b(String r100) {
        monitor-enter(cm.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if ("WIFI-ID-UNKNOWN".equals(r100) == false) goto L12;
        String r101 = f324a;     // Catch: Throwable -> L16
        if (r101 != null) goto L9;
    L11:
        f324a = null;     // Catch: Throwable -> L16
    L13:
        a("updateNetId new networkId = " + r100 + ", finally netId = " + f324a);     // Catch: Throwable -> L16
        monitor-exit(cm.class);
        return;
    L9:
        if (r101.startsWith("W-") == false) goto L11;
    L12:
        f324a = r100;     // Catch: Throwable -> L16
        goto L13
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8909a(Context r100) {
        if (m8910a(r100) == true) goto L6;
        a("onReconnection shouldSampling = false");
        return;
    L6:
        long r101 = System.currentTimeMillis();
        f463253a = a(r100);
        cp.a(r100, r101);
        a("onReconnection connectedNetworkType = " + f463253a);
    }

    public static void a(String r100) {
        cj.a("Push-DiscntStats", r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m8910a(Context r100) {
        return cj.a(r100);
    }

    public static void a(Context r100, String r101) {
        if (m8910a(r100) == true) goto L6;
        a("onWifiChanged shouldSampling = false");
        return;
    L6:
        a("onWifiChanged wifiDigest = " + r101);
        if (TextUtils.isEmpty(r101) == true) goto L10;
        b("W-" + r101);
        return;
    }

    public static void b(Context r100, ez r101) {
        cq r102 = f323a;
        if (r102 == null) goto L6;
        r101.b(r102);
        f323a = null;
        a("stopStats");
        return;
    }

    public static void a(Context r100, ez r101) {
        if (m8910a(r100) == true) goto L5;
        return;
    L5:
        if (f323a != null) goto L7;
        f323a = new cq(r100);
    L7:
        r101.a(f323a);
        a("startStats");
    }

    public static void a(Context r110, String r111, int r112) {
        if (m8910a(r110) == true) goto L6;
        a("onDisconnection shouldSampling = false");
        return;
    L6:
        long r100 = System.currentTimeMillis();
        int r101 = a(r110);
        cp.a(r110, r111, at.b(r110), r100, r112, com.xiaomi.push.service.m.a(r110).m9394b(), r101, a(), f463253a);
        a("onDisconnection");
    }
}
