package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import androidx.paging.PagedList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements ca3.a {
    public final /* synthetic */ LivePromotionListListingPresenter a;

    public x(LivePromotionListListingPresenter r1) {
        this.a = r1;
    }

    public final ca3.d a(int r4) {
        PagedList r0 = (PagedList) this.a.d0().getPageListLiveData().getValue();
        if (r0 == null) goto L7;
        mj2.c r5 = (mj2.c) CollectionsKt.getOrNull(r0, r4);
        if (r5 == null) goto L7;
        ql.a r6 = r5.a;
    L8:
        if (r6 == null) goto L13;
        String r1 = r6.getScheme();
        if (r1 != null) goto L12;
        return null;
    L12:
        return new ca3.d(r1, r6.getPromotionId(), r6.getProductId());
    L13:
        return null;
    L7:
        r6 = null;
        goto L8
    }
}
