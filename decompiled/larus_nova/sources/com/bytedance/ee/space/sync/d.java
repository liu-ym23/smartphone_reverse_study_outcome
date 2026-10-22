package com.bytedance.ee.space.sync;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import f75.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends c0c.b implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f243094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f243095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<b> f243096d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Cd(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        return this.f243094b.Cd(r100, r101);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void De(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.De(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Lb(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "routeKey");
        Intrinsics.checkNotNullParameter(r101, "observer");
        return this.f243094b.Lb(r100, r101);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Lc(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.Lc(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean M6(String r100, int r101, i65.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.M6(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void P1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.P1(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean P8(String r100, int r101, f75.c r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.P8(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean S2(String r100, int r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.S2(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Ye(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.Ye(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean d7(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.d7(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean i4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.i4(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void lb(cr5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.lb(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n5(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.n5(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n8(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.n8(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void onDestroy() {
        this.f243094b.onDestroy();
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void q1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.q1(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean r6(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.r6(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean u4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        return this.f243094b.u4(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void w7(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f243094b.w7(r100);
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("SyncPushServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f243096d.c().onDestroy();
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<b> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), b.class), b.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f243094b = r103.b();
        this.f243095c = r101;
        this.f243096d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        tt5.a.h("SyncPushServiceProxy", "preparing");
        v r102 = this.f243095c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        b r104 = (b) k.b(r102.c(r103), b.class);
        this.f243096d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
