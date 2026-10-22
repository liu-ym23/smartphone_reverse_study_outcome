package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f492831a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.f492831a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f492831a.get());
    }

    public a() {
        this.f492831a = new AtomicReference();
    }

    public final void b(Disposable r100) {
        DisposableHelper.set(this.f492831a, r100);
    }
}
