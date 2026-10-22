package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.midi.KtvComponentProgressView;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.x41;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvListenerLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvRoomLyricHolder;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.LyricComponentListenerPresenter;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.component.lyric.LyricComponentImplManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvComponentUIWidget$mKtvCoreListener$1 extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
    public final /* synthetic */ KtvComponentUIWidget a;

    public KtvComponentUIWidget$mKtvCoreListener$1(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r15) {
        Intrinsics.checkNotNullParameter(r15, "valid");
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r15.c;
        boolean r4 = false;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L41;
        KtvComponentUIWidget r1 = this.a;
        TokenCert r2 = KtvComponentUIWidget.y1;
        r1.getClass();
        ALogger.e(bb0.b.b(), "KtvComponentUIWidget :onKtvStateIdle , invoke class :KtvComponentUIWidget");
        r1.e = false;
        r1.g = false;
        r1.h = false;
        r1.U.f(je2.f.a.a);
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.k<fd2.z> r5 = r3.getKtvComponentSingerUserIdChangedEvent();
        if (r5 == null) goto L9;
        r5.post(new fd2.z(null));
    L9:
        KtvContext r6 = KtvContext.a.g();
        if (r6 == null) goto L14;
        com.bytedance.live.datacontext.n<OrderInfo> r7 = r6.getKtvCurrentSingOrderInfo();
        if (r7 == null) goto L14;
        r7.setValue(null);
    L14:
        KtvComponentCountDownView r8 = r1.T.o;
        if (r8 == null) goto L17;
        r8.setVisibility(8);
    L17:
        KtvRoomLyricHolder r9 = r1.g1;
        if (r9 == null) goto L20;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r10 = r9.a;
        r10.b = 0;
        r10.a.release();
        r9.b.d();
    L20:
        KtvRoomLyricHolder r11 = r1.g1;
        if (r11 == null) goto L23;
        r11.b();
    L23:
        LyricComponentImplManager r12 = r1.S;
        if (r12 == null) goto L26;
        r12.m();
    L26:
        LyricComponentListenerPresenter r13 = r1.p;
        if (r13 == null) goto L29;
        r13.b();
    L29:
        KtvComponentProgressView r14 = r1.T.g;
        if (r14 == null) goto L32;
        r14.setProgress(100.0f);
    L32:
        KtvComponentUIContext r16 = r1.s;
        if (r16 == null) goto L37;
        MutableLiveData<Boolean> r17 = r16.getSingerScoreOpen();
        if (r17 == null) goto L37;
        r17.setValue(Boolean.FALSE);
    L37:
        a r18 = r1.t;
        if (r18 == null) goto L247;
        r18.f(r15);
    L247:
        KtvRoomLyricsStateMachineConfig.a r19 = (KtvRoomLyricsStateMachineConfig.a) r15.b;
        if ((r19 instanceof KtvRoomLyricsStateMachineConfig.a.h) == false) goto L250;
    L257:
        KtvComponentUIWidget.Aq(this.a, ((KtvRoomLyricsStateMachineConfig.d) r15.a).b());
        return;
    L250:
        if ((r19 instanceof KtvRoomLyricsStateMachineConfig.a.g) == true) goto L257;
        if ((r19 instanceof KtvRoomLyricsStateMachineConfig.a.i) == false) goto L259;
        Object r110 = r15.a;
        if ((r110 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L260;
        KtvComponentUIWidget.Aq(this.a, ((KtvRoomLyricsStateMachineConfig.d) r110).b());
        return;
    L260:
        return;
    L259:
        return;
    L41:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L77;
        KtvComponentUIWidget r20 = this.a;
        TokenCert r21 = KtvComponentUIWidget.y1;
        r20.e = false;
        r20.g = false;
        r20.h = false;
        r20.U.f(je2.f.a.a);
        LyricComponentImplManager r22 = r20.S;
        if (r22 == null) goto L45;
        r22.m();
    L45:
        KtvRoomLyricsStateMachineConfig.d r23 = (KtvRoomLyricsStateMachineConfig.d) r15.a;
        Object r24 = r15.c;
        if (r24 == null) goto L75;
        KtvRoomLyricsStateMachineConfig.d.e r25 = (KtvRoomLyricsStateMachineConfig.d.e) r24;
        if ((r23 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L53;
        if (((KtvRoomLyricsStateMachineConfig.d.e) r23).b.a.getMId() == r25.b.a.getMId()) goto L247;
    L53:
        if (KtvUtilsKt.x(r25.b.a) == true) goto L55;
    L56:
        ChorusContext.a r26 = ChorusContext.Companion;
        if (r26.c() == true) goto L59;
    L61:
        if (r4 == true) goto L63;
        r20.or(r25.b, null);
    L63:
        KtvComponentUIContext r27 = r20.s;
        if (r27 == null) goto L68;
        MutableLiveData<Boolean> r28 = r27.getSingerScoreOpen();
        if (r28 == null) goto L68;
        r28.setValue(Boolean.FALSE);
    L68:
        KtvComponentCountDownView r29 = r20.T.o;
        if (r29 == null) goto L71;
        r29.setVisibility(8);
    L71:
        a r30 = r20.t;
        if (r30 == null) goto L247;
        r30.h(r15);
        goto L247
    L59:
        if (r26.d() == false) goto L61;
    L60:
        r4 = true;
        goto L61
    L55:
        if (ChorusContext.Companion.c() == false) goto L60;
    L75:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Preparing");
    L77:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L96;
        KtvComponentUIWidget r31 = this.a;
        TokenCert r32 = KtvComponentUIWidget.y1;
        r31.getClass();
        if ((r15.a instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L81;
        r31.Q = true;
    L81:
        r31.mr();
        LyricComponentListenerPresenter r33 = r31.p;
        if (r33 == null) goto L84;
        r33.c(4);
    L84:
        KtvRoomLyricHolder r34 = r31.g1;
        if (r34 == null) goto L89;
        KtvListenerLyricPresenter r35 = r34.b;
        if (r35 == null) goto L89;
        r35.b(4);
    L89:
        KtvComponentProgressView r36 = r31.T.g;
        if (r36 == null) goto L92;
        r36.a();
    L92:
        a r37 = r31.t;
        if (r37 == null) goto L247;
        r37.i(r15);
        goto L247
    L96:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L219;
        KtvComponentUIWidget r38 = this.a;
        TokenCert r39 = KtvComponentUIWidget.y1;
        r38.getClass();
        boolean r40 = com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.f.a(r15);
        Object r41 = r15.c;
        if (r41 == null) goto L217;
        KtvRoomLyricsStateMachineConfig.d.f r42 = (KtvRoomLyricsStateMachineConfig.d.f) r41;
        if (r40 == false) goto L247;
        if ((r15.a instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L109;
        if (KtvComponentUIWidget.Iq() == true) goto L109;
        LyricComponentListenerPresenter r43 = r38.p;
        if (r43 == null) goto L136;
        r43.c(5);
    L136:
        KtvRoomLyricHolder r44 = r38.g1;
        if (r44 == null) goto L141;
        wd2.a r45 = r44.b.g;
        if (r45 == null) goto L141;
        r45.e = true;
    L141:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r46 = r38.A;
        if (r46 == null) goto L144;
        r46.g = -1;
    L144:
        KtvContext.Companion.getClass();
        KtvContext.a.g().getKtvComponentSingerUserIdChangedEvent().post(new fd2.z(r42.b.a.getOrderInfo()));
        r38.mr();
        if (r38.M == true) goto L147;
    L199:
        KtvMusic.a r47 = KtvMusic.Companion;
        KtvMusic r48 = r42.b.a;
        r47.getClass();
        if (KtvMusic.a.a(r48) <= 0) goto L213;
        KtvComponentProgressView r49 = r38.T.g;
        if (r49 == null) goto L204;
        r49.setProgress(0.0f);
    L204:
        int r50 = ge2.a.a;
        float r51 = z0.b(true);
        if (r51 > 0) goto L207;
    L209:
        if (r4 == true) goto L213;
        KtvComponentProgressView r52 = r38.T.g;
        if (r52 == null) goto L213;
        r52.c(KtvMusic.a.a(r42.b.a) * 1000, KtvMusic.a.b(r42.b.a, r42.d.a));
        goto L213
    L207:
        if (r51 >= ((Number) vm2.h.c3.getValue(null, vm2.h.a[209(0xd1, float:2.93E-43)])).floatValue()) goto L209;
        r4 = true;
    L213:
        KtvContext.a.g().getKtvComponentSingerUserIdChangedEvent().post(new fd2.z(r42.b.a.getOrderInfo()));
        a r53 = r38.t;
        if (r53 == null) goto L247;
        r53.d(r15);
        goto L247
    L147:
        if ((r15.a instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L184;
        LyricComponentImplManager r54 = r38.S;
        if (r54 == null) goto L151;
        jg4.j r55 = r54.a;
    L153:
        if ((r55 instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h) == true) goto L155;
        r55 = null;
    L155:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h r56 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.h) r55;
        MusicPanel r57 = r42.b;
        Object r58 = r15.b;
        if ((r58 instanceof KtvRoomLyricsStateMachineConfig.a.d) == true) goto L158;
        r58 = null;
    L158:
        KtvRoomLyricsStateMachineConfig.a.d r59 = (KtvRoomLyricsStateMachineConfig.a.d) r58;
        if (r56 != null) goto L169;
        if (r59 == null) goto L166;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r60 = r59.c;
        if (r60 == null) goto L166;
        if (r60.j() == r57.c()) goto L166;
        boolean r61 = true;
    L167:
        if (r61 == true) goto L196;
        r38.ar(r57);
    L196:
        LyricComponentListenerPresenter r62 = r38.p;
        if (r62 == null) goto L199;
        r62.d.e = true;
    L166:
        r61 = false;
        goto L167
    L169:
        if (r59 == null) goto L178;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r63 = r59.c;
        if (r63 == null) goto L178;
        if (r63.j() == r56.n) goto L178;
        LyricComponentImplManager r64 = r38.S;
        if (r64 == null) goto L178;
        r64.m();
    L178:
        if (r57.c() != r56.n) goto L183;
        List r65 = ((jg4.j) r56).c;
        if (r65 == null) goto L183;
        if ((!r65.isEmpty()) == true) goto L196;
    L183:
        r38.Jq(r57);
        goto L196
    L151:
        r55 = null;
        goto L153
    L184:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r66 = r42.c;
        if (r66 != null) goto L187;
    L189:
        boolean r67 = false;
    L190:
        if (r67 == true) goto L196;
        StringBuilder r68 = new StringBuilder("onKtvStateSinging ");
        r68.append(r67);
        r68.append("  ");
        KtvMusic r69 = r42.b.a;
        if (r69 == null) goto L194;
        String r70 = r69.getMTitle();
    L195:
        r68.append(r70);
        r68.append(' ');
        kg4.a.b(r68.toString());
        r38.ar(r42.b);
        goto L196
    L194:
        r70 = null;
        goto L195
    L187:
        if (r66.j() == r42.b.c()) goto L189;
        r67 = true;
    L109:
        if (KtvSettingHelper.h() == false) goto L111;
    L117:
        MusicPanel r71 = ((KtvRoomLyricsStateMachineConfig.d) r15.c).b();
        if (r71 == null) goto L136;
        KtvComponentUIContext r72 = r38.s;
        if (r72 == null) goto L124;
        MutableLiveData<Boolean> r73 = r72.getScoreOpen();
        if (r73 == null) goto L124;
        Boolean r74 = (Boolean) r73.getValue();
    L125:
        Boolean r75 = Boolean.TRUE;
        if (Intrinsics.areEqual(r74, r75) == true) goto L135;
        KtvComponentUIContext r76 = r38.s;
        if (r76 == null) goto L132;
        MutableLiveData<Boolean> r77 = r76.getSingerScoreOpen();
        if (r77 == null) goto L132;
        Boolean r78 = (Boolean) r77.getValue();
    L134:
        if (Intrinsics.areEqual(r78, r75) == false) goto L136;
    L132:
        r78 = null;
    L135:
        r38.Gq(r71);
    L124:
        r74 = null;
        goto L125
    L111:
        if ((r15.a instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L117;
        if (KtvComponentUIWidget.Iq() == true) goto L117;
        LyricComponentListenerPresenter r79 = r38.p;
        if (r79 == null) goto L117;
        r79.b();
        goto L117
    L217:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L219:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L247;
        KtvComponentUIWidget r80 = this.a;
        TokenCert r81 = KtvComponentUIWidget.y1;
        r80.e = false;
        r80.g = false;
        r80.h = false;
        r80.U.f(je2.f.a.a);
        LyricComponentImplManager r82 = r80.S;
        if (r82 == null) goto L224;
        r82.m();
    L224:
        if (KtvSettingHelper.h() == false) goto L228;
        LyricComponentListenerPresenter r83 = r80.p;
        if (r83 == null) goto L228;
        r83.b();
    L228:
        KtvRoomLyricHolder r85 = r80.g1;
        if (r85 == null) goto L231;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r86 = r85.a;
        r86.b = 0;
        r86.a.release();
        r85.b.d();
    L231:
        KtvComponentProgressView r87 = r80.T.g;
        if (r87 == null) goto L234;
        r87.setProgress(100.0f);
    L234:
        KtvComponentCountDownView r88 = r80.T.o;
        if (r88 == null) goto L237;
        r88.setVisibility(8);
    L237:
        KtvContext.Companion.getClass();
        KtvContext r89 = KtvContext.a.g();
        if (r89 == null) goto L242;
        com.bytedance.live.datacontext.k<fd2.z> r90 = r89.getKtvComponentSingerUserIdChangedEvent();
        if (r90 == null) goto L242;
        r90.post(new fd2.z(null));
    L242:
        KtvContext r91 = KtvContext.a.g();
        if (r91 == null) goto L247;
        com.bytedance.live.datacontext.n<OrderInfo> r92 = r91.getKtvCurrentSingOrderInfo();
        if (r92 == null) goto L247;
        r92.setValue(null);
        goto L247
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public final void e(long r7) {
        if (this.a.R.isCurrentUserIsSinger() == false) goto L55;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r0 = this.a.u;
        if (r0 != null) goto L7;
    L15:
        KtvComponentUIWidget r1 = this.a;
        if (r1.M == false) goto L20;
        KtvComponentCountDownView r2 = r1.T.o;
        if (r2 == null) goto L20;
        r2.a(r7);
    L20:
        LyricComponentImplManager r3 = this.a.S;
        if (r3 == null) goto L23;
        r3.j(r7);
    L23:
        KtvComponentUIWidget r4 = this.a;
        if (r4.M == false) goto L26;
        r4.O.a(r7);
    L26:
        KtvComponentUIWidget r5 = this.a;
        KtvSingAndListenerLyricViewV2 r6 = r5.T.b;
        Boolean r8 = null;
        if (r6 == null) goto L29;
        int r9 = r6.getCurShowIndex();
    L36:
        Integer r10 = Integer.valueOf(r9);
    L38:
        if (r10 == null) goto L40;
        int r11 = r10.intValue();
    L41:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r12 = this.a.n;
        if (r12 == null) goto L44;
        r12.updateCurrentLyricsLine(r11);
    L44:
        KtvComponentUIContext r13 = this.a.s;
        if (r13 == null) goto L50;
        MutableLiveData<Boolean> r14 = r13.getScoreOpen();
        if (r14 == null) goto L50;
        r8 = (Boolean) r14.getValue();
    L50:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L56;
        KtvComponentMidiViewModel r15 = this.a.N;
        if (r15 == null) goto L57;
        r15.tryStartGetScoreInfoTimer(Long.valueOf(r7));
        return;
    L57:
        return;
    L56:
        return;
    L40:
        r11 = 0;
        goto L41
    L29:
        LyricComponentImplManager r16 = r5.S;
        if (r16 == null) goto L37;
        jg4.j r17 = r16.a;
        if (r17 == null) goto L37;
        jg4.a r18 = r17.f;
        if (r18 == null) goto L37;
        r9 = r18.c;
    L37:
        r10 = null;
        goto L38
    L7:
        if ((r7 - r0.b) < r0.c) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r19 = r0.a;
        long r20 = 0;
        if (r7 < 0) goto L12;
        r20 = r7;
    L12:
        r19.renderLyricsByPlayTime(r20);
        r0.b = r7;
        KtvComponentCountDownView r21 = r0.e;
        if (r21 == null) goto L15;
        r21.a(r7);
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
    public final void d(KtvRoomLyricsStateMachineConfig.d r21, final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r22) {
        Intrinsics.checkNotNullParameter(r21, "curstate");
        Intrinsics.checkNotNullParameter(r22, "ktvCoreDataModel");
        boolean r4 = false;
        boolean r5 = true;
        KtvMusic r6 = null;
        if ((r21 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L117;
        MusicPanel r1 = r22.a;
        if (r1 == null) goto L203;
        final KtvMusic r2 = r1.a;
        if (r2 == null) goto L204;
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.k<fd2.z> r7 = r3.getKtvComponentSingerUserIdChangedEvent();
        if (r7 == null) goto L13;
        r7.post(new fd2.z(r2.getOrderInfo()));
    L13:
        KtvContext r8 = KtvContext.a.g();
        if (r8 == null) goto L18;
        com.bytedance.live.datacontext.n<OrderInfo> r9 = r8.getKtvCurrentSingOrderInfo();
        if (r9 == null) goto L18;
        r9.setValue(r2.getOrderInfo());
    L18:
        KtvComponentProgressView r10 = this.a.T.g;
        if (r10 == null) goto L21;
        r10.b();
    L21:
        LyricComponentImplManager r11 = this.a.S;
        if (r11 == null) goto L24;
        r11.m();
    L24:
        LyricComponentListenerPresenter r12 = this.a.p;
        if (r12 == null) goto L27;
        r12.b();
    L27:
        KtvRoomLyricHolder r13 = this.a.g1;
        if (r13 == null) goto L30;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r14 = r13.a;
        r14.b = 0;
        r14.a.release();
        r13.b.d();
    L30:
        KtvRoomLyricHolder r15 = this.a.g1;
        if (r15 == null) goto L33;
        r15.b();
    L33:
        String r16 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        ArrayList<Integer> r17 = ke2.a.a;
        List<MusicPanel> r18 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        long r19 = r22.a.a.getMId();
        if (r18 == null) goto L46;
        Iterator<T> r20 = r18.iterator();
    L37:
        if (r20.hasNext() == false) goto L44;
        Object r110 = r20.next();
        if (((MusicPanel) r110).a.getMId() != r19) goto L41;
        boolean r111 = true;
    L42:
        if (r111 == false) goto L37;
    L45:
        final MusicPanel r112 = (MusicPanel) r110;
    L47:
        final KtvComponentUIWidget r23 = this.a;
        if (r112 == null) goto L50;
        KtvMusic r24 = r112.a;
    L51:
        r23.getClass();
        if (r24 == null) goto L54;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getLyricResourceManager().c(r24, new KtvComponentUIWidget$preDownloadLyrics$$inlined$let$lambda$1(r23));
    L54:
        OrderInfo r25 = r2.getOrderInfo();
        if (r25 == null) goto L60;
        InteractiveSongUserInfo r26 = r25.getTopUser();
        if (r26 == null) goto L60;
        String r27 = r26.getIdString();
        if (r27 == null) goto L60;
    L62:
        if (Intrinsics.areEqual(r16, r27) == true) goto L69;
        ChorusContext.a r28 = ChorusContext.Companion;
        if (r28.c() == true) goto L66;
    L68:
        boolean r29 = false;
    L70:
        ChorusContext.a r30 = ChorusContext.Companion;
        if (r30.c() == true) goto L73;
    L82:
        if (r29 == false) goto L94;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r31 = this.a.n;
        if (r31 != null) goto L86;
    L87:
        com.bytedance.android.live.ktv.common.music.download.m r32 = KtvMusicManager.a;
        if (KtvMusicManager.h(r22.a) == false) goto L93;
    L89:
        this.a.Qq();
        this.a.U.d(r2, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, new KtvComponentUIWidget$mKtvCoreListener$1$onDataModelChange$$inlined$let$lambda$3(r2, this, r22));
        ALogger.w("KtvComponentUIWidget", "onPreparingSinging but find no music res download so try download now. " + r2.getMTitle());
        if (r30.c() == false) goto L92;
        f2.b(2131918310, 0);
    L92:
        MusicPanel r33 = r22.a;
        KtvMusicManager.e(KtvMusicManager.m, r33, new b0(this, r33), true, null, false, 24);
    L95:
        int r34 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.a;
        float r35 = z0.b(false);
        if (r35 > 0) goto L98;
    L101:
        if (r5 == false) goto L103;
        return;
    L103:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L206;
        MultiChorusContext.a r36 = MultiChorusContext.Companion;
        if (r36.c() == true) goto L107;
        return;
    L107:
        if (r36.b() == false) goto L109;
        return;
    L109:
        if (hd0.c.f().h() == false) goto L209;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L210;
        com.bytedance.android.livesdk.sharedpref.e r37 = com.bytedance.android.livesdk.sharedpref.c.z;
        if (((Boolean) r37.getValue()).booleanValue() == true) goto L221;
        com.bytedance.android.livesdk.sharedpref.f.d(r37, Boolean.TRUE);
        f2.b(2131917297, 0);
        return;
    L221:
        return;
    L210:
        return;
    L209:
        return;
    L206:
        return;
    L98:
        if (r35 >= ((Number) vm2.h.Z0.getValue(null, vm2.h.a[102(0x66, float:1.43E-43)])).floatValue()) goto L101;
        r5 = false;
        goto L101
    L93:
        this.a.Qq();
        this.a.U.d(r2, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, new KtvComponentUIWidget$mKtvCoreListener$1$onDataModelChange$$inlined$let$lambda$4(r2, this, r22));
        goto L95
    L86:
        if (r31.isNeedMusicDownload(r22.a) == true) goto L89;
    L94:
        this.a.or(r22.a, null);
        goto L95
    L73:
        if (r30.d() == false) goto L82;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r38 = this.a.n;
        if (r38 != null) goto L77;
    L78:
        com.bytedance.android.live.ktv.common.music.download.m r39 = KtvMusicManager.a;
        if (KtvMusicManager.h(r22.a) == false) goto L81;
    L80:
        this.a.Qq();
        this.a.U.d(r2, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, new KtvComponentUIWidget$mKtvCoreListener$1$onDataModelChange$$inlined$let$lambda$1(r2, this, r22));
        MusicPanel r113 = r22.a;
        KtvMusicManager.e(KtvMusicManager.m, r113, new b0(this, r113), true, null, false, 24);
        goto L95
    L81:
        this.a.Qq();
        this.a.U.d(r2, KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, new KtvComponentUIWidget$mKtvCoreListener$1$onDataModelChange$$inlined$let$lambda$2(r112, r2, this, r22));
        goto L95
    L77:
        if (r38.isNeedMusicDownload(r22.a) == true) goto L80;
    L66:
        if (r28.d() == false) goto L68;
    L69:
        r29 = true;
    L60:
        r27 = "";
        goto L62
    L50:
        r24 = null;
        goto L51
    L41:
        r111 = false;
        goto L42
    L44:
        r110 = null;
        goto L45
    L46:
        r112 = null;
        goto L47
    L204:
        return;
    L203:
        return;
    L117:
        if ((r21 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L195;
        KtvContext.Companion.getClass();
        KtvContext r40 = KtvContext.a.g();
        if (r40 == null) goto L129;
        com.bytedance.live.datacontext.n<OrderInfo> r41 = r40.getKtvCurrentSingOrderInfo();
        if (r41 == null) goto L129;
        MusicPanel r42 = r22.a;
        if (r42 == null) goto L127;
        KtvMusic r43 = r42.a;
        if (r43 == null) goto L127;
        OrderInfo r44 = r43.getOrderInfo();
    L128:
        r41.setValue(r44);
    L127:
        r44 = null;
    L129:
        boolean r45 = KtvContext.a.g().isCurrentUserIsSinger();
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r46 = r22.b;
        if (r45 == true) goto L141;
        if (r46 == null) goto L141;
        KtvListenerLyricPresenter r47 = this.a.v;
        if (r47 == null) goto L135;
        r47.c(r46);
    L135:
        LyricComponentListenerPresenter r48 = this.a.p;
        if (r48 == null) goto L138;
        r48.c(r46.d());
    L138:
        LyricComponentListenerPresenter r49 = this.a.p;
        if (r49 == null) goto L141;
        r49.d(r46);
    L141:
        MusicPanel r50 = r22.a;
        if (r50 == null) goto L149;
        KtvMusic r51 = r50.a;
        if (r51 == null) goto L149;
        if (KtvUtilsKt.x(r51) != true) goto L149;
        if (ChorusContext.Companion.c() == true) goto L149;
    L153:
        boolean r52 = true;
    L155:
        if (r52 == true) goto L158;
        KtvComponentUIWidget r53 = this.a;
        MusicPanel r54 = r22.a;
        TokenCert r55 = KtvComponentUIWidget.y1;
        r53.or(r54, null);
    L158:
        if (this.a.M == true) goto L212;
        MusicPanel r56 = r22.a;
        if (r56 == null) goto L167;
        KtvMusic r57 = r56.a;
        if (r57 == null) goto L167;
        if (KtvUtilsKt.x(r57) != true) goto L167;
        if (ChorusContext.Companion.c() == true) goto L167;
    L171:
        List<com.bytedance.component.lyric.model.b> r58 = r22.c;
        if (r58 != null) goto L174;
    L175:
        r4 = true;
    L176:
        if (r4 == false) goto L213;
        KtvComponentUIWidget r59 = this.a;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r60 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        MusicPanel r61 = r22.a;
        if (r61 == null) goto L180;
        r6 = r61.a;
    L180:
        r60.getClass();
        KtvComponentUIWidget.Cq(r59, com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r6));
        return;
    L213:
        return;
    L174:
        if (r58.isEmpty() == false) goto L176;
    L167:
        ChorusContext.a r62 = ChorusContext.Companion;
        if (r62.c() == false) goto L182;
        if (r62.d() == true) goto L171;
    L182:
        if (r22.b != null) goto L184;
        return;
    L184:
        if (((x41) vm2.h.V0.getValue(null, vm2.h.a[98])).a() > 0) goto L216;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r63 = r22.b;
        if (r63 != null) goto L188;
    L193:
        this.a.or(r22.a, null);
        return;
    L188:
        if (r63.J() != true) goto L193;
        KtvComponentUIWidget r64 = this.a;
        if (r64.g == false) goto L192;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r65 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r66 = r22.b;
        r65.getClass();
        KtvComponentUIWidget.Cq(r64, com.bytedance.android.livesdk.ktvimpl.base.util.j.c(r66));
        return;
    L192:
        r64.or(r22.a, new KtvComponentUIWidget$mKtvCoreListener$1$onDataModelChange$2(this, r22));
        return;
    L216:
        return;
    L212:
        return;
    L149:
        ChorusContext.a r67 = ChorusContext.Companion;
        if (r67.c() == true) goto L152;
    L154:
        r52 = false;
        goto L155
    L152:
        if (r67.d() == false) goto L154;
    L195:
        if ((r21 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L220;
        KtvComponentUIWidget r68 = this.a;
        TokenCert r69 = KtvComponentUIWidget.y1;
        r68.tr();
        return;
    }
}
