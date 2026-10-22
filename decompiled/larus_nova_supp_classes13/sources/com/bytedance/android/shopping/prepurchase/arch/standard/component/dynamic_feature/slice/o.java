package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.DynamicFeatureComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.z;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements f {
    public final SlcContext a;
    public final Map<String, Object> b;
    public final Lazy c;
    public final m d;
    public EventChain e;
    public final k f;

    public final com.bytedance.android.ecom.arch.slice.action.p B() {
        return this.f.h8();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f
    public final List<com.bytedance.android.ecom.arch.slice.g> F() {
        return this.d.F();
    }

    public final v F0() {
        com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.l r0 = this.f.e8();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final float b1() {
        float r0 = ((SlcRenderContext) this.a).f.b;
        Resources r1 = Resources.getSystem();
        return r0 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
    }

    public final c l0() {
        c r0 = new c(this.a.getContext());
        SlcContext r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "slcContext");
        r0.c = r1;
        return r0;
    }

    public final void K1(ProductDetailEventService.a r2) {
        Intrinsics.checkNotNullParameter(r2, "sliceHook");
        ((SlcRenderContext) this.a).b0 = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f
    public final void M0(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "updateMap");
        SlcContext r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        Map r2 = this.a.u0;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        r1.putAll(r4);
        Unit r5 = Unit.INSTANCE;
        r0.u0 = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f
    public final void o1(Map<String, SlcElement> r2) {
        Intrinsics.checkNotNullParameter(r2, "templates");
        this.a.t0.b(r2);
    }

    public final void p1(Map<String, ? extends Object> r2) {
        if (r2 == null) goto L5;
        this.b.putAll(r2);
        return;
    }

    public o(final FragmentActivity r13, DynamicFeatureComponent.b r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "sliceProvider");
        this.f = r14;
        LinkedHashMap r8 = new LinkedHashMap();
        this.b = r8;
        Lazy r0 = LazyKt.lazy(new StandardSliceServiceImpl$templateLoader$2(this, r13));
        this.c = r0;
        m r9 = new m();
        this.d = r9;
        SlcGeckoTemplateMgr r1 = SlcGeckoTemplateMgr.l;
        r14.getBiz();
        r14.getChannel();
        SlcGeckoTemplateMgr.f(r1, "pdp", "pdp_slice_template", wh.a.b(r13), r14.i8());
        ActionContext r3 = new ActionContext(r13, r14.getFragmentManager(), r14.h8());
        com.bytedance.android.ecom.arch.slice.adapter.e r4 = new com.bytedance.android.ecom.arch.slice.adapter.e(0);
        com.bytedance.android.ecom.arch.slice.expr.b r2 = ((com.bytedance.android.ecom.slice.ext.template.gecko.c) r0.getValue()).c();
        if (r2 != null) goto L5;
        com.bytedance.android.shopping.anchorv4.data.k r5 = AnchorV4DataManager.a;
        r2 = (com.bytedance.android.ecom.arch.slice.expr.b) AnchorV4DataManager.f.getValue();
    L5:
        SlcExprContext r6 = new SlcExprContext(r2);
        r14.getBiz();
        com.bytedance.android.ecom.arch.slice.a r7 = r14.j8();
        if (r7 != null) goto L8;
        r7 = new com.bytedance.android.ecom.arch.slice.a();
    L8:
        SlcContext r11 = new SlcContext(r13, r3, r4, "pdp", r6, r7, r8, r9);
        com.bytedance.android.ecom.slice.ext.template.gecko.c r10 = (com.bytedance.android.ecom.slice.ext.template.gecko.c) r0.getValue();
        r14.k8();
        ((SlcRenderContext) r11).v = 0;
        com.bytedance.android.ecom.arch.slice.render.context.b r12 = r14.d8();
        if (r12 == null) goto L11;
        ((SlcRenderContext) r11).f = r12;
    L11:
        r11.o0 = r10;
        r10.b(r11);
        ((SlcRenderContext) r11).o = r14.f8();
        r14.g8();
        ((SlcRenderContext) r11).g = false;
        ((SlcRenderContext) r11).d = true;
        ((SlcRenderContext) r11).c0 = r14.l8();
        Unit r15 = Unit.INSTANCE;
        this.a = r11;
        com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.l r16 = r14.e8();
        if (r16 == null) goto L17;
        EventChain r17 = qg3.a.a(r13, "product_detail_page", new com.bytedance.android.shopping.anchorv4.event_chain.a(r13, r16.a(), r16.b(), r16.c()), new com.bytedance.kmp.ec.yata.common.init.c());
        J1("eventChain", r17);
        this.e = r17;
        ActionContext r18 = r11.r0;
        if (r18 == null) goto L18;
        n r19 = new n(this);
        Intrinsics.checkNotNullParameter(r19, "interceptor");
        r18.d = r19;
        return;
    L18:
        return;
    }

    @Deprecated(message = "临时兼容")
    public final void J1(Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceKey");
        Intrinsics.checkNotNullParameter(r3, "service");
        this.a.o(r2, r3);
    }

    public final void p(String r2, Function0<? extends List<? extends com.bytedance.android.ecom.arch.slice.g>> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentKey");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.d.G(r2, r3);
    }

    public final j h0(z r4, ug3.c r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "recyclerViewDelegate");
        Intrinsics.checkNotNullParameter(r5, "exposureService");
        m r0 = this.d;
        WeakReference r1 = new WeakReference(r4.b);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "provider");
        ((ArrayList) r0.a).add(r1);
        return new j(this.a, r4, r5, r6);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f
    public final void y0(IAction r11, com.bytedance.android.ecom.arch.slice.action.c r12, Map r13) {
        Intrinsics.checkNotNullParameter(r11, "action");
        int r0 = com.bytedance.android.ecom.arch.slice.action.f.a;
        EventChain r1 = this.e;
        View r2 = null;
        if (r12 == null) goto L5;
        com.bytedance.android.ecom.arch.slice.g r3 = com.bytedance.android.ecom.arch.slice.action.b.e(r12);
    L6:
        SlcContext r4 = this.a;
        if (r12 == null) goto L9;
        r2 = r12.a;
    L9:
        this.f.getBiz();
        com.bytedance.android.ecom.arch.slice.action.f.b(r1, r3, r4, r11, r2, r13, r12, "pdp", 32);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f
    public final void O0(com.bytedance.android.ecom.arch.slice.g r11, IAction r12, View r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r12, "action");
        int r0 = com.bytedance.android.ecom.arch.slice.action.f.a;
        EventChain r1 = this.e;
        SlcContext r3 = this.a;
        this.f.getBiz();
        com.bytedance.android.ecom.arch.slice.action.f.a(r1, r11, r3, r12, r13, r14, null, null, "pdp");
    }
}
