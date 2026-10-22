package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class h<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ttc.a<? super T, ? super Throwable> f493862b;

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ttc.a<? super T, ? super Throwable> f493864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493865c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493865c.dispose();
            this.f493865c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493865c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493865c = DisposableHelper.DISPOSED;
            this.f493864b.accept(null, null);     // Catch: Throwable -> L6
            this.f493863a.onComplete();
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493863a.onError(th);
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493865c = DisposableHelper.DISPOSED;
            this.f493864b.accept(null, r100);     // Catch: Throwable -> L5
        L7:
            this.f493863a.onError(r100);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100 = new CompositeException(new Throwable[]{r100, th});
            goto L7
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493865c, r100) == false) goto L6;
            this.f493865c = r100;
            this.f493863a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493865c = DisposableHelper.DISPOSED;
            this.f493864b.accept(r100, null);     // Catch: Throwable -> L6
            this.f493863a.onSuccess(r100);
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493863a.onError(th);
        }

        public a(io.reactivex.k<? super T> r100, ttc.a<? super T, ? super Throwable> r101) {
            this.f493863a = r100;
            this.f493864b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this.f493862b));
    }

    public h(MaybeSource<T> r100, ttc.a<? super T, ? super Throwable> r101) {
        super(r100);
        this.f493862b = r101;
    }
}
