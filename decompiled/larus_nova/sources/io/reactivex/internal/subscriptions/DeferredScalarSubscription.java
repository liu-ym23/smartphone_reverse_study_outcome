package io.reactivex.internal.subscriptions;

import wwc.b;

/* JADX INFO: loaded from: classes41.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final b<? super T> downstream;
    protected T value;

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
    public void cancel() {
        set(4);
        this.value = null;
    }

    public final boolean tryCancel() {
        if (getAndSet(4) == 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.j
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final boolean isCancelled() {
        if (get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.j
    public final boolean isEmpty() {
        if (get() == 16) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.j
    public final T poll() {
        if (get() != 16) goto L6;
        lazySet(32);
        T r100 = this.value;
        this.value = null;
        return r100;
    L6:
        return null;
    }

    public DeferredScalarSubscription(b<? super T> r100) {
        this.downstream = r100;
    }

    public final void complete(T r100) {
        int r101 = get();
    L4:
        if (r101 == 8) goto L5;
        if ((r101 & (-3)) != 0) goto L11;
        if (r101 == 2) goto L14;
        this.value = r100;
        if (compareAndSet(0, 1) == true) goto L20;
        r101 = get();
        if (r101 != 4) goto L4;
        this.value = null;
        return;
    L20:
        return;
    L14:
        lazySet(3);
        b<? super T> r102 = this.downstream;
        r102.onNext(r100);
        if (get() == 4) goto L32;
        r102.onComplete();
        return;
    L32:
        return;
    L11:
        return;
    L5:
        this.value = r100;
        lazySet(16);
        b<? super T> r103 = this.downstream;
        r103.onNext(r100);
        if (get() == 4) goto L31;
        r103.onComplete();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, wwc.c
    public final void request(long r100) {
        if (SubscriptionHelper.validate(r100) == false) goto L19;
    L4:
        int r101 = get();
        if ((r101 & (-2)) != 0) goto L6;
        if (r101 == 1) goto L10;
        if (compareAndSet(0, 2) == false) goto L4;
        return;
    L10:
        if (compareAndSet(1, 3) == false) goto L24;
        T r102 = this.value;
        if (r102 == null) goto L25;
        this.value = null;
        b<? super T> r103 = this.downstream;
        r103.onNext(r102);
        if (get() == 4) goto L26;
        r103.onComplete();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L6:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vtc.f
    public final int requestFusion(int r100) {
        if ((r100 & 2) == 0) goto L6;
        lazySet(8);
        return 2;
    L6:
        return 0;
    }
}
