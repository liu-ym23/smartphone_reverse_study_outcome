package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ d.c a;

    public e(d.c r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.c r0 = this.a;     // Catch: Throwable -> L6
        r0.b.g = true;     // Catch: Throwable -> L6
        ECUIPromotion r1 = (ECUIPromotion) r0.a.getPromotionState().a();     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        d.E(this.a.b, r1);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
