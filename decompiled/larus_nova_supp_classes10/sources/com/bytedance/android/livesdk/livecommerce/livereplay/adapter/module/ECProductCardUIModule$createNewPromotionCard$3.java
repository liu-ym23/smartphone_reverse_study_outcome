package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECProductCardUIModule$createNewPromotionCard$3 extends MutablePropertyReference0Impl {
    public ECProductCardUIModule$createNewPromotionCard$3(f r7) {
        super(r7, f.class, "promotionCard", "getPromotionCard()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCard;", 0);
    }

    public Object get() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r0 = ((f) ((CallableReference) this).receiver).l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L5:
        return r0;
    }

    public void set(Object r3) {
        f r0 = (f) ((CallableReference) this).receiver;
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r4 = (com.bytedance.android.livesdk.livecommerce.promotion.card.b) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.l = r4;
    }
}
