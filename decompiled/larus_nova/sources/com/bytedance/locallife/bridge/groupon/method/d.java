package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "getLifeTransParentParams", owner = "zengyutong")
public final class d extends qo6.c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        qo6.c.b r103 = (qo6.c.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Objects.toString(r103.getPageType());     // Catch: Exception -> L20
        if (com.bytedance.locallife.groupon.basic.utils.d.a(Integer.valueOf(r103.getPageType().intValue())) != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -300, "pageType must be 0,1,2", null, 4, null);     // Catch: Exception -> L20
        return;
    L6:
        XBaseModel r104 = ne7.e.c(Reflection.getOrCreateKotlinClass(qo6.c.InterfaceC7375c.class));     // Catch: Exception -> L20
        qo6.c.InterfaceC7375c r105 = (qo6.c.InterfaceC7375c) r104;     // Catch: Exception -> L20
        int r106 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;     // Catch: Exception -> L20
        wq6.a r107 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);     // Catch: Exception -> L20
        if (r107 == null) goto L9;
        String r108 = r107.a();     // Catch: Exception -> L20
    L10:
        r105.setDiamondTrackParams(r108);     // Catch: Exception -> L20
        wq6.a r109 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);     // Catch: Exception -> L20
        if (r109 == null) goto L13;
        String r110 = r109.a();     // Catch: Exception -> L20
    L14:
        r105.setFeedTrackParams(r110);     // Catch: Exception -> L20
        wq6.a r111 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);     // Catch: Exception -> L20
        if (r111 == null) goto L17;
        String r112 = r111.getCommonTransInfo();     // Catch: Exception -> L20
    L18:
        r105.setCommonTransInfo(r112);     // Catch: Exception -> L20
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (qo6.c.InterfaceC7375c) r104, null, 2, null);     // Catch: Exception -> L20
        return;
    L17:
        r112 = null;
        goto L18
    L13:
        r110 = null;
        goto L14
    L9:
        r108 = null;
    L20:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, String.valueOf(e.getMessage()), null, 4, null);
    }
}
