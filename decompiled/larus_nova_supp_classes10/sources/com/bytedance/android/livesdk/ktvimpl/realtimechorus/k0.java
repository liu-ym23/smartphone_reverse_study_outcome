package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public final boolean c() {
        return !this.a.O;
    }

    public k0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "valid");
        RealTimeChorusMainViewWidget r0 = this.a;
        int r1 = RealTimeChorusMainViewWidget.Q2;
        r0.Kq(r3);
    }
}
