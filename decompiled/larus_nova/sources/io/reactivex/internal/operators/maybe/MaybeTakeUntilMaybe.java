package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeTakeUntilMaybe<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaybeSource<U> f493796b;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;
        final io.reactivex.k<? super T> downstream;
        final TakeUntilOtherMaybeObserver<U> other;

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements io.reactivex.k<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> parent;

            @Override // io.reactivex.k
            public void onComplete() {
                this.parent.otherComplete();
            }

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> r100) {
                this.parent = r100;
            }

            @Override // io.reactivex.k
            public void onError(Throwable r100) {
                this.parent.otherError(r100);
            }

            @Override // io.reactivex.k
            public void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this, r100);
            }

            @Override // io.reactivex.k
            public void onSuccess(Object r100) {
                this.parent.otherComplete();
            }
        }

        @Override // io.reactivex.k
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            DisposableHelper r100 = DisposableHelper.DISPOSED;
            if (getAndSet(r100) == r100) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L6;
            this.downstream.onComplete();
            return;
        }

        public TakeUntilMainMaybeObserver(io.reactivex.k<? super T> r100) {
            this.downstream = r100;
            this.other = new TakeUntilOtherMaybeObserver(this);
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            DisposableHelper.dispose(this.other);
            DisposableHelper r101 = DisposableHelper.DISPOSED;
            if (getAndSet(r101) == r101) goto L5;
            this.downstream.onError(r100);
            return;
        L5:
            RxJavaPlugins.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            DisposableHelper.dispose(this.other);
            DisposableHelper r101 = DisposableHelper.DISPOSED;
            if (getAndSet(r101) == r101) goto L6;
            this.downstream.onSuccess(r100);
            return;
        }

        public void otherError(Throwable r100) {
            if (DisposableHelper.dispose(this) == false) goto L5;
            this.downstream.onError(r100);
            return;
        L5:
            RxJavaPlugins.onError(r100);
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        TakeUntilMainMaybeObserver r101 = new TakeUntilMainMaybeObserver(r100);
        r100.onSubscribe(r101);
        this.f493796b.subscribe(r101.other);
        this.f493817a.subscribe(r101);
    }

    public MaybeTakeUntilMaybe(MaybeSource<T> r100, MaybeSource<U> r101) {
        super(r100);
        this.f493796b = r101;
    }
}
