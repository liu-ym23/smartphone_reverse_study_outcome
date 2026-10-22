package com.bytedance.dora.link.monitor;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.bytelink.syswrapper.ble.SessionAttribute;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.text.Typography;
import pk4.j;
import pk4.l;

/* JADX INFO: loaded from: classes3.dex */
public final class DoraBytelinkPairTraceMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f204392e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ExecutorService f204393f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f204394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, c> f204395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<Integer, a> f204396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f204397d;

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f204398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f204399b;

        public a(c r100, long r101) {
            this.f204398a = r100;
            this.f204399b = r101;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f204400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f204403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f204404e;

        public b(Map<String, Object> r100, int r101, int r102, long r103, long r104) {
            this.f204400a = r100;
            this.f204401b = r101;
            this.f204402c = r102;
            this.f204403d = r103;
            this.f204404e = r104;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class c {
        public long A;
        public long B;
        public long C;
        public long D;
        public boolean E;
        public boolean F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f204405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f204406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f204408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f204409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f204410f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f204411g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f204412h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f204413i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f204414j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f204415k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f204416l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f204417m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f204418n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f204419o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f204420p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f204421q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f204422r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f204423s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f204424t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final String f204425u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final List<String> f204426v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f204427w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public long f204428x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public long f204429y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public long f204430z;

        public final void a(int r100) {
            StringBuilder r101 = new StringBuilder();
            long r102 = System.currentTimeMillis();
            ExecutorService r103 = DoraBytelinkPairTraceMonitor.f204392e;
            r101.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(r102)));
            r101.append(" ");
            r101.append(DoraBytelinkPairTraceMonitor.e(r100));
            b(r101.toString(), true);
        }

        public final void b(String r100, boolean r101) {
            if (((ArrayList) this.f204426v).size() >= 9) goto L5;
            ((ArrayList) this.f204426v).add(r100);
            return;
        L5:
            if (r101 == false) goto L9;
            ListProtector.set(this.f204426v, 8, r100);
            return;
        }

        public c(DoraDevice r100, SessionAttribute r101, int r102, boolean r103, String r104) {
            long r105 = SystemClock.elapsedRealtime();
            this.f204405a = r105;
            this.f204426v = new ArrayList();
            int r106 = 0;
            this.f204427w = 0;
            this.f204428x = r105;
            this.f204429y = 0;
            this.f204430z = 0;
            this.A = 0;
            this.B = 0;
            this.C = 0;
            this.D = 0;
            this.E = false;
            this.F = false;
            String r107 = r100.f204389mac;
            ExecutorService r108 = DoraBytelinkPairTraceMonitor.f204392e;
            if (r107 == null) goto L5;
            String r109 = r107.replace(":", "");
        L6:
            this.f204406b = r109;
            this.f204407c = r102;
            this.f204408d = r103;
            this.f204425u = r104;
            this.f204422r = r100.vendorId;
            this.f204423s = r100.productId;
            this.f204424t = r100.type;
            SessionAttribute.SessionRole r110 = r101.getRole();
            if (r110 == null) goto L9;
            int r111 = r110.getValue();
        L10:
            this.f204409e = r111;
            SessionAttribute.ProtocolType r112 = r101.getProtocolType();
            if (r112 == null) goto L13;
            int r113 = r112.getValue();
        L14:
            this.f204410f = r113;
            SessionAttribute.SecMode r114 = r101.getSecMode();
            if (r114 == null) goto L17;
            int r115 = r114.getValue();
        L18:
            this.f204411g = r115;
            SessionAttribute.PairMode r116 = r101.getPairMode();
            if (r116 == null) goto L21;
            int r117 = r116.getValue();
        L22:
            this.f204412h = r117;
            SessionAttribute.LinkType r118 = r101.getLinkType();
            if (r118 == null) goto L25;
            int r119 = r118.getValue();
        L26:
            this.f204413i = r119;
            SessionAttribute.ChannelType r120 = r101.getChannelType();
            if (r120 == null) goto L29;
            r106 = r120.getValue();
        L29:
            this.f204414j = r106;
            this.f204415k = r101.getDid();
            this.f204416l = r101.getUid();
            this.f204417m = r100.modelVersion;
            this.f204418n = r100.hwVersion;
            this.f204419o = r100.softVersion;
            this.f204420p = r100.typeName;
            this.f204421q = r100.getSerialNumber();
            return;
        L25:
            r119 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r115 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r111 = 0;
            goto L10
        L5:
            r109 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f204431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f204433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f204434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f204435e;

        public d(c r100, int r101, int r102, long r103, long r104) {
            this.f204431a = r100;
            this.f204432b = r101;
            this.f204433c = r102;
            this.f204434d = r103;
            this.f204435e = r104;
        }
    }

    static {
        f204392e = PThreadExecutorsUtils.newSingleThreadExecutor(new com.bytedance.dora.link.monitor.c());
        f204393f = PThreadExecutorsUtils.newSingleThreadExecutor(new com.bytedance.dora.link.monitor.d());
    }

    public DoraBytelinkPairTraceMonitor() {
        this.f204394a = new Object();
        this.f204395b = new ConcurrentHashMap();
        final float r100 = 0.75f;
        final boolean r101 = true;
        final int r102 = 16;
        this.f204396c = new AnonymousClass1(this, r102, r100, r101);
    }

    public static String e(int r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 != (-10)) goto L5;
        String r102 = "REASON_CODE_SESSION_HANDLE_CONNECT_START";
    L34:
        r101.append(r102);
        r101.append("(code: ");
        r101.append(r100);
        r101.append(")");
        return r101.toString();
    L5:
        if (r100 != (-9)) goto L7;
        r102 = "REASON_CODE_SESSION_HANDLE_CONNECT_SUCCESS";
        goto L34
    L7:
        if (r100 == (-8)) goto L31;
        switch(r100) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            default: goto L9;
        };
    L9:
        r102 = "REASON_CODE_UNKNOWN";
        goto L34
    L10:
        r102 = "REASON_CODE_MAX";
        goto L34
    L11:
        r102 = "REASON_CODE_USER_REQUESTED";
        goto L34
    L12:
        r102 = "REASON_CODE_PEER_UNAVAILABLE";
        goto L34
    L13:
        r102 = "REASON_CODE_PROTOCOL_ERROR";
        goto L34
    L14:
        r102 = "REASON_CODE_NETWORK_ERROR";
        goto L34
    L15:
        r102 = "REASON_CODE_RESOURCE_LIMIT";
        goto L34
    L16:
        r102 = "REASON_CODE_SECURITY_CPBC";
        goto L34
    L17:
        r102 = "REASON_CODE_SECURITY_ERROR";
        goto L34
    L18:
        r102 = "REASON_CODE_PAIR_SKIP";
        goto L34
    L19:
        r102 = "REASON_CODE_PAIR_TIMEOUT";
        goto L34
    L20:
        r102 = "REASON_CODE_PAIR_ERROR";
        goto L34
    L21:
        r102 = "REASON_CODE_PAIR_OK";
        goto L34
    L22:
        r102 = "REASON_CODE_RECV_CTRL_FRAME";
        goto L34
    L23:
        r102 = "REASON_CODE_SEND_CTRL_FAILED";
        goto L34
    L24:
        r102 = "REASON_CODE_SEND_CTRL_OK";
        goto L34
    L25:
        r102 = "REASON_CODE_LOCAL_DISCONNECT";
        goto L34
    L26:
        r102 = "REASON_CODE_REMOTE_DISCONNECT";
        goto L34
    L27:
        r102 = "REASON_CODE_CONNECT_TIMEOUT";
        goto L34
    L28:
        r102 = "REASON_CODE_CONNECT_FAILED";
        goto L34
    L29:
        r102 = "REASON_CODE_CONNECT_OK";
        goto L34
    L30:
        r102 = "REASON_CODE_NONE";
        goto L34
    L31:
        r102 = "REASON_CODE_SESSION_HANDLE_CONNECT_FAILED";
        goto L34
    }

    public static void g(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        final String r101 = l.f529654v;
        final Map<String, Object> r102 = r100.f204400a;
        f204393f.execute(new e(r101, r102));
        j.d("DoraBytelinkPairTraceMonitor", "reportPairTerminal: sessionId=" + r100.f204401b + ", reason=" + e(r100.f204402c) + ", duration=" + r100.f204403d + ", pairDuration=" + r100.f204404e);
    }

    public final void f(d r110) {
        Object r100 = this.f204394a;
        monitor-enter(r100);
        c r101 = r110.f204431a;     // Catch: Throwable -> L72
        if (r101 != null) goto L7;
        j.f("DoraBytelinkPairTraceMonitor", "onTracePoint: missing record, sessionId=" + r110.f204432b + ", reasonCode=" + r110.f204433c);     // Catch: Throwable -> L72
    L56:
        b r102 = null;
    L68:
        this.f204394a.notifyAll();     // Catch: Throwable -> L72
        monitor-exit(r100);     // Catch: Throwable -> L72
        g(r102);
        return;
    L7:
        int r103 = r110.f204433c;     // Catch: Throwable -> L72
        if (r103 == 9) goto L14;
        if (r103 == 10) goto L14;
        if (r103 == 11) goto L14;
        if (r103 == 14) goto L14;
        boolean r111 = false;
    L16:
        if (r111 == true) goto L25;
        if (r103 == 4) goto L21;
        if (r103 == 5) goto L21;
        boolean r112 = false;
    L22:
        if (r112 == true) goto L25;
        boolean r113 = false;
    L26:
        r101.b(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date(r110.f204435e)) + " " + e(r103), r113);     // Catch: Throwable -> L72
        if (r110.f204433c == 1) goto L29;
    L31:
        int r104 = r110.f204433c;     // Catch: Throwable -> L72
        if (r104 != 11) goto L37;
        r102 = a(r101, r104, r110.f204434d);     // Catch: Throwable -> L72
        if (r101.F == false) goto L68;
        ((ConcurrentHashMap) this.f204395b).remove(Integer.valueOf(r110.f204432b), r101);     // Catch: Throwable -> L72
        goto L68
    L37:
        if (r104 != 9) goto L39;
    L45:
        boolean r105 = true;
    L46:
        if (r105 == false) goto L48;
    L57:
        r102 = a(r101, r104, r110.f204434d);     // Catch: Throwable -> L72
        int r106 = r110.f204433c;     // Catch: Throwable -> L72
        if (r106 != 4) goto L60;
    L63:
        boolean r107 = true;
    L64:
        if (r107 == false) goto L66;
    L67:
        ((ConcurrentHashMap) this.f204395b).remove(Integer.valueOf(r110.f204432b), r101);     // Catch: Throwable -> L72
        goto L68
    L66:
        if (r101.F == false) goto L68;
    L60:
        if (r106 == 5) goto L63;
        r107 = false;
        goto L64
    L48:
        if (r104 != 4) goto L50;
    L53:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L56;
    L50:
        if (r104 == 5) goto L53;
        r108 = false;
        goto L54
    L39:
        if (r104 == 10) goto L45;
        if (r104 == 11) goto L45;
        if (r104 == 14) goto L45;
        r105 = false;
        goto L46
    L29:
        if (r101.f204429y != 0) goto L31;
        long r114 = r110.f204434d;     // Catch: Throwable -> L72
        r101.f204429y = r114;     // Catch: Throwable -> L72
        r101.A = Math.max(0, r114 - r101.f204428x);     // Catch: Throwable -> L72
    L21:
        r112 = true;
    L25:
        r113 = true;
    L14:
        r111 = true;
    L72:
        th = move-exception;
        throw th;
    }

    public final void b(int r100, c r101) {
        Object r102 = this.f204394a;
        monitor-enter(r102);
        if (r101 != null) goto L21;
    L10:
        c r103 = this.f204397d;     // Catch: Throwable -> L18
        if (r103 != null) goto L13;
    L15:
        this.f204394a.notifyAll();     // Catch: Throwable -> L18
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L13:
        if (r103.f204427w != r100) goto L15;
        this.f204397d = null;     // Catch: Throwable -> L18
        goto L15
    L21:
        Map<Integer, c> r104 = this.f204395b;     // Catch: Throwable -> L18
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L18
        if (r105.get(Integer.valueOf(r100)) != r101) goto L10;
        r101.F = true;     // Catch: Throwable -> L18
        if (r101.E == false) goto L10;
        this.f204396c.put(Integer.valueOf(r100), new a(r101, r101.D));     // Catch: Throwable -> L18
        Map<Integer, c> r106 = this.f204395b;     // Catch: Throwable -> L18
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;     // Catch: Throwable -> L18
        r107.remove(Integer.valueOf(r100), r101);     // Catch: Throwable -> L18
        goto L10
    }

    public final void c(int r110, boolean r111) {
        Object r100 = this.f204394a;
        monitor-enter(r100);
        c r101 = this.f204397d;     // Catch: Throwable -> L35
        b r102 = null;
        this.f204397d = null;     // Catch: Throwable -> L35
        if (r101 != null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L35
        return;
    L8:
        long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L35
        r101.f204428x = r103;     // Catch: Throwable -> L35
        r101.f204430z = Math.max(0, r103 - r101.f204405a);     // Catch: Throwable -> L35
        boolean r104 = true;
        if (r110 <= 0) goto L12;
        if (r110 > 255) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        r101.f204427w = r110;     // Catch: Throwable -> L35
        r101.a(-9);     // Catch: Throwable -> L35
        this.f204396c.remove(Integer.valueOf(r110));     // Catch: Throwable -> L35
        ((ConcurrentHashMap) this.f204395b).put(Integer.valueOf(r110), r101);     // Catch: Throwable -> L35
    L18:
        this.f204394a.notifyAll();     // Catch: Throwable -> L35
        monitor-exit(r100);     // Catch: Throwable -> L35
        g(r102);
        if (r110 <= 0) goto L24;
        if (r110 > 255) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == true) goto L28;
        if (r111 == false) goto L28;
        j.f("DoraBytelinkPairTraceMonitor", "onSessionConnectResult: invalid sessionId=" + r110 + ", skip bytelink pair report because spp socket connect failed.");
        return;
    L28:
        if (r110 <= 0) goto L31;
        if (r110 > 255) goto L31;
    L32:
        if (r104 == true) goto L40;
        j.f("DoraBytelinkPairTraceMonitor", "onSessionConnectResult: invalid sessionId=" + r110 + ", report bytelink session connect failure.");
        return;
    L40:
        return;
    L31:
        r104 = false;
    L24:
        r106 = false;
        goto L25
    L15:
        r101.f204427w = r110;     // Catch: Throwable -> L35
        r101.a(-8);     // Catch: Throwable -> L35
        if (r111 == true) goto L18;
        r102 = a(r101, -8, SystemClock.elapsedRealtime());     // Catch: Throwable -> L35
    L12:
        r105 = false;
    L35:
        th = move-exception;
        throw th;
    }

    public final b a(c r110, int r111, long r112) {
        if (r110.E == false) goto L6;
        return null;
    L6:
        boolean r100 = true;
        r110.E = true;
        r110.C = Math.max(0, r112 - r110.f204405a);
        long r101 = r110.f204429y;
        if (r101 <= 0) goto L9;
        r110.B = Math.max(0, r112 - r101);
    L9:
        r110.D = r110.C;
        int r102 = r110.f204427w;
        int r103 = 0;
        if (r102 > 0) goto L12;
    L14:
        r100 = false;
    L15:
        if (r100 == false) goto L18;
        Map<Integer, c> r104 = this.f204395b;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        if (r105.get(Integer.valueOf(r102)) == r110) goto L18;
    L19:
        HashMap r106 = new HashMap();
        r106.put("session_id", Integer.valueOf(r110.f204427w));
        r106.put("role", Integer.valueOf(r110.f204409e));
        r106.put(SpeechEngineDefines.PARAMS_KEY_PROTOCOL_TYPE_INT, Integer.valueOf(r110.f204410f));
        r106.put("sec_mode", Integer.valueOf(r110.f204411g));
        r106.put("pair_mode", Integer.valueOf(r110.f204412h));
        r106.put("link_type", Integer.valueOf(r110.f204413i));
        r106.put(WsConstants.KEY_CHANNEL_TYPE, Integer.valueOf(r110.f204414j));
        r106.put(com.bytedance.android.ec.core.event.a.KEY_DID, r110.f204415k);
        r106.put("uid", r110.f204416l);
        r106.put("pair_mac", r110.f204406b);
        r106.put(MonitorConstants.CONNECT_TYPE, Integer.valueOf(r110.f204407c));
        r106.put("has_bond", Integer.valueOf(r110.f204408d ? 1 : 0));
        r106.put("alg_version", r110.f204417m);
        r106.put("hw_version", r110.f204418n);
        r106.put("soft_version", r110.f204419o);
        r106.put("product", r110.f204420p);
        r106.put("series_no", r110.f204421q);
        r106.put(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, Integer.valueOf(r110.f204422r));
        r106.put("product_id", Integer.valueOf(r110.f204423s));
        r106.put("device_type", Integer.valueOf(r110.f204424t));
        r106.put("rfcomm_mode", r110.f204425u);
        if (r111 != 9) goto L22;
        String r107 = "success";
    L23:
        r106.put("result", r107);
        r106.put("duration", Long.valueOf(r110.C));
        r106.put("t1", Long.valueOf(r110.f204430z));
        r106.put("t2", Long.valueOf(r110.A));
        r106.put("t3", Long.valueOf(r110.B));
        r106.put("pair_mac", r110.f204406b);
        StringBuilder r108 = new StringBuilder("[");
    L25:
        if (r103 >= ((ArrayList) r110.f204426v).size()) goto L29;
        if (r103 <= 0) goto L28;
        r108.append(',');
    L28:
        r108.append(Typography.quote);
        r108.append(((String) ListProtector.get(r110.f204426v, r103)).replace("\\", "\\\\").replace("\"", "\\\""));
        r108.append(Typography.quote);
        r103 = r103 + 1;
        goto L25
    L29:
        r108.append(']');
        r106.put("events", r108.toString());
        return new b(r106, r110.f204427w, r111, r110.C, r110.D);
    L22:
        r107 = e(r111);
    L18:
        this.f204396c.put(Integer.valueOf(r110.f204427w), new a(r110, r110.D));
        goto L19
    L12:
        if (r102 > 255) goto L14;
        goto L14
    }

    public final void d(DoraDevice r100, SessionAttribute r101, int r110, boolean r111, String r112) {
        c r102 = new c(r100, r101, r110, r111, r112);
        r102.a(-10);
        Object r103 = this.f204394a;
        monitor-enter(r103);
        this.f204397d = r102;     // Catch: Throwable -> L7
        this.f204394a.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
