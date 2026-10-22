package com.bytedance.ee.util.ui;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f243165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile iu5.a f243166b;

    static {
        f243165a = new Handler(Looper.getMainLooper());
    }

    public static void c() {
        if (f243166b == null) goto L5;
        return;
    L5:
        monitor-enter(iu5.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f243166b != null) goto L9;
        f243166b = new iu5.a(f243165a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(iu5.a.class);     // Catch: Throwable -> L11
    }

    public static void a(Runnable r100) {
        c();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        f243166b.f495799a.post(r100);
    }

    public static void d(Runnable r100) {
        c();
        f243166b.f495799a.post(r100);
    }

    public static void e(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (f243166b == null) goto L12;
        Handler r101 = f243166b.f495799a;
        if (r101 == null) goto L11;
        r101.removeCallbacks(r100);
        return;
    L11:
        return;
    }

    public static void b(Runnable r100, long r101) {
        c();
        f243166b.f495799a.postDelayed(r100, r101);
    }
}
