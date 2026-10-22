package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public l(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        sh6.b r12 = (sh6.b) r11;
        KtvComponentUIWidget r0 = this.a;
        String r1 = null;
        if (r12 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r13 = (com.bytedance.android.livesdk.ktvimpl.base.sei.a) sh6.c.b(r12);
    L6:
        TokenCert r2 = KtvComponentUIWidget.y1;
        r0.getClass();
        boolean r3 = r13 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.h;
        if (r3 == false) goto L62;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r4 = r0.m;
        if (r4 == null) goto L18;
        KtvRoomLyricsStateMachineConfig.d r5 = r4.getCurState();
        if (r5 == null) goto L18;
        MusicPanel r6 = r5.b();
        if (r6 == null) goto L18;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L18;
        long r8 = r7.getMId();
    L19:
        Long r9 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.h) r13).i();
        if (r9 == null) goto L25;
        if (r9.longValue() != r8) goto L25;
    L27:
        if (r3 == true) goto L29;
        r13 = null;
    L29:
        com.bytedance.android.livesdk.ktvimpl.base.sei.h r14 = (com.bytedance.android.livesdk.ktvimpl.base.sei.h) r13;
        if (r14 != null) goto L32;
        return;
    L32:
        if (r0.h == false) goto L34;
        return;
    L34:
        if (r0.K == true) goto L36;
        return;
    L36:
        if (r14.d() != true) goto L60;
        r0.h = true;
        View r10 = r0.T.d;
        if (r10 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r10);
    L40:
        r0.U.c(r14);
        KtvComponentUIContext r15 = r0.s;
        if (r15 == null) goto L45;
        MutableLiveData<Boolean> r16 = r15.getSingerScoreOpen();
        if (r16 == null) goto L45;
        r16.setValue(Boolean.FALSE);
    L45:
        r0.qr();
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n().toString(), r14.k()) == false) goto L48;
        String r17 = "oneself";
    L49:
        Long r18 = KtvLoggerHelper.a;
        int r19 = (int) r14.g();
        String r20 = r14.k();
        if (r14.l() == false) goto L52;
        r1 = "mark";
    L52:
        KtvLoggerHelper.g0(r19, r20, r17, r1);
        KtvComponentMidiViewModel r21 = r0.N;
        if (r21 == null) goto L61;
        r21.startFeedBackShowTimer(r14.i());
        return;
    L61:
        return;
    L48:
        r17 = "others";
        goto L49
    L60:
        return;
    L25:
        if (r8 == 0) goto L27;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentUIWidget", "onSongFeedbackShow but current song not match");
        return;
    L18:
        r8 = 0;
        goto L19
    L62:
        return;
    L5:
        r13 = null;
        goto L6
    }
}
