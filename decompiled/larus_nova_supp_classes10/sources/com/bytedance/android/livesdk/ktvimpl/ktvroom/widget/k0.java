package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0<T> implements Observer {
    public final /* synthetic */ KtvMvMidiWidget a;

    public k0(KtvMvMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        StateMachine.c.b r9 = (StateMachine.c.b) r8;
        KtvMvMidiWidget r0 = this.a;
        r0.getClass();
        if (r9 == null) goto L97;
        KtvRoomLyricsStateMachineConfig.d r1 = (KtvRoomLyricsStateMachineConfig.d) r9.c;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L14;
        AbsKtvMidiView r10 = r0.c;
        if (r10 == null) goto L10;
        r10.setVisibility(8);
    L10:
        AbsKtvMidiView r11 = r0.c;
        if (r11 == null) goto L88;
        r11.reset();
        return;
    L88:
        return;
    L14:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L22;
        AbsKtvMidiView r12 = r0.c;
        if (r12 == null) goto L18;
        r12.reset();
    L18:
        AbsKtvMidiView r13 = r0.c;
        if (r13 == null) goto L90;
        r13.setVisibility(0);
        return;
    L90:
        return;
    L22:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L27;
        AbsKtvMidiView r14 = r0.c;
        if (r14 == null) goto L92;
        r14.A1();
        return;
    L92:
        return;
    L27:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L94;
        Object r2 = r9.a;
        String r6 = null;
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L48;
        if (r2 == null) goto L47;
        OrderInfo r3 = ((KtvRoomLyricsStateMachineConfig.d.f) r2).b.a.getOrderInfo();
        if (r3 == null) goto L36;
        InteractiveSongUserInfo r4 = r3.getTopUser();
        if (r4 == null) goto L36;
        String r5 = r4.getIdString();
    L37:
        OrderInfo r7 = ((KtvRoomLyricsStateMachineConfig.d.f) r1).b.a.getOrderInfo();
        if (r7 == null) goto L42;
        InteractiveSongUserInfo r15 = r7.getTopUser();
        if (r15 == null) goto L42;
        String r16 = r15.getIdString();
    L44:
        if ((!Intrinsics.areEqual(r5, r16)) == true) goto L48;
        return;
    L42:
        r16 = null;
    L36:
        r5 = null;
        goto L37
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L48:
        AbsKtvMidiView r17 = r0.c;
        if (r17 != null) goto L51;
    L52:
        KtvRoomLyricsStateMachineConfig.d r18 = (KtvRoomLyricsStateMachineConfig.d) r9.c;
        if (r18 == null) goto L55;
        MusicPanel r19 = r18.b();
    L56:
        if (r19 == null) goto L63;
        AbsKtvMidiView r20 = r0.c;
        if (r20 == null) goto L60;
        r20.setVisibility(0);
    L60:
        AbsKtvMidiView r21 = r0.c;
        if (r21 == null) goto L63;
        r21.R5();
    L63:
        KtvRoomLyricsStateMachineConfig.d r22 = (KtvRoomLyricsStateMachineConfig.d) r9.a;
        if ((r22 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L86;
        if (r22 == null) goto L85;
        OrderInfo r23 = ((KtvRoomLyricsStateMachineConfig.d.f) r22).b.a.getOrderInfo();
        if (r23 == null) goto L71;
        InteractiveSongUserInfo r24 = r23.getTopUser();
        if (r24 == null) goto L71;
        String r25 = r24.getIdString();
    L72:
        KtvRoomLyricsStateMachineConfig.d r26 = (KtvRoomLyricsStateMachineConfig.d) r9.c;
        if (r26 == null) goto L83;
        OrderInfo r27 = ((KtvRoomLyricsStateMachineConfig.d.f) r26).b.a.getOrderInfo();
        if (r27 == null) goto L80;
        InteractiveSongUserInfo r28 = r27.getTopUser();
        if (r28 == null) goto L80;
        r6 = r28.getIdString();
    L80:
        if ((!Intrinsics.areEqual(r25, r6)) == true) goto L86;
        return;
    L83:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L71:
        r25 = null;
        goto L72
    L85:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L86:
        r0.wq();
        return;
    L55:
        r19 = null;
        goto L56
    L51:
        if (r17.getVisibility() == 0) goto L63;
    L94:
        return;
    }
}
