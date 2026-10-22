package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class k<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends ObservableSource<B>> f494414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<U> f494415c;

    public static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T, U, B> f494416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f494417c;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494417c == false) goto L5;
            return;
        L5:
            this.f494417c = true;
            this.f494416b.q();
        }

        public a(b<T, U, B> r100) {
            this.f494416b = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494417c == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494417c = true;
            this.f494416b.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(B r100) {
            if (this.f494417c == false) goto L5;
            return;
        L5:
            this.f494417c = true;
            dispose();
            this.f494416b.q();
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.observers.k<T, U, U> implements Disposable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Callable<U> f494418g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Callable<? extends ObservableSource<B>> f494419h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Disposable f494420i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AtomicReference<Disposable> f494421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public U f494422k;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            monitor-enter(this);
            U r100 = this.f494422k;     // Catch: Throwable -> L13
            if (r100 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            this.f494422k = null;     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            this.f492891c.offer(r100);
            this.f492893e = true;
            if (d() == false) goto L17;
            io.reactivex.internal.util.j.b(this.f492891c, this.f492890b, this, this);
            return;
        L17:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f492892d == true) goto L8;
            this.f492892d = true;
            this.f494420i.dispose();
            DisposableHelper.dispose(this.f494421j);
            if (d() == false) goto L9;
            this.f492891c.clear();
            return;
        L9:
            return;
        }

        public final void q() {
            U r100 = (U) ObjectHelper.requireNonNull(this.f494418g.call(), "The buffer supplied is null");     // Catch: Throwable -> L21
            ObservableSource r101 = (ObservableSource) ObjectHelper.requireNonNull(this.f494419h.call(), "The boundary ObservableSource supplied is null");     // Catch: Throwable -> L18
            a r102 = new a(this);
            if (DisposableHelper.replace(this.f494421j, r102) == false) goto L17;
            monitor-enter(this);
            U r103 = this.f494422k;     // Catch: Throwable -> L14
            if (r103 != null) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L11:
            this.f494422k = r100;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r101.subscribe(r102);
            l(r103, this);
            return;
        L14:
            th = move-exception;
            throw th;
        L17:
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492892d = true;
            this.f494420i.dispose();
            this.f492890b.onError(th);
            return;
        L21:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.f492890b.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492892d;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            dispose();
            this.f492890b.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            monitor-enter(this);
            U r101 = this.f494422k;     // Catch: Throwable -> L10
            if (r101 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            r101.add(r100);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494420i, r100) == false) goto L21;
            this.f494420i = r100;
            Observer<? super V> r101 = this.f492890b;
            this.f494422k = (U) ObjectHelper.requireNonNull(this.f494418g.call(), "The buffer supplied is null");
            ObservableSource r102 = (ObservableSource) ObjectHelper.requireNonNull(this.f494419h.call(), "The boundary ObservableSource supplied is null");     // Catch: Throwable -> L11
            a r103 = new a(this);
            this.f494421j.set(r103);
            r101.onSubscribe(this);
            if (this.f492892d == true) goto L22;
            r102.subscribe(r103);
            return;
        L22:
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492892d = true;
            r100.dispose();
            EmptyDisposable.error(th, r101);
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492892d = true;
            r100.dispose();
            EmptyDisposable.error(th, r101);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.observers.k, io.reactivex.internal.util.h
        public final void b(Observer r100, Object r101) {
            this.f492890b.onNext((Collection) r101);
        }

        public b(io.reactivex.observers.f r100, Callable r101, Callable r102) {
            super(r100, new MpscLinkedQueue());
            this.f494421j = new AtomicReference();
            this.f494418g = r101;
            this.f494419h = r102;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        this.f494245a.subscribe(new b(new io.reactivex.observers.f(r100), this.f494415c, this.f494414b));
    }

    public k(ObservableSource<T> r100, Callable<? extends ObservableSource<B>> r101, Callable<U> r102) {
        super(r100);
        this.f494414b = r101;
        this.f494415c = r102;
    }
}
