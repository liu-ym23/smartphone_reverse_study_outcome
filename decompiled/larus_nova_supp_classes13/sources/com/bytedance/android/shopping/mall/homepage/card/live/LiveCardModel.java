package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$MaskStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001:\u0004/012Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel;", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "live", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;", "experiment", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "showAdTag", "", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "showJustNowUI", "windVane", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "elementStyle", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "ttExperiment", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;)V", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getElementStyle", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "getExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "getLive", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "getShowAdTag", "()Z", "getShowJustNowUI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTtExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "getWindVane", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "ElementStyle", "Experiment", "Live", "TTExperiment", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCardModel {
    private final CommonData.CoinData coinData;
    private final ElementStyle elementStyle;
    private final Experiment experiment;
    private final LiveCardData.FavoriteItemStyle itemStyle;
    private final Live live;
    private final CommonModel$Product product;
    private final boolean showAdTag;
    private final Boolean showJustNowUI;
    private final TTExperiment ttExperiment;
    private final CommonModel$User user;
    private final CommonData.WindVaneEventData windVane;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\bK\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\u0015¢\u0006\u0002\u0010&J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0010HÆ\u0003J\t\u0010R\u001a\u00020\u0012HÆ\u0003J\t\u0010S\u001a\u00020\u0012HÆ\u0003J\t\u0010T\u001a\u00020\u0015HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010V\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00106J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0012HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u00101J\t\u0010a\u001a\u00020\u0015HÆ\u0003J\t\u0010b\u001a\u00020\u0006HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0006HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J¤\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u0015HÆ\u0001¢\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\u00152\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020$HÖ\u0001J\t\u0010n\u001a\u00020\"HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010(R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010(R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010(R\u0011\u0010\u001e\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bI\u0010=R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010(R\u0011\u0010%\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bK\u00104R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bL\u0010=R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u0010+¨\u0006o"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "", "infoLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "avatarLayout", "userTextStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "logoLayout", "logoTextLayout", "logoTextStyle", "hotLayout", "hotTextStyle", "arriveTimeIconLayout", "arriveTimeTextStyle", "arriveTimeTextLayout", "maskStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "hotIconStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "rootStyle", "darkModeEnable", "", "height", "", "feedCardRatio", "", "redPacketLayout", "coinLayout", "coinStyle", "coinIconLayout", "playerMaskStyle", "playerLayout", "feedbackLayout", "leftTopAnimUrl", "", "colorfulCardStyle", "", "removeShadow", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getArriveTimeIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getArriveTimeTextLayout", "getArriveTimeTextStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getAvatarLayout", "getCoinIconLayout", "getCoinLayout", "getCoinStyle", "getColorfulCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDarkModeEnable", "()Z", "getFeedCardRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeedbackLayout", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHotIconStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "getHotLayout", "getHotTextStyle", "getInfoLayout", "getLeftTopAnimUrl", "()Ljava/lang/String;", "getLogoLayout", "getLogoTextLayout", "getLogoTextStyle", "getMaskStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "getPlayerLayout", "getPlayerMaskStyle", "getRedPacketLayout", "getRemoveShadow", "getRootStyle", "getUserTextStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "equals", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementStyle {
        private final CommonModel$LayoutStyle arriveTimeIconLayout;
        private final CommonModel$LayoutStyle arriveTimeTextLayout;
        private final CommonModel$CusTextStyle arriveTimeTextStyle;
        private final CommonModel$LayoutStyle avatarLayout;
        private final CommonModel$LayoutStyle coinIconLayout;
        private final CommonModel$LayoutStyle coinLayout;
        private final CommonModel$CusTextStyle coinStyle;
        private final Integer colorfulCardStyle;
        private final boolean darkModeEnable;
        private final Float feedCardRatio;
        private final CommonModel$LayoutStyle feedbackLayout;
        private final Double height;
        private final CommonModel$CommonColorStyle hotIconStyle;
        private final CommonModel$LayoutStyle hotLayout;
        private final CommonModel$CusTextStyle hotTextStyle;
        private final CommonModel$LayoutStyle infoLayout;
        private final String leftTopAnimUrl;
        private final CommonModel$LayoutStyle logoLayout;
        private final CommonModel$LayoutStyle logoTextLayout;
        private final CommonModel$CusTextStyle logoTextStyle;
        private final CommonModel$MaskStyle maskStyle;
        private final CommonModel$LayoutStyle playerLayout;
        private final CommonModel$CommonColorStyle playerMaskStyle;
        private final CommonModel$LayoutStyle redPacketLayout;
        private final boolean removeShadow;
        private final CommonModel$CommonColorStyle rootStyle;
        private final CommonModel$CusTextStyle userTextStyle;

        public static /* synthetic */ ElementStyle copy$default(ElementStyle r17, CommonModel$LayoutStyle r18, CommonModel$LayoutStyle r19, CommonModel$CusTextStyle r20, CommonModel$LayoutStyle r21, CommonModel$LayoutStyle r22, CommonModel$CusTextStyle r23, CommonModel$LayoutStyle r24, CommonModel$CusTextStyle r25, CommonModel$LayoutStyle r26, CommonModel$CusTextStyle r27, CommonModel$LayoutStyle r28, CommonModel$MaskStyle r29, CommonModel$CommonColorStyle r30, CommonModel$CommonColorStyle r31, boolean r32, Double r33, Float r34, CommonModel$LayoutStyle r35, CommonModel$LayoutStyle r36, CommonModel$CusTextStyle r37, CommonModel$LayoutStyle r38, CommonModel$CommonColorStyle r39, CommonModel$LayoutStyle r40, CommonModel$LayoutStyle r41, String r42, Integer r43, boolean r44, int r45, Object r46) {
            if ((r45 & 1) == 0) goto L5;
            CommonModel$LayoutStyle r2 = r17.infoLayout;
        L7:
            if ((r45 & 2) == 0) goto L9;
            CommonModel$LayoutStyle r3 = r17.avatarLayout;
        L11:
            if ((r45 & 4) == 0) goto L13;
            CommonModel$CusTextStyle r4 = r17.userTextStyle;
        L15:
            if ((r45 & 8) == 0) goto L17;
            CommonModel$LayoutStyle r5 = r17.logoLayout;
        L19:
            if ((r45 & 16) == 0) goto L21;
            CommonModel$LayoutStyle r6 = r17.logoTextLayout;
        L23:
            if ((r45 & 32) == 0) goto L25;
            CommonModel$CusTextStyle r7 = r17.logoTextStyle;
        L27:
            if ((r45 & 64) == 0) goto L29;
            CommonModel$LayoutStyle r8 = r17.hotLayout;
        L31:
            if ((r45 & 128) == 0) goto L33;
            CommonModel$CusTextStyle r9 = r17.hotTextStyle;
        L35:
            if ((r45 & 256) == 0) goto L37;
            CommonModel$LayoutStyle r10 = r17.arriveTimeIconLayout;
        L39:
            if ((r45 & 512) == 0) goto L41;
            CommonModel$CusTextStyle r11 = r17.arriveTimeTextStyle;
        L43:
            if ((r45 & 1024) == 0) goto L45;
            CommonModel$LayoutStyle r12 = r17.arriveTimeTextLayout;
        L47:
            if ((r45 & 2048) == 0) goto L49;
            CommonModel$MaskStyle r13 = r17.maskStyle;
        L51:
            if ((r45 & 4096) == 0) goto L53;
            CommonModel$CommonColorStyle r14 = r17.hotIconStyle;
        L55:
            if ((r45 & 8192) == 0) goto L57;
            CommonModel$CommonColorStyle r15 = r17.rootStyle;
        L58:
            CommonModel$CommonColorStyle r310 = r15;
            if ((r45 & 16384) == 0) goto L61;
            boolean r16 = r17.darkModeEnable;
        L62:
            boolean r311 = r16;
            if ((r45 & 32768) == 0) goto L65;
            Double r110 = r17.height;
        L66:
            Double r312 = r110;
            if ((r45 & 65536) == 0) goto L69;
            Float r111 = r17.feedCardRatio;
        L70:
            Float r313 = r111;
            if ((r45 & 131072) == 0) goto L73;
            CommonModel$LayoutStyle r112 = r17.redPacketLayout;
        L74:
            CommonModel$LayoutStyle r314 = r112;
            if ((r45 & 262144) == 0) goto L77;
            CommonModel$LayoutStyle r113 = r17.coinLayout;
        L78:
            CommonModel$LayoutStyle r315 = r113;
            if ((r45 & 524288) == 0) goto L81;
            CommonModel$CusTextStyle r114 = r17.coinStyle;
        L82:
            CommonModel$CusTextStyle r316 = r114;
            if ((r45 & 1048576) == 0) goto L85;
            CommonModel$LayoutStyle r115 = r17.coinIconLayout;
        L86:
            CommonModel$LayoutStyle r317 = r115;
            if ((r45 & 2097152) == 0) goto L89;
            CommonModel$CommonColorStyle r116 = r17.playerMaskStyle;
        L90:
            CommonModel$CommonColorStyle r318 = r116;
            if ((r45 & 4194304) == 0) goto L93;
            CommonModel$LayoutStyle r117 = r17.playerLayout;
        L94:
            CommonModel$LayoutStyle r47 = r117;
            if ((r45 & 8388608) == 0) goto L97;
            CommonModel$LayoutStyle r118 = r17.feedbackLayout;
        L98:
            CommonModel$LayoutStyle r48 = r118;
            if ((r45 & 16777216) == 0) goto L101;
            String r119 = r17.leftTopAnimUrl;
        L102:
            String r49 = r119;
            if ((r45 & 33554432) == 0) goto L105;
            Integer r120 = r17.colorfulCardStyle;
        L107:
            if ((r45 & 67108864) == 0) goto L109;
            boolean r1 = r17.removeShadow;
        L111:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r47, r48, r49, r120, r1);
        L109:
            r1 = r44;
            goto L111
        L105:
            r120 = r43;
            goto L107
        L101:
            r119 = r42;
            goto L102
        L97:
            r118 = r41;
            goto L98
        L93:
            r117 = r40;
            goto L94
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final CommonModel$LayoutStyle component1() {
            return this.infoLayout;
        }

        public final CommonModel$CusTextStyle component10() {
            return this.arriveTimeTextStyle;
        }

        public final CommonModel$LayoutStyle component11() {
            return this.arriveTimeTextLayout;
        }

        public final CommonModel$MaskStyle component12() {
            return this.maskStyle;
        }

        public final CommonModel$CommonColorStyle component13() {
            return this.hotIconStyle;
        }

        public final CommonModel$CommonColorStyle component14() {
            return this.rootStyle;
        }

        public final boolean component15() {
            return this.darkModeEnable;
        }

        public final Double component16() {
            return this.height;
        }

        public final Float component17() {
            return this.feedCardRatio;
        }

        public final CommonModel$LayoutStyle component18() {
            return this.redPacketLayout;
        }

        public final CommonModel$LayoutStyle component19() {
            return this.coinLayout;
        }

        public final CommonModel$LayoutStyle component2() {
            return this.avatarLayout;
        }

        public final CommonModel$CusTextStyle component20() {
            return this.coinStyle;
        }

        public final CommonModel$LayoutStyle component21() {
            return this.coinIconLayout;
        }

        public final CommonModel$CommonColorStyle component22() {
            return this.playerMaskStyle;
        }

        public final CommonModel$LayoutStyle component23() {
            return this.playerLayout;
        }

        public final CommonModel$LayoutStyle component24() {
            return this.feedbackLayout;
        }

        public final String component25() {
            return this.leftTopAnimUrl;
        }

        public final Integer component26() {
            return this.colorfulCardStyle;
        }

        public final boolean component27() {
            return this.removeShadow;
        }

        public final CommonModel$CusTextStyle component3() {
            return this.userTextStyle;
        }

        public final CommonModel$LayoutStyle component4() {
            return this.logoLayout;
        }

        public final CommonModel$LayoutStyle component5() {
            return this.logoTextLayout;
        }

        public final CommonModel$CusTextStyle component6() {
            return this.logoTextStyle;
        }

        public final CommonModel$LayoutStyle component7() {
            return this.hotLayout;
        }

        public final CommonModel$CusTextStyle component8() {
            return this.hotTextStyle;
        }

        public final CommonModel$LayoutStyle component9() {
            return this.arriveTimeIconLayout;
        }

        public final ElementStyle copy(CommonModel$LayoutStyle r31, CommonModel$LayoutStyle r32, CommonModel$CusTextStyle r33, CommonModel$LayoutStyle r34, CommonModel$LayoutStyle r35, CommonModel$CusTextStyle r36, CommonModel$LayoutStyle r37, CommonModel$CusTextStyle r38, CommonModel$LayoutStyle r39, CommonModel$CusTextStyle r40, CommonModel$LayoutStyle r41, CommonModel$MaskStyle r42, CommonModel$CommonColorStyle r43, CommonModel$CommonColorStyle r44, boolean r45, Double r46, Float r47, CommonModel$LayoutStyle r48, CommonModel$LayoutStyle r49, CommonModel$CusTextStyle r50, CommonModel$LayoutStyle r51, CommonModel$CommonColorStyle r52, CommonModel$LayoutStyle r53, CommonModel$LayoutStyle r54, String r55, Integer r56, boolean r57) {
            Intrinsics.checkNotNullParameter(r31, "infoLayout");
            Intrinsics.checkNotNullParameter(r32, "avatarLayout");
            Intrinsics.checkNotNullParameter(r33, "userTextStyle");
            Intrinsics.checkNotNullParameter(r34, "logoLayout");
            Intrinsics.checkNotNullParameter(r35, "logoTextLayout");
            Intrinsics.checkNotNullParameter(r36, "logoTextStyle");
            Intrinsics.checkNotNullParameter(r37, "hotLayout");
            Intrinsics.checkNotNullParameter(r38, "hotTextStyle");
            Intrinsics.checkNotNullParameter(r39, "arriveTimeIconLayout");
            Intrinsics.checkNotNullParameter(r40, "arriveTimeTextStyle");
            Intrinsics.checkNotNullParameter(r41, "arriveTimeTextLayout");
            Intrinsics.checkNotNullParameter(r42, "maskStyle");
            Intrinsics.checkNotNullParameter(r43, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r44, "rootStyle");
            Intrinsics.checkNotNullParameter(r48, "redPacketLayout");
            Intrinsics.checkNotNullParameter(r49, "coinLayout");
            Intrinsics.checkNotNullParameter(r50, "coinStyle");
            Intrinsics.checkNotNullParameter(r51, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r52, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r53, "playerLayout");
            Intrinsics.checkNotNullParameter(r54, "feedbackLayout");
            return new ElementStyle(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ElementStyle) == false) goto L60;
            ElementStyle r4 = (ElementStyle) r3;
            if (Intrinsics.areEqual(this.infoLayout, r4.infoLayout) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avatarLayout, r4.avatarLayout) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.userTextStyle, r4.userTextStyle) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.logoLayout, r4.logoLayout) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.logoTextLayout, r4.logoTextLayout) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.logoTextStyle, r4.logoTextStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.hotLayout, r4.hotLayout) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.hotTextStyle, r4.hotTextStyle) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.arriveTimeIconLayout, r4.arriveTimeIconLayout) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.arriveTimeTextStyle, r4.arriveTimeTextStyle) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.arriveTimeTextLayout, r4.arriveTimeTextLayout) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.maskStyle, r4.maskStyle) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.hotIconStyle, r4.hotIconStyle) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.rootStyle, r4.rootStyle) == true) goto L34;
            return false;
        L34:
            if (this.darkModeEnable == r4.darkModeEnable) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.height, r4.height) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.feedCardRatio, r4.feedCardRatio) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.redPacketLayout, r4.redPacketLayout) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.coinLayout, r4.coinLayout) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.coinStyle, r4.coinStyle) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.coinIconLayout, r4.coinIconLayout) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.playerMaskStyle, r4.playerMaskStyle) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.playerLayout, r4.playerLayout) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.feedbackLayout, r4.feedbackLayout) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.leftTopAnimUrl, r4.leftTopAnimUrl) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.colorfulCardStyle, r4.colorfulCardStyle) == true) goto L58;
            return false;
        L58:
            if (this.removeShadow == r4.removeShadow) goto L91;
            return false;
        L91:
            return true;
        L60:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v30, types: [int] */
        /* JADX WARN: Type inference failed for: r0v54, types: [int] */
        /* JADX WARN: Type inference failed for: r2v40, types: [int] */
        /* JADX WARN: Type inference failed for: r2v82 */
        /* JADX WARN: Type inference failed for: r2v96 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            CommonModel$LayoutStyle r0 = this.infoLayout;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            CommonModel$LayoutStyle r4 = this.avatarLayout;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            CommonModel$CusTextStyle r7 = this.userTextStyle;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            CommonModel$LayoutStyle r10 = this.logoLayout;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            CommonModel$LayoutStyle r13 = this.logoTextLayout;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            CommonModel$CusTextStyle r16 = this.logoTextStyle;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            CommonModel$LayoutStyle r19 = this.hotLayout;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            CommonModel$CusTextStyle r22 = this.hotTextStyle;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            CommonModel$LayoutStyle r25 = this.arriveTimeIconLayout;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            CommonModel$CusTextStyle r28 = this.arriveTimeTextStyle;
            if (r28 == null) goto L41;
            int r29 = r28.hashCode();
        L42:
            int r30 = (r27 + r29) * 31;
            CommonModel$LayoutStyle r31 = this.arriveTimeTextLayout;
            if (r31 == null) goto L45;
            int r32 = r31.hashCode();
        L46:
            int r33 = (r30 + r32) * 31;
            CommonModel$MaskStyle r34 = this.maskStyle;
            if (r34 == null) goto L49;
            int r35 = r34.hashCode();
        L50:
            int r36 = (r33 + r35) * 31;
            CommonModel$CommonColorStyle r37 = this.hotIconStyle;
            if (r37 == null) goto L53;
            int r38 = r37.hashCode();
        L54:
            int r39 = (r36 + r38) * 31;
            CommonModel$CommonColorStyle r40 = this.rootStyle;
            if (r40 == null) goto L57;
            int r41 = r40.hashCode();
        L58:
            int r42 = (r39 + r41) * 31;
            boolean r43 = this.darkModeEnable;
            ?? r44 = 1;
            ?? r45 = r43;
            if (r43 == false) goto L61;
            r45 = 1;
        L61:
            int r46 = (r42 + r45) * 31;
            Double r47 = this.height;
            if (r47 == null) goto L64;
            int r48 = r47.hashCode();
        L65:
            int r49 = (r46 + r48) * 31;
            Float r50 = this.feedCardRatio;
            if (r50 == null) goto L68;
            int r51 = r50.hashCode();
        L69:
            int r52 = (r49 + r51) * 31;
            CommonModel$LayoutStyle r53 = this.redPacketLayout;
            if (r53 == null) goto L72;
            int r54 = r53.hashCode();
        L73:
            int r55 = (r52 + r54) * 31;
            CommonModel$LayoutStyle r56 = this.coinLayout;
            if (r56 == null) goto L76;
            int r57 = r56.hashCode();
        L77:
            int r58 = (r55 + r57) * 31;
            CommonModel$CusTextStyle r59 = this.coinStyle;
            if (r59 == null) goto L80;
            int r60 = r59.hashCode();
        L81:
            int r61 = (r58 + r60) * 31;
            CommonModel$LayoutStyle r62 = this.coinIconLayout;
            if (r62 == null) goto L84;
            int r63 = r62.hashCode();
        L85:
            int r64 = (r61 + r63) * 31;
            CommonModel$CommonColorStyle r65 = this.playerMaskStyle;
            if (r65 == null) goto L88;
            int r66 = r65.hashCode();
        L89:
            int r67 = (r64 + r66) * 31;
            CommonModel$LayoutStyle r68 = this.playerLayout;
            if (r68 == null) goto L92;
            int r69 = r68.hashCode();
        L93:
            int r70 = (r67 + r69) * 31;
            CommonModel$LayoutStyle r71 = this.feedbackLayout;
            if (r71 == null) goto L96;
            int r72 = r71.hashCode();
        L97:
            int r73 = (r70 + r72) * 31;
            String r74 = this.leftTopAnimUrl;
            if (r74 == null) goto L100;
            int r75 = r74.hashCode();
        L101:
            int r76 = (r73 + r75) * 31;
            Integer r77 = this.colorfulCardStyle;
            if (r77 == null) goto L104;
            r1 = r77.hashCode();
        L104:
            int r78 = (r76 + r1) * 31;
            boolean r79 = this.removeShadow;
            if (r79 == true) goto L109;
            r44 = r79;
        L109:
            return r78 + r44;
        L100:
            r75 = 0;
            goto L101
        L96:
            r72 = 0;
            goto L97
        L92:
            r69 = 0;
            goto L93
        L88:
            r66 = 0;
            goto L89
        L84:
            r63 = 0;
            goto L85
        L80:
            r60 = 0;
            goto L81
        L76:
            r57 = 0;
            goto L77
        L72:
            r54 = 0;
            goto L73
        L68:
            r51 = 0;
            goto L69
        L64:
            r48 = 0;
            goto L65
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ElementStyle(infoLayout=" + this.infoLayout + ", avatarLayout=" + this.avatarLayout + ", userTextStyle=" + this.userTextStyle + ", logoLayout=" + this.logoLayout + ", logoTextLayout=" + this.logoTextLayout + ", logoTextStyle=" + this.logoTextStyle + ", hotLayout=" + this.hotLayout + ", hotTextStyle=" + this.hotTextStyle + ", arriveTimeIconLayout=" + this.arriveTimeIconLayout + ", arriveTimeTextStyle=" + this.arriveTimeTextStyle + ", arriveTimeTextLayout=" + this.arriveTimeTextLayout + ", maskStyle=" + this.maskStyle + ", hotIconStyle=" + this.hotIconStyle + ", rootStyle=" + this.rootStyle + ", darkModeEnable=" + this.darkModeEnable + ", height=" + this.height + ", feedCardRatio=" + this.feedCardRatio + ", redPacketLayout=" + this.redPacketLayout + ", coinLayout=" + this.coinLayout + ", coinStyle=" + this.coinStyle + ", coinIconLayout=" + this.coinIconLayout + ", playerMaskStyle=" + this.playerMaskStyle + ", playerLayout=" + this.playerLayout + ", feedbackLayout=" + this.feedbackLayout + ", leftTopAnimUrl=" + this.leftTopAnimUrl + ", colorfulCardStyle=" + this.colorfulCardStyle + ", removeShadow=" + this.removeShadow + ")";
        }

        public final CommonModel$LayoutStyle getArriveTimeIconLayout() {
            return this.arriveTimeIconLayout;
        }

        public final CommonModel$LayoutStyle getArriveTimeTextLayout() {
            return this.arriveTimeTextLayout;
        }

        public final CommonModel$CusTextStyle getArriveTimeTextStyle() {
            return this.arriveTimeTextStyle;
        }

        public final CommonModel$LayoutStyle getAvatarLayout() {
            return this.avatarLayout;
        }

        public final CommonModel$LayoutStyle getCoinIconLayout() {
            return this.coinIconLayout;
        }

        public final CommonModel$LayoutStyle getCoinLayout() {
            return this.coinLayout;
        }

        public final CommonModel$CusTextStyle getCoinStyle() {
            return this.coinStyle;
        }

        public final Integer getColorfulCardStyle() {
            return this.colorfulCardStyle;
        }

        public final boolean getDarkModeEnable() {
            return this.darkModeEnable;
        }

        public final Float getFeedCardRatio() {
            return this.feedCardRatio;
        }

        public final CommonModel$LayoutStyle getFeedbackLayout() {
            return this.feedbackLayout;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final CommonModel$CommonColorStyle getHotIconStyle() {
            return this.hotIconStyle;
        }

        public final CommonModel$LayoutStyle getHotLayout() {
            return this.hotLayout;
        }

        public final CommonModel$CusTextStyle getHotTextStyle() {
            return this.hotTextStyle;
        }

        public final CommonModel$LayoutStyle getInfoLayout() {
            return this.infoLayout;
        }

        public final String getLeftTopAnimUrl() {
            return this.leftTopAnimUrl;
        }

        public final CommonModel$LayoutStyle getLogoLayout() {
            return this.logoLayout;
        }

        public final CommonModel$LayoutStyle getLogoTextLayout() {
            return this.logoTextLayout;
        }

        public final CommonModel$CusTextStyle getLogoTextStyle() {
            return this.logoTextStyle;
        }

        public final CommonModel$MaskStyle getMaskStyle() {
            return this.maskStyle;
        }

        public final CommonModel$LayoutStyle getPlayerLayout() {
            return this.playerLayout;
        }

        public final CommonModel$CommonColorStyle getPlayerMaskStyle() {
            return this.playerMaskStyle;
        }

        public final CommonModel$LayoutStyle getRedPacketLayout() {
            return this.redPacketLayout;
        }

        public final boolean getRemoveShadow() {
            return this.removeShadow;
        }

        public final CommonModel$CommonColorStyle getRootStyle() {
            return this.rootStyle;
        }

        public final CommonModel$CusTextStyle getUserTextStyle() {
            return this.userTextStyle;
        }

        public ElementStyle(CommonModel$LayoutStyle r17, CommonModel$LayoutStyle r18, CommonModel$CusTextStyle r19, CommonModel$LayoutStyle r20, CommonModel$LayoutStyle r21, CommonModel$CusTextStyle r22, CommonModel$LayoutStyle r23, CommonModel$CusTextStyle r24, CommonModel$LayoutStyle r25, CommonModel$CusTextStyle r26, CommonModel$LayoutStyle r27, CommonModel$MaskStyle r28, CommonModel$CommonColorStyle r29, CommonModel$CommonColorStyle r30, boolean r31, Double r32, Float r33, CommonModel$LayoutStyle r34, CommonModel$LayoutStyle r35, CommonModel$CusTextStyle r36, CommonModel$LayoutStyle r37, CommonModel$CommonColorStyle r38, CommonModel$LayoutStyle r39, CommonModel$LayoutStyle r40, String r41, Integer r42, boolean r43) {
            Intrinsics.checkNotNullParameter(r17, "infoLayout");
            Intrinsics.checkNotNullParameter(r18, "avatarLayout");
            Intrinsics.checkNotNullParameter(r19, "userTextStyle");
            Intrinsics.checkNotNullParameter(r20, "logoLayout");
            Intrinsics.checkNotNullParameter(r21, "logoTextLayout");
            Intrinsics.checkNotNullParameter(r22, "logoTextStyle");
            Intrinsics.checkNotNullParameter(r23, "hotLayout");
            Intrinsics.checkNotNullParameter(r24, "hotTextStyle");
            Intrinsics.checkNotNullParameter(r25, "arriveTimeIconLayout");
            Intrinsics.checkNotNullParameter(r26, "arriveTimeTextStyle");
            Intrinsics.checkNotNullParameter(r27, "arriveTimeTextLayout");
            Intrinsics.checkNotNullParameter(r28, "maskStyle");
            Intrinsics.checkNotNullParameter(r29, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r30, "rootStyle");
            Intrinsics.checkNotNullParameter(r34, "redPacketLayout");
            Intrinsics.checkNotNullParameter(r35, "coinLayout");
            Intrinsics.checkNotNullParameter(r36, "coinStyle");
            Intrinsics.checkNotNullParameter(r37, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r38, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r39, "playerLayout");
            Intrinsics.checkNotNullParameter(r40, "feedbackLayout");
            this.infoLayout = r17;
            this.avatarLayout = r18;
            this.userTextStyle = r19;
            this.logoLayout = r20;
            this.logoTextLayout = r21;
            this.logoTextStyle = r22;
            this.hotLayout = r23;
            this.hotTextStyle = r24;
            this.arriveTimeIconLayout = r25;
            this.arriveTimeTextStyle = r26;
            this.arriveTimeTextLayout = r27;
            this.maskStyle = r28;
            this.hotIconStyle = r29;
            this.rootStyle = r30;
            this.darkModeEnable = r31;
            this.height = r32;
            this.feedCardRatio = r33;
            this.redPacketLayout = r34;
            this.coinLayout = r35;
            this.coinStyle = r36;
            this.coinIconLayout = r37;
            this.playerMaskStyle = r38;
            this.playerLayout = r39;
            this.feedbackLayout = r40;
            this.leftTopAnimUrl = r41;
            this.colorfulCardStyle = r42;
            this.removeShadow = r43;
        }

        public /* synthetic */ ElementStyle(CommonModel$LayoutStyle r32, CommonModel$LayoutStyle r33, CommonModel$CusTextStyle r34, CommonModel$LayoutStyle r35, CommonModel$LayoutStyle r36, CommonModel$CusTextStyle r37, CommonModel$LayoutStyle r38, CommonModel$CusTextStyle r39, CommonModel$LayoutStyle r40, CommonModel$CusTextStyle r41, CommonModel$LayoutStyle r42, CommonModel$MaskStyle r43, CommonModel$CommonColorStyle r44, CommonModel$CommonColorStyle r45, boolean r46, Double r47, Float r48, CommonModel$LayoutStyle r49, CommonModel$LayoutStyle r50, CommonModel$CusTextStyle r51, CommonModel$LayoutStyle r52, CommonModel$CommonColorStyle r53, CommonModel$LayoutStyle r54, CommonModel$LayoutStyle r55, String r56, Integer r57, boolean r58, int r59, DefaultConstructorMarker r60) {
            if ((r59 & 16384) == 0) goto L5;
            boolean r18 = false;
        L7:
            if ((32768 & r59) == 0) goto L9;
            Double r19 = null;
        L11:
            if ((65536 & r59) == 0) goto L13;
            Float r20 = null;
        L15:
            if ((16777216 & r59) == 0) goto L17;
            String r28 = null;
        L19:
            if ((33554432 & r59) == 0) goto L21;
            Integer r29 = null;
        L23:
            if ((r59 & 67108864) == 0) goto L25;
            boolean r30 = false;
        L26:
            this(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r18, r19, r20, r49, r50, r51, r52, r53, r54, r55, r28, r29, r30);
            return;
        L25:
            r30 = r58;
            goto L26
        L21:
            r29 = r57;
            goto L23
        L17:
            r28 = r56;
            goto L19
        L13:
            r20 = r48;
            goto L15
        L9:
            r19 = r47;
            goto L11
        L5:
            r18 = r46;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003Jt\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\fHÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "", "noProductInfo", "", "isNewProductUI", "showPeopleNewIcon", "newPadding", "highValue", "uiCompact", "liveCardChangeCover", "liveCardEnlargePlayArea", "coinLabelStyle", "", "appendHeight", "", "(ZZZZZZZZILjava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()I", "getHighValue", "()Z", "getLiveCardChangeCover", "getLiveCardEnlargePlayArea", "getNewPadding", "getNoProductInfo", "getShowPeopleNewIcon", "getUiCompact", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZZZZZZZILjava/lang/Double;)Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "equals", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Experiment {
        private final Double appendHeight;
        private final int coinLabelStyle;
        private final boolean highValue;
        private final boolean isNewProductUI;
        private final boolean liveCardChangeCover;
        private final boolean liveCardEnlargePlayArea;
        private final boolean newPadding;
        private final boolean noProductInfo;
        private final boolean showPeopleNewIcon;
        private final boolean uiCompact;

        public static /* synthetic */ Experiment copy$default(Experiment r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, int r20, Double r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            boolean r2 = r11.noProductInfo;
        L7:
            if ((r22 & 2) == 0) goto L9;
            boolean r3 = r11.isNewProductUI;
        L11:
            if ((r22 & 4) == 0) goto L13;
            boolean r4 = r11.showPeopleNewIcon;
        L15:
            if ((r22 & 8) == 0) goto L17;
            boolean r5 = r11.newPadding;
        L19:
            if ((r22 & 16) == 0) goto L21;
            boolean r6 = r11.highValue;
        L23:
            if ((r22 & 32) == 0) goto L25;
            boolean r7 = r11.uiCompact;
        L27:
            if ((r22 & 64) == 0) goto L29;
            boolean r8 = r11.liveCardChangeCover;
        L31:
            if ((r22 & 128) == 0) goto L33;
            boolean r9 = r11.liveCardEnlargePlayArea;
        L35:
            if ((r22 & 256) == 0) goto L37;
            int r10 = r11.coinLabelStyle;
        L39:
            if ((r22 & 512) == 0) goto L41;
            Double r1 = r11.appendHeight;
        L43:
            return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
        L41:
            r1 = r21;
            goto L43
        L37:
            r10 = r20;
            goto L39
        L33:
            r9 = r19;
            goto L35
        L29:
            r8 = r18;
            goto L31
        L25:
            r7 = r17;
            goto L27
        L21:
            r6 = r16;
            goto L23
        L17:
            r5 = r15;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r3 = r13;
            goto L11
        L5:
            r2 = r12;
            goto L7
        }

        public final boolean component1() {
            return this.noProductInfo;
        }

        public final Double component10() {
            return this.appendHeight;
        }

        public final boolean component2() {
            return this.isNewProductUI;
        }

        public final boolean component3() {
            return this.showPeopleNewIcon;
        }

        public final boolean component4() {
            return this.newPadding;
        }

        public final boolean component5() {
            return this.highValue;
        }

        public final boolean component6() {
            return this.uiCompact;
        }

        public final boolean component7() {
            return this.liveCardChangeCover;
        }

        public final boolean component8() {
            return this.liveCardEnlargePlayArea;
        }

        public final int component9() {
            return this.coinLabelStyle;
        }

        public final Experiment copy(boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, int r21, Double r22) {
            return new Experiment(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Experiment) == false) goto L26;
            Experiment r4 = (Experiment) r3;
            if (this.noProductInfo == r4.noProductInfo) goto L8;
            return false;
        L8:
            if (this.isNewProductUI == r4.isNewProductUI) goto L10;
            return false;
        L10:
            if (this.showPeopleNewIcon == r4.showPeopleNewIcon) goto L12;
            return false;
        L12:
            if (this.newPadding == r4.newPadding) goto L14;
            return false;
        L14:
            if (this.highValue == r4.highValue) goto L16;
            return false;
        L16:
            if (this.uiCompact == r4.uiCompact) goto L18;
            return false;
        L18:
            if (this.liveCardChangeCover == r4.liveCardChangeCover) goto L20;
            return false;
        L20:
            if (this.liveCardEnlargePlayArea == r4.liveCardEnlargePlayArea) goto L22;
            return false;
        L22:
            if (this.coinLabelStyle == r4.coinLabelStyle) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.appendHeight, r4.appendHeight) == true) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        public int hashCode() {
            boolean r0 = this.noProductInfo;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.isNewProductUI;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.showPeopleNewIcon;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.newPadding;
            ?? r11 = r10;
            if (r10 == false) goto L14;
            r11 = 1;
        L14:
            int r12 = (r9 + r11) * 31;
            boolean r13 = this.highValue;
            ?? r14 = r13;
            if (r13 == false) goto L17;
            r14 = 1;
        L17:
            int r15 = (r12 + r14) * 31;
            boolean r16 = this.uiCompact;
            ?? r17 = r16;
            if (r16 == false) goto L20;
            r17 = 1;
        L20:
            int r18 = (r15 + r17) * 31;
            boolean r19 = this.liveCardChangeCover;
            ?? r20 = r19;
            if (r19 == false) goto L23;
            r20 = 1;
        L23:
            int r21 = (r18 + r20) * 31;
            boolean r22 = this.liveCardEnlargePlayArea;
            if (r22 == true) goto L27;
            r1 = r22;
        L27:
            int r23 = (((r21 + r1) * 31) + this.coinLabelStyle) * 31;
            Double r24 = this.appendHeight;
            if (r24 == null) goto L30;
            int r25 = r24.hashCode();
        L32:
            return r23 + r25;
        L30:
            r25 = 0;
            goto L32
        }

        public String toString() {
            return "Experiment(noProductInfo=" + this.noProductInfo + ", isNewProductUI=" + this.isNewProductUI + ", showPeopleNewIcon=" + this.showPeopleNewIcon + ", newPadding=" + this.newPadding + ", highValue=" + this.highValue + ", uiCompact=" + this.uiCompact + ", liveCardChangeCover=" + this.liveCardChangeCover + ", liveCardEnlargePlayArea=" + this.liveCardEnlargePlayArea + ", coinLabelStyle=" + this.coinLabelStyle + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final int getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final boolean getHighValue() {
            return this.highValue;
        }

        public final boolean getLiveCardChangeCover() {
            return this.liveCardChangeCover;
        }

        public final boolean getLiveCardEnlargePlayArea() {
            return this.liveCardEnlargePlayArea;
        }

        public final boolean getNewPadding() {
            return this.newPadding;
        }

        public final boolean getNoProductInfo() {
            return this.noProductInfo;
        }

        public final boolean getShowPeopleNewIcon() {
            return this.showPeopleNewIcon;
        }

        public final boolean getUiCompact() {
            return this.uiCompact;
        }

        public final boolean isNewProductUI() {
            return this.isNewProductUI;
        }

        public Experiment(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, int r9, Double r10) {
            this.noProductInfo = r1;
            this.isNewProductUI = r2;
            this.showPeopleNewIcon = r3;
            this.newPadding = r4;
            this.highValue = r5;
            this.uiCompact = r6;
            this.liveCardChangeCover = r7;
            this.liveCardEnlargePlayArea = r8;
            this.coinLabelStyle = r9;
            this.appendHeight = r10;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0015HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003JÅ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010B\u001a\u00020\u00152\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\nHÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006F"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;", "", "roomId", "", "streamData", "", "cover", "recommend", "animateImageUrl", "animateImageWidth", "", "animateImageHeight", "content", "hotNum", "hotNumStr", "accessibilityLabel", "playIconUrl", "title", "recReason", "recReasonType", "showProductImage", "", "newHotIcon", "newHotDesc", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getAnimateImageHeight", "()I", "getAnimateImageUrl", "getAnimateImageWidth", "getContent", "getCover", "getHotNum", "getHotNumStr", "getNewHotDesc", "getNewHotIcon", "getPlayIconUrl", "getRecReason", "getRecReasonType", "getRecommend", "getRoomId", "()J", "getShowProductImage", "()Z", "getStreamData", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Live {
        private final String accessibilityLabel;
        private final int animateImageHeight;
        private final String animateImageUrl;
        private final int animateImageWidth;
        private final String content;
        private final String cover;
        private final String hotNum;
        private final String hotNumStr;
        private final String newHotDesc;
        private final String newHotIcon;
        private final String playIconUrl;
        private final String recReason;
        private final String recReasonType;
        private final String recommend;
        private final long roomId;
        private final boolean showProductImage;
        private final String streamData;
        private final String title;

        public static /* synthetic */ Live copy$default(Live r17, long r18, String r20, String r21, String r22, String r23, int r24, int r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, boolean r34, String r35, String r36, int r37, Object r38) {
            if ((r37 & 1) == 0) goto L5;
            long r2 = r17.roomId;
        L7:
            if ((r37 & 2) == 0) goto L9;
            String r4 = r17.streamData;
        L11:
            if ((r37 & 4) == 0) goto L13;
            String r5 = r17.cover;
        L15:
            if ((r37 & 8) == 0) goto L17;
            String r6 = r17.recommend;
        L19:
            if ((r37 & 16) == 0) goto L21;
            String r7 = r17.animateImageUrl;
        L23:
            if ((r37 & 32) == 0) goto L25;
            int r8 = r17.animateImageWidth;
        L27:
            if ((r37 & 64) == 0) goto L29;
            int r9 = r17.animateImageHeight;
        L31:
            if ((r37 & 128) == 0) goto L33;
            String r10 = r17.content;
        L35:
            if ((r37 & 256) == 0) goto L37;
            String r11 = r17.hotNum;
        L39:
            if ((r37 & 512) == 0) goto L41;
            String r12 = r17.hotNumStr;
        L43:
            if ((r37 & 1024) == 0) goto L45;
            String r13 = r17.accessibilityLabel;
        L47:
            if ((r37 & 2048) == 0) goto L49;
            String r14 = r17.playIconUrl;
        L51:
            if ((r37 & 4096) == 0) goto L53;
            String r15 = r17.title;
        L54:
            String r39 = r15;
            if ((r37 & 8192) == 0) goto L57;
            String r16 = r17.recReason;
        L58:
            String r310 = r16;
            if ((r37 & 16384) == 0) goto L61;
            String r19 = r17.recReasonType;
        L62:
            String r311 = r19;
            if ((r37 & 32768) == 0) goto L65;
            boolean r110 = r17.showProductImage;
        L66:
            boolean r312 = r110;
            if ((r37 & 65536) == 0) goto L69;
            String r111 = r17.newHotIcon;
        L71:
            if ((r37 & 131072) == 0) goto L73;
            String r1 = r17.newHotDesc;
        L75:
            return r17.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r39, r310, r311, r312, r111, r1);
        L73:
            r1 = r36;
            goto L75
        L69:
            r111 = r35;
            goto L71
        L65:
            r110 = r34;
            goto L66
        L61:
            r19 = r33;
            goto L62
        L57:
            r16 = r32;
            goto L58
        L53:
            r15 = r31;
            goto L54
        L49:
            r14 = r30;
            goto L51
        L45:
            r13 = r29;
            goto L47
        L41:
            r12 = r28;
            goto L43
        L37:
            r11 = r27;
            goto L39
        L33:
            r10 = r26;
            goto L35
        L29:
            r9 = r25;
            goto L31
        L25:
            r8 = r24;
            goto L27
        L21:
            r7 = r23;
            goto L23
        L17:
            r6 = r22;
            goto L19
        L13:
            r5 = r21;
            goto L15
        L9:
            r4 = r20;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final long component1() {
            return this.roomId;
        }

        public final String component10() {
            return this.hotNumStr;
        }

        public final String component11() {
            return this.accessibilityLabel;
        }

        public final String component12() {
            return this.playIconUrl;
        }

        public final String component13() {
            return this.title;
        }

        public final String component14() {
            return this.recReason;
        }

        public final String component15() {
            return this.recReasonType;
        }

        public final boolean component16() {
            return this.showProductImage;
        }

        public final String component17() {
            return this.newHotIcon;
        }

        public final String component18() {
            return this.newHotDesc;
        }

        public final String component2() {
            return this.streamData;
        }

        public final String component3() {
            return this.cover;
        }

        public final String component4() {
            return this.recommend;
        }

        public final String component5() {
            return this.animateImageUrl;
        }

        public final int component6() {
            return this.animateImageWidth;
        }

        public final int component7() {
            return this.animateImageHeight;
        }

        public final String component8() {
            return this.content;
        }

        public final String component9() {
            return this.hotNum;
        }

        public final Live copy(long r22, String r24, String r25, String r26, String r27, int r28, int r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, boolean r38, String r39, String r40) {
            Intrinsics.checkNotNullParameter(r24, "streamData");
            Intrinsics.checkNotNullParameter(r25, "cover");
            Intrinsics.checkNotNullParameter(r26, "recommend");
            Intrinsics.checkNotNullParameter(r27, "animateImageUrl");
            Intrinsics.checkNotNullParameter(r30, "content");
            Intrinsics.checkNotNullParameter(r31, "hotNum");
            Intrinsics.checkNotNullParameter(r32, "hotNumStr");
            Intrinsics.checkNotNullParameter(r33, "accessibilityLabel");
            Intrinsics.checkNotNullParameter(r34, "playIconUrl");
            Intrinsics.checkNotNullParameter(r35, "title");
            return new Live(r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof Live) == false) goto L42;
            Live r7 = (Live) r6;
            if (this.roomId == r7.roomId) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.streamData, r7.streamData) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.cover, r7.cover) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.recommend, r7.recommend) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.animateImageUrl, r7.animateImageUrl) == true) goto L16;
            return false;
        L16:
            if (this.animateImageWidth == r7.animateImageWidth) goto L18;
            return false;
        L18:
            if (this.animateImageHeight == r7.animateImageHeight) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.content, r7.content) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.hotNum, r7.hotNum) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.hotNumStr, r7.hotNumStr) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.accessibilityLabel, r7.accessibilityLabel) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.playIconUrl, r7.playIconUrl) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.title, r7.title) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.recReason, r7.recReason) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.recReasonType, r7.recReasonType) == true) goto L36;
            return false;
        L36:
            if (this.showProductImage == r7.showProductImage) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.newHotIcon, r7.newHotIcon) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.newHotDesc, r7.newHotDesc) == true) goto L64;
            return false;
        L64:
            return true;
        L42:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v41, types: [int] */
        /* JADX WARN: Type inference failed for: r0v47 */
        /* JADX WARN: Type inference failed for: r0v60 */
        /* JADX WARN: Type inference failed for: r1v30, types: [int] */
        public int hashCode() {
            long r0 = this.roomId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.streamData;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (r1 + r4) * 31;
            String r6 = this.cover;
            if (r6 == null) goto L9;
            int r7 = r6.hashCode();
        L10:
            int r8 = (r5 + r7) * 31;
            String r9 = this.recommend;
            if (r9 == null) goto L13;
            int r10 = r9.hashCode();
        L14:
            int r11 = (r8 + r10) * 31;
            String r12 = this.animateImageUrl;
            if (r12 == null) goto L17;
            int r13 = r12.hashCode();
        L18:
            int r14 = (((((r11 + r13) * 31) + this.animateImageWidth) * 31) + this.animateImageHeight) * 31;
            String r15 = this.content;
            if (r15 == null) goto L21;
            int r16 = r15.hashCode();
        L22:
            int r17 = (r14 + r16) * 31;
            String r18 = this.hotNum;
            if (r18 == null) goto L25;
            int r19 = r18.hashCode();
        L26:
            int r20 = (r17 + r19) * 31;
            String r21 = this.hotNumStr;
            if (r21 == null) goto L29;
            int r22 = r21.hashCode();
        L30:
            int r23 = (r20 + r22) * 31;
            String r24 = this.accessibilityLabel;
            if (r24 == null) goto L33;
            int r25 = r24.hashCode();
        L34:
            int r26 = (r23 + r25) * 31;
            String r27 = this.playIconUrl;
            if (r27 == null) goto L37;
            int r28 = r27.hashCode();
        L38:
            int r29 = (r26 + r28) * 31;
            String r30 = this.title;
            if (r30 == null) goto L41;
            int r31 = r30.hashCode();
        L42:
            int r32 = (r29 + r31) * 31;
            String r33 = this.recReason;
            if (r33 == null) goto L45;
            int r34 = r33.hashCode();
        L46:
            int r35 = (r32 + r34) * 31;
            String r36 = this.recReasonType;
            if (r36 == null) goto L49;
            int r37 = r36.hashCode();
        L50:
            int r38 = (r35 + r37) * 31;
            boolean r39 = this.showProductImage;
            ?? r40 = r39;
            if (r39 == false) goto L53;
            r40 = 1;
        L53:
            int r41 = (r38 + r40) * 31;
            String r42 = this.newHotIcon;
            if (r42 == null) goto L56;
            int r43 = r42.hashCode();
        L57:
            int r44 = (r41 + r43) * 31;
            String r45 = this.newHotDesc;
            if (r45 == null) goto L61;
            r3 = r45.hashCode();
        L61:
            return r44 + r3;
        L56:
            r43 = 0;
            goto L57
        L49:
            r37 = 0;
            goto L50
        L45:
            r34 = 0;
            goto L46
        L41:
            r31 = 0;
            goto L42
        L37:
            r28 = 0;
            goto L38
        L33:
            r25 = 0;
            goto L34
        L29:
            r22 = 0;
            goto L30
        L25:
            r19 = 0;
            goto L26
        L21:
            r16 = 0;
            goto L22
        L17:
            r13 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public String toString() {
            return "Live(roomId=" + this.roomId + ", streamData=" + this.streamData + ", cover=" + this.cover + ", recommend=" + this.recommend + ", animateImageUrl=" + this.animateImageUrl + ", animateImageWidth=" + this.animateImageWidth + ", animateImageHeight=" + this.animateImageHeight + ", content=" + this.content + ", hotNum=" + this.hotNum + ", hotNumStr=" + this.hotNumStr + ", accessibilityLabel=" + this.accessibilityLabel + ", playIconUrl=" + this.playIconUrl + ", title=" + this.title + ", recReason=" + this.recReason + ", recReasonType=" + this.recReasonType + ", showProductImage=" + this.showProductImage + ", newHotIcon=" + this.newHotIcon + ", newHotDesc=" + this.newHotDesc + ")";
        }

        public final String getAccessibilityLabel() {
            return this.accessibilityLabel;
        }

        public final int getAnimateImageHeight() {
            return this.animateImageHeight;
        }

        public final String getAnimateImageUrl() {
            return this.animateImageUrl;
        }

        public final int getAnimateImageWidth() {
            return this.animateImageWidth;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getCover() {
            return this.cover;
        }

        public final String getHotNum() {
            return this.hotNum;
        }

        public final String getHotNumStr() {
            return this.hotNumStr;
        }

        public final String getNewHotDesc() {
            return this.newHotDesc;
        }

        public final String getNewHotIcon() {
            return this.newHotIcon;
        }

        public final String getPlayIconUrl() {
            return this.playIconUrl;
        }

        public final String getRecReason() {
            return this.recReason;
        }

        public final String getRecReasonType() {
            return this.recReasonType;
        }

        public final String getRecommend() {
            return this.recommend;
        }

        public final long getRoomId() {
            return this.roomId;
        }

        public final boolean getShowProductImage() {
            return this.showProductImage;
        }

        public final String getStreamData() {
            return this.streamData;
        }

        public final String getTitle() {
            return this.title;
        }

        public Live(long r14, String r16, String r17, String r18, String r19, int r20, int r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, boolean r30, String r31, String r32) {
            Intrinsics.checkNotNullParameter(r16, "streamData");
            Intrinsics.checkNotNullParameter(r17, "cover");
            Intrinsics.checkNotNullParameter(r18, "recommend");
            Intrinsics.checkNotNullParameter(r19, "animateImageUrl");
            Intrinsics.checkNotNullParameter(r22, "content");
            Intrinsics.checkNotNullParameter(r23, "hotNum");
            Intrinsics.checkNotNullParameter(r24, "hotNumStr");
            Intrinsics.checkNotNullParameter(r25, "accessibilityLabel");
            Intrinsics.checkNotNullParameter(r26, "playIconUrl");
            Intrinsics.checkNotNullParameter(r27, "title");
            this.roomId = r14;
            this.streamData = r16;
            this.cover = r17;
            this.recommend = r18;
            this.animateImageUrl = r19;
            this.animateImageWidth = r20;
            this.animateImageHeight = r21;
            this.content = r22;
            this.hotNum = r23;
            this.hotNumStr = r24;
            this.accessibilityLabel = r25;
            this.playIconUrl = r26;
            this.title = r27;
            this.recReason = r28;
            this.recReasonType = r29;
            this.showProductImage = r30;
            this.newHotIcon = r31;
            this.newHotDesc = r32;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;", "", "uiStyle", "", "taskExpGroup", "(Ljava/lang/String;Ljava/lang/String;)V", "getTaskExpGroup", "()Ljava/lang/String;", "getUiStyle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTExperiment {
        private final String taskExpGroup;
        private final String uiStyle;

        public static /* synthetic */ TTExperiment copy$default(TTExperiment r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.uiStyle;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.taskExpGroup;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.uiStyle;
        }

        public final String component2() {
            return this.taskExpGroup;
        }

        public final TTExperiment copy(String r2, String r3) {
            return new TTExperiment(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof TTExperiment) == false) goto L10;
            TTExperiment r4 = (TTExperiment) r3;
            if (Intrinsics.areEqual(this.uiStyle, r4.uiStyle) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.taskExpGroup, r4.taskExpGroup) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.uiStyle;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.taskExpGroup;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "TTExperiment(uiStyle=" + this.uiStyle + ", taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public final String getUiStyle() {
            return this.uiStyle;
        }

        public TTExperiment(String r1, String r2) {
            this.uiStyle = r1;
            this.taskExpGroup = r2;
        }
    }

    public final CommonData.CoinData getCoinData() {
        return this.coinData;
    }

    public final ElementStyle getElementStyle() {
        return this.elementStyle;
    }

    public final Experiment getExperiment() {
        return this.experiment;
    }

    public final LiveCardData.FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final Live getLive() {
        return this.live;
    }

    public final CommonModel$Product getProduct() {
        return this.product;
    }

    public final boolean getShowAdTag() {
        return this.showAdTag;
    }

    public final Boolean getShowJustNowUI() {
        return this.showJustNowUI;
    }

    public final TTExperiment getTtExperiment() {
        return this.ttExperiment;
    }

    public final CommonModel$User getUser() {
        return this.user;
    }

    public final CommonData.WindVaneEventData getWindVane() {
        return this.windVane;
    }

    public LiveCardModel(CommonModel$Product r2, CommonModel$User r3, Live r4, Experiment r5, boolean r6, LiveCardData.FavoriteItemStyle r7, Boolean r8, CommonData.WindVaneEventData r9, CommonData.CoinData r10, ElementStyle r11, TTExperiment r12) {
        Intrinsics.checkNotNullParameter(r2, "product");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "live");
        Intrinsics.checkNotNullParameter(r5, "experiment");
        Intrinsics.checkNotNullParameter(r11, "elementStyle");
        this.product = r2;
        this.user = r3;
        this.live = r4;
        this.experiment = r5;
        this.showAdTag = r6;
        this.itemStyle = r7;
        this.showJustNowUI = r8;
        this.windVane = r9;
        this.coinData = r10;
        this.elementStyle = r11;
        this.ttExperiment = r12;
    }

    public /* synthetic */ LiveCardModel(CommonModel$Product r16, CommonModel$User r17, Live r18, Experiment r19, boolean r20, LiveCardData.FavoriteItemStyle r21, Boolean r22, CommonData.WindVaneEventData r23, CommonData.CoinData r24, ElementStyle r25, TTExperiment r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 32) == 0) goto L5;
        LiveCardData.FavoriteItemStyle r9 = null;
    L7:
        if ((r27 & 64) == 0) goto L9;
        Boolean r10 = null;
    L11:
        if ((r27 & 128) == 0) goto L13;
        CommonData.WindVaneEventData r11 = null;
    L15:
        if ((r27 & 256) == 0) goto L17;
        CommonData.CoinData r12 = null;
    L19:
        if ((r27 & 1024) == 0) goto L21;
        TTExperiment r14 = null;
    L22:
        this(r16, r17, r18, r19, r20, r9, r10, r11, r12, r25, r14);
        return;
    L21:
        r14 = r26;
        goto L22
    L17:
        r12 = r24;
        goto L19
    L13:
        r11 = r23;
        goto L15
    L9:
        r10 = r22;
        goto L11
    L5:
        r9 = r21;
        goto L7
    }
}
