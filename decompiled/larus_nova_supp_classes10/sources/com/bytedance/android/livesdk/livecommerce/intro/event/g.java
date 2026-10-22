package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g a;
        public final /* synthetic */ g b;

        public a(com.bytedance.android.ec.common.api.jump.model.g r1, g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            v r0 = new v("livesdk_ecom_product_introduce", this.a);     // Catch: Throwable -> L9
            com.bytedance.android.livesdk.livecommerce.intro.event.a r1 = this.b.a.a;     // Catch: Throwable -> L9
            if (r1 == null) goto L6;
            r1.a();     // Catch: Throwable -> L9
            String r2 = "a1128.b3295.c59667.d30609";
        L7:
            r0.i(r2);     // Catch: Throwable -> L9
            return;
        L6:
            r2 = null;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public g(IntroCardEventCenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);     // Catch: Throwable -> L11
        if (r0 == null) goto L14;
        ql.a r1 = r0.a;     // Catch: Throwable -> L11
        if ((r1 instanceof IntroPromotionVO) == true) goto L8;
        r1 = null;
    L8:
        if (((IntroPromotionVO) r1) == null) goto L18;
        oh.a.c("showDurationEvent", new a(r0, this));     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
