package io.reactivex.internal.operators.mixed;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.k;
import io.reactivex.o;

/* JADX INFO: loaded from: classes41.dex */
public final class a<T> implements SingleObserver<T>, k<T>, io.reactivex.b, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleObserver<? super o<T>> f493987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f493988b;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f493988b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f493988b.isDisposed();
    }

    @Override // io.reactivex.k
    public final void onComplete() {
        this.f493987a.onSuccess(o.f495051b);
    }

    public a(SingleObserver<? super o<T>> r100) {
        this.f493987a = r100;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable r100) {
        this.f493987a.onSuccess(o.a(r100));
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable r100) {
        if (DisposableHelper.validate(this.f493988b, r100) == false) goto L6;
        this.f493988b = r100;
        this.f493987a.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T r100) {
        SingleObserver<? super o<T>> r101 = this.f493987a;
        o<Object> r102 = o.f495051b;
        ObjectHelper.requireNonNull(r100, "value is null");
        r101.onSuccess(new o(r100));
    }
}
