package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "transition");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void b(KtvRoomLyricsStateMachineConfig.b r2) {
        Intrinsics.checkNotNullParameter(r2, "sideEffect");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public boolean c() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void d(KtvRoomLyricsStateMachineConfig.d r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "curstate");
        Intrinsics.checkNotNullParameter(r3, "ktvCoreDataModel");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public void e(long r1) {
    }
}
