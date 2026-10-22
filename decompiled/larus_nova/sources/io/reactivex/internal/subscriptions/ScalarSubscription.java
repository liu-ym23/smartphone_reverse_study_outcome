package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import vtc.g;
import wwc.b;

/* JADX INFO: loaded from: classes41.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements g<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final b<? super T> subscriber;
    final T value;

    @Override // wwc.c
    public void cancel() {
        lazySet(2);
    }

    @Override // vtc.j
    public void clear() {
        lazySet(1);
    }

    @Override // vtc.f
    public int requestFusion(int r100) {
        return r100 & 1;
    }

    public boolean isCancelled() {
        if (get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vtc.j
    public boolean isEmpty() {
        if (get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // vtc.j
    public T poll() {
        if (get() != 0) goto L6;
        lazySet(1);
        return this.value;
    L6:
        return null;
    }

    @Override // vtc.j
    public boolean offer(T r100) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // wwc.c
    public void request(long r100) {
        if (SubscriptionHelper.validate(r100) == true) goto L6;
        return;
    L6:
        if (compareAndSet(0, 1) == false) goto L11;
        b<? super T> r101 = this.subscriber;
        r101.onNext(this.value);
        if (get() == 2) goto L12;
        r101.onComplete();
        return;
    L12:
        return;
    }

    public ScalarSubscription(b<? super T> r100, T r101) {
        this.subscriber = r100;
        this.value = r101;
    }

    public boolean offer(T r100, T r101) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
