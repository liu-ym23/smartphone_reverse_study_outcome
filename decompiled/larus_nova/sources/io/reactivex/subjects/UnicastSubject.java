package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class UnicastSubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.internal.queue.a<T> f495130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Observer<? super T>> f495131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Runnable> f495132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f495133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f495134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f495135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f495136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f495137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f495138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f495139j;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;
        final /* synthetic */ UnicastSubject this$0;

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public void clear() {
            this.this$0.f495130a.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.this$0.f495134e == true) goto L8;
            this.this$0.f495134e = true;
            this.this$0.c();
            this.this$0.f495131b.lazySet(null);
            if (this.this$0.f495138i.getAndIncrement() != 0) goto L9;
            this.this$0.f495131b.lazySet(null);
            this.this$0.f495130a.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.this$0.f495134e;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public boolean isEmpty() {
            return this.this$0.f495130a.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public T poll() throws Exception {
            return this.this$0.f495130a.poll();
        }

        public UnicastQueueDisposable(UnicastSubject r100) {
            this.this$0 = r100;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.f
        public int requestFusion(int r100) {
            if ((r100 & 2) == 0) goto L6;
            this.this$0.f495139j = true;
            return 2;
        L6:
            return 0;
        }
    }

    public final void c() {
        Runnable r100 = this.f495132c.get();
        if (r100 == null) goto L17;
        AtomicReference<Runnable> r101 = this.f495132c;
    L6:
        if (r101.compareAndSet(r100, null) == true) goto L7;
        if (r101.get() == r100) goto L6;
        boolean r102 = false;
    L11:
        if (r102 == false) goto L18;
        r100.run();
        return;
    L18:
        return;
    L7:
        r102 = true;
        goto L11
    }

    public final void d() {
        if (this.f495138i.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super T> r100 = this.f495131b.get();
        int r101 = 1;
    L6:
        if (r100 != null) goto L8;
        r101 = this.f495138i.addAndGet(-r101);
        if (r101 == 0) goto L61;
        r100 = this.f495131b.get();
        goto L6
    L61:
        return;
    L8:
        if (this.f495139j == false) goto L31;
        io.reactivex.internal.queue.a<T> r102 = this.f495130a;
        boolean r103 = !this.f495133d;
        int r104 = 1;
    L11:
        if (this.f495134e == true) goto L12;
        boolean r105 = this.f495135f;
        if (r103 == false) goto L22;
        if (r105 == false) goto L22;
        Throwable r106 = this.f495136g;
        if (r106 == null) goto L19;
        this.f495131b.lazySet(null);
        r102.clear();
        r100.onError(r106);
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        return;
    L19:
        r107 = false;
    L22:
        r100.onNext(null);
        if (r105 == true) goto L24;
        r104 = this.f495138i.addAndGet(-r104);
        if (r104 != 0) goto L11;
        return;
    L24:
        this.f495131b.lazySet(null);
        Throwable r108 = this.f495136g;
        if (r108 == null) goto L27;
        r100.onError(r108);
        return;
    L27:
        r100.onComplete();
        return;
    L12:
        this.f495131b.lazySet(null);
        r102.clear();
        return;
    L31:
        io.reactivex.internal.queue.a<T> r109 = this.f495130a;
        boolean r110 = !this.f495133d;
        boolean r111 = true;
        int r112 = 1;
    L33:
        if (this.f495134e == true) goto L34;
        boolean r113 = this.f495135f;
        T r114 = this.f495130a.poll();
        if (r114 != null) goto L38;
        boolean r115 = true;
    L39:
        if (r113 == false) goto L54;
        if (r110 == false) goto L49;
        if (r111 == false) goto L49;
        Throwable r116 = this.f495136g;
        if (r116 == null) goto L45;
        this.f495131b.lazySet(null);
        r109.clear();
        r100.onError(r116);
        boolean r117 = true;
    L46:
        if (r117 == true) goto L86;
        r111 = false;
        goto L49
    L86:
        return;
    L45:
        r117 = false;
    L49:
        if (r115 == false) goto L54;
        this.f495131b.lazySet(null);
        Throwable r118 = this.f495136g;
        if (r118 == null) goto L53;
        r100.onError(r118);
        return;
    L53:
        r100.onComplete();
        return;
    L54:
        if (r115 == true) goto L55;
        r100.onNext(r114);
        goto L33
    L55:
        r112 = this.f495138i.addAndGet(-r112);
        if (r112 != 0) goto L33;
        return;
    L38:
        r115 = false;
        goto L39
    L34:
        this.f495131b.lazySet(null);
        r109.clear();
    }

    @Override // io.reactivex.subjects.Subject
    public final Throwable getThrowable() {
        if (this.f495135f == true) goto L5;
        return null;
    L5:
        return this.f495136g;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasComplete() {
        if (this.f495135f == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f495136g != null) goto L7;
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasObservers() {
        if (this.f495131b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasThrowable() {
        if (this.f495135f == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f495136g == null) goto L7;
        return true;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.f495135f == false) goto L5;
        return;
    L5:
        if (this.f495134e == true) goto L10;
        this.f495135f = true;
        c();
        d();
        return;
    }

    public UnicastSubject(int r100) {
        this.f495130a = new io.reactivex.internal.queue.a(ObjectHelper.verifyPositive(r100, "capacityHint"));
        this.f495132c = new AtomicReference();
        this.f495133d = true;
        this.f495131b = new AtomicReference();
        this.f495137h = new AtomicBoolean();
        this.f495138i = new UnicastQueueDisposable(this);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> a(int r100) {
        return new UnicastSubject(r100);
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495135f == false) goto L5;
    L9:
        RxJavaPlugins.onError(r100);
        return;
    L5:
        if (this.f495134e == true) goto L9;
        this.f495136g = r100;
        this.f495135f = true;
        c();
        d();
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495135f == false) goto L5;
        return;
    L5:
        if (this.f495134e == true) goto L10;
        this.f495130a.offer(r100);
        d();
        return;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        if (this.f495135f == false) goto L5;
    L6:
        r100.dispose();
        return;
    L5:
        if (this.f495134e == true) goto L6;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        if (this.f495137h.get() == false) goto L5;
    L11:
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), r100);
        return;
    L5:
        if (this.f495137h.compareAndSet(false, true) == false) goto L11;
        r100.onSubscribe(this.f495138i);
        this.f495131b.lazySet(r100);
        if (this.f495134e == false) goto L10;
        this.f495131b.lazySet(null);
        return;
    L10:
        d();
    }

    public UnicastSubject(int r100, Runnable r101) {
        this.f495130a = new io.reactivex.internal.queue.a(ObjectHelper.verifyPositive(r100, "capacityHint"));
        this.f495132c = new AtomicReference(ObjectHelper.requireNonNull(r101, "onTerminate"));
        this.f495133d = true;
        this.f495131b = new AtomicReference();
        this.f495137h = new AtomicBoolean();
        this.f495138i = new UnicastQueueDisposable(this);
    }
}
