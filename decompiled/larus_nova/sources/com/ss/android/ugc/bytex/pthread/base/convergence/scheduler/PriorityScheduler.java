package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityScheduler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "priority", "", "executor", "Ljava/util/concurrent/Executor;", "(ILjava/util/concurrent/Executor;)V", "scheduling", "", "type", "runnable", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class PriorityScheduler implements Scheduler {
    private final Executor executor;
    private final int priority;

    public PriorityScheduler(int r100, Executor r101) {
        this.priority = r100;
        this.executor = r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.scheduler.Scheduler
    public boolean scheduling(int r100, PriorityRunnable r101) {
        int r102 = r101.priorityAffinity();
        int r103 = this.priority;
        if (r102 >= r103) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        this.executor.execute(r101);
    L10:
        return r104;
    L5:
        if (r102 >= PriorityProvider.Companion.progressive(r103)) goto L7;
        r104 = true;
        goto L8
    }
}
