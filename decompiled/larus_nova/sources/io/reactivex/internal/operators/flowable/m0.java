package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class m0<T, U> implements Function<T, Publisher<U>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends U>> f493511a;

    public m0(Function<? super T, ? extends Iterable<? extends U>> r100) {
        this.f493511a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) throws Exception {
        return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.f493511a.apply(r100), "The mapper returned a null Iterable"));
    }
}
