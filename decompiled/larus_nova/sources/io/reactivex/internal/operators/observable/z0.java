package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes41.dex */
public final class z0<T> implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<T> f494728a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        this.f494728a.onComplete();
    }

    public z0(Observer<T> r100) {
        this.f494728a = r100;
    }
}
