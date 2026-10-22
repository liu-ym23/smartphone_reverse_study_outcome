package com.bytedance.applet.impl;

import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t1 implements com.bytedance.ai.widget.l {
    public t1() {
    }

    public final void a(com.bytedance.ai.widget.m r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        com.larus.bmhome.chat.api.t r0 = ILegacyChatUiServiceDelegate.b.V8();
        if (r0 == null) goto L6;
        r0.g(r5.a, r5.d, r5.e, r5.b);
        return;
    }

    public final void c(com.bytedance.ai.widget.m r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        com.larus.bmhome.chat.api.t r0 = ILegacyChatUiServiceDelegate.b.V8();
        if (r0 == null) goto L6;
        r0.h(r5.a, r5.d, r5.e, r5.b);
        return;
    }

    public final void b(com.bytedance.ai.widget.m r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "info");
        Intrinsics.checkNotNullParameter(r9, "errorMsg");
        com.larus.bmhome.chat.api.t r0 = ILegacyChatUiServiceDelegate.b.V8();
        if (r0 == null) goto L6;
        String r1 = r8.a;
        ContainerExceptionType r2 = ContainerExceptionType.FAILED_LYNX;
        String r3 = r8.b;
        JSONObject r4 = new JSONObject();
        r4.put("applet_id", r8.d);
        r4.put("widget_id", r8.e);
        r4.put("error_msg", r9);
        Unit r10 = Unit.INSTANCE;
        com.larus.bmhome.chat.api.t.a.a(r0, r1, r2, r3, r4);
        return;
    }
}
