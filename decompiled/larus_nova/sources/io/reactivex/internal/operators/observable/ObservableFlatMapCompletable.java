package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableFlatMapCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f494055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f494056c;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final boolean delayErrors;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends CompletableSource> mapper;
        final CompositeDisposable set;
        Disposable upstream;

        public final class InnerObserver extends AtomicReference<Disposable> implements io.reactivex.b, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;
            final /* synthetic */ FlatMapCompletableMainObserver this$0;

            @Override // io.reactivex.b
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public InnerObserver(FlatMapCompletableMainObserver r100) {
                this.this$0 = r100;
            }

            @Override // io.reactivex.b
            public void onError(Throwable r100) {
                this.this$0.innerError(this, r100);
            }

            @Override // io.reactivex.b
            public void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this, r100);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public void clear() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.f
        public int requestFusion(int r100) {
            return r100 & 2;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() != 0) goto L9;
            Throwable r100 = this.errors.terminate();
            if (r100 == null) goto L7;
            this.downstream.onError(r100);
            return;
        L7:
            this.downstream.onComplete();
            return;
        }

        public void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver r100) {
            this.set.delete(r100);
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.errors.addThrowable(r100) == true) goto L5;
            RxJavaPlugins.onError(r100);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            dispose();
            if (getAndSet(0) <= 0) goto L16;
            Throwable r101 = this.errors.terminate();
            this.downstream.onError(r101);
            return;
        L16:
            return;
        L7:
            if (decrementAndGet() != 0) goto L14;
            Throwable r102 = this.errors.terminate();
            this.downstream.onError(r102);
            return;
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            CompletableSource r101 = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(r100), "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
            getAndIncrement();
            InnerObserver r102 = new InnerObserver(this);
            if (this.disposed == false) goto L6;
            return;
        L6:
            if (this.set.add(r102) == false) goto L15;
            r101.subscribe(r102);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public void innerError(FlatMapCompletableMainObserver<T>.InnerObserver r100, Throwable r101) {
            this.set.delete(r100);
            onError(r101);
        }

        public FlatMapCompletableMainObserver(Observer<? super T> r100, Function<? super T, ? extends CompletableSource> r101, boolean r102) {
            this.downstream = r100;
            this.mapper = r101;
            this.delayErrors = r102;
            this.errors = new AtomicThrowable();
            this.set = new CompositeDisposable();
            lazySet(1);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new FlatMapCompletableMainObserver(r100, this.f494055b, this.f494056c));
    }

    public ObservableFlatMapCompletable(ObservableSource<T> r100, Function<? super T, ? extends CompletableSource> r101, boolean r102) {
        super(r100);
        this.f494055b = r101;
        this.f494056c = r102;
    }
}
