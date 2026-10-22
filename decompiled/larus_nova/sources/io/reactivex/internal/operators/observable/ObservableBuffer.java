package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f493996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f493997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<U> f493998d;

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers;
        final int count;
        final Observer<? super U> downstream;
        long index;
        final int skip;
        Disposable upstream;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        L3:
            if (this.buffers.isEmpty() == true) goto L5;
            this.downstream.onNext(this.buffers.poll());
            goto L3
        L5:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.buffers.clear();
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            long r101 = this.index;
            this.index = 1 + r101;
            if ((r101 % ((long) this.skip)) == 0) goto L16;
        L9:
            Iterator<U> r102 = this.buffers.iterator();
        L11:
            if (r102.hasNext() == false) goto L15;
            U r103 = r102.next();
            r103.add(r100);
            if (this.count > r103.size()) goto L11;
            r102.remove();
            this.downstream.onNext(r103);
            goto L11
        L15:
            return;
        L16:
            Collection r104 = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
            this.buffers.offer((U) r104);
        L6:
            th = move-exception;
            this.buffers.clear();
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public BufferSkipObserver(Observer<? super U> r100, int r101, int r102, Callable<U> r103) {
            this.downstream = r100;
            this.count = r101;
            this.skip = r102;
            this.bufferSupplier = r103;
            this.buffers = new ArrayDeque();
        }
    }

    public static final class a<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super U> f493999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f494000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Callable<U> f494001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public U f494002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f494003e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Disposable f494004f;

        public final boolean b() {
            this.f494002d = (U) ObjectHelper.requireNonNull(this.f494001c.call(), "Empty buffer supplied");
            return true;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494002d = null;
            Disposable r100 = this.f494004f;
            if (r100 != null) goto L9;
            EmptyDisposable.error(th, this.f493999a);
            return false;
        L9:
            r100.dispose();
            this.f493999a.onError(th);
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494004f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494004f.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U r100 = this.f494002d;
            if (r100 == null) goto L9;
            this.f494002d = null;
            if (r100.isEmpty() == true) goto L7;
            this.f493999a.onNext(r100);
        L7:
            this.f493999a.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494002d = null;
            this.f493999a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            U r101 = this.f494002d;
            if (r101 == null) goto L8;
            r101.add(r100);
            int r102 = this.f494003e + 1;
            this.f494003e = r102;
            if (r102 < this.f494000b) goto L9;
            this.f493999a.onNext(r101);
            this.f494003e = 0;
            b();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494004f, r100) == false) goto L6;
            this.f494004f = r100;
            this.f493999a.onSubscribe(this);
            return;
        }

        public a(Observer<? super U> r100, int r101, Callable<U> r102) {
            this.f493999a = r100;
            this.f494000b = r101;
            this.f494001c = r102;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        int r101 = this.f493997c;
        int r102 = this.f493996b;
        if (r101 != r102) goto L7;
        a r103 = new a(r100, r102, this.f493998d);
        if (r103.b() == false) goto L9;
        this.f494245a.subscribe(r103);
        return;
    L9:
        return;
    L7:
        this.f494245a.subscribe(new BufferSkipObserver(r100, this.f493996b, this.f493997c, this.f493998d));
    }

    public ObservableBuffer(ObservableSource<T> r100, int r101, int r102, Callable<U> r103) {
        super(r100);
        this.f493996b = r101;
        this.f493997c = r102;
        this.f493998d = r103;
    }
}
