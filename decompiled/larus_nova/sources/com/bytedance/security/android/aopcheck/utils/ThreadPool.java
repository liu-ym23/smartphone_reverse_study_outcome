package com.bytedance.security.android.aopcheck.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadPool {
    private static volatile ThreadPoolExecutor sDefaultThreadPool;

    public ThreadPool() {
    }

    public static ThreadPoolExecutor getDefaultThreadPool() {
        if (sDefaultThreadPool != null) goto L15;
        monitor-enter(ThreadPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDefaultThreadPool != null) goto L9;
        sDefaultThreadPool = new PThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new AnonymousClass1());     // Catch: Throwable -> L11
        sDefaultThreadPool.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadPool.class);     // Catch: Throwable -> L11
    L15:
        return sDefaultThreadPool;
    }
}
