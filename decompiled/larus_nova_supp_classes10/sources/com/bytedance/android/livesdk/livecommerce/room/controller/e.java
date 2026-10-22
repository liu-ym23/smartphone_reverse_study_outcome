package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.event.ECEventV3;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends ECEventV3 {
    public e() {
        super("ec_controller_timeline");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final void k() {
        LiveRoomProvider r0 = LiveRoomProvider.h;
        f("c_cache_snapshot", LiveRoomProvider.a());
        f("c_provider_snapshot", r0.f());
        f("c_process_snapshot", LiveRoomProvider.e());
        int r1 = m0.a;
        GsonProtectorUtils.toJson(m0.a.a, this.c.a);
    }
}
