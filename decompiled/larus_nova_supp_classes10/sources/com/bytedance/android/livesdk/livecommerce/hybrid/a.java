package com.bytedance.android.livesdk.livecommerce.hybrid;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r2, RoomContextController r3) {
        JSONObject r0 = new JSONObject();
        r0.put("is_show", r2);
        if (r3.v() == false) goto L5;
        String r4 = r3.B();
    L6:
        r0.put("room_id", r4);
        Unit r5 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.cart.state", r0);
        return;
    L5:
        int r6 = RoomContextController.h;
        r4 = RoomContextController.a.a().B();
        goto L6
    }
}
