package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;

    public static final class a implements Runnable {
        public final /* synthetic */ IntroNumAtmosphere a;
        public final /* synthetic */ IntroPromotionVO b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ e d;

        public a(IntroNumAtmosphere r1, IntroPromotionVO r2, com.bytedance.android.ec.common.api.jump.model.g r3, e r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            IntroCardEventCenter r0 = this.d.a;
            v r1 = new v("livesdk_show_hot_sale", this.c);
            IntroNumAtmosphere r2 = this.a;
            String r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.c();
        L6:
            r1.c("hot_sale_num", r4);
            IntroAtmosphere r5 = this.b.getIntroAtmosphere();
            if (r5 == null) goto L9;
            Integer r6 = Integer.valueOf(r5.a());
        L10:
            r1.c("hot_sale_type", String.valueOf(r6));
            r1.c("product_id", this.b.getProductId());
            com.bytedance.android.livesdk.livecommerce.intro.event.a r7 = this.d.a.a;
            if (r7 == null) goto L13;
            r7.a();
            r3 = "a1128.b3295.c59667.d30609";
        L13:
            r0.d(r1, r3);
            return;
        L9:
            r6 = null;
            goto L10
        L5:
            r4 = null;
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

    public e(IntroCardEventCenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);     // Catch: Throwable -> L14
        if (r0 == null) goto L17;
        ql.a r1 = r0.a;     // Catch: Throwable -> L14
        IntroNumAtmosphere r3 = null;
        if ((r1 instanceof IntroPromotionVO) == true) goto L7;
        r1 = null;
    L7:
        IntroPromotionVO r2 = (IntroPromotionVO) r1;     // Catch: Throwable -> L14
        if (r2 == null) goto L21;
        IntroAtmosphere r4 = r2.getIntroAtmosphere();     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        r3 = r4.d();     // Catch: Throwable -> L14
    L12:
        oh.a.c("recordHotAtmosphereEvent", new a(r3, r2, r0, this));     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L17:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
