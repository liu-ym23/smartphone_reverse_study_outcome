package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.m;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.getTeenMode", owner = "wanglijie.skin")
public final class UpcGetTeenModeMethodIDLImpl extends gp7.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f272423d;

    public UpcGetTeenModeMethodIDLImpl() {
        this.f272423d = LazyKt.lazy(UpcGetTeenModeMethodIDLImpl$mConfiguration$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        gp7.h.b r103 = (gp7.h.b) r101;
        m r104 = ((com.bytedance.upc.a) this.f272423d.getValue()).f272404e;     // Catch: Throwable -> L7
        if (r104 == null) goto L10;
        new AnonymousClass1(r102);     // Catch: Throwable -> L7
        r104.b();     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }
}
