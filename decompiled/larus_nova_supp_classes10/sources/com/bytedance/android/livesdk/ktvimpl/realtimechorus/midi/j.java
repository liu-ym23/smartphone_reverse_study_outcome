package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.e0;
import fd2.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ RealTimeChorusMidiWidget a;

    public j(RealTimeChorusMidiWidget r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onChanged(Object r37) {
        Pair r0 = (Pair) r37;
        RealTimeChorusMidiWidget r2 = this.a;
        int r3 = RealTimeChorusMidiWidget.p;
        r2.getClass();
        if (r0 == null) goto L5;
        Long r4 = (Long) r0.getFirst();
    L6:
        if (r0 == null) goto L8;
        com.bytedance.android.live.ktv.common.midi.k r1 = (com.bytedance.android.live.ktv.common.midi.k) r0.getSecond();
    L9:
        com.bytedance.android.live.ktv.common.util.c r5 = r2.c;
        if (r5 != null) goto L12;
    L24:
        if (r1 == null) goto L135;
        int r6 = r1.e;
        int r7 = r2.i;
        int r8 = -1;
        if (r6 > r7) goto L33;
        if (r6 == 0) goto L29;
    L32:
        boolean r9 = false;
    L34:
        if (r9 == false) goto L128;
        xs2.b.a().post(new jd0.j(r1.e + 2));
        RealTimeChorusBusinessContext.a r10 = RealTimeChorusBusinessContext.Companion;
        float r11 = 0.0f;
        if (r10.j() == false) goto L38;
    L43:
        String r12 = gh0.a.c();
        List<UserChorusInfo> r13 = r2.o.Ol();
        if (r13 == null) goto L53;
        Iterator<T> r14 = r13.iterator();
    L47:
        if (r14.hasNext() == false) goto L51;
        T r15 = r14.next();
        if (Intrinsics.areEqual(String.valueOf(((UserChorusInfo) r15).getUserId()), r12) == false) goto L47;
    L52:
        UserChorusInfo r16 = (UserChorusInfo) r15;
    L54:
        if (r16 == null) goto L71;
        if (((r1.e + 1) % ((int) KtvSettingHelper.q().j())) != 1) goto L71;
        if (r1.e == 0) goto L71;
        b r17 = r2.n;
        if (r17 == null) goto L63;
        r17.a(r12, r1.d);
    L63:
        if (((Boolean) KtvSettingHelper.j1.getValue()).booleanValue() == false) goto L67;
        b r18 = r2.n;
        if (r18 == null) goto L71;
        r18.b();
        goto L71
    L67:
        com.bytedance.android.live.ktv.common.util.c r19 = r2.c;
        if (r19 == null) goto L71;
        r19.postDelayed(new p(r2), ((Number) KtvSettingHelper.q.getValue()).intValue());
    L71:
        if (((r1.e + 1) % ((int) KtvSettingHelper.q().j())) == 0) goto L73;
    L127:
        RealTimeChorusMidiWidget r20 = r2;
        com.bytedance.android.live.ktv.common.midi.k r21 = r1;
        r20.g += r21.c;
        r20.h++;
    L129:
        r20.i = r21.e;
        return;
    L73:
        if (r1.e == 0) goto L127;
        com.bytedance.android.livesdk.chatroom.o r22 = o3.g(r2);
        if (r22 == null) goto L81;
        com.bytedance.live.datacontext.m r23 = r22.getRoom();
        if (r23 == null) goto L81;
        IRoom r24 = (IRoom) r23.getValue();
        if (r24 == null) goto L81;
        long r110 = r24.getId();
    L82:
        Ref.IntRef r25 = new Ref.IntRef();
        r25.element = (r1.e + 1) / ((int) KtvSettingHelper.q().j());
        r2.g += r1.c;
        r2.h++;
        Ref.FloatRef r111 = new Ref.FloatRef();
        r111.element = r2.g / r2.h;
        Ref.IntRef r112 = new Ref.IntRef();
        RealTimeChorusBusinessContext r26 = RealTimeChorusBusinessContext.Companion.getContext();
        if (r26 == null) goto L89;
        com.bytedance.live.datacontext.j<s> r27 = r26.m454getService();
        if (r27 == null) goto L89;
        s r28 = (s) r27.getValue();
        if (r28 == null) goto L89;
        e0 r29 = r28.D7();
    L90:
        if (r29 == null) goto L92;
        r8 = r29.a;
    L92:
        r112.element = r8;
        Ref.FloatRef r30 = new Ref.FloatRef();
        KtvContext.Companion.getClass();
        if (((com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue()) == null) goto L97;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r31 = KSongTuningPanelHelperKt.d();
        if (r31 == null) goto L97;
        float r32 = r31.e();
    L98:
        r30.element = r32;
        Ref.ObjectRef r33 = new Ref.ObjectRef();
        KtvModeOrderedSongDataContext r113 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r113 == null) goto L103;
        List<MusicPanel> r114 = r113.m200getKtvSingSongList();
        if (r114 == null) goto L103;
        MusicPanel r115 = (MusicPanel) KtvUtilsKt.K(r114, 0);
    L104:
        r33.element = r115;
        Ref.LongRef r116 = new Ref.LongRef();
        MusicPanel r34 = (MusicPanel) r33.element;
        if (r34 == null) goto L109;
        RealTimeChorusInfo r35 = r34.C;
        if (r35 == null) goto L109;
        long r36 = r35.getChorusID();
    L110:
        r116.element = r36;
        r2.g = 0.0f;
        r2.h = 0;
        float r38 = r1.d;
        long r210 = System.currentTimeMillis();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r39 = KtvRoomContext.a.a();
        if (r39 == null) goto L115;
        com.bytedance.live.datacontext.m<Map<Integer, Float>> r40 = r39.getScoreMap();
        if (r40 == null) goto L115;
        Map r41 = (Map) r40.getValue();
    L116:
        if (r41 == null) goto L123;
        Collection r42 = r41.values();
        if (r42 == null) goto L123;
        Iterator<T> r43 = r42.iterator();
    L121:
        if (r43.hasNext() == false) goto L123;
        r11 = r11 + ((Number) r43.next()).floatValue();
    L123:
        a r44 = r2.j;
        String r45 = String.valueOf(r116.element);
        r44.getClass();
        Intrinsics.checkNotNullParameter(r45, "<set-?>");
        r44.b = r45;
        String r46 = String.valueOf(r25.element);
        Intrinsics.checkNotNullParameter(r46, "<set-?>");
        r44.a = r46;
        String r47 = String.valueOf(r11);
        Intrinsics.checkNotNullParameter(r47, "<set-?>");
        r44.c = r47;
        r44.d = 1;
        if (RealTimeChorusBusinessContext.Companion.f() == true) goto L137;
        w.a(KtvMidiStageViewModel.TAG, "reportClientChorusInfo chorusId : " + r116.element + " segment : " + r25.element + "  curSentenceIndex : " + (r1.e + 1) + " segmentTotalScore : " + r2.g + "  scoreCount : " + r2.h + " segmentAvgScore : " + r111.element + " curScore : $" + r1.d);
        com.bytedance.android.live.ktv.common.midi.k r310 = r1;
        r20 = r2;
        RxUtilKt.c(((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).reportClientChorusInfo(r110, r116.element, (long) r25.element, (double) r111.element, (double) r38, (long) r30.element, (long) r112.element, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r33, r116, r25, r111, r38, r210, r30, r112, r310), new g(r33, r116, r25, r111, r38, r210, r30, r112, r310)), r20.e);
        r21 = r310;
        goto L129
    L137:
        return;
    L115:
        r41 = null;
    L109:
        r36 = 0;
    L103:
        r115 = null;
    L97:
        r32 = 0.0f;
    L89:
        r29 = null;
    L81:
        r110 = 0;
        goto L82
    L51:
        r15 = null;
        goto L52
    L53:
        r16 = null;
        goto L54
    L38:
        if (r10.b() != 1) goto L40;
        boolean r48 = true;
    L41:
        if (r48 == true) goto L43;
        r2.g = 0.0f;
        r2.h = 0;
        r2.j.d = 0;
        return;
    L40:
        r48 = false;
        goto L41
    L128:
        r20 = r2;
        r21 = r1;
        goto L129
    L29:
        if (r1.c <= 0) goto L32;
        if (r7 != (-1)) goto L32;
    L33:
        r9 = true;
        goto L34
    L135:
        return;
    L12:
        if (r5.getVisibility() != 0) goto L24;
        if (r1 == null) goto L20;
        KtvComponentMidiView r49 = r2.c;
        if (r49 == null) goto L17;
        r49.F9(r1, r4, false);
    L17:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r50 = KtvChallengeDataContext.Companion.a();
        if (r50 == null) goto L20;
        r50.onMidiScoreChanged(r1);
    L20:
        if (r4 == null) goto L24;
        r4.longValue();
        KtvComponentMidiView r51 = r2.c;
        if (r51 == null) goto L24;
        r51.R2(r4.longValue());
        goto L24
    L8:
        r1 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
