package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import ttc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class CancellableDisposable extends AtomicReference<c> implements Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (get() == null) goto L13;
        c r100 = getAndSet(null);
        if (r100 == null) goto L14;
        r100.cancel();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Exceptions.throwIfFatal(e);
        RxJavaPlugins.onError(e);
        return;
    L14:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public CancellableDisposable(c r100) {
        super(r100);
    }
}
