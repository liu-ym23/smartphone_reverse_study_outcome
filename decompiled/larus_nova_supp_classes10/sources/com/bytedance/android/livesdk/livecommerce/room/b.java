package com.bytedance.android.livesdk.livecommerce.room;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealStartLiveController;
import com.bytedance.android.livesdk.livecommerce.room.controller.s;
import com.bytedance.android.livesdk.livecommerce.room.controller.u;
import com.bytedance.android.livesdk.livecommerce.room.controller.x;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements rd.b, i<rd.a, rd.c> {
    public static final b a = null;

    public b() {
    }

    public final String businessType() {
        return "LiveRoomProviderV1";
    }

    static {
        a = new b();
    }

    public final Object c() {
        return new u(new RealStartLiveController());
    }

    public final rd.c getStartLivePreviewController() {
        Lazy r0 = LiveRoomProvider.a;
        Intrinsics.checkNotNullParameter(this, "factory");
        Object r1 = LiveRoomProvider.f;
        if (r1 != null) goto L6;
        r1 = c();
        LiveRoomProvider.f = r1;
    L6:
        return (rd.c) r1;
    }

    public final void substituteClearLiveRoomController(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
        Lazy r2 = LiveRoomProvider.a;
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
    }

    public final rd.a a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        Intrinsics.checkNotNullParameter(r5, "env");
        LiveRoomProvider.ECProviderSource r0 = LiveRoomProvider.ECProviderSource.PREVIEW;
        if (Intrinsics.areEqual(r5, r0.name()) == true) goto L6;
        r0 = LiveRoomProvider.ECProviderSource.DEFAULT;
    L6:
        Lazy r6 = LiveRoomProvider.a;
        return (rd.a) LiveRoomProvider.d(r3, r4, r0, this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.i
    public final rd.a b(String r4, String r5, LiveRoomProvider.ECProviderSource r6) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "uniqueKey");
        Intrinsics.checkNotNullParameter(r6, "env");
        if (r6 == LiveRoomProvider.ECProviderSource.PREVIEW) goto L5;
    L7:
        com.bytedance.android.livesdk.livecommerce.room.api.b r0 = new RealRoomController(r4, r5, r6, false);
    L9:
        return new s(new com.bytedance.android.livesdk.livecommerce.room.api.i(r4, r5, r6), r0);
    L5:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FORBID_PREVIEW_CONTROLLER() == false) goto L7;
        r0 = new x(r4, r5, r6);
        goto L9
    }
}
