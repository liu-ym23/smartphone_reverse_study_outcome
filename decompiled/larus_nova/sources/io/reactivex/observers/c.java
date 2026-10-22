package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f495063a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f495063a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f495063a.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public c() {
        this.f495063a = new AtomicReference();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        io.reactivex.internal.util.f.b(this.f495063a, r100, getClass());
    }
}
