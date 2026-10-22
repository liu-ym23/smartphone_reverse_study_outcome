package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final ECPromotionInterationData a;
    public int b;

    public final String toString() {
        return "[data=" + this.a + ", rotationCount=" + this.b + ']';
    }

    public a(ECPromotionInterationData r2) {
        Intrinsics.checkNotNullParameter(r2, "interactionData");
        this.a = r2;
        this.b = 0;
    }
}
