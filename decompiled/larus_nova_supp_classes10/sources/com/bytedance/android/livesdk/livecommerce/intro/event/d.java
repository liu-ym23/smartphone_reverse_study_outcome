package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ IntroCardEventCenter a;
    public final /* synthetic */ RoomContextController b;

    public static final class a implements Runnable {
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g a;
        public final /* synthetic */ d b;

        public a(com.bytedance.android.ec.common.api.jump.model.g r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            v r0 = new v("livesdk_popup_card_close", this.a);
            d r1 = this.b;
            IntroCardEventCenter r2 = r1.a;
            RoomContextController r3 = r1.b;
            r2.getClass();
            boolean r4 = true;
            if (r3 != null) goto L5;
        L12:
            if (r4 == false) goto L14;
            String r5 = BDLocationException.ERROR_TIMEOUT;
        L15:
            r0.c("screen_type", r5);
            com.bytedance.android.livesdk.livecommerce.intro.event.a r6 = this.b.a.a;
            if (r6 == null) goto L18;
            r6.d();
            String r7 = "a1128.b3295.c59667.d83267";
        L19:
            r0.i(r7);
            return;
        L18:
            r7 = null;
            goto L19
        L14:
            r5 = "1";
            goto L15
        L5:
            if (r3.x() != true) goto L12;
            com.bytedance.android.ec.adapter.api.state.a r8 = r3.L();
            if (r8 == null) goto L12;
            if (r8.d == true) goto L12;
            r4 = false;
            goto L12
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

    public d(IntroCardEventCenter r1, RoomContextController r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        com.bytedance.android.ec.common.api.jump.model.g r0 = IntroCardEventCenter.c(this.a);
        if (r0 == null) goto L11;
        ql.a r1 = r0.a;
        if ((r1 instanceof IntroPromotionVO) == true) goto L7;
        r1 = null;
    L7:
        IntroPromotionVO r2 = (IntroPromotionVO) r1;
        if (r2 == null) goto L12;
        oh.a.c("closePopupCardEvent", new a(r0, this));
        xh.c.a("Live").d("explain_card", "explain_card_close", MapsKt.mapOf(TuplesKt.to("promotion_id", r2.getPromotionId())));
        return;
    L12:
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
