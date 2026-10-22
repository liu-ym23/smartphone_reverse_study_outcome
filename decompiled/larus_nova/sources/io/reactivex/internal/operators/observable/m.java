package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class m<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f494465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f494466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scheduler f494467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable<U> f494468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f494469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f494470h;

    public static final class a<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.k<T, U, U> implements Runnable, Disposable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Callable<U> f494471g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f494472h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TimeUnit f494473i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f494474j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f494475k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Scheduler.Worker f494476l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public U f494477m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Disposable f494478n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Disposable f494479o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f494480p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f494481q;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f492892d == true) goto L13;
            this.f492892d = true;
            this.f494479o.dispose();
            this.f494476l.dispose();
            monitor-enter(this);
            this.f494477m = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494476l.dispose();
            monitor-enter(this);
            U r100 = this.f494477m;     // Catch: Throwable -> L10
            this.f494477m = null;     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            this.f492891c.offer(r100);
            this.f492893e = true;
            if (d() == false) goto L15;
            io.reactivex.internal.util.j.b(this.f492891c, this.f492890b, this, this);
            return;
        L15:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final void q() {
            U r100 = (U) ObjectHelper.requireNonNull(this.f494471g.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L18
            monitor-enter(this);
            U r101 = this.f494477m;     // Catch: Throwable -> L15
            if (r101 != null) goto L7;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L7:
            if (this.f494480p != this.f494481q) goto L13;
            this.f494477m = r100;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            m(r101, this);
            return;
        L15:
            th = move-exception;
            throw th;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.f492890b.onError(th);
        }

        @Override // java.lang.Runnable
        public final void run() {
            q();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492892d;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            monitor-enter(this);
            this.f494477m = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.f492890b.onError(r100);
            this.f494476l.dispose();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            monitor-enter(this);
            U r101 = this.f494477m;     // Catch: Throwable -> L31
            if (r101 != null) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L7:
            r101.add(r100);     // Catch: Throwable -> L31
            if (r101.size() >= this.f494474j) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L31
            return;
        L11:
            this.f494477m = null;     // Catch: Throwable -> L31
            this.f494480p++;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
            if (this.f494475k == false) goto L16;
            this.f494478n.dispose();
        L16:
            m(r101, this);
            U r102 = (U) ObjectHelper.requireNonNull(this.f494471g.call(), "The buffer supplied is null");     // Catch: Throwable -> L28
            monitor-enter(this);
            this.f494477m = r102;     // Catch: Throwable -> L25
            this.f494481q++;     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
            if (this.f494475k == false) goto L39;
            Scheduler.Worker r103 = this.f494476l;
            long r104 = this.f494472h;
            this.f494478n = r103.schedulePeriodically(this, r104, r104, this.f494473i);
            return;
        L39:
            return;
        L25:
            th = move-exception;
            throw th;
        L28:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492890b.onError(th);
            dispose();
            return;
        L31:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494479o, r100) == false) goto L12;
            this.f494479o = r100;
            this.f494477m = (U) ObjectHelper.requireNonNull(this.f494471g.call(), "The buffer supplied is null");
            this.f492890b.onSubscribe(this);
            Scheduler.Worker r101 = this.f494476l;
            long r102 = this.f494472h;
            this.f494478n = r101.schedulePeriodically(this, r102, r102, this.f494473i);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100.dispose();
            EmptyDisposable.error(th, this.f492890b);
            this.f494476l.dispose();
            return;
        }

        @Override // io.reactivex.internal.observers.k, io.reactivex.internal.util.h
        public final void b(Observer r100, Object r101) {
            r100.onNext((Collection) r101);
        }

        public a(io.reactivex.observers.f r100, Callable r101, long r102, TimeUnit r103, int r104, boolean r105, Scheduler.Worker r106) {
            super(r100, new MpscLinkedQueue());
            this.f494471g = r101;
            this.f494472h = r102;
            this.f494473i = r103;
            this.f494474j = r104;
            this.f494475k = r105;
            this.f494476l = r106;
        }
    }

    public static final class b<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.k<T, U, U> implements Runnable, Disposable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Callable<U> f494482g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f494483h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TimeUnit f494484i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Scheduler f494485j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Disposable f494486k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public U f494487l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final AtomicReference<Disposable> f494488m;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            monitor-enter(this);
            U r100 = this.f494487l;     // Catch: Throwable -> L11
            this.f494487l = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            if (r100 == null) goto L9;
            this.f492891c.offer(r100);
            this.f492893e = true;
            if (d() == false) goto L9;
            io.reactivex.internal.util.j.b(this.f492891c, this.f492890b, null, this);
        L9:
            DisposableHelper.dispose(this.f494488m);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.f494488m);
            this.f494486k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.f494488m.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        public final void q() {
            U r100 = (U) ObjectHelper.requireNonNull(this.f494482g.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L16
            monitor-enter(this);
            U r101 = this.f494487l;     // Catch: Throwable -> L13
            if (r101 == null) goto L7;
            this.f494487l = r100;     // Catch: Throwable -> L13
        L7:
            monitor-exit(this);     // Catch: Throwable -> L13
            if (r101 != null) goto L11;
            DisposableHelper.dispose(this.f494488m);
            return;
        L11:
            l(r101, this);
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492890b.onError(th);
            dispose();
        }

        @Override // java.lang.Runnable
        public final void run() {
            q();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            monitor-enter(this);
            this.f494487l = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.f492890b.onError(r100);
            DisposableHelper.dispose(this.f494488m);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            monitor-enter(this);
            U r101 = this.f494487l;     // Catch: Throwable -> L10
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
            if (DisposableHelper.validate(this.f494486k, r100) == false) goto L25;
            this.f494486k = r100;
            this.f494487l = (U) ObjectHelper.requireNonNull(this.f494482g.call(), "The buffer supplied is null");
            this.f492890b.onSubscribe(this);
            if (this.f492892d == true) goto L26;
            Scheduler r101 = this.f494485j;
            long r102 = this.f494483h;
            Disposable r103 = r101.schedulePeriodicallyDirect(this, r102, r102, this.f494484i);
            AtomicReference<Disposable> r104 = this.f494488m;
        L10:
            if (r104.compareAndSet(null, r103) == true) goto L11;
            if (r104.get() == null) goto L10;
            boolean r105 = false;
        L15:
            if (r105 == true) goto L27;
            r103.dispose();
            return;
        L27:
            return;
        L11:
            r105 = true;
            goto L15
        L26:
            return;
        L17:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            EmptyDisposable.error(th, this.f492890b);
            return;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.internal.observers.k, io.reactivex.internal.util.h
        public final void b(Observer r100, Object r101) {
            this.f492890b.onNext((Collection) r101);
        }

        public b(io.reactivex.observers.f r100, Callable r101, long r102, TimeUnit r103, Scheduler r104) {
            super(r100, new MpscLinkedQueue());
            this.f494488m = new AtomicReference();
            this.f494482g = r101;
            this.f494483h = r102;
            this.f494484i = r103;
            this.f494485j = r104;
        }
    }

    public static final class c<T, U extends Collection<? super T>> extends io.reactivex.internal.observers.k<T, U, U> implements Runnable, Disposable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Callable<U> f494489g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f494490h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f494491i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final TimeUnit f494492j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Scheduler.Worker f494493k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final List<U> f494494l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Disposable f494495m;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final U f494496a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f494497b;

            @Override // java.lang.Runnable
            public final void run() {
                c r100 = this.f494497b;     // Catch: Throwable -> L11
                monitor-enter(r100);     // Catch: Throwable -> L11
                List<U> r101 = this.f494497b.f494494l;     // Catch: Throwable -> L8
                LinkedList r102 = (LinkedList) r101;     // Catch: Throwable -> L8
                r102.remove(this.f494496a);     // Catch: Throwable -> L8
                monitor-exit(r100);     // Catch: Throwable -> L8
                c r103 = this.f494497b;     // Catch: Throwable -> L11
                r103.m(this.f494496a, r103.f494493k);     // Catch: Throwable -> L11
                return;
            L8:
                th = move-exception;
                throw th;     // Catch: Throwable -> L11
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L15;
                return;
            L15:
                throw th;
            }

            public a(c r100, U r101) {
                this.f494497b = r100;
                this.f494496a = r101;
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final U f494498a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f494499b;

            @Override // java.lang.Runnable
            public final void run() {
                c r100 = this.f494499b;     // Catch: Throwable -> L11
                monitor-enter(r100);     // Catch: Throwable -> L11
                List<U> r101 = this.f494499b.f494494l;     // Catch: Throwable -> L8
                LinkedList r102 = (LinkedList) r101;     // Catch: Throwable -> L8
                r102.remove(this.f494498a);     // Catch: Throwable -> L8
                monitor-exit(r100);     // Catch: Throwable -> L8
                c r103 = this.f494499b;     // Catch: Throwable -> L11
                r103.m(this.f494498a, r103.f494493k);     // Catch: Throwable -> L11
                return;
            L8:
                th = move-exception;
                throw th;     // Catch: Throwable -> L11
            L11:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L15;
                return;
            L15:
                throw th;
            }

            public b(c r100, U r101) {
                this.f494499b = r100;
                this.f494498a = r101;
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public final void onComplete() {
            monitor-enter(this);
            ArrayList r100 = new ArrayList(this.f494494l);     // Catch: Throwable -> L13
            ((LinkedList) this.f494494l).clear();     // Catch: Throwable -> L13
            monitor-exit(this);     // Catch: Throwable -> L13
            Iterator r101 = r100.iterator();
        L7:
            if (r101.hasNext() == false) goto L9;
            Collection r102 = (Collection) r101.next();
            this.f492891c.offer((U) r102);
            goto L7
        L9:
            this.f492893e = true;
            if (d() == false) goto L19;
            io.reactivex.internal.util.j.b(this.f492891c, this.f492890b, this.f494493k, this);
            return;
        L19:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f492892d == true) goto L12;
            this.f492892d = true;
            monitor-enter(this);
            ((LinkedList) this.f494494l).clear();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            this.f494495m.dispose();
            this.f494493k.dispose();
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public final void q() {
            if (this.f492892d == false) goto L22;
            return;
        L22:
            Collection r100 = (Collection) ObjectHelper.requireNonNull(this.f494489g.call(), "The bufferSupplier returned a null buffer");     // Catch: Throwable -> L18
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L8:
            if (this.f492892d == false) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L15
            return;
        L11:
            ((LinkedList) this.f494494l).add(r100);     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            this.f494493k.schedule(new a(this, r100), this.f494490h, this.f494492j);
            return;
        L18:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492890b.onError(th);
            dispose();
        }

        @Override // java.lang.Runnable
        public final void run() {
            q();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492892d;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f492893e = true;
            monitor-enter(this);
            ((LinkedList) this.f494494l).clear();     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.f492890b.onError(r100);
            this.f494493k.dispose();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            monitor-enter(this);
            Iterator<U> r101 = this.f494494l.iterator();     // Catch: Throwable -> L9
        L5:
            if (r101.hasNext() == false) goto L7;
            r101.next().add(r100);     // Catch: Throwable -> L9
            goto L5
        L7:
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494495m, r100) == false) goto L12;
            this.f494495m = r100;
            Collection r101 = (Collection) ObjectHelper.requireNonNull(this.f494489g.call(), "The buffer supplied is null");     // Catch: Throwable -> L7
            ((LinkedList) this.f494494l).add(r101);
            this.f492890b.onSubscribe(this);
            Scheduler.Worker r102 = this.f494493k;
            long r103 = this.f494491i;
            r102.schedulePeriodically(this, r103, r103, this.f494492j);
            this.f494493k.schedule(new b(this, r101), this.f494490h, this.f494492j);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100.dispose();
            EmptyDisposable.error(th, this.f492890b);
            this.f494493k.dispose();
            return;
        }

        @Override // io.reactivex.internal.observers.k, io.reactivex.internal.util.h
        public final void b(Observer r100, Object r101) {
            r100.onNext((Collection) r101);
        }

        public c(io.reactivex.observers.f r100, Callable r101, long r102, long r103, TimeUnit r104, Scheduler.Worker r105) {
            super(r100, new MpscLinkedQueue());
            this.f494489g = r101;
            this.f494490h = r102;
            this.f494491i = r103;
            this.f494492j = r104;
            this.f494493k = r105;
            this.f494494l = new LinkedList();
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r110) {
        long r100 = this.f494464b;
        if (r100 == this.f494465c) goto L5;
    L8:
        Scheduler.Worker r101 = this.f494467e.createWorker();
        long r102 = this.f494464b;
        long r103 = this.f494465c;
        if (r102 != r103) goto L12;
        this.f494245a.subscribe(new a(new io.reactivex.observers.f(r110), this.f494468f, r102, this.f494466d, this.f494469g, this.f494470h, r101));
        return;
    L12:
        this.f494245a.subscribe(new c(new io.reactivex.observers.f(r110), this.f494468f, r102, r103, this.f494466d, r101));
        return;
    L5:
        if (this.f494469g != Integer.MAX_VALUE) goto L8;
        this.f494245a.subscribe(new b(new io.reactivex.observers.f(r110), this.f494468f, r100, this.f494466d, this.f494467e));
    }

    public m(ObservableSource<T> r100, long r101, long r102, TimeUnit r103, Scheduler r104, Callable<U> r105, int r106, boolean r110) {
        super(r100);
        this.f494464b = r101;
        this.f494465c = r102;
        this.f494466d = r103;
        this.f494467e = r104;
        this.f494468f = r105;
        this.f494469g = r106;
        this.f494470h = r110;
    }
}
