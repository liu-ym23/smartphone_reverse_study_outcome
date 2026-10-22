package com.bytedance.kmp.ec.yata.common.biz;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.init.c;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import com.bytedance.kmp.ec.yata.common.platform.YataPlatformAtomicBoolean;
import com.bytedance.kmp.ec.yata.common.platform.h;
import com.bytedance.kmp.ec.yata.common.protocol.CopyConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.n;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.render.TreeType;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import com.bytedance.kmp.ec.yata.common.utils.b;
import com.bytedance.kmp.ec.yata.event.common.i;
import com.bytedance.kmp.ec.yata.event.common.j;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.bytedance.kmp.ec.yata.store.core.RenderTreeStruct;
import com.bytedance.kmp.ec.yata.store.core.YataStore;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import com.bytedance.kmp.ec.yata.store.core.d;
import com.bytedance.kmp.ec.yata.store.core.e;
import com.bytedance.kmp.ec.yata.store.core.g;
import com.bytedance.kmp.ec.yata.store.core.l;
import com.bytedance.kmp.ec.yata.store.core.m;
import com.bytedance.kmp.ec.yata.store.frontier.YataFrontierMessageDispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v96.f;

/* JADX INFO: loaded from: classes19.dex */
public abstract class YataStoreWrapper implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f251341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final YataPageInfo f251342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f251343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f251344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f251345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f251346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f251347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f251348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f251349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f251350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f251351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f251352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f251353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final YataPlatformAtomicBoolean f251354o;

    @Deprecated(message = "SDK内部API")
    public abstract void F(YataStoreData r100, RenderTreeStruct r101, List r102, YataStoreWrapper$submitStoreData$1 r103);

    @Deprecated(message = "触发节点View刷新")
    public abstract void w(String r100);

    public void d() {
        String r100 = YaTaLog.f251436a;
        YaTaLog.g("YataStoreWrapper", YataStoreWrapper$destroy$1.INSTANCE);
        com.bytedance.kmp.ec.yata.common.error.b r101 = g();
        r101.a("uplink", MapsKt.mapOf(new Pair[]{TuplesKt.to("start_count", Integer.valueOf(r101.f251392b.f251394a)), TuplesKt.to("success_count", Integer.valueOf(r101.f251392b.f251396c)), TuplesKt.to("failed_count", Integer.valueOf(r101.f251392b.f251395b))}));
        YataConcurrentHashMap<String, com.bytedance.kmp.ec.yata.common.error.b.a> r102 = r101.f251393c;
        ReentrantReadWriteLock.ReadLock r103 = r102.getLock().getLock().readLock();
        r103.lock();
        Iterator<Map.Entry<String, com.bytedance.kmp.ec.yata.common.error.b.a>> r104 = r102.getMap().entrySet().iterator();     // Catch: Throwable -> L13
    L5:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, com.bytedance.kmp.ec.yata.common.error.b.a> r110 = r104.next();     // Catch: Throwable -> L13
        r101.a("request", MapsKt.mapOf(new Pair[]{TuplesKt.to("request_api", r110.getKey()), TuplesKt.to("start_count", Integer.valueOf(r110.getValue().f251394a)), TuplesKt.to("success_count", Integer.valueOf(r110.getValue().f251396c)), TuplesKt.to("failed_count", Integer.valueOf(r110.getValue().f251395b))}));     // Catch: Throwable -> L13
        goto L5
    L8:
        r103.unlock();
        ((com.bytedance.kmp.ec.yata.common.utils.a) this.f251346g.getValue()).b();
        YataFrontierMessageDispatcher r105 = t();
        if (r105 == null) goto L11;
        r105.b((AndroidYaTaInstance) this);
    L11:
        k().f251677b.b();
        this.f251348i = true;
        return;
    L13:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    @Deprecated(message = "SDK内部API")
    public final YataErrorManager f() {
        return (YataErrorManager) this.f251347h.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.error.b g() {
        return (com.bytedance.kmp.ec.yata.common.error.b) this.f251345f.getValue();
    }

    public final YataEventCenter k() {
        return (YataEventCenter) this.f251349j.getValue();
    }

    @Deprecated(message = "测试")
    public final l r() {
        return (l) ((YataStore) this.f251351l.getValue()).f251715d.invoke();
    }

    public final f s() {
        return (f) this.f251344e.getValue();
    }

    @Deprecated(message = "测试")
    public final YataFrontierMessageDispatcher t() {
        if (this.f251342c.getUseFrontier() == true) goto L7;
        return null;
    L7:
        return YataFrontierMessageDispatcher.f251760a;
    }

    @Deprecated(message = "SDK内部API")
    public final com.bytedance.kmp.ec.yata.common.utils.a v() {
        return (com.bytedance.kmp.ec.yata.common.utils.a) this.f251346g.getValue();
    }

    public final Map<String, Object> j() {
        aa6.b r100 = r().a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    public final String m() {
        aa6.b r100 = r().a();
        if (r100 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<?, ?> r101 = aa6.c.b(r100);
        if (r101 == null) goto L7;
        Object r102 = r101.get("query_params");
    L9:
        if ((r102 instanceof String) == true) goto L11;
        return null;
    L11:
        return (String) r102;
    L7:
        r102 = null;
        goto L9
    L12:
        return null;
    }

    @Override // com.bytedance.kmp.ec.yata.common.utils.b
    @Deprecated(message = "SDK内部API")
    public final boolean a() {
        return this.f251348i;
    }

    public static final com.bytedance.kmp.ec.yata.common.utils.a b(YataStoreWrapper r100) {
        return (com.bytedance.kmp.ec.yata.common.utils.a) r100.f251346g.getValue();
    }

    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "setAsyncFieldNameList()", imports = {}))
    public final void C(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        d r101 = (d) this.f251350k.getValue();
        List<String> r102 = ArraysKt.toList(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f251733a = r102;
    }

    public final void D(i r100) {
        YataEventCenter r101 = k();
        if (r100 != null) goto L5;
        r101.f251677b.f251265k = null;
        return;
    L5:
        EventChain r102 = r101.f251677b;
        r102.f251265k = new com.bytedance.kmp.ec.yata.event.core.c(r100);
    }

    public final void E(com.bytedance.kmp.ec.yata.event.ability.uplink.c r100) {
        k().f251679d = r100;
    }

    public final void c(com.bytedance.kmp.ec.yata.store.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        ((m) this.f251352m.getValue()).f251753b.b(r100);
    }

    @Deprecated(message = "SDK内部API")
    public final void e(final YataStoreData r100) {
        Intrinsics.checkNotNullParameter(r100, "storeData");
        if (Intrinsics.areEqual(r100.f251719c, aa6.a.b.C0039a.f2349b) == false) goto L5;
    L6:
        YataPageInfo r101 = this.f251342c;
        int r102 = h.f251540a;
        r101.setLastQueryOrUplinkProtocolTime(System.currentTimeMillis());
    L7:
        Object r103 = r100.f251718b;
        if (r103 != null) goto L10;
        r103 = r100.f251717a.r().a();
    L10:
        if (r103 != null) goto L19;
        final String r104 = "yata protocol is Empty()." + r100.f251719c.f2347a;
        String r105 = YaTaLog.f251436a;
        YaTaLog.d("YataStoreWrapper", new YataStoreWrapper$doStoreDispatch$1(r100, r104));
        YataErrorManager r106 = r100.f251717a.f();
        com.bytedance.kmp.ec.yata.common.error.d r107 = com.bytedance.kmp.ec.yata.common.error.c.j();
        r107.c("store_dispatch");
        Intrinsics.checkNotNullParameter(r107, "<this>");
        r107.m(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r100.f251719c.f2347a);
        AbsPerfMonitor r108 = r100.f251723g;
        String r109 = null;
        if (r108 == null) goto L14;
        String r110 = r108.f251461c;
    L15:
        r107.m("scene", String.valueOf(r110));
        r107.o(r100.f251721e);
        String r111 = String.valueOf(r100.f251722f);
        Intrinsics.checkNotNullParameter(r111, "eventName");
        r107.f251403f = r111;
        r107.m("event", r111);
        r107.h(r104);
        StringBuilder r112 = new StringBuilder("刷新数据 但是数据为null scene:");
        AbsPerfMonitor r113 = r100.f251723g;
        if (r113 == null) goto L18;
        r109 = r113.f251461c;
    L18:
        r112.append(r109);
        r107.d(r112.toString());
        r106.c(r107);
        r100.a();
        return;
    L14:
        r110 = null;
        goto L15
    L19:
        com.bytedance.kmp.ec.yata.store.redux.b r114 = ((YataStore) this.f251351l.getValue()).f251714c;
        Intrinsics.checkNotNullParameter(r100, "data");
        r114.a(new g(r100));
        return;
    L5:
        if (Intrinsics.areEqual(r100.f251719c, aa6.a.b.C0040b.f2350b) == false) goto L7;
        goto L6
    }

    public final aa6.b h(@CopyConfig int r100) {
        aa6.b r101 = r().a();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    public final Object i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        l r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        aa6.b r102 = r101.a();
        if (r102 == null) goto L7;
        Map<String, Object> r103 = r102.h();
        if (r103 == null) goto L7;
        return r103.get(r100);
    L7:
        return null;
    }

    public final p l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        aa6.b r101 = r().a();
        if (r101 == null) goto L7;
        Map<String, p> r102 = r101.getData();
        if (r102 == null) goto L7;
        return r102.get(r100);
    L7:
        return null;
    }

    public final List<com.bytedance.kmp.ec.yata.store.node.c> n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        l r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "position");
        List<e> r102 = r101.f251750d;
        if (r102 == null) goto L23;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L5:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L12;
        Object r106 = r104.next();
        if (((e) r106).getType() != TreeType.MAIN) goto L10;
        r105 = true;
    L10:
        if (r105 == false) goto L5;
        r103.add(r106);
        goto L5
    L12:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r103.iterator();
    L14:
        if (r108.hasNext() == false) goto L16;
        CollectionsKt.addAll(r107, ((e) r108.next()).f251735b);
        goto L14
    L16:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r107.iterator();
    L18:
        if (r110.hasNext() == false) goto L36;
        List<com.bytedance.kmp.ec.yata.store.node.f> r111 = ((RenderTreeStruct) r110.next()).d().f251738c.get(r100);
        if (r111 == null) goto L18;
        r109.add(r111);
        goto L18
    L36:
        return (List) CollectionsKt.getOrNull(r109, 0);
    L23:
        return null;
    }

    public final com.bytedance.kmp.ec.yata.store.node.c o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        l r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        return (com.bytedance.kmp.ec.yata.store.node.c) ((Map) r101.f251751e.getValue()).get(r100);
    }

    public final List<com.bytedance.kmp.ec.yata.store.node.c> p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        l r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        List<e> r102 = r101.f251750d;
        if (r102 == null) goto L15;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        CollectionsKt.addAll(r103, ((e) r104.next()).f251735b);
        goto L6
    L8:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L23;
        List<com.bytedance.kmp.ec.yata.store.node.c> r107 = ((RenderTreeStruct) r106.next()).d().f251737b.get(r100);
        if (r107 == null) goto L10;
        r105.add(r107);
        goto L10
    L23:
        return CollectionsKt.flatten(r105);
    L15:
        return null;
    }

    public final List<com.bytedance.kmp.ec.yata.store.node.c> q(Function1<? super com.bytedance.kmp.ec.yata.store.node.c, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        l r101 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "predicate");
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((Map) r101.f251751e.getValue()).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r100.invoke(r104.getValue()).booleanValue() == false) goto L4;
        r102.add(r104.getValue());
        goto L4
    L8:
        return r102;
    }

    public final void u(com.bytedance.kmp.ec.yata.event.common.f r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        k().d(r100);
    }

    public final void A(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "exprFunction");
        YataEventCenter r102 = k();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "exprFunction");
        r102.f251681f.put(r100, r101);
    }

    public final void B(String r100, com.bytedance.kmp.ec.yata.event.common.d r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "eventFunNG");
        k().e(r100, r101);
    }

    public YataStoreWrapper(String r100, c r101, YataPageInfo r102, final f r103) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "switchConfig");
        Intrinsics.checkNotNullParameter(r102, "pageInfo");
        Intrinsics.checkNotNullParameter(r103, "originStoreAbility");
        this.f251340a = r100;
        this.f251341b = r101;
        this.f251342c = r102;
        int r104 = h.f251540a;
        this.f251343d = UUID.randomUUID().toString();
        this.f251344e = LazyKt.lazy(new YataStoreWrapper$storeAbilityProvider$2(this, r103));
        this.f251345f = LazyKt.lazy(new YataStoreWrapper$bizMonitor$2(this));
        this.f251346g = LazyKt.lazy(YataStoreWrapper$mainHandler$2.INSTANCE);
        this.f251347h = LazyKt.lazy(new YataStoreWrapper$yataErrorHandler$2(this));
        this.f251349j = LazyKt.lazy(new YataStoreWrapper$mEventCenter$2(this));
        this.f251350k = LazyKt.lazy(YataStoreWrapper$mergeRulers$2.INSTANCE);
        this.f251351l = LazyKt.lazy(new YataStoreWrapper$mYataStore$2(this));
        this.f251352m = LazyKt.lazy(new YataStoreWrapper$storeContext$2(this));
        this.f251353n = LazyKt.lazy(new YataStoreWrapper$transformCallbackManager$2(this));
        this.f251354o = new YataPlatformAtomicBoolean(false);
    }

    public final void x(n r100, aa6.a r101, com.bytedance.kmp.ec.yata.common.perf.d r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        z(r100, r101, r110, r111, YataStoreWrapper$refreshProtocol$1.INSTANCE);
    }

    public final void z(n r100, aa6.a r110, com.bytedance.kmp.ec.yata.common.perf.d r111, String r112, Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r113, "onRenderEndCallback");
        y(r100, r110, r111, r112, IYataStoreWrapperDelegate$refreshProtocolWithAllCallback$1.INSTANCE, r113);
    }

    public final void y(n r110, aa6.a r111, com.bytedance.kmp.ec.yata.common.perf.d r112, String r113, final Function0<Unit> r114, final Function0<Unit> r115) {
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r114, "onStoreEndCallback");
        Intrinsics.checkNotNullParameter(r115, "onRenderEndCallback");
        if (r113 == null) goto L5;
        f().a("log_id", r113);
    L5:
        Map<String, Object> r100 = null;
        if ((r110 instanceof aa6.b) == false) goto L8;
        aa6.b r101 = (aa6.b) r110;
    L9:
        if (r101 == null) goto L22;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map<String, Object> r102 = r101.e();
        if (r102 == null) goto L13;
        Object r103 = r102.get("biz_info");
    L15:
        if ((r103 instanceof Map) == false) goto L17;
        Map<String, Object> r104 = (Map) r103;
    L18:
        if (r104 == null) goto L22;
        r100 = r104;
    L27:
        if (r100 == null) goto L32;
        Iterator<Map.Entry<String, Object>> r105 = r100.entrySet().iterator();
    L30:
        if (r105.hasNext() == false) goto L32;
        Map.Entry<String, Object> r106 = r105.next();
        f().a(r106.getKey(), String.valueOf(r106.getValue()));
    L32:
        YataStoreData.StoreType r107 = YataStoreData.StoreType.MERGE;
        if (r112 == null) goto L35;
        String r108 = r112.f251461c;
    L35:
        e(new YataStoreData(this, r110, r111, r107, null, null, r112, new YataStoreWrapper$refreshProtocolWithAllCallback$2(r114), new YataStoreWrapper$refreshProtocolWithAllCallback$3(r115), 48));
        return;
    L17:
        r104 = null;
        goto L18
    L13:
        r103 = null;
    L22:
        if ((r110 instanceof com.bytedance.kmp.ec.yata.common.protocol.data.c) == false) goto L24;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r109 = (com.bytedance.kmp.ec.yata.common.protocol.data.c) r110;
    L25:
        if (r109 == null) goto L27;
        r100 = com.bytedance.kmp.ec.yata.common.protocol.data.d.a(r109);
        goto L27
    L24:
        r109 = null;
        goto L25
    L8:
        r101 = null;
        goto L9
    }
}
