package com.bytedance.android.shopping.feed.view;

import android.os.Looper;
import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.MFPromotionEvent;
import com.bytedance.android.ec.model.response.anchorv3.ProductLeaderBoardEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionBigSaleStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionMarketFloor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLogisticsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductServiceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductShopEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.info.CouponGroupLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3CrossborderInfoLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3LogisticsLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3ProductBottomBannerListLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.AnchorV3RankInfoLayout;
import com.bytedance.android.shopping.anchorv3.detail.widget.InflowFeedServiceView;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.InnerFeedSellingPointView;
import com.bytedance.android.shopping.feed.widget.ProductFeedCouponBackLayout;
import com.bytedance.android.shopping.feed.widget.ProductFeedPlatformActivityCouponLayout;
import com.bytedance.android.shopping.feed.widget.WindowEntryInfoView;
import com.bytedance.android.shopping.feed.widget.inflowsellingpoint.InFlowSellingPointAreaView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static final HashMap<String, Queue<View>> a = null;
    public static final boolean b = false;

    static {
        a = new HashMap();
        b = ld3.d.e(ld3.d.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.ArrayList] */
    public static CouponGroupLayout a(PromotionProductStruct r10) {
        Intrinsics.checkNotNullParameter(r10, "promotion");
        PromotionProductPrivilegesStruct r0 = r10.getPrivilegeInfo();
        View r1 = null;
        if (r0 == null) goto L7;
        PromotionProductCouponsStruct r2 = r0.getCoupons();
        if (r2 == null) goto L7;
        List r3 = r2.getDiscountLabels();
    L8:
        List r4 = r3;
        boolean r5 = false;
        if (r4 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
    L46:
        return r1;
    L17:
        if (r10.isShowDiscount() == false) goto L46;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L21;
        r5 = true;
    L21:
        if (r5 == false) goto L45;
        Queue<View> r7 = a.get(CouponGroupLayout.class.getName());
        if (r7 == null) goto L25;
        View r8 = r7.poll();
    L27:
        if ((r8 instanceof CouponGroupLayout) == false) goto L30;
        r1 = r8;
    L30:
        r1 = (CouponGroupLayout) r1;
        if (r1 == null) goto L46;
        PromotionProductPrivilegesStruct r11 = r10.getPrivilegeInfo();
        if (r11 == null) goto L42;
        PromotionProductCouponsStruct r12 = r11.getCoupons();
        if (r12 == null) goto L42;
        List r13 = r12.getDiscountLabels();
        if (r13 == null) goto L42;
        List r14 = r13;
        ?? r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L40:
        if (r15.hasNext() == false) goto L43;
        PromotionDiscountLabel r16 = (PromotionDiscountLabel) r15.next();
        r9.add(new d63.h(r16.getTag(), r16.getTagHeader(), r16.getType(), r16.getId(), Integer.valueOf(r16.getUiType())));
    L43:
        r1.b(r9);
    L42:
        r9 = CollectionsKt.emptyList();
        goto L43
    L25:
        r8 = null;
        goto L27
    L45:
        throw new IllegalStateException("only main thread can touch");
    L11:
        if (r4.isEmpty() == true) goto L14;
        r6 = false;
    L7:
        r3 = null;
        goto L8
    }

    public static View b(PromotionProductStruct r8, AnchorV3Param r9, ProductFeedViewModel r10, rd3.a r11) {
        Intrinsics.checkNotNullParameter(r8, "promotion");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        boolean r5 = false;
        AnchorV3CrossborderInfoLayout r7 = null;
        if (b == false) goto L49;
        Intrinsics.checkNotNullParameter(r8, "promotion");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        PromotionProductAuthorEntriesStruct r12 = r8.getEntryInfo();
        if (r12 == null) goto L7;
        ProductLeaderBoardEntryStruct r13 = r12.getLeaderBoardEntry();
    L8:
        if (r13 != null) goto L33;
        PromotionProductPrivilegesStruct r14 = r8.getPrivilegeInfo();
        if (r14 == null) goto L22;
        PromotionProductLogisticsStruct r15 = r14.getLogistics();
        if (r15 == null) goto L22;
        List r16 = r15.getLogisticText();
        if (r16 == null) goto L22;
        String r17 = (String) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L22;
        if (r17.length() <= 0) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == true) goto L33;
    L20:
        r18 = false;
    L22:
        PromotionProductBaseStruct r19 = r8.getBaseInfo();
        if (r19 == null) goto L25;
        List r110 = r19.getSellingPointInfo();
    L26:
        if (r110 != null) goto L33;
        PromotionProductPrivilegesStruct r111 = r8.getPrivilegeInfo();
        if (r111 == null) goto L30;
        List r112 = r111.getServices();
    L31:
        if (r112 != null) goto L33;
        return null;
    L30:
        r112 = null;
        goto L31
    L25:
        r110 = null;
    L33:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L35;
        r5 = true;
    L35:
        if (r5 == false) goto L48;
        Queue<View> r113 = a.get(InFlowSellingPointAreaView.class.getName());
        if (r113 == null) goto L39;
        View r114 = r113.poll();
    L41:
        if ((r114 instanceof InFlowSellingPointAreaView) == false) goto L44;
        r7 = r114;
    L44:
        InFlowSellingPointAreaView r20 = (InFlowSellingPointAreaView) r7;
        if (r20 == null) goto L351;
        r20.c(r11, r8, r9);
        return r20;
    L351:
        return r20;
    L39:
        r114 = null;
        goto L41
    L48:
        throw new IllegalStateException("only main thread can touch");
    L7:
        r13 = null;
        goto L8
    L49:
        InnerFlowPageStyleDTO r0 = r10.getInnerFlowPageStyle();
        if (r0 == null) goto L77;
        PageStyle r1 = r0.getPageStyle();
        if (r1 == null) goto L77;
        if (r1.getWindowEntryPriority() != 2) goto L77;
        PromotionProductAuthorEntriesStruct r2 = r8.getEntryInfo();
        if (r2 == null) goto L58;
        PromotionProductShopEntryStruct r3 = r2.getShopEntry();
    L59:
        if (r3 == null) goto L77;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L63;
        r5 = true;
    L63:
        if (r5 == false) goto L76;
        Queue<View> r21 = a.get(WindowEntryInfoView.class.getName());
        if (r21 == null) goto L67;
        View r22 = r21.poll();
    L69:
        if ((r22 instanceof WindowEntryInfoView) == false) goto L72;
        r7 = r22;
    L72:
        WindowEntryInfoView r23 = (WindowEntryInfoView) r7;
        if (r23 == null) goto L353;
        r23.a(r8, r11);
        return r23;
    L353:
        return r23;
    L67:
        r22 = null;
        goto L69
    L76:
        throw new IllegalStateException("only main thread can touch");
    L58:
        r3 = null;
    L77:
        PromotionProductPrivilegesStruct r4 = r8.getPrivilegeInfo();
        if (r4 == null) goto L82;
        PromotionProductActivitiesStruct r6 = r4.getActivities();
        if (r6 == null) goto L82;
        MFPromotionEvent r24 = r6.getMfPromotionEvent();
    L83:
        if (r24 != null) goto L85;
        PromotionProductPrivilegesStruct r25 = r8.getPrivilegeInfo();
        if (r25 == null) goto L106;
        PromotionProductActivitiesStruct r26 = r25.getActivities();
        if (r26 == null) goto L106;
        PromotionMarketFloor r27 = r26.getPlatformTextActivity();
    L107:
        if (r27 != null) goto L109;
    L127:
        PromotionProductExtraStruct r28 = r8.getExtraInfo();
        if (r28 == null) goto L130;
        PromotionCrossBorderStruct r29 = r28.getCrossborderInfo();
    L131:
        if (r29 != null) goto L133;
        PromotionProductPrivilegesStruct r30 = r8.getPrivilegeInfo();
        if (r30 == null) goto L152;
        List r31 = r30.getBanners();
    L153:
        if (r31 == null) goto L183;
        PromotionProductPrivilegesStruct r32 = r8.getPrivilegeInfo();
        if (r32 == null) goto L161;
        List r33 = r32.getBanners();
        if (r33 == null) goto L161;
        PromotionProductBannerStruct r34 = (PromotionProductBannerStruct) CollectionsKt.firstOrNull(r33);
        if (r34 == null) goto L161;
        Integer r35 = r34.getBannerType();
    L162:
        if (r35 == null) goto L167;
        if (r35.intValue() == 4) goto L183;
    L167:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L169;
        r5 = true;
    L169:
        if (r5 == false) goto L182;
        Queue<View> r115 = a.get(InflowFeedBannerView.class.getName());
        if (r115 == null) goto L173;
        AnchorV3CrossborderInfoLayout r116 = (View) r115.poll();
    L175:
        if ((r116 instanceof InflowFeedBannerView) == false) goto L178;
        r7 = r116;
    L178:
        InflowFeedBannerView r36 = (InflowFeedBannerView) r7;
        if (r36 == null) goto L361;
        r36.b(r8, r9);
        return r36;
    L361:
        return r36;
    L173:
        r116 = null;
        goto L175
    L182:
        throw new IllegalStateException("only main thread can touch");
    L161:
        r35 = null;
    L183:
        PromotionProductAuthorEntriesStruct r37 = r8.getEntryInfo();
        if (r37 == null) goto L186;
        ProductLeaderBoardEntryStruct r38 = r37.getLeaderBoardEntry();
    L187:
        if (r38 != null) goto L189;
        PromotionProductPrivilegesStruct r39 = r8.getPrivilegeInfo();
        if (r39 == null) goto L240;
        PromotionProductLogisticsStruct r40 = r39.getLogistics();
        if (r40 == null) goto L240;
        List r41 = r40.getLogisticText();
        if (r41 == null) goto L240;
        String r42 = (String) CollectionsKt.firstOrNull(r41);
        if (r42 == null) goto L240;
        if (r42.length() <= 0) goto L219;
        boolean r43 = true;
    L220:
        if (r43 != true) goto L240;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L224;
        r5 = true;
    L224:
        if (r5 == false) goto L239;
        Queue<View> r44 = a.get(AnchorV3LogisticsLayout.class.getName());
        if (r44 == null) goto L228;
        View r45 = r44.poll();
    L230:
        if ((r45 instanceof AnchorV3LogisticsLayout) == true) goto L232;
        r45 = null;
    L232:
        AnchorV3LogisticsLayout r46 = (AnchorV3LogisticsLayout) r45;
        if (r46 == null) goto L367;
        PromotionProductPrivilegesStruct r47 = r8.getPrivilegeInfo();
        if (r47 == null) goto L237;
        r7 = r47.getLogistics();
    L237:
        r46.b(r7);
    L367:
        return r46;
    L228:
        r45 = null;
        goto L230
    L239:
        throw new IllegalStateException("only main thread can touch");
    L219:
        r43 = false;
    L240:
        PromotionProductPrivilegesStruct r48 = r8.getPrivilegeInfo();
        if (r48 == null) goto L243;
        List r49 = r48.getTags();
    L244:
        if (r49 != null) goto L246;
        PromotionProductBaseStruct r50 = r8.getBaseInfo();
        if (r50 == null) goto L270;
        List r51 = r50.getSellingPointInfo();
    L271:
        if (r51 != null) goto L273;
        PromotionProductPrivilegesStruct r52 = r8.getPrivilegeInfo();
        if (r52 == null) goto L295;
        List r53 = r52.getServices();
    L296:
        if (r53 != null) goto L298;
        InnerFlowPageStyleDTO r54 = r10.getInnerFlowPageStyle();
        if (r54 == null) goto L368;
        PageStyle r55 = r54.getPageStyle();
        if (r55 != null) goto L326;
        return null;
    L326:
        if (r55.getWindowEntryPriority() != 1) goto L370;
        PromotionProductAuthorEntriesStruct r56 = r8.getEntryInfo();
        if (r56 == null) goto L330;
        PromotionProductShopEntryStruct r57 = r56.getShopEntry();
    L331:
        if (r57 != null) goto L333;
        return null;
    L333:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L335;
        r5 = true;
    L335:
        if (r5 == false) goto L348;
        Queue<View> r58 = a.get(WindowEntryInfoView.class.getName());
        if (r58 == null) goto L339;
        AnchorV3CrossborderInfoLayout r59 = (View) r58.poll();
    L341:
        if ((r59 instanceof WindowEntryInfoView) == false) goto L344;
        r7 = r59;
    L344:
        WindowEntryInfoView r60 = (WindowEntryInfoView) r7;
        if (r60 == null) goto L372;
        r60.a(r8, r11);
        return r60;
    L372:
        return r60;
    L339:
        r59 = null;
        goto L341
    L348:
        throw new IllegalStateException("only main thread can touch");
    L330:
        r57 = null;
        goto L331
    L370:
        return null;
    L368:
        return null;
    L298:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L300;
        r5 = true;
    L300:
        if (r5 == false) goto L320;
        Queue<View> r61 = a.get(InflowFeedServiceView.class.getName());
        if (r61 == null) goto L304;
        AnchorV3LogisticsLayout r62 = (View) r61.poll();
    L306:
        if ((r62 instanceof InflowFeedServiceView) == true) goto L308;
        r62 = null;
    L308:
        r46 = (InflowFeedServiceView) r62;
        if (r46 == null) goto L367;
        PromotionProductPrivilegesStruct r63 = r8.getPrivilegeInfo();
        if (r63 == null) goto L318;
        List r64 = r63.getServices();
        if (r64 == null) goto L318;
        List r65 = r64;
        r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r65, 10));
        Iterator r66 = r65.iterator();
    L316:
        if (r66.hasNext() == false) goto L318;
        r7.add(((PromotionProductServiceStruct) r66.next()).getTitle());
    L318:
        r46.b(r7);
        goto L367
    L304:
        r62 = null;
        goto L306
    L320:
        throw new IllegalStateException("only main thread can touch");
    L295:
        r53 = null;
        goto L296
    L273:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L275;
        r5 = true;
    L275:
        if (r5 == false) goto L291;
        Queue<View> r67 = a.get(InnerFeedSellingPointView.class.getName());
        if (r67 == null) goto L279;
        AnchorV3LogisticsLayout r68 = (View) r67.poll();
    L281:
        if ((r68 instanceof InnerFeedSellingPointView) == true) goto L283;
        r68 = null;
    L283:
        r46 = (InnerFeedSellingPointView) r68;
        if (r46 == null) goto L367;
        PromotionProductBaseStruct r69 = r8.getBaseInfo();
        if (r69 == null) goto L288;
        r7 = r69.getSellingPointInfo();
    L288:
        r46.b(r7);
        goto L367
    L279:
        r68 = null;
        goto L281
    L291:
        throw new IllegalStateException("only main thread can touch");
    L270:
        r51 = null;
        goto L271
    L246:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L248;
        r5 = true;
    L248:
        if (r5 == false) goto L266;
        Queue<View> r70 = a.get(AnchorV3ProductBottomBannerListLayout.class.getName());
        if (r70 == null) goto L252;
        AnchorV3CrossborderInfoLayout r71 = (View) r70.poll();
    L254:
        if ((r71 instanceof AnchorV3ProductBottomBannerListLayout) == false) goto L257;
        r7 = r71;
    L257:
        AnchorV3ProductBottomBannerListLayout r72 = (AnchorV3ProductBottomBannerListLayout) r7;
        if (r72 == null) goto L365;
        PromotionProductExtraStruct r73 = r8.getExtraInfo();
        if (r73 == null) goto L264;
        PromotionBigSaleStruct r74 = r73.getBigSaleInfo();
        if (r74 == null) goto L264;
        r74.getInBigSale();
    L264:
        r72.b(r8);
        return r72;
    L365:
        return r72;
    L252:
        r71 = null;
        goto L254
    L266:
        throw new IllegalStateException("only main thread can touch");
    L243:
        r49 = null;
        goto L244
    L189:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L191;
        r5 = true;
    L191:
        if (r5 == false) goto L207;
        Queue<View> r117 = a.get(AnchorV3RankInfoLayout.class.getName());
        if (r117 == null) goto L195;
        AnchorV3CrossborderInfoLayout r118 = (View) r117.poll();
    L197:
        if ((r118 instanceof AnchorV3RankInfoLayout) == false) goto L200;
        r7 = r118;
    L200:
        AnchorV3RankInfoLayout r75 = (AnchorV3RankInfoLayout) r7;
        if (r11.e == false) goto L203;
        String r119 = "c3865.d58821";
    L204:
        if (r75 == null) goto L363;
        PromotionProductAuthorEntriesStruct r76 = r8.getEntryInfo();
        Intrinsics.checkNotNull(r76);
        ProductLeaderBoardEntryStruct r77 = r76.getLeaderBoardEntry();
        Intrinsics.checkNotNull(r77);
        r75.R5(r77, r9, r119);
        return r75;
    L363:
        return r75;
    L203:
        r119 = "c4701.d20783";
        goto L204
    L195:
        r118 = null;
        goto L197
    L207:
        throw new IllegalStateException("only main thread can touch");
    L186:
        r38 = null;
        goto L187
    L152:
        r31 = null;
        goto L153
    L133:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L135;
        r5 = true;
    L135:
        if (r5 == false) goto L148;
        Queue<View> r78 = a.get(AnchorV3CrossborderInfoLayout.class.getName());
        if (r78 == null) goto L139;
        View r79 = r78.poll();
    L141:
        if ((r79 instanceof AnchorV3CrossborderInfoLayout) == false) goto L144;
        r7 = r79;
    L144:
        AnchorV3CrossborderInfoLayout r80 = r7;
        if (r80 == null) goto L359;
        r80.b(r8);
        return r80;
    L359:
        return r80;
    L139:
        r79 = null;
        goto L141
    L148:
        throw new IllegalStateException("only main thread can touch");
    L130:
        r29 = null;
        goto L131
    L109:
        if (r8.hasPlatformDiscountCoupon() == false) goto L127;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L113;
        r5 = true;
    L113:
        if (r5 == false) goto L126;
        Queue<View> r81 = a.get(ProductFeedPlatformActivityCouponLayout.class.getName());
        if (r81 == null) goto L117;
        View r82 = r81.poll();
    L119:
        if ((r82 instanceof ProductFeedPlatformActivityCouponLayout) == false) goto L122;
        r7 = r82;
    L122:
        ProductFeedPlatformActivityCouponLayout r84 = (ProductFeedPlatformActivityCouponLayout) r7;
        if (r84 == null) goto L357;
        r84.b(r8);
        return r84;
    L357:
        return r84;
    L117:
        r82 = null;
        goto L119
    L126:
        throw new IllegalStateException("only main thread can touch");
    L106:
        r27 = null;
        goto L107
    L85:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L87;
        r5 = true;
    L87:
        if (r5 == false) goto L100;
        Queue<View> r85 = a.get(ProductFeedCouponBackLayout.class.getName());
        if (r85 == null) goto L91;
        View r86 = r85.poll();
    L93:
        if ((r86 instanceof ProductFeedCouponBackLayout) == false) goto L96;
        r7 = r86;
    L96:
        ProductFeedCouponBackLayout r87 = (ProductFeedCouponBackLayout) r7;
        if (r87 == null) goto L355;
        r87.b(r8);
        return r87;
    L355:
        return r87;
    L91:
        r86 = null;
        goto L93
    L100:
        throw new IllegalStateException("only main thread can touch");
    L82:
        r24 = null;
        goto L83
    }
}
