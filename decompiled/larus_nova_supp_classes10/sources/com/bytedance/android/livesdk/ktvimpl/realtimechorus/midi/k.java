package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ RealTimeChorusMidiWidget a;

    public k(RealTimeChorusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        StateMachine.c.b r5 = (StateMachine.c.b) r4;
        RealTimeChorusMidiWidget r0 = this.a;
        int r1 = RealTimeChorusMidiWidget.p;
        r0.getClass();
        if (r5 == null) goto L48;
        w.a("RealTimeChorusMidiWidget", "handleState " + ((KtvRoomLyricsStateMachineConfig.d) r5.c));
        KtvRoomLyricsStateMachineConfig.d r2 = (KtvRoomLyricsStateMachineConfig.d) r5.c;
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L11;
        KtvComponentMidiView r6 = r0.c;
        if (r6 == null) goto L39;
        r6.reset();
        return;
    L39:
        return;
    L11:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L16;
        KtvComponentMidiView r7 = r0.c;
        if (r7 == null) goto L41;
        r7.reset();
        return;
    L41:
        return;
    L16:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L21;
        KtvComponentMidiView r8 = r0.c;
        if (r8 == null) goto L43;
        r8.A1();
        return;
    L43:
        return;
    L21:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L45;
        Object r9 = r5.a;
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L46;
        if (r9 == null) goto L38;
        OrderInfo r10 = ((KtvRoomLyricsStateMachineConfig.d.f) r9).b.a.getOrderInfo();
        String r3 = null;
        if (r10 == null) goto L30;
        InteractiveSongUserInfo r11 = r10.getTopUser();
        if (r11 == null) goto L30;
        String r12 = r11.getIdString();
    L31:
        OrderInfo r13 = ((KtvRoomLyricsStateMachineConfig.d.f) r2).b.a.getOrderInfo();
        if (r13 == null) goto L36;
        InteractiveSongUserInfo r14 = r13.getTopUser();
        if (r14 == null) goto L36;
        r3 = r14.getIdString();
    L36:
        Intrinsics.areEqual(r12, r3);
        return;
    L30:
        r12 = null;
        goto L31
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L46:
        return;
    L45:
        return;
    }
}
