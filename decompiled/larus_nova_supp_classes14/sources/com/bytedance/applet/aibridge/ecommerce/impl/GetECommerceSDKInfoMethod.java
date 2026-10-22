package com.bytedance.applet.aibridge.ecommerce.impl;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsGetECommerceSDKInfoMethodIDL;
import com.larus.platform.api.l2;
import com.larus.platform.service.l0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/GetECommerceSDKInfoMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetECommerceSDKInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetECommerceSDKInfoMethodIDL$GetECommerceSDKInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetECommerceSDKInfoMethodIDL$GetECommerceSDKInfoResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetECommerceSDKInfoMethod extends AbsGetECommerceSDKInfoMethodIDL {
    public GetECommerceSDKInfoMethod() {
    }

    public final void handle(d r3, ParamModel r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetECommerceSDKInfoMethodIDL.a) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        l2 r6 = l0.a();
        if (r6 == null) goto L6;
        String r7 = Integer.valueOf(r6.getVersion()).toString();
        if (r7 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(AbsGetECommerceSDKInfoMethodIDL.b.class, "<this>");
        AbsGetECommerceSDKInfoMethodIDL.b r0 = c.a(AbsGetECommerceSDKInfoMethodIDL.b.class);
        r0.setVersion(r7);
        r0.setSupport(Boolean.TRUE);
        if (r6 == null) goto L10;
        boolean r8 = true;
    L11:
        r0.setSupportEcommerceSaas(Boolean.valueOf(r8));
        r5.b(r0, "");
        return;
    L10:
        r8 = false;
    L6:
        r7 = "0";
        goto L7
    }
}
