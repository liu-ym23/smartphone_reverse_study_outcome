package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.kmp.ec.yata.event.common.a {
    public final Lazy a;
    public final CartObjectContainer b;
    public final CartViewModel c;

    public j(CartObjectContainer r3) {
        CartViewModel r0 = r3.d;
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r0, "cartViewModel");
        this.b = r3;
        this.c = r0;
        this.a = LazyKt.lazy(new OpenCrossShopDiscountFunction$isInSplit$2(this));
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r9, Function1 r10) {
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
        String r4 = (String) r1;
        bg3.a r2 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this.c, "OpenCrossShopDiscountFunction", new h(this), null);
        if (r11 == null) goto L12;
        Object r3 = r11.get("btm");
    L14:
        if ((r3 instanceof String) == true) goto L16;
        r3 = null;
    L16:
        String r6 = (String) r3;
        if (r11 == null) goto L19;
        Object r12 = r11.get("bcm");
    L21:
        if ((r12 instanceof Map) == false) goto L24;
        r0 = r12;
    L24:
        com.bytedance.android.shopping.new_cart.utils.a.f(new i(this, r4, r10, r6, (Map) r0));
        return;
    L19:
        r12 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
