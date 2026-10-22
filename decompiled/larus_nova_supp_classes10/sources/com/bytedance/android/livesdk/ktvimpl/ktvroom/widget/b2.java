package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b2<T> implements Consumer {
    public final /* synthetic */ KtvStageWidget a;
    public final /* synthetic */ StateMachine.c.b b;

    public b2(KtvStageWidget r1, StateMachine.c.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        if (this.b == null) goto L8;
        KtvStageWidget r4 = this.a;
        if (r4.f == true) goto L9;
        r4.f = true;
        r4.y.getKtvStageReadyEvent().post(0);
        ALogger.i("alog_ktv_smooth_enter_room", "removeFeedMockView ;; wait lyric state transition ready time out ;; current state == " + ((KtvRoomLyricsStateMachineConfig.d) this.b.c));
        return;
    L9:
        return;
    }
}
