package com.bytedance.reparo;

import android.app.Application;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<Runnable> f267458a = null;

    static {
        f267458a = new ConcurrentLinkedQueue();
    }

    public static void a(Application r100) {
        if (k.f267459b != null) goto L25;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (k.f267459b != null) goto L9;
        k.f267459b = new k(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L25:
        ConcurrentLinkedQueue<Runnable> r101 = f267458a;     // Catch: Throwable -> L22
        if (r101.isEmpty() == true) goto L32;
        Runnable r102 = r101.poll();     // Catch: Throwable -> L22
        if (r102 == null) goto L21;
        r102.run();     // Catch: Throwable -> L22
    L21:
        return;
    L32:
        return;
    }
}
