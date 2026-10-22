package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes41.dex */
public abstract class h<T, U, V> extends l implements io.reactivex.g<T>, io.reactivex.internal.util.i<U, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wwc.b<? super V> f495029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vtc.i<U> f495030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f495031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f495032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f495033g;

    public boolean b(wwc.b<? super V> r100, U r101) {
        return false;
    }

    public final boolean d() {
        if (this.f495035a.getAndIncrement() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.f495035a.get() == 0) goto L5;
        return false;
    L5:
        if (this.f495035a.compareAndSet(0, 1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final long u() {
        return this.f495034b.get();
    }

    public final int n(int r100) {
        return this.f495035a.addAndGet(r100);
    }

    public final long q(long r100) {
        return this.f495034b.addAndGet(-1);
    }

    public final void z(long r100) {
        if (SubscriptionHelper.validate(r100) == false) goto L6;
        io.reactivex.internal.util.b.a(this.f495034b, r100);
        return;
    }

    public h(io.reactivex.subscribers.d r100, MpscLinkedQueue r101) {
        this.f495029c = r100;
        this.f495030d = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(Object r100, Disposable r101) {
        wwc.b<? super V> r102 = this.f495029c;
        vtc.i<U> r103 = this.f495030d;
        if (e() == false) goto L16;
        long r104 = this.f495034b.get();
        if (r104 != 0) goto L7;
        r101.dispose();
        r102.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
        return;
    L7:
        if (b(r102, r100) == false) goto L12;
        if (r104 == Long.MAX_VALUE) goto L12;
        q(1);
    L12:
        if (n(-1) != 0) goto L19;
        return;
    L19:
        io.reactivex.internal.util.j.c(r103, r102, r101, this);
        return;
    L16:
        r103.offer(r100);
        if (d() == true) goto L19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(Object r100, Disposable r101) {
        wwc.b<? super V> r102 = this.f495029c;
        vtc.i<U> r103 = this.f495030d;
        if (e() == false) goto L19;
        long r104 = this.f495034b.get();
        if (r104 != 0) goto L7;
        this.f495031e = true;
        r101.dispose();
        r102.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
        return;
    L7:
        if (r103.isEmpty() == true) goto L9;
        r103.offer(r100);
    L22:
        io.reactivex.internal.util.j.c(r103, r102, r101, this);
        return;
    L9:
        if (b(r102, r100) == false) goto L14;
        if (r104 == Long.MAX_VALUE) goto L14;
        q(1);
    L14:
        if (n(-1) != 0) goto L22;
        return;
    L19:
        r103.offer(r100);
        if (d() == true) goto L22;
    }
}
