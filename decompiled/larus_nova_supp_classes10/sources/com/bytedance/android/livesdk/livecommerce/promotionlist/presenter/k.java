package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements View.OnLayoutChangeListener {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public k(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = r4 - r2;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (r10 == (r8 - r6)) goto L9;
        LivePromotionListViewModel r11 = this.a.d0();
        UIUtils.getScreenWidth(this.a.Y().c());
        com.bytedance.android.ec.core.arch.event.c.d(r11, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.u());
        return;
    }
}
