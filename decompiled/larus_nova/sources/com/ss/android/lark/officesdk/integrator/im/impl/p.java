package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.security.compliance.api.ISecurityComplianceApi;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class p implements pmb.j {
    @Inject
    public p() {
    }

    @Override // pmb.j
    public final boolean getSwitchStatusFromAdmin() {
        return ((ISecurityComplianceApi) e0c.k.a(LarkContext.getApplication(), ISecurityComplianceApi.class)).getSwitchStatusFromAdmin();
    }
}
