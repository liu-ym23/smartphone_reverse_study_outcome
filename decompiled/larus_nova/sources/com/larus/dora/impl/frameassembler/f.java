package com.larus.dora.impl.frameassembler;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f335832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f335833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f335834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f335835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f335836e;

    public final void a() {
        this.f335833b.incrementAndGet();
    }

    public final void b() {
        this.f335835d.incrementAndGet();
    }

    public f() {
        this.f335832a = new AtomicLong();
        this.f335833b = new AtomicLong();
        this.f335834c = new AtomicLong();
        this.f335835d = new AtomicLong();
        this.f335836e = new AtomicLong();
    }
}
