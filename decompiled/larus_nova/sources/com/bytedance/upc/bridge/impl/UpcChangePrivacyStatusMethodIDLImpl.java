package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.changePrivacyStatus", owner = "wanglijie.skin")
public final class UpcChangePrivacyStatusMethodIDLImpl extends gp7.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f272416d;

    public UpcChangePrivacyStatusMethodIDLImpl() {
        this.f272416d = LazyKt.lazy(UpcChangePrivacyStatusMethodIDLImpl$mConfiguration$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        gp7.b.InterfaceC6052b r103 = (gp7.b.InterfaceC6052b) r101;
        com.bytedance.upc.e r104 = ((com.bytedance.upc.a) this.f272416d.getValue()).f272402c;     // Catch: Throwable -> L5
        r103.getType();     // Catch: Throwable -> L5
        r103.getStatus();     // Catch: Throwable -> L5
        r104.d();     // Catch: Throwable -> L5
        CompletionBlock.DefaultImpls.onSuccess$default(r102, new d(), null, 2, null);     // Catch: Throwable -> L5
        return;
    L5:
        r102.onFailure(-1, "", new e());
    }
}
