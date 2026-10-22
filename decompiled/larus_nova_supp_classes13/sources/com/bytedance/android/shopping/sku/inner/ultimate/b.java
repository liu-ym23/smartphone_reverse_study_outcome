package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static int a() {
        int r0 = com.bytedance.android.shopping.sku.common.utils.c.a;
        return (int) SlcDimensExtensionsKt.d(Integer.valueOf(com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).b), new com.bytedance.android.shopping.buynow.starter.b(false, false, false, 0.0f, 12).a());
    }

    static {
    }

    public static int b(boolean r7) {
        if (r7 == false) goto L8;
        nj.d r8 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r8 == null) goto L6;
        r8.getSpiltWidth();
        float r9 = 0;
    L7:
        int r0 = com.bytedance.android.shopping.sku.common.utils.c.a;
        float r1 = (com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).a * 375.0f) / r9;
        Float r10 = Float.valueOf(r9);
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        float r11 = SlcDimensExtensionsKt.d(r10, com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r1, 1.0f, 1.0f));
    L14:
        return (int) r11;
    L6:
        r9 = 360.0f;
        goto L7
    L8:
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.V() == false) goto L12;
        return 390;
    L12:
        int r12 = com.bytedance.android.shopping.sku.common.utils.c.a;
        r11 = SlcDimensExtensionsKt.d(Integer.valueOf(com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).a), new com.bytedance.android.shopping.buynow.starter.b(false, false, false, 0.0f, 12).a());
        goto L14
    }
}
