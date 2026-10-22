package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.v0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
    public final /* synthetic */ ECUIPromotionV2 d;

    public s(PromotionListEventActionImplV2 r1, String r2, com.bytedance.android.ec.common.api.jump.model.g r3, ECUIPromotionV2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        sg2.v r0 = new sg2.v(this.b, this.c);
        v0 r1 = this.d.getExtend();
        String r2 = null;
        if (r1 == null) goto L7;
        s1 r3 = r1.j();
        if (r3 == null) goto L7;
        Map r4 = r3.d();
    L8:
        r0.d(r4);
        com.bytedance.android.livesdk.livecommerce.promotion.card.e r5 = this.a.a;
        v0 r6 = this.d.getExtend();
        if (r6 == null) goto L11;
        r2 = r6.d();
    L11:
        PromotionListEventActionImplKt.a(r0, r5, r2);
        return;
    L7:
        r4 = null;
        goto L8
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
