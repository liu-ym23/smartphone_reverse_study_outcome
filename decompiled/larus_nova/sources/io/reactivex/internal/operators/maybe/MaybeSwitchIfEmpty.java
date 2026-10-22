package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeSwitchIfEmpty<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaybeSource<? extends T> f493789b;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = -2223459372976438024L;
        final io.reactivex.k<? super T> downstream;
        final MaybeSource<? extends T> other;

        public static final class a<T> implements io.reactivex.k<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final io.reactivex.k<? super T> f493790a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference<Disposable> f493791b;

            @Override // io.reactivex.k
            public final void onComplete() {
                this.f493790a.onComplete();
            }

            @Override // io.reactivex.k
            public final void onError(Throwable r100) {
                this.f493790a.onError(r100);
            }

            @Override // io.reactivex.k
            public final void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this.f493791b, r100);
            }

            @Override // io.reactivex.k
            public final void onSuccess(T r100) {
                this.f493790a.onSuccess(r100);
            }

            public a(io.reactivex.k<? super T> r100, AtomicReference<Disposable> r101) {
                this.f493790a = r100;
                this.f493791b = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.k
        public void onComplete() {
            Disposable r100 = get();
            if (r100 != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (compareAndSet(r100, null) == false) goto L9;
            this.other.subscribe(new a(this.downstream, this));
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.downstream.onSuccess(r100);
        }

        public SwitchIfEmptyMaybeObserver(io.reactivex.k<? super T> r100, MaybeSource<? extends T> r101) {
            this.downstream = r100;
            this.other = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new SwitchIfEmptyMaybeObserver(r100, this.f493789b));
    }

    public MaybeSwitchIfEmpty(MaybeSource<T> r100, MaybeSource<? extends T> r101) {
        super(r100);
        this.f493789b = r101;
    }
}
