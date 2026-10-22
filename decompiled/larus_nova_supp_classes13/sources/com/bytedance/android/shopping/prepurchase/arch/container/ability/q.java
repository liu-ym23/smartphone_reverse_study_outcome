package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public final String a;
    public final String b;

    public q() {
        Intrinsics.checkNotNullParameter("updateGoodsDetail", "lynxEventName");
        Intrinsics.checkNotNullParameter("Refresh", "sliceEventName");
        this.a = "Refresh";
        this.b = "updateGoodsDetail";
    }
}
