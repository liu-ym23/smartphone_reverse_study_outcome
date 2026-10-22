package com.bytedance.android.shopping.skubuy.module;

import android.view.View;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.ErrorMonitorType;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.PageStartupStatus;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.track.TradeCheckPoint;
import com.bytedance.android.shopping.anchorv3.utils.a0;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.skubuy.constant.PageAvailability;
import com.bytedance.android.shopping.skubuy.constant.SkuBuyModuleName;
import com.bytedance.android.shopping.skubuy.starter.SkuBuyPageInfo;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
import u33.a;
import v43.a;
import v43.b;
import v43.l;
import v43.n;
import v43.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<STATE extends o & v43.b & l & v43.a & n, PROPS extends u33.a> extends s33.b<STATE, PROPS> {
    public final String b;
    public final String c;
    public final String d;
    public final Stack<String> e;
    public boolean f;
    public PageAvailability g;
    public final boolean h;
    public final Map<String, Pair<String, Map<String, Object>>> i;
    public final HashSet<String> j;
    public Long k;
    public Long l;
    public boolean m;

    public final void A() {
        long r0 = ((s33.b) this).a.a.F();
        PageStartupStatus r2 = ((s33.b) this).a.a.c();
        String r3 = ((s33.b) this).a.a.K();
        Pair[] r4 = new Pair[6];
        int r5 = ai3.c.a;
        a0 r6 = a0.a;
        r4[0] = TuplesKt.to("page_hidden", 0);
        r4[1] = TuplesKt.to("return_method", r3);
        r4[2] = TuplesKt.to("startup_status", r2.getRawValue());
        r4[3] = TuplesKt.to("popup_codes", CollectionsKt.joinToString$default(this.e, ",", null, null, 0, null, null, 62, null));
        int r7 = j43.d.a;
        r4[4] = TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r0));
        Long r1 = this.l;
        if (r1 == null) goto L5;
        long r8 = r1.longValue();
    L6:
        r4[5] = TuplesKt.to("stage2_delay", Long.valueOf(r8));
        Map r9 = MapsKt.mapOf(r4);
        ((s33.b) this).a.d.a().b("order_submit_return", r9);
        y43.a r10 = (y43.a) ((w33.e) ((s33.b) this).a.a.a()).a;
        if (r10 != null) goto L9;
    L11:
        C();
        Lazy r11 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L15;
        TrackCatcher.b("step_order");
        return;
    L15:
        return;
    L9:
        if (r10.a != true) goto L11;
        ai3.a.a(((s33.b) this).a.d.a(), ErrorMonitorType.CLOSE_WITH_LOADING, "");
        goto L11
    L5:
        r8 = 0;
        goto L6
    }

    public final void C() {
        Iterator r0 = ((LinkedHashMap) this.i).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        ((s33.b) this).a.d.a().a((String) ((Pair) r1.getValue()).getFirst(), k.b((Map) ((Pair) r1.getValue()).getSecond()));
        goto L4
    L6:
        ((LinkedHashMap) this.i).clear();
        this.j.clear();
    }

    public final void b() {
        ((s33.b) this).a.a.M(PageStartupStatus.RENDER_FINISH);
        this.k = Long.valueOf(System.currentTimeMillis());
    }

    public final void c() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((s33.b) this).a.d.c().e("async_two_stage"), 2) == false) goto L20;
        Long r0 = this.k;
        Object r1 = null;
        if (r0 == null) goto L9;
        Long r2 = Long.valueOf(System.currentTimeMillis() - r0.longValue());
    L10:
        this.l = r2;
        Object r3 = ((s33.b) this).a.d.c().e("tracker_common_params");
        if ((r3 instanceof Map) == false) goto L14;
        r1 = r3;
    L14:
        Map r4 = (Map) r1;
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r5 = ((s33.b) this).a.d.a();
        if (r4 != null) goto L17;
        r4 = MapsKt.emptyMap();
    L17:
        r5.c(r4);
        D("page_view", MapsKt.mapOf(TuplesKt.to("availability", Integer.valueOf(this.g.getRawValue()))));
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void y() {
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r1 = ((s33.b) this).a.d.a();
        ISchemaModel r2 = ((s33.b) this).a.c.a.getSchemaModel();
        String r3 = r2.getQueryParam("eztf_sdk_extra");
        Object r4 = null;
        if (r3 == null) goto L7;
        JSONObject r5 = k.w(r3);
        if (r5 == null) goto L7;
        Object r6 = r5.opt(PdpOpenThirdParam.KEY_SOURCE_PAGE);
    L9:
        if ((r6 instanceof String) == false) goto L12;
        r4 = r6;
    L12:
        String r7 = (String) r4;
        String r8 = "";
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        AtomicBoolean r9 = com.bytedance.android.shopping.skubuy.platform.helper.b.a;
        long r10 = wh.a.a("ecom_buynow_card_template");
        String r11 = ((s33.b) this).a.c.a.getSchemaModel().getQueryParam("scene_type");
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        String r12 = r2.getQueryParam("combo_id");
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        String r13 = r2.getQueryParam("shop_id");
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        String r14 = r2.getQueryParam("id");
        if (r14 == null) goto L29;
        r8 = r14;
    L29:
        if (Intrinsics.areEqual(r2.getQueryParam("is_cart_order"), "1") == false) goto L31;
        String r15 = "105";
    L32:
        String r16 = r2.getQueryParam("new_source_type");
        if (r16 != null) goto L35;
        r16 = "0";
    L35:
        int r17 = e.a;
        e.a = r17 + 1;
        r1.c(MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("btm", ((s33.b) this).a.c.b.a), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "submit_orders"), TuplesKt.to("log_id", ((s33.b) this).a.c.a.getSessionID()), TuplesKt.to("page_scene", "1"), TuplesKt.to("params_for_special", "tppp"), TuplesKt.to("new_source_type", r16), TuplesKt.to("area_type", r15), TuplesKt.to("page_type", "half_screen"), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r8), TuplesKt.to("shop_id", r13), TuplesKt.to("sku_id", r12), TuplesKt.to("eztf_source_page", r7), TuplesKt.to("gecko_channel_version", Long.valueOf(r10)), TuplesKt.to("scene_type", r11), TuplesKt.to("arch_opt", 2), TuplesKt.to("start_count", Integer.valueOf(r17))}));
        ((s33.b) this).a.d.a().a("trade_checkpoint", MapsKt.mapOf(TuplesKt.to("type", TradeCheckPoint.Node.ENTER_PAGE.getRawValue())));
        ((s33.b) this).a.d.a().a("trade_checkpoint", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", TradeCheckPoint.Node.RENDER_REQUEST_START.getRawValue()), TuplesKt.to("desc", this.c)}));
        ((s33.b) this).a.a.g().a(new b(this));
        ((s33.b) this).a.a.o().a(new c(this));
        Lazy r18 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L39;
        TrackCatcher.a("step_order");
        return;
    L39:
        return;
    L31:
        r15 = "169";
    L7:
        r6 = null;
        goto L9
    }

    public final String j() {
        return this.b;
    }

    public d(l33.b<STATE, PROPS> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.b = SkuBuyModuleName.PAGE_LIFECYCLE_TRACK_MODULE.getRawValue();
        this.c = "/order/component/confirmOrder/";
        this.d = "/order/component/confirmOrderEdit/";
        this.e = new Stack();
        this.g = PageAvailability.FAILED;
        ConcurrentHashMap r3 = a43.a.a;
        Object r4 = l43.a.a("ec_buy_now_async_tracker_delay");
        if ((r4 instanceof Boolean) == true) goto L5;
        r4 = null;
    L5:
        this.h = Intrinsics.areEqual((Boolean) r4, Boolean.TRUE);
        this.i = new LinkedHashMap();
        this.j = new HashSet();
    }

    public final void E(Map<String, ? extends Object> r5) {
        if (this.h == false) goto L19;
        Object r0 = null;
        if (r5 == null) goto L7;
        Object r6 = r5.get("async_delay_list");
    L9:
        if ((r6 instanceof List) == false) goto L12;
        r0 = r6;
    L12:
        List r1 = (List) r0;
        if (r1 != null) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        if (r1.contains("page_view") == false) goto L19;
        this.i.put("page_view", TuplesKt.to("page_view", MapsKt.mapOf(TuplesKt.to("availability", Integer.valueOf(this.g.getRawValue())))));
        return;
    L7:
        r6 = null;
    L19:
        ((s33.b) this).a.d.a().b("page_view", MapsKt.mapOf(TuplesKt.to("availability", Integer.valueOf(this.g.getRawValue()))));
    }

    public final void e(n33.c r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        this.g = PageAvailability.FAILED;
        E(null);
        ((s33.b) this).a.d.a().a("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", TradeCheckPoint.Node.RENDER_REQUEST_FAILED.getRawValue()), TuplesKt.to("desc", this.c)}));
        if (((s33.b) this).a.a.L() <= 0) goto L6;
        ((s33.b) this).a.d.a().a("skubuy_query_retry_failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("retry_count", Integer.valueOf(((s33.b) this).a.a.L())), TuplesKt.to("is_auto_retry", Boolean.valueOf(((s33.b) this).a.a.e()))}));
        return;
    }

    public final void f(n33.f r9) {
        Intrinsics.checkNotNullParameter(r9, "response");
        com.bytedance.kmp.ec.yata.common.protocol.data.c r0 = r9.b.g();
        Map<String, ? extends Object> r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.g();
        if (r2 == null) goto L7;
        Object r3 = r2.get("tracker_common_params");
    L9:
        if ((r3 instanceof Map) == true) goto L11;
        r3 = null;
    L11:
        Map r4 = (Map) r3;
        if (r4 != null) goto L14;
        r4 = MapsKt.emptyMap();
    L14:
        ISchemaModel r5 = ((s33.b) this).a.c.a.getSchemaModel();
        if ((r5 instanceof ISkuBuySchemaModel) == true) goto L17;
        r5 = null;
    L17:
        ISkuBuySchemaModel r6 = (ISkuBuySchemaModel) r5;
        if (r6 == null) goto L20;
        Map r7 = r6.getSkuLogData();
    L22:
        if (TypeIntrinsics.isMutableMap(r7) == true) goto L24;
        r7 = null;
    L24:
        if (r7 != null) goto L26;
        r7 = MapsKt.emptyMap();
    L26:
        if (r7 != null) goto L28;
        Map r8 = r4;
    L50:
        ((s33.b) this).a.d.a().c(r8);
        if (mq.b.c(r4, "all_forbidden", false) == false) goto L53;
        PageAvailability r10 = PageAvailability.ALL_FOR_FORBIDDEN;
    L54:
        this.g = r10;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r11 = r9.b.g();
        if (r11 == null) goto L57;
        r1 = r11.g();
    L57:
        E(r1);
        ((s33.b) this).a.d.a().a("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", TradeCheckPoint.Node.RENDER_REQUEST_SUCCESS.getRawValue()), TuplesKt.to("desc", this.c)}));
        ((s33.b) this).a.a.M(PageStartupStatus.RENDERING);
        if (((s33.b) this).a.a.L() <= 0) goto L61;
        ((s33.b) this).a.d.a().a("skubuy_query_retry_success", MapsKt.mapOf(new Pair[]{TuplesKt.to("retry_count", Integer.valueOf(((s33.b) this).a.a.L())), TuplesKt.to("is_auto_retry", Boolean.valueOf(((s33.b) this).a.a.e()))}));
        return;
    L61:
        return;
    L53:
        r10 = PageAvailability.SUCCESS;
        goto L54
    L28:
        r8 = MapsKt.toMutableMap(r7);
        if (TypeIntrinsics.isMutableMap(r8) == true) goto L31;
        r8 = null;
    L31:
        if (r8 != null) goto L33;
        r8 = new LinkedHashMap();
    L33:
        B(r8, r7, r4);
        PageInfo r12 = ((s33.b) this).a.c.a;
        if ((r12 instanceof SkuBuyPageInfo) == true) goto L36;
        r12 = null;
    L36:
        SkuBuyPageInfo r13 = (SkuBuyPageInfo) r12;
        if (r13 == null) goto L50;
        String r14 = r13.f;
        if (r14 == null) goto L50;
        String r15 = a2.d(r14);
        if (r15 == null) goto L50;
        r8.put("recommend_info", r15);
        Object r16 = r8.get("entrance_info");
        if ((r16 instanceof String) == true) goto L45;
        r16 = null;
    L45:
        String r17 = (String) r16;
        if (r17 == null) goto L50;
        JSONObject r18 = k.w(r17);
        if (r18 == null) goto L50;
        KtSafeMethodExtensionKt.safePut(r18, "recommend_info", r15);
        r8.put("entrance_info", r18.toString());
        goto L50
    L20:
        r7 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final void h(com.bytedance.kmp.ec.yata.common.biz.callback.a r5) {
        Intrinsics.checkNotNullParameter(r5, "model");
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r0 = ((s33.b) this).a.d.a();
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("type", TradeCheckPoint.Node.EDIT_REQUEST_START.getRawValue());
        r1[1] = TuplesKt.to("desc", this.d);
        String r6 = r5.c;
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r1[2] = TuplesKt.to("trigger_origin", r6);
        r0.a("trade_checkpoint", MapsKt.mapOf(r1));
        if (this.m == true) goto L9;
        this.m = true;
        ((s33.b) this).a.d.a().c(MapsKt.mapOf(TuplesKt.to("edited", "1")));
        return;
    }

    public final q33.b o(com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.b r8) {
        Intrinsics.checkNotNullParameter(r8, "info");
        if (com.bytedance.android.shopping.abscontainer.common_biz.helper.a.a(((s33.b) this).a.d.c(), null) == false) goto L7;
        return new q33.b(true, null);
    L7:
        if (this.h == false) goto L60;
        String r0 = r8.a;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L58;
        Map r2 = r8.c.q();
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L58;
        Map r4 = r8.c.q();
        if (r4 == null) goto L28;
        Object r5 = r4.get("suffix_id");
    L29:
        String r6 = String.valueOf(r5);
        String r7 = r8.c.k();
        StringBuilder r9 = new StringBuilder();
        r9.append(r7);
        r9.append('-');
        r9.append(r8.a);
        r9.append('-');
        r9.append(r6);
        r9.append('-');
        Map r10 = r8.b;
        if (r10 == null) goto L32;
        Object r11 = r10.get("level");
    L33:
        r9.append(r11);
        String r12 = r9.toString();
        String r13 = r8.a;
        Object r14 = ((s33.b) this).a.d.c().e("async_delay_list");
        if ((r14 instanceof List) == true) goto L36;
        r14 = null;
    L36:
        List r15 = (List) r14;
        if (r15 != null) goto L40;
        r15 = CollectionsKt.emptyList();
    L40:
        if (r15.contains(r13) == false) goto L46;
        String r16 = r8.a;
        Map r17 = r8.b;
        if (r17 != null) goto L44;
        r17 = MapsKt.emptyMap();
    L44:
        this.i.put(r12, TuplesKt.to(r16, r17));
        return new q33.b(true, null);
    L46:
        if (Intrinsics.areEqual(((s33.b) this).a.d.c().e("async_two_stage"), 2) == false) goto L64;
        if (this.j.contains(r12) == false) goto L51;
        return new q33.b(true, null);
    L51:
        if (this.i.containsKey(r12) == false) goto L64;
        Map<String, ? extends Object> r18 = r8.b;
        if (r18 != null) goto L55;
        r18 = MapsKt.emptyMap();
    L55:
        D(r12, r18);
        this.i.remove(r12);
        this.j.add(r12);
        return new q33.b(true, null);
    L64:
        return new q33.b(false, null);
    L32:
        r11 = null;
        goto L33
    L28:
        r5 = null;
        goto L29
    L19:
        if (r2.isEmpty() == true) goto L22;
        r3 = false;
    L58:
        return new q33.b(false, null);
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    L60:
        return new q33.b(false, null);
    }

    public final void D(String r3, Map<String, ? extends Object> r4) {
        Pair r0 = (Pair) ((LinkedHashMap) this.i).get(r3);
        if (r0 == null) goto L6;
        Map r1 = MapsKt.toMutableMap((Map) r0.getSecond());
        r1.putAll(r4);
        ((s33.b) this).a.d.a().a((String) r0.getFirst(), k.b(r1));
        Pair<String, Map<String, Object>> r5 = this.i.remove(r3);
        return;
    }

    public final void g(com.bytedance.kmp.ec.yata.common.biz.callback.a r4, n33.c r5) {
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "response");
        n33.a r6 = r5.a;
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r7 = ((s33.b) this).a.d.a();
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("type", TradeCheckPoint.Node.EDIT_REQUEST_FAILED.getRawValue());
        r0[1] = TuplesKt.to("desc", this.c);
        String r8 = r4.c;
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        r0[2] = TuplesKt.to("trigger_origin", r8);
        r7.a("trade_checkpoint", MapsKt.mapOf(r0));
    }

    public final void i(com.bytedance.kmp.ec.yata.common.biz.callback.a r4, n33.f r5) {
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "response");
        com.bytedance.kmp.ec.yata.common.protocol.data.c r6 = r5.b.g();
        Object r0 = null;
        if (r6 == null) goto L7;
        Map r7 = r6.g();
        if (r7 == null) goto L7;
        Object r8 = r7.get("tracker_common_params");
    L9:
        if ((r8 instanceof Map) == false) goto L12;
        r0 = r8;
    L12:
        Map r1 = (Map) r0;
        if (r1 != null) goto L15;
        r1 = MapsKt.emptyMap();
    L15:
        ((s33.b) this).a.d.a().c(r1);
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r9 = ((s33.b) this).a.d.a();
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("type", TradeCheckPoint.Node.EDIT_REQUEST_SUCCESS.getRawValue());
        r2[1] = TuplesKt.to("desc", this.c);
        String r10 = r4.c;
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r2[2] = TuplesKt.to("trigger_origin", r10);
        r9.a("trade_checkpoint", MapsKt.mapOf(r2));
        return;
    L7:
        r8 = null;
        goto L9
    }

    public final q33.b m(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        Lazy r4 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L6;
        TrackCatcher.c("step_order", r2, "");
    L6:
        return new q33.b(false, null);
    }

    public final void q(int r2, int r3) {
        if (r2 > 0) goto L5;
        if (r3 > 0) goto L5;
        return;
    L5:
        if (this.f == true) goto L9;
        ((s33.b) this).a.d.a().a("order_submit_slide", MapsKt.emptyMap());
        ((s33.b) this).a.d.a().c(MapsKt.mapOf(TuplesKt.to("open_status", PageScrollStatus.slide)));
        this.f = true;
        return;
    }

    public final void t(z33.a r1, Map<String, ? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerMap");
        if (this.e.isEmpty() == true) goto L6;
        this.e.pop();
        return;
    }

    public final void v(z33.a r2, Map<String, ? extends View> r3) {
        Intrinsics.checkNotNullParameter(r3, "containerMap");
        Object r4 = null;
        if (r2 == null) goto L7;
        Map r5 = r2.e();
        if (r5 == null) goto L7;
        Object r6 = r5.get("popup_code");
    L9:
        if ((r6 instanceof String) == false) goto L12;
        r4 = r6;
    L12:
        String r7 = (String) r4;
        if (r7 == null) goto L16;
        String r8 = this.e.push(r7);
        return;
    L16:
        return;
    L7:
        r6 = null;
        goto L9
    }

    public static void B(Map r10, Map r11, Map r12) {
        Iterator r13 = r12.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L69;
        Map.Entry r0 = (Map.Entry) r13.next();
        Object r1 = r11.get(r0.getKey());
        if (r1 != null) goto L7;
        r10.put(r0.getKey(), r0.getValue());
        goto L4
    L7:
        Object r3 = null;
        if ((r1 instanceof Map) == true) goto L10;
        Object r2 = null;
    L12:
        if (((Map) r2) != null) goto L13;
        if ((r1 instanceof List) == true) goto L28;
        Object r4 = null;
    L30:
        if (((List) r4) != null) goto L31;
        r10.put(r0.getKey(), r0.getValue());
        goto L4
    L31:
        List r5 = CollectionsKt.toMutableList((Collection) r1);
        Object r6 = r0.getValue();
        if ((r6 instanceof List) == true) goto L35;
        r6 = null;
    L35:
        if (((List) r6) != null) goto L36;
        r10.put(r0.getKey(), r0.getValue());
        goto L4
    L36:
        Object r7 = r0.getValue();
        if (r7 == null) goto L65;
        Iterator r8 = ((List) r7).iterator();
        int r9 = 0;
    L40:
        if (r8.hasNext() == false) goto L63;
        Object r14 = r8.next();
        int r15 = r9 + 1;
        if (r9 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        List r16 = (List) r1;
        if (r16.size() > r9) goto L47;
        r5.add(r14);
    L62:
        r9 = r15;
        goto L40
    L47:
        if ((r14 instanceof Map) == true) goto L49;
        Object r17 = null;
    L51:
        if (((Map) r17) == null) goto L60;
        Object r18 = CollectionsKt.getOrNull(r16, r9);
        if ((r18 instanceof Map) == true) goto L55;
        Object r19 = null;
    L57:
        if (((Map) r19) == null) goto L59;
        Map r20 = (Map) r18;
        Map r21 = MapsKt.toMutableMap(r20);
        B(r21, r20, (Map) r14);
        ListProtector.set(r5, r9, r21);
        goto L62
    L59:
        ListProtector.set(r5, r9, r14);
        goto L62
    L55:
        r19 = r18;
        goto L57
    L60:
        ListProtector.set(r5, r9, r14);
        goto L62
    L49:
        r17 = r14;
        goto L51
    L63:
        r10.put(r0.getKey(), r5);
        goto L4
    L65:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
    L28:
        r4 = r1;
        goto L30
    L13:
        Object r22 = r0.getValue();
        if ((r22 instanceof Map) == false) goto L18;
        r3 = r22;
    L18:
        if (((Map) r3) != null) goto L19;
        r10.put(r0.getKey(), r0.getValue());
        goto L4
    L19:
        Map r23 = (Map) r1;
        Map r24 = MapsKt.toMutableMap(r23);
        Object r25 = r0.getValue();
        if (r25 == null) goto L23;
        B(r24, r23, (Map) r25);
        r10.put(r0.getKey(), r24);
        goto L4
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    L10:
        r2 = r1;
        goto L12
    }
}
