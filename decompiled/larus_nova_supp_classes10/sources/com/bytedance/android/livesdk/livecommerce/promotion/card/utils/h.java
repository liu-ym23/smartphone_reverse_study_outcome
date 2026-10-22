package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;

    public h(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("livesdk_explain_apply_entrance_click", this.b);
        ECUIAskExplainInfo r1 = this.b.a.getAskExplainInfo();
        if (r1 == null) goto L9;
        ECUIPromotion r3 = this.b.a;
        if (r3 == null) goto L8;
        String r2 = r1.getButtonStatus(r3);
    L10:
        r0.c("button_status", r2);
        PromotionListEventActionImplKt.a(r0, this.a.a, null);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    L9:
        r2 = null;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
