package com.larus.avlink.plugins;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.avlink.liveai.DoraLiveAiTracer;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class u2 extends com.larus.avlink.plugins.c<n4> implements w4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w98.a f294088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w98.d f294089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f294090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IDoraService.a.InterfaceC4203a f294091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f294092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f294093k;

    public static final class a implements t39.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u2 f294094a;

        @Override // t39.g
        public final void c() {
            w98.a r100 = this.f294094a.f294088f;
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.f558750f != null) goto L9;
            r100.f558750f = Long.valueOf(System.currentTimeMillis());
            this.f294094a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onVideoCodecInfo: first codec info received.");
            return;
        }

        public a(u2 r100) {
            this.f294094a = r100;
        }

        @Override // t39.g
        public final void a(t39.s r110) {
            Intrinsics.checkNotNullParameter(r110, "mirrorData");
            w98.a r100 = this.f294094a.f294088f;
            if (r100 != null) goto L5;
            return;
        L5:
            r100.f558748d = Long.valueOf(System.currentTimeMillis());
            int r101 = r110.f544485f;
            r100.f558753i = r101;
            r100.f558755k = new w98.b(r110.f544480a, r110.f544481b, r110.f544482c, r110.f544483d, r110.f544484e, r101, r110.f544486g);
            this.f294094a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onRecvMirrorData: mirror connected, transType: " + r110.f544487h + ", data: " + r110);
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.audio.call.arch.c] */
        @Override // t39.g
        public final void b(tf9.a r110) {
            tf9.a r100 = r110;
            Intrinsics.checkNotNullParameter(r100, "frame");
            w98.a r101 = this.f294094a.f294088f;
            if (r101 != null) goto L7;
            com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", "drop video frame: trace model unavailable, timestampUs=" + r100.f545769c + ", frameType=" + r100.f545774h + ", codec=" + r100.f545773g + ", dataSize=" + r100.f545767a.length);
            return;
        L7:
            if (r101.f558749e != null) goto L9;
            r101.f558749e = Long.valueOf(System.currentTimeMillis());
            this.f294094a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onVideoData: first I-frame received.");
        L9:
            r101.f558752h++;
            x4 r102 = (x4) this.f294094a.getContext().c(Reflection.getOrCreateKotlinClass(x4.class), null);
            if (r102 != null) goto L13;
            this.f294094a.getClass();
            com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", "drop video frame: video frame sender unavailable, timestampUs=" + r100.f545769c + ", frameType=" + r100.f545774h + ", codec=" + r100.f545773g + ", dataSize=" + r100.f545767a.length);
            return;
        L13:
            w98.d r103 = this.f294094a.f294089g;
            if (r103 == null) goto L42;
            long r104 = System.currentTimeMillis();
            long r105 = r100.f545769c / ((long) 1000);
            int r106 = r100.f545770d;
            int r107 = r100.f545771e;
            if (r105 <= 0) goto L19;
            long r111 = r104 - r105;
        L20:
            Object r112 = r103.f558772d;
            monitor-enter(r112);
        L44:
            th = move-exception;
            throw th;
        L23:
            if (r103.f558783o == false) goto L26;
            monitor-exit(r112);
            goto L42
        L26:
            r103.f558773e++;     // Catch: Throwable -> L44
            r103.f558774f += (long) r106;     // Catch: Throwable -> L44
            r103.f558775g += (long) r107;     // Catch: Throwable -> L44
            if (r111 < 0) goto L29;
            r103.f558776h += r111;     // Catch: Throwable -> L44
        L29:
            if (r105 <= 0) goto L39;
            r103.f558782n.put(Long.valueOf(r105), new w98.d.b(r104));     // Catch: Throwable -> L44
            if (r103.f558782n.size() <= r103.f558771c) goto L39;
            Iterator<Map.Entry<Long, w98.d.b>> r108 = r103.f558782n.entrySet().iterator();     // Catch: Throwable -> L44
        L35:
            if (r103.f558782n.size() <= r103.f558771c) goto L39;
            if (r108.hasNext() == false) goto L39;
            r108.next();     // Catch: Throwable -> L44
            r108.remove();     // Catch: Throwable -> L44
        L39:
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L44
            monitor-exit(r112);
            r100 = r110;
            goto L42
        L19:
            r111 = -1;
        L42:
            r102.u1(r100);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.audio.call.arch.c] */
        @Override // t39.g
        public final void d(boolean r100, String r101, long r110) {
            Intrinsics.checkNotNullParameter(r101, "ocrText");
            this.f294094a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onRecvOcrData: hasText=" + r100 + ", ts=" + r110);
            long r102 = System.currentTimeMillis();
            if (r100 == false) goto L25;
            w98.d r103 = this.f294094a.f294089g;
            if (r103 == null) goto L25;
            if (r110 <= 0) goto L9;
            long r104 = r102 - r110;
        L10:
            Object r105 = r103.f558772d;
            monitor-enter(r105);
        L22:
            th = move-exception;
            throw th;
        L13:
            if (r103.f558783o == false) goto L16;
            monitor-exit(r105);
            goto L25
        L16:
            r103.f558780l++;     // Catch: Throwable -> L22
            if (r104 < 0) goto L19;
            r103.f558781m += r104;     // Catch: Throwable -> L22
        L19:
            w98.d.b r106 = r103.f558782n.get(Long.valueOf(r110));     // Catch: Throwable -> L22
            Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r105);
            goto L25
        L9:
            r104 = -1;
        L25:
            x4 r108 = (x4) this.f294094a.getContext().c(Reflection.getOrCreateKotlinClass(x4.class), null);
            if (r108 != null) goto L29;
            this.f294094a.getClass();
            com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", "drop OCR: video frame sender unavailable, timestamp=" + r110);
            return;
        L29:
            r108.l2(new we9.e(r100, r101, r110));
        }
    }

    public static final class b implements com.larus.im.service.audio.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u2 f294095a;

        @Override // com.larus.im.service.audio.v
        public final String getName() {
            return "DoraRtcVideoStreamPlugin";
        }

        public b(u2 r100) {
            this.f294095a = r100;
            r100.getClass();
        }

        @Override // com.larus.im.service.audio.v
        public final void O1(jd9.c r100, jd9.c r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            this.f294095a.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onConnectionStateChanged status=" + r101);
            if (((n4) this.f294095a.getContext()).E() == true) goto L6;
            return;
        L6:
            if ((r101 instanceof jd9.c.a) == false) goto L8;
            this.f294095a.k3("onConnectionStateChanged");
            return;
        L8:
            this.f294095a.f294092j = false;
        }
    }

    public static final class c extends com.larus.im.service.audio.z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f294096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u2 f294097b;

        @Override // com.larus.im.service.audio.z0
        public final void k() {
            u2 r100 = this.f294097b;
            w98.a r101 = r100.f294088f;
            if (r101 == null) goto L5;
            r101.f558756l++;
        L5:
            r100.getClass();
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onExternalVideoKeyFrameRequested");
            DoraByteCastManagerDelegate.f331705b.requestKeyFrame();
        }

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f294096a;
        }

        public c(u2 r100) {
            this.f294097b = r100;
            r100.getClass();
            this.f294096a = "DoraRtcVideoStreamPlugin";
        }

        @Override // com.larus.im.service.audio.z0
        public final void l(long r100) {
            DoraByteCastManagerDelegate.f331705b.e(r100);
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(com.larus.im.service.audio.z0.a r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            if ((r110 instanceof pf9.w) == false) goto L83;
            u2 r100 = this.f294097b;
            pf9.w r111 = (pf9.w) r110;
            w98.a r101 = r100.f294088f;
            if (r101 == null) goto L84;
            Map<String, String> r102 = r111.f528979e;
            Long r103 = null;
            if (r102 == null) goto L10;
            String r104 = r102.get("is_from_rtc");
        L12:
            if (Intrinsics.areEqual(r104, "1") == false) goto L85;
            long r105 = System.currentTimeMillis();
            boolean r106 = true;
            if (r111.f528975a == false) goto L53;
            Map<String, String> r107 = r111.f528979e;
            if (r107 == null) goto L23;
            String r108 = r107.get("pic_shooting_time_ms");
            if (r108 == null) goto L23;
            Long r109 = StringsKt.toLongOrNull(r108);
            if (r109 == null) goto L23;
            long r112 = r109.longValue();
        L24:
            w98.d r113 = r100.f294089g;
            if (r113 == null) goto L53;
            Object r114 = r113.f558772d;
            monitor-enter(r114);
        L49:
            th = move-exception;
            throw th;
        L29:
            if (r113.f558783o == false) goto L32;
            monitor-exit(r114);
            goto L53
        L32:
            w98.d.b r115 = r113.f558782n.get(Long.valueOf(r112));     // Catch: Throwable -> L49
            if (r115 != null) goto L37;
            monitor-exit(r114);
            goto L53
        L37:
            if (r115.f558787d == false) goto L39;
        L47:
            monitor-exit(r114);
            goto L53
        L39:
            if (r115.f558786c == true) goto L47;
            r115.f558785b = true;     // Catch: Throwable -> L49
            r115.f558787d = true;     // Catch: Throwable -> L49
            r113.f558777i++;     // Catch: Throwable -> L49
            r113.f558779k++;     // Catch: Throwable -> L49
            long r116 = r105 - r115.f558784a;     // Catch: Throwable -> L49
            if (r116 < 0) goto L44;
            r113.f558778j += r116;     // Catch: Throwable -> L49
        L44:
            Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L49
            monitor-exit(r114);
        L23:
            r112 = 0;
        L53:
            if (r101.f558757m == true) goto L86;
            com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "handleFileDownlinkReceived, code: " + r111.f528976b + ", msg: " + r111.f528977c);
            r101.f558751g = Long.valueOf(r105);
            r101.f558757m = true;
            boolean r118 = DoraLiveAiTracer.f293391b;
            int r119 = ((n4) r100.getContext()).q();
            n4 r120 = (n4) r100.getContext();
            Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
            LinkedHashMap r121 = new LinkedHashMap();
            Long r122 = r101.f558746b;
            if (r122 != null) goto L58;
            r122 = r101.f558745a;
        L58:
            r121.put("rtc_connection_time", Long.valueOf(DoraLiveAiTracer.a(r101.f558749e, r101.f558745a)));
            r121.put("mirror_connect_finish_time", Long.valueOf(DoraLiveAiTracer.a(r101.f558748d, r122)));
            r121.put("mirror_to_ps_frame_time", Long.valueOf(DoraLiveAiTracer.a(r101.f558750f, r101.f558748d)));
            r121.put("mirror_to_video_frame_time", Long.valueOf(DoraLiveAiTracer.a(r101.f558749e, r101.f558748d)));
            Long r123 = r101.f558751g;
            if (r123 == null) goto L66;
            long r124 = r123.longValue();
            r121.put("first_frame_server_parse_time", Long.valueOf(DoraLiveAiTracer.a(Long.valueOf(r124), r101.f558745a)));
            Long r125 = Long.valueOf(r124);
            Long r126 = r101.f558749e;
            if (r125 == null) goto L64;
            if (r126 == null) goto L64;
            long r127 = r125.longValue() - r126.longValue();
        L65:
            r121.put("first_frame_server_parse_after_idr_time", Long.valueOf(r127));
        L64:
            r127 = -1;
        L66:
            w98.b r128 = r101.f558755k;
            if (r128 == null) goto L69;
            r121.put("bwdl_connect_time", Integer.valueOf(r128.f558759a));
            r121.put("cast_connect_time", Integer.valueOf(r128.f558760b));
            r121.put("cast_init_time", Integer.valueOf(r128.f558761c));
            r121.put("cast_start_mirror_time", Integer.valueOf(r128.f558762d));
            r121.put("mirror_height", Integer.valueOf(r128.f558763e));
            r121.put("mirror_fps", Integer.valueOf(r128.f558764f));
            r121.put("mirror_width", Integer.valueOf(r128.f558765g));
        L69:
            Long r129 = r101.f558747c;
            if (r129 != null) goto L72;
        L79:
            r121.put("trans_type", Integer.valueOf(DoraLiveAiTracer.f()));
            r121.put("mode", Integer.valueOf(r119));
            r121.put("av_session_type", Integer.valueOf(r120.params().f288759s.getType()));
            Map<Function1<Boolean, Unit>, k4> r130 = x2.f294117a;
            x2.e("dora_video_liveai_init", r121);
            return;
        L72:
            if (r129.longValue() >= 0) goto L75;
            r106 = false;
        L75:
            if (r106 == false) goto L77;
            r103 = r129;
        L77:
            if (r103 == null) goto L79;
            r121.put("p2p_connection_time", Long.valueOf(r103.longValue()));
            goto L79
        L86:
            return;
        L85:
            return;
        L10:
            r104 = null;
            goto L12
        L84:
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return "DoraRtcVideoStreamPlugin";
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    public final void l3() {
        w98.a r100 = this.f294088f;
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "reportRtcVideoStreamEnd, frameCount=" + r100.f558752h + ", requestKeyFrameCount=" + r100.f558756l + ", hasReportedVideoInit=" + r100.f558757m);
        boolean r101 = DoraLiveAiTracer.f293391b;
        n4 r102 = (n4) getContext();
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinkedHashMap r103 = new LinkedHashMap();
        long r104 = System.currentTimeMillis();
        Long r105 = r100.f558748d;
        if (r105 == null) goto L8;
        long r106 = r105.longValue();
    L9:
        long r107 = r104 - r106;
        r103.put("mirror_duration", Long.valueOf(r107));
        r103.put("mirror_total_frames", Integer.valueOf(r100.f558752h));
        r103.put("rtc_request_key_frame_count", Integer.valueOf(r100.f558756l));
        w98.b r108 = r100.f558755k;
        if (r108 == null) goto L12;
        r103.put("mirror_height", Integer.valueOf(r108.f558763e));
        r103.put("mirror_fps", Integer.valueOf(r108.f558764f));
        r103.put("mirror_width", Integer.valueOf(r108.f558765g));
        long r109 = (r107 / 1000) * ((long) r108.f558764f);
        r103.put("loss_frame_rate", Float.valueOf(((r109 - ((long) r100.f558752h)) * 1.0f) / r109));
    L12:
        r103.put("trans_type", Integer.valueOf(DoraLiveAiTracer.f()));
        r103.put("mode", Integer.valueOf(r100.f558758n));
        r103.put("av_session_type", Integer.valueOf(r102.params().f288759s.getType()));
        Map<Function1<Boolean, Unit>, k4> r110 = x2.f294117a;
        x2.e("dora_video_liveai_end", r103);
        w98.d r111 = this.f294089g;
        if (r111 == null) goto L43;
        long r112 = System.currentTimeMillis();
        int r113 = w98.d.f558768p;
        Object r114 = r111.f558772d;
        monitor-enter(r114);
    L40:
        th = move-exception;
        throw th;
    L17:
        if (r111.f558783o == false) goto L20;
        monitor-exit(r114);
    L39:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "reportConversationFrameInfo, received=" + r111.g() + ", upload=" + r111.h() + ", actualUpload=" + r111.a() + ", ocr=" + r111.f());
        boolean r115 = DoraLiveAiTracer.f293391b;
        DoraLiveAiTracer.b(r111, (n4) getContext());
        goto L43
    L20:
        Iterator<T> r116 = r111.f558782n.values().iterator();     // Catch: Throwable -> L40
    L22:
        if (r116.hasNext() == false) goto L37;
        w98.d.b r117 = (w98.d.b) r116.next();     // Catch: Throwable -> L40
        long r118 = r112 - r117.f558784a;     // Catch: Throwable -> L40
        if (r117.f558785b == false) goto L22;
        if (r117.f558787d == true) goto L22;
        if (r117.f558786c == true) goto L22;
        if (0 <= r118) goto L32;
    L34:
        boolean r119 = false;
    L35:
        if (r119 == false) goto L22;
        r117.f558787d = true;     // Catch: Throwable -> L40
        r111.f558777i++;     // Catch: Throwable -> L40
        goto L22
    L32:
        if (r118 > 2000) goto L34;
        r119 = true;
        goto L35
    L37:
        r111.f558783o = true;     // Catch: Throwable -> L40
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L40
        monitor-exit(r114);
    L43:
        this.f294088f = null;
        this.f294089g = null;
        return;
    L8:
        r106 = System.currentTimeMillis();
        goto L9
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        if (((n4) getContext()).E() == false) goto L12;
        id9.d r100 = ((n4) getContext()).j();
        if (r100 == null) goto L7;
        jd9.c r101 = r100.state();
    L9:
        if ((r101 instanceof jd9.c.a) == false) goto L11;
        k3("onStart(mmt-connected)");
        return;
    L11:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onStart: MMT session, defer external capture setup until connected.");
        return;
    L7:
        r101 = null;
        goto L9
    L12:
        k3(WidgetCostModule.TYPE_ON_START);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        IDoraService.a.InterfaceC4203a r100 = this.f294091i;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onStop");
        this.f294092j = false;
        if (this.f294090h == false) goto L9;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "unregisterRtcVideoStreamCallbacks.");
        DoraByteCastManagerDelegate.f331705b.f();
        this.f294090h = false;
    L9:
        l3();
    }

    public u2(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f294093k = new a(this);
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void Q0(int r100) {
        IDoraService.a.InterfaceC4203a r101 = this.f294091i;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onConversationEnd: reason=" + r100);
        if (this.f294090h == false) goto L9;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "unregisterRtcVideoStreamCallbacks.");
        DoraByteCastManagerDelegate.f331705b.f();
        this.f294090h = false;
    L9:
        l3();
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L15;
        AbilityService r103 = r102.o0();
        if (r103 == null) goto L16;
        r103.h();
        return;
    L16:
        return;
    }

    public final void k3(String r100) {
        if (this.f294092j == false) goto L6;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", r100.concat(": external capture already configured, skip."));
        return;
    L6:
        id9.d r101 = ((n4) getContext()).j();
        if (r101 != null) goto L10;
        com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", r100.concat(": media session unavailable, external encoded capture not configured."));
        return;
    L10:
        com.larus.im.service.audio.z r102 = r101.e();
        if (r102 != null) goto L14;
        com.larus.avlink.n1.e("DoraRtcVideoStreamPlugin", r100.concat(": video service unavailable, external encoded capture not configured."));
        return;
    L14:
        r102.t(true);
        this.f294092j = true;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", r100.concat(": external encoded video capture configured."));
    }

    @Override // com.larus.avlink.plugins.w4
    public final void S0(long r100, boolean r101) {
        w98.d r102 = this.f294089g;
        if (r102 == null) goto L31;
        Object r103 = r102.f558772d;
        monitor-enter(r103);
    L28:
        th = move-exception;
        throw th;
    L7:
        if (r102.f558783o == false) goto L10;
        monitor-exit(r103);
        return;
    L10:
        w98.d.b r104 = r102.f558782n.get(Long.valueOf(r100));     // Catch: Throwable -> L28
        if (r104 != null) goto L15;
        monitor-exit(r103);
        return;
    L15:
        if (r104.f558787d == false) goto L17;
    L26:
        monitor-exit(r103);
        return;
    L17:
        if (r104.f558786c == true) goto L26;
        if (r101 == false) goto L22;
        r104.f558785b = true;     // Catch: Throwable -> L28
    L23:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r103);
        return;
    L22:
        r104.f558786c = true;     // Catch: Throwable -> L28
        goto L23
    }

    @Override // com.larus.avlink.plugins.c, com.larus.avlink.plugins.o4
    public final void i0(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "caller");
        Intrinsics.checkNotNullParameter(r110, "caller");
        IDoraService r113 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r113 == null) goto L8;
        AbilityService r114 = r113.o0();
        if (r114 == null) goto L8;
        r114.g();
    L8:
        if (((n4) getContext()).A() == true) goto L11;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "onConversationStart: rtc video stream disabled, skip.");
        return;
    L11:
        IDoraService.a.InterfaceC4203a r115 = this.f294091i;
        Long r116 = null;
        if (r115 != null) goto L19;
        IDoraService r117 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r117 == null) goto L18;
        AbilityService r118 = r117.o0();
        if (r118 == null) goto L18;
        r115 = new AbilityService.VideoStreamLifecycleImpl(r118);
    L18:
        r115 = null;
    L19:
        this.f294091i = r115;
        if (r115 == null) goto L22;
        r115.b(((n4) getContext()).q(), ((n4) getContext()).x(), ((n4) getContext()).E());
    L22:
        long r100 = System.currentTimeMillis();
        Long r101 = Long.valueOf(r100);
        Long r119 = Long.valueOf(((n4) getContext()).params().f288741c);
        long r102 = r119.longValue();
        if (r102 > 0) goto L25;
    L29:
        boolean r103 = false;
    L30:
        if (r103 == false) goto L32;
        Long r104 = r119;
    L33:
        IDoraService r120 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r120 == null) goto L38;
        AbilityService r121 = r120.o0();
        if (r121 == null) goto L38;
        r116 = r121.e();
    L38:
        this.f294088f = new w98.a(r101, r104, r116, ((n4) getContext()).q(), 8184);
        this.f294089g = new w98.d(r100, ((n4) getContext()).q());
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "enter RTC video stream, mode: " + ((n4) getContext()).q() + '.');
        boolean r122 = DoraLiveAiTracer.f293391b;
        int r123 = ((n4) getContext()).q();
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put("trans_type", Integer.valueOf(DoraLiveAiTracer.f()));
        r124.put("mode", Integer.valueOf(r123));
        Map<Function1<Boolean, Unit>, k4> r125 = x2.f294117a;
        x2.e("dora_video_liveai_start", r124);
        if (((n4) getContext()).A() == true) goto L42;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "skip video callback registration: rtc video stream disabled.");
        return;
    L42:
        if (this.f294090h == false) goto L44;
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "skip video callback registration: callback already registered.");
        return;
    L44:
        com.larus.avlink.n1.d("DoraRtcVideoStreamPlugin", "registerRtcVideoStreamCallbacks.");
        DoraByteCastManagerDelegate.f331705b.g(this.f294093k);
        this.f294090h = true;
        return;
    L32:
        r104 = null;
        goto L33
    L25:
        if (r102 > r100) goto L29;
        if (v88.a.b(Integer.valueOf(((n4) getContext()).q())) == true) goto L29;
        r103 = true;
        goto L30
    }
}
