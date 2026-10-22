package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.ies.xbridge.XBridgeMethod;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends b.a implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XBridgeMethod f202633b;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        this.f202633b.release();
    }

    public c(XBridgeMethod r100) {
        this.f202633b = r100;
        super(r100);
    }
}
