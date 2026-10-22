package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.anchorv4.bottom.EnterShopMeta;
import com.bytedance.android.shopping.anchorv4.bottom.z;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.internal.LinkedTreeMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public static final /* synthetic */ int d = 0;
    public final AnchorV4VM a;
    public final Context b;
    public final AnchorV4ShopAndStoreMeta c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.shop.a$a, reason: collision with other inner class name */
    public static final class C0020a {
        public static String a(long r3, List r5) {
            if (r5 == null) goto L7;
            if (r3 >= r5.size()) goto L7;
            return (String) ListProtector.get(r5, (int) r3);
        L7:
            if (r3 != 0) goto L10;
            return "product_detail_coupon";
        L10:
            if (r3 != 1) goto L13;
            return "product_detail_discount";
        L13:
            if (r3 != 2) goto L16;
        L21:
            return "product_detail";
        L16:
            if (r3 != 3) goto L19;
            return "product_detail_point";
        L19:
            if (r3 != 4) goto L21;
            return "product_detail_activity";
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final Context getContext() {
        return this.b;
    }

    public static String b(String r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        return p0.g(r2, "entrance_location", "product_detail_card");
    }

    public a(AnchorV4VM r2, Context r3, AnchorV4ShopAndStoreMeta r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r24, Action r25, Object r26) {
        Intrinsics.checkNotNullParameter(r24, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r25, "action");
        String r0 = r25.getId();
        String r15 = null;
        if (r0 != null) goto L6;
    L144:
        String r1 = r25.getId();
        if (r1 != null) goto L147;
        return;
    L147:
        if (StringsKt.startsWith$default(r1, "shop_coupon_id_", false, 2, null) != true) goto L193;
        int r2 = CastIntegerProtector.parseInt(String.valueOf(StringsKt.last(r25.getId())));
        AnchorV4ShopAndStoreMeta r3 = this.c;
        if (r3 == null) goto L194;
        AnchorV4ShopAndStoreBusinessMeta r4 = r3.getBusinessMeta();
        if (r4 == null) goto L195;
        List<Long> r5 = r4.getShopCouponType();
        if (r5 == null) goto L196;
        Long r6 = (Long) CollectionsKt.getOrNull(r5, r2);
        if (r6 == null) goto L197;
        long r7 = r6.longValue();
        List<String> r8 = this.c.getBusinessMeta().getShopCouponUrl();
        if (r8 == null) goto L159;
        String r9 = (String) CollectionsKt.getOrNull(r8, r2);
    L160:
        AnchorV4ShopAndStoreBusinessMeta r10 = this.c.getBusinessMeta();
        if (r10 == null) goto L163;
        List<String> r11 = r10.getShopCouponEntranceLocation();
    L164:
        String r12 = C0020a.a(r7, r11);
        if (r9 == null) goto L167;
        m0 r13 = new m0(r9);
    L168:
        AnchorV4ShopAndStoreMeta r14 = this.c;
        if (r14 == null) goto L174;
        AnchorV4ShopAndStoreBusinessMeta r16 = r14.getBusinessMeta();
        if (r16 == null) goto L174;
        r16.getShopAuthorId();
    L174:
        if (r7 != 2) goto L181;
        p r17 = p.a;
        Context r18 = this.b;
        if (r13 == null) goto L178;
        r15 = r13.c();
    L178:
        r17.openSchema(r18, r15);
        int r19 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r110 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a);
        if (r110 == null) goto L198;
        r110.c = MapsKt.mapOf(TuplesKt.to("entrance_location", r12));
        AnchorV4TrackerImpl.b(r110, "click_member_entrance", false, null, false, null, 30);
        return;
    L198:
        return;
    L181:
        if (r13 == null) goto L183;
        String r20 = r13.c();
    L184:
        AnchorV4ShopAndStoreMeta r21 = this.c;
        if (r21 == null) goto L189;
        AnchorV4ShopAndStoreBusinessMeta r22 = r21.getBusinessMeta();
        if (r22 == null) goto L189;
        Boolean r23 = Boolean.valueOf(r22.isStore());
    L190:
        a(this, r24, r20, r23, r12, false, null, 48);
        return;
    L189:
        r23 = null;
        goto L190
    L183:
        r20 = null;
        goto L184
    L167:
        r13 = null;
        goto L168
    L163:
        r11 = null;
        goto L164
    L159:
        r9 = null;
        goto L160
    L197:
        return;
    L196:
        return;
    L195:
        return;
    L194:
        return;
    L193:
        return;
    L6:
        switch(r0.hashCode()) {
            case -1913486152: goto L127;
            case 3506402: goto L112;
            case 453122681: goto L55;
            case 606495201: goto L35;
            case 1458500296: goto L24;
            case 1703714252: goto L9;
            default: goto L144;
        };
    L9:
        if (r0.equals("shop_recommend_title") == false) goto L144;
        AnchorV4ShopAndStoreMeta r27 = this.c;
        if (r27 == null) goto L15;
        AnchorV4ShopAndStoreBusinessMeta r28 = r27.getBusinessMeta();
        if (r28 == null) goto L15;
        String r29 = r28.getShopPortfolioUrl();
    L16:
        String r30 = b(r29);
        AnchorV4ShopAndStoreMeta r31 = this.c;
        if (r31 == null) goto L21;
        AnchorV4ShopAndStoreBusinessMeta r32 = r31.getBusinessMeta();
        if (r32 == null) goto L21;
        Boolean r33 = Boolean.valueOf(r32.isStore());
    L22:
        a(this, r24, r30, r33, null, true, "103", 24);
    L21:
        r33 = null;
    L15:
        r29 = null;
        goto L16
    L24:
        if (r0.equals("shop_rank_list") == false) goto L144;
        p r34 = p.a;
        Context r35 = this.b;
        AnchorV4ShopAndStoreMeta r36 = this.c;
        if (r36 == null) goto L30;
        AnchorV4ShopAndStoreBusinessMeta r37 = r36.getBusinessMeta();
        if (r37 == null) goto L30;
        String r38 = r37.getShopRankList();
    L31:
        r34.openSchema(r35, r38);
        String r39 = new BtmItemBuilder("a1.b8094.c4307.d18510", Boolean.TRUE).withView(r24).createBtmId();
        int r40 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r41 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a);
        if (r41 == null) goto L144;
        r41.c = MapsKt.mapOf(TuplesKt.to("btm_id", r39));
        AnchorV4TrackerImpl.b(r41, "shop_list_entrance_click", false, null, false, null, 30);
    L30:
        r38 = null;
        goto L31
    L35:
        if (r0.equals("shop_jump_reputation") == false) goto L144;
        AnchorV4ShopAndStoreMeta r42 = this.c;
        if (r42 == null) goto L41;
        AnchorV4ShopAndStoreBusinessMeta r43 = r42.getBusinessMeta();
        if (r43 == null) goto L41;
        String r44 = r43.getShopReputationLink();
    L42:
        if (r44 == null) goto L144;
        ECLiveHybridUtil.k(this.b, r44, false, false, false, null, 252);
        int r45 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r46 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a);
        if (r46 == null) goto L144;
        Pair[] r47 = new Pair[2];
        r47[0] = TuplesKt.to("entrance_location", "102");
        AnchorV4ShopAndStoreMeta r48 = this.c;
        if (r48 == null) goto L52;
        AnchorV4ShopAndStoreBusinessMeta r49 = r48.getBusinessMeta();
        if (r49 == null) goto L52;
        if (r49.isStore() != true) goto L52;
        String r50 = "shop";
    L53:
        r47[1] = TuplesKt.to("store_type", r50);
        r46.c = MapsKt.mapOf(r47);
        AnchorV4TrackerImpl.b(r46, "shop_level_info_explain_page_click", true, null, false, null, 28);
    L52:
        r50 = "window";
    L41:
        r44 = null;
        goto L42
    L55:
        if (r0.equals("shop_jump_store") == false) goto L144;
        if (r24.getId() != 2131362817) goto L98;
        JSONObject r51 = z1.g(r25.getMeta());
        if (r51 == null) goto L61;
        boolean r52 = r51.optBoolean("shop_struct_optimize");
        boolean r53 = r51.optBoolean("has_new_products");
    L62:
        if (r52 == false) goto L85;
        if (r53 == false) goto L85;
        AnchorV4ShopAndStoreMeta r54 = this.c;
        if (r54 == null) goto L69;
        AnchorV4ShopAndStoreBusinessMeta r55 = r54.getBusinessMeta();
        if (r55 == null) goto L69;
        String r56 = r55.getShopAvatarLink();
    L71:
        if (a2.b(r56) == false) goto L85;
        AnchorV4ShopAndStoreMeta r57 = this.c;
        if (r57 == null) goto L77;
        AnchorV4ShopAndStoreBusinessMeta r58 = r57.getBusinessMeta();
        if (r58 == null) goto L77;
        String r59 = r58.getShopAvatarLink();
    L78:
        String r60 = b(r59);
        AnchorV4ShopAndStoreMeta r61 = this.c;
        if (r61 == null) goto L83;
        AnchorV4ShopAndStoreBusinessMeta r62 = r61.getBusinessMeta();
        if (r62 == null) goto L83;
        Boolean r63 = Boolean.valueOf(r62.isStore());
    L84:
        a(this, r24, r60, r63, null, false, "101", 56);
    L83:
        r63 = null;
    L77:
        r59 = null;
    L69:
        r56 = null;
    L85:
        AnchorV4ShopAndStoreMeta r64 = this.c;
        if (r64 == null) goto L90;
        AnchorV4ShopAndStoreBusinessMeta r65 = r64.getBusinessMeta();
        if (r65 == null) goto L90;
        String r66 = r65.getShopPortfolioUrl();
    L91:
        String r67 = b(r66);
        AnchorV4ShopAndStoreMeta r68 = this.c;
        if (r68 == null) goto L96;
        AnchorV4ShopAndStoreBusinessMeta r69 = r68.getBusinessMeta();
        if (r69 == null) goto L96;
        Boolean r70 = Boolean.valueOf(r69.isStore());
    L97:
        a(this, r24, r67, r70, null, false, "101", 56);
    L96:
        r70 = null;
    L90:
        r66 = null;
        goto L91
    L61:
        r53 = false;
        r52 = false;
        goto L62
    L98:
        AnchorV4ShopAndStoreMeta r71 = this.c;
        if (r71 == null) goto L103;
        AnchorV4ShopAndStoreBusinessMeta r72 = r71.getBusinessMeta();
        if (r72 == null) goto L103;
        String r73 = r72.getShopPortfolioUrl();
    L104:
        String r74 = b(r73);
        AnchorV4ShopAndStoreMeta r75 = this.c;
        if (r75 == null) goto L109;
        AnchorV4ShopAndStoreBusinessMeta r76 = r75.getBusinessMeta();
        if (r76 == null) goto L109;
        Boolean r77 = Boolean.valueOf(r76.isStore());
    L110:
        a(this, r24, r74, r77, null, false, "104", 56);
    L109:
        r77 = null;
    L103:
        r73 = null;
        goto L104
    L112:
        if (r0.equals("root") == false) goto L144;
        AnchorV4ShopAndStoreMeta r78 = this.c;
        if (r78 == null) goto L118;
        AnchorV4ShopAndStoreBusinessMeta r79 = r78.getBusinessMeta();
        if (r79 == null) goto L118;
        String r80 = r79.getShopPortfolioUrl();
    L119:
        String r81 = b(r80);
        AnchorV4ShopAndStoreMeta r82 = this.c;
        if (r82 == null) goto L124;
        AnchorV4ShopAndStoreBusinessMeta r84 = r82.getBusinessMeta();
        if (r84 == null) goto L124;
        Boolean r85 = Boolean.valueOf(r84.isStore());
    L125:
        a(this, r24, r81, r85, null, false, "102", 56);
    L124:
        r85 = null;
    L118:
        r80 = null;
        goto L119
    L127:
        if (r0.equals("shop_view_profile") == false) goto L144;
        int r86 = ECSdk.a;
        IAdapterService r87 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r87 == null) goto L133;
        j r88 = r87.getLiveWindowService();
        if (r88 == null) goto L133;
        r88.stopShowFloatInNextLifecycle();
    L133:
        AnchorV4ShopAndStoreMeta r89 = this.c;
        if (r89 == null) goto L144;
        AnchorV4ShopAndStoreBusinessMeta r90 = r89.getBusinessMeta();
        if (r90 == null) goto L144;
        String r91 = r90.getShopNavLink();
        if (r91 == null) goto L144;
        String r92 = a2.d(r91);
        if (r92 == null) goto L144;
        m0 r94 = new m0(r92);
        r94.b(SimilarProductParam.ENTER_FROM, "product_detail_card");
        p.a.openSchema(this.b, r94.c());
        String r95 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c4307.d4352", Boolean.TRUE).withView(r24).build());
        int r96 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r97 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a);
        if (r97 == null) goto L144;
        r97.c = MapsKt.mapOf(TuplesKt.to("btm_id", r95));
        AnchorV4TrackerImpl.b(r97, "click_author_name", false, null, false, null, 30);
        goto L144
    }

    public static void a(a r22, View r23, String r24, Boolean r25, String r26, boolean r27, String r28, int r29) {
        if ((r29 & 8) == 0) goto L5;
        String r6 = "product_detail_card";
    L7:
        if ((r29 & 16) == 0) goto L9;
        String r8 = "click_store_entrance";
    L10:
        boolean r11 = false;
        if ((r29 & 32) == 0) goto L13;
        boolean r2 = false;
    L14:
        AnchorV4ShopAndStoreMeta r3 = r22.c;
        if (r3 == null) goto L19;
        LinkedTreeMap<String, Object> r4 = r3.getTrackMeta();
        if (r4 == null) goto L19;
        Object r5 = r4.get("is_exist_follow");
    L21:
        if ((r5 instanceof Boolean) == true) goto L23;
        r5 = null;
    L23:
        Boolean r7 = (Boolean) r5;
        if (r7 == null) goto L26;
        boolean r9 = r7.booleanValue();
    L27:
        if (r28 == null) goto L33;
        AnchorV4ShopAndStoreMeta r10 = r22.c;
        if (r10 == null) goto L33;
        LinkedTreeMap<String, Object> r12 = r10.getTrackMeta();
        if (r12 == null) goto L33;
        r12.put("click_area", r28);
    L33:
        AnchorV4ShopAndStoreMeta r13 = r22.c;
        if (r13 == null) goto L36;
        LinkedTreeMap<String, Object> r14 = r13.getTrackMeta();
    L37:
        z r15 = new z(new EnterShopMeta(r24, r14, false, null, null, null, null, 124, null).fillCommonMeta(r22.a.commonMeta()), r22.a);
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L40;
        String r1 = "shop";
    L41:
        r15.a(r23, "a1.b8094.c4307.d3324", r6, r1, r8, r9);
        CommonMeta r16 = r22.a.commonMeta();
        if (r16 == null) goto L48;
        String r17 = r16.getEntranceInfo();
        if (r17 == null) goto L48;
        JSONObject r18 = z1.g(r17);
        if (r18 == null) goto L48;
        String r19 = r18.optString("log_extra");
    L49:
        CommonMeta r20 = r22.a.commonMeta();
        if (r20 == null) goto L56;
        Map<String, ? extends Object> r21 = h73.a.a(r20);
        if (r21 == null) goto L56;
        if (r2 == false) goto L55;
        r21.put("module", "店铺推荐");
    L55:
        Map<String, ? extends Object> r110 = r21;
    L57:
        CommonMeta r0 = r22.a.commonMeta();
        if (r0 == null) goto L80;
        String r30 = h73.a.b(r0);
        if (r30 == null) goto L81;
        g r31 = AdLogUtils.a;
        Intrinsics.checkNotNullParameter(r30, "cid");
        if (r30.length() != 0) goto L64;
        r11 = true;
    L64:
        if (r11 == true) goto L84;
        ECAppInfoService r32 = ECAppInfoService.e;
        if (we.a.a == false) goto L69;
    L78:
        AdLogUtils.a().d("otherclick", null, Long.valueOf(CastLongProtector.parseLong(r30)), r19);
        return;
    L69:
        if (r32.n() == true) goto L78;
        g r111 = AdLogUtils.a;
        if (r111 != null) goto L74;
        return;
    L74:
        if (r2 == false) goto L76;
        String r33 = "button";
    L77:
        r111.d("product_detail_ad", "otherclick", r33, r30, r19, r110, null, "umeng");
        return;
    L76:
        r33 = "shop_card";
        goto L77
    L84:
        return;
    L81:
        return;
    L80:
        return;
    L56:
        r110 = null;
    L48:
        r19 = null;
        goto L49
    L40:
        r1 = "window";
        goto L41
    L36:
        r14 = null;
        goto L37
    L26:
        r9 = false;
    L19:
        r5 = null;
        goto L21
    L13:
        r2 = r27;
        goto L14
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = r26;
        goto L7
    }
}
