package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class m0<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends T> f494500a;

    public static final class a<T> extends io.reactivex.internal.observers.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<? extends T> f494502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f494503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494504d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f494505e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f494506f;

        @Override // vtc.j
        public final void clear() {
            this.f494505e = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494503c = true;
        }

        @Override // vtc.j
        public final T poll() {
            if (this.f494505e == false) goto L6;
            return null;
        L6:
            if (this.f494506f == true) goto L8;
            this.f494506f = true;
        L13:
            return (T) ObjectHelper.requireNonNull(this.f494502b.next(), "The iterator returned a null value");
        L8:
            if (this.f494502b.hasNext() == true) goto L13;
            this.f494505e = true;
            return null;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494503c;
        }

        @Override // vtc.j
        public final boolean isEmpty() {
            return this.f494505e;
        }

        @Override // vtc.f
        public final int requestFusion(int r100) {
            if ((r100 & 1) == 0) goto L6;
            this.f494504d = true;
            return 1;
        L6:
            return 0;
        }

        public a(Observer<? super T> r100, Iterator<? extends T> r101) {
            this.f494501a = r100;
            this.f494502b = r101;
        }
    }

    public m0(Iterable<? extends T> r100) {
        this.f494500a = r100;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Iterator<? extends T> r101 = this.f494500a.iterator();     // Catch: Throwable -> L29
        if (r101.hasNext() == true) goto L7;
        EmptyDisposable.complete(r100);
        return;
    L7:
        a r102 = new a(r100, r101);
        r100.onSubscribe(r102);
        if (r102.f494504d == false) goto L10;
        return;
    L10:
        if (r102.f494503c == true) goto L48;
        Object r103 = ObjectHelper.requireNonNull(r102.f494502b.next(), "The iterator returned a null value");     // Catch: Throwable -> L23
        r102.f494501a.onNext(r103);
        if (r102.f494503c == true) goto L49;
        if (r102.f494502b.hasNext() == true) goto L10;
        if (r102.f494503c == true) goto L45;
        r102.f494501a.onComplete();
        return;
    L45:
        return;
    L21:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r102.f494501a.onError(th);
        return;
    L49:
        return;
    L23:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r102.f494501a.onError(th);
        return;
    L48:
        return;
    L26:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
        return;
    L29:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }
}
