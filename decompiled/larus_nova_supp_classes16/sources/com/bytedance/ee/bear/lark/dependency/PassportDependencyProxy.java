package com.bytedance.ee.bear.lark.dependency;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PassportDependencyProxy extends c0c.b implements a0 {
    public final /* synthetic */ a0 b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<a0> d;

    @Override // com.bytedance.ee.bear.lark.dependency.a0
    public final void k8(a0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.d.d(new com.ss.android.lark.passportc.convention.b.b(a0.b.class, r4));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.a0
    public final void wd(final a0.b r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.d.a(new com.ss.android.lark.passportc.convention.b.b(a0.b.class, r6), new com.ss.android.lark.passportc.convention.b.c(new PassportDependencyProxy$registerSessionRotatedListener$1(r6), new PassportDependencyProxy$registerSessionRotatedListener$2(r6)));
    }

    public PassportDependencyProxy(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a0> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), a0.class), a0.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (a0) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r1, f0c.g r2) {
        com.ss.android.lark.passportc.internal.v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        a0 r5 = (a0) e0c.k.b(r3.c(r4), a0.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
