package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f1 extends u0 {
    public f1(RoomContextController r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        super(r3, "livesdk_nofilter_comment_show");
        f("room_id", l0.j("room_id", r3));
        f("anchor_id", l0.j("anchor_id", r3));
        f("enter_from_merge", l0.j("enter_from_merge", r3));
        f("enter_method", l0.j("enter_method", r3));
        f("action_type", l0.j("action_type", r3));
    }
}
