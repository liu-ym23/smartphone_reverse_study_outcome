package com.larus.login.impl.multiaccount;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r0 implements n38.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f358151a;

    public r0(o0 r100) {
        this.f358151a = r100;
    }

    @Override // n38.j
    public final void a(n38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        final o0 r101 = this.f358151a;
        r101.f358137c.post(new q0(r101));
    }

    @Override // n38.j
    public final void b(n38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        final o0 r101 = this.f358151a;
        r101.f358137c.post(new p0(r101));
    }
}
