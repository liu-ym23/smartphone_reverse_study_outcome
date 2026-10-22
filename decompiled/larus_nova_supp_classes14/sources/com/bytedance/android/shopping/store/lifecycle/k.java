package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements c {
    public JSONObject a;
    public long b;
    public long c;
    public boolean d;

    public k() {
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
    public final void n() {
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
    public final void x(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void y() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void l() {
        int r0 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.c(this.a, "click_expansion", null, null);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onPause() {
        this.b += SystemClock.elapsedRealtime() - this.c;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void w() {
        int r0 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.c(this.a, "load", null, null);
        com.bytedance.android.ec.store.utils.h.c(this.a, "label_receive", null, null);
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
    public final void onResume(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c = SystemClock.elapsedRealtime();
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
    public final void J(ECStoreViewModel r3, ECStoreParam r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        c.a.e(r3, r4);
        int r6 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.c(this.a, "landing_page", "button", null);
        JSONObject r7 = this.a;
        Map<String, Object> r8 = r3.getAdParams();
        r8.put("duration", String.valueOf(this.b / ECDraweeView.SQUARE));
        Unit r9 = Unit.INSTANCE;
        com.bytedance.android.ec.store.utils.h.d(r7, "stay_page", "shop", r8, "shop_window_ad");
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
        this.a = r3;
        int r5 = com.bytedance.android.ec.store.utils.h.a;
        com.bytedance.android.ec.store.utils.h.c(r3, "detail_show", null, null);
        int r6 = ECSdk.a;
        s83.g r7 = (s83.g) ECSdk.a(s83.g.class);
        if (r7 == null) goto L6;
        r7.j0("detail_show");
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r1, StoreTabConfig r2, ECStoreParam r3, JSONObject r4, JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        c.a.g(r1, r3);
        if (this.d == true) goto L6;
        this.d = true;
        int r7 = com.bytedance.android.ec.store.utils.h.a;
        JSONObject r8 = r1.getEntranceInfoJsonObject();
        Map<String, Object> r9 = r1.getAdParams();
        r9.put("enter_from", r3.getEnterFrom());
        Unit r10 = Unit.INSTANCE;
        com.bytedance.android.ec.store.utils.h.d(r8, "load_finish", "shop", r9, "shop_window_ad");
        return;
    }
}
