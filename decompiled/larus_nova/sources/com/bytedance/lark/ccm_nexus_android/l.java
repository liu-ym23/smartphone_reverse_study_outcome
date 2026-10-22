package com.bytedance.lark.ccm_nexus_android;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
public abstract class l implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f252923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f252924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f252925c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f252924b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f252925c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public l(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f252923a = r100;
        this.f252924b = new AtomicBoolean(false);
        this.f252925c = new AtomicLong(1);
    }
}
