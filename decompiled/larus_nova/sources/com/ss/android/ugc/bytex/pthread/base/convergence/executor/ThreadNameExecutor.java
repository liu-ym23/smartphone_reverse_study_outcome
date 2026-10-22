package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadWorker;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ThreadNameExecutor;", "Ljava/util/concurrent/Executor;", "targetSet", "", "", "enablePriority", "", "targetExecutor", "defaultExecutor", "(Ljava/util/Set;ZLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V", "enable", "execute", "", "command", "Ljava/lang/Runnable;", "setEnable", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadNameExecutor implements Executor {
    private final Executor defaultExecutor;
    private volatile boolean enable;
    private final boolean enablePriority;
    private final Executor targetExecutor;
    private final Set<String> targetSet;

    public ThreadNameExecutor(Set<String> r100, boolean r101, Executor r102, Executor r103) {
        this.targetSet = r100;
        this.enablePriority = r101;
        this.targetExecutor = r102;
        this.defaultExecutor = r103;
        this.enable = true;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (this.enable == true) goto L5;
    L14:
        Executor r101 = this.defaultExecutor;
    L12:
        r101.execute(r100);
        return;
    L5:
        if ((r100 instanceof IThreadWorker) == false) goto L14;
        if (this.enablePriority == true) goto L9;
        ((IThreadWorker) r100).setPriorityEnable(false);
    L9:
        String r102 = ((IThreadWorker) r100).getDelegate().getName();
        if (this.targetSet.contains(r102) == false) goto L14;
        r101 = this.targetExecutor;
        goto L12
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }
}
