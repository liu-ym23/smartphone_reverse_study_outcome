package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.locallife.groupon.host.popup.ICommonResourceService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "locallife.groupon.animation", owner = "changlei")
public final class t extends qo6.p {

    public static final class a {
    }

    static {
    }

    public t() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        qo6.p.b r103 = (qo6.p.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getModuleID();
        String r105 = r103.getTargetID();
        int r106 = r103.getAnimation().intValue();
        int r107 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        ICommonResourceService r108 = (ICommonResourceService) com.bytedance.locallife.groupon.basic.utils.c.a(ICommonResourceService.class);
        if (r108 == null) goto L6;
        r108.runGrouponEntranceAnimation(r104, r105, r106, new u(r102));
        return;
    }
}
