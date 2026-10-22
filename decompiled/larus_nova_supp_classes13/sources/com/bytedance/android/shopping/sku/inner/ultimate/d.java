package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static String a(SkuParams r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "skuParams");
        Map<String, mh3.a> r0 = mh3.a.m;
        SkuAbilityType r1 = SkuAbilityType.BUYNOW;
        mh3.a.C0219a.a(r1, r11, false);
        new com.bytedance.android.shopping.sku.common.controller.d(r1, r11, false).a();
        UltimateBuyParams r2 = new UltimateBuyParams(null, new i(r11, true).a(), r12, 0, r11, null, 32, null);
        int r13 = ECSdk.a;
        IEShoppingService r14 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r14 == null) goto L8;
        sc3.c r15 = r14.getBuyNowService();
        if (r15 == null) goto L9;
        Lazy r3 = SkuBuyNowPanelHeightHelper.a;
        return r15.h(null, r2, new UltimateBuyStyleParams(SkuBuyNowPanelHeightHelper.a(String.valueOf(r11.getSceneType()), r11.getHeightPercent()), Float.valueOf(ul.g.a(r11.getMaskAlpha()))), null);
    L9:
        return null;
    L8:
        return null;
    }
}
