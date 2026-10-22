package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Action f494048b;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Observer<? super T> downstream;
        final Action onFinally;

        /* JADX INFO: renamed from: qd, reason: collision with root package name */
        vtc.e<T> f494049qd;
        boolean syncFused;
        Disposable upstream;

        public void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            return;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public void clear() {
            this.f494049qd.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public boolean isEmpty() {
            return this.f494049qd.isEmpty();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public T poll() throws Exception {
            T r100 = this.f494049qd.poll();
            if (r100 == null) goto L5;
        L7:
            return r100;
        L5:
            if (this.syncFused == false) goto L7;
            runFinally();
            goto L7
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
            runFinally();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            this.downstream.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L9;
            this.upstream = r100;
            if ((r100 instanceof vtc.e) == false) goto L7;
            this.f494049qd = (vtc.e) r100;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.f
        public int requestFusion(int r100) {
            vtc.e<T> r101 = this.f494049qd;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L13:
            return 0;
        L5:
            if ((r100 & 4) != 0) goto L13;
            int r103 = r101.requestFusion(r100);
            if (r103 != 0) goto L9;
        L12:
            return r103;
        L9:
            if (r103 != 1) goto L11;
            r102 = true;
        L11:
            this.syncFused = r102;
            goto L12
        }

        public DoFinallyObserver(Observer<? super T> r100, Action r101) {
            this.downstream = r100;
            this.onFinally = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new DoFinallyObserver(r100, this.f494048b));
    }

    public ObservableDoFinally(ObservableSource<T> r100, Action r101) {
        super(r100);
        this.f494048b = r101;
    }
}
