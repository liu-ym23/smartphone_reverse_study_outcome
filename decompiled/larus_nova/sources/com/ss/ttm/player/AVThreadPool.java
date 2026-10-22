package com.ss.ttm.player;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public final class AVThreadPool {
    private static ThreadPoolExecutor mExecutorInstance;
    private static volatile ExecutorService mExtExecutorInstance;

    public AVThreadPool() {
    }

    private static synchronized ExecutorService getExecutorInstance() {
        monitor-enter(AVThreadPool.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mExtExecutorInstance == null) goto L8;
        ExecutorService r100 = mExtExecutorInstance;     // Catch: Throwable -> L13
    L11:
        monitor-exit(AVThreadPool.class);
        return r100;
    L8:
        if (mExecutorInstance != null) goto L10;
        mExecutorInstance = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("/AVThreadPool"));     // Catch: Throwable -> L13
    L10:
        r100 = mExecutorInstance;     // Catch: Throwable -> L13
        goto L11
    }

    public static synchronized Future<String> addTask(Callable<String> r100) {
        monitor-enter(AVThreadPool.class);
        Future<String> r101 = getExecutorInstance().submit(r100);     // Catch: Throwable -> L7
        monitor-exit(AVThreadPool.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setExecutorInstance(ExecutorService r100) {
        monitor-enter(AVThreadPool.class);
        mExtExecutorInstance = r100;     // Catch: Throwable -> L7
        monitor-exit(AVThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void addTask(Runnable r100) {
        monitor-enter(AVThreadPool.class);
        getExecutorInstance().submit(r100);     // Catch: Throwable -> L7
        monitor-exit(AVThreadPool.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
