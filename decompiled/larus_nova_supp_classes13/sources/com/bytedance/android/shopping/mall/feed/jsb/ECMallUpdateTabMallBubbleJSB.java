package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallUpdateTabMallBubbleJSB extends qf3.a {
    public final String getName() {
        return "ec.mallUpdateTabMallBubble";
    }

    public ECMallUpdateTabMallBubbleJSB(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r9, qf3.d r10, Map<String, ? extends Object> r11, final IDLXBridgeMethod.a r12) {
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Object r13 = r11.get("needShow");
        Object r1 = null;
        if ((r13 instanceof Boolean) == true) goto L5;
        r13 = null;
    L5:
        Intrinsics.areEqual((Boolean) r13, Boolean.TRUE);
        Object r14 = r11.get("bubbleComponentID");
        if ((r14 instanceof String) == true) goto L8;
        r14 = null;
    L8:
        String r15 = (String) r14;
        if (r15 != null) goto L11;
        String r3 = "";
    L12:
        Object r16 = r11.get("bubbleIcon");
        if ((r16 instanceof String) == true) goto L15;
        r16 = null;
    L15:
        String r17 = (String) r16;
        if (r17 != null) goto L18;
        String r4 = "";
    L19:
        Object r18 = r11.get("bubbleText");
        if ((r18 instanceof String) == true) goto L22;
        r18 = null;
    L22:
        String r19 = (String) r18;
        if (r19 != null) goto L25;
        String r5 = "";
    L26:
        Object r20 = r11.get("bubbleDuration");
        if ((r20 instanceof Integer) == true) goto L29;
        r20 = null;
    L29:
        Integer r21 = (Integer) r20;
        if (r21 == null) goto L32;
        r21.intValue();
    L32:
        Object r22 = r11.get("bubbleType");
        if ((r22 instanceof Integer) == true) goto L35;
        r22 = null;
    L35:
        Integer r23 = (Integer) r22;
        if (r23 == null) goto L38;
        r23.intValue();
    L38:
        Object r24 = r11.get("bubbleSubType");
        if ((r24 instanceof Integer) == false) goto L42;
        r1 = r24;
    L42:
        Integer r2 = (Integer) r1;
        if (r2 == null) goto L45;
        r2.intValue();
    L45:
        r10.b.A1.rL(r3, r4, r5, new ECMallUpdateTabMallBubbleJSB$handleCall$1(r12), new ECMallUpdateTabMallBubbleJSB$handleCall$2(r12));
        return;
    L25:
        r5 = r19;
        goto L26
    L18:
        r4 = r17;
        goto L19
    L11:
        r3 = r15;
        goto L12
    }
}
