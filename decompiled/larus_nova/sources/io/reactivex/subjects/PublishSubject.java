package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class PublishSubject<T> extends Subject<T> {
    static final PublishDisposable[] EMPTY = null;
    static final PublishDisposable[] TERMINATED = null;
    Throwable error;
    final AtomicReference<PublishDisposable<T>[]> subscribers;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishSubject<T> parent;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.remove(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r100) {
            if (get() == false) goto L5;
            RxJavaPlugins.onError(r100);
            return;
        L5:
            this.downstream.onError(r100);
        }

        public void onNext(T r100) {
            if (get() == true) goto L6;
            this.downstream.onNext(r100);
            return;
        }

        public PublishDisposable(Observer<? super T> r100, PublishSubject<T> r101) {
            this.downstream = r100;
            this.parent = r101;
        }
    }

    static {
        TERMINATED = new PublishDisposable[0];
        EMPTY = new PublishDisposable[0];
    }

    @CheckReturnValue
    public static <T> PublishSubject<T> create() {
        return new PublishSubject();
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) goto L5;
        return null;
    L5:
        return this.error;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error != null) goto L7;
        return true;
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
        if (this.subscribers.get() == TERMINATED) goto L5;
    L7:
        return false;
    L5:
        if (this.error == null) goto L7;
        return true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        PublishDisposable<T>[] r100 = this.subscribers.get();
        PublishDisposable<T>[] r101 = TERMINATED;
        if (r100 != r101) goto L5;
        return;
    L5:
        PublishDisposable<T>[] r102 = this.subscribers.getAndSet(r101);
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        r102[r104].onComplete();
        r104 = r104 + 1;
        goto L6
    }

    public PublishSubject() {
        this.subscribers = new AtomicReference(EMPTY);
    }

    public boolean add(PublishDisposable<T> r100) {
    L2:
        PublishDisposable<T>[] r101 = this.subscribers.get();
        boolean r102 = false;
        if (r101 == TERMINATED) goto L4;
        int r103 = r101.length;
        PublishDisposable<T>[] r104 = new PublishDisposable[r103 + 1];
        System.arraycopy(r101, 0, r104, 0, r103);
        r104[r103] = r100;
        AtomicReference<PublishDisposable<T>[]> r105 = this.subscribers;
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

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] r101 = this.subscribers.get();
        PublishDisposable<T>[] r102 = TERMINATED;
        if (r101 != r102) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.error = r100;
        PublishDisposable<T>[] r103 = this.subscribers.getAndSet(r102);
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r103[r105].onError(r100);
        r105 = r105 + 1;
        goto L7
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] r101 = this.subscribers.get();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].onNext(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        if (this.subscribers.get() != TERMINATED) goto L6;
        r100.dispose();
        return;
    }

    public void remove(PublishDisposable<T> r100) {
    L2:
        PublishDisposable<T>[] r101 = this.subscribers.get();
        if (r101 == TERMINATED) goto L27;
        if (r101 == EMPTY) goto L39;
        int r102 = r101.length;
        boolean r103 = false;
        int r104 = 0;
    L8:
        if (r104 >= r102) goto L13;
        if (r101[r104] == r100) goto L14;
        r104 = r104 + 1;
    L14:
        if (r104 < 0) goto L15;
        if (r102 != 1) goto L19;
        PublishDisposable<T>[] r105 = EMPTY;
    L20:
        AtomicReference<PublishDisposable<T>[]> r106 = this.subscribers;
    L22:
        if (r106.compareAndSet(r101, r105) == true) goto L23;
        if (r106.get() == r101) goto L22;
    L26:
        if (r103 == false) goto L2;
        return;
    L23:
        r103 = true;
        goto L26
    L19:
        PublishDisposable<T>[] r107 = new PublishDisposable[r102 - 1];
        System.arraycopy(r101, 0, r107, 0, r104);
        System.arraycopy(r101, r104 + 1, r107, r104, (r102 - r104) - 1);
        r105 = r107;
        goto L20
    L15:
        return;
    L13:
        r104 = -1;
        goto L14
    L39:
        return;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r100) {
        PublishDisposable<T> r101 = new PublishDisposable(r100, this);
        r100.onSubscribe(r101);
        if (add(r101) == true) goto L5;
        Throwable r102 = this.error;
        if (r102 == null) goto L10;
        r100.onError(r102);
        return;
    L10:
        r100.onComplete();
        return;
    L5:
        if (r101.isDisposed() == false) goto L12;
        remove(r101);
        return;
    }
}
