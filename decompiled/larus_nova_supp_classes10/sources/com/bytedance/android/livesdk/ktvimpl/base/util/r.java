package com.bytedance.android.livesdk.ktvimpl.base.util;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r {
    public Long a;
    public final String b;

    public r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "currentUid");
        this.b = r2;
    }

    public static void a(StateMachine.c.b r3) {
        Intrinsics.checkNotNullParameter(r3, "transition");
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.c) == true) goto L6;
        return;
    L6:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L14;
        KtvRoomLyricsStateMachineConfig.d r1 = (KtvRoomLyricsStateMachineConfig.d) r3.a;
        if ((r3.b instanceof KtvRoomLyricsStateMachineConfig.a.i) == true) goto L10;
    L12:
        pd2.d.M(pd2.d.n, ((KtvRoomLyricsStateMachineConfig.d.c) r0).b, LBSLightLocationTraceLogger.PREPARE);
        return;
    L10:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L12;
        pd2.d.M(pd2.d.n, ((KtvRoomLyricsStateMachineConfig.d.e) r1).b, "sing_cut");
        goto L12
    L14:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L18;
        pd2.d.M(pd2.d.n, ((KtvRoomLyricsStateMachineConfig.d.c) r0).b, "start_sing");
        return;
    }
}
