package io.reactivex.internal.schedulers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    static final Object ASYNC_DISPOSED = null;
    static final Object DONE = null;
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = null;
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = null;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    L2:
        Object r100 = get(1);
        if (r100 == DONE) goto L19;
        Object r101 = SYNC_DISPOSED;
        if (r100 == r101) goto L19;
        Object r102 = ASYNC_DISPOSED;
        if (r100 == r102) goto L19;
        if (get(2) == ThreadMethodProxy.currentThread()) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r101 = r102;
    L16:
        if (compareAndSet(1, r100, r101) == false) goto L2;
        if (r100 == null) goto L19;
        ((Future) r100).cancel(r103);
        goto L19
    L12:
        r103 = false;
    L19:
        Object r104 = get(0);
        if (r104 == DONE) goto L40;
        Object r105 = PARENT_DISPOSED;
        if (r104 == r105) goto L41;
        if (r104 == null) goto L42;
        if (compareAndSet(0, r104, r105) == false) goto L19;
        ((utc.a) r104).delete(this);
        return;
    L42:
        return;
    L41:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Object r100 = get(0);
        if (r100 != PARENT_DISPOSED) goto L5;
    L6:
        return true;
    L5:
        if (r100 == DONE) goto L6;
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        io_reactivex_internal_schedulers_ScheduledRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        PARENT_DISPOSED = new Object();
        SYNC_DISPOSED = new Object();
        ASYNC_DISPOSED = new Object();
        DONE = new Object();
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    public void io_reactivex_internal_schedulers_ScheduledRunnable__run$___twin___() {
        lazySet(2, ThreadMethodProxy.currentThread());
        this.actual.run();     // Catch: Throwable -> L5
    L7:
        lazySet(2, null);
        Object r100 = get(0);
        if (r100 == PARENT_DISPOSED) goto L13;
        if (compareAndSet(0, r100, DONE) == false) goto L13;
        if (r100 == null) goto L13;
        ((utc.a) r100).delete(this);
    L13:
        Object r101 = get(1);
        if (r101 == SYNC_DISPOSED) goto L50;
        if (r101 == ASYNC_DISPOSED) goto L19;
        if (compareAndSet(1, r101, DONE) == false) goto L13;
        return;
    L19:
        return;
    L50:
        return;
    L5:
        th = move-exception;
        RxJavaPlugins.onError(th);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        lazySet(2, null);
        Object r102 = get(0);
        if (r102 == PARENT_DISPOSED) goto L27;
        if (compareAndSet(0, r102, DONE) == false) goto L27;
        if (r102 == null) goto L27;
        ((utc.a) r102).delete(this);
    L27:
        Object r103 = get(1);
        if (r103 == SYNC_DISPOSED) goto L34;
        if (r103 == ASYNC_DISPOSED) goto L34;
        if (compareAndSet(1, r103, DONE) == false) goto L27;
    L34:
        throw th;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void io_reactivex_internal_schedulers_ScheduledRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ScheduledRunnable r100) {
        r100.io_reactivex_internal_schedulers_ScheduledRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setFuture(Future<?> r100) {
    L2:
        Object r101 = get(1);
        if (r101 == DONE) goto L4;
        if (r101 == SYNC_DISPOSED) goto L7;
        if (r101 == ASYNC_DISPOSED) goto L11;
        if (compareAndSet(1, r101, r100) == false) goto L2;
        return;
    L11:
        r100.cancel(true);
        return;
    L7:
        r100.cancel(false);
        return;
    }

    public ScheduledRunnable(Runnable r100, utc.a r101) {
        super(3);
        this.actual = r100;
        lazySet(0, r101);
    }
}
