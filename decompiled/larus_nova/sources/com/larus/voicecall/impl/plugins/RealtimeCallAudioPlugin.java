package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AVInnerPlayerAdapter;
import com.larus.audio.call.record.CaptureBackTraceReadScene;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.platform.model.NotificationBusiness;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes32.dex */
public final class RealtimeCallAudioPlugin extends com.larus.audio.call.plugins.u<r> {
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f378415J;
    public final String K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public boolean R;
    public final hga.b S;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f378416a = null;

        static {
            int[] r100 = new int[TriggerMode.values().length];
            r100[TriggerMode.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TriggerMode.CLIM_IN_STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TriggerMode.CLIM_IN_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f378416a = r100;
        }
    }

    public static final class b extends com.larus.audio.call.play.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeCallAudioPlugin f378417a;

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void a() {
            s.c((r) this.f378417a.getContext()).x0().b();
        }

        public b(RealtimeCallAudioPlugin r100) {
            this.f378417a = r100;
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void d(com.larus.audio.call.play.h.a r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r100, "data");
            s.c((r) this.f378417a.getContext()).x0().f(r100.f289332b, r100.f289333c);
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void g(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "audio");
            Intrinsics.checkNotNullParameter(r100, "audio");
            com.larus.voicecall.impl.q r101 = ((r) this.f378417a.getContext()).h();
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }
    }

    @Override // com.larus.audio.call.plugins.u
    public final void F1(com.larus.audio.call.play.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.larus.audio.call.plugins.u
    public final void a4() {
        RealtimeCallUtil.f379424a.getClass();
        if (((RealtimeCallSceneModeHelloConfig) RealtimeCallUtil.f379451p.getValue()).getEnableSceneHello() == false) goto L16;
        com.larus.voicecall.impl.scene.o r100 = RealtimeCallUtil.f379446l;
        if (r100 == null) goto L11;
        SceneModel r101 = r100.f378741a;
        if (r101 == null) goto L11;
        boolean r102 = true;
        if (r101.getNotTriggerHello() != true) goto L11;
    L12:
        if (r102 == true) goto L16;
        if (RealtimeCallUtil.f379446l == null) goto L16;
        s.c((r) getContext()).T1();
    L11:
        r102 = false;
    L16:
        super.a4();
    }

    public final boolean i4() {
        return ((Boolean) this.N.getValue()).booleanValue();
    }

    public final boolean j4() {
        return ((Boolean) this.M.getValue()).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.larus.voicecall.impl.plugins.s0] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.plugins.t0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.voicecall.impl.plugins.u0] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.voicecall.impl.plugins.v0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.voicecall.impl.plugins.i0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.voicecall.impl.plugins.j0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.voicecall.impl.plugins.k0] */
    @Override // com.larus.audio.call.plugins.u
    public final u68.c m3() {
        FLogger.f375446a.i(this.K, "createAudioPlayer: useRTCInnerPlayer=" + ((Boolean) this.L.getValue()).booleanValue() + ", useAVMedia=" + i4() + ", asyncPlay=" + this.I);
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L5;
    L12:
        id9.d r100 = ((r) getContext()).j();
        Intrinsics.checkNotNull(r100);
        return new AVInnerPlayerAdapter(r100, new com.larus.audio.call.play.g(new s0(this), new t0(this), new u0(this), new v0(this), new i0(this), new j0(this), new k0(this)));
    L5:
        if (i4() == true) goto L12;
        if (this.I == false) goto L11;
        return new v3a.f(((r) getContext()).params(), J3(), ((Boolean) this.f289527m.getValue()).booleanValue());
    L11:
        return new com.larus.audio.call.play.c(((r) getContext()).params(), J3(), ((Boolean) this.f289527m.getValue()).booleanValue(), null, 0);
    }

    @Override // com.larus.audio.call.plugins.u
    public final v68.a n3() {
        FLogger.f375446a.i(this.K, "createAudioRecorder: useRTCInnerRecord=" + j4() + ", useAVMedia=" + i4() + ", asyncRecord=" + this.f378415J);
        if (j4() == false) goto L5;
    L17:
        RealtimeCallUtil r100 = RealtimeCallUtil.f379424a;
        AudioSessionType r101 = ((r) getContext()).params().f288759s;
        boolean r102 = ((r) getContext()).params().f288766z;
        boolean r103 = J3();
        r100.getClass();
        boolean r104 = RealtimeCallUtil.K(r101, r102, r103);
        if (((r) getContext()).params().f288759s != AudioSessionType.MMT) goto L22;
        if (r104 == false) goto L22;
        AvAecType r105 = AvAecType.RTC_SPEECH;
    L24:
        AvAecType r106 = r105;
        id9.d r107 = ((r) getContext()).j();
        Intrinsics.checkNotNull(r107);
        Function0 r108 = new m0(this);
        if (j4() == false) goto L48;
        ObricAsrDelegate r109 = ObricAsrDelegate.f392831b;
        if (r109.a() == false) goto L48;
        if (r109.k() == false) goto L48;
        int r110 = r109.f();
    L50:
        return new com.larus.audio.call.record.a(r107, r106, r108, r110, null, 16);
    L48:
        r110 = 1;
    L22:
        if (((r) getContext()).params().f288766z == false) goto L26;
        r105 = AvAecType.NONE;
        goto L24
    L26:
        if (J3() == false) goto L33;
        if (((Boolean) this.O.getValue()).booleanValue() == false) goto L33;
        if (r104 == false) goto L31;
        r105 = AvAecType.RTC_SPEECH;
        goto L24
    L31:
        r105 = AvAecType.RTC;
    L33:
        if (J3() == false) goto L36;
        r105 = AvAecType.SAMI;
        goto L24
    L36:
        if (J3() == false) goto L38;
    L40:
        r105 = AvAecType.NONE;
        goto L24
    L38:
        if (((Boolean) RealtimeCallUtil.f379433e0.getValue()).booleanValue() == false) goto L40;
        r105 = AvAecType.RTC;
        goto L24
    L5:
        if (i4() == true) goto L17;
        if (w3() == false) goto L13;
        com.larus.audio.call.record.k r111 = h4();
        if (r111 == null) goto L52;
        return r111;
    L52:
        return new com.larus.audio.call.record.g();
    L13:
        if (this.f378415J == false) goto L16;
        return new com.larus.audio.call.record.e(J3());
    L16:
        return new com.larus.audio.call.record.f(null, 0, J3(), 2);
    }

    @Override // com.larus.audio.call.plugins.u
    public final int u3() {
        return ((Number) this.Q.getValue()).intValue();
    }

    @Override // com.larus.audio.call.plugins.u
    public final boolean w3() {
        ObricAsrDelegate r100 = ObricAsrDelegate.f392831b;
        if (r100.m() == true) goto L5;
        return false;
    L5:
        if (r100.a() == false) goto L19;
        RealtimeCallParam r101 = ((r) getContext()).params();
        if (Intrinsics.areEqual(r101.f288751k.f288831t, "assistant_scene_mode_click_talk") == false) goto L9;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L20;
        return true;
    L20:
        return false;
    L9:
        if (r101.f288737a == true) goto L14;
        if (r101.f288756p.f288869q == true) goto L14;
        r102 = false;
        goto L15
    L19:
        return false;
    }

    @Override // com.larus.audio.call.plugins.u
    public final boolean x3() {
        return ((Boolean) this.P.getValue()).booleanValue();
    }

    @Override // com.larus.audio.call.plugins.u
    public final Long D3() {
        RealtimeCallParam.g r100 = ((r) getContext()).params().N;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f288811b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.audio.call.plugins.u
    public final Map<String, Object> I3() {
        Map<String, Object> r100 = null;
        t r101 = (t) getContext().c(Reflection.getOrCreateKotlinClass(t.class), null);
        if (r101 == null) goto L7;
        Function0<Map<String, Object>> r102 = r101.X1();
        if (r102 == null) goto L7;
        r100 = r102.invoke();
    L7:
        if (r100 == null) goto L9;
        return r100;
    L9:
        return MapsKt.emptyMap();
    }

    @Override // com.larus.audio.call.plugins.u
    public final void M3() {
        if (w3() == false) goto L6;
        this.S.d();
        return;
    }

    @Override // com.larus.audio.call.plugins.u
    public final void N3() {
        if (w3() == false) goto L6;
        this.S.f(NotificationBusiness.REALTIME_CALL);
        return;
    }

    @Override // com.larus.audio.call.plugins.u
    public final void S3() {
        if (J3() == true) goto L5;
        return;
    L5:
        if (s3().isPlaying() == false) goto L9;
        s.c((r) getContext()).x0().onInterrupt();
        return;
    }

    @Override // com.larus.audio.call.plugins.u
    public final void V3() {
        if (((r) getContext()).params().f288752l.f288792h == 1) goto L5;
        return;
    L5:
        if (this.R == false) goto L12;
        FLogger.f375446a.i(this.K, "onLLMReplyBegin stopRecorder");
        if (this.f289533s == null) goto L9;
        t3().stopRecord();
    L9:
        this.R = false;
        return;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.audio.call.plugins.u
    public final boolean b1() {
        if (((r) getContext()).params().I >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        o1 r101 = s.e((r) getContext());
        if (r101 == null) goto L11;
        Boolean r102 = Boolean.valueOf(r101.y1());
    L12:
        com.larus.audio.call.plugins.y0 r103 = com.larus.audio.call.arch.b.d(getContext());
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L23;
        if (r100 == true) goto L21;
        return true;
    L21:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        if (r103.b1() != true) goto L17;
        r104 = true;
        goto L18
    L11:
        r102 = null;
        goto L12
    L5:
        if (((r) getContext()).params().f288759s == AudioSessionType.SAMI) goto L7;
        r100 = true;
        goto L8
    }

    @Override // com.larus.audio.call.plugins.u, com.larus.audio.call.arch.a
    public final void b3() {
        super.b3();
        this.S.h();
    }

    @Override // com.larus.audio.call.plugins.u
    public final void c4() {
        s3().i(new b(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.audio.call.plugins.u, com.larus.audio.call.plugins.t0
    public final void d0() {
        com.larus.voicecall.impl.tracer.o r100 = d3a.a.b(getContext());
        if (r100 == null) goto L5;
        r100.d0();
    L5:
        id9.d r101 = ((r) getContext()).j();
        if (r101 == null) goto L9;
        r101.p(TriggerMode.END_ASR, null);
        return;
    }

    @Override // com.larus.audio.call.plugins.u, com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        if (w3() == false) goto L17;
        hga.b r100 = this.S;
        Long r101 = y3();
        if (r101 != null) goto L7;
    L15:
        long r102 = 50;
    L16:
        hga.b.a.a(r100, r102, NotificationBusiness.REALTIME_CALL);
        goto L17
    L7:
        if (r101.longValue() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        r102 = r101.longValue();
        goto L16
    L9:
        r103 = false;
    L17:
        IWakeupLatencyTrackService.a.b(ObricWakeupLatencyTrackService.f392922b);
    }

    @Override // com.larus.audio.call.plugins.u
    public final void f4() {
        if (w3() == true) goto L5;
        return;
    L5:
        if (((r) getContext()).params().f288739b == false) goto L7;
    L15:
        String r100 = "continuous_talk";
    L16:
        if (r100 == null) goto L18;
        t3().a(r100);
        t3().f(new RealtimeCallAudioPlugin$setRecordStartTrace$1$1(ObricBackTraceLogDelegate.f392833b));
    L18:
        t3().g(new l0(this));
        return;
    L7:
        if (((r) getContext()).params().f288737a == true) goto L15;
        if (((r) getContext()).params().f288756p.f288869q == true) goto L15;
        if (((r) getContext()).params().O == false) goto L14;
        r100 = "click_talk";
        goto L16
    L14:
        r100 = null;
        goto L16
    }

    @Override // com.larus.audio.call.plugins.u
    public final v68.a g4() {
        if (w3() == false) goto L8;
        com.larus.audio.call.record.k r100 = h4();
        if (r100 == null) goto L10;
        return r100;
    L10:
        return n3();
    L8:
        return n3();
    }

    public final com.larus.audio.call.record.k h4() {
        Long r100 = D3();
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        Long r102 = y3();
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
    L11:
        if (r101 <= 0) goto L13;
        long r104 = r101 - r103;
    L14:
        int r105 = com.larus.audio.call.record.k.f289594j;
        return com.larus.audio.call.record.k.a.a(CaptureBackTraceReadScene.REALTIME_CALL, r104, NotificationBusiness.REALTIME_CALL, ((r) getContext()).params().f288742c0);
    L13:
        r104 = System.currentTimeMillis();
        goto L14
    L9:
        r103 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.larus.audio.call.plugins.u
    public final Long y3() {
        RealtimeCallParam.g r100 = ((r) getContext()).params().N;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f288810a;
    }

    @Override // com.larus.audio.call.plugins.u, com.larus.audio.call.arch.a
    public final String T2() {
        return this.K;
    }

    @Override // com.larus.audio.call.plugins.u
    public final void L3(r58.d r100) {
        Intrinsics.checkNotNullParameter(r100, "audioData");
        if (w3() == false) goto L7;
        this.S.g();
        com.larus.voicecall.impl.q r101 = ((r) getContext()).h();
        if (r101 == null) goto L7;
        byte[] r102 = r100.f536321b;
        r101.a(new r58.d(r100.f536320a, r102));
    L7:
        super.L3(r100);
    }

    @Override // com.larus.audio.call.plugins.u
    public final void P3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r100, "id");
        com.larus.voicecall.impl.q r101 = ((r) getContext()).h();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.audio.call.plugins.u
    public final void R3(pf9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        TriggerMode r101 = r100.getType();
        int r102 = a.f378416a[r101.ordinal()];
        if (r102 != 1) goto L5;
        FLogger.f375446a.i(this.K, "[CALL] IMAGE");
        this.R = true;
        s3().d(true, true, "image_triggered");
        return;
    L5:
        if (r102 != 2) goto L7;
        FLogger.f375446a.i(this.K, "[CALL] CLIM_IN_STARTED");
        R1("clim_in_started");
        return;
    L7:
        if (r102 != 3) goto L15;
        FLogger.f375446a.i(this.K, "[CALL] CLIM_IN_END");
        return;
    }

    @Override // com.larus.audio.call.plugins.u
    public final void U3(pf9.c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (w3() == false) goto L6;
        this.S.e();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.audio.call.plugins.u
    public final void i(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
        com.larus.audio.call.plugins.v0 r101 = com.larus.audio.call.arch.b.b(getContext());
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.audio.call.arch.c] */
    @Override // com.larus.audio.call.plugins.u
    public final void Y3(r58.d r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "audioData");
        if (w3() == false) goto L8;
        this.S.i(r100.f536320a);
        s58.a.f540756a.getClass();
        Pair r102 = s58.a.C7569a.b(r100);
        r58.d r103 = (r58.d) r102.component1();
        r58.d r104 = (r58.d) r102.component2();
        this.S.a(r100.f536320a);
        if (x3() == true) goto L25;
        Z3(r100, r103, r104);
        return;
    L25:
        return;
    L8:
        com.larus.voicecall.impl.q r105 = ((r) getContext()).h();
        if (r105 == null) goto L12;
        byte[] r106 = r100.f536321b;
        r105.a(new r58.d(r100.f536320a, r106));
    L12:
        if (x3() == false) goto L15;
        return;
    L15:
        if (j4() == false) goto L17;
    L21:
        com.larus.audio.call.plugins.v0 r107 = com.larus.audio.call.arch.b.b(getContext());
        if (r107 == null) goto L26;
        r107.q2(r100.f536321b, 0);
        return;
    L26:
        return;
    L17:
        if (i4() == true) goto L21;
        super.Y3(r100, r101);
    }

    public RealtimeCallAudioPlugin(final r r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.I = r101;
        this.f378415J = r102;
        this.K = "RealtimeCallAudioPlugin";
        this.L = LazyKt.lazy(new h0(r100));
        this.M = LazyKt.lazy(new n0(r100));
        this.N = LazyKt.lazy(new o0(r100));
        this.O = LazyKt.lazy(new p0(r100));
        this.P = LazyKt.lazy(new q0(r100));
        this.Q = LazyKt.lazy(new r0(r100));
        this.S = ObricBackTraceLogDelegate.f392833b.c();
    }
}
