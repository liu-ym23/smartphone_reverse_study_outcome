package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableFlatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f494050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f494051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f494052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f494053e;

    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final long f494054id;
        final MergeObserver<T, U> parent;
        volatile vtc.j<U> queue;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.parent.errors.addThrowable(r100) == false) goto L8;
            MergeObserver<T, U> r101 = this.parent;
            if (r101.delayErrors == true) goto L7;
            r101.disposeAll();
        L7:
            this.done = true;
            this.parent.drain();
            return;
        L8:
            RxJavaPlugins.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(U r100) {
            if (this.fusionMode != 0) goto L5;
            this.parent.tryEmit(r100, this);
            return;
        L5:
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == true) goto L5;
            return;
        L5:
            if ((r100 instanceof vtc.e) == false) goto L15;
            vtc.e r101 = (vtc.e) r100;
            int r102 = r101.requestFusion(7);
            if (r102 != 1) goto L11;
            this.fusionMode = r102;
            this.queue = r101;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r102 != 2) goto L16;
            this.fusionMode = r102;
            this.queue = r101;
            return;
        L16:
            return;
        }

        public InnerObserver(MergeObserver<T, U> r100, long r101) {
            this.f494054id = r101;
            this.parent = r100;
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        static final InnerObserver<?, ?>[] CANCELLED = null;
        static final InnerObserver<?, ?>[] EMPTY = null;
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super U> downstream;
        final AtomicThrowable errors;
        long lastId;
        int lastIndex;
        final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile vtc.i<U> queue;
        Queue<ObservableSource<? extends U>> sources;
        long uniqueId;
        Disposable upstream;
        int wip;

        static {
            EMPTY = new InnerObserver[0];
            CANCELLED = new InnerObserver[0];
        }

        public boolean checkTerminate() {
            if (this.cancelled == false) goto L5;
            return true;
        L5:
            Throwable r100 = this.errors.get();
            if (this.delayErrors == true) goto L12;
            if (r100 == null) goto L14;
            disposeAll();
            Throwable r101 = this.errors.terminate();
            if (r101 == ExceptionHelper.f495041a) goto L11;
            this.downstream.onError(r101);
        L11:
            return true;
        L14:
            return false;
        L12:
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L12;
            this.cancelled = true;
            if (disposeAll() == false) goto L13;
            Throwable r100 = this.errors.terminate();
            if (r100 != null) goto L9;
            return;
        L9:
            if (r100 == ExceptionHelper.f495041a) goto L15;
            RxJavaPlugins.onError(r100);
            return;
        L15:
            return;
        L13:
            return;
        }

        public boolean disposeAll() {
            this.upstream.dispose();
            InnerObserver<?, ?>[] r100 = this.observers.get();
            InnerObserver<?, ?>[] r101 = CANCELLED;
            int r102 = 0;
            if (r100 == r101) goto L11;
            InnerObserver<?, ?>[] r103 = this.observers.getAndSet(r101);
            if (r103 == r101) goto L11;
            int r104 = r103.length;
        L7:
            if (r102 >= r104) goto L9;
            r103[r102].dispose();
            r102 = r102 + 1;
            goto L7
        L9:
            return true;
        L11:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainLoop() {
            Observer<? super U> r100 = this.downstream;
            int r101 = 1;
        L4:
            if (checkTerminate() == true) goto L5;
            vtc.i<U> r102 = this.queue;
            if (r102 != null) goto L9;
        L15:
            boolean r103 = this.done;
            vtc.i<U> r104 = this.queue;
            InnerObserver<?, ?>[] r105 = this.observers.get();
            int r106 = r105.length;
            int r107 = 0;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L24;
            monitor-enter(this);
            int r108 = this.sources.size();     // Catch: Throwable -> L21
            monitor-exit(this);     // Catch: Throwable -> L21
        L25:
            if (r103 == false) goto L37;
            if (r104 != null) goto L28;
        L29:
            if (r106 != 0) goto L37;
            if (r108 != 0) goto L37;
            Throwable r109 = this.errors.terminate();
            if (r109 == ExceptionHelper.f495041a) goto L142;
            if (r109 != null) goto L35;
            r100.onComplete();
            return;
        L35:
            r100.onError(r109);
            return;
        L142:
            return;
        L28:
            if (r104.isEmpty() == true) goto L29;
        L37:
            if (r106 == 0) goto L88;
            long r110 = this.lastId;
            int r111 = this.lastIndex;
            if (r106 > r111) goto L41;
        L42:
            if (r106 > r111) goto L44;
            r111 = 0;
        L44:
            int r112 = 0;
        L45:
            if (r112 >= r106) goto L53;
            if (r105[r111].f494054id == r110) goto L53;
            r111 = r111 + 1;
            if (r111 != r106) goto L52;
            r111 = 0;
        L52:
            r112 = r112 + 1;
        L53:
            this.lastIndex = r111;
            this.lastId = r105[r111].f494054id;
        L54:
            int r113 = 0;
            int r114 = 0;
        L55:
            if (r113 >= r106) goto L87;
            if (checkTerminate() == true) goto L58;
            InnerObserver<T, U> r115 = r105[r111];
            vtc.j<U> r116 = r115.queue;
            if (r116 != null) goto L110;
        L74:
            boolean r117 = r115.done;
            vtc.j<U> r118 = r115.queue;
            if (r117 == false) goto L83;
            if (r118 != null) goto L78;
        L79:
            removeInner(r115);
            if (checkTerminate() == true) goto L81;
            r114 = r114 + 1;
            goto L83
        L81:
            return;
        L78:
            if (r118.isEmpty() == true) goto L79;
        L83:
            r111 = r111 + 1;
            if (r111 != r106) goto L86;
        L85:
            r111 = 0;
        L86:
            r113 = r113 + 1;
        L110:
            U r119 = r116.poll();     // Catch: Throwable -> L67
            if (r119 == null) goto L74;
            r100.onNext(r119);
            if (checkTerminate() == false) goto L110;
            return;
        L67:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r115.dispose();
            this.errors.addThrowable(th);
            if (checkTerminate() == true) goto L70;
            removeInner(r115);
            r114 = r114 + 1;
            r111 = r111 + 1;
            if (r111 != r106) goto L86;
        L70:
            return;
        L58:
            return;
        L87:
            this.lastIndex = r111;
            this.lastId = r105[r111].f494054id;
            r107 = r114;
            goto L88
        L41:
            if (r105[r111].f494054id == r110) goto L54;
        L88:
            if (r107 != 0) goto L90;
            r101 = addAndGet(-r101);
            if (r101 != 0) goto L4;
            return;
        L90:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L4;
        L91:
            int r120 = r107 - 1;
            if (r107 == 0) goto L4;
            monitor-enter(this);
            ObservableSource<? extends U> r121 = this.sources.poll();     // Catch: Throwable -> L102
            if (r121 != null) goto L99;
            this.wip--;     // Catch: Throwable -> L102
            monitor-exit(this);     // Catch: Throwable -> L102
        L101:
            r107 = r120;
            goto L91
        L99:
            monitor-exit(this);     // Catch: Throwable -> L102
            subscribeInner(r121);
        L102:
            th = move-exception;
            throw th;
        L21:
            th = move-exception;
            throw th;
        L24:
            r108 = 0;
        L9:
            if (checkTerminate() == true) goto L10;
            U r122 = r102.poll();
            if (r122 == null) goto L15;
            r100.onNext(r122);
            goto L9
        L10:
            return;
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
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public boolean addInner(InnerObserver<T, U> r100) {
        L2:
            InnerObserver<?, ?>[] r101 = this.observers.get();
            boolean r102 = false;
            if (r101 == CANCELLED) goto L4;
            int r103 = r101.length;
            InnerObserver[] r104 = new InnerObserver[r103 + 1];
            System.arraycopy(r101, 0, r104, 0, r103);
            r104[r103] = r100;
            AtomicReference<InnerObserver<?, ?>[]> r105 = this.observers;
        L8:
            if (r105.compareAndSet(r101, (InnerObserver<?, ?>[]) r104) == true) goto L9;
            if (r105.get() == r101) goto L8;
        L12:
            if (r102 == false) goto L2;
            return true;
        L9:
            r102 = true;
            goto L12
        L4:
            r100.dispose();
            return false;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.done == false) goto L7;
            RxJavaPlugins.onError(r100);
            return;
        L7:
            if (this.errors.addThrowable(r100) == false) goto L9;
            this.done = true;
            drain();
            return;
        L9:
            RxJavaPlugins.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.done == false) goto L25;
            return;
        L25:
            ObservableSource<? extends U> r101 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r100), "The mapper returned a null ObservableSource");     // Catch: Throwable -> L22
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L20;
            monitor-enter(this);
            int r102 = this.wip;     // Catch: Throwable -> L17
            if (r102 != this.maxConcurrency) goto L14;
            this.sources.offer(r101);     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L14:
            this.wip = r102 + 1;     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L20:
            subscribeInner(r101);
            return;
        L22:
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

        /* JADX WARN: Multi-variable type inference failed */
        public void removeInner(InnerObserver<T, U> r100) {
        L2:
            InnerObserver<?, ?>[] r101 = this.observers.get();
            int r102 = r101.length;
            if (r102 == 0) goto L4;
            boolean r103 = false;
            int r104 = 0;
        L6:
            if (r104 >= r102) goto L11;
            if (r101[r104] == r100) goto L12;
            r104 = r104 + 1;
        L12:
            if (r104 < 0) goto L13;
            if (r102 != 1) goto L17;
            InnerObserver<?, ?>[] r105 = EMPTY;
        L18:
            AtomicReference<InnerObserver<?, ?>[]> r106 = this.observers;
        L20:
            if (r106.compareAndSet(r101, r105) == true) goto L21;
            if (r106.get() == r101) goto L20;
        L24:
            if (r103 == false) goto L2;
            return;
        L21:
            r103 = true;
            goto L24
        L17:
            InnerObserver<?, ?>[] r107 = new InnerObserver[r102 - 1];
            System.arraycopy(r101, 0, r107, 0, r104);
            System.arraycopy(r101, r104 + 1, r107, r104, (r102 - r104) - 1);
            r105 = r107;
            goto L18
        L13:
            return;
        L11:
            r104 = -1;
            goto L12
        }

        public void subscribeInner(ObservableSource<? extends U> r100) {
        L3:
            if ((r100 instanceof Callable) == false) goto L19;
            if (tryEmitScalar((Callable) r100) == false) goto L32;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L33;
            monitor-enter(this);
            r100 = this.sources.poll();     // Catch: Throwable -> L16
            if (r100 != null) goto L12;
            boolean r101 = true;
            this.wip--;     // Catch: Throwable -> L16
        L13:
            monitor-exit(this);     // Catch: Throwable -> L16
            if (r101 == false) goto L3;
            drain();
            return;
        L12:
            r101 = false;
        L16:
            th = move-exception;
            throw th;
        L33:
            return;
        L32:
            return;
        L19:
            long r102 = this.uniqueId;
            this.uniqueId = 1 + r102;
            InnerObserver<T, U> r103 = new InnerObserver(this, r102);
            if (addInner(r103) == false) goto L31;
            r100.subscribe(r103);
            return;
        }

        public boolean tryEmitScalar(Callable<? extends U> r100) {
            U r101 = r100.call();     // Catch: Throwable -> L29
            if (r101 != null) goto L7;
            return true;
        L7:
            if (get() == 0) goto L9;
        L13:
            vtc.i<U> r102 = this.queue;
            if (r102 != null) goto L21;
            if (this.maxConcurrency != Integer.MAX_VALUE) goto L18;
            r102 = new io.reactivex.internal.queue.a(this.bufferSize);
        L19:
            this.queue = r102;
            goto L21
        L18:
            r102 = new SpscArrayQueue(this.maxConcurrency);
        L21:
            if (r102.offer(r101) == true) goto L25;
            onError(new IllegalStateException("Scalar queue full?!"));
            return true;
        L25:
            if (getAndIncrement() == 0) goto L27;
            return false;
        L27:
            drainLoop();
            return true;
        L9:
            if (compareAndSet(0, 1) == false) goto L13;
            this.downstream.onNext(r101);
            if (decrementAndGet() != 0) goto L27;
            return true;
        L29:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
            drain();
            return true;
        }

        public void tryEmit(U r100, InnerObserver<T, U> r101) {
            if (get() == 0) goto L5;
        L9:
            vtc.j r102 = r101.queue;
            if (r102 != null) goto L12;
            r102 = new io.reactivex.internal.queue.a(this.bufferSize);
            r101.queue = r102;
        L12:
            r102.offer(r100);
            if (getAndIncrement() == 0) goto L15;
            return;
        L15:
            drainLoop();
            return;
        L5:
            if (compareAndSet(0, 1) == false) goto L9;
            this.downstream.onNext(r100);
            if (decrementAndGet() != 0) goto L15;
        }

        public MergeObserver(Observer<? super U> r100, Function<? super T, ? extends ObservableSource<? extends U>> r101, boolean r102, int r103, int r104) {
            this.errors = new AtomicThrowable();
            this.downstream = r100;
            this.mapper = r101;
            this.delayErrors = r102;
            this.maxConcurrency = r103;
            this.bufferSize = r104;
            if (r103 == Integer.MAX_VALUE) goto L5;
            this.sources = new ArrayDeque(r103);
        L5:
            this.observers = new AtomicReference(EMPTY);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        if (ObservableScalarXMap.a(this.f494245a, r100, this.f494050b) == false) goto L5;
        return;
    L5:
        this.f494245a.subscribe(new MergeObserver(r100, this.f494050b, this.f494051c, this.f494052d, this.f494053e));
    }

    public ObservableFlatMap(ObservableSource<T> r100, Function<? super T, ? extends ObservableSource<? extends U>> r101, boolean r102, int r103, int r104) {
        super(r100);
        this.f494050b = r101;
        this.f494051c = r102;
        this.f494052d = r103;
        this.f494053e = r104;
    }
}
