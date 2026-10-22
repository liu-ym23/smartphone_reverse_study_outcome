package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public o(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        we3.b r3 = (we3.b) r2;
        if (r3 == null) goto L8;
        com.bytedance.android.shopping.ligo.context.b<?> r0 = this.a.z;
        if (r0 == null) goto L9;
        r0.g(r3);
        return;
    L9:
        return;
    }
}
