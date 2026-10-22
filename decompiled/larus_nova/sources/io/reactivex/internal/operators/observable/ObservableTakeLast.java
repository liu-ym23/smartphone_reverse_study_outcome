package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableTakeLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f494182b;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final Observer<? super T> downstream;
        Disposable upstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> r100 = this.downstream;
        L4:
            if (this.cancelled == true) goto L5;
            T r101 = poll();
            if (r101 == null) goto L9;
            r100.onNext(r101);
            goto L4
        L9:
            if (this.cancelled == true) goto L15;
            r100.onComplete();
            return;
        L15:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.count != size()) goto L5;
            poll();
        L5:
            offer(r100);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public TakeLastObserver(Observer<? super T> r100, int r101) {
            this.downstream = r100;
            this.count = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new TakeLastObserver(r100, this.f494182b));
    }

    public ObservableTakeLast(ObservableSource<T> r100, int r101) {
        super(r100);
        this.f494182b = r101;
    }
}
