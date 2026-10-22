package com.bytedance.android.livesdk.livecommerce.promotion.card;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements d {
    public static final a a = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.d
    public final Pair<String[], Long> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.d
    public final void b(String r1, String[] r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "promotionId");
        Intrinsics.checkNotNullParameter(r2, "selectedSkuIdList");
    }

    static {
        a = new a();
    }
}
