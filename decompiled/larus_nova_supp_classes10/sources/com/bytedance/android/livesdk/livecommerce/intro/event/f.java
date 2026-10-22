package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;
    public final /* synthetic */ ECHotAtmosphere b;

    public static final class a implements Runnable {
        public final /* synthetic */ IntroPromotionVO a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ f c;

        public a(IntroPromotionVO r1, com.bytedance.android.ec.common.api.jump.model.g r2, f r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            IntroCardEventCenter r0 = this.c.a;
            v r1 = new v("livesdk_show_hot_sale", this.b);
            r1.a("hot_sale_num", this.c.b.getNumInt());
            r1.c("hot_sale_type", this.c.b.getTypeStr());
            r1.c("product_id", this.a.getProductId());
            com.bytedance.android.livesdk.livecommerce.intro.event.a r2 = this.c.a.a;
            if (r2 == null) goto L5;
            r2.a();
            String r3 = "a1128.b3295.c59667.d30609";
        L6:
            r0.d(r1, r3);
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

    public f(IntroCardEventCenter r1, ECHotAtmosphere r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);     // Catch: Throwable -> L11
        if (r0 == null) goto L14;
        ql.a r1 = r0.a;     // Catch: Throwable -> L11
        if ((r1 instanceof IntroPromotionVO) == true) goto L7;
        r1 = null;
    L7:
        IntroPromotionVO r2 = (IntroPromotionVO) r1;     // Catch: Throwable -> L11
        if (r2 == null) goto L18;
        oh.a.c("recordHotAtmosphereEvent", new a(r2, r0, this));     // Catch: Throwable -> L11
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
