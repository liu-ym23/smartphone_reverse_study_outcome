package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataFutureManager;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreDataManager;
import com.bytedance.android.shopping.store.home.preload.data.ECStoreTabKitAPIDataCacheManager;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.router.ShopHelper;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements c {
    public l() {
    }

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
    public final void k(StoreTabConfig r1) {
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

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void A(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r2, "storeParam");
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
    public final void h(ECStorePreloadInfoResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
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
    public final void q(Context r9, ECStoreParam r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        c.a.i(r9, r10);
        Map<Long, m> r11 = a.a;
        m r12 = a.a(Long.valueOf(r10.getLifecycleMonitorId()));
        if (r12 == null) goto L5;
        r12.v();
    L5:
        m r13 = a.a(Long.valueOf(r10.getLifecycleMonitorId()));
        if (r13 == null) goto L8;
        r13.O();
    L8:
        Lazy r14 = ECStoreDataManager.c;
        ECStoreDataManager r15 = ECStoreDataManager.a.a();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        ECStoreTabKitAPIDataCacheManager r16 = r15.a();
        int r1 = ShopHelper.a;
        String r2 = ShopHelper.d(r10);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        boolean r4 = true;
        if (r2.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L19;
        Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b> r17 = r16.c.get(r2);
        if (r17 == null) goto L19;
        if (ECStoreTabKitAPIDataCacheManager.a(((Number) r17.getSecond()).longValue(), (fl.b) r17.getThird()) == true) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == true) goto L26;
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.h() == false) goto L25;
        Lazy r19 = ECStoreDataFutureManager.g;
        ECStoreDataFutureManager r20 = ECStoreDataFutureManager.a.a();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        r20.b = r10;
        io.reactivex.internal.observers.h<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> r5 = new io.reactivex.internal.observers.h();
        r20.f = r5;
        r20.a.d(r10, 0, "/shop/bff/tab/stream/").subscribeOn(Schedulers.io()).subscribe(r5);
        goto L26
    L25:
        Lazy r21 = ECStoreDataFutureManager.g;
        ECStoreDataFutureManager r22 = ECStoreDataFutureManager.a.a();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        r22.b = r10;
        io.reactivex.internal.observers.h<ECStoreHomeTabResponseTabkit> r6 = new io.reactivex.internal.observers.h();
        r22.e = r6;
        r22.a.c(r10, 0, "/shop/bff/tab/").subscribeOn(Schedulers.io()).subscribe(r6);
    L26:
        ECStoreDataManager r23 = ECStoreDataManager.a.a();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        ECStoreTabKitAPIDataCacheManager r24 = r23.a();
        String r7 = ShopHelper.d(r10);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r7, "uniqueId");
        if (r7.length() != 0) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == true) goto L37;
        Triple<ECShopHeadInfoBlock, Long, fl.b> r25 = r24.b.get(r7);
        if (r25 == null) goto L37;
        if (ECStoreTabKitAPIDataCacheManager.a(((Number) r25.getSecond()).longValue(), (fl.b) r25.getThird()) == true) goto L37;
    L38:
        if (r4 == true) goto L41;
        Lazy r26 = ECStoreDataFutureManager.g;
        ECStoreDataFutureManager r27 = ECStoreDataFutureManager.a.a();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        r27.b = r10;
        io.reactivex.internal.observers.h<ECShopHeadInfoBlock> r28 = new io.reactivex.internal.observers.h();
        r27.c = r28;
        ti3.d.a.a(r27.a, r10).subscribeOn(Schedulers.io()).subscribe(r28);
    L41:
        Lazy r29 = ECStoreDataFutureManager.g;
        ECStoreDataFutureManager r30 = ECStoreDataFutureManager.a.a();
        r30.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        r30.b = r10;
        r30.d = new io.reactivex.internal.observers.h();
        ti3.c r31 = r30.a;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r10, "storeParam");
        r31.a.getClass();
        Observable r110 = ti3.a.j(r10).subscribeOn(Schedulers.io());
        io.reactivex.internal.observers.h<ECStorePreloadInfoResponse> r32 = r30.d;
        Intrinsics.checkNotNull(r32);
        r110.subscribe(r32);
        return;
    L37:
        r4 = false;
        goto L38
    L29:
        r8 = false;
    L19:
        r18 = false;
        goto L20
    L11:
        r3 = false;
        goto L12
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
    }
}
