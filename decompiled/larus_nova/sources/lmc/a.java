package lmc;

import android.os.Looper;
import android.os.Message;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.data.SdkUplinkPacket;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import com.ss.ugc.live.sdk.msg.network.m;
import com.ss.ugc.live.sdk.msg.uplink.UplinkException;
import com.ss.ugc.live.sdk.msg.uplink.UplinkStrategy;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import com.ss.ugc.live.sdk.msg.utils.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPOutputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements m, i.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f509905m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f509906n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f509907o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f509908p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f509909q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UplinkStrategy f509910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lmc.c f509911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f509912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f509913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f509914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final lmc.e f509915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f509916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final amc.i f509917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f509918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.network.i f509919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final vlc.g f509920k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final vlc.c f509921l;

    /* JADX INFO: renamed from: lmc.a$a, reason: collision with other inner class name */
    public static final class C6712a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f509922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f509923b;

        public final void a() {
            lmc.d r100 = this.f509923b.f509915f.a(this.f509922a);
            if (r100 == null) goto L6;
            com.ss.ugc.live.sdk.msg.utils.a.c(this.f509923b.f509921l, "ws uplink timeout, serviceId: " + r100.f509946l + ", uniqueId: " + r100.f509945k);
            r100.c(new UplinkException(-2, "ws timeout", null, null, 12, null), "ws", this.f509923b.f509918i.c());
            this.f509923b.e(r100);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, long r101) {
            this.f509923b = r100;
            this.f509922a = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f509924a;

        public c() {
            this.f509924a = new AtomicLong(Random.Default.nextLong(0, 10000));
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ lmc.d f509925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.utils.g f509926b;

        public d(lmc.d r100, com.ss.ugc.live.sdk.msg.utils.g r101) {
            this.f509925a = r100;
            this.f509926b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f509925a.f509949o.a(this.f509926b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements com.ss.ugc.live.sdk.msg.network.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f509927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ lmc.d f509928b;

        @Override // com.ss.ugc.live.sdk.msg.network.e
        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            lmc.d r101 = this.f509928b;
            r101.f509937c = r100;
            i r102 = this.f509927a.f509913d;
            if (r102 == null) goto L8;
            int r103 = a.f509905m;
            Message r104 = r102.obtainMessage(a.f509907o, r101);
            if (r104 == null) goto L9;
            r104.sendToTarget();
            return;
        L9:
            return;
        }

        public e(a r100, lmc.d r101) {
            this.f509927a = r100;
            this.f509928b = r101;
        }
    }

    public static final class f implements com.ss.ugc.live.sdk.msg.network.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f509929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ lmc.d f509930b;

        @Override // com.ss.ugc.live.sdk.msg.network.e
        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            lmc.d r101 = this.f509930b;
            r101.f509937c = r100;
            i r102 = this.f509929a.f509913d;
            if (r102 == null) goto L8;
            int r103 = a.f509905m;
            Message r104 = r102.obtainMessage(a.f509907o, r101);
            if (r104 == null) goto L9;
            r104.sendToTarget();
            return;
        L9:
            return;
        }

        public f(a r100, lmc.d r101) {
            this.f509929a = r100;
            this.f509930b = r101;
        }
    }

    public static final class g implements com.ss.ugc.live.sdk.msg.network.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f509931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ lmc.d f509932b;

        @Override // com.ss.ugc.live.sdk.msg.network.e
        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            lmc.d r101 = this.f509932b;
            r101.f509936b = r100;
            i r102 = this.f509931a.f509913d;
            if (r102 == null) goto L8;
            int r103 = a.f509905m;
            Message r104 = r102.obtainMessage(a.f509906n, r101);
            if (r104 == null) goto L9;
            r104.sendToTarget();
            return;
        L9:
            return;
        }

        public g(a r100, lmc.d r101) {
            this.f509931a = r100;
            this.f509932b = r101;
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void a() {
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void d(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
    }

    static {
        f509905m = 12346;
        f509906n = 12347;
        f509907o = 12348;
        f509908p = 12349;
        f509909q = 12350;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        lmc.c r101 = this.f509911b;
        if (r101 == null) goto L5;
        Looper r102 = r101.getLooper();
    L6:
        if (r102 == null) goto L11;
        i r103 = this.f509914e;
        if (r103 == null) goto L12;
        r103.sendEmptyMessage(f509909q);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void e(lmc.d r110) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "uplink request finished, serviceId: " + r110.f509946l + ", uniqueId: " + r110.f509945k);
        lmc.e r100 = this.f509915f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "requestItem");
        r100.f509950a.remove(Long.valueOf(r110.f509945k));
        Runnable r101 = r110.f509943i;
        if (r101 == null) goto L7;
        i r102 = this.f509912c;
        if (r102 == null) goto L7;
        r102.removeCallbacks(r101);
    L7:
        lmc.f r103 = r110.f509942h;
        vlc.g r104 = this.f509920k;
        vlc.c r105 = this.f509921l;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "monitor");
        Intrinsics.checkNotNullParameter(r105, "logger");
        if (r103.f509956f <= r103.f509955e) goto L29;
        JSONObject r106 = new JSONObject();
        r106.put("service_id", r103.f509962l);
        r106.put("status_code", r103.f509958h);
        r106.put("expect_strategy", r103.f509951a);
        r106.put("actual_strategy", r103.f509952b);
        r106.put("ws_connected_on_send", r103.f509953c);
        r106.put("ws_connected_on_finish", r103.f509954d);
        r106.put("success", r103.f509957g);
        long r107 = r103.f509956f - r103.f509955e;
        JSONObject r111 = new JSONObject();
        r111.put("use_time", r107);
        JSONObject r112 = new JSONObject();
        r112.put(BdpAppEventConstant.PARAMS_UNIQUEID, r103.f509961k);
        r112.put("status_message", r103.f509959i);
        r112.put("send_time", r103.f509955e);
        r112.put("finish_time", r103.f509956f);
        String r108 = r103.f509960j;
        if (r108 != null) goto L13;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == true) goto L19;
        r112.put("log_id", r103.f509960j);
    L19:
        r104.d(r107, r106, r111, r112);
        if (r103.f509957g == true) goto L22;
        r104.e("uplink_status_error", r106, r111, r112);
    L22:
        JSONObject r113 = new JSONObject();
        r113.put("category", r106);
        r113.put("metric", r111);
        r113.put("extra", r112);
        com.ss.ugc.live.sdk.msg.utils.a.c(r105, "uplink stat: " + r113);
        goto L29
    L13:
        if (r108.length() == 0) goto L16;
        r109 = false;
    L29:
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> r114 = r110.a();     // Catch: Exception -> L25
    L27:
        MainTaskScheduler.a(new d(r110, r114));
        return;
    L25:
        e = move-exception;
        int r115 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        r114 = com.ss.ugc.live.sdk.msg.utils.g.a.a(e);
        goto L27
    }

    public final void g(lmc.d r100) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "send uplink packet by origin http, serviceId: " + r100.f509946l + ", uniqueId: " + r100.f509945k);
        HttpMethod r101 = r100.f509948n.f458298a;
        if (r101 != null) goto L6;
        r101 = HttpMethod.POST;
    L6:
        int r102 = lmc.b.f509933a[r101.ordinal()];
        if (r102 != 1) goto L9;
        this.f509919j.b(r100.f509948n, new e(this, r100));
        return;
    L9:
        if (r102 != 2) goto L15;
        this.f509919j.c(r100.f509948n, new f(this, r100));
        return;
    }

    public final void h(lmc.d r100) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "send uplink packet by uplink http, serviceId: " + r100.f509946l + ", uniqueId: " + r100.f509945k);
        String r101 = this.f509917h.e();
        Intrinsics.checkNotNullParameter(r101, "uplinkHttpUrl");
        SdkUplinkPacket r102 = r100.b();
        com.ss.ugc.live.sdk.msg.network.f r103 = new com.ss.ugc.live.sdk.msg.network.f();
        r103.f458304g = "application/protobuf";
        r103.f458299b = r101;
        r103.f458302e = r102.encode();
        if (r103.f458305h != null) goto L5;
        r103.f458305h = Collections.emptyMap();
    L5:
        this.f509919j.b(r103, new g(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.i.a
    public final void handleMsg(Message r110) {
        if (r110 == null) goto L162;
        int r100 = r110.what;
        if (r100 != 12345) goto L38;
        Object r101 = r110.obj;
        if (r101 == null) goto L37;
        lmc.d r102 = (lmc.d) r101;
        lmc.e r103 = this.f509915f;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "requestItem");
        r103.f509950a.put(Long.valueOf(r102.f509945k), r102);
        String r104 = this.f509910a.getStrategy(this.f509918i.c());
        boolean r105 = this.f509918i.c();
        Intrinsics.checkNotNullParameter(r104, "expectUplinkStrategy");
        lmc.f r106 = r102.f509942h;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r104, "uplinkStrategy");
        r106.f509955e = System.currentTimeMillis();
        r106.f509951a = r104;
        r106.f509953c = r105;
        UplinkStrategy r107 = this.f509910a;
        UplinkStrategy r108 = UplinkStrategy.WS_MSG_ORIGIN;
        if (r107 == r108) goto L13;
        if (r107 == UplinkStrategy.WS_ORIGIN) goto L13;
    L19:
        if (this.f509910a != r108) goto L21;
    L169:
        h(r102);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        r102.c(e, UplinkStrategy.UPLINK_HTTP, this.f509918i.c());
        e(r102);
        c(r102.f509946l, UplinkStrategy.UPLINK_HTTP, this.f509918i.c(), e);
        return;
    L21:
        if (r102.f() == false) goto L169;
        if (r102.f509948n.f458309l == true) goto L26;
    L31:
        UplinkException r109 = new UplinkException(-6, "not support origin http", null, null, 12, null);
        r102.c(r109, "ws", this.f509918i.c());
        e(r102);
        c(r102.f509946l, "ws", this.f509918i.c(), r109);
        return;
    L26:
        if (r102.f() == false) goto L31;
        g(r102);     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        r102.c(e, UplinkStrategy.ORIGIN_HTTP, this.f509918i.c());
        e(r102);
        c(r102.f509946l, UplinkStrategy.ORIGIN_HTTP, this.f509918i.c(), e);
        return;
    L13:
        if (this.f509918i.c() == false) goto L19;
        j(r102);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        r102.c(e, "ws", true);
        e(r102);
        c(r102.f509946l, "ws", this.f509918i.c(), e);
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.uplink.UplinkRequestItem");
    L38:
        String r111 = "server error";
        if (r100 != f509905m) goto L79;
        Object r112 = r110.obj;
        if (r112 == null) goto L77;
        tlc.f r113 = (tlc.f) r112;
        byte[] r114 = r113.f546764e;     // Catch: Exception -> L70
        if (Intrinsics.areEqual(com.ss.ugc.live.sdk.msg.utils.h.a(r113), DownloadHelper.GZIP) == false) goto L46;
        r114 = com.ss.ugc.live.sdk.msg.utils.b.a(r114);     // Catch: Exception -> L70
    L46:
        SdkUplinkPacket r115 = SdkUplinkPacket.ADAPTER.decode(r114);     // Catch: Exception -> L70
        String r116 = com.ss.ugc.live.sdk.msg.utils.h.b(r115);     // Catch: Exception -> L70
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive uplink packet by ws, logId: ".concat(r116));     // Catch: Exception -> L70
        lmc.d r117 = this.f509915f.a(r115.uniqueID.longValue());     // Catch: Exception -> L70
        if (r117 != null) goto L49;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "no request item found");     // Catch: Exception -> L70
        return;
    L49:
        UplinkStrategy.a r118 = UplinkStrategy.Companion;     // Catch: Exception -> L70
        int r119 = r115.uplinkStrategy.intValue();     // Catch: Exception -> L70
        r118.getClass();     // Catch: Exception -> L70
        if (r119 == 0) goto L57;
        if (r119 == 1) goto L56;
        if (r119 == 2) goto L55;
        if (r119 == 3) goto L57;
        UplinkStrategy r120 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L70
    L58:
        this.f509910a = r120;     // Catch: Exception -> L70
        Integer r121 = r115.statusCode;     // Catch: Exception -> L70
        if (r121 != null) goto L62;
    L64:
        int r122 = r115.statusCode.intValue();     // Catch: Exception -> L70
        String r123 = r115.statusMessage;     // Catch: Exception -> L70
        if (r123 == null) goto L67;
        r111 = r123;
    L67:
        r117.c(new UplinkException(r122, r111, null, r116), "ws", this.f509918i.c());     // Catch: Exception -> L70
    L68:
        e(r117);     // Catch: Exception -> L70
        return;
    L62:
        if (r121.intValue() != 0) goto L64;
        r117.e(r115, "ws", this.f509918i.c(), true);     // Catch: Exception -> L70
        goto L68
    L55:
        r120 = UplinkStrategy.ORIGIN;     // Catch: Exception -> L70
        goto L58
    L56:
        r120 = UplinkStrategy.WS_ORIGIN;     // Catch: Exception -> L70
    L57:
        r120 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L70
    L70:
        e = move-exception;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive uplink packet by ws error");
        JSONObject r124 = new JSONObject();
        JSONObject r125 = new JSONObject();
        String r126 = e.getMessage();
        if (r126 != null) goto L75;
        r126 = "Unknown exception";
    L75:
        JSONObject r127 = new JSONObject();
        r127.put("error", r126);
        r127.put("log_id", r113.f546766g);
        this.f509920k.e("uplink_receive_ws_packet_error", r124, r125, r127);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive ws uplink packet error: ".concat(r126));
        return;
    L77:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
    L79:
        if (r100 != f509906n) goto L119;
        Object r128 = r110.obj;
        if (r128 == null) goto L117;
        lmc.d r129 = this.f509915f.a(((lmc.d) r128).f509945k);
        if (r129 != null) goto L173;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive uplink packet by uplink http but no request item found");
        return;
    L173:
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r130 = r129.f509936b;     // Catch: Exception -> L113
        if (r130 != null) goto L88;
    L115:
        e(r129);
        return;
    L88:
        if ((r130 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L109;
        com.ss.ugc.live.sdk.msg.network.g r131 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r130).f458479b;     // Catch: Exception -> L113
        SdkUplinkPacket r132 = SdkUplinkPacket.ADAPTER.decode(r131.f458314d);     // Catch: Exception -> L113
        String r133 = com.ss.ugc.live.sdk.msg.utils.h.b(r132);     // Catch: Exception -> L113
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive uplink packet by uplink http, logId: ".concat(r133));     // Catch: Exception -> L113
        UplinkStrategy.a r134 = UplinkStrategy.Companion;     // Catch: Exception -> L113
        int r135 = r132.uplinkStrategy.intValue();     // Catch: Exception -> L113
        r134.getClass();     // Catch: Exception -> L113
        if (r135 == 0) goto L97;
        if (r135 == 1) goto L96;
        if (r135 == 2) goto L95;
        if (r135 == 3) goto L97;
        UplinkStrategy r136 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L113
    L98:
        this.f509910a = r136;     // Catch: Exception -> L113
        Integer r137 = r132.statusCode;     // Catch: Exception -> L113
        if (r137 != null) goto L102;
    L104:
        int r138 = r132.statusCode.intValue();     // Catch: Exception -> L113
        String r139 = r132.statusMessage;     // Catch: Exception -> L113
        if (r139 == null) goto L107;
        r111 = r139;
    L107:
        r129.c(new UplinkException(r138, r111, null, r133), UplinkStrategy.UPLINK_HTTP, this.f509918i.c());     // Catch: Exception -> L113
        goto L115
    L102:
        if (r137.intValue() != 0) goto L104;
        r129.e(r132, UplinkStrategy.UPLINK_HTTP, this.f509918i.c(), false);     // Catch: Exception -> L113
        goto L115
    L95:
        r136 = UplinkStrategy.ORIGIN;     // Catch: Exception -> L113
        goto L98
    L96:
        r136 = UplinkStrategy.WS_ORIGIN;     // Catch: Exception -> L113
    L97:
        r136 = UplinkStrategy.WS_MSG_ORIGIN;     // Catch: Exception -> L113
        goto L98
    L109:
        if ((r130 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L112;
        Exception r140 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r130).f458478b;     // Catch: Exception -> L113
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive uplink packet by uplink http error");     // Catch: Exception -> L113
        r129.c(r140, UplinkStrategy.UPLINK_HTTP, this.f509918i.c());     // Catch: Exception -> L113
        goto L115
    L112:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L113
    L113:
        e = move-exception;
        r129.c(e, UplinkStrategy.UPLINK_HTTP, this.f509918i.c());
        goto L115
    L117:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.uplink.UplinkRequestItem");
    L119:
        if (r100 != f509907o) goto L141;
        Object r141 = r110.obj;
        if (r141 == null) goto L139;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "receive uplink packet by origin http");
        lmc.d r142 = this.f509915f.a(((lmc.d) r141).f509945k);
        if (r142 != null) goto L166;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "no request item found");
        return;
    L166:
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r143 = r142.f509937c;     // Catch: Exception -> L135
        if (r143 != null) goto L128;
    L137:
        e(r142);
        return;
    L128:
        if ((r143 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L131;
        r142.d((com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r143).f458479b, this.f509918i.c());     // Catch: Exception -> L135
        goto L137
    L131:
        if ((r143 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L134;
        r142.c((Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r143).f458478b, UplinkStrategy.ORIGIN_HTTP, this.f509918i.c());     // Catch: Exception -> L135
        goto L137
    L134:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L135
    L135:
        e = move-exception;
        r142.c(e, UplinkStrategy.ORIGIN_HTTP, this.f509918i.c());
        goto L137
    L139:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.uplink.UplinkRequestItem");
    L141:
        if (r100 != f509908p) goto L151;
        Iterator<Map.Entry<Long, lmc.d>> r144 = this.f509915f.f509950a.entrySet().iterator();     // Catch: Throwable -> L163
    L144:
        if (r144.hasNext() == false) goto L146;
        Map.Entry<Long, lmc.d> r145 = r144.next();     // Catch: Throwable -> L163
        r145.getValue().c(new UplinkException(-4, "released", null, null, 12, null), this.f509910a.getStrategy(this.f509918i.c()), this.f509918i.c());     // Catch: Throwable -> L163
        e(r145.getValue());     // Catch: Throwable -> L163
        goto L144
    L146:
        this.f509915f.f509950a.clear();     // Catch: Throwable -> L163
        lmc.c r146 = this.f509911b;     // Catch: Throwable -> L163
        if (r146 == null) goto L192;
        r146.quit();     // Catch: Throwable -> L163
        return;
    L192:
        return;
    L199:
        return;
    L151:
        if (r100 != f509909q) goto L193;
        LinkedHashMap<Long, lmc.d> r147 = this.f509915f.f509950a;
        LinkedHashMap r148 = new LinkedHashMap();
        Iterator<Map.Entry<Long, lmc.d>> r149 = r147.entrySet().iterator();
    L154:
        if (r149.hasNext() == false) goto L158;
        Map.Entry<Long, lmc.d> r150 = r149.next();
        if (r150.getValue().f509944j == false) goto L154;
        r148.put(r150.getKey(), r150.getValue());
        goto L154
    L158:
        Iterator r151 = r148.entrySet().iterator();
    L160:
        if (r151.hasNext() == false) goto L200;
        Map.Entry r152 = (Map.Entry) r151.next();
        ((lmc.d) r152.getValue()).c(new UplinkException(-5, "ws disconnect", null, null, 12, null), "ws", this.f509918i.c());
        e((lmc.d) r152.getValue());
        goto L160
    L200:
        return;
    L193:
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.network.m
    public final void i(tlc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        i r101 = this.f509913d;
        if (r101 == null) goto L8;
        Message r102 = r101.obtainMessage(f509905m, r100);
        if (r102 == null) goto L9;
        r102.sendToTarget();
        return;
    L9:
        return;
    }

    public final void j(lmc.d r110) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "send uplink packet by ws, serviceId: " + r110.f509946l + ", uniqueId: " + r110.f509945k);
        SdkUplinkPacket r100 = r110.b();
        b r101 = new b(this, r110.f509945k);
        r110.f509943i = r101;
        r110.f509944j = true;
        byte[] r102 = r100.encode();
        ArrayList r103 = new ArrayList();
        if (this.f509918i.g() == false) goto L9;
        r103.add(new com.ss.ugc.live.sdk.msg.network.d("compress_type", DownloadHelper.GZIP));
        ByteArrayInputStream r104 = new ByteArrayInputStream(r102);
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();
        GZIPOutputStream r106 = new GZIPOutputStream(r105);
        byte[] r107 = new byte[4096];
    L5:
        int r108 = r104.read(r107, 0, 4096);
        if (r108 == (-1)) goto L8;
        r106.write(r107, 0, r108);
        goto L5
    L8:
        r106.finish();
        r106.flush();
        r106.close();
        byte[] r109 = r105.toByteArray();
        r105.flush();
        r105.close();
        r104.close();
        byte[] r111 = r109;
    L10:
        r103.add(new com.ss.ugc.live.sdk.msg.network.d("im_uplink_service_id", String.valueOf(r110.f509946l)));
        if (r110.f509935a == false) goto L13;
        r103.add(new com.ss.ugc.live.sdk.msg.network.d("BYTELINK-DISABLE-RESPONSE", "true"));
    L13:
        this.f509918i.e(new tlc.f(PayloadItemType.PAYLOAD_TYPE_UPLINK.getType(), "pb", r111, r103, r100.uniqueID.longValue(), r100.uniqueID.longValue()));
        if (r110.f509935a == false) goto L16;
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f509921l, "disable bytelink response，direct success");
        boolean r112 = this.f509918i.c();
        Intrinsics.checkNotNullParameter("ws", "uplinkStrategy");
        lmc.f r113 = r110.f509942h;
        r113.getClass();
        Intrinsics.checkNotNullParameter("ws", "uplinkStrategy");
        r113.f509956f = System.currentTimeMillis();
        r113.f509952b = "ws";
        r113.f509954d = r112;
        r113.f509957g = true;
        r113.f509958h = 0;
        r113.f509959i = "disable_response";
        e(r110);
        return;
    L16:
        com.ss.ugc.live.sdk.msg.utils.a.a(this.f509921l, "post ws timeout task, timeout: " + r110.f509947m);
        i r114 = this.f509912c;
        if (r114 == null) goto L22;
        r114.postDelayed(r101, r110.f509947m);
        return;
    L22:
        return;
    L9:
        r111 = r102;
        goto L10
    }

    public final void f(long r110, com.ss.ugc.live.sdk.msg.network.f r111, com.ss.ugc.live.sdk.msg.network.e r112) {
        Intrinsics.checkNotNullParameter(r111, "request");
        Intrinsics.checkNotNullParameter(r112, "callback");
        long r100 = this.f509916g.f509924a.incrementAndGet();
        long r101 = r111.f458306i;
        if (r101 > 0) goto L6;
        r101 = this.f509917h.a();
    L6:
        lmc.d r102 = new lmc.d(r100, r110, r101, r111, r112);
        i r113 = this.f509912c;
        if (r113 == null) goto L12;
        Message r114 = r113.obtainMessage(12345, r102);
        if (r114 == null) goto L13;
        r114.sendToTarget();
        return;
    L13:
        return;
    }

    public final void c(long r100, String r101, boolean r102, Exception r103) {
        JSONObject r104 = new JSONObject();
        r104.put("service_id", r100);
        r104.put("send_uplink_strategy", r101);
        r104.put("ws_connected", r102);
        JSONObject r105 = new JSONObject();
        String r106 = r103.getMessage();
        if (r106 != null) goto L6;
        r106 = "Unknown exception";
    L6:
        JSONObject r107 = new JSONObject();
        r107.put("error", r106);
        this.f509920k.e("uplink_send_error", r104, r105, r107);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f509921l, "uplink send error, use strategy: " + r101 + ", ws connect: " + r102 + ", error: " + r106);
    }

    public a(amc.i r100, h r101, com.ss.ugc.live.sdk.msg.network.i r102, vlc.g r103, vlc.c r104) {
        Intrinsics.checkNotNullParameter(r100, "uplinkConfig");
        Intrinsics.checkNotNullParameter(r101, "wsState");
        Intrinsics.checkNotNullParameter(r102, "httpClient");
        Intrinsics.checkNotNullParameter(r103, "monitor");
        Intrinsics.checkNotNullParameter(r104, "logger");
        this.f509917h = r100;
        this.f509918i = r101;
        this.f509919j = r102;
        this.f509920k = r103;
        this.f509921l = r104;
        if (r100.b() == false) goto L8;
        if (r100.d() == false) goto L8;
        UplinkStrategy r105 = UplinkStrategy.WS_MSG_ORIGIN;
    L11:
        this.f509910a = r105;
        this.f509915f = new lmc.e();
        this.f509916g = new c();
        return;
    L8:
        if (r100.b() == false) goto L10;
        r105 = UplinkStrategy.WS_ORIGIN;
        goto L11
    L10:
        r105 = UplinkStrategy.ORIGIN;
        goto L11
    }
}
