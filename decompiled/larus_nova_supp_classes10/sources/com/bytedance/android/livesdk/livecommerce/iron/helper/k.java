package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.model.response.ECPromotionCheckResponse;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements Runnable {
    public final /* synthetic */ PromotionJumpDispatcher.c a;
    public final /* synthetic */ ECPromotionCheckResponse b;

    public k(PromotionJumpDispatcher.c r1, ECPromotionCheckResponse r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("livesdk_check_promotion_toast", this.a.e);
        ECPromotionCheckResponse r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = String.valueOf(((com.bytedance.android.ec.model.g) r1).statusCode);
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.c("status_code", r3);
        com.bytedance.android.btm.api.model.d r4 = this.a.f;
        if (r4 == null) goto L11;
        r2 = r4.a;
    L11:
        r0.i(r2);
        return;
    L5:
        r3 = null;
        goto L6
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
