package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionAskExplainInfo;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.response.ECPromotionLotteryInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.model.ECUISkuInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingDialog;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static si2.p b(xi2.l r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        si2.p r0 = new si2.p();
        r0.j = r8.couponMetaId;
        int r1 = r8.type;
        boolean r2 = false;
        if (r1 > 0) goto L8;
    L10:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L15;
        r0.a = 1;
        r0.b = r8.discount;
    L30:
        r0.e = r8.startTime + "-" + r8.expireTime;
        r0.f = r8.periodType;
        r0.g = r8.validPeriod;
        r0.h = r8.typeString;
        r0.n = r8.shopId;
        r0.i = r8.leftAmount;
        if (r8.status != 3) goto L33;
        r2 = true;
    L33:
        r0.k = r2;
        r0.l = r8.liveCouponStatus;
        r0.m = r8.couponSource;
        r0.o = r8.typeIcon;
        r0.p = r8.typeIconWidth;
        r0.q = r8.typeIconHeight;
        r0.r = r8.kolUserTag;
        return r0;
    L15:
        if (r1 > 0) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L22;
        r0.a = 2;
        r0.c = r8.credit / 100;
        goto L30
    L22:
        if (r1 > 0) goto L24;
    L26:
        boolean r3 = false;
    L27:
        if (r3 == false) goto L29;
        r0.a = 3;
        r0.c = r8.credit / 100;
        r0.d = r8.threshold / 100;
        goto L30
    L29:
        r0.c = r8.credit / 100;
        r0.d = r8.threshold / 100;
        goto L30
    L24:
        if ((r1 % 10) != 3) goto L26;
        r3 = true;
        goto L27
    L17:
        if ((r1 % 10) != 2) goto L19;
        r6 = true;
        goto L20
    L8:
        if ((r1 % 10) != 1) goto L10;
        r4 = true;
        goto L12
    }

    public static ECPromotion c(ECCurrentPromotion r4) {
        ECPromotion r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        l(r4.a(), r4.extraParam);
        if (r4.a() != null) goto L8;
    L34:
        return r0;
    L8:
        if (r4.a().size() <= 0) goto L34;
        List r1 = r4.a();
        if (r1 == null) goto L13;
        r0 = (ECPromotion) ListProtector.get(r1, 0);
    L13:
        if (r0 == null) goto L34;
        ((com.bytedance.android.ec.model.g) r0).statusCode = ((com.bytedance.android.ec.model.g) r4).statusCode;
        ((com.bytedance.android.ec.model.g) r0).statusMessage = ((com.bytedance.android.ec.model.g) r4).statusMessage;
        ECCurrentPromotion.CommodityIcon r2 = r4.commodityIconInfo;
        if (r2 == null) goto L17;
        r0.productType = r2.productType;
        r0.upIcon = r2.upIcon;
        r0.bottomIcon = r2.bottomIcon;
        r0.buttomIconWide = r2.buttomIconWide;
        r0.liveRoomType = r2.liveRoomType;
        r0.upDesc = r2.upDesc;
        r0.topIcon = r2.topIcon;
        r0.upIconTagTrack = r2.upIconTagTrack;
        r0.background = r2.background;
    L17:
        r0.showDuration = r4.showDuration;
        r0.carouselTime = r4.carouselTime;
        r0.rawCampaign = r4.campaign;
        r0.serverTime = r4.serverTime;
        r0.logicalClock = r4.logicalClock;
        r0.floatWindowInfo = r4.floatWindowInfo;
        r0.extendInfo = r4.extendInfo;
        r0.roomType = r4.roomType;
        r0.isRetry = r4.a;
        r0.publicArea = r4.publicArea;
        r0.skinData = r4.skinData;
        r0.showPriority = r4.showPriority;
        r0.replaceRelatedInfo = r4.replaceRelatedInfo;
        ECCurrentPromotion.b r3 = r4.extra;
        if (r3 == null) goto L21;
        r0.logid = r3.logid;
    L21:
        if (r4.roomInfo == null) goto L34;
        if (r0.eventParams != null) goto L25;
        r0.eventParams = new HashMap();
    L25:
        r0.eventParams.put("room_type", String.valueOf(r4.roomInfo.getRoomType()));
        r0.eventParams.put("instant_room_type", String.valueOf(r4.roomInfo.getInstantRoomType()));
        if (r4.roomInfo.getReceiveAddressId() == null) goto L29;
        r0.eventParams.put("receive_address_id", r4.roomInfo.getReceiveAddressId());
    L29:
        if (r4.roomInfo.getAddressType() == null) goto L32;
        r0.eventParams.put("address_type", r4.roomInfo.getAddressType());
    L32:
        if (r4.roomInfo.getAddressStrategy() == null) goto L34;
        r0.eventParams.put("address_strategy_type", r4.roomInfo.getAddressStrategy());
        goto L34
    }

    public static String g(long r9) {
        if ((r9 % 100) != 0) goto L7;
        return String.valueOf(r9 / 100);
    L7:
        if ((r9 % 10) != 0) goto L11;
        return String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(r9 / 100.0d)});
    L11:
        return String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(r9 / 100.0d)});
    }

    public static void h(int r1) {
        int r0 = ECSdk.a;
        IAdapterService r2 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r2 == null) goto L6;
        r2.notifyPushStream(r1);
        return;
    }

    public static boolean a(ECPromotionCampaign r6, long r7) {
        if (r6 != null) goto L4;
    L20:
        return false;
    L4:
        if (TextUtils.isEmpty(r6.promotionId) == true) goto L20;
        if (r6.price > 0) goto L10;
        if (r6.auctionInfo == null) goto L20;
    L10:
        if (r7 <= 0) goto L20;
        long r0 = r6.startTime;
        if (r0 <= 0) goto L20;
        long r4 = r6.endTime;
        if (r4 <= 0) goto L20;
        if (r4 <= r0) goto L20;
        if (r4 <= r7) goto L20;
        return true;
    }

    public static ECUIPromotion e(ECPromotion r3, Boolean r4) {
        return d(r3, com.bytedance.android.livesdk.livecommerce.room.f.a(), 0, r4);
    }

    public static void i(Context r4, String r5) {
        if (ECDisplayUtils.c(r4) == true) goto L5;
    L15:
        com.bytedance.android.livesdk.livecommerce.room.f.b(r4, r5);
        return;
    L5:
        if (r5.contains("as_panel") == false) goto L15;
        Uri r1 = UriProtector.parse(r5);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r1, "as_panel")) == false) goto L10;
        Uri.Builder r2 = r1.buildUpon();     // Catch: Exception -> L12
        r2.appendQueryParameter("as_panel", BDLocationException.ERROR_TIMEOUT);     // Catch: Exception -> L12
        r5 = r2.build().toString();     // Catch: Exception -> L12
    L17:
    L14:
        com.bytedance.android.livesdk.livecommerce.room.f.b(r4, r5);
        return;
    L10:
        r5 = com.bytedance.android.livesdk.livecommerce.event.l0.u(r1).toString();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L14
    }

    public static void j(Context r6, String r7) {
        HashMap r0 = new HashMap(com.bytedance.android.livesdk.livecommerce.event.l0.g());
        if (ECDisplayUtils.c(r6) == true) goto L5;
        String r1 = BDLocationException.ERROR_TIMEOUT;
    L6:
        r0.put("screen_type", r1);
        r0.put("coupon_type", "");
        Uri r2 = UriProtector.parse(r7);     // Catch: Exception -> L22
        String r3 = UriProtector.getQueryParameter(r2, "v3_events_additions");     // Catch: Exception -> L22
        if (r3 != null) goto L10;
    L11:
        r3 = "{}";
    L12:
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L22
        Iterator r5 = r0.entrySet().iterator();     // Catch: Exception -> L22
    L14:
        if (r5.hasNext() == false) goto L20;
        Map.Entry r8 = (Map.Entry) r5.next();     // Catch: Exception -> L22
        if (r8.getKey() == null) goto L14;
        if (r8.getValue() == null) goto L14;
        r4.put((String) r8.getKey(), r8.getValue());     // Catch: Exception -> L22
        goto L14
    L20:
        r7 = com.bytedance.android.livesdk.livecommerce.event.l0.t(r2, "v3_events_additions", r4.toString()).toString();     // Catch: Exception -> L22
    L24:
        com.bytedance.android.livesdk.livecommerce.room.f.b(r6, r7);
        return;
    L10:
        if (r3.isEmpty() == false) goto L12;
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L24
    L5:
        r1 = "1";
        goto L6
    }

    public static void k(List r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isEmpty() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L21;
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L22;
        ECPromotion r0 = (ECPromotion) r3.next();
        if (r0 == null) goto L10;
        r0.logid = r2;
        goto L10
    L22:
        return;
    }

    public static void l(List<ECPromotion> r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L21;
        Iterator<ECPromotion> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L22;
        ECPromotion r0 = r5.next();
        if (r0 == null) goto L10;
        r0.detailUrl += "&" + r4;
        goto L10
    L22:
        return;
    }

    public static ECLoadingDialog m(Context r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        ECLoadingDialog r0 = new ECLoadingDialog(r1);
        r0.setDialogCancelable(false);
        r0.setCancelable(false);
        r0.setCanceledOnTouchOutside(false);
        r0.setShowCloseBtn(false);
        r0.setMessage(r2);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r0);
    L10:
        return r0;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L10
    }

    public static void n(Context r2, String r3) {
        ECToast.INSTANCE.showToast(r2, r3, Boolean.TRUE);
    }

    public static ECUISkuInfo f(ql.a r2, String r3, int r4) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ECUISkuInfo r0 = new ECUISkuInfo();
        r0.f = r2.getPromotionId();
        r0.i = r4;
        r2.getPrice();
        r0.j = r3;
        r0.o = r2.getEventItemType();
        r0.q = r2.getEventParams();
        r0.h = r2.getProductId();
        r0.g = r2.getShopId();
        r0.r = r2.getApplyCoupon();
        r0.t = r2.getShowNotice();
        r0.u = r2.getActivity();
        r0.a = r2.getOriginId();
        r0.b = r2.getOriginType();
        r2.getCanAddShopCart();
        r0.c = r2.getSingleSku();
        r2.isOnSale();
        String r5 = r2.getTrackExtra();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.d = r5;
        r0.v = r2.getAskExplainInfo();
        r0.e = r2.getCampaign();
        r0.w = r2.isMultiGroupBuy();
        return r0;
    }

    public static ECUIPromotion d(ECPromotion r43, Context r44, long r45, Boolean r47) {
        if (r43 != null) goto L5;
        return null;
    L5:
        ECUIPromotion r5 = new ECUIPromotion();
        r5.setCanAddShopCart(r43.canAddShopCart);
        r5.setSingleSku(r43.singleSku);
        r5.hideCart = r43.hideCart;
        String r0 = r43.promotionId;
        String r6 = "";
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        r5.setPromotionId(r0);
        r5.setCover(r43.cover);
        r5.setDetailCover(r43.detailCover);
        r5.title = r43.title;
        r5.setEventItemType(String.valueOf(r43.itemType));
        boolean r1 = r43.inStock;
        r5.inStock = r1;
        boolean r7 = r43.canSold;
        r5.canSold = r7;
        r5.setStatus(ECUIPromotion.getECUIPromotionStatus(r43.status, r1, r7));
        r5.soldHint = r43.soldHint;
        r5.setEventLabel("normal");
        r5.titleLabel = r43.platformLabel;
        r5.platformAtmosphere = r43.platformAtmosphere;
        r5.canExplain = r43.canExplain;
        r5.fragmentId = r43.fragmentId;
        if (r44 == null) goto L12;
        Resources r2 = th.a.f(r44);
        r5.labelColor = r2.getColor(2131101665);
        r5.openDetailButtonText = r2.getString(2131896671, new Object[]{""});
    L12:
        r5.setScheme(r43.detailUrl);
        ECPromotion.Extra r3 = r43.extra;
        if (r3 == null) goto L16;
        r5.setOriginId(r3.originId);
        r5.setOriginType(r43.extra.originType);
        r5.setShowNotice(r43.extra.showNotice);
        r5.setCouponMinPrice(r43.extra.couponMinPrice);
    L16:
        if (r43.extra != null) goto L156;
    L59:
        int r4 = n0.a;
        String r8 = r5.getTrackExtra();
        int r9 = com.bytedance.android.livesdk.livecommerce.room.controller.w.h;
        r5.setTrackExtra(n0.a(r8, "ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b()));
        ECPromotion.AuthorStat r10 = r43.authorStat;
        if (r10 == null) goto L62;
        r5.gmv = r10.gmv;
        r5.orderNum = r10.orderNum;
        r5.userNum = r10.userNum;
    L62:
        r5.setBenefitLabels(r43.benefitLabels);
        r5.buttonLabel = r43.buttonLabel;
        r5.flashIcon = r43.flashIcon;
        r5.labelIcon = r43.labelIcon;
        r5.flickerIconV2 = r43.flickerIconV2;
        r5.stockNum = r43.stockNum;
        r5.soldNum = r43.soldNum;
        r5.setIronIndex(r43.index);
        r5.setRealIndex(r43.realIndex);
        r5.opType = r43.opType;
        boolean r11 = r43.campaign;
        r5.isCampaign = r11;
        if (r11 == true) goto L65;
    L67:
        r5.setEventParams(r43.eventParams);
        r5.setStandardEventTrack(r43.standardEventTrack);
        r5.processEventParams();
        r5.shortTitle = r43.shortTitle;
        r5.setFlashType(r43.flashType);
        ECPromotion.ECActivityResponse r12 = r43.activity;
        if (r12 != null) goto L70;
        ECUIActivity r13 = null;
    L71:
        r5.setActivity(r13);
        ECPromotionAskExplainInfo r14 = r43.askExplainInfo;
        if (r14 != null) goto L74;
        ECUIAskExplainInfo r15 = null;
    L75:
        r5.setAskExplainInfo(r15);
        r5.statusImgUrl = r43.statusImgUrl;
        if (r43.lottery == false) goto L82;
        ECPromotionLotteryInfo r16 = r43.lotteryInfo;
        if (r16 != null) goto L80;
        ECUILotteryInfo r17 = null;
    L81:
        r5.setLotteryInfo(r17);
        goto L82
    L80:
        long r18 = SystemClock.elapsedRealtime();
        r17 = new ECUILotteryInfo(r16.getActivityId(), r16.getLotteryType(), r16.getTaskType(), ((r16.getOpenTime() * 1000) + r18) - (r16.getServerTime() * 1000), r16.getUserActivityStatus(), r16.getWinRecordId(), r16.getResultLabel(), r16.getButtonLabel(), r16.getText(), r16.getJumpUrl(), r16.getShortPic(), (r18 + (r16.getBuyTime() * 1000)) - (r16.getServerTime() * 1000), r16.getElasticTitle(), r16.getBenefitLabel());
    L82:
        r5.platform = r43.platform;
        r5.setProductId(r43.productId);
        r5.setChannelId(r43.channelId);
        r5.setChannelType(Integer.valueOf(r43.channelType));
        String r19 = r43.shopId;
        if (r19 == null) goto L85;
        r5.setShopId(r19);
    L85:
        r5.shopSource = r43.shopSource;
        r5.setApplyCoupon(r43.applyCoupon);
        r5.statusImgMap = r43.statusImgMap;
        ECPromotion.SmallPopCard r20 = r43.smallPopCard;
        ECCurrentPromotion.PopBackground r21 = r43.background;
        if (r20 != null) goto L88;
        ECUISmallPopCard r110 = null;
    L92:
        r5.smallPopCard = r110;
        int r22 = b0.a;
        Intrinsics.checkNotNullParameter(r43, "promotion");
        String r23 = g(r43.minPrice);
        if (r23 != null) goto L95;
        r23 = "";
    L95:
        r5.price = r23;
        r5.minPriceStr = r43.minPriceStr;
        Intrinsics.checkNotNullParameter(r43, "promotion");
        String r24 = g(r43.maxPrice);
        if (r24 != null) goto L98;
        r24 = "";
    L98:
        r5.maxPrice = r24;
        Intrinsics.checkNotNullParameter(r43, "promotion");
        String r25 = g(r43.marketPrice);
        if (r25 != null) goto L101;
        r25 = "";
    L101:
        r5.marketPrice = r25;
        r5.priceDescription = r43.priceDescription;
        if (r5.isScarceLottery() == false) goto L104;
        r5.marketPrice = null;
    L104:
        Intrinsics.checkNotNullParameter(r43, "promotion");
        String r26 = r43.priceHeader;
        if (r26 == null) goto L108;
        r6 = r26;
    L108:
        r5.priceHeader = r6;
        ECPromotion.Extra r27 = r43.extra;
        if (r27 == null) goto L111;
        r5.setHasDiscountPrice(r27.hasDiscountPrice);
    L111:
        r5.hasCommentaryVideo = r43.hasCommentaryVideo;
        r5.commentaryVideoData = r43.commentaryVideoData;
        r5.productKind = r43.productKind;
        r5.setExplainType(r43.explainType);
        r5.setIsInsurance(r43.eventParams);
        r5.setRitTag(r43.ritTags);
        r5.isAuctionFast = r43.isAuction;
        r5.qIvIcon = r43.upIcon;
        r5.upDesc = r43.upDesc;
        r5.topIcon = r43.topIcon;
        r5.setUpIconTagTrack(r43.upIconTagTrack);
        r5.setBackground(r43.background);
        Map r28 = r43.bottomIcon;
        if (r28 == null) goto L114;
        r5.transparentBottonIcon = (String) r28.get("transparent");
        r5.normalBottonIcon = (String) r43.bottomIcon.get("normal");
        r5.backgroundButtonIcon = (String) r43.bottomIcon.get(TraceCons.METRIC_BACKGROUND);
    L115:
        r5.productType = Long.valueOf(r43.productType);
        if (r43.reservationInfo == null) goto L118;
        r5.productType = 21L;
        r5.reservationInfo = r43.reservationInfo;
        r5.reserveMinPrice = r43.minPrice;
    L118:
        String r29 = r43.findGoodsInfo;
        if (r29 != null) goto L121;
    L123:
        r5.findGoodsInfo = r43.findGoodsInfo;
        r5.buttomIconWide = r43.buttomIconWide;
        if (a(r43.rawCampaign, r43.serverTime) == false) goto L126;
        r5.campaign = ECUICampaign.convertCampaign(r43.rawCampaign, r43.serverTime);
    L126:
        r5.liveRoomType = r43.liveRoomType;
        r5.roomType = r43.roomType;
        long r30 = r43.showDuration;
        if (r30 <= 0) goto L129;
        r5.showDuration = r30 / 1000;
    L133:
        r5.publicArea = r43.publicArea;
    L144:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L146:
        r5.orderUrl = r43.orderUrl;
        r5.setJumpDestination(r43.jumpDestination);
        r5.setHotAtmosphere(r43.hotAtmosphere);
        r5.setAtmosphere(r43.atmosphere);
        r5.logicalClock = r43.logicalClock;
        r5.directlyJumpUrl = r43.directlyJumpUrl;
        r5.popHeader = r43.pop3DHeader;
        r5.bottomBanner = r43.bottomBanner;
        r5.setCombination(r43.combination);
        r5.setHasPriceModule(r43.hasPriceModule);
        r5.setForcePriceModule(r43.forcePriceModule);
        r5.setPromotionBottom(r43.promotionBottom);
        r5.floatWindowInfo = r43.floatWindowInfo;
        r5.carouselTime = r43.carouselTime;
        r5.setLogid(r43.logid);
        r5.setLeafCategory(r43.leafCategory);
        r5.setCategoryData(r43.categoryData);
        r5.salePointData = r43.salePointData;
        r5.recommendPointData = r43.recommendPointData;
        r5.givenProduct = r43.givenProduct;
        r5.promotionHeader = r43.promotionHeader;
        r5.stepperInfo = r43.stepperInfo;
        r5.setDynamicRecommendIndex(r43.dynamicRecommendIndex);
        r5.skinData = r43.skinData;
        r5.overlayType = r43.overlayType;
        r5.addCartParams = r43.addCartParams;
        r5.showPriority = r43.showPriority;
        r5.replaceRelatedInfo = r43.replaceRelatedInfo;
        r5.setBizIdentity(r43.bizIdentity);
        r5.setCheckCallback(r43.checkCallback);
        r5.auctionV2 = r43.auctionV2;
        r5.auctionAtmosphere = r43.auctionAtmosphere;
        r5.extendInfo = r43.extendInfo;
        r5.setPrefetchOrder(r43.prefetchOrder);
        long r31 = r5.logicalClock;
        if (r31 <= 0) goto L149;
        int r32 = wl.a.b;
        long r111 = System.currentTimeMillis() - r31;
    L150:
        wl.a.a = r111;
        ECUICampaign r33 = r5.campaign;
        if (r33 == null) goto L153;
        r5.setAuctionInfo(r33.auctionInfo);
        r5.setMultiGroupBuy(r5.campaign.isMultiGroupBuy().booleanValue());
    L153:
        return r5;
    L149:
        r111 = 0;
        goto L150
    L135:
        if (r47.booleanValue() == false) goto L138;
        JSONObject r34 = new JSONObject();     // Catch: Exception -> L144
        int r35 = RoomContextController.h;     // Catch: Exception -> L144
        RoomContextController r36 = RoomContextController.a.a();     // Catch: Exception -> L144
        r34.put("ecom_scene_id", com.bytedance.android.livesdk.livecommerce.room.controller.w.a.b());     // Catch: Exception -> L144
        r34.put("anchor_id", r36.y());     // Catch: Exception -> L144
        r34.put("room_id", r36.B());     // Catch: Exception -> L144
        r5.setExtraTransmissibleLogParams(r34);     // Catch: Exception -> L144
    L140:
        JSONObject r37 = r5.getExtraTransmissibleLogParams();     // Catch: Exception -> L144
        if (r37 == null) goto L146;
        r37.put("show_dou_campaign", 0);     // Catch: Exception -> L144
        r37.put("is_retry", r43.isRetry);     // Catch: Exception -> L144
        goto L146
    L138:
        if (r5.getExtraTransmissibleLogParams() != null) goto L140;
        r5.setExtraTransmissibleLogParams(new JSONObject());     // Catch: Exception -> L144
        goto L140
    L129:
        if (r30 != 0) goto L131;
        r5.showDuration = 10;
        goto L133
    L131:
        if (r30 >= 0) goto L133;
        r5.showDuration = -1;
        goto L133
    L121:
        if (r29.isEmpty() == true) goto L123;
        r5.productType = 19L;
        goto L123
    L114:
        r5.normalBottonIcon = null;
        r5.transparentBottonIcon = null;
        goto L115
    L88:
        r110 = new ECUISmallPopCard();
        r110.backgroundImg = r20.backgroundImg;
        String r112 = r20.backgroundImgNew;
        if (r21 == null) goto L91;
        r112 = r21.image;
    L91:
        r110.backgroundImgNew = r112;
        r110.headerImg = r20.headerImg;
        r110.buttonLabel = r20.buttonLabel;
        r110.headerLabel = r20.headerLabel;
        goto L92
    L74:
        r15 = new ECUIAskExplainInfo(r14.getStatus(), r14.getUserCount(), r14.getRank(), r14.getRankIconUrl(), r14.getCanAskExplain());
        goto L75
    L70:
        r13 = new ECUIActivity(r12.activityIcon, r12.activityType, r12.activityId, r12.activityBanner, r12.activityBannerLandscape, r12.activityBannerSmall);
        goto L71
    L65:
        if (a(r43.campaignInfo, r45) == false) goto L67;
        r5.setCampaign(ECUICampaign.convertCampaign(r43.campaignInfo, r45, 0));
        goto L67
    L156:
        JSONObject r113 = new JSONObject(com.bytedance.android.livesdk.livecommerce.event.l0.c());     // Catch: Exception -> L49
        Lazy r114 = ExtraController.l;     // Catch: Exception -> L49
        ExtraController r115 = ControllerCenter.c(null, null).u;     // Catch: Exception -> L49
        Objects.toString(r115);     // Catch: Exception -> L49
        JSONObject r116 = r115.H();     // Catch: Exception -> L49
        if (r116 != null) goto L21;
    L35:
        fh2.a r38 = PromotionListController.H();     // Catch: Exception -> L49
        if (r38 == null) goto L43;
        String r39 = ((LivePromotionListFragment) r38).ea0();     // Catch: Exception -> L49
        if (r39 == null) goto L43;
        JSONObject r40 = new JSONObject(r39);     // Catch: Exception -> L41
    L44:
        if (r40 != null) goto L46;
    L51:
        Map r41 = r43.eventParams;
        if (r41 != null) goto L154;
    L58:
        int r42 = n0.a;
        r5.setTrackExtra(n0.a(r43.extra.trackExtra, "cart_track", r113.toString()));
        goto L59
    L154:
        r113.put("store_id", r41.get("store_id"));     // Catch: Exception -> L56
        r113.put("live_business_type", r41.get("live_business_type"));     // Catch: Exception -> L56
    L56:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L58
    L46:
        if (r40.has("live_list_channel") == false) goto L51;
        r113.put("live_list_channel", r40.optString("live_list_channel"));     // Catch: Exception -> L49
        goto L51
    L41:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L49
    L43:
        r40 = null;
        goto L44
    L21:
        if (r116.has("product_source_page") == false) goto L24;
        r113.put("product_source_page", r116.optString("product_source_page"));     // Catch: Exception -> L49
    L24:
        if (r116.has("store_type") == false) goto L27;
        r113.put("store_type", r116.optString("store_type"));     // Catch: Exception -> L49
    L27:
        if (r116.has("store_source_page") == false) goto L30;
        r113.put("store_source_page", r116.optString("store_source_page"));     // Catch: Exception -> L49
    L30:
        if (r116.has("store_source_method") == false) goto L33;
        r113.put("store_source_method", r116.optString("store_source_method"));     // Catch: Exception -> L49
    L33:
        if (r116.has("store_group_type") == false) goto L35;
        r113.put("store_group_type", r116.optString("store_group_type"));     // Catch: Exception -> L49
    L49:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r113 = new JSONObject();
        goto L51
    }
}
