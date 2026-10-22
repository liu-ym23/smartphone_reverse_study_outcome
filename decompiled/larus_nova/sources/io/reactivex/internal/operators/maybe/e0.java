package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class e0<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super Throwable> f493839b;

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Predicate<? super Throwable> f493841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493842c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493842c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493842c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493840a.onComplete();
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            if (this.f493841b.test(r100) == false) goto L5;
            this.f493840a.onComplete();
            return;
        L5:
            this.f493840a.onError(r100);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493840a.onError(new CompositeException(new Throwable[]{r100, th}));
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493842c, r100) == false) goto L6;
            this.f493842c = r100;
            this.f493840a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493840a.onSuccess(r100);
        }

        public a(io.reactivex.k<? super T> r100, Predicate<? super Throwable> r101) {
            this.f493840a = r100;
            this.f493841b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this.f493839b));
    }

    public e0(MaybeSource<T> r100, Predicate<? super Throwable> r101) {
        super(r100);
        this.f493839b = r101;
    }
}
