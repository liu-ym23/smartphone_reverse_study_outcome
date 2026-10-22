package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListViewModel$onSuccessCallback$4$1 extends MutablePropertyReference0Impl {
    public LivePromotionListViewModel$onSuccessCallback$4$1(LivePromotionListViewModel r7) {
        super(r7, LivePromotionListViewModel.class, "promotionListParams", "getPromotionListParams()Lcom/bytedance/android/livesdk/livecommerce/jump/model/PromotionListParams;", 0);
    }

    public Object get() {
        return ((LivePromotionListViewModel) ((CallableReference) this).receiver).getPromotionListParams();
    }

    public void set(Object r2) {
        ((LivePromotionListViewModel) ((CallableReference) this).receiver).setPromotionListParams((gi2.a) r2);
    }
}
