package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class v0<T, U> implements Function<T, ObservableSource<U>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends U>> f494690a;

    public v0(Function<? super T, ? extends Iterable<? extends U>> r100) {
        this.f494690a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) throws Exception {
        return new m0((Iterable) ObjectHelper.requireNonNull(this.f494690a.apply(r100), "The mapper returned a null Iterable"));
    }
}
