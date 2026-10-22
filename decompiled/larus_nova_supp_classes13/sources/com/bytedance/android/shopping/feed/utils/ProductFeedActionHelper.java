package com.bytedance.android.shopping.feed.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilities;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.InnerFlowAdData;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductDetailPageParams;
import com.bytedance.android.ec.model.order.ProductPurchaseInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.LubanParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECLubanData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.o1;
import com.bytedance.android.shopping.feed.model.InflowFeedPageParams;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sameproduct.SameProductListFragment;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductFeedActionHelper {
    public static final /* synthetic */ int a = 0;

    public ProductFeedActionHelper() {
    }

    static {
    }

    public static AnchorV3Param b(AnchorV3Param r58, rd3.a r59) {
        Intrinsics.checkNotNullParameter(r58, "$this$copyAppendAdLogExtra");
        if (r59 != null) goto L5;
        return r58;
    L5:
        if (r59.a != null) goto L8;
        return r58;
    L8:
        if (r59.e == false) goto L10;
    L12:
        String r2 = r58.getEntranceInfo();
        if (r2 == null) goto L15;
        JSONObject r3 = z1.g(r2);
    L16:
        InnerFlowAdRawData r4 = r59.a;
        if (r4 == null) goto L23;
        InnerFlowAdData r5 = r4.getAdData();
        if (r5 == null) goto L23;
        Long r6 = r5.getCreativeId();
        if (r6 == null) goto L23;
        String r7 = String.valueOf(r6.longValue());
    L24:
        InnerFlowAdRawData r8 = r59.a;
        if (r8 == null) goto L27;
        String r9 = r8.getLogExtra();
    L28:
        if (r7 == null) goto L34;
        if (r9 == null) goto L34;
        if (r3 == null) goto L32;
        r3.putOpt("cid", r7);
    L32:
        if (r3 == null) goto L34;
        r3.putOpt("log_extra", r9);
    L34:
        InnerFlowAdRawData r1 = r59.a;
        if (r1 == null) goto L49;
        int r10 = com.bytedance.android.shopping.anchorv3.utils.b.a;
        InnerFlowAdData r11 = r1.getAdData();
        if (r11 == null) goto L41;
        Long r12 = r11.getCreativeId();
        if (r12 == null) goto L41;
        String r13 = String.valueOf(r12.longValue());
    L42:
        String r14 = r1.getLogExtra();
        InnerFlowAdData r15 = r1.getAdData();
        if (r15 == null) goto L47;
        Long r16 = r15.getAwemeId();
        if (r16 == null) goto L47;
        String r17 = String.valueOf(r16.longValue());
    L48:
        ECAdLogExtra r57 = com.bytedance.android.shopping.anchorv3.utils.b.b(r13, r14, null, r17);
    L51:
        return AnchorV3Param.copy$default(r58, null, null, null, null, null, null, null, r57, null, null, null, String.valueOf(r3), null, null, null, null, false, null, null, 0, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, -2177, 524287, null);
    L47:
        r17 = null;
    L41:
        r13 = null;
        goto L42
    L49:
        r57 = null;
        goto L51
    L27:
        r9 = null;
    L23:
        r7 = null;
        goto L24
    L15:
        r3 = null;
        goto L16
    L10:
        if (r58.getRequestParam().getAggParams() == null) goto L12;
        return r58;
    }

    public static final void a(Context r1, boolean r2, boolean r3) {
        if (r2 == false) goto L8;
        int r4 = g1.a;
        if (r3 == false) goto L7;
        String r5 = g1.a.c(r1, 2131896359, new Object[0]);
    L12:
        UIUtils.displayToast(r1, r5);
        return;
    L7:
        r5 = g1.a.c(r1, 2131895704, new Object[0]);
        goto L12
    L8:
        int r6 = g1.a;
        if (r3 == false) goto L11;
        r5 = g1.a.c(r1, 2131895815, new Object[0]);
        goto L12
    L11:
        r5 = g1.a.c(r1, 2131895816, new Object[0]);
        goto L12
    }

    @JvmStatic
    public static final void f(Context r72, rd3.a r73, String r74, String r75) {
        Intrinsics.checkNotNullParameter(r72, "context");
        if (r73 != null) goto L5;
        return;
    L5:
        ProductFeedViewModel r3 = r73.c;
        if (r3 != null) goto L8;
        return;
    L8:
        Promotion r4 = r73.f();
        if (r4 == null) goto L320;
        String r5 = r4.getLink();
        if (r5 == null) goto L321;
        com.bytedance.android.ec.sdk.helper.p r8 = com.bytedance.android.ec.sdk.helper.p.a;
        int r6 = md3.a.a;
        int r7 = b.a;
        String r9 = r3.getEcomSceneId();
        PromotionProductStruct r10 = r4.getPromotionInfo();
        if (r10 == null) goto L20;
        PromotionProductBaseStruct r11 = r10.getBaseInfo();
        if (r11 == null) goto L20;
        Integer r12 = r11.getPromotionSource();
        if (r12 == null) goto L20;
        long r13 = r12.intValue();
    L21:
        Intrinsics.checkNotNullParameter(r72, "context");
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r73, "anchorInflowFeedItem");
        Promotion r2 = r73.f();
        if (r2 == null) goto L298;
        PromotionProductStruct r14 = r2.getPromotionInfo();
        if (r14 == null) goto L298;
        Uri r15 = UriProtector.parse(r5);
        String r16 = UriProtector.getQueryParameter(r15, "meta_params");
        if (r16 == null) goto L30;
        JSONObject r17 = z1.g(r16);
        if (r17 == null) goto L30;
    L31:
        JSONObject r18 = r17;
        int r19 = rk.a.a;
        gl.a r110 = rk.a.a("flow_guess_card_to_detail", r18.optString("entrance_info"));
        ProductFeedViewModel r111 = r73.c;
        String r112 = null;
        if (r111 == null) goto L34;
        AnchorV3Param r113 = r111.m907getAnchorV3Param();
    L35:
        if (r113 == null) goto L39;
        String r114 = r113.getEntranceInfo();
        if (r114 == null) goto L39;
        JSONObject r115 = z1.g(r114);
    L41:
        if (r115 == null) goto L43;
        String r116 = r115.optString(SimilarProductParam.ENTER_FROM);
    L45:
        if (TextUtils.equals(r116, "similar_product_homepage") == true) goto L53;
        if (r115 == null) goto L48;
        String r117 = r115.optString(SimilarProductParam.ENTER_FROM);
    L50:
        if (TextUtils.equals(r117, "similar_card_page") == true) goto L53;
        boolean r21 = false;
    L54:
        List r118 = CollectionsKt.mutableListOf(new String[]{SimilarProductParam.ENTER_FROM, "previous_page", "video_id", "from_author_id", "group_id", "author_id", "similar_entrance_form", "similar_card_type", "vertical_category_new", "carrier_source", "source_method", "trend_id", "trend_name", "product_label", "ugc_label", "topic_label"});
        long r26 = r13;
        Uri r29 = r15;
        String r20 = "share_object";
        String r119 = "share_id";
        if (r115 == null) goto L57;
        String r32 = r115.optString("share_previous_page");
        String r33 = r115.optString("is_show_new_coupon");
        String r34 = r115.optString("im_group_id");
        String r35 = r115.optString("share_id");
        String r36 = r115.optString("share_object");
        String r37 = r115.optString("share_content");
        String r38 = r115.optString("share_type");
        String r39 = r115.optString("from_user_id");
        String r40 = r115.optString("search_params", "");
        String r22 = r115.optString("previous_page", "product_flow_page");
        String r42 = r115.optString("anchor_detail_info", "");
        String r43 = r115.optString("is_label_show", "");
        String r44 = r115.optString("sellpoint_bp_video", "");
        Unit r45 = Unit.INSTANCE;
        String r46 = r32;
        String r47 = r33;
        String r48 = r34;
        String r49 = r35;
        String r50 = r36;
        String r51 = r37;
        String r52 = r38;
        String r53 = r39;
        String r310 = r40;
        String r311 = r42;
        String r312 = r43;
        String r313 = r44;
    L58:
        ArrayList r120 = new ArrayList();
        if (a2.b(r9) == false) goto L68;
        if (r9 == null) goto L68;
        Object r63 = "sellpoint_bp_video";
        JSONObject r64 = r115;
        Object r67 = "previous_page";
        gl.a r66 = r110;
        List r65 = r118;
        Object r69 = "anchor_detail_info";
        String r68 = "flow_guess_card_to_detail";
        String r121 = "";
        Object r122 = "share_type";
        ArrayList r1 = r120;
        String r70 = "entrance_info";
        Object r23 = "is_label_show";
        List r24 = StringsKt.split$default(r9, new String[]{","}, false, 0, 6, null);
        if (r24 == null) goto L69;
        Iterator r25 = r24.iterator();
    L65:
        if (r25.hasNext() == false) goto L67;
        r1.add((String) r25.next());
        goto L65
    L67:
        Unit r27 = Unit.INSTANCE;
    L69:
        r1.add("1061");
        ArrayList r314 = r1;
        gl.a r28 = r66;
        if (r28 == null) goto L188;
        rd3.a r30 = r73;
        Iterator r31 = ((LinkedHashMap) r30.k).entrySet().iterator();
    L73:
        if (r31.hasNext() == false) goto L75;
        Map.Entry r315 = (Map.Entry) r31.next();
        r28.g(new Pair[]{TuplesKt.to(r315.getKey(), r315.getValue())});
        r31 = r31;
        r20 = r20;
        r119 = r119;
        goto L73
    L75:
        String r410 = r20;
        String r411 = r119;
        Pair[] r41 = new Pair[4];
        r41[0] = TuplesKt.to(r67, r22);
        if (r113 == null) goto L80;
        ECLogExtraData r54 = r113.getLogExtraData();
        if (r54 == null) goto L80;
        String r55 = r54.getEComEntranceForm();
    L81:
        r41[1] = TuplesKt.to("source_method", r55);
        if (r113 == null) goto L86;
        ECLogExtraData r56 = r113.getLogExtraData();
        if (r56 == null) goto L86;
        String r57 = r56.getEnterFrom();
    L87:
        r41[2] = TuplesKt.to("carrier_source", r57);
        r41[3] = TuplesKt.to("enter_method", "click_guess_you_like_product");
        r28.g(r41);
        if ((!StringsKt.isBlank(r310)) == false) goto L91;
        r28.g(new Pair[]{TuplesKt.to("search_params", r310)});
    L91:
        if (com.bytedance.android.shopping.anchorv3.a.b(r311) == false) goto L94;
        r28.g(new Pair[]{TuplesKt.to(r69, r311)});
    L94:
        if (com.bytedance.android.shopping.anchorv3.a.b(r312) == false) goto L97;
        r28.g(new Pair[]{TuplesKt.to(r23, r312)});
    L97:
        if (com.bytedance.android.shopping.anchorv3.a.b(r313) == false) goto L99;
        r28.g(new Pair[]{TuplesKt.to(r63, r313)});
    L99:
        Pair[] r58 = new Pair[5];
        r58[0] = TuplesKt.to("button_status", CommerceButtonUtil.a(r14).getType());
        r58[1] = TuplesKt.to("display_rank", Integer.valueOf(r30.f));
        if (r113 == null) goto L102;
        String r59 = r113.getVideoId();
    L103:
        r58[2] = TuplesKt.to(PdpOpenThirdParam.KEY_ITEM_ID, r59);
        r58[3] = TuplesKt.to("module_label", "guess_you_like_product");
        r58[4] = TuplesKt.to("inflow_product_card_mode", r30.m);
        r28.g(r58);
        r28.j(new Pair[]{TuplesKt.to("share_previous_page", r46)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$2.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to("is_show_new_coupon", r47)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$3.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to("im_group_id", r48)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$4.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to(r411, r49)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$5.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to(r410, r50)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$6.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to("share_content", r51)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$7.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to(r122, r52)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$8.INSTANCE);
        r28.j(new Pair[]{TuplesKt.to("from_user_id", r53)}, AnchorInflowFeedSchemaUtils$getAndCompleteGoodDetailSchema$3$9.INSTANCE);
        JSONObject r60 = r64;
        String r61 = "aweme_type";
        if (r60 == null) goto L106;
        r28.g(new Pair[]{TuplesKt.to(r61, Integer.valueOf(r60.optInt(r61)))});
        Unit r0 = Unit.INSTANCE;
    L106:
        String r62 = "ecom_scene_id";
        r28.g(new Pair[]{TuplesKt.to("ecom_group_type", "product_card"), TuplesKt.to(r62, CollectionsKt.joinToString$default(r314, ",", null, null, 0, null, null, 62, null))});
        if (r75 == null) goto L109;
        r28.g(new Pair[]{TuplesKt.to("action_type", r75)});
        Unit r71 = Unit.INSTANCE;
    L109:
        Promotion r76 = r73.f();
        if (r76 == null) goto L130;
        PromotionProductStruct r77 = r76.getPromotionInfo();
        if (r77 == null) goto L130;
        PromotionProductExtraStruct r78 = r77.getExtraInfo();
        if (r78 == null) goto L130;
        String r79 = r78.getEntranceInfo();
        if (r79 == null) goto L130;
        JSONObject r80 = z1.g(r79);
        if (r80 == null) goto L130;
        Iterator<String> r81 = r80.keys();
    L303:
    L127:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L129:
        Unit r82 = Unit.INSTANCE;
        goto L130
    L121:
        if (r81.hasNext() == false) goto L129;
        String r84 = r81.next();     // Catch: Exception -> L127
        if (r84 == null) goto L126;
        String r85 = r84;     // Catch: Exception -> L127
        r28.g(new Pair[]{TuplesKt.to(r85, r80.optString(r85))});     // Catch: Exception -> L127
        goto L303
    L126:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L127
    L130:
        Pair[] r86 = new Pair[2];
        ProductFeedViewModel r87 = r30.c;
        if (r87 == null) goto L137;
        AnchorV3Param r88 = r87.m907getAnchorV3Param();
        if (r88 == null) goto L137;
        ECLogExtraData r89 = r88.getLogExtraData();
        if (r89 == null) goto L137;
        String r90 = r89.getInflowRecommendType();
    L138:
        String r91 = "inflow_recommend_type";
        r86[0] = TuplesKt.to(r91, r90);
        if (r113 == null) goto L141;
        String r92 = r113.getEntranceInfo();
    L142:
        JSONObject r94 = z1.g(r92);
        String r95 = "selling_pt_info";
        if (r94 == null) goto L145;
        String r96 = r94.optString(r95);
    L146:
        r86[1] = TuplesKt.to(r95, r96);
        r28.g(r86);
        if (r21 == false) goto L158;
        if (r60 == null) goto L158;
        Iterator<String> r97 = r60.keys();
        if (r97 == null) goto L158;
    L152:
        if (r97.hasNext() == false) goto L157;
        String r98 = r97.next();
        List r99 = r65;
        Iterator<String> r710 = r97;
        if (r99.contains(r98) == false) goto L156;
        r28.g(new Pair[]{TuplesKt.to(r98, r60.optString(r98))});
    L156:
        r97 = r710;
        r65 = r99;
        goto L152
    L157:
        List r100 = r65;
        Unit r101 = Unit.INSTANCE;
    L159:
        Pair[] r102 = new Pair[5];
        int r103 = c.a;
        Promotion r104 = r73.f();
        if (r104 == null) goto L164;
        PromotionProductStruct r105 = r104.getPromotionInfo();
        if (r105 == null) goto L164;
        PromotionProductPriceStruct r106 = r105.getProductPrice();
    L165:
        r102[0] = TuplesKt.to("cost_price", String.valueOf(c.f(r106)));
        Promotion r107 = r73.f();
        if (r107 == null) goto L170;
        PromotionProductStruct r108 = r107.getPromotionInfo();
        if (r108 == null) goto L170;
        PromotionProductPriceStruct r109 = r108.getProductPrice();
    L171:
        r102[1] = TuplesKt.to("real_price", String.valueOf(c.k(r109)));
        Promotion r123 = r73.f();
        if (r123 == null) goto L176;
        PromotionProductStruct r124 = r123.getPromotionInfo();
        if (r124 == null) goto L176;
        PromotionProductPriceStruct r125 = r124.getProductPrice();
    L177:
        r102[2] = TuplesKt.to("max_sku_price", String.valueOf(c.g(r125)));
        Promotion r126 = r73.f();
        if (r126 == null) goto L182;
        PromotionProductStruct r127 = r126.getPromotionInfo();
        if (r127 == null) goto L182;
        PromotionProductPriceStruct r128 = r127.getProductPrice();
    L183:
        r102[3] = TuplesKt.to("min_sku_price", String.valueOf(c.j(r128)));
        if (r60 == null) goto L186;
        String r129 = r60.optString("friends_ecom_tag");
    L187:
        r102[4] = TuplesKt.to("friends_ecom_tag", r129);
        r28.g(r102);
        Unit r130 = Unit.INSTANCE;
    L189:
        if (r28 == null) goto L192;
        String r131 = r28.h();
        if (r131 == null) goto L192;
    L193:
        Lazy r132 = DataChecker.a;
        if (r113 == null) goto L199;
        ECLogExtraData r133 = r113.getLogExtraData();
        if (r133 == null) goto L199;
        String r134 = r133.getEnterFrom();
        if (r134 == null) goto L199;
    L200:
        DataChecker.a(r72, r134, "product_detail", r131);
        r18.put(r70, r131);
        Set r135 = j1.b(r29);
        Uri.Builder r136 = r29.buildUpon().clearQuery();
        ArrayList r137 = new ArrayList();
        r137.add("meta_params");
        r137.add("request_additions");
        String r138 = PdpOpenThirdParam.KEY_SOURCE_PAGE;
        r137.add(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        if (r135 == null) goto L211;
        Iterator r139 = r135.iterator();
    L204:
        if (r139.hasNext() == false) goto L210;
        Iterator r711 = r139;
        String r140 = (String) r139.next();
        if (CollectionsKt.contains(r137, r140) == true) goto L208;
        Uri r141 = r29;
        r136.appendQueryParameter(r140, UriProtector.getQueryParameter(r141, r140));
    L209:
        r139 = r711;
        r29 = r141;
        r137 = r137;
        r138 = r138;
        goto L204
    L208:
        r141 = r29;
        goto L209
    L210:
        String r210 = r138;
        Uri r142 = r29;
        Unit r143 = Unit.INSTANCE;
    L212:
        JSONObject r144 = new JSONObject();
        String r145 = UriProtector.getQueryParameter(r142, "module_label");
        JSONObject r146 = new JSONObject();
        if (r145 != null) goto L215;
        String r147 = "guess_you_like_product";
    L216:
        r146.put("module_label", r147);
        if (r113 == null) goto L219;
        String r148 = r113.getEntranceInfo();
    L220:
        JSONObject r149 = z1.g(r148);
        if (r149 == null) goto L223;
        String r150 = r149.optString(r61);
    L224:
        r146.put(r61, r150);
        Unit r151 = Unit.INSTANCE;
        r144.put("transmissible_json", r146);
        r144.put("inflow_product_card_mode", r30.m);
        if (r145 != null) goto L227;
        r145 = "guess_you_like_product";
    L227:
        r144.put("module_label", r145);
        ProductFeedViewModel r152 = r30.c;
        if (r152 == null) goto L234;
        AnchorV3Param r153 = r152.m907getAnchorV3Param();
        if (r153 == null) goto L234;
        ECLogExtraData r154 = r153.getLogExtraData();
        if (r154 == null) goto L234;
        String r155 = r154.getInflowRecommendType();
    L235:
        r144.put(r91, r155);
        ProductFeedViewModel r156 = r30.c;
        if (r156 == null) goto L242;
        AnchorV3Param r157 = r156.m907getAnchorV3Param();
        if (r157 == null) goto L242;
        Integer r158 = r157.getFollowStatus();
        if (r158 == null) goto L242;
        String r159 = String.valueOf(r158.intValue());
    L243:
        r144.put(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r159);
        r144.put("display_rank", r30.f);
        if (r113 == null) goto L246;
        String r160 = r113.getEntranceInfo();
    L247:
        JSONObject r161 = z1.g(r160);
        if (r161 == null) goto L250;
        String r162 = r161.optString(r95);
    L251:
        r144.put(r95, r162);
        if (r21 == false) goto L262;
        if (r60 == null) goto L262;
        Iterator<String> r163 = r60.keys();
        if (r163 == null) goto L262;
    L257:
        if (r163.hasNext() == false) goto L261;
        String r164 = r163.next();
        if (r100.contains(r164) == false) goto L257;
        r144.put(r164, r60.optString(r164));
        goto L257
    L261:
        Unit r165 = Unit.INSTANCE;
    L262:
        String r166 = UriProtector.getQueryParameter(r142, "request_additions");
        if (r166 == null) goto L266;
        JSONObject r167 = z1.g(r166);
        if (r167 == null) goto L266;
    L267:
        if (r113 == null) goto L271;
        AnchorV3PromotionRequestParam r168 = r113.getRequestParam();
        if (r168 == null) goto L271;
        String r169 = r168.getSecAuthorId();
    L272:
        r167.put(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r169);
        r167.put(r62, CollectionsKt.joinToString$default(r314, ",", null, null, 0, null, null, 62, null));
        int r170 = rk.c.a;
        if (r113 == null) goto L275;
        String r171 = r113.getEntranceInfo();
    L276:
        if (r28 == null) goto L278;
        String r172 = r28.h();
    L279:
        rk.c.a(r68, r171, r172);
        if (r113 == null) goto L282;
        String r173 = r113.getAuthorId();
    L283:
        Uri.Builder r174 = r136.appendQueryParameter("kol_id", r173);
        if (r113 == null) goto L286;
        String r175 = r113.getVideoId();
    L287:
        Uri.Builder r176 = r174.appendQueryParameter(PdpOpenThirdParam.KEY_ITEM_ID, r175);
        if (r113 == null) goto L292;
        ECLogExtraData r177 = r113.getLogExtraData();
        if (r177 == null) goto L292;
        String r178 = r177.getEnterFrom();
    L293:
        Uri.Builder r179 = r176.appendQueryParameter(r210, r178).appendQueryParameter("v3_events_additions", r144.toString()).appendQueryParameter("request_additions", r167.toString()).appendQueryParameter("meta_params", r18.toString());
        if (r113 == null) goto L296;
        r112 = r113.getEComEntranceFrom();
    L296:
        r5 = r179.appendQueryParameter("ecom_entrance_form", r112).appendQueryParameter(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(r26)).appendQueryParameter("inflow_feed_card_layout_pos", String.valueOf(r30.g)).build().toString();
    L292:
        r178 = null;
        goto L293
    L286:
        r175 = null;
        goto L287
    L282:
        r173 = null;
        goto L283
    L278:
        r172 = null;
        goto L279
    L275:
        r171 = null;
    L271:
        r169 = null;
    L266:
        r167 = new JSONObject();
        goto L267
    L250:
        r162 = null;
        goto L251
    L246:
        r160 = null;
    L242:
        r159 = null;
    L234:
        r155 = null;
        goto L235
    L223:
        r150 = null;
        goto L224
    L219:
        r148 = null;
        goto L220
    L215:
        r147 = r145;
        goto L216
    L211:
        r210 = PdpOpenThirdParam.KEY_SOURCE_PAGE;
        r142 = r29;
    L199:
        r134 = r121;
    L192:
        r131 = "{}";
        goto L193
    L186:
        r129 = null;
    L182:
        r128 = null;
    L176:
        r125 = null;
    L170:
        r109 = null;
    L164:
        r106 = null;
    L158:
        r100 = r65;
        goto L159
    L145:
        r96 = null;
        goto L146
    L141:
        r92 = null;
    L137:
        r90 = null;
        goto L138
    L102:
        r59 = null;
    L86:
        r57 = null;
    L80:
        r55 = null;
        goto L81
    L188:
        r61 = "aweme_type";
        r91 = "inflow_recommend_type";
        r95 = "selling_pt_info";
        r62 = "ecom_scene_id";
        r60 = r64;
        r100 = r65;
        r30 = r73;
    L68:
        r63 = "sellpoint_bp_video";
        r64 = r115;
        r67 = "previous_page";
        r69 = "anchor_detail_info";
        r66 = r110;
        r68 = r13;
        r70 = "entrance_info";
        r65 = r118;
        r121 = "";
        r122 = "share_type";
        r1 = r120;
        r23 = r14;
        goto L69
    L57:
        r22 = "";
        r310 = r22;
        r311 = null;
        r312 = null;
        r313 = null;
        r46 = null;
        r47 = null;
        r48 = null;
        r49 = null;
        r50 = null;
        r51 = null;
        r52 = null;
        r53 = null;
        goto L58
    L48:
        r117 = null;
    L53:
        r21 = true;
        goto L54
    L43:
        r116 = null;
    L39:
        r115 = null;
        goto L41
    L34:
        r113 = null;
    L30:
        r17 = new JSONObject();
    L298:
        String r180 = r5;
        int r181 = ECSdk.a;
        com.bytedance.android.ec.core.monitor.o r182 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r182 == null) goto L301;
        r182.a(r72, "inflow_feed_jump_good_detail", r180, null, VmSdkSetting.a().i());
    L301:
        Unit r183 = Unit.INSTANCE;
        r8.openSchema(r72, md3.a.a(r180, r74));
        return;
    L20:
        r13 = SourceType.UNKNOWN.getType();
        goto L21
    L321:
        return;
    }

    public static boolean g(Context r45, rd3.a r46, boolean r47, String r48, String r49) {
        Intrinsics.checkNotNullParameter(r45, "context");
        if (r46 != null) goto L5;
        return false;
    L5:
        ProductFeedViewModel r10 = r46.c;
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r46.f() != null) goto L11;
        return false;
    L11:
        InnerFlowAdRawData r11 = r46.a;
        if (r11 != null) goto L14;
        return false;
    L14:
        InnerFlowAdData r2 = r11.getAdData();
        if (r2 == null) goto L17;
        String r13 = r2.getOpenUrl();
    L19:
        if (com.bytedance.android.shopping.anchorv3.a.b(r13) == false) goto L276;
        AnchorV3Param r15 = r10.m907getAnchorV3Param();
        if (r47 == false) goto L28;
        if (r15 == null) goto L28;
        if (com.bytedance.android.shopping.anchorv3.a.c(r15) != true) goto L28;
        int r3 = k.a;
        JSONObject r4 = com.bytedance.android.shopping.anchorv3.a.a(r15);
        if (r4 == null) goto L31;
        new com.bytedance.android.shopping.feed.event.b(r4).post(null, null);
    L31:
        new com.bytedance.android.shopping.feed.event.a(r47, false).post(null, null);
        if (ECAppInfoService.e.i() == false) goto L46;
        ECToast r1 = ECToast.INSTANCE;
        StringBuilder r5 = new StringBuilder("当前是广告流量，cid: ");
        InnerFlowAdData r6 = r11.getAdData();
        if (r6 == null) goto L36;
        Long r7 = r6.getCreativeId();
    L37:
        r5.append(r7);
        r5.append(", promotion id: ");
        Promotion r8 = r46.f();
        if (r8 == null) goto L44;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L44;
        PromotionProductBaseStruct r12 = r9.getBaseInfo();
        if (r12 == null) goto L44;
        String r14 = r12.getPromotionId();
    L45:
        r5.append(r14);
        ECToast.showToast$default(r1, r45, r5.toString(), null, 4, null);
    L44:
        r14 = null;
        goto L45
    L36:
        r7 = null;
    L46:
        Uri r16 = UriProtector.parse(r13);
        if (r47 == false) goto L54;
        if (r15 == null) goto L54;
        if (com.bytedance.android.shopping.anchorv3.a.c(r15) != true) goto L54;
        JSONObject r17 = com.bytedance.android.shopping.anchorv3.a.a(r15);
        if (r17 == null) goto L60;
        r16 = l0.c(l0.c(r16, "creative_id", r17.optString("cid")), "log_extra", r17.optString("log_extra"));
    L60:
        com.bytedance.android.ec.sdk.helper.p r18 = com.bytedance.android.ec.sdk.helper.p.a;
        int r19 = md3.a.a;
        int r20 = a.a;
        String r21 = r16.toString();
        String r110 = r10.getEcomSceneId();
        boolean r22 = !r47;
        Intrinsics.checkNotNullParameter(r21, "schema");
        Intrinsics.checkNotNullParameter(r46, "anchorInflowFeedItem");
        Promotion r0 = r46.f();
        if (r0 == null) goto L274;
        PromotionProductStruct r23 = r0.getPromotionInfo();
        if (r23 == null) goto L274;
        Uri r24 = UriProtector.parse(r21);
        String r25 = UriProtector.getQueryParameter(r24, "meta_params");
        JsonObject r111 = new JsonObject();
        JsonObject r112 = new JsonObject();
        JsonObject r26 = (JsonObject) new Gson().fromJson(r25, JsonObject.class);     // Catch: Exception -> L75
        if (r26 == null) goto L69;
        r111 = r26;
    L69:
        JsonElement r27 = r111.get("entrance_info");     // Catch: Exception -> L75
        if ((r27 instanceof JsonObject) == true) goto L72;
        r27 = null;
    L72:
        JsonObject r28 = (JsonObject) r27;     // Catch: Exception -> L75
        if (r28 == null) goto L77;
        r112 = r28;
    L77:
        ProductFeedViewModel r29 = r46.c;
        if (r29 == null) goto L80;
        AnchorV3Param r113 = r29.m907getAnchorV3Param();
    L81:
        if (r113 == null) goto L85;
        String r30 = r113.getEntranceInfo();
        if (r30 == null) goto L85;
        JSONObject r31 = z1.g(r30);
    L86:
        JsonObject r210 = r111;
        if (r31 == null) goto L89;
        String r114 = r31.optString("share_previous_page");
        String r115 = r31.optString("is_show_new_coupon");
        String r116 = r31.optString("im_group_id");
        String r117 = r31.optString("share_object");
        String r211 = r31.optString("share_content");
        String r212 = r31.optString("share_type");
        String r213 = r31.optString("from_user_id");
        String r35 = r211;
        String r32 = r212;
        String r33 = r213;
        String r34 = r31.optString("search_params", "");
        String r36 = r31.optString("previous_page", "product_flow_page");
        String r214 = "";
        String r118 = r114;
        String r37 = r115;
        String r38 = r116;
        String r39 = r117;
    L90:
        ArrayList r119 = new ArrayList();
        if (a2.b(r110) == false) goto L99;
        if (r110 == null) goto L99;
        List r120 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
        if (r120 == null) goto L99;
        Iterator r121 = r120.iterator();
    L97:
        if (r121.hasNext() == false) goto L99;
        r119.add((String) r121.next());
        r121 = r121;
    L99:
        r119.add("1061");
        Iterator r122 = ((LinkedHashMap) r46.k).entrySet().iterator();
    L101:
        if (r122.hasNext() == false) goto L103;
        Map.Entry r123 = (Map.Entry) r122.next();
        Iterator r124 = r122;
        r112.addProperty((String) r123.getKey(), (String) r123.getValue());
        r119 = r119;
        r122 = r124;
        goto L101
    L103:
        ArrayList r125 = r119;
        r112.addProperty("previous_page", r36);
        if (r113 == null) goto L108;
        ECLogExtraData r40 = r113.getLogExtraData();
        if (r40 == null) goto L108;
        String r41 = r40.getEComEntranceForm();
    L109:
        r112.addProperty("source_method", r41);
        if (r22 == false) goto L112;
        r112.addProperty("enter_method", "click_guess_you_like_product");
        r112.addProperty("ecom_group_type", "product_card");
    L114:
        if ((!StringsKt.isBlank(r34)) == false) goto L116;
        r112.addProperty("search_params", r34);
    L116:
        r112.addProperty("button_status", CommerceButtonUtil.a(r23).getType());
        r112.addProperty("display_rank", Integer.valueOf(r46.f));
        r112.addProperty("product_source_page", "product_flow_page");
        int r42 = a.a;
        if (r22 == false) goto L119;
        String r126 = "guess_you_like_product";
    L120:
        r112.addProperty("module_label", r126);
        r112.addProperty("inflow_product_card_mode", r46.m);
        if (r118 == null) goto L123;
        r112.addProperty("share_previous_page", r118);
    L123:
        if (r37 == null) goto L125;
        r112.addProperty("is_show_new_coupon", r37);
    L125:
        if (r38 == null) goto L127;
        r112.addProperty("im_group_id", r38);
    L127:
        if (r39 == null) goto L129;
        r112.addProperty("share_object", r39);
    L129:
        if (r35 == null) goto L131;
        r112.addProperty("share_content", r35);
    L131:
        String r43 = r32;
        if (r43 == null) goto L134;
        r112.addProperty("share_type", r43);
    L134:
        String r44 = r33;
        if (r44 == null) goto L138;
        r112.addProperty("from_user_id", r44);
    L138:
        if (r31 == 0) goto L140;
        r112.addProperty("aweme_type", Integer.valueOf(r31.optInt("aweme_type")));
    L140:
        r112.addProperty("ecom_scene_id", CollectionsKt.joinToString$default(r125, ",", null, null, 0, null, null, 62, null));
        if (r49 == null) goto L143;
        r112.addProperty("action_type", r49);
    L143:
        Promotion r50 = r46.f();
        if (r50 == null) goto L163;
        PromotionProductStruct r51 = r50.getPromotionInfo();
        if (r51 == null) goto L163;
        PromotionProductExtraStruct r52 = r51.getExtraInfo();
        if (r52 == null) goto L163;
        String r53 = r52.getEntranceInfo();
        if (r53 == null) goto L163;
        JSONObject r54 = z1.g(r53);
        if (r54 == null) goto L163;
        Iterator<String> r55 = r54.keys();
    L280:
    L161:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L163
    L155:
        if (r55.hasNext() == false) goto L163;
        String r56 = r55.next();     // Catch: Exception -> L161
        if (r56 == null) goto L160;
        String r57 = r56;     // Catch: Exception -> L161
        r112.addProperty(r57, r54.optString(r57));     // Catch: Exception -> L161
        goto L280
    L160:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L161
    L163:
        ProductFeedViewModel r58 = r46.c;
        if (r58 == null) goto L170;
        AnchorV3Param r59 = r58.m907getAnchorV3Param();
        if (r59 == null) goto L170;
        ECLogExtraData r60 = r59.getLogExtraData();
        if (r60 == null) goto L170;
        String r61 = r60.getInflowRecommendType();
    L171:
        r112.addProperty("inflow_recommend_type", r61);
        if (r113 == 0) goto L174;
        String r62 = r113.getEntranceInfo();
    L175:
        JSONObject r63 = z1.g(r62);
        if (r63 == null) goto L178;
        String r64 = r63.optString("selling_pt_info");
    L179:
        r112.addProperty("selling_pt_info", r64);
        int r65 = c.a;
        Promotion r66 = r46.f();
        if (r66 == null) goto L184;
        PromotionProductStruct r67 = r66.getPromotionInfo();
        if (r67 == null) goto L184;
        PromotionProductPriceStruct r68 = r67.getProductPrice();
    L185:
        r112.addProperty("cost_price", String.valueOf(c.f(r68)));
        Promotion r69 = r46.f();
        if (r69 == null) goto L190;
        PromotionProductStruct r70 = r69.getPromotionInfo();
        if (r70 == null) goto L190;
        PromotionProductPriceStruct r71 = r70.getProductPrice();
    L191:
        r112.addProperty("real_price", String.valueOf(c.k(r71)));
        Promotion r72 = r46.f();
        if (r72 == null) goto L196;
        PromotionProductStruct r73 = r72.getPromotionInfo();
        if (r73 == null) goto L196;
        PromotionProductPriceStruct r74 = r73.getProductPrice();
    L197:
        r112.addProperty("max_sku_price", String.valueOf(c.g(r74)));
        Promotion r75 = r46.f();
        if (r75 == null) goto L202;
        PromotionProductStruct r76 = r75.getPromotionInfo();
        if (r76 == null) goto L202;
        PromotionProductPriceStruct r77 = r76.getProductPrice();
    L203:
        r112.addProperty("min_sku_price", String.valueOf(c.j(r77)));
        if (r113 == 0) goto L206;
        String r78 = r113.getEntranceInfo();
    L207:
        JSONObject r79 = z1.g(r78);
        if (r79 == null) goto L210;
        String r80 = r79.optString("friends_ecom_tag");
    L211:
        r112.addProperty("friends_ecom_tag", r80);
        r210.addProperty("entrance_info", r112.toString());
        String r127 = UriProtector.getQueryParameter(r24, "request_additions");
        if (r127 == null) goto L215;
        JSONObject r128 = z1.g(r127);
        if (r128 == null) goto L215;
    L216:
        String r129 = UriProtector.getQueryParameter(r24, "module_label");
        if (r22 == false) goto L219;
        r128.put("ecom_group_type", "product_card");
    L220:
        JSONObject r81 = new JSONObject();
        if (r129 != null) goto L223;
        String r82 = "guess_you_like_product";
    L224:
        r81.put("module_label", r82);
        if (r113 == 0) goto L227;
        String r84 = r113.getEntranceInfo();
    L228:
        JSONObject r85 = z1.g(r84);
        if (r85 == null) goto L231;
        String r86 = r85.optString("aweme_type");
    L232:
        r81.put("aweme_type", r86);
        Unit r87 = Unit.INSTANCE;
        r128.put("transmissible_json", r81);
        r128.put("inflow_product_card_mode", r46.m);
        if (r129 != null) goto L238;
        int r88 = a.a;
        if (r22 == false) goto L237;
        r214 = "guess_you_like_product";
    L237:
        r129 = r214;
    L238:
        r128.put("module_label", r129);
        ProductFeedViewModel r89 = r46.c;
        if (r89 == null) goto L245;
        AnchorV3Param r90 = r89.m907getAnchorV3Param();
        if (r90 == null) goto L245;
        ECLogExtraData r91 = r90.getLogExtraData();
        if (r91 == null) goto L245;
        String r92 = r91.getInflowRecommendType();
    L246:
        r128.put("inflow_recommend_type", r92);
        ProductFeedViewModel r94 = r46.c;
        if (r94 == null) goto L253;
        AnchorV3Param r95 = r94.m907getAnchorV3Param();
        if (r95 == null) goto L253;
        Integer r96 = r95.getFollowStatus();
        if (r96 == null) goto L253;
        String r97 = String.valueOf(r96.intValue());
    L254:
        r128.put(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r97);
        r128.put("display_rank", r46.f);
        if (r113 == 0) goto L257;
        String r98 = r113.getEntranceInfo();
    L258:
        JSONObject r99 = z1.g(r98);
        if (r99 == null) goto L261;
        String r100 = r99.optString("selling_pt_info");
    L262:
        r128.put("selling_pt_info", r100);
        String r101 = UriProtector.getQueryParameter(r24, "request_additions");
        if (r101 == null) goto L266;
        JSONObject r102 = z1.g(r101);
        if (r102 == null) goto L266;
    L267:
        if (r113 == 0) goto L271;
        AnchorV3PromotionRequestParam r103 = r113.getRequestParam();
        if (r103 == null) goto L271;
        String r130 = r103.getSecAuthorId();
    L272:
        r102.put(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r130);
        r102.put("ecom_scene_id", CollectionsKt.joinToString$default(r125, ",", null, null, 0, null, null, 62, null));
        r21 = l0.c(l0.c(l0.c(r24, "v3_events_additions", r128.toString()), "request_additions", r102.toString()), "meta_params", r210.toString()).toString();
    L271:
        r130 = null;
    L266:
        r102 = new JSONObject();
        goto L267
    L261:
        r100 = null;
        goto L262
    L257:
        r98 = null;
    L253:
        r97 = null;
    L245:
        r92 = null;
        goto L246
    L231:
        r86 = null;
        goto L232
    L227:
        r84 = null;
        goto L228
    L223:
        r82 = r129;
        goto L224
    L219:
        r128.put("ecom_group_type", "video");
    L215:
        r128 = new JSONObject();
        goto L216
    L210:
        r80 = null;
        goto L211
    L206:
        r78 = null;
    L202:
        r77 = null;
    L196:
        r74 = null;
    L190:
        r71 = null;
    L184:
        r68 = null;
        goto L185
    L178:
        r64 = null;
        goto L179
    L174:
        r62 = null;
    L170:
        r61 = null;
        goto L171
    L119:
        r126 = r214;
        goto L120
    L112:
        r112.addProperty("ecom_group_type", "video");
    L108:
        r41 = null;
        goto L109
    L89:
        r36 = "";
        r214 = r36;
        r34 = r214;
        r37 = null;
        r39 = null;
        r38 = null;
        r118 = null;
        r32 = null;
        r33 = null;
        r35 = null;
    L85:
        r31 = null;
        goto L86
    L80:
        r113 = null;
    L75:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L274:
        r18.openSchema(r45, md3.a.a(r21, r48));
        return true;
    L54:
        InnerFlowAdData r104 = r11.getAdData();
        if (r104 == null) goto L59;
        Long r105 = r104.getCreativeId();
        if (r105 == null) goto L59;
        r16 = l0.c(r16, "creative_id", String.valueOf(r105.longValue()));
    L59:
        r16 = l0.c(r16, "log_extra", r11.getLogExtra());
    L28:
        int r106 = k.a;
        InnerFlowAdRawData r107 = r46.a;
        if (r107 == null) goto L31;
        new com.bytedance.android.shopping.feed.event.c(r107).post(null, null);
        goto L31
    L276:
        int r108 = k.a;
        new com.bytedance.android.shopping.feed.event.a(r47, true).post(null, null);
        return false;
    L17:
        r13 = null;
        goto L19
    }

    @JvmStatic
    public static final void d(rd3.a r40, View r41, Fragment r42, com.bytedance.android.btm.api.model.d r43, sc3.a r44, Function1<? super SkuProductDetailInfo, Unit> r45) {
        Intrinsics.checkNotNullParameter(r41, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r42, "fragment");
        if (r40 == null) goto L249;
        final ProductFeedViewModel r2 = r40.c;
        if (r2 == null) goto L251;
        Promotion r3 = r40.f();
        if (r3 == null) goto L10;
        PromotionProductStruct r9 = r3.getPromotionInfo();
    L11:
        boolean r4 = r40.e;
        if (z53.b.a(r41.getId(), 800) == true) goto L250;
        if (r9 == null) goto L15;
        ActivityVO r5 = f53.a.c(r9);
    L17:
        if (r2.isExpanded() == true) goto L20;
        int r6 = ld3.c.a;
    L20:
        if (r40.e == false) goto L22;
        String r7 = "a1.b7365.c3865.d92097";
    L23:
        String r14 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r7, Boolean.FALSE).withView(r41).build());
        AnchorV3Param r8 = r2.m907getAnchorV3Param();
        if (r8 == null) goto L26;
        AnchorV3Param r10 = b(r8, r40);
    L27:
        boolean r11 = true;
        if (r40.e == true) goto L35;
        if (r10 == null) goto L35;
        if (com.bytedance.android.shopping.anchorv3.a.c(r10) != true) goto L35;
        int r12 = k.a;
        JSONObject r13 = com.bytedance.android.shopping.anchorv3.a.a(r10);
        if (r13 == null) goto L38;
        new com.bytedance.android.shopping.feed.event.b(r13).post(null, null);
    L38:
        Lazy r15 = DataChecker.a;
        Context r16 = r41.getContext();
        AnchorV3Param r17 = r2.m907getAnchorV3Param();
        if (r17 == null) goto L44;
        ECLogExtraData r18 = r17.getLogExtraData();
        if (r18 == null) goto L44;
        String r19 = r18.getEnterFrom();
        if (r19 == null) goto L44;
    L45:
        AnchorV3Param r110 = r2.m907getAnchorV3Param();
        if (r110 == null) goto L49;
        String r111 = r110.getEntranceInfo();
        if (r111 == null) goto L49;
    L50:
        DataChecker.a(r16, r19, "add_cart", r111);
        int r20 = ECSdk.a;
        IEShoppingService r21 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r21 == null) goto L65;
        ProductDetailPageParams r36 = new ProductDetailPageParams(null, null, null, false, false, null, null, null, 0, null, null, r2.getPageType(), null, null, null, null, 63487, null);
        if (r5 != null) goto L55;
    L59:
        r11 = false;
    L60:
        int r112 = b.a;
        Intrinsics.checkNotNullParameter(r40, "anchorInflowFeedItem");
        boolean r1 = r40.e;
        JSONObject r22 = new JSONObject();
        if (r1 == false) goto L63;
        r22.put("ecom_group_type", "product_card");
        r22.put("module_label", "guess_you_like_product");
    L64:
        r22.put("inflow_product_card_mode", r40.m);
        r22.put(PdpOpenThirdParam.KEY_CARRIER_TYPE, "product_flow_page");
        String r38 = "";
        PromotionProductStruct r23 = null;
        r21.onClickAddShopCartBtn(r42, r10, r36, r11, false, r9, "", r43, new InflowFeedPageParams(8L, r4, r44, r22.toString()), null, r2.getSkuPanelState(), new ProductFeedActionHelper$doOnAddCartClicked$1(r2), r45);
    L66:
        FeedProductEventTracker r24 = FeedProductEventTracker.a;
        Context r25 = r41.getContext();
        r24.getClass();
        ProductFeedViewModel r26 = r40.c;
        if (r26 == null) goto L252;
        Promotion r27 = r40.f();
        if (r27 == null) goto L72;
        PromotionProductStruct r113 = r27.getPromotionInfo();
    L73:
        boolean r28 = r40.e;
        TrackerProvider.a r29 = TrackerProvider.Companion;
        if (r25 == null) goto L81;
        PromotionProductStruct r30 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r25);
        if ((r30 instanceof FragmentActivity) == true) goto L79;
        r30 = r23;
    L79:
        FragmentActivity r31 = (FragmentActivity) r30;
        if (r31 == null) goto L81;
        Object r32 = ViewModelProviders.of(r31).get(TrackerProvider.class).getTracker();
        if ((r32 instanceof o1) == true) goto L85;
        r32 = r23;
    L85:
        PromotionProductStruct r33 = (o1) r32;
    L87:
        if (r33 == null) goto L91;
        HashMap<String, String> r34 = r33.a;
        if (r34 == null) goto L91;
        PromotionProductStruct r35 = (String) r34.get("entrance_info");
    L93:
        if (r35 != null) goto L245;
    L121:
        String r37 = r38;
    L122:
        jd3.e r39 = new jd3.e();
        AnchorV3Param r46 = r26.m907getAnchorV3Param();
        if (r46 == null) goto L125;
        PromotionProductStruct r47 = b(r46, r40);
    L126:
        if (r47 == null) goto L128;
        PromotionProductStruct r48 = r47.getSearchId();
    L129:
        r39.b = r48;
        if (r47 == null) goto L134;
        ECAdLogExtra r49 = r47.getAdLogExtra();
        if (r49 == null) goto L134;
        PromotionProductStruct r50 = r49.getAdExtraData();
    L136:
        if (cg4.a.a(r50) == false) goto L139;
        r39.a = r50;
    L139:
        if (r26.isExpanded() == false) goto L141;
        String r51 = "full_screen";
    L142:
        r39.e = r51;
        if (r113 == null) goto L151;
        PromotionProductPrivilegesStruct r52 = r113.getPrivilegeInfo();
        if (r52 == null) goto L151;
        PromotionProductCouponsStruct r53 = r52.getCoupons();
        if (r53 == null) goto L151;
        List r54 = r53.getDiscountLabels();
        if (r54 == null) goto L151;
        PromotionProductStruct r55 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r54);
    L152:
        r39.d = String.valueOf(com.bytedance.android.ec.model.response.anchorv3.c.a(r55));
        if (r113 == null) goto L163;
        PromotionProductPrivilegesStruct r56 = r113.getPrivilegeInfo();
        if (r56 == null) goto L163;
        PromotionProductCouponsStruct r57 = r56.getCoupons();
        if (r57 == null) goto L163;
        List r58 = r57.getDiscountLabels();
        if (r58 == null) goto L163;
        PromotionDiscountLabel r59 = (PromotionDiscountLabel) CollectionsKt.firstOrNull(r58);
        if (r59 == null) goto L163;
        PromotionProductStruct r60 = r59.getId();
    L164:
        r39.c = r60;
        if (r47 == null) goto L171;
        ECAdLogExtra r61 = r47.getAdLogExtra();
        if (r61 == null) goto L171;
        PromotionProductStruct r62 = r61.getCreativeId();
        if (r62 == null) goto L171;
    L172:
        r39.f = r62;
        if (r113 == null) goto L177;
        PromotionProductExtraStruct r63 = r113.getExtraInfo();
        if (r63 == null) goto L177;
        PromotionProductStruct r64 = r63.getShopId();
    L178:
        r39.g = r64;
        int r65 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        if (r113 == null) goto L183;
        PromotionProductExtraStruct r66 = r113.getExtraInfo();
        if (r66 == null) goto L183;
        PromotionProductStruct r67 = r66.getNeedCheck();
    L185:
        if (Intrinsics.areEqual(r67, Boolean.FALSE) == false) goto L187;
        String r68 = "0";
    L188:
        r39.h = r68;
        if (r113 == null) goto L193;
        PromotionProductBaseStruct r69 = r113.getBaseInfo();
        if (r69 == null) goto L193;
        PromotionProductStruct r114 = r69.getProductId();
    L194:
        r39.l = r114;
        if (r28 == false) goto L197;
        String r115 = "product_card";
    L198:
        r39.k = r115;
        if (r28 == false) goto L201;
        PromotionProductStruct r116 = "guess_you_like_product";
    L202:
        r39.m = r116;
        if (r47 == null) goto L210;
        String r70 = r47.getEntranceInfo();
        if (r70 == null) goto L210;
        JSONObject r71 = z1.g(r70);
        if (r71 == null) goto L210;
        r39.i = r71.optString("search_params", r37);
        r39.j = r71.optString("previous_page", r37);
    L210:
        if (r40.e == false) goto L212;
        r39.s = "product";
    L213:
        r39.n = r40.m;
        int r72 = c.a;
        Promotion r73 = r40.f();
        if (r73 == null) goto L218;
        PromotionProductStruct r74 = r73.getPromotionInfo();
        if (r74 == null) goto L218;
        PromotionProductStruct r117 = r74.getProductPrice();
    L219:
        r39.o = String.valueOf(c.f(r117));
        Promotion r75 = r40.f();
        if (r75 == null) goto L224;
        PromotionProductStruct r76 = r75.getPromotionInfo();
        if (r76 == null) goto L224;
        PromotionProductStruct r118 = r76.getProductPrice();
    L225:
        r39.p = String.valueOf(c.k(r118));
        Promotion r77 = r40.f();
        if (r77 == null) goto L230;
        PromotionProductStruct r78 = r77.getPromotionInfo();
        if (r78 == null) goto L230;
        PromotionProductStruct r119 = r78.getProductPrice();
    L231:
        r39.q = String.valueOf(c.j(r119));
        Promotion r0 = r40.f();
        if (r0 == null) goto L236;
        PromotionProductStruct r79 = r0.getPromotionInfo();
        if (r79 == null) goto L236;
        PromotionProductStruct r120 = r79.getProductPrice();
    L237:
        r39.r = String.valueOf(c.g(r120));
        if (r14 != null) goto L240;
    L242:
        com.bytedance.android.shopping.feed.event.g.d(r39, r25);
        return;
    L240:
        if (a2.d(r14) == null) goto L242;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r39.appendParam("btm_id", r14, com.bytedance.android.ec.core.event.a.b.a.a);
    L236:
        r120 = r23;
    L230:
        r119 = r23;
    L224:
        r118 = r23;
    L218:
        r117 = r23;
        goto L219
    L212:
        r39.s = "video";
        goto L213
    L201:
        r116 = r23;
        goto L202
    L197:
        r115 = r10;
    L193:
        r114 = r23;
        goto L194
    L187:
        r68 = "1";
    L183:
        r67 = r23;
    L177:
        r64 = r23;
    L171:
        r62 = r23;
    L163:
        r60 = r23;
    L151:
        r55 = r23;
        goto L152
    L141:
        r51 = "half_screen";
    L134:
        r50 = r23;
        goto L136
    L128:
        r48 = r23;
        goto L129
    L125:
        r47 = r23;
        goto L126
    L245:
        JSONObject r80 = new JSONObject(r35);     // Catch: Exception -> L120
        if (r28 == false) goto L97;
        Object r121 = "product";
    L98:
        if (r28 == false) goto L100;
        String r81 = "product";
    L101:
        r80.putOpt("bst_form_info", r121);     // Catch: Exception -> L120
        r80.putOpt("bst_group_type", r81);     // Catch: Exception -> L120
        if (r25 == null) goto L109;
        PromotionProductStruct r82 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r25);     // Catch: Exception -> L120
        if ((r82 instanceof FragmentActivity) == true) goto L107;
        r82 = r23;
    L107:
        FragmentActivity r84 = (FragmentActivity) r82;     // Catch: Exception -> L120
        if (r84 == null) goto L109;
        Object r85 = ViewModelProviders.of(r84).get(TrackerProvider.class).getTracker();     // Catch: Exception -> L120
        if ((r85 instanceof o1) == true) goto L113;
        r85 = r23;
    L113:
        PromotionProductStruct r86 = (o1) r85;     // Catch: Exception -> L120
    L114:
        if (r86 == null) goto L121;
        r37 = r38;
        r86.c("entrance_info", r80.toString(), r37);     // Catch: Exception -> L244
    L109:
        r86 = r23;
        goto L114
    L100:
        r81 = r38;
        goto L101
    L97:
        r121 = r10;
    L120:
        r37 = r38;
    L91:
        r35 = r23;
    L81:
        r33 = r23;
        goto L87
    L72:
        r113 = r23;
        goto L73
    L252:
        return;
    L63:
        r22.put("ecom_group_type", "video");
        goto L64
    L55:
        if (r5.getActivityType() != 1) goto L59;
        if (r5.isOnActivity() == false) goto L59;
    L65:
        r38 = "";
        r23 = null;
    L49:
        r111 = "";
    L44:
        r19 = "";
    L35:
        int r87 = k.a;
        InnerFlowAdRawData r88 = r40.a;
        if (r88 == null) goto L38;
        new com.bytedance.android.shopping.feed.event.c(r88).post(null, null);
        goto L38
    L26:
        r10 = null;
        goto L27
    L22:
        r7 = "a1.b7365.c4701.d39232";
        goto L23
    L15:
        r5 = null;
        goto L17
    L250:
        return;
    L10:
        r9 = null;
        goto L11
    L251:
        return;
    }

    public static void c(Fragment r81, PromotionProductStruct r82, View r84, ProductFeedViewModel r85, boolean r86, String r87, String r88) {
        Intrinsics.checkNotNullParameter(r81, "fragment");
        Intrinsics.checkNotNullParameter(r82, "promotion");
        Intrinsics.checkNotNullParameter(r84, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r85, "viewModel");
        if (z53.b.a(r84.getId(), 800) == true) goto L140;
        AnchorV3Param r1 = r85.m907getAnchorV3Param();
        com.bytedance.android.shopping.sameproduct.helper.c r5 = new com.bytedance.android.shopping.sameproduct.helper.c(r84.getContext());
        PromotionProductBaseStruct r6 = r82.getBaseInfo();
        if (r6 == null) goto L10;
        String r7 = r6.getProductId();
        if (r7 == null) goto L10;
        String r8 = r7;
    L11:
        PromotionProductBaseStruct r9 = r82.getBaseInfo();
        if (r9 == null) goto L17;
        String r10 = r9.getPromotionId();
        if (r10 == null) goto L17;
        String r11 = r10;
    L18:
        PromotionProductBaseStruct r2 = r82.getBaseInfo();
        if (r2 == null) goto L21;
        boolean r12 = r2.isGoodUnAvailable();
    L22:
        InnerFlowPageStyleDTO r3 = r85.getInnerFlowPageStyle();
        if (r3 == null) goto L29;
        PageStyle r4 = r3.getPageStyle();
        if (r4 == null) goto L29;
        Integer r13 = r4.getSameProductStyle();
        if (r13 == null) goto L29;
        int r14 = r13.intValue();
    L30:
        boolean r15 = r85.isExpanded();
        if (r1 == null) goto L33;
        String r16 = r1.getAuthorId();
    L34:
        if (r1 == null) goto L36;
        String r17 = r1.getSecAuthorId();
    L37:
        com.bytedance.android.ec.sdk.helper.r r18 = com.bytedance.android.ec.sdk.helper.r.a;
        String r19 = r18.getCurrentUserId();
        String r110 = r18.f();
        if (r1 == null) goto L40;
        String r111 = r1.getVideoId();
    L41:
        if (r1 == null) goto L45;
        ECAnchorV3ExtraData r20 = r1.getAnchorV3ExtraData();
        if (r20 == null) goto L45;
        String r112 = r20.getShopId();
    L46:
        if (r1 == null) goto L50;
        ECLogExtraData r21 = r1.getLogExtraData();
        if (r21 == null) goto L50;
        String r113 = r21.getEnterFrom();
    L51:
        if (r1 == null) goto L53;
        Integer r22 = r1.getFollowStatus();
    L54:
        if (r1 == null) goto L58;
        ECLogExtraData r23 = r1.getLogExtraData();
        if (r23 == null) goto L58;
        String r24 = r23.getEComEntranceForm();
    L59:
        if (r1 == null) goto L63;
        AnchorV3PromotionRequestParam r25 = r1.getRequestParam();
        if (r25 == null) goto L63;
        String r26 = r25.getMetaParam();
    L64:
        if (r1 == null) goto L66;
        String r27 = r1.getEntranceInfo();
    L68:
        if (r1 == null) goto L70;
        AnchorV3PromotionRequestParam r28 = r1.getRequestParam();
    L71:
        m r29 = r85.getInnerGuessULikeFiltersHelper();
        ArrayList<String> r114 = r29.b;
        Iterator<String> r30 = r29.a.iterator();
    L73:
        if (r30.hasNext() == false) goto L75;
        r114.remove(r30.next());
        goto L73
    L75:
        AnchorV3Param r31 = r85.m907getAnchorV3Param();
        if (r31 == null) goto L78;
        String r210 = r31.getV3EventsAdditions();
    L79:
        SameProductPageParams r32 = new SameProductPageParams(r8, r11, r12, r14, r86, r15, r16, r17, r19, r110, r111, r112, r113, r22, r24, r26, r27, null, r210, null, r28, r87, r88, r114, 655360, null);
        Intrinsics.checkNotNullParameter(r32, "params");
        Intrinsics.checkNotNullParameter(r81, "parentFragment");
        Activity r33 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(r5.b);
        if (r33 != null) goto L82;
        r33 = ECAppInfoService.e.getCurrentActivity();
    L82:
        if (r33 == null) goto L141;
        Intrinsics.checkNotNullParameter(r32, "params");
        Intrinsics.checkNotNullParameter(r33, "activity");
        ShoppingAsyncInflater.e.getClass();
        com.bytedance.android.ec.opt.asyncInflate.d r34 = ShoppingAsyncInflater.a.a(r33).a();
        int r35 = 2;
        if (r32.getSameProductStyle() != 1) goto L88;
        r34.a(2131560716, 1).commit();
    L91:
        if (TextUtils.isEmpty(r32.getMainPromotionId()) == false) goto L93;
    L117:
        ECExceptionMonitor.c("传入的初始化参数存在异常");
    L118:
        com.bytedance.android.ec.sdk.helper.r r36 = com.bytedance.android.ec.sdk.helper.r.a;
        JSONObject r37 = r5.a;
        if (r37 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("entranceInfoJSONObject");
    L121:
        Map r38 = MapsKt.mapOf(TuplesKt.to("ecom_scene_id", r37.optString("ecom_scene_id")));
        List r39 = CollectionsKt.listOf(r32.getMainPromotionId());
        String r115 = r32.getVideoId();
        if (r115 != null) goto L124;
        String r310 = "";
    L125:
        String r116 = r32.getSecAuthorId();
        if (r116 != null) goto L128;
        String r311 = "";
    L129:
        String r312 = String.valueOf(r32.getMetaParams());
        String r117 = r32.getEnterFrom();
        if (r117 != null) goto L132;
        String r40 = "";
    L133:
        String r42 = r36.getCurrentUserId();
        String r43 = r36.f();
        String r44 = r32.getRequestAdditions();
        Integer r46 = Integer.valueOf(UIUtils.getScreenWidth(r5.b));
        Integer r47 = Integer.valueOf(UIUtils.getScreenWidth(r5.b));
        String r45 = r32.getAuthorId();
        Boolean r53 = Boolean.TRUE;
        int r41 = com.bytedance.android.shopping.anchorv3.utils.x.a;
        Map r54 = MapsKt.plus(com.bytedance.android.shopping.anchorv3.utils.x.b(r5.b), r38);
        if (r32.isFromFlowGuessULike() == true) goto L137;
        r35 = 1;
    L137:
        r32.setMainCardRequestParam(new AnchorV3PromotionRequestParam(r39, null, r310, r311, r312, r40, null, r42, r43, r44, r45, r46, r47, null, 7, null, null, null, r53, r54, null, null, null, null, null, Integer.valueOf(r35), null, null, null, null, false, null, null, false, false, null, null, null, null, null, null, null, null, -34365374, 2047, null));
        int r48 = SameProductListFragment.w;
        Intrinsics.checkNotNullParameter(r32, "params");
        SameProductListFragment r49 = new SameProductListFragment();
        Bundle r50 = new Bundle();
        r50.putSerializable("param_key", r32);
        Unit r51 = Unit.INSTANCE;
        r49.setArguments(r50);
        r49.Y90(r33, r81.getChildFragmentManager());
        return;
    L132:
        r40 = r117;
        goto L133
    L128:
        r311 = r116;
        goto L129
    L124:
        r310 = r115;
        goto L125
    L93:
        if (TextUtils.isEmpty(r32.getMainProductId()) == true) goto L117;
        if (r32.getSameProductStyle() <= 0) goto L117;
        String r52 = r32.getEntranceInfo();
        if (r52 == null) goto L101;
        JSONObject r55 = z1.g(r52);
        if (r55 == null) goto L101;
    L102:
        r5.a = r55;
        r55.put("inflow_landing_page_type", "product_inflow_similar_tab");
        if (r32.isFromFlowGuessULike() == false) goto L105;
        r55.put("module_label", "guess_you_like_product");
        r55.put("from_product_module_label", "guess_you_like_product");
    L105:
        r55.put("product_source_page", "product_flow_page");
        r55.put("carrier_source", r32.getEnterFrom());
        r55.put("source_method", r32.getEcomEntranceForm());
        int r56 = com.bytedance.android.shopping.utils.w.a;
        String r57 = r32.getMetaParams();
        if (r57 == null) goto L109;
        JSONObject r58 = z1.g(r57);
        if (r58 == null) goto L109;
    L110:
        JSONObject r59 = r5.a;
        if (r59 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("entranceInfoJSONObject");
    L113:
        com.bytedance.android.shopping.utils.w.a(r58, r59.toString());
        JSONObject r60 = r5.a;
        if (r60 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("entranceInfoJSONObject");
    L116:
        r32.setEntranceInfo(r60.toString());
    L109:
        r58 = new JSONObject();
    L101:
        r55 = new JSONObject();
        goto L102
    L88:
        if (r32.getSameProductStyle() != 2) goto L91;
        r34.a(2131560716, 1).a(2131560573, 4).commit();
        goto L91
    L141:
        return;
    L78:
        r210 = null;
        goto L79
    L70:
        r28 = null;
        goto L71
    L66:
        r27 = null;
    L63:
        r26 = null;
    L58:
        r24 = null;
        goto L59
    L53:
        r22 = null;
    L50:
        r113 = null;
    L45:
        r112 = null;
        goto L46
    L40:
        r111 = null;
        goto L41
    L36:
        r17 = null;
        goto L37
    L33:
        r16 = null;
    L29:
        r14 = 0;
        goto L30
    L21:
        r12 = false;
    L17:
        r11 = "";
    L10:
        r8 = "";
        goto L11
    }

    public static void h(View r84, rd3.a r85, String r86, String r87, String r88, String r89, int r90) {
        if ((r90 & 4) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r90 & 8) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r90 & 32) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r90 & 64) == 0) goto L17;
        String r4 = null;
    L18:
        Intrinsics.checkNotNullParameter(r84, FreqActions.ACTION_VIEW);
        if (r85 == null) goto L23;
        Promotion r5 = r85.f();
        if (r5 == null) goto L23;
        PromotionProductStruct r6 = r5.getPromotionInfo();
    L24:
        if (r85 == null) goto L297;
        ProductFeedViewModel r7 = r85.c;
        if (r7 == null) goto L305;
        if (r6 == null) goto L294;
        PromotionProductBaseStruct r9 = r6.getBaseInfo();
        if (r9 == null) goto L32;
        String r10 = r9.getPromotionId();
    L33:
        boolean r11 = true;
        if (r10 != null) goto L36;
    L39:
        boolean r12 = true;
    L40:
        if (r12 == true) goto L294;
        if (r85.a == null) goto L48;
        if (g(r84.getContext(), r85, true, r1, "click") == false) goto L48;
        return;
    L48:
        if (z53.b.a(r84.getId(), 800) == true) goto L298;
        AnchorV3Param r13 = r7.m907getAnchorV3Param();
        if (r13 == null) goto L299;
        int r14 = rk.a.a;
        gl.a r15 = rk.a.a("flow_card_to_detail", r13.getEntranceInfo());
        if (r15 == null) goto L86;
        String r16 = r15.getString("previous_page");
        if (r16 != null) goto L56;
    L59:
        boolean r17 = true;
    L60:
        if (r17 == false) goto L62;
        r15.g(new Pair[]{TuplesKt.to("previous_page", "product_flow_page")});
    L62:
        Pair[] r2 = new Pair[8];
        r2[0] = TuplesKt.to("group_id", r13.getRequestParam().getItemId());
        PromotionProductBaseStruct r18 = r6.getBaseInfo();
        if (r18 == null) goto L65;
        String r19 = r18.getPromotionId();
    L66:
        r2[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_ID, r19);
        r2[2] = TuplesKt.to("action_type", r1);
        r2[3] = TuplesKt.to("display_rank", Integer.valueOf(r85.f));
        int r110 = c.a;
        r2[4] = TuplesKt.to("cost_price", String.valueOf(c.f(r6.getProductPrice())));
        r2[5] = TuplesKt.to("real_price", String.valueOf(c.k(r6.getProductPrice())));
        r2[6] = TuplesKt.to("max_sku_price", String.valueOf(c.g(r6.getProductPrice())));
        r2[7] = TuplesKt.to("min_sku_price", String.valueOf(c.j(r6.getProductPrice())));
        r15.g(r2);
        if (r3 != null) goto L69;
    L74:
        if (r4 != null) goto L76;
    L81:
        Iterator r20 = ((LinkedHashMap) r85.k).entrySet().iterator();
    L83:
        if (r20.hasNext() == false) goto L85;
        Map.Entry r21 = (Map.Entry) r20.next();
        r15.g(new Pair[]{TuplesKt.to(r21.getKey(), r21.getValue())});
        goto L83
    L85:
        Unit r22 = Unit.INSTANCE;
        goto L86
    L76:
        if (com.bytedance.android.shopping.anchorv3.a.b(r4) == true) goto L79;
        r4 = null;
    L79:
        if (r4 == null) goto L81;
        r15.g(new Pair[]{TuplesKt.to("search_id", r4)});
        Unit r23 = Unit.INSTANCE;
        goto L81
    L69:
        if (com.bytedance.android.shopping.anchorv3.a.b(r3) == true) goto L72;
        r3 = null;
    L72:
        if (r3 == null) goto L74;
        r15.g(new Pair[]{TuplesKt.to("inflow_main_card_location", r3)});
        Unit r24 = Unit.INSTANCE;
        goto L74
    L65:
        r19 = null;
        goto L66
    L56:
        if (r16.length() == 0) goto L59;
        r17 = false;
    L86:
        Lazy r25 = DataChecker.a;
        Context r26 = r84.getContext();
        ECLogExtraData r27 = r13.getLogExtraData();
        if (r27 == null) goto L90;
        String r28 = r27.getEnterFrom();
        if (r28 == null) goto L90;
    L91:
        if (r15 == null) goto L94;
        String r111 = r15.h();
        if (r111 == null) goto L94;
    L95:
        DataChecker.a(r26, r28, "product_detail", r111);
        int r29 = rk.c.a;
        String r30 = r13.getEntranceInfo();
        if (r15 == null) goto L98;
        String r31 = r15.h();
    L99:
        rk.c.a("flow_card_to_detail", r30, r31);
        if (com.bytedance.android.ec.core.opt.ab.u.d() == 1) goto L104;
        r11 = false;
    L104:
        if (r11 == false) goto L197;
        int r32 = ECSdk.a;
        IShoppingAbilities r112 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r112 == null) goto L300;
        Context r113 = r84.getContext();
        PromotionProductBaseStruct r33 = r6.getBaseInfo();
        if (r33 == null) goto L110;
        String r34 = r33.getPromotionId();
    L111:
        if (r34 != null) goto L113;
        r34 = "";
    L113:
        ECLogExtraData r35 = r13.getLogExtraData();
        if (r35 == null) goto L117;
        String r36 = r35.getEnterFrom();
        if (r36 == null) goto L117;
    L118:
        df.r r114 = new df.r(r34, r36);
        int r37 = df.p.Y;
        PromotionProductBaseStruct r38 = r6.getBaseInfo();
        if (r38 == null) goto L121;
        String r39 = r38.getProductId();
    L122:
        if (r39 != null) goto L124;
        String r115 = "";
    L125:
        String r40 = r13.getRequestParam().getItemId();
        if (r40 != null) goto L128;
        String r41 = "";
    L129:
        String r42 = r13.getRequestParam().getAuthorId();
        if (r42 != null) goto L132;
        r42 = "";
    L132:
        String r116 = r13.getRequestParam().getSecAuthorId();
        String r43 = r1;
        if (r15 == null) goto L135;
        String r117 = r15.h();
    L136:
        JSONObject r118 = z1.g(r117);
        if (r118 != null) goto L139;
        r118 = new JSONObject();
    L139:
        int r119 = b.a;
        String r44 = b.a(r85, r7.getEcomSceneId(), null);
        String r45 = r13.getRequestParam().getMetaParam();
        if (r45 == null) goto L142;
        JSONObject r46 = z1.f(r45);
    L143:
        ECLogExtraData r120 = r13.getLogExtraData();
        if (r120 == null) goto L146;
        String r121 = r120.getV3EventsAdditions();
    L147:
        JSONObject r122 = z1.f(r121);
        ECLogExtraData r123 = r13.getLogExtraData();
        if (r123 == null) goto L150;
        String r124 = r123.getInflowRecommendType();
    L151:
        r122.put("inflow_recommend_type", r124);
        r122.put("inflow_product_card_mode", r85.m);
        Unit r0 = Unit.INSTANCE;
        PromotionProductBaseStruct r47 = r6.getBaseInfo();
        if (r47 == null) goto L160;
        List r48 = r47.getImages();
        if (r48 == null) goto L160;
        ECUrlModel r49 = (ECUrlModel) CollectionsKt.getOrNull(r48, 0);
        if (r49 == null) goto L160;
        List r50 = r49.getUrlList();
        if (r50 == null) goto L160;
        String r51 = (String) CollectionsKt.getOrNull(r50, 0);
    L161:
        Integer r52 = r13.getFollowStatus();
        ECAdLogExtra r53 = r13.getAdLogExtra();
        if (r53 == null) goto L164;
        String r410 = r53.getCreativeId();
    L165:
        ECAdLogExtra r54 = r13.getAdLogExtra();
        if (r54 == null) goto L168;
        String r411 = r54.getLogExtra();
    L169:
        ECAdLogExtra r55 = r13.getAdLogExtra();
        if (r55 == null) goto L172;
        String r412 = r55.getAdExtraData();
    L173:
        ECBoltParam r56 = r13.getBoltParam();
        if (r56 == null) goto L176;
        String r310 = r56.getActivityId();
    L177:
        ECBoltParam r57 = r13.getBoltParam();
        if (r57 == null) goto L180;
        String r413 = r57.getNewSourceId();
    L181:
        Boolean r125 = Boolean.TRUE;
        Boolean r210 = Boolean.valueOf(r13.isLuban());
        LubanParam r58 = r13.getRequestParam().getLubanParam();
        if (r58 == null) goto L184;
        String r211 = r58.getPageId();
    L185:
        ECLogExtraData r59 = r13.getLogExtraData();
        if (r59 == null) goto L191;
        String r60 = r59.getEnterMethod();
        if (r60 == null) goto L191;
        String r212 = r60;
    L192:
        ECLogExtraData r61 = r13.getLogExtraData();
        if (r61 == null) goto L195;
        String r213 = r61.getEComEntranceForm();
    L196:
        JSONObject r214 = z1.f(r13.getRequestParam().getRequestAdditions());
        Boolean r414 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r115, "productId");
        Intrinsics.checkNotNullParameter(r41, "itemId");
        Intrinsics.checkNotNullParameter(r42, "authorId");
        Intrinsics.checkNotNullParameter(r116, "secAuthorId");
        Intrinsics.checkNotNullParameter("product_flow_page", "productSourcePage");
        Intrinsics.checkNotNullParameter(r44, "transitionTrackerData");
        Intrinsics.checkNotNullParameter(r118, "entranceInfo");
        Intrinsics.checkNotNullParameter(r46, "metaParam");
        Intrinsics.checkNotNullParameter(r122, "v3EventsAdditions");
        df.q r510 = new df.q(null, null, null, null, null, null, r44, null);
        r112.openPDP(r113, r114, new df.p(r115, null, null, r51, null, r42, r116, r52, r41, null, r125, r125, null, r125, r118, null, r46, r214, r210, r211, null, null, r212, r213, r122, r510, null, r43, null, null, null, null, false, true, null, r310, r413, r410, r411, r412, null, null, null, r414, "product_flow_page", null, null, null, null, null, 0, 196608), null);
        return;
    L195:
        r213 = null;
    L191:
        r212 = "";
        goto L192
    L184:
        r211 = null;
        goto L185
    L180:
        r413 = null;
        goto L181
    L176:
        r310 = null;
        goto L177
    L172:
        r412 = null;
        goto L173
    L168:
        r411 = null;
        goto L169
    L164:
        r410 = null;
    L160:
        r51 = null;
        goto L161
    L150:
        r124 = null;
        goto L151
    L146:
        r121 = null;
        goto L147
    L142:
        r46 = new JSONObject();
        goto L143
    L135:
        r117 = null;
        goto L136
    L128:
        r41 = r40;
        goto L129
    L124:
        r115 = r39;
        goto L125
    L121:
        r39 = null;
    L117:
        r36 = "";
        goto L118
    L110:
        r34 = null;
        goto L111
    L300:
        return;
    L197:
        String r415 = r1;
        BtmSDK r62 = BtmSDK.INSTANCE;
        PageFinder r63 = PageFinder.via(r84);
        BcmParams r126 = new BcmParams();
        r126.put("bst_group_type", "video");
        int r127 = vd3.a.a;
        PromotionProductExtraStruct r128 = r6.getExtraInfo();
        if (r128 == null) goto L202;
        String r129 = r128.getLogExtra();
        if (r129 == null) goto L202;
        String r130 = com.bytedance.commerce.base.json.b.a(r129).optString("standard_chain_param");
    L203:
        vd3.a.a(r126, r130);
        Unit r131 = Unit.INSTANCE;
        String r64 = r62.createJumpSourceBtmToken("c4701.d5727", r63, r126);
        int r65 = ECSdk.a;
        IEShoppingService r66 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r66 == null) goto L302;
        p83.d r416 = r66.getAnchorV3Service();
        if (r416 == null) goto L303;
        Context r417 = r84.getContext();
        PromotionProductBaseStruct r67 = r6.getBaseInfo();
        if (r67 == null) goto L210;
        String r68 = r67.getPromotionId();
    L211:
        if (r68 != null) goto L213;
        String r511 = "";
    L214:
        PromotionProductBaseStruct r69 = r6.getBaseInfo();
        if (r69 == null) goto L217;
        String r512 = r69.getProductId();
    L218:
        PromotionProductBaseStruct r70 = r6.getBaseInfo();
        if (r70 == null) goto L228;
        List r71 = r70.getImages();
        if (r71 == null) goto L228;
        ECUrlModel r72 = (ECUrlModel) CollectionsKt.getOrNull(r71, 0);
        if (r72 == null) goto L228;
        List r73 = r72.getUrlList();
        if (r73 == null) goto L228;
        String r610 = (String) CollectionsKt.getOrNull(r73, 0);
    L229:
        PromotionProductBaseStruct r74 = r6.getBaseInfo();
        if (r74 == null) goto L232;
        Integer r75 = r74.getPromotionSource();
    L233:
        long r611 = com.bytedance.android.shopping.extensions.c.a(r75, SourceType.UNKNOWN.getType());
        PromotionProductExtraStruct r76 = r6.getExtraInfo();
        if (r76 == null) goto L238;
        Map r77 = r76.getExtra();
        if (r77 == null) goto L238;
        String r78 = (String) r77.get("channel_id");
    L239:
        PromotionProductExtraStruct r79 = r6.getExtraInfo();
        if (r79 == null) goto L246;
        Map r80 = r79.getExtra();
        if (r80 == null) goto L246;
        String r81 = (String) r80.get("channel_type");
        if (r81 == null) goto L246;
        int r132 = CastIntegerProtector.parseInt(r81);
    L247:
        ECProductInfo r418 = new ECProductInfo(r511, r512, null, null, 0, null, r610, null, r611, 0, null, null, null, null, null, null, null, r78, Integer.valueOf(r132), null, null, null, null, 7995068, null);
        String r133 = r13.getRequestParam().getItemId();
        String r82 = r13.getRequestParam().getAuthorId();
        if (r82 != null) goto L250;
        String r134 = "";
    L251:
        String r91 = r13.getRequestParam().getSecAuthorId();
        if (r91 != null) goto L254;
        String r135 = "";
    L255:
        ECAwemeItemInfo r419 = new ECAwemeItemInfo(r133, r134, r135, r13.getFollowStatus(), false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048560, null);
        String r92 = r13.getRequestParam().getMetaParam();
        if (r92 == null) goto L258;
        JSONObject r94 = z1.f(r92);
    L259:
        JSONObject r420 = r94;
        ECAdLogExtra r421 = r13.getAdLogExtra();
        ECBoltParam r422 = r13.getBoltParam();
        if (r15 == null) goto L262;
        String r423 = r15.h();
    L263:
        String r424 = r13.isReceptor();
        ECProductDetailPageShowStyle r513 = new ECProductDetailPageShowStyle(true, false, 0, true, 6, null);
        boolean r136 = r13.isLuban();
        LubanParam r95 = r13.getRequestParam().getLubanParam();
        if (r95 == null) goto L266;
        String r137 = r95.getPageId();
    L267:
        ECLubanData r514 = new ECLubanData(r136, r137, null, null, 12, null);
        ECLogExtraData r96 = r13.getLogExtraData();
        if (r96 == null) goto L273;
        String r97 = r96.getEnterFrom();
        if (r97 == null) goto L273;
        String r515 = r97;
    L274:
        ECLogExtraData r98 = r13.getLogExtraData();
        if (r98 == null) goto L280;
        String r99 = r98.getEnterMethod();
        if (r99 == null) goto L280;
        String r516 = r99;
    L281:
        ECLogExtraData r100 = r13.getLogExtraData();
        if (r100 == null) goto L284;
        String r517 = r100.getEComEntranceForm();
    L285:
        ECLogExtraData r101 = r13.getLogExtraData();
        if (r101 == null) goto L288;
        String r102 = r101.getV3EventsAdditions();
    L289:
        JSONObject r103 = z1.f(r102);
        ECLogExtraData r104 = r13.getLogExtraData();
        if (r104 == null) goto L292;
        String r105 = r104.getInflowRecommendType();
    L293:
        r103.put("inflow_recommend_type", r105);
        r103.put("inflow_product_card_mode", r85.m);
        String r612 = r103.toString();
        int r106 = b.a;
        p83.d.a.b(r416, r417, r418, r419, r420, r421, r422, r423, r64, r424, r513, r514, new ECLogExtraData(r515, r516, r517, r612, null, null, null, "product_flow_page", null, null, null, null, b.a(r85, r7.getEcomSceneId(), null), null, null, null, null, null, 257904, null), z1.f(r13.getRequestParam().getRequestAdditions()), new ECUIParam(null, false, false, r415, r8, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 0.0f, 0, null, -29, 1, null), Boolean.TRUE);
        return;
    L292:
        r105 = null;
        goto L293
    L288:
        r102 = null;
        goto L289
    L284:
        r517 = null;
    L280:
        r516 = "";
    L273:
        r515 = "";
        goto L274
    L266:
        r137 = null;
        goto L267
    L262:
        r423 = null;
        goto L263
    L258:
        r94 = new JSONObject();
        goto L259
    L254:
        r135 = r91;
        goto L255
    L250:
        r134 = r82;
    L246:
        r132 = 0;
    L238:
        r78 = null;
        goto L239
    L232:
        r75 = null;
    L228:
        r610 = null;
        goto L229
    L217:
        r512 = null;
        goto L218
    L213:
        r511 = r68;
        goto L214
    L210:
        r68 = null;
        goto L211
    L303:
        return;
    L302:
        return;
    L202:
        r130 = null;
        goto L203
    L98:
        r31 = null;
    L94:
        r111 = "";
    L90:
        r28 = "";
        goto L91
    L299:
        return;
    L298:
        return;
    L36:
        if (StringsKt.isBlank(r10) == true) goto L39;
        r12 = false;
        goto L40
    L32:
        r10 = null;
    L294:
        ECExceptionMonitor.e(new Exception("inflow enter product detail fail"));
        return;
    L305:
        return;
    L297:
        return;
    L23:
        r6 = null;
        goto L24
    L17:
        r4 = r89;
        goto L18
    L13:
        r3 = r88;
        goto L15
    L9:
        r8 = r87;
        goto L11
    L5:
        r1 = r86;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(final View r41, FragmentActivity r42, rd3.a r43, nl.d r44, Function1 r45, PromotionProductStruct r46, String r47, BtmItemBuilder r48, com.bytedance.android.btm.api.model.d r49, boolean r50, Function1 r51, String r52, String r53, int r54) {
        if ((r54 & 8) == 0) goto L5;
        nl.d r4 = null;
    L7:
        if ((r54 & 16) == 0) goto L9;
        Function1 r6 = null;
    L11:
        if ((r54 & 32) == 0) goto L13;
        PromotionProductStruct r7 = null;
    L15:
        if ((r54 & 64) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r54 & 128) == 0) goto L21;
        BtmItemBuilder r9 = null;
    L23:
        if ((r54 & 256) == 0) goto L25;
        com.bytedance.android.btm.api.model.d r10 = null;
    L27:
        if ((r54 & 512) == 0) goto L29;
        boolean r11 = true;
    L31:
        if ((r54 & 1024) == 0) goto L33;
        Function1 r13 = null;
    L35:
        if ((r54 & 2048) == 0) goto L37;
        String r14 = null;
    L39:
        if ((r54 & 4096) == 0) goto L41;
        String r0 = null;
    L42:
        Intrinsics.checkNotNullParameter(r41, FreqActions.ACTION_VIEW);
        if (r42 == null) goto L187;
        if (r7 != null) goto L51;
        if (r43 == null) goto L50;
        Promotion r15 = r43.f();
        if (r15 == null) goto L50;
        final PromotionProductStruct r16 = r15.getPromotionInfo();
    L52:
        if (r43 == null) goto L179;
        final ProductFeedViewModel r5 = r43.c;
        if (r5 == null) goto L188;
        BtmItemBuilder r17 = r9;
        com.bytedance.android.btm.api.model.d r18 = r10;
        if (z53.b.a(r41.getId(), 800) == true) goto L180;
        if (r16 == null) goto L60;
        ActivityVO r12 = f53.a.c(r16);
    L61:
        if (r16 == null) goto L63;
        d63.q r19 = d63.r.a(r16);
    L64:
        if (r12 == null) goto L70;
        if (r12.getActivityType() != 5) goto L70;
        return;
    L70:
        if (r12 != null) goto L72;
    L73:
        if (r19 != null) goto L75;
    L79:
        AnchorV3Param r20 = r5.m907getAnchorV3Param();
        if (r20 == null) goto L82;
        AnchorV3Param r21 = b(r20, r43);
    L84:
        if (r43.e == true) goto L91;
        if (r21 == null) goto L91;
        if (com.bytedance.android.shopping.anchorv3.a.c(r21) != true) goto L91;
        int r110 = k.a;
        JSONObject r111 = com.bytedance.android.shopping.anchorv3.a.a(r21);
        if (r111 == null) goto L94;
        new com.bytedance.android.shopping.feed.event.b(r111).post(null, null);
    L94:
        int r112 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        ECOrderTrackerData r113 = com.bytedance.android.shopping.anchorv3.utils.y.x(r21);
        yd3.p r114 = r43.i();
        if (r114 == null) goto L99;
        yd3.m r115 = r114.l();
        if (r115 == null) goto L99;
        Integer r116 = r115.f();
    L100:
        if (r7 == null) goto L114;
        if (r116 != null) goto L103;
        nl.d r117 = r4;
    L105:
        if (r116 != null) goto L108;
    L115:
        r6 = r6;
    L116:
        String r22 = r113.getEntranceInfo();
        if (r22 == null) goto L146;
        JSONObject r23 = z1.f(r22);
        r23.put("display_rank", r43.f);     // Catch: JSONException -> L143
        if (r14 != null) goto L122;
    L127:
        if (r0 != null) goto L129;
    L134:
        Iterator r1 = ((LinkedHashMap) r43.k).entrySet().iterator();     // Catch: JSONException -> L143
    L136:
        if (r1.hasNext() == false) goto L138;
        Map.Entry r24 = (Map.Entry) r1.next();     // Catch: JSONException -> L143
        r23.put((String) r24.getKey(), r24.getValue());     // Catch: JSONException -> L143
        goto L136
    L138:
        if (r21 == null) goto L145;
        JSONObject r2 = com.bytedance.android.shopping.anchorv3.a.a(r21);     // Catch: JSONException -> L143
        if (r2 == null) goto L145;
        r23.put("creative_id", r2.optString("cid"));     // Catch: JSONException -> L143
    L145:
        Unit r3 = Unit.INSTANCE;
    L147:
        r113.setEntranceInfo(String.valueOf(r23));
        Lazy r25 = DataChecker.a;
        AnchorV3Param r26 = r5.m907getAnchorV3Param();
        String r27 = "";
        if (r26 == null) goto L153;
        ECLogExtraData r28 = r26.getLogExtraData();
        if (r28 == null) goto L153;
        String r29 = r28.getEnterFrom();
        if (r29 == null) goto L153;
    L154:
        String r30 = r113.getEntranceInfo();
        if (r30 == null) goto L158;
        r27 = r30;
    L158:
        DataChecker.a(r42, r29, "buy_now", r27);
        int r31 = ECSdk.a;
        IEShoppingService r32 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r32 == null) goto L185;
        p83.d r33 = r32.getAnchorV3Service();
        if (r33 == 0) goto L186;
        Function0<Unit> r34 = new ProductFeedActionHelper$doOnBuyButtonClicked$3(r16, r41, r5);
        Function0<Unit> r35 = new ProductFeedActionHelper$doOnBuyButtonClicked$4(r5, r16, r41);
        SkuRestoreState r36 = r5.getSkuPanelState();
        Function1<SkuRestoreState, Unit> r118 = new ProductFeedActionHelper$doOnBuyButtonClicked$5(r5);
        int r119 = b.a;
        if (r7 == null) goto L173;
        if (r116 != null) goto L167;
    L168:
        if (r116 == null) goto L173;
        if (r116.intValue() != 3) goto L173;
    L172:
        String r37 = "1002,1064";
    L174:
        boolean r410 = r11;
        PromotionProductStruct r411 = r16;
        Function1 r412 = r6;
        r33.d(r42, r113, new ProductPurchaseInfo(r410, r411, "product_flow_page", r412, r34, r35, r36, r118, b.a(r43, r37, null)), new ProductDetailPageParams(null, null, null, false, false, null, null, null, 0, null, null, r5.getPageType(), null, null, null, null, 63487, null), r17, r18, r117, r13);
        return;
    L167:
        if (r116.intValue() == 4) goto L172;
    L173:
        r37 = r5.getEcomSceneId();
        goto L174
    L186:
        return;
    L185:
        return;
    L153:
        r29 = "";
        goto L154
    L129:
        if (com.bytedance.android.shopping.anchorv3.a.b(r0) == true) goto L132;
        r0 = null;
    L132:
        if (r0 == null) goto L134;
        r23.put("search_id", r0);     // Catch: JSONException -> L143
        goto L134
    L122:
        if (com.bytedance.android.shopping.anchorv3.a.b(r14) == true) goto L125;
        r14 = null;
    L125:
        if (r14 == null) goto L127;
        r23.put("inflow_main_card_location", r14);     // Catch: JSONException -> L143
    L143:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L145
    L146:
        r23 = null;
        goto L147
    L108:
        if (r116.intValue() != 3) goto L115;
    L109:
        String r38 = r113.getEntranceInfo();
        if (r38 == null) goto L112;
        JSONObject r39 = z1.f(r38);
        r39.put("inflow_coupon_type", "1");
        r39.put("product_source_page", "product_flow_page");
        r39.put("carrier_source", "ecom_new_channel");
        r39.put("module_label", "guess_you_like_product");
        r39.put("recommend_info", r8);
        r39.put("click_area", "buynow");
        Unit r40 = Unit.INSTANCE;
    L113:
        r113.setEntranceInfo(String.valueOf(r39));
        goto L116
    L112:
        r39 = null;
        goto L113
    L103:
        r117 = r4;
        if (r116.intValue() == 4) goto L109;
    L114:
        r117 = r4;
    L99:
        r116 = null;
    L91:
        int r120 = k.a;
        InnerFlowAdRawData r121 = r43.a;
        if (r121 == null) goto L94;
        new com.bytedance.android.shopping.feed.event.c(r121).post(null, null);
        goto L94
    L82:
        r21 = null;
        goto L84
    L75:
        if (r19.a != true) goto L79;
        if (r12 != null) goto L78;
        return;
    L78:
        if (r12.getActivityType() == 13) goto L79;
        return;
    L72:
        if (r12.getActivityType() != 4) goto L73;
        return;
    L63:
        r19 = null;
        goto L64
    L60:
        r12 = null;
        goto L61
    L180:
        return;
    L188:
        return;
    L179:
        return;
    L50:
        r16 = null;
        goto L52
    L51:
        r16 = r7;
        goto L52
    L187:
        return;
    L41:
        r0 = r53;
        goto L42
    L37:
        r14 = r52;
        goto L39
    L33:
        r13 = r51;
        goto L35
    L29:
        r11 = r50;
        goto L31
    L25:
        r10 = r49;
        goto L27
    L21:
        r9 = r48;
        goto L23
    L17:
        r8 = r47;
        goto L19
    L13:
        r7 = r46;
        goto L15
    L9:
        r6 = r45;
        goto L11
    L5:
        r4 = r44;
        goto L7
    }
}
