package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes41.dex */
public final class n0<U, R, T> implements Function<U, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f493521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f493522b;

    @Override // io.reactivex.functions.Function
    public final R apply(U r100) throws Exception {
        return this.f493521a.apply(this.f493522b, r100);
    }

    public n0(BiFunction<? super T, ? super U, ? extends R> r100, T r101) {
        this.f493521a = r100;
        this.f493522b = r101;
    }
}
