package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends ECEventV3 {
    public h(String r2, String r3, RoomContextController r4) {
        Intrinsics.checkNotNullParameter(r2, "apiPath");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "controller");
        super(r4, "livesdk_api_request_success_event");
        f("api_path", r2);
        f("room_id", r3);
    }
}
