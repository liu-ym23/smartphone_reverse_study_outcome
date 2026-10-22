package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w extends c0 {
    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onEnterRoomPrepared() {
        JSONObject r0 = new JSONObject();
        r0.put("anchorId", y());
        r0.put("roomId", B());
        Lazy r1 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("enter_room", r0);
        int r2 = ECSdk.a;
        b93.c r3 = (b93.c) ECSdk.a(b93.c.class);
        if (r3 == null) goto L8;
        b93.b r4 = r3.b();
        if (r4 == null) goto L9;
        r4.sendEvent("enter_room", r0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        JSONObject r0 = new JSONObject();
        r0.put("anchorId", y());
        r0.put("roomId", B());
        Lazy r1 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("exit_room", r0);
        int r2 = ECSdk.a;
        b93.c r3 = (b93.c) ECSdk.a(b93.c.class);
        if (r3 == null) goto L8;
        b93.b r4 = r3.b();
        if (r4 == null) goto L9;
        r4.sendEvent("exit_room", r0);
        return;
    L9:
        return;
    }

    public w(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
    }
}
