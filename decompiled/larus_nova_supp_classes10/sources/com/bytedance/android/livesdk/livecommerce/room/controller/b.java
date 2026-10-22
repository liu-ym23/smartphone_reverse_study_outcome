package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final boolean a(com.bytedance.android.ec.adapter.api.state.a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isRoomVisibleWithAB");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FIX_CURRENT_WHEN_VISIBLE().booleanValue() == true) goto L7;
        return true;
    L7:
        return ((Boolean) r1.x.invoke()).booleanValue();
    }
}
