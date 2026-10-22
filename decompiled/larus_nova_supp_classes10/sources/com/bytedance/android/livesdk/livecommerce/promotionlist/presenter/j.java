package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements View.OnLayoutChangeListener {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public j(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r5 - r3) == (r9 - r7)) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(this.a.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.o());
        return;
    }
}
