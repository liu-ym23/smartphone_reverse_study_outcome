package com.bytedance.applet.aibridge.ecommerce.impl;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsGetBtmInfoMethodIDL;
import com.larus.btm.api.IBTMService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/GetBtmInfoMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL$AbsGetBtmInfoMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL$AbsGetBtmInfoMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetBtmInfoMethod extends AbsGetBtmInfoMethodIDL {
    public GetBtmInfoMethod() {
    }

    public final void handle(d r4, ParamModel r5, h r6) {
        AbsGetBtmInfoMethodIDL.a r7 = (AbsGetBtmInfoMethodIDL.a) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        String r0 = r7.getBtm();
        JSONObject r8 = r7.getBcm();
        IBTMService r1 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        String r2 = null;
        if (r1 == null) goto L5;
        String r9 = r1.n(r0, r8, r4.getEngineView());
    L6:
        IBTMService r10 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r10 == null) goto L9;
        r2 = r10.c(r9);
    L9:
        Intrinsics.checkNotNullParameter(AbsGetBtmInfoMethodIDL.b.class, "<this>");
        AbsGetBtmInfoMethodIDL.b r11 = c.a(AbsGetBtmInfoMethodIDL.b.class);
        r11.setSourceBtmToken(r9);
        r11.setBtmShowId(r2);
        r6.b(r11, "");
        return;
    L5:
        r9 = null;
        goto L6
    }
}
