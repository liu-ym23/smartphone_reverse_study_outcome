package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends c0c.b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f425371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f425372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<f> f425373d;

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<f> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), f.class), f.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f425371b = r103.b();
        this.f425372c = r101;
        this.f425373d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        if (r101 == null) goto L5;
        UserSession r102 = r101.f475034b;
        if (r102 == null) goto L5;
    L6:
        f r103 = (f) k.b(this.f425372c.c(r102), f.class);
        this.f425373d.e(r103);
        return;
    L5:
        r102 = ContainerConstsKt.a();
        goto L6
    }
}
