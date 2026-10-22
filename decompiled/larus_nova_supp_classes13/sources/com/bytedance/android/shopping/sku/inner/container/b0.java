package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 implements com.bytedance.kmp.ec.yata.event.common.i {
    public final /* synthetic */ SkuYataFragment a;

    public b0(SkuYataFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.event.common.h e(EventTriggerInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "eventTriggerInfo");
        return this.a.t.e(r2);
    }
}
