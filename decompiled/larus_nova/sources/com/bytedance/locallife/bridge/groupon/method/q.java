package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.grouponInnerPageLifecycle", owner = "liuzhen.koi")
public final class q extends qo6.l {
    public q() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.l.b r113 = (qo6.l.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (com.bytedance.locallife.groupon.basic.utils.g.a(r113.getEnterFrom()) == true) goto L5;
    L23:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "params is invalid", null, 4, null);
        return;
    L5:
        if (com.bytedance.locallife.groupon.basic.utils.g.a(r113.getPage()) == false) goto L23;
        if (com.bytedance.locallife.groupon.basic.utils.g.a(r113.getPageUniqueId()) == false) goto L23;
        if (com.bytedance.locallife.groupon.basic.utils.g.a(r113.getState()) == false) goto L23;
        String r114 = r113.getState();
        if (Intrinsics.areEqual(r114, "show") == false) goto L17;
        int r115 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        wq6.a r116 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r116 == null) goto L15;
        r113.getEnterFrom();
        r113.getPageUniqueId();
        r116.d();
    L15:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(qo6.l.c.class), null, 2, null);
        r113.getEnterFrom();
        r113.getPageUniqueId();
        return;
    L17:
        if (Intrinsics.areEqual(r114, "close") == false) goto L22;
        int r117 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        wq6.a r118 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r118 == null) goto L21;
        r113.getEnterFrom();
        r113.getPageUniqueId();
        r118.g();
    L21:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(qo6.l.c.class), null, 2, null);
        r113.getEnterFrom();
        r113.getPageUniqueId();
        return;
    L22:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "state params " + r113.getState() + " is invalid", null, 4, null);
    }
}
