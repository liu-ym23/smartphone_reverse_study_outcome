package com.bytedance.ee.bear.tts.service;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;
import mo5.e;
import mo5.f;
import mo5.g;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends c0c.b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f239783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f239784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<e> f239785d;

    public static final class a {
    }

    static {
    }

    @Override // mo5.e
    public final boolean N3(String r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        return this.f239783b.N3(r100);
    }

    @Override // mo5.e
    public final f V6(boolean r100) {
        return this.f239783b.V6(r100);
    }

    @Override // mo5.e
    public final boolean Zb() {
        return this.f239783b.Zb();
    }

    @Override // mo5.e
    public final g b2(String r100, int r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        return this.f239783b.b2(r100, r101, r110, r111, r112);
    }

    @Override // mo5.e
    public final boolean canAutoPlay() {
        return this.f239783b.canAutoPlay();
    }

    @Override // mo5.e
    public final boolean isEnable() {
        return this.f239783b.isEnable();
    }

    @Override // mo5.e
    public final void onDestroy() {
        this.f239783b.onDestroy();
    }

    @Override // mo5.e
    public final boolean z5() {
        return this.f239783b.z5();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("TtsServiceProxy", MapMonitorConst.EVENT_DESTROY);
        this.f239785d.c().onDestroy();
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<e> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), e.class), e.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f239783b = r103.b();
        this.f239784c = r101;
        this.f239785d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        v r102 = this.f239784c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        e r104 = (e) k.b(r102.c(r103), e.class);
        this.f239785d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
