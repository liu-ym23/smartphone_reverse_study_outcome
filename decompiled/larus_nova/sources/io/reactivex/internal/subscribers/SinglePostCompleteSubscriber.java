package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes41.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements io.reactivex.g<T>, wwc.c {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final wwc.b<? super R> downstream;
    protected long produced;
    protected wwc.c upstream;
    protected R value;

    public abstract /* synthetic */ void onComplete();

    public void onDrop(R r100) {
    }

    public abstract /* synthetic */ void onError(Throwable r100);

    public abstract /* synthetic */ void onNext(T r100);

    public void cancel() {
        this.upstream.cancel();
    }

    public SinglePostCompleteSubscriber(wwc.b<? super R> r100) {
        this.downstream = r100;
    }

    public final void complete(R r110) {
        long r100 = this.produced;
        if (r100 == 0) goto L5;
        io.reactivex.internal.util.b.e(this, r100);
    L5:
        long r101 = get();
        if ((r101 & Long.MIN_VALUE) != 0) goto L7;
        if ((r101 & Long.MAX_VALUE) != 0) goto L11;
        this.value = r110;
        if (compareAndSet(0, Long.MIN_VALUE) == true) goto L15;
        this.value = null;
        goto L5
    L15:
        return;
    L11:
        lazySet(-9223372036854775807L);
        this.downstream.onNext(r110);
        this.downstream.onComplete();
        return;
    L7:
        onDrop(r110);
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.validate(this.upstream, r100) == false) goto L6;
        this.upstream = r100;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // wwc.c
    public final void request(long r110) {
        if (SubscriptionHelper.validate(r110) == false) goto L16;
    L4:
        long r100 = get();
        if ((r100 & Long.MIN_VALUE) != 0) goto L7;
        if (compareAndSet(r100, io.reactivex.internal.util.b.c(r100, r110)) == false) goto L4;
        this.upstream.request(r110);
        return;
    L7:
        if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L) == false) goto L17;
        this.downstream.onNext(this.value);
        this.downstream.onComplete();
        return;
    L17:
        return;
    }
}
