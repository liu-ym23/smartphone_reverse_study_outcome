package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectPriority;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "redirect_api_path", description = "直播间重定向", service = {"LiveBase"})
public final class u extends com.bytedance.android.livesdk.livecommerce.ability.d<LiveRoomRedirectInfo> {

    public static final class a {
    }

    static {
    }

    public u() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r17, LiveRoomRedirectInfo r18, Object r19, il2.a r20, com.bytedance.android.livesdk.livecommerce.ability.e r21) {
        LiveRoomRedirectInfo r0 = r18;
        Object r1 = r19;
        String r3 = null;
        if ((r1 instanceof RoomContextController) == true) goto L5;
        r1 = null;
    L5:
        RoomContextController r2 = (RoomContextController) r1;
        if (r2 != null) goto L8;
        int r4 = RoomContextController.h;
        r2 = RoomContextController.a.a();
    L8:
        if (r0 == null) goto L11;
        Map r5 = r0.b;
        if (r5 == null) goto L11;
    L12:
        if (r0 == null) goto L14;
        r3 = r0.a;
    L14:
        String r6 = r3;
        if (r0 == null) goto L18;
        LiveRoomRedirectPriority r7 = r0.c;
        if (r7 == null) goto L18;
    L19:
        LiveRoomRedirectPriority r8 = r7;
        if (r0 == null) goto L22;
        long r9 = r0.d;
    L23:
        LiveRoomRedirectInfo r10 = r2.g;
        if (r10 == null) goto L26;
        long r11 = r10.d;
    L27:
        LiveRoomRedirectInfo r12 = r2.g;
        if (r12 == null) goto L31;
        LiveRoomRedirectPriority r13 = r12.c;
        if (r13 == null) goto L31;
    L32:
        dm.a.a("LiveRedirectAbility").a("current: " + r2.g + " params: " + r0);
        if (r8.compareTo(r13) >= 0) goto L36;
        dm.a.a("LiveRedirectAbility").i("current: " + r2.g + " params: " + r0 + " priority < currPriority");
        return;
    L36:
        if (r9 > 0) goto L38;
    L40:
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r8, "priority");
        r2.g = new LiveRoomRedirectInfo(r6, MapsKt.toMap(r5), r8, 0);
    L41:
        if (r21 == null) goto L45;
        r21.onSuccess();
        return;
    L45:
        return;
    L38:
        if (r9 <= r11) goto L40;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r8, "priority");
        r2.g = new LiveRoomRedirectInfo(r6, MapsKt.toMap(r5), r8, r9);
    L31:
        r13 = LiveRoomRedirectPriority.UNDEFINED;
        goto L32
    L26:
        r11 = 0;
        goto L27
    L22:
        r9 = 0;
    L18:
        r7 = LiveRoomRedirectPriority.UNDEFINED;
    L11:
        r5 = new LinkedHashMap();
        goto L12
    }
}
