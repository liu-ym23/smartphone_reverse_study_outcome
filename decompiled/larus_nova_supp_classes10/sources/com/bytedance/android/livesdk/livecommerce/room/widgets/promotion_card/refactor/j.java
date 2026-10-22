package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.livesdk.livecommerce.event.f1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ RoomContextController a;
    public final /* synthetic */ Map b;

    public j(RoomContextController r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f1 r0 = new f1(this.a);     // Catch: Throwable -> L4
        r0.m(this.b);     // Catch: Throwable -> L4
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
