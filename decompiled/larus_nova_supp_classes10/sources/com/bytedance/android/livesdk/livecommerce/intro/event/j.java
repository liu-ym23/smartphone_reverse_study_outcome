package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b a;
    public Long b;
    public final boolean c;
    public final LiveRoomParams d;

    public j(LiveRoomParams r2) {
        Intrinsics.checkNotNullParameter(r2, "liveRoomParams");
        this.d = r2;
        this.c = EComABUtils.enableExplainCardMonitor();
    }
}
