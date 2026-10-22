package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ LivePromotionListGroupPresenter a;

    public l(LivePromotionListGroupPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg2.v r0 = new sg2.v("livesdk_back_store_button_click", this.a.d0().getPromotionListParams());     // Catch: Throwable -> L4
        r0.c("store_id", this.a.i0().z);     // Catch: Throwable -> L4
        r0.i(null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
