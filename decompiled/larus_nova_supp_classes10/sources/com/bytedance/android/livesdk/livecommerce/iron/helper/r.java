package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.response.ECPromotionCheckResponse;
import com.bytedance.android.ec.model.response.UltimateBuy;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements Runnable {
    public final /* synthetic */ PromotionJumpDispatcher a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ ECPromotionCheckResponse f;
    public final /* synthetic */ IOrderSchema g;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g h;
    public final /* synthetic */ sl.g i;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d j;
    public final /* synthetic */ il2.a k;
    public final /* synthetic */ sc3.b l;

    public r(PromotionJumpDispatcher r1, Context r2, String r3, int r4, String r5, ECPromotionCheckResponse r6, IOrderSchema r7, com.bytedance.android.ec.common.api.jump.model.g r8, sl.g r9, com.bytedance.android.btm.api.model.d r10, il2.a r11, sc3.b r12) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }

    public final void a() {
        PromotionJumpDispatcher r0 = this.a;
        Context r1 = this.b;
        String r2 = this.c;
        int r3 = this.d;
        String r4 = this.e;
        ECPromotionCheckResponse r5 = this.f;
        if (r5 == null) goto L7;
        UltimateBuy r6 = r5.getUltimateBuy();
        if (r6 == null) goto L7;
        r6.getType();
    L7:
        IOrderSchema r7 = this.g;
        com.bytedance.android.ec.common.api.jump.model.g r8 = this.h;
        sl.g r9 = this.i;
        sc3.b r10 = null;
        if (r9 == null) goto L10;
        sl.o r11 = r9.e();
    L11:
        com.bytedance.android.btm.api.model.d r12 = this.j;
        il2.a r13 = this.k;
        if (this.d == 1) goto L15;
        r10 = this.l;
    L15:
        PromotionJumpDispatcher.w(r0, r1, r2, r3, r4, r7, r8, r11, r12, r13, r10);
        return;
    L10:
        r11 = null;
        goto L11
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
