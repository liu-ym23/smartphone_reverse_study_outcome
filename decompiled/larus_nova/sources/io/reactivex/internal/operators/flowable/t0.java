package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class t0<T, S> implements BiFunction<S, Emitter<T>, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Consumer<Emitter<T>> f493595a;

    public t0(Consumer<Emitter<T>> r100) {
        this.f493595a = r100;
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) throws Exception {
        Consumer<Emitter<T>> r102 = this.f493595a;
        r102.accept((Emitter) r101);
        return r100;
    }
}
