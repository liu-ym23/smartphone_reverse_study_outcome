package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.livesdk.livecommerce.event.q1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ RoomContextController a;
    public final /* synthetic */ String b;

    public m(RoomContextController r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q1 r0 = new q1(this.a);     // Catch: Throwable -> L4
        r0.f("product_id", this.b);     // Catch: Throwable -> L4
        r0.f("status", "in");     // Catch: Throwable -> L4
        r0.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
