package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.bottom.EnterShopMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public final EnterShopMeta a;
    public final k b;

    public j(EnterShopMeta r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "enterShopMeta");
        Intrinsics.checkNotNullParameter(r3, "anchorV4VM");
        this.a = r2;
        this.b = r3;
    }

    public static void a(final j r42, final View r43, final String r44, final String r45, String r46, int r47) {
        final String r15 = "shop";
        if ((r47 & 16) == 0) goto L5;
        final String r10 = "click_store_entrance";
    L6:
        final boolean r16 = false;
        Intrinsics.checkNotNullParameter(r43, "btmView");
        Intrinsics.checkNotNullParameter(r44, "btm");
        Intrinsics.checkNotNullParameter(r45, "entranceLocation");
        Intrinsics.checkNotNullParameter("shop", "shopType");
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Set r0 = ECProcessMonitor.a;
        ECProcessMonitor.c("ec_product_detail", "enter_shop").d();
        String r1 = r42.a.getShopSchema();
        if (r1 != null) goto L9;
    L114:
        com.bytedance.android.ec.core.monitor.listener.c.j(ECProcessMonitor.c("ec_product_detail", "enter_shop"), -2);
    L115:
        int r2 = ECSdk.a;
        IECUserTrackerService r3 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r3 == null) goto L127;
        of.a r4 = r3.getMarketingService();
        if (r4 == null) goto L128;
        r4.a("product_detail_click_enter_shop", PostActionType.DO, "product_detail");
        return;
    L128:
        return;
    L127:
        return;
    L9:
        if (cg4.a.a(r1) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L114;
        final EnterShopMeta r5 = r42.a;
        final boolean r17 = r42.b.j();
        if (r5 == null) goto L115;
        final o0 r6 = new o0(r1);
        Activity r7 = ECAppInfoService.e.getCurrentActivity();
        if (r7 == null) goto L115;
        r6.b("pre_product_id", r5.getProductId());
        r6.b("pre_room_id", r5.getLiveRoomId());
        r6.b("pre_group_id", r5.getItemId());
        LinkedTreeMap r8 = r5.getEnterShopLog();
        if (r8 == null) goto L24;
        Iterator r9 = r8.entrySet().iterator();
    L22:
        if (r9.hasNext() == false) goto L24;
        Map.Entry r18 = (Map.Entry) r9.next();
        Iterator r48 = r9;
        r6.b((String) r18.getKey(), String.valueOf(r18.getValue()));
        r9 = r48;
    L24:
        r6.b("entrance_location", r45);
        if (r17 == false) goto L27;
        String r11 = "full_screen";
    L28:
        r6.b("page_type", r11);
        r6.b(SimilarProductParam.ENTER_FROM, r45);
        r6.b("source_product_id", r5.getProductId());
        CommonMeta r12 = r42.b.a();
        if (r12 == null) goto L33;
        String r13 = r12.getEntranceInfo();
        if (r13 == null) goto L33;
        JSONObject r14 = com.bytedance.android.shopping.extensions.k.w(r13);
    L34:
        int r19 = ECSdk.a;
        IEntranceInfoService r20 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r20 == null) goto L37;
        gl.a r21 = r20.initEntranceInfo(new EntranceInfoScene("productDetail", "enterShop"), r6.e("entrance_info"));
    L39:
        if (r21 == null) goto L57;
        Pair[] r22 = new Pair[4];
        if (r14 == null) goto L43;
        String r23 = r14.optString("creative_id");
    L44:
        r22[0] = TuplesKt.to("creative_id", r23);
        if (r14 == null) goto L47;
        String r24 = r14.optString("log_extra");
    L48:
        r22[1] = TuplesKt.to("log_extra", r24);
        if (r14 == null) goto L51;
        String r25 = r14.optString("cid");
    L52:
        r22[2] = TuplesKt.to("cid", r25);
        if (r14 == null) goto L55;
        Integer r26 = Integer.valueOf(r14.optInt("ad_type", 0));
    L56:
        r22[3] = TuplesKt.to("ad_type", r26);
        char r110 = 4;
        String r111 = "ec_product_detail";
        String r112 = "entrance_info";
        Function2<Object, Object, Boolean> r27 = new EnterShopComponent$onClickShopBtnWithCommonMeta$$inlined$apply$lambda$1(r42, r6, r5, r45, r17, r44, r43, r15, r16, r10);
        gl.a r113 = r21;
        r113.b(r22, r27);
    L58:
        if (r113 == null) goto L64;
        Pair[] r28 = new Pair[1];
        JSONObject r29 = r14;
        if (r29 == null) goto L62;
        Boolean r30 = Boolean.valueOf(r29.optBoolean("forbid_popup"));
    L63:
        r28[0] = TuplesKt.to("forbid_popup", r30);
        gl.a r114 = r113;
        final String r115 = r10;
        r114.b(r28, new EnterShopComponent$onClickShopBtnWithCommonMeta$$inlined$apply$lambda$2(r42, r6, r5, r45, r17, r44, r43, r15, r16, r115));
    L65:
        if (r114 == null) goto L67;
        String r31 = r114.h();
    L68:
        r6.a(r112, r31);
        if (Intrinsics.areEqual(r6.e("pre_group_id"), "0") == false) goto L71;
        ECAdLogExtra r32 = null;
        r6.a("pre_group_id", null);
    L72:
        final String r116 = r6.c();
        BtmItemBuilder r33 = new BtmItemBuilder(r44, Boolean.FALSE).withView(r43);
        String r34 = BtmSDK.INSTANCE.createBtmId(r33.build());
        com.bytedance.android.ec.sdk.helper.p.a.d(com.bytedance.android.ec.core.btm.c.c(r116, r43, r44, new Pair[0]), r7);
        Set r35 = ECProcessMonitor.a;
        ECProcessMonitor.c(r111, "enter_shop").g();
        int r36 = com.bytedance.android.shopping.anchorv3.utils.a.a;
        CommonMeta r37 = r42.b.a();
        if (r37 != null) goto L75;
    L77:
        boolean r38 = false;
    L78:
        CommonMeta r39 = r42.b.a();
        if (r39 == null) goto L81;
        ECAdLogExtra r310 = r39.getAdLogExtra();
    L82:
        CommonMeta r40 = r42.b.a();
        if (r40 == null) goto L85;
        ECAdLogExtra r311 = r40.getPromotionId();
    L86:
        CommonMeta r41 = r42.b.a();
        if (r41 == null) goto L89;
        ECAdLogExtra r312 = Long.valueOf(r41.getPromotionSource());
    L90:
        CommonMeta r49 = r42.b.a();
        if (r49 == null) goto L93;
        ECAdLogExtra r313 = r49.getProductMinPrice();
    L94:
        com.bytedance.android.shopping.anchorv3.utils.a.c(r38, r310, r311, r312, r313, r42.b.getDuration());
        Pair[] r50 = new Pair[5];
        r50[0] = TuplesKt.to("entrance_location", r45);
        r50[1] = TuplesKt.to("store_type", "shop");
        r50[2] = TuplesKt.to("btm_id", r34);
        r50[3] = TuplesKt.to("btm", r34);
        CommonMeta r51 = r42.b.a();
        if (r51 == null) goto L97;
        ECAdLogExtra r52 = r51.getProductId();
    L98:
        if (r52 != null) goto L100;
        r52 = "";
    L100:
        r50[r110] = TuplesKt.to("pre_product_id", r52);
        final Map r53 = MapsKt.mutableMapOf(r50);
        LinkedTreeMap r54 = r5.getEnterShopLog();
        if (r54 == null) goto L109;
        Iterator r55 = r54.entrySet().iterator();
    L104:
        if (r55.hasNext() == false) goto L109;
        Map.Entry r56 = (Map.Entry) r55.next();
        if (r53.containsKey(r56.getKey()) == true) goto L104;
        r53.put(r56.getKey(), r56.getValue());
    L109:
        if (Intrinsics.areEqual(r45, "product_detail_card") == false) goto L111;
        r53.put("is_exist_follow", 0);
    L111:
        final String r117 = r10;
        r42.b.d(new EnterShopComponent$onClickShopBtnWithCommonMeta$$inlined$apply$lambda$3(r53, r42, r6, r5, r45, r17, r44, r43, r15, r16, r117));
        int r57 = ECSdk.a;
        IVisitUnit r58 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r58 == null) goto L115;
        r58.hookToSchema(VisitActions.PDP_OUT_SHOP.getKey(), new EnterShopComponent$onClickShopBtnWithCommonMeta$1$6(r116));
        goto L115
    L97:
        r52 = r32;
        goto L98
    L93:
        r313 = r32;
        goto L94
    L89:
        r312 = r32;
        goto L90
    L85:
        r311 = r32;
        goto L86
    L81:
        r310 = r32;
        goto L82
    L75:
        if (r37.isLuban() != true) goto L77;
        r38 = true;
        goto L78
    L71:
        r32 = null;
        goto L72
    L67:
        r31 = null;
        goto L68
    L62:
        r30 = null;
        goto L63
    L64:
        r114 = r113;
        goto L65
    L55:
        r26 = null;
        goto L56
    L51:
        r25 = null;
        goto L52
    L47:
        r24 = null;
        goto L48
    L43:
        r23 = null;
        goto L44
    L57:
        r112 = "entrance_info";
        r110 = 4;
        r111 = "ec_product_detail";
        r113 = r21;
        goto L58
    L37:
        r21 = null;
    L33:
        r14 = null;
        goto L34
    L27:
        r11 = "half_screen";
        goto L28
    L5:
        r10 = r46;
        goto L6
    }
}
