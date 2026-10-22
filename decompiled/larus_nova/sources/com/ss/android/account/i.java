package com.ss.android.account;

import com.bytedance.sdk.account.platform.api.IAuthorizeMonitorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements IAuthorizeMonitorService {
    public i() {
    }

    @Override // com.bytedance.sdk.account.platform.api.IAuthorizeMonitorService
    public final void onEvent(String r100, JSONObject r101) {
        com.bytedance.sdk.account.monitor.a.a(r100, r101);
    }
}
