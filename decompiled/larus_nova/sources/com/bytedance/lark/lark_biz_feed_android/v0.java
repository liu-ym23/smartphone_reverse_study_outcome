package com.bytedance.lark.lark_biz_feed_android;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes8.dex */
public abstract class v0 implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f253204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f253205c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f253204b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f253205c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public v0(long r100) {
        this.f253203a = r100;
        this.f253204b = new AtomicBoolean(false);
        this.f253205c = new AtomicLong(1);
    }
}
