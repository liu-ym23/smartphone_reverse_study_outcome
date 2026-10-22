package com.bytedance.ies.bullet.service.prefetch;

import bolts.Task;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.tools.prefetch.l;
import com.bytedance.ies.tools.prefetch.m;
import com.bytedance.ies.tools.prefetch.w;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.lynx.tasm.LynxError;
import h16.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(biz = "bullet", name = "__prefetch")
public class b extends com.bytedance.ies.bullet.core.kit.bridge.c implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f248033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBridgeMethod.Access f248034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f248035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f248036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<m> f248037g;

    public static final class a extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeMethod.a f248038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f248039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f248040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f248041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f248042e;

        @Override // com.bytedance.ies.tools.prefetch.m.a, com.bytedance.ies.tools.prefetch.m
        public final void a(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "result");
            JSONObject r100 = new JSONObject();
            r100.put("code", 1);
            r100.put("data", r110);
            this.f248038a.onComplete(r100);
            this.f248039b.f248037g.remove(this);
            long r101 = System.currentTimeMillis() - this.f248040c;
            ExecutorService r102 = BulletLogger.f247763a;
            a36.a r103 = null;
            BulletLogger.k("__prefetch success cost " + r101 + " ms", null, "XPrefetch", 2);
            b r104 = this.f248039b;
            d r105 = this.f248041d;
            JSONObject r106 = this.f248042e;
            r104.getClass();
            if (r105 == null) goto L13;
            r r107 = (r) r105.F0(r.class);
            if (r107 == null) goto L14;
            c1 r111 = new c1("bdx_monitor_prefetch_data", null, null, null, null, 254);
            e r108 = (e) r104.f248033c.c(e.class);
            if (r108 == null) goto L11;
            BulletContext r109 = r108.getBulletContext();
            if (r109 == null) goto L11;
            r103 = r109.f246449q;
        L11:
            r111.f247801k = r103;
            JSONObject r112 = new JSONObject();
            r112.put("prefetch_api", r106.optString("url"));
            r112.put("prefetch_state", "success");
            r112.put("prefetch_from", "bridge");
            r112.put("prefetch_cached", r110.optInt("cached"));
            r112.put("prefetch_type", "v1");
            r111.f247794d = r112;
            JSONObject r113 = new JSONObject();
            r113.put("duration", r101);
            r111.f247795e = r113;
            r107.S(r111);
            return;
        L14:
            return;
        }

        @Override // com.bytedance.ies.tools.prefetch.m.a, com.bytedance.ies.tools.prefetch.m
        public final void onFailed(Throwable r110) {
            Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
            JSONObject r100 = new JSONObject();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
            if ((r110 instanceof HttpResponseException) == false) goto L8;
            r100.put("status", ((HttpResponseException) r110).getStatusCode());     // Catch: Throwable -> L16
        L11:
            if ((r110 instanceof NetworkNotAvailabeException) == false) goto L13;
            int r102 = -106;
        L14:
            Result.m9449constructorimpl(r100.put("error_code", r102));     // Catch: Throwable -> L16
        L18:
            IBridgeMethod.a r103 = this.f248038a;
            String r104 = r110.getMessage();
            if (r104 != null) goto L21;
            r104 = "";
        L21:
            r103.onError(r104, r100);
            this.f248039b.f248037g.remove(this);
            long r105 = System.currentTimeMillis() - this.f248040c;
            ExecutorService r106 = BulletLogger.f247763a;
            a36.a r107 = null;
            BulletLogger.k("__prefetch failed cost " + r105 + " ms", null, "XPrefetch", 2);
            b r108 = this.f248039b;
            d r109 = this.f248041d;
            JSONObject r111 = this.f248042e;
            r108.getClass();
            if (r109 == null) goto L34;
            r r112 = (r) r109.F0(r.class);
            if (r112 == null) goto L35;
            c1 r113 = new c1("bdx_monitor_prefetch_data", null, null, null, null, 254);
            e r114 = (e) r108.f248033c.c(e.class);
            if (r114 == null) goto L30;
            BulletContext r115 = r114.getBulletContext();
            if (r115 == null) goto L30;
            r107 = r115.f246449q;
        L30:
            r113.f247801k = r107;
            JSONObject r116 = new JSONObject();
            r116.put("prefetch_api", r111.optString("url"));
            r116.put("prefetch_state", "fail");
            r116.put("prefetch_from", "bridge");
            r116.put("prefetch_error", r110.getMessage());
            r116.put("prefetch_type", "v1");
            r113.f247794d = r116;
            JSONObject r117 = new JSONObject();
            r117.put("duration", r105);
            r113.f247795e = r117;
            r112.S(r113);
            return;
        L35:
            return;
        L34:
            return;
        L13:
            r102 = 1001;
            goto L14
        L8:
            if ((r110 instanceof CronetIOException) == false) goto L11;
            r100.put("status", ((CronetIOException) r110).getStatusCode());     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L18
        }

        public a(IBridgeMethod.a r100, b r101, long r102, d r103, JSONObject r104) {
            this.f248038a = r100;
            this.f248039b = r101;
            this.f248040c = r102;
            this.f248041d = r103;
            this.f248042e = r104;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.service.prefetch.b$b, reason: collision with other inner class name */
    public static final class C3546b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f248043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f248044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f248045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f248046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f248047e;

        /* JADX INFO: renamed from: com.bytedance.ies.bullet.service.prefetch.b$b$a */
        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f248048a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l f248049b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f248050c;

            public a(b r100, l r101, JSONObject r102) {
                this.f248048a = r100;
                this.f248049b = r101;
                this.f248050c = r102;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                b r100 = this.f248048a;
                r100.f248037g.add(r100.f248036f);
                new w(this.f248049b, this.f248048a.f248036f).c(this.f248050c);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.m
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            if (this.f248045c == false) goto L5;
            Task.call(new a(this.f248044b, this.f248046d, this.f248047e), Task.BACKGROUND_EXECUTOR);
        L5:
            this.f248043a.a(r100);
            this.f248044b.f248037g.remove(this);
        }

        @Override // com.bytedance.ies.tools.prefetch.m
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f248043a.onFailed(r100);
            this.f248044b.f248037g.remove(this);
        }

        public C3546b(a r100, b r101, boolean r102, l r103, JSONObject r104) {
            this.f248043a = r100;
            this.f248044b = r101;
            this.f248045c = r102;
            this.f248046d = r103;
            this.f248047e = r104;
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f248051a;

        public c(b r100) {
            this.f248051a = r100;
        }

        @Override // com.bytedance.ies.tools.prefetch.m
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            BulletLogger.k("request success", null, "XPrefetch", 2);
            this.f248051a.f248037g.remove(this);
        }

        @Override // com.bytedance.ies.tools.prefetch.m
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            ExecutorService r101 = BulletLogger.f247763a;
            BulletLogger.k("request failed message = " + r100.getMessage(), null, "XPrefetch", 2);
            this.f248051a.f248037g.remove(this);
        }
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final boolean i90() {
        return false;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        this.f248037g.clear();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f248034d;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f248035e;
    }

    public b(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f248033c = r100;
        this.f248034d = IBridgeMethod.Access.PRIVATE;
        this.f248035e = "__prefetch";
        this.f248036f = new c(this);
        this.f248037g = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r110, IBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        long r100 = System.currentTimeMillis();
        Object r112 = null;
        BulletLogger.k("__prefetch start", null, "XPrefetch", 2);
        d r101 = (d) this.f248033c.c(d.class);
        Object r102 = this.f248033c.c(l.class);
        Intrinsics.checkNotNull(r102);
        l r113 = (l) r102;
        a r114 = new a(r111, this, r100, r101, r110);
        this.f248037g.add(r114);
        boolean r103 = r110.optBoolean("ignore_cache", false);
        boolean r104 = r110.optBoolean("doRequestEvenInCache", false);
        Map<String, l> r105 = com.bytedance.ies.bullet.service.prefetch.c.f248052a;
        Intrinsics.checkNotNullParameter(r110, "params");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        if (r110.optString("business").equals("lucky_page") == false) goto L7;
        l r107 = (l) ((LinkedHashMap) com.bytedance.ies.bullet.service.prefetch.c.f248052a).get("lucky_page");     // Catch: Throwable -> L12
    L39:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L15:
        ExecutorService r108 = BulletLogger.f247763a;
        BulletLogger.k("Get Processor: " + r107 + " For Params: " + r110, null, "XPreRender", 2);
        if (r107 != null) goto L18;
        l r109 = r113;
    L19:
        com.bytedance.sdk.xbridge.cn.auth.h r115 = (com.bytedance.sdk.xbridge.cn.auth.h) this.f246545a.c(com.bytedance.sdk.xbridge.cn.auth.h.class);
        if (r115 == null) goto L35;
        Set<String> r116 = SecurityContextUtils.f269807a;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        String r117 = SecurityContextUtils.c(r115);
        JSONObject r118 = r110.optJSONObject("headers");
        if (r118 != null) goto L25;
        r118 = new JSONObject();
        r110.put("headers", r118);
    L25:
        Iterator r119 = SequencesKt.asSequence(r118.keys()).iterator();
    L27:
        if (r119.hasNext() == false) goto L31;
        Object r120 = r119.next();
        if (StringsKt.equals((String) r120, "x-security-argus", true) == false) goto L27;
        r112 = r120;
    L31:
        String r121 = (String) r112;
        if (r121 == null) goto L34;
        r118.remove(r121);
    L34:
        r118.put("x-security-argus", r117);
    L35:
        if (r103 == false) goto L37;
        new w(r109, r114).c(r110);
        return;
    L37:
        C3546b r122 = new C3546b(r114, this, r104, r113, r110);
        this.f248037g.add(r122);
        new w(r109, r122).b(r110);
        return;
    L18:
        r109 = r107;
    L10:
        th = th;
    L14:
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L7:
        r107 = null;
    L12:
        th = th;
        r107 = null;
        goto L14
    }
}
