package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableConcatMapEager<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f494029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f494030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f494031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f494032e;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, io.reactivex.internal.observers.j<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final ErrorMode errorMode;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        final int maxConcurrency;
        final ArrayDeque<InnerQueuedObserver<R>> observers;
        final int prefetch;
        vtc.j<T> queue;
        int sourceMode;
        Disposable upstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.cancelled = true;
            if (getAndIncrement() != 0) goto L6;
            this.queue.clear();
            disposeAll();
            return;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        public void disposeAll() {
            InnerQueuedObserver<R> r100 = this.current;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            InnerQueuedObserver<R> r101 = this.observers.poll();
            if (r101 == null) goto L7;
            r101.dispose();
            goto L5
        }

        @Override // io.reactivex.internal.observers.j
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            vtc.j<T> r100 = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> r101 = this.observers;
            Observer<? super R> r102 = this.downstream;
            ErrorMode r103 = this.errorMode;
            int r104 = 1;
        L6:
            int r105 = this.activeCount;
        L8:
            if (r105 == this.maxConcurrency) goto L27;
            if (this.cancelled == true) goto L11;
            if (r103 == ErrorMode.IMMEDIATE) goto L16;
        L87:
            T r106 = r100.poll();     // Catch: Throwable -> L24
            if (r106 == null) goto L27;
            ObservableSource r107 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r106), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L24
            InnerQueuedObserver<R> r108 = new InnerQueuedObserver(this, this.prefetch);
            r101.offer(r108);
            r107.subscribe(r108);
            r105 = r105 + 1;
        L24:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            r100.clear();
            disposeAll();
            this.error.addThrowable(th);
            r102.onError(this.error.terminate());
            return;
        L16:
            if (this.error.get() == null) goto L87;
            r100.clear();
            disposeAll();
            r102.onError(this.error.terminate());
            return;
        L11:
            r100.clear();
            disposeAll();
            return;
        L27:
            this.activeCount = r105;
            if (this.cancelled == true) goto L29;
            if (r103 == ErrorMode.IMMEDIATE) goto L34;
        L37:
            InnerQueuedObserver<R> r109 = this.current;
            if (r109 == null) goto L40;
        L59:
            if (r109 == null) goto L84;
            vtc.j<R> r110 = r109.queue();
        L62:
            if (this.cancelled == true) goto L63;
            boolean r111 = r109.isDone();
            if (r103 != ErrorMode.IMMEDIATE) goto L89;
            if (this.error.get() == null) goto L89;
            r100.clear();
            disposeAll();
            r102.onError(this.error.terminate());
            return;
        L89:
            R r112 = r110.poll();     // Catch: Throwable -> L82
            if (r112 != null) goto L75;
            boolean r113 = true;
        L76:
            if (r111 == false) goto L79;
            if (r113 == false) goto L79;
            this.current = null;
            this.activeCount--;
        L79:
            if (r113 == true) goto L84;
            r102.onNext(r112);
            goto L62
        L75:
            r113 = false;
        L82:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.error.addThrowable(th);
            this.current = null;
            this.activeCount--;
            goto L6
        L63:
            r100.clear();
            disposeAll();
            return;
        L84:
            r104 = addAndGet(-r104);
            if (r104 != 0) goto L6;
            return;
        L40:
            if (r103 == ErrorMode.BOUNDARY) goto L42;
        L45:
            boolean r114 = this.done;
            InnerQueuedObserver<R> r115 = r101.poll();
            if (r115 != null) goto L48;
            boolean r116 = true;
        L49:
            if (r114 == false) goto L56;
            if (r116 == false) goto L56;
            if (this.error.get() == null) goto L54;
            r100.clear();
            disposeAll();
            r102.onError(this.error.terminate());
            return;
        L54:
            r102.onComplete();
            return;
        L56:
            if (r116 == true) goto L58;
            this.current = r115;
        L58:
            r109 = r115;
            goto L59
        L48:
            r116 = false;
            goto L49
        L42:
            if (this.error.get() == null) goto L45;
            r100.clear();
            disposeAll();
            r102.onError(this.error.terminate());
            return;
        L34:
            if (this.error.get() == null) goto L37;
            r100.clear();
            disposeAll();
            r102.onError(this.error.terminate());
            return;
        L29:
            r100.clear();
            disposeAll();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.internal.observers.j
        public void innerComplete(InnerQueuedObserver<R> r100) {
            r100.setDone();
            drain();
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
            this.queue = new io.reactivex.internal.queue.a(this.prefetch);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.observers.j
        public void innerError(InnerQueuedObserver<R> r100, Throwable r101) {
            if (this.error.addThrowable(r101) == true) goto L5;
            RxJavaPlugins.onError(r101);
            return;
        L5:
            if (this.errorMode != ErrorMode.IMMEDIATE) goto L7;
            this.upstream.dispose();
        L7:
            r100.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.j
        public void innerNext(InnerQueuedObserver<R> r100, R r101) {
            r100.queue().offer(r101);
            drain();
        }

        public ConcatMapEagerMainObserver(Observer<? super R> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, int r102, int r103, ErrorMode r104) {
            this.downstream = r100;
            this.mapper = r101;
            this.maxConcurrency = r102;
            this.prefetch = r103;
            this.errorMode = r104;
            this.error = new AtomicThrowable();
            this.observers = new ArrayDeque();
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        this.f494245a.subscribe(new ConcatMapEagerMainObserver(r100, this.f494029b, this.f494031d, this.f494032e, this.f494030c));
    }

    public ObservableConcatMapEager(ObservableSource<T> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, ErrorMode r102, int r103, int r104) {
        super(r100);
        this.f494029b = r101;
        this.f494030c = r102;
        this.f494031d = r103;
        this.f494032e = r104;
    }
}
