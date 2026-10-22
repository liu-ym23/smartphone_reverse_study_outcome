package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final Observer<? super T> downstream;
    protected T value;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final boolean tryDispose() {
        if (getAndSet(4) == 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete() {
        if ((get() & 54) == 0) goto L5;
        return;
    L5:
        lazySet(2);
        this.downstream.onComplete();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
    public final T poll() throws Exception {
        if (get() != 16) goto L6;
        T r100 = this.value;
        this.value = null;
        lazySet(32);
        return r100;
    L6:
        return null;
    }

    public DeferredScalarDisposable(Observer<? super T> r100) {
        this.downstream = r100;
    }

    public final void complete(T r100) {
        int r101 = get();
        if ((r101 & 54) == 0) goto L5;
        return;
    L5:
        Observer<? super T> r102 = this.downstream;
        if (r101 != 8) goto L8;
        this.value = r100;
        lazySet(16);
        r102.onNext(null);
    L10:
        if (get() == 4) goto L13;
        r102.onComplete();
        return;
    L13:
        return;
    L8:
        lazySet(2);
        r102.onNext(r100);
        goto L10
    }

    public final void error(Throwable r100) {
        if ((get() & 54) == 0) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        lazySet(2);
        this.downstream.onError(r100);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.f
    public final int requestFusion(int r100) {
        if ((r100 & 2) == 0) goto L6;
        lazySet(8);
        return 2;
    L6:
        return 0;
    }
}
