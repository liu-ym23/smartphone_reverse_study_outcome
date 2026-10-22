package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemBottomBlockView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends QPresenter {
    public boolean e;
    public final LivePromotionCardArgs f;
    public final w83.d<?> g;
    public final Lazy<w83.i> h;

    public final void A(QModel r5) {
        if ((r5 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r5 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r6 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r5;
        if (r6 != null) goto L8;
        return;
    L8:
        if (this.e == true) goto L11;
        this.e = true;
        ListItemBottomBlockView r0 = (ListItemBottomBlockView) w().f();
        LivePromotionCardArgs r1 = this.f;
        Lazy<w83.i> r2 = this.h;
        Intrinsics.checkNotNullParameter(r1, "argument");
        r0.a = r2;
        r0.getClass();
    L11:
        ListItemBottomBlockView r3 = (ListItemBottomBlockView) w().f();
        Intrinsics.checkNotNullParameter(r6, "item");
    }

    public c(LivePromotionCardArgs r2, w83.d<?> r3, Lazy<? extends w83.i> r4) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        Intrinsics.checkNotNullParameter(r4, "ligoViewManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
