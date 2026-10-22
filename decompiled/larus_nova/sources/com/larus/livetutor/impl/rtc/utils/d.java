package com.larus.livetutor.impl.rtc.utils;

import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes30.dex */
public final class d {
    static {
    }

    public static boolean a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L12;
        s r101 = r100.s0();
        if (r101 == null) goto L12;
        Integer r102 = r101.l();
        if (r102 == null) goto L12;
        if (r102.intValue() != 2) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        r103 = false;
        goto L13
    }
}
