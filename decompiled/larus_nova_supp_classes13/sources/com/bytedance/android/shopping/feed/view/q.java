package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.y;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public static final boolean a = false;
    public static final a b = null;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r10v3, types: [java.util.ArrayList] */
        public static CouponGroupLayout b(PromotionProductStruct r9, Context r10) {
            Intrinsics.checkNotNullParameter(r9, "promotion");
            Intrinsics.checkNotNullParameter(r10, "context");
            PromotionProductPrivilegesStruct r0 = r9.getPrivilegeInfo();
            CouponGroupLayout r1 = null;
            if (r0 == null) goto L7;
            PromotionProductCouponsStruct r2 = r0.getCoupons();
            if (r2 == null) goto L7;
            List r3 = r2.getDiscountLabels();
        L8:
            List r4 = r3;
            if (r4 != null) goto L11;
        L14:
            boolean r5 = true;
        L15:
            if (r5 == false) goto L17;
        L30:
            return r1;
        L17:
            if (r9.isShowDiscount() == false) goto L30;
            r1 = new CouponGroupLayout(r10);
            PromotionProductPrivilegesStruct r11 = r9.getPrivilegeInfo();
            if (r11 == null) goto L28;
            PromotionProductCouponsStruct r12 = r11.getCoupons();
            if (r12 == null) goto L28;
            List r13 = r12.getDiscountLabels();
            if (r13 == null) goto L28;
            List r14 = r13;
            ?? r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r16 = r14.iterator();
        L26:
            if (r16.hasNext() == false) goto L29;
            PromotionDiscountLabel r6 = (PromotionDiscountLabel) r16.next();
            r15.add(new d63.h(r6.getTag(), r6.getTagHeader(), r6.getType(), r6.getId(), Integer.valueOf(r6.getUiType())));
        L29:
            r1.b(r15);
        L28:
            r15 = CollectionsKt.emptyList();
            goto L29
        L11:
            if (r4.isEmpty() == true) goto L14;
            r5 = false;
        L7:
            r3 = null;
            goto L8
        }

        public static View a(PromotionProductStruct r9, Context r10, AnchorV3Param r11, ProductFeedViewModel r12, rd3.a r13) {
            Intrinsics.checkNotNullParameter(r9, "promotion");
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r12, "viewModel");
            Intrinsics.checkNotNullParameter(r13, "anchorInflowFeedItem");
            PromotionProductLogisticsStruct r8 = null;
            if (q.a == false) goto L34;
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r9, "promotion");
            Intrinsics.checkNotNullParameter(r12, "viewModel");
            Intrinsics.checkNotNullParameter(r13, "anchorInflowFeedItem");
            PromotionProductAuthorEntriesStruct r14 = r9.getEntryInfo();
            if (r14 == null) goto L7;
            ProductLeaderBoardEntryStruct r15 = r14.getLeaderBoardEntry();
        L8:
            if (r15 != null) goto L32;
            PromotionProductPrivilegesStruct r16 = r9.getPrivilegeInfo();
            if (r16 == null) goto L22;
            PromotionProductLogisticsStruct r17 = r16.getLogistics();
            if (r17 == null) goto L22;
            List r18 = r17.getLogisticText();
            if (r18 == null) goto L22;
            String r19 = (String) CollectionsKt.firstOrNull(r18);
            if (r19 == null) goto L22;
            if (r19.length() <= 0) goto L20;
            boolean r110 = true;
        L21:
            if (r110 == true) goto L32;
        L20:
            r110 = false;
        L22:
            PromotionProductBaseStruct r111 = r9.getBaseInfo();
            if (r111 == null) goto L25;
            List r112 = r111.getSellingPointInfo();
        L26:
            if (r112 != null) goto L32;
            PromotionProductPrivilegesStruct r113 = r9.getPrivilegeInfo();
            if (r113 == null) goto L30;
            List r114 = r113.getServices();
        L31:
            if (r114 != null) goto L32;
            return null;
        L30:
            r114 = null;
            goto L31
        L25:
            r112 = null;
        L32:
            InFlowSellingPointAreaView r115 = new InFlowSellingPointAreaView(r10, null, 6, 0);
            r115.c(r13, r9, r11);
            View r116 = r115;
        L185:
            return r116;
        L7:
            r15 = null;
            goto L8
        L34:
            InnerFlowPageStyleDTO r0 = r12.getInnerFlowPageStyle();
            if (r0 == null) goto L46;
            PageStyle r1 = r0.getPageStyle();
            if (r1 == null) goto L46;
            if (r1.getWindowEntryPriority() != 2) goto L46;
            PromotionProductAuthorEntriesStruct r2 = r9.getEntryInfo();
            if (r2 == null) goto L43;
            PromotionProductShopEntryStruct r3 = r2.getShopEntry();
        L44:
            if (r3 == null) goto L46;
            AnchorV3CrossborderInfoLayout r117 = new WindowEntryInfoView(r10, null, 6, 0);
            r117.a(r9, r13);
        L186:
            return r117;
        L43:
            r3 = null;
        L46:
            PromotionProductPrivilegesStruct r4 = r9.getPrivilegeInfo();
            if (r4 == null) goto L51;
            PromotionProductActivitiesStruct r5 = r4.getActivities();
            if (r5 == null) goto L51;
            MFPromotionEvent r6 = r5.getMfPromotionEvent();
        L52:
            if (r6 == null) goto L55;
            r117 = new ProductFeedCouponBackLayout(r10, null, 6, 0);
            r117.b(r9);
            goto L186
        L55:
            PromotionProductPrivilegesStruct r7 = r9.getPrivilegeInfo();
            if (r7 == null) goto L60;
            PromotionProductActivitiesStruct r20 = r7.getActivities();
            if (r20 == null) goto L60;
            PromotionMarketFloor r21 = r20.getPlatformTextActivity();
        L61:
            if (r21 != null) goto L63;
        L65:
            PromotionProductExtraStruct r22 = r9.getExtraInfo();
            if (r22 == null) goto L68;
            PromotionCrossBorderStruct r23 = r22.getCrossborderInfo();
        L69:
            if (r23 == null) goto L71;
            r117 = new AnchorV3CrossborderInfoLayout(r10, null, 6, 0);
            r117.b(r9);
            goto L186
        L71:
            PromotionProductPrivilegesStruct r24 = r9.getPrivilegeInfo();
            if (r24 == null) goto L74;
            List r25 = r24.getBanners();
        L75:
            if (r25 == null) goto L89;
            PromotionProductPrivilegesStruct r26 = r9.getPrivilegeInfo();
            if (r26 == null) goto L83;
            List r27 = r26.getBanners();
            if (r27 == null) goto L83;
            PromotionProductBannerStruct r28 = (PromotionProductBannerStruct) CollectionsKt.firstOrNull(r27);
            if (r28 == null) goto L83;
            Integer r29 = r28.getBannerType();
        L84:
            if (r29 != null) goto L87;
        L88:
            InflowFeedBannerView r118 = new InflowFeedBannerView(r10, null, 6, 0);
            r118.b(r9, r11);
            r116 = r118;
            goto L185
        L87:
            if (r29.intValue() == 4) goto L89;
        L83:
            r29 = null;
        L89:
            PromotionProductAuthorEntriesStruct r30 = r9.getEntryInfo();
            if (r30 == null) goto L92;
            ProductLeaderBoardEntryStruct r31 = r30.getLeaderBoardEntry();
        L93:
            if (r31 != null) goto L95;
            PromotionProductPrivilegesStruct r119 = r9.getPrivilegeInfo();
            if (r119 == null) goto L116;
            PromotionProductLogisticsStruct r120 = r119.getLogistics();
            if (r120 == null) goto L116;
            List r121 = r120.getLogisticText();
            if (r121 == null) goto L116;
            String r122 = (String) CollectionsKt.firstOrNull(r121);
            if (r122 == null) goto L116;
            if (r122.length() <= 0) goto L110;
            boolean r123 = true;
        L111:
            if (r123 != true) goto L116;
            r117 = new AnchorV3LogisticsLayout(r10, null, 6, 0);
            PromotionProductPrivilegesStruct r32 = r9.getPrivilegeInfo();
            if (r32 == null) goto L115;
            r8 = r32.getLogistics();
        L115:
            r117.b(r8);
            goto L186
        L110:
            r123 = false;
        L116:
            PromotionProductPrivilegesStruct r124 = r9.getPrivilegeInfo();
            if (r124 == null) goto L119;
            List r125 = r124.getTags();
        L120:
            if (r125 == null) goto L127;
            r117 = new AnchorV3ProductBottomBannerListLayout(r10, null, 6, 0);
            PromotionProductExtraStruct r126 = r9.getExtraInfo();
            if (r126 == null) goto L126;
            PromotionBigSaleStruct r127 = r126.getBigSaleInfo();
            if (r127 == null) goto L126;
            r127.getInBigSale();
        L126:
            r117.b(r9);
            goto L186
        L127:
            PromotionProductBaseStruct r128 = r9.getBaseInfo();
            if (r128 == null) goto L130;
            List r129 = r128.getSellingPointInfo();
        L131:
            if (r129 == null) goto L136;
            r117 = new InnerFeedSellingPointView(r10, null, 6, 0);
            PromotionProductBaseStruct r33 = r9.getBaseInfo();
            if (r33 == null) goto L135;
            r8 = r33.getSellingPointInfo();
        L135:
            r117.b(r8);
            goto L186
        L136:
            PromotionProductPrivilegesStruct r130 = r9.getPrivilegeInfo();
            if (r130 == null) goto L143;
            List r131 = r130.getServices();
            if (r131 == null) goto L143;
            PromotionProductServiceStruct r132 = (PromotionProductServiceStruct) CollectionsKt.firstOrNull(r131);
            if (r132 == null) goto L143;
            Integer r133 = r132.getServiceType();
        L144:
            if (r133 != null) goto L147;
        L157:
            PromotionProductPrivilegesStruct r134 = r9.getPrivilegeInfo();
            if (r134 == null) goto L160;
            List r135 = r134.getServices();
        L161:
            if (r135 == null) goto L171;
            r117 = new InflowFeedServiceView(r10, null, 6, 0);
            PromotionProductPrivilegesStruct r34 = r9.getPrivilegeInfo();
            if (r34 == null) goto L170;
            List r35 = r34.getServices();
            if (r35 == null) goto L170;
            List r36 = r35;
            r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
            Iterator r37 = r36.iterator();
        L168:
            if (r37.hasNext() == false) goto L170;
            r8.add(((PromotionProductServiceStruct) r37.next()).getTitle());
        L170:
            r117.b(r8);
            goto L186
        L171:
            InnerFlowPageStyleDTO r136 = r12.getInnerFlowPageStyle();
            if (r136 == null) goto L188;
            PageStyle r137 = r136.getPageStyle();
            if (r137 != null) goto L176;
            return null;
        L176:
            if (r137.getWindowEntryPriority() != 1) goto L190;
            PromotionProductAuthorEntriesStruct r138 = r9.getEntryInfo();
            if (r138 == null) goto L180;
            PromotionProductShopEntryStruct r139 = r138.getShopEntry();
        L181:
            if (r139 == null) goto L191;
            r117 = new WindowEntryInfoView(r10, null, 6, 0);
            r117.a(r9, r13);
            goto L186
        L191:
            return null;
        L180:
            r139 = null;
            goto L181
        L190:
            return null;
        L188:
            return null;
        L160:
            r135 = null;
            goto L161
        L147:
            if (r133.intValue() != 11) goto L157;
            r117 = new InflowFeedSecureBuyView(r10, null, 6, 0);
            PromotionProductPrivilegesStruct r38 = r9.getPrivilegeInfo();
            if (r38 == null) goto L186;
            List r39 = r38.getServices();
            if (r39 == null) goto L186;
            PromotionProductServiceStruct r40 = (PromotionProductServiceStruct) CollectionsKt.firstOrNull(r39);
            if (r40 == null) goto L186;
            Intrinsics.checkNotNullParameter(r40, "promotionProductServiceStruct");
            y.d(r117.a, r40.getIcon());
            r117.b.setText(r40.getSubtitle());
            int r140 = com.bytedance.android.ec.core.utils.s.a;
            Integer r41 = com.bytedance.android.ec.core.utils.s.b(r40.getSubtitleTextColor());
            if (r41 == null) goto L186;
            r117.b.setTextColor(r41.intValue());
        L143:
            r133 = null;
            goto L144
        L130:
            r129 = null;
            goto L131
        L119:
            r125 = null;
            goto L120
        L95:
            if (r13.e == false) goto L97;
            String r141 = "c3865.d58821";
        L98:
            AnchorV3RankInfoLayout r142 = new AnchorV3RankInfoLayout(r10, null, 6, 0);
            PromotionProductAuthorEntriesStruct r42 = r9.getEntryInfo();
            Intrinsics.checkNotNull(r42);
            ProductLeaderBoardEntryStruct r43 = r42.getLeaderBoardEntry();
            Intrinsics.checkNotNull(r43);
            r142.R5(r43, r11, r141);
            return r142;
        L97:
            r141 = "c4701.d20783";
            goto L98
        L92:
            r31 = null;
            goto L93
        L74:
            r25 = null;
            goto L75
        L68:
            r23 = null;
            goto L69
        L63:
            if (r9.hasPlatformDiscountCoupon() == false) goto L65;
            r117 = new ProductFeedPlatformActivityCouponLayout(r10, null, 6, 0);
            r117.b(r9);
        L60:
            r21 = null;
        L51:
            r6 = null;
            goto L52
        }
    }

    static {
        b = new a();
        a = ld3.d.e(ld3.d.b());
    }
}
