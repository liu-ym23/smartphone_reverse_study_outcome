package com.larus.platform.service;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes31.dex */
public final class w0 {
    static {
    }

    public static String b() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r101 = null;
        if (r100 == null) goto L5;
        r100.i0();
        com.larus.home.impl.sdk.y r102 = com.larus.home.impl.sdk.y.f346269a;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.f();
    L8:
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    public static Fragment a(Activity r100) {
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L5;
        r101.i0();
        com.larus.home.impl.sdk.y r102 = com.larus.home.impl.sdk.y.f346269a;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.b(r100);
    L5:
        r102 = null;
        goto L6
    }
}
