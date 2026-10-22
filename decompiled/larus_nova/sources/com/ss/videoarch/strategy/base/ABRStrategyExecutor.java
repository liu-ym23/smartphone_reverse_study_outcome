package com.ss.videoarch.strategy.base;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes38.dex */
public class ABRStrategyExecutor extends PThreadPoolExecutor {
    private int queueThreshold;

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.base.ABRStrategyExecutor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class NamedThreadFactory implements ThreadFactory {
        private NamedThreadFactory() {
        }

        public /* synthetic */ NamedThreadFactory(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "LiveStrategy");
            ThreadMethodProxy.setPriority(r101, 10);
            return r101;
        }
    }

    private synchronized void checkAndClearQueue() {
        monitor-enter(this);
        BlockingQueue<Runnable> r100 = getQueue();     // Catch: Throwable -> L8
        if (r100.size() < this.queueThreshold) goto L6;
        r100.size();     // Catch: Throwable -> L8
        r100.clear();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        checkAndClearQueue();
        super.execute(r100);
    }

    public void setQueueThreshold(int r100) {
        this.queueThreshold = r100;
    }

    public ABRStrategyExecutor(int r100, int r110, long r111, TimeUnit r112, BlockingQueue<Runnable> r113) {
        super(r100, r110, r111, r112, r113, new NamedThreadFactory(null));
        this.queueThreshold = 5;
    }
}
