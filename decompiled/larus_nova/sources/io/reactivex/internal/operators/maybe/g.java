package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class g<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer<? super T> f493849b;

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Consumer<? super T> f493851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493852c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493852c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493852c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493850a.onComplete();
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493850a.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493852c, r100) == false) goto L6;
            this.f493852c = r100;
            this.f493850a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493850a.onSuccess(r100);
            this.f493851b.accept(r100);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }

        public a(io.reactivex.k<? super T> r100, Consumer<? super T> r101) {
            this.f493850a = r100;
            this.f493851b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this.f493849b));
    }

    public g(MaybeSource<T> r100, Consumer<? super T> r101) {
        super(r100);
        this.f493849b = r101;
    }
}
