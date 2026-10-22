package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListFloatBottomHeightEventData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements a93.b<Integer> {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public p(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    public final void a(Object r5) {
        Integer r6 = (Integer) r5;
        LivePromotionListViewModel r0 = this.a.d0();
        int r2 = 0;
        if (r6 == null) goto L5;
        int r3 = r6.intValue();
    L6:
        com.bytedance.android.ec.core.arch.event.c.e(r0, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.c(r3));
        com.bytedance.android.shopping.ligo.context.b<?> r1 = this.a.d0().getLigoContext();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r6 == null) goto L11;
        r2 = r6.intValue();
    L11:
        r1.g(new we3.a.b(new LiveLigoListFloatBottomHeightEventData(r2)));
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
