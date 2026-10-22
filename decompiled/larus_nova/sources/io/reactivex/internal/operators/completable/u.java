package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes41.dex */
public final class u extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f492994a = null;

    static {
        f492994a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        r100.onSubscribe(EmptyDisposable.NEVER);
    }
}
