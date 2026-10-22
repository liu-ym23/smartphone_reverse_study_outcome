package fk2;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b a;
    public Long b;
    public final boolean c;
    public final LiveRoomParams d;

    public a(LiveRoomParams r2) {
        Intrinsics.checkNotNullParameter(r2, "liveRoomParams");
        this.d = r2;
        this.c = EComABUtils.enableExplainCardMonitor();
    }

    public final void a(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        v r0 = new v("livesdk_pop_msg_receive", this.d);
        jf.b.g r1 = jf.b.g.b;
        r0.c("ecom_entrance_form", "live_popup_card");
        long r2 = System.currentTimeMillis();
        if (r11 == false) goto L5;
        String r12 = "1";
    L6:
        r0.c("ignore", r12);
        int r13 = r10.a;
        if (r13 == 0) goto L11;
        if (r13 != 1) goto L12;
        r0.c("msg_type", "disappear");
    L12:
        r0.b("promotion_id", r10.c);
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r14 = this.a;
        if (r14 == null) goto L23;
        int r5 = r14.a;
        if (r5 == 0) goto L19;
        if (r5 != 1) goto L20;
        r0.c("last_msg_type", "disappear");
    L20:
        r0.b("last_promotion_id", r14.c);
        Long r15 = this.b;
        if (r15 == null) goto L23;
        r0.b("msg_interval_time", r2 - r15.longValue());
        goto L23
    L19:
        r0.c("last_msg_type", "appear");
    L23:
        this.a = r10;
        this.b = Long.valueOf(r2);
        if (this.c == false) goto L27;
        r0.i(null);
        return;
    L27:
        return;
    L11:
        r0.c("msg_type", "appear");
        goto L12
    L5:
        r12 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public final void b(boolean r2, boolean r3, boolean r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "promotionId");
        if (r2 == true) goto L5;
        return;
    L5:
        if (r6 == false) goto L7;
        String r7 = "related_card";
    L16:
        v r8 = new v("livesdk_popup_card_show", this.d);
        r8.c("from_scene", r7);
        r8.c("promotion_id", r5);
        Unit r9 = Unit.INSTANCE;
        if (this.c == false) goto L20;
        r8.i(null);
        return;
    L20:
        return;
    L7:
        if (r3 == true) goto L9;
        r7 = "enter_room";
        goto L16
    L9:
        if (r3 == false) goto L12;
        if (r4 == true) goto L12;
        r7 = "message";
    L12:
        if (r3 == false) goto L15;
        if (r4 == false) goto L15;
        r7 = "auto_host";
    L15:
        r7 = "";
        goto L16
    }
}
