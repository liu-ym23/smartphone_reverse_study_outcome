package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectPriority;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m extends a {
    public m() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if ((r11 instanceof si2.x) == true) goto L6;
        return false;
    L6:
        Context r1 = getContext();
        si2.x r0 = (si2.x) r11;
        LiveRoomRedirectInfo.a r2 = LiveRoomRedirectInfo.f;
        String r3 = r0.routeRule;
        r2.getClass();
        Map r6 = LiveRoomRedirectInfo.a.a(r3);
        if (r6 != null) goto L10;
        com.bytedance.android.livesdk.livecommerce.ability.f r4 = null;
    L9:
        com.bytedance.android.livesdk.livecommerce.ability.f r5 = r4;
        if (r1 == null) goto L20;
        if (r5 == null) goto L21;
        RoomContextController r7 = (RoomContextController) b(RoomContextController.class, r11);
        Lazy r12 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r1, r5, r7, null, null, 24);
        return true;
    L21:
        return true;
    L20:
        return true;
    L10:
        sg2.b r8 = r0.getCommon();
        if (r8 == null) goto L13;
        long r9 = r8.c;
    L14:
        String r10 = r0.routeRule;
        LiveRoomRedirectPriority r13 = LiveRoomRedirectPriority.LIVE_HIGH_HEAT_MESSAGE;
        r4 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveBase", "redirect_api_path", new LiveRoomRedirectInfo(r10, r6, r13, r9));
        goto L9
    L13:
        r9 = 0;
        goto L14
    }
}
