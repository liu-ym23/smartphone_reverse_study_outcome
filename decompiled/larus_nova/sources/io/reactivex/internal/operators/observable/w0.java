package io.reactivex.internal.operators.observable;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes41.dex */
public final class w0<U, R, T> implements Function<U, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f494699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f494700b;

    @Override // io.reactivex.functions.Function
    public final R apply(U r100) throws Exception {
        return this.f494699a.apply(this.f494700b, r100);
    }

    public w0(BiFunction<? super T, ? super U, ? extends R> r100, T r101) {
        this.f494699a = r100;
        this.f494700b = r101;
    }
}
