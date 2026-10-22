package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.MpscLinkedQueue;

/* JADX INFO: loaded from: classes41.dex */
public abstract class k<T, U, V> extends m implements Observer<T>, io.reactivex.internal.util.h<U, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Observer<? super V> f492890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vtc.i<U> f492891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f492892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f492893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f492894f;

    @Override // io.reactivex.internal.util.h
    public void b(Observer<? super V> r100, U r101) {
    }

    public final boolean d() {
        if (this.f492895a.getAndIncrement() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.f492895a.get() == 0) goto L5;
        return false;
    L5:
        if (this.f492895a.compareAndSet(0, 1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final int n(int r100) {
        return this.f492895a.addAndGet(r100);
    }

    public k(io.reactivex.observers.f r100, MpscLinkedQueue r101) {
        this.f492890b = r100;
        this.f492891c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(Object r100, Disposable r101) {
        Observer<? super V> r102 = this.f492890b;
        vtc.i<U> r103 = this.f492891c;
        if (this.f492895a.get() == 0) goto L5;
    L9:
        r103.offer(r100);
        if (d() == true) goto L12;
        return;
    L12:
        io.reactivex.internal.util.j.b(r103, r102, r101, this);
        return;
    L5:
        if (this.f492895a.compareAndSet(0, 1) == false) goto L9;
        b(r102, r100);
        if (n(-1) != 0) goto L12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(Object r100, Disposable r101) {
        Observer<? super V> r102 = this.f492890b;
        vtc.i<U> r103 = this.f492891c;
        if (this.f492895a.get() == 0) goto L5;
    L12:
        r103.offer(r100);
        if (d() == true) goto L15;
        return;
    L15:
        io.reactivex.internal.util.j.b(r103, r102, r101, this);
        return;
    L5:
        if (this.f492895a.compareAndSet(0, 1) == false) goto L12;
        if (r103.isEmpty() == false) goto L11;
        b(r102, r100);
        if (n(-1) != 0) goto L15;
        return;
    L11:
        r103.offer(r100);
        goto L15
    }
}
