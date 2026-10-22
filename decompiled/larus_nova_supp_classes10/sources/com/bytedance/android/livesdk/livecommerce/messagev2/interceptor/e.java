package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends a {
    public e() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        if ((r7 instanceof si2.t) == true) goto L5;
        return false;
    L5:
        RoomContextController r1 = (RoomContextController) b(RoomContextController.class, r7);
        if (r1 == null) goto L20;
        si2.t r3 = (si2.t) r7;
        Intrinsics.checkNotNullParameter(r3, "message");
        int r0 = r3.msgType;
        n1 r5 = null;
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L20;
        if (r1.f == null) goto L15;
        r5 = new n1(null);
    L15:
        r1.f = r5;
        PromotionListController r2 = r1.A().r;
        r2.K();
        com.bytedance.android.livesdk.livecommerce.kmp.b r4 = r2.A().w;
        goto L20
    L17:
        if (r1.f == null) goto L19;
        r5 = new n1(r3.ecomLinkmicRoomIds);
    L19:
        r1.f = r5;
        PromotionListController r6 = r1.A().r;
        r6.I(r6.C());
        com.bytedance.android.livesdk.livecommerce.kmp.b r8 = r6.A().w;
    L20:
        lj2.a r9 = (lj2.a) b(lj2.a.class, r7);
        if (r9 == null) goto L23;
        r9.m((si2.t) r7);
    L23:
        return false;
    }
}
