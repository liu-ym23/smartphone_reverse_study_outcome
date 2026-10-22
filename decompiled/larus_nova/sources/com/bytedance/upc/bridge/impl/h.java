package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.cache.ApiHookRecord;
import java.util.Set;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.getApiRecordStatus", owner = "wanglijie.skin")
public final class h extends gp7.e {
    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        gp7.e.b r103 = (gp7.e.b) r101;
        Set<String> r104 = ApiHookRecord.f272434a;     // Catch: Throwable -> L9
        Number r105 = r103.getLimit();     // Catch: Throwable -> L9
        if (r105 == null) goto L7;
        ApiHookRecord.d(((Integer) r105).intValue(), new UpcGetApiRecordStatusMethodIDLImpl$handle$1(r102));     // Catch: Throwable -> L9
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L9
    }
}
