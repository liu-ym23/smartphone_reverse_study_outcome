package io.reactivex.internal.schedulers;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() throws Exception {
        this.runner = ThreadMethodProxy.currentThread();
        this.runnable.run();     // Catch: Throwable -> L6
        lazySet(AbstractDirectTask.FINISHED);
        this.runner = null;
        return null;
    L6:
        th = move-exception;
        lazySet(AbstractDirectTask.FINISHED);
        this.runner = null;
        throw th;
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    public ScheduledDirectTask(Runnable r100) {
        super(r100);
    }
}
