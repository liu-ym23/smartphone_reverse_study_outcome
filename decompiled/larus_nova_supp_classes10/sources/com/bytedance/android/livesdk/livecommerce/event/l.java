package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends u0 {
    public l(String r3, RoomContextController r4) {
        Intrinsics.checkNotNullParameter(r3, "trackName");
        super(r4, "livesdk_" + r3 + "_click");
    }
}
