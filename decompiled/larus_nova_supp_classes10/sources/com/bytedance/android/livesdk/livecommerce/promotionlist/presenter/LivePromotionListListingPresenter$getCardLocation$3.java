package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListListingPresenter$getCardLocation$3 extends MutablePropertyReference0Impl {
    public LivePromotionListListingPresenter$getCardLocation$3(LivePromotionListListingPresenter r7) {
        super(r7, LivePromotionListListingPresenter.class, "layoutManager", "getLayoutManager()Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/PromotionLinearLayoutManager;", 0);
    }

    public Object get() {
        return LivePromotionListListingPresenter.i0((LivePromotionListListingPresenter) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        PromotionLinearLayoutManager r3 = (PromotionLinearLayoutManager) r2;
        ((LivePromotionListListingPresenter) ((CallableReference) this).receiver).l = r3;
    }
}
