package com.bytedance.android.shopping.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.h0;
import com.bytedance.android.ec.core.utils.i1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductInstallmentStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv3.utils.x;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.bytedance.android.shopping.feed.activity.ProductFeedActivity;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.x1;
import com.bytedance.android.shopping.feed.fragment.VideoProductFeedFragment;
import com.bytedance.android.shopping.feed.repository.AnchorV3Repository;
import com.bytedance.android.shopping.feed.utils.c0;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.w;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductFeedStarter {
    public final String A;
    public final ECProductDetailPageShowStyle B;
    public final ECLogExtraData C;
    public final JSONObject D;
    public final ECUIParam E;
    public final boolean F;
    public final Boolean G;
    public final n83.m H;
    public AnchorV3PromotionRequestParam a;
    public Activity b;
    public gl.a c;
    public PromotionProductStruct d;
    public Long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public InnerFlowPageStyleDTO j;
    public d k;
    public AnchorV3Param l;
    public VideoProductFeedFragment m;
    public long n;
    public long o;
    public long p;
    public final boolean q;
    public final Lazy r;
    public PromotionPackResponse s;
    public PromotionProductStruct t;
    public final Context u;
    public final ECProductInfo v;
    public final ECAwemeItemInfo w;
    public final JSONObject x;
    public final String y;
    public final String z;

    public final boolean g() {
        if (this.q == false) goto L10;
        if (this.B.getFullMode() == false) goto L7;
    L15:
        return true;
    L7:
        if (((Boolean) this.r.getValue()).booleanValue() == true) goto L15;
    L14:
        return false;
    L10:
        if (this.B.getFullMode() == true) goto L15;
        if (com.bytedance.android.ec.core.utils.a.c() == false) goto L14;
        goto L14
    }

    public final void h() {
        Activity r0 = d0.a.getActivity(this.u);
        if (r0 != null) goto L5;
        r0 = ECAppInfoService.e.getCurrentActivity();
    L5:
        final Activity r2 = r0;
        final boolean r3 = Intrinsics.areEqual(this.v.isDirectSubmitOrder(), Boolean.TRUE);
        int r7 = 1;
        if (r3 == true) goto L21;
        if (r2 == null) goto L13;
        int r1 = c0.a;
        boolean r4 = this.q;
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (r4 == false) goto L11;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater r5 = ShoppingAsyncInflater.a.a(r2);
        r5.a().d(2131560803).d(2131564843).d(2131560701).a(2131560587, 4).a(2131560741, 1).a(2131560626, 1).a(2131560625, 1).commit();
        r5.a().d(2131564841).a(2131560568, 4).a(2131560729, 4).a(2131560730, 4).a(2131560731, 4).a(2131560734, 4).a(2131560742, 4).commit();
        r5.a().a(2131564842, 4).a(2131560738, 3).a(2131560647, 3).commit();
        r5.a().d(2131560726).a(2131560744, 2).a(2131560733, 4).a(2131560745, 3).a(2131560728, 4).a(2131560619, 2).a(2131560574, 2).commit();
        r5.a().a(2131560582, 1).commit();
        r5.a().a(2131560808, 4).a(2131560806, 4).a(2131560434, 3).a(2131560673, 3).a(2131560627, 3).a(2131560520, 3).a(2131560463, 3).a(2131560460, 3).commit();
        r5.a().a(2131560521, 4).a(2131560633, 4).a(2131560555, 4).commit();
        r5.a().a(2131560740, 1).a(2131560578, 1).a(2131560579, 1).a(2131560580, 1).a(2131560635, 1).a(2131560794, 1).b(2131560798, "ec_panels_view_one_to_two").b(2131560797, "ec_panels_view_four").b(2131560796, "ec_panel_view_three").a(2131560389, 1).commit();
        r5.a().a(2131564853, 1).a(2131560456, 1).commit();
        r5.a().a(2131560648, 1).a(2131560570, 3).commit();
        r5.a().a(2131560588, 1).commit();
        goto L13
    L11:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater r6 = ShoppingAsyncInflater.a.a(r2);
        r6.a().d(2131560803).d(2131564843).d(2131564841);
        r6.a().d(2131560701).a(2131560568, 4).a(2131560808, 4).a(2131560806, 4).commit();
        r6.a().a(2131564842, 3).a(2131560738, 3).a(2131560746, 3).a(2131560647, 3).commit();
        r6.a().a(2131560434, 3).a(2131560673, 3).a(2131560627, 3).a(2131560520, 3).a(2131560463, 3).a(2131560460, 3).commit();
        r6.a().a(2131560740, 1).a(2131560578, 1).a(2131560579, 1).a(2131560580, 1).a(2131560635, 1).a(2131560794, 1).b(2131560798, "ec_panels_view_one_to_two").b(2131560797, "ec_panels_view_four").b(2131560796, "ec_panel_view_three").a(2131560389, 1).commit();
        r6.a().a(2131560648, 1).a(2131560570, 3).commit();
        r6.a().a(2131560563, 2).commit();
        r6.a().a(2131560521, 4).a(2131560633, 4).a(2131560555, 4).commit();
        r6.a().a(2131560588, 1).commit();
        r6.a().a(2131560619, 1).commit();
        r6.a().a(2131560582, 1).commit();
        r6.a().a(2131560582, 1).commit();
        r6.a().a(2131560729, 3).a(2131560730, 3).a(2131560731, 3).a(2131560732, 3).a(2131560744, 2).a(2131560733, 3).a(2131560734, 3).a(2131560745, 3).a(2131560728, 4).commit();
    L13:
        if ((!ld3.c.c().isEmpty()) == false) goto L18;
        Iterator<T> r8 = ld3.c.c().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        h0.a((String) r8.next());
    L18:
        String r9 = this.v.getFrameCovImage();
        if (r9 == null) goto L21;
        r r10 = new r("ec_goods_feed", "ec_goods_feed_banner");
        List<String> r11 = ld3.c.c();
        Intrinsics.checkNotNullParameter(r11, "$this$isHitExp");
        r10.g("ec_goods_feed_enable_preconnect", Integer.valueOf(!r11.isEmpty() ? 1 : 0));
        Unit r12 = Unit.INSTANCE;
        ImageExtensionsKt.B(r9, r10, null, null, null, null, null, false, 192);
    L21:
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = null;
        if (this.q == true) goto L24;
    L25:
        if (r2 != null) goto L346;
        com.bytedance.android.shopping.feed.view.b r14 = null;
    L35:
        r13.element = r14;     // Catch: Exception -> L32
    L38:
        this.g = com.bytedance.android.shopping.monitor.d.c("ec_product_feed_page_duration");
        com.bytedance.android.ec.monitor.duration.i r15 = com.bytedance.android.ec.monitor.duration.i.a;
        this.h = r15.create("ec_perf_duration_product_feed_page");
        this.i = r15.create("ec_perf_duration_product_feed_page_full");
        this.C.setProductSourcePage("product_flow_page");
        com.bytedance.android.shopping.monitor.d.f(this.g).a("page_check_duration");
        com.bytedance.android.ec.monitor.duration.d r16 = r15.get(this.i);
        if (r16 == null) goto L41;
        r16.a("page_check_start");
    L41:
        this.p = SystemClock.elapsedRealtime();
        this.e = Long.valueOf(System.currentTimeMillis());
        int r17 = x1.a;
        Intrinsics.checkNotNullParameter(com.bytedance.android.shopping.extensions.h.a(this.C), "<set-?>");
        gl.a r18 = rk.a.a("start_product_flow", this.y);
        if (r18 == null) goto L152;
        String r19 = r18.getString("carrier_source");
        if (r19 != null) goto L46;
    L49:
        boolean r110 = true;
    L50:
        if (r110 == false) goto L52;
        r18.g(new Pair[]{TuplesKt.to("carrier_source", this.C.getEnterFrom())});
        Intrinsics.checkNotNullParameter(this.C.getEnterFrom(), "<set-?>");
    L56:
        String r20 = r18.getString("source_method");
        if (r20 != null) goto L59;
    L62:
        boolean r21 = true;
    L63:
        if (r21 == false) goto L65;
        r18.g(new Pair[]{TuplesKt.to("source_method", com.bytedance.android.shopping.extensions.h.b(this.C))});
    L65:
        String r22 = r18.getString("ecom_group_type");
        if (r22 != null) goto L68;
    L71:
        boolean r23 = true;
    L72:
        if (r23 == false) goto L74;
        r18.g(new Pair[]{TuplesKt.to("ecom_group_type", "")});
        Intrinsics.checkNotNullParameter("product_card", "<set-?>");
    L78:
        String r24 = r18.getString("which_account");
        if (r24 != null) goto L81;
    L84:
        boolean r25 = true;
    L85:
        if (r25 == false) goto L87;
        r18.g(new Pair[]{TuplesKt.to("which_account", this.C.getWhichAccount())});
    L87:
        String r26 = this.C.getV3EventsAdditions();
        if (r26 == null) goto L103;
        JSONObject r27 = z1.g(r26);
        if (r27 == null) goto L103;
        String r28 = r18.getString("search_params");
        if (r28 != null) goto L94;
    L97:
        boolean r29 = true;
    L98:
        if (r29 == false) goto L100;
        r18.g(new Pair[]{TuplesKt.to("search_params", r27.optString("search_params"))});
    L100:
        String r30 = r27.optString("card_status");
        if (r30 == null) goto L103;
        r18.g(new Pair[]{TuplesKt.to("card_status", r30)});
        goto L103
    L94:
        if (r28.length() == 0) goto L97;
        r29 = false;
    L103:
        String r31 = r18.getString("recommend_info");
        if (r31 != null) goto L106;
    L109:
        boolean r32 = true;
    L110:
        if (r32 == false) goto L112;
        r18.g(new Pair[]{TuplesKt.to("recommend_info", this.C.getRecommendInfo())});
    L112:
        String r33 = r18.getString("request_id");
        if (r33 != null) goto L115;
    L118:
        boolean r34 = true;
    L119:
        if (r34 == false) goto L121;
        r18.g(new Pair[]{TuplesKt.to("request_id", this.C.getRequestId())});
    L121:
        String r35 = r18.getString("product_source_page");
        if (r35 != null) goto L124;
    L127:
        boolean r36 = true;
    L128:
        if (r36 == false) goto L130;
        r18.g(new Pair[]{TuplesKt.to("product_source_page", this.C.getProductSourcePage())});
    L130:
        String r37 = r18.getString("module_label");
        if (r37 != null) goto L133;
    L136:
        boolean r38 = true;
    L137:
        if (r38 == false) goto L139;
        r18.g(new Pair[]{TuplesKt.to("module_label", this.C.getModuleLabel())});
    L139:
        Pair[] r39 = new Pair[5];
        r39[0] = TuplesKt.to("group_id", this.w.getItemId());
        r39[1] = TuplesKt.to(PdpOpenThirdParam.KEY_PROMOTION_ID, this.v.getCurrentPromotionId());
        ECUIParam r40 = this.E;
        if (r40 == null) goto L142;
        String r41 = r40.getIconType();
    L143:
        r39[2] = TuplesKt.to("ecom_icon", r41);
        r39[3] = TuplesKt.to("anchor_id", this.w.getUserId());
        r39[4] = TuplesKt.to("inflow_recommend_type", this.C.getInflowRecommendType());
        r18.g(r39);
        String r42 = this.w.getTopLabelText();
        if (r42 != null) goto L146;
    L149:
        boolean r43 = true;
    L150:
        if (r43 == true) goto L152;
        r18.g(new Pair[]{TuplesKt.to("friends_ecom_tag", this.w.getTopLabelText())});
        goto L152
    L146:
        if (r42.length() == 0) goto L149;
        r43 = false;
        goto L150
    L142:
        r41 = null;
        goto L143
    L133:
        if (r37.length() == 0) goto L136;
        r38 = false;
        goto L137
    L124:
        if (r35.length() == 0) goto L127;
        r36 = false;
        goto L128
    L115:
        if (r33.length() == 0) goto L118;
        r34 = false;
        goto L119
    L106:
        if (r31.length() == 0) goto L109;
        r32 = false;
        goto L110
    L81:
        if (r24.length() == 0) goto L84;
        r25 = false;
        goto L85
    L74:
        String r44 = r18.getString("ecom_group_type");
        if (r44 != null) goto L77;
        r44 = "";
    L77:
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        goto L78
    L68:
        if (r22.length() == 0) goto L71;
        r23 = false;
        goto L72
    L59:
        if (r20.length() == 0) goto L62;
        r21 = false;
        goto L63
    L52:
        String r45 = r18.getString("carrier_source");
        if (r45 != null) goto L55;
        r45 = "";
    L55:
        Intrinsics.checkNotNullParameter(r45, "<set-?>");
        goto L56
    L46:
        if (r19.length() == 0) goto L49;
        r110 = false;
    L152:
        this.c = r18;
        int r46 = w.a;
        JSONObject r47 = this.x;
        if (r18 == null) goto L155;
        String r48 = r18.h();
    L156:
        w.a(r47, r48);
        String r49 = this.C.getV3EventsAdditions();
        if (r49 == null) goto L172;
        JSONObject r50 = z1.g(r49);
        if (r50 == null) goto L172;
        String r51 = r50.optString("transmissible_json");
        if (r51 == null) goto L172;
        String r52 = a2.d(r51);
        if (r52 == null) goto L172;
        JSONObject r53 = z1.g(r52);
        if (r53 == null) goto L172;
        Iterator<String> r54 = r53.keys();
    L168:
        if (r54.hasNext() == false) goto L172;
        String r55 = r54.next();
        gl.a r56 = this.c;
        if (r56 == null) goto L168;
        Pair[] r57 = new Pair[r7];
        r57[0] = TuplesKt.to(r55, r53.get(r55));
        r56.g(r57);
        r7 = 1;
    L172:
        com.bytedance.android.ec.sdk.helper.r r58 = com.bytedance.android.ec.sdk.helper.r.a;
        gl.a r59 = this.c;
        if (r59 == null) goto L176;
        String r60 = r59.getString("ecom_scene_id");
        if (r60 == null) goto L176;
    L177:
        Map r61 = MapsKt.mapOf(TuplesKt.to("ecom_scene_id", r60));
        List<String> r111 = this.v.getPromotionIds();
        String r210 = this.v.getCurrentPromotionId();
        String r62 = this.w.getItemId();
        if (r62 != null) goto L180;
        String r211 = "";
    L181:
        String r212 = this.w.getSecUid();
        String r213 = this.x.toString();
        String r214 = this.C.getEnterFrom();
        String r215 = r58.getCurrentUserId();
        String r216 = r58.f();
        JSONObject r63 = this.D;
        if (r63 == null) goto L184;
        String r217 = r63.toString();
    L185:
        Integer r310 = Integer.valueOf(UIUtils.getScreenWidth(this.u));
        Integer r311 = Integer.valueOf(UIUtils.getScreenWidth(this.u));
        String r218 = this.w.getUserId();
        String r312 = this.v.getRankId();
        Boolean r64 = this.G;
        int r65 = x.a;
        this.a = new AnchorV3PromotionRequestParam(r111, r210, r211, r212, r213, r214, null, r215, r216, r217, r218, r310, r311, r312, 7, null, null, null, r64, MapsKt.plus(x.b(this.u), r61), null, null, null, null, null, null, null, null, null, null, false, this.w.getAggParams(), this.w.getUserOpenId(), this.w.isStar(), this.w.isAds(), this.w.getGoodPriceParam(), this.w.getGoodPriceCardGuessLikeOpt(), this.w.getGoodPriceCardMainOpt(), null, null, null, null, null, 2146664512, 1984, null);
        gl.a r66 = this.c;
        if (r66 == null) goto L188;
        r66.g(new Pair[]{TuplesKt.to("ad_type", this.w.getAdType())});
    L188:
        AnchorV3PromotionRequestParam r67 = this.a;
        if (r67 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L191:
        PromotionProductStruct r68 = this.d;
        if (TextUtils.isEmpty(this.v.getProductId()) == true) goto L194;
        String r69 = this.v.getProductId();
    L197:
        String r219 = r69;
    L199:
        List r220 = CollectionsKt.listOf(this.d);
        String r221 = this.v.getCurrentPromotionId();
        String r222 = this.w.getUserId();
        String r223 = this.w.getSecUid();
        Integer r224 = this.w.getFollowStatus();
        String r225 = this.C.getEnterMethod();
        gl.a r70 = this.c;
        if (r70 == null) goto L203;
        String r71 = r70.h();
        if (r71 == null) goto L203;
    L204:
        String r313 = r71;
        String r72 = this.z;
        gl.a r73 = this.c;
        if (r73 == null) goto L210;
        String r74 = r73.getString("source_method");
        if (r74 == null) goto L210;
        String r314 = r74;
    L211:
        int r75 = ECSdk.a;
        s83.g r76 = (s83.g) ECSdk.a(s83.g.class);
        if (r76 == null) goto L214;
        String r315 = r76.S(this.C.getEnterFrom());
    L215:
        String r77 = this.A;
        ECUIParam r78 = this.E;
        String r316 = com.bytedance.android.shopping.extensions.h.a(this.C);
        String r317 = this.C.getV3EventsAdditions();
        int r318 = this.B.getShowSkuPanel();
        String r410 = this.C.getWhichAccount();
        boolean r411 = g();
        String r112 = this.C.getRecommendInfo();
        if (r112 != null) goto L221;
        gl.a r113 = this.c;
        if (r113 == null) goto L220;
        r112 = r113.getString("recommend_info");
        goto L221
    L220:
        r112 = null;
    L221:
        if (r112 != null) goto L223;
        String r412 = null;
    L224:
        AnchorV3Param r114 = new AnchorV3Param(r67, r68, r219, r220, r221, r222, r223, null, null, r224, r225, r313, r72, r314, r315, r77, false, r316, r317, r318, r78, null, r410, null, null, null, null, r411, r412, new ECAnchorV3ExtraData(true, this.f, this.v.getShopId()), this.C, this.v.getFrameCovImage(), this.w.getItemId(), null, null, null, 0, null, null, null, this.w.getPageInternalFlowStyle(), this.w.getAdType(), this.v.getFrontCategoryId(), this.v.getFrontCategoryName(), this.v.getFirstCategoryId(), this.v.getFirstCategoryName(), null, null, this.w.getRawCreativeId(), this.w.getUserOpenId(), this.q, 127992192, 49406, null);
        r114.setMonitorName(this.g);
        r114.setNewMonitorName(this.h);
        r114.setFullPageMonitorName(this.i);
        this.l = r114;
        com.bytedance.android.shopping.monitor.d.f(this.g).i("group_id", this.w.getItemId());
        com.bytedance.android.shopping.monitor.d r79 = com.bytedance.android.shopping.monitor.d.f(this.g);
        AnchorV3Param r80 = this.l;
        if (r80 != null) goto L227;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L227:
        JSONObject r81 = z1.g(r80.getEntranceInfo());
        if (r81 == null) goto L230;
        String r82 = r81.optString("request_id", "");
    L231:
        r79.i("request_id", r82);
        String r84 = this.w.getItemId();
        if (r84 == null) goto L239;
        com.bytedance.android.ec.monitor.duration.i r85 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r86 = r85.get(this.h);
        if (r86 == null) goto L236;
        r86.b("group_id", r84);
    L236:
        com.bytedance.android.ec.monitor.duration.d r87 = r85.get(this.i);
        if (r87 == null) goto L239;
        r87.b("group_id", r84);
    L239:
        AnchorV3Param r88 = this.l;
        if (r88 != null) goto L242;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L242:
        JSONObject r89 = z1.g(r88.getEntranceInfo());
        if (r89 == null) goto L252;
        String r90 = r89.optString("request_id", "");
        if (r90 == null) goto L252;
        com.bytedance.android.ec.monitor.duration.i r91 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r92 = r91.get(this.h);
        if (r92 == null) goto L249;
        r92.b("request_id", r90);
    L249:
        com.bytedance.android.ec.monitor.duration.d r94 = r91.get(this.i);
        if (r94 == null) goto L252;
        r94.b("request_id", r90);
    L252:
        com.bytedance.android.ec.monitor.duration.i r95 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r96 = r95.get(this.h);
        if (r96 != null) goto L255;
    L259:
        com.bytedance.android.ec.monitor.duration.d r97 = r95.get(this.i);
        if (r97 != null) goto L262;
    L266:
        pi.b r98 = (pi.b) ECSdk.a(pi.b.class);
        if (r98 == null) goto L276;
        JSONObject r99 = new JSONObject();
        r99.put("group_id", this.w.getItemId());
        AnchorV3Param r100 = this.l;
        if (r100 != null) goto L271;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L271:
        JSONObject r101 = z1.g(r100.getEntranceInfo());
        if (r101 == null) goto L274;
        Object r102 = r101.optString("request_id", "");
    L275:
        r99.put("request_id", r102);
        Unit r103 = Unit.INSTANCE;
        PromotionPackResponse r104 = null;
        r98.monitorEvent("ec_perf_page_start_video_product_flow", r99, null, null);
    L277:
        Queue<j> r105 = p.a;
        AnchorV3PromotionRequestParam r106 = this.a;
        if (r106 != null) goto L280;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L280:
        String r107 = r106.getPromotionId();
        AnchorV3PromotionRequestParam r108 = this.a;
        if (r108 != null) goto L283;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L283:
        String r109 = r108.getItemId();
        if (r107 != null) goto L286;
    L289:
        boolean r115 = true;
    L290:
        if (r115 == true) goto L322;
        if (r109 != null) goto L293;
    L296:
        boolean r116 = true;
    L297:
        if (r116 == true) goto L322;
        Queue<j> r117 = p.a;
        if (r117 == null) goto L322;
        Iterator r118 = ((ArrayBlockingQueue) r117).iterator();
    L303:
        if (r118.hasNext() == false) goto L322;
        j r119 = (j) r118.next();
        Queue<j> r120 = p.a;
        PromotionProductStruct r121 = p.a(r119.a, r107);
        if ((System.currentTimeMillis() - r119.c) <= p.b) goto L307;
        boolean r122 = true;
    L309:
        if (Intrinsics.areEqual(r119.b, r109) == false) goto L313;
        if (r121 == null) goto L313;
        if (r122 == true) goto L313;
        boolean r123 = true;
    L320:
        if (r123 == false) goto L303;
        PromotionPackResponse r124 = r119.a;
    L323:
        this.s = r124;
        if (r124 == null) goto L329;
        AnchorV3Param r125 = this.l;
        if (r125 != null) goto L328;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L328:
        r125.setFallbackPage(r124.getFallbackPage());
    L329:
        AnchorV3PromotionRequestParam r126 = this.a;
        if (r126 != null) goto L332;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L332:
        String r127 = r126.getPromotionId();
        if (r127 == null) goto L338;
        Queue<j> r128 = p.a;
        PromotionPackResponse r129 = p.a(this.s, r127);
        if (r129 == null) goto L338;
        PromotionPackResponse r130 = r129;
    L339:
        this.t = r130;
        Queue<j> r131 = p.a;
        x63.d r132 = new x63.d();
        r132.b(new ProductFeedStarter$start$8(this, r13));
        r132.b(new ProductFeedStarter$start$9(this, r13));
        r132.b(new ProductFeedStarter$start$10(this, r3, r13, r2));
        r132.a(new ProductFeedStarter$start$11(this, r3, r13));
        x63.a r133 = r132.a;
        if (r133 == null) goto L361;
        r133.a();
        return;
    L361:
        return;
    L338:
        r130 = r104;
    L313:
        if (r122 == true) goto L348;
    L319:
        r123 = false;
        goto L320
    L348:
        Queue<j> r134 = p.a;     // Catch: Exception -> L318
        if (r134 == null) goto L319;
        ((ArrayBlockingQueue) r134).remove(r119);     // Catch: Exception -> L318
        goto L319
    L307:
        r122 = false;
        goto L309
    L293:
        if (r109.length() == 0) goto L296;
        r116 = false;
    L322:
        r124 = r104;
        goto L323
    L286:
        if (r107.length() == 0) goto L289;
        r115 = false;
        goto L290
    L274:
        r102 = null;
        goto L275
    L276:
        r104 = null;
        goto L277
    L262:
        if (this.w.getAggParams() == null) goto L264;
        int r135 = 1;
    L265:
        r97.b("is_ad", Integer.valueOf(r135));
        goto L266
    L264:
        r135 = 0;
        goto L265
    L255:
        if (this.w.getAggParams() == null) goto L257;
        int r136 = 1;
    L258:
        r96.b("is_ad", Integer.valueOf(r136));
        goto L259
    L257:
        r136 = 0;
        goto L258
    L230:
        r82 = null;
        goto L231
    L223:
        r412 = r112;
        goto L224
    L214:
        r315 = null;
    L210:
        r314 = "";
    L203:
        r71 = "{}";
        goto L204
    L194:
        PromotionProductBaseStruct r137 = this.d.getBaseInfo();
        if (r137 == null) goto L198;
        r69 = r137.getProductId();
        goto L197
    L198:
        r219 = null;
        goto L199
    L184:
        r217 = null;
        goto L185
    L180:
        r211 = r62;
    L176:
        r60 = "";
        goto L177
    L155:
        r48 = null;
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L38
    L346:
        r14 = new com.bytedance.android.shopping.feed.view.b(r2);     // Catch: Exception -> L32
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L344;
        DialogLancet.handleBlockedDialogShow(r14);     // Catch: Exception -> L32
        goto L35
    L344:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L343
    L31:
        DialogLancet.beforeDialogShow(r14);     // Catch: Exception -> L32
        r14.show();     // Catch: Exception -> L32
        DialogLancet.afterDialogShow(r14);     // Catch: Exception -> L32
        goto L35
    L24:
        if (g() == false) goto L38;
        goto L25
    }

    public final Context getContext() {
        return this.u;
    }

    public static final void a(ProductFeedStarter r11) {
        r11.getClass();
        com.bytedance.android.ec.monitor.duration.i r0 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r1 = r0.get(r11.i);
        if (r1 == null) goto L5;
        r1.a("render_start");
    L5:
        com.bytedance.android.ec.monitor.duration.d r2 = r0.get(r11.i);
        if (r2 == null) goto L8;
        r2.a("skeleton_render_start");
    L8:
        PromotionProductExtraStruct r3 = r11.d.getExtraInfo();
        int r4 = 1;
        if (r3 == null) goto L21;
        String r5 = r3.getEntranceInfo();
        if (r5 == null) goto L21;
        JSONObject r6 = com.bytedance.android.shopping.extensions.k.u(r5);
        Iterator<String> r7 = r6.keys();
    L71:
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L14:
        if (r7.hasNext() == false) goto L21;
        String r8 = r7.next();     // Catch: Exception -> L19
        String r9 = r6.optString(r8);     // Catch: Exception -> L19
        gl.a r10 = r11.c;     // Catch: Exception -> L19
        if (r10 == null) goto L71;
        r10.g(new Pair[]{TuplesKt.to(r8, r9)});     // Catch: Exception -> L19
    L21:
        PromotionProductPrivilegesStruct r12 = r11.d.getPrivilegeInfo();
        Integer r13 = null;
        if (r12 == null) goto L26;
        PromotionProductInstallmentStruct r14 = r12.getInstallment();
        if (r14 == null) goto L26;
        PromotionDiscountInfo r15 = r14.getMPromotionDiscountInfo();
    L27:
        gl.a r16 = r11.c;
        if (r16 == null) goto L41;
        Pair[] r17 = new Pair[1];
        if (r15 == null) goto L32;
        Boolean r18 = r15.getShowFlag();
    L34:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == true) goto L36;
    L38:
        r4 = 0;
    L39:
        r17[0] = TuplesKt.to("show_dou_campaign", Integer.valueOf(r4));
        r16.g(r17);
        goto L41
    L36:
        if (cg4.a.a(r15.getDiscountDesc()) == false) goto L38;
    L32:
        r18 = null;
    L41:
        if (r11.g() == false) goto L49;
        int r19 = ProductFeedActivity.l;
        Activity r20 = r11.b;
        if (r20 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L45:
        AnchorV3Param r21 = r11.l;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L48:
        InnerFlowPageStyleDTO r110 = r11.j;
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "param");
        Intrinsics.checkNotNullParameter(r110, "innerFlowPageStyle");
        Intent r22 = new Intent(r20, ProductFeedActivity.class);
        r22.putExtra("param_key", r21);
        r22.putExtra("page_style", r110);
        Unit r111 = Unit.INSTANCE;
        r20.startActivity(r22);
        return;
    L49:
        int r23 = VideoProductFeedFragment.O;
        Activity r24 = r11.b;
        if (r24 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L52:
        FragmentActivity r25 = r11.b;
        if (r25 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
    L55:
        if (r25 == null) goto L70;
        FragmentManager r26 = r25.getSupportFragmentManager();
        Serializable r27 = r11.l;
        if (r27 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L59:
        Serializable r28 = r11.j;
        n83.m r29 = r11.H;
        d r112 = r11.k;
        Intrinsics.checkNotNullParameter(r27, "param");
        Intrinsics.checkNotNullParameter(r28, "innerFlowPageStyle");
        VideoProductFeedFragment r30 = new VideoProductFeedFragment();
        Bundle r31 = new Bundle();
        r31.putSerializable("param_key", r27);
        r31.putSerializable("page_style", r28);
        Unit r32 = Unit.INSTANCE;
        r30.setArguments(r31);
        r30.K = r112;
        ECUIParam r33 = r27.getUiParam();
        if (r33 == null) goto L62;
        r13 = r33.getSplitPercent();
    L62:
        if (r13 != null) goto L65;
    L66:
        r30.m = r29;
    L67:
        r30.Y90(r24, r26);
        r11.m = r30;
        return;
    L65:
        if (r13.intValue() == 9) goto L67;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L26:
        r15 = null;
        goto L27
    }

    public static final void e(ProductFeedStarter r5) {
        PromotionProductBaseStruct r0 = r5.d.getBaseInfo();
        if (r0 == null) goto L17;
        List r1 = r0.getImages();
        if (r1 == null) goto L19;
        ECUrlModel r2 = r5.v.getHeadImg();
        if (r2 != null) goto L11;
        return;
    L11:
        if (r1.isEmpty() == true) goto L21;
        PromotionProductBaseStruct r6 = r5.d.getBaseInfo();
        if (r6 == null) goto L18;
        ArrayList r3 = CollectionsKt.arrayListOf(new ECUrlModel[]{r2});
        r3.addAll(r1.subList(1, r1.size()));
        Unit r4 = Unit.INSTANCE;
        r6.setImages(r3);
        return;
    L18:
        return;
    L21:
        return;
    L19:
        return;
    }

    public static final void f(ProductFeedStarter r4) {
        AnchorV3PromotionRequestParam r0 = r4.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L5:
        String r1 = r0.getCpsTrack();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L19;
        AnchorV3Repository r3 = AnchorV3Repository.g;
        String r5 = r4.v.getProductId();
        AnchorV3PromotionRequestParam r6 = r4.a;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L17:
        ud3.h r7 = new ud3.h(r5, r6.getCpsTrack(), 4);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "request");
        i1.b(((ud3.i) AnchorV3Repository.e.getValue()).a(r7).subscribeOn(Schedulers.io()).map(h.a)).subscribe(new i());
        return;
    L19:
        return;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    }

    public static final boolean c(ProductFeedStarter r6, boolean r7) {
        r6.getClass();
        if (r7 == true) goto L197;
        int r8 = ld3.c.a;
        int r9 = com.bytedance.android.ec.core.opt.ab.m.a;
        Object r10 = 0;
        boolean r1 = ECServiceManager.a;
        s83.g r2 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r2 == null) goto L10;
        s83.a r3 = r2.q();
        if (r3 == null) goto L10;
        Object r4 = r3.e("ec_inflow_feed_loading_opt");
        if (r4 == null) goto L10;
    L177:
        if (((Number) r4).intValue() == 0) goto L179;
        boolean r11 = true;
    L180:
        if (r11 == true) goto L182;
        return false;
    L182:
        if (r6.g() == true) goto L199;
        return true;
    L199:
        return false;
    L179:
        r11 = false;
    L10:
        int r5 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r12 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L167
        Object r14 = null;
        Object r15 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_feed_loading_opt");     // Catch: Throwable -> L62
        if (r15 != null) goto L17;
    L59:
        Object r16 = null;
    L60:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L62
    L64:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L167
        if (r18 == null) goto L68;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L167
    L68:
        if (Result.isFailure-impl(r17) == false) goto L71;
        r17 = null;
    L71:
        if ((r17 instanceof Integer) == true) goto L73;
        r17 = null;
    L73:
        Integer r19 = (Integer) r17;     // Catch: Throwable -> L167
        if (r19 != null) goto L80;
        Object r20 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_feed_loading_opt");     // Catch: Throwable -> L167
        if ((r20 instanceof Integer) == true) goto L79;
        r20 = null;
    L79:
        r19 = (Integer) r20;     // Catch: Throwable -> L167
    L80:
        if (r19 == null) goto L82;
        r4 = r19;
        goto L177
    L82:
        int r21 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L167
        Object r22 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_feed_loading_opt");     // Catch: Throwable -> L132
        if (r22 != null) goto L87;
    L129:
        Object r23 = null;
    L130:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L132
    L134:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L158
        if (r25 == null) goto L138;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L158
    L138:
        if (Result.isFailure-impl(r24) == false) goto L141;
        r24 = null;
    L141:
        if ((r24 instanceof Integer) == true) goto L143;
        r24 = null;
    L143:
        Integer r26 = (Integer) r24;     // Catch: Throwable -> L158
        if (r26 == null) goto L146;
        r4 = r26;
    L165:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_feed_loading_opt", r4);     // Catch: Throwable -> L167
        goto L177
    L146:
        IHybridHostService r27 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L158
        if (r27 == null) goto L149;
        Object r28 = r27.getHostABValue("ec_inflow_feed_loading_opt", r10);     // Catch: Throwable -> L158
    L150:
        if (r28 != null) goto L152;
    L164:
        r4 = r10;
        goto L165
    L152:
        if ((r28 instanceof Integer) == false) goto L155;
        r14 = r28;
    L155:
        r4 = (Integer) r14;     // Catch: Throwable -> L158
        if (r4 != null) goto L165;
    L158:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L167
        r4 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
        Throwable r30 = Result.exceptionOrNull-impl(r4);     // Catch: Throwable -> L167
        if (r30 == null) goto L163;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L167
    L163:
        if (Result.isFailure-impl(r4) == false) goto L165;
    L149:
        r28 = null;
        goto L150
    L87:
        if ((r22 instanceof Integer) == true) goto L89;
        Object r31 = null;
    L90:
        r23 = (Integer) r31;     // Catch: Throwable -> L132
        if (r23 != null) goto L130;
        if ((r22 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r32 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L132
        if ((r32 instanceof Integer) == true) goto L100;
        r32 = null;
    L100:
        r23 = (Integer) r32;     // Catch: Throwable -> L132
        goto L130
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r33 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L132
        if ((r33 instanceof Integer) == true) goto L106;
        r33 = null;
    L106:
        r23 = (Integer) r33;     // Catch: Throwable -> L132
        goto L130
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        r23 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r34 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L132
        if ((r34 instanceof Integer) == true) goto L115;
        r34 = null;
    L115:
        r23 = (Integer) r34;     // Catch: Throwable -> L132
    L117:
        if ((r22 instanceof JSONObject) == false) goto L119;
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L125
        Object r35 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Integer.class);     // Catch: Throwable -> L125
        if ((r35 instanceof Integer) == true) goto L123;
        r35 = null;
    L123:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L125
    L127:
        r23 = r36;
        if (Result.isFailure-impl(r23) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L132
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r22 instanceof JSONArray) == false) goto L129;
    L89:
        r31 = r22;
    L132:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L158
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L158
        goto L134
    L17:
        if ((r15 instanceof Integer) == true) goto L19;
        Object r39 = null;
    L20:
        r16 = (Integer) r39;     // Catch: Throwable -> L62
        if (r16 != null) goto L60;
        if ((r15 instanceof Number) == false) goto L47;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L32;
        Float r40 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L62
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r16 = (Integer) r40;     // Catch: Throwable -> L62
        goto L60
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L38;
        Double r41 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L62
        if ((r41 instanceof Integer) == true) goto L36;
        r41 = null;
    L36:
        r16 = (Integer) r41;     // Catch: Throwable -> L62
        goto L60
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L41;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L62
        goto L60
    L41:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L47;
        Long r42 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L62
        if ((r42 instanceof Integer) == true) goto L45;
        r42 = null;
    L45:
        r16 = (Integer) r42;     // Catch: Throwable -> L62
    L47:
        if ((r15 instanceof JSONObject) == false) goto L49;
    L195:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L55
        Object r43 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L55
        if ((r43 instanceof Integer) == true) goto L53;
        r43 = null;
    L53:
        Object r44 = Result.constructor-impl((Integer) r43);     // Catch: Throwable -> L55
    L57:
        r16 = r44;
        if (Result.isFailure-impl(r16) == false) goto L60;
    L55:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L62
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L62
        goto L57
    L49:
        if ((r15 instanceof JSONArray) == false) goto L59;
    L19:
        r39 = r15;
    L62:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L167
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L172;
        EnsureManager.ensureNotReachHere(r49);
    L172:
        if (Result.isFailure-impl(r48) == true) goto L175;
        r10 = r48;
    L175:
        r4 = r10;
        goto L177
    L197:
        return false;
    }

    public final void i(List<? extends PromotionProductStruct> r8, String r9) {
        String r0 = null;
        if (r8 == null) goto L9;
        PromotionProductStruct r1 = (PromotionProductStruct) CollectionsKt.firstOrNull(r8);
        if (r1 == null) goto L9;
        PromotionProductBaseStruct r2 = r1.getBaseInfo();
        if (r2 == null) goto L9;
        List r3 = r2.getImages();
    L10:
        ECUrlModel r4 = this.v.getHeadImg();
        if (r3 == null) goto L21;
        if (r4 == null) goto L21;
        if ((!r3.isEmpty()) == false) goto L21;
        if (r8 == null) goto L21;
        PromotionProductStruct r5 = (PromotionProductStruct) CollectionsKt.firstOrNull(r8);
        if (r5 == null) goto L21;
        PromotionProductBaseStruct r6 = r5.getBaseInfo();
        if (r6 == null) goto L21;
        ArrayList r7 = CollectionsKt.arrayListOf(new ECUrlModel[]{r4});
        r7.addAll(r3.subList(1, r3.size()));
        Unit r10 = Unit.INSTANCE;
        r6.setImages(r7);
    L21:
        AnchorV3Param r11 = this.l;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L24:
        if (r8 != null) goto L26;
        List<? extends PromotionProductStruct> r12 = CollectionsKt.emptyList();
    L27:
        r11.setPromotions(r12);
        AnchorV3Param r13 = this.l;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L30:
        r13.setAdInnerFlowLogExtra(com.bytedance.android.shopping.feed.viewmodel.a.a(r9));
        if (r8 == null) goto L48;
        PromotionProductStruct r14 = (PromotionProductStruct) CollectionsKt.firstOrNull(r8);
        if (r14 == null) goto L49;
        AnchorV3Param r15 = this.l;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L37:
        r15.setCurrentPromotion(r14);
        AnchorV3Param r16 = this.l;
        if (r16 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L41:
        if (TextUtils.isEmpty(this.v.getProductId()) == true) goto L43;
        r0 = this.v.getProductId();
    L46:
        r16.setProductId(r0);
        return;
    L43:
        PromotionProductBaseStruct r17 = r14.getBaseInfo();
        if (r17 == null) goto L46;
        r0 = r17.getProductId();
        goto L46
    L49:
        return;
    L48:
        return;
    L26:
        r12 = r8;
    L9:
        r3 = null;
        goto L10
    }

    public static final void b(ProductFeedStarter r3, boolean r4, Function1 r5) {
        r3.getClass();
        AnchorV3Repository r0 = AnchorV3Repository.g;
        AnchorV3PromotionRequestParam r1 = r3.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L5:
        AnchorV3Repository.b(r0, r1, r3.v.getCurrentPromotionId()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r3, r4, r5));
    }

    public static final void d(ProductFeedStarter r4, String r5, Integer r6, boolean r7, Function1 r8) {
        r4.getClass();
        String r0 = com.bytedance.android.shopping.extensions.j.c(2131911862);
        if (r7 == false) goto L8;
        if (r5 == null) goto L8;
        String r9 = a2.d(r5);
        if (r9 == null) goto L8;
        r0 = r9;
    L8:
        UIUtils.displayToast(r4.u, r0);
        FeedProductEventTracker r10 = FeedProductEventTracker.a;
        Context r1 = r4.u;
        String r11 = r4.f;
        r10.getClass();
        com.bytedance.android.shopping.feed.event.d0 r12 = new com.bytedance.android.shopping.feed.event.d0();
        r12.c = r11;
        r12.a = r6;
        r12.b = r5;
        r12.d = "0";
        com.bytedance.android.shopping.feed.event.g.c(r12, r1, null);
        int r13 = ECSdk.a;
        pi.b r14 = (pi.b) ECSdk.a(pi.b.class);
        if (r14 == null) goto L11;
        JSONObject r2 = new JSONObject();
        r2.put("log_id", r11);
        r2.put("status", r6);
        r2.put("status_msg", r5);
        r2.put("is_preload", "0");
        Unit r15 = Unit.INSTANCE;
        r14.monitorEvent("ec_perf_page_show_video_product_flow", r2, null, null);
    L11:
        if (r8 == null) goto L14;
        Unit r16 = (Unit) r8.invoke(Boolean.FALSE);
        return;
    }

    public ProductFeedStarter(Context r36, ECProductInfo r37, ECAwemeItemInfo r38, JSONObject r39, String r40, String r41, String r42, ECProductDetailPageShowStyle r43, ECLogExtraData r44, JSONObject r45, ECUIParam r46, boolean r47, Boolean r48, n83.m r49) {
        Intrinsics.checkNotNullParameter(r36, "context");
        Intrinsics.checkNotNullParameter(r37, "productInfo");
        Intrinsics.checkNotNullParameter(r38, "awemeInfo");
        Intrinsics.checkNotNullParameter(r39, "metaParam");
        Intrinsics.checkNotNullParameter(r43, "detailPageStyle");
        Intrinsics.checkNotNullParameter(r44, "logExtraData");
        this.u = r36;
        this.v = r37;
        this.w = r38;
        this.x = r39;
        this.y = r40;
        this.z = r41;
        this.A = r42;
        this.B = r43;
        this.C = r44;
        this.D = r45;
        this.E = r46;
        this.F = r47;
        this.G = r48;
        this.H = r49;
        this.d = new PromotionProductStruct(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, false, false, null, false, null, null, 536870911, null);
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = new InnerFlowPageStyleDTO();
        this.q = Intrinsics.areEqual(r37.isOptCode(), Boolean.TRUE);
        this.r = LazyKt.lazy(ProductFeedStarter$isAccessibilityEnabled$2.INSTANCE);
    }
}
