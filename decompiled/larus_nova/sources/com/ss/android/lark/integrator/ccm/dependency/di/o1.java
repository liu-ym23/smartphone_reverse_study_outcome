package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class o1 extends c0c.b implements com.bytedance.ee.bear.lark.dependency.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.c0 f427859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f427860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.c0> f427861d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void D1(Fragment r100, UserSession r110, String r111, String r112, String r113, String r114, com.bytedance.ee.bear.lark.dependency.c0.a r115) {
        this.f427859b.D1(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void Wb(FragmentActivity r110, FragmentManager r111, UserSession r112, String r113, String r114, String r115, String r116, com.bytedance.ee.bear.lark.dependency.c0.a r117) {
        this.f427859b.Wb(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void eb(Context r100, String r101, String r102, boolean r103) {
        this.f427859b.eb(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final Pair<Fragment, r1c.a> j4(UserSession r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "p1");
        return this.f427859b.j4(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.c0
    public final void onDestroy() {
        this.f427859b.onDestroy();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("ProfileDependencyProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f427861d.c().onDestroy();
    }

    public o1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.c0> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), com.bytedance.ee.bear.lark.dependency.c0.class), com.bytedance.ee.bear.lark.dependency.c0.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f427859b = r103.b();
        this.f427860c = r101;
        this.f427861d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        tt5.a.h("ProfileDependencyProxy", "preparing");
        com.ss.android.lark.passportc.internal.v r102 = this.f427860c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.bytedance.ee.bear.lark.dependency.c0 r104 = (com.bytedance.ee.bear.lark.dependency.c0) e0c.k.b(r102.c(r103), com.bytedance.ee.bear.lark.dependency.c0.class);
        this.f427861d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
