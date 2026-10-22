package com.larus.voicecall.impl.tracer;

import androidx.core.app.NotificationCompat;
import com.bytedance.ai.event.MessageIndication;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.service.audio.y0;
import com.larus.platform.service.z2;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class j {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ int f379174J = 0;
    public volatile boolean A;
    public int B;
    public long C;
    public String D;
    public boolean E;
    public boolean F;
    public long G;
    public String H;
    public final b I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.audio.call.arch.c f379175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f379176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f379177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f379178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f379179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f379180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f379181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f379182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f379183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f379184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f379185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f379186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f379187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f379188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f379189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f379190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f379191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f379192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f379193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f379194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.larus.audio.call.p f379195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k f379196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public l f379197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f379198x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f379199y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f379200z;

    public static final class a {
    }

    public static final class b extends com.larus.audio.call.play.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f379201a;

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void c() {
            this.f379201a.n();
        }

        public b(j r100) {
            this.f379201a = r100;
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void b(Map<String, String> r100) {
            if (this.f379201a.f379187m == false) goto L6;
            this.f379201a.f379187m = false;
            this.f379201a.getContext().k().Q(IRealtimeCallTracer.HelloStatus.PLAY_HELLO, null);
            com.larus.audio.call.tracer.b.b(this.f379201a.getContext().i(), "tts_delay", null, 6);
            com.larus.audio.call.tracer.b.b(this.f379201a.getContext().i(), "realcall_message", null, 6);
            j r101 = this.f379201a;
            r101.f379190p = System.currentTimeMillis();
            this.f379201a.f379192r = false;
            j.q(this.f379201a, 0, -2, null, null, 12);
            j r102 = this.f379201a;
            r102.getClass();
            com.larus.utils.l0.b(new h(r102, 0));
            j r103 = this.f379201a;
            r103.getClass();
            l r104 = new l(r103);
            r103.f379197w = r104;
            r104.d();
            return;
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void f(TtsPlayEndType r100) {
            Intrinsics.checkNotNullParameter(r100, "endType");
            this.f379201a.o();
        }
    }

    public static final class c extends com.larus.audio.call.p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ j f379202g;

        @Override // com.larus.audio.call.p
        public final void c(long r100) {
        }

        @Override // com.larus.audio.call.p
        public final void b() {
            j.q(this.f379202g, 2, 0, null, null, 14);
        }

        public c(long r100, j r101) {
            this.f379202g = r101;
            super(r100, r100);
        }
    }

    static {
    }

    public long c() {
        return 60000;
    }

    public void n() {
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "onTtsFirstFramePlayed");
        this.f379191q = System.currentTimeMillis();
        l r100 = this.f379197w;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f379197w = null;
    }

    public final void o() {
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "onTtsPlayFinished");
        if (this.f379190p > 0) goto L5;
    L9:
        this.f379192r = true;
        return;
    L5:
        if (this.A == false) goto L7;
        int r100 = 0;
    L8:
        long r101 = System.currentTimeMillis();
        long r102 = this.f379190p;
        r(r100, r101 - r102, this.f379191q - r102, System.currentTimeMillis() - this.f379182h, 0);
        goto L9
    L7:
        r100 = 3;
        goto L8
    }

    public final void s() {
        k r100 = this.f379196v;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f379196v = null;
        if (this.f379192r == true) goto L12;
        long r101 = this.f379191q;
        long r102 = 0;
        if (r101 <= 0) goto L10;
        r102 = r101 - this.f379190p;
    L10:
        r(3, b(this.f379190p), r102, b(this.f379182h), -222);
    L12:
        if (this.f379195u == null) goto L14;
        q(this, 3, 0, null, MessageIndication.STATUS_INTERRUPT, 6);
    L14:
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "trigger interrupt qid = " + this.f379176b + " callId =" + this.f379180f + " roomId=" + this.f379181g + "scene = " + this.f379179e + " hasSendExpResponseEvent = " + this.f379193s + " isFirstPacifyResponse = " + this.f379188n + " ttsPlayComplete = " + this.f379192r + " isFirstTTSResponse = " + this.f379187m + "isFirstChatResponse = " + this.f379189o);
    }

    public final com.larus.audio.call.arch.c getContext() {
        return this.f379175a;
    }

    public static long b(long r100) {
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return System.currentTimeMillis() - r100;
    }

    public final void a(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        r100.put("scene", this.f379179e);
        r100.put("call_id", this.f379180f);
        r100.put("room_id", this.f379181g);
        int r101 = com.larus.im.a.f346406a;
        gd9.o r102 = com.larus.im.internal.d.f347913a;
        com.larus.im.internal.audio.u.f347501c.getClass();
        com.larus.im.internal.utils.x r103 = com.larus.im.internal.utils.x.f350563a;
        r100.put("is_mock_test", Boolean.FALSE);
        r100.put("task_id", this.f379175a.params().f288752l.f288785a);
        if (Intrinsics.areEqual(this.f379179e, NotificationCompat.CATEGORY_CALL) == false) goto L5;
    L7:
        RealtimeCallParam r104 = this.f379175a.params();
        r100.put("is_rtc", Boolean.valueOf(y0.e(r104.f288759s)));
        r100.put("is_quic", Boolean.valueOf(y0.d(r104.f288759s)));
        r100.put("is_mmt", Integer.valueOf(y0.b(r104.f288759s) ? 1 : 0));
        r100.put("client_pre_connect", Integer.valueOf(r104.f288760t));
        r100.put("av_session_type", Integer.valueOf(r104.f288759s.getType()));
        r100.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(this.f379175a.params().f288751k.f288826o, "dora_si") ? 1 : 0));
        r100.put("is_v3", Integer.valueOf(this.F ? 1 : 0));
        return;
    L5:
        if (Intrinsics.areEqual(this.f379179e, "assistant_scene_mode_click_talk") == true) goto L7;
        r100.put("dora_mode", this.f379179e);
        goto L7
    }

    public final void e(boolean r110) {
        if (this.f379195u == null) goto L5;
        q(this, 3, 0, null, "onCallEnd", 6);
    L5:
        l r100 = this.f379197w;
        if (r100 == null) goto L8;
        r100.a();
        this.f379197w = null;
    L8:
        k r101 = this.f379196v;
        if (r101 == null) goto L12;
        r101.a();
        this.f379196v = null;
    L12:
        if (this.f379192r == true) goto L17;
        if (this.f379198x == false) goto L17;
        r(3, b(this.f379190p), this.f379191q - this.f379190p, b(this.f379182h), -111);
    L17:
        if (this.f379182h != 0) goto L23;
        long r111 = this.f379200z;
        if (r111 <= 0) goto L24;
        if (r110 == true) goto L25;
        com.larus.utils.l0.b(new com.larus.voicecall.impl.tracer.c(this, this.f379199y, false, true, r111));
        return;
    L25:
        return;
    L24:
        return;
    }

    public void f(pf9.q r110) {
        Intrinsics.checkNotNullParameter(r110, "serverEvent");
        if (this.f379189o == false) goto L5;
        this.f379189o = false;
        com.larus.utils.l0.b(new f(this, 0, true));
    L5:
        List<pf9.p> r100 = r110.f528966a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L88;
        pf9.p r103 = (pf9.p) r102.next();
        Long r104 = r103.f528964a;
        Integer r111 = null;
        if (r104 == null) goto L11;
        Integer r105 = Integer.valueOf((int) r104.longValue());
    L12:
        if (r105 != null) goto L15;
    L16:
        if (r105 != null) goto L19;
    L20:
        if (r105 != null) goto L23;
    L24:
        if (r105 != null) goto L27;
    L28:
        if (r105 != null) goto L31;
    L33:
        if (r105 != null) goto L36;
    L67:
        if (r105 != null) goto L70;
    L71:
        if (r105 != null) goto L74;
    L76:
        List<Integer> r106 = z2.f365865a.o1();
        Long r107 = r103.f528964a;
        if (r107 == null) goto L80;
        r111 = Integer.valueOf((int) r107.longValue());
    L80:
        if (CollectionsKt.contains(r106, r111) == false) goto L87;
        Long r108 = r103.f528964a;
        if (r108 == null) goto L84;
        int r109 = (int) r108.longValue();
    L85:
        q(this, 0, r109, null, null, 12);
        goto L87
    L84:
        r109 = -1;
    L87:
        r101.add(r103);
        goto L7
    L74:
        if (r105.intValue() != 24) goto L76;
    L86:
        q(this, 0, 0, null, null, 14);
        goto L87
    L70:
        if (r105.intValue() == 23) goto L86;
    L36:
        if (r105.intValue() != 8) goto L67;
        Map<String, String> r112 = r103.f528965b;
        if (r112 == null) goto L44;
        String r113 = r112.get("tea_tags_time_cost");
        if (r113 == null) goto L44;
        String r114 = new JSONObject(r113).optString("agent_intention");
        if (o0.d(r114) == false) goto L44;
        Intrinsics.checkNotNull(r114);
        q(this, 0, 0, r114, null, 10);
    L44:
        JSONObject r115 = new JSONObject();
        int r116 = z2a.g.f569833a;
        com.larus.trace.tracespan.span.b r117 = z2a.g.c(this.f379175a.i().d(), "realcall_message");
        com.larus.trace.tracespan.span.b r118 = z2a.g.c(this.f379175a.i().d(), "llm_phase");
        Map<String, String> r119 = r103.f528965b;
        if (r119 == null) goto L49;
        String r120 = r119.get("intention");
        if (r120 == null) goto L49;
        this.f379186l = r120;
        r115.put("intention", r120);
    L49:
        Map<String, String> r121 = r103.f528965b;
        if (r121 != null) goto L52;
    L54:
        if (r117 == null) goto L56;
        ((SpanWrapImpl) r117).b(r115);
    L56:
        if (r118 == null) goto L58;
        ((SpanWrapImpl) r118).b(r115);
    L58:
        Map<String, String> r122 = r103.f528965b;
        if (r122 == null) goto L61;
        String r123 = r122.get("is_chat_resp_first");
    L63:
        if (Intrinsics.areEqual(r123, "1") == false) goto L87;
        if (this.f379189o == false) goto L87;
        this.f379189o = false;
        com.larus.audio.call.tracer.b.b(this.f379175a.i(), "llm_phase", null, 6);
        this.f379175a.i().f("tts_delay", "realcall_message");
        goto L87
    L61:
        r123 = null;
        goto L63
    L52:
        if (r121.get("is_pacity") == null) goto L54;
        r115.put("is_pacity", "1");
        goto L54
    L31:
        if (r105.intValue() != 21) goto L33;
    L27:
        if (r105.intValue() == 5) goto L87;
    L23:
        if (r105.intValue() == 14) goto L87;
    L19:
        if (r105.intValue() == 12) goto L87;
    L15:
        if (r105.intValue() == 13) goto L87;
    L11:
        r105 = null;
        goto L12
    }

    public void g(pf9.q r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void h(pf9.z r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void i(pf9.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void j(pf9.c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void k(pf9.d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void l(pf9.e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public void m(pf9.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public j(com.larus.audio.call.arch.c r100, String r101, boolean r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "questionId");
        Intrinsics.checkNotNullParameter(r103, "currentConnectValid");
        this.f379175a = r100;
        this.f379176b = r101;
        this.f379177c = r102;
        this.f379178d = r103;
        this.f379179e = r100.params().f288751k.a();
        this.f379180f = r100.params().f288745e;
        this.f379181g = r100.params().f288743d;
        this.f379183i = -1;
        this.f379187m = true;
        this.f379188n = true;
        this.f379189o = true;
        this.f379192r = true;
        this.f379198x = true;
        this.D = "";
        b r104 = new b(this);
        this.I = r104;
        com.larus.audio.call.arch.b.a(r100).e0().i(r104);
    }

    public final void d(pf9.a0 r210, String r211, boolean r310, String r311) {
        Intrinsics.checkNotNullParameter(r210, "asrEndData");
        this.H = null;
        this.f379193s = false;
        this.f379186l = null;
        this.f379182h = System.currentTimeMillis();
        Long r100 = r210.f528882b;
        if (r100 == null) goto L5;
        long r101 = RangesKt.coerceAtLeast(r100.longValue(), 0);
    L6:
        this.f379183i = r101;
        long r102 = r210.f528886f;
        if (r102 > 0) goto L10;
        r102 = r210.f528887g;
    L10:
        this.G = r102;
        long r110 = r210.f528881a;
        boolean r103 = r210.f528883c;
        if (r103 == false) goto L13;
    L16:
        if (r103 == true) goto L18;
    L20:
        boolean r104 = false;
    L21:
        this.f379198x = r104;
        IRealtimeCallTracer r111 = this.f379175a.k();
        RealtimeCallParam r112 = this.f379175a.params();
        int r113 = (int) r110;
        Long r105 = r210.f528882b;
        if (r105 == null) goto L24;
        long r114 = r105.longValue();
    L25:
        long r106 = this.G;
        String r107 = this.f379176b;
        if (r310 == true) goto L28;
        String r108 = "auto";
    L29:
        r111.d0(r112, r113, r114, r106, r103, r211, r107, r108, Long.valueOf(this.f379184j), Long.valueOf(this.f379182h), r311);
        if (this.E == false) goto L33;
        this.f379199y = 0;
        this.f379200z = 0;
    L33:
        if (this.f379178d.invoke().booleanValue() == false) goto L36;
        com.larus.utils.l0.b(new com.larus.voicecall.impl.tracer.c(this, this.f379199y, this.f379198x, false, this.f379200z));
        com.larus.audio.call.tracer.b.b(this.f379175a.i(), "asr_phase", null, 6);
        this.f379175a.i().f("llm_phase", "realcall_message");
        this.f379175a.k().c0(r110);
        long r109 = c();
        FLogger.f375446a.i("RealtimeCallQueryMonitor", "startExpResponseTimer timeoutDuration = " + r109);
        c r115 = new c(r109, this);
        this.f379195u = r115;
        r115.d();
        this.C = 0;
        return;
    L36:
        return;
    L28:
        r108 = "click_sound_wave";
        goto L29
    L24:
        r114 = 0;
        goto L25
    L18:
        if (r210.f528884d == false) goto L20;
    L19:
        r104 = true;
        goto L21
    L13:
        if (r110 > 0) goto L19;
        if (Intrinsics.areEqual(this.f379179e, "dora_radio") == true) goto L19;
    L5:
        r101 = 0;
        goto L6
    }

    public void p(final int r100, final int r101, final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r110, "agentIntention");
        Intrinsics.checkNotNullParameter(r111, "bisScene");
        com.larus.utils.l0.b(new d(this, r100, r110, r111, r101));
    }

    public final void r(final int r110, final long r111, final long r112, final long r113, final int r114) {
        com.larus.utils.l0.b(new e(this, r110, r112, r111, r113, r114));
    }

    public static /* synthetic */ void q(j r100, int r101, int r102, String r103, String r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = -1;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = "";
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = "";
    L11:
        r100.p(r101, r102, r103, r104);
    }
}
