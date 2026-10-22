package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements md4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IXPayBaseMethod f202621a;

    public c(IXPayBaseMethod r100) {
        this.f202621a = r100;
    }

    @Override // md4.d
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter("ttcjpay.receiveSDKNotification", "eventName");
        cd4.e r101 = this.f202621a.f();
        if (r101 == null) goto L8;
        com.bytedance.caijing.sdk.infra.base.impl.container.d r102 = r101.getEvent();
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    }
}
