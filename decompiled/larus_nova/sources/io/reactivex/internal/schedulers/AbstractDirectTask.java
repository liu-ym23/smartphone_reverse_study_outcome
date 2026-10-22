package io.reactivex.internal.schedulers;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable {
    protected static final FutureTask<Void> DISPOSED = null;
    protected static final FutureTask<Void> FINISHED = null;
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    static {
        Runnable r100 = Functions.EMPTY_RUNNABLE;
        FINISHED = new FutureTask(r100, null);
        DISPOSED = new FutureTask(r100, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Future<?> r100 = get();
        if (r100 == FINISHED) goto L15;
        FutureTask<Void> r101 = DISPOSED;
        if (r100 != r101) goto L7;
        return;
    L7:
        if (compareAndSet(r100, r101) == false) goto L17;
        if (r100 != null) goto L10;
        return;
    L10:
        if (this.runner == ThreadMethodProxy.currentThread()) goto L12;
        boolean r102 = true;
    L13:
        r100.cancel(r102);
        return;
    L12:
        r102 = false;
        goto L13
    L17:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> r100 = get();
        if (r100 != FINISHED) goto L5;
    L8:
        return true;
    L5:
        if (r100 == DISPOSED) goto L8;
        return false;
    }

    public Runnable getWrappedRunnable() {
        return this.runnable;
    }

    public AbstractDirectTask(Runnable r100) {
        this.runnable = r100;
    }

    public void setFuture(Future<?> r100) {
    L2:
        Future<?> r101 = get();
        if (r101 == FINISHED) goto L19;
        if (r101 == DISPOSED) goto L8;
        if (compareAndSet(r101, r100) == false) goto L2;
        return;
    L8:
        if (this.runner == ThreadMethodProxy.currentThread()) goto L10;
        boolean r102 = true;
    L11:
        r100.cancel(r102);
        return;
    L10:
        r102 = false;
        goto L11
    }
}
