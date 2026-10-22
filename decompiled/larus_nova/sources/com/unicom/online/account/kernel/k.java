package com.unicom.online.account.kernel;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f462061a;

    public static boolean a(Context r110) {
        if (f462061a == false) goto L5;
        return true;
    L5:
        Long r100 = m.b(r110, "success_limit_time");
        long r101 = System.currentTimeMillis();
        if (r100 != null) goto L10;
        m.a(r110, "success_limit_time", Long.valueOf(r101));
        return true;
    L10:
        if ((r101 - r100.longValue()) <= 600000) goto L13;
        m.a(r110, "success_limit_time", Long.valueOf(r101));
        m.a(r110, "success_limit_count", 0L);
        return true;
    L13:
        Long r102 = m.b(r110, "success_limit_count");
        if (r102 != null) goto L18;
        m.a(r110, "success_limit_count", 0L);
        return true;
    L18:
        if (r102.longValue() >= 50) goto L20;
        return true;
    L20:
        return false;
    }

    public static void b(Context r100) {
        Long r101 = m.b(r100, "success_limit_count");
        if (r101 != null) goto L7;
        long r102 = 0;
    L5:
        m.a(r100, "success_limit_count", Long.valueOf(r102));
        return;
    L7:
        r102 = r101.longValue() + 1;
        goto L5
    }
}
