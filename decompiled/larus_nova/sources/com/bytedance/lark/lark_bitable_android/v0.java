package com.bytedance.lark.lark_bitable_android;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class v0 implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f253119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f253120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f253121c;

    public abstract void b();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (this.f253120b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.f253121c.decrementAndGet() != 0) goto L9;
        b();
        return;
    }

    public v0(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f253119a = r100;
        this.f253120b = new AtomicBoolean(false);
        this.f253121c = new AtomicLong(1);
    }
}
