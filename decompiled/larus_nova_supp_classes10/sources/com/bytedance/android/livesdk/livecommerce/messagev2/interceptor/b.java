package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends a {
    public EntryController e;
    public final RealRoomController f;

    public b(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(false);
        this.f = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        boolean r0 = r7 instanceof si2.a0;
        if (r0 == true) goto L5;
        sg2.a r2 = null;
    L6:
        si2.a0 r3 = (si2.a0) r2;
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r0 == true) goto L14;
        sg2.a r1 = null;
    L15:
        si2.a0 r5 = (si2.a0) r1;
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L22:
        if ((r7 instanceof si2.v) == true) goto L24;
        r7 = null;
    L24:
        si2.v r8 = (si2.v) r7;
        if (r8 != null) goto L27;
    L29:
        boolean r9 = false;
    L30:
        EntryController r10 = this.e;
        if (r10 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("entryController");
    L34:
        if (r10.L == true) goto L40;
        if (r4 == true) goto L38;
        if (r6 == true) goto L38;
        if (r9 == true) goto L38;
        return false;
    L38:
        return true;
    L40:
        return false;
    L27:
        if (r8.msgType != 1) goto L29;
        r9 = true;
        goto L30
    L18:
        if (r5.msgType != 2) goto L20;
        r6 = true;
        goto L22
    L14:
        r1 = r7;
        goto L15
    L9:
        if (r3.msgType != 0) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = r7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L6;
        EntryController r3 = this.f.t;
    L9:
        this.e = r3;
        return;
    L6:
        if (this.f.l() == false) goto L8;
        r3 = this.f.t;
        goto L9
    L8:
        boolean r4 = EntryController.M1;
        r3 = EntryController.a.b(r1, this.f.I);
        goto L9
    }
}
