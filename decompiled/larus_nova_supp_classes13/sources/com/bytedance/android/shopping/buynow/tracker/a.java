package com.bytedance.android.shopping.buynow.tracker;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.buynow.viewmodel.b;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nl.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int i = 0;
    public final Map<String, Object> a;
    public volatile long b;
    public volatile long c;
    public final EventActionImpl d;
    public final Set<String> e;
    public boolean f;
    public final List<String> g;
    public final BuyNowViewModel h;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.buynow.tracker.a$a, reason: collision with other inner class name */
    public static final class C0029a {
        @JvmStatic
        public static Map a(String r8, boolean r9, boolean r10, c r11, UltimateBuyParams r12) {
            int r0 = ja3.a.a;
            String r1 = null;
            if (r11 == null) goto L5;
            String r2 = r11.getQueryParam("scene_type");
        L7:
            if ((r2 instanceof String) == true) goto L9;
            r2 = null;
        L9:
            Pair[] r3 = new Pair[17];
            r3[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
            r3[1] = TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android");
            int r4 = com.bytedance.android.shopping.buynow.utils.c.a;
            if (r10 == false) goto L12;
            String r5 = PageType.CONTINUEPAY;
        L13:
            r3[2] = TuplesKt.to("btm", com.bytedance.android.shopping.buynow.utils.c.a(r5));
            if (r10 == false) goto L16;
            String r13 = "pay_pad";
        L17:
            r3[3] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r13);
            r3[4] = TuplesKt.to("log_id", r8);
            String r14 = "0";
            if (r9 == false) goto L20;
            Object r6 = "1";
        L21:
            r3[5] = TuplesKt.to("page_scene", r6);
            r3[6] = TuplesKt.to("params_for_special", "tppp");
            if (r11 == null) goto L24;
            String r7 = r11.getQueryParam("new_source_type");
        L26:
            if ((r7 instanceof String) == true) goto L28;
            r7 = null;
        L28:
            if (r7 == null) goto L31;
            r14 = r7;
        L31:
            r3[7] = TuplesKt.to("new_source_type", r14);
            if (r11 == null) goto L34;
            String r15 = r11.getQueryParam("is_cart_order");
        L36:
            if (Intrinsics.areEqual(r15, "1") == false) goto L38;
            String r16 = "105";
        L39:
            r3[8] = TuplesKt.to("area_type", r16);
            if (ja3.a.c(r11) == true) goto L44;
            if (r9 == true) goto L44;
            String r17 = "full_screen";
        L45:
            r3[9] = TuplesKt.to("page_type", r17);
            String r18 = "";
            if (r9 == false) goto L61;
            if (r12 != null) goto L49;
        L50:
            if (r12 == null) goto L55;
            SkuParams r19 = r12.getSkuParams();
            if (r19 == null) goto L55;
            String r20 = r19.getProductId();
            if (r20 == null) goto L55;
        L66:
            r3[10] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r20);
            if (r9 == false) goto L81;
            if (r12 != null) goto L70;
        L71:
            if (r12 == null) goto L76;
            SkuParams r21 = r12.getSkuParams();
            if (r21 == null) goto L76;
            String r22 = r21.getShopId();
            if (r22 == null) goto L76;
        L86:
            r3[11] = TuplesKt.to("shop_id", r22);
            if (r9 == false) goto L106;
            if (r12 != null) goto L90;
        L91:
            if (r12 == null) goto L98;
            SkuParams r110 = r12.getSkuParams();
            if (r110 == null) goto L98;
            DefaultSelect r111 = r110.getDefaultSelect();
            if (r111 == null) goto L98;
            String r112 = r111.getLastSelectedSkuId();
            if (r112 == null) goto L98;
        L116:
            r3[12] = TuplesKt.to("sku_id", r112);
            if (r11 == null) goto L123;
            String r23 = r11.getQueryParam("eztf_sdk_extra");
            if (r23 == null) goto L123;
            JSONObject r24 = k.w(r23);
            if (r24 == null) goto L123;
            Object r25 = r24.get(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        L125:
            if ((r25 instanceof String) == true) goto L127;
            r25 = null;
        L127:
            r3[13] = TuplesKt.to("eztf_source_page", (String) r25);
            r3[14] = TuplesKt.to("gecko_channel_version", Long.valueOf(wh.a.a("ecom_buynow_card_template")));
            if (r9 == true) goto L130;
        L138:
            Integer r26 = null;
        L139:
            r3[15] = TuplesKt.to("arch_opt", r26);
            if (r11 == null) goto L142;
            r1 = r11.getQueryParam("check_optimize");
        L142:
            r3[16] = TuplesKt.to("check_optimize", r1);
            return MapsKt.mapOf(r3);
        L130:
            if (Intrinsics.areEqual(r2, "101") == false) goto L132;
        L137:
            r26 = 3;
            goto L139
        L132:
            if (Intrinsics.areEqual(r2, "102") == true) goto L137;
            if (Intrinsics.areEqual(r2, "105") == true) goto L137;
            if (Intrinsics.areEqual(r2, "106") == false) goto L138;
        L123:
            r25 = null;
        L98:
            if (r11 == null) goto L100;
            String r27 = r11.getQueryParam("combo_id");
        L102:
            if ((r27 instanceof String) == true) goto L104;
            r27 = null;
        L104:
            if (r27 == null) goto L115;
        L114:
            r18 = r27;
        L115:
            r112 = r18;
            goto L116
        L100:
            r27 = null;
            goto L102
        L90:
            if (r12.isSingleSku() != 1) goto L91;
        L106:
            if (r11 == null) goto L108;
            r27 = r11.getQueryParam("combo_id");
        L110:
            if ((r27 instanceof String) == true) goto L112;
            r27 = null;
        L112:
            if (r27 != null) goto L114;
        L108:
            r27 = null;
        L76:
            if (r11 == null) goto L78;
            r22 = r11.getQueryParam("shop_id");
        L79:
            if (r22 != null) goto L86;
        L80:
            r22 = "";
            goto L86
        L78:
            r22 = null;
            goto L79
        L70:
            if (r12.isSingleSku() != 1) goto L71;
        L81:
            if (r11 == null) goto L83;
            r22 = r11.getQueryParam("shop_id");
        L84:
            if (r22 != null) goto L86;
        L83:
            r22 = null;
        L55:
            if (r11 == null) goto L57;
            String r28 = r11.getQueryParam("id");
        L58:
            if (r28 != null) goto L60;
        L59:
            r20 = "";
        L60:
            r20 = r28;
            goto L66
        L57:
            r28 = null;
            goto L58
        L49:
            if (r12.isSingleSku() != 1) goto L50;
        L61:
            if (r11 == null) goto L63;
            r28 = r11.getQueryParam("id");
        L64:
            if (r28 != null) goto L60;
        L63:
            r28 = null;
        L44:
            r17 = "half_screen";
            goto L45
        L38:
            r16 = "169";
            goto L39
        L34:
            r15 = null;
            goto L36
        L24:
            r7 = null;
            goto L26
        L20:
            r6 = "0";
            goto L21
        L16:
            r13 = "submit_orders";
            goto L17
        L12:
            r5 = PageType.BUYNOW;
            goto L13
        L5:
            r2 = null;
            goto L7
        }
    }

    static {
    }

    public final Map<String, Object> d() {
        Map<String, Object> r0 = MapsKt.toMutableMap(this.d.c());
        r0.putAll(this.a);
        return r0;
    }

    public a(BuyNowViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        this.h = r5;
        this.a = new LinkedHashMap();
        this.d = new EventActionImpl();
        this.e = new LinkedHashSet();
        this.g = CollectionsKt.listOf(new String[]{"a1.b2298.c0.d0", "a1.b4943.c0.d0", "a1.b31.c0.d0", "a1.b32.c0.d0", "a1.b6871.c0.d0"});
    }

    public static Map e(SsResponse r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = r11.raw().getHeaders().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Header r2 = (Header) r1.next();
        if (Intrinsics.areEqual(r2.getName(), "x-tt-logid") == true) goto L7;
        if (Intrinsics.areEqual(r2.getName(), "content-length") == false) goto L4;
        r0.put("content_length", r2.getValue());
        goto L4
    L7:
        r0.put("log_id", r2.getValue());
        goto L4
    L11:
        TypedInput r12 = r11.raw().getBody();
        if ((r12 instanceof TypedByteArray) == true) goto L14;
        r12 = null;
    L14:
        TypedByteArray r13 = (TypedByteArray) r12;
        if (r13 == null) goto L19;
        byte[] r14 = r13.getBytes();
        if (r14 == null) goto L19;
        r0.put("content_body", ArraysKt.joinToString$default(Arrays.copyOf(r14, RangesKt.coerceAtMost(r14.length, 200)), ",", null, null, 0, null, null, 62, null));
    L19:
        return r0;
    }

    public final void a(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "customParams");
        this.d.appendEventParams(r2);
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "triggerOrigin");
        b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.CHECK_ORDER_START), TuplesKt.to("trigger_origin", r4)}));
    }

    public final void i(boolean r6) {
        BtmSDK r0 = BtmSDK.INSTANCE;
        int r2 = com.bytedance.android.shopping.buynow.utils.c.a;
        r0.willJumpToNextPage(new BtmItemBuilder(com.bytedance.android.shopping.buynow.utils.c.a(this.h.getStaticState().g), null, 2, null).withPageFinder(this.h.getStaticState().d).setTargetPagesBtm(this.g).build());
        if (r6 == false) goto L5;
        String r1 = "order_pay_success";
    L7:
        if (this.h.getStaticState().b() == false) goto L9;
        String r3 = "a1.b25587.c5642.d1959";
    L10:
        b(r1, MapsKt.mapOf(TuplesKt.to("btm", r3)));
        if (this.h.getStaticState().b() == false) goto L15;
        if (r6 == false) goto L16;
        b("WALLET_CASHIER_PAY_FINISH_PAGE_IMP", MapsKt.emptyMap());
        b("order_submit_success", MapsKt.emptyMap());
        return;
    L16:
        return;
    L15:
        return;
    L9:
        r3 = "c5642.d1959";
        goto L10
    L5:
        r1 = "order_pay_fail";
        goto L7
    }

    public final void b(String r9, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "params");
        if (this.h.getStaticState().c() == false) goto L8;
        Lazy r0 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.c("step_order", r9, String.valueOf(r10.get("btm")));
    L12:
        EventActionImpl r1 = this.d;
        PageFinder r2 = this.h.getStaticState().d;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(this.a);
        r3.putAll(r10);
        if (this.h.getStaticState().c() == true) goto L16;
    L21:
        Unit r11 = Unit.INSTANCE;
        r1.doEventAction(r9, r2, r3);
        return;
    L16:
        if (Intrinsics.areEqual(r9, "sku_action") == false) goto L19;
        r3.put("sku_action_index", String.valueOf(this.b));
        this.b++;
        goto L21
    L19:
        if (Intrinsics.areEqual(r9, "sku_content_show") == false) goto L21;
        r3.put("sku_action_index", String.valueOf(this.c));
        this.c++;
        goto L21
    L8:
        if (this.h.getStaticState().a() == false) goto L12;
        Lazy r4 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.c("normal_order", r9, String.valueOf(r10.get("btm")));
        goto L12
    }

    public final void c(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (this.e.contains(r2) == true) goto L6;
        b(r2, r3);
        this.e.add(r2);
        return;
    }

    public final void g(String r4, String r5) {
        Pair[] r0 = new Pair[3];
        int r1 = com.bytedance.android.shopping.buynow.utils.c.a;
        String r2 = this.h.getStaticState().g;
        Intrinsics.checkNotNullParameter(r2, "pageType");
        if (r2.equals(PageType.CONTINUEPAY) == false) goto L5;
        String r3 = "a1.b25587.c0.d0";
    L6:
        r0[0] = TuplesKt.to("btm", r3);
        r0[1] = TuplesKt.to("button_name", r4);
        r0[2] = TuplesKt.to("button_action", r5);
        b("ecom_module_click", MapsKt.mapOf(r0));
        return;
    L5:
        r3 = "a1.b7411.c10310.d309439";
        goto L6
    }

    public final void h(Integer r4, String r5) {
        b("trade_checkpoint", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", CheckPointType.ORDER_REQUEST_FAILED), TuplesKt.to("desc", b.a(this.h.getStaticState())), TuplesKt.to("code", r4), TuplesKt.to("message", r5)}));
    }

    public final void k(String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "params");
        r4.put("type", r3);
        b("trade_checkpoint", r4);
    }

    public final void j(String r6, String r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "pageType");
        if ((!Intrinsics.areEqual(r8, Boolean.TRUE)) == false) goto L6;
        BtmSDK.INSTANCE.willJumpToNextPage(new BtmItemBuilder(com.bytedance.android.shopping.buynow.utils.c.a(r7), null, 2, null).withPageFinder(this.h.getStaticState().d).setTargetPagesBtm(CollectionsKt.listOf(new String[]{"a1.b2298", "a1.b4943", "a1.b31", "a1.b32"})).build());
        b("validate_rule_check_fail", MapsKt.mapOf(TuplesKt.to("fail_reason", k.j(r6))));
        JSONObject r9 = new JSONObject();
        r9.put("message", r6);
        r9.put("error_type", 2);
        r9.put("type", "ORDER_SUBMIT_ERROR");
        Unit r10 = Unit.INSTANCE;
        b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(TuplesKt.to("detail", r9)));
        return;
    }
}
