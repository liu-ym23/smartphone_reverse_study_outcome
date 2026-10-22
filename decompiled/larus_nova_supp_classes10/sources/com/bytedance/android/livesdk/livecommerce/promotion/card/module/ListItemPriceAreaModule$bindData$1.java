package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ListItemPriceAreaModule$bindData$1 extends MutablePropertyReference0Impl {
    public ListItemPriceAreaModule$bindData$1(ListItemPriceAreaModule r7) {
        super(r7, ListItemPriceAreaModule.class, "promotion", "getPromotion()Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", 0);
    }

    public Object get() {
        ECUIPromotion r0 = ((ListItemPriceAreaModule) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ECUIPromotion r3 = (ECUIPromotion) r2;
        ((ListItemPriceAreaModule) ((CallableReference) this).receiver).d = r3;
    }
}
