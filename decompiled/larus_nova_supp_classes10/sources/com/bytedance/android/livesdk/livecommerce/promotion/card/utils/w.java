package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.v0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ECUIPromotionV2 d;

    public w(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, int r3, ECUIPromotionV2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("livesdk_ecom_gift_bar_show", this.b);
        r0.a("product_cnt", this.c);
        v0 r1 = this.d.getExtend();
        if (r1 == null) goto L9;
        s1 r2 = r1.j();
        if (r2 == null) goto L9;
        Map r3 = r2.d();
        if (r3 == null) goto L9;
        r0.d(r3);
    L9:
        PromotionListEventActionImplKt.a(r0, this.a.a, null);
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
