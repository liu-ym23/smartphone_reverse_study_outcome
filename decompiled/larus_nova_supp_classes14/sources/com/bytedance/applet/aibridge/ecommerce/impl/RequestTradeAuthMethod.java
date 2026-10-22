package com.bytedance.applet.aibridge.ecommerce.impl;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsRequestTradeAuthMethodIDL;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.TouristManager;
import com.larus.platform.api.f2;
import com.larus.platform.api.l2;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.l0;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lv3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/RequestTradeAuthMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsRequestTradeAuthMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsRequestTradeAuthMethodIDL$RequestTradeAuthMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsRequestTradeAuthMethodIDL$RequestTradeAuthMethodResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestTradeAuthMethod extends AbsRequestTradeAuthMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public RequestTradeAuthMethod() {
    }

    public final void handle(d r13, ParamModel r14, final h r15) {
        AbsRequestTradeAuthMethodIDL.a r16 = (AbsRequestTradeAuthMethodIDL.a) r14;
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "callback");
        TouristManager r0 = TouristManager.a;
        if (r0.f() == false) goto L5;
        FLogger.a.i("RequestTradeAuthMethod", "requestTradeAuth tourist mode, trigger login");
        ITouristApi.a.a(r0, TriggerLoginScene.TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL, false, 2);
        Intrinsics.checkNotNullParameter(AbsRequestTradeAuthMethodIDL.b.class, "<this>");
        AbsRequestTradeAuthMethodIDL.b r17 = c.a(AbsRequestTradeAuthMethodIDL.b.class);
        r17.setAccessToken("");
        r15.b(r17, "");
        return;
    L5:
        FragmentActivity r18 = r13.getOwnerActivity();
        if ((r18 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r5 = r18;
    L10:
        if (r5 != null) goto L12;
        FLogger.a.e("RequestTradeAuthMethod", "requestTradeAuth failed: cannot get fragment activity");
        h.a.a(r15, "Failed to get fragment activity", null, null, 14);
        return;
    L12:
        l2 r1 = l0.a();
        if (r1 != null) goto L15;
        FLogger.a.e("RequestTradeAuthMethod", "requestTradeAuth failed: IECommerceService is null");
        h.a.a(r15, "IECommerceService is null", null, null, 14);
        return;
    L15:
        String r3 = r16.getCurrentPage();
        if (r3 != null) goto L18;
        String r6 = "";
    L19:
        String r19 = r16.getSource();
        if (r19 != null) goto L22;
        String r7 = "";
    L23:
        r1.e(new uq9.d(r5, r6, r7, !f2.a.u(), false, true, 16), null, new u(r15));
        return;
    L22:
        r7 = r19;
        goto L23
    L18:
        r6 = r3;
        goto L19
    L8:
        r5 = null;
        goto L10
    }
}
