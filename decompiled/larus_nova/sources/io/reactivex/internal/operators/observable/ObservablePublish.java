package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservablePublish<T> extends io.reactivex.observables.a<T> {
    final AtomicReference<a<T>> current;
    final ObservableSource<T> onSubscribe;
    final ObservableSource<T> source;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final Observer<? super T> child;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object r100 = getAndSet(this);
            if (r100 == null) goto L7;
            if (r100 == this) goto L8;
            ((a) r100).b(this);
            return;
        L8:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != this) goto L5;
            return true;
        L5:
            return false;
        }

        public InnerDisposable(Observer<? super T> r100) {
            this.child = r100;
        }

        public void setParent(a<T> r100) {
            if (compareAndSet(null, r100) == true) goto L6;
            r100.b(this);
            return;
        }
    }

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final InnerDisposable[] f494094e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final InnerDisposable[] f494095f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<a<T>> f494096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<InnerDisposable<T>[]> f494097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f494098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReference<Disposable> f494099d;

        static {
            f494094e = new InnerDisposable[0];
            f494095f = new InnerDisposable[0];
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            AtomicReference<InnerDisposable<T>[]> r100 = this.f494097b;
            InnerDisposable<T>[] r101 = f494095f;
            if (r100.getAndSet(r101) == r101) goto L15;
            AtomicReference<a<T>> r102 = this.f494096a;
        L6:
            if (r102.compareAndSet(this, null) == true) goto L10;
            if (r102.get() == this) goto L6;
        L10:
            DisposableHelper.dispose(this.f494099d);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.f494097b.get() != f494095f) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            AtomicReference<a<T>> r100 = this.f494096a;
        L4:
            if (r100.compareAndSet(this, null) == true) goto L8;
            if (r100.get() == this) goto L4;
        L8:
            InnerDisposable<T>[] r101 = this.f494097b.getAndSet(f494095f);
            int r102 = r101.length;
            int r103 = 0;
        L9:
            if (r103 >= r102) goto L11;
            r101[r103].child.onComplete();
            r103 = r103 + 1;
            goto L9
        }

        public a(AtomicReference<a<T>> r100) {
            this.f494099d = new AtomicReference();
            this.f494097b = new AtomicReference(f494094e);
            this.f494096a = r100;
            this.f494098c = new AtomicBoolean();
        }

        public final void b(InnerDisposable<T> r100) {
        L2:
            InnerDisposable<T>[] r101 = this.f494097b.get();
            int r102 = r101.length;
            if (r102 == 0) goto L4;
            boolean r103 = false;
            int r104 = 0;
        L6:
            if (r104 >= r102) goto L11;
            if (r101[r104].equals(r100) == true) goto L12;
            r104 = r104 + 1;
        L12:
            if (r104 < 0) goto L13;
            if (r102 != 1) goto L17;
            InnerDisposable<T>[] r105 = f494094e;
        L18:
            AtomicReference<InnerDisposable<T>[]> r106 = this.f494097b;
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
            InnerDisposable<T>[] r107 = new InnerDisposable[r102 - 1];
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
            AtomicReference<a<T>> r101 = this.f494096a;
        L4:
            if (r101.compareAndSet(this, null) == true) goto L8;
            if (r101.get() == this) goto L4;
        L8:
            InnerDisposable<T>[] r102 = this.f494097b.getAndSet(f494095f);
            if (r102.length == 0) goto L13;
            int r103 = r102.length;
            int r104 = 0;
        L11:
            if (r104 >= r103) goto L19;
            r102[r104].child.onError(r100);
            r104 = r104 + 1;
            goto L11
        L19:
            return;
        L13:
            RxJavaPlugins.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            InnerDisposable<T>[] r101 = this.f494097b.get();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101[r103].child.onNext(r100);
            r103 = r103 + 1;
            goto L3
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this.f494099d, r100);
        }
    }

    public static final class b<T> implements ObservableSource<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<a<T>> f494100a;

        public b(AtomicReference<a<T>> r100) {
            this.f494100a = r100;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> r110) {
            InnerDisposable<T> r100 = new InnerDisposable(r110);
            r110.onSubscribe(r100);
        L3:
            a<T> r111 = this.f494100a.get();
            boolean r101 = false;
            if (r111 != null) goto L6;
        L9:
            a<T> r102 = new a(this.f494100a);
            AtomicReference<a<T>> r103 = this.f494100a;
        L11:
            if (r103.compareAndSet(r111, r102) == true) goto L12;
            if (r103.get() == r111) goto L11;
            boolean r112 = false;
        L16:
            if (r112 == false) goto L3;
            a<T> r104 = r102;
        L19:
            InnerDisposable<T>[] r105 = r104.f494097b.get();
            if (r105 == a.f494095f) goto L31;
            int r113 = r105.length;
            InnerDisposable<T>[] r106 = new InnerDisposable[r113 + 1];
            System.arraycopy(r105, 0, r106, 0, r113);
            r106[r113] = r100;
            AtomicReference<InnerDisposable<T>[]> r107 = r104.f494097b;
        L24:
            if (r107.compareAndSet(r105, r106) == true) goto L25;
            if (r107.get() == r105) goto L24;
            boolean r114 = false;
        L29:
            if (r114 == false) goto L19;
            r101 = true;
            goto L31
        L25:
            r114 = true;
        L31:
            if (r101 == false) goto L3;
            r100.setParent(r104);
            return;
        L12:
            r112 = true;
            goto L16
        L6:
            if (r111.isDisposed() == true) goto L9;
            r104 = r111;
            goto L19
        }
    }

    public ObservableSource<T> source() {
        return this.source;
    }

    public static <T> io.reactivex.observables.a<T> create(ObservableSource<T> r100) {
        AtomicReference r101 = new AtomicReference();
        return RxJavaPlugins.onAssembly(new ObservablePublish(new b(r101), r100, r101));
    }

    @Override // io.reactivex.observables.a
    public void connect(Consumer<? super Disposable> r100) {
    L2:
        a<T> r101 = this.current.get();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L6:
        a<T> r103 = new a(this.current);
        AtomicReference<a<T>> r104 = this.current;
    L8:
        if (r104.compareAndSet(r101, r103) == true) goto L9;
        if (r104.get() == r101) goto L8;
        boolean r105 = false;
    L13:
        if (r105 == false) goto L2;
        r101 = r103;
    L17:
        if (r101.f494098c.get() == false) goto L19;
    L28:
        r100.accept(r101);     // Catch: Throwable -> L25
        if (r102 == false) goto L38;
        this.source.subscribe(r101);
        return;
    L38:
        return;
    L25:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.d(th);
    L19:
        if (r101.f494098c.compareAndSet(false, true) == false) goto L28;
        r102 = true;
        goto L28
    L9:
        r105 = true;
        goto L13
    L5:
        if (r101.isDisposed() == false) goto L17;
        goto L6
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> r100) {
        this.onSubscribe.subscribe(r100);
    }

    private ObservablePublish(ObservableSource<T> r100, ObservableSource<T> r101, AtomicReference<a<T>> r102) {
        this.onSubscribe = r100;
        this.source = r101;
        this.current = r102;
    }
}
