package com.xiaomi.push;

import android.util.Log;

/* JADX INFO: loaded from: classes41.dex */
class er {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f463499a = false;

    static {
        f463499a = Log.isLoggable("BCompressed", 3);
    }

    public static byte[] a(eq r100, byte[] r101) {
        byte[] r102 = eu.a.a(r101);     // Catch: Exception -> L9
        if (f463499a == false) goto L8;
        com.xiaomi.channel.commonutils.logger.b.m8719a("BCompressed", "decompress " + r101.length + " to " + r102.length + " for " + r100);     // Catch: Exception -> L9
        if (r100.f515a != 1) goto L8;
        com.xiaomi.channel.commonutils.logger.b.m8719a("BCompressed", "decompress not support upStream");     // Catch: Exception -> L9
    L8:
        return r102;
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8719a("BCompressed", "decompress error " + e);
        return r101;
    }
}
