package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x extends c0 {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    public x(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
    }

    public final void H(String r8, String r9, long r10, String r12) {
        ak2.m r3 = A().t.F;
        if (r3 == null) goto L18;
        if (r9 != null) goto L6;
        r9 = "-1";
    L6:
        JSONObject r4 = new JSONObject();
        r4.put("anchor_id", y());     // Catch: JSONException -> L12
        if (hh2.f.e() == false) goto L10;
        r4.put("anchor_open_id", y());     // Catch: JSONException -> L12
    L10:
        r4.put("room_id", B());     // Catch: JSONException -> L12
        r4.put("commodity_id", r8);     // Catch: JSONException -> L12
        r4.put("commodity_type", r9);     // Catch: JSONException -> L12
        r4.put("commodity_price", r10);     // Catch: JSONException -> L12
        r4.put("enter_from", "live");     // Catch: JSONException -> L12
        r4.put("source_page", r12);     // Catch: JSONException -> L12
        r4.put("action_type", l0.i("action_type"));     // Catch: JSONException -> L12
        r4.put("enter_from_merge", l0.i("enter_from_merge"));     // Catch: JSONException -> L12
        r4.put("enter_method", l0.i("enter_method"));     // Catch: JSONException -> L12
    L14:
        r3.onClickPromotion("live_ad", "click_confirm", "", r4);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
