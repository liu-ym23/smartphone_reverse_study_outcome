package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.stopGyroscope")
public final class y extends ye7.d {
    public y() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((ye7.d.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r100.getOwnerActivity() != null) goto L5;
        id7.c.a("XStopGyroscopeMethod: obtaining context, but got a null.");
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "context is null!!", null, 4, null);
        return;
    L5:
        ze7.b.f571549a.a();
        r102.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(ye7.d.c.class)), "stop gyroscope execute success.");
    }
}
