package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OpenCrossShopDiscountFunction extends com.bytedance.kmp.ec.yata.event.common.a {
    public final String a;
    public final Lazy b;
    public final Lazy c;
    public final CardListObjectContainer d;

    public OpenCrossShopDiscountFunction(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.d = r2;
        CardPassThroughData r3 = r2.e.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMonitorId();
    L6:
        this.a = r4;
        this.b = LazyKt.lazy(new OpenCrossShopDiscountFunction$monitorManager$2(this));
        this.c = LazyKt.lazy(new OpenCrossShopDiscountFunction$isInSplit$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r9, final Function1 r10) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "chainNextCallback");
        Map r11 = r9.q();
        Object r0 = null;
        if (r11 == null) goto L5;
        Object r1 = r11.get("schema");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        final String r4 = (String) r1;
        CardListRunCatchExtKt.a(this.a, "OpenCrossShopDiscountFunction", new OpenCrossShopDiscountFunction$onExecuteAsync$1(this));
        if (r11 == null) goto L12;
        Object r2 = r11.get("btm");
    L14:
        if ((r2 instanceof String) == true) goto L16;
        r2 = null;
    L16:
        final String r6 = (String) r2;
        if (r11 == null) goto L19;
        Object r12 = r11.get("bcm");
    L21:
        if ((r12 instanceof Map) == false) goto L24;
        r0 = r12;
    L24:
        final Map r7 = (Map) r0;
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r13 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new OpenCrossShopDiscountFunction$onExecuteAsync$2(this, r4, r10, r6, r7));
        return;
    L19:
        r12 = null;
        goto L21
    L12:
        r2 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
