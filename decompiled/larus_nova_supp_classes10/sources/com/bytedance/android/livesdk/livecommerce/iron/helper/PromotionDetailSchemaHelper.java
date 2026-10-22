package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.utils.EnumEntranceInfoScene;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionDetailSchemaHelper {
    public static final PromotionDetailSchemaHelper a = null;

    public PromotionDetailSchemaHelper() {
    }

    static {
        a = new PromotionDetailSchemaHelper();
    }

    public static /* synthetic */ String b(PromotionDetailSchemaHelper r6, com.bytedance.android.ec.common.api.jump.model.g r7, String r8) {
        r6.getClass();
        return a(r7, r8, false, null, 0, null);
    }

    public static String a(com.bytedance.android.ec.common.api.jump.model.g r21, String r22, boolean r23, com.bytedance.android.btm.api.model.d r24, int r25, Long r26) {
        Intrinsics.checkNotNullParameter(r21, "promotionParams");
        final ql.a r2 = r21.a;
        com.bytedance.android.ec.common.api.jump.model.f r3 = r21.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        gi2.a r4 = (gi2.a) r21.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        pk2.b r5 = (pk2.b) r21.getParamsModel(Reflection.getOrCreateKotlinClass(pk2.b.class));
        final LiveRoomParams r6 = r21.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        UrlBuilderV2 r7 = new UrlBuilderV2(r2.getScheme());
        ECEventUtilsV2.b.getClass();
        Intrinsics.checkNotNullParameter(r7, "urlBuilder");
        JSONObject r8 = z1.g((String) r7.getMMap().get("ad_extra_data"));
        if (r8 == null) goto L24;
        if (r22 == null) goto L22;
        int r12 = r22.hashCode();
        if (r12 == (-1377687758)) goto L20;
        if (r12 == 3046160) goto L17;
        if (r12 != 93819220) goto L22;
        if (r22.equals("blank") == false) goto L22;
        String r1 = "live_product_button";
    L23:
        r8.put("source_page", r1);
    L25:
        if (r8 == null) goto L27;
        r7.addOrReplaceParam("ad_extra_data", r8.toString());
        Unit r9 = Unit.INSTANCE;
    L27:
        r7.addOrReplaceParam("show_sku_panel", r25);
        if (ECLiveABUtils.INSTANCE.getECOM_DETAIL_SHOW_HOT_ATMOSPHERE().booleanValue() == false) goto L32;
        ECHotAtmosphere r10 = r2.getHotAtmosphere();
        if (r10 == null) goto L32;
        r7.addOrReplaceParam("live_hot_sale_component", com.bytedance.android.shopping.extensions.k.v(r10).toString());
    L32:
        if (r3 == null) goto L34;
        jf.b r11 = r3.c;
    L35:
        r7.addOrReplaceParam("disable_live_window", String.valueOf(Intrinsics.areEqual(r11, jf.b.j.b)));
        r7.addOrReplaceParam("promotion_source", String.valueOf(SourceType.XIAO_DIAN.getType()));
        String r13 = r2.getLabelNameLive();
        if (r13 != null) goto L38;
        r13 = "";
    L38:
        r7.addOrReplaceParam("label_name_live", r13);
        String r14 = r2.getTrackLabelName();
        if (r14 != null) goto L41;
        r14 = "";
    L41:
        r7.addOrReplaceParam("label_name_from_live", r14);
        String r15 = r2.getBaseVerifiedCategory();
        if (r15 != null) goto L44;
        r15 = "";
    L44:
        r7.addOrReplaceParam("base_verified_category", r15);
        if (r26 == null) goto L47;
        r7.addOrReplaceParam("pre_page_click_start", String.valueOf(r26.longValue()));
    L47:
        final JSONObject r16 = r21.getEntranceInfo();
        if (r6 == null) goto L50;
        String r17 = r6.getLogExtra();
    L51:
        JSONObject r18 = z1.g(r17);
        if (r18 == null) goto L54;
        r18.remove("vid");
        r7.addOrReplaceParam("log_extra", r18);
    L55:
        if (r6 == null) goto L59;
        Map r19 = r6.getReportParams();
        if (r19 == null) goto L59;
        JSONObject r110 = cd.a.c(r19);
    L60:
        if (r6 == null) goto L66;
        Function0 r111 = r6.getScreenType();
        if (r111 == null) goto L66;
        String r112 = (String) r111.invoke();
        if (r112 == null) goto L66;
        r110.put("screen_type", r112);
    L66:
        String r113 = a2.d(r2.getBaseVerifiedCategory());
        if (r113 == null) goto L70;
        r110.put("base_verified_category", r113);
    L70:
        if (r2.isCrossborderProduct() == false) goto L72;
        Object r20 = "1";
    L73:
        r110.put("is_crossborder_goods", r20);
        if (r2.isPreSale() == false) goto L76;
        Object r27 = "1";
    L77:
        r110.put("upfront_presell", r27);
        if (r2.isOnExplaining() == false) goto L80;
        Object r28 = "1";
    L81:
        r110.put("is_explaining", r28);
        String r29 = a2.d(String.valueOf(r2.getLocalNum()));
        if (r29 == null) goto L84;
        r110.put("local_num", r29);
    L84:
        JSONObject r114 = r2.getTransmissibleJson(false);
        if (r6 == null) goto L87;
        String r115 = r6.getEcomSceneId();
    L89:
        if (r115 != null) goto L91;
        String r30 = "";
    L92:
        r114.put("ecom_scene_id", r30);
        if (r6 == null) goto L95;
        String r31 = r6.getAuthorId();
    L96:
        if (r31 != null) goto L98;
        r31 = "";
    L98:
        r114.put("anchor_id", r31);
        if (r6 == null) goto L101;
        String r32 = r6.getRoomId();
    L103:
        if (r32 != null) goto L105;
        r32 = "";
    L105:
        r114.put("room_id", r32);
        Unit r33 = Unit.INSTANCE;
        r110.put("transmissible_json", r114.toString());
        if (r16 == null) goto L146;
        String r116 = a2.d(r16.optString("anchor_id"));
        com.bytedance.android.ec.common.api.jump.model.f r117 = r3;
        if (r116 == null) goto L110;
        r110.put("author_id", r116);
    L110:
        String r34 = a2.d(r16.optString("enter_from_merge"));
        if (r34 == null) goto L113;
        r110.put("carrier_source", r34);
    L113:
        String r35 = a2.d(r16.optString("enter_from_merge"));
        if (r35 == null) goto L116;
        r110.put("enter_from_merge", r35);
    L116:
        String r36 = a2.d(r16.optString("enter_method"));
        if (r36 == null) goto L119;
        r110.put("enter_method", r36);
    L119:
        String r118 = a2.d(r16.optString("follow_status"));
        if (r118 == null) goto L122;
        r110.put("follow_status", r118);
    L122:
        String r119 = a2.d(r16.optString("group_id"));
        if (r119 == null) goto L125;
        r110.put("group_id", r119);
    L125:
        String r120 = a2.d(r16.optString("creative_id"));
        if (r120 == null) goto L128;
        r110.put("creative_id", r120);
    L128:
        if (r18 == null) goto L134;
        String r37 = r18.toString();
        if (r37 == null) goto L134;
        String r38 = a2.d(r37);
        if (r38 == null) goto L134;
        r110.put("log_extra", r38);
    L134:
        String r39 = a2.d(r16.optString("is_other_channel"));
        if (r39 == null) goto L137;
        r110.put("is_other_channel", r39);
    L137:
        JSONObject r40 = z1.g(r16.optString("live_tracker_params"));
        if (r40 == null) goto L147;
        Iterator<String> r41 = r40.keys();
    L141:
        if (r41.hasNext() == false) goto L145;
        String r121 = r41.next();
        String r122 = a2.d(r40.optString(r121));
        if (r122 == null) goto L141;
        r110.put(r121, r122);
        Unit r123 = Unit.INSTANCE;
        goto L141
    L145:
        Unit r42 = Unit.INSTANCE;
    L147:
        r7.addOrReplaceParam("v3_events_additions", r110);
        final JSONObject r43 = z1.g((String) r7.getMMap().get("meta_params"));
        if (r43 != null) goto L150;
        r43 = new JSONObject();
    L150:
        String r124 = r43.optString("entrance_info");
        EnumEntranceInfoScene r125 = EnumEntranceInfoScene.ENTER_PRODUCT_DETAIL;
        Intrinsics.checkNotNullParameter(r125, "scene");
        gl.a r44 = com.bytedance.android.livesdk.livecommerce.utils.q.a(r125, r124);
        if (r44 == null) goto L168;
        Pair[] r45 = new Pair[4];
        if (r2.isOnExplaining() == false) goto L155;
        Object r46 = "1";
    L156:
        r45[0] = TuplesKt.to("is_explaining", r46);
        ECUIAskExplainInfo r47 = r2.getAskExplainInfo();
        if (r47 == null) goto L161;
        char r126 = 1;
        if (r47.isAsked() != true) goto L162;
        Object r48 = "1";
    L163:
        r45[r126] = TuplesKt.to("is_explain_apply", r48);
        r45[2] = TuplesKt.to("local_num", String.valueOf(r2.getLocalNum()));
        String r0 = r2.getEcomGroupType();
        if (r0 != null) goto L166;
        r0 = "live";
    L166:
        r45[3] = TuplesKt.to("ecom_group_type", r0);
        r44.g(r45);
    L162:
        r48 = BDLocationException.ERROR_TIMEOUT;
        goto L163
    L161:
        r126 = 1;
        goto L162
    L155:
        r46 = BDLocationException.ERROR_TIMEOUT;
    L168:
        if (r44 == null) goto L170;
        com.bytedance.android.livesdk.livecommerce.utils.s.a(r44, r16, PromotionDetailSchemaHelper$buildPromotionDetailSchema$entranceInfoStr$1$1.INSTANCE);
    L170:
        if (r44 == null) goto L172;
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r44, new Pair[]{TuplesKt.to("ecom_group_type", "live")}, new PromotionDetailSchemaHelper$buildPromotionDetailSchema$$inlined$run$lambda$1(r43, r2, r16, r6));
    L172:
        if (r44 == null) goto L182;
        Pair[] r49 = new Pair[2];
        if (r16 == null) goto L176;
        String r50 = r16.optString("enter_method");
    L177:
        r49[0] = TuplesKt.to("source_method", r50);
        if (r16 == null) goto L180;
        String r51 = r16.optString("enter_from_merge");
    L181:
        r49[1] = TuplesKt.to("carrier_source", r51);
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r44, r49, new PromotionDetailSchemaHelper$buildPromotionDetailSchema$$inlined$run$lambda$2(r43, r2, r16, r6));
        goto L182
    L180:
        r51 = null;
        goto L181
    L176:
        r50 = null;
    L182:
        if (r44 == null) goto L194;
        Pair[] r52 = new Pair[4];
        r52[0] = TuplesKt.to("promotion_id", r2.getPromotionId());
        r52[1] = TuplesKt.to("product_id", r2.getProductId());
        String r53 = r2.getPromotionId();
        if (cg4.a.a(r53) == true) goto L187;
        r53 = null;
    L187:
        if (r53 != null) goto L189;
        r53 = r2.getProductId();
    L189:
        r52[2] = TuplesKt.to("commodity_id", r53);
        String r54 = r2.getEventItemType();
        if (r54 != null) goto L192;
        String r127 = BDLocationException.ERROR_TIMEOUT;
    L193:
        r52[3] = TuplesKt.to("commodity_type", r127);
        com.bytedance.android.livesdk.livecommerce.utils.s.b(r44, r52, new PromotionDetailSchemaHelper$buildPromotionDetailSchema$$inlined$run$lambda$3(r43, r2, r16, r6));
        goto L194
    L192:
        r127 = r54;
    L194:
        if (r44 == null) goto L199;
        if (r6 == null) goto L197;
        JSONObject r55 = r6.getPassThroughLogData();
    L198:
        com.bytedance.android.livesdk.livecommerce.utils.s.a(r44, r55, PromotionDetailSchemaHelper$buildPromotionDetailSchema$entranceInfoStr$1$6.INSTANCE);
        goto L199
    L197:
        r55 = null;
    L199:
        if (r44 == null) goto L201;
        String r56 = r44.h();
    L202:
        if (r56 == null) goto L204;
        r43.put("entrance_info", r56);
    L204:
        r7.addOrReplaceParam("meta_params", r43.toString());
        if (r5 == null) goto L207;
        r7.addOrReplaceParam("clear_screen_upon", "clear_screen_upon_card");
    L215:
        hh2.g r57 = hh2.f.a.a;
        if (r57 == null) goto L220;
        Boolean r58 = r57.c();
        if (r58 == null) goto L220;
        boolean r59 = r58.booleanValue();
    L221:
        if (r59 == false) goto L229;
        int r60 = ECSdk.a;
        s83.g r61 = (s83.g) ECSdk.a(s83.g.class);
        if (r61 == null) goto L228;
        s83.a r62 = r61.q();
        if (r62 == null) goto L228;
        if (r62.i() == 0) goto L229;
    L228:
        System.out.println("Django: need to jump to full screen in low phone");
        boolean r63 = true;
    L230:
        if (r63 == false) goto L232;
        r7.addOrReplaceParam("fullscreen", String.valueOf(true));
    L232:
        ECUrlModel r64 = r2.getDetailCover();
        if (r64 == null) goto L244;
        List r65 = r64.getUrlList();
        if (r65 == null) goto L244;
        String r66 = (String) CollectionsKt.getOrNull(r65, 0);
        if (r66 == null) goto L244;
        if ((!StringsKt.isBlank(r66)) == false) goto L241;
        String r128 = r66;
    L242:
        if (r128 == null) goto L244;
        r7.addOrReplaceParam("cover_img", r128);
        goto L244
    L241:
        r128 = null;
    L244:
        BtmUtilsKt.c(r7, BtmUtilsKt.a(r24, r21.getChainParams()));
        String r67 = r7.build();
        com.bytedance.android.livesdk.livecommerce.utils.s.d(r67, r125, new PromotionDetailSchemaHelper$buildPromotionDetailSchema$6(r6));
        com.bytedance.android.livesdk.livecommerce.utils.s.c(r67, r125);
        return r67;
    L229:
        r63 = r23;
    L220:
        r59 = true;
        goto L221
    L207:
        if (r4 == null) goto L209;
        r7.addOrReplaceParam("clear_screen_upon", "clear_screen_upon_list");
        goto L215
    L209:
        if (r117 == null) goto L211;
        jf.b r68 = r117.c;
    L213:
        if (Intrinsics.areEqual(r68, jf.b.k.b) == false) goto L215;
        r7.addOrReplaceParam("clear_screen_upon", "clear_screen_upon_card");
        goto L215
    L211:
        r68 = null;
        goto L213
    L201:
        r56 = null;
        goto L202
    L146:
        r117 = r3;
        goto L147
    L101:
        r32 = null;
        goto L103
    L95:
        r31 = null;
        goto L96
    L91:
        r30 = r115;
        goto L92
    L87:
        r115 = null;
        goto L89
    L80:
        r28 = BDLocationException.ERROR_TIMEOUT;
        goto L81
    L76:
        r27 = BDLocationException.ERROR_TIMEOUT;
        goto L77
    L72:
        r20 = BDLocationException.ERROR_TIMEOUT;
    L59:
        r110 = new JSONObject();
        goto L60
    L54:
        r18 = null;
        goto L55
    L50:
        r17 = null;
        goto L51
    L34:
        r11 = null;
        goto L35
    L17:
        if (r22.equals("card") == false) goto L22;
        r1 = "live_card_button";
        goto L23
    L20:
        if (r22.equals("button") == false) goto L22;
        r1 = "live_confirm_button";
    L22:
        r1 = "";
        goto L23
    L24:
        r8 = null;
        goto L25
    }
}
