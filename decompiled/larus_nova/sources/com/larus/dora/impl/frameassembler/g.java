package com.larus.dora.impl.frameassembler;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f335837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f335838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f335839c;

    public final void b() {
        this.f335838b.decrementAndGet();
    }

    public g(e r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f335837a = r100;
        this.f335838b = new AtomicInteger();
        this.f335839c = new AtomicLong();
    }

    public final void a(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        this.f335839c.addAndGet(-r100);
    }

    public final boolean c(long r100) {
        if (r100 > 0) goto L5;
        return true;
    L5:
        long r101 = this.f335839c.get();
        long r102 = r101 + r100;
        if (r102 > this.f335837a.f335811d) goto L7;
        if (this.f335839c.compareAndSet(r101, r102) == false) goto L5;
        return true;
    L7:
        return false;
    }
}
