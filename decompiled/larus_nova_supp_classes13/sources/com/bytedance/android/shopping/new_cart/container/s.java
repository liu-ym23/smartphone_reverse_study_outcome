package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.bytedance.android.ecom.arch.slice.render.context.b a(Boolean r4) {
        com.bytedance.android.ecom.arch.slice.render.context.b.a r0 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        float r2 = 1.0f;
        if (CartSettingUtils.b() == false) goto L7;
        Float r1 = ECAppInfoService.e.getCurrentFontScale();
        if (r1 == null) goto L7;
        float r3 = r1.floatValue();
    L9:
        if (CartSettingUtils.b() == false) goto L14;
        Float r5 = ECAppInfoService.e.getCurrentFontScale();
        if (r5 == null) goto L14;
        r2 = r5.floatValue();
    L14:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
        nj.d r6 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r6 == null) goto L18;
        r6.getSpiltWidth();
        int r7 = 0;
    L20:
        r0.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.b(375.0f, r2, r3, r7);
    L18:
        r7 = 360;
        goto L20
    L19:
        r7 = -1;
    L7:
        r3 = 1.0f;
        goto L9
    }
}
