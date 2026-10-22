package com.bytedance.android.shopping.new_cart.yata.abilities;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.new_cart.components.CartBodyComponent;
import com.bytedance.android.shopping.new_cart.components.CartPageCallBackComponent;
import com.bytedance.android.shopping.new_cart.components.g;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.t;
import com.bytedance.android.shopping.new_cart.monitor.ECCartMonitorReporter;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.callback.h;
import com.bytedance.kmp.ec.yata.common.biz.callback.i;
import com.bytedance.kmp.ec.yata.common.biz.callback.j;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.ability.uplink.response.UplinkFailedException;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v96.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartYataPageCallbackImpl implements f.a, com.bytedance.kmp.ec.yata.common.biz.callback.f, com.bytedance.kmp.ec.yata.common.biz.callback.c, com.bytedance.kmp.ec.yata.common.biz.callback.d {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public long d;
    public final HashSet<String> e;
    public final CartObjectContainer f;

    public static final class a {
    }

    static {
    }

    public final CartViewModel n() {
        return (CartViewModel) this.c.getValue();
    }

    public final CartPageCallBackComponent o() {
        return (CartPageCallBackComponent) this.b.getValue();
    }

    public final void a() {
        e r0 = (e) this.a.getValue();
        boolean r2 = false;
        if (r0.a.compareAndSet(false, true) == false) goto L20;
        CartParams r1 = r0.b.e.c;
        String r4 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getDurationMonitorKey();
    L8:
        t r5 = r0.b.e.l;
        int r6 = ECCartMonitorReporter.d;
        ECCartMonitorReporter.a.a().getClass();
        ECCartMonitorReporter.d(r3, "render_end");
        if (r5.a == false) goto L11;
    L12:
        r2 = true;
    L13:
        ECCartMonitorReporter r7 = ECCartMonitorReporter.a.a();
        Integer r8 = Integer.valueOf(k.q(Boolean.valueOf(r2)));
        r7.getClass();
        ECCartMonitorReporter.e(r3, "cache_used", r8);
        ECCartMonitorReporter r9 = ECCartMonitorReporter.a.a();
        Long r10 = Long.valueOf(System.currentTimeMillis());
        r9.getClass();
        ECCartMonitorReporter.e(r3, "cache_render_end", r10);
        ECCartMonitorReporter r11 = ECCartMonitorReporter.a.a();
        Integer r12 = Integer.valueOf(k.q(Boolean.valueOf(r5.c)));
        r11.getClass();
        ECCartMonitorReporter.e(r3, "query_used", r12);
        ECCartMonitorReporter r13 = ECCartMonitorReporter.a.a();
        CartParams r14 = r0.b.e.c;
        if (r14 == null) goto L16;
        r4 = r14.getNewSourceType();
    L16:
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        r13.getClass();
        ECCartMonitorReporter.e(r3, "new_source_type", r4);
        ECCartMonitorReporter.a.a().c(r3);
        int r15 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        com.bytedance.android.shopping.base.event.a.d("cart", "render", "success", null, false, null, 56);
        return;
    L11:
        if (r5.b == false) goto L13;
    L7:
        r3 = null;
        goto L8
    }

    public CartYataPageCallbackImpl(CartObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        this.f = r3;
        this.a = LazyKt.lazy(new CartYataPageCallbackImpl$viewHolderCallback$2(this));
        this.b = LazyKt.lazy(new CartYataPageCallbackImpl$pageCallback$2(this));
        this.c = LazyKt.lazy(new CartYataPageCallbackImpl$cartVM$2(this));
        this.d = -1;
        this.e = new HashSet();
    }

    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "requestModel");
        Intrinsics.checkNotNullParameter(r2, "requestModel");
    }

    public final void c(YataStoreData r8) {
        Intrinsics.checkNotNullParameter(r8, "storeData");
        CartViewModel.doEventAction$default(n(), "yata_cart_sdk_callback", MapsKt.mapOf(TuplesKt.to("method", "onUpScreenStart")), null, 4, null);
    }

    public final void e(com.bytedance.kmp.ec.yata.common.biz.callback.a r10) {
        Intrinsics.checkNotNullParameter(aa6.a.b.b.b, "source");
        Intrinsics.checkNotNullParameter(r10, "model");
        this.d = System.currentTimeMillis();
        CartViewModel.doEventAction$default(n(), "yata_cart_sdk_callback", MapsKt.mapOf(TuplesKt.to("method", "onTransformStart")), null, 4, null);
        CartPageCallBackComponent r1 = o();
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "model");
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.components.k(r1, "yata_update", false, r10));
        return;
    }

    public final void l(final com.bytedance.kmp.ec.yata.store.node.c r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Lazy r0 = CartSettingUtils.a;
        Function0<Unit> r1 = new CartYataPageCallbackImpl$onNodeAttachedToWindow$1(this, r2);
        Intrinsics.checkNotNullParameter(r1, "action");
        r1.invoke();
    }

    public final void f(YataStoreData r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "storeData");
        aa6.a r9 = r7.c;
        CartViewModel.doEventAction$default(n(), "yata_cart_sdk_callback", MapsKt.mapOf(TuplesKt.to("method", "onUpScreenFinish")), null, 4, null);
        CartPageCallBackComponent r0 = o();
        if (r0 == null) goto L6;
        boolean r1 = Intrinsics.areEqual(r9, aa6.a.a.b);
        Result.isSuccess-impl(r8);
        r0.v(r1);
    L6:
        if ((!Intrinsics.areEqual(r9, aa6.a.a.b)) == false) goto L16;
        vf3.a r10 = n().getMultiUpdateImpl();
        if (r10 == null) goto L17;
        com.bytedance.android.shopping.new_cart.yata.interceptor.a r11 = r10.c;
        if (r11 == null) goto L18;
        aa6.b r12 = ((AndroidYaTaInstance) this.f.e.d.invoke()).h(2);
        dm.a.a("RollBackImpl").i("saveNewProtocol");
        if (r12 == null) goto L19;
        r11.b.getAndSet(r12);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void g(com.bytedance.kmp.ec.yata.store.node.c r17, ga6.c r18) {
        Intrinsics.checkNotNullParameter(r17, "root");
        Intrinsics.checkNotNullParameter(r18, "config");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.e(r17, r18);
        int r4 = ((Number) r18.b("height", -1)).intValue();
        if (r4 <= 0) goto L20;
        if ((!Intrinsics.areEqual(r17.getNodeName(), "price_detail_popup")) == false) goto L20;
        CartPageCallBackComponent r11 = o();
        if (r11 == null) goto L11;
        Integer r12 = r11.r();
        if (r12 == null) goto L11;
        int r13 = r12.intValue();
    L12:
        int r5 = r4 - r13;
        CartParams r14 = this.f.e.c;
        if (r14 == null) goto L17;
        HashMap<String, String> r15 = r14.getSchemaParams();
        if (r15 == null) goto L17;
        String r16 = r15.get("bottom_offset");
    L18:
        r18.c("height", Integer.valueOf(r5 - k.r(r16, 0)));
    L17:
        r16 = null;
    L11:
        r13 = com.bytedance.android.shopping.extensions.b.b(64);
    L20:
        CartPageCallBackComponent r6 = o();
        if (r6 == null) goto L100;
        Intrinsics.checkNotNullParameter(r18, "config");
        Map r19 = r17.s();
        if (r19 == null) goto L25;
        Object r110 = r19.get("popup_code");
    L26:
        p r111 = r17.b.b;
        if (r111 == null) goto L32;
        Object r112 = q.b(r111, Reflection.getOrCreateKotlinClass(Boolean.class), "should_below_footer");
        if ((r112 instanceof Boolean) == true) goto L31;
        r112 = null;
    L31:
        Boolean r113 = (Boolean) r112;
    L34:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == true) goto L36;
    L71:
        com.bytedance.android.shopping.new_cart.components.f r3 = r6.q();
        if (r3 == null) goto L74;
        int r7 = r3.n();
    L75:
        int r8 = db3.a.a;
        List<String> r9 = db3.a.C0188a.a().c();
        if (r9 == null) goto L81;
        if (r9.contains(r18.f()) != true) goto L81;
        r18.c("bottom_offset", Integer.valueOf(r7));
    L81:
        if (Intrinsics.areEqual(r110, "MIX_CART") == false) goto L101;
        p r0 = r17.b.b;
        if (r0 == null) goto L88;
        Object r1 = q.b(r0, Reflection.getOrCreateKotlinClass(Map.class), "config");
        if ((r1 instanceof Map) == true) goto L87;
        r1 = null;
    L87:
        Map r2 = (Map) r1;
    L89:
        float r10 = 1.0f;
        if (r2 == null) goto L92;
        r10 = com.bytedance.android.ecom.arch.slice.render.util.b.u(r2, "height", 1.0f);
    L92:
        float r20 = ((((AndroidYaTaInstance) r6.x.e.d.invoke()).s.e() * r10) - CJPayBasicExtensionKt.dpF(r6.x.e.a)) - r7;
        CartParams r21 = r6.x.e.c;
        if (r21 == null) goto L97;
        HashMap<String, String> r22 = r21.getSchemaParams();
        if (r22 == null) goto L97;
        String r23 = r22.get("bottom_offset");
    L98:
        r18.c("height", Integer.valueOf((int) (r20 - k.r(r23, 0))));
        return;
    L97:
        r23 = null;
        goto L98
    L88:
        r2 = null;
        goto L89
    L101:
        return;
    L74:
        r7 = com.bytedance.android.shopping.extensions.b.b(64);
        goto L75
    L36:
        if (((AndroidYaTaInstance) r6.x.e.d.invoke()).s.b().isEmpty() == false) goto L71;
        com.bytedance.android.shopping.new_cart.components.f r114 = r6.q();
        if (r114 == null) goto L42;
        LinearLayout r115 = r114.d;
        if (r115 == null) goto L42;
        ViewParent r116 = r115.getParent();
    L44:
        if ((r116 instanceof ViewGroup) == true) goto L46;
        r116 = null;
    L46:
        ViewGroup r117 = (ViewGroup) r116;
        if (r117 == null) goto L49;
        Integer r118 = Integer.valueOf(r117.indexOfChild(r6.A));
    L50:
        if (r118 == null) goto L63;
        int r119 = r118.intValue();
        if (r118.intValue() == (-1)) goto L63;
        FrameLayout r120 = r6.A;
        if (r120 == null) goto L56;
        ViewParent r121 = r120.getParent();
    L58:
        if ((r121 instanceof ViewGroup) == true) goto L60;
        r121 = null;
    L60:
        ViewGroup r122 = (ViewGroup) r121;
        if (r122 == null) goto L63;
        r122.removeViewAt(r119);
        goto L63
    L56:
        r121 = null;
    L63:
        if (r117 == null) goto L71;
        com.bytedance.android.shopping.new_cart.components.f r24 = r6.q();
        if (r24 == null) goto L67;
        LinearLayout r25 = r24.d;
    L68:
        int r26 = r117.indexOfChild(r25);
        if (r26 == (-1)) goto L71;
        r117.addView(r6.A, r26);
        goto L71
    L67:
        r25 = null;
        goto L68
    L49:
        r118 = null;
    L42:
        r116 = null;
        goto L44
    L32:
        r113 = null;
        goto L34
    L25:
        r110 = null;
        goto L26
    }

    public final void h(i r3, j r4) {
        Intrinsics.checkNotNullParameter(r3, "requestModel");
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r3, "requestModel");
        Intrinsics.checkNotNullParameter(r4, "result");
    }

    public final void d(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.a(r2, r3, r4);
    }

    public final void i(com.bytedance.kmp.ec.yata.store.node.c r2, ga6.c r3, Map<String, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "root");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.c(r2, r3, r4);
        CartPageCallBackComponent r5 = o();
        if (r5 == null) goto L6;
        r5.t(r2, r4);
        return;
    }

    public final void k(com.bytedance.kmp.ec.yata.store.node.c r3, ga6.c r4, Map<String, ? extends View> r5) {
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.d(r3, r4, r5);
        CartPageCallBackComponent r6 = o();
        if (r6 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        FrameLayout r7 = r6.A;
        if (r7 == null) goto L9;
        CartViewExtentionsKt.c(r7);
        return;
    L9:
        return;
    }

    public final void m(com.bytedance.kmp.ec.yata.store.node.c r5, ga6.c r6, Map<String, ? extends View> r7) {
        Intrinsics.checkNotNullParameter(r5, "root");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "containerMap");
        com.bytedance.kmp.ec.yata.common.biz.callback.c.a.b(r5, r6, r7);
        CartPageCallBackComponent r8 = o();
        if (r8 == null) goto L66;
        Intrinsics.checkNotNullParameter(r5, "root");
        Intrinsics.checkNotNullParameter(r7, "containerMap");
        Map r9 = r5.s();
        Integer r0 = null;
        if (r9 == null) goto L7;
        Object r10 = r9.get("popup_code");
    L9:
        if (Intrinsics.areEqual(r10, "DISCOUNT_DETAIL") == false) goto L12;
        r8.b.compareAndSet(true, false);
    L24:
        if ((r10 instanceof String) == true) goto L26;
        r10 = null;
    L26:
        r8.x((String) r10, r5, "DidDismiss", "onPopUpDismiss");
        com.bytedance.android.shopping.new_cart.components.f r11 = r8.q();
        if (r11 == null) goto L31;
        LinearLayout r12 = r11.d;
        if (r12 == null) goto L31;
        ViewParent r13 = r12.getParent();
    L33:
        if ((r13 instanceof ViewGroup) == true) goto L35;
        r13 = null;
    L35:
        ViewGroup r14 = (ViewGroup) r13;
        if (r14 == null) goto L42;
        com.bytedance.android.shopping.new_cart.components.f r15 = r8.q();
        if (r15 == null) goto L40;
        LinearLayout r16 = r15.d;
    L41:
        Integer r17 = Integer.valueOf(r14.indexOfChild(r16));
    L43:
        if (r14 == null) goto L45;
        r0 = Integer.valueOf(r14.indexOfChild(r8.A));
    L45:
        if (r0 == null) goto L56;
        if (r17 == null) goto L56;
        int r18 = r17.intValue();
        int r1 = r0.intValue();
        if (r1 == (-1)) goto L56;
        if (r18 == (-1)) goto L56;
        if (r1 >= r18) goto L56;
        if (r14 == null) goto L53;
        r14.removeView(r8.A);
    L53:
        if (r14 == null) goto L56;
        r14.addView(r8.A, r18);
    L56:
        if (((AndroidYaTaInstance) r8.x.e.d.invoke()).s.b().size() != 1) goto L67;
        CartBodyComponent r19 = r8.p();
        if (r19 == null) goto L60;
        com.bytedance.android.ec.core.utils.a.a(r19.p(), true);
    L60:
        g r20 = (g) r8.u.getValue();
        if (r20 == null) goto L68;
        LinearLayout r21 = r20.b;
        if (r21 == null) goto L69;
        com.bytedance.android.ec.core.utils.a.a(r21, true);
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L40:
        r16 = null;
        goto L41
    L42:
        r17 = null;
    L31:
        r13 = null;
        goto L33
    L12:
        if (Intrinsics.areEqual(r10, "SEARCH_PANEL") == false) goto L18;
        r8.c.compareAndSet(true, false);
        r8.j = null;
        com.bytedance.android.shopping.cart_common.keyboard_manager.b r2 = r8.i;
        if (r2 == null) goto L16;
        r2.onDetach();
    L16:
        r8.i = null;
        goto L24
    L18:
        if (Intrinsics.areEqual(r10, "MIX_CART") == false) goto L24;
        r8.j = null;
        com.bytedance.android.shopping.cart_common.keyboard_manager.b r3 = r8.i;
        if (r3 == null) goto L22;
        r3.onDetach();
    L22:
        r8.i = null;
        goto L24
    L7:
        r10 = null;
        goto L9
    }

    public final void j(aa6.a r21, Object r22, com.bytedance.kmp.ec.yata.common.biz.callback.a r23, com.bytedance.kmp.ec.yata.common.biz.callback.k r24, h r25, com.bytedance.kmp.ec.yata.event.ability.uplink.b r26) {
        Intrinsics.checkNotNullParameter(r21, "source");
        Intrinsics.checkNotNullParameter(r23, "model");
        Intrinsics.checkNotNullParameter(r25, "responseInfo");
        if (this.d <= 0) goto L5;
        CartViewModel.doEventAction$default(n(), "yata_cart_uplink_timing", MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - this.d)), TuplesKt.to("trigger", r23.b)}), null, 4, null);
    L5:
        CartViewModel.doEventAction$default(n(), "yata_cart_sdk_callback", MapsKt.mapOf(TuplesKt.to("method", "onTransformFinish")), null, 4, null);
        if (r26.a == true) goto L8;
        return;
    L8:
        CartPageCallBackComponent r3 = o();
        if (r3 == null) goto L15;
        boolean r4 = Result.isSuccess-impl(r22);
        Throwable r5 = Result.exceptionOrNull-impl(r22);
        if ((r5 instanceof UplinkFailedException) == true) goto L13;
        r5 = null;
    L13:
        Intrinsics.checkNotNullParameter(r23, "model");
        r3.w("yata_update", r23);
        bg3.a r1 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.components.j(r3, r4, (UplinkFailedException) r5));
        return;
    }
}
