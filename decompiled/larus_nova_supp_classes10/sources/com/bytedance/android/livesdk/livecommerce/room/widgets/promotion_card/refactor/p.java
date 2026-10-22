package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.i1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Runnable {
    public final /* synthetic */ ECUIPromotion a;
    public final /* synthetic */ RoomContextController b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public p(ECUIPromotion r1, RoomContextController r2, Map r3, Map r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        i1 r0 = new i1(this.a, this.b);
        r0.g(this.c);
        String r1 = String.valueOf(this.b.v());
        r0.c.c("is_preview", r1);
        r0.m(this.d);
        r0.l(this.e, this.f);
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
