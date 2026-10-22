package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ RoomContextController c;
    public final /* synthetic */ boolean d;

    public l(String r1, String r2, RoomContextController r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.livecommerce.event.h r0 = new com.bytedance.android.livesdk.livecommerce.event.h(this.a, this.b, this.c);     // Catch: Throwable -> L4
        r0.d("has_promotion", this.d ? 1 : 0);     // Catch: Throwable -> L4
        r0.f("is_ecom_new", "1");     // Catch: Throwable -> L4
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
