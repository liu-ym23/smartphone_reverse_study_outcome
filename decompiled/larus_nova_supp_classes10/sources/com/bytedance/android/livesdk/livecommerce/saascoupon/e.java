package com.bytedance.android.livesdk.livecommerce.saascoupon;

import android.content.Context;
import bl2.g;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import el2.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public final /* synthetic */ k a;
    public final /* synthetic */ SaasCouponService b;
    public final /* synthetic */ g c;
    public final /* synthetic */ el.b d;

    public e(k r1, SaasCouponService r2, g r3, el.b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a a(Context r15, int r16, String r17, BottomRightAnimController r18, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.b r19, ef.a r20) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r18, "animController");
        Intrinsics.checkNotNullParameter(r19, "viewProvider");
        Intrinsics.checkNotNullParameter(r20, "cardManager");
        g r4 = this.c;
        el.b r5 = this.d;
        k r9 = this.a;
        gf.a r10 = new gf.a(r16);
        Function0<LiveRoomParams> r2 = this.b.o;
        if (r2 == null) goto L5;
        LiveRoomParams r3 = (LiveRoomParams) r2.invoke();
    L6:
        com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a r1 = new com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a(r15, r4, r5, r17, r18, r19, r9, r10, r3, ((Boolean) this.b.n.getValue()).booleanValue(), r20);
        this.b.l = r1;
        return r1;
    L5:
        r3 = null;
        goto L6
    }
}
