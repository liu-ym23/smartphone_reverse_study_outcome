package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableTakeUntil<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableSource<? extends U> f494189b;

    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;
        final Observer<? super T> downstream;
        final AtomicThrowable error;
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
        final AtomicReference<Disposable> upstream;

        public final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;
            final /* synthetic */ TakeUntilMainObserver this$0;

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.this$0.otherComplete();
            }

            public OtherObserver(TakeUntilMainObserver r100) {
                this.this$0 = r100;
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r100) {
                this.this$0.otherError(r100);
            }

            @Override // io.reactivex.Observer
            public void onNext(U r100) {
                DisposableHelper.dispose(this);
                this.this$0.otherComplete();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this, r100);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        public void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        public TakeUntilMainObserver(Observer<? super T> r100) {
            this.downstream = r100;
            this.upstream = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.c(this.downstream, r100, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            io.reactivex.internal.util.g.e(this.downstream, r100, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this.upstream, r100);
        }

        public void otherError(Throwable r100) {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.c(this.downstream, r100, this, this.error);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        TakeUntilMainObserver r101 = new TakeUntilMainObserver(r100);
        r100.onSubscribe(r101);
        this.f494189b.subscribe(r101.otherObserver);
        this.f494245a.subscribe(r101);
    }

    public ObservableTakeUntil(ObservableSource<T> r100, ObservableSource<? extends U> r101) {
        super(r100);
        this.f494189b = r101;
    }
}
