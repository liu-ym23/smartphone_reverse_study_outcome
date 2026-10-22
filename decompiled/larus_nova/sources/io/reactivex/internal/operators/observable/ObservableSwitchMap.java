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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableSwitchMap<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f494179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f494180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f494181d;

    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        volatile vtc.j<R> queue;

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.index != this.parent.unique) goto L6;
            this.done = true;
            this.parent.drain();
            return;
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.parent.innerError(this, r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r100) {
            if (this.index != this.parent.unique) goto L8;
            if (r100 == null) goto L6;
            this.queue.offer(r100);
        L6:
            this.parent.drain();
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == true) goto L5;
            return;
        L5:
            if ((r100 instanceof vtc.e) == false) goto L14;
            vtc.e r101 = (vtc.e) r100;
            int r102 = r101.requestFusion(7);
            if (r102 != 1) goto L11;
            this.queue = r101;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r102 != 2) goto L14;
            this.queue = r101;
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
        }

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> r100, long r101, int r102) {
            this.parent = r100;
            this.index = r101;
            this.bufferSize = r102;
        }
    }

    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED = null;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable errors;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        volatile long unique;
        Disposable upstream;

        static {
            SwitchMapInnerObserver<Object, Object> r100 = new SwitchMapInnerObserver(null, -1, 1);
            CANCELLED = r100;
            r100.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L6;
            this.cancelled = true;
            this.upstream.dispose();
            disposeInner();
            return;
        }

        public void disposeInner() {
            SwitchMapInnerObserver<T, R> r100 = this.active.get();
            SwitchMapInnerObserver<Object, Object> r101 = CANCELLED;
            if (r100 == r101) goto L9;
            SwitchMapInnerObserver<T, R> r102 = this.active.getAndSet((SwitchMapInnerObserver<T, R>) r101);
            if (r102 == r101) goto L10;
            if (r102 == null) goto L11;
            r102.cancel();
            return;
        L11:
            return;
        L10:
            return;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            drain();
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super R> r100 = this.downstream;
            AtomicReference<SwitchMapInnerObserver<T, R>> r101 = this.active;
            boolean r102 = this.delayErrors;
            int r103 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            if (this.done == true) goto L12;
        L29:
            SwitchMapInnerObserver<T, R> r104 = r101.get();
            if (r104 == null) goto L96;
            vtc.j<R> r105 = r104.queue;
            if (r105 == null) goto L96;
            if (r104.done == false) goto L55;
            boolean r106 = r105.isEmpty();
            if (r102 == true) goto L37;
            if (this.errors.get() != null) goto L46;
            if (r106 == false) goto L55;
        L50:
            if (r101.compareAndSet(r104, null) == true) goto L7;
            if (r101.get() == r104) goto L50;
        L46:
            r100.onError(this.errors.terminate());
            return;
        L37:
            if (r106 == false) goto L55;
        L39:
            if (r101.compareAndSet(r104, null) == true) goto L7;
            if (r101.get() == r104) goto L39;
        L55:
            boolean r107 = false;
        L57:
            if (this.cancelled == true) goto L58;
            if (r104 != r101.get()) goto L61;
            if (r102 == false) goto L64;
        L67:
            boolean r110 = r104.done;
            DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r111 = r105.poll();     // Catch: Throwable -> L70
        L81:
            if (r111 != null) goto L83;
            boolean r112 = true;
        L84:
            if (r110 == false) goto L92;
            if (r112 == false) goto L92;
        L87:
            if (r101.compareAndSet(r104, null) == true) goto L61;
            if (r101.get() == r104) goto L87;
        L92:
            if (r112 == true) goto L93;
            r100.onNext(r111);
        L93:
            if (r107 == false) goto L96;
        L83:
            r112 = false;
        L70:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.errors.addThrowable(th);
        L73:
            if (r101.compareAndSet(r104, null) == true) goto L77;
            if (r101.get() == r104) goto L73;
        L77:
            if (r102 == true) goto L79;
            disposeInner();
            this.upstream.dispose();
            this.done = true;
        L80:
            r111 = null;
            r107 = true;
            goto L81
        L79:
            r104.cancel();
            goto L80
        L64:
            if (this.errors.get() == null) goto L67;
            r100.onError(this.errors.terminate());
            return;
        L61:
            r107 = true;
            goto L93
        L58:
            return;
        L96:
            r103 = addAndGet(-r103);
            if (r103 != 0) goto L7;
            return;
        L12:
            if (r101.get() != null) goto L14;
            boolean r108 = true;
        L15:
            if (r102 == false) goto L23;
            if (r108 == false) goto L29;
            Throwable r109 = this.errors.get();
            if (r109 == null) goto L20;
            r100.onError(r109);
            return;
        L20:
            r100.onComplete();
            return;
        L23:
            if (this.errors.get() != null) goto L24;
            if (r108 == false) goto L29;
            r100.onComplete();
            return;
        L24:
            r100.onError(this.errors.terminate());
            return;
        L14:
            r108 = false;
            goto L15
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.done == false) goto L5;
        L10:
            RxJavaPlugins.onError(r100);
            return;
        L5:
            if (this.errors.addThrowable(r100) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            disposeInner();
        L9:
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            long r101 = this.unique + 1;
            this.unique = r101;
            SwitchMapInnerObserver<T, R> r102 = this.active.get();
            if (r102 == null) goto L23;
            r102.cancel();
        L23:
            ObservableSource r103 = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(r100), "The ObservableSource returned is null");     // Catch: Throwable -> L20
            SwitchMapInnerObserver<T, R> r104 = new SwitchMapInnerObserver(this, r101, this.bufferSize);
        L7:
            SwitchMapInnerObserver<T, R> r105 = this.active.get();
            if (r105 == CANCELLED) goto L33;
            AtomicReference<SwitchMapInnerObserver<T, R>> r106 = this.active;
        L12:
            if (r106.compareAndSet(r105, r104) == true) goto L13;
            if (r106.get() == r105) goto L12;
            boolean r107 = false;
        L17:
            if (r107 == false) goto L7;
            r103.subscribe(r104);
            return;
        L13:
            r107 = true;
            goto L17
        L33:
            return;
        L20:
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

        public void innerError(SwitchMapInnerObserver<T, R> r100, Throwable r101) {
            if (r100.index == this.unique) goto L5;
        L10:
            RxJavaPlugins.onError(r101);
            return;
        L5:
            if (this.errors.addThrowable(r101) == false) goto L10;
            if (this.delayErrors == true) goto L9;
            this.upstream.dispose();
        L9:
            r100.done = true;
            drain();
        }

        public SwitchMapObserver(Observer<? super R> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, int r102, boolean r103) {
            this.active = new AtomicReference();
            this.downstream = r100;
            this.mapper = r101;
            this.bufferSize = r102;
            this.delayErrors = r103;
            this.errors = new AtomicThrowable();
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        if (ObservableScalarXMap.a(this.f494245a, r100, this.f494179b) == false) goto L5;
        return;
    L5:
        this.f494245a.subscribe(new SwitchMapObserver(r100, this.f494179b, this.f494180c, this.f494181d));
    }

    public ObservableSwitchMap(ObservableSource<T> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, int r102, boolean r103) {
        super(r100);
        this.f494179b = r101;
        this.f494180c = r102;
        this.f494181d = r103;
    }
}
