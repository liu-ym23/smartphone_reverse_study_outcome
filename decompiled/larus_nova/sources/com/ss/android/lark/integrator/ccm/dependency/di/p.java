package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.setting.api.ISettingApi;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements ao4.d {
    public p() {
    }

    @Override // ao4.d
    public final void a(go2.g r100) {
        ISettingApi r101 = (ISettingApi) ApiUtils.getApi(ISettingApi.class);
        if (r101 == null) goto L7;
        r101.getUiModeService();
        return;
    }
}
