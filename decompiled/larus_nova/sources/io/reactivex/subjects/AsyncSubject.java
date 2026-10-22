package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class AsyncSubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AsyncDisposable[] f495100d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AsyncDisposable[] f495101e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<AsyncDisposable<T>[]> f495102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f495103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f495104c;

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose() == false) goto L6;
            this.parent.a(this);
            return;
        }

        public void onComplete() {
            if (isDisposed() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r100) {
            if (isDisposed() == false) goto L5;
            RxJavaPlugins.onError(r100);
            return;
        L5:
            this.downstream.onError(r100);
        }

        public AsyncDisposable(Observer<? super T> r100, AsyncSubject<T> r101) {
            super(r100);
            this.parent = r101;
        }
    }

    static {
        f495100d = new AsyncDisposable[0];
        f495101e = new AsyncDisposable[0];
    }

    @Override // io.reactivex.subjects.Subject
    public final Throwable getThrowable() {
        if (this.f495102a.get() == f495101e) goto L7;
        return null;
    L7:
        return this.f495103b;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasComplete() {
        if (this.f495102a.get() == f495101e) goto L5;
    L7:
        return false;
    L5:
        if (this.f495103b != null) goto L7;
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasObservers() {
        if (this.f495102a.get().length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.subjects.Subject
    public final boolean hasThrowable() {
        if (this.f495102a.get() == f495101e) goto L5;
    L7:
        return false;
    L5:
        if (this.f495103b == null) goto L7;
        return true;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        AsyncDisposable<T>[] r100 = this.f495102a.get();
        AsyncDisposable<T>[] r101 = f495101e;
        if (r100 != r101) goto L5;
        return;
    L5:
        T r102 = this.f495104c;
        AsyncDisposable<T>[] r103 = this.f495102a.getAndSet(r101);
        int r104 = 0;
        if (r102 != null) goto L10;
        int r105 = r103.length;
    L8:
        if (r104 >= r105) goto L13;
        r103[r104].onComplete();
        r104 = r104 + 1;
        goto L8
    L13:
        return;
    L10:
        int r106 = r103.length;
    L11:
        if (r104 >= r106) goto L16;
        r103[r104].complete(r102);
        r104 = r104 + 1;
        goto L11
    }

    public AsyncSubject() {
        this.f495102a = new AtomicReference(f495100d);
    }

    public final void a(AsyncDisposable<T> r100) {
    L2:
        AsyncDisposable<T>[] r101 = this.f495102a.get();
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
        AsyncDisposable<T>[] r105 = f495100d;
    L18:
        AtomicReference<AsyncDisposable<T>[]> r106 = this.f495102a;
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
        AsyncDisposable<T>[] r107 = new AsyncDisposable[r102 - 1];
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

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] r101 = this.f495102a.get();
        AsyncDisposable<T>[] r102 = f495101e;
        if (r101 != r102) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f495104c = null;
        this.f495103b = r100;
        AsyncDisposable<T>[] r103 = this.f495102a.getAndSet(r102);
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r103[r105].onError(r100);
        r105 = r105 + 1;
        goto L7
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        ObjectHelper.requireNonNull(r100, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f495102a.get() != f495101e) goto L5;
        return;
    L5:
        this.f495104c = r100;
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        if (this.f495102a.get() != f495101e) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        AsyncDisposable<T> r101 = new AsyncDisposable(r100, this);
        r100.onSubscribe(r101);
    L3:
        AsyncDisposable<T>[] r102 = this.f495102a.get();
        boolean r103 = false;
        if (r102 == f495101e) goto L14;
        int r104 = r102.length;
        AsyncDisposable<T>[] r105 = new AsyncDisposable[r104 + 1];
        System.arraycopy(r102, 0, r105, 0, r104);
        r105[r104] = r101;
        AtomicReference<AsyncDisposable<T>[]> r106 = this.f495102a;
    L8:
        if (r106.compareAndSet(r102, r105) == true) goto L9;
        if (r106.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L3;
        r103 = true;
        goto L14
    L9:
        r103 = true;
    L14:
        if (r103 == true) goto L16;
        Throwable r107 = this.f495103b;
        if (r107 == null) goto L21;
        r100.onError(r107);
        return;
    L21:
        T r108 = this.f495104c;
        if (r108 == null) goto L24;
        r101.complete(r108);
        return;
    L24:
        r101.onComplete();
        return;
    L16:
        if (r101.isDisposed() == false) goto L33;
        a(r101);
        return;
    }
}
