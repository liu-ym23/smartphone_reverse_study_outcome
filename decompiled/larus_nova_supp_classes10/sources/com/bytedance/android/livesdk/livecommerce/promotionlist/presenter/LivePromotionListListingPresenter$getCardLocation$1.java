package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListListingPresenter$getCardLocation$1 extends MutablePropertyReference0Impl {
    public LivePromotionListListingPresenter$getCardLocation$1(LivePromotionListListingPresenter r7) {
        super(r7, LivePromotionListListingPresenter.class, "recyclerView", "getRecyclerView()Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/PromotionRecyclerView;", 0);
    }

    public Object get() {
        return LivePromotionListListingPresenter.k0((LivePromotionListListingPresenter) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        PromotionRecyclerView r3 = (PromotionRecyclerView) r2;
        ((LivePromotionListListingPresenter) ((CallableReference) this).receiver).k = r3;
    }
}
