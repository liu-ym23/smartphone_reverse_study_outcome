package com.bytedance.badger.collect.impl.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.badger.collect.impl.abs.Singleton;
import com.bytedance.badger.collect.impl.model.ExecutorOptions;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes47.dex */
public class ExecutorManager {
    private static final int CORE_THREAD = 0;
    private static ExecutorManager instance;
    private static final Singleton<Looper> sDefaultLooper = null;
    private ExecutorService defaultIOExecutor;
    private Looper defaultLooper;
    private ExecutorService defaultNetExecutor;
    private Handler handler;

    private ExecutorManager() {
        int r110 = CORE_THREAD;
        TimeUnit r111 = TimeUnit.SECONDS;
        this.defaultNetExecutor = new PThreadPoolExecutor(2, r110 * 10, 30, r111, new LinkedBlockingQueue(), new DefaultThreadFactory("ExecutorManager"), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.defaultIOExecutor = new PThreadPoolExecutor(2, r110 * 10, 30, r111, new LinkedBlockingQueue(), new DefaultThreadFactory("ExecutorManager"), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static ExecutorManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(ExecutorManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ExecutorManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExecutorManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public Handler getHandler() {
        if (this.handler != null) goto L6;
        this.handler = new Handler(sDefaultLooper.get(new Object[0]));
    L6:
        return this.handler;
    }

    public Looper getLooper() {
        Looper r100 = this.defaultLooper;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return sDefaultLooper.get(new Object[0]);
    }

    static {
        CORE_THREAD = Runtime.getRuntime().availableProcessors();
        sDefaultLooper = new AnonymousClass1();
    }

    public ExecutorService getDefaultIOExecutor() {
        return this.defaultIOExecutor;
    }

    public ExecutorService getDefaultNetExecutor() {
        return this.defaultNetExecutor;
    }

    public void runOnIOExecutor(Runnable r100) {
        this.defaultIOExecutor.execute(r100);
    }

    public void runOnNetExecutor(Runnable r100) {
        this.defaultNetExecutor.execute(r100);
    }

    public void setExecutorOptions(ExecutorOptions r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ExecutorService r101 = r100.ioExecutor;
        if (r101 == null) goto L7;
        this.defaultIOExecutor = r101;
    L7:
        ExecutorService r102 = r100.networkExecutor;
        if (r102 == null) goto L10;
        this.defaultNetExecutor = r102;
    L10:
        Looper r103 = r100.looper;
        if (r103 == null) goto L14;
        this.defaultLooper = r103;
        return;
    }

    public <T> Future<T> submitToIOExecutor(Callable<T> r100) {
        return this.defaultIOExecutor.submit(r100);
    }
}
