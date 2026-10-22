package com.bytedance.ee.bear.account.container.dwarf;

import c0c.b;
import com.bytedance.ee.bear.contract.a0;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class UserAccountInfoServiceProxy extends b implements a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f206188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f206189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a0> f206190d;

    @Override // com.bytedance.ee.bear.contract.a0
    public final m Ad() {
        return this.f206188b.Ad();
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final DocDynamicConfig docDynamicConfig() {
        return this.f206188b.docDynamicConfig();
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final void E1(final a0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f206190d.a(new com.ss.android.lark.passportc.convention.b.C5239b(a0.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new UserAccountInfoServiceProxy$addDocDynamicConfigListener$1(r100), new UserAccountInfoServiceProxy$addDocDynamicConfigListener$2(r100)));
    }

    @Override // com.bytedance.ee.bear.contract.a0
    public final void Vb(a0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f206190d.d(new com.ss.android.lark.passportc.convention.b.C5239b(a0.a.class, r100));
    }

    public UserAccountInfoServiceProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a0> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), a0.class), a0.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f206188b = r103.b();
        this.f206189c = r101;
        this.f206190d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f206189c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a0 r104 = (a0) k.b(r102.c(r103), a0.class);
        this.f206190d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
