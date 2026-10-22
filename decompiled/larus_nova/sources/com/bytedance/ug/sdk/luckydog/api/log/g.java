package com.bytedance.ug.sdk.luckydog.api.log;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements SDKMonitor.IGetExtendParams {
    public g() {
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final Map<String, String> getCommonParams() {
        HashMap r100 = new HashMap();
        r100.put("oversea", "0");
        return r100;
    }
}
