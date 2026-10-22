package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvMidiSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u0<T> implements Observer {
    public final /* synthetic */ KtvOpusMidiWidget a;

    public u0(KtvOpusMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        StateMachine.c.b r8 = (StateMachine.c.b) r7;
        KtvOpusMidiWidget r0 = this.a;
        r0.getClass();
        if (r8 == null) goto L113;
        KtvRoomLyricsStateMachineConfig.d r1 = (KtvRoomLyricsStateMachineConfig.d) r8.c;
        Object r3 = null;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L24;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r9 = r0.c;
        if (r9 == null) goto L10;
        View r10 = r9.asView();
    L11:
        if (r10 == null) goto L13;
        r10.post(new y0(r10));
    L13:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r11 = r0.c;
        if ((r11 instanceof KtvMidiSurfaceView) == false) goto L17;
        r3 = r11;
    L17:
        KtvMidiSurfaceView r4 = (KtvMidiSurfaceView) r3;
        if (r4 == null) goto L20;
        r4.setBusinessVisible(8);
    L20:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r12 = r0.c;
        if (r12 == null) goto L104;
        r12.reset();
        return;
    L104:
        return;
    L10:
        r10 = null;
        goto L11
    L24:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L41;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r13 = r0.c;
        if (r13 == null) goto L28;
        r13.reset();
    L28:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r14 = r0.c;
        if (r14 == null) goto L33;
        View r15 = r14.asView();
        if (r15 == null) goto L33;
        r15.setVisibility(0);
    L33:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r16 = r0.c;
        if ((r16 instanceof KtvMidiSurfaceView) == false) goto L37;
        r3 = r16;
    L37:
        KtvMidiSurfaceView r5 = (KtvMidiSurfaceView) r3;
        if (r5 == null) goto L106;
        r5.setBusinessVisible(0);
        return;
    L106:
        return;
    L41:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L46;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r17 = r0.c;
        if (r17 == null) goto L108;
        r17.A1();
        return;
    L108:
        return;
    L46:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L110;
        Object r2 = r8.a;
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L67;
        if (r2 == null) goto L66;
        OrderInfo r6 = ((KtvRoomLyricsStateMachineConfig.d.f) r2).b.a.getOrderInfo();
        if (r6 == null) goto L55;
        InteractiveSongUserInfo r18 = r6.getTopUser();
        if (r18 == null) goto L55;
        String r19 = r18.getIdString();
    L56:
        OrderInfo r20 = ((KtvRoomLyricsStateMachineConfig.d.f) r1).b.a.getOrderInfo();
        if (r20 == null) goto L61;
        InteractiveSongUserInfo r21 = r20.getTopUser();
        if (r21 == null) goto L61;
        String r22 = r21.getIdString();
    L63:
        if ((!Intrinsics.areEqual(r19, r22)) == true) goto L67;
        return;
    L61:
        r22 = null;
    L55:
        r19 = null;
        goto L56
    L66:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L67:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r23 = r0.c;
        if (r23 == null) goto L73;
        View r24 = r23.asView();
        if (r24 == null) goto L73;
        if (r24.getVisibility() != 0) goto L73;
    L79:
        KtvRoomLyricsStateMachineConfig.d r25 = (KtvRoomLyricsStateMachineConfig.d) r8.a;
        if ((r25 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L102;
        if (r25 == null) goto L101;
        OrderInfo r26 = ((KtvRoomLyricsStateMachineConfig.d.f) r25).b.a.getOrderInfo();
        if (r26 == null) goto L87;
        InteractiveSongUserInfo r27 = r26.getTopUser();
        if (r27 == null) goto L87;
        String r28 = r27.getIdString();
    L88:
        KtvRoomLyricsStateMachineConfig.d r29 = (KtvRoomLyricsStateMachineConfig.d) r8.c;
        if (r29 == null) goto L99;
        OrderInfo r30 = ((KtvRoomLyricsStateMachineConfig.d.f) r29).b.a.getOrderInfo();
        if (r30 == null) goto L96;
        InteractiveSongUserInfo r31 = r30.getTopUser();
        if (r31 == null) goto L96;
        r3 = r31.getIdString();
    L96:
        if ((!Intrinsics.areEqual(r28, r3)) == true) goto L102;
        return;
    L99:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L87:
        r28 = null;
        goto L88
    L101:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L102:
        r0.xq();
        return;
    L73:
        KtvRoomLyricsStateMachineConfig.d r32 = (KtvRoomLyricsStateMachineConfig.d) r8.c;
        if (r32 == null) goto L76;
        MusicPanel r33 = r32.b();
    L77:
        if (r33 == null) goto L79;
        r0.wq();
        goto L79
    L76:
        r33 = null;
        goto L77
    L110:
        return;
    }
}
