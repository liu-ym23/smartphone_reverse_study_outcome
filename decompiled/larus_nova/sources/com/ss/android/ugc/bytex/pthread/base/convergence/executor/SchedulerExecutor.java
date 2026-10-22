package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityRunnable;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/SchedulerExecutor;", "Ljava/util/concurrent/Executor;", "priorityAffinity", "", "(I)V", "execute", "", "command", "Ljava/lang/Runnable;", "DelegatePriorityRunnable", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class SchedulerExecutor implements Executor {
    private final int priorityAffinity;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/SchedulerExecutor$DelegatePriorityRunnable;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "delegate", "Ljava/lang/Runnable;", "priorityAffinity", "", "(Ljava/lang/Runnable;I)V", "run", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class DelegatePriorityRunnable implements PriorityRunnable {
        private final Runnable delegate;
        private final int priorityAffinity;

        public DelegatePriorityRunnable(Runnable r100, int r101) {
            this.delegate = r100;
            this.priorityAffinity = r101;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.PriorityProvider
        public int priorityAffinity() {
            return this.priorityAffinity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.delegate.run();
        }
    }

    public SchedulerExecutor(int r100) {
        this.priorityAffinity = r100;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (r100 == null) goto L5;
        SuperThreadPool.INSTANCE.execute(new DelegatePriorityRunnable(r100, this.priorityAffinity), 2);
        return;
    }
}
