package com.bytedance.badger.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile m f199270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f199271c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f199272a;

    static {
        f199271c = Math.max(2, Runtime.getRuntime().availableProcessors() * 2);
    }

    public m() {
        l r100 = new l();
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(2, f199271c, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(256), r100, new ThreadPoolExecutor.CallerRunsPolicy());
        r101.allowCoreThreadTimeOut(true);
        this.f199272a = r101;
    }

    public static m a() {
        if (f199270b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f199270b != null) goto L9;
        f199270b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f199270b;
    }

    public final void b(Runnable r100) {
        this.f199272a.execute(r100);     // Catch: Exception -> L4
        return;
    }
}
