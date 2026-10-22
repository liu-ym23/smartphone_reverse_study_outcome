package com.bytedance.lark.base.open.pkm;

import com.sun.jna.Pointer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class k implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f7235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f7237c;

    public abstract void a();

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f7236b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f7237c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public k(Pointer r3) {
        Intrinsics.checkNotNullParameter(r3, "pointer");
        this.f7235a = r3;
        this.f7236b = new AtomicBoolean(false);
        this.f7237c = new AtomicLong(1);
    }
}
