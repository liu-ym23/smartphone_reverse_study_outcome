package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ListItemButtonModule$doClick$1 extends MutablePropertyReference0Impl {
    public ListItemButtonModule$doClick$1(ListItemButtonModule r7) {
        super(r7, ListItemButtonModule.class, "promotionCardItem", "getPromotionCardItem()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardItem;", 0);
    }

    public Object get() {
        i r0 = ((ListItemButtonModule) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        return r0;
    }

    public void set(Object r2) {
        i r3 = (i) r2;
        ((ListItemButtonModule) ((CallableReference) this).receiver).b = r3;
    }
}
