package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.net.ECStoreNetPreloadManager;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class StoreLynxResourcePreloadLifecycle implements c {
    public final long a;

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void C() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void D(StoreTabConfig r1, int r2, int r3, Integer r4, Integer r5, String r6, String r7, String r8) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void F(uj3.j r1, long r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void H() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void K() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void M(int r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void N(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void O() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void R(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void T() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void b() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void d(Throwable r1, CommerceBaseResponse r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void e(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void g() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void i(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void j() {
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
    public final void r(int r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void s(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void w() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void x(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void y() {
    }

    public StoreLynxResourcePreloadLifecycle(long r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void A(final ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Lazy r0 = ECTaskManager.b;
        ECTaskManager r1 = ECTaskManager.a.a();
        Function0<Unit> r2 = new StoreLynxResourcePreloadLifecycle$onPageInitStart$1(this, r3);
        r1.getClass();
        ECTaskManager.b(r2);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void L(f r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void Q(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r2, "storeParam");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void c(StoreTabConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void h(final ECStorePreloadInfoResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "preloadInfo");
        Intrinsics.checkNotNullParameter(r3, "preloadInfo");
        Lazy r0 = ECTaskManager.b;
        ECTaskManager r1 = ECTaskManager.a.a();
        Function0<Unit> r2 = new StoreLynxResourcePreloadLifecycle$preloadComponents$1(r3);
        r1.getClass();
        ECTaskManager.b(r2);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void k(StoreTabConfig r6) {
        Object r0 = null;
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getTabType());
    L7:
        if (r1 == null) goto L59;
        Integer r2 = r6.getContainerType();
        if (r2 == null) goto L59;
        if (r2.intValue() != 2) goto L59;
        ECStoreDynamicTabDTO r3 = r6.getDynamicTabVO();
        if (r3 == null) goto L16;
        String r4 = r3.getBundleUrl();
    L18:
        if (com.bytedance.android.shopping.anchorv3.a.b(r4) == false) goto L24;
        ECLiveHybridUtil.a r5 = ECLiveHybridUtil.a;
        ECStoreDynamicTabDTO r7 = r6.getDynamicTabVO();
        if (r7 == null) goto L22;
        String r8 = r7.getBundleUrl();
    L23:
        ECLiveHybridUtil.l(r8, true);
        goto L59
    L22:
        r8 = null;
        goto L23
    L24:
        String r9 = String.valueOf(r6.getTabType());
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L27
        int r11 = t0.a;     // Catch: Throwable -> L27
        Object r12 = Result.constructor-impl((ResPreloadConfig) t0.a.a.fromJson(ECStoreSettings.d(), ResPreloadConfig.class));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == false) goto L32;
        r12 = null;
    L32:
        ResPreloadConfig r13 = (ResPreloadConfig) r12;
        if (r13 != null) goto L35;
        List<String> r14 = null;
    L36:
        if (r14 == null) goto L59;
        Iterator<T> r15 = r14.iterator();
    L39:
        if (r15.hasNext() == false) goto L59;
        ECLiveHybridUtil.l((String) r15.next(), true);
        goto L39
    L35:
        r14 = r13.getMatchValue(r9);
    L27:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L16:
        r4 = null;
    L59:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L44
        Object r18 = Result.constructor-impl(com.bytedance.android.shopping.extensions.k.w(SettingKeys.getECOM_SHOP_INFO_AREA_LYNX_RES()));     // Catch: Throwable -> L44
    L47:
        if (Result.isFailure-impl(r18) == true) goto L50;
        r0 = r18;
    L50:
        JSONObject r19 = (JSONObject) r0;
        if (r19 != null) goto L53;
        r19 = new JSONObject();
    L53:
        String r20 = r19.optString("bundle_url");
        if (com.bytedance.android.shopping.anchorv3.a.b(r20) == false) goto L62;
        ECLiveHybridUtil.l(r20, true);
        return;
    L62:
        return;
    L44:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void m(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "preContext");
        Intrinsics.checkNotNullParameter(r2, "preContext");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void o(ECShopHeadInfoBlock r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
        ((ECStoreNetPreloadManager) ECStoreNetPreloadManager.b.getValue()).getClass();
        ECStoreNetPreloadManager.a();
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onResume(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void z(ECStorePreloadInfoResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void I(StoreTabConfig r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
        Intrinsics.checkNotNullParameter(r3, "metaInfo");
        c.a.b(r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void S(int r1, ECHybridListAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "listAdapter");
        Intrinsics.checkNotNullParameter(r2, "listAdapter");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void q(Context r2, ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        c.a.i(r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void G(ECStoreParam r2, ECStoreTabAreaVO r3, ECStoreHomeTabResponseTabkit r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "tabData");
        Intrinsics.checkNotNullParameter(r4, "response");
        c.a.j(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void J(ECStoreViewModel r1, ECStoreParam r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        c.a.e(r1, r2);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void P(String r1, Map<String, ? extends Object> r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void p(StoreTabConfig r1, JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "filterParams");
        Intrinsics.checkNotNullParameter(r2, "filterParams");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void u(ECStoreParam r2, com.bytedance.android.shopping.store.home.entity.n r3, CommerceBaseResponse r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "infoData");
        Intrinsics.checkNotNullParameter(r4, "response");
        c.a.c(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void B(Context r1, ECStoreParam r2, JSONObject r3, PageType r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "pageType");
        c.a.f(r2, r4);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r1, StoreTabConfig r2, ECStoreParam r3, JSONObject r4, JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        c.a.g(r1, r3);
        Lazy r7 = ECTaskManager.b;
        ECTaskManager.a.a().a(this.a, TaskPriority.AFTER_FIRST_SCREEN_IDLE, StoreLynxResourcePreloadLifecycle$onPageShow$1.INSTANCE);
    }
}
