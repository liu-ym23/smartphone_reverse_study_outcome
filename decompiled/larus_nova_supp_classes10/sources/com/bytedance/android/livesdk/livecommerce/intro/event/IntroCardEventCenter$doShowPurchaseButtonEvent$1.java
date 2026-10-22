package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.k0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardEventCenter$doShowPurchaseButtonEvent$1 implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;

    public IntroCardEventCenter$doShowPurchaseButtonEvent$1(IntroCardEventCenter r1) {
        this.a = r1;
    }

    public final void a() {
        final com.bytedance.android.ec.common.api.jump.model.g r5 = IntroCardEventCenter.c(this.a);
        if (r5 == null) goto L23;
        ql.a r0 = r5.a;
        if ((r0 instanceof IntroPromotionVO) == true) goto L7;
        r0 = null;
    L7:
        final IntroPromotionVO r3 = (IntroPromotionVO) r0;
        if (r3 == null) goto L24;
        k0 r1 = r3.getPurchase();
        if (r1 == null) goto L14;
        l0 r2 = r1.a();
        if (r2 == null) goto L14;
        s1 r4 = r2.f();
    L15:
        if (r4 == null) goto L17;
        final Map r6 = r4.d();
    L18:
        if (r4 == null) goto L25;
        final String r7 = r4.c();
        if (r7 == null) goto L26;
        this.a.c.c(r7, r3.getPromotionId(), new IntroCardEventCenter$doShowPurchaseButtonEvent$1$$special$$inlined$also$lambda$3(r7, r3, r6, r5, this));
        return;
    L26:
        return;
    L25:
        return;
    L17:
        r6 = null;
    L14:
        r4 = null;
        goto L15
    L24:
        return;
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
