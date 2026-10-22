package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends k implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XBridgeMethod f246286b;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        if (com.bytedance.ies.bullet.service.base.h.D() == false) goto L13;
        this.f246286b.release();
        XBridgeMethod r100 = this.f246286b;
        if ((r100 instanceof XCoreBridgeMethod) == false) goto L7;
        XCoreBridgeMethod r101 = (XCoreBridgeMethod) r100;
    L8:
        if (r101 == null) goto L12;
        g66.c r102 = r101.getContextProviderFactory();
        if (r102 == null) goto L12;
        r102.g();
    L12:
        this.f246286b.setProviderFactory(null);
        return;
    L7:
        r101 = null;
        goto L8
    L13:
        XBridgeMethod r103 = this.f246286b;
        if ((r103 instanceof XCoreBridgeMethod) == false) goto L16;
        XCoreBridgeMethod r104 = (XCoreBridgeMethod) r103;
    L17:
        if (r104 == null) goto L21;
        g66.c r105 = r104.getContextProviderFactory();
        if (r105 == null) goto L21;
        r105.g();
    L21:
        this.f246286b.setProviderFactory(null);
        this.f246286b.release();
        return;
    L16:
        r104 = null;
        goto L17
    }

    public g(XBridgeMethod r100) {
        this.f246286b = r100;
        super(r100);
    }
}
