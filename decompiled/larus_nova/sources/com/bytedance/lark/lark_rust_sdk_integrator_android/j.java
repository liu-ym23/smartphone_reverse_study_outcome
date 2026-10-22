package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class j implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f253254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f253255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f253256c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f253255b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f253256c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public j(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f253254a = r100;
        this.f253255b = new AtomicBoolean(false);
        this.f253256c = new AtomicLong(1);
    }
}
