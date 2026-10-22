package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class e1<T, U> extends Flowable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Publisher<T> f493391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends U> f493392b;

    @Override // io.reactivex.Flowable
    public final void subscribeActual(wwc.b<? super U> r100) {
        this.f493391a.subscribe(new d1.b(r100, this.f493392b));
    }

    public e1(Publisher r100, n0 r101) {
        this.f493391a = r100;
        this.f493392b = r101;
    }
}
