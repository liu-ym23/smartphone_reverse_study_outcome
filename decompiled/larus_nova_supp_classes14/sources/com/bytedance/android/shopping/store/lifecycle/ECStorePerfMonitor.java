package com.bytedance.android.shopping.store.lifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.util.LruCache;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.ExecutorType;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataManager;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreTabKitAPIDataCacheManager;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.home.s;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.router.ShopHelper;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStorePerfMonitor implements c {
    public static final /* synthetic */ int n = 0;
    public boolean a;
    public ECStoreParam b;
    public long c;
    public String d;
    public long e;
    public long f;
    public final Map<Integer, StoreTabConfig> g;
    public final Map<Integer, q> h;
    public final Map<Integer, b> i;
    public final e j;
    public final g k;
    public s l;
    public final String m;

    public static final class a {
        public static ECStorePerfMonitor a(Long r0) {
            m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(r0);
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.b;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void D(StoreTabConfig r1, int r2, int r3, Integer r4, Integer r5, String r6, String r7, String r8) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void M(int r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void d(Throwable r1, CommerceBaseResponse r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void i(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void l() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void n() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void w() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void x(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void H() {
        e r0 = this.j;
        r0.f = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void K() {
        e r0 = this.j;
        r0.h = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void O() {
        e r0 = this.j;
        r0.d = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void T() {
        e r0 = this.j;
        r0.m = System.currentTimeMillis();
        e r1 = this.j;
        r1.n = r1.m;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void a() {
        e r0 = this.j;
        r0.p = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void b() {
        e r0 = this.j;
        r0.e = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void t() {
        e r0 = this.j;
        r0.l = System.currentTimeMillis();
        this.j.u = true;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void C() {
        this.j.y = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void f() {
        this.j.v = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void g() {
        this.j.x = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void j() {
        long r0 = System.currentTimeMillis();
        this.f = r0;
        this.j.j = r0;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void v() {
        this.e = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void y() {
        this.j.w = System.currentTimeMillis();
    }

    public ECStorePerfMonitor(String r3) {
        Intrinsics.checkNotNullParameter(r3, "entranceClassName");
        this.m = r3;
        this.c = -1;
        this.e = -1;
        this.f = -1;
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.j = new e();
        this.k = new g();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void A(ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        e r4 = this.j;
        r4.b = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void L(f r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void N(StoreTabConfig r11) {
        ECStoreParam r3 = this.b;
        if (r3 == null) goto L28;
        Map<Integer, b> r0 = this.i;
        if (r11 == null) goto L7;
        Integer r1 = Integer.valueOf(r11.getTabId());
    L8:
        if (r0 == null) goto L27;
        b r2 = (b) TypeIntrinsics.asMutableMap(r0).remove(r1);
        if (r2 != null) goto L12;
        return;
    L12:
        s r4 = this.l;
        if (r4 == null) goto L29;
        JSONObject r5 = new JSONObject();
        r5.put("t_filter_click", r2.a);
        r5.put(TabkitFirstFramePref.T_REQUEST_START, r2.b);
        r5.put(TabkitFirstFramePref.T_REQUEST_END, r2.c);
        r5.put("t_page_show", System.currentTimeMillis());
        ECAppInfoService r6 = ECAppInfoService.e;
        if (r6.isLocalTest() == false) goto L17;
    L18:
        r5.put("debug_filter_total_duration", System.currentTimeMillis() - r2.a);
        r5.put("debug_filter_api_duration", r2.c - r2.b);
        r5.put("debug_filter_render_duration", System.currentTimeMillis() - r2.c);
    L19:
        Unit r7 = Unit.INSTANCE;
        JSONObject r8 = r2.d;
        if (r8 != null) goto L22;
        r8 = new JSONObject();
    L22:
        String r9 = r2.e;
        if (r9 == null) goto L25;
        com.bytedance.android.shopping.extensions.d.a(r8, r9);
    L25:
        s.c(r4, "ec_perf_duration_shop_product", r11, r3, r8, r5, 32);
        return;
    L17:
        if (r6.isDebug() == false) goto L19;
    L29:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void Q(ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        e r4 = this.j;
        r4.o = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void R(StoreTabConfig r3) {
        Map<Integer, b> r0 = this.i;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getTabId());
    L6:
        b r5 = (b) ((LinkedHashMap) r0).get(r4);
        if (r5 == null) goto L10;
        r5.c = System.currentTimeMillis();
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void c(StoreTabConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "tabConfig");
        if (r3.getDefaultSelected() == false) goto L5;
        r3.setMonitorId(this.d);
    L6:
        this.g.put(Integer.valueOf(r3.getTabId()), r3);
        this.h.put(Integer.valueOf(r3.getTabId()), new q());
        return;
    L5:
        r3.setMonitorId(UUID.randomUUID().toString());
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void e(StoreTabConfig r4) {
        e r0 = this.j;
        r0.q = System.currentTimeMillis();
        if (r4 == null) goto L8;
        Map<Integer, q> r1 = this.h;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        q r5 = (q) r2.get(Integer.valueOf(r4.getTabId()));
        if (r5 == null) goto L9;
        r5.b = System.currentTimeMillis();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void h(ECStorePreloadInfoResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "preloadInfo");
        e r4 = this.j;
        r4.k = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void k(StoreTabConfig r3) {
        if (r3 != null) goto L5;
        ECExceptionMonitor.e(new Throwable("onFetchDynamicTabData tabConfig is empty"));
        return;
    L5:
        Map<Integer, q> r0 = this.h;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        q r4 = (q) r1.get(Integer.valueOf(r3.getTabId()));
        if (r4 == null) goto L9;
        r4.c = Long.valueOf(System.currentTimeMillis());
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void m(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "preContext");
        e r4 = this.j;
        r4.a = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void o(ECShopHeadInfoBlock r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        e r0 = this.j;
        r0.g = System.currentTimeMillis();
        s r1 = this.l;
        if (r1 == null) goto L8;
        Map<String, String> r5 = r4.getPerfLogExtra();
        if (r5 == null) goto L9;
        r1.a.putAll(r5);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onResume(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r8, "context");
        BtmSDK r3 = BtmSDK.INSTANCE;
        BtmItemBuilder r4 = new BtmItemBuilder("", Boolean.FALSE);
        if ((r8 instanceof MutableContextWrapper) == true) goto L5;
    L9:
        Unit r6 = null;
        if ((r8 instanceof Activity) == true) goto L12;
        r8 = null;
    L12:
        JSONObject r9 = r3.createBtmChain(r4.withBtmPage((Activity) r8).build());
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L24
        s r7 = this.l;     // Catch: Throwable -> L24
        if (r7 == null) goto L16;
        r7.a("btm", JSONObjectProtectorUtils.getString(r9, "btm"));     // Catch: Throwable -> L24
    L16:
        s r2 = this.l;     // Catch: Throwable -> L24
        if (r2 == null) goto L19;
        r2.a("btm_pre", JSONObjectProtectorUtils.getString(r9, "btm_pre"));     // Catch: Throwable -> L24
    L19:
        s r1 = this.l;     // Catch: Throwable -> L24
        if (r1 == null) goto L22;
        r1.a("btm_ppre", JSONObjectProtectorUtils.getString(r9, "btm_ppre"));     // Catch: Throwable -> L24
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Result.constructor-impl(r6);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L5:
        if ((r8 instanceof Activity) == true) goto L9;
        if ((r8 instanceof ContextWrapper) == false) goto L9;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L5
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void s(StoreTabConfig r3) {
        if (r3 != null) goto L5;
        ECExceptionMonitor.e(new Throwable("onFetchDynamicTabDataEnd tabConfig is empty"));
        return;
    L5:
        Map<Integer, q> r0 = this.h;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        q r4 = (q) r1.get(Integer.valueOf(r3.getTabId()));
        if (r4 == null) goto L9;
        r4.d = Long.valueOf(System.currentTimeMillis());
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void z(ECStorePreloadInfoResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "preloadInfo");
        e r4 = this.j;
        r4.i = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void F(uj3.j r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        Map<Integer, q> r0 = this.h;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        q r4 = (q) r1.get(Integer.valueOf(r2.hashCode()));
        if (r4 == null) goto L8;
        r4.a = r3;
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void I(StoreTabConfig r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "tabConfig");
        Intrinsics.checkNotNullParameter(r7, "metaInfo");
        q r0 = (q) ((LinkedHashMap) this.h).get(Integer.valueOf(r6.getTabId()));
        long r1 = -1;
        if (r0 == null) goto L5;
        long r3 = r0.b;
    L6:
        r7.put("monitor_start_time", Long.valueOf(r3));
        r7.put("monitor_total_start_time", Long.valueOf(this.c));
        if (r6.isFetchDynamicTabInitialData() == false) goto L14;
        q r2 = (q) ((LinkedHashMap) this.h).get(Integer.valueOf(r6.getTabId()));
        if (r2 == null) goto L13;
        Long r4 = r2.c;
        if (r4 == null) goto L13;
        long r5 = r4.longValue();
    L15:
        r7.put("monitor_fetch_start_time", Long.valueOf(r5));
        if (r6.isFetchDynamicTabInitialData() == false) goto L22;
        q r8 = (q) ((LinkedHashMap) this.h).get(Integer.valueOf(r6.getTabId()));
        if (r8 == null) goto L23;
        Long r9 = r8.d;
        if (r9 == null) goto L23;
        r1 = r9.longValue();
    L23:
        r7.put("monitor_fetch_end_time", Long.valueOf(r1));
        r7.put("monitor_enter_type", Integer.valueOf(!r6.getDefaultSelected() ? 1 : 0));
        return;
    L22:
        r1 = this.f;
    L13:
        r5 = -1;
        goto L15
    L14:
        r5 = this.e;
        goto L15
    L5:
        r3 = -1;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void S(int r1, ECHybridListAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "listAdapter");
        Intrinsics.checkNotNullParameter(r2, "listAdapter");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void q(Context r3, ECStoreParam r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        String r5 = UUID.randomUUID().toString();
        this.c = System.currentTimeMillis();
        this.d = r5;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void r(int r1, int r2) {
        Map<Integer, StoreTabConfig> r3 = this.g;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        StoreTabConfig r5 = (StoreTabConfig) r4.get(Integer.valueOf(r1));
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getDefaultSelected() == true) goto L9;
        this.c = System.currentTimeMillis();
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void G(final ECStoreParam r3, final ECStoreTabAreaVO r4, final ECStoreHomeTabResponseTabkit r5) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "tabData");
        Intrinsics.checkNotNullParameter(r5, "response");
        s r0 = this.l;
        if (r0 == null) goto L7;
        Map<String, String> r1 = r4.e;
        if (r1 == null) goto L7;
        r0.a.putAll(r1);
    L7:
        Lazy r2 = ECTaskManager.b;
        ECTaskManager r6 = ECTaskManager.a.a();
        Function0<Unit> r7 = new ECStorePerfMonitor$onTabDataReady$1(this, r5, r3, r4);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "runnable");
        int r8 = com.bytedance.android.ec.store.utils.taskmanager.c.c;
        com.bytedance.android.ec.store.utils.taskmanager.c.b.a.a(ExecutorType.COMPUTE, r7);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void J(ECStoreViewModel r12, ECStoreParam r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        Intrinsics.checkNotNullParameter(r13, "storeParam");
        Lazy r15 = ECStoreDataManager.c;
        ECStoreDataManager r16 = ECStoreDataManager.a.a();
        int r17 = ShopHelper.a;
        String r18 = ShopHelper.d(r13);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r18, "uniqueId");
        ECStoreTabKitAPIDataCacheManager r19 = r16.a();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "uniqueId");
        StoreTabConfig r1 = null;
        if (r19.b.get(r18) != null) goto L5;
    L12:
        Iterator r110 = ((LinkedHashMap) this.g).entrySet().iterator();
        boolean r111 = false;
    L13:
        StoreTabConfig r5 = r1;
        boolean r0 = false;
    L15:
        if (r110.hasNext() == false) goto L25;
        Map.Entry r2 = (Map.Entry) r110.next();
        if (((StoreTabConfig) r2.getValue()).getDefaultSelected() == true) goto L18;
        if (r0 == false) goto L21;
    L24:
        r0 = true;
        goto L15
    L21:
        if (((StoreTabConfig) r2.getValue()).getDurationReported() == true) goto L24;
        r1 = r5;
        goto L13
    L18:
        r111 = ((StoreTabConfig) r2.getValue()).getDurationReported();
        r5 = (StoreTabConfig) r2.getValue();
        goto L15
    L25:
        s r3 = this.l;
        if (r3 == null) goto L44;
        JSONObject r7 = new JSONObject();
        String r112 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (r111 == false) goto L30;
        Object r113 = CommentScene.COMMENTSCENE_NO_AWEME;
    L31:
        r7.put("ec_perf_duration_shop_default_reported", r113);
        if (r0 == true) goto L35;
        r112 = "0";
    L35:
        r7.put("ec_perf_duration_shop_switch_reported", r112);
        r7.put("stay_duration", System.currentTimeMillis() - this.j.a);
        Unit r114 = Unit.INSTANCE;
        s.c(r3, "ec_perf_shop_page_destory", r5, r13, r7, null, 48);
        return;
    L30:
        r113 = "0";
        goto L31
    L44:
        return;
    L5:
        if (r19.c.get(r18) == null) goto L12;
        Triple<ECShopHeadInfoBlock, Long, fl.b> r4 = r19.b.get(r18);
        Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r6 = r19.c.get(r18);
        fl.b r8 = (fl.b) r4.getThird();
        if ((System.currentTimeMillis() - (((Number) r4.getSecond()).longValue() + ((long) (com.bytedance.android.shopping.extensions.k.g(r8.a, 0) * ECDraweeView.SQUARE)))) <= 120000) goto L10;
        r19.b.remove(r18);
        r19.c.remove(r18);
        goto L12
    L10:
        if (Intrinsics.areEqual(r8.b, Boolean.TRUE) == false) goto L12;
        r8.b = Boolean.FALSE;
        r8.a = null;
        LruCache<String, Triple<ECShopHeadInfoBlock, Long, fl.b>> r9 = r19.b;
        r9.put(r18, new Triple(r9.get(r18).getFirst(), Long.valueOf(System.currentTimeMillis()), r8));
        r19.c.put(r18, new Triple(r6.getFirst(), Long.valueOf(System.currentTimeMillis()), r8));
        goto L12
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void P(String r1, Map<String, ? extends Object> r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void p(StoreTabConfig r5, JSONObject r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "filterParams");
        Intrinsics.checkNotNullParameter(r6, "filterParams");
        if (r5 != null) goto L5;
        return;
    L5:
        Map<Integer, b> r0 = this.i;
        Integer r8 = Integer.valueOf(r5.getTabId());
        b r1 = new b();
        long r2 = System.currentTimeMillis();
        r1.a = r2;
        r1.b = r2;
        r1.d = r6;
        r1.e = r7;
        Unit r9 = Unit.INSTANCE;
        r0.put(r8, r1);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void u(final ECStoreParam r2, com.bytedance.android.shopping.store.home.entity.n r3, final CommerceBaseResponse r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "infoData");
        Intrinsics.checkNotNullParameter(r4, "response");
        s r0 = this.l;
        if (r0 == null) goto L7;
        Map<String, String> r5 = r3.k;
        if (r5 == null) goto L7;
        r0.a.putAll(r5);
    L7:
        Lazy r6 = ECTaskManager.b;
        ECTaskManager r7 = ECTaskManager.a.a();
        Function0<Unit> r1 = new ECStorePerfMonitor$onInfoDataReady$1(this, r4, r2);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "runnable");
        int r8 = com.bytedance.android.ec.store.utils.taskmanager.c.c;
        com.bytedance.android.ec.store.utils.taskmanager.c.b.a.a(ExecutorType.COMPUTE, r1);
    }

    public static void V(ECStorePerfMonitor r7, di.d r8, StoreTabConfig r9, ECStoreParam r10) {
        s r0 = r7.l;
        if (r0 == null) goto L48;
        JSONObject r4 = new JSONObject();
        Iterator r11 = r8.c.a().entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) r11.next();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Result.constructor-impl(r4.put((String) r2.getKey(), r2.getValue()));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    L12:
        Unit r12 = Unit.INSTANCE;
        JSONObject r6 = new JSONObject();
        Iterator r13 = r8.a.a().entrySet().iterator();
    L14:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r14 = (Map.Entry) r13.next();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L18
        Result.constructor-impl(r6.put((String) r14.getKey(), r14.getValue()));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L20:
        Iterator r17 = r8.b.a().entrySet().iterator();
    L22:
        if (r17.hasNext() == false) goto L28;
        Map.Entry r18 = (Map.Entry) r17.next();
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L26
        Result.constructor-impl(r6.put((String) r18.getKey(), r18.getValue()));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L28:
        Unit r21 = Unit.INSTANCE;
        s.c(r0, "ec_perf_duration_shop_net", r9, r10, r4, r6, 32);
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void B(Context r8, ECStoreParam r9, JSONObject r10, PageType r11) {
        Intrinsics.checkNotNullParameter(r9, "storeParam");
        Intrinsics.checkNotNullParameter(r11, "pageType");
        this.b = r9;
        Map<Long, m> r12 = com.bytedance.android.shopping.store.lifecycle.a.a;
        this.l = com.bytedance.android.shopping.store.lifecycle.a.b(Long.valueOf(r9.getLifecycleMonitorId()));
        e r13 = this.j;
        r13.c = System.currentTimeMillis();
        s r14 = this.l;
        if (r14 == null) goto L5;
        r14.a("sec_shop_id", r9.getSecShopId());
    L5:
        s r15 = this.l;
        if (r15 == null) goto L8;
        r15.a("entrance_location", r9.getEntranceLocation());
    L8:
        s r16 = this.l;
        if (r16 == null) goto L11;
        r16.a("entrance_class_name", this.m);
    L11:
        if (r10 == null) goto L17;
        String r17 = r10.optString("enable_common_ad_track");
        if (r17 == null) goto L17;
        s r0 = this.l;
        if (r0 == null) goto L17;
        r0.a("enable_common_ad_track", r17);
    L17:
        if (r10 == null) goto L23;
        String r18 = r10.optString("is_from_ad");
        if (r18 == null) goto L23;
        s r1 = this.l;
        if (r1 == null) goto L23;
        r1.a("is_from_ad", r18);
    L23:
        if (r10 == null) goto L29;
        String r19 = r10.optString("creative_id");
        if (r19 == null) goto L29;
        s r2 = this.l;
        if (r2 == null) goto L29;
        r2.a("creative_id", r19);
    L29:
        if (r10 == null) goto L37;
        String r20 = r10.optString("log_extra");
        if (r20 == null) goto L37;
        String r21 = z1.f(r20).optString("rit");
        if (r21 == null) goto L37;
        s r110 = this.l;
        if (r110 == null) goto L37;
        r110.a("ad_rit", r21);
    L37:
        s r3 = this.l;
        if (r3 == null) goto L41;
        s.c(r3, "ec_perf_page_start_store", null, r9, null, null, 58);
        return;
    }

    public static final void U(ECStorePerfMonitor r18, StoreTabConfig r19, ECStoreParam r20, JSONObject r21, JSONObject r22) {
        r18.getClass();
        if (r19 != null) goto L5;
        return;
    L5:
        if (r19.getMonitorId() != null) goto L7;
        return;
    L7:
        if (r19.getDurationReported() == true) goto L76;
        r19.setDurationReported(true);
        s r4 = r18.l;
        if (r4 == null) goto L75;
        if (r22 != null) goto L13;
        JSONObject r5 = new JSONObject();
    L69:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L32
        boolean r8 = false;
        if (r18.a == false) goto L17;
        int r7 = 1;
    L18:
        r5.put("is_unusual", r7);     // Catch: Throwable -> L32
        r5.put(TabkitFirstFramePref.T_PAGE_ROUTE_START, r18.j.a);     // Catch: Throwable -> L32
        r5.put(TabkitFirstFramePref.T_PAGE_INIT_START, r18.j.b);     // Catch: Throwable -> L32
        r5.put(TabkitFirstFramePref.T_PAGE_INIT_END, r18.j.c);     // Catch: Throwable -> L32
        r5.put(TabkitFirstFramePref.T_REQUEST_START, r18.j.d);     // Catch: Throwable -> L32
        r5.put("t_request_preload_end", r18.j.k);     // Catch: Throwable -> L32
        r5.put("t_request_info_end", r18.j.g);     // Catch: Throwable -> L32
        r5.put("t_request_frame_info_start", r18.j.h);     // Catch: Throwable -> L32
        r5.put("t_request_frame_info_end", r18.j.i);     // Catch: Throwable -> L32
        r5.put("t_request_tab_end", r18.j.j);     // Catch: Throwable -> L32
        r5.put("t_render_tab_start", r18.j.p);     // Catch: Throwable -> L32
        r5.put("t_render_info_start", r18.j.l);     // Catch: Throwable -> L32
        r5.put("t_render_info_end", r18.j.m);     // Catch: Throwable -> L32
        r5.put("t_render_async_info_end", r18.j.n);     // Catch: Throwable -> L32
        r5.put("t_render_live_end", r18.j.o);     // Catch: Throwable -> L32
        r5.put("t_tab_container_ready", r18.j.q);     // Catch: Throwable -> L32
        r5.put("t_page_show", r18.j.r);     // Catch: Throwable -> L32
        r5.put("t_page_show_async", r18.j.s);     // Catch: Throwable -> L32
        e r9 = r18.j;     // Catch: Throwable -> L32
        if (r9.r == r9.s) goto L21;
    L22:
        r8 = true;
    L23:
        r5.put("async_render", r8);     // Catch: Throwable -> L32
        r5.put("t_init_slice_start", r18.j.v);     // Catch: Throwable -> L32
        r5.put("t_init_slice_end", r18.j.w);     // Catch: Throwable -> L32
        r5.put("t_preload_template_start", r18.j.x);     // Catch: Throwable -> L32
        r5.put("t_preload_template_end", r18.j.y);     // Catch: Throwable -> L32
        r5.put("t_request_tab_start", r18.j.e);     // Catch: Throwable -> L32
        r5.put("t_request_info_start", r18.j.f);     // Catch: Throwable -> L32
        if (r18.k.b() == false) goto L30;
        r5.put("t_page_show_2", g.a(r18.k.a, 100));     // Catch: Throwable -> L32
        r5.put("t_page_route_start_2", g.a(r18.k.a, 1));     // Catch: Throwable -> L32
        g r10 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_route_duration", g.a(r10.a, 2) - g.a(r10.a, 1));     // Catch: Throwable -> L32
        g r11 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_pre_activity_pause_duration", g.a(r11.a, 3) - g.a(r11.a, 2));     // Catch: Throwable -> L32
        g r12 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_base_duration", (g.a(r12.a, 4) - g.a(r12.a, 3)) - (g.a(r12.a, 10) - g.a(r12.a, 9)));     // Catch: Throwable -> L32
        g r13 = r18.k;     // Catch: Throwable -> L32
        long r14 = g.a(r13.a, 6) - g.a(r13.a, 5);     // Catch: Throwable -> L32
        if (r13.b == false) goto L28;
        long r15 = 0;
    L29:
        r5.put("pure_render_header_duration", r14 - r15);     // Catch: Throwable -> L32
        g r16 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_tab_duration", g.a(r16.a, 8) - g.a(r16.a, 7));     // Catch: Throwable -> L32
        g r17 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_api_block_duration", g.a(r17.a, 10) - g.a(r17.a, 9));     // Catch: Throwable -> L32
        g r23 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_product_card_duration", g.a(r23.a, 12) - g.a(r23.a, 11));     // Catch: Throwable -> L32
        g r24 = r18.k;     // Catch: Throwable -> L32
        r5.put("pure_render_live_duration", g.a(r24.a, 14) - g.a(r24.a, 13));     // Catch: Throwable -> L32
        r5.put("pure_render_is_first_frame_merged", r18.k.b ? 1 : 0);     // Catch: Throwable -> L32
        r5.put("media_type", r18.k.c);     // Catch: Throwable -> L32
        r5.put("first_screen_render_card_count", r18.k.d);     // Catch: Throwable -> L32
        goto L30
    L28:
        r15 = g.a(r13.a, 14) - g.a(r13.a, 13);     // Catch: Throwable -> L32
    L30:
        Result.constructor-impl(r5);     // Catch: Throwable -> L32
    L35:
        if (r19.getDefaultSelected() == true) goto L49;
        q r0 = (q) ((LinkedHashMap) r18.h).get(Integer.valueOf(r19.getTabId()));
        if (r0 == null) goto L39;
        Long r1 = Long.valueOf(r0.a);
    L40:
        r5.put("t_tab_click", r1);
        q r2 = (q) ((LinkedHashMap) r18.h).get(Integer.valueOf(r19.getTabId()));
        if (r2 == null) goto L43;
        Long r3 = r2.c;
    L44:
        r5.put("t_request_xtab_start", r3);
        q r25 = (q) ((LinkedHashMap) r18.h).get(Integer.valueOf(r19.getTabId()));
        if (r25 == null) goto L47;
        Long r26 = r25.d;
    L48:
        r5.put("t_request_xtab_end", r26);
        goto L49
    L47:
        r26 = null;
        goto L48
    L43:
        r3 = null;
        goto L44
    L39:
        r1 = null;
    L49:
        r5.put("flag_slice_product_card", r18.j.t ? 1 : 0);
        r5.put("flag_slice_profile_card", r18.j.u ? 1 : 0);
        di.q r27 = r18.j.A;
        if (r27 != null) goto L71;
    L55:
        di.q r28 = r18.j.z;
        if (r28 != null) goto L67;
    L61:
        Unit r29 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("ec_perf_duration_shop", "eventName");
        Intrinsics.checkNotNullParameter(r19, "tabConfig");
        Intrinsics.checkNotNullParameter(r20, "storeParam");
        Intrinsics.checkNotNullParameter(r5, "metric");
        int r30 = ECMonitorService.b;
        if (r21 != null) goto L64;
        JSONObject r31 = new JSONObject();
    L65:
        r4.b(r31, r19, r20);
        ECMonitorService.a.a("ec_perf_duration_shop", r31, r5, null);
        return;
    L64:
        r31 = r21;
        goto L65
    L67:
        r5.put("net_tab_start_time", r28.a);     // Catch: Throwable -> L59
        r5.put("net_tab_create_stream_start", r28.b);     // Catch: Throwable -> L59
        r5.put("net_tab_create_stream_finish", r28.c);     // Catch: Throwable -> L59
        r5.put("net_tab_request_sent_time", r28.d);     // Catch: Throwable -> L59
        r5.put("net_tab_response_recv_time", r28.e);     // Catch: Throwable -> L59
        r5.put("net_tab_end_time", r28.f);     // Catch: Throwable -> L59
        r5.put("net_tab_ec_net_request_start", r28.g);     // Catch: Throwable -> L59
        Result.constructor-impl(r5.put("net_tab_ec_net_request_end", r28.h));     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L71:
        r5.put("net_info_start_time", r27.a);     // Catch: Throwable -> L53
        r5.put("net_info_create_stream_start", r27.b);     // Catch: Throwable -> L53
        r5.put("net_info_create_stream_finish", r27.c);     // Catch: Throwable -> L53
        r5.put("net_info_request_sent_time", r27.d);     // Catch: Throwable -> L53
        r5.put("net_info_response_recv_time", r27.e);     // Catch: Throwable -> L53
        r5.put("net_info_end_time", r27.f);     // Catch: Throwable -> L53
        r5.put("net_info_ec_net_request_start", r27.g);     // Catch: Throwable -> L53
        Result.constructor-impl(r5.put("net_info_ec_net_request_end", r27.h));     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L21:
        if (r9.m == r9.n) goto L23;
    L17:
        r7 = 0;
    L32:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L13:
        r5 = r22;
        goto L69
    L75:
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r10, final StoreTabConfig r11, final ECStoreParam r12, final JSONObject r13, final JSONObject r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r12, "storeParam");
        e r16 = this.j;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r14 == null) goto L6;
        Long r2 = Long.valueOf(r14.optLong("t_page_show"));     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r3) == true) goto L15;
        r0 = r3;
    L15:
        Long r4 = (Long) r0;
        if (r4 == null) goto L18;
        long r5 = r4.longValue();
    L19:
        Long r6 = Long.valueOf(r5);
        if (r6 == null) goto L22;
        long r7 = r6.longValue();
    L23:
        r16.r = r7;
        e r17 = this.j;
        r17.t = true;
        if (r15 == false) goto L26;
        return;
    L26:
        r17.s = r17.r;
        Lazy r18 = ECTaskManager.b;
        ECTaskManager.a.a().a(r12.getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN_IDLE, new ECStorePerfMonitor$onPageShow$1(this, r11, r12, r13, r14));
        return;
    L22:
        r7 = -1;
        goto L23
    L18:
        r5 = System.currentTimeMillis();
        goto L19
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
