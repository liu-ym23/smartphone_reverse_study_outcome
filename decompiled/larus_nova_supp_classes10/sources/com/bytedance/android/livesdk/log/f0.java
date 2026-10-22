package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0 implements ce1.d {
    public f0() {
    }

    public final void b() {
    }

    public final String c() {
        return jc1.k.n(IInteractService.class).getCurrentFunctionType();
    }

    public final boolean isEnableSwitchLandscape() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isLiveEnableSwitchLandscape();
    }

    public final String a() {
        if (PadConfigUtils.a() == false) goto L5;
        return "1";
    L5:
        return BDLocationException.ERROR_TIMEOUT;
    }

    public final boolean e() {
        return e5.n();
    }

    public final String d(LiveMode r2) {
        Intrinsics.checkNotNullParameter(r2, "streamType");
        int r0 = h1.a;
        return i1.a(r2);
    }

    public final void f(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        if (r3 == null) goto L12;
        Long r5 = StringsKt.toLongOrNull(r3);
        if (r5 == null) goto L13;
        ILivePlayerClient r6 = LivePlatformPlayerManager.c(r5.longValue(), false).player();
        if (r6 == null) goto L14;
        ILivePlayerExtraRenderController r7 = r6.extraRenderController();
        if (r7 == null) goto L15;
        r7.putSjbUgcExtraRenderParams(r4);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
