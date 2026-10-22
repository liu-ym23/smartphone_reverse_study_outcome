package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f463128a;

    public static boolean a(Context r100) {
        Class<?> r101 = q.a(r100, "com.bun.miitmdid.core.JLibrary");     // Catch: Throwable -> L7
        if (r101 == null) goto L13;
        a(r101, r100);     // Catch: Throwable -> L7
        return true;
    L13:
        return false;
    L7:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("mdid:check error " + th);
        return false;
    }

    private static void a(Class<?> r100, Context r101) {
        if (f463128a == false) goto L10;
        return;
    L10:
        f463128a = true;     // Catch: Throwable -> L7
        r100.getDeclaredMethod("InitEntry", new Class[]{Context.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("mdid:load lib error " + th);
    }
}
