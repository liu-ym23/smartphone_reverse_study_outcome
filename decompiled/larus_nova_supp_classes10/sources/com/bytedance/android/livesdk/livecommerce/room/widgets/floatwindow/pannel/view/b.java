package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.event.a2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ lk2.b b;
    public final /* synthetic */ boolean c;

    public b(a r1, lk2.b r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        a2 r0 = new a2();
        LiveRoomParams r1 = this.a.h;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getAuthorId();
    L6:
        r0.f("anchor_id", r3);
        r0.f("product_id", this.b.d);
        r0.f("commodity_id", this.b.e);
        r0.f("commodity_type", this.b.f);
        LiveRoomParams r4 = this.a.h;
        if (r4 == null) goto L9;
        r2 = r4.getRoomId();
    L9:
        r0.f("room_id", r2);
        if (this.c == false) goto L12;
        String r5 = "expand";
    L13:
        r0.f("click_type", r5);
        r0.g(this.b.c);
        r0.k();
        return;
    L12:
        r5 = "close";
        goto L13
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
