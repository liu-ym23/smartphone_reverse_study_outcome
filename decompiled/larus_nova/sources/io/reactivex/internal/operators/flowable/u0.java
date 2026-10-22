package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes41.dex */
public final class u0<T> implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwc.b<T> f493604a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        this.f493604a.onComplete();
    }

    public u0(wwc.b<T> r100) {
        this.f493604a = r100;
    }
}
