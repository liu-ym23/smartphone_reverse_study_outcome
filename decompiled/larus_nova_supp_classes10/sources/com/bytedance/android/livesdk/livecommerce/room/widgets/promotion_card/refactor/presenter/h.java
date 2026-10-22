package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends InfoItemAnim<Long> {
    public h(Query r2, Query r3) {
        super(r2, r3, 0.8f);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final void a(Long r3, Query r4) {
        Long r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "query");
        if (r5 == null) goto L6;
        final long r0 = r5.longValue();
        r4.f().C(new AuctionCardPresenter$updateBidInfo$1$onBindView$1$1(r0));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final boolean b(Long r1, Long r2) {
        return !Intrinsics.areEqual(r1, r2);
    }
}
