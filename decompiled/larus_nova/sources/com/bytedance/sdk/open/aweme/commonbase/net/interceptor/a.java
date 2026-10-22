package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;

/* JADX INFO: loaded from: classes22.dex */
public class a implements OpenInterceptor {
    public a() {
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor
    public OpenHostResponse intercept(OpenInterceptor.Chain r100) {
        OpenHostRequest r101 = r100.request();
        OpenNetworkService r102 = (OpenNetworkService) OpenServiceManager.getInst().getService(OpenNetworkService.class);
        if (r102 != null) goto L6;
        r102 = new com.bytedance.sdk.open.aweme.commonbase.net.a();
    L6:
        return r102.newCall(r101).execute();
    }
}
