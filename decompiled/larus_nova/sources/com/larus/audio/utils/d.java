package com.larus.audio.utils;

import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f290027a = 0;

    static {
    }

    public static String a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L5;
        r100.getAccountService();
        Boolean r101 = Boolean.valueOf(com.larus.home.impl.sdk.d.f346150a.isEnterpriseAccount());
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L9;
        return "nKYtQoVZ7RO2XEAe";
    L9:
        return "mcRPQyXTQo";
    L5:
        r101 = null;
        goto L7
    }
}
