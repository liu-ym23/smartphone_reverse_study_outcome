package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements cf.t {
    public final /* synthetic */ LiveRoomParams a;
    public final /* synthetic */ JSONObject b;

    public final JSONObject c() {
        JSONObject r0 = new JSONObject();
        r0.put("_param_live_platform", "live");
        LiveRoomParams r1 = this.a;
        String r3 = null;
        if (r1 == null) goto L5;
        String r2 = r1.getFollowStatus();
    L6:
        r0.put("follow_status", r2);
        JSONObject r4 = this.b;
        if (r4 == null) goto L9;
        r3 = r4.toString();
    L9:
        r0.put("entrance_info", r3);
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.put("enter_from", "live");
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public final void a(q83.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r2);
    }

    public final void b(q83.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(r2);
    }

    public d(LiveRoomParams r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
