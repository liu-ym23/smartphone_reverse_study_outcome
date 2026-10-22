package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ ECStockProgressLayout a;

    public j(ECStockProgressLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LivePromotionCardArgsV2 r0 = this.a.e;     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        ILivePromotionCardContainerHandler r1 = r0.b;     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        r1.i(null, 2, true);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
