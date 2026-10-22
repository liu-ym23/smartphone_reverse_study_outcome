package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class v<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f493909b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493909b.dispose();
            this.f493909b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493909b.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493909b = DisposableHelper.DISPOSED;
            this.f493908a.onComplete();
        }

        public a(io.reactivex.k<? super T> r100) {
            this.f493908a = r100;
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493909b = DisposableHelper.DISPOSED;
            this.f493908a.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493909b, r100) == false) goto L6;
            this.f493909b = r100;
            this.f493908a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493909b = DisposableHelper.DISPOSED;
            this.f493908a.onComplete();
        }
    }

    public v(MaybeSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100));
    }
}
