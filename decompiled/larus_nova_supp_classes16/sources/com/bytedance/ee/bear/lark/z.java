package com.bytedance.ee.bear.lark;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z {
    public static volatile z a;

    public z() {
    }

    public static z b() {
        if (a != null) goto L15;
        monitor-enter(z.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new z();     // Catch: Throwable -> L11
    L9:
        monitor-exit(z.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public static void a(String[] r4) {
        lc5.x.c().b();
        String[] r0 = new String[r4.length + 1];
        r0[0] = "init";
        System.arraycopy(r4, 0, r0, 1, r4.length);
        lc5.x r5 = lc5.x.c();
        r5.getClass();
        r5.k(SystemClock.uptimeMillis(), r0);
    }
}
