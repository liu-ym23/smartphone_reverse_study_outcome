package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableGroupBy<T, K, V> extends io.reactivex.internal.operators.observable.a<T, GroupedObservable<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends K> f494064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function<? super T, ? extends V> f494065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f494066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f494067e;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object NULL_KEY = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        final Observer<? super GroupedObservable<K, V>> downstream;
        final Map<Object, a<K, V>> groups;
        final Function<? super T, ? extends K> keySelector;
        Disposable upstream;
        final Function<? super T, ? extends V> valueSelector;

        static {
            NULL_KEY = new Object();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList r100 = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((a) r101.next()).f494068a.onComplete();
            goto L4
        L6:
            this.downstream.onComplete();
        }

        public void cancel(K r100) {
            if (r100 != null) goto L5;
            r100 = (K) NULL_KEY;
        L5:
            this.groups.remove(r100);
            if (decrementAndGet() != 0) goto L9;
            this.upstream.dispose();
            return;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            ArrayList r101 = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((a) r102.next()).f494068a.onError(r100);
            goto L4
        L6:
            this.downstream.onError(r100);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            K r101 = this.keySelector.apply(r100);     // Catch: Throwable -> L18
            if (r101 == null) goto L5;
            Object r102 = r101;
        L6:
            a<K, V> r103 = this.groups.get(r102);
            if (r103 == null) goto L9;
        L23:
            Object r104 = ObjectHelper.requireNonNull(this.valueSelector.apply(r100), "The value supplied is null");     // Catch: Throwable -> L15
            r103.f494068a.onNext((T) r104);
            return;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.dispose();
            onError(th);
            return;
        L9:
            if (this.cancelled.get() == false) goto L11;
            return;
        L11:
            r103 = new a(r101, new State(this.bufferSize, this, r101, this.delayError));
            this.groups.put(r102, r103);
            getAndIncrement();
            this.downstream.onNext(r103);
            goto L23
        L5:
            r102 = NULL_KEY;
        L18:
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

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> r100, Function<? super T, ? extends K> r101, Function<? super T, ? extends V> r102, int r103, boolean r104) {
            this.cancelled = new AtomicBoolean();
            this.downstream = r100;
            this.keySelector = r101;
            this.valueSelector = r102;
            this.bufferSize = r103;
            this.delayError = r104;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }
    }

    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<Observer<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        final GroupByObserver<?, K, T> parent;
        final io.reactivex.internal.queue.a<T> queue;

        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (getAndIncrement() != 0) goto L9;
            this.actual.lazySet(null);
            this.parent.cancel(this.key);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            io.reactivex.internal.queue.a<T> r100 = this.queue;
            boolean r101 = this.delayError;
            Observer<? super T> r102 = this.actual.get();
            int r103 = 1;
        L6:
            if (r102 == null) goto L17;
        L7:
            boolean r104 = this.done;
            T r105 = r100.poll();
            if (r105 != null) goto L10;
            boolean r106 = true;
        L12:
            if (checkTerminated(r104, r106, r102, r101) == true) goto L13;
            if (r106 == true) goto L17;
            r102.onNext(r105);
            goto L7
        L13:
            return;
        L10:
            r106 = false;
        L17:
            r103 = addAndGet(-r103);
            if (r103 == 0) goto L19;
            if (r102 != null) goto L6;
            r102 = this.actual.get();
            goto L6
        }

        public void onError(Throwable r100) {
            this.error = r100;
            this.done = true;
            drain();
        }

        public void onNext(T r100) {
            this.queue.offer(r100);
            drain();
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> r100) {
            if (this.once.compareAndSet(false, true) == false) goto L8;
            r100.onSubscribe(this);
            this.actual.lazySet(r100);
            if (this.cancelled.get() == false) goto L7;
            this.actual.lazySet(null);
            return;
        L7:
            drain();
            return;
        L8:
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), r100);
        }

        public State(int r100, GroupByObserver<?, K, T> r101, K r102, boolean r103) {
            this.cancelled = new AtomicBoolean();
            this.once = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.queue = new io.reactivex.internal.queue.a(r100);
            this.parent = r101;
            this.key = r102;
            this.delayError = r103;
        }

        public boolean checkTerminated(boolean r100, boolean r101, Observer<? super T> r102, boolean r103) {
            if (this.cancelled.get() == false) goto L6;
            this.queue.clear();
            this.parent.cancel(this.key);
            this.actual.lazySet(null);
            return true;
        L6:
            if (r100 == false) goto L21;
            if (r103 == false) goto L14;
            if (r101 == false) goto L23;
            Throwable r104 = this.error;
            this.actual.lazySet(null);
            if (r104 == null) goto L12;
            r102.onError(r104);
        L13:
            return true;
        L12:
            r102.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r105 = this.error;
            if (r105 == null) goto L18;
            this.queue.clear();
            this.actual.lazySet(null);
            r102.onError(r105);
            return true;
        L18:
            if (r101 == false) goto L24;
            this.actual.lazySet(null);
            r102.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }
    }

    public static final class a<K, T> extends GroupedObservable<K, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final State<T, K> f494068a;

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super T> r100) {
            this.f494068a.subscribe(r100);
        }

        public a(K r100, State<T, K> r101) {
            super(r100);
            this.f494068a = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super GroupedObservable<K, V>> r100) {
        this.f494245a.subscribe(new GroupByObserver(r100, this.f494064b, this.f494065c, this.f494066d, this.f494067e));
    }

    public ObservableGroupBy(ObservableSource<T> r100, Function<? super T, ? extends K> r101, Function<? super T, ? extends V> r102, int r103, boolean r104) {
        super(r100);
        this.f494064b = r101;
        this.f494065c = r102;
        this.f494066d = r103;
        this.f494067e = r104;
    }
}
