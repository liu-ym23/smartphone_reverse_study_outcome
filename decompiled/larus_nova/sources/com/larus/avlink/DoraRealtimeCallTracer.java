package com.larus.avlink;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.dora.DoraMode;
import com.larus.avlink.dora.DoraType;
import com.larus.avlink.env.diary.settings.DiaryImageSwitchManager;
import com.larus.avlink.plugins.BaseDoraLiteLiveAiPlugin;
import com.larus.avlink.plugins.DoraETracePlugin;
import com.larus.avlink.plugins.DoraETracer;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.tracer.RealtimeCallTracer;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class DoraRealtimeCallTracer implements IRealtimeCallTracer {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f291373u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<RealtimeCallParam> f291374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f291375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f291376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f291377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f291378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f291379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f291380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f291381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f291382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f291383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f291384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f291385l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f291386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f291387n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile String f291388o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f291389p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f291390q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f291391r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RealtimeCallTracer f291392s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f291393t;

    public static final class a {
    }

    static {
    }

    public DoraRealtimeCallTracer() {
        throw null;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void D(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void G(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void I() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void J(int r100, String r101, int r102) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void W() {
        this.f291392s.D = 1;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f0(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j0(boolean r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void m(RealtimeCallParam r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void m0(String r100) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void n(RealtimeCallParam r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void q(boolean r100, long r101) {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t0() {
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final ouc.d0 x(ouc.d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        return r100;
    }

    public final IDoraService A0() {
        return (IDoraService) this.f291385l.getValue();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void E() {
        this.f291392s.E();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void S() {
        this.f291392s.S();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c() {
        this.f291392s.c();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g() {
        this.f291392s.E();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void n0() {
        this.f291392s.n0();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o0() {
        this.f291392s.o0();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r() {
        this.f291392s.r();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s0() {
        if (this.f291383j == false) goto L5;
        this.f291383j = false;
        this.f291377d = -1;
        this.f291381h = 0;
        this.f291380g = -1;
        this.f291379f = true;
        this.f291384k = true;
        this.f291375b++;
    L5:
        this.f291384k = true;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void t() {
        if (this.f291383j == false) goto L6;
        this.f291383j = false;
        this.f291380g = -1;
        this.f291379f = true;
        this.f291384k = true;
        this.f291375b++;
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void u0() {
        this.f291392s.u0();
    }

    public final String z0() {
        if (Intrinsics.areEqual(this.f291374a.invoke().f288751k.f288831t, DoraMode.DORA_CALL.getValue()) == false) goto L6;
        return DoraType.DORA.getValue();
    L6:
        return DoraType.DORA_RADIO.getValue();
    }

    @Override // com.larus.audio.call.tracer.c
    public final void onSessionStarted() {
        this.f291378e = System.currentTimeMillis();
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final boolean R() {
        return this.f291391r;
    }

    public DoraRealtimeCallTracer(c0 r100) {
        this.f291374a = r100;
        this.f291377d = -1;
        this.f291378e = -1;
        this.f291379f = true;
        this.f291380g = -1;
        this.f291381h = -1;
        this.f291383j = true;
        this.f291384k = true;
        this.f291385l = LazyKt.lazy(new p0());
        this.f291388o = "";
        this.f291389p = LazyKt.lazy(new q0(this));
        this.f291390q = LazyKt.lazy(new r0(this));
        int r101 = RealtimeCallTracer.f379042s0;
        Intrinsics.checkNotNullParameter(r100, "callParam");
        RealtimeCallTracer r102 = new RealtimeCallTracer(r100);
        DoraRealtimeCallTracer$traceDelegate$1$1 r103 = new DoraRealtimeCallTracer$traceDelegate$1$1(this);
        Intrinsics.checkNotNullParameter(r103, "scene");
        r102.M = r103;
        this.f291392s = r102;
        this.f291393t = LazyKt.lazy(new s0());
    }

    public static boolean B0(RealtimeCallParam r100) {
        if (r100 == null) goto L8;
        RealtimeCallParam.k r101 = r100.f288756p;
        if (r101 == null) goto L8;
        if (r101.R != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static void y0(String r100) {
        FLogger.f375446a.d("DoraRealtimeCallTracer", "dora不需要上报此埋点, method ".concat(r100));
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void C(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f291392s.C(r100);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void F(boolean r100) {
        if (this.f291379f == false) goto L6;
        this.f291379f = false;
        this.f291380g = System.currentTimeMillis();
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void K(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "serverInfo");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void b0(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        LinkedHashMap r101 = new LinkedHashMap();
        String r102 = r100.f288756p.f288875w;
        if (r102 == null) goto L5;
        r101.put("dora_proactive_id", r102);
    L5:
        int r103 = ia8.n.f488956a;
        String r104 = ia8.n.a(r100.f288756p.f288876x);
        if (r104 == null) goto L8;
        r101.put("dora_proactive_type", r104);
    L8:
        String r105 = r100.f288756p.f288877y;
        if (r105 == null) goto L11;
        r101.put("dora_proactive_sub_type", r105);
    L11:
        String r106 = r100.f288756p.f288878z;
        if (r106 == null) goto L14;
        r101.put("system_notify_version", r106);
    L14:
        IDoraService r107 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r107 == null) goto L18;
        r107.A0("dora_proactive_notice_send", r101);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void c0(long r100) {
        if (r100 < 0) goto L6;
        this.f291382i += r100;
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d(com.larus.audio.call.play.h.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h(jd9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void i(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "audio");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k(long r100) {
        this.f291392s.f379064k = r100;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void v(boolean r100) {
        this.f291391r = r100;
    }

    public final void x0(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        r100.put("scene", z0());
        r100.put("call_id", (String) this.f291389p.getValue());
        r100.put("room_id", (String) this.f291390q.getValue());
        RealtimeCallParam r101 = this.f291374a.invoke();
        r100.put("task_id", r101.f288752l.f288785a);
        if (Intrinsics.areEqual(z0(), NotificationCompat.CATEGORY_CALL) == false) goto L5;
    L7:
        r100.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(r101.f288751k.f288826o, "dora_si") ? 1 : 0));
        int r102 = com.larus.voicecall.impl.tracer.j.f379174J;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r100, "json");
        r100.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r101.f288759s)));
        r100.put("is_quic", Boolean.valueOf(com.larus.im.service.audio.y0.d(r101.f288759s)));
        r100.put("is_mmt", Integer.valueOf(com.larus.im.service.audio.y0.b(r101.f288759s) ? 1 : 0));
        r100.put("client_pre_connect", Integer.valueOf(r101.f288760t));
        r100.put("av_session_type", Integer.valueOf(r101.f288759s.getType()));
        return;
    L5:
        if (Intrinsics.areEqual(z0(), "assistant_scene_mode_click_talk") == true) goto L7;
        r100.put("dora_mode", z0());
        goto L7
    }

    public static void E0(String r100, String r101) {
        FLogger.f375446a.w("DoraRealtimeCallTracer", "新架构dora上报时机等效实时通话，invoke event method " + r100 + " trans to " + r101);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void B(IRealtimeCallTracer.TotalTimeType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    public final void D0(RealtimeCallParam r100, boolean r101) {
        final LinkedHashMap r102 = new LinkedHashMap();
        x0(r102);
        if (r100 == null) goto L7;
        String r103 = r100.f288745e;
        if (r103 == null) goto L7;
        r102.put("task_id", r103);
    L7:
        r102.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, "");
        if (r101 == false) goto L10;
        String r104 = "success";
    L11:
        r102.put("status", r104);
        r102.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r100.f288759s)));
        DiaryImageSwitchManager.f292080a.c(new n0(r102, this));
        return;
    L10:
        r104 = "failure";
        goto L11
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void H(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        Intrinsics.checkNotNullParameter(r101, "serverParamJson");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void O(String r100, RealtimeCallParam r101) {
        Intrinsics.checkNotNullParameter(r100, "endReason");
        this.f291392s.O(r100, r101);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Q(IRealtimeCallTracer.HelloStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        y0("reportHelloEvent");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void T(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "content");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void X(String r100, RealtimeCallParam r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = null;
        if (r100 != null) goto L9;
        if (r101 == null) goto L8;
        RealtimeCallParam.p r104 = r101.f288755o;
        if (r104 == null) goto L8;
        r100 = r104.f288906h;
    L8:
        r100 = null;
    L9:
        r102.put("thru_method", z0());
        if (B0(r101) == false) goto L12;
        r102.put("thru_sec_method", "dora_natural_wakeup");
    L12:
        if (r100 == null) goto L14;
        r102.put("bot_id", r100);
    L14:
        if (r101 == null) goto L16;
        String r105 = r101.f288746f;
    L18:
        if (com.larus.utils.o0.d(r105) == false) goto L21;
        r103 = r105;
    L21:
        if (r103 == null) goto L23;
        r102.put("wake_up_word", r103);
    L24:
        if (r101 == null) goto L30;
        RealtimeCallParam.k r106 = r101.f288756p;
        if (r106 == null) goto L30;
        if (r106.f288875w == null) goto L30;
        r102.put("thru_method", "dora_proactive");
    L30:
        IDoraService r107 = A0();
        if (r107 == null) goto L34;
        r107.A0("dora_wake_up", r102);
        return;
    L34:
        return;
    L23:
        r102.put("wake_up_word", "none");
        goto L24
    L16:
        r105 = null;
        goto L18
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void Z(RealtimeCallParam r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f291392s.Z(r100, r101);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "comfortType");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("comfort_scene", r100);
        r102.put("total", Integer.valueOf(r101));
        AudioSessionType r103 = this.f291374a.invoke().f288759s;
        r102.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r103) ? 1 : 0));
        r102.put("av_session_type", Integer.valueOf(r103.getType()));
        if (Intrinsics.areEqual(this.f291374a.invoke().f288751k.f288826o, "dora_si") == false) goto L5;
        r102.put("is_dora_si", 1);
    L6:
        x0(r102);
        IDoraService r104 = A0();
        if (r104 == null) goto L10;
        r104.A0("appease_play_duration", r102);
        return;
    L10:
        return;
    L5:
        r102.put("is_dora_si", 0);
        goto L6
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l0(RealtimeCallParam r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "botFromStatus");
        this.f291392s.l0(r100, r101);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void reportEvent(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r102 = true;
        if (BaseDoraLiteLiveAiPlugin.f293561l == false) goto L5;
    L8:
        r101.put("is_live_ai", Boolean.valueOf(r102));
        IDoraService r103 = A0();
        if (r103 == null) goto L12;
        r103.A0(r100, r101);
        return;
    L12:
        return;
    L5:
        if (b98.b.b(1) == true) goto L8;
        r102 = false;
        goto L8
    }

    @Override // com.larus.audio.call.tracer.c
    public final void N(RealtimeCallParam r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "comfortType");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("scene", r101);
        r103.put("comfortScene", r102);
        if (r100 == null) goto L9;
        RealtimeCallParam.p r104 = r100.f288755o;
        if (r104 == null) goto L9;
        String r105 = r104.f288906h;
        if (r105 == null) goto L9;
        r103.put("bot_id", r105);
    L9:
        if (r100 == null) goto L15;
        RealtimeCallParam.p r106 = r100.f288755o;
        if (r106 == null) goto L15;
        String r107 = r106.f288901c;
        if (r107 == null) goto L15;
        r103.put("conversation_id", r107);
    L15:
        if (r100 == null) goto L19;
        String r108 = r100.f288745e;
        if (r108 == null) goto L19;
        r103.put("call_id", r108);
    L19:
        if (r100 == null) goto L25;
        RealtimeCallParam.h r109 = r100.f288751k;
        if (r109 == null) goto L25;
        String r110 = r109.f288831t;
        if (r110 == null) goto L25;
        r103.put("dora_mode", r110);
    L25:
        r103.put("trigger", "invoke_plugin");
        x0(r103);
        IDoraService r111 = A0();
        if (r111 == null) goto L29;
        r111.A0("latency_comfort", r103);
        return;
    }

    @Override // com.larus.audio.call.tracer.c
    public final void Y(final long r110, final long r111, final long r112) {
        FLogger.f375446a.e("AudioTrackPerformance", "costTime " + r110 + ",costTtsResponseToPrepareTime：" + r111 + ",costPrepareToPlayTime: " + r112 + ' ');
        com.larus.utils.l0.b(new o0(r110, r111, r112, this));
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void a0(Flow<Integer> r100, CoroutineScope r101, RealtimeCallParam r102) {
        Intrinsics.checkNotNullParameter(r100, "callStateFlow");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f291392s.a0(r100, r101, r102);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void q0(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "result");
        LinkedHashMap r103 = new LinkedHashMap();
        if (r100 == null) goto L5;
        r103.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, r100);
    L5:
        r103.put("begin_is_playing", Boolean.valueOf(r101));
        r103.put("result", r102);
        IDoraService r104 = A0();
        if (r104 == null) goto L9;
        r104.A0("sv_result", r103);
        return;
    }

    public final Map<String, Object> w0(RealtimeCallParam r110, long r111, long r112) {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("scene", z0());
        Integer r101 = null;
        if (r110 == null) goto L5;
        String r102 = r110.f288746f;
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L26;
        if (r110 == null) goto L20;
        RealtimeCallParam.p r104 = r110.f288755o;
        if (r104 == null) goto L20;
        String r105 = r104.f288906h;
        if (r105 == null) goto L20;
        r100.put("bot_id", r105);
    L20:
        if (r110 == null) goto L26;
        RealtimeCallParam.p r106 = r110.f288755o;
        if (r106 == null) goto L26;
        String r107 = r106.f288901c;
        if (r107 == null) goto L26;
        r100.put("conversation_id", r107);
    L26:
        if (r110 == null) goto L30;
        String r108 = r110.f288745e;
        if (r108 == null) goto L30;
        r100.put("call_id", r108);
    L30:
        if (r110 == null) goto L36;
        RealtimeCallParam.h r109 = r110.f288751k;
        if (r109 == null) goto L36;
        String r113 = r109.f288831t;
        if (r113 == null) goto L36;
        r100.put("dora_mode", r113);
    L36:
        r100.put("dora_conversation_type", z0());
        if (B0(r110) == false) goto L39;
        r100.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L39:
        int r114 = ia8.n.f488956a;
        if (r110 == null) goto L44;
        RealtimeCallParam.k r115 = r110.f288756p;
        if (r115 == null) goto L44;
        String r116 = r115.f288876x;
    L45:
        String r117 = ia8.n.a(r116);
        if (r117 == null) goto L48;
        r100.put("dora_proactive_type", r117);
    L48:
        if (r110 == null) goto L54;
        RealtimeCallParam.k r118 = r110.f288756p;
        if (r118 == null) goto L54;
        String r119 = r118.f288877y;
        if (r119 == null) goto L54;
        r100.put("dora_proactive_sub_type", r119);
    L54:
        r100.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, "");
        r100.put("status", "success");
        if (r110 == null) goto L59;
        AudioSessionType r120 = r110.f288759s;
        if (r120 == null) goto L59;
        r100.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r120) ? 1 : 0));
        r100.put("av_session_type", Integer.valueOf(r120.getType()));
    L59:
        if (r110 == null) goto L67;
        RealtimeCallParam.j r121 = r110.f288754n;
        if (r121 == null) goto L67;
        if (r121.f288842e == false) goto L65;
        String r122 = "video";
    L66:
        r100.put("trans_mode", r122);
        goto L67
    L65:
        r122 = "image";
    L67:
        if (r110 == null) goto L71;
        RealtimeCallParam.h r123 = r110.f288751k;
        if (r123 == null) goto L71;
        String r124 = r123.f288826o;
    L73:
        if (Intrinsics.areEqual(r124, "dora_si") == false) goto L75;
        r100.put("is_dora_si", 1);
    L76:
        r100.put("dora_message_mode", com.larus.avlink.plugins.y.a(r110));
        r100.put("start_session_exp_duration", Long.valueOf(r111));
        r100.put("start_session_duration", Long.valueOf(r112));
        if (r110 == null) goto L81;
        RealtimeCallParam.h r125 = r110.f288751k;
        if (r125 == null) goto L81;
        r101 = Integer.valueOf(r125.f288830s);
    L81:
        r100.put("dora_wakeup_mode", r101);
        x0(r100);
        if (r110 == null) goto L88;
        RealtimeCallParam.k r126 = r110.f288756p;
        if (r126 == null) goto L88;
        String r127 = r126.f288875w;
        if (r127 == null) goto L88;
        r100.put("dora_proactive_id", r127);
        r100.put("scene", "dora_proactive");
        r100.put("dora_conversation_type", "dora_proactive");
    L88:
        return r100;
    L75:
        r100.put("is_dora_si", 0);
    L71:
        r124 = null;
    L44:
        r116 = null;
        goto L45
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void y(String r100, RealtimeCallParam r101, ouc.d0 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        this.f291392s.y(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void A(RealtimeCallParam r100, String r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("group_type", BridgePrivilege.PRIVATE);
        r103.put("success", 1);
        ?? r104 = 0;
        if (r101 == null) goto L14;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        this.f291388o = r101;
        Pair<String, Boolean> r105 = DoraETracer.f293611a;
        if (r105 == null) goto L7;
        String r106 = r105.getFirst();
    L9:
        if (Intrinsics.areEqual(r106, r101) == false) goto L14;
        Pair<String, Boolean> r107 = DoraETracer.f293611a;
        if (r107 == null) goto L13;
        r104 = r107.getSecond().booleanValue();
    L13:
        r103.put("is_dora_exploration_active_message", Integer.valueOf(r104));
        goto L14
    L7:
        r106 = null;
    L14:
        if (r102 == null) goto L16;
        r103.put("agent_id", r102);
    L16:
        if (r110 == null) goto L18;
        r103.put("agent_intention", r110);
    L18:
        r103.put("conversation_id", r100.f288755o.f288901c);
        r103.put("bot_id", r100.f288755o.f288906h);
        Long r108 = StringsKt.toLongOrNull(r100.f288755o.f288904f);
        if (r108 == null) goto L21;
        r103.put("voice_id", Long.valueOf(r108.longValue()));
    L21:
        r103.put("speaker_name", r100.f288755o.f288905g);
        r103.put("speaker_id", r100.f288755o.f288902d);
        r103.put("current_page", r100.f288756p.f288856d);
        r103.put("previous_page", r100.f288756p.f288854b);
        int r109 = ia8.n.f488956a;
        String r111 = ia8.n.a(r100.f288756p.f288876x);
        if (r111 == null) goto L24;
        r103.put("dora_proactive_type", r111);
    L24:
        String r112 = r100.f288756p.f288877y;
        if (r112 == null) goto L27;
        r103.put("dora_proactive_sub_type", r112);
    L27:
        r103.put("voice_type", "default");
        r103.put("type", "text");
        r103.put("is_tts_open", 1);
        r103.put("is_onboarding", 0);
        r103.put("is_soft_link", 0);
        r103.put("message_type", "text");
        r103.put(LocationMonitorConst.IS_CACHE, -1);
        r103.put("use_nickname", "0");
        r103.put("is_baike_link", "0");
        if (Intrinsics.areEqual(r100.f288752l.f288802r, "1") == false) goto L37;
        String r113 = r100.f288756p.f288863k;
        if (Intrinsics.areEqual(r113, "dora_new_onboarding_voicewakeup_example") == false) goto L32;
    L35:
        r103.put("sec_scene", r113);
    L39:
        r103.put("dora_mode", r100.f288751k.f288831t);
        r103.put("dora_message_mode", com.larus.avlink.plugins.y.a(r100));
        x0(r103);
        String r114 = r100.f288756p.f288875w;
        if (r114 == null) goto L42;
        r103.put("dora_proactive_id", r114);
        r103.put("scene", "dora_proactive");
        int r115 = this.f291387n + 1;
        this.f291387n = r115;
        r103.put("dora_proactive_response_index", Integer.valueOf(r115));
    L43:
        IDoraService r116 = A0();
        if (r116 == null) goto L47;
        r116.A0("vui_receive_stream", r103);
        return;
    L47:
        return;
    L42:
        r103.put("scene", z0());
        goto L43
    L32:
        if (Intrinsics.areEqual(r113, "dora_new_onboarding_voicewakeup_continue") == true) goto L35;
        r103.put("sec_scene", "dora_onboarding");
        goto L39
    L37:
        if (B0(r100) == false) goto L39;
        r103.put("sec_scene", "dora_natural_wakeup");
        goto L39
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e(String r100, String r101, String r102, String r103) {
        y0("reportSoothingSoundGenerateStart");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void e0(String r100, String r101, RealtimeCallParam r102, e3a.a r103) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r103, "argumentData");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void g0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        y0("reportMicPermissionEntranceShow");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void h0(long r100, long r101, String r110, String r111) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("reportCallMessageDisplayEvent, scene=");
        r103.append(z0());
        r103.append(", imTime=");
        r103.append(r100);
        r103.append(", vuiTime=");
        r103.append(r101);
        r103.append(", diff=");
        long r104 = r101 - r100;
        r103.append(r104);
        r102.i("DoraRealtimeCallTracer", r103.toString());
        if (r100 != 0) goto L5;
        return;
    L5:
        if (r101 == 0) goto L13;
        LinkedHashMap r105 = new LinkedHashMap();
        if (r110 == null) goto L10;
        r105.put("task_id", r110);
    L10:
        r105.put("dora_mode", r111);
        r105.put("scene", z0());
        r105.put("im_time", Long.valueOf(r100));
        r105.put("vui_time", Long.valueOf(r101));
        r105.put("duration", Long.valueOf(r104));
        reportEvent("realtime_call_message_display", r105);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void k0(String r100, RealtimeCallParam r101, boolean r102, e3a.a r103) {
        Intrinsics.checkNotNullParameter(r101, "param");
        Intrinsics.checkNotNullParameter(r103, "argumentData");
    }

    public final Map<String, Object> v0(RealtimeCallParam r100, String r110, Integer r111, Integer r112) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("scene", z0());
        if (r100 == null) goto L9;
        RealtimeCallParam.h r102 = r100.f288751k;
        if (r102 == null) goto L9;
        String r103 = r102.f288831t;
        if (r103 == null) goto L9;
        r101.put("dora_mode", r103);
    L9:
        String r104 = null;
        if (r100 == null) goto L12;
        String r105 = r100.f288746f;
    L14:
        if (r105 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == false) goto L33;
        if (r100 == null) goto L27;
        RealtimeCallParam.p r107 = r100.f288755o;
        if (r107 == null) goto L27;
        String r108 = r107.f288906h;
        if (r108 == null) goto L27;
        r101.put("bot_id", r108);
    L27:
        if (r100 == null) goto L33;
        RealtimeCallParam.p r109 = r100.f288755o;
        if (r109 == null) goto L33;
        String r113 = r109.f288901c;
        if (r113 == null) goto L33;
        r101.put("conversation_id", r113);
    L33:
        if (r100 == null) goto L37;
        String r114 = r100.f288745e;
        if (r114 == null) goto L37;
        r101.put("call_id", r114);
    L37:
        r101.put("dora_conversation_type", z0());
        if (B0(r100) == false) goto L40;
        r101.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L40:
        r101.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, r110);
        if (r111 == null) goto L43;
        r101.put("error_code", Integer.valueOf(r111.intValue()));
    L43:
        if (r112 == null) goto L45;
        r101.put("session_status", Integer.valueOf(r112.intValue()));
    L45:
        int r115 = ia8.n.f488956a;
        if (r100 == null) goto L50;
        RealtimeCallParam.k r116 = r100.f288756p;
        if (r116 == null) goto L50;
        String r117 = r116.f288876x;
    L51:
        String r118 = ia8.n.a(r117);
        if (r118 == null) goto L54;
        r101.put("dora_proactive_type", r118);
    L54:
        if (r100 == null) goto L60;
        RealtimeCallParam.k r119 = r100.f288756p;
        if (r119 == null) goto L60;
        String r120 = r119.f288877y;
        if (r120 == null) goto L60;
        r101.put("dora_proactive_sub_type", r120);
    L60:
        r101.put("status", "failure");
        if (r100 == null) goto L65;
        AudioSessionType r121 = r100.f288759s;
        if (r121 == null) goto L65;
        r101.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r121) ? 1 : 0));
        r101.put("av_session_type", Integer.valueOf(r121.getType()));
    L65:
        if (r100 == null) goto L70;
        RealtimeCallParam.h r122 = r100.f288751k;
        if (r122 == null) goto L70;
        r104 = r122.f288826o;
    L70:
        if (Intrinsics.areEqual(r104, "dora_si") == false) goto L72;
        r101.put("is_dora_si", 1);
    L73:
        r101.put("dora_message_mode", com.larus.avlink.plugins.y.a(r100));
        r101.put("start_session_exp_duration", -1L);
        r101.put("start_session_duration", -1L);
        x0(r101);
        if (r100 == null) goto L80;
        RealtimeCallParam.k r123 = r100.f288756p;
        if (r123 == null) goto L80;
        String r124 = r123.f288875w;
        if (r124 == null) goto L80;
        r101.put("dora_proactive_id", r124);
        r101.put("scene", "dora_proactive");
        r101.put("dora_conversation_type", "dora_proactive");
    L80:
        return r101;
    L72:
        r101.put("is_dora_si", 0);
    L50:
        r117 = null;
        goto L51
    L16:
        if (r105.length() == 0) goto L19;
        r106 = false;
        goto L20
    L12:
        r105 = null;
        goto L14
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void z(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        y0("reportMicPermissionEntranceClick");
    }

    public final void C0(int r110, String r111, long r112, RealtimeCallParam r113, JSONObject r210) {
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r210, "extraParams");
        BuildersKt.launch$default((CoroutineScope) this.f291393t.getValue(), null, null, new DoraRealtimeCallTracer$reportDoraRealtimeCallError$1(this, r110, r111, r112, r113, r210, null), 3, null);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void M(String r100, String r101, String r102, Long r103, String r104) {
        y0("reportSoothingSoundGenerateComplete");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void P(RealtimeCallParam r210, Long r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r210, "params");
        if (this.f291384k == true) goto L5;
    L11:
        this.f291383j = true;
        return;
    L5:
        if (this.f291377d == (-1)) goto L11;
        this.f291384k = false;
        System.currentTimeMillis();
        long r100 = System.currentTimeMillis();
        long r101 = this.f291380g;
        long r102 = r100 - r101;
        long r103 = r101 - this.f291377d;
        if (r212 == null) goto L9;
        JSONObject r110 = new JSONObject(r212);
    L10:
        FLogger.f375446a.i("AudioTrackPerformance", "TTSResponse : appeasePlayDuration :" + r211);
        BuildersKt.launch$default((CoroutineScope) this.f291393t.getValue(), null, null, new DoraRealtimeCallTracer$onTTSResponse$1(this, r210, r103, r102, r211, r214, r213, r110, null), 3, null);
        this.f291376c = this.f291376c + 1;
        goto L11
    L9:
        r110 = new JSONObject();
        goto L10
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void l(String r100, String r101, String r102, String r103, String r104) {
        y0("reportSoundGenerate");
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void j(RealtimeCallParam r100, boolean r101, IRealtimeCallTracer.EnterCallSessionStatus r102, long r110, long r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "sessionStatus");
        if (r101 == false) goto L14;
        E0("onEnterCallStatus", "reportCallStartEvent");
        long r103 = System.currentTimeMillis() - r100.f288741c;
        DoraImageMode.a r104 = DoraImageMode.Companion;
        Integer r105 = Integer.valueOf(r100.f288751k.f288830s);
        r104.getClass();
        if (DoraImageMode.a.a(r105) == false) goto L7;
        D0(r100, true);
        return;
    L7:
        FLogger.f375446a.b("Dora call", "Dora call start", r100.f288745e);
        Map<String, ? extends Object> r106 = w0(r100, r103, r111);
        IDoraService r107 = A0();
        if (r107 == null) goto L10;
        r107.A0("dora_conversation_start", r106);
    L10:
        IDoraService r108 = A0();
        if (r108 == null) goto L16;
        r108.A0("flow_dora_conversation_start", r106);
        return;
    L16:
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void p0(RealtimeCallParam r110, IRealtimeCallTracer.EnterCallSessionStatus r111, String r112, int r113, String r114, Boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r114, "errorMsg");
        E0("reportFinishCall", "reportCallEndEvent");
        DoraImageMode.a r116 = DoraImageMode.Companion;
        Integer r100 = Integer.valueOf(r110.f288751k.f288830s);
        r116.getClass();
        boolean r117 = DoraImageMode.a.a(r100);
        Integer r101 = null;
        boolean r102 = true;
        if (r117 == false) goto L35;
        Map<String, ? extends Object> r118 = new LinkedHashMap();
        if (this.f291378e <= 0) goto L137;
        r118.put("duration", Long.valueOf(System.currentTimeMillis() - this.f291378e));
        String r119 = r110.f288745e;
        if (r119 == null) goto L9;
        r118.put("task_id", r119);
    L9:
        com.larus.audio.call.o r120 = g98.d.f480522a;
        String r121 = r110.f288745e;
        if (r121 != null) goto L12;
    L15:
        if (r102 == false) goto L18;
        r121 = null;
    L18:
        if (r121 == null) goto L24;
        Object r122 = g98.d.f480528g;
        monitor-enter(r122);
        r101 = g98.d.f480527f.remove(r121);     // Catch: Throwable -> L32
        monitor-exit(r122);
    L32:
        th = move-exception;
        throw th;
    L24:
        if (r101 == null) goto L26;
        r118.put("end_code", Integer.valueOf(r101.intValue()));
    L29:
        IDoraService r123 = A0();
        if (r123 == null) goto L138;
        r123.A0("dora_g_observation_end", r118);
        return;
    L138:
        return;
    L26:
        Integer r124 = r110.f288754n.f288838a;
        if (r124 == null) goto L29;
        r118.put("end_code", Integer.valueOf(r124.intValue()));
        goto L29
    L12:
        if (StringsKt.isBlank(r121) == true) goto L15;
        r102 = false;
        goto L15
    L137:
        return;
    L35:
        if (r111 == null) goto L37;
        int r125 = r111.getValue();
    L39:
        if (this.f291378e <= 0) goto L140;
        LinkedHashMap r126 = new LinkedHashMap();
        long r103 = System.currentTimeMillis() - this.f291378e;
        if (r115 == null) goto L43;
        r126.put("is_last_message_read", Integer.valueOf(r115.booleanValue() ? 1 : 0));
    L43:
        r126.put("error_code", Integer.valueOf(r113));
        r126.put("error_message", r114);
        r126.put("session_status", Integer.valueOf(r125));
        Intrinsics.checkNotNullParameter(r126, "otherParam");
        if (this.f291378e <= 0) goto L141;
        FLogger.f375446a.c("Dora call", "Dora call end", r110.f288745e);
        Map<String, Object> r127 = new LinkedHashMap();
        r127.put("scene", z0());
        RealtimeCallParam.p r128 = r110.f288755o;
        if (r128 == null) goto L50;
        Object r129 = r128.f288906h;
        if (r129 == null) goto L50;
        r127.put("bot_id", r129);
    L50:
        RealtimeCallParam.p r130 = r110.f288755o;
        if (r130 == null) goto L55;
        Object r131 = r130.f288901c;
        if (r131 == null) goto L55;
        r127.put("conversation_id", r131);
    L55:
        Object r132 = r110.f288745e;
        if (r132 == null) goto L58;
        r127.put("call_id", r132);
    L58:
        r127.put("dora_conversation_type", z0());
        if (B0(r110) == false) goto L61;
        r127.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L61:
        RealtimeCallParam.h r133 = r110.f288751k;
        if (r133 == null) goto L66;
        Object r134 = r133.f288831t;
        if (r134 == null) goto L66;
        r127.put("dora_mode", r134);
    L66:
        int r135 = ia8.n.f488956a;
        RealtimeCallParam.k r136 = r110.f288756p;
        if (r136 == null) goto L69;
        String r137 = r136.f288876x;
    L70:
        Object r138 = ia8.n.a(r137);
        if (r138 == null) goto L73;
        r127.put("dora_proactive_type", r138);
    L73:
        RealtimeCallParam.k r139 = r110.f288756p;
        if (r139 == null) goto L78;
        Object r140 = r139.f288877y;
        if (r140 == null) goto L78;
        r127.put("dora_proactive_sub_type", r140);
    L78:
        RealtimeCallParam.k r141 = r110.f288756p;
        if (r141 == null) goto L83;
        RealtimeCallParam.DoraEndType r142 = r141.C;
        if (r142 == null) goto L83;
        r127.put("dora_end_type", r142.getType());
    L83:
        RealtimeCallParam.j r143 = r110.f288754n;
        if (r143 == null) goto L88;
        Integer r144 = r143.f288838a;
        if (r144 == null) goto L88;
        int r145 = r144.intValue();
        r127.put("end_code", Integer.valueOf(r145));
        DoraETracePlugin r104 = DoraETracePlugin.f293596p;
        r127.put("unexpected", Integer.valueOf(DoraETracePlugin.a.b(Integer.valueOf(r145)) ? 1 : 0));
    L88:
        r127.put("question_cnt", Integer.valueOf(this.f291375b));
        r127.put("answer_cnt", Integer.valueOf(this.f291376c));
        r127.put("user_speaking_duration", Integer.valueOf((int) this.f291382i));
        r127.put("duration", Integer.valueOf((int) r103));
        r127.put(MusicAppletPage.KEY_MESSAGE_ID, this.f291388o);
        AudioSessionType r146 = r110.f288759s;
        if (r146 == null) goto L91;
        r127.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r146) ? 1 : 0));
        r127.put("av_session_type", Integer.valueOf(r146.getType()));
    L91:
        RealtimeCallParam.h r147 = r110.f288751k;
        if (r147 == null) goto L94;
        String r148 = r147.f288826o;
    L96:
        if (Intrinsics.areEqual(r148, "dora_si") == false) goto L98;
        r127.put("is_dora_si", 1);
    L99:
        r127.put("dora_message_mode", com.larus.avlink.plugins.y.a(r110));
        x0(r127);
        RealtimeCallParam.k r149 = r110.f288756p;
        if (r149 == null) goto L104;
        Object r150 = r149.f288875w;
        if (r150 == null) goto L104;
        r127.put("dora_proactive_id", r150);
        r127.put("scene", "dora_proactive");
        r127.put("dora_conversation_type", "dora_proactive");
    L104:
        RealtimeCallParam.h r151 = r110.f288751k;
        if (r151 == null) goto L107;
        r101 = Integer.valueOf(r151.f288830s);
    L107:
        r127.put("dora_wakeup_mode", r101);
        Iterator r152 = r126.entrySet().iterator();
    L109:
        if (r152.hasNext() == false) goto L111;
        Map.Entry r153 = (Map.Entry) r152.next();
        r127.put((String) r153.getKey(), r153.getValue());
        goto L109
    L111:
        RealtimeCallParam.j r154 = r110.f288754n;
        if (r154 != null) goto L114;
    L116:
        boolean r155 = false;
    L117:
        if (r155 == false) goto L130;
        IDoraService r156 = A0();
        if (r156 == null) goto L125;
        AbilityService r157 = r156.o0();
        if (r157 == null) goto L125;
        if (r157.k() != true) goto L125;
    L126:
        if (r102 == false) goto L128;
        int r158 = 2;
    L129:
        r127.put("trans_type", Integer.valueOf(r158));
        goto L130
    L128:
        r158 = 0;
    L125:
        r102 = false;
    L130:
        this.f291375b = 0;
        this.f291376c = 0;
        this.f291382i = 0;
        IDoraService r159 = A0();
        if (r159 == null) goto L142;
        r159.A0("dora_conversation_end", r127);
        return;
    L142:
        return;
    L114:
        if (r154.f288842e != true) goto L116;
        r155 = true;
        goto L117
    L98:
        r127.put("is_dora_si", 0);
        goto L99
    L94:
        r148 = null;
        goto L96
    L69:
        r137 = null;
        goto L70
    L141:
        return;
    L140:
        return;
    L37:
        r125 = 0;
        goto L39
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void L(RealtimeCallParam r100, int r101, String r102, String r103, Long r104, Long r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "params");
        y0("onInterpretStart");
    }

    @Override // com.larus.audio.call.tracer.c
    public final void b(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "startType");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r103, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r104, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r105, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r106, "translateMode");
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("start_type", r100);
        r107.put("task_id", r101);
        r107.put("owner_input_language", r102);
        r107.put("owner_output_language", r103);
        r107.put("guest_input_language", r104);
        r107.put("guest_output_language", r105);
        r107.put("translate_mode", r106);
        r107.put("mode_duration", 0L);
        IDoraService r108 = A0();
        if (r108 == null) goto L6;
        r108.A0("dora_interpretation_start", r107);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void f(RealtimeCallParam r100, String r101, boolean r102, IRealtimeCallTracer.EnterCallSessionStatus r103, Integer r104, long r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r103, "sessionStatus");
        if (r102 == false) goto L17;
        E0("onEnterCallFailed", "reportCallStartFailedEvent");
        DoraImageMode.a r107 = DoraImageMode.Companion;
        Integer r108 = Integer.valueOf(r100.f288751k.f288830s);
        r107.getClass();
        if (DoraImageMode.a.a(r108) == false) goto L7;
        D0(r100, false);
        return;
    L7:
        Map<String, Object> r109 = v0(r100, r101, r104, Integer.valueOf(r103.getValue()));
        IDoraService r110 = A0();
        if (r110 == null) goto L10;
        r110.A0("dora_conversation_start", r109);
    L10:
        IDoraService r111 = A0();
        if (r111 == null) goto L13;
        r111.A0("flow_dora_conversation_start", r109);
    L13:
        Map<String, Object> r112 = v0(r100, r101, r104, Integer.valueOf(r103.getValue()));
        IDoraService r113 = A0();
        if (r113 == null) goto L19;
        r113.A0("flow_dora_session_start", r112);
        return;
    L19:
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void w(RealtimeCallParam r110, int r111, boolean r112, String r113, String r114, long r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "params");
        this.f291392s.w(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void U(int r210, String r211, long r212, RealtimeCallParam r213, Boolean r214, int r215, String r216, String r217) {
        Intrinsics.checkNotNullParameter(r213, "params");
        BuildersKt.launch$default((CoroutineScope) this.f291393t.getValue(), null, null, new DoraRealtimeCallTracer$onError$1(r213, this, r210, r211, r215, r216, r217, r212, true, r214, NotificationCompat.CATEGORY_CALL, null), 3, null);
    }

    @Override // com.larus.audio.call.tracer.c
    public final void V(String r100, Integer r101, String r102, Long r103, Long r104, Long r105, Long r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        LinkedHashMap r106 = new LinkedHashMap();
        if (r101 == null) goto L5;
        r106.put("command", Integer.valueOf(r101.intValue()));
    L5:
        r106.put("scene", r100);
        if (r102 == null) goto L8;
        r106.put("msg_id", r102);
    L8:
        if (r103 == null) goto L10;
        r106.put("t1", Long.valueOf(r103.longValue()));
    L10:
        if (r104 == null) goto L12;
        r106.put("t2", Long.valueOf(r104.longValue()));
    L12:
        if (r105 == null) goto L14;
        r106.put("t3", Long.valueOf(r105.longValue()));
    L14:
        if (r110 == null) goto L16;
        r106.put("duration", Long.valueOf(r110.longValue()));
    L16:
        if (r111 == null) goto L18;
        r106.put("err_code", Integer.valueOf(r111.intValue()));
    L18:
        IDoraService r107 = A0();
        if (r107 == null) goto L22;
        r107.A0("dora_command_send", r106);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void r0(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111) {
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("task_id", this.f291374a.invoke().f288752l.f288785a);
        r106.put("success", Boolean.TRUE);
        r106.put("im_asr_message_num", Integer.valueOf(r100));
        r106.put("im_tts_message_num", Integer.valueOf(r101));
        r106.put("im_tts_query_message_num", Integer.valueOf(r102));
        r106.put("im_pull_asr_message_num", Integer.valueOf(r103));
        r106.put("im_pull_tts_message_num", Integer.valueOf(r104));
        r106.put("vui_asr_message_num", Integer.valueOf(r105));
        r106.put("vui_tts_message_num", Integer.valueOf(r110));
        r106.put("vui_chat_message_num", Integer.valueOf(r111));
        r106.put("scene", z0());
        r106.put("dora_mode", this.f291374a.invoke().f288751k.f288831t);
        IDoraService r107 = A0();
        if (r107 == null) goto L6;
        r107.A0("realtime_call_message_on_screen", r106);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void o(String r100, long r101, boolean r102, boolean r103, boolean r104, long r110, long r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "audioRoute");
        FLogger.f375446a.i("DoraRealtimeCallTracer", "reportCallTtsPlayEvent, scene=" + z0() + ", audioRoute=" + r100 + ", firstTtsDuration=" + r101 + ", isFinish=" + r102 + ", isTtsEnd=" + r103);
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("task_id", this.f291374a.invoke().f288752l.f288785a);
        r105.put("scene", z0());
        r105.put("current_route", r100);
        r105.put("first_tts_duration", Long.valueOf(r101));
        r105.put(EventConstant.Key.IS_FINISH, Boolean.valueOf(r102));
        r105.put("is_tts_end", Boolean.valueOf(r103));
        r105.put("is_pacify", Boolean.valueOf(r104));
        r105.put("dora_mode", this.f291374a.invoke().f288751k.f288831t);
        AudioSessionType r106 = this.f291374a.invoke().f288759s;
        r105.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(r106) ? 1 : 0));
        r105.put("av_session_type", Integer.valueOf(r106.getType()));
        r105.put("is_rtc", Integer.valueOf(com.larus.im.service.audio.y0.e(this.f291374a.invoke().f288759s) ? 1 : 0));
        if (Intrinsics.areEqual(this.f291374a.invoke().f288751k.f288826o, "dora_si") == false) goto L5;
        r105.put("is_dora_si", 1);
    L6:
        r105.put("answer_start_time", Long.valueOf(r110));
        r105.put("answer_end_time", Long.valueOf(r111));
        r105.put("answer_type", r113);
        r105.put("call_round", r112);
        reportEvent("realtime_call_tts_play", r105);
        return;
    L5:
        r105.put("is_dora_si", 0);
        goto L6
    }

    @Override // com.larus.audio.call.tracer.c
    public final void u(String r100, String r101, long r102, String r103, String r104, String r105, String r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "ownerInputLanguage");
        Intrinsics.checkNotNullParameter(r104, "ownerOutputLanguage");
        Intrinsics.checkNotNullParameter(r105, "guestInputLanguage");
        Intrinsics.checkNotNullParameter(r110, "guestOutputLanguage");
        Intrinsics.checkNotNullParameter(r111, "translateMode");
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("end_type", r100);
        r106.put("task_id", r101);
        r106.put("duration", Long.valueOf(r102));
        r106.put("owner_input_language", r103);
        r106.put("owner_output_language", r104);
        r106.put("guest_input_language", r105);
        r106.put("guest_output_language", r110);
        r106.put("translate_mode", r111);
        r106.put("mode_duration", Long.valueOf(r112));
        IDoraService r107 = A0();
        if (r107 == null) goto L6;
        r107.A0("dora_interpretation_end", r106);
        return;
    }

    @Override // com.larus.audio.call.tracer.IRealtimeCallTracer
    public final void d0(final RealtimeCallParam r110, final int r111, final long r112, long r113, final boolean r114, String r115, final String r116, String r210, Long r211, Long r212, String r213) {
        Intrinsics.checkNotNullParameter(r110, "params");
        this.f291377d = System.currentTimeMillis();
        com.larus.utils.l0.b(new t0(r116, r112, r110, r114, this, r111));
    }
}
