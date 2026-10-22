package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeTimeoutPublisher<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Publisher<U> f493800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MaybeSource<? extends T> f493801c;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        final io.reactivex.k<? super T> downstream;

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        public TimeoutFallbackMaybeObserver(io.reactivex.k<? super T> r100) {
            this.downstream = r100;
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.downstream.onSuccess(r100);
        }
    }

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;
        final io.reactivex.k<? super T> downstream;
        final MaybeSource<? extends T> fallback;
        final TimeoutOtherMaybeObserver<T, U> other;
        final TimeoutFallbackMaybeObserver<T> otherObserver;

        @Override // io.reactivex.k
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            DisposableHelper r100 = DisposableHelper.DISPOSED;
            if (getAndSet(r100) == r100) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.other);
            TimeoutFallbackMaybeObserver<T> r100 = this.otherObserver;
            if (r100 == null) goto L6;
            DisposableHelper.dispose(r100);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L9;
            MaybeSource<? extends T> r100 = this.fallback;
            if (r100 != null) goto L7;
            this.downstream.onError(new TimeoutException());
            return;
        L7:
            r100.subscribe(this.otherObserver);
            return;
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            SubscriptionHelper.cancel(this.other);
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
            SubscriptionHelper.cancel(this.other);
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

        public TimeoutMainMaybeObserver(io.reactivex.k<? super T> r100, MaybeSource<? extends T> r101) {
            this.downstream = r100;
            this.other = new TimeoutOtherMaybeObserver(this);
            this.fallback = r101;
            if (r101 == null) goto L5;
            TimeoutFallbackMaybeObserver<T> r102 = new TimeoutFallbackMaybeObserver(r100);
        L6:
            this.otherObserver = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<wwc.c> implements io.reactivex.g<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final TimeoutMainMaybeObserver<T, U> parent;

        @Override // wwc.b
        public void onComplete() {
            this.parent.otherComplete();
        }

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> r100) {
            this.parent = r100;
        }

        @Override // wwc.b
        public void onError(Throwable r100) {
            this.parent.otherError(r100);
        }

        @Override // wwc.b
        public void onNext(Object r100) {
            get().cancel();
            this.parent.otherComplete();
        }

        @Override // io.reactivex.g, wwc.b
        public void onSubscribe(wwc.c r100) {
            SubscriptionHelper.setOnce(this, r100, Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        TimeoutMainMaybeObserver r101 = new TimeoutMainMaybeObserver(r100, this.f493801c);
        r100.onSubscribe(r101);
        this.f493800b.subscribe(r101.other);
        this.f493817a.subscribe(r101);
    }

    public MaybeTimeoutPublisher(MaybeSource<T> r100, Publisher<U> r101, MaybeSource<? extends T> r102) {
        super(r100);
        this.f493800b = r101;
        this.f493801c = r102;
    }
}
