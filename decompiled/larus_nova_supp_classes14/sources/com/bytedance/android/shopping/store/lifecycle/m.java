package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements c {
    public final List<c> a;
    public final ECStorePerfMonitor b;
    public final o c;
    public final String d;

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void C() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).C();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void H() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).H();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void K() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).K();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void O() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).O();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void T() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).T();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).b();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void f() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).f();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void g() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).g();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void j() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).j();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void l() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).l();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void n() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).n();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onPause() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onPause();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void t() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).t();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void v() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).v();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void w() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).w();
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void y() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).y();
        goto L4
    }

    public m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entranceClassName");
        this.d = r2;
        this.a = new ArrayList();
        ECStorePerfMonitor r0 = new ECStorePerfMonitor(r2);
        this.b = r0;
        o r3 = new o();
        this.c = r3;
        U(r0);
        U(r3);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void A(ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).A(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void L(f r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).L(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void N(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).N(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void Q(ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).Q(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void R(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).R(r3);
        goto L4
    }

    public final void U(c r2) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycle");
        ((ArrayList) this.a).add(r2);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void c(StoreTabConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "tabConfig");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).c(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void e(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).e(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void h(ECStorePreloadInfoResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "preloadInfo");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).h(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void i(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).i(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void k(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).k(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void m(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "preContext");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).m(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void o(ECShopHeadInfoBlock r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).o(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onResume(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).onResume(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void s(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).s(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void x(StoreTabConfig r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).x(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void z(ECStorePreloadInfoResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "preloadInfo");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).z(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void F(uj3.j r3, long r4) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).F(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void I(StoreTabConfig r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "tabConfig");
        Intrinsics.checkNotNullParameter(r4, "metaInfo");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).I(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void M(int r3, int r4) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).M(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void S(int r3, ECHybridListAdapter r4) {
        Intrinsics.checkNotNullParameter(r4, "listAdapter");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).S(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void d(Throwable r3, CommerceBaseResponse r4) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).d(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void q(Context r3, ECStoreParam r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).q(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void r(int r3, int r4) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).r(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void G(ECStoreParam r3, ECStoreTabAreaVO r4, ECStoreHomeTabResponseTabkit r5) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "tabData");
        Intrinsics.checkNotNullParameter(r5, "response");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).G(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void J(ECStoreViewModel r3, ECStoreParam r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).J(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void P(String r3, Map<String, ? extends Object> r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).P(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void p(StoreTabConfig r3, JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "filterParams");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).p(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void u(ECStoreParam r3, com.bytedance.android.shopping.store.home.entity.n r4, CommerceBaseResponse r5) {
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "infoData");
        Intrinsics.checkNotNullParameter(r5, "response");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).u(r3, r4, r5);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void B(Context r3, ECStoreParam r4, JSONObject r5, PageType r6) {
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        Intrinsics.checkNotNullParameter(r6, "pageType");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).B(r3, r4, r5, r6);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r10, StoreTabConfig r11, ECStoreParam r12, JSONObject r13, JSONObject r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r12, "storeParam");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((c) r0.next()).E(r10, r11, r12, r13, r14, r15);
        goto L4
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void D(StoreTabConfig r13, int r14, int r15, Integer r16, Integer r17, String r18, String r19, String r20) {
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((c) r1.next()).D(r13, r14, r15, r16, r17, r18, r19, r20);
        goto L4
    }
}
