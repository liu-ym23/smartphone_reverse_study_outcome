package com.bytedance.android.shopping.mall.homepage.card.video;

import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$MaskStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001:\u00040123Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel;", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "video", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;", "liveHeader", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "experiment", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "showJustNowUI", "", "windVane", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "elementStyle", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "ttExperiment", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;)V", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getElementStyle", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "getExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "getLiveHeader", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "getShowJustNowUI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTtExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "getVideo", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;", "getWindVane", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "ElementStyle", "Experiment", "TTExperiment", "Video", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCardModel {
    private final CommonData.CoinData coinData;
    private final ElementStyle elementStyle;
    private final Experiment experiment;
    private final VideoCardData.FavoriteItemStyle itemStyle;
    private final VideoCardData.Companion.LiveHeader liveHeader;
    private final CommonModel$Product product;
    private final Boolean showJustNowUI;
    private final TTExperiment ttExperiment;
    private final CommonModel$User user;
    private final Video video;
    private final CommonData.WindVaneEventData windVane;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010C\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\rHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0010HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003Jð\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00102\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020[HÖ\u0001J\t\u0010\\\u001a\u00020]HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u001d\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010(R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&¨\u0006^"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "", "infoLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "avatarLayout", "userTextStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "logoLayout", "videoTitleLayout", "videoTitleTextStyle", "maskStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "hotIconStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "rootStyle", "darkModeEnable", "", "height", "", "feedCardRatio", "", "liveHeaderStateStyle", "liveHeaderEnterIconLayout", "coinLayout", "coinStyle", "coinIconLayout", "playerMaskStyle", "playerLayout", "feedBackLayout", "isEnlarge", "videoLikeStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;)V", "getAvatarLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getCoinIconLayout", "getCoinLayout", "getCoinStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getDarkModeEnable", "()Z", "getFeedBackLayout", "getFeedCardRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHotIconStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "getInfoLayout", "getLiveHeaderEnterIconLayout", "getLiveHeaderStateStyle", "getLogoLayout", "getMaskStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "getPlayerLayout", "getPlayerMaskStyle", "getRootStyle", "getUserTextStyle", "getVideoLikeStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "getVideoTitleLayout", "getVideoTitleTextStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;)Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "equals", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementStyle {
        private final CommonModel$LayoutStyle avatarLayout;
        private final CommonModel$LayoutStyle coinIconLayout;
        private final CommonModel$LayoutStyle coinLayout;
        private final CommonModel$CusTextStyle coinStyle;
        private final boolean darkModeEnable;
        private final CommonModel$LayoutStyle feedBackLayout;
        private final Float feedCardRatio;
        private final Double height;
        private final CommonModel$CommonColorStyle hotIconStyle;
        private final CommonModel$LayoutStyle infoLayout;
        private final boolean isEnlarge;
        private final CommonModel$LayoutStyle liveHeaderEnterIconLayout;
        private final CommonModel$CusTextStyle liveHeaderStateStyle;
        private final CommonModel$LayoutStyle logoLayout;
        private final CommonModel$MaskStyle maskStyle;
        private final CommonModel$LayoutStyle playerLayout;
        private final CommonModel$CommonColorStyle playerMaskStyle;
        private final CommonModel$CommonColorStyle rootStyle;
        private final CommonModel$CusTextStyle userTextStyle;
        private final CommonData.ElementStyle.VideoLikeStyle videoLikeStyle;
        private final CommonModel$LayoutStyle videoTitleLayout;
        private final CommonModel$CusTextStyle videoTitleTextStyle;

        public static /* synthetic */ ElementStyle copy$default(ElementStyle r17, CommonModel$LayoutStyle r18, CommonModel$LayoutStyle r19, CommonModel$CusTextStyle r20, CommonModel$LayoutStyle r21, CommonModel$LayoutStyle r22, CommonModel$CusTextStyle r23, CommonModel$MaskStyle r24, CommonModel$CommonColorStyle r25, CommonModel$CommonColorStyle r26, boolean r27, Double r28, Float r29, CommonModel$CusTextStyle r30, CommonModel$LayoutStyle r31, CommonModel$LayoutStyle r32, CommonModel$CusTextStyle r33, CommonModel$LayoutStyle r34, CommonModel$CommonColorStyle r35, CommonModel$LayoutStyle r36, CommonModel$LayoutStyle r37, boolean r38, CommonData.ElementStyle.VideoLikeStyle r39, int r40, Object r41) {
            if ((r40 & 1) == 0) goto L5;
            CommonModel$LayoutStyle r2 = r17.infoLayout;
        L7:
            if ((r40 & 2) == 0) goto L9;
            CommonModel$LayoutStyle r3 = r17.avatarLayout;
        L11:
            if ((r40 & 4) == 0) goto L13;
            CommonModel$CusTextStyle r4 = r17.userTextStyle;
        L15:
            if ((r40 & 8) == 0) goto L17;
            CommonModel$LayoutStyle r5 = r17.logoLayout;
        L19:
            if ((r40 & 16) == 0) goto L21;
            CommonModel$LayoutStyle r6 = r17.videoTitleLayout;
        L23:
            if ((r40 & 32) == 0) goto L25;
            CommonModel$CusTextStyle r7 = r17.videoTitleTextStyle;
        L27:
            if ((r40 & 64) == 0) goto L29;
            CommonModel$MaskStyle r8 = r17.maskStyle;
        L31:
            if ((r40 & 128) == 0) goto L33;
            CommonModel$CommonColorStyle r9 = r17.hotIconStyle;
        L35:
            if ((r40 & 256) == 0) goto L37;
            CommonModel$CommonColorStyle r10 = r17.rootStyle;
        L39:
            if ((r40 & 512) == 0) goto L41;
            boolean r11 = r17.darkModeEnable;
        L43:
            if ((r40 & 1024) == 0) goto L45;
            Double r12 = r17.height;
        L47:
            if ((r40 & 2048) == 0) goto L49;
            Float r13 = r17.feedCardRatio;
        L51:
            if ((r40 & 4096) == 0) goto L53;
            CommonModel$CusTextStyle r14 = r17.liveHeaderStateStyle;
        L55:
            if ((r40 & 8192) == 0) goto L57;
            CommonModel$LayoutStyle r15 = r17.liveHeaderEnterIconLayout;
        L58:
            CommonModel$LayoutStyle r310 = r15;
            if ((r40 & 16384) == 0) goto L61;
            CommonModel$LayoutStyle r16 = r17.coinLayout;
        L62:
            CommonModel$LayoutStyle r311 = r16;
            if ((r40 & 32768) == 0) goto L65;
            CommonModel$CusTextStyle r110 = r17.coinStyle;
        L66:
            CommonModel$CusTextStyle r312 = r110;
            if ((r40 & 65536) == 0) goto L69;
            CommonModel$LayoutStyle r111 = r17.coinIconLayout;
        L70:
            CommonModel$LayoutStyle r313 = r111;
            if ((r40 & 131072) == 0) goto L73;
            CommonModel$CommonColorStyle r112 = r17.playerMaskStyle;
        L74:
            CommonModel$CommonColorStyle r314 = r112;
            if ((r40 & 262144) == 0) goto L77;
            CommonModel$LayoutStyle r113 = r17.playerLayout;
        L78:
            CommonModel$LayoutStyle r315 = r113;
            if ((r40 & 524288) == 0) goto L81;
            CommonModel$LayoutStyle r114 = r17.feedBackLayout;
        L82:
            CommonModel$LayoutStyle r316 = r114;
            if ((r40 & 1048576) == 0) goto L85;
            boolean r115 = r17.isEnlarge;
        L87:
            if ((r40 & 2097152) == 0) goto L89;
            CommonData.ElementStyle.VideoLikeStyle r1 = r17.videoLikeStyle;
        L91:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r115, r1);
        L89:
            r1 = r39;
            goto L91
        L85:
            r115 = r38;
            goto L87
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

        public final boolean component10() {
            return this.darkModeEnable;
        }

        public final Double component11() {
            return this.height;
        }

        public final Float component12() {
            return this.feedCardRatio;
        }

        public final CommonModel$CusTextStyle component13() {
            return this.liveHeaderStateStyle;
        }

        public final CommonModel$LayoutStyle component14() {
            return this.liveHeaderEnterIconLayout;
        }

        public final CommonModel$LayoutStyle component15() {
            return this.coinLayout;
        }

        public final CommonModel$CusTextStyle component16() {
            return this.coinStyle;
        }

        public final CommonModel$LayoutStyle component17() {
            return this.coinIconLayout;
        }

        public final CommonModel$CommonColorStyle component18() {
            return this.playerMaskStyle;
        }

        public final CommonModel$LayoutStyle component19() {
            return this.playerLayout;
        }

        public final CommonModel$LayoutStyle component2() {
            return this.avatarLayout;
        }

        public final CommonModel$LayoutStyle component20() {
            return this.feedBackLayout;
        }

        public final boolean component21() {
            return this.isEnlarge;
        }

        public final CommonData.ElementStyle.VideoLikeStyle component22() {
            return this.videoLikeStyle;
        }

        public final CommonModel$CusTextStyle component3() {
            return this.userTextStyle;
        }

        public final CommonModel$LayoutStyle component4() {
            return this.logoLayout;
        }

        public final CommonModel$LayoutStyle component5() {
            return this.videoTitleLayout;
        }

        public final CommonModel$CusTextStyle component6() {
            return this.videoTitleTextStyle;
        }

        public final CommonModel$MaskStyle component7() {
            return this.maskStyle;
        }

        public final CommonModel$CommonColorStyle component8() {
            return this.hotIconStyle;
        }

        public final CommonModel$CommonColorStyle component9() {
            return this.rootStyle;
        }

        public final ElementStyle copy(CommonModel$LayoutStyle r26, CommonModel$LayoutStyle r27, CommonModel$CusTextStyle r28, CommonModel$LayoutStyle r29, CommonModel$LayoutStyle r30, CommonModel$CusTextStyle r31, CommonModel$MaskStyle r32, CommonModel$CommonColorStyle r33, CommonModel$CommonColorStyle r34, boolean r35, Double r36, Float r37, CommonModel$CusTextStyle r38, CommonModel$LayoutStyle r39, CommonModel$LayoutStyle r40, CommonModel$CusTextStyle r41, CommonModel$LayoutStyle r42, CommonModel$CommonColorStyle r43, CommonModel$LayoutStyle r44, CommonModel$LayoutStyle r45, boolean r46, CommonData.ElementStyle.VideoLikeStyle r47) {
            Intrinsics.checkNotNullParameter(r26, "infoLayout");
            Intrinsics.checkNotNullParameter(r27, "avatarLayout");
            Intrinsics.checkNotNullParameter(r28, "userTextStyle");
            Intrinsics.checkNotNullParameter(r29, "logoLayout");
            Intrinsics.checkNotNullParameter(r30, "videoTitleLayout");
            Intrinsics.checkNotNullParameter(r31, "videoTitleTextStyle");
            Intrinsics.checkNotNullParameter(r32, "maskStyle");
            Intrinsics.checkNotNullParameter(r33, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r34, "rootStyle");
            Intrinsics.checkNotNullParameter(r38, "liveHeaderStateStyle");
            Intrinsics.checkNotNullParameter(r39, "liveHeaderEnterIconLayout");
            Intrinsics.checkNotNullParameter(r40, "coinLayout");
            Intrinsics.checkNotNullParameter(r41, "coinStyle");
            Intrinsics.checkNotNullParameter(r42, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r43, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r44, "playerLayout");
            Intrinsics.checkNotNullParameter(r45, "feedBackLayout");
            return new ElementStyle(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ElementStyle) == false) goto L50;
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
            if (Intrinsics.areEqual(this.videoTitleLayout, r4.videoTitleLayout) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.videoTitleTextStyle, r4.videoTitleTextStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.maskStyle, r4.maskStyle) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.hotIconStyle, r4.hotIconStyle) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.rootStyle, r4.rootStyle) == true) goto L24;
            return false;
        L24:
            if (this.darkModeEnable == r4.darkModeEnable) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.height, r4.height) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.feedCardRatio, r4.feedCardRatio) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.liveHeaderStateStyle, r4.liveHeaderStateStyle) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.liveHeaderEnterIconLayout, r4.liveHeaderEnterIconLayout) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.coinLayout, r4.coinLayout) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.coinStyle, r4.coinStyle) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.coinIconLayout, r4.coinIconLayout) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.playerMaskStyle, r4.playerMaskStyle) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.playerLayout, r4.playerLayout) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.feedBackLayout, r4.feedBackLayout) == true) goto L46;
            return false;
        L46:
            if (this.isEnlarge == r4.isEnlarge) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.videoLikeStyle, r4.videoLikeStyle) == true) goto L76;
            return false;
        L76:
            return true;
        L50:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r2v25, types: [int] */
        /* JADX WARN: Type inference failed for: r2v68 */
        /* JADX WARN: Type inference failed for: r2v77 */
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
            CommonModel$LayoutStyle r13 = this.videoTitleLayout;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            CommonModel$CusTextStyle r16 = this.videoTitleTextStyle;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            CommonModel$MaskStyle r19 = this.maskStyle;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            CommonModel$CommonColorStyle r22 = this.hotIconStyle;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            CommonModel$CommonColorStyle r25 = this.rootStyle;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            boolean r28 = this.darkModeEnable;
            ?? r29 = 1;
            ?? r30 = r28;
            if (r28 == false) goto L41;
            r30 = 1;
        L41:
            int r31 = (r27 + r30) * 31;
            Double r32 = this.height;
            if (r32 == null) goto L44;
            int r33 = r32.hashCode();
        L45:
            int r34 = (r31 + r33) * 31;
            Float r35 = this.feedCardRatio;
            if (r35 == null) goto L48;
            int r36 = r35.hashCode();
        L49:
            int r37 = (r34 + r36) * 31;
            CommonModel$CusTextStyle r38 = this.liveHeaderStateStyle;
            if (r38 == null) goto L52;
            int r39 = r38.hashCode();
        L53:
            int r40 = (r37 + r39) * 31;
            CommonModel$LayoutStyle r41 = this.liveHeaderEnterIconLayout;
            if (r41 == null) goto L56;
            int r42 = r41.hashCode();
        L57:
            int r43 = (r40 + r42) * 31;
            CommonModel$LayoutStyle r44 = this.coinLayout;
            if (r44 == null) goto L60;
            int r45 = r44.hashCode();
        L61:
            int r46 = (r43 + r45) * 31;
            CommonModel$CusTextStyle r47 = this.coinStyle;
            if (r47 == null) goto L64;
            int r48 = r47.hashCode();
        L65:
            int r49 = (r46 + r48) * 31;
            CommonModel$LayoutStyle r50 = this.coinIconLayout;
            if (r50 == null) goto L68;
            int r51 = r50.hashCode();
        L69:
            int r52 = (r49 + r51) * 31;
            CommonModel$CommonColorStyle r53 = this.playerMaskStyle;
            if (r53 == null) goto L72;
            int r54 = r53.hashCode();
        L73:
            int r55 = (r52 + r54) * 31;
            CommonModel$LayoutStyle r56 = this.playerLayout;
            if (r56 == null) goto L76;
            int r57 = r56.hashCode();
        L77:
            int r58 = (r55 + r57) * 31;
            CommonModel$LayoutStyle r59 = this.feedBackLayout;
            if (r59 == null) goto L80;
            int r60 = r59.hashCode();
        L81:
            int r61 = (r58 + r60) * 31;
            boolean r62 = this.isEnlarge;
            if (r62 == true) goto L85;
            r29 = r62;
        L85:
            int r63 = (r61 + r29) * 31;
            CommonData.ElementStyle.VideoLikeStyle r64 = this.videoLikeStyle;
            if (r64 == null) goto L89;
            r1 = r64.hashCode();
        L89:
            return r63 + r1;
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
        L60:
            r45 = 0;
            goto L61
        L56:
            r42 = 0;
            goto L57
        L52:
            r39 = 0;
            goto L53
        L48:
            r36 = 0;
            goto L49
        L44:
            r33 = 0;
            goto L45
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
            return "ElementStyle(infoLayout=" + this.infoLayout + ", avatarLayout=" + this.avatarLayout + ", userTextStyle=" + this.userTextStyle + ", logoLayout=" + this.logoLayout + ", videoTitleLayout=" + this.videoTitleLayout + ", videoTitleTextStyle=" + this.videoTitleTextStyle + ", maskStyle=" + this.maskStyle + ", hotIconStyle=" + this.hotIconStyle + ", rootStyle=" + this.rootStyle + ", darkModeEnable=" + this.darkModeEnable + ", height=" + this.height + ", feedCardRatio=" + this.feedCardRatio + ", liveHeaderStateStyle=" + this.liveHeaderStateStyle + ", liveHeaderEnterIconLayout=" + this.liveHeaderEnterIconLayout + ", coinLayout=" + this.coinLayout + ", coinStyle=" + this.coinStyle + ", coinIconLayout=" + this.coinIconLayout + ", playerMaskStyle=" + this.playerMaskStyle + ", playerLayout=" + this.playerLayout + ", feedBackLayout=" + this.feedBackLayout + ", isEnlarge=" + this.isEnlarge + ", videoLikeStyle=" + this.videoLikeStyle + ")";
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

        public final boolean getDarkModeEnable() {
            return this.darkModeEnable;
        }

        public final CommonModel$LayoutStyle getFeedBackLayout() {
            return this.feedBackLayout;
        }

        public final Float getFeedCardRatio() {
            return this.feedCardRatio;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final CommonModel$CommonColorStyle getHotIconStyle() {
            return this.hotIconStyle;
        }

        public final CommonModel$LayoutStyle getInfoLayout() {
            return this.infoLayout;
        }

        public final CommonModel$LayoutStyle getLiveHeaderEnterIconLayout() {
            return this.liveHeaderEnterIconLayout;
        }

        public final CommonModel$CusTextStyle getLiveHeaderStateStyle() {
            return this.liveHeaderStateStyle;
        }

        public final CommonModel$LayoutStyle getLogoLayout() {
            return this.logoLayout;
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

        public final CommonModel$CommonColorStyle getRootStyle() {
            return this.rootStyle;
        }

        public final CommonModel$CusTextStyle getUserTextStyle() {
            return this.userTextStyle;
        }

        public final CommonData.ElementStyle.VideoLikeStyle getVideoLikeStyle() {
            return this.videoLikeStyle;
        }

        public final CommonModel$LayoutStyle getVideoTitleLayout() {
            return this.videoTitleLayout;
        }

        public final CommonModel$CusTextStyle getVideoTitleTextStyle() {
            return this.videoTitleTextStyle;
        }

        public final boolean isEnlarge() {
            return this.isEnlarge;
        }

        public ElementStyle(CommonModel$LayoutStyle r17, CommonModel$LayoutStyle r18, CommonModel$CusTextStyle r19, CommonModel$LayoutStyle r20, CommonModel$LayoutStyle r21, CommonModel$CusTextStyle r22, CommonModel$MaskStyle r23, CommonModel$CommonColorStyle r24, CommonModel$CommonColorStyle r25, boolean r26, Double r27, Float r28, CommonModel$CusTextStyle r29, CommonModel$LayoutStyle r30, CommonModel$LayoutStyle r31, CommonModel$CusTextStyle r32, CommonModel$LayoutStyle r33, CommonModel$CommonColorStyle r34, CommonModel$LayoutStyle r35, CommonModel$LayoutStyle r36, boolean r37, CommonData.ElementStyle.VideoLikeStyle r38) {
            Intrinsics.checkNotNullParameter(r17, "infoLayout");
            Intrinsics.checkNotNullParameter(r18, "avatarLayout");
            Intrinsics.checkNotNullParameter(r19, "userTextStyle");
            Intrinsics.checkNotNullParameter(r20, "logoLayout");
            Intrinsics.checkNotNullParameter(r21, "videoTitleLayout");
            Intrinsics.checkNotNullParameter(r22, "videoTitleTextStyle");
            Intrinsics.checkNotNullParameter(r23, "maskStyle");
            Intrinsics.checkNotNullParameter(r24, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r25, "rootStyle");
            Intrinsics.checkNotNullParameter(r29, "liveHeaderStateStyle");
            Intrinsics.checkNotNullParameter(r30, "liveHeaderEnterIconLayout");
            Intrinsics.checkNotNullParameter(r31, "coinLayout");
            Intrinsics.checkNotNullParameter(r32, "coinStyle");
            Intrinsics.checkNotNullParameter(r33, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r34, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r35, "playerLayout");
            Intrinsics.checkNotNullParameter(r36, "feedBackLayout");
            this.infoLayout = r17;
            this.avatarLayout = r18;
            this.userTextStyle = r19;
            this.logoLayout = r20;
            this.videoTitleLayout = r21;
            this.videoTitleTextStyle = r22;
            this.maskStyle = r23;
            this.hotIconStyle = r24;
            this.rootStyle = r25;
            this.darkModeEnable = r26;
            this.height = r27;
            this.feedCardRatio = r28;
            this.liveHeaderStateStyle = r29;
            this.liveHeaderEnterIconLayout = r30;
            this.coinLayout = r31;
            this.coinStyle = r32;
            this.coinIconLayout = r33;
            this.playerMaskStyle = r34;
            this.playerLayout = r35;
            this.feedBackLayout = r36;
            this.isEnlarge = r37;
            this.videoLikeStyle = r38;
        }

        public /* synthetic */ ElementStyle(CommonModel$LayoutStyle r27, CommonModel$LayoutStyle r28, CommonModel$CusTextStyle r29, CommonModel$LayoutStyle r30, CommonModel$LayoutStyle r31, CommonModel$CusTextStyle r32, CommonModel$MaskStyle r33, CommonModel$CommonColorStyle r34, CommonModel$CommonColorStyle r35, boolean r36, Double r37, Float r38, CommonModel$CusTextStyle r39, CommonModel$LayoutStyle r40, CommonModel$LayoutStyle r41, CommonModel$CusTextStyle r42, CommonModel$LayoutStyle r43, CommonModel$CommonColorStyle r44, CommonModel$LayoutStyle r45, CommonModel$LayoutStyle r46, boolean r47, CommonData.ElementStyle.VideoLikeStyle r48, int r49, DefaultConstructorMarker r50) {
            if ((r49 & 512) == 0) goto L5;
            boolean r13 = false;
        L7:
            if ((r49 & 1024) == 0) goto L9;
            Double r14 = null;
        L11:
            if ((r49 & 2048) == 0) goto L13;
            Float r15 = null;
        L15:
            if ((1048576 & r49) == 0) goto L17;
            boolean r24 = false;
        L19:
            if ((r49 & 2097152) == 0) goto L21;
            CommonData.ElementStyle.VideoLikeStyle r25 = null;
        L22:
            this(r27, r28, r29, r30, r31, r32, r33, r34, r35, r13, r14, r15, r39, r40, r41, r42, r43, r44, r45, r46, r24, r25);
            return;
        L21:
            r25 = r48;
            goto L22
        L17:
            r24 = r47;
            goto L19
        L13:
            r15 = r38;
            goto L15
        L9:
            r14 = r37;
            goto L11
        L5:
            r13 = r36;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u000fJ`\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "", "noProductInfo", "", "isNewProductUI", "newPadding", "hideVideoTime", "hideVideoDesc", "uiCompact", "coinLabelStyle", "", "appendHeight", "", "(ZZZZZZILjava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()I", "getHideVideoDesc", "()Z", "getHideVideoTime", "getNewPadding", "getNoProductInfo", "getUiCompact", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZZZZZZILjava/lang/Double;)Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "equals", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Experiment {
        private final Double appendHeight;
        private final int coinLabelStyle;
        private final boolean hideVideoDesc;
        private final boolean hideVideoTime;
        private final boolean isNewProductUI;
        private final boolean newPadding;
        private final boolean noProductInfo;
        private final boolean uiCompact;

        public static /* synthetic */ Experiment copy$default(Experiment r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, int r16, Double r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L5;
            boolean r2 = r9.noProductInfo;
        L7:
            if ((r18 & 2) == 0) goto L9;
            boolean r3 = r9.isNewProductUI;
        L11:
            if ((r18 & 4) == 0) goto L13;
            boolean r4 = r9.newPadding;
        L15:
            if ((r18 & 8) == 0) goto L17;
            boolean r5 = r9.hideVideoTime;
        L19:
            if ((r18 & 16) == 0) goto L21;
            boolean r6 = r9.hideVideoDesc;
        L23:
            if ((r18 & 32) == 0) goto L25;
            boolean r7 = r9.uiCompact;
        L27:
            if ((r18 & 64) == 0) goto L29;
            int r8 = r9.coinLabelStyle;
        L31:
            if ((r18 & 128) == 0) goto L33;
            Double r1 = r9.appendHeight;
        L35:
            return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
        L33:
            r1 = r17;
            goto L35
        L29:
            r8 = r16;
            goto L31
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final boolean component1() {
            return this.noProductInfo;
        }

        public final boolean component2() {
            return this.isNewProductUI;
        }

        public final boolean component3() {
            return this.newPadding;
        }

        public final boolean component4() {
            return this.hideVideoTime;
        }

        public final boolean component5() {
            return this.hideVideoDesc;
        }

        public final boolean component6() {
            return this.uiCompact;
        }

        public final int component7() {
            return this.coinLabelStyle;
        }

        public final Double component8() {
            return this.appendHeight;
        }

        public final Experiment copy(boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, Double r18) {
            return new Experiment(r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Experiment) == false) goto L22;
            Experiment r4 = (Experiment) r3;
            if (this.noProductInfo == r4.noProductInfo) goto L8;
            return false;
        L8:
            if (this.isNewProductUI == r4.isNewProductUI) goto L10;
            return false;
        L10:
            if (this.newPadding == r4.newPadding) goto L12;
            return false;
        L12:
            if (this.hideVideoTime == r4.hideVideoTime) goto L14;
            return false;
        L14:
            if (this.hideVideoDesc == r4.hideVideoDesc) goto L16;
            return false;
        L16:
            if (this.uiCompact == r4.uiCompact) goto L18;
            return false;
        L18:
            if (this.coinLabelStyle == r4.coinLabelStyle) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.appendHeight, r4.appendHeight) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
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
            boolean r7 = this.newPadding;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.hideVideoTime;
            ?? r11 = r10;
            if (r10 == false) goto L14;
            r11 = 1;
        L14:
            int r12 = (r9 + r11) * 31;
            boolean r13 = this.hideVideoDesc;
            ?? r14 = r13;
            if (r13 == false) goto L17;
            r14 = 1;
        L17:
            int r15 = (r12 + r14) * 31;
            boolean r16 = this.uiCompact;
            if (r16 == true) goto L21;
            r1 = r16;
        L21:
            int r17 = (((r15 + r1) * 31) + this.coinLabelStyle) * 31;
            Double r18 = this.appendHeight;
            if (r18 == null) goto L24;
            int r19 = r18.hashCode();
        L26:
            return r17 + r19;
        L24:
            r19 = 0;
            goto L26
        }

        public String toString() {
            return "Experiment(noProductInfo=" + this.noProductInfo + ", isNewProductUI=" + this.isNewProductUI + ", newPadding=" + this.newPadding + ", hideVideoTime=" + this.hideVideoTime + ", hideVideoDesc=" + this.hideVideoDesc + ", uiCompact=" + this.uiCompact + ", coinLabelStyle=" + this.coinLabelStyle + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final int getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final boolean getHideVideoDesc() {
            return this.hideVideoDesc;
        }

        public final boolean getHideVideoTime() {
            return this.hideVideoTime;
        }

        public final boolean getNewPadding() {
            return this.newPadding;
        }

        public final boolean getNoProductInfo() {
            return this.noProductInfo;
        }

        public final boolean getUiCompact() {
            return this.uiCompact;
        }

        public final boolean isNewProductUI() {
            return this.isNewProductUI;
        }

        public Experiment(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, Double r8) {
            this.noProductInfo = r1;
            this.isNewProductUI = r2;
            this.newPadding = r3;
            this.hideVideoTime = r4;
            this.hideVideoDesc = r5;
            this.uiCompact = r6;
            this.coinLabelStyle = r7;
            this.appendHeight = r8;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;", "", "taskExpGroup", "", "(Ljava/lang/String;)V", "getTaskExpGroup", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTExperiment {
        private final String taskExpGroup;

        public static /* synthetic */ TTExperiment copy$default(TTExperiment r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.taskExpGroup;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.taskExpGroup;
        }

        public final TTExperiment copy(String r2) {
            return new TTExperiment(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof TTExperiment) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.taskExpGroup, ((TTExperiment) r2).taskExpGroup) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r0 = this.taskExpGroup;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "TTExperiment(taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public TTExperiment(String r1) {
            this.taskExpGroup = r1;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;", "", "id", "", "seconds", "", "cover", "addr", "addrH265", "width", "height", "accessibilityLabel", "desc", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getAddr", "getAddrH265", "getCover", "getDesc", "getHeight", "()I", "getId", "getSeconds", "getWidth", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Video {
        private final String accessibilityLabel;
        private final String addr;
        private final String addrH265;
        private final String cover;
        private final String desc;
        private final int height;
        private final String id;
        private final int seconds;
        private final int width;

        public final String getAccessibilityLabel() {
            return this.accessibilityLabel;
        }

        public final String getAddr() {
            return this.addr;
        }

        public final String getAddrH265() {
            return this.addrH265;
        }

        public final String getCover() {
            return this.cover;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getHeight() {
            return this.height;
        }

        public final String getId() {
            return this.id;
        }

        public final int getSeconds() {
            return this.seconds;
        }

        public final int getWidth() {
            return this.width;
        }

        public Video(String r2, int r3, String r4, String r5, String r6, int r7, int r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r4, "cover");
            Intrinsics.checkNotNullParameter(r5, "addr");
            Intrinsics.checkNotNullParameter(r6, "addrH265");
            Intrinsics.checkNotNullParameter(r9, "accessibilityLabel");
            Intrinsics.checkNotNullParameter(r10, "desc");
            this.id = r2;
            this.seconds = r3;
            this.cover = r4;
            this.addr = r5;
            this.addrH265 = r6;
            this.width = r7;
            this.height = r8;
            this.accessibilityLabel = r9;
            this.desc = r10;
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

    public final VideoCardData.FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final VideoCardData.Companion.LiveHeader getLiveHeader() {
        return this.liveHeader;
    }

    public final CommonModel$Product getProduct() {
        return this.product;
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

    public final Video getVideo() {
        return this.video;
    }

    public final CommonData.WindVaneEventData getWindVane() {
        return this.windVane;
    }

    public VideoCardModel(CommonModel$Product r2, CommonModel$User r3, Video r4, VideoCardData.Companion.LiveHeader r5, Experiment r6, VideoCardData.FavoriteItemStyle r7, Boolean r8, CommonData.WindVaneEventData r9, CommonData.CoinData r10, ElementStyle r11, TTExperiment r12) {
        Intrinsics.checkNotNullParameter(r2, "product");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "video");
        Intrinsics.checkNotNullParameter(r6, "experiment");
        Intrinsics.checkNotNullParameter(r11, "elementStyle");
        this.product = r2;
        this.user = r3;
        this.video = r4;
        this.liveHeader = r5;
        this.experiment = r6;
        this.itemStyle = r7;
        this.showJustNowUI = r8;
        this.windVane = r9;
        this.coinData = r10;
        this.elementStyle = r11;
        this.ttExperiment = r12;
    }

    public /* synthetic */ VideoCardModel(CommonModel$Product r16, CommonModel$User r17, Video r18, VideoCardData.Companion.LiveHeader r19, Experiment r20, VideoCardData.FavoriteItemStyle r21, Boolean r22, CommonData.WindVaneEventData r23, CommonData.CoinData r24, ElementStyle r25, TTExperiment r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 8) == 0) goto L5;
        VideoCardData.Companion.LiveHeader r7 = null;
    L7:
        if ((r27 & 32) == 0) goto L9;
        VideoCardData.FavoriteItemStyle r9 = null;
    L11:
        if ((r27 & 64) == 0) goto L13;
        Boolean r10 = null;
    L15:
        if ((r27 & 128) == 0) goto L17;
        CommonData.WindVaneEventData r11 = null;
    L19:
        if ((r27 & 256) == 0) goto L21;
        CommonData.CoinData r12 = null;
    L23:
        if ((r27 & 1024) == 0) goto L25;
        TTExperiment r14 = null;
    L26:
        this(r16, r17, r18, r7, r20, r9, r10, r11, r12, r25, r14);
        return;
    L25:
        r14 = r26;
        goto L26
    L21:
        r12 = r24;
        goto L23
    L17:
        r11 = r23;
        goto L19
    L13:
        r10 = r22;
        goto L15
    L9:
        r9 = r21;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }
}
