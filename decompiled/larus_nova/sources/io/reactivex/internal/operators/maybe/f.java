package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class f<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public io.reactivex.k<? super T> f493843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f493844b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493843a = null;
            this.f493844b.dispose();
            this.f493844b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493844b.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493844b = DisposableHelper.DISPOSED;
            io.reactivex.k<? super T> r100 = this.f493843a;
            if (r100 == null) goto L6;
            this.f493843a = null;
            r100.onComplete();
            return;
        }

        public a(io.reactivex.k<? super T> r100) {
            this.f493843a = r100;
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493844b = DisposableHelper.DISPOSED;
            io.reactivex.k<? super T> r101 = this.f493843a;
            if (r101 == null) goto L6;
            this.f493843a = null;
            r101.onError(r100);
            return;
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493844b, r100) == false) goto L6;
            this.f493844b = r100;
            this.f493843a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493844b = DisposableHelper.DISPOSED;
            io.reactivex.k<? super T> r101 = this.f493843a;
            if (r101 == null) goto L6;
            this.f493843a = null;
            r101.onSuccess(r100);
            return;
        }
    }

    public f(MaybeSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100));
    }
}
