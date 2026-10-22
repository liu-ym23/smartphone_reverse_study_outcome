package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.locallife.groupon.host.popup.ICommonResourceService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.grouponGetCouponResult", owner = "sunxinghang")
public final class p extends qo6.k {
    public p() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        qo6.k.b r103 = (qo6.k.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        System.currentTimeMillis();
        String r104 = r103.getCouponUuid();
        if (com.bytedance.locallife.groupon.basic.utils.g.a(r104) == true) goto L6;
        r104 = null;
    L6:
        if (r104 != null) goto L8;
        r104 = r103.getSendInfo();
    L8:
        int r105 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        ICommonResourceService r106 = (ICommonResourceService) com.bytedance.locallife.groupon.basic.utils.c.a(ICommonResourceService.class);
        if (r106 == null) goto L12;
        r106.getDrawCouponResult(r104, r103.getSendInfo(), new o(r102));
        return;
    }
}
