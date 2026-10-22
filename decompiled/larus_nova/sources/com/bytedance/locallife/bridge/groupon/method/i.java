package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "isLiveSDKInit", owner = "zhoujia.ethan")
public final class i extends qo6.g {
    public i() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((qo6.g.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (HostServiceUtilsKt.u0().e() == true) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, null, null, 6, null);
        return;
    L5:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(qo6.g.c.class), null, 2, null);
    }
}
