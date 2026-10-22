package com.larus.platform.service;

import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowOfficeAuthService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes31.dex */
public final class a2 {
    static {
    }

    public static IFlowOfficeAuthService a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.F();
    }
}
