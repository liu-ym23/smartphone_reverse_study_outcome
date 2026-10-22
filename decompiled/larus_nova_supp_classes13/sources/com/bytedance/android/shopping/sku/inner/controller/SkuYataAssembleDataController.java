package com.bytedance.android.shopping.sku.inner.controller;

import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataAssembleDataController {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public SkuYataAssembleDataController(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void a(final Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "trackCommonInfo");
        SkuRunCatchExtKt.a(this.a.qn().getSkuParams().getMonitorId(), "SkuYataAssembleDataController", new SkuYataAssembleDataController$putDataToTransmissibleJson$1(this, r3));
    }
}
