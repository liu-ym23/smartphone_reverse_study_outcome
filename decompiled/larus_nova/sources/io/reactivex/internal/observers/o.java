package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class o<T> implements SingleObserver<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<Disposable> f492896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleObserver<? super T> f492897b;

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        this.f492897b.onError(r100);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        DisposableHelper.replace(this.f492896a, r100);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
        this.f492897b.onSuccess(r100);
    }

    public o(AtomicReference<Disposable> r100, SingleObserver<? super T> r101) {
        this.f492896a = r100;
        this.f492897b = r101;
    }
}
