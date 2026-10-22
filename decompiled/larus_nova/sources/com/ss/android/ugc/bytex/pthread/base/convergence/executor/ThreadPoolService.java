package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadFactoryProxy;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ThreadPoolService;", "", "()V", "createLightExecutor", "Ljava/util/concurrent/Executor;", "priority", "", "threadPrefix", "", "maxPoolSize", "createLightPriorityExecutor", "createPriorityThreadFactory", "Ljava/util/concurrent/ThreadFactory;", "factory", "transformExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "PriorityThreadFactory", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadPoolService {
    public static final ThreadPoolService INSTANCE = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ThreadPoolService$PriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "factory", "priority", "", "(Ljava/util/concurrent/ThreadFactory;I)V", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "priorityAffinity", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class PriorityThreadFactory implements PriorityProvider, ThreadFactory {
        private final ThreadFactory factory;
        private final int priority;

        public PriorityThreadFactory(ThreadFactory r100, int r101) {
            this.factory = r100;
            this.priority = r101;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            return this.factory.newThread(r100);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
        public int priorityAffinity() {
            return this.priority;
        }
    }

    static {
        INSTANCE = new ThreadPoolService();
    }

    private ThreadPoolService() {
    }

    public static /* synthetic */ Executor createLightExecutor$default(ThreadPoolService r100, int r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = 1;
    L6:
        return r100.createLightExecutor(r101, r102, r103);
    }

    public static /* synthetic */ Executor createLightPriorityExecutor$default(ThreadPoolService r100, int r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = 1;
    L6:
        return r100.createLightPriorityExecutor(r101, r102, r103);
    }

    public final Executor createLightExecutor(int r110, String r111, int r112) {
        return new ResourceExecutor(new SchedulerExecutor(r110), 0, r112, new LinkedBlockingQueue(), 0, null, r111, 50, null);
    }

    public final Executor createLightPriorityExecutor(int r110, String r111, int r112) {
        return new ResourceExecutor(new SchedulerExecutor(r110), 0, r112, new PriorityBlockingQueue(), 0, null, r111, 50, null);
    }

    public final ThreadFactory createPriorityThreadFactory(int r100) {
        return new PriorityThreadFactory(Executors.defaultThreadFactory(), r100);
    }

    public final ThreadFactory createPriorityThreadFactory(ThreadFactory r100, int r101) {
        return new PriorityThreadFactory(r100, r101);
    }

    public final ThreadPoolExecutor transformExecutor(ThreadPoolExecutor r100, int r101) {
        ThreadFactory r102 = r100.getThreadFactory();
        if ((r102 instanceof ThreadFactoryProxy) == false) goto L5;
        r102 = ((ThreadFactoryProxy) r102).getDelegate();
    L5:
        PriorityThreadFactory r103 = new PriorityThreadFactory(r102, r101);
        ThreadFactoryProxy.Companion r104 = ThreadFactoryProxy.Companion;
        if ((r100 instanceof ScheduledExecutorService) == false) goto L8;
        int r105 = 8;
    L9:
        r100.setThreadFactory(r104.proxy(r103, r105));
        return r100;
    L8:
        r105 = 2;
        goto L9
    }
}
