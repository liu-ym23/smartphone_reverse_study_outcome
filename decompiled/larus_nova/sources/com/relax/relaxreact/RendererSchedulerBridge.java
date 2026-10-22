package com.relax.relaxreact;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class RendererSchedulerBridge implements com.relax.relaxreact.shared.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.rts.kmp.foundation.p<mpa.l> f405429a;

    public final mpa.l g() {
        com.bytedance.rts.kmp.foundation.p<mpa.l> r100 = this.f405429a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("renderer");
        r100 = null;
    L5:
        mpa.l r101 = (mpa.l) com.bytedance.rts.kmp.foundation.q.a(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101;
    }

    public RendererSchedulerBridge(mpa.l r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f405429a = new com.bytedance.rts.kmp.foundation.p(r100);
    }

    @Override // com.relax.relaxreact.shared.c
    public final long a(final Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        mpa.l r101 = g();
        if (r101 != null) goto L6;
        return 0;
    L6:
        Function1<Object, Unit> r102 = new RendererSchedulerBridge$setTimeout$1(r100);
        int r103 = com.bytedance.rts.kmp.foundation.c.f267609a;
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = mpa.e.f514751a;
        mpa.k r105 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r105, "renderer");
        Intrinsics.checkNotNullParameter(r102, "callback");
        return r105.a().M(mpa.j.a(r102), 0);
    }

    @Override // com.relax.relaxreact.shared.c
    public final void b(long r100) {
        mpa.l r101 = g();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = mpa.e.f514751a;
        mpa.k r103 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        r103.a().b(r100);
    }

    @Override // com.relax.relaxreact.shared.c
    public final void c(long r100) {
        mpa.l r101 = g();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = mpa.e.f514751a;
        mpa.k r103 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        r103.a().d(r100);
    }

    @Override // com.relax.relaxreact.shared.c
    public final long d(final Function1<? super Long, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        mpa.l r101 = g();
        if (r101 != null) goto L6;
        return 0;
    L6:
        Function1<Object, Unit> r102 = new RendererSchedulerBridge$requestAnimationFrame$1(r100);
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r102, "callback");
        return r104.a().H(mpa.j.a(r102));
    }

    @Override // com.relax.relaxreact.shared.c
    public final void e(long r100) {
        mpa.l r101 = g();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = mpa.e.f514751a;
        mpa.k r103 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r103, "renderer");
        r103.a().c(r100);
    }

    @Override // com.relax.relaxreact.shared.c
    public final long f(final Function1<? super Long, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        mpa.l r101 = g();
        if (r101 != null) goto L6;
        return 0;
    L6:
        Function1<Object, Unit> r102 = new RendererSchedulerBridge$requestFrameCommitCallback$1(r100);
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = mpa.e.f514751a;
        mpa.k r104 = r101.f514759a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r102, "callback");
        return r104.a().I(mpa.j.a(r102));
    }
}
