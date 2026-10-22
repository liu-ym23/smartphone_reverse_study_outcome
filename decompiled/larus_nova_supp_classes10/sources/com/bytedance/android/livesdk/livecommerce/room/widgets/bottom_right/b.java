package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ef.c {
    public final /* synthetic */ BottomRightCardManager a;

    public final void a() {
    }

    public final BottomRightCardManager.b getRootView() {
        return this.a.f;
    }

    public b(BottomRightCardManager r1) {
        this.a = r1;
    }

    public final void b(boolean r3) {
        if (this.a.r.v() == false) goto L9;
        ECContext r0 = this.a.r.r();
        if (r0 == null) goto L19;
        m<Boolean> r1 = r0.isBottomCardVisible();
        if (r1 == null) goto L20;
        r1.setValue(Boolean.valueOf(r3));
        return;
    L20:
        return;
    L19:
        return;
    L9:
        BottomRightCardManager r2 = this.a;
        RoomContextController r4 = r2.r;
        ml.b r5 = r2.p;
        if (r5 == null) goto L12;
        String r6 = r5.roomId();
    L13:
        ECContext r7 = ControllerExtensionsKt.c(r4, r6).r();
        if (r7 == null) goto L22;
        m<Boolean> r8 = r7.isBottomCardVisible();
        if (r8 == null) goto L23;
        r8.setValue(Boolean.valueOf(r3));
        return;
    L23:
        return;
    L22:
        return;
    L12:
        r6 = null;
        goto L13
    }
}
