package com.bytedance.applet.aibridge.auth;

import android.os.Bundle;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i0;
import com.larus.platform.service.i3;
import f3.h;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/OpenAuthDouyinByHostMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsOpenAuthDouyinByHostMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/auth/AbsOpenAuthDouyinByHostMethodIDL$OpenAuthDouyinByHostParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/auth/AbsOpenAuthDouyinByHostMethodIDL$OpenAuthDouyinByHostResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenAuthDouyinByHostMethod extends AbsOpenAuthDouyinByHostMethodIDL {
    public static final Set<String> a = null;

    public static final class a {
    }

    static {
        a = SetsKt.setOf(new String[]{"1030", "1041"});
    }

    public OpenAuthDouyinByHostMethod() {
    }

    public final void handle(e3.d r11, ParamModel r12, h r13) {
        AbsOpenAuthDouyinByHostMethodIDL.a r14 = (AbsOpenAuthDouyinByHostMethodIDL.a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        i3 r15 = i3.a;
        boolean r1 = false;
        if (r15.f() == false) goto L5;
        r15.g(TriggerLoginScene.TRIGGER_LOGIN_TOURIST_AUTH);
        Intrinsics.checkNotNullParameter(AbsOpenAuthDouyinByHostMethodIDL.b.class, "<this>");
        AbsOpenAuthDouyinByHostMethodIDL.b r16 = k3.c.a(AbsOpenAuthDouyinByHostMethodIDL.b.class);
        r16.setAuthorized(false);
        r13.b(r16, "");
        return;
    L5:
        ISdkDouyinAuth r0 = i0.a();
        JSONObject r17 = r14.getTraceInfo();
        if (r17 != null) goto L8;
        JSONObject r18 = new JSONObject();
    L9:
        if (r0 == null) goto L11;
        w0.f(r18.optString("scene"), "host", r18.optString("enter_method"), r18.optString("message_id"), r18.optString("sec_enter_method"), null, null, null, 480);
        r1 = r0.k(new d(r0, r18, r13), "", false, false, new Bundle());
    L11:
        if (r1 == true) goto L15;
        h.a.a(r13, null, null, null, 15);
        return;
    L15:
        return;
    L8:
        r18 = new JSONObject(r17.toString());
        goto L9
    }
}
