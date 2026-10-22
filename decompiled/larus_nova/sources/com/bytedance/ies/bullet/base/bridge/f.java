package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends b implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBridgeMethod f246285b;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        this.f246285b.release();
    }

    public f(IBridgeMethod r100) {
        this.f246285b = r100;
        super(r100);
    }
}
