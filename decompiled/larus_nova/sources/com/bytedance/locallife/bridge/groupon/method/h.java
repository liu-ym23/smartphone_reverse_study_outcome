package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "groupon.saveFeedCardSchema", owner = "liuzhen.koi")
public final class h extends qo6.f {
    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        qo6.f.b r112 = (qo6.f.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        r112.getCardType();     // Catch: Exception -> L41
        r112.getProductId();     // Catch: Exception -> L41
        r112.getPoiId();     // Catch: Exception -> L41
        r112.getSchema();     // Catch: Exception -> L41
        String r101 = r112.getSchema();     // Catch: Exception -> L41
        boolean r102 = false;
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "schema cannot be empty", null, 4, null);     // Catch: Exception -> L41
        return;
    L12:
        String r104 = r112.getPoiId();     // Catch: Exception -> L41
        if (r104 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == false) goto L27;
        String r106 = r112.getProductId();     // Catch: Exception -> L41
        if (r106 != null) goto L23;
    L24:
        r102 = true;
    L25:
        if (r102 == false) goto L27;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "poiId and productId cannot be empty at the same time", null, 4, null);     // Catch: Exception -> L41
        return;
    L23:
        if (r106.length() != 0) goto L25;
    L27:
        String r107 = r112.getCardType();     // Catch: Exception -> L41
        if (Intrinsics.areEqual(r107, AppletNaviType.POI) == false) goto L34;
        int r108 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;     // Catch: Exception -> L41
        wq6.a r109 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);     // Catch: Exception -> L41
        if (r109 == null) goto L32;
        r112.getPoiId();     // Catch: Exception -> L41
        r112.getSchema();     // Catch: Exception -> L41
        r109.p();     // Catch: Exception -> L41
    L32:
        r112.getPoiId();     // Catch: Exception -> L41
        r112.getSchema();     // Catch: Exception -> L41
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(qo6.f.c.class), null, 2, null);     // Catch: Exception -> L41
        return;
    L34:
        if (Intrinsics.areEqual(r107, "product") == false) goto L39;
        int r113 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;     // Catch: Exception -> L41
        wq6.a r114 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);     // Catch: Exception -> L41
        if (r114 == null) goto L38;
        r112.getProductId();     // Catch: Exception -> L41
        r112.getSchema();     // Catch: Exception -> L41
        r114.e();     // Catch: Exception -> L41
    L38:
        r112.getProductId();     // Catch: Exception -> L41
        r112.getSchema();     // Catch: Exception -> L41
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(qo6.f.c.class), null, 2, null);     // Catch: Exception -> L41
        return;
    L39:
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "cardType must be poi or product", null, 4, null);     // Catch: Exception -> L41
        return;
    L15:
        if (r104.length() == 0) goto L18;
        r105 = false;
        goto L19
    L6:
        if (r101.length() == 0) goto L9;
        r103 = false;
    L41:
        e = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, String.valueOf(e.getMessage()), null, 4, null);
    }
}
