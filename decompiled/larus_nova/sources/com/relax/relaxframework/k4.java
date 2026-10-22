package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k4 extends com.relax.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RelaxPage f405169a;

    @Override // com.relax.v
    public final void a() {
        RelaxPage r100 = this.f405169a;
        String r101 = r100.f404908h;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r100.c(r101, this.f405169a.f404909i);
        return;
    }

    public k4(RelaxPage r100) {
        this.f405169a = r100;
    }
}
