package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class u<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f493907b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493907b.dispose();
            this.f493907b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493907b.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493906a.onComplete();
        }

        public a(io.reactivex.k<? super T> r100) {
            this.f493906a = r100;
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493906a.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493907b, r100) == false) goto L6;
            this.f493907b = r100;
            this.f493906a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493906a.onSuccess(r100);
        }
    }

    public u(MaybeSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100));
    }
}
