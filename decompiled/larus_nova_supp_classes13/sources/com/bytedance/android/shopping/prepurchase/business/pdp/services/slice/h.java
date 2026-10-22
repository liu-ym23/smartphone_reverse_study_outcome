package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2.j1;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.PdpRootComponent$dependency$1;
import com.bytedance.android.shopping.utils.a0;
import com.google.gson.internal.LinkedTreeMap;
import fi3.w0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j73.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vg3.f0;
import vg3.q;
import vg3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements j73.d, j73.h, j73.l, j73.b, m, j73.j, j73.e, j73.f {
    public final Function0<j73.g> a;
    public final Function0<j73.c> b;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j c;
    public final /* synthetic */ j73.h d;
    public final /* synthetic */ j73.l e;
    public final /* synthetic */ j73.b f;
    public final /* synthetic */ m g;
    public final /* synthetic */ j73.j h;
    public final /* synthetic */ j73.e i;
    public final /* synthetic */ j73.f j;

    public final Map<String, Object> A() {
        return this.h.A();
    }

    public final Integer B() {
        return this.f.B();
    }

    public final boolean E() {
        return this.h.E();
    }

    public final void F(String r2, a0 r3) {
        Intrinsics.checkNotNullParameter(r2, "skuSessionId");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.g.F(r2, r3);
    }

    public final void H(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "label");
        Intrinsics.checkNotNullParameter(r3, "map");
        this.d.H(r2, r3);
    }

    public final boolean I() {
        return this.g.I();
    }

    public final void J(List<com.bytedance.android.ecom.arch.slice.adapter.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.h.J(r2);
    }

    public final void K(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.h.K(r2);
    }

    public final void K1(StatTagItem r2, int r3, Integer r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "tagItem");
        this.f.K1(r2, r3, r4, r5);
    }

    public final PdpSliceLocalCacheHelper M() {
        return this.j.M();
    }

    public final void O() {
        this.i.O();
    }

    public final SkuRestoreState P() {
        return this.g.P();
    }

    public final void Q() {
        this.e.Q();
    }

    public final void R(List<String> r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.j.R(r2, r3);
    }

    public final void S(String r2) {
        Intrinsics.checkNotNullParameter(r2, "specId");
        this.g.S(r2);
    }

    public final void T(Map<String, ? extends Object> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.e.T(r2, r3);
    }

    public final void U(boolean r2) {
        this.e.U(true);
    }

    public final void V(Map r3, Map r4, boolean r5, Function1 r6) {
        Intrinsics.checkNotNullParameter("custom_action_refresh", "refreshType");
        this.e.V(r3, r4, r5, r6);
    }

    public final boolean X() {
        return this.g.X();
    }

    public final void Z() {
        this.f.Z();
    }

    public final CommonMeta a() {
        return this.e.a();
    }

    public final LinkedTreeMap<String, Object> b() {
        return this.e.b();
    }

    public final HashMap<String, Boolean> b0() {
        return this.i.b0();
    }

    public final AnchorV4Param c() {
        return this.f.c();
    }

    public final void c0(w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.i.c0(r2);
    }

    public final CompositeDisposable compositeDisposable() {
        return this.f.compositeDisposable();
    }

    public final void d0(int r2) {
        this.g.d0(r2);
    }

    public final boolean e() {
        return this.f.e();
    }

    public final void e0(SkuRestoreState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.g.e0(r2);
    }

    public final String f() {
        return this.e.f();
    }

    public final void f0() {
        this.g.f0();
    }

    public final void g(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.f.g(r2);
    }

    public Context getContext() {
        return this.f.getContext();
    }

    public final long getDuration() {
        return this.f.getDuration();
    }

    public final FragmentManager getFragmentManager() {
        return this.f.getFragmentManager();
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f.getLifecycleOwner();
    }

    public final PageFinder getPageFinder() {
        return this.d.getPageFinder();
    }

    public final String getSessionId() {
        return this.f.getSessionId();
    }

    public final boolean h0() {
        return this.g.h0();
    }

    public final void i0() {
        this.i.i0();
    }

    public final boolean isExpanded() {
        return this.f.isExpanded();
    }

    public final void j0(Function1<? super Map<String, ? extends Object>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "calcCB");
        this.h.j0(r2);
    }

    public final void l(SkuProductDetailInfo r2) {
        this.g.l(r2);
    }

    public final Map<String, Object> l0() {
        return this.h.l0();
    }

    public final UserInteractFrameLayout m0() {
        return this.f.m0();
    }

    public final void n(String r9, Map<String, ? extends Object> r10, boolean r11, boolean r12, String r13, PageFinder r14) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        this.d.n(r9, r10, r11, r12, r13, r14);
    }

    public final void n0(boolean r2) {
        this.g.n0(false);
    }

    public final Map<String, String> o0() {
        return this.h.o0();
    }

    public final long p() {
        return this.f.p();
    }

    public final void p0(boolean r2) {
        this.h.p0(r2);
    }

    public final void q(SkuRestoreState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.g.q(r2, r3);
    }

    public final void q0(boolean r2) {
        this.h.q0(r2);
    }

    public final int r() {
        return this.f.r();
    }

    public final boolean t0(String r2, String r3, View r4, com.bytedance.android.ecom.arch.slice.g r5) {
        Intrinsics.checkNotNullParameter(r2, "indexName");
        Intrinsics.checkNotNullParameter(r3, "indexType");
        return this.j.t0(r2, r3, r4, r5);
    }

    public final void u0(int r2) {
        this.h.u0(r2);
    }

    public final void v() {
        this.g.v();
    }

    public final V4NativeParams w() {
        return this.f.w();
    }

    public final Map<String, Object> x() {
        return this.h.x();
    }

    public final void y() {
        this.i.y();
    }

    public final void z() {
        this.g.z();
    }

    public final BottomButtonMeta D() {
        j73.c r0 = (j73.c) this.b.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.D();
    }

    public final hn.c G() {
        q r0 = (q) this.c.getService(q.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.G();
    }

    public final int W() {
        j73.c r0 = (j73.c) this.b.invoke();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.W();
    }

    public final Boolean d() {
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final Boolean i() {
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i();
    }

    public final com.bytedance.android.shopping.anchorv3.i j() {
        q r0 = (q) this.c.getService(q.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    public final boolean k0() {
        j73.c r0 = (j73.c) this.b.invoke();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.k0() != true) goto L7;
        return true;
    }

    public final Pair<com.bytedance.android.shopping.anchorv3.i, com.bytedance.android.shopping.anchorv3.widget.f> r0() {
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 == null) goto L7;
        Pair<com.bytedance.android.shopping.anchorv3.i, com.bytedance.android.shopping.anchorv3.widget.f> r1 = r0.r0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new Pair(null, null);
    }

    public final boolean u() {
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.u() != true) goto L7;
        return true;
    }

    public final void C(String r2) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 == null) goto L6;
        r0.C(r2);
        return;
    }

    public final View L(String r3) {
        Intrinsics.checkNotNullParameter(r3, "pendentId");
        vg3.a0 r0 = (vg3.a0) this.c.getService(vg3.a0.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.L(r3);
    }

    public final void N(int r2) {
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 == null) goto L6;
        r0.N(r2);
        return;
    }

    public final void Y(JSONObject r3) {
        Intrinsics.checkNotNullParameter("edit_cart_combo_num", "eventName");
        j73.c r0 = (j73.c) this.b.invoke();
        if (r0 == null) goto L6;
        r0.Y(r3);
        return;
    }

    public final void h(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extraElementId");
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    public final void k(SkuRestoreState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        j73.c r0 = (j73.c) this.b.invoke();
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }

    public final void s(boolean r2) {
        j73.g r0 = (j73.g) this.a.invoke();
        if (r0 == null) goto L6;
        r0.s(r2);
        return;
    }

    public final void s0(fi3.q r2) {
        j73.c r0 = (j73.c) this.b.invoke();
        if (r0 == null) goto L6;
        r0.s0(r2);
        return;
    }

    public final void t(b0 r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        vg3.l r0 = (vg3.l) this.c.getService(vg3.l.class);
        if (r0 == null) goto L6;
        r0.t(r3);
        return;
    }

    public final void openSchema(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "string");
        f0 r4 = (f0) this.c.getService(f0.class);
        if (r4 == null) goto L6;
        r4.openSchema(r3);
        return;
    }

    public final void g0(long r8, long r10, j1 r12) {
        Intrinsics.checkNotNullParameter(r12, "listener");
        vg3.h r1 = (vg3.h) this.c.getService(vg3.h.class);
        if (r1 == null) goto L6;
        r1.K0(r8, r10, r12);
        return;
    }

    public final void o(String r3, Map<String, Object> r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "queryParams");
        u r0 = (u) this.c.getService(u.class);
        if (r0 == null) goto L6;
        r0.o(r3, r4, r5);
        return;
    }

    public final void a0(View r3, String r4, Map<String, ? extends Object> r5, Map<String, ? extends Object> r6) {
        vg3.l r0 = (vg3.l) this.c.getService(vg3.l.class);
        if (r0 == null) goto L6;
        r0.z(r3, r4, r5, r6);
        return;
    }

    public h(i r2, g r3, PdpRootComponent$dependency$1 r4, m r5, Function0 r6, Function0 r7, j73.j r8, j73.e r9, com.bytedance.android.shopping.prepurchase.arch.container.component.j r10, j73.f r11) {
        Intrinsics.checkNotNullParameter(r2, "eventAbility");
        Intrinsics.checkNotNullParameter(r3, "dataDependency");
        Intrinsics.checkNotNullParameter(r4, "containerDependency");
        Intrinsics.checkNotNullParameter(r5, "skuEventChainDependency");
        Intrinsics.checkNotNullParameter(r6, "topEventChainDependency");
        Intrinsics.checkNotNullParameter(r7, "bottomEventChainDependency");
        Intrinsics.checkNotNullParameter(r8, "instantDependency");
        Intrinsics.checkNotNullParameter(r9, "mainFeedDependency");
        Intrinsics.checkNotNullParameter(r10, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r11, "dynamicFeatureDependency");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r8;
        this.i = r9;
        this.j = r11;
        this.a = r6;
        this.b = r7;
        this.c = r10;
    }
}
