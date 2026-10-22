package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class x0<T, R, U> implements Function<T, ObservableSource<R>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f494712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f494713b;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) throws Exception {
        return new m1((ObservableSource) ObjectHelper.requireNonNull(this.f494713b.apply(r100), "The mapper returned a null ObservableSource"), new w0(this.f494712a, r100));
    }

    public x0(BiFunction<? super T, ? super U, ? extends R> r100, Function<? super T, ? extends ObservableSource<? extends U>> r101) {
        this.f494712a = r100;
        this.f494713b = r101;
    }
}
