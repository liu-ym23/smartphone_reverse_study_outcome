package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;

    public i(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = this.b;     // Catch: Throwable -> L8
        ECUIPromotion r1 = r0.a;     // Catch: Throwable -> L8
        sg2.v r2 = new sg2.v("livesdk_explain_apply_entrance_show", r0);     // Catch: Throwable -> L8
        ECUIAskExplainInfo r3 = r1.getAskExplainInfo();     // Catch: Throwable -> L8
        if (r3 == null) goto L5;
        String r4 = r3.getButtonStatus(r1);     // Catch: Throwable -> L8
    L6:
        r2.c("button_status", r4);     // Catch: Throwable -> L8
        PromotionListEventActionImplKt.a(r2, this.a.a, null);     // Catch: Throwable -> L8
        return;
    L5:
        r4 = null;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
