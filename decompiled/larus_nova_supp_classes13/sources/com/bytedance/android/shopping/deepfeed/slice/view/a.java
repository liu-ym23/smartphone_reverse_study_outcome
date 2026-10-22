package com.bytedance.android.shopping.deepfeed.slice.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.slice.action.n;
import com.bytedance.android.shopping.deepfeed.slice.action.s;
import com.bytedance.android.shopping.deepfeed.slice.action.t;
import com.bytedance.android.shopping.deepfeed.slice.action.u;
import com.bytedance.android.shopping.deepfeed.slice.action.v;
import com.bytedance.android.shopping.deepfeed.slice.action.w;
import com.bytedance.android.shopping.deepfeed.slice.g;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.utlis.DataUtilsKt$createDefaultIAction$1;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.deepfeed.ui.c, w, u, com.bytedance.android.shopping.deepfeed.slice.service.b {
    public final String a;
    public ViewGroup b;
    public com.bytedance.android.shopping.deepfeed.slice.a c;
    public boolean d;
    public t e;
    public w f;
    public final Map<String, Object> g;
    public final Map<String, Object> h;
    public final Map<String, v> i;
    public ValueAnimator j;
    public int k;
    public final b l;
    public final wc3.b m;
    public final View n;
    public final Fragment o;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.a$a, reason: collision with other inner class name */
    public static final class C0053a {
    }

    static {
    }

    public final Map<String, Object> E() {
        Pair[] r0 = new Pair[3];
        DeepFeedFoldHelper.f();
        r0[0] = TuplesKt.to("is_fold", Boolean.FALSE);
        r0[1] = TuplesKt.to("screen_width", Integer.valueOf(DeepFeedFoldHelper.c(this.o.getContext())));
        nj.d r1 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r1 == null) goto L5;
        r1.isPad();
    L5:
        r0[2] = TuplesKt.to("is_pad", false);
        return MapsKt.mapOf(r0);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void H() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void J(int r1, int r2, boolean r3, boolean r4) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final int L() {
        return 0;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void N(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void Q() {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.u
    public final void a() {
        this.d = true;
        Lazy r0 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(this.o.getActivity());
        FragmentActivity r1 = this.o.getActivity();
        if (r1 == null) goto L6;
        r1.finish();
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxUrl");
        Intrinsics.checkNotNullParameter(r3, "popupType");
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void l(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void p(int r1, int r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean v() {
        return false;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void z(int r1, String r2) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final DeepFeedProductEventTracker A() {
        w r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.A();
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void B() {
        this.g.put("config", E());
        D();
    }

    public final void D() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.g);
        r0.put("state", this.h);
        com.bytedance.android.shopping.deepfeed.slice.a r1 = this.c;
        if (r1 == null) goto L6;
        r1.updateData(r0);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final com.bytedance.android.shopping.deepfeed.action.d c() {
        w r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final boolean i() {
        w r0 = this.f;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.i();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.b q() {
        w r0 = this.f;
        if (r0 == null) goto L7;
        vc3.b r1 = r0.q();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new vc3.b(null);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final LifecycleOwner k() {
        return this.o;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final boolean o() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.y
    public final void C(Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "model");
        int r0 = xc3.a.a;
        Map<String, Object> r1 = this.g;
        Map<String, Object> r2 = this.h;
        Intrinsics.checkNotNullParameter(r1, "nonStateMap");
        Intrinsics.checkNotNullParameter(r2, "stateMap");
        Intrinsics.checkNotNullParameter(r8, "data");
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r4 = r8.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r5 = r4.next();
        if ((!Intrinsics.areEqual(r5.getKey(), "state")) == false) goto L4;
        r3.put(r5.getKey(), r5.getValue());
        goto L4
    L9:
        if ((!r3.isEmpty()) == false) goto L11;
        xc3.a.a(r1, r3);
    L11:
        Object r9 = r8.get("state");
        if ((r9 instanceof Map) == true) goto L14;
        r9 = null;
    L14:
        Map r10 = (Map) r9;
        if (r10 == null) goto L17;
        xc3.a.a(r2, r10);
    L17:
        D();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void I(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r2, "list");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void K(com.bytedance.android.shopping.deepfeed.slice.service.a r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(r2, "lifecycleObserver");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void M(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void P(com.bytedance.android.shopping.deepfeed.slice.service.a r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleObserver");
        Intrinsics.checkNotNullParameter(r2, "lifecycleObserver");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void b(boolean r2) {
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void e(float r2) {
        Map<? extends String, ? extends Object> r3 = MapsKt.mapOf(TuplesKt.to("shop_alpha", Float.valueOf(r2)));
        this.h.putAll(r3);
        D();
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.c j(vc3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        w r0 = this.f;
        if (r0 == null) goto L7;
        vc3.c r11 = r0.j(r10);
        if (r11 == null) goto L7;
        return r11;
    L7:
        return new vc3.c(null, 0, null, null, null, null, null, "");
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final v r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        v r0 = this.i.get(r2);
        if (r0 != null) goto L9;
        w r1 = this.f;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.r(r2);
    L9:
        return r0;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final String s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        w r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.s(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void t(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        r2.invoke(null);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void w(int r2) {
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.w(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void x(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "afterAction");
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.x(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void y(boolean r2) {
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.y(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void h(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "viewName");
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void m(Boolean r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "targetView");
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.m(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void u(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mainArea");
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.u(r2, r3);
        return;
    }

    public a(com.bytedance.android.shopping.deepfeed.slice.e r2, View r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "slcManager");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.a = "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/eccs/gecko/resource/ecom_deep_feed_template/top_bar_card/main.json";
        LinkedHashMap r5 = new LinkedHashMap();
        this.g = r5;
        this.h = new LinkedHashMap();
        LinkedHashMap r6 = new LinkedHashMap();
        this.i = r6;
        this.k = -1;
        this.l = new b(this);
        r6.put("UpdateModel", new s(this));
        r6.put("PageFinish", new n(this));
        r6.put("EventChain", new com.bytedance.android.shopping.deepfeed.slice.action.e(this));
        r5.putAll(MapsKt.mapOf(TuplesKt.to("config", E())));
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.service.b
    public final void O(String r3, Map<String, ? extends Object> r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "actionName");
        DataUtilsKt$createDefaultIAction$1 r0 = new DataUtilsKt$createDefaultIAction$1(r3, r4);
        v r6 = this.l.a(r3);
        if (r6 == null) goto L6;
        r6.m(r0, r5);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final void d(String r2, List<String> r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r3, "featureInfoList");
        Intrinsics.checkNotNullParameter(r4, "targetView");
        w r0 = this.f;
        if (r0 == null) goto L6;
        r0.d(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.c
    public final void f(DeepFeedProductViewModel r7, com.bytedance.android.shopping.deepfeed.action.b r8, Function0<? extends AbsDeepFeedProductVH> r9) {
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        Intrinsics.checkNotNullParameter(r8, "deepFeedContext");
        Intrinsics.checkNotNullParameter(r9, "curVH");
        ViewGroup r10 = (ViewGroup) this.n.findViewById(2131386879);
        if (r10 == null) goto L5;
        this.b = r10;
    L5:
        ViewGroup r4 = this.b;
        if (r4 == null) goto L27;
        r4.removeAllViews();
        com.bytedance.android.shopping.deepfeed.slice.a r11 = new com.bytedance.android.shopping.deepfeed.slice.a(this.m, UUID.randomUUID().toString());
        this.c = r11;
        Map<String, LinkedTreeMap<String, Object>> r0 = g.a;
        g r1 = (g) ((LinkedHashMap) g.a.a()).get("top_bar_card");
        if (r1 == null) goto L17;
        String r2 = r1.c();
        if (r2 == null) goto L17;
        if (r2.length() <= 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
    L18:
        r11.a(new com.bytedance.android.shopping.deepfeed.slice.b(r2, "top_bar_card", "1.0.0", r4, this.l));
        com.bytedance.android.shopping.deepfeed.slice.a r12 = this.c;
        if (r12 == null) goto L25;
        Intrinsics.checkNotNullParameter(this, "service");
        r r13 = r12.a;
        if (r13 == null) goto L25;
        SlcTemplateContext r14 = r13.b;
        if (r14 == null) goto L25;
        r14.s(com.bytedance.android.shopping.deepfeed.slice.service.b.class, this);
    L25:
        Function1<com.bytedance.android.shopping.deepfeed.data.e, Unit> r15 = new DeepFeedSlcTopBar$slcListener$1(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r15, "listener");
        Intrinsics.checkNotNullParameter(r15, "listener");
        return;
    L14:
        r3 = false;
    L17:
        r2 = this.a;
        goto L18
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.w
    public final vc3.a n(String r9, String r10, String r11, boolean r12, View r13) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "area");
        Intrinsics.checkNotNullParameter(r11, "btm");
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        w r1 = this.f;
        if (r1 == null) goto L7;
        vc3.a r14 = r1.n(r9, r10, r11, r12, r13);
        if (r14 == null) goto L7;
        return r14;
    L7:
        return new vc3.a(null, null, 0, null, null, null, null);
    }
}
