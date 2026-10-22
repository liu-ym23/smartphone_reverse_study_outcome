package com.larus.login.impl.agegate;

import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: classes30.dex */
public final class g0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseNeutralAgeGateFragment f357337a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        AgeGateManagerService.f286218a.c(false);
        this.f357337a.S90();
    }

    public g0(BaseNeutralAgeGateFragment r100) {
        this.f357337a = r100;
    }
}
