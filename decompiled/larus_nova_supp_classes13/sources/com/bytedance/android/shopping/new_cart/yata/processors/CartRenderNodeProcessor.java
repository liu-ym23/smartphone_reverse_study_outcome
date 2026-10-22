package com.bytedance.android.shopping.new_cart.yata.processors;

import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.store.core.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartRenderNodeProcessor extends a {
    public final CartViewModel a;
    public final CartObjectContainer b;

    public final void d() {
        this.b.e.f.clear();
        this.b.e.h.clear();
        this.b.e.i.clear();
    }

    public final void e() {
        this.b.e.g.clear();
        this.b.e.f.clear();
        this.b.e.h.clear();
        this.b.e.i.clear();
    }

    public final void b(a.a r6) {
        Intrinsics.checkNotNullParameter(r6, "modifier");
        String r0 = r6.c();
        if (r0 == null) goto L63;
        boolean r2 = false;
        int r3 = 0;
        Integer r4 = null;
        switch(r0.hashCode()) {
            case -1665880638: goto L41;
            case -891535336: goto L35;
            case -397099026: goto L32;
            case 6871542: goto L26;
            case 287836899: goto L15;
            case 1014047840: goto L12;
            case 2109560828: goto L9;
            default: goto L64;
        };
    L64:
        return;
    L9:
        if (r0.equals("mix_cart_product_card") == true) goto L42;
        return;
    L42:
        com.bytedance.android.shopping.new_cart.yata.customdata.a r1 = this.a.getCustomDataCenter();
        if (r1 == null) goto L61;
        Map r5 = (Map) ((LinkedHashMap) r1.b).get(r6.b());
        if (r5 == null) goto L62;
        Iterator r7 = r5.entrySet().iterator();
    L48:
        if (r7.hasNext() == false) goto L65;
        Map.Entry r8 = (Map.Entry) r7.next();
        r6.e((String) r8.getKey(), r8.getValue());
        goto L48
    L65:
        return;
    L62:
        return;
    L61:
        return;
    L12:
        if (r0.equals("product_card") == true) goto L42;
        return;
    L15:
        if (r0.equals("cart_header_card") == false) goto L53;
        com.bytedance.android.shopping.new_cart.yata.customdata.a r9 = this.a.getCustomDataCenter();
        if (r9 == null) goto L24;
        Integer r10 = r9.a;
        if (r10 == null) goto L24;
        int r11 = r10.intValue();
        if (Intrinsics.areEqual(r9.d, ECFoldScene.LIVE.name()) == false) goto L23;
        r3 = 7;
    L23:
        r4 = Integer.valueOf(r11 + r3);
    L24:
        r6.e("padding_top", r4);
        r6.e("is_xtab", Boolean.valueOf(!this.b.e.k));
        return;
    L53:
        return;
    L26:
        if (r0.equals("cart_tab") == true) goto L28;
        return;
    L28:
        if (this.b.e.q != 100) goto L30;
        r2 = true;
    L30:
        r6.e("show", Boolean.valueOf(r2));
        return;
    L32:
        if (r0.equals("srp_product_card") == true) goto L42;
        return;
    L35:
        if (r0.equals("submit") == false) goto L58;
        Lazy r12 = CartCommonLog.a;
        CartCommonLog.a("CartRenderNodeProcessor", new CartRenderNodeProcessor$doProcessModify$1(this));
        com.bytedance.android.shopping.new_cart.yata.customdata.a r13 = this.a.getCustomDataCenter();
        if (r13 == null) goto L39;
        r4 = Integer.valueOf(r13.b());
    L39:
        r6.e("padding_bottom", r4);
        return;
    L58:
        return;
    L41:
        if (r0.equals("product_card_ext") == true) goto L42;
        return;
    }

    public final void c(a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "modifier");
        String r0 = r4.b();
        Map r5 = r4.a();
        if (r0 == null) goto L9;
        if (r5 == null) goto L10;
        com.bytedance.android.shopping.new_cart.yata.customdata.a r1 = this.a.getCustomDataCenter();
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r0, "nodeKey");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.b.put(r0, MapsKt.toMutableMap(r5));
        return;
    L11:
        return;
    L10:
        return;
    }

    public CartRenderNodeProcessor(CartViewModel r2, CartObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "cartVM");
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        this.a = r2;
        this.b = r3;
    }
}
