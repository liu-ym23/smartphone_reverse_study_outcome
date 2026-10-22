package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final boolean a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isTransition");
        if (Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r2.a).getClass(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).getClass()) == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r2.a).getClass().getClassLoader(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).getClass().getClassLoader()) == false) goto L8;
        return false;
    }
}
