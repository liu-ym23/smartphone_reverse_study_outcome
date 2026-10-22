package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.CurrentUserInfo;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import com.bytedance.android.ec.model.response.ECCombination;
import com.bytedance.android.ec.model.response.ECJumpDestination;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECPromotionCheckResponse;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "confirm", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class PromotionJumpDispatcher$clickBuyOrItemInner$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ il2.a $actionTracker;
    final /* synthetic */ com.bytedance.android.btm.api.model.d $btmModel;
    final /* synthetic */ Pair $cartLoc;
    final /* synthetic */ String $clickArea;
    final /* synthetic */ int $clickEnterFrom;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $dest;
    final /* synthetic */ Ref.BooleanRef $fallbackToDetail;
    final /* synthetic */ LiveRoomParams $liveRoomParams;
    final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.f $pageParams;
    final /* synthetic */ ECUIPromotion $promotion;
    final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g $promotionParams;
    final /* synthetic */ View $view;
    final /* synthetic */ PromotionJumpDispatcher this$0;

    public PromotionJumpDispatcher$clickBuyOrItemInner$1(PromotionJumpDispatcher r1, int r2, Context r3, com.bytedance.android.ec.common.api.jump.model.g r4, String r5, int r6, com.bytedance.android.btm.api.model.d r7, il2.a r8, View r9, Pair r10, ECUIPromotion r11, Ref.BooleanRef r12, com.bytedance.android.ec.common.api.jump.model.f r13, LiveRoomParams r14) {
        this.this$0 = r1;
        this.$dest = r2;
        this.$context = r3;
        this.$promotionParams = r4;
        this.$clickArea = r5;
        this.$clickEnterFrom = r6;
        this.$btmModel = r7;
        this.$actionTracker = r8;
        this.$view = r9;
        this.$cartLoc = r10;
        this.$promotion = r11;
        this.$fallbackToDetail = r12;
        this.$pageParams = r13;
        this.$liveRoomParams = r14;
        super(1);
    }

    public final void invoke(boolean r37) {
        if (r37 == false) goto L313;
        String r2 = "";
        switch(this.$dest) {
            case 1: goto L283;
            case 2: goto L283;
            case 3: goto L182;
            case 4: goto L160;
            case 5: goto L365;
            case 6: goto L139;
            case 7: goto L138;
            case 8: goto L26;
            case 9: goto L18;
            case 10: goto L7;
            default: goto L365;
        };
    L7:
        ECCombination r1 = this.$promotion.getCombination();
        if (r1 == null) goto L17;
        final String r3 = r1.getJumpUrl();
        if (r3 == null) goto L17;
        PromotionJumpDispatcher r4 = this.this$0;
        Context r5 = this.$context;
        Function0<Unit> r6 = new PromotionJumpDispatcher$clickBuyOrItemInner$1$$special$$inlined$let$lambda$1(r3, this);
        int r7 = PromotionJumpDispatcher.i;
        r4.getClass();
        if (com.bytedance.android.ec.sdk.helper.r.a.isLogin() == false) goto L14;
        r6.invoke();
        return;
    L14:
        Activity r8 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r5);
        if (r8 == null) goto L317;
        LoginUtil.g(r8, "live_detail", "", r6);
        return;
    L317:
        return;
    L17:
        this.$fallbackToDetail.element = true;
        return;
    L18:
        jf.c r9 = this.this$0.g;
        if (r9 == null) goto L21;
        r9.l();
    L21:
        il2.a r10 = this.$actionTracker;
        if (r10 == null) goto L320;
        il2.a r11 = il2.a.C0145a.a(r10, "default", null, false, null, null, null, 62);
        if (r11 == null) goto L321;
        ((LiveActionTracker) r11).e(false);
        return;
    L321:
        return;
    L320:
        return;
    L26:
        PromotionJumpDispatcher r12 = this.this$0;
        Context r13 = this.$context;
        com.bytedance.android.ec.common.api.jump.model.g r14 = this.$promotionParams;
        com.bytedance.android.btm.api.model.d r15 = this.$btmModel;
        il2.a r16 = this.$actionTracker;
        int r17 = PromotionJumpDispatcher.i;
        r12.getClass();
        ECFindSimilarConfig r18 = EComABUtils.getSimilarConfig();
        ql.a r19 = r14.a;
        com.bytedance.android.ec.common.api.jump.model.f r110 = r14.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        LiveRoomParams r20 = r14.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        gi2.a r111 = (gi2.a) r14.getParamsModel(Reflection.getOrCreateKotlinClass(gi2.a.class));
        if (r16 == null) goto L30;
        il2.a.C0145a.a(r16, "handle_similar", MapsKt.mapOf(TuplesKt.to("similar_config_type", String.valueOf(r18.getType()))), false, null, null, null, 60);
    L30:
        int r112 = r18.getType();
        if (r112 == 0) goto L112;
        if (r112 == 1) goto L66;
        if (r112 == 2) goto L45;
        String r21 = a2.d(r18.getSchema());
        if (r21 == null) goto L41;
        String r22 = BtmUtilsKt.b(r21, BtmUtilsKt.a(r15, r14.getChainParams()));
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r13, r22);
        if (r16 == 0) goto L323;
        il2.a r23 = il2.a.C0145a.a(r16, "jump_similar", MapsKt.mapOf(TuplesKt.to("schema", r22)), false, null, null, null, 60);
        if (r23 == null) goto L324;
        ((LiveActionTracker) r23).e(false);
        return;
    L324:
        return;
    L323:
        return;
    L41:
        if (r16 == 0) goto L326;
        il2.a r24 = il2.a.C0145a.a(r16, "jump_similar", null, false, "schema_is_null", null, null, 48);
        if (r24 == null) goto L327;
        ((LiveActionTracker) r24).e(false);
        Unit r25 = Unit.INSTANCE;
        return;
    L327:
        return;
    L326:
        return;
    L45:
        UrlBuilderV2 r26 = new UrlBuilderV2(r18.getSchema());
        r26.addOrReplaceParam("product_id", r19.getProductId());
        if (r26.queryMap().containsKey("insert_room_id") == false) goto L54;
        if (r20 == null) goto L49;
        String r27 = r20.getRoomId();
    L50:
        if (r27 == null) goto L53;
        r2 = r27;
    L53:
        r26.addOrReplaceParam("insert_room_id", r2);
        goto L54
    L49:
        r27 = null;
    L54:
        BtmUtilsKt.c(r26, BtmUtilsKt.a(r15, r14.getChainParams()));
        String r28 = r26.build();
        if (r20 == null) goto L57;
        String r113 = r20.getRoomId();
    L58:
        if (r20 == null) goto L60;
        String r114 = r20.getRoomUniqueKey();
    L61:
        com.bytedance.android.livesdk.livecommerce.params.a.b(r13, r113, r114, r28, r18.getSchemaParamsType(), false, null, null, null, null, 960);
        if (r16 == 0) goto L329;
        il2.a r29 = il2.a.C0145a.a(r16, "jump_similar", MapsKt.mapOf(TuplesKt.to("schema", r28)), false, null, null, null, 60);
        if (r29 == null) goto L330;
        ((LiveActionTracker) r29).e(false);
        return;
    L330:
        return;
    L329:
        return;
    L60:
        r114 = null;
        goto L61
    L57:
        r113 = null;
        goto L58
    L66:
        String r30 = r18.getSchema();
        JSONObject r31 = new JSONObject();
        r31.put("photo_search_previous_page", "live_sold_out_page");
        if (r20 == null) goto L69;
        String r32 = r20.getEnterFromMerge();
    L70:
        if (r32 != null) goto L72;
        r32 = "";
    L72:
        r31.put("enter_from_second", r32);
        JSONObject r33 = new JSONObject();
        r33.put("product_id", r19.getProductId());
        if (r20 == null) goto L75;
        String r115 = r20.getRoomId();
    L76:
        if (r115 != null) goto L78;
        r115 = "";
    L78:
        r33.put("room_id", r115);
        if (r20 == null) goto L81;
        String r116 = r20.getAuthorId();
    L82:
        if (r116 != null) goto L84;
        r116 = "";
    L84:
        r33.put("author_id", r116);
        UrlBuilderV2 r117 = new UrlBuilderV2(r30);
        r117.setEncoding("null_encoding");
        r117.addOrReplaceParam("product_id", r19.getProductId());
        if (r20 == null) goto L87;
        String r34 = r20.getRoomId();
    L88:
        if (r34 != null) goto L90;
        r34 = "";
    L90:
        r117.addOrReplaceParam("room_id", r34);
        if (r20 == null) goto L93;
        String r35 = r20.getAuthorId();
    L94:
        if (r35 != null) goto L96;
        r35 = "";
    L96:
        r117.addOrReplaceParam("author_id", r35);
        String r36 = r19.getCover();
        if (r36 == null) goto L100;
        r2 = r36;
    L100:
        r117.addOrReplaceParam("search_image_url", r2);
        r117.addOrReplaceParam("search_scan_params", r31.toString());
        r117.addOrReplaceParam("search_passthrough_params", r33.toString());
        if (r110 == null) goto L103;
        jf.b r38 = r110.c;
    L105:
        if (Intrinsics.areEqual(r38, jf.b.l.b) == false) goto L107;
        r117.addOrReplaceParam("enter_from", "search_live_product");
    L107:
        r117.addOrReplaceParam("float_screen", String.valueOf(0.73f));
        BtmUtilsKt.c(r117, BtmUtilsKt.a(r15, r14.getChainParams()));
        String r39 = r117.build();
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r13, r39);
        if (r16 == 0) goto L332;
        il2.a r40 = il2.a.C0145a.a(r16, "jump_similar", MapsKt.mapOf(TuplesKt.to("schema", r39)), false, null, null, null, 60);
        if (r40 == null) goto L333;
        ((LiveActionTracker) r40).e(false);
        return;
    L333:
        return;
    L332:
        return;
    L103:
        r38 = null;
        goto L105
    L93:
        r35 = null;
        goto L94
    L87:
        r34 = null;
        goto L88
    L81:
        r116 = null;
        goto L82
    L75:
        r115 = null;
        goto L76
    L69:
        r32 = null;
        goto L70
    L112:
        int r41 = RoomContextController.h;
        if (r20 == null) goto L115;
        String r42 = r20.getRoomId();
    L116:
        if (r20 == null) goto L118;
        String r43 = r20.getRoomUniqueKey();
    L119:
        Set r44 = ((LinkedHashMap) RoomContextController.a.b(r42, r43).d.c).keySet();
        String r45 = r18.getSchema();
        String r46 = CollectionsKt.joinToString$default(r44, ",", null, null, 30, null, null, 54, null);
        UrlBuilderV2 r118 = new UrlBuilderV2(r45);
        BtmUtilsKt.c(r118, BtmUtilsKt.a(r15, r14.getChainParams()));
        UrlBuilderV2 r47 = new UrlBuilderV2((String) r118.queryMap().get("url"));
        r47.addOrReplaceParam("filters", r46);
        r47.addOrReplaceParam("product_id", r19.getProductId());
        r118.addOrReplaceParam("url", r47.build());
        if (r20 == null) goto L122;
        String r48 = r20.getRoomId();
    L123:
        if (r48 == null) goto L126;
        r2 = r48;
    L126:
        r118.addOrReplaceParam("live_window_room_id", r2);
        r118.addOrReplaceParam("height_percent", 73);
        String r49 = r118.build();
        if (r20 == null) goto L129;
        String r119 = r20.getRoomId();
    L130:
        if (r20 == null) goto L132;
        String r120 = r20.getRoomUniqueKey();
    L133:
        com.bytedance.android.livesdk.livecommerce.params.a.b(r13, r119, r120, r49, r18.getSchemaParamsType(), false, null, null, null, null, 960);
        if (r16 == 0) goto L335;
        il2.a r50 = il2.a.C0145a.a(r16, "jump_similar", MapsKt.mapOf(TuplesKt.to("schema", r49)), false, null, null, null, 60);
        if (r50 == null) goto L336;
        ((LiveActionTracker) r50).e(false);
        return;
    L336:
        return;
    L335:
        return;
    L132:
        r120 = null;
        goto L133
    L129:
        r119 = null;
        goto L130
    L122:
        r48 = null;
        goto L123
    L118:
        r43 = null;
        goto L119
    L115:
        r42 = null;
        goto L116
    L138:
        PromotionJumpDispatcher.D(this.this$0, this.$context, this.$promotionParams, 1, 0, 0, this.$promotion.isFlash(), this.$btmModel, this.$actionTracker, null, new AnonymousClass3(this), 5592);
        return;
    L139:
        String r121 = this.$promotion.directlyJumpUrl;
        if (r121 == null) goto L154;
        jf.c r51 = this.this$0.g;
        if (r51 != null) goto L144;
    L152:
        this.this$0.n(this.$context, r121, this.$btmModel, this.$promotionParams, this.$clickArea, this.$actionTracker);
        Unit r52 = Unit.INSTANCE;
    L153:
        if (r52 == null) goto L154;
        return;
    L144:
        if (r51.k(r121) != true) goto L152;
        il2.a r122 = this.$actionTracker;
        if (r122 == null) goto L151;
        il2.a r53 = il2.a.C0145a.a(r122, "direct_jump_intercepted", MapsKt.mapOf(TuplesKt.to("schema", r121)), false, null, null, null, 60);
        if (r53 == null) goto L151;
        ((LiveActionTracker) r53).e(false);
        r52 = Unit.INSTANCE;
    L151:
        r52 = null;
    L154:
        il2.a r54 = this.$actionTracker;
        if (r54 == null) goto L340;
        il2.a r55 = il2.a.C0145a.a(r54, "direct_jump", null, false, "schema_is_null", null, null, 48);
        if (r55 == null) goto L341;
        ((LiveActionTracker) r55).e(false);
        Unit r56 = Unit.INSTANCE;
        return;
    L341:
        return;
    L340:
        return;
    L283:
        final PromotionJumpDispatcher r57 = this.this$0;
        final Context r123 = this.$context;
        final com.bytedance.android.ec.common.api.jump.model.g r124 = this.$promotionParams;
        final String r125 = this.$clickArea;
        final int r126 = this.$clickEnterFrom;
        final com.bytedance.android.btm.api.model.d r127 = this.$btmModel;
        final il2.a r128 = this.$actionTracker;
        final View r58 = this.$view;
        final Pair r59 = this.$cartLoc;
        int r60 = PromotionJumpDispatcher.i;
        r57.getClass();
        ECUIPromotion r61 = r124.a;
        if (r61 == null) goto L312;
        final ECUIPromotion r210 = r61;
        if (r128 == null) goto L294;
        ECJumpDestination r62 = r210.getJumpDestination();
        if (r62 != null) goto L290;
    L292:
        boolean r63 = false;
    L293:
        il2.a.C0145a.a(r128, "jump_to_sku_or_order", MapsKt.mapOf(TuplesKt.to("skip_check", String.valueOf(r63))), false, null, null, null, 60);
        goto L294
    L290:
        if (r62.getSkipCheck() != true) goto L292;
        r63 = true;
    L294:
        final Ref.ObjectRef r64 = new Ref.ObjectRef();
        r64.element = null;
        int r65 = ECSdk.a;
        IEShoppingService r66 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r66 == null) goto L299;
        sc3.c r67 = r66.getBuyNowService();
        if (r67 == null) goto L299;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r68 = r67.n(new com.bytedance.android.ec.model.d(r123, "PromotionJumpDispatcher_2", System.currentTimeMillis()));
    L300:
        if (r68 == null) goto L302;
        r68.c(ChainPoint.PAGE_INIT, Long.valueOf(System.currentTimeMillis()));
    L302:
        final com.bytedance.android.shopping.buynow.monitor.firstscreen.a r69 = r68;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r310 = r68;
        final Function1<ECPromotionCheckResponse, Unit> r70 = new PromotionJumpDispatcher$jumpToSkuOrOrder$jump$1(r57, r69, r210, r123, r125, r126, r64, r124, r127, r128, r58, r59);
        ECJumpDestination r71 = r210.getJumpDestination();
        if (r71 == null) goto L308;
        if (r71.getSkipCheck() != true) goto L308;
        r70.invoke(null);
        return;
    L308:
        if (r310 == null) goto L310;
        r310.c(ChainPoint.SKU_CHECK_START, Long.valueOf(System.currentTimeMillis()));
    L310:
        PromotionJumpDispatcher.D(r57, r123, r124, r126, 0, 0, r210.isFlash(), r127, r128, new PromotionJumpDispatcher$jumpToSkuOrOrder$1(r57, r64), new PromotionJumpDispatcher$jumpToSkuOrOrder$2(r57, r210, r123, r124, r127, r128, r58, r59, r70), 1496);
        r64.element = r57.K(r123, r124, r310, r125, r126, r127);
        return;
    L299:
        r68 = null;
        goto L300
    L312:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    L365:
        return;
    L160:
        if (this.$promotion.isLottery() == false) goto L180;
        PromotionJumpDispatcher r72 = this.this$0;
        Context r73 = this.$context;
        com.bytedance.android.ec.common.api.jump.model.g r74 = this.$promotionParams;
        String r75 = this.$clickArea;
        com.bytedance.android.btm.api.model.d r76 = this.$btmModel;
        il2.a r77 = this.$actionTracker;
        int r78 = PromotionJumpDispatcher.i;
        r72.getClass();
        if (r77 == null) goto L164;
        il2.a.C0145a.a(r77, "open_lottery_panel", null, false, null, null, null, 62);
    L164:
        ql.a r129 = r74.a;
        ECUILotteryInfo r79 = r129.getLotteryInfo();
        if (r79 != null) goto L167;
    L169:
        s r130 = new s(r72, r129, r76, r73, r77);
        if (ECDisplayUtils.c(r73) == false) goto L179;
        ECUILotteryInfo r80 = r129.getLotteryInfo();
        if (r80 != null) goto L174;
    L175:
        jf.c r81 = r72.g;
        if (r81 == null) goto L178;
        r81.b();
    L178:
        new Handler().post(r130);
        return;
    L174:
        if (r80.isLotteryFinish() != true) goto L175;
    L179:
        r130.run();
        return;
    L167:
        if (r79.isScarceLotteryWinNotBuy() != true) goto L169;
        r72.r(r73, r74, r75, ECDisplayUtils.c(r73), r76, r77, 1);
        return;
    L180:
        this.$fallbackToDetail.element = true;
        return;
    L182:
        if (this.$promotion.isAuction() == false) goto L268;
        PromotionJumpDispatcher r82 = this.this$0;
        Context r83 = this.$context;
        ECPromotionAuctionInfo r85 = this.$promotion.getAuctionInfo();
        if (r85 == null) goto L186;
        String r86 = r85.getJumpUrl();
    L187:
        if (r86 != null) goto L189;
        r86 = "";
    L189:
        com.bytedance.android.ec.common.api.jump.model.g r131 = this.$promotionParams;
        String r132 = this.$clickArea;
        com.bytedance.android.btm.api.model.d r133 = this.$btmModel;
        il2.a r134 = this.$actionTracker;
        int r87 = PromotionJumpDispatcher.i;
        r82.getClass();
        ECUICampaign r88 = r131.a.getCampaign();
        if (r88 == null) goto L192;
        ECPromotionAuctionInfo r89 = r88.auctionInfo;
    L193:
        if (r89 == null) goto L195;
        Integer r135 = r89.getStatus();
    L196:
        if (r135 != null) goto L199;
    L266:
        jf.d.b.c(r82, r83, r131, r132, ECDisplayUtils.c(r83), r133, r134);
        return;
    L199:
        if (r135.intValue() != 2) goto L266;
        a r90 = a.a;
        Intrinsics.checkNotNullParameter(r131, "promotionParams");
        if (r83 != null) goto L206;
        if (r134 == null) goto L347;
        il2.a r91 = il2.a.C0145a.a(r134, "open_bid", null, false, "context_is_null", null, null, 48);
        if (r91 == null) goto L348;
        ((LiveActionTracker) r91).e(false);
        return;
    L348:
        return;
    L347:
        return;
    L206:
        if (r89 != null) goto L212;
        if (r134 == null) goto L350;
        il2.a r92 = il2.a.C0145a.a(r134, "open_bid", null, false, "auction_info_is_null", null, null, 48);
        if (r92 == null) goto L351;
        ((LiveActionTracker) r92).e(false);
        return;
    L351:
        return;
    L350:
        return;
    L212:
        if (r89.getBizId() != 1) goto L224;
        CurrentUserInfo r93 = r89.getCurrentUserInfo();
        if (r93 == null) goto L216;
        String r94 = String.valueOf(r93.getUserId());
    L218:
        if (Intrinsics.areEqual(r94, com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId()) == false) goto L224;
        com.bytedance.android.livesdk.livecommerce.utils.k.n(r83, th.a.g(r83, 2131896342));
        if (r134 == null) goto L353;
        il2.a r95 = il2.a.C0145a.a(r134, "open_bid_self_highest", null, false, null, null, null, 62);
        if (r95 == null) goto L354;
        ((LiveActionTracker) r95).e(false);
        return;
    L354:
        return;
    L353:
        return;
    L216:
        r94 = null;
    L224:
        LiveRoomParams r96 = r131.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r97 = r131.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r97 == null) goto L227;
        jf.b r98 = r97.c;
    L228:
        if (r96 == null) goto L230;
        Map<String, String> r99 = new sg2.v("", r96).g();
    L231:
        UrlBuilderV2 r136 = new UrlBuilderV2(r86);
        r136.addOrReplaceParam("from_type", "live");
        if (r96 == null) goto L234;
        String r100 = r96.getCreativeId();
    L235:
        if (r100 != null) goto L237;
        r100 = "";
    L237:
        r136.addOrReplaceParam("creative_id", r100);
        JSONObject r101 = new JSONObject();
        JSONObject r137 = new JSONObject();
        if (r99 == null) goto L243;
        Iterator<Map.Entry<String, String>> r138 = r99.entrySet().iterator();
    L241:
        if (r138.hasNext() == false) goto L243;
        Map.Entry<String, String> r139 = r138.next();
        String r102 = r139.getKey();
        String r140 = r2;
        r137.put(r102, r139.getValue());
        r2 = r140;
    L243:
        String r141 = r2;
        if (r98 == null) goto L246;
        String r103 = r98.a;
    L247:
        r137.put("ecom_entrance_form", r103);
        r137.put("product_id", r89.getProductId());
        if (r96 == null) goto L252;
        Function0 r104 = r96.getScreenType();
        if (r104 == null) goto L252;
        String r105 = (String) r104.invoke();
    L253:
        if (r105 != null) goto L255;
        r105 = r141;
    L255:
        r137.put("screen_type", r105);
        Unit r106 = Unit.INSTANCE;
        r101.put("ecom_live_lynx_log_data", r137);
        JSONObject r107 = new JSONObject();
        JSONObject r108 = new JSONObject();
        r108.put("product_id", r89.getProductId());
        r107.put("order_log_data", r108);
        JSONObject r109 = new JSONObject();
        if (r99 == null) goto L261;
        Iterator<Map.Entry<String, String>> r142 = r99.entrySet().iterator();
    L259:
        if (r142.hasNext() == false) goto L261;
        Map.Entry<String, String> r143 = r142.next();
        r109.put(r143.getKey(), r143.getValue());
    L261:
        Unit r144 = Unit.INSTANCE;
        r107.put("order_entrance_info", r109);
        r101.put("ecom_live_lynx_data", r107);
        r136.addOrReplaceParam("mega_object", r101.toString());
        BtmUtilsKt.c(r136, BtmUtilsKt.a(r133, r131.getChainParams()));
        String r145 = r136.build();
        Handler r146 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r83, r145);
        if (r134 == null) goto L356;
        il2.a r147 = il2.a.C0145a.a(r134, "open_bid", MapsKt.mapOf(TuplesKt.to("bid_schema", r145)), false, null, null, null, 60);
        if (r147 == null) goto L357;
        ((LiveActionTracker) r147).e(false);
        return;
    L357:
        return;
    L356:
        return;
    L252:
        r105 = null;
        goto L253
    L246:
        r103 = null;
        goto L247
    L234:
        r100 = null;
        goto L235
    L230:
        r99 = null;
        goto L231
    L227:
        r98 = null;
        goto L228
    L195:
        r135 = null;
        goto L196
    L192:
        r89 = null;
        goto L193
    L186:
        r86 = null;
        goto L187
    L268:
        if (this.$promotion.isAuctionV2() == false) goto L282;
        PromotionJumpDispatcher r148 = this.this$0;
        Context r149 = this.$context;
        ECAuctionInfo r150 = this.$promotion.auctionV2;
        if (r150 == null) goto L272;
        String r151 = r150.getJumpUrl();
    L273:
        if (r151 != null) goto L275;
        String r152 = "";
    L276:
        com.bytedance.android.ec.common.api.jump.model.g r153 = this.$promotionParams;
        String r154 = this.$clickArea;
        com.bytedance.android.btm.api.model.d r155 = this.$btmModel;
        il2.a r156 = this.$actionTracker;
        int r157 = PromotionJumpDispatcher.i;
        r148.getClass();
        ECAuctionInfo r158 = r153.a.getAuctionV2();
        if (r158 != null) goto L279;
    L281:
        jf.d.b.c(r148, r149, r153, r154, ECDisplayUtils.c(r149), r155, r156);
        return;
    L279:
        if (r158.getStatus() != 2) goto L281;
        a.a.getClass();
        a.a(r149, r152, r153, r155, r156);
        return;
    L275:
        r152 = r151;
        goto L276
    L272:
        r151 = null;
        goto L273
    L282:
        this.$fallbackToDetail.element = true;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
