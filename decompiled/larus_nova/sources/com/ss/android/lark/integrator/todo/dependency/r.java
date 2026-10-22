package com.ss.android.lark.integrator.todo.dependency;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class r implements g7c.m {
    public r() {
    }

    @Override // g7c.m
    public final void getTenantId() {
    }

    @Override // g7c.m
    public final boolean a() {
        return !((gpb.a) ApiUtils.getApi(gpb.a.class)).isChinaMainlandGeo();
    }

    @Override // g7c.m
    public final String getUserId() {
        String r100 = OfficeSDKManager.getCurrentUid();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }
}
