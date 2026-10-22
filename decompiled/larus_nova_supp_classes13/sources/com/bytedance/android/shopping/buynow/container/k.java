package com.bytedance.android.shopping.buynow.container;

import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements com.bytedance.kmp.ec.yata.event.common.i {
    public final /* synthetic */ BuyNowFragment a;

    public k(BuyNowFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.event.common.h e(EventTriggerInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "eventTriggerInfo");
        return this.a.W90().getSkuService().e(r2);
    }
}
