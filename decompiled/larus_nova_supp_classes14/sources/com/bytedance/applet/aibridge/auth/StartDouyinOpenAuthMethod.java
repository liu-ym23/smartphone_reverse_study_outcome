package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.service.i0;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/StartDouyinOpenAuthMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsStartDouyinOpenAuthMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/auth/AbsStartDouyinOpenAuthMethodIDL$StartDouyinOpenAuthParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/auth/AbsStartDouyinOpenAuthMethodIDL$StartDouyinOpenAuthResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartDouyinOpenAuthMethod extends AbsStartDouyinOpenAuthMethodIDL {

    public static final class a {
    }

    static {
    }

    public StartDouyinOpenAuthMethod() {
    }

    public final void handle(e3.d r11, ParamModel r12, h r13) {
        AbsStartDouyinOpenAuthMethodIDL.a r14 = (AbsStartDouyinOpenAuthMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        ISdkDouyinAuth r15 = i0.a();
        JSONObject r0 = r14.getTraceInfo();
        if (r0 != null) goto L5;
        JSONObject r1 = new JSONObject();
    L7:
        if (r15 == null) goto L9;
        Boolean r16 = r15.f(r14.getClientKey(), r14.getScope(), r14.getState(), new e(r1, r13));
    L10:
        if (r16 != null) goto L13;
        h.a.a(r13, "getService fails", null, null, 14);
        return;
    L13:
        if (r16.booleanValue() == false) goto L17;
        w0.f(r1.optString("scene"), r1.optString("page_type"), r1.optString("enter_method"), r1.optString("message_id"), r1.optString("sec_enter_method"), null, null, null, 480);
        return;
    L17:
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r1 = new JSONObject(r0.toString());
        goto L7
    }
}
