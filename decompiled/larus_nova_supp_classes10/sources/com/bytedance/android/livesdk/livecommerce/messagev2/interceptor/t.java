package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RoomTagOfflineInfo;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t extends a {
    public RoomContextController e;
    public final RealRoomController f;

    public t(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(true);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if ((r4 instanceof si2.v) == true) goto L5;
        return false;
    L5:
        si2.v r5 = (si2.v) r4;
        if (r5.msgType != 3) goto L23;
        RoomContextController r0 = this.e;
        if (r0 != null) goto L11;
        return true;
    L11:
        if (r0.s() == true) goto L27;
        ECV2RoomTagOfflineInfo r1 = r5.roomTagOfflineInfo;
        if (r1 == null) goto L24;
        fh2.a r2 = (fh2.a) b(fh2.a.class, r5);
        if (r2 == null) goto L18;
        r2.X80(r1);
    L18:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o r6 = (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o) b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o.class, r5);
        if (r6 == null) goto L25;
        r6.i(r1);
        return true;
    L25:
        return true;
    L24:
        return true;
    L27:
        return true;
    L23:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        RoomContextController r3 = this.f.m;
    L9:
        this.e = r3;
        return;
    L6:
        if (this.f.l() == false) goto L8;
        r3 = this.f.m;
        goto L9
    L8:
        int r4 = RoomContextController.h;
        r3 = RoomContextController.a.b(r1, this.f.I);
        goto L9
    }
}
