package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class BooleanSubscription extends AtomicBoolean implements c {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // wwc.c
    public void cancel() {
        lazySet(true);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }

    public boolean isCancelled() {
        return get();
    }

    public BooleanSubscription() {
    }

    @Override // wwc.c
    public void request(long r100) {
        SubscriptionHelper.validate(r100);
    }
}
