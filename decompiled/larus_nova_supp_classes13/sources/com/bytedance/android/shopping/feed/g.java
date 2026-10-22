package com.bytedance.android.shopping.feed;

import android.content.Context;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStructV2;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.FallbackPage;
import com.bytedance.android.shopping.anchorv3.repository.dto.InflowRespExtra;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.enumeration.GoodPriceCardOrStripType;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.g0;
import com.bytedance.android.shopping.feed.event.o1;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.fragment.VideoProductFeedFragment;
import com.bytedance.android.shopping.feed.model.feedbackboard.FeedbackBoardDataUtils;
import com.bytedance.android.shopping.feed.repository.api.ReqFeedbackPanelDataViewType;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Observer<PromotionPackResponse> {
    public final /* synthetic */ ProductFeedStarter a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function1 c;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        ProductFeedStarter.d(this.a, r5.getMessage(), null, false, this.c);
    }

    public final void onNext(Object r24) {
        PromotionPackResponse r2 = (PromotionPackResponse) r24;
        Intrinsics.checkNotNullParameter(r2, "resp");
        boolean r4 = false;
        String r6 = null;
        if (r2.isValid() == true) goto L13;
        FallbackPage r0 = r2.getFallbackPage();
        if (r0 == null) goto L10;
        if (com.bytedance.android.shopping.feed.utils.j.b(r0) == true) goto L13;
    L10:
        if (cg4.a.a(r2.getBdturing()) == false) goto L12;
        ProductFeedStarter.d(this.a, r2.getMessage(), Integer.valueOf(r2.getStatusCode()), true, this.c);
    L422:
        ProductFeedStarter r1 = this.a;
        PromotionLogPbData r3 = r2.getLogPb();
        if (r3 == null) goto L425;
        r6 = r3.getImprId();
    L425:
        r1.f = r6;
        this.a.getClass();
        if (ld3.c.a() == 1) goto L428;
        return;
    L428:
        if (FeedbackBoardDataUtils.a != null) goto L430;
        r4 = true;
    L430:
        if (r4 == false) goto L462;
        FeedbackBoardDataUtils.a(ReqFeedbackPanelDataViewType.VIDEO_INNER_FLOW.getType());
        return;
    L462:
        return;
    L12:
        ProductFeedStarter.d(this.a, r2.getMessage(), Integer.valueOf(r2.getStatusCode()), true, this.c);
    L13:
        List r5 = r2.getPromotions();
        if (r5 == null) goto L28;
        Iterator r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L25;
        Object r8 = r7.next();
        PromotionProductBaseStruct r9 = ((PromotionProductStruct) r8).getBaseInfo();
        if (r9 == null) goto L21;
        String r10 = r9.getPromotionId();
    L23:
        if (Intrinsics.areEqual(r10, this.a.v.getCurrentPromotionId()) == false) goto L17;
    L26:
        PromotionProductStruct r11 = (PromotionProductStruct) r8;
        if (r11 == null) goto L28;
    L32:
        if (r11 == null) goto L36;
        ProductFeedStarter r12 = this.a;
        PromotionProductStruct r13 = r12.d;
        r12.d = r11;
        if (r13.isPreload() == false) goto L36;
        this.a.d.setForceRefreshHeadCard(true);
    L36:
        InnerFlowPageStyleDTO r14 = r2.getInnerFlowPageStyle();
        if (r14 == null) goto L48;
        this.a.j = r14;
        if (ld3.c.e() == true) goto L48;
        if (ProductFeedStarter.c(this.a, this.b) == false) goto L43;
    L44:
        ProductFeedStarter r15 = this.a;
        VideoProductFeedFragment r16 = r15.m;
        if (r16 == null) goto L48;
        r16.ea0(r15.j);
        goto L48
    L43:
        if (this.a.m != null) goto L44;
    L48:
        if (ld3.c.e() == true) goto L50;
    L56:
        String r17 = "0";
        if (ProductFeedStarter.c(this.a, this.b) == true) goto L66;
        ProductFeedStarter r18 = this.a;
        if (r18.m != null) goto L66;
        List<? extends PromotionProductStruct> r19 = r2.getPromotions();
        InflowRespExtra r110 = r2.getExtra();
        if (r110 == null) goto L64;
        String r111 = r110.getAdExtra();
    L65:
        r18.i(r19, r111);
    L318:
        AnchorV3Param r20 = this.a.l;
        if (r20 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L321:
        if (r20 == null) goto L323;
        r20.setFallbackPage(r2.getFallbackPage());
    L323:
        FeedProductEventTracker r21 = FeedProductEventTracker.a;
        PromotionProductExtraStruct r22 = this.a.d.getExtraInfo();
        if (r22 == null) goto L326;
        String r112 = r22.getCBizCombo();
    L327:
        PromotionProductExtraStruct r23 = this.a.d.getExtraInfo();
        if (r23 == null) goto L330;
        String r113 = r23.getBuyinTrack();
    L331:
        AnchorV3PromotionRequestParam r25 = this.a.a;
        if (r25 != null) goto L334;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L334:
        String r114 = r25.getItemId();
        AnchorV3PromotionRequestParam r26 = this.a.a;
        if (r26 != null) goto L337;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L337:
        String r115 = r26.getPromotionId();
        AnchorV3PromotionRequestParam r27 = this.a.a;
        if (r27 != null) goto L340;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L340:
        String r116 = r27.getAuthorId();
        InflowRespExtra r28 = r2.getExtra();
        if (r28 == null) goto L343;
        String r117 = r28.getLogId();
    L344:
        AnchorV3PromotionRequestParam r29 = this.a.a;
        if (r29 != null) goto L347;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L347:
        String r118 = r29.getUserId();
        r21.getClass();
        Single.fromCallable(new g0(4, r112, r113, r114, r115, r116, r117, r118)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
        if (ld3.c.b() == 0) goto L350;
        boolean r30 = true;
    L351:
        if (r30 == false) goto L398;
        PromotionProductPrivilegesStruct r31 = this.a.d.getPrivilegeInfo();
        if (r31 == null) goto L357;
        PromotionProductActivitiesStruct r32 = r31.getActivities();
        if (r32 == null) goto L357;
        CommonGirdleStructV2 r33 = r32.getCommonGirdleV2();
    L358:
        if (r33 != null) goto L398;
        Queue<j> r34 = p.a;
        AnchorV3PromotionRequestParam r35 = this.a.a;
        if (r35 != null) goto L362;
        Intrinsics.throwUninitializedPropertyAccessException("reqParam");
    L362:
        String r36 = r35.getItemId();
        PromotionProductStruct r37 = this.a.d;
        if (r37 == null) goto L367;
        PromotionProductBaseStruct r38 = r37.getBaseInfo();
        if (r38 == null) goto L367;
        String r39 = r38.getPromotionId();
    L368:
        Intrinsics.checkNotNullParameter(r2, "resp");
        if (r36 == null) goto L398;
        if (p.a != null) goto L374;
        p.a = new ArrayBlockingQueue(5);
    L374:
        Queue<j> r40 = p.a;
        if (r40 == null) goto L398;
        ArrayBlockingQueue r119 = (ArrayBlockingQueue) r40;
        if (r119.size() >= 5) goto L440;
    L379:
        Iterator r41 = r119.iterator();
    L381:
        if (r41.hasNext() == false) goto L438;
        j r120 = (j) r41.next();
        if (r39 == null) goto L381;
        if (Intrinsics.areEqual(r120.b, r36) == false) goto L381;
        Queue<j> r121 = p.a;
        PromotionProductStruct r122 = p.a(r120.a, r39);
        if (r122 == null) goto L391;
        PromotionProductBaseStruct r123 = r122.getBaseInfo();
        if (r123 == null) goto L391;
        String r124 = r123.getPromotionId();
    L393:
        if (Intrinsics.areEqual(r124, r39) == false) goto L381;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r120.a = r2;
        r120.c = System.currentTimeMillis();
    L391:
        r124 = null;
        goto L393
    L438:
        r119.add(new j(r2, r36, System.currentTimeMillis()));     // Catch: Exception -> L397
    L397:
        Unit r42 = Unit.INSTANCE;
        goto L398
    L440:
        r40.remove();     // Catch: Exception -> L433
    L367:
        r39 = null;
    L357:
        r33 = null;
    L398:
        com.bytedance.android.ec.monitor.duration.i r43 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r44 = r43.get(this.a.h);
        if (r44 == null) goto L410;
        PromotionProductPrivilegesStruct r125 = this.a.d.getPrivilegeInfo();
        if (r125 == null) goto L405;
        PromotionProductActivitiesStruct r126 = r125.getActivities();
        if (r126 == null) goto L405;
        CommonGirdleStructV2 r127 = r126.getCommonGirdleV2();
    L406:
        if (r127 == null) goto L408;
        Object r128 = "1";
    L409:
        r44.b("is_activity", r128);
        goto L410
    L408:
        r128 = "0";
    L405:
        r127 = null;
    L410:
        com.bytedance.android.ec.monitor.duration.d r45 = r43.get(this.a.i);
        if (r45 == null) goto L421;
        PromotionProductPrivilegesStruct r46 = this.a.d.getPrivilegeInfo();
        if (r46 == null) goto L417;
        PromotionProductActivitiesStruct r47 = r46.getActivities();
        if (r47 == null) goto L417;
        CommonGirdleStructV2 r48 = r47.getCommonGirdleV2();
    L418:
        if (r48 == null) goto L420;
        r17 = "1";
    L420:
        r45.b("is_activity", r17);
    L417:
        r48 = null;
    L421:
        this.c.invoke(Boolean.TRUE);
        goto L422
    L350:
        r30 = false;
        goto L351
    L343:
        r117 = null;
        goto L344
    L330:
        r113 = null;
        goto L331
    L326:
        r112 = null;
        goto L327
    L64:
        r111 = null;
    L66:
        ProductFeedStarter r49 = this.a;
        if (r49.s == null) goto L253;
        PromotionProductStruct r50 = r49.t;
        if (r50 != null) goto L71;
    L72:
        int r51 = com.bytedance.android.ec.core.opt.ab.m.a;
        Object r129 = 0;
        boolean r52 = ECServiceManager.a;
        s83.g r53 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r53 == null) goto L78;
        s83.a r54 = r53.q();
        if (r54 == null) goto L78;
        Object r55 = r54.e("ec_inflow_cache_resp_no_req");
        if (r55 == null) goto L78;
    L243:
        if (((Number) r55).intValue() == 0) goto L245;
        boolean r56 = true;
    L246:
        if (r56 == false) goto L253;
        com.bytedance.android.ec.monitor.duration.i r57 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r130 = r57.get(this.a.h);
        if (r130 == null) goto L250;
        r130.b("render_again", "0");
    L250:
        com.bytedance.android.ec.monitor.duration.d r58 = r57.get(this.a.i);
        if (r58 == null) goto L262;
        r58.b("render_again", "0");
    L262:
        ProductFeedStarter.e(this.a);
        ProductFeedStarter r59 = this.a;
        List<? extends PromotionProductStruct> r131 = r2.getPromotions();
        InflowRespExtra r132 = r2.getExtra();
        if (r132 == null) goto L265;
        String r133 = r132.getAdExtra();
    L266:
        r59.i(r131, r133);
        ProductFeedStarter r60 = this.a;
        VideoProductFeedFragment r134 = r60.m;
        if (r134 == null) goto L318;
        AnchorV3Param r61 = r60.l;
        if (r61 != null) goto L271;
        Intrinsics.throwUninitializedPropertyAccessException("anchorV3Param");
    L271:
        Intrinsics.checkNotNullParameter(r61, "anchorV3Param");
        ProductFeedContentFragment r135 = r134.r;
        if (r135 == null) goto L317;
        Intrinsics.checkNotNullParameter(r61, "anchorV3Param");
        r135.U90().setAnchorV3Param(r61);
        Context r136 = r135.getContext();
        if (r136 == null) goto L276;
        TrackerProvider.a r137 = TrackerProvider.Companion;
        int r138 = o1.b;
        o1 r139 = o1.a.a(r61, BtmSDK.INSTANCE.getPageId(PageFinder.via(r135)));
        r137.getClass();
        TrackerProvider.a.a(r136, r139);
    L276:
        AnchorV3Param r140 = r135.U90().m907getAnchorV3Param();
        if (r140 != null) goto L279;
    L281:
        r135.Z90();
    L282:
        FeedProductEventTracker r141 = FeedProductEventTracker.a;
        Context r142 = r135.getContext();
        AnchorV3Param r143 = r135.U90().m907getAnchorV3Param();
        ProductFeedAdapter r144 = r135.o;
        if (r144 == null) goto L285;
        String r145 = r144.B2();
    L286:
        r141.getClass();
        FeedProductEventTracker.s(r142, r143, r145);
        PromotionProductBaseStruct r146 = r61.getCurrentPromotion().getBaseInfo();
        if (r146 == null) goto L292;
        if (r146.isSoldOut() != true) goto L292;
        r135.W90();
    L292:
        if (r61.getCurrentPromotion().isApiBack() == false) goto L317;
        if (r61.getCurrentPromotion().isPreload() == true) goto L317;
        int r147 = com.bytedance.android.shopping.feed.utils.c.a;
        Long r148 = com.bytedance.android.shopping.feed.utils.c.d(r61.getCurrentPromotion().getProductPrice());
        if (r148 == null) goto L317;
        long r149 = r148.longValue();
        PromotionProductBaseStruct r150 = r61.getCurrentPromotion().getBaseInfo();
        if (r150 == null) goto L317;
        String r151 = r150.getProductId();
        String r152 = r150.getShopId();
        String r153 = r150.getSkuId();
        List r154 = r150.getImages();
        if (r154 == null) goto L306;
        ECUrlModel r155 = (ECUrlModel) CollectionsKt.firstOrNull(r154);
        if (r155 == null) goto L306;
        String r156 = r155.getFirstUrl();
    L307:
        List<ud3.d> r157 = CollectionsKt.listOf(new ud3.d(r151, r152, r153, r156, Long.valueOf(r149), r61.getAuthorId()));
        Integer r158 = r61.getRequestParam().getGoodPriceCardMainOpt();
        ArrayList r159 = new ArrayList();
        r159.add(GoodPriceCardOrStripType.MAIN_PRODUCT_BAR.getType());
        if (r158 != null) goto L311;
    L313:
        Iterator r160 = r159.iterator();
    L315:
        if (r160.hasNext() == false) goto L317;
        r135.U90().tryLoadGoodPriceCardOrStrip(r157, (String) r160.next());
        goto L315
    L311:
        if (r158.intValue() != 0) goto L313;
        r159.add(GoodPriceCardOrStripType.GOOD_PRICE_CARD_1.getType());
    L306:
        r156 = null;
        goto L307
    L285:
        r145 = null;
        goto L286
    L279:
        if (r140.isFullScreen() != true) goto L281;
        r135.Y90();
    L317:
        r134.ba0(r61);
        goto L318
    L265:
        r133 = null;
        goto L266
    L245:
        r56 = false;
    L78:
        int r62 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r63 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L233
        Object r65 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_cache_resp_no_req");     // Catch: Throwable -> L129
        if (r65 != null) goto L84;
    L126:
        Object r161 = null;
    L127:
        Object r66 = Result.constructor-impl(r161);     // Catch: Throwable -> L129
    L131:
        Throwable r162 = Result.exceptionOrNull-impl(r66);     // Catch: Throwable -> L233
        if (r162 == null) goto L135;
        EnsureManager.ensureNotReachHere(r162);     // Catch: Throwable -> L233
    L135:
        if (Result.isFailure-impl(r66) == false) goto L138;
        r66 = null;
    L138:
        if ((r66 instanceof Integer) == true) goto L140;
        r66 = null;
    L140:
        r55 = (Integer) r66;     // Catch: Throwable -> L233
        if (r55 != null) goto L147;
        Object r67 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_cache_resp_no_req");     // Catch: Throwable -> L233
        if ((r67 instanceof Integer) == true) goto L146;
        r67 = null;
    L146:
        r55 = (Integer) r67;     // Catch: Throwable -> L233
    L147:
        if (r55 != null) goto L243;
        int r68 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L233
        Object r69 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_cache_resp_no_req");     // Catch: Throwable -> L199
        if (r69 != null) goto L154;
    L196:
        Object r163 = null;
    L197:
        Object r70 = Result.constructor-impl(r163);     // Catch: Throwable -> L199
    L201:
        Throwable r164 = Result.exceptionOrNull-impl(r70);     // Catch: Throwable -> L224
        if (r164 == null) goto L205;
        EnsureManager.ensureNotReachHere(r164);     // Catch: Throwable -> L224
    L205:
        if (Result.isFailure-impl(r70) == false) goto L208;
        r70 = null;
    L208:
        if ((r70 instanceof Integer) == true) goto L210;
        r70 = null;
    L210:
        r55 = (Integer) r70;     // Catch: Throwable -> L224
        if (r55 != null) goto L231;
        IHybridHostService r71 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L224
        if (r71 == null) goto L216;
        Object r72 = r71.getHostABValue("ec_inflow_cache_resp_no_req", r129);     // Catch: Throwable -> L224
    L217:
        if (r72 != null) goto L219;
    L230:
        r55 = r129;
        goto L231
    L219:
        if ((r72 instanceof Integer) == true) goto L221;
        r72 = null;
    L221:
        r55 = (Integer) r72;     // Catch: Throwable -> L224
        if (r55 != null) goto L231;
    L224:
        th = move-exception;
        Result.Companion r165 = Result.Companion;     // Catch: Throwable -> L233
        r55 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L233
        Throwable r166 = Result.exceptionOrNull-impl(r55);     // Catch: Throwable -> L233
        if (r166 == null) goto L229;
        EnsureManager.ensureNotReachHere(r166);     // Catch: Throwable -> L233
    L229:
        if (Result.isFailure-impl(r55) == false) goto L231;
    L216:
        r72 = null;
    L231:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_cache_resp_no_req", r55);     // Catch: Throwable -> L233
        goto L243
    L154:
        if ((r69 instanceof Integer) == true) goto L156;
        Object r167 = null;
    L157:
        r163 = (Integer) r167;     // Catch: Throwable -> L199
        if (r163 != null) goto L197;
        if ((r69 instanceof Number) == false) goto L184;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L169;
        Float r73 = Float.valueOf(((Number) r69).floatValue());     // Catch: Throwable -> L199
        if ((r73 instanceof Integer) == true) goto L167;
        r73 = null;
    L167:
        r163 = (Integer) r73;     // Catch: Throwable -> L199
        goto L197
    L169:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L175;
        Double r74 = Double.valueOf(((Number) r69).doubleValue());     // Catch: Throwable -> L199
        if ((r74 instanceof Integer) == true) goto L173;
        r74 = null;
    L173:
        r163 = (Integer) r74;     // Catch: Throwable -> L199
        goto L197
    L175:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L178;
        r163 = Integer.valueOf(((Number) r69).intValue());     // Catch: Throwable -> L199
        goto L197
    L178:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L184;
        Long r75 = Long.valueOf(((Number) r69).longValue());     // Catch: Throwable -> L199
        if ((r75 instanceof Integer) == true) goto L182;
        r75 = null;
    L182:
        r163 = (Integer) r75;     // Catch: Throwable -> L199
    L184:
        if ((r69 instanceof JSONObject) == false) goto L186;
    L436:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L192
        Object r76 = SDKSettingsCacheManager.a().fromJson(r69.toString(), Integer.class);     // Catch: Throwable -> L192
        if ((r76 instanceof Integer) == true) goto L190;
        r76 = null;
    L190:
        Object r77 = Result.constructor-impl((Integer) r76);     // Catch: Throwable -> L192
    L194:
        r163 = r77;
        if (Result.isFailure-impl(r163) == false) goto L197;
    L192:
        th = move-exception;
        Result.Companion r168 = Result.Companion;     // Catch: Throwable -> L199
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L199
        goto L194
    L186:
        if ((r69 instanceof JSONArray) == false) goto L196;
    L156:
        r167 = r69;
    L199:
        th = move-exception;
        Result.Companion r169 = Result.Companion;     // Catch: Throwable -> L224
        r70 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L224
        goto L201
    L84:
        if ((r65 instanceof Integer) == true) goto L86;
        Object r170 = null;
    L87:
        r161 = (Integer) r170;     // Catch: Throwable -> L129
        if (r161 != null) goto L127;
        if ((r65 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r78 = Float.valueOf(((Number) r65).floatValue());     // Catch: Throwable -> L129
        if ((r78 instanceof Integer) == true) goto L97;
        r78 = null;
    L97:
        r161 = (Integer) r78;     // Catch: Throwable -> L129
        goto L127
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r79 = Double.valueOf(((Number) r65).doubleValue());     // Catch: Throwable -> L129
        if ((r79 instanceof Integer) == true) goto L103;
        r79 = null;
    L103:
        r161 = (Integer) r79;     // Catch: Throwable -> L129
        goto L127
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        r161 = Integer.valueOf(((Number) r65).intValue());     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r80 = Long.valueOf(((Number) r65).longValue());     // Catch: Throwable -> L129
        if ((r80 instanceof Integer) == true) goto L112;
        r80 = null;
    L112:
        r161 = (Integer) r80;     // Catch: Throwable -> L129
    L114:
        if ((r65 instanceof JSONObject) == false) goto L116;
    L434:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r81 = SDKSettingsCacheManager.a().fromJson(r65.toString(), Integer.class);     // Catch: Throwable -> L122
        if ((r81 instanceof Integer) == true) goto L120;
        r81 = null;
    L120:
        Object r82 = Result.constructor-impl((Integer) r81);     // Catch: Throwable -> L122
    L124:
        r161 = r82;
        if (Result.isFailure-impl(r161) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r171 = Result.Companion;     // Catch: Throwable -> L129
        r82 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r65 instanceof JSONArray) == false) goto L126;
    L86:
        r170 = r65;
    L129:
        th = move-exception;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L233
        r66 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L233
    L233:
        th = move-exception;
        Result.Companion r173 = Result.Companion;
        Object r84 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r174 = Result.exceptionOrNull-impl(r84);
        if (r174 == null) goto L238;
        EnsureManager.ensureNotReachHere(r174);
    L238:
        if (Result.isFailure-impl(r84) == true) goto L241;
        r129 = r84;
    L241:
        r55 = r129;
        goto L243
    L71:
        if (r50.isPreload() != true) goto L72;
    L253:
        ProductFeedStarter r85 = this.a;
        if (r85.s == null) goto L256;
        r85.d.setForceRefreshHeadCard(true);
    L256:
        com.bytedance.android.ec.monitor.duration.i r86 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r175 = r86.get(this.a.h);
        if (r175 == null) goto L259;
        r175.b("render_again", "1");
    L259:
        com.bytedance.android.ec.monitor.duration.d r87 = r86.get(this.a.i);
        if (r87 == null) goto L262;
        r87.b("render_again", "1");
        goto L262
    L50:
        if (ProductFeedStarter.c(this.a, this.b) == false) goto L52;
    L53:
        ProductFeedStarter r88 = this.a;
        VideoProductFeedFragment r89 = r88.m;
        if (r89 == null) goto L56;
        r89.ea0(r88.j);
        goto L56
    L52:
        if (this.a.m == null) goto L56;
    L21:
        r10 = null;
        goto L23
    L25:
        r8 = null;
    L28:
        List r90 = r2.getPromotions();
        if (r90 == null) goto L31;
        r11 = (PromotionProductStruct) CollectionsKt.first(r90);
        goto L32
    L31:
        r11 = null;
        goto L32
    }

    public g(ProductFeedStarter r1, boolean r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
