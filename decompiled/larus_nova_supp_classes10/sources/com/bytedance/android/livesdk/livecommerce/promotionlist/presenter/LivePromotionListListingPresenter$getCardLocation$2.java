package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListListingPresenter$getCardLocation$2 extends MutablePropertyReference0Impl {
    public LivePromotionListListingPresenter$getCardLocation$2(LivePromotionListListingPresenter r7) {
        super(r7, LivePromotionListListingPresenter.class, "adapter", "getAdapter()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/LivePromotionListPageAdapter;", 0);
    }

    public Object get() {
        return LivePromotionListListingPresenter.h0((LivePromotionListListingPresenter) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        LivePromotionListPageAdapter r3 = (LivePromotionListPageAdapter) r2;
        ((LivePromotionListListingPresenter) ((CallableReference) this).receiver).m = r3;
    }
}
