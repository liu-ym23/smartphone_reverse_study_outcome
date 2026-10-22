package com.larus.im.network;

import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.GsonBuilder;
import com.larus.common.apphost.AppHost;
import com.larus.im.trace.FrontierStatusMonitor;
import com.larus.im.ws.FlowWsConnectionState;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import xf9.g;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f350585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Set<Function1<byte[], Unit>>> f350586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Function1<Integer, Unit>> f350587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<com.larus.im.f.a> f350588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<com.larus.im.f.b> f350589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<Function1<xf9.e, Unit>> f350590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Function1<xf9.a, Unit>> f350591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrontierStatusMonitor f350592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ed9.a f350593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public xf9.d f350594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f350595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.larus.im.trace.a f350596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f350597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f350598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f350599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CompletableDeferred<Unit> f350600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CoroutineScope f350601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f350602r;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350603a = null;

        static {
            int[] r100 = new int[FlowWsConnectionState.values().length];
            r100[FlowWsConnectionState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FlowWsConnectionState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FlowWsConnectionState.CONNECT_CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FlowWsConnectionState.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f350603a = r100;
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("IM/FrontierConnection", "connectScope err: " + r101);
        }
    }

    static {
    }

    public final synchronized int c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f350594j != null) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        int r100 = this.f350595k;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    }

    public final boolean d() {
        return ((Boolean) this.f350602r.getValue()).booleanValue();
    }

    public d(int r100) {
        this.f350585a = r100;
        this.f350586b = new ConcurrentHashMap();
        this.f350587c = new LinkedHashSet();
        this.f350588d = new LinkedHashSet();
        this.f350589e = new LinkedHashSet();
        this.f350590f = new LinkedHashSet();
        this.f350591g = new LinkedHashSet();
        this.f350592h = FrontierStatusMonitor.f350898a;
        this.f350593i = new ed9.a(0, "", "", "");
        new GsonBuilder().create();
        this.f350596l = new com.larus.im.trace.a();
        this.f350597m = new AtomicBoolean(false);
        this.f350598n = -1;
        this.f350601q = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new c(CoroutineExceptionHandler.Key)));
        this.f350602r = LazyKt.lazy(new com.larus.im.network.b());
    }

    @Override // xf9.g
    public final void a(xf9.a r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L11;
    L21:
        if (r101 == false) goto L23;
        return;
    L23:
        if (r100 == null) goto L37;
        byte[] r103 = r100.f563531d;
        String r104 = new String(r103, Charsets.UTF_8);
        FLogger r105 = FLogger.f375446a;
        r105.d("IM/FrontierConnection", "service: " + r100.f563529b + ", payload: " + g2a.d.c(r104));
        if (AccountService.f365697a.c(r100.f563529b, r100.f563530c, r104) == false) goto L27;
        r105.i("IM/FrontierConnection", "Account service handle frontier message, method = " + r100.f563530c);
        this.f350596l.a("ACCOUNT_SERVICE", e(this, r100));
    L33:
        Iterator<T> r106 = this.f350591g.iterator();
    L35:
        if (r106.hasNext() == false) goto L41;
        ((Function1) r106.next()).invoke(r100);
        goto L35
    L41:
        return;
    L27:
        Set<Function1<byte[], Unit>> r107 = this.f350586b.get(Integer.valueOf(r100.f563529b));
        if (r107 == null) goto L33;
        Iterator<T> r108 = r107.iterator();
    L31:
        if (r108.hasNext() == false) goto L33;
        ((Function1) r108.next()).invoke(r103);
        goto L31
    L37:
        return;
    L11:
        if (1 != r100.f563530c) goto L21;
        boolean r109 = AccountService.f365697a.a();
        if (AppHost.f326268a.isOversea() == false) goto L16;
        if (r109 == false) goto L16;
        FLogger.f375446a.d("IM/FrontierConnection", "Receive cloud message " + e(this, r100) + ", but in minor mode");
    L16:
        this.f350596l.a("tryCloudMessage", e(this, r100));
        byte[] r110 = r100.f563531d;
        HashMap r111 = new HashMap();
        Iterator<T> r112 = r100.f563534g.iterator();
    L18:
        if (r112.hasNext() == false) goto L20;
        xf9.b r113 = (xf9.b) r112.next();
        r111.put(r113.f563535a, r113.f563536b);
        goto L18
    L20:
        com.larus.platform.service.g.f365738a.f(r110, r111);
        r101 = true;
        goto L21
    L5:
        if (1004 != r100.f563529b) goto L7;
        r102 = true;
        goto L9
    }

    @Override // xf9.g
    public final synchronized void b(xf9.e r110) {
        monitor-enter(this);
        com.larus.im.trace.a r100 = this.f350596l;     // Catch: Throwable -> L73
        FlowWsConnectionState r101 = null;
        if (r110 == null) goto L7;
        FlowWsConnectionState r102 = r110.f563548b;     // Catch: Throwable -> L73
    L8:
        r100.a("onReceiveConnectEvent", String.valueOf(r102));     // Catch: Throwable -> L73
        if (this.f350594j == null) goto L25;
        if (r110 == null) goto L13;
        FlowWsConnectionState r103 = r110.f563548b;     // Catch: Throwable -> L73
    L14:
        if (r103 != null) goto L16;
        int r104 = -1;
    L17:
        if (r104 == 1) goto L27;
        if (r104 != 2) goto L20;
        int r105 = 1;
    L29:
        if (d() == true) goto L31;
    L59:
        FLogger r106 = FLogger.f375446a;     // Catch: Throwable -> L73
        StringBuilder r107 = new StringBuilder("WS #");     // Catch: Throwable -> L73
        if (r110 == null) goto L62;
        Integer r108 = Integer.valueOf(r110.f563547a);     // Catch: Throwable -> L73
    L63:
        r107.append(r108);     // Catch: Throwable -> L73
        r107.append(" state ");     // Catch: Throwable -> L73
        r107.append(this.f350595k);     // Catch: Throwable -> L73
        r107.append(" -> ");     // Catch: Throwable -> L73
        r107.append(r105);     // Catch: Throwable -> L73
        r107.append(" by ");     // Catch: Throwable -> L73
        if (r110 == null) goto L66;
        r101 = r110.f563548b;     // Catch: Throwable -> L73
    L66:
        r107.append(r101);     // Catch: Throwable -> L73
        r106.i("IM/FrontierConnection", r107.toString());     // Catch: Throwable -> L73
        g(r105);     // Catch: Throwable -> L73
        Iterator<T> r109 = this.f350590f.iterator();     // Catch: Throwable -> L73
    L67:
        if (r109.hasNext() == false) goto L71;
        ((Function1) r109.next()).invoke(r110);     // Catch: Throwable -> L73
        goto L67
    L71:
        monitor-exit(this);
        return;
    L62:
        r108 = null;
        goto L63
    L31:
        if (this.f350599o == false) goto L41;
        if (r110 == null) goto L34;
        FlowWsConnectionState r111 = r110.f563548b;     // Catch: Throwable -> L73
    L36:
        if (r111 != FlowWsConnectionState.CONNECT_CLOSED) goto L41;
        this.f350599o = false;     // Catch: Throwable -> L73
        CompletableDeferred<Unit> r112 = this.f350600p;     // Catch: Throwable -> L73
        if (r112 == null) goto L40;
        r112.complete(Unit.INSTANCE);     // Catch: Throwable -> L73
    L40:
        boolean r113 = true;
    L42:
        List r114 = CollectionsKt.listOf(new FlowWsConnectionState[]{FlowWsConnectionState.CONNECTED, FlowWsConnectionState.CONNECT_FAILED});     // Catch: Throwable -> L73
        if (r110 == null) goto L45;
        FlowWsConnectionState r115 = r110.f563548b;     // Catch: Throwable -> L73
    L47:
        if (CollectionsKt.contains(r114, r115) == true) goto L54;
        if (r113 == true) goto L59;
        if (r110 == null) goto L51;
        FlowWsConnectionState r116 = r110.f563548b;     // Catch: Throwable -> L73
    L53:
        if (r116 != FlowWsConnectionState.CONNECT_CLOSED) goto L59;
    L51:
        r116 = null;
    L54:
        this.f350597m.set(false);     // Catch: Throwable -> L73
        FLogger r117 = FLogger.f375446a;     // Catch: Throwable -> L73
        StringBuilder r118 = new StringBuilder("reset isConnecting flag by connection state: ");     // Catch: Throwable -> L73
        if (r110 == null) goto L57;
        FlowWsConnectionState r119 = r110.f563548b;     // Catch: Throwable -> L73
    L58:
        r118.append(r119);     // Catch: Throwable -> L73
        r117.i("IM/FrontierConnection", r118.toString());     // Catch: Throwable -> L73
        goto L59
    L57:
        r119 = null;
        goto L58
    L45:
        r115 = null;
        goto L47
    L34:
        r111 = null;
    L41:
        r113 = false;
        goto L42
    L20:
        if (r104 == 3) goto L25;
        if (r104 == 4) goto L25;
        monitor-exit(this);
        return;
    L27:
        r105 = 2;
        goto L29
    L16:
        r104 = b.f350603a[r103.ordinal()];     // Catch: Throwable -> L73
        goto L17
    L13:
        r103 = null;
    L25:
        r105 = 0;
        goto L29
    L7:
        r102 = null;
    L73:
        th = move-exception;
        throw th;
    }

    public final boolean f(xf9.d r100) {
        xf9.d r101 = this.f350594j;
        boolean r102 = false;
        if (r101 != null) goto L19;
    L15:
        if (r100 == null) goto L17;
        FLogger.f375446a.i("IM/FrontierConnection", "boot WS #" + r100.getChannelId());
    L17:
        this.f350594j = r100;
        return r102;
    L19:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        FLogger.f375446a.i("IM/FrontierConnection", "shutdown WS #" + r101.getChannelId());     // Catch: Throwable -> L12
        if (d() == false) goto L7;
        this.f350599o = true;     // Catch: Throwable -> L12
        this.f350600p = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L12
    L7:
        g(0);     // Catch: Throwable -> L12
        r101.close();     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        r102 = true;
    L14:
        Result.m9448boximpl(r104);
    L10:
        th = th;
        r102 = true;
    L13:
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L12:
        th = th;
        goto L13
    }

    public final void g(int r100) {
        int r101 = this.f350595k;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 != 2) goto L12;
        FrontierStatusMonitor r102 = this.f350592h;
        if (r100 != 1) goto L10;
        int r103 = 1;
    L11:
        r102.getClass();
        o r104 = o.f365780a;
        AppHost.Companion r105 = AppHost.f326268a;
        r104.b("flow_frontier_connect", com.larus.utils.f.c(new Pair[]{TuplesKt.to("result", Integer.valueOf(r103)), TuplesKt.to("network", Integer.valueOf(NetworkUtils.isNetworkAvailable(r105.getApplication()) ? 1 : 0)), TuplesKt.to("background", Integer.valueOf(r105.a().isAppBackground() ? 1 : 0)), TuplesKt.to("is_login", Integer.valueOf(AccountService.f365697a.isLogin().booleanValue() ? 1 : 0))}));
        goto L12
    L10:
        r103 = 0;
    L12:
        Iterator<T> r106 = this.f350587c.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        ((Function1) r106.next()).invoke(Integer.valueOf(r100));
        goto L14
    L16:
        this.f350595k = r100;
    }

    public static String e(d r100, xf9.a r101) {
        r100.getClass();
        return "WsChannelMsg{channelId=" + r101.f563528a + ", seqId=" + r101.f563532e + ", service=" + r101.f563529b + ", method=" + r101.f563530c + ", msgHeaders=" + r101.f563534g + "}, payload=" + r101.f563531d.length + ", e=null";
    }
}
