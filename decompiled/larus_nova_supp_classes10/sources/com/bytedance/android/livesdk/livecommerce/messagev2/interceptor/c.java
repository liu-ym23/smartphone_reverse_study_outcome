package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends a {
    public EntryController e;
    public com.bytedance.android.livesdk.livecommerce.room.controller.business.n f;
    public final RealRoomController g;

    public c(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(false);
        this.g = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if ((r6 instanceof si2.a0) == true) goto L5;
        return false;
    L5:
        si2.a0 r7 = (si2.a0) r6;
        boolean r2 = true;
        if (r7.msgType != 0) goto L22;
        if (r7.bubbleType != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L22;
        EntryController r1 = this.e;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("entryController");
    L16:
        if (r1.L == false) goto L22;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r8 = this.f;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L20:
        r8.I(true);
    L32:
        return false;
    L10:
        r0 = false;
    L22:
        if (r7.msgType != 1) goto L32;
        if (r7.bubbleType == 0) goto L27;
        r2 = false;
    L27:
        if (r2 == false) goto L32;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r9 = this.f;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardController");
    L31:
        r9.I(false);
        goto L32
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r2, boolean r3) {
        ECLiveABUtils r4 = ECLiveABUtils.INSTANCE;
        if (r4.getENABLE_CONTROLLER_OPT() == false) goto L6;
        EntryController r0 = this.g.t;
    L9:
        this.e = r0;
        if (r4.getENABLE_CONTROLLER_OPT() == false) goto L13;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r5 = this.g.q;
    L16:
        this.f = r5;
        return;
    L13:
        if (this.g.l() == false) goto L15;
        r5 = this.g.q;
        goto L16
    L15:
        int r6 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        r5 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r2, this.g.I);
        goto L16
    L6:
        if (this.g.l() == false) goto L8;
        r0 = this.g.t;
        goto L9
    L8:
        boolean r1 = EntryController.M1;
        r0 = EntryController.a.b(r2, this.g.I);
        goto L9
    }
}
