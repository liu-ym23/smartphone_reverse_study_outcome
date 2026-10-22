package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.view.TuningPanelDialog;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KSongTuningPanelOuterCallback implements zb0.a {
    public final Lazy a;
    public final Map<String, ac0.c> b;

    public final void c() {
        KtvComponentContext.a r1 = KtvComponentContext.Companion;
        KtvComponentContext r2 = r1.getContext();
        boolean r3 = false;
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r4 = r2.getPanelState();
        if (r4 == null) goto L9;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L10:
        int r7 = v.b(r6, 4);
        KtvComponentContext r8 = r1.getContext();
        if (r8 == null) goto L15;
        com.bytedance.live.datacontext.m<Integer> r9 = r8.getPanelState();
        if (r9 == null) goto L15;
        r9.setValue(Integer.valueOf(r7));
    L15:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = KSongTuningPanelHelperKt.d();
        ac0.c r11 = (ac0.c) ((LinkedHashMap) this.b).get(TuningVolumeType.EAR_BACK_VOLUME.getValue());
        if (r11 == null) goto L21;
        if (r10 == null) goto L19;
        int r12 = MathKt.roundToInt(r10.f());
    L20:
        r11.c = r12;
        goto L21
    L19:
        r12 = 0;
    L21:
        ac0.c r13 = (ac0.c) ((LinkedHashMap) this.b).get(TuningVolumeType.VOCAL_VOLUME.getValue());
        if (r13 == null) goto L27;
        if (r10 == null) goto L25;
        int r14 = MathKt.roundToInt(r10.e());
    L26:
        r13.c = r14;
        goto L27
    L25:
        r14 = 0;
    L27:
        ac0.c r15 = (ac0.c) ((LinkedHashMap) this.b).get(TuningVolumeType.CHORUS_SINGER_VOLUME.getValue());
        if (r15 == null) goto L33;
        if (r10 == null) goto L31;
        int r16 = MathKt.roundToInt(r10.V());
    L32:
        r15.c = r16;
        goto L33
    L31:
        r16 = 0;
    L33:
        ac0.c r17 = (ac0.c) ((LinkedHashMap) this.b).get(TuningVolumeType.ACCOMPANIMENT_VOLUME.getValue());
        if (r17 == null) goto L39;
        if (r10 == null) goto L37;
        int r18 = MathKt.roundToInt(r10.A());
    L38:
        r17.c = r18;
        goto L39
    L37:
        r18 = 0;
    L39:
        ac0.c r19 = (ac0.c) ((LinkedHashMap) this.b).get(TuningVolumeType.TONE_VOLUME.getValue());
        if (r19 == null) goto L45;
        if (r10 == null) goto L43;
        int r20 = r10.u();
    L44:
        r19.c = r20;
        goto L45
    L43:
        r20 = 0;
    L45:
        com.bytedance.android.livesdk.chatroom.o r21 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r21 == null) goto L50;
        com.bytedance.live.datacontext.m r22 = r21.getRoom();
        if (r22 == null) goto L50;
        IRoom r23 = (IRoom) r22.getValue();
    L51:
        String r24 = "";
        if (r23 == null) goto L55;
        String r25 = r23.getOwnerUserIdString();
        if (r25 == null) goto L55;
    L56:
        long r26 = 0;
        if (r23 == null) goto L59;
        long r27 = r23.getId();
    L60:
        ec0.a r28 = KSongTuningPanelHelperKt.e();
        if (r28 == null) goto L63;
        MusicPanel r29 = r28.e();
    L64:
        if (r29 == null) goto L68;
        KtvMusic r30 = r29.a;
        if (r30 == null) goto L68;
        r26 = r30.getMId();
    L68:
        long r210 = r26;
        Lazy r31 = KtvCommonConfigParams.a;
        boolean r211 = vm2.h.r().a();
        KtvContext.Companion.getClass();
        a0.e(KtvContext.a.g().getDataCenter());
        oe2.b r32 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r32 == null) goto L74;
        String r33 = r32.getEnterFrom();
        if (r33 == null) goto L74;
        r24 = r33;
    L74:
        if (r29 == null) goto L83;
        KtvMusic r34 = r29.a;
        if (r34 == null) goto L83;
        String r35 = r34.getMidiUrl();
        if (r35 == null) goto L83;
        if (r35.length() <= 0) goto L82;
        r3 = true;
    L82:
        Boolean r36 = Boolean.valueOf(r3);
    L84:
        Iterator r37 = ((LinkedHashMap) this.b).entrySet().iterator();
    L86:
        if (r37.hasNext() == false) goto L92;
        ac0.c r38 = (ac0.c) ((Map.Entry) r37.next()).getValue();
        if (r38.b == r38.c) goto L86;
        pb0.a r39 = pb0.b.a;
        String r110 = com.bytedance.android.live.ktv.common.util.j.d();
        String r111 = com.bytedance.android.live.ktv.common.util.j.a(null);
        String r112 = com.bytedance.android.live.ktv.common.util.j.c();
        String r113 = r38.getType();
        int r114 = r38.b;
        int r115 = r38.c;
        Intrinsics.checkNotNullParameter(r25, "anchorId");
        Intrinsics.checkNotNullParameter(r110, "liveType");
        Intrinsics.checkNotNullParameter(r111, "roomType");
        Intrinsics.checkNotNullParameter(r112, "functionType");
        Intrinsics.checkNotNullParameter(r113, "tuneType");
        pb0.a r40 = pb0.b.a;
        if (r40 == null) goto L86;
        r40.d(r25, r27, r110, r111, r112, r210, r211, r113, r114, r115, r24, r36);
        goto L86
    L92:
        f();
        return;
    L83:
        r36 = null;
        goto L84
    L63:
        r29 = null;
        goto L64
    L59:
        r27 = 0;
    L55:
        r25 = "";
    L50:
        r23 = null;
    L9:
        r6 = 0;
        goto L10
    }

    public final void clearData() {
        ((CompositeDisposable) this.a.getValue()).clear();
    }

    public KSongTuningPanelOuterCallback() {
        this.a = LazyKt.lazy(KSongTuningPanelOuterCallback$compositeDisposable$2.INSTANCE);
        LinkedHashMap r0 = new LinkedHashMap();
        TuningVolumeType r1 = TuningVolumeType.EAR_BACK_VOLUME;
        r0.put(r1.getValue(), new ac0.c(r1.getValue()));
        TuningVolumeType r2 = TuningVolumeType.VOCAL_VOLUME;
        r0.put(r2.getValue(), new ac0.c(r2.getValue()));
        TuningVolumeType r3 = TuningVolumeType.CHORUS_SINGER_VOLUME;
        r0.put(r3.getValue(), new ac0.c(r3.getValue()));
        TuningVolumeType r4 = TuningVolumeType.ACCOMPANIMENT_VOLUME;
        r0.put(r4.getValue(), new ac0.c(r4.getValue()));
        TuningVolumeType r5 = TuningVolumeType.TONE_VOLUME;
        r0.put(r5.getValue(), new ac0.c(r5.getValue()));
        Unit r6 = Unit.INSTANCE;
        this.b = r0;
    }

    public final void f() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        Map<String, ac0.c> r1 = this.b;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        ac0.c r3 = (ac0.c) r2.get(TuningVolumeType.EAR_BACK_VOLUME.getValue());
        int r4 = 0;
        if (r3 == null) goto L8;
        if (r0 == null) goto L6;
        int r5 = MathKt.roundToInt(r0.f());
    L7:
        r3.b = r5;
        r3.c = r5;
        goto L8
    L6:
        r5 = 0;
    L8:
        Map<String, ac0.c> r6 = this.b;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        ac0.c r8 = (ac0.c) r7.get(TuningVolumeType.VOCAL_VOLUME.getValue());
        if (r8 == null) goto L14;
        if (r0 == null) goto L12;
        int r9 = MathKt.roundToInt(r0.e());
    L13:
        r8.b = r9;
        r8.c = r9;
        goto L14
    L12:
        r9 = 0;
    L14:
        Map<String, ac0.c> r10 = this.b;
        LinkedHashMap r11 = (LinkedHashMap) r10;
        ac0.c r12 = (ac0.c) r11.get(TuningVolumeType.CHORUS_SINGER_VOLUME.getValue());
        if (r12 == null) goto L20;
        if (r0 == null) goto L18;
        int r13 = MathKt.roundToInt(r0.V());
    L19:
        r12.b = r13;
        r12.c = r13;
        goto L20
    L18:
        r13 = 0;
    L20:
        Map<String, ac0.c> r14 = this.b;
        LinkedHashMap r15 = (LinkedHashMap) r14;
        ac0.c r16 = (ac0.c) r15.get(TuningVolumeType.ACCOMPANIMENT_VOLUME.getValue());
        if (r16 == null) goto L26;
        if (r0 == null) goto L24;
        int r17 = MathKt.roundToInt(r0.A());
    L25:
        r16.b = r17;
        r16.c = r17;
        goto L26
    L24:
        r17 = 0;
    L26:
        Map<String, ac0.c> r18 = this.b;
        LinkedHashMap r19 = (LinkedHashMap) r18;
        ac0.c r20 = (ac0.c) r19.get(TuningVolumeType.TONE_VOLUME.getValue());
        if (r20 == null) goto L32;
        if (r0 == null) goto L30;
        r4 = r0.u();
    L30:
        r20.b = r4;
        r20.c = r4;
        return;
    }

    public final void b(long r3) {
        mb0.c r0 = mb0.d.a;
        mb0.d.f("adjust_music", System.currentTimeMillis() - r3);
    }

    public final void e(int[] r19) {
        Intrinsics.checkNotNullParameter(r19, "array");
        KtvComponentContext.a r1 = KtvComponentContext.Companion;
        KtvComponentContext r2 = r1.getContext();
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r3 = r2.getPanelTop();
        if (r3 == null) goto L7;
        r3.setValue(Integer.valueOf(r19[1]));
    L7:
        KtvComponentContext r0 = r1.getContext();
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.m<Integer> r4 = r0.getPanelState();
        if (r4 == null) goto L14;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L14;
        int r6 = r5.intValue();
    L15:
        int r7 = r6 | 4;
        KtvComponentContext r8 = r1.getContext();
        if (r8 == null) goto L20;
        com.bytedance.live.datacontext.m<Integer> r9 = r8.getPanelState();
        if (r9 == null) goto L20;
        r9.setValue(Integer.valueOf(r7));
    L20:
        f();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = KSongTuningPanelHelperKt.d();
        ec0.a r11 = KSongTuningPanelHelperKt.e();
        if (r10 == null) goto L23;
        r10.i();
    L23:
        if (r10 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        if (r11 != null) goto L30;
    L34:
        boolean r13 = false;
    L35:
        pb0.a r14 = pb0.b.a;
        String r15 = com.bytedance.android.live.ktv.common.util.j.d();
        Float r16 = null;
        String r17 = com.bytedance.android.live.ktv.common.util.j.a(null);
        Boolean r18 = Boolean.valueOf(r12);
        if (r10 == null) goto L38;
        String r110 = String.valueOf(r10.e());
    L39:
        if (r10 == null) goto L41;
        String r111 = String.valueOf(r10.A());
    L42:
        if (r10 == null) goto L44;
        String r112 = String.valueOf(r10.f());
    L45:
        Boolean r113 = Boolean.valueOf(r13);
        Intrinsics.checkNotNullParameter(r15, "liveType");
        Intrinsics.checkNotNullParameter(r17, "roomType");
        pb0.a r20 = pb0.b.a;
        if (r20 == null) goto L48;
        r20.e(r15, r17, r18, false, r110, r111, r112, r113);
    L48:
        if (r11 == null) goto L52;
        MusicPanel r21 = r11.e();
        if (r21 == null) goto L52;
        String r22 = r21.e();
    L53:
        if (r10 == null) goto L55;
        r10.i();
        Boolean r23 = Boolean.FALSE;
    L56:
        if (r10 == null) goto L58;
        r10.b();
    L58:
        if (r10 == null) goto L60;
        r10.P();
    L60:
        if (r10 == null) goto L62;
        Boolean r24 = r10.I();
    L63:
        if (r10 == null) goto L65;
        Float r25 = Float.valueOf(r10.A());
    L66:
        if (r10 == null) goto L68;
        Float r114 = Float.valueOf(r10.e());
    L69:
        if (r10 == null) goto L84;
        r16 = Float.valueOf(r10.f());
    L84:
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L82
        r26.put("isOriginOpen", r12);     // Catch: Exception -> L82
        r26.put("isScoreOpen", r13);     // Catch: Exception -> L82
        if (r22 != null) goto L74;
    L77:
        boolean r27 = true;
    L78:
        if (r27 == true) goto L80;
        r26.put("musicName", r22);     // Catch: Exception -> L82
    L80:
        r26.put("isEchoFeatureEnable", r23);     // Catch: Exception -> L82
        r26.put("enableHardwareEcho", true);     // Catch: Exception -> L82
        r26.put("enableHardwareEchoAB", vm2.h.c());     // Catch: Exception -> L82
        r26.put("supportHardWareEcho", false);     // Catch: Exception -> L82
        r26.put("enableSoftwareEcho", vm2.h.L());     // Catch: Exception -> L82
        r26.put("supportSoftWareEcho", false);     // Catch: Exception -> L82
        r26.put("isWiredHeadsetConnected", r24);     // Catch: Exception -> L82
        r26.put("bgmVolume", r25);     // Catch: Exception -> L82
        r26.put("voiceVolume", r114);     // Catch: Exception -> L82
        r26.put("echoVolume", r16);     // Catch: Exception -> L82
        int r28 = mb0.f.a;     // Catch: Exception -> L82
        Intrinsics.checkNotNullParameter(r26, "extra");     // Catch: Exception -> L82
        int r29 = rd0.a.a;     // Catch: Exception -> L82
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.KtvFeatureSwitch, "toneControlPanelShow", 0, null, r26, 88);     // Catch: Exception -> L82
        return;
    L74:
        if (r22.length() == 0) goto L77;
        r27 = false;
    L82:
        ALogger.e("KSongTuningPanelOuterCallback", "toneControlPanelShowTraceMonitor exception");
        return;
    L68:
        r114 = null;
        goto L69
    L65:
        r25 = null;
        goto L66
    L62:
        r24 = null;
        goto L63
    L55:
        r23 = null;
    L52:
        r22 = null;
        goto L53
    L44:
        r112 = null;
        goto L45
    L41:
        r111 = null;
        goto L42
    L38:
        r110 = null;
        goto L39
    L30:
        if (r11.b() != true) goto L34;
        if (r11.h() == false) goto L34;
        r13 = true;
        goto L35
    L25:
        if (r10.R() != true) goto L27;
        r12 = true;
    L14:
        r6 = 0;
        goto L15
    }

    public final void a(LifecycleOwner r8, TuningPanelDialog.c r9) {
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r9, "observer");
        Disposable r10 = xs2.b.a().b(ae2.a.class).subscribe(new k(r9));
        if (r10 == null) goto L5;
        RxUtilKt.c(r10, (CompositeDisposable) this.a.getValue());
    L5:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isKtvMode() == false) goto L8;
        OrderedSongDataContext r11 = KtvModeOrderedSongDataContext.Companion.getContext();
    L9:
        if (r11 == null) goto L13;
        Disposable r12 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r11, null, new l(r9), 3);
        if (r12 == null) goto L13;
        RxUtilKt.c(r12, (CompositeDisposable) this.a.getValue());
    L13:
        Disposable r13 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new m(r9), 3, null);
        if (r13 == null) goto L17;
        RxUtilKt.c(r13, (CompositeDisposable) this.a.getValue());
        return;
    L17:
        return;
    L8:
        r11 = KtvComponentOrderedSongDataContext.Companion.getContext();
        goto L9
    }

    public final void d(ac0.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "tuningButtonData");
        if (r3.getType() != TuningButtonType.ECHO_ITEM) goto L8;
        if (r4 == false) goto L6;
        String r5 = "earphone_open";
    L18:
        KSongTuningPanelHelperKt.c(r5);
        return;
    L6:
        r5 = "earphone_close";
        goto L18
    L8:
        if (r3.getType() != TuningButtonType.SCORE_ITEM) goto L13;
        if (r4 == false) goto L11;
        r5 = "score_open";
        goto L18
    L11:
        r5 = "score_close";
        goto L18
    L13:
        if (r3.getType() != TuningButtonType.ORIGIN_ITEM) goto L17;
        if (r4 == false) goto L16;
        r5 = "original_vocal_open";
        goto L18
    L16:
        r5 = "original_vocal_close";
        goto L18
    L17:
        r5 = "";
        goto L18
    }
}
