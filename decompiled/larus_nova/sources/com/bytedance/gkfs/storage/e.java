package com.bytedance.gkfs.storage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f245326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile CountDownLatch f245327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245328c;

    public final void b() {
        if (this.f245326a.decrementAndGet() >= 0) goto L6;
        this.f245326a.set(0);
        return;
    }

    public final void c() {
    L3:
        if (this.f245326a.get() <= 0) goto L6;
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
        goto L3
    L6:
        if (this.f245327b != null) goto L8;
        this.f245327b = new CountDownLatch(1);
        return;
    L8:
        com.bytedance.gkfs.c.c(com.bytedance.gkfs.c.f245127c, "rwLock", "rwLock already exists when writeLock", null, false, 28);
    }

    public final void d() {
        CountDownLatch r100 = this.f245327b;
        this.f245327b = null;
        if (r100 == null) goto L6;
        r100.countDown();
        return;
    }

    public final String a() {
        return this.f245328c;
    }

    public e(String r100) {
        this.f245328c = r100;
        this.f245326a = new AtomicInteger(0);
    }
}
