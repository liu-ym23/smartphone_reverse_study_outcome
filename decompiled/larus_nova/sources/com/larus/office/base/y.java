package com.larus.office.base;

import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y implements o0b.c {
    public y() {
    }

    @Override // o0b.c
    public final void P1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L6;
        r101.D();
        x1.f346268a.o(r100);
        return;
    }

    @Override // o0b.c
    public final void X(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L6;
        r101.D();
        x1.f346268a.n(r100);
        return;
    }
}
