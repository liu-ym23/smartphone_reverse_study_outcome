package com.bytedance.applet.aibridge.anniex;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.w3;
import com.larus.platform.service.u3;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/anniex/SendEventToAnniexMethod;", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL$SendEventToAnniexParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/anniex/AbsSendEventToAnniexMethodIDL$SendEventToAnniexResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendEventToAnniexMethod extends AbsSendEventToAnniexMethodIDL {
    public SendEventToAnniexMethod() {
    }

    public final void handle(d r4, ParamModel r5, h r6) {
        AbsSendEventToAnniexMethodIDL.b r7 = (AbsSendEventToAnniexMethodIDL.b) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        String r0 = null;
        if (StringsKt.isBlank(r7.getEventName()) == false) goto L5;
        h.a.a(r6, "eventName is empty", null, null, 14);
        return;
    L5:
        Lazy r8 = u3.a;
        String r9 = r7.getEventName();
        Map<String, Object> r1 = r7.getParams();
        String r10 = r7.getContainerId();
        if (r10 != null) goto L8;
    L13:
        Intrinsics.checkNotNullParameter(r9, "eventName");
        w3 r11 = (w3) u3.a.getValue();
        if (r11 == null) goto L16;
        r11.b(r9, r1, r0);
    L16:
        Intrinsics.checkNotNullParameter(AbsSendEventToAnniexMethodIDL.c.class, "<this>");
        r6.b(c.a(AbsSendEventToAnniexMethodIDL.c.class), "");
        return;
    L8:
        if (r10.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        r0 = r10;
        goto L13
    L10:
        r2 = false;
        goto L11
    }
}
