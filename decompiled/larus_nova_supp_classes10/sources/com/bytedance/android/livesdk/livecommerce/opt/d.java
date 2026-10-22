package com.bytedance.android.livesdk.livecommerce.opt;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, String r4, Long r5, LiveRoomParams r6) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L7;
        if (r6 != null) goto L11;
        r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L11:
        v r7 = new v("ec_live_client_ai_preload_promotion_list", r6);
        r7.c("stage", r3);
        if (r5 == null) goto L14;
        long r8 = r5.longValue();
    L15:
        r7.b("api_duration", r8);
        r7.i(null);
        return;
    L14:
        r8 = -1;
        goto L15
    L7:
        int r9 = RoomContextController.h;
        r6 = RoomContextController.a.b(r4, null).l();
        if (r6 != null) goto L11;
        r6 = com.bytedance.android.ec.common.api.jump.model.b.a;
        goto L11
    }
}
