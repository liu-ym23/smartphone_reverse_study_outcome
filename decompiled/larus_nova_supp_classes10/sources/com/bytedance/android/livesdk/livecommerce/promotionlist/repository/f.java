package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageHeaderData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LivePromotionListRepository a;
    public final /* synthetic */ v0 b;

    public f(LivePromotionListRepository r1, LivePromotionListViewModel.i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        ECPromotionList.o r3 = (ECPromotionList.o) r2;
        if (r3 != null) goto L5;
    L18:
        v0 r4 = this.b;
        if (r4 == null) goto L24;
        r4.onError(null);
        return;
    L24:
        return;
    L5:
        if (((com.bytedance.android.ec.model.g) r3).statusCode != 0) goto L18;
        PromotionListController r0 = this.a.J();
        if (r0 == null) goto L15;
        LivePromotionListCacheCenter r1 = r0.F;
        if (r1 == null) goto L15;
        mj2.e r5 = r1.b;
        if (r5 == null) goto L15;
        LivePromotionPageHeaderData r6 = r5.m;
        if (r6 == null) goto L15;
        r6.setListBanner(r3);
    L15:
        v0 r7 = this.b;
        if (r7 == null) goto L22;
        r7.onSuccess(r3);
        return;
    }
}
