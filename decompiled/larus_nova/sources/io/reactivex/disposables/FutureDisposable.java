package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> r100 = getAndSet(null);
        if (r100 == null) goto L6;
        r100.cancel(this.allowInterrupt);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Future<?> r100 = get();
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isDone() == true) goto L8;
        return false;
    }

    public FutureDisposable(Future<?> r100, boolean r101) {
        super(r100);
        this.allowInterrupt = r101;
    }
}
