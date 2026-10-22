package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import vtc.g;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements g<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public abstract /* synthetic */ void cancel();

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    public abstract /* synthetic */ T poll() throws Exception;

    public abstract /* synthetic */ void request(long r100);

    public abstract /* synthetic */ int requestFusion(int r100);

    public BasicIntQueueSubscription() {
    }

    @Override // vtc.j
    public final boolean offer(T r100) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T r100, T r101) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
