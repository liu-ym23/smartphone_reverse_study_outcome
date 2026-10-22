package com.bytedance.lark.open_app_android;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class k implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f253434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f253435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f253436c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f253435b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f253436c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public k(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f253434a = r100;
        this.f253435b = new AtomicBoolean(false);
        this.f253436c = new AtomicLong(1);
    }
}
