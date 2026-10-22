package com.bytedance.android.shopping.sku.outer.action;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import cf.l;
import cf.t;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuCheckResult;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.ability.c;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonHandleSchemaUtils;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.outer.business.buynow.SkuOuterBuyNowOpenHelper;
import com.bytedance.android.shopping.sku.outer.business.cart.core.SkuOuterAddToCartHelper;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import mh3.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uh3.b;
import ul.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuOuterPanelAction implements c {
    public SkuParams a;
    public final t b;
    public final Function2<SkuParams, Long, Unit> c;
    public final Function1<String, Unit> d;
    public final Function1<SkuShowAndDismissState, Unit> e;
    public final Function1<SkuProductDetailInfo, Unit> f;
    public final Function1<SkuCartResult, Unit> g;
    public final Function1<SkuCheckResult, Unit> h;
    public final Function0<Unit> i;

    public final a l() {
        Map<String, a> r0 = a.m;
        return a.C0219a.c(this.a.getMonitorId());
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final SkuParams a() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void e(SkuParams r2) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        this.a = r2;
    }

    public static void k(SkuParams r2, int r3) {
        if (r2.getSceneType() == 201) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Boolean r1 = null;
        if (r0 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L21;
        int r4 = ECSdk.a;
        l r5 = (l) ECSdk.a(l.class);
        if (r5 == null) goto L22;
        Boolean r6 = Boolean.valueOf(r5.Na());
        if (r6.booleanValue() == false) goto L18;
        r1 = r6;
    L18:
        if (r1 == null) goto L23;
        r1.booleanValue();
        lf.a.a(r3, "clear_screen_upon_card");
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (Intrinsics.areEqual(r2.getMethod(), "live_card_buy") == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void d(Context r27, Map<String, ? extends Object> r28) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "businessParamsMap");
        int r0 = vh3.a.a;
        vh3.a r1 = vh3.a.C0237a.a(r28);
        b r2 = r1.d();
        Function1<SkuProductDetailInfo, Unit> r4 = this.f;
        String r5 = "";
        if (r4 == null) goto L45;
        String r7 = r1.b();
        if (r2 == null) goto L7;
        Long r9 = r2.d();
    L8:
        if (r2 == null) goto L10;
        Long r10 = r2.g();
    L12:
        if (r2 == null) goto L14;
        Long r18 = r2.b();
    L16:
        if (r2 == null) goto L21;
        String r8 = r2.c();
        if (r8 == null) goto L21;
        String r20 = r8;
    L22:
        ProductPriceInfo r16 = new ProductPriceInfo(r9, r10, new PromotionDiscountPrice(r18, null, r20, null, 10, null), null, null, 24, null);
        if (r2 == null) goto L27;
        uh3.a r3 = r2.a();
        if (r3 == null) goto L27;
        Object r11 = r3.a();
    L28:
        List<uh3.c> r6 = r1.f();
        if (r6 == null) goto L35;
        List<uh3.c> r12 = r6;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L32:
        if (r14.hasNext() == false) goto L34;
        r13.add(((uh3.c) r14.next()).a());
        goto L32
    L34:
        String r15 = CollectionsKt.joinToString$default(r13, " ", null, null, 0, null, null, 62, null);
    L36:
        List<String> r17 = r1.c();
        if (r17 == null) goto L43;
        Object[] r19 = r17.toArray(new String[0]);
        if (r19 == null) goto L42;
        String[] r110 = (String[]) r19;
    L44:
        Unit r21 = (Unit) r4.invoke(new SkuProductDetailInfo(r7, r16, r11, r15, false, r110, false, 64, null));
        goto L45
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L43:
        r110 = null;
        goto L44
    L35:
        r15 = null;
    L27:
        r11 = null;
    L21:
        r20 = "";
        goto L22
    L14:
        r18 = null;
        goto L16
    L10:
        r10 = null;
        goto L12
    L7:
        r9 = null;
    L45:
        JSONArray r22 = new JSONArray();
        List<String> r23 = r1.c();
        if (r23 == null) goto L54;
        Iterator<T> r24 = r23.iterator();
    L49:
        if (r24.hasNext() == false) goto L54;
        String r25 = (String) r24.next();
        if (r25 != null) goto L53;
        r25 = "";
    L53:
        r22.put(r25);
    L54:
        JSONObject r26 = k.b(r28);
        String r29 = r1.e();
        if (r29 == null) goto L58;
        r5 = r29;
    L58:
        r26.put("sku_session_id", r5);
        String r30 = r1.a();
        if (r30 == null) goto L63;
        Long r31 = StringsKt.toLongOrNull(r30);
        if (r31 == null) goto L63;
        long r32 = r31.longValue();
    L64:
        r26.put("combo_num", r32);
        r26.put("select_spec_ids", r22);
        ECLiveHybridUtil.f("ecom.sku.spec.change", r26);
        return;
    L63:
        r32 = 0;
        goto L64
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void g(Context r4, f r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "skuPageState");
        Function1<SkuShowAndDismissState, Unit> r6 = this.e;
        if (r6 == null) goto L6;
        Unit r7 = (Unit) r6.invoke(new SkuShowAndDismissState(true, null, r5));
    L6:
        if (ECSettingKeys.n() == false) goto L8;
        JSONObject r8 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r8, "stage", "will_show");
        KtSafeMethodExtensionKt.safePut(r8, "sku_session_id", this.a.getSkuSessionId());
        Unit r9 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.show", r8);
    L8:
        k(this.a, 1);
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void h(Context r23, PageFinder r24, Map<String, ? extends Object> r25) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r25, "businessParamsMap");
        com.bytedance.android.shopping.sku.outer.business.anchor.c r4 = new com.bytedance.android.shopping.sku.outer.business.anchor.c(this.a, r25);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        Intrinsics.checkNotNullParameter(r4, "anchorData");
        String r12 = r4.a();
        if (r12 != null) goto L6;
        String r0 = null;
    L18:
        final Ref.ObjectRef r1 = r9;
    L138:
        r1.element = r0;
        Object r2 = r25.get("btm");
        if ((r2 instanceof String) == true) goto L141;
        r2 = null;
    L141:
        String r5 = (String) r2;
        if (r5 != null) goto L144;
    L147:
        boolean r13 = true;
    L148:
        if (r13 == false) goto L154;
        a r3 = l();
        if (r3 == null) goto L154;
        com.bytedance.android.shopping.sku.common.monitor.error.a r6 = r3.c;
        if (r6 == null) goto L154;
        SkuErrorMonitorType r7 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r8 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r6.a(r7, "打开商详缺少btm参数", null);
    L154:
        String r10 = (String) r1.element;
        if (r10 == null) goto L158;
        int r11 = SkuCommonHandleSchemaUtils.a;
        r1.element = SkuCommonHandleSchemaUtils.a(r10, r5, null, l(), "SkuOuterPanelAction", r24);
    L158:
        if (this.a.isFromLiveRoom() == false) goto L165;
        Lazy r14 = SkuCommonLog.a;
        SkuCommonLog.a("SkuOuterPanelAction", SkuOuterPanelAction$onOpenDetail$2.INSTANCE);
        String r15 = (String) r1.element;
        if (r15 == null) goto L188;
        Activity r16 = d0.a.getActivity(r23);
        if (r16 == null) goto L189;
        p.a.d(r15, r16);
        return;
    L189:
        return;
    L188:
        return;
    L165:
        if (this.a.isFromPlayback() == false) goto L169;
        Lazy r17 = SkuCommonLog.a;
        SkuCommonLog.a("SkuOuterPanelAction", SkuOuterPanelAction$onOpenDetail$4.INSTANCE);
        Function1<String, Unit> r18 = this.d;
        if (r18 == null) goto L191;
        Unit r19 = (Unit) r18.invoke((String) r1.element);
        return;
    L191:
        return;
    L169:
        Lazy r20 = SkuCommonLog.a;
        SkuCommonLog.a("SkuOuterPanelAction", SkuOuterPanelAction$onOpenDetail$5.INSTANCE);
        final Activity r21 = d0.a.getActivity(r23);
        if (r21 == null) goto L193;
        String r22 = (String) r1.element;
        if (r22 == null) goto L194;
        com.bytedance.android.shopping.sku.common.utils.b.a(r22, new SkuOuterPanelAction$onOpenDetail$6$1(r21), new SkuOuterPanelAction$onOpenDetail$$inlined$apply$lambda$1(this, r1));
        return;
    L194:
        return;
    L193:
        return;
    L144:
        if (StringsKt.isBlank(r5) == true) goto L147;
        r13 = false;
        goto L148
    L6:
        if (r4.d.isSchemaOpen() == false) goto L19;
        Map<String, String> r26 = r4.c();
        if (r26 == null) goto L17;
        UrlBuilderV2 r27 = new UrlBuilderV2(r4.a());
        Iterator<T> r28 = r26.keySet().iterator();
    L11:
        if (r28.hasNext() == false) goto L16;
        String r29 = (String) r28.next();
        String r30 = r26.get(r29);
        if (r30 != null) goto L15;
        r30 = "";
    L15:
        r27.addOrReplaceParam(r29, r30);
        goto L11
    L16:
        r0 = r27.build();
        goto L18
    L17:
        r0 = r4.a();
        goto L18
    L19:
        Map r110 = MapsKt.toMutableMap(r4.d.getLiveEventParams());
        String r111 = r4.b().get("screen_type");
        if (r111 != null) goto L22;
        r111 = "0";
    L22:
        r110.put("screen_type", r111);
        String r112 = r4.b().get("base_verified_category");
        if (r112 != null) goto L25;
        r112 = "";
    L25:
        r110.put("base_verified_category", r112);
        String r113 = r4.b().get("tab_name");
        if (r113 != null) goto L28;
        r113 = "";
    L28:
        r110.put("tab_name", r113);
        String r114 = r4.b().get("is_explaining");
        if (r114 != null) goto L31;
        r114 = "0";
    L31:
        r110.put("is_explaining", r114);
        String r115 = r4.b().get("card_status");
        if (r115 != null) goto L34;
        r115 = "";
    L34:
        r110.put("card_status", r115);
        String r116 = r4.b;
        if (r116 == null) goto L37;
        r110.put("upfront_presell", r116);
    L37:
        String r117 = r4.d.getTransmissibleJson();
        if (r117 != null) goto L40;
        r117 = "";
    L40:
        r110.put("transmissible_json", r117);
        if (r4.d.isLiveSkuCheck() == false) goto L43;
        r110.put("from_entrance", "live_sku_card");
    L43:
        String r31 = wh3.b.b(r12, "v3_events_additions", r110);
        String r118 = j1.c(UriProtector.parse(r31), "meta_params");
        if (r118 == null) goto L122;
        if (r118.length() <= 0) goto L48;
        boolean r210 = true;
    L49:
        if (r210 == true) goto L52;
        r118 = null;
    L52:
        if (r118 == null) goto L122;
        JSONObject r32 = new JSONObject(r118);     // Catch: JSONException -> L119
        String r119 = r32.optString("entrance_info");     // Catch: JSONException -> L119
        if (r119.length() <= 0) goto L57;
        boolean r211 = true;
    L58:
        if (r211 == true) goto L61;
        r119 = null;
    L61:
        if (r119 == null) goto L63;
        JSONObject r33 = new JSONObject(r119);     // Catch: JSONException -> L119
    L64:
        if (r33 == null) goto L66;
        r33.putOpt("from_entrance", "live_sku_card");     // Catch: JSONException -> L119
    L66:
        if (r33 == null) goto L68;
        r33.putOpt("upfront_presell", r4.b);     // Catch: JSONException -> L119
    L68:
        if (r33 == null) goto L70;
        r33.putOpt("is_under_stock", r4.c);     // Catch: JSONException -> L119
    L70:
        if (r33 == null) goto L75;
        String r34 = r4.b().get("is_explain_apply");     // Catch: JSONException -> L119
        if (r34 != null) goto L74;
        r34 = "0";
    L74:
        r33.putOpt("is_explain_apply", r34);     // Catch: JSONException -> L119
    L75:
        if (r33 == null) goto L80;
        String r35 = r4.b().get("tab_name");     // Catch: JSONException -> L119
        if (r35 != null) goto L79;
        r35 = "";
    L79:
        r33.putOpt("tab_name", r35);     // Catch: JSONException -> L119
    L80:
        if (r33 == null) goto L85;
        String r36 = r4.b().get("is_explaining");     // Catch: JSONException -> L119
        if (r36 != null) goto L84;
        r36 = "0";
    L84:
        r33.putOpt("is_explaining", r36);     // Catch: JSONException -> L119
    L85:
        if (r33 == null) goto L90;
        String r37 = r4.b().get("card_status");     // Catch: JSONException -> L119
        if (r37 != null) goto L89;
        r37 = "";
    L89:
        r33.putOpt("card_status", r37);     // Catch: JSONException -> L119
    L90:
        r32.putOpt("entrance_info", String.valueOf(r33));     // Catch: JSONException -> L119
        r31 = wh3.b.a(r31, "meta_params", r32.toString());     // Catch: JSONException -> L119
        String r38 = r4.d.getSkuLogExtra();     // Catch: JSONException -> L119
        if (r38 == null) goto L122;
        if (r38.length() <= 0) goto L95;
        boolean r39 = true;
    L96:
        if (r39 == true) goto L99;
        r38 = null;
    L99:
        if (r38 == null) goto L122;
        JSONObject r40 = new JSONObject(r38);     // Catch: JSONException -> L119
        Pair[] r41 = new Pair[4];     // Catch: JSONException -> L119
        r41[0] = new Pair("fxh_white_list_flag", r40.optString("fxh_white_list_flag"));     // Catch: JSONException -> L116
        r41[1] = new Pair("user_open_fxh_flag", r40.optString("user_open_fxh_flag"));     // Catch: JSONException -> L114
        r41[2] = new Pair("bind_card_flag", r40.optString("bind_card_flag"));     // Catch: JSONException -> L114
        r41[3] = new Pair("shop_open_fxh_flag", r40.optString("shop_open_fxh_flag"));     // Catch: JSONException -> L114
        Map r42 = MapsKt.mapOf(r41);     // Catch: JSONException -> L114
        Uri r43 = UriProtector.parse(r31);     // Catch: Exception -> L110
        String r44 = UriProtector.getQueryParameter(r43, "url");     // Catch: Exception -> L110
        if (r44 == null) goto L108;
        String r45 = wh3.b.d(r43, "url", wh3.b.b(r44, "log_data", r42)).toString();     // Catch: Exception -> L110
    L109:
        r31 = r45;
    L112:
        Unit r46 = Unit.INSTANCE;     // Catch: JSONException -> L114
        goto L122
    L108:
        r45 = wh3.b.b(r31, "log_data", r42);     // Catch: Exception -> L110
    L110:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: JSONException -> L114
    L114:
        e = e;
    L121:
        ECExceptionMonitor.e(e);
        Unit r47 = Unit.INSTANCE;
    L116:
        e = e;
        goto L121
    L95:
        r39 = false;
        goto L96
    L63:
        r33 = null;
        goto L64
    L57:
        r211 = false;
    L119:
        e = e;
        goto L121
    L48:
        r210 = false;
    L122:
        String r48 = wh3.b.c(r31, "disable_live_window", String.valueOf(r4.d.isFromPlayback()));
        Lazy r49 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L125;
        r48 = wh3.b.c(r48, "request_page", "ecom_product_detail");
    L125:
        r0 = wh3.b.c(wh3.b.c(wh3.b.c(wh3.b.c(r48, "label_name_live", r4.b().get("label_name_live")), "label_name_from_live", r4.b().get("label_name")), "base_verified_category", r4.b().get("base_verified_category")), PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(SourceType.XIAO_DIAN.getType()));
        Map<String, String> r50 = r4.c();
        if (r50 == null) goto L137;
        Set<String> r51 = r50.keySet();
        if (r51 == null) goto L137;
        Iterator<T> r52 = r51.iterator();
    L131:
        if (r52.hasNext() == false) goto L137;
        String r53 = (String) r52.next();
        Map<String, String> r54 = r4.c();
        if (r54 == null) goto L135;
        String r55 = r54.get(r53);
    L136:
        r0 = wh3.b.c(r0, r53, r55);
        goto L131
    L135:
        r55 = null;
    L137:
        r1 = r9;
        goto L138
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void i(Context r18, PageFinder r19, Map<String, ? extends Object> r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r20, "businessParamsMap");
        com.bytedance.android.shopping.sku.outer.business.confirm.b r2 = new com.bytedance.android.shopping.sku.outer.business.confirm.b(this.a, r20);
        long r3 = 1;
        if (r2.b.isFromMatchPurchase() == false) goto L26;
        Function1<SkuCheckResult, Unit> r1 = this.h;
        if (r1 == null) goto L49;
        String r6 = r2.g();
        if (r6 != null) goto L9;
        String r8 = "";
    L10:
        List<uh3.c> r5 = r2.h();
        if (r5 == null) goto L17;
        List<uh3.c> r7 = r5;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r10 = r7.iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        r9.add(((uh3.c) r10.next()).a());
        goto L14
    L16:
        List r11 = r9;
    L18:
        Long r12 = r2.a();
        if (r12 == null) goto L21;
        r3 = r12.longValue();
    L21:
        long r13 = r3;
        int r4 = g.a;
        Long r14 = r2.f();
        if (r14 == null) goto L24;
        long r15 = r14.longValue();
    L25:
        Unit r16 = (Unit) r1.invoke(new SkuCheckResult(r8, r11, r13, g.d(r15), r2.i()));
        return;
    L24:
        r15 = 0;
        goto L25
    L17:
        r11 = CollectionsKt.emptyList();
        goto L18
    L9:
        r8 = r6;
        goto L10
    L49:
        return;
    L26:
        StringBuilder r17 = new StringBuilder();
        List<uh3.c> r21 = r2.h();
        if (r21 == null) goto L32;
        Iterator<T> r22 = r21.iterator();
    L30:
        if (r22.hasNext() == false) goto L32;
        uh3.c r23 = (uh3.c) r22.next();
        r17.append(r23.b() + ':' + r23.a() + ';');
    L32:
        String r24 = r17.toString();
        if (r24 == null) goto L46;
        String r25 = StringsKt.trim(r24).toString();
        Function1<SkuCartResult, Unit> r26 = this.g;
        if (r26 == null) goto L51;
        String r27 = r2.g();
        if (r27 != null) goto L39;
        String r28 = "";
    L40:
        Long r29 = r2.a();
        if (r29 == null) goto L43;
        r3 = r29.longValue();
    L43:
        Unit r30 = (Unit) r26.invoke(new SkuCartResult(r25, r28, r3, r2.d(), r2.e(), r2.b(), r2.c(), r2.i()));
        return;
    L39:
        r28 = r27;
        goto L40
    L51:
        return;
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void b(Context r4, PageFinder r5, Map<String, ? extends Object> r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r6, "businessParamsMap");
        com.bytedance.android.shopping.sku.outer.business.buynow.c r0 = new com.bytedance.android.shopping.sku.outer.business.buynow.c(this.a, r7, r6, false);
        Function2<SkuParams, Long, Unit> r8 = this.c;
        if (r8 == null) goto L9;
        SkuParams r9 = this.a;
        Long r1 = r0.h();
        if (r1 == null) goto L7;
        long r2 = r1.longValue();
    L8:
        Unit r10 = (Unit) r8.invoke(r9, Long.valueOf(r2));
        goto L9
    L7:
        r2 = 0;
    L9:
        new SkuOuterBuyNowOpenHelper(r4, r0, r5, l()).a();
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void c(Context r27, Map<String, ? extends Object> r28, f r29, SkuAbilityType r30) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "businessParamsMap");
        Intrinsics.checkNotNullParameter(r29, "skuPageState");
        Intrinsics.checkNotNullParameter(r30, "type");
        int r3 = vh3.a.a;
        vh3.a r4 = vh3.a.C0237a.a(r28);
        List<String> r5 = r4.c();
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L6:
        boolean r8 = false;
        if (r7.hasNext() == false) goto L16;
        String r9 = (String) r7.next();
        if (r9 != null) goto L11;
    L12:
        r8 = true;
    L13:
        if (r8 == true) goto L14;
        r6.add(r9);
        goto L6
    L14:
        r6.add(null);
        goto L6
    L11:
        if (r9.length() != 0) goto L13;
    L16:
        String r15 = "";
        if ((!r6.isEmpty()) == false) goto L78;
        SkuRestoreState r10 = new SkuRestoreState(r6.size());
        Object[] r11 = r6.toArray(new String[0]);
        if (r11 == null) goto L76;
        String[] r17 = (String[]) r11;
        String r12 = r4.a();
        if (r12 == null) goto L23;
        Long r18 = StringsKt.toLongOrNull(r12);
    L24:
        b r13 = r4.d();
        if (r13 == null) goto L27;
        String r19 = r13.h();
    L28:
        SkuRestoreState.saveSelectedSpec$default(r10, r17, r18, r19, null, null, null, 0, 120, null);
        Function1<SkuShowAndDismissState, Unit> r14 = this.e;
        if (r14 == null) goto L32;
        Unit r16 = (Unit) r14.invoke(new SkuShowAndDismissState(false, r10, r29));
    L32:
        if (ECSettingKeys.n() == true) goto L39;
        if (this.e != null) goto L36;
    L37:
        JSONObject r2 = k.b(r28);
        KtSafeMethodExtensionKt.safePut(r2, "sku_session_id", this.a.getSkuSessionId());
        KtSafeMethodExtensionKt.safePut(r2, "stage", "will_dismiss");
        KtSafeMethodExtensionKt.safePut(r2, "close_type", Integer.valueOf(r29.a));
        Unit r20 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.dismiss", r2);
        goto L39
    L36:
        if (r30 == SkuAbilityType.BUYNOW) goto L37;
    L39:
        if (ECSettingKeys.n() == false) goto L41;
        JSONObject r21 = k.b(r28);
        KtSafeMethodExtensionKt.safePut(r21, "sku_session_id", this.a.getSkuSessionId());
        KtSafeMethodExtensionKt.safePut(r21, "stage", "will_dismiss");
        KtSafeMethodExtensionKt.safePut(r21, "close_type", Integer.valueOf(r29.a));
        Unit r1 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.dismiss", r21);
    L41:
        String r22 = this.a.getEventSessionId();
        if (r22 != null) goto L44;
        r22 = "";
    L44:
        String r23 = this.a.getSkuSessionId();
        if (r23 == null) goto L48;
        r15 = r23;
    L48:
        s0.a(new jl.a(r22, r10, r15));
        if (this.a.getSkuState() == null) goto L93;
        SkuRestoreState r24 = this.a.getSkuState();
        if (r24 == null) goto L93;
        if (r24.hasSelectedSku() != true) goto L93;
        int r25 = r6.size();
        SkuRestoreState r26 = this.a.getSkuState();
        if (r26 == null) goto L60;
        String[] r31 = r26.getSelectSkuKeys();
        if (r31 == null) goto L60;
        if (r25 == r31.length) goto L93;
    L60:
        a r32 = l();
        if (r32 == null) goto L93;
        com.bytedance.android.shopping.sku.common.monitor.error.a r33 = r32.c;
        if (r33 == null) goto L93;
        SkuErrorMonitorType r34 = SkuErrorMonitorType.MINOR_BUSINESS_ERROR;
        StringBuilder r35 = new StringBuilder("OPT2:内外skuState的数组数量不一致  外:");
        SkuRestoreState r36 = this.a.getSkuState();
        if (r36 == null) goto L69;
        String[] r37 = r36.getSelectSkuKeys();
        if (r37 == null) goto L69;
        Integer r38 = Integer.valueOf(r37.length);
    L70:
        r35.append(r38);
        r35.append("  内:");
        r35.append(r6.size());
        String r39 = r35.toString();
        JSONObject r40 = new JSONObject();
        SkuRestoreState r41 = this.a.getSkuState();
        if (r41 == null) goto L73;
        String[] r42 = r41.getSelectSkuKeys();
    L74:
        r40.put("error_msg", k.d(r42));
        Unit r43 = Unit.INSTANCE;
        r33.a(r34, r39, r40);
        goto L93
    L73:
        r42 = null;
    L69:
        r38 = null;
    L93:
        ProductSelectPoiInfo r44 = null;
    L94:
        k(this.a, 4);
        if (this.a.isFromAnchorV3() == true) goto L104;
        d1.a = r44;
        d1.b = r44;
        return;
    L104:
        return;
    L27:
        r19 = null;
        goto L28
    L23:
        r18 = null;
        goto L24
    L76:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L78:
        if (ECSettingKeys.n() == false) goto L80;
        JSONObject r45 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r45, "sku_session_id", this.a.getSkuSessionId());
        KtSafeMethodExtensionKt.safePut(r45, "stage", "will_dismiss");
        KtSafeMethodExtensionKt.safePut(r45, "close_type", Integer.valueOf(r29.a));
        Unit r46 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.sku.dismiss", r45);
    L80:
        Function1<SkuShowAndDismissState, Unit> r47 = this.e;
        if (r47 == null) goto L84;
        Unit r48 = (Unit) r47.invoke(new SkuShowAndDismissState(false, null, r29));
    L84:
        if (this.e != null) goto L93;
        String r49 = this.a.getEventSessionId();
        if (r49 != null) goto L88;
        r49 = "";
    L88:
        String r50 = this.a.getSkuSessionId();
        if (r50 == null) goto L92;
        r15 = r50;
    L92:
        r44 = null;
        s0.a(new jl.a(r49, null, r15));
        goto L94
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void f(final Context r11, final PageFinder r12, final String r13, final String r14, final Map<String, ? extends Object> r15, final boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r13, "baseSchema");
        Intrinsics.checkNotNullParameter(r15, "logData");
        if (r14 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L15;
        a r1 = l();
        if (r1 == null) goto L15;
        com.bytedance.android.shopping.sku.common.monitor.error.a r2 = r1.c;
        if (r2 == null) goto L15;
        SkuErrorMonitorType r3 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r4 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r2.a(r3, "券面板缺少btm参数", null);
    L15:
        com.bytedance.android.shopping.sku.common.utils.b.a(r13, new SkuOuterPanelAction$onOpenCouponPanel$1(this, r15, r13, r14, r12, r11, r16), new SkuOuterPanelAction$onOpenCouponPanel$2(this, r13));
        return;
    L5:
        if (StringsKt.isBlank(r14) == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.sku.common.ability.c
    public final void j(Context r9, View r10, PageFinder r11, com.bytedance.android.shopping.sku.inner.container.b r12, Map r13, com.bytedance.android.shopping.sku.inner.function.business.a r14, float[] r15) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r12, "disposableScope");
        Intrinsics.checkNotNullParameter(r13, "businessParamsMap");
        Intrinsics.checkNotNullParameter(r14, "skuAddCartListener");
        com.bytedance.android.shopping.sku.outer.business.cart.core.c r3 = new com.bytedance.android.shopping.sku.outer.business.cart.core.c(this.a, r11, r13, r15);
        new SkuOuterAddToCartHelper(l(), r12, r3, r10, this.g, r14, this.i).d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkuOuterPanelAction(SkuParams r2, t r3, Function2<? super SkuParams, ? super Long, Unit> r4, Function1<? super String, Unit> r5, Function1<? super SkuShowAndDismissState, Unit> r6, Function1<? super SkuProductDetailInfo, Unit> r7, Function1<? super SkuCartResult, Unit> r8, Function1<? super SkuCheckResult, Unit> r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
