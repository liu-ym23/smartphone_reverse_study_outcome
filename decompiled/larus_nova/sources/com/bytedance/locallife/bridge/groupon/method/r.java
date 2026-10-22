package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.insertInteractUndertakeCards", owner = "zhoujia.ethan")
public final class r extends qo6.m {
    public r() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        qo6.m.b r103 = (qo6.m.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        mr6.b r104 = bs6.a.a().getGrouponFeedService();
        r100.getEngineView();
        new LocalLifeInsertInteractUndertakeCardsMethodIDL$handle$1(r102);
        r103.getVersion();
        r103.getInteractCardContext();
        r104.getClass();
    }
}
