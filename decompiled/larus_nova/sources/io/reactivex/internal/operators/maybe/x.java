package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class x<T> extends io.reactivex.internal.operators.maybe.a<T, Boolean> {

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super Boolean> f493913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f493914b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493914b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493914b.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493913a.onSuccess(Boolean.TRUE);
        }

        public a(io.reactivex.k<? super Boolean> r100) {
            this.f493913a = r100;
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493913a.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493914b, r100) == false) goto L6;
            this.f493914b = r100;
            this.f493913a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493913a.onSuccess(Boolean.FALSE);
        }
    }

    public x(MaybeSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super Boolean> r100) {
        this.f493817a.subscribe(new a(r100));
    }
}
