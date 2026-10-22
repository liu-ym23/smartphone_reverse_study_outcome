package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableSkipLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f494170b;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3807491841935125653L;
        final Observer<? super T> downstream;
        final int skip;
        Disposable upstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.skip != size()) goto L5;
            this.downstream.onNext(poll());
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

        public SkipLastObserver(Observer<? super T> r100, int r101) {
            super(r101);
            this.downstream = r100;
            this.skip = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new SkipLastObserver(r100, this.f494170b));
    }

    public ObservableSkipLast(ObservableSource<T> r100, int r101) {
        super(r100);
        this.f494170b = r101;
    }
}
