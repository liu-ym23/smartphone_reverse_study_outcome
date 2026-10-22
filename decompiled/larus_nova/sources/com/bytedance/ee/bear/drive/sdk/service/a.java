package com.bytedance.ee.bear.drive.sdk.service;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends c0c.b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f224596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f224597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<f> f224598d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.sdk.service.a$a, reason: collision with other inner class name */
    public static final class C3223a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final g d0() {
        return this.f224596b.d0();
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final void onDestroy() {
        this.f224596b.onDestroy();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("DriveSdkServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f224598d.c().onDestroy();
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<f> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), f.class), f.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f224596b = r103.b();
        this.f224597c = r101;
        this.f224598d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        tt5.a.h("DriveSdkServiceProxy", "preparing");
        v r102 = this.f224597c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        f r104 = (f) k.b(r102.c(r103), f.class);
        this.f224598d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
