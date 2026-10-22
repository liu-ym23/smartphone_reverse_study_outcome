package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableSource<?>[] f494231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterable<? extends ObservableSource<?>> f494232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function<? super Object[], R> f494233d;

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Observer<? super R> downstream;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReference<Disposable> upstream;
        final AtomicReferenceArray<Object> values;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            WithLatestInnerObserver[] r100 = this.observers;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            r100[r102].dispose();
            r102 = r102 + 1;
            goto L3
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
            return;
        }

        public void cancelAllBut(int r100) {
            WithLatestInnerObserver[] r101 = this.observers;
            int r102 = 0;
        L4:
            if (r102 >= r101.length) goto L8;
            if (r102 == r100) goto L7;
            r101[r102].dispose();
        L7:
            r102 = r102 + 1;
            goto L4
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.g.c(this.downstream, r100, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.done == false) goto L5;
            return;
        L5:
            AtomicReferenceArray<Object> r101 = this.values;
            int r102 = r101.length();
            Object[] r103 = new Object[r102 + 1];
            int r104 = 0;
            r103[0] = r100;
        L6:
            if (r104 >= r102) goto L17;
            Object r105 = r101.get(r104);
            if (r105 == null) goto L9;
            r104 = r104 + 1;
            r103[r104] = r105;
            goto L6
        L9:
            return;
        L17:
            Object r106 = ObjectHelper.requireNonNull(this.combiner.apply(r103), "combiner returned a null value");     // Catch: Throwable -> L14
            io.reactivex.internal.util.g.e(this.downstream, r106, this, this.error);
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this.upstream, r100);
        }

        public void innerComplete(int r100, boolean r101) {
            if (r101 == true) goto L5;
            this.done = true;
            cancelAllBut(r100);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
            return;
        }

        public void innerError(int r100, Throwable r101) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(r100);
            io.reactivex.internal.util.g.c(this.downstream, r101, this, this.error);
        }

        public void innerNext(int r100, Object r101) {
            this.values.set(r100, r101);
        }

        public void subscribe(ObservableSource<?>[] r100, int r101) {
            WithLatestInnerObserver[] r102 = this.observers;
            AtomicReference<Disposable> r103 = this.upstream;
            int r104 = 0;
        L3:
            if (r104 >= r101) goto L10;
            if (DisposableHelper.isDisposed(r103.get()) == true) goto L14;
            if (this.done == true) goto L15;
            r100[r104].subscribe(r102[r104]);
            r104 = r104 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }

        public WithLatestFromObserver(Observer<? super R> r100, Function<? super Object[], R> r101, int r102) {
            this.downstream = r100;
            this.combiner = r101;
            WithLatestInnerObserver[] r103 = new WithLatestInnerObserver[r102];
            int r104 = 0;
        L3:
            if (r104 >= r102) goto L5;
            r103[r104] = new WithLatestInnerObserver(this, r104);
            r104 = r104 + 1;
            goto L3
        L5:
            this.observers = r103;
            this.values = new AtomicReferenceArray(r102);
            this.upstream = new AtomicReference();
            this.error = new AtomicThrowable();
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.parent.innerError(this.index, r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object r100) {
            if (this.hasValue == true) goto L5;
            this.hasValue = true;
        L5:
            this.parent.innerNext(this.index, r100);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> r100, int r101) {
            this.parent = r100;
            this.index = r101;
        }
    }

    public final class a implements Function<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableWithLatestFromMany f494234a;

        public a(ObservableWithLatestFromMany r100) {
            this.f494234a = r100;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public final R apply(T r100) throws Exception {
            return (R) ObjectHelper.requireNonNull(this.f494234a.f494233d.apply(new Object[]{r100}), "The combiner returned a null value");
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        ObservableSource<?>[] r101 = this.f494231b;
        if (r101 != null) goto L16;
        r101 = new ObservableSource[8];
        Iterator<? extends ObservableSource<?>> r102 = this.f494232c.iterator();     // Catch: Throwable -> L13
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L17;
        ObservableSource<?> r104 = r102.next();     // Catch: Throwable -> L13
        if (r103 != r101.length) goto L11;
        r101 = (ObservableSource[]) Arrays.copyOf(r101, (r103 >> 1) + r103);     // Catch: Throwable -> L13
    L11:
        int r105 = r103 + 1;     // Catch: Throwable -> L13
        r101[r103] = r104;     // Catch: Throwable -> L13
        r103 = r105;
    L17:
        if (r103 != 0) goto L20;
        new m1(this.f494245a, new a(this)).subscribeActual(r100);
        return;
    L20:
        WithLatestFromObserver r106 = new WithLatestFromObserver(r100, this.f494233d, r103);
        r100.onSubscribe(r106);
        r106.subscribe(r101, r103);
        this.f494245a.subscribe(r106);
        return;
    L13:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
        return;
    L16:
        r103 = r101.length;
        goto L17
    }

    public ObservableWithLatestFromMany(ObservableSource<T> r100, Iterable<? extends ObservableSource<?>> r101, Function<? super Object[], R> r102) {
        super(r100);
        this.f494231b = null;
        this.f494232c = r101;
        this.f494233d = r102;
    }

    public ObservableWithLatestFromMany(ObservableSource<T> r100, ObservableSource<?>[] r101, Function<? super Object[], R> r102) {
        super(r100);
        this.f494231b = r101;
        this.f494232c = null;
        this.f494233d = r102;
    }
}
