package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492982a;

    public o(CompletableSource r100) {
        this.f492982a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492982a.subscribe(r100);
    }
}
