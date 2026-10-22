package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ l a;

    public i(l r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        UserAttr r4 = (UserAttr) r3;
        l r0 = this.a;
        KtvRoomViewModel r1 = r0.u;
        if (r1 == null) goto L7;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r2 = r1.getStateChangeEvent();
        if (r2 == null) goto L7;
        StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r5 = (StateMachine.c.b) r2.getValue();
    L8:
        r0.b(r5);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r6 = r0.w;
        if (r6 == null) goto L12;
        r6.h(r4);
        return;
    L12:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
