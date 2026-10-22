package io.reactivex.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public abstract class d<T> implements SingleObserver<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f495064a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f495064a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f495064a.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public d() {
        this.f495064a = new AtomicReference();
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        io.reactivex.internal.util.f.b(this.f495064a, r100, getClass());
    }
}
