package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements com.bytedance.kmp.ec.yata.event.common.i {
    public final /* synthetic */ SkuFullScreenFragment a;

    public l(SkuFullScreenFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.event.common.h e(EventTriggerInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "eventTriggerInfo");
        return this.a.q.e(r2);
    }
}
