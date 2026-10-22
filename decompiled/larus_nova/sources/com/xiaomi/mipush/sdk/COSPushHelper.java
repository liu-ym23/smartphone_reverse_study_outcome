package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes41.dex */
public class COSPushHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f463028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile boolean f144a;

    public COSPushHelper() {
    }

    public static void onNotificationMessageCome(Context r100, String r101) {
    }

    public static void onPassThoughMessageCome(Context r100, String r101) {
    }

    public static boolean getNeedRegister() {
        return f144a;
    }

    public static void convertMessage(Intent r100) {
        f.a(r100);
    }

    public static void doInNetworkChange(Context r100) {
        long r101 = SystemClock.elapsedRealtime();
        if (getNeedRegister() == false) goto L10;
        long r102 = f463028a;
        if (r102 > 0) goto L7;
    L8:
        f463028a = r101;
        registerCOSAssemblePush(r100);
        return;
    L7:
        if ((r102 + 300000) <= r101) goto L8;
        return;
    }

    public static boolean hasNetwork(Context r100) {
        return f.m8766a(r100);
    }

    public static void registerCOSAssemblePush(Context r100) {
        AbstractPushManager r101 = e.a(r100).a(d.f463057c);
        if (r101 == null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH :  register cos when network change!");
        r101.register();
        return;
    }

    public static synchronized void setNeedRegister(boolean r100) {
        monitor-enter(COSPushHelper.class);
        f144a = r100;     // Catch: Throwable -> L7
        monitor-exit(COSPushHelper.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void uploadToken(Context r100, String r101) {
        f.m8765a(r100, d.f463057c, r101);
    }
}
