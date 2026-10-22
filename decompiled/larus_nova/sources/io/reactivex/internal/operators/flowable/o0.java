package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class o0<T, R, U> implements Function<T, Publisher<R>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f493531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends U>> f493532b;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) throws Exception {
        return new e1((Publisher) ObjectHelper.requireNonNull(this.f493532b.apply(r100), "The mapper returned a null Publisher"), new n0(this.f493531a, r100));
    }

    public o0(BiFunction<? super T, ? super U, ? extends R> r100, Function<? super T, ? extends Publisher<? extends U>> r101) {
        this.f493531a = r100;
        this.f493532b = r101;
    }
}
