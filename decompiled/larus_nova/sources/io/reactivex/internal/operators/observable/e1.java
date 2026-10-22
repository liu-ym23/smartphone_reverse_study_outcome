package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.functions.BiFunction;

/* JADX INFO: loaded from: classes41.dex */
public final class e1<T, S> implements BiFunction<S, Emitter<T>, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ttc.a<S, Emitter<T>> f494338a;

    public e1(ttc.a<S, Emitter<T>> r100) {
        this.f494338a = r100;
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) throws Exception {
        ttc.a<S, Emitter<T>> r102 = this.f494338a;
        r102.accept(r100, (Emitter) r101);
        return r100;
    }
}
