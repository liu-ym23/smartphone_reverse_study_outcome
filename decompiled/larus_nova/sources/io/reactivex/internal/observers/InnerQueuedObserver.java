package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final j<T> parent;
    final int prefetch;
    vtc.j<T> queue;

    public void setDone() {
        this.done = true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    public boolean isDone() {
        return this.done;
    }

    public vtc.j<T> queue() {
        return this.queue;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        this.parent.innerError(this, r100);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r100);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        if (DisposableHelper.setOnce(this, r100) == true) goto L5;
        return;
    L5:
        if ((r100 instanceof vtc.e) == false) goto L14;
        vtc.e r101 = (vtc.e) r100;
        int r102 = r101.requestFusion(3);
        if (r102 != 1) goto L11;
        this.fusionMode = r102;
        this.queue = r101;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r102 != 2) goto L14;
        this.fusionMode = r102;
        this.queue = r101;
        return;
    L14:
        int r103 = -this.prefetch;
        if (r103 >= 0) goto L17;
        vtc.j<T> r104 = new io.reactivex.internal.queue.a(-r103);
    L18:
        this.queue = r104;
        return;
    L17:
        r104 = new SpscArrayQueue(r103);
        goto L18
    }

    public InnerQueuedObserver(j<T> r100, int r101) {
        this.parent = r100;
        this.prefetch = r101;
    }
}
