package com.bytedance.ee.bear.lark;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes16.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile z f227591a;

    public z() {
    }

    public static z b() {
        if (f227591a != null) goto L15;
        monitor-enter(z.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f227591a != null) goto L9;
        f227591a = new z();     // Catch: Throwable -> L11
    L9:
        monitor-exit(z.class);     // Catch: Throwable -> L11
    L15:
        return f227591a;
    }

    public static void a(String[] r100) {
        lc5.x.c().b();
        String[] r101 = new String[r100.length + 1];
        r101[0] = "init";
        System.arraycopy(r100, 0, r101, 1, r100.length);
        lc5.x r102 = lc5.x.c();
        r102.getClass();
        r102.k(SystemClock.uptimeMillis(), r101);
    }
}
