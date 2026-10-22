package com.bytedance.ies.bullet.service.preload;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.bullet.service.base.y;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.preload", owner = "liushaocong")
public final class WebPreloadBridge extends com.bytedance.ies.bullet.core.kit.bridge.c implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f248079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f248080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<MessageQueue.IdleHandler> f248081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f248082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f248083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f248084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f248085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBridgeMethod.Access f248086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f248087k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WebPreloadBridge$Strategy;", "", "OnlyPreCreate", "PreConnect", "LoadUriOnIdle", "LoadUriRightNow", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Strategy extends Enum<Strategy> {
        public static final Strategy LoadUriOnIdle = null;
        public static final Strategy LoadUriRightNow = null;
        public static final Strategy OnlyPreCreate = null;
        public static final Strategy PreConnect = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Strategy[] f248088a = null;

        public static Strategy valueOf(String r100) {
            return (Strategy) r27.a.a(Strategy.class, r100);
        }

        public static Strategy[] values() {
            return (Strategy[]) f248088a.clone();
        }

        static {
            Strategy r100 = new Strategy("OnlyPreCreate", 0);
            OnlyPreCreate = r100;
            Strategy r101 = new Strategy("PreConnect", 1);
            PreConnect = r101;
            Strategy r102 = new Strategy("LoadUriOnIdle", 2);
            LoadUriOnIdle = r102;
            Strategy r103 = new Strategy("LoadUriRightNow", 3);
            LoadUriRightNow = r103;
            f248088a = new Strategy[]{r100, r101, r102, r103};
        }

        public Strategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f248089a = null;

        static {
            int[] r100 = new int[Strategy.values().length];
            r100[Strategy.OnlyPreCreate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Strategy.PreConnect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Strategy.LoadUriOnIdle.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Strategy.LoadUriRightNow.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f248089a = r100;
        }
    }

    public static final class c implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebPreloadBridge f248090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeMethod.a f248091b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f248092a = null;

            static {
                int[] r100 = new int[PoolResult.values().length];
                r100[PoolResult.FAIL_EXISTS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[PoolResult.FAIL_LOAD_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[PoolResult.FAIL_INVALID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[PoolResult.FAIL_EXCEPTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f248092a = r100;
            }
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            BulletLogger.k("PreRender Success", null, "XPreload", 2);
            JSONObject r101 = this.f248090a.f(true, 1, "Preload Success");
            IBridgeMethod.a r102 = this.f248091b;
            if (r102 == null) goto L6;
            r102.onComplete(r101);
            return;
        }

        public c(WebPreloadBridge r100, IBridgeMethod.a r101) {
            this.f248090a = r100;
            this.f248091b = r101;
        }

        @Override // com.bytedance.ies.bullet.service.base.y
        public final void a(PoolResult r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            int r102 = a.f248092a[r100.ordinal()];
            if (r102 == 1) goto L13;
            if (r102 != 2) goto L6;
            String r103 = "FAIL_LOAD_ERROR";
        L14:
            ExecutorService r104 = BulletLogger.f247763a;
            BulletLogger.k("PreRender Failed " + r103 + ", " + r101, null, "XPreload", 2);
            IBridgeMethod.a r105 = this.f248091b;
            if (r105 == null) goto L21;
            StringBuilder r106 = new StringBuilder("PoolResult:");
            r106.append(r103);
            r106.append(',');
            if (r101 != null) goto L19;
            r101 = "Preload Fail";
        L19:
            r106.append(r101);
            r105.onError(-1, r106.toString());
            return;
        L21:
            return;
        L6:
            if (r102 != 3) goto L8;
            r103 = "FAIL_INVALID";
            goto L14
        L8:
            if (r102 == 4) goto L10;
            r103 = "NULL";
            goto L14
        L10:
            r103 = "FAIL_EXCEPTION";
            goto L14
        L13:
            r103 = "FAIL_EXISTS";
            goto L14
        }
    }

    static {
    }

    private final BulletContext getContext() {
        h16.e r100 = (h16.e) this.f248079c.c(h16.e.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBulletContext();
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        if ((!((ArrayList) this.f248081e).isEmpty()) == false) goto L10;
        Iterator r100 = ((ArrayList) this.f248081e).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        MessageQueue.IdleHandler r101 = (MessageQueue.IdleHandler) r100.next();
        BulletLogger.k("===remove pendingPrerenderTask====", null, "XPreload", 2);
        Looper.myQueue().removeIdleHandler(r101);
        goto L6
    L8:
        ((ArrayList) this.f248081e).clear();
    L10:
        if ((!this.f248084h.isEmpty()) == true) goto L12;
        return;
    L12:
        if (((Boolean) this.f248085i.getValue()).booleanValue() == false) goto L20;
        BulletLogger.k("===remove cacheKeys and cache====", null, "XPreload", 2);
        a0 r102 = (a0) this.f248083g.getValue();
        if (r102 == null) goto L16;
        r102.c(CollectionsKt.toHashSet(this.f248084h));
    L16:
        this.f248084h.clear();
        return;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final IBridgeMethod.Access getAccess() {
        return this.f248086j;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return this.f248087k;
    }

    public WebPreloadBridge(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        super(r100);
        this.f248079c = r100;
        this.f248080d = 10;
        this.f248081e = new ArrayList();
        BulletContext r101 = getContext();
        if (r101 == null) goto L6;
        String r102 = r101.f246438f;
        if (r102 == null) goto L6;
    L7:
        this.f248082f = r102;
        this.f248083g = LazyKt.lazy(new WebPreloadBridge$preRenderService$2(this));
        this.f248084h = new ConcurrentLinkedQueue();
        this.f248085i = LazyKt.lazy(WebPreloadBridge$isJSBReleaseCacheEnable$2.INSTANCE);
        this.f248086j = IBridgeMethod.Access.PRIVATE;
        this.f248087k = "bullet.preload";
        return;
    L6:
        r102 = "default_bid";
        goto L7
    }

    public static final /* synthetic */ BulletContext b(WebPreloadBridge r100) {
        return r100.getContext();
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r110, IBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r100 = r110.optString("schema");
        String r101 = r110.optString(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        Strategy r103 = Strategy.OnlyPreCreate;
    L31:
        int r112 = r110.optInt("availableMemoryThreshold");
        m16.b r104 = this.f246545a;
        if (r104 == null) goto L34;
        Context r105 = (Context) r104.c(Context.class);
    L35:
        if (r105 != null) goto L37;
        long r106 = -1;
    L39:
        if (r106 <= r112) goto L41;
        boolean r113 = true;
    L42:
        m16.b r107 = this.f246545a;
        if (r107 == null) goto L45;
        Context r108 = (Context) r107.c(Context.class);
    L46:
        if (r113 == false) goto L64;
        if (r108 == null) goto L64;
        Uri r109 = UriProtector.parse(r100);
        ExecutorService r114 = BulletLogger.f247763a;
        BulletLogger.k("Start Preload for schema " + r109, null, "XPreload", 2);
        String r115 = w36.a.a(r109, "view_cache_time");
        if (r115 == null) goto L51;
        long r116 = CastLongProtector.parseLong(r115);
    L52:
        long r117 = r116;
        int r118 = b.f248089a[r103.ordinal()];
        if (r118 == 1) goto L63;
        if (r118 != 2) goto L56;
        c(r108, r111);
        BulletLogger.k("Start PreConnect", null, "XPreload", 2);
        vq7.a.a(r109.toString());
        return;
    L56:
        if (r118 != 3) goto L58;
        f r119 = new f(this, r108, r109, r117, r111);
        ((ArrayList) this.f248081e).add(r119);
        Looper.myQueue().addIdleHandler(r119);
        return;
    L58:
        if (r118 != 4) goto L70;
        e(r108, r109, r117, r111);
        return;
    L70:
        return;
    L63:
        c(r108, r111);
        return;
    L51:
        r116 = this.f248080d;
    L64:
        r111.onComplete(f(false, -1, "memory is not allowed"));
        return;
    L45:
        r108 = null;
        goto L46
    L41:
        r113 = false;
        goto L42
    L37:
        ActivityManager.MemoryInfo r120 = new ActivityManager.MemoryInfo();
        Object r121 = r105.getSystemService("activity");
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) r121).getMemoryInfo(r120);
        r106 = r120.availMem / ((long) 1048576);
        goto L39
    L34:
        r105 = null;
        goto L35
    L12:
        switch(r101.hashCode()) {
            case -2001951915: goto L27;
            case -1607411300: goto L23;
            case -1085510111: goto L19;
            case 1503977306: goto L15;
            default: goto L30;
        };
    L30:
        r103 = Strategy.OnlyPreCreate;
        goto L31
    L15:
        if (r101.equals("PreconnectSocket") == false) goto L30;
        r103 = Strategy.PreConnect;
        goto L31
    L19:
        if (r101.equals("Default") == false) goto L30;
        r103 = Strategy.OnlyPreCreate;
        goto L31
    L23:
        if (r101.equals("PreloadOnIdle") == false) goto L30;
        r103 = Strategy.LoadUriOnIdle;
        goto L31
    L27:
        if (r101.equals("PreloadImmediately") == false) goto L30;
        r103 = Strategy.LoadUriRightNow;
        goto L31
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void c(Context r100, IBridgeMethod.a r101) {
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        b36.f r103 = (b36.f) x26.a.b(this.f248082f, b36.f.class);
        if (r103 != null) goto L5;
        BulletLogger.k("Preload fail, PreCreate service = null", null, "XPreload", 2);
        r101.onError(-1, "Preload Fail, PreCreate service = null");
        return;
    L5:
        BulletLogger.k("Start PreCreate", null, "XPreload", 2);
        r103.w0(r100);
        r101.onComplete(f(true, 1, "Preload Success"));
    }

    public final JSONObject f(boolean r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("code", r101);
        JSONObject r104 = new JSONObject();
        r104.put("message", r102);
        r104.put("result", r100);
        Unit r105 = Unit.INSTANCE;
        r103.put("data", r104);
        return r103;
    }

    public final void e(Context r100, Uri r101, long r110, IBridgeMethod.a r111) {
        if (((Boolean) this.f248085i.getValue()).booleanValue() == false) goto L7;
        String r102 = w36.a.a(r101, "view_cache_key");
        if (r102 == null) goto L7;
        this.f248084h.add(r102);
    L7:
        a0 r103 = (a0) this.f248083g.getValue();
        if (r103 == null) goto L11;
        r103.e(r101, r100, r110 * ((long) 1000), new c(this, r111));
    L11:
        if (((a0) this.f248083g.getValue()) != null) goto L15;
        if (r111 == null) goto L16;
        r111.onError(-1, "poolservice = null");
        return;
    L16:
        return;
    }
}
