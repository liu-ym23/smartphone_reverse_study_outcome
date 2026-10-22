package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.cart_common.keyboard_manager.CommonPopupKeyBoardManager$onAttach$$inlined$apply$lambda$1;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.t;
import com.bytedance.android.shopping.new_cart.eventcenter.event.ScrollMode;
import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.viewmodel.QueryScene;
import com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.util.u;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartPageCallBackComponent extends com.bytedance.android.shopping.new_cart.components.a {
    public final FrameLayout A;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final CartViewModel d;
    public final AtomicLong e;
    public boolean f;
    public boolean g;
    public String h;
    public com.bytedance.android.shopping.cart_common.keyboard_manager.b i;
    public RecyclerView j;
    public final long k;
    public final Function0<Unit> l;
    public final Function0<Unit> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final WeakHashMap<View, RecyclerView.OnScrollListener> w;
    public final CartObjectContainer x;
    public final String y;
    public final CartParams z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ CartPageCallBackComponent a;

        public a(CartPageCallBackComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            com.bytedance.android.shopping.new_cart.viewmodel.d r6 = (com.bytedance.android.shopping.new_cart.viewmodel.d) r5;
            CartPageCallBackComponent r0 = this.a;
            boolean r1 = Intrinsics.areEqual(r6.a, "first_enter");
            String r7 = r6.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r7, "scene");
            com.bytedance.android.shopping.new_cart.utils.a.f(new k(r0, r7, r1, null));
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CartPageCallBackComponent a;

        public b(CartPageCallBackComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            com.bytedance.android.shopping.new_cart.viewmodel.c r5 = (com.bytedance.android.shopping.new_cart.viewmodel.c) r4;
            CartPageCallBackComponent r0 = this.a;
            String r1 = r5.a;
            com.bytedance.kmp.ec.yata.common.protocol.data.e r2 = r5.b;
            if (r2 == null) goto L5;
            boolean r3 = com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r2);
        L6:
            r0.u(r1, r3, r5.b);
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CartPageCallBackComponent a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.protocol.data.e d;

        public c(CartPageCallBackComponent r1, boolean r2, boolean r3, com.bytedance.kmp.ec.yata.common.protocol.data.e r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            if (this.a.f == true) goto L5;
        L37:
            CartBodyComponent r1 = this.a.p();
            if (r1 == null) goto L41;
            r1.n();
        L41:
            if (this.c == false) goto L56;
            com.bytedance.android.shopping.new_cart.components.d r0 = (com.bytedance.android.shopping.new_cart.components.d) this.a.s.getValue();
            if (r0 == null) goto L50;
            r0.c = false;
            ECCartErrorView r2 = r0.b;
            if (r2 == null) goto L50;
            com.bytedance.android.shopping.new_cart.widgets.c r3 = new com.bytedance.android.shopping.new_cart.widgets.c(r2);
            if (u.a() == false) goto L49;
            r3.run();
            goto L50
        L49:
            r2.a.post(r3);
        L50:
            CartPageCallBackComponent r4 = this.a;
            if (r4.g == true) goto L55;
            Context r5 = r4.e();
            if (r5 == null) goto L55;
            this.a.d.queryForCoupon(r5);
        L55:
            this.a.g = true;
        L92:
            CartPageCallBackComponent r6 = this.a;
            r6.f = false;
            vf3.a r7 = r6.d.getMultiUpdateImpl();
            if (r7 == null) goto L107;
            boolean r8 = this.c;
            dm.a.a("cart MultiUpdateImpl").i("onQueryEnd: success: " + r8 + "，enable: " + r7.b + ", hitClick: " + r7.n());
            if (r7.b == true) goto L98;
            return;
        L98:
            if (r7.n() == false) goto L110;
            if (r8 == true) goto L108;
            r7.q();
            return;
        L108:
            return;
        L110:
            return;
        L107:
            return;
        L56:
            CartPageCallBackComponent r9 = this.a;
            if (r9.f == true) goto L59;
        L103:
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L79
            JSONObject r11 = new JSONObject();     // Catch: Throwable -> L79
            r11.put("event_type", "error_show");     // Catch: Throwable -> L79
            r11.put("is_first_screen", this.a.f);     // Catch: Throwable -> L79
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L79
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L79
            r13.put("duration", System.currentTimeMillis() - this.a.k);     // Catch: Throwable -> L79
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L79
            r14.put("duration", System.currentTimeMillis() - this.a.k);     // Catch: Throwable -> L79
            ApmAgent.monitorEvent("cart_error_show_android", r11, r13, r14);     // Catch: Throwable -> L79
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L79
        L81:
            com.bytedance.kmp.ec.yata.common.protocol.data.e r15 = this.d;
            if (r15 == null) goto L85;
            String r16 = r15.b();
            if (r16 == null) goto L85;
        L86:
            String r17 = r16;
            Context r18 = this.a.e();
            if (r18 == null) goto L89;
            ECToast.showToast$default(ECToast.INSTANCE, r18, r17, null, 4, null);
        L89:
            CartLoadMoreComponent r19 = (CartLoadMoreComponent) this.a.r.getValue();
            if (r19 == null) goto L92;
            r19.b = false;
        L85:
            r16 = "网络错误";
        L79:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L81
        L59:
            if (r9.x.e.l.b == true) goto L103;
            CartBackToTopBtnManageComponent r21 = (CartBackToTopBtnManageComponent) r9.v.getValue();
            if (r21 == null) goto L63;
            r21.n(false);
        L63:
            com.bytedance.android.shopping.new_cart.components.d r22 = (com.bytedance.android.shopping.new_cart.components.d) this.a.s.getValue();
            if (r22 == null) goto L103;
            r22.c = true;
            if (r22.b != null) goto L70;
            com.bytedance.android.shopping.new_cart.utils.a.c.d("initErrorView", new com.bytedance.android.shopping.new_cart.components.c(r22));
            ECCartErrorView r23 = r22.b;
            if (r23 == null) goto L70;
            r23.setCallback(r22);
        L70:
            bg3.a r24 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.g(r22.a.d, "ErrorView-Show", "", MapsKt.emptyMap());
            ECCartErrorView r25 = r22.b;
            if (r25 == null) goto L103;
            com.bytedance.android.shopping.new_cart.widgets.d r26 = new com.bytedance.android.shopping.new_cart.widgets.d(r25);
            if (u.a() == false) goto L75;
            r26.run();
        L76:
            com.bytedance.android.shopping.new_cart.utils.a.e(1000, new com.bytedance.android.shopping.new_cart.widgets.e(r25));
            goto L103
        L75:
            r25.a.post(r26);
            goto L76
        L5:
            if (this.b == true) goto L37;
            if (this.c == false) goto L9;
            ECCartMonitorReporter.b r27 = ECCartMonitorReporter.b.C0126b.c;
        L10:
            int r28 = ECCartMonitorReporter.d;
            ECCartMonitorReporter r29 = ECCartMonitorReporter.a.a();
            String r30 = BtmSDK.INSTANCE.obtainEventBtmParams(new BtmItemBuilder(null, null, 3, null).withBtmPage(this.a.e()).build());
            r29.getClass();
            Intrinsics.checkNotNullParameter(r27, "result");
            Map r31 = com.bytedance.android.ec.core.monitor.c.a;
            MonitorScenes r32 = MonitorScenes.EC_PERF_PAGE_SHOW_CART;
            LinkedHashMap r33 = new LinkedHashMap();
            r33.put("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
            r33.put("area_type", "104");
            r33.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_cart_page");
            r33.put("status", String.valueOf(r27.a));
            String r34 = r27.b;
            if (r34 != null) goto L13;
            r34 = "";
        L13:
            r33.put("error_msg", r34);
            if (r30 == null) goto L16;
            r33.put("btm_id", r30);
        L16:
            Unit r35 = Unit.INSTANCE;
            com.bytedance.android.ec.core.monitor.c.b(r32, null, r33);
            Map<String, Map<String, Long>> r36 = yf3.b.a;
            String r37 = this.a.y;
            boolean r38 = this.c;
            Intrinsics.checkNotNullParameter(r37, "sessionId");
            LinkedHashMap r39 = (LinkedHashMap) yf3.b.a;
            if (((Map) r39.get(r37)) == null) goto L37;
            Long r40 = (Long) ((LinkedHashMap) yf3.b.c).get(r37);
            if (r40 == null) goto L37;
            r40.longValue();
            if (((Map) ((LinkedHashMap) yf3.b.b).get(r37)) == null) goto L37;
            yf3.b.a(r37, "FirstScreenEnd");
            bg3.a r41 = com.bytedance.android.shopping.new_cart.utils.a.a;
            Map r42 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("biz", "yata_cart")});
            r42.put("first_screen_perf", r39.get(r37));
            Map r43 = (Map) r39.get(r37);
            if (r43 == null) goto L30;
            Iterator r44 = r43.entrySet().iterator();
        L28:
            if (r44.hasNext() == false) goto L30;
            Map.Entry r110 = (Map.Entry) r44.next();
            r42.put("FCP_" + ((String) r110.getKey()), r110.getValue());
        L30:
            Map r45 = (Map) ((LinkedHashMap) yf3.b.b).get(r37);
            if (r45 == null) goto L36;
            Iterator r46 = r45.entrySet().iterator();
        L34:
            if (r46.hasNext() == false) goto L36;
            Map.Entry r111 = (Map.Entry) r46.next();
            r42.put(r111.getKey(), r111.getValue());
        L36:
            r42.put("is_normal", Boolean.valueOf(r38));
            Unit r47 = Unit.INSTANCE;
            r41.a("cart_first_screen_perf_monitor", r42, null, null);
            yf3.b.a.remove(r37);
            yf3.b.c.remove(r37);
            yf3.b.b.remove(r37);
            goto L37
        L9:
            r27 = new ECCartMonitorReporter.b.a.C0125a();
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CartPageCallBackComponent a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.biz.callback.a c;

        public d(CartPageCallBackComponent r1, String r2, com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartLoadingComponent r0 = CartPageCallBackComponent.o(this.a);     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.p(this.b, this.c);     // Catch: Throwable -> L7
        L5:
            this.a.e.set(-1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public final CartBodyComponent p() {
        return (CartBodyComponent) this.q.getValue();
    }

    public final f q() {
        return (f) this.t.getValue();
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        this.d.getOnQueryStartLiveData().observe(f(), new a(this));
        this.d.getOnQueryEndLiveData().observe(f(), new b(this));
    }

    public final void s() {
        com.bytedance.android.shopping.new_cart.container.b r0 = this.x.e;
        if (r0.l.c == false) goto L52;
        Map<String, ?> r1 = r0.a();
        if (r1 == null) goto L7;
        Object r2 = r1.get("is_anchor_optimize");
    L9:
        if ((r2 instanceof Boolean) == true) goto L11;
        r2 = null;
    L11:
        Boolean r3 = (Boolean) r2;
        int r4 = 0;
        if (r3 == null) goto L14;
        boolean r5 = r3.booleanValue();
    L15:
        CartParams r6 = this.z;
        if (r6 == null) goto L46;
        String r7 = r6.getAnchorCartId();
        if (r7 == null) goto L46;
        if (com.bytedance.android.shopping.extensions.k.c(r7) != true) goto L46;
        if (r5 == false) goto L23;
        return;
    L23:
        List r8 = ((AndroidYaTaInstance) this.x.e.d.invoke()).n("body");
        if (r8 == null) goto L53;
        Iterator r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L42;
        p r10 = ((com.bytedance.kmp.ec.yata.store.node.c) r9.next()).b.b;
        if (r10 == null) goto L34;
        Object r11 = q.b(r10, Reflection.getOrCreateKotlinClass(Map.class), "basic_info");
        if ((r11 instanceof Map) == true) goto L33;
        r11 = null;
    L33:
        Map r12 = (Map) r11;
    L35:
        if (r12 == null) goto L37;
        Object r13 = r12.get("cart_id");
    L39:
        if (Intrinsics.areEqual(String.valueOf(r13), this.z.getAnchorCartId()) == true) goto L43;
        r4 = r4 + 1;
    L43:
        CartBodyComponent r14 = p();
        if (r14 == null) goto L54;
        r14.r(r4, ScrollMode.CENTER);
        return;
    L54:
        return;
    L37:
        r13 = null;
        goto L39
    L34:
        r12 = null;
        goto L35
    L42:
        r4 = -1;
        goto L43
    L53:
        return;
    L46:
        CartBodyComponent r15 = p();
        if (r15 == null) goto L56;
        r15.s();
        return;
    L56:
        return;
    L14:
        r5 = false;
        goto L15
    L7:
        r2 = null;
        goto L9
    }

    public final Integer r() {
        f r0 = q();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.n());
    }

    public static final void n(CartPageCallBackComponent r2) {
        CartSliceCustomWidgetAdapterComponent r0 = (CartSliceCustomWidgetAdapterComponent) r2.n.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d != true) goto L15;
        com.bytedance.android.shopping.new_cart.yata.customdata.a r1 = r2.d.getCustomDataCenter();
        if (r1 == null) goto L9;
        r1.c(Boolean.FALSE);
    L9:
        CartSliceCustomWidgetAdapterComponent r3 = (CartSliceCustomWidgetAdapterComponent) r2.n.getValue();
        if (r3 == null) goto L12;
        r3.d = false;
    L12:
        ((AndroidYaTaInstance) r2.x.e.d.invoke()).x(null, aa6.a.a.b, null, null);
        return;
    }

    public static final CartLoadingComponent o(CartPageCallBackComponent r0) {
        return (CartLoadingComponent) r0.p.getValue();
    }

    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.FrameLayout, com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2] */
    public final void v(boolean r7) {
        if (this.x.e.l.a == false) goto L5;
        return;
    L5:
        final CartLoadMoreComponent r0 = (CartLoadMoreComponent) this.r.getValue();
        if (r0 == null) goto L26;
        CartBodyComponent r2 = r0.n();
        if (r2 == null) goto L10;
        ?? r3 = r2.p();
    L11:
        if (r7 == true) goto L26;
        if (r0.h == false) goto L18;
        if (r3 == 0) goto L18;
        r3.p.scrollBy(0, r3.getScrollY());
        r3.scrollTo(0, 0);
    L18:
        if (r0.b == false) goto L20;
        r0.c.updateHasMore(true);
        r0.b = false;
    L20:
        int r4 = CartLoadMoreComponent.j;
        Boolean r5 = CartLoadMoreComponent.a.a((AndroidYaTaInstance) r0.i.e.d.invoke(), Boolean.FALSE);
        if (r5 == null) goto L23;
        r0.c.updateHasMore(r5.booleanValue());
    L23:
        final CartBodyComponent r6 = r0.n();
        if (r6 == null) goto L26;
        r6.p().post(new CartLoadMoreComponent$autoLoadMoreIfNeed$$inlined$let$lambda$1(r6, r0));
        goto L26
    L10:
        r3 = 0;
    L26:
        CartBodyComponent r1 = p();
        if (r1 == null) goto L31;
        CartLinkedScrollViewV2 r8 = r1.b;
        if (r8 == null) goto L31;
        r8.d();
    L31:
        CartBodyComponent r9 = p();
        if (r9 == null) goto L34;
        r9.p().post(new i(this));
    L34:
        if (r7 == false) goto L36;
        return;
    L36:
        w("yata_upscreen", null);
    }

    public final void t(final com.bytedance.kmp.ec.yata.store.node.c r18, Map<String, ? extends View> r19) {
        Intrinsics.checkNotNullParameter(r18, "root");
        Intrinsics.checkNotNullParameter(r19, "containerMap");
        Map r3 = r18.s();
        View r4 = null;
        if (r3 == null) goto L5;
        final Object r5 = r3.get("popup_code");
    L6:
        Function0<Unit> r6 = new CartPageCallBackComponent$onPopUpShow$triggerPopup$1(this, r5, r18);
        if (Intrinsics.areEqual(r5, "DISCOUNT_DETAIL") == false) goto L10;
        this.b.compareAndSet(false, true);
        r6.invoke();
    L70:
        int r1 = db3.a.a;
        List<String> r2 = db3.a.C0188a.a().a();
        if (r2 != null) goto L73;
    L74:
        View r7 = r19.get("body");
        if ((r7 instanceof RecyclerView) == false) goto L78;
        r4 = r7;
    L78:
        final View r8 = (RecyclerView) r4;
        if (r8 != null) goto L82;
        return;
    L82:
        if (this.w.get(r8) != null) goto L86;
        RecyclerView.OnScrollListener r9 = new CartPageCallBackComponent$listenToKeyboard$1(this, r8);
        r8.addOnScrollListener(r9);
        this.w.put(r8, r9);
        return;
    L86:
        return;
    L73:
        if (CollectionsKt.contains(r2, r5) != true) goto L74;
        return;
    L10:
        if (Intrinsics.areEqual(r5, "SEARCH_PANEL") == false) goto L44;
        this.c.compareAndSet(false, true);
        View r10 = r19.get("body");
        if ((r10 instanceof RecyclerView) == true) goto L14;
        r10 = null;
    L14:
        RecyclerView r11 = (RecyclerView) r10;
        this.j = r11;
        if (r11 == null) goto L17;
        ViewParent r12 = r11.getParent();
    L19:
        if ((r12 instanceof ViewGroup) == true) goto L21;
        r12 = null;
    L21:
        ViewGroup r13 = (ViewGroup) r12;
        if (r13 == null) goto L35;
        SlcRenderContext r14 = (SlcRenderContext) ((AndroidYaTaInstance) this.x.e.d.invoke()).I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        Integer r15 = r();
        Function0<Unit> r16 = this.l;
        Function0<Unit> r17 = this.m;
        CartParams r110 = this.z;
        if (r110 == null) goto L28;
        HashMap<String, String> r111 = r110.getSchemaParams();
        if (r111 == null) goto L28;
        String r20 = r111.get("bottom_offset");
    L29:
        com.bytedance.android.shopping.cart_common.keyboard_manager.c r21 = new com.bytedance.android.shopping.cart_common.keyboard_manager.c(r13, r15, r14, r16, r17, com.bytedance.android.shopping.extensions.k.r(r20, 0));
        ViewTreeObserver r22 = r21.e.getViewTreeObserver();
        r21.c = r22;
        if (r22 != null) goto L32;
    L34:
        Unit r23 = Unit.INSTANCE;
        this.i = r21;
        goto L35
    L32:
        if (r22.isAlive() == false) goto L34;
        r22.addOnGlobalLayoutListener(r21.a);
    L28:
        r20 = null;
    L35:
        r6.invoke();
        CartBodyComponent r24 = p();
        if (r24 == null) goto L38;
        com.bytedance.android.ec.core.utils.a.a(r24.p(), false);
    L38:
        g r25 = (g) this.u.getValue();
        if (r25 == null) goto L70;
        LinearLayout r26 = r25.b;
        if (r26 == null) goto L70;
        com.bytedance.android.ec.core.utils.a.a(r26, false);
        goto L70
    L17:
        r12 = null;
        goto L19
    L44:
        if (Intrinsics.areEqual(r5, "MIX_CART") == false) goto L69;
        View r27 = r19.get("body");
        if ((r27 instanceof RecyclerView) == true) goto L48;
        r27 = null;
    L48:
        RecyclerView r28 = (RecyclerView) r27;
        this.j = r28;
        if (r28 == null) goto L51;
        ViewParent r29 = r28.getParent();
    L53:
        if ((r29 instanceof ViewGroup) == true) goto L55;
        r29 = null;
    L55:
        ViewGroup r112 = (ViewGroup) r29;
        if (r112 == null) goto L69;
        Integer r113 = r();
        Function0<Unit> r114 = this.l;
        Function0<Unit> r115 = this.m;
        CartParams r116 = this.z;
        if (r116 == null) goto L62;
        HashMap<String, String> r117 = r116.getSchemaParams();
        if (r117 == null) goto L62;
        String r30 = r117.get("bottom_offset");
    L63:
        final com.bytedance.android.shopping.cart_common.keyboard_manager.a r31 = new com.bytedance.android.shopping.cart_common.keyboard_manager.a(r112, r113, r114, r115, com.bytedance.android.shopping.extensions.k.r(r30, 0));
        final ViewTreeObserver r32 = r31.e.getViewTreeObserver();
        r31.c = r32;
        if (r32 != null) goto L66;
    L68:
        Unit r33 = Unit.INSTANCE;
        this.i = r31;
        goto L69
    L66:
        if (r32.isAlive() == false) goto L68;
        final ViewGroup r34 = r31.e;
        int r118 = com.bytedance.commerce.base.view.a.d;
        com.bytedance.commerce.base.view.a r35 = new com.bytedance.commerce.base.view.a(r34, new CommonPopupKeyBoardManager$onAttach$$inlined$apply$lambda$1(r34, r32, r31));
        r34.getViewTreeObserver().addOnPreDrawListener(r35);
        r34.addOnAttachStateChangeListener(r35);
    L62:
        r30 = null;
        goto L63
    L51:
        r29 = null;
    L69:
        r6.invoke();
        goto L70
    L5:
        r5 = null;
        goto L6
    }

    public final void w(String r2, com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        Intrinsics.checkNotNullParameter(r2, "callScene");
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new d(this, r2, r3));
    }

    public final void u(@QueryScene String r13, boolean r14, com.bytedance.kmp.ec.yata.common.protocol.data.e r15) {
        Intrinsics.checkNotNullParameter(r13, "queryScene");
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        yf3.b.a(this.y, "StartOnQueryEnd");
        Object r1 = null;
        w(r13, null);
        com.bytedance.android.shopping.new_cart.container.b r16 = this.x.e;
        t r2 = r16.l;
        r2.a = false;
        r2.c = true;
        boolean r17 = r16.n;
        if (r17 == true) goto L35;
        vf3.b r3 = (vf3.b) this.o.getValue();
        boolean r4 = this.x.e.l.b;
        if (r3.a.get() == true) goto L35;
        if (r3.a.compareAndSet(false, true) == false) goto L35;
        CartViewModel r8 = r3.b;
        Object r11 = 0;
        Map<String, ? extends Object> r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_normal", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r4)) | com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r14)))), TuplesKt.to("btm", "c0.d0"), TuplesKt.to("cache_used", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r4)))), TuplesKt.to("query_used", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r14))))});
        Map r6 = r3.c.j();     // Catch: Throwable -> L32
        if (r6 == null) goto L13;
        Object r7 = r6.get("tracker");     // Catch: Throwable -> L32
    L15:
        if ((r7 instanceof Map) == false) goto L18;
        r1 = r7;
    L18:
        Map r9 = (Map) r1;     // Catch: Throwable -> L32
        if (r9 == null) goto L34;
        Object r10 = r9.get("product_num");     // Catch: Throwable -> L32
        if (r10 != null) goto L23;
        r10 = r11;
    L23:
        r5.put("product_num", r10);     // Catch: Throwable -> L32
        Object r12 = r9.get("store_num");     // Catch: Throwable -> L32
        if (r12 != null) goto L26;
        r12 = r11;
    L26:
        r5.put("store_num", r12);     // Catch: Throwable -> L32
        Object r18 = r9.get("invalid_num");     // Catch: Throwable -> L32
        if (r18 == null) goto L30;
        r11 = r18;
    L30:
        r5.put("invalid_num", r11);     // Catch: Throwable -> L32
    L34:
        Unit r19 = Unit.INSTANCE;
        r8.doEventAction("page_view", r5, "page_view: " + (r14 ? 1 : 0));
        goto L35
    L13:
        r7 = null;
    L32:
        th = move-exception;
        bg3.a r20 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.i("yata_cart_get_global_tracker_exception", "error_message: " + th.getMessage(), MapsKt.mapOf(TuplesKt.to("sessionId", r3.d)), r3.e);
    L35:
        bg3.a r21 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new c(this, r17, r14, r15));
    }

    public CartPageCallBackComponent(CartObjectContainer r2, String r3, CartParams r4, FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "prefetchSessionId");
        super(r2);
        this.x = r2;
        this.y = r3;
        this.z = r4;
        this.A = r5;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = this.a.d;
        this.e = new AtomicLong(-1);
        this.f = true;
        this.h = "";
        this.k = System.currentTimeMillis();
        this.l = new CartPageCallBackComponent$onPopupKeyBoardShow$1(this);
        this.m = new CartPageCallBackComponent$onPopupKeyBoardHide$1(this);
        this.n = LazyKt.lazy(new CartPageCallBackComponent$sliceCustomWidgetAdapterComponent$2(this));
        this.o = LazyKt.lazy(new CartPageCallBackComponent$pageViewLoggerImpl$2(this));
        this.p = LazyKt.lazy(new CartPageCallBackComponent$loadingComponent$2(this));
        this.q = LazyKt.lazy(new CartPageCallBackComponent$bodyComponent$2(this));
        this.r = LazyKt.lazy(new CartPageCallBackComponent$cartLoadMoreComponent$2(this));
        this.s = LazyKt.lazy(new CartPageCallBackComponent$errorComponent$2(this));
        this.t = LazyKt.lazy(new CartPageCallBackComponent$footerComponent$2(this));
        this.u = LazyKt.lazy(new CartPageCallBackComponent$headerComponent$2(this));
        this.v = LazyKt.lazy(new CartPageCallBackComponent$cartBackToTopBtnManageComponent$2(this));
        this.w = new WeakHashMap();
    }

    public final void x(String r2, com.bytedance.kmp.ec.yata.store.node.c r3, String r4, String r5) {
        if (r2 == null) goto L11;
        int r0 = db3.a.a;
        Map<String, List<String>> r1 = db3.a.C0188a.a().b();
        if (r1 == null) goto L12;
        List<String> r6 = r1.get(r2);
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.contains(r4) != true) goto L14;
        bg3.a r7 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this.d, r5, new h(this, r3, r4, r5), null);
        return;
    L14:
        return;
    L12:
        return;
    }
}
