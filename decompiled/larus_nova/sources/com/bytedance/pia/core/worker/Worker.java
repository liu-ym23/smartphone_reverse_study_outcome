package com.bytedance.pia.core.worker;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.services.IPiaWorkerService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.d;
import com.bytedance.pia.core.utils.h;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.worker.binding.BaseModule;
import com.bytedance.pia.core.worker.network.WorkerDelegate;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l47.c;
import m47.g;
import m47.o;
import n47.m;
import org.json.JSONObject;
import s47.l;
import s47.n;
import v47.e;
import v47.f;
import v47.i;
import v47.k;
import v47.p;

/* JADX INFO: loaded from: classes21.dex */
public final class Worker implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<String> f266404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<String> f266405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<JsonObject> f266406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<JsonObject> f266407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BaseModule f266408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f266409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f266410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Uri f266411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f266412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Uri f266413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i47.c f266414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f266415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JsWorker f266416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final JSModuleManager f266417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, ?> f266418p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f266419q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j47.a f266420r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o f266421s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b47.b f266422t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l47.a<JsonObject> f266423u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.pia.core.worker.a f266424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f266425w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Status f266426x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f266427y;

    public static final enum Status extends Enum<Status> {
        public static final Status Create = null;
        public static final Status Fetching = null;
        public static final Status Ready = null;
        public static final Status Terminate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f266428a = null;

        static {
            Status r100 = new Status("Create", 0);
            Create = r100;
            Status r101 = new Status("Fetching", 1);
            Fetching = r101;
            Status r102 = new Status("Ready", 2);
            Ready = r102;
            Status r103 = new Status("Terminate", 3);
            Terminate = r103;
            f266428a = new Status[]{r100, r101, r102, r103};
        }

        public static Status[] values() {
            return (Status[]) f266428a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b47.b f266429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f266430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f266431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f266432d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i47.c f266433e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final o f266434f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final g47.a f266435g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final l47.a<JsonObject> f266436h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f266437i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f266438j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Map<String, ?> f266439k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Map<String, String> f266440l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final j47.a f266441m;

        /* JADX INFO: renamed from: com.bytedance.pia.core.worker.Worker$a$a, reason: collision with other inner class name */
        public static class C3723a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f266442a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f266443b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b47.b f266444c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public i47.c f266445d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public l47.a<JsonObject> f266446e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f266447f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f266448g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f266449h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public Map<String, ?> f266450i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public Map<String, String> f266451j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public j47.a f266452k;

            public final a a() {
                if (Settings.e().y() == true) goto L6;
                return null;
            L6:
                if (TextUtils.isEmpty(this.f266443b) == false) goto L9;
                return null;
            L9:
                if (TextUtils.isEmpty(this.f266442a) == true) goto L11;
                Uri r100 = UriProtector.parse(this.f266442a);
            L12:
                Uri r101 = r100;
                if (this.f266443b.startsWith("javascript:") == true) goto L64;
                String r102 = this.f266443b;
                int r103 = j.f266400a;
                if (r102 == null) goto L17;
                Uri r104 = UriProtector.parse(r102);
            L18:
                if (r104 != null) goto L20;
            L19:
                Uri r105 = null;
            L57:
                if (r105 == null) goto L63;
                this.f266443b = r105.toString();
                Lazy<Settings> r106 = Settings.f266286f;
                if (Settings.f266288h == false) goto L64;
                if (Settings.e().n(r105) == true) goto L64;
                d.c("worker script invalid by domain list");
            L63:
                return null;
            L20:
                List<String> r107 = r104.getPathSegments();
                if ((!r107.isEmpty()) == true) goto L24;
                r107 = null;
            L24:
                if (r107 == null) goto L19;
                String r108 = r104.getScheme();
                if (r108 != null) goto L33;
                if (r101 == null) goto L30;
                r108 = r101.getScheme();
            L31:
                if (r108 != null) goto L33;
            L30:
                r108 = null;
            L33:
                String r109 = r104.getEncodedAuthority();
                if (r109 != null) goto L41;
                if (r101 == null) goto L37;
                r109 = r101.getEncodedAuthority();
            L38:
                if (r109 != null) goto L41;
            L37:
                r109 = null;
            L41:
                if (Intrinsics.areEqual(CollectionsKt.first(r107), ".") == false) goto L56;
                if (r101 == null) goto L44;
                List<String> r110 = r101.getPathSegments();
            L45:
                if (r110 != null) goto L47;
                r110 = CollectionsKt.emptyList();
            L47:
                if (r101 == null) goto L49;
                String r111 = r101.getPath();
            L50:
                if (r111 != null) goto L53;
                r111 = "";
            L53:
                if (StringsKt.endsWith$default(r111, '/', false, 2, null) == true) goto L55;
                r110 = CollectionsKt.dropLast(r110, 1);
            L55:
                r107 = CollectionsKt.plus(r110, CollectionsKt.drop(r107, 1));
                goto L56
            L49:
                r111 = null;
                goto L50
            L44:
                r110 = null;
            L56:
                String r112 = CollectionsKt.joinToString$default(r107, HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
                Uri.Builder r113 = new Uri.Builder();
                r113.scheme(r108);
                r113.encodedAuthority(r109);
                r113.encodedQuery(r104.getEncodedQuery());
                r113.path(r112);
                r105 = r113.build();
                goto L57
            L17:
                r104 = null;
            L64:
                b47.b r114 = this.f266444c;
                if (r114 != null) goto L67;
                return null;
            L67:
                i47.c r115 = this.f266445d;
                if (r115 != null) goto L70;
                r115 = r114.f17563l;
            L70:
                i47.c r116 = r115;
                o r117 = new o(PiaMethod.Scope.Worker, r114, r114.f17561j);
                b47.b r118 = this.f266444c;
                return new a(r118, this.f266449h, this.f266443b, r101, r116, r117, r118.f17564m, this.f266446e, this.f266447f, this.f266448g, this.f266450i, this.f266451j, this.f266452k);
            L73:
                return null;
            L11:
                r100 = this.f266444c.f17559h;
                goto L12
            }

            public C3723a() {
                this.f266442a = "";
                this.f266443b = "";
                this.f266444c = null;
                this.f266445d = null;
                this.f266446e = null;
                this.f266447f = false;
                this.f266448g = true;
                this.f266449h = "";
                this.f266450i = null;
                this.f266451j = null;
                this.f266452k = null;
            }
        }

        public a(b47.b r100, String r101, String r102, Uri r103, i47.c r104, o r105, g47.a r106, l47.a<JsonObject> r107, boolean r108, boolean r110, Map<String, ?> r111, Map<String, String> r112, j47.a r113) {
            this.f266429a = r100;
            this.f266430b = r101;
            this.f266431c = r102;
            this.f266432d = r103;
            this.f266433e = r104;
            this.f266434f = r105;
            this.f266435g = r106;
            this.f266436h = r107;
            this.f266437i = r108;
            this.f266438j = r110;
            this.f266439k = r111;
            this.f266440l = r112;
            this.f266441m = r113;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicBoolean f266453a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f266454b;

        static {
            f266453a = new AtomicBoolean();
            f266454b = false;
        }
    }

    @Override // l47.c
    public final void release() {
        h(null);
    }

    public final boolean b() {
        if (this.f266426x != Status.Terminate) goto L5;
    L7:
        return false;
    L5:
        if (this.f266416n.isRunning() == false) goto L7;
        return true;
    }

    public final void g() {
        com.bytedance.pia.core.worker.a r100 = this.f266424v;
        if (r100 != null) goto L5;
        this.f266422t.f17571t.a(TraceEvent.REQUEST_WORKER_START, System.currentTimeMillis());
    L6:
        String r101 = this.f266411i.toString();
        AtomicBoolean r102 = b.f266453a;
        if (this.f266426x == Status.Create) goto L9;
        return;
    L9:
        this.f266426x = Status.Fetching;
        com.bytedance.pia.core.tracing.d.a r103 = i(EventName.WorkerScriptRequestStart);
        r103.args.put("url", r101);
        com.bytedance.pia.core.tracing.d r104 = r103.f266354b;
        r104.getClass();
        boolean r105 = false;
        ThreadUtil.d(new com.bytedance.pia.core.tracing.c(r104, r103, false));
        this.f266427y = System.currentTimeMillis();
        com.bytedance.pia.core.worker.a r106 = this.f266424v;
        if (r106 == null) goto L22;
        Runnable r107 = new i(this);
        monitor-enter(r106);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (r106.f266459d == false) goto L16;
        r107.run();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r106);     // Catch: Throwable -> L19
        return;
    L16:
        r106.f266460e = r107;     // Catch: Throwable -> L19
        goto L17
    L22:
        String r108 = this.f266412j;
        if (r108 == null) goto L25;
        e(r108, Boolean.TRUE);
        return;
    L25:
        b47.b r109 = this.f266422t;
        s47.j r110 = r109.f17575x;
        if (r110 == null) goto L43;
        String r111 = r110.f540633b;
        if (r111 == null) goto L37;
        r109.f17573v.g("manifestV3", r111);
        r109.f17573v.g("manifestStatus", String.valueOf(r110.f540639h));
        int r112 = r110.f540639h;
        if (r112 != 1) goto L32;
    L33:
        Config r113 = r109.f17555d.a();
        r113.d().add("manifestWarmup");
        l r114 = ((n) r109).f("pia_props");
        if ((r114 instanceof PiaPropsPlugin) == false) goto L37;
        String r115 = r113.toString();
        ((PiaPropsPlugin) r114).f266256c.add("getPageConfig", new JsonPrimitive(r115));
        goto L37
    L32:
        if (r112 == 2) goto L33;
    L37:
        if (TextUtils.isEmpty(r110.f540632a) == false) goto L39;
    L41:
        if (r105 == false) goto L43;
        this.f266425w = r110.a(new v47.j(this), new k(this));
        return;
    L39:
        if (TextUtils.equals(r101, r110.f540632a) == false) goto L41;
        r105 = true;
    L43:
        this.f266425w = this.f266414l.b(LoadFrom.Auto, new v47.l(this), new v47.j(this), new k(this));
        return;
    L5:
        this.f266422t.f17571t.a(TraceEvent.REQUEST_WORKER_START, r100.f266464i);
        goto L6
    }

    public b47.b getContext() {
        return this.f266422t;
    }

    public Worker(final a r210) throws Throwable {
        this.f266404b = new com.bytedance.pia.core.utils.a();
        final com.bytedance.pia.core.utils.a<String> r100 = new com.bytedance.pia.core.utils.a();
        this.f266405c = r100;
        this.f266406d = new com.bytedance.pia.core.utils.a();
        this.f266407e = new com.bytedance.pia.core.utils.a();
        r210.f266429a.f17571t.a(TraceEvent.INITIALIZE_WORKER_START, System.currentTimeMillis());
        Lazy<Settings> r101 = Settings.f266286f;
        if (Settings.a.a().y() == true) goto L5;
        r210.f266429a.f17562k.a(ErrorType.WORKER, -1);
        throw new PiaMethod.SettingDisableError();
    L5:
        if (TextUtils.isEmpty(r210.f266430b) == false) goto L7;
        this.f266409g = "Worker";
    L8:
        String r102 = "[" + this.f266409g + "] ";
        this.f266410h = r102;
        b47.b r103 = r210.f266429a;
        this.f266422t = r103;
        i(EventName.WorkerEnvironmentInitializeStart).a();
    L59:
        th = move-exception;
        d.d(this.f266410h + " Worker create failed (Reason: " + th + ")", th);     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        i(EventName.WorkerEnvironmentInitializeEnd).a();
        r210.f266429a.f17571t.a(TraceEvent.INITIALIZE_WORKER_END, System.currentTimeMillis());
        throw th;
    L10:
        if (TextUtils.isEmpty(r210.f266431c) == false) goto L12;
        r210.f266429a.f17562k.b(ErrorType.WORKER, -2, "script url is empty.");     // Catch: Throwable -> L59
        throw new PiaMethod.Error(-10001);     // Catch: Throwable -> L59
    L12:
        if (r210.f266431c.startsWith("javascript:") == false) goto L14;
        String r104 = r210.f266431c.substring(11);     // Catch: Throwable -> L59
        this.f266411i = Uri.EMPTY;     // Catch: Throwable -> L59
    L15:
        JsWorker.EngineType r110 = JsWorker.EngineType.QUICKJS;     // Catch: Throwable -> L59
        AtomicBoolean r105 = b.f266453a;     // Catch: Throwable -> L59
        Uri r106 = this.f266411i;     // Catch: Throwable -> L59
        monitor-enter(com.bytedance.pia.core.worker.a.class);     // Catch: Throwable -> L59
    L67:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L18:
        if (com.bytedance.pia.core.worker.a.f266455k != null) goto L20;
    L24:
        monitor-exit(com.bytedance.pia.core.worker.a.class);     // Catch: Throwable -> L59
        com.bytedance.pia.core.worker.a r111 = null;
    L26:
        this.f266424v = r111;     // Catch: Throwable -> L59
        if (r111 == null) goto L29;
        r103.f17571t.b(TraceEvent.IS_WARMUP, 1);     // Catch: Throwable -> L59
        r103.f17571t.a(TraceEvent.WARMUP_START, r111.f266462g);     // Catch: Throwable -> L59
        d.i(r102 + "consume warmup worker.");     // Catch: Throwable -> L59
        this.f266416n = r111.f266457b;     // Catch: Throwable -> L59
        this.f266417o = r111.f266458c;     // Catch: Throwable -> L59
    L33:
        this.f266413k = r210.f266432d;     // Catch: Throwable -> L59
        this.f266414l = r210.f266433e;     // Catch: Throwable -> L59
        this.f266412j = r104;     // Catch: Throwable -> L59
        this.f266423u = r210.f266436h;     // Catch: Throwable -> L59
        this.f266418p = r210.f266439k;     // Catch: Throwable -> L59
        this.f266419q = r210.f266440l;     // Catch: Throwable -> L59
        this.f266420r = r210.f266441m;     // Catch: Throwable -> L59
        this.f266426x = Status.Create;     // Catch: Throwable -> L59
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L59
        r107.append(r103.f17565n);     // Catch: Throwable -> L59
        r107.append("PIANativeWorker ");     // Catch: Throwable -> L59
        if (r210.f266437i == false) goto L36;
        r107.append(" PIAWarmup");     // Catch: Throwable -> L59
    L36:
        if (r111 == null) goto L38;
        r107.append(" WarmupWorker");     // Catch: Throwable -> L59
    L38:
        String r112 = r107.toString();     // Catch: Throwable -> L59
        this.f266415m = r112;     // Catch: Throwable -> L59
        o r108 = r210.f266434f;     // Catch: Throwable -> L59
        this.f266421s = r108;     // Catch: Throwable -> L59
        r108.getClass();     // Catch: Throwable -> L59
        ThreadUtil.c(new g(r108, new m(this)));     // Catch: Throwable -> L59
        this.f266417o.b(BaseModule.NAME, BaseModule.class, this);     // Catch: Throwable -> L59
        BaseModule r109 = (BaseModule) this.f266417o.a(BaseModule.NAME).getModule();     // Catch: Throwable -> L59
        this.f266408f = r109;     // Catch: Throwable -> L59
        r109.setMessageHandle(new v47.o(this));     // Catch: Throwable -> L59
        r109.setBridgeMessageHandle(new p(this));     // Catch: Throwable -> L59
        if (r210.f266438j == false) goto L46;
        String r113 = Polyfill.a.f266403a;     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r113) == true) goto L43;
        this.f266416n.evaluateJavaScript(r113);     // Catch: Throwable -> L59
        goto L46
    L43:
        r210.f266429a.f17562k.a(ErrorType.WORKER, -4);     // Catch: Throwable -> L59
        throw new RuntimeException("Polyfill load failed!");     // Catch: Throwable -> L59
    L46:
        if (Settings.a.a().w() == false) goto L52;
        if (r210.f266435g == null) goto L50;
        this.f266416n.setWorkerDelegate(new WorkerDelegate(r102, r112, r210.f266435g, r210.f266433e, r210.f266440l, r210.f266441m));     // Catch: Throwable -> L59
        d.i(r102.concat("Initialize Fetch-API successfully"));     // Catch: Throwable -> L59
        goto L52
    L50:
        d.c(r102 + "Initialize Fetch-API failed (Reason: 'Retrofit is null')");     // Catch: Throwable -> L59
    L52:
        this.f266416n.setOnErrorCallback(new v47.d(this, r210));     // Catch: Throwable -> L59
        this.f266416n.setOnMessageCallback(new e(r100));     // Catch: Throwable -> L59
        StringBuilder r114 = new StringBuilder();     // Catch: Throwable -> L59
        r114.append(r102);     // Catch: Throwable -> L59
        r114.append("Worker create successfully (UserAgent: '");     // Catch: Throwable -> L59
        r114.append(r112);     // Catch: Throwable -> L59
        r114.append("', RuntimeType: ");     // Catch: Throwable -> L59
        r114.append(r110);     // Catch: Throwable -> L59
        r114.append(", URL: ");     // Catch: Throwable -> L59
        r114.append(this.f266411i);     // Catch: Throwable -> L59
        r114.append(", location: ");     // Catch: Throwable -> L59
        r114.append(r210.f266432d);     // Catch: Throwable -> L59
        r114.append(", Debuggable: ");     // Catch: Throwable -> L59
        if (r110 != JsWorker.EngineType.V8) goto L55;
        boolean r115 = true;
    L56:
        r114.append(r115);     // Catch: Throwable -> L59
        r114.append(")");     // Catch: Throwable -> L59
        d.j(r114.toString(), r103.f17557f);     // Catch: Throwable -> L59
        i(EventName.WorkerEnvironmentInitializeEnd).a();
        r210.f266429a.f17571t.a(TraceEvent.INITIALIZE_WORKER_END, System.currentTimeMillis());
        return;
    L55:
        r115 = false;
        goto L56
    L29:
        r103.f17571t.b(TraceEvent.IS_WARMUP, 0);     // Catch: Throwable -> L59
        JSModuleManager r116 = new JSModuleManager(b47.b.f17554y);     // Catch: Throwable -> L59
        this.f266417o = r116;     // Catch: Throwable -> L59
        this.f266416n = new JsWorker(r116, r110, null, false, "PIA");     // Catch: Throwable -> L61
    L87:
        new JSONObject().put("use_vmsdk_worker", Boolean.TRUE);     // Catch: Throwable -> L79
        VmSdkMonitor.a();     // Catch: Throwable -> L79
        throw null;     // Catch: Throwable -> L79
    L61:
        th = move-exception;
        new JSONObject().put("use_vmsdk_worker", Boolean.FALSE);     // Catch: Throwable -> L65
        VmSdkMonitor.a();     // Catch: Throwable -> L65
        throw null;     // Catch: Throwable -> L65
    L65:
        r210.f266429a.f17562k.b(ErrorType.WORKER, -3, Log.getStackTraceString(th));     // Catch: Throwable -> L59
        throw new IPiaWorkerService.NoJSRuntimeException(th);     // Catch: Throwable -> L59
    L20:
        if (com.bytedance.pia.core.worker.a.f266455k.f266456a.equals(r106) == false) goto L24;
        com.bytedance.pia.core.worker.a r117 = com.bytedance.pia.core.worker.a.f266455k;     // Catch: Throwable -> L67
        com.bytedance.pia.core.worker.a.f266455k = null;     // Catch: Throwable -> L67
        monitor-exit(com.bytedance.pia.core.worker.a.class);     // Catch: Throwable -> L59
        r111 = r117;
        goto L26
    L14:
        this.f266411i = Uri.parse(r210.f266431c);     // Catch: Throwable -> L59
        r104 = null;
        goto L15
    L7:
        this.f266409g = r210.f266430b;
        goto L8
    }

    public final void c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (b() == false) goto L9;
        this.f266416n.evaluateJavaScript(r100);
        return;
    }

    public final void d(final Throwable r100) {
        com.bytedance.pia.core.worker.a r101 = this.f266424v;
        if (r101 != null) goto L5;
        this.f266422t.f17571t.a(TraceEvent.REQUEST_WORKER_END, System.currentTimeMillis());
    L6:
        this.f266422t.f17562k.b(ErrorType.WORKER, -6, "url=" + this.f266411i + ", error=" + Log.getStackTraceString(r100));
        d.d(this.f266410h + "PIA worker fails to fetch script(URL:" + this.f266411i + ", Reason: " + r100 + ")", r100);
        this.f266426x = Status.Terminate;
        com.bytedance.pia.core.tracing.d.a r102 = i(EventName.WorkerScriptRequestEnd);
        r102.args.put("url", this.f266411i.toString());
        r102.args.put(ForwardDependency$ForwardLocation.FLAG, "failed");
        r102.args.put("mode", "online");
        r102.args.put("f", 0);
        r102.args.put("m", 0);
        r102.a();
        ThreadUtil.a().post(new f(this, r100));
        return;
    L5:
        this.f266422t.f17571t.a(TraceEvent.REQUEST_WORKER_END, r101.f266465j);
        goto L6
    }

    public final void f(final l47.a<String> r100) {
        this.f266404b.c(new v47.c(this, r100));
    }

    public final void h(JsonObject r100) {
        if (b() == true) goto L5;
        return;
    L5:
        l47.a<JsonObject> r101 = this.f266423u;
        if (r101 == null) goto L8;
        r101.accept(r100);
    L8:
        d.i(this.f266410h + "PIA worker was terminated (URL: " + this.f266413k + ")");
        c r102 = this.f266425w;
        if (r102 == null) goto L11;
        r102.release();
        this.f266425w = null;
    L11:
        this.f266426x = Status.Terminate;
        o r103 = this.f266421s;
        r103.getClass();
        ThreadUtil.c(new m47.f(r103));
        this.f266416n.terminate();
    }

    public final com.bytedance.pia.core.tracing.d.a i(EventName r100) {
        com.bytedance.pia.core.tracing.d.a r101 = this.f266422t.f17572u.a(r100);
        String r102 = this.f266422t.c(this);
        r101.args.put(ErrorType.WORKER, r102);
        return r101;
    }

    public static void a(Worker r100, i47.e r101) {
        r100.getClass();
        String r102 = h.a(r101);     // Catch: Throwable -> L9
        if (r101.a() != LoadFrom.Offline) goto L6;
        boolean r103 = true;
    L7:
        r100.e(r102, Boolean.valueOf(r103));     // Catch: Throwable -> L9
        return;
    L6:
        r103 = false;
    L9:
        th = move-exception;
        r100.d(th);
    }

    public final void e(final String r100, Boolean r101) {
        this.f266422t.f17573v.b("WJD", System.currentTimeMillis() - this.f266427y);
        com.bytedance.pia.core.worker.a r102 = this.f266424v;
        if (r102 != null) goto L5;
        this.f266422t.f17571t.a(TraceEvent.REQUEST_WORKER_END, System.currentTimeMillis());
    L6:
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f266410h);
        r103.append("PIA worker fetches script successfully(URL: ");
        r103.append(this.f266411i);
        r103.append(", Mode: ");
        if (r101.booleanValue() == false) goto L9;
        String r104 = "Offline";
    L10:
        r103.append(r104);
        r103.append(")");
        d.j(r103.toString(), this.f266422t.f17557f);
        com.bytedance.pia.core.tracing.d.a r105 = i(EventName.WorkerScriptRequestEnd);
        String r106 = this.f266411i.toString();
        r105.args.put("url", r106);
        r105.args.put(ForwardDependency$ForwardLocation.FLAG, "success");
        if (r101.booleanValue() == false) goto L13;
        String r107 = OperationName.OPERATION_OFFLINE_AVAILABLE;
    L14:
        r105.args.put("mode", r107);
        r105.args.put("f", 1);
        Integer r108 = Integer.valueOf(r101.booleanValue() ? 1 : 0);
        r105.args.put("m", r108);
        r105.a();
        ThreadUtil.c(new v47.g(this, r100));
        return;
    L13:
        r107 = "online";
        goto L14
    L9:
        r104 = "Network";
        goto L10
    L5:
        this.f266422t.f17571t.a(TraceEvent.REQUEST_WORKER_END, r102.f266465j);
        goto L6
    }
}
