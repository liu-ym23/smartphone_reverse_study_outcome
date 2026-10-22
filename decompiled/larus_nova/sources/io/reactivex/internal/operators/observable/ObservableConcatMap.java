package io.reactivex.internal.operators.observable;

import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableConcatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f494026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f494027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorMode f494028d;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final DelayErrorInnerObserver<R> observer;
        vtc.j<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        Disposable upstream;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final Observer<? super R> downstream;
            final ConcatMapDelayErrorObserver<?, R> parent;

            @Override // io.reactivex.Observer
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> r100 = this.parent;
                r100.active = false;
                r100.drain();
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r100) {
                ConcatMapDelayErrorObserver<?, R> r101 = this.parent;
                if (r101.error.addThrowable(r100) == true) goto L5;
                RxJavaPlugins.onError(r100);
                return;
            L5:
                if (r101.tillTheEnd == true) goto L7;
                r101.upstream.dispose();
            L7:
                r101.active = false;
                r101.drain();
            }

            @Override // io.reactivex.Observer
            public void onNext(R r100) {
                this.downstream.onNext(r100);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r100) {
                DisposableHelper.replace(this, r100);
            }

            public DelayErrorInnerObserver(Observer<? super R> r100, ConcatMapDelayErrorObserver<?, R> r101) {
                this.downstream = r100;
                this.parent = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super R> r100 = this.downstream;
            vtc.j<T> r101 = this.queue;
            AtomicThrowable r102 = this.error;
        L7:
            if (this.active == true) goto L49;
            if (this.cancelled == true) goto L10;
            if (this.tillTheEnd == false) goto L15;
        L18:
            boolean r103 = this.done;
            T r104 = r101.poll();     // Catch: Throwable -> L45
            if (r104 != null) goto L22;
            boolean r105 = true;
        L23:
            if (r103 == false) goto L30;
            if (r105 == false) goto L30;
            this.cancelled = true;
            Throwable r106 = r102.terminate();
            if (r106 == null) goto L28;
            r100.onError(r106);
            return;
        L28:
            r100.onComplete();
            return;
        L30:
            if (r105 == true) goto L49;
            ObservableSource r107 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r104), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L42
            if ((r107 instanceof Callable) == false) goto L41;
            DeepThinkTopHeaderComponent$runCollapseAnimation$2 r108 = (Object) ((Callable) r107).call();
            if (r108 == null) goto L7;
            if (this.cancelled == true) goto L7;
            r100.onNext(r108);
        L39:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r102.addThrowable(th);
            goto L7
        L41:
            this.active = true;
            r107.subscribe(this.observer);
        L42:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.dispose();
            r101.clear();
            r102.addThrowable(th);
            r100.onError(r102.terminate());
            return;
        L22:
            r105 = false;
        L45:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.cancelled = true;
            this.upstream.dispose();
            r102.addThrowable(th);
            r100.onError(r102.terminate());
            return;
        L15:
            if (r102.get() == null) goto L18;
            r101.clear();
            this.cancelled = true;
            r100.onError(r102.terminate());
            return;
        L10:
            r101.clear();
            return;
        L49:
            if (decrementAndGet() != 0) goto L7;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.error.addThrowable(r100) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            RxJavaPlugins.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.sourceMode != 0) goto L5;
            this.queue.offer(r100);
        L5:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L16;
            this.upstream = r100;
            if ((r100 instanceof vtc.e) == false) goto L14;
            vtc.e r101 = (vtc.e) r100;
            int r102 = r101.requestFusion(3);
            if (r102 != 1) goto L11;
            this.sourceMode = r102;
            this.queue = r101;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r102 != 2) goto L14;
            this.sourceMode = r102;
            this.queue = r101;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, int r102, boolean r103) {
            this.downstream = r100;
            this.mapper = r101;
            this.bufferSize = r102;
            this.tillTheEnd = r103;
            this.error = new AtomicThrowable();
            this.observer = new DelayErrorInnerObserver(r100, this);
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super U> downstream;
        int fusionMode;
        final InnerObserver<U> inner;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        vtc.j<T> queue;
        Disposable upstream;

        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final Observer<? super U> downstream;
            final SourceObserver<?, ?> parent;

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.parent.innerComplete();
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable r100) {
                this.parent.dispose();
                this.downstream.onError(r100);
            }

            @Override // io.reactivex.Observer
            public void onNext(U r100) {
                this.downstream.onNext(r100);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable r100) {
                DisposableHelper.replace(this, r100);
            }

            public InnerObserver(Observer<? super U> r100, SourceObserver<?, ?> r101) {
                this.downstream = r100;
                this.parent = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            return;
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            drain();
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.disposed == true) goto L7;
            if (this.active == true) goto L31;
            boolean r100 = this.done;
            T r101 = this.queue.poll();     // Catch: Throwable -> L27
            if (r101 != null) goto L16;
            boolean r102 = true;
        L17:
            if (r100 == false) goto L21;
            if (r102 == false) goto L21;
            this.disposed = true;
            this.downstream.onComplete();
            return;
        L21:
            if (r102 == true) goto L31;
            ObservableSource r103 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r101), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
            this.active = true;
            r103.subscribe(this.inner);
        L24:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.queue.clear();
            this.downstream.onError(th);
            return;
        L16:
            r102 = false;
        L27:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.queue.clear();
            this.downstream.onError(th);
            return;
        L31:
            if (decrementAndGet() != 0) goto L6;
            return;
        L7:
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.done = true;
            dispose();
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.fusionMode != 0) goto L8;
            this.queue.offer(r100);
        L8:
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L16;
            this.upstream = r100;
            if ((r100 instanceof vtc.e) == false) goto L14;
            vtc.e r101 = (vtc.e) r100;
            int r102 = r101.requestFusion(3);
            if (r102 != 1) goto L11;
            this.fusionMode = r102;
            this.queue = r101;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L11:
            if (r102 != 2) goto L14;
            this.fusionMode = r102;
            this.queue = r101;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        public SourceObserver(Observer<? super U> r100, Function<? super T, ? extends ObservableSource<? extends U>> r101, int r102) {
            this.downstream = r100;
            this.mapper = r101;
            this.bufferSize = r102;
            this.inner = new InnerObserver(r100, this);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        if (ObservableScalarXMap.a(this.f494245a, r100, this.f494026b) == false) goto L6;
        return;
    L6:
        if (this.f494028d != ErrorMode.IMMEDIATE) goto L8;
        io.reactivex.observers.f r101 = new io.reactivex.observers.f(r100);
        this.f494245a.subscribe(new SourceObserver(r101, this.f494026b, this.f494027c));
        return;
    L8:
        ObservableSource<T> r102 = this.f494245a;
        Function<? super T, ? extends ObservableSource<? extends U>> r103 = this.f494026b;
        int r104 = this.f494027c;
        if (this.f494028d != ErrorMode.END) goto L11;
        boolean r105 = true;
    L12:
        r102.subscribe(new ConcatMapDelayErrorObserver(r100, r103, r104, r105));
        return;
    L11:
        r105 = false;
        goto L12
    }

    public ObservableConcatMap(ObservableSource<T> r100, Function<? super T, ? extends ObservableSource<? extends U>> r101, int r102, ErrorMode r103) {
        super(r100);
        this.f494026b = r101;
        this.f494028d = r103;
        this.f494027c = Math.max(8, r102);
    }
}
