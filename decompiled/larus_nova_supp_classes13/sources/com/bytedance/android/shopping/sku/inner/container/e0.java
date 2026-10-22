package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
        Map r0 = SkuPerformanceOpt.b();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("ec_sku_slice_enable_layout_dirty_opt");
    L6:
        Intrinsics.areEqual(r2, 1);
        Map r3 = SkuPerformanceOpt.b();
        if (r3 == null) goto L9;
        Object r4 = r3.get("ec_sku_slice_enable_layout_param_opt");
    L10:
        Intrinsics.areEqual(r4, 1);
        Map r5 = SkuPerformanceOpt.b();
        if (r5 == null) goto L13;
        r1 = r5.get("ec_sku_slice_enable_style_merge_opt");
    L13:
        Intrinsics.areEqual(r1, 1);
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static com.bytedance.android.ecom.arch.slice.render.context.b a() {
        ECSettingKeys.j.getClass();
        float r1 = 1.0f;
        if (ECSettingKeys.T() != 1) goto L7;
        int r0 = com.bytedance.android.shopping.utils.o.a;
        if (ECAppInfoService.e.f() == false) goto L7;
        float r2 = 1.15f;
    L9:
        if (ECSettingKeys.T() != 1) goto L12;
        r1 = com.bytedance.android.shopping.utils.o.a();
    L12:
        if (ECSettingKeys.V() == false) goto L14;
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.d(390.0f, r2, r1);
    L14:
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.c(true);
    L7:
        r2 = 1.0f;
        goto L9
    }
}
