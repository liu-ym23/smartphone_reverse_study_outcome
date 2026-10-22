package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.expandOrFoldPendant", owner = "lizhongxian.ll0106")
public final class n extends qo6.j {

    public static final class a {
    }

    static {
    }

    public n() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        qo6.j.b r103 = (qo6.j.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
    L11:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, String.valueOf(e.getMessage()), null, 4, null);
        return;
    L4:
        if (com.bytedance.locallife.groupon.basic.utils.d.a(Integer.valueOf(r103.getPageType().intValue())) != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -300, "pageType must be 0,1,2", null, 4, null);     // Catch: Exception -> L11
        return;
    L6:
        int r104 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;     // Catch: Exception -> L11
        wq6.a r105 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);     // Catch: Exception -> L11
        if (r105 == null) goto L9;
        r103.getAction();     // Catch: Exception -> L11
        r103.isFixedState();     // Catch: Exception -> L11
        r105.r();     // Catch: Exception -> L11
    L9:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(qo6.j.c.class)), null, 2, null);     // Catch: Exception -> L11
    }
}
