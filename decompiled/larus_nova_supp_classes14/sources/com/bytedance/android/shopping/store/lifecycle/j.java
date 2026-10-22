package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.home.s;
import com.bytedance.android.shopping.store.home.t;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements c {
    public ECStoreParam a;
    public int b;
    public final List<i> c;
    public final Map<Integer, Integer> d;

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void C() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void D(StoreTabConfig r1, int r2, int r3, Integer r4, Integer r5, String r6, String r7, String r8) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void H() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void K() {
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

    public j() {
        this.b = -1;
        this.c = new ArrayList();
        this.d = new LinkedHashMap();
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
    public final void F(uj3.j r1, long r2) {
        if (r1 == null) goto L4;
        int r3 = r1.d;
    L5:
        this.b = r3;
        return;
    L4:
        r3 = -1;
        goto L5
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void I(StoreTabConfig r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
        Intrinsics.checkNotNullParameter(r3, "metaInfo");
        c.a.b(r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void M(int r3, int r4) {
        Map<Integer, Integer> r0 = this.d;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Integer r2 = (Integer) r1.get(Integer.valueOf(r3));
        Map<Integer, Integer> r5 = this.d;
        Integer r6 = Integer.valueOf(r3);
        if (r2 == null) goto L5;
        int r7 = r2.intValue();
    L6:
        r5.put(r6, Integer.valueOf(RangesKt.coerceAtLeast(r7, r4)));
        return;
    L5:
        r7 = 0;
        goto L6
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
    public final void r(int r2, int r3) {
        if (this.d.containsKey(Integer.valueOf(r3)) == true) goto L6;
        this.d.put(Integer.valueOf(r3), 0);
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void G(ECStoreParam r2, ECStoreTabAreaVO r3, ECStoreHomeTabResponseTabkit r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "tabData");
        Intrinsics.checkNotNullParameter(r4, "response");
        c.a.j(r2, r3, r4);
        uj3.j r5 = t.b(r2, r3);
        if (r5 == null) goto L6;
        this.b = Integer.valueOf(r5.d).intValue();
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void J(ECStoreViewModel r8, ECStoreParam r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        Intrinsics.checkNotNullParameter(r9, "storeParam");
        c.a.e(r8, r9);
        Map<Long, m> r11 = a.a;
        ECStoreParam r12 = this.a;
        if (r12 == null) goto L5;
        Long r13 = Long.valueOf(r12.getLifecycleMonitorId());
    L6:
        s r0 = a.b(r13);
        if (r0 == null) goto L42;
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r1 = ((ArrayList) this.c).iterator();
    L10:
        if (r1.hasNext() == false) goto L21;
        i r2 = (i) r1.next();
        if (r2 == null) goto L14;
        Integer r3 = Integer.valueOf(r2.a);
    L15:
        String r4 = String.valueOf(r3.intValue());
        if (r4 == null) goto L10;
        Integer r5 = (Integer) r14.get(r4);
        int r6 = 0;
        if (r5 == null) goto L20;
        r6 = 0 | r5.intValue();
    L20:
        r14.put(r4, Integer.valueOf(r6 + 1));
        goto L10
    L14:
        r3 = null;
        goto L15
    L21:
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r7 = ((LinkedHashMap) this.d).entrySet().iterator();
        float r16 = 0.0f;
    L23:
        if (r7.hasNext() == false) goto L27;
        Map.Entry r17 = (Map.Entry) r7.next();
        if (r10 <= 0) goto L23;
        float r18 = (((Number) r17.getValue()).intValue() / r10) + 1;
        r16 = r16 + r18;
        r15.put(r17.getKey(), Float.valueOf(r18));
        goto L23
    L27:
        JSONObject r19 = new JSONObject();
        r19.put("action_count", ((ArrayList) this.c).size());
        r19.put("tab_action_count", u0.d(r14));
        r19.put("action_deep", Float.valueOf(r16));
        r19.put("tab_action_deep", u0.d(r15));
        if (ECAppInfoService.e.i() == false) goto L30;
        r19.put("event_debug_details", u0.d(this.c));
    L30:
        s.c(r0, "ec_perf_shop_actions", null, this.a, r19, null, 50);
        return;
    L42:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void P(String r8, Map<String, ? extends Object> r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r8, "eventName");
        com.bytedance.android.ec.store.setting.a r0 = (com.bytedance.android.ec.store.setting.a) ECStoreSettings.c.getValue();
        if (r0 == null) goto L47;
        Set r1 = r0.a();
        if (r1 == null) goto L48;
        boolean r2 = true;
        if (r1.contains(r8) != true) goto L49;
        Map r3 = r0.b();
        if (r3 == null) goto L36;
        List r4 = (List) r3.get(r8);
        if (r4 == null) goto L36;
        Iterator r5 = r4.iterator();
    L13:
        boolean r6 = false;
        if (r5.hasNext() == false) goto L33;
        Iterator r7 = ((Map) r5.next()).entrySet().iterator();
    L17:
        if (r7.hasNext() == false) goto L30;
        Map.Entry r11 = (Map.Entry) r7.next();
        String r12 = (String) r11.getKey();
        if (r9 == null) goto L21;
        String r13 = String.valueOf(r9.get(r12));
    L28:
        if ((!Intrinsics.areEqual(r13, (String) r11.getValue())) == false) goto L17;
    L31:
        if (r6 == false) goto L13;
    L34:
        if (r2 == true) goto L50;
        ((ArrayList) this.c).add(new i(this.b, r8));
        return;
    L50:
        return;
    L21:
        if (r10 != null) goto L38;
    L26:
        r13 = null;
        goto L28
    L38:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L24
        r13 = JSONObjectProtectorUtils.getString(r10, r12);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L30:
        r6 = true;
        goto L31
    L33:
        r2 = false;
    L36:
        ((ArrayList) this.c).add(new i(this.b, r8));
        return;
    L49:
        return;
    L48:
        return;
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
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r1, StoreTabConfig r2, ECStoreParam r3, JSONObject r4, JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        c.a.g(r1, r3);
    }
}
