package com.lynx.tasm.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes32.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f384095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f384096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Throwable> f384097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f384098d;

    public final void a() {
        if (this.f384096b.compareAndSet(0, 1) == true) goto L13;
        return;
    L13:
        this.f384095a.run();     // Catch: Throwable -> L6
        this.f384096b.set(3);     // Catch: Throwable -> L6
        this.f384098d.countDown();
        return;
    L6:
        th = move-exception;
        this.f384096b.set(2);     // Catch: Throwable -> L9
        this.f384097c.set(th);     // Catch: Throwable -> L9
        throw new RuntimeException(th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f384098d.countDown();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(i8a.k r100) {
        this.f384096b = new AtomicInteger(0);
        this.f384097c = new AtomicReference(null);
        this.f384098d = new CountDownLatch(1);
        this.f384095a = r100;
    }
}
