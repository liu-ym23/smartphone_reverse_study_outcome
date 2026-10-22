package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListViewModel$addCartSuccessForAnim$addCartOpt$1 extends MutablePropertyReference0Impl {
    public LivePromotionListViewModel$addCartSuccessForAnim$addCartOpt$1(LivePromotionListViewModel r7) {
        super(r7, LivePromotionListViewModel.class, "params", "getParams()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", 0);
    }

    public Object get() {
        return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getParams();
    }

    public void set(Object r2) {
        ((LivePromotionListViewModel) ((CallableReference) this).receiver).setParams((LivePromotionListParams) r2);
    }
}
