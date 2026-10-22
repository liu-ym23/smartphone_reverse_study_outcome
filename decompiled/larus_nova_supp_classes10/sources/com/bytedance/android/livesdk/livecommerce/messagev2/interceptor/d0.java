package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0 extends a {
    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    public d0(RealRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        super(true);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if ((r10 instanceof si2.z) == true) goto L5;
        return false;
    L5:
        Context r0 = com.bytedance.android.livesdk.livecommerce.room.f.a();
        si2.z r2 = (si2.z) r10;
        int r3 = r2.msgType;
        if (r3 != 6) goto L8;
    L13:
        sg2.b r11 = r10.getCommon();
        if (r11 == null) goto L16;
        long r4 = r11.c;
    L18:
        if (com.bytedance.android.livesdk.livecommerce.utils.x.a(r0, "ec_update_auction_timestamp") > r4) goto L21;
        com.bytedance.android.livesdk.livecommerce.utils.x.c(r0, "ec_update_auction_timestamp", r4);
    L20:
        boolean r12 = true;
    L22:
        if (r12 == false) goto L36;
        lj2.a r13 = (lj2.a) b(lj2.a.class, r2);
        if (r13 == null) goto L26;
        r13.h(r2);
    L26:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o r14 = (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o) b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o.class, r2);
        if (r14 == null) goto L29;
        r14.h(r2);
    L29:
        jk2.a r15 = (jk2.a) b(jk2.a.class, r2);
        if (r15 == null) goto L32;
        r15.b();
    L32:
        com.bytedance.android.livesdk.livecommerce.intro.message.a r16 = (com.bytedance.android.livesdk.livecommerce.intro.message.a) b(com.bytedance.android.livesdk.livecommerce.intro.message.a.class, r2);
        if (r16 == null) goto L35;
        r16.d(r2);
    L35:
        return true;
    L36:
        return false;
    L21:
        r12 = false;
        goto L22
    L16:
        r4 = 0;
        goto L18
    L8:
        if (r3 == 4) goto L13;
        if (r3 != 5) goto L21;
        goto L21
    }
}
