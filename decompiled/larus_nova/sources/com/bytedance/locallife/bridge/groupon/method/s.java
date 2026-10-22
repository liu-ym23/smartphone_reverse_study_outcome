package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.updateLifeMallFeedsCardData", owner = "zhoujia.ethan")
public final class s extends qo6.o {
    public s() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        qo6.o.b r103 = (qo6.o.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        JSONObject r104 = ConvertUtils.mapToJSON$default(ConvertUtils.INSTANCE, r103.getCardData(), 0, 2, null);
        if (r104.length() <= 0) goto L5;
        mr6.b r105 = bs6.a.a().getGrouponFeedService();
        r100.getEngineView();
        r104.toString();
        r105.getClass();
    L5:
        XBaseModel r106 = ne7.e.b(qo6.o.c.class);
        ((qo6.o.c) r106).setResult(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r106, null, 2, null);
    }
}
