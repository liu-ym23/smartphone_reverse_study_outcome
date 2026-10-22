package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        StateMachine.c.b r3 = (StateMachine.c.b) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.f.a(r3) != true) goto L15;
        i r4 = this.a;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = r4.d;
        if (r0 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
    L11:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L16;
        KtvContext.Companion.getClass();
        r4.b(KtvContext.a.g().isCurrentUserIsSinger());
        return;
    L16:
        return;
    L9:
        r1 = null;
        goto L11
    }
}
