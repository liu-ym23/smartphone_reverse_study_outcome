package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes41.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    static final a[] EMPTY = null;
    private static final Object[] EMPTY_ARRAY = null;
    static final a[] TERMINATED = null;
    long index;
    final ReadWriteLock lock;
    final Lock readLock;
    final AtomicReference<a<T>[]> subscribers;
    final AtomicReference<Throwable> terminalEvent;
    final AtomicReference<Object> value;
    final Lock writeLock;

    public static final class a<T> implements Disposable, io.reactivex.internal.util.a.InterfaceC6334a<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f495105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BehaviorSubject<T> f495106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f495107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f495108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public io.reactivex.internal.util.a<Object> f495109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f495110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f495111g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f495112h;

        public final void b() {
        L3:
            if (this.f495111g == true) goto L4;
            monitor-enter(this);
            io.reactivex.internal.util.a<Object> r100 = this.f495109e;     // Catch: Throwable -> L14
            if (r100 == null) goto L8;
            this.f495109e = null;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r100.c(this);
            goto L3
        L8:
            this.f495108d = false;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f495111g == true) goto L6;
            this.f495111g = true;
            this.f495106b.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f495111g;
        }

        @Override // io.reactivex.internal.util.a.InterfaceC6334a, io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            if (this.f495111g == false) goto L5;
        L8:
            return true;
        L5:
            if (NotificationLite.accept(r100, this.f495105a) == true) goto L8;
            return false;
        }

        public a(Observer<? super T> r100, BehaviorSubject<T> r101) {
            this.f495105a = r100;
            this.f495106b = r101;
        }

        public final void d(Object r100, long r101) {
            if (this.f495111g == false) goto L6;
            return;
        L6:
            if (this.f495110f == true) goto L30;
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L9:
            if (this.f495111g == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L13:
            if (this.f495112h != r101) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L17:
            if (this.f495108d == false) goto L24;
            io.reactivex.internal.util.a<Object> r102 = this.f495109e;     // Catch: Throwable -> L27
            if (r102 != null) goto L21;
            r102 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L27
            this.f495109e = r102;     // Catch: Throwable -> L27
        L21:
            r102.b(r100);     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L24:
            this.f495107c = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.f495110f = true;
        L30:
            test(r100);
        }
    }

    static {
        EMPTY_ARRAY = new Object[0];
        EMPTY = new a[0];
        TERMINATED = new a[0];
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject();
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        Object r100 = this.value.get();
        if (NotificationLite.isError(r100) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r100);
    }

    public T getValue() {
        Object r100 = this.value.get();
        if (NotificationLite.isComplete(r100) == false) goto L5;
        return null;
    L5:
        if (NotificationLite.isError(r100) == false) goto L8;
        return null;
    L8:
        return (T) NotificationLite.getValue(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] r100 = EMPTY_ARRAY;
        Object[] r101 = getValues(r100);
        if (r101 == r100) goto L5;
        return r101;
    L5:
        return new Object[0];
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.value.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        if (this.subscribers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.value.get());
    }

    public boolean hasValue() {
        Object r100 = this.value.get();
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (NotificationLite.isComplete(r100) == true) goto L9;
        if (NotificationLite.isError(r100) == true) goto L9;
        return true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        AtomicReference<Throwable> r100 = this.terminalEvent;
        Throwable r101 = ExceptionHelper.f495041a;
    L3:
        int r102 = 0;
        if (r100.compareAndSet(null, r101) == true) goto L5;
        if (r100.get() == null) goto L3;
        boolean r103 = false;
    L9:
        if (r103 == true) goto L11;
        return;
    L11:
        Object r104 = NotificationLite.complete();
        a<T>[] r105 = terminate(r104);
        int r106 = r105.length;
    L12:
        if (r102 >= r106) goto L14;
        r105[r102].d(r104, this.index);
        r102 = r102 + 1;
        goto L12
    L14:
        return;
    L5:
        r103 = true;
        goto L9
    }

    public int subscriberCount() {
        return this.subscribers.get().length;
    }

    public BehaviorSubject() {
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        this.lock = r100;
        this.readLock = r100.readLock();
        this.writeLock = r100.writeLock();
        this.subscribers = new AtomicReference(EMPTY);
        this.value = new AtomicReference();
        this.terminalEvent = new AtomicReference();
    }

    public BehaviorSubject(T r100) {
        this();
        this.value.lazySet(ObjectHelper.requireNonNull(r100, "defaultValue is null"));
    }

    @CheckReturnValue
    public static <T> BehaviorSubject<T> createDefault(T r100) {
        return new BehaviorSubject(r100);
    }

    public boolean add(a<T> r100) {
    L2:
        a<T>[] r101 = this.subscribers.get();
        boolean r102 = false;
        if (r101 == TERMINATED) goto L4;
        int r103 = r101.length;
        a<T>[] r104 = new a[r103 + 1];
        System.arraycopy(r101, 0, r104, 0, r103);
        r104[r103] = r100;
        AtomicReference<a<T>[]> r105 = this.subscribers;
    L7:
        if (r105.compareAndSet(r101, r104) == true) goto L8;
        if (r105.get() == r101) goto L7;
    L11:
        if (r102 == false) goto L2;
        return true;
    L8:
        r102 = true;
        goto L11
    L4:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] getValues(T[] r100) {
        Object r101 = this.value.get();
        if (r101 == null) goto L17;
        if (NotificationLite.isComplete(r101) == true) goto L17;
        if (NotificationLite.isError(r101) == true) goto L17;
        Object r102 = NotificationLite.getValue(r101);
        if (r100.length == 0) goto L14;
        r100[0] = r102;
        if (r100.length == 1) goto L20;
        r100[1] = 0;
        return r100;
    L20:
        return r100;
    L14:
        T[] r103 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), 1));
        r103[0] = r102;
        return r103;
    L17:
        if (r100.length == 0) goto L19;
        r100[0] = 0;
    L19:
        return r100;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference<Throwable> r101 = this.terminalEvent;
    L3:
        int r102 = 0;
        if (r101.compareAndSet(null, r100) == true) goto L5;
        if (r101.get() == null) goto L3;
        boolean r103 = false;
    L9:
        if (r103 == true) goto L12;
        RxJavaPlugins.onError(r100);
        return;
    L12:
        Object r104 = NotificationLite.error(r100);
        a<T>[] r105 = terminate(r104);
        int r106 = r105.length;
    L13:
        if (r102 >= r106) goto L15;
        r105[r102].d(r104, this.index);
        r102 = r102 + 1;
        goto L13
    L15:
        return;
    L5:
        r103 = true;
        goto L9
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.terminalEvent.get() == null) goto L5;
        return;
    L5:
        Object r101 = NotificationLite.next(r100);
        setCurrent(r101);
        a<T>[] r102 = this.subscribers.get();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r102[r104].d(r101, this.index);
        r104 = r104 + 1;
        goto L6
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        if (this.terminalEvent.get() == null) goto L6;
        r100.dispose();
        return;
    }

    public void remove(a<T> r100) {
    L2:
        a<T>[] r101 = this.subscribers.get();
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
        a<T>[] r105 = EMPTY;
    L18:
        AtomicReference<a<T>[]> r106 = this.subscribers;
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
        a<T>[] r107 = new a[r102 - 1];
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

    public void setCurrent(Object r100) {
        this.writeLock.lock();
        this.index++;
        this.value.lazySet(r100);
        this.writeLock.unlock();
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r100) {
        a<T> r101 = new a(r100, this);
        r100.onSubscribe(r101);
        if (add(r101) == true) goto L5;
        Throwable r102 = this.terminalEvent.get();
        if (r102 != ExceptionHelper.f495041a) goto L36;
        r100.onComplete();
        return;
    L36:
        r100.onError(r102);
        return;
    L5:
        if (r101.f495111g == false) goto L8;
        remove(r101);
        return;
    L8:
        if (r101.f495111g == true) goto L44;
        monitor-enter(r101);
    L30:
        th = move-exception;
        throw th;
    L12:
        if (r101.f495111g == false) goto L16;
        monitor-exit(r101);     // Catch: Throwable -> L30
    L38:
        return;
    L16:
        if (r101.f495107c == false) goto L19;
        monitor-exit(r101);     // Catch: Throwable -> L30
        goto L38
    L19:
        Lock r103 = this.readLock;     // Catch: Throwable -> L30
        r103.lock();     // Catch: Throwable -> L30
        r101.f495112h = this.index;     // Catch: Throwable -> L30
        Object r104 = this.value.get();     // Catch: Throwable -> L30
        r103.unlock();     // Catch: Throwable -> L30
        if (r104 == null) goto L22;
        boolean r105 = true;
    L23:
        r101.f495108d = r105;     // Catch: Throwable -> L30
        r101.f495107c = true;     // Catch: Throwable -> L30
        monitor-exit(r101);     // Catch: Throwable -> L30
        if (r104 == null) goto L38;
        if (r101.test(r104) == true) goto L38;
        r101.b();
        goto L38
    L22:
        r105 = false;
        goto L23
    }

    public a<T>[] terminate(Object r100) {
        AtomicReference<a<T>[]> r101 = this.subscribers;
        a<T>[] r102 = TERMINATED;
        a<T>[] r103 = r101.getAndSet(r102);
        if (r103 == r102) goto L5;
        setCurrent(r100);
    L5:
        return r103;
    }
}
