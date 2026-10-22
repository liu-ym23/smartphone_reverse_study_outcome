package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public class SubscriptionArbiter extends AtomicInteger implements c {
    private static final long serialVersionUID = -2189523197179400958L;
    c actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced;
    final AtomicLong missedRequested;
    final AtomicReference<c> missedSubscription;
    long requested;
    protected boolean unbounded;

    public void cancel() {
        if (this.cancelled == true) goto L6;
        this.cancelled = true;
        drain();
        return;
    }

    final void drainLoop() {
        int r100 = 1;
        long r101 = 0;
        c r102 = null;
    L3:
        c r103 = this.missedSubscription.get();
        if (r103 == null) goto L6;
        r103 = this.missedSubscription.getAndSet(null);
    L6:
        long r104 = this.missedRequested.get();
        if (r104 == 0) goto L9;
        r104 = this.missedRequested.getAndSet(0);
    L9:
        long r110 = this.missedProduced.get();
        if (r110 == 0) goto L12;
        r110 = this.missedProduced.getAndSet(0);
    L12:
        c r111 = this.actual;
        if (this.cancelled == false) goto L18;
        if (r111 == null) goto L16;
        r111.cancel();
        this.actual = null;
    L16:
        if (r103 == null) goto L38;
        r103.cancel();
    L38:
        r100 = addAndGet(-r100);
        if (r100 != 0) goto L3;
        if (r101 == 0) goto L46;
        r102.request(r101);
        return;
    L46:
        return;
    L18:
        long r112 = this.requested;
        if (r112 == Long.MAX_VALUE) goto L26;
        r112 = b.c(r112, r104);
        if (r112 == Long.MAX_VALUE) goto L25;
        r112 = r112 - r110;
        if (r112 >= 0) goto L25;
        SubscriptionHelper.reportMoreProduced(r112);
        r112 = 0;
    L25:
        this.requested = r112;
    L26:
        if (r103 == null) goto L34;
        if (r111 != null) goto L29;
    L31:
        this.actual = r103;
        if (r112 == 0) goto L38;
        r101 = b.c(r101, r112);
        r102 = r103;
        goto L38
    L29:
        if (this.cancelOnReplace == false) goto L31;
        r111.cancel();
        goto L31
    L34:
        if (r111 == null) goto L38;
        if (r104 == 0) goto L38;
        r101 = b.c(r101, r104);
        r102 = r111;
        goto L38
    }

    final void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        drainLoop();
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public SubscriptionArbiter(boolean r100) {
        this.cancelOnReplace = r100;
        this.missedSubscription = new AtomicReference();
        this.missedRequested = new AtomicLong();
        this.missedProduced = new AtomicLong();
    }

    public final void produced(long r100) {
        if (this.unbounded == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L8;
    L20:
        b.a(this.missedProduced, r100);
        drain();
        return;
    L8:
        if (compareAndSet(0, 1) == false) goto L20;
        long r101 = this.requested;
        if (r101 == Long.MAX_VALUE) goto L16;
        long r102 = r101 - r100;
        if (r102 >= 0) goto L14;
        SubscriptionHelper.reportMoreProduced(r102);
        r102 = 0;
    L14:
        this.requested = r102;
    L16:
        if (decrementAndGet() != 0) goto L18;
        return;
    L18:
        drainLoop();
    }

    @Override // wwc.c
    public final void request(long r100) {
        if (SubscriptionHelper.validate(r100) == true) goto L5;
        return;
    L5:
        if (this.unbounded == false) goto L8;
        return;
    L8:
        if (get() == 0) goto L10;
    L22:
        b.a(this.missedRequested, r100);
        drain();
        return;
    L10:
        if (compareAndSet(0, 1) == false) goto L22;
        long r101 = this.requested;
        if (r101 == Long.MAX_VALUE) goto L16;
        long r102 = b.c(r101, r100);
        this.requested = r102;
        if (r102 != Long.MAX_VALUE) goto L16;
        this.unbounded = true;
    L16:
        c r103 = this.actual;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r103 == null) goto L24;
        r103.request(r100);
        return;
    }

    public final void setSubscription(c r100) {
        if (this.cancelled == false) goto L6;
        r100.cancel();
        return;
    L6:
        ObjectHelper.requireNonNull(r100, "s is null");
        if (get() == 0) goto L9;
    L22:
        c r101 = this.missedSubscription.getAndSet(r100);
        if (r101 != null) goto L25;
    L27:
        drain();
        return;
    L25:
        if (this.cancelOnReplace == false) goto L27;
        r101.cancel();
        goto L27
    L9:
        if (compareAndSet(0, 1) == false) goto L22;
        c r102 = this.actual;
        if (r102 != null) goto L13;
    L15:
        this.actual = r100;
        long r103 = this.requested;
        if (decrementAndGet() == 0) goto L19;
        drainLoop();
    L19:
        if (r103 == 0) goto L29;
        r100.request(r103);
        return;
    L29:
        return;
    L13:
        if (this.cancelOnReplace == false) goto L15;
        r102.cancel();
        goto L15
    }
}
