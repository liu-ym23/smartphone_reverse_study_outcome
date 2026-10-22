package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.home.entity.ToolType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(List r12, boolean r13, Function0 r14, String r15, Function0 r16, boolean r17, String r18, Function0 r19, boolean r20, String r21, Function0 r22) {
        Intrinsics.checkNotNullParameter(r12, "entryList");
        Intrinsics.checkNotNullParameter(r15, "couponLabelText");
        Intrinsics.checkNotNullParameter(r16, "onCouponClick");
        Intrinsics.checkNotNullParameter(r18, "cartLabelText");
        Intrinsics.checkNotNullParameter(r19, "onCartClick");
        Intrinsics.checkNotNullParameter(r21, "orderLabelText");
        Intrinsics.checkNotNullParameter(r22, "onOrderClick");
        if (r13 == false) goto L5;
        Unit r1 = (Unit) r14.invoke();
        com.bytedance.android.ec.model.h r2 = new com.bytedance.android.ec.model.h(r16, 2131237488, "shop_coupon_red_pack", r15, ToolType.COUPON_RED_PACK.getType());
        ((ArrayList) r12).add(r2);
    L5:
        if (r17 == false) goto L7;
        com.bytedance.android.ec.model.h r3 = new com.bytedance.android.ec.model.h(r19, 2131237482, "shop_cart", r18, ToolType.CART.getType());
        ((ArrayList) r12).add(r3);
    L7:
        if (r20 == false) goto L10;
        ArrayList r0 = (ArrayList) r12;
        r0.add(new com.bytedance.android.ec.model.h(r22, 2131237485, "shop_order", r21, ToolType.ORDER.getType()));
        return;
    }
}
