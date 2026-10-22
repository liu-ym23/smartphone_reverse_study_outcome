package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f492969a = null;

    static {
        f492969a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        EmptyDisposable.complete(r100);
    }
}
