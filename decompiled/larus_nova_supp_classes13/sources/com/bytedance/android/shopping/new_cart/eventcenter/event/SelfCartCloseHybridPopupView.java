package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfCartCloseHybridPopupView extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Lazy a;
    public final CartObjectContainer b;

    public SelfCartCloseHybridPopupView(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "cartObjectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new SelfCartCloseHybridPopupView$cartPopupLayerComponent$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        Map r9 = r8.q();
        if (r9 == null) goto L5;
        Object r10 = r9.get("popup_code");
    L7:
        if ((r10 instanceof String) == true) goto L9;
        r10 = null;
    L9:
        String r1 = (String) r10;
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "popup code is null", null, null, 57);
    L18:
        Iterator r3 = StringsKt.split$default(r1, new String[]{","}, false, 0, 6, null).iterator();
    L20:
        if (r3.hasNext() == false) goto L32;
        String r4 = (String) r3.next();
        com.bytedance.android.shopping.new_cart.components.l r5 = (com.bytedance.android.shopping.new_cart.components.l) this.a.getValue();
        if (r5 == null) goto L26;
        PopupLayer r6 = r5.n();
        if (r6 == null) goto L26;
        Boolean r7 = Boolean.valueOf(r6.h(r4));
    L28:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L20;
        com.bytedance.android.shopping.new_cart.components.l r12 = (com.bytedance.android.shopping.new_cart.components.l) this.a.getValue();
        if (r12 == null) goto L20;
        r12.o();
    L26:
        r7 = null;
        goto L28
    L32:
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    L5:
        r10 = null;
        goto L7
    }
}
