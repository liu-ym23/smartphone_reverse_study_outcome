package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.v0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ ECUIPromotionV2 c;

    public r(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, ECUIPromotionV2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg2.v r0 = new sg2.v("livesdk_click_list_product_bottom", this.b);     // Catch: Throwable -> L10
        v0 r1 = this.c.getExtend();     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        s1 r2 = r1.j();     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        Map r3 = r2.d();     // Catch: Throwable -> L10
    L8:
        r0.d(r3);     // Catch: Throwable -> L10
        PromotionListEventActionImplKt.a(r0, this.a.a, null);     // Catch: Throwable -> L10
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
