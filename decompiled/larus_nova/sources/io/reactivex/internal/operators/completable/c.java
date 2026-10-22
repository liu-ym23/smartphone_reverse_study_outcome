package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492956a;

    public static final class a implements io.reactivex.b, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public io.reactivex.b f492957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f492958b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f492957a = null;
            this.f492958b.dispose();
            this.f492958b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492958b.isDisposed();
        }

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f492958b = DisposableHelper.DISPOSED;
            io.reactivex.b r100 = this.f492957a;
            if (r100 == null) goto L6;
            this.f492957a = null;
            r100.onComplete();
            return;
        }

        public a(io.reactivex.b r100) {
            this.f492957a = r100;
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f492958b = DisposableHelper.DISPOSED;
            io.reactivex.b r101 = this.f492957a;
            if (r101 == null) goto L6;
            this.f492957a = null;
            r101.onError(r100);
            return;
        }

        @Override // io.reactivex.b
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f492958b, r100) == false) goto L6;
            this.f492958b = r100;
            this.f492957a.onSubscribe(this);
            return;
        }
    }

    public c(CompletableSource r100) {
        this.f492956a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492956a.subscribe(new a(r100));
    }
}
