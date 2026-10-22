package com.facebook.common.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public class CallerThreadExecutor extends AbstractExecutorService {
    private static final CallerThreadExecutor sInstance = null;

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    static {
        sInstance = new CallerThreadExecutor();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }

    private CallerThreadExecutor() {
    }

    public static CallerThreadExecutor getInstance() {
        return sInstance;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        r100.run();
    }
}
