package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ int c;

    public m(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg2.v r0 = new sg2.v("livesdk_product_apply_explain_show", this.b);     // Catch: Throwable -> L4
        r0.a("explain_apply_type", this.c);     // Catch: Throwable -> L4
        PromotionListEventActionImplKt.a(r0, this.a.a, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
