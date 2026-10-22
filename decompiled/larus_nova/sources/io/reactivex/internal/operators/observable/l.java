package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class l<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableSource<B> f494435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<U> f494436c;

    public static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T, U, B> f494437b;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494437b.onComplete();
        }

        public a(b<T, U, B> r100) {
            this.f494437b = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494437b.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(B r100) {
            b<T, U, B> r101 = this.f494437b;
            r101.getClass();
            U r102 = (U) ObjectHelper.requireNonNull(r101.f494438g.call(), "The buffer supplied is null");     // Catch: Throwable -> L15
            monitor-enter(r101);
            U r103 = r101.f494442k;     // Catch: Throwable -> L12
            if (r103 != null) goto L9;
            monitor-exit(r101);     // Catch: Throwable -> L12
        L18:
            return;
        L9:
            r101.f494442k = r102;     // Catch: Throwable -> L12
            monitor-exit(r101);     // Catch: Throwable -> L12
            r101.l(r103, r101);
        L12:
            th = move-exception;
            throw th;
        L15:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r101.dispose();
            r101.f492890b.onError(th);
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.observers.k<T, U, U> implements Disposable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Callable<U> f494438g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ObservableSource<B> f494439h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Disposable f494440i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public a f494441j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public U f494442k;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            monitor-enter(this);
            U r100 = this.f494442k;     // Catch: Throwable -> L13
            if (r100 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L13
            return;
        L7:
            this.f494442k = null;     // Catch: Throwable -> L13
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
            this.f494441j.dispose();
            this.f494440i.dispose();
            if (d() == false) goto L9;
            this.f492891c.clear();
            return;
        L9:
            return;
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
            U r101 = this.f494442k;     // Catch: Throwable -> L10
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
            if (DisposableHelper.validate(this.f494440i, r100) == false) goto L14;
            this.f494440i = r100;
            this.f494442k = (U) ObjectHelper.requireNonNull(this.f494438g.call(), "The buffer supplied is null");
            a r101 = new a(this);
            this.f494441j = r101;
            this.f492890b.onSubscribe(this);
            if (this.f492892d == true) goto L15;
            this.f494439h.subscribe(r101);
            return;
        L15:
            return;
        L9:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492892d = true;
            r100.dispose();
            EmptyDisposable.error(th, this.f492890b);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.observers.k, io.reactivex.internal.util.h
        public final void b(Observer r100, Object r101) {
            this.f492890b.onNext((Collection) r101);
        }

        public b(io.reactivex.observers.f r100, Callable r101, ObservableSource r102) {
            super(r100, new MpscLinkedQueue());
            this.f494438g = r101;
            this.f494439h = r102;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        this.f494245a.subscribe(new b(new io.reactivex.observers.f(r100), this.f494436c, this.f494435b));
    }

    public l(ObservableSource<T> r100, ObservableSource<B> r101, Callable<U> r102) {
        super(r100);
        this.f494435b = r101;
        this.f494436c = r102;
    }
}
