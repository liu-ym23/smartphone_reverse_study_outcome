package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class p extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492983a;

    public static final class a implements io.reactivex.b, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.b f492984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f492985b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f492985b.dispose();
            this.f492985b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492985b.isDisposed();
        }

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f492984a.onComplete();
        }

        public a(io.reactivex.b r100) {
            this.f492984a = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f492984a.onError(r100);
        }

        @Override // io.reactivex.b
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f492985b, r100) == false) goto L6;
            this.f492985b = r100;
            this.f492984a.onSubscribe(this);
            return;
        }
    }

    public p(CompletableSource r100) {
        this.f492983a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492983a.subscribe(new a(r100));
    }
}
