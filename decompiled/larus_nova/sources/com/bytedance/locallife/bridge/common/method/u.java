package com.bytedance.locallife.bridge.common.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.batchSendPoiLog")
public final class u extends ko6.m implements com.bytedance.sdk.xbridge.cn.protocol.h {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public u() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        ko6.m.b r113 = (ko6.m.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Iterator<T> r100 = r113.getEventList().iterator();
    L3:
        boolean r101 = true;
    L5:
        if (r100.hasNext() == false) goto L11;
        ko6.m.d r102 = (ko6.m.d) r100.next();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r113.getCommonParams());
        r103.putAll(r102.getParams());
        t r104 = new t(r102, r103, r113);
        int r105 = mo6.b.f514593a;
        boolean r106 = mo6.b.a(r104, r110.getEngineView(), null, false);
        if (r101 == false) goto L10;
        if (r106 == true) goto L3;
    L10:
        r101 = false;
        goto L5
    L11:
        if (r101 == false) goto L13;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(ko6.m.c.class), null, 2, null);
        return;
    L13:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, null, null, 6, null);
    }
}
