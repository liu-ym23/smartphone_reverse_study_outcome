package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public v0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.O = false;
        w.a("RealTimeChorusMainViewWidget", "showFeedBackView feedTimeDisposable dispose, onError " + ((Throwable) r3));
        KtvCoreViewModel r4 = this.a.M;
        if (r4 == null) goto L8;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r5 = r4.getCurrentTransition();
        if (r5 == null) goto L9;
        this.a.Kq(r5);
        return;
    L9:
        return;
    }
}
