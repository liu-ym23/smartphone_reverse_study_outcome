package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements cf.j {
    public final /* synthetic */ LivePromotionListListingPresenter a;

    public r(LivePromotionListListingPresenter r1) {
        this.a = r1;
    }

    public final void e(ql.a r2) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
        LivePromotionListListingPresenter.j0(this.a).D = r2;
    }

    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "promotionId");
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b r0 = this.a.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listingViewModel");
    L5:
        r0.m(CollectionsKt.listOf(r4), false, UpdateLocalViewType.UPDATE_ALL);
    }

    public final void c(String r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        this.a.d0().getPromotionById(r2, r3, r4);
    }
}
