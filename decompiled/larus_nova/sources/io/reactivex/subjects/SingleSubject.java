package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    static final SingleDisposable[] EMPTY = null;
    static final SingleDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<SingleDisposable<T>[]> observers;
    final AtomicBoolean once;
    T value;

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject<T> r100 = getAndSet(null);
            if (r100 == null) goto L6;
            r100.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public SingleDisposable(SingleObserver<? super T> r100, SingleSubject<T> r101) {
            this.downstream = r100;
            lazySet(r101);
        }
    }

    static {
        EMPTY = new SingleDisposable[0];
        TERMINATED = new SingleDisposable[0];
    }

    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject();
    }

    public Throwable getThrowable() {
        if (this.observers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.error;
    }

    public T getValue() {
        if (this.observers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.value;
    }

    public boolean hasObservers() {
        if (this.observers.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasThrowable() {
        if (this.observers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    public boolean hasValue() {
        if (this.observers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.value == null) goto L7;
        return true;
    }

    public int observerCount() {
        return this.observers.get().length;
    }

    public SingleSubject() {
        this.once = new AtomicBoolean();
        this.observers = new AtomicReference(EMPTY);
    }

    public boolean add(SingleDisposable<T> r100) {
    L2:
        SingleDisposable<T>[] r101 = this.observers.get();
        boolean r102 = false;
        if (r101 == TERMINATED) goto L4;
        int r103 = r101.length;
        SingleDisposable<T>[] r104 = new SingleDisposable[r103 + 1];
        System.arraycopy(r101, 0, r104, 0, r103);
        r104[r103] = r100;
        AtomicReference<SingleDisposable<T>[]> r105 = this.observers;
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

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r101 = 0;
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.error = r100;
        SingleDisposable<T>[] r102 = this.observers.getAndSet(TERMINATED);
        int r103 = r102.length;
    L5:
        if (r101 >= r103) goto L10;
        r102[r101].downstream.onError(r100);
        r101 = r101 + 1;
        goto L5
    L10:
        return;
    L7:
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r100) {
        if (this.observers.get() != TERMINATED) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r100) {
        ObjectHelper.requireNonNull(r100, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r101 = 0;
        if (this.once.compareAndSet(false, true) == false) goto L7;
        this.value = r100;
        SingleDisposable<T>[] r102 = this.observers.getAndSet(TERMINATED);
        int r103 = r102.length;
    L5:
        if (r101 >= r103) goto L9;
        r102[r101].downstream.onSuccess(r100);
        r101 = r101 + 1;
        goto L5
    L9:
        return;
    }

    public void remove(SingleDisposable<T> r100) {
    L2:
        SingleDisposable<T>[] r101 = this.observers.get();
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
        SingleDisposable<T>[] r105 = EMPTY;
    L18:
        AtomicReference<SingleDisposable<T>[]> r106 = this.observers;
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
        SingleDisposable<T>[] r107 = new SingleDisposable[r102 - 1];
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

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> r100) {
        SingleDisposable<T> r101 = new SingleDisposable(r100, this);
        r100.onSubscribe(r101);
        if (add(r101) == true) goto L5;
        Throwable r102 = this.error;
        if (r102 == null) goto L10;
        r100.onError(r102);
        return;
    L10:
        r100.onSuccess(this.value);
        return;
    L5:
        if (r101.isDisposed() == false) goto L12;
        remove(r101);
        return;
    }
}
