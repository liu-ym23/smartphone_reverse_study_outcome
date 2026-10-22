package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemGuideModule;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends QPresenter {
    public boolean e;
    public com.bytedance.android.livesdk.livecommerce.promotion.card.i f;
    public final LivePromotionCardArgs g;

    public final void C() {
    }

    public h(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.g = r2;
    }

    public final void A(QModel r4) {
        if ((r4 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r5 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r4;
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.e == true) goto L11;
        this.e = true;
        ((ListItemGuideModule) w().b(2131377866).f()).setArgument(this.g);
    L11:
        this.f = r5;
        ListItemGuideModule r6 = (ListItemGuideModule) w().b(2131377866).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r0 = this.f;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L14:
        r6.f(r0.a, new ListItemRootPresenter$updateGuideArea$1(this));
        UpdateType r7 = UpdateType.UPDATE_ALL;
    }
}
