package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public i(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.d0().retry();
    }
}
