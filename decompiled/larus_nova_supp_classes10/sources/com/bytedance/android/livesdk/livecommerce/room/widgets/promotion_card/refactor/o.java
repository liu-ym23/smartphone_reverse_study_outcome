package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.s0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements Runnable {
    public final /* synthetic */ ECUIPromotion a;
    public final /* synthetic */ RoomContextController b;
    public final /* synthetic */ Map c;

    public o(ECUIPromotion r1, RoomContextController r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r0 = this.a.liveRoomType;     // Catch: Throwable -> L11
        if (r0 != 1) goto L6;
        String r1 = "anchor_insurance";
    L9:
        s0 r2 = new s0(r1, this.b);     // Catch: Throwable -> L11
        r2.m(this.c);     // Catch: Throwable -> L11
        r2.k();     // Catch: Throwable -> L11
        return;
    L6:
        if (r0 != 2) goto L8;
        r1 = "save_insurance";
        goto L9
    L8:
        r1 = "error_insurance";
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L15;
        return;
    L15:
        throw th;
    }
}
