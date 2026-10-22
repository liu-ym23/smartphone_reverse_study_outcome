package com.bytedance.pia.core.utils;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes21.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<l47.a<T>> f266385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f266386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f266387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f266388d;

    public final void b() {
        if (this.f266385a.get() != null) goto L6;
        return;
    L6:
        if (this.f266387c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (this.f266386b.isEmpty() == true) goto L12;
        T r100 = this.f266386b.poll();
        if (r100 == null) goto L8;
        this.f266385a.get().accept(r100);
        goto L8
    L12:
        this.f266387c.set(false);
    }

    public a() {
        this.f266385a = new AtomicReference();
        this.f266386b = new ConcurrentLinkedQueue();
        this.f266387c = new AtomicBoolean(false);
        this.f266388d = false;
    }

    public final void a(T r100) {
        if (this.f266388d == false) goto L5;
        return;
    L5:
        this.f266386b.offer(r100);
        b();
    }

    public final void c(l47.a<T> r100) {
        if (this.f266388d == false) goto L5;
        return;
    L5:
        AtomicReference<l47.a<T>> r101 = this.f266385a;
    L7:
        if (r101.compareAndSet(null, r100) == true) goto L11;
        if (r101.get() == null) goto L7;
    L11:
        b();
    }
}
