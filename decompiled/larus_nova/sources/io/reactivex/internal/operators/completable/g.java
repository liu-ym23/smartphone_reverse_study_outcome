package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes41.dex */
public final class g extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f492970a;

    public g(Throwable r100) {
        this.f492970a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        EmptyDisposable.error(this.f492970a, r100);
    }
}
