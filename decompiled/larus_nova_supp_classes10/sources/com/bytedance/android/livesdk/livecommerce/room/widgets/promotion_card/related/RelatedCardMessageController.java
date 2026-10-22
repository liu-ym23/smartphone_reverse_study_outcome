package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RelatedCardMessageController implements c {
    public final com.bytedance.android.livesdk.livecommerce.room.utils.g a;
    public final b b;

    public RelatedCardMessageController(b r2) {
        Intrinsics.checkNotNullParameter(r2, "relatedController");
        this.b = r2;
        this.a = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.c
    public final void a(final e0 r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        int r0 = r5.actionType;
        if (r0 != 1) goto L5;
        this.a.c(String.valueOf(r5.promotionId), 0, true, new RelatedCardMessageController$refreshPromotion$1(this, r5));
        return;
    L5:
        if (r0 != 2) goto L14;
        ProductInfo r1 = r5.productInfo;
        if (r1 == null) goto L12;
        this.b.c(String.valueOf(r5.promotionId), r1);
        return;
    L12:
        return;
    }
}
