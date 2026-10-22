package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class l1<R, T> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.q<? extends R, ? super T> f494446b;

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        this.f494245a.subscribe((Observer) ObjectHelper.requireNonNull(this.f494446b.a(r100), "Operator " + this.f494446b + " returned a null Observer"));
        return;
    L9:
        e = move-exception;
        throw e;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        NullPointerException r101 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r101.initCause(th);
        throw r101;
    }

    public l1(ObservableSource<T> r100, io.reactivex.q<? extends R, ? super T> r101) {
        super(r100);
        this.f494446b = r101;
    }
}
