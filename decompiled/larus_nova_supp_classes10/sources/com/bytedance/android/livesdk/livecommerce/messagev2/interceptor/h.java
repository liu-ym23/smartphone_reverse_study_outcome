package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends a {
    public com.bytedance.android.livesdk.livecommerce.room.api.c e;

    public h() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r12) {
        Intrinsics.checkNotNullParameter(r12, "message");
        if ((r12 instanceof si2.z) == true) goto L5;
        return false;
    L5:
        si2.z r13 = (si2.z) r12;
        int r3 = r13.msgType;
        if (r3 != 2) goto L8;
    L11:
        ECV2CouponInfo r14 = r13.couponInfo;
        com.bytedance.android.livesdk.livecommerce.room.api.c r2 = this.e;
        if (r2 == null) goto L26;
        long r4 = 0;
        if (r14 == null) goto L16;
        long r6 = r14.serverTime;
    L17:
        if (r14 == null) goto L19;
        String r0 = r14.activity;
    L20:
        if (r14 == null) goto L22;
        int r8 = r14.couponType;
    L23:
        if (r14 == null) goto L25;
        r4 = r14.metaId;
    L25:
        r2.onCouponMessage(r3, r6, r0, r8, r4);
        goto L26
    L22:
        r8 = 0;
        goto L23
    L19:
        r0 = null;
        goto L20
    L16:
        r6 = 0;
    L26:
        return false;
    L8:
        if (r3 == 1) goto L11;
        if (r3 != 3) goto L26;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        this.e = (com.bytedance.android.livesdk.livecommerce.room.api.c) b(com.bytedance.android.livesdk.livecommerce.room.api.c.class, null);
    }
}
