package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public n(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r5 = (com.bytedance.android.livesdk.livecommerce.iron.listheader.b) r4;
        this.a.Y().d().c(com.bytedance.android.livesdk.livecommerce.iron.listheader.c.class, this.a.d0().getListHeaderViewModel());
        LivePromotionListViewModel r6 = this.a.d0();
        com.bytedance.android.livesdk.livecommerce.iron.listheader.i.b r1 = this.a.d0().getListHeaderViewModel().c;
        if (r1 == null) goto L5;
        ECLottieAnimationView r2 = r1.b();
    L6:
        com.bytedance.android.ec.core.arch.event.c.d(r6, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b0(r2, this.a.d0().isDefaultTab()));
        return;
    L5:
        r2 = null;
        goto L6
    }
}
