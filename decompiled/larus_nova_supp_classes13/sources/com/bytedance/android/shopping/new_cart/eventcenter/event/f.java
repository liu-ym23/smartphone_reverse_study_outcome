package com.bytedance.android.shopping.new_cart.eventcenter.event;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.new_cart.components.CartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.new_cart.components.CartBodyComponent;
import com.bytedance.android.shopping.new_cart.components.CartPageCallBackComponent;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CartObjectContainer a;

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Map r6 = r5.q();
        if (r6 == null) goto L5;
        Object r7 = r6.get("popup_code");
    L7:
        if ((r7 instanceof String) == true) goto L9;
        r7 = null;
    L9:
        String r8 = (String) r7;
        if (Intrinsics.areEqual(r8, "SEARCH_PANEL") == false) goto L12;
    L20:
        CartPageCallBackComponent r9 = (CartPageCallBackComponent) this.a.a(Reflection.getOrCreateKotlinClass(CartPageCallBackComponent.class));
        if (r9 == null) goto L23;
        RecyclerView r10 = r9.j;
    L24:
        if (r10 == null) goto L26;
        r10.post(new d(r10));
    L26:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L23:
        r10 = null;
        goto L24
    L12:
        if (Intrinsics.areEqual(r8, "MIX_CART") == true) goto L20;
        CartBackToTopBtnManageComponent r12 = (CartBackToTopBtnManageComponent) this.a.a(Reflection.getOrCreateKotlinClass(CartBackToTopBtnManageComponent.class));
        if (r12 == null) goto L17;
        r12.n(false);
    L17:
        CartBodyComponent r13 = (CartBodyComponent) this.a.a(Reflection.getOrCreateKotlinClass(CartBodyComponent.class));
        if (r13 == null) goto L26;
        r13.p().post(new e(r13));
        goto L26
    L5:
        r7 = null;
        goto L7
    }

    public f(CartViewModel r2, CartObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "cartViewModel");
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        this.a = r3;
    }
}
