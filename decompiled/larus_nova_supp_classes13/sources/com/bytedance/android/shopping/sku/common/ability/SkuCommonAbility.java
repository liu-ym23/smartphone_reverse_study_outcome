package com.bytedance.android.shopping.sku.common.ability;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.f2;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheHelper;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.sku.common.controller.SkuHandleEventOpportunity;
import com.bytedance.android.shopping.sku.common.controller.e;
import com.bytedance.android.shopping.sku.common.controller.uplink.SkuCommonCacheTrackerController;
import com.bytedance.android.shopping.sku.common.controller.uplink.SkuCommonUplinkController;
import com.bytedance.android.shopping.sku.common.function.SkuCommonCalCurSkuIdResultFunction;
import com.bytedance.android.shopping.sku.common.function.SkuCommonHandleEventWhenAppearFunction;
import com.bytedance.android.shopping.sku.common.function.SkuCommonPreviewImgFunction;
import com.bytedance.android.shopping.sku.common.function.SkuCommonScrollToViewFunction;
import com.bytedance.android.shopping.sku.common.function.SkuCommonSelfOpenSchema;
import com.bytedance.android.shopping.sku.common.jsb.SkuCommonEventCenter;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.platform.o;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import com.bytedance.kmp.ec.yata.event.common.h;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ti.j;
import ul.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonAbility implements b {
    public static final /* synthetic */ int j = 0;
    public Function0<AndroidYaTaInstance> a;
    public Function0<? extends c> b;
    public SkuCommonEventCenter c;
    public Map<String, ? extends Object> d;
    public com.bytedance.android.shopping.sku.common.controller.c e;
    public final e f;
    public final Lazy g;
    public final Lazy h;
    public final SkuAbilityType i;

    public static final class a {
    }

    static {
    }

    public final SkuCommonUplinkController B() {
        return (SkuCommonUplinkController) this.g.getValue();
    }

    public final mh3.a A() {
        Map<String, mh3.a> r0 = mh3.a.m;
        Function0<? extends c> r1 = this.b;
        if (r1 == null) goto L9;
        c r2 = (c) r1.invoke();
        if (r2 == null) goto L9;
        SkuParams r3 = r2.a();
        if (r3 == null) goto L9;
        String r4 = r3.getMonitorId();
    L11:
        return mh3.a.C0219a.c(r4);
    L9:
        r4 = null;
        goto L11
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void a() {
        SkuCommonEventCenter r0 = this.c;
        if (r0 == null) goto L11;
        s0.e(r0);
        Iterator<T> r1 = r0.a.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Pair r2 = (Pair) r1.next();
        ECLiveHybridUtil.p((String) r2.getFirst(), (j) r2.getSecond());
        goto L6
    L8:
        f2.a = null;
        f2.a r3 = f2.b;
        ECLiveHybridUtil.p("prescribeIMPageClose", r3);
        ECLiveHybridUtil.p("reloadSKUPanel", r3);
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void f() {
        Function0<AndroidYaTaInstance> r0 = this.a;
        if (r0 == null) goto L9;
        AndroidYaTaInstance r1 = (AndroidYaTaInstance) r0.invoke();
        if (r1 == null) goto L10;
        new SkuCommonCalCurSkuIdResultFunction(A(), r1).b();
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void onResume() {
        v(SkuHandleEventOpportunity.PAGE_APPEAR_RESUME, null);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void onStart() {
        v(SkuHandleEventOpportunity.PAGE_APPEAR_START, null);
        com.bytedance.android.shopping.sku.common.controller.c r0 = this.e;
        if (r0 == null) goto L13;
        Window r1 = r0.d;     // Catch: Exception -> L8
        if (r1 == null) goto L14;
        r1.setSoftInputMode(48);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void onStop() {
        com.bytedance.android.shopping.sku.common.controller.c r0 = this.e;
        if (r0 == null) goto L13;
        Window r1 = r0.d;     // Catch: Exception -> L8
        if (r1 == null) goto L14;
        r1.setSoftInputMode(r0.a);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final long b() {
        return B().c();
    }

    public SkuCommonAbility(SkuAbilityType r1) {
        this.i = r1;
        this.d = MapsKt.emptyMap();
        this.f = new e();
        this.g = LazyKt.lazy(new SkuCommonAbility$skuCommonUplinkController$2(this));
        this.h = LazyKt.lazy(new SkuCommonAbility$skuCommonCacheTrackerController$2(this));
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final com.bytedance.kmp.ec.yata.event.ability.tracker.b c(com.bytedance.kmp.ec.yata.event.ability.tracker.a r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        SkuCommonCacheTrackerController r0 = (SkuCommonCacheTrackerController) this.h.getValue();
        Function0<AndroidYaTaInstance> r1 = this.a;
        if (r1 == null) goto L5;
        AndroidYaTaInstance r2 = (AndroidYaTaInstance) r1.invoke();
    L6:
        r0.getClass();
        return SkuCommonCacheTrackerController.a(r2, r3);
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final com.bytedance.kmp.ec.yata.event.ability.uplink.b d(com.bytedance.kmp.ec.yata.event.ability.uplink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Function0<AndroidYaTaInstance> r0 = this.a;
        if (r0 == null) goto L10;
        AndroidYaTaInstance r1 = (AndroidYaTaInstance) r0.invoke();
        if (r1 == null) goto L10;
        return B().d(r1, r3);
    L10:
        return new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final h e(EventTriggerInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "eventTriggerInfo");
        SkuCommonUplinkController r0 = B();
        Function0<AndroidYaTaInstance> r1 = this.a;
        if (r1 == null) goto L5;
        AndroidYaTaInstance r2 = (AndroidYaTaInstance) r1.invoke();
    L7:
        return r0.e(r3, r2);
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void i(com.bytedance.kmp.ec.yata.event.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        B().a();
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void m(com.bytedance.android.shopping.sku.inner.repo.a r2) {
        Intrinsics.checkNotNullParameter(r2, "queryResponse");
        B().g(r2);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final boolean n(com.bytedance.kmp.ec.yata.common.biz.callback.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        return B().b(r2);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void o(com.bytedance.kmp.ec.yata.event.core.a r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        new SkuCommonHandleEventWhenAppearFunction(this.f, r4, A()).a();
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void r(com.bytedance.kmp.ec.yata.event.core.a r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        SkuCommonUplinkController r1 = B();
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r1, "uplinkController");
        Map r0 = r10.q();
        if (r0 == null) goto L5;
        Object r2 = r0.get("global_triggers");
    L7:
        if ((r2 instanceof List) == true) goto L9;
        r2 = null;
    L9:
        List r3 = (List) r2;
        if (r3 != null) goto L12;
        r3 = CollectionsKt.emptyList();
    L12:
        ArrayList r4 = new ArrayList();
        Map r11 = r10.q();
        if (r11 == null) goto L15;
        Object r12 = r11.get("module_infos");
    L17:
        if ((r12 instanceof List) == true) goto L19;
        r12 = null;
    L19:
        List r13 = (List) r12;
        if (r13 != null) goto L22;
        r13 = CollectionsKt.emptyList();
    L22:
        Iterator r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L49;
        Map r5 = (Map) r14.next();
        Object r6 = r5.get("module_key");
        if ((r6 instanceof String) == true) goto L28;
        r6 = null;
    L28:
        String r7 = (String) r6;
        if (r7 != null) goto L31;
    L34:
        boolean r8 = true;
    L35:
        if (r8 == true) goto L24;
        Object r9 = r5.get("triggers");
        if ((r9 instanceof List) == true) goto L39;
        r9 = null;
    L39:
        List r15 = (List) r9;
        if (r15 == null) goto L24;
        Iterator r16 = r15.iterator();
    L43:
        if (r16.hasNext() == false) goto L24;
        String r17 = (String) r16.next();
        if (r7 != null) goto L47;
        String r18 = "";
    L48:
        r4.add(new com.bytedance.android.shopping.sku.common.controller.uplink.c(r18, r17));
        goto L43
    L47:
        r18 = r7;
        goto L48
    L31:
        if (StringsKt.isBlank(r7) == true) goto L34;
        r8 = false;
        goto L35
    L49:
        r1.h(new com.bytedance.android.shopping.sku.common.controller.uplink.a(r3, r4));
        return;
    L15:
        r12 = null;
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void s(String r2) {
        mh3.a r0 = A();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void h(Context r2, com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "input");
        Map<String, ? extends Object> r4 = r3.q();
        if (r4 != null) goto L5;
        r4 = MapsKt.emptyMap();
    L5:
        this.d = r4;
        Function0<? extends c> r5 = this.b;
        if (r5 == null) goto L11;
        c r6 = (c) r5.invoke();
        if (r6 == null) goto L12;
        r6.d(r2, this.d);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void j(com.bytedance.kmp.ec.yata.event.core.a r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r13, "input");
        Intrinsics.checkNotNullParameter(r14, "nextData");
        Function0<AndroidYaTaInstance> r2 = this.a;
        if (r2 == null) goto L18;
        AndroidYaTaInstance r3 = (AndroidYaTaInstance) r2.invoke();
        if (r3 == null) goto L20;
        SkuCommonCalCurSkuIdResultFunction r4 = new SkuCommonCalCurSkuIdResultFunction(A(), r3);
        Intrinsics.checkNotNullParameter(r13, "input");
        Intrinsics.checkNotNullParameter(r14, "nextData");
        Map<String, UltimateBuyCacheQueryHelper> r0 = UltimateBuyCacheHelper.b;
        boolean r1 = UltimateBuyCacheHelper.e(r4.b, r13);
        Object r5 = r13.p(Reflection.getOrCreateKotlinClass(String.class), "next_event");
        String r6 = null;
        if ((r5 instanceof String) == true) goto L10;
        r5 = null;
    L10:
        String r9 = (String) r5;
        com.bytedance.android.shopping.sku.common.function.a r7 = r4.a(r13.j());
        Map r10 = MapsKt.mapOf(new Pair[]{TuplesKt.to("next_sku_id", r7.a), TuplesKt.to("next_specs_content", r7.b), TuplesKt.to("next_pic_spec_item_id", r7.c), TuplesKt.to("next_head_img", r7.d), TuplesKt.to("spec_items_state", r7.e), TuplesKt.to("bounding_rect", ((com.bytedance.kmp.ec.yata.chain.trigger.a) r13.e).a.get("boundingRect"))});
        Lazy r8 = SkuCommonLog.a;
        SkuCommonLog.c("SkuCommonSelfCalCurSkuIdToUpdate", "doAction  nextSkuId:" + r7.a);
        if (r1 == false) goto L13;
        r14.invoke(new com.bytedance.android.shopping.sku.common.data.e(r7.a, null, null, 6));
        return;
    L13:
        YataEventCenter r15 = r4.b.k();
        com.bytedance.kmp.ec.yata.event.common.e.a r11 = com.bytedance.kmp.ec.yata.event.common.e.a;
        AndroidYaTaInstance r12 = r4.b;
        o r16 = r13.d.b;
        com.bytedance.kmp.ec.yata.store.node.c r17 = r13.j();
        if (r17 == null) goto L16;
        r6 = r17.getKey();
    L16:
        r15.d(r11.a(r12, r16, r6, r9, r10, "SkuCommonCalCurSkuIdResultFunction"));
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void p(com.bytedance.kmp.ec.yata.event.core.a r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "nextData");
        Function0<AndroidYaTaInstance> r2 = this.a;
        if (r2 == null) goto L42;
        AndroidYaTaInstance r3 = (AndroidYaTaInstance) r2.invoke();
        if (r3 == null) goto L44;
        Function0<? extends c> r4 = this.b;
        if (r4 == null) goto L15;
        c r5 = (c) r4.invoke();
        if (r5 == null) goto L15;
        SkuParams r8 = r5.a();
        if (r8 == null) goto L15;
        String r9 = r8.getProductId();
        if (r9 == null) goto L15;
    L16:
        Intrinsics.checkNotNullParameter(r9, "productId");
        Intrinsics.checkNotNullParameter(r3, "yataInstance");
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "nextData");
        Map<String, UltimateBuyCacheQueryHelper> r0 = UltimateBuyCacheHelper.b;
        boolean r1 = UltimateBuyCacheHelper.e(r3, r6);
        com.bytedance.kmp.ec.yata.store.node.c r10 = r6.j();
        if (r10 == null) goto L27;
        p r11 = r10.b.b;
        if (r11 == null) goto L24;
        Object r12 = q.b(r11, Reflection.getOrCreateKotlinClass(Map.class), "specs_state");
        if ((r12 instanceof Map) == true) goto L23;
        r12 = null;
    L23:
        Map r13 = (Map) r12;
    L25:
        if (r13 == null) goto L27;
        Object r14 = r13.get("0");
    L29:
        if ((r14 instanceof Map) == true) goto L31;
        r14 = null;
    L31:
        Map r15 = (Map) r14;
        if (r15 == null) goto L34;
        Object r16 = r15.get("cur_show_mode");
    L36:
        if ((r16 instanceof String) == true) goto L38;
        r16 = null;
    L38:
        String r17 = (String) r16;
        Lazy r18 = SkuCommonLog.a;
        SkuCommonLog.c("SkuCommonSelfSaveSpecShowMode", "doAction key:" + r9 + "     curShowMode:" + r17);
        SkuCommonBigPicCacheController.a r19 = SkuCommonBigPicCacheController.a;
        SkuCommonBigPicCacheController.b(r9, Intrinsics.areEqual(r17, "big_pic"));
        if (r1 == false) goto L43;
        r7.invoke(new com.bytedance.android.shopping.sku.common.data.e(null, null, Boolean.valueOf(Intrinsics.areEqual(r17, "big_pic")), 3));
        return;
    L43:
        return;
    L34:
        r16 = null;
        goto L36
    L24:
        r13 = null;
    L27:
        r14 = null;
    L15:
        r9 = "";
        goto L16
    L44:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void u(Context r4, f r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "skuPageState");
        Function0<? extends c> r0 = this.b;
        if (r0 == null) goto L7;
        c r1 = (c) r0.invoke();
        if (r1 == null) goto L7;
        r1.c(r4, this.d, r5, this.i);
    L7:
        com.bytedance.android.shopping.sku.common.controller.c r6 = this.e;
        if (r6 == null) goto L15;
        com.bytedance.android.shopping.sku.common.controller.c.a r2 = r6.b;
        if (r2 == null) goto L15;
        SlcRenderContext r3 = r6.c;
        if (r3 == null) goto L14;
        r3.t(r2);
    L14:
        r6.b = null;
    L15:
        this.e = null;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void v(SkuHandleEventOpportunity r11, Object r12) {
        Intrinsics.checkNotNullParameter(r11, "opportunity");
        Function0<AndroidYaTaInstance> r1 = this.a;
        if (r1 == null) goto L21;
        AndroidYaTaInstance r3 = (AndroidYaTaInstance) r1.invoke();
        if (r3 == null) goto L26;
        e r2 = this.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "opportunity");
        Intrinsics.checkNotNullParameter(r3, "yataInstance");
        if (r11 == SkuHandleEventOpportunity.PAY_FOR_FIX_NEXT_PAGE_EVENT) goto L10;
        e.a r13 = r2.a.get(r11.getValue());
        Lazy r0 = SkuCommonLog.a;
        SkuCommonLog.c("SkuHandleEventController", "handleEvent  opportunity:" + r11 + "    info:" + r13);
        if (r13 == null) goto L24;
        r3.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r3, null, r13.d, r13.a, null, "handleEvent_" + r13.b));
        if (r13.c == true) goto L25;
        r2.a.remove(r11.getValue());
        return;
    L25:
        return;
    L24:
        return;
    L10:
        if ((r12 instanceof com.bytedance.android.shopping.sku.common.jsb.b) == false) goto L27;
        Lazy r14 = SkuCommonLog.a;
        SkuCommonLog.c("SkuHandleEventController", "handleEvent nextPageEventData    info:" + r12);
        com.bytedance.android.shopping.sku.common.jsb.b r15 = (com.bytedance.android.shopping.sku.common.jsb.b) r12;
        if (k.c(r15.a) == false) goto L22;
        r3.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r3, null, r15.b, r15.c, r15.d, "handleSkuPayForFixEvent"));
        return;
    L22:
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void w(com.bytedance.android.ec.core.async.b r2, com.bytedance.android.shopping.sku.common.jsb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r3, "callback");
        if (this.c != null) goto L5;
        this.c = new SkuCommonEventCenter(r2, r3);
    L5:
        SkuCommonEventCenter r4 = this.c;
        if (r4 == null) goto L9;
        r4.a();
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void x(Function0<AndroidYaTaInstance> r2, Function0<? extends c> r3) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "skuPanelAction");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void z(com.bytedance.kmp.ec.yata.event.core.a r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "toastAction");
        mh3.a r2 = A();
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "toastAction");
        Map r0 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r6.e).a;
        if (r0 == null) goto L5;
        Object r1 = r0.get("toast_message");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r3 = (String) r1;
        if (r3 != null) goto L15;
        Object r8 = r6.p(Reflection.getOrCreateKotlinClass(String.class), "toast_message");
        if ((r8 instanceof String) == true) goto L14;
        r8 = null;
    L14:
        r3 = (String) r8;
    L15:
        if (r3 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == false) goto L26;
        if (r2 == null) goto L26;
        com.bytedance.android.shopping.sku.common.monitor.error.a r10 = r2.c;
        if (r10 == null) goto L26;
        SkuErrorMonitorType r4 = SkuErrorMonitorType.SELF_FUN_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r5 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r10.a(r4, "selfToast  toastMsg is null", null);
    L26:
        r7.invoke(r3);
        return;
    L17:
        if (StringsKt.isBlank(r3) == true) goto L20;
        r9 = false;
        goto L21
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void q(Activity r2, PageFinder r3, com.bytedance.kmp.ec.yata.event.core.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r4, "input");
        Map<String, ? extends Object> r5 = r4.q();
        if (r5 != null) goto L5;
        r5 = MapsKt.emptyMap();
    L5:
        Function0<? extends c> r0 = this.b;
        if (r0 == null) goto L11;
        c r1 = (c) r0.invoke();
        if (r1 == null) goto L12;
        r1.h(r2, r3, r5);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void y(com.bytedance.kmp.ec.yata.event.core.a r8, RecyclerView r9, SlcRenderContext r10) {
        Intrinsics.checkNotNullParameter(r8, "input");
        Intrinsics.checkNotNullParameter(r9, "bodyRecyclerView");
        Intrinsics.checkNotNullParameter(r10, "slcRenderContext");
        Function0<AndroidYaTaInstance> r0 = this.a;
        if (r0 == null) goto L9;
        AndroidYaTaInstance r2 = (AndroidYaTaInstance) r0.invoke();
        if (r2 == null) goto L10;
        new SkuCommonScrollToViewFunction(r2, r8, r9, r10, A()).b();
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void g(SlcRenderContext r2, Window r3, RecyclerView r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "footerView");
        this.e = new com.bytedance.android.shopping.sku.common.controller.c(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void k(Activity r9, com.bytedance.kmp.ec.yata.event.core.a r10, PageFinder r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "btmPageFinder");
        mh3.a r5 = A();
        Function0<? extends c> r1 = this.b;
        if (r1 == null) goto L11;
        c r2 = (c) r1.invoke();
        if (r2 == null) goto L11;
        SkuParams r3 = r2.a();
        if (r3 == null) goto L11;
        if (r3.isSplitScreen() != true) goto L11;
        boolean r7 = true;
    L12:
        new SkuCommonSelfOpenSchema(r9, r10, r11, r5, r12, r7).a();
        return;
    L11:
        r7 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void l(Activity r11, PageFinder r12, com.bytedance.kmp.ec.yata.event.core.a r13, Map r14) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r13, "input");
        Intrinsics.checkNotNullParameter(r14, "logData");
        Object r0 = r13.p(Reflection.getOrCreateKotlinClass(String.class), "schema");
        Object r2 = null;
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r6 = r1;
        Object r15 = r13.p(Reflection.getOrCreateKotlinClass(String.class), "btm");
        if ((r15 instanceof String) == false) goto L12;
        r2 = r15;
    L12:
        String r7 = (String) r2;
        Function0<? extends c> r16 = this.b;
        if (r16 == null) goto L28;
        c r3 = (c) r16.invoke();
        if (r3 == null) goto L29;
        Function0<? extends c> r17 = this.b;
        if (r17 == null) goto L25;
        c r18 = (c) r17.invoke();
        if (r18 == null) goto L25;
        SkuParams r19 = r18.a();
        if (r19 == null) goto L25;
        if (r19.isSplitScreen() != true) goto L25;
        boolean r9 = true;
    L26:
        r3.f(r11, r12, r6, r7, r14, r9);
        return;
    L25:
        r9 = false;
        goto L26
    L29:
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.b
    public final void t(Activity r12, com.bytedance.android.ec.core.gallery2.opt.b r13, com.bytedance.android.ec.core.async.b r14, com.bytedance.kmp.ec.yata.event.core.a r15, View r16, Function1 r17) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "galleryAbilityProvider");
        Intrinsics.checkNotNullParameter(r14, "disposableScope");
        Intrinsics.checkNotNullParameter(r15, "input");
        Intrinsics.checkNotNullParameter(r16, "anchorView");
        Intrinsics.checkNotNullParameter(r17, "onPageSelectedListener");
        Function0<AndroidYaTaInstance> r1 = this.a;
        if (r1 == null) goto L9;
        AndroidYaTaInstance r5 = (AndroidYaTaInstance) r1.invoke();
        if (r5 == null) goto L10;
        new SkuCommonPreviewImgFunction(r14, r12, r13, r5, r15, r16, r17, this).a();
        return;
    L10:
        return;
    }
}
