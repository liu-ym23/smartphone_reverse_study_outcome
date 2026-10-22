package com.larus.im.internal.rtcsdk.impl;

import com.byted.cast.common.CastMonitor;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.im.internal.audio.video.fps.VideoFpsDowngradeLevel;
import com.larus.im.internal.rtcsdk.service.RTCServiceConnectionState;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.VideoEncoderConfig;
import com.ss.bytertc.engine.data.AudioSourceType;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.LocalLogLevel;
import com.ss.bytertc.engine.data.RTCLogConfig;
import com.ss.bytertc.engine.data.VideoRotationMode;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.video.VideoCaptureConfig;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f350031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f350032b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f350033c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f350034d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArraySet<o1> f350035e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f350036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile Pair<? extends Job, String> f350037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f350038h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile cf9.a f350039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @RTCServiceConnectionState
    public static volatile int f350040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile RTCEngine f350041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f350042l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f350043m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final r1 f350044n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final w1 f350045o = null;

    public static final class a implements com.larus.im.service.m {
        public a() {
        }

        @Override // com.larus.im.service.m
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bizID");
        }

        @Override // com.larus.im.service.m
        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bizID");
        }

        @Override // com.larus.im.service.m
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bizID");
            Intrinsics.checkNotNullParameter(r101, "withBizId");
            if (Intrinsics.areEqual(r100, "AVSDK") == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r100, r101) == true) goto L14;
            fe9.a r102 = fe9.a.f476620a;
            StringBuilder r103 = new StringBuilder("engine occupied by ");
            r103.append(r101);
            r103.append(", notify ");
            CopyOnWriteArraySet<o1> r104 = v.f350035e;
            r103.append(r104.size());
            r103.append(" listeners");
            r102.e("FlowRTCEngineManager", r103.toString());
            Iterator<o1> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            r105.next().b(r101);
            goto L8
        L10:
            v.f350031a.getClass();
            v.g(null);
            fe9.a.f476620a.e("FlowRTCEngineManager", "engine occupied notify end");
            return;
        }

        @Override // com.larus.im.service.m
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bizID");
            Intrinsics.checkNotNullParameter(r101, "withBizId");
            if (Intrinsics.areEqual(r100, "AVSDK") == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r101, r100) == false) goto L14;
            fe9.a r102 = fe9.a.f476620a;
            StringBuilder r103 = new StringBuilder("engine destroyed by ");
            r103.append(r101);
            r103.append(", notify ");
            CopyOnWriteArraySet<o1> r104 = v.f350035e;
            r103.append(r104.size());
            r103.append(" listeners");
            r102.e("FlowRTCEngineManager", r103.toString());
            Iterator<T> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            ((o1) r105.next()).a(r101);
            goto L8
        L10:
            fe9.a.f476620a.e("FlowRTCEngineManager", "engine destroyed notify end");
            return;
        }
    }

    public static final class b implements com.larus.im.internal.utils.g0 {
        public b() {
        }

        @Override // com.larus.im.internal.utils.g0
        public final void onThermalStatusChanged(int r100) {
            fe9.h.f476628a.e("FlowRTCEngineManager", "[thermalListener] onThermalStatusChanged:" + r100);
            RTCEngine r101 = v.f350041k;
            if (r101 == null) goto L13;
            Integer r102 = rd9.b.f537343a;
            if (r100 > 1) goto L8;
            VideoFpsDowngradeLevel r103 = VideoFpsDowngradeLevel.NONE;
        L11:
            VideoFpsDowngradeLevel r104 = rd9.b.a(r103, Integer.valueOf(r100));
            v.f350031a.getClass();
            v.i(r101, r104);
            return;
        L8:
            if (r100 > 2) goto L10;
            r103 = VideoFpsDowngradeLevel.MEDIUM;
            goto L11
        L10:
            r103 = VideoFpsDowngradeLevel.LOWER;
            goto L11
        }
    }

    public v() {
    }

    public final synchronized cf9.a d() {
        monitor-enter(this);
        cf9.a r100 = f350039i;     // Catch: Throwable -> L24
        cf9.a r101 = null;
        String r102 = null;
        if (r100 == null) goto L19;
        String r103 = r100.f23544c;     // Catch: Throwable -> L24
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        com.larus.im.internal.utils.v r104 = com.larus.im.internal.utils.v.f350556a;     // Catch: Throwable -> L24
        boolean r105 = CollectionsKt.listOf(new Integer[]{1, 2}).contains(Integer.valueOf(r100.f23546e));     // Catch: Throwable -> L24
        r104.getClass();     // Catch: Throwable -> L24
        Object r106 = com.larus.im.internal.utils.v.b(r103, true, r105);     // Catch: Throwable -> L24
        if (Result.m9455isFailureimpl(r106) == false) goto L11;
        r106 = null;
    L11:
        com.larus.im.internal.utils.v.a r107 = (com.larus.im.internal.utils.v.a) r106;     // Catch: Throwable -> L24
        if (r107 == null) goto L14;
        r102 = r107.f350561b;     // Catch: Throwable -> L24
    L14:
        if (r102 != null) goto L16;
        r102 = "";
    L16:
        cf9.a r108 = cf9.a.a(r100, null, null, r102, false, 0, 27);     // Catch: Throwable -> L24
        f350039i = r108;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r108;
    L19:
        cf9.a r109 = f350039i;     // Catch: Throwable -> L24
        if (r109 == null) goto L22;
        r101 = cf9.a.a(r109, null, null, null, false, 0, 31);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return r101;
    L24:
        th = move-exception;
        throw th;
    }

    static {
        f350031a = new v();
        f350032b = new Object();
        f350033c = new AtomicBoolean(false);
        f350034d = new AtomicBoolean(false);
        f350035e = new CopyOnWriteArraySet();
        f350038h = new b();
        f350040j = 3;
        f350042l = new f();
        f350043m = new d();
        f350044n = new r1();
        f350045o = new w1();
    }

    public static void f() {
        if (f350034d.compareAndSet(false, true) == false) goto L22;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L13
        Lazy r101 = com.larus.im.internal.utils.f0.f350538a;     // Catch: Throwable -> L13
        com.larus.im.internal.utils.m r102 = (com.larus.im.internal.utils.m) r101.getValue();     // Catch: Throwable -> L13
        if (r102 == null) goto L7;
        r102.a(f350038h);     // Catch: Throwable -> L13
    L7:
        com.larus.im.internal.utils.m r103 = (com.larus.im.internal.utils.m) r101.getValue();     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        r103.b();     // Catch: Throwable -> L13
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L13
    L15:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        fe9.h.f476628a.c("FlowRTCEngineManager", "[initializeMonitors] failed to initialize thermal monitor", r106);
    L18:
        com.larus.im.service.t.f350889a.getClass();
        com.larus.im.service.t.a.f350891b.b(new a());
        return;
    L10:
        r104 = null;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void h() {
        com.larus.im.internal.delegate.c r100 = com.larus.im.internal.delegate.c.f348197a;
        if (r100.isTestChannel() == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        LocalLogLevel r102 = LocalLogLevel.INFO;
        if (r101 == false) goto L15;
        int r103 = com.larus.im.internal.utils.a.f350523a;
        String r104 = null;
        File r105 = r100.getApplication().getExternalFilesDir(null);
        if (r105 == null) goto L14;
        r104 = r105.getAbsolutePath();
    L14:
        String r106 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r104, "audio"}), File.separator, null, null, 0, null, null, 62, null);
    L16:
        if (r101 == false) goto L18;
        int r107 = 100;
    L19:
        RTCEngine.setLogConfig(new RTCLogConfig(r102, r106, r107, "flow_rtc"));
        fe9.c.f476624a.e("FlowRTCEngineManager", "[setRTCLog] done");
        return;
    L18:
        r107 = 20;
        goto L19
    L15:
        r106 = r100.getApplication().getCacheDir().getPath();
        goto L16
    L5:
        if (r100.o() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static void c(String r100) {
        Object r101 = f350032b;
        monitor-enter(r101);
        f350031a.getClass();     // Catch: Throwable -> L7
        g(null);     // Catch: Throwable -> L7
        f350036f = null;     // Catch: Throwable -> L7
        com.larus.im.service.t.f350889a.getClass();     // Catch: Throwable -> L7
        com.larus.im.service.k r102 = com.larus.im.service.t.a.f350891b;     // Catch: Throwable -> L7
        r102.getClass();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("AVSDK", "bizId");     // Catch: Throwable -> L7
        r102.c("AVSDK", "AVSDK");     // Catch: Throwable -> L7
        fe9.h.f476628a.e("FlowRTCEngineManager", "[destroy] end trace: " + r100);     // Catch: Throwable -> L7
        f350033c.set(false);     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void g(RTCEngine r100) {
        if (Intrinsics.areEqual(f350041k, r100) == true) goto L11;
        RTCEngine r101 = f350041k;
        if (r101 == null) goto L7;
        r101.registerAudioProcessor(null);
    L7:
        RTCEngine r102 = f350041k;
        if (r102 == null) goto L10;
        r102.registerAudioFrameObserver(null);
    L10:
        f350041k = r100;
    L11:
        if (r100 == null) goto L13;
        r100.registerAudioProcessor(f350042l);
    L13:
        if (r100 == null) goto L16;
        r100.registerAudioFrameObserver(f350043m);
        return;
    }

    public static void j(String r100) {
        Pair<? extends Job, String> r101 = f350037g;
        if (r101 != null) goto L5;
        return;
    L5:
        Job r102 = r101.component1();
        String r103 = r101.component2();
        if (r102.isActive() == false) goto L8;
        r102.cancel(new CancellationException("cancel by ".concat(r100)));
        fe9.h.f476628a.e("FlowRTCEngineManager", "[tryCancelDestroyJob] cancel destroyJob by " + r100 + ", traceId: " + r103);
    L8:
        AtomicBoolean r104 = f350033c;
        if (r104.get() == false) goto L12;
        r104.set(false);
        fe9.h.f476628a.e("FlowRTCEngineManager", "[tryCancelDestroyJob] reset pending flag by " + r100 + ", traceId: " + r103);
        return;
    }

    public static void k(i r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        r100.f349898a = false;
        r1 r101 = f350044n;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "handler");
        fe9.h r102 = fe9.h.f476628a;
        r102.e("RTCEngineEventHandlerManager", "before removeHandler, size: " + r101.f349983a.size() + ", hashCode: " + r100.hashCode());
        r101.f349983a.remove(r100);
        r102.e("RTCEngineEventHandlerManager", "after removeHandler, size: " + r101.f349983a.size() + ", hashCode: " + r100.hashCode());
    }

    public final void e(RTCEngine r100) {
        r100.setAudioSourceType(AudioSourceType.AUDIO_SOURCE_TYPE_EXTERNAL);
        cf9.a r101 = d();
        if (r101 == null) goto L6;
        r100.setBusinessId(r101.f23543b);
    L6:
        g(r100);
        cf9.a r102 = d();
        if (r102 == null) goto L9;
        String r103 = r102.f23542a;
    L10:
        f350036f = r103;
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        r105.put(MessageIndication.STATUS_INTERRUPT, ((Number) com.larus.im.internal.delegate.w.f348284t.getValue()).intValue());
        r105.put(CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_LOST, ((Number) com.larus.im.internal.delegate.w.f348283s.getValue()).intValue());
        Unit r106 = Unit.INSTANCE;
        r104.put("rtc.signaling_timeout", r105);
        r100.setRuntimeParameters(r104);
        r100.enableAudioVADReport(com.larus.im.internal.delegate.w.i().f348378f);
        if (com.larus.im.internal.delegate.r0.f348258b.l() == false) goto L13;
        r100.setAudioScenario(AudioScenarioType.CHATROOM);
    L14:
        cf9.a r107 = d();
        int r108 = 0;
        if (r107 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == true) goto L37;
    L25:
        com.larus.im.internal.utils.m r110 = (com.larus.im.internal.utils.m) com.larus.im.internal.utils.f0.f350538a.getValue();
        if (r110 == null) goto L28;
        r108 = r110.getCurrentThermalStatus();
    L28:
        Integer r111 = rd9.b.f537343a;
        if (r108 > 1) goto L32;
        VideoFpsDowngradeLevel r112 = VideoFpsDowngradeLevel.NONE;
    L35:
        i(r100, rd9.b.a(r112, Integer.valueOf(r108)));
        int r113 = r100.setVideoRotationMode(VideoRotationMode.FOLLOW_GSENSOR);
        fe9.h r114 = fe9.h.f476628a;
        r114.e("FlowRTCEngineManager", "setVideoRotationMode, ret=" + r113);
        JSONObject r115 = new JSONObject();
        r115.put("rtc.enable_drop_frame_on_clarity", com.larus.im.internal.delegate.w.p().f348440d);
        r114.e("FlowRTCEngineManager", "setRuntimeParameters, ret=" + r100.setRuntimeParameters(r115) + ", parameters=" + r115);
        StringBuilder r116 = new StringBuilder("[createRTCEngine] initialized, engine:");
        r116.append(r100);
        r114.e("FlowRTCEngineManager", r116.toString());
        return;
    L32:
        if (r108 > 2) goto L34;
        r112 = VideoFpsDowngradeLevel.MEDIUM;
        goto L35
    L34:
        r112 = VideoFpsDowngradeLevel.LOWER;
        goto L35
    L37:
        JSONObject r117 = new JSONObject();     // Catch: JSONException -> L23
        r117.put("rtc.enable_skip_bluetooth_connect_permission", true);     // Catch: JSONException -> L23
        r100.setRuntimeParameters(r117);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L17:
        if (r107.f23545d != true) goto L19;
        r109 = true;
        goto L20
    L13:
        r100.setAudioScenario(AudioScenarioType.GAMESTREAMING);
        goto L14
    L9:
        r103 = null;
        goto L10
    }

    public static RTCEngine a(EngineConfig r100, r1 r101) {
        final CountDownLatch r102 = new CountDownLatch(1);
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        com.larus.im.service.t.f350889a.getClass();
        com.larus.im.service.t.a.f350891b.h(new com.larus.im.service.n("AVSDK", r100, r101, new t()), new u(r103, r102));
        r102.await();
        com.larus.im.service.e r104 = (com.larus.im.service.e) r103.element;
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.X();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, java.lang.Object, java.lang.String] */
    public static void b(String r110, r1 r111) {
        Object r100 = f350032b;
        monitor-enter(r100);
        Ref.ObjectRef r101 = new Ref.ObjectRef();     // Catch: Throwable -> L40
        r101.element = r110;     // Catch: Throwable -> L40
        com.larus.im.internal.delegate.r0 r112 = com.larus.im.internal.delegate.r0.f348258b;     // Catch: Throwable -> L40
        String r102 = r112.n();     // Catch: Throwable -> L40
        fe9.h r103 = fe9.h.f476628a;     // Catch: Throwable -> L40
        r103.e("FlowRTCEngineManager", "[createRTCEngine] appId:" + ((String) r101.element) + ", businessId:" + r102);     // Catch: Throwable -> L40
        boolean r104 = false;
        if (((CharSequence) r101.element).length() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L17;
        com.larus.im.internal.delegate.c1 r106 = com.larus.im.internal.delegate.c1.f348202a;     // Catch: Throwable -> L40
        ?? r107 = com.flow.kmp.common.util.g.b(gd9.z.a.b("flow_av_rtc_engine_config", SliceInitService.DEFAULT_SWITCH)).optString("app_id");     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L40
        if (r107.length() <= 0) goto L12;
        r104 = true;
    L12:
        if (r104 == false) goto L14;
        r101.element = r107;     // Catch: Throwable -> L40
        r103.e("FlowRTCEngineManager", "[createRTCEngine] use cached config, appId:".concat(r107));     // Catch: Throwable -> L40
    L18:
        T r108 = r101.element;     // Catch: Throwable -> L40
        v r109 = f350031a;     // Catch: Throwable -> L40
        cf9.a r113 = r109.d();     // Catch: Throwable -> L40
        if (r113 == null) goto L21;
        String r114 = r113.f23542a;     // Catch: Throwable -> L40
    L23:
        if (Intrinsics.areEqual(r108, r114) == true) goto L28;
        cf9.a r115 = r109.d();     // Catch: Throwable -> L40
        if (r115 != null) goto L27;
        r115 = new cf9.a("", "", "", false, 0);     // Catch: Throwable -> L40
    L27:
        f350039i = cf9.a.a(r115, (String) r101.element, r112.n(), null, false, 0, 28);     // Catch: Throwable -> L40
    L28:
        int r116 = q1.f349981a;     // Catch: Throwable -> L40
        EngineConfig r117 = q1.a((String) r101.element);     // Catch: Throwable -> L40
        h();     // Catch: Throwable -> L40
        RTCEngine r118 = f350041k;     // Catch: Throwable -> L40
        if (r118 != null) goto L34;
        RTCEngine r119 = a(r117, r111);     // Catch: Throwable -> L40
        if (r119 == null) goto L33;
        r109.e(r119);     // Catch: Throwable -> L40
    L38:
        monitor-exit(r100);
        return;
    L33:
        r103.b("FlowRTCEngineManager", "[createRTCEngine] failed, usePool: true");     // Catch: Throwable -> L40
        goto L38
    L34:
        r103.e("FlowRTCEngineManager", "[createRTCEngine] reuse, engine:" + f350041k);     // Catch: Throwable -> L40
        r118.setRtcVideoEventHandler(r111);     // Catch: Throwable -> L40
        cf9.a r120 = r109.d();     // Catch: Throwable -> L40
        if (r120 == null) goto L38;
        r118.setBusinessId(r120.f23543b);     // Catch: Throwable -> L40
        goto L38
    L21:
        r114 = null;
        goto L23
    L14:
        r103.b("FlowRTCEngineManager", "[createRTCEngine] appId or businessId is empty");     // Catch: Throwable -> L40
        monitor-exit(r100);
        return;
    L17:
        JSONObject r121 = new JSONObject();     // Catch: Throwable -> L40
        r121.put("app_id", r101.element);     // Catch: Throwable -> L40
        com.larus.im.internal.delegate.c1 r122 = com.larus.im.internal.delegate.c1.f348202a;     // Catch: Throwable -> L40
        gd9.z.a.c("flow_av_rtc_engine_config", r121.toString());     // Catch: Throwable -> L40
        goto L18
    L7:
        r105 = false;
    L40:
        th = move-exception;
        throw th;
    }

    public static void i(RTCEngine r110, VideoFpsDowngradeLevel r111) {
        Integer r100 = rd9.b.f537343a;
        Intrinsics.checkNotNullParameter(r111, "level");
        int[] r101 = rd9.b.a.f537346a;
        int r102 = r101[r111.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L11;
        if (r102 != 3) goto L10;
        com.larus.im.internal.delegate.w.p r103 = com.larus.im.internal.delegate.w.p().f348445i;
        if (r103 != null) goto L15;
        r103 = new com.larus.im.internal.delegate.w.p(18, 3);
    L15:
        VideoCaptureConfig r104 = new VideoCaptureConfig();
        r104.width = r103.f348432a;
        r104.height = r103.f348433b;
        r104.frameRate = r103.f348434c;
        r104.capturePreference = VideoCaptureConfig.CapturePreference.MANUAL;
        int r105 = r110.setVideoCaptureConfig(r104);
        fe9.h r106 = fe9.h.f476628a;
        r106.e("FlowRTCEngineManager", "captureConfig: " + r104 + ", ret=" + r105 + ", downgrade:" + r111.ordinal());
        Intrinsics.checkNotNullParameter(r111, "level");
        int r112 = r101[r111.ordinal()];
        if (r112 == 1) goto L28;
        if (r112 == 2) goto L24;
        if (r112 != 3) goto L23;
        com.larus.im.internal.delegate.w.p r107 = com.larus.im.internal.delegate.w.p().f348446j;
        if (r107 != null) goto L29;
        r107 = new com.larus.im.internal.delegate.w.p(18, 3);
    L29:
        Intrinsics.checkNotNullParameter(r111, "level");
        int r108 = r101[r111.ordinal()];
        if (r108 != 1) goto L32;
        com.larus.im.internal.delegate.w.f r109 = com.larus.im.internal.delegate.w.p().f348439c;
        if (r109 != null) goto L46;
        r109 = new com.larus.im.internal.delegate.w.f(0, 0, 63);
    L46:
        if (com.larus.im.internal.delegate.w.p().f348440d == false) goto L48;
        int r113 = r107.f348434c / r109.f348367c;
    L49:
        VideoEncoderConfig r114 = new VideoEncoderConfig();
        r114.width = r107.f348432a;
        r114.height = r107.f348433b;
        r114.frameRate = r113;
        r106.e("FlowRTCEngineManager", "encoderConfig: " + r114 + ", ret=" + r110.setVideoEncoderConfig(r114) + ", downgrade:" + r111.ordinal());
        int r115 = r110.enableNtpTimestampInRtp(true);
        StringBuilder r116 = new StringBuilder("enableNtpTimestampInRtp, ret=");
        r116.append(r115);
        r106.e("FlowRTCEngineManager", r116.toString());
        return;
    L48:
        r113 = r107.f348434c;
        goto L49
    L32:
        if (r108 == 2) goto L39;
        if (r108 != 3) goto L38;
        r109 = com.larus.im.internal.delegate.w.p().f348447k;
        if (r109 != null) goto L46;
        r109 = new com.larus.im.internal.delegate.w.f(0, 3, 59);
        goto L46
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        r109 = com.larus.im.internal.delegate.w.p().f348444h;
        if (r109 != null) goto L46;
        r109 = new com.larus.im.internal.delegate.w.f(0, 4, 59);
        goto L46
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        com.larus.im.internal.delegate.w.p r117 = com.larus.im.internal.delegate.w.p().f348443g;
        if (r117 != null) goto L27;
        r117 = new com.larus.im.internal.delegate.w.p(24, 3);
    L27:
        r107 = r117;
        goto L29
    L28:
        r107 = com.larus.im.internal.delegate.w.o();
        goto L29
    L10:
        throw new NoWhenBranchMatchedException();
    L11:
        r103 = com.larus.im.internal.delegate.w.p().f348442f;
        if (r103 != null) goto L15;
        r103 = new com.larus.im.internal.delegate.w.p(24, 3);
        goto L15
    L14:
        r103 = com.larus.im.internal.delegate.w.n();
        goto L15
    }
}
