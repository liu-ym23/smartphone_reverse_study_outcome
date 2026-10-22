package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements ai2.a {
    public final /* synthetic */ LivePromotionListListingPresenter a;

    @Override // ai2.a
    public final void b(Pair<Integer, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "range");
    }

    public t(LivePromotionListListingPresenter r1) {
        this.a = r1;
    }

    @Override // ai2.a
    public final void a(int r4) {
        LivePromotionListListingPresenter.l0(this.a, CollectionsKt.listOf(new cf.x(r4, UpdateLocalViewType.UPDATE_EXPOSE)));
    }
}
