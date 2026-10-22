package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class l<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f493877b;

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super T> f493879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493880c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable r100 = this.f493880c;
            this.f493880c = DisposableHelper.DISPOSED;
            r100.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493880c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493878a.onComplete();
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493878a.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493880c, r100) == false) goto L6;
            this.f493880c = r100;
            this.f493878a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            if (this.f493879b.test(r100) == false) goto L5;
            this.f493878a.onSuccess(r100);
            return;
        L5:
            this.f493878a.onComplete();
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493878a.onError(th);
        }

        public a(io.reactivex.k<? super T> r100, Predicate<? super T> r101) {
            this.f493878a = r100;
            this.f493879b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this.f493877b));
    }

    public l(MaybeSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f493877b = r101;
    }
}
