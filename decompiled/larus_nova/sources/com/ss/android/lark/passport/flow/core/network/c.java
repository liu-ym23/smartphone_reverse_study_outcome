package com.ss.android.lark.passport.flow.core.network;

import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements gpb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gpb.a f437753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f437754b;

    @Override // gpb.a
    public final String getGeo() {
        if (this.f437754b != 2) goto L6;
        return EnvConst$GEO.BOE_CN;
    L6:
        return this.f437753a.getGeo();
    }

    @Override // gpb.a
    public final String getTenantBrand() {
        return this.f437753a.getTenantBrand();
    }

    @Override // gpb.a
    public final String getUserUnit() {
        if (this.f437754b != 2) goto L6;
        return EnvConst$UNIT.BOE_CN;
    L6:
        return this.f437753a.getUserUnit();
    }

    @Override // gpb.a
    public final boolean isBoe() {
        if (this.f437754b != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gpb.a
    public final boolean isChinaMainlandGeo() {
        if (this.f437754b != 2) goto L6;
        return true;
    L6:
        return this.f437753a.isChinaMainlandGeo();
    }

    @Override // gpb.a
    public final boolean isFeishuBrand() {
        return this.f437753a.isFeishuBrand();
    }

    @Override // gpb.a
    @Deprecated(message = "use isFeishuBrand and envType")
    public final int oldSdkEnv() {
        return gpb.a.C6054a.a(this);
    }

    @Override // gpb.a
    public final int envType() {
        return this.f437754b;
    }

    @Override // gpb.a
    public final String getPolicyUrl(PolicyAgreement r100) {
        Intrinsics.checkNotNullParameter(r100, "policyAgreement");
        return this.f437753a.getPolicyUrl(r100);
    }

    @Override // gpb.a
    public final void registerEnvChangeListener(ipb.a r100) {
        this.f437753a.registerEnvChangeListener(r100);
    }

    public c(gpb.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f437753a = r100;
        this.f437754b = r101;
    }
}
