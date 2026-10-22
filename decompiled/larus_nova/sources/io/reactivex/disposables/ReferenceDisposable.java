package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long serialVersionUID = 6537757548749041217L;

    public abstract void onDisposed(T r100);

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (get() == null) goto L8;
        T r100 = getAndSet(null);
        if (r100 == null) goto L9;
        onDisposed(r100);
        return;
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public ReferenceDisposable(T r100) {
        super(ObjectHelper.requireNonNull(r100, "value is null"));
    }
}
