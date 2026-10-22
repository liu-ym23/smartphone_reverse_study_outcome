package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class b0<T, R> extends io.reactivex.internal.operators.maybe.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends R> f493824b;

    public static final class a<T, R> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super R> f493825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends R> f493826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493827c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable r100 = this.f493827c;
            this.f493827c = DisposableHelper.DISPOSED;
            r100.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493827c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493825a.onComplete();
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493825a.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493827c, r100) == false) goto L6;
            this.f493827c = r100;
            this.f493825a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            Object r101 = ObjectHelper.requireNonNull(this.f493826b.apply(r100), "The mapper returned a null item");     // Catch: Throwable -> L5
            this.f493825a.onSuccess(r101);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493825a.onError(th);
        }

        public a(io.reactivex.k<? super R> r100, Function<? super T, ? extends R> r101) {
            this.f493825a = r100;
            this.f493826b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super R> r100) {
        this.f493817a.subscribe(new a(r100, this.f493824b));
    }

    public b0(MaybeSource<T> r100, Function<? super T, ? extends R> r101) {
        super(r100);
        this.f493824b = r101;
    }
}
