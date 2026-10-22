package com.bytedance.android.shopping.buynow.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements com.bytedance.kmp.ec.yata.event.ability.uplink.c {
    public final /* synthetic */ BuyNowFragment a;

    public j(BuyNowFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.event.ability.uplink.b d(com.bytedance.kmp.ec.yata.event.ability.uplink.a r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        return this.a.W90().getSkuService().d(r2);
    }
}
