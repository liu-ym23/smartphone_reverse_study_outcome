package com.jakewharton.rxrelay2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes23.dex */
public final class PublishRelay<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PublishDisposable[] f278528b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<PublishDisposable<T>[]> f278529a;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> downstream;
        final PublishRelay<T> parent;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.a(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onNext(T r100) {
            if (get() == true) goto L6;
            this.downstream.onNext(r100);
            return;
        }

        public PublishDisposable(Observer<? super T> r100, PublishRelay<T> r101) {
            this.downstream = r100;
            this.parent = r101;
        }
    }

    static {
        f278528b = new PublishDisposable[0];
    }

    public PublishRelay() {
        this.f278529a = new AtomicReference(f278528b);
    }

    public final void a(PublishDisposable<T> r100) {
    L2:
        PublishDisposable<T>[] r101 = this.f278529a.get();
        PublishDisposable<T>[] r102 = f278528b;
        if (r101 == r102) goto L4;
        int r103 = r101.length;
        boolean r104 = false;
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L11;
        if (r101[r105] == r100) goto L12;
        r105 = r105 + 1;
    L12:
        if (r105 < 0) goto L13;
        if (r103 == 1) goto L18;
        r102 = new PublishDisposable[r103 - 1];
        System.arraycopy(r101, 0, r102, 0, r105);
        System.arraycopy(r101, r105 + 1, r102, r105, (r103 - r105) - 1);
    L18:
        AtomicReference<PublishDisposable<T>[]> r106 = this.f278529a;
    L20:
        if (r106.compareAndSet(r101, r102) == true) goto L21;
        if (r106.get() == r101) goto L20;
    L24:
        if (r104 == false) goto L2;
        return;
    L21:
        r104 = true;
        goto L24
    L13:
        return;
    L11:
        r105 = -1;
        goto L12
    }

    @Override // com.jakewharton.rxrelay2.b, io.reactivex.functions.Consumer
    public final void accept(T r100) {
        if (r100 == null) goto L8;
        PublishDisposable<T>[] r101 = this.f278529a.get();
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L6;
        r101[r103].onNext(r100);
        r103 = r103 + 1;
        goto L4
    L6:
        return;
    L8:
        throw new NullPointerException("value == null");
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        PublishDisposable<T> r101 = new PublishDisposable(r100, this);
        r100.onSubscribe(r101);
    L3:
        PublishDisposable<T>[] r102 = this.f278529a.get();
        int r103 = r102.length;
        PublishDisposable<T>[] r104 = new PublishDisposable[r103 + 1];
        boolean r105 = false;
        System.arraycopy(r102, 0, r104, 0, r103);
        r104[r103] = r101;
        AtomicReference<PublishDisposable<T>[]> r106 = this.f278529a;
    L5:
        if (r106.compareAndSet(r102, r104) == true) goto L6;
        if (r106.get() == r102) goto L5;
    L9:
        if (r105 == false) goto L3;
        if (r101.isDisposed() == false) goto L20;
        a(r101);
        return;
    L20:
        return;
    L6:
        r105 = true;
        goto L9
    }
}
