package com.bytedance.caijing.sdk.infra.base.impl.container;

import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements md4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BulletServiceImpl.b f202499a;

    public d(BulletServiceImpl.b r100) {
        this.f202499a = r100;
    }

    @Override // md4.d
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter("ttcjpay.receiveSDKNotification", "eventName");
        XCoreBridgeMethod r101 = (XCoreBridgeMethod) this.f202499a.g(XCoreBridgeMethod.class);
        if (r101 == null) goto L12;
        m16.b r102 = (m16.b) r101.provideContext(m16.b.class);
        if (r102 == null) goto L13;
        h16.e r103 = (h16.e) r102.c(h16.e.class);
        if (r103 == null) goto L14;
        o r104 = r103.getKitView();
        if (r104 == null) goto L15;
        r104.sendEvent("ttcjpay.receiveSDKNotification", r100);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
