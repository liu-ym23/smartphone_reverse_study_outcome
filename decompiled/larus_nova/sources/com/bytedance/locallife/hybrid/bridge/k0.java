package com.bytedance.locallife.hybrid.bridge;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k0 extends oe7.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oe7.c f259002d;

    public k0() {
        this.f259002d = new oe7.c();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        oe7.a.b r102 = (oe7.a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        int r103 = com.bytedance.locallife.common.utils.j.f257151a;
        if (com.bytedance.locallife.common.utils.j.b(r102.getSchema()) == false) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r110, -3, "schema should not be empty", null, 4, null);
        return;
    L5:
        tu6.b.a();
        this.f259002d.b(r100, r102, r110);
    }
}
