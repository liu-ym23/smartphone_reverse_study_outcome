package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements vtc.e<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // vtc.j
    public abstract /* synthetic */ void clear();

    @Override // vtc.j
    public abstract /* synthetic */ boolean isEmpty();

    @Override // vtc.j
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // vtc.f
    public abstract /* synthetic */ int requestFusion(int r100);

    public BasicIntQueueDisposable() {
    }

    @Override // vtc.j
    public final boolean offer(T r100) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T r100, T r101) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
