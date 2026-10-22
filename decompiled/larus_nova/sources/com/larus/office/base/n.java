package com.larus.office.base;

import com.larus.applog.api.IApplog;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;

/* JADX INFO: loaded from: classes29.dex */
public final class n implements IDeviceInfoProvider {
    public n() {
    }

    @Override // com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider
    public final String getDeviceId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider
    public final String getInstallId() {
        return IApplog.f287053a.getInstallId();
    }
}
