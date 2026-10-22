package com.bytedance.bdp.appbase.base.bdptask;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends AbstractExecutorService {
    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r100, TimeUnit r101) {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return null;
    }

    public a() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        new BdpTask.Builder().onIO().runnable(r100).start();
    }
}
