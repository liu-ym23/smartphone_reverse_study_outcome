package com.bytedance.android.shopping.sku.inner.controller;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.container.e0;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataSliceServerTimeController {
    public Long a;

    public SkuYataSliceServerTimeController() {
    }

    public final void a(SlcRenderContext r11, long r12) {
        Long r0 = this.a;
        if (r0 != null) goto L6;
    L9:
        this.a = Long.valueOf(r12);
        long r4 = 1000;
        long r2 = System.currentTimeMillis() / r4;
        int r1 = e0.a;
        long r6 = r2 - ((long) ECSettingKeys.Y().c());
        long r3 = r2 + ((long) ECSettingKeys.Y().c());
        if (r6 <= r12) goto L13;
    L17:
        if (r11 == null) goto L19;
        r11.r(r12);
    L19:
        Lazy r13 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSliceServerTimeController", SkuYataSliceServerTimeController$updateServerTime$3.INSTANCE);
        return;
    L13:
        if (r3 < r12) goto L17;
        if (r11 == null) goto L16;
        r11.r(System.currentTimeMillis() / r4);
    L16:
        Lazy r14 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSliceServerTimeController", SkuYataSliceServerTimeController$updateServerTime$2.INSTANCE);
        return;
    L6:
        if (r0.longValue() != r12) goto L9;
        Lazy r15 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataSliceServerTimeController", SkuYataSliceServerTimeController$updateServerTime$1.INSTANCE);
    }
}
