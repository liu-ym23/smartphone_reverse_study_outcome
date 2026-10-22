package com.bytedance.lark.molten_livequery;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes19.dex */
public abstract class k implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f253348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f253349c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f253348b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.f253349c.decrementAndGet() != 0) goto L9;
        a();
        return;
    }

    public k(long r100) {
        this.f253347a = r100;
        this.f253348b = new AtomicBoolean(false);
        this.f253349c = new AtomicLong(1);
    }
}
