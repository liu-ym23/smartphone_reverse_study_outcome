package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import com.bytedance.android.livesdk.livecommerce.promotion.card.b;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECProductCardPresenter$onUnBind$2 extends MutablePropertyReference0Impl {
    public ECProductCardPresenter$onUnBind$2(ECProductCardPresenter r7) {
        super(r7, ECProductCardPresenter.class, "promotionCard", "getPromotionCard()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCard;", 0);
    }

    public Object get() {
        b r0 = ((ECProductCardPresenter) ((CallableReference) this).receiver).f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCard");
    L5:
        return r0;
    }

    public void set(Object r2) {
        b r3 = (b) r2;
        ((ECProductCardPresenter) ((CallableReference) this).receiver).f = r3;
    }
}
