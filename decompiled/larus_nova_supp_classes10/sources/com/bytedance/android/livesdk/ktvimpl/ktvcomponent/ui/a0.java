package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public a0(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        KtvComponentUIWidget r0 = this.a;
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        TokenCert r1 = KtvComponentUIWidget.y1;
        if (r6 == false) goto L43;
        r0.mr();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r7 = r0.m;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = null;
        if (r7 == null) goto L11;
        KtvRoomLyricsStateMachineConfig.d r8 = r7.getCurState();
    L13:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L47;
        KtvComponentUIContext r9 = r0.s;
        if (r9 == null) goto L19;
        MutableLiveData<Boolean> r10 = r9.getScoreOpen();
        if (r10 == null) goto L19;
        Boolean r11 = (Boolean) r10.getValue();
    L20:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r11, r3) == true) goto L30;
        KtvComponentUIContext r12 = r0.s;
        if (r12 == null) goto L27;
        MutableLiveData<Boolean> r13 = r12.getSingerScoreOpen();
        if (r13 == null) goto L27;
        Boolean r14 = (Boolean) r13.getValue();
    L29:
        if (Intrinsics.areEqual(r14, r3) == true) goto L30;
        return;
    L27:
        r14 = null;
    L30:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r15 = r0.m;
        if ((r15 instanceof BaseCoreViewModel) == false) goto L34;
        r2 = r15;
    L34:
        BaseCoreViewModel r16 = (BaseCoreViewModel) r2;
        if (r16 == null) goto L49;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r17 = r16.getCurrentTransition();
        if (r17 == null) goto L50;
        KtvRoomLyricsStateMachineConfig.d r18 = (KtvRoomLyricsStateMachineConfig.d) r17.c;
        if (r18 == null) goto L51;
        MusicPanel r19 = r18.b();
        if (r19 == null) goto L52;
        r0.Gq(r19);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L19:
        r11 = null;
        goto L20
    L47:
        return;
    L11:
        r8 = null;
        goto L13
    L43:
        r0.Qq();
        com.bytedance.android.live.ktv.common.util.c r20 = r0.T.l;
        if (r20 == null) goto L54;
        r20.setVisibility(8);
        return;
    L54:
        return;
    L5:
        r6 = true;
        goto L6
    }
}
