package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.PlayFlag;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.r2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class c extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a {
    public com.bytedance.android.livesdk.ktvimpl.base.sei.k a;
    public final boolean b;
    public final boolean c;
    public final KtvContext d;
    public final BaseCoreViewModel e;
    public final sb0.b f;
    public final Function2<Integer, Long, Unit> g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
    }

    public static long j(com.bytedance.android.livesdk.ktvimpl.base.sei.k r7) {
        RealTimeChorusBusinessContext.a r0 = RealTimeChorusBusinessContext.Companion;
        RealTimeChorusBusinessContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.j<fd2.s> r2 = r1.m454getService();
        if (r2 == null) goto L9;
        fd2.s r3 = (fd2.s) r2.getValue();
        if (r3 == null) goto L9;
        long r4 = r3.Qm();
    L10:
        long r5 = (long) ((r7.y() + r7.m()) * 1000);
        if (RealTimeChorusBusinessContext.a.g() == false) goto L18;
        if (r0.j() == false) goto L18;
        if (r4 <= 1000) goto L18;
        return r4;
    L18:
        return r5;
    L9:
        r4 = 0;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void f(com.bytedance.android.livesdk.ktvimpl.base.sei.k r8) {
        Intrinsics.checkNotNullParameter(r8, "seiModel");
        int r0 = r8.C();
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r1 = this.a;
        String r3 = null;
        if (r1 != null) goto L5;
    L27:
        MusicPanel r2 = this.e.getCurState().b();
        StringBuilder r4 = new StringBuilder("ktv_state_change,sei state:");
        r4.append(r8.C());
        r4.append(",last state:");
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = this.a;
        if (r5 == null) goto L30;
        Integer r6 = Integer.valueOf(r5.C());
    L31:
        r4.append(r6);
        r4.append(",remoteMusicTitle:");
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r7 = r8.w();
        if (r7 == null) goto L34;
        String r9 = r7.g();
    L35:
        r4.append(r9);
        r4.append("，flag:");
        r4.append(r8.x());
        String r10 = r4.toString();
        String r11 = bb0.b.b();
        StringBuilder r12 = new StringBuilder("MusicPanel：");
        if (r2 == null) goto L40;
        KtvMusic r13 = r2.a;
        if (r13 == null) goto L40;
        r3 = r13.getMTitle();
    L40:
        r12.append(r3);
        r12.append(", ");
        r12.append(r10);
        ALogger.i(r11, r12.toString());
        this.a = r8;
    L41:
        ALogger.i("logKtvMainPath", ("listener :" + r8.C()) + ", invoke class :" + c.class.getSimpleName());
        int r14 = r8.C();
        if (r14 == 0) goto L70;
        if (r14 == 1) goto L68;
        if (r14 == 2) goto L48;
        return;
    L48:
        if (((Boolean) KtvSettingHelper.l.getValue()).booleanValue() == false) goto L64;
        if (r8.x() != PlayFlag.NORMAL.ordinal()) goto L64;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r15 = r8.w();
        if (r15 == null) goto L55;
        String r16 = r15.h();
        if (r16 == null) goto L55;
    L57:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.e(r16) == false) goto L64;
        if (this.f.a() == true) goto L64;
        if (this.f.c().isAudienceLinkEngineOn() == false) goto L64;
        ALogger.i("logKtvMainPath", "listener change singer from sing state, invoke class :".concat(c.class.getSimpleName()));
        m(r8);
    L55:
        r16 = "";
    L64:
        if (KtvSettingHelper.w() == false) goto L66;
        l(r8);
    L66:
        n(r8);
        return;
    L68:
        if (r8.x() != PlayFlag.NORMAL.ordinal()) goto L73;
        m(r8);
        return;
    L73:
        return;
    L70:
        o(KtvRoomLyricsStateMachineConfig.a.h.c);
        return;
    L34:
        r9 = null;
        goto L35
    L30:
        r6 = null;
        goto L31
    L5:
        if (r0 != r1.C()) goto L27;
        Long r17 = Long.valueOf(r8.j());
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r18 = r8.w();
        if (r18 == null) goto L9;
        String r19 = r18.h();
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r20 = this.a;
        if (r20 == null) goto L13;
        Long r21 = Long.valueOf(r20.j());
    L14:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r22 = this.a;
        if (r22 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r23 = r22.w();
        if (r23 == null) goto L19;
        String r24 = r23.h();
    L21:
        if (Intrinsics.areEqual(r17, r21) == true) goto L23;
    L25:
        boolean r25 = false;
    L26:
        if (r25 == true) goto L41;
    L23:
        if (Intrinsics.areEqual(r19, r24) == false) goto L25;
        r25 = true;
    L19:
        r24 = null;
        goto L21
    L13:
        r21 = null;
        goto L14
    L9:
        r19 = null;
        goto L10
    }

    public MusicPanel k(com.bytedance.android.livesdk.ktvimpl.base.sei.k r2) {
        Intrinsics.checkNotNullParameter(r2, "seiModel");
        return com.bytedance.android.livesdk.ktvimpl.base.util.o.d(r2);
    }

    public final void l(com.bytedance.android.livesdk.ktvimpl.base.sei.k r6) {
        ALogger.i("logKtvMainPath", ("handleNormalLyricsSei :" + r6.d()) + ", invoke class :" + c.class.getSimpleName());
        int r0 = r6.d();
        KtvRoomLyricsStateMachineConfig.d r1 = null;
        if (r0 == 0) goto L58;
        if (r0 == 1) goto L47;
        if (r0 != 3) goto L8;
        o(new KtvRoomLyricsStateMachineConfig.a.e(k(r6), r6, j(r6)));
        return;
    L8:
        if (r0 == 4) goto L36;
        if (r0 != 5) goto L12;
        o(new KtvRoomLyricsStateMachineConfig.a.d(r6));
        return;
    L12:
        if (r0 == 6) goto L15;
        return;
    L15:
        if ((this.e.getCurState() instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L21;
        List<MusicPanel> r2 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(this.d);
        if (r2 == null) goto L21;
        if ((!r2.isEmpty()) != true) goto L21;
        return;
    L21:
        if (this.c == false) goto L33;
        long r3 = r6.j();
        BaseCoreViewModel r7 = this.e;
        if (r7 == null) goto L127;
        KtvRoomLyricsStateMachineConfig.d r8 = r7.getCurState();
        if (r8 == null) goto L128;
        MusicPanel r9 = r8.b();
        if (r9 == null) goto L129;
        KtvMusic r10 = r9.a;
        if (r10 != null) goto L31;
        return;
    L31:
        if (r3 != r10.getMId()) goto L131;
        o(KtvRoomLyricsStateMachineConfig.a.h.c);
        return;
    L131:
        return;
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L33:
        o(KtvRoomLyricsStateMachineConfig.a.h.c);
        return;
    L36:
        if (((Boolean) KtvSettingHelper.t1.getValue()).booleanValue() == true) goto L38;
    L44:
        o(new KtvRoomLyricsStateMachineConfig.a.b(k(r6), j(r6)));
        return;
    L38:
        if (this.a != null) goto L44;
        if (r6.K() == false) goto L44;
        if ((this.e.getCurState() instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L44;
        o(new KtvRoomLyricsStateMachineConfig.a.e(k(r6), r6, j(r6)));
        goto L44
    L47:
        if (KtvSettingHelper.w() == true) goto L49;
        return;
    L49:
        if (r6.C() == 2) goto L51;
        return;
    L51:
        if (this.f.b().b() == false) goto L139;
        BaseCoreViewModel r4 = this.e;
        if (r4 == null) goto L56;
        r1 = r4.getCurState();
    L56:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L140;
        p(r6);
        return;
    L140:
        return;
    L139:
        return;
    L58:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.a() == true) goto L108;
        boolean r5 = false;
        if (KtvSettingHelper.w() == false) goto L87;
        if (this.f.b().b() == true) goto L108;
        if (((Boolean) KtvSettingHelper.Z.getValue()).booleanValue() == false) goto L77;
        String r11 = r6.p();
        if (r11 != null) goto L71;
    L74:
        boolean r12 = true;
    L75:
        if (r12 == false) goto L108;
    L110:
        if (r6.v() == 1) goto L112;
    L118:
        if (r5 == false) goto L143;
        BaseCoreViewModel r13 = this.e;
        if (r13 == null) goto L123;
        r1 = r13.getCurState();
    L123:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L144;
        p(r6);
        return;
    L144:
        return;
    L143:
        return;
    L112:
        if (this.f.isAnchor() == true) goto L118;
        if (this.b == false) goto L118;
        if ((this.e.getCurState() instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L118;
        o(new KtvRoomLyricsStateMachineConfig.a.b(k(r6), (long) ((r6.y() + r6.m()) * 1000)));
        return;
    L71:
        if (r11.length() == 0) goto L74;
        r12 = false;
        goto L75
    L77:
        List<com.bytedance.android.livesdk.ktvimpl.base.sei.v> r14 = r6.l();
        if (r14 != null) goto L80;
    L83:
        boolean r15 = true;
    L84:
        if (r15 == true) goto L110;
    L80:
        if (r14.isEmpty() == true) goto L83;
        r15 = false;
        goto L84
    L87:
        if (((Number) this.d.getKtvAllState().getValue()).intValue() == 8) goto L108;
        if (((Boolean) KtvSettingHelper.Z.getValue()).booleanValue() == false) goto L100;
        String r16 = r6.p();
        if (r16 != null) goto L94;
    L97:
        boolean r17 = true;
    L98:
        if (r17 == true) goto L110;
    L94:
        if (r16.length() == 0) goto L97;
        r17 = false;
        goto L98
    L100:
        List<com.bytedance.android.livesdk.ktvimpl.base.sei.v> r18 = r6.l();
        if (r18 != null) goto L103;
    L106:
        boolean r19 = true;
    L107:
        if (r19 == true) goto L110;
    L103:
        if (r18.isEmpty() == true) goto L106;
        r19 = false;
    L108:
        r5 = true;
        goto L110
    }

    public final void m(com.bytedance.android.livesdk.ktvimpl.base.sei.k r12) {
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r0 = r12.w();
        if (r0 == null) goto L6;
        String r1 = r0.h();
        if (r1 == null) goto L6;
    L8:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.e(r1) == false) goto L10;
        MusicPanel r2 = this.e.getCurState().b();
        Boolean r3 = null;
        if (r2 == null) goto L24;
        KtvMusic r4 = r2.a;
    L25:
        ALogger.i("logKtvMainPath", ("isSinger，curStateMusic:" + r4 + ',' + this.f.c().isAudienceLinkEngineOn()) + ", invoke class :" + c.class.getSimpleName());
        Boolean r5 = Boolean.valueOf(this.f.c().isAudienceLinkEngineOn());
        if (r5.booleanValue() == false) goto L28;
        r3 = r5;
    L28:
        if (r3 == null) goto L52;
        r3.booleanValue();
        MusicPanel r6 = this.f.d().a();
        if (r6 == null) goto L53;
        boolean r7 = com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.d(r6.a);
        if (r6.a.getMId() != r12.j()) goto L54;
        if (r7 == false) goto L55;
        boolean r13 = this.f.a();
        ALogger.i("logKtvMainPath", ("切换身份：" + r13) + ", invoke class :" + Boolean.class.getSimpleName());
        int r8 = mb0.f.a;
        Long r9 = Long.valueOf(r6.a.getMId());
        String r10 = r6.a.getMTitle();
        JSONObject r11 = new JSONObject();
        if (r9 == null) goto L37;
        r9.longValue();
        r11.put("songId", r9.longValue());
    L37:
        if (r10 != null) goto L39;
    L42:
        boolean r14 = true;
    L43:
        if (r14 == true) goto L45;
        r11.put("musicName", r10);
    L45:
        r11.put("isSinger", r13);
        int r15 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "guestBeSinger", 0, null, r11, 88);
        if (r13 == true) goto L56;
        this.g.invoke(1, Long.valueOf(r6.a.getMId()));
        pd2.d.M(pd2.d.n, r6, "singer_comfirm");
        this.d.updateCurrentUserIsSinger(true);
        return;
    L56:
        return;
    L39:
        if (r10.length() == 0) goto L42;
        r14 = false;
        goto L43
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L24:
        r4 = null;
        goto L25
    L10:
        if (r2.a(r1) == true) goto L12;
        o(KtvRoomLyricsStateMachineConfig.a.h.c);
        return;
    L12:
        if ((this.e.getCurState() instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L19;
        MusicPanel r16 = this.e.getCurState().b();
        if (r16 == null) goto L19;
        KtvMusic r17 = r16.a;
        if (r17 == null) goto L19;
        if (KtvUtilsKt.s(r17, r12.j(), r1) != true) goto L19;
        return;
    L19:
        o(new KtvRoomLyricsStateMachineConfig.a.c(k(r12)));
        return;
    L6:
        r1 = "";
        goto L8
    }

    public final void n(com.bytedance.android.livesdk.ktvimpl.base.sei.k r8) {
        if (r8.y() <= 0) goto L10;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.ktv.common.model.bean.a> r0 = this.d.getCountDownEvent();
        Intrinsics.checkNotNullParameter(r8, "$this$getCountDownEvent");
        if (r8.C() != 1) goto L7;
        com.bytedance.android.live.ktv.common.model.bean.a r9 = com.bytedance.android.live.ktv.common.model.bean.a.c;
    L8:
        r0.post(r9);
        return;
    L7:
        r9 = new com.bytedance.android.live.ktv.common.model.bean.a((long) (r8.h() * 1000.0f), (long) ((r8.h() - (r8.y() - r8.B())) * 1000.0f));
        goto L8
    }

    public final void o(KtvRoomLyricsStateMachineConfig.a r3) {
        ALogger.i("logKtvMainPath", ("sendEvent :" + r3) + ", invoke class :" + c.class.getSimpleName());
        this.e.sendEvent(r3, "KtvRoomListenerController");
    }

    public final void p(com.bytedance.android.livesdk.ktvimpl.base.sei.k r6) {
        if (this.f.isAnchor() == false) goto L5;
    L7:
        MusicPanel r0 = this.f.d().a();
        if (r0 != null) goto L10;
    L12:
        r0 = null;
    L13:
        if (r0 == null) goto L15;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        o(new KtvRoomLyricsStateMachineConfig.a.e(k(r6), r6, j(r6)));
        return;
    L19:
        return;
    L15:
        r1 = false;
        goto L16
    L10:
        if (KtvUtilsKt.s(r0.a, r6.j(), r6.A()) == false) goto L12;
    L5:
        if (this.f.c().isAudienceLinkEngineOn() == true) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void g(com.bytedance.android.livesdk.ktvimpl.base.sei.k r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "seiModel");
        Intrinsics.checkNotNullParameter(r3, "sourceSei");
        l(r2);
        n(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(KtvContext r3, BaseCoreViewModel r4, sb0.b r5, Function2<? super Integer, ? super Long, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "ktvContext");
        Intrinsics.checkNotNullParameter(r4, "coreViewModel");
        Intrinsics.checkNotNullParameter(r5, "dataEntity");
        Intrinsics.checkNotNullParameter(r6, "singerUpdateAction");
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        ReadOnlyProperty r7 = vm2.h.G3;
        KProperty[] r8 = vm2.h.a;
        MusicPanel r1 = null;
        this.b = ((Boolean) r7.getValue(null, r8[239(0xef, float:3.35E-43)])).booleanValue();
        this.c = ((Boolean) vm2.h.a4.getValue(null, r8[259(0x103, float:3.63E-43)])).booleanValue();
        if (r5.b().isAnchor() == false) goto L14;
        MusicPanel r9 = r5.d().a();
        if (r9 != null) goto L7;
        return;
    L7:
        if ((!com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.d(r9.a)) == false) goto L9;
        r1 = r9;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        if (ChorusContext.Companion.c() == true) goto L17;
        r4.sendEvent(new KtvRoomLyricsStateMachineConfig.a.c(r1), "KtvRoomListenerController");
        return;
    L17:
        return;
    }
}
