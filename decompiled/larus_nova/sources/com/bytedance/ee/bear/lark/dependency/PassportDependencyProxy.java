package com.bytedance.ee.bear.lark.dependency;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class PassportDependencyProxy extends c0c.b implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f227345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f227346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a0> f227347d;

    @Override // com.bytedance.ee.bear.lark.dependency.a0
    public final void k8(a0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f227347d.d(new com.ss.android.lark.passportc.convention.b.C5239b(a0.b.class, r100));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.a0
    public final void wd(final a0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f227347d.a(new com.ss.android.lark.passportc.convention.b.C5239b(a0.b.class, r100), new com.ss.android.lark.passportc.convention.b.c(new PassportDependencyProxy$registerSessionRotatedListener$1(r100), new PassportDependencyProxy$registerSessionRotatedListener$2(r100)));
    }

    public PassportDependencyProxy(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a0> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), a0.class), a0.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f227345b = r103.b();
        this.f227346c = r101;
        this.f227347d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        com.ss.android.lark.passportc.internal.v r102 = this.f227346c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a0 r104 = (a0) e0c.k.b(r102.c(r103), a0.class);
        this.f227347d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
