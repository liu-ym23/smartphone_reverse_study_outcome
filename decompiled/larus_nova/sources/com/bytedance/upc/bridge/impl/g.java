package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.delete", owner = "wanglijie.skin")
public final class g extends gp7.d {
    public g() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        gp7.d.b r103 = (gp7.d.b) r101;
        ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().getClass();
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "business don't set deleteEventService", null, 4, null);
    }
}
