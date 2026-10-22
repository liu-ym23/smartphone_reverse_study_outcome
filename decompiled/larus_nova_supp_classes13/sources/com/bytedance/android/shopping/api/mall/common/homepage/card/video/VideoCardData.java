package com.bytedance.android.shopping.api.mall.common.homepage.card.video;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECParamsFromClientDTO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\b\u0007\u0018\u0000 S2\u00020\u0001:\u0006STUVWXBõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010'J\b\u0010Q\u001a\u0004\u0018\u00010\u0001J\b\u0010R\u001a\u0004\u0018\u00010\u0013R\u0018\u0010%\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010&\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P¨\u0006Y"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData;", "", "type", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "video", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "liveHeader", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "impression", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "cardCommon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "schema", "", "marketingData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "favoriteVideoCardABValue", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "favoriteVideoCardABValues", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "showJustNowUI", "", "windVaneData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneParams", "elementStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "accessibilityLabel", "btmCD", "(Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Ljava/lang/Object;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;Ljava/lang/String;Ljava/lang/String;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getBtmCD", "getCardCommon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getElementStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "getFavoriteVideoCardABValue", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "getFavoriteVideoCardABValues", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "getImpression", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "getLiveHeader", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "getMarketingData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "getSchema", "getShowJustNowUI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "getVideo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "getWindVaneData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneHaveRcInfo", "getWindVaneParams", "()Ljava/lang/Object;", "carryRCInfoWindVaneParams", "rcPriorityFromProduct", "Companion", "FavoriteItemStyle", "FavoriteVideoCardABValue", "FavoriteVideoCardABValues", "TTFavoriteVideoCardABParam", "Video", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCardData {
    public static final Companion Companion = null;
    private static final String RECOMMEND_INFO = "recommend_info";

    @SerializedName("accessibility_label")
    private final String accessibilityLabel;

    @SerializedName("btm_cd")
    private final String btmCD;

    @SerializedName("card_common")
    private final CommonData.CardCommon cardCommon;

    @SerializedName("gold_coin_info")
    private final CommonData.CoinData coinData;

    @SerializedName("element_style")
    private final CommonData.ElementStyle elementStyle;

    @SerializedName("extra")
    private final CommonData.Extra extra;

    @SerializedName("ab_value")
    private final FavoriteVideoCardABValue favoriteVideoCardABValue;

    @SerializedName("ab_values")
    private final FavoriteVideoCardABValues favoriteVideoCardABValues;

    @SerializedName("impression")
    private final CommonData.Impression impression;

    @SerializedName("item_style")
    private final FavoriteItemStyle itemStyle;

    @SerializedName("live_header")
    private final Companion.LiveHeader liveHeader;

    @SerializedName("marketing_data")
    private final CommonData.MarketingData marketingData;

    @SerializedName("product")
    private final CommonData.Product product;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("show_just_now_ui")
    private final Boolean showJustNowUI;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final CommonData.User user;

    @SerializedName("video")
    private final Video video;

    @SerializedName("wind_vane_data")
    private final CommonData.WindVaneEventData windVaneData;
    private String windVaneHaveRcInfo;

    @SerializedName("wind_vane_params")
    private final Object windVaneParams;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0099\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "", "roomID", "", "secUid", "avatar", "nickName", "liveDesc", "liveIcon", "enterLiveIcon", "schema", "event", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;", "btmCD", "bcmData", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;Ljava/lang/String;Ljava/util/Map;)V", "getAvatar", "()Ljava/lang/String;", "getBcmData", "()Ljava/util/Map;", "getBtmCD", "getEnterLiveIcon", "getEvent", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;", "getLiveDesc", "getLiveIcon", "getNickName", "getRoomID", "getSchema", "getSecUid", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeader {

            @SerializedName("avatar")
            private final String avatar;

            @SerializedName("bcm_data")
            private final Map<String, String> bcmData;

            @SerializedName("btm_cd")
            private final String btmCD;

            @SerializedName("enter_live_icon")
            private final String enterLiveIcon;

            @SerializedName("event")
            private final LiveHeaderEvent event;

            @SerializedName("live_description")
            private final String liveDesc;

            @SerializedName("live_icon")
            private final String liveIcon;

            @SerializedName("nick_name")
            private final String nickName;

            @SerializedName("room_id")
            private final String roomID;

            @SerializedName("schema")
            private final String schema;

            @SerializedName("sec_uid")
            private final String secUid;

            public LiveHeader() {
                this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LiveHeader copy$default(LiveHeader r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, LiveHeaderEvent r21, String r22, Map r23, int r24, Object r25) {
                if ((r24 & 1) == 0) goto L5;
                String r2 = r12.roomID;
            L7:
                if ((r24 & 2) == 0) goto L9;
                String r3 = r12.secUid;
            L11:
                if ((r24 & 4) == 0) goto L13;
                String r4 = r12.avatar;
            L15:
                if ((r24 & 8) == 0) goto L17;
                String r5 = r12.nickName;
            L19:
                if ((r24 & 16) == 0) goto L21;
                String r6 = r12.liveDesc;
            L23:
                if ((r24 & 32) == 0) goto L25;
                String r7 = r12.liveIcon;
            L27:
                if ((r24 & 64) == 0) goto L29;
                String r8 = r12.enterLiveIcon;
            L31:
                if ((r24 & 128) == 0) goto L33;
                String r9 = r12.schema;
            L35:
                if ((r24 & 256) == 0) goto L37;
                LiveHeaderEvent r10 = r12.event;
            L39:
                if ((r24 & 512) == 0) goto L41;
                String r11 = r12.btmCD;
            L43:
                if ((r24 & 1024) == 0) goto L45;
                Map r1 = r12.bcmData;
            L47:
                return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
            L45:
                r1 = r23;
                goto L47
            L41:
                r11 = r22;
                goto L43
            L37:
                r10 = r21;
                goto L39
            L33:
                r9 = r20;
                goto L35
            L29:
                r8 = r19;
                goto L31
            L25:
                r7 = r18;
                goto L27
            L21:
                r6 = r17;
                goto L23
            L17:
                r5 = r16;
                goto L19
            L13:
                r4 = r15;
                goto L15
            L9:
                r3 = r14;
                goto L11
            L5:
                r2 = r13;
                goto L7
            }

            public final String component1() {
                return this.roomID;
            }

            public final String component10() {
                return this.btmCD;
            }

            public final Map<String, String> component11() {
                return this.bcmData;
            }

            public final String component2() {
                return this.secUid;
            }

            public final String component3() {
                return this.avatar;
            }

            public final String component4() {
                return this.nickName;
            }

            public final String component5() {
                return this.liveDesc;
            }

            public final String component6() {
                return this.liveIcon;
            }

            public final String component7() {
                return this.enterLiveIcon;
            }

            public final String component8() {
                return this.schema;
            }

            public final LiveHeaderEvent component9() {
                return this.event;
            }

            public final LiveHeader copy(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, LiveHeaderEvent r22, String r23, Map<String, String> r24) {
                return new LiveHeader(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof LiveHeader) == false) goto L28;
                LiveHeader r4 = (LiveHeader) r3;
                if (Intrinsics.areEqual(this.roomID, r4.roomID) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.liveDesc, r4.liveDesc) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.liveIcon, r4.liveIcon) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.enterLiveIcon, r4.enterLiveIcon) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.event, r4.event) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.btmCD, r4.btmCD) == true) goto L26;
                return false;
            L26:
                if (Intrinsics.areEqual(this.bcmData, r4.bcmData) == true) goto L43;
                return false;
            L43:
                return true;
            L28:
                return false;
            }

            public int hashCode() {
                String r0 = this.roomID;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.secUid;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                String r7 = this.avatar;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                String r10 = this.nickName;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.liveDesc;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                String r16 = this.liveIcon;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                String r19 = this.enterLiveIcon;
                if (r19 == null) goto L29;
                int r20 = r19.hashCode();
            L30:
                int r21 = (r18 + r20) * 31;
                String r22 = this.schema;
                if (r22 == null) goto L33;
                int r23 = r22.hashCode();
            L34:
                int r24 = (r21 + r23) * 31;
                LiveHeaderEvent r25 = this.event;
                if (r25 == null) goto L37;
                int r26 = r25.hashCode();
            L38:
                int r27 = (r24 + r26) * 31;
                String r28 = this.btmCD;
                if (r28 == null) goto L41;
                int r29 = r28.hashCode();
            L42:
                int r30 = (r27 + r29) * 31;
                Map<String, String> r31 = this.bcmData;
                if (r31 == null) goto L46;
                r1 = r31.hashCode();
            L46:
                return r30 + r1;
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
                return "LiveHeader(roomID=" + this.roomID + ", secUid=" + this.secUid + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ", liveDesc=" + this.liveDesc + ", liveIcon=" + this.liveIcon + ", enterLiveIcon=" + this.enterLiveIcon + ", schema=" + this.schema + ", event=" + this.event + ", btmCD=" + this.btmCD + ", bcmData=" + this.bcmData + ")";
            }

            public final String getAvatar() {
                return this.avatar;
            }

            public final Map<String, String> getBcmData() {
                return this.bcmData;
            }

            public final String getBtmCD() {
                return this.btmCD;
            }

            public final String getEnterLiveIcon() {
                return this.enterLiveIcon;
            }

            public final LiveHeaderEvent getEvent() {
                return this.event;
            }

            public final String getLiveDesc() {
                return this.liveDesc;
            }

            public final String getLiveIcon() {
                return this.liveIcon;
            }

            public final String getNickName() {
                return this.nickName;
            }

            public final String getRoomID() {
                return this.roomID;
            }

            public final String getSchema() {
                return this.schema;
            }

            public final String getSecUid() {
                return this.secUid;
            }

            public LiveHeader(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, LiveHeaderEvent r9, String r10, Map<String, String> r11) {
                this.roomID = r1;
                this.secUid = r2;
                this.avatar = r3;
                this.nickName = r4;
                this.liveDesc = r5;
                this.liveIcon = r6;
                this.enterLiveIcon = r7;
                this.schema = r8;
                this.event = r9;
                this.btmCD = r10;
                this.bcmData = r11;
            }

            public /* synthetic */ LiveHeader(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, LiveHeaderEvent r21, String r22, Map r23, int r24, DefaultConstructorMarker r25) {
                Map r2 = null;
                if ((r24 & 1) == 0) goto L5;
                String r1 = null;
            L7:
                if ((r24 & 2) == 0) goto L9;
                String r3 = null;
            L11:
                if ((r24 & 4) == 0) goto L13;
                String r4 = null;
            L15:
                if ((r24 & 8) == 0) goto L17;
                String r5 = null;
            L19:
                if ((r24 & 16) == 0) goto L21;
                String r6 = null;
            L23:
                if ((r24 & 32) == 0) goto L25;
                String r7 = null;
            L27:
                if ((r24 & 64) == 0) goto L29;
                String r8 = null;
            L31:
                if ((r24 & 128) == 0) goto L33;
                String r9 = null;
            L35:
                if ((r24 & 256) == 0) goto L37;
                LiveHeaderEvent r10 = null;
            L39:
                if ((r24 & 512) == 0) goto L41;
                String r11 = null;
            L43:
                if ((r24 & 1024) != 0) goto L46;
                r2 = r23;
            L46:
                this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
                return;
            L41:
                r11 = r22;
                goto L43
            L37:
                r10 = r21;
                goto L39
            L33:
                r9 = r20;
                goto L35
            L29:
                r8 = r19;
                goto L31
            L25:
                r7 = r18;
                goto L27
            L21:
                r6 = r17;
                goto L23
            L17:
                r5 = r16;
                goto L19
            L13:
                r4 = r15;
                goto L15
            L9:
                r3 = r14;
                goto L11
            L5:
                r1 = r13;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEvent;", "", "showEvent", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;", "clickEvent", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;)V", "getClickEvent", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;", "getShowEvent", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeaderEvent {

            @SerializedName("video_live_header_click")
            private final LiveHeaderEventInner clickEvent;

            @SerializedName("video_live_header_show")
            private final LiveHeaderEventInner showEvent;

            public LiveHeaderEvent() {
                LiveHeaderEventInner r0 = null;
                this(r0, r0, 3, r0);
            }

            public static /* synthetic */ LiveHeaderEvent copy$default(LiveHeaderEvent r0, LiveHeaderEventInner r1, LiveHeaderEventInner r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.showEvent;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.clickEvent;
            L9:
                return r0.copy(r1, r2);
            }

            public final LiveHeaderEventInner component1() {
                return this.showEvent;
            }

            public final LiveHeaderEventInner component2() {
                return this.clickEvent;
            }

            public final LiveHeaderEvent copy(LiveHeaderEventInner r2, LiveHeaderEventInner r3) {
                return new LiveHeaderEvent(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof LiveHeaderEvent) == false) goto L10;
                LiveHeaderEvent r4 = (LiveHeaderEvent) r3;
                if (Intrinsics.areEqual(this.showEvent, r4.showEvent) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.clickEvent, r4.clickEvent) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                LiveHeaderEventInner r0 = this.showEvent;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                LiveHeaderEventInner r4 = this.clickEvent;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "LiveHeaderEvent(showEvent=" + this.showEvent + ", clickEvent=" + this.clickEvent + ")";
            }

            public final LiveHeaderEventInner getClickEvent() {
                return this.clickEvent;
            }

            public final LiveHeaderEventInner getShowEvent() {
                return this.showEvent;
            }

            public LiveHeaderEvent(LiveHeaderEventInner r1, LiveHeaderEventInner r2) {
                this.showEvent = r1;
                this.clickEvent = r2;
            }

            public /* synthetic */ LiveHeaderEvent(LiveHeaderEventInner r2, LiveHeaderEventInner r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeaderEventInner;", "", "params", "", "", "paramsFromClient", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECParamsFromClientDTO;", "(Ljava/util/Map;Ljava/util/List;)V", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "getParamsFromClient", "()Ljava/util/List;", "setParamsFromClient", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class LiveHeaderEventInner {

            @SerializedName("params")
            private Map<String, Object> params;

            @SerializedName("params_from_client")
            private List<ECParamsFromClientDTO> paramsFromClient;

            /* JADX WARN: Multi-variable type inference failed */
            public LiveHeaderEventInner() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LiveHeaderEventInner copy$default(LiveHeaderEventInner r0, Map r1, List r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.params;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.paramsFromClient;
            L9:
                return r0.copy(r1, r2);
            }

            public final Map<String, Object> component1() {
                return this.params;
            }

            public final List<ECParamsFromClientDTO> component2() {
                return this.paramsFromClient;
            }

            public final LiveHeaderEventInner copy(Map<String, Object> r2, List<ECParamsFromClientDTO> r3) {
                return new LiveHeaderEventInner(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof LiveHeaderEventInner) == false) goto L10;
                LiveHeaderEventInner r4 = (LiveHeaderEventInner) r3;
                if (Intrinsics.areEqual(this.params, r4.params) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.paramsFromClient, r4.paramsFromClient) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                Map<String, Object> r0 = this.params;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<ECParamsFromClientDTO> r4 = this.paramsFromClient;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "LiveHeaderEventInner(params=" + this.params + ", paramsFromClient=" + this.paramsFromClient + ")";
            }

            public final Map<String, Object> getParams() {
                return this.params;
            }

            public final List<ECParamsFromClientDTO> getParamsFromClient() {
                return this.paramsFromClient;
            }

            public final void setParams(Map<String, Object> r1) {
                this.params = r1;
            }

            public final void setParamsFromClient(List<ECParamsFromClientDTO> r1) {
                this.paramsFromClient = r1;
            }

            public LiveHeaderEventInner(Map<String, Object> r1, List<ECParamsFromClientDTO> r2) {
                this.params = r1;
                this.paramsFromClient = r2;
            }

            public /* synthetic */ LiveHeaderEventInner(Map r2, List r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        public Companion() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "", "itemCornerRadius", "", "itemThemeColor", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getItemCornerRadius", "()Ljava/lang/Double;", "setItemCornerRadius", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getItemThemeColor", "()Ljava/lang/String;", "setItemThemeColor", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteItemStyle {

        @SerializedName("item_corner_radius")
        private Double itemCornerRadius;

        @SerializedName("item_theme_color")
        private String itemThemeColor;

        /* JADX WARN: Multi-variable type inference failed */
        public FavoriteItemStyle() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FavoriteItemStyle copy$default(FavoriteItemStyle r0, Double r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.itemCornerRadius;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.itemThemeColor;
        L9:
            return r0.copy(r1, r2);
        }

        public final Double component1() {
            return this.itemCornerRadius;
        }

        public final String component2() {
            return this.itemThemeColor;
        }

        public final FavoriteItemStyle copy(Double r2, String r3) {
            return new FavoriteItemStyle(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof FavoriteItemStyle) == false) goto L10;
            FavoriteItemStyle r4 = (FavoriteItemStyle) r3;
            if (Intrinsics.areEqual(this.itemCornerRadius, r4.itemCornerRadius) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.itemThemeColor, r4.itemThemeColor) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Double r0 = this.itemCornerRadius;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.itemThemeColor;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "FavoriteItemStyle(itemCornerRadius=" + this.itemCornerRadius + ", itemThemeColor=" + this.itemThemeColor + ")";
        }

        public final Double getItemCornerRadius() {
            return this.itemCornerRadius;
        }

        public final String getItemThemeColor() {
            return this.itemThemeColor;
        }

        public final void setItemCornerRadius(Double r1) {
            this.itemCornerRadius = r1;
        }

        public final void setItemThemeColor(String r1) {
            this.itemThemeColor = r1;
        }

        public FavoriteItemStyle(Double r1, String r2) {
            this.itemCornerRadius = r1;
            this.itemThemeColor = r2;
        }

        public /* synthetic */ FavoriteItemStyle(Double r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "", "feedUIStyle", "", "feedCardScale", "", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "getFeedCardScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeedUIStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValue;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteVideoCardABValue {

        @SerializedName("feed_card_scale")
        private final Float feedCardScale;

        @SerializedName("feed_ui_style")
        private final Integer feedUIStyle;

        /* JADX WARN: Multi-variable type inference failed */
        public FavoriteVideoCardABValue() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FavoriteVideoCardABValue copy$default(FavoriteVideoCardABValue r0, Integer r1, Float r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.feedUIStyle;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.feedCardScale;
        L9:
            return r0.copy(r1, r2);
        }

        public final Integer component1() {
            return this.feedUIStyle;
        }

        public final Float component2() {
            return this.feedCardScale;
        }

        public final FavoriteVideoCardABValue copy(Integer r2, Float r3) {
            return new FavoriteVideoCardABValue(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof FavoriteVideoCardABValue) == false) goto L10;
            FavoriteVideoCardABValue r4 = (FavoriteVideoCardABValue) r3;
            if (Intrinsics.areEqual(this.feedUIStyle, r4.feedUIStyle) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.feedCardScale, r4.feedCardScale) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.feedUIStyle;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Float r4 = this.feedCardScale;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "FavoriteVideoCardABValue(feedUIStyle=" + this.feedUIStyle + ", feedCardScale=" + this.feedCardScale + ")";
        }

        public final Float getFeedCardScale() {
            return this.feedCardScale;
        }

        public final Integer getFeedUIStyle() {
            return this.feedUIStyle;
        }

        public FavoriteVideoCardABValue(Integer r1, Float r2) {
            this.feedUIStyle = r1;
            this.feedCardScale = r2;
        }

        public /* synthetic */ FavoriteVideoCardABValue(Integer r2, Float r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010$\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0012Jz\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\nHÖ\u0001J\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000100J\t\u00101\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u000b\u0010\u0018R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "", "newPadding", "", "hideVideoTime", "hideVideoDesc", "useSameHeight", "", "uiCompact", "coinLabelStyle", "", "isEnlarge", "ttABParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "appendHeight", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHideVideoDesc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHideVideoTime", "getNewPadding", "getTtABParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "getUiCompact", "getUseSameHeight", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Double;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteVideoCardABValues;", "equals", "other", "hashCode", "toMap", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteVideoCardABValues {

        @SerializedName("live_video_height_v2_append")
        private final Double appendHeight;

        @SerializedName("coin_label_style")
        private final Integer coinLabelStyle;

        @SerializedName("hide_video_desc")
        private final Boolean hideVideoDesc;

        @SerializedName("hide_video_time")
        private final Boolean hideVideoTime;

        @SerializedName("video_card_enlarge_play_area")
        private final Boolean isEnlarge;

        @SerializedName("new_padding")
        private final Boolean newPadding;

        @SerializedName("toutiao_ab_param")
        private final LiveCardData.TTFavoriteLiveCardABParam ttABParam;

        @SerializedName("is_ui_compact")
        private final Boolean uiCompact;

        @SerializedName("use_same_height")
        private final String useSameHeight;

        public FavoriteVideoCardABValues() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ FavoriteVideoCardABValues copy$default(FavoriteVideoCardABValues r10, Boolean r11, Boolean r12, Boolean r13, String r14, Boolean r15, Integer r16, Boolean r17, LiveCardData.TTFavoriteLiveCardABParam r18, Double r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            Boolean r2 = r10.newPadding;
        L7:
            if ((r20 & 2) == 0) goto L9;
            Boolean r3 = r10.hideVideoTime;
        L11:
            if ((r20 & 4) == 0) goto L13;
            Boolean r4 = r10.hideVideoDesc;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = r10.useSameHeight;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Boolean r6 = r10.uiCompact;
        L23:
            if ((r20 & 32) == 0) goto L25;
            Integer r7 = r10.coinLabelStyle;
        L27:
            if ((r20 & 64) == 0) goto L29;
            Boolean r8 = r10.isEnlarge;
        L31:
            if ((r20 & 128) == 0) goto L33;
            LiveCardData.TTFavoriteLiveCardABParam r9 = r10.ttABParam;
        L35:
            if ((r20 & 256) == 0) goto L37;
            Double r1 = r10.appendHeight;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final Boolean component1() {
            return this.newPadding;
        }

        public final Boolean component2() {
            return this.hideVideoTime;
        }

        public final Boolean component3() {
            return this.hideVideoDesc;
        }

        public final String component4() {
            return this.useSameHeight;
        }

        public final Boolean component5() {
            return this.uiCompact;
        }

        public final Integer component6() {
            return this.coinLabelStyle;
        }

        public final Boolean component7() {
            return this.isEnlarge;
        }

        public final LiveCardData.TTFavoriteLiveCardABParam component8() {
            return this.ttABParam;
        }

        public final Double component9() {
            return this.appendHeight;
        }

        public final FavoriteVideoCardABValues copy(Boolean r12, Boolean r13, Boolean r14, String r15, Boolean r16, Integer r17, Boolean r18, LiveCardData.TTFavoriteLiveCardABParam r19, Double r20) {
            return new FavoriteVideoCardABValues(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof FavoriteVideoCardABValues) == false) goto L24;
            FavoriteVideoCardABValues r4 = (FavoriteVideoCardABValues) r3;
            if (Intrinsics.areEqual(this.newPadding, r4.newPadding) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.hideVideoTime, r4.hideVideoTime) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.hideVideoDesc, r4.hideVideoDesc) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.useSameHeight, r4.useSameHeight) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.uiCompact, r4.uiCompact) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.coinLabelStyle, r4.coinLabelStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.isEnlarge, r4.isEnlarge) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.ttABParam, r4.ttABParam) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.appendHeight, r4.appendHeight) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            Boolean r0 = this.newPadding;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.hideVideoTime;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Boolean r7 = this.hideVideoDesc;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.useSameHeight;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Boolean r13 = this.uiCompact;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.coinLabelStyle;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            Boolean r19 = this.isEnlarge;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            LiveCardData.TTFavoriteLiveCardABParam r22 = this.ttABParam;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            Double r25 = this.appendHeight;
            if (r25 == null) goto L38;
            r1 = r25.hashCode();
        L38:
            return r24 + r1;
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

        public final Map<String, Object> toMap() {
            Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("new_padding", this.newPadding), TuplesKt.to("is_ui_compact", this.uiCompact), TuplesKt.to("use_same_height", this.useSameHeight)});
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator r2 = r0.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            Map.Entry r4 = (Map.Entry) r2.next();
            if (r4.getValue() == null) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L4;
            r1.put(r4.getKey(), r4.getValue());
            goto L4
        L8:
            r5 = false;
            goto L9
        L11:
            return r1;
        }

        public String toString() {
            return "FavoriteVideoCardABValues(newPadding=" + this.newPadding + ", hideVideoTime=" + this.hideVideoTime + ", hideVideoDesc=" + this.hideVideoDesc + ", useSameHeight=" + this.useSameHeight + ", uiCompact=" + this.uiCompact + ", coinLabelStyle=" + this.coinLabelStyle + ", isEnlarge=" + this.isEnlarge + ", ttABParam=" + this.ttABParam + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final Boolean getHideVideoDesc() {
            return this.hideVideoDesc;
        }

        public final Boolean getHideVideoTime() {
            return this.hideVideoTime;
        }

        public final Boolean getNewPadding() {
            return this.newPadding;
        }

        public final LiveCardData.TTFavoriteLiveCardABParam getTtABParam() {
            return this.ttABParam;
        }

        public final Boolean getUiCompact() {
            return this.uiCompact;
        }

        public final String getUseSameHeight() {
            return this.useSameHeight;
        }

        public final Boolean isEnlarge() {
            return this.isEnlarge;
        }

        public FavoriteVideoCardABValues(Boolean r1, Boolean r2, Boolean r3, String r4, Boolean r5, Integer r6, Boolean r7, LiveCardData.TTFavoriteLiveCardABParam r8, Double r9) {
            this.newPadding = r1;
            this.hideVideoTime = r2;
            this.hideVideoDesc = r3;
            this.useSameHeight = r4;
            this.uiCompact = r5;
            this.coinLabelStyle = r6;
            this.isEnlarge = r7;
            this.ttABParam = r8;
            this.appendHeight = r9;
        }

        public /* synthetic */ FavoriteVideoCardABValues(Boolean r11, Boolean r12, Boolean r13, String r14, Boolean r15, Integer r16, Boolean r17, LiveCardData.TTFavoriteLiveCardABParam r18, Double r19, int r20, DefaultConstructorMarker r21) {
            if ((r20 & 1) == 0) goto L5;
            Boolean r1 = Boolean.FALSE;
        L7:
            if ((r20 & 2) == 0) goto L9;
            Boolean r2 = Boolean.FALSE;
        L11:
            if ((r20 & 4) == 0) goto L13;
            Boolean r3 = Boolean.FALSE;
        L14:
            Double r5 = null;
            if ((r20 & 8) == 0) goto L17;
            String r4 = null;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Boolean r6 = Boolean.FALSE;
        L23:
            if ((r20 & 32) == 0) goto L25;
            Integer r7 = null;
        L27:
            if ((r20 & 64) == 0) goto L29;
            Boolean r8 = Boolean.FALSE;
        L31:
            if ((r20 & 128) == 0) goto L33;
            LiveCardData.TTFavoriteLiveCardABParam r9 = null;
        L35:
            if ((r20 & 256) != 0) goto L38;
            r5 = r19;
        L38:
            this(r1, r2, r3, r4, r6, r7, r8, r9, r5);
            return;
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r4 = r14;
            goto L19
        L13:
            r3 = r13;
            goto L14
        L9:
            r2 = r12;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$TTFavoriteVideoCardABParam;", "", "taskExpGroup", "", "(Ljava/lang/String;)V", "getTaskExpGroup", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTFavoriteVideoCardABParam {

        @SerializedName("task_tab_show_exp_group")
        private final String taskExpGroup;

        public TTFavoriteVideoCardABParam() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ TTFavoriteVideoCardABParam copy$default(TTFavoriteVideoCardABParam r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.taskExpGroup;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.taskExpGroup;
        }

        public final TTFavoriteVideoCardABParam copy(String r2) {
            return new TTFavoriteVideoCardABParam(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof TTFavoriteVideoCardABParam) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.taskExpGroup, ((TTFavoriteVideoCardABParam) r2).taskExpGroup) == true) goto L13;
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
            return "TTFavoriteVideoCardABParam(taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public TTFavoriteVideoCardABParam(String r1) {
            this.taskExpGroup = r1;
        }

        public /* synthetic */ TTFavoriteVideoCardABParam(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001:\u0003*+,BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "", "id", "", "itemId", "seconds", "", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "addr", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "addrH265", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "desc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;Ljava/lang/String;)V", "getAddr", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "getAddrH265", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "getDesc", "()Ljava/lang/String;", "getId", "getItemId", "getSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video;", "equals", "", "other", "hashCode", "toString", "Addr", "AddrH265", "Cover", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Video {

        @SerializedName("addr")
        private final Addr addr;

        @SerializedName("addr_h265")
        private final AddrH265 addrH265;

        @SerializedName("cover")
        private final Cover cover;

        @SerializedName("desc")
        private final String desc;

        @SerializedName("id")
        private final String id;

        @SerializedName(PdpOpenThirdParam.KEY_ITEM_ID)
        private final String itemId;

        @SerializedName("seconds")
        private final Integer seconds;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jv\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "", "uri", "", "urlList", "", "width", "", "height", "urlKey", "dataSize", "fileHash", "fileCs", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDataSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileCs", "()Ljava/lang/String;", "getFileHash", "getHeight", "getUri", "getUrlKey", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Addr;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Addr {

            @SerializedName("data_size")
            private final Integer dataSize;

            @SerializedName("file_cs")
            private final String fileCs;

            @SerializedName("file_hash")
            private final String fileHash;

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_key")
            private final String urlKey;

            @SerializedName("url_list")
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Addr() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Addr copy$default(Addr r9, String r10, List r11, Integer r12, Integer r13, String r14, Integer r15, String r16, String r17, int r18, Object r19) {
                if ((r18 & 1) == 0) goto L5;
                String r2 = r9.uri;
            L7:
                if ((r18 & 2) == 0) goto L9;
                List r3 = r9.urlList;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Integer r4 = r9.width;
            L15:
                if ((r18 & 8) == 0) goto L17;
                Integer r5 = r9.height;
            L19:
                if ((r18 & 16) == 0) goto L21;
                String r6 = r9.urlKey;
            L23:
                if ((r18 & 32) == 0) goto L25;
                Integer r7 = r9.dataSize;
            L27:
                if ((r18 & 64) == 0) goto L29;
                String r8 = r9.fileHash;
            L31:
                if ((r18 & 128) == 0) goto L33;
                String r1 = r9.fileCs;
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

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final String component5() {
                return this.urlKey;
            }

            public final Integer component6() {
                return this.dataSize;
            }

            public final String component7() {
                return this.fileHash;
            }

            public final String component8() {
                return this.fileCs;
            }

            public final Addr copy(String r11, List<String> r12, Integer r13, Integer r14, String r15, Integer r16, String r17, String r18) {
                return new Addr(r11, r12, r13, r14, r15, r16, r17, r18);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Addr) == false) goto L22;
                Addr r4 = (Addr) r3;
                if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.urlKey, r4.urlKey) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.dataSize, r4.dataSize) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.fileHash, r4.fileHash) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.fileCs, r4.fileCs) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
                return false;
            }

            public int hashCode() {
                String r0 = this.uri;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<String> r4 = this.urlList;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.width;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.height;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.urlKey;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                Integer r16 = this.dataSize;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                String r19 = this.fileHash;
                if (r19 == null) goto L29;
                int r20 = r19.hashCode();
            L30:
                int r21 = (r18 + r20) * 31;
                String r22 = this.fileCs;
                if (r22 == null) goto L34;
                r1 = r22.hashCode();
            L34:
                return r21 + r1;
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
                return "Addr(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ", urlKey=" + this.urlKey + ", dataSize=" + this.dataSize + ", fileHash=" + this.fileHash + ", fileCs=" + this.fileCs + ")";
            }

            public final Integer getDataSize() {
                return this.dataSize;
            }

            public final String getFileCs() {
                return this.fileCs;
            }

            public final String getFileHash() {
                return this.fileHash;
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final String getUrlKey() {
                return this.urlKey;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Addr(String r1, List<String> r2, Integer r3, Integer r4, String r5, Integer r6, String r7, String r8) {
                this.uri = r1;
                this.urlList = r2;
                this.width = r3;
                this.height = r4;
                this.urlKey = r5;
                this.dataSize = r6;
                this.fileHash = r7;
                this.fileCs = r8;
            }

            public /* synthetic */ Addr(String r10, List r11, Integer r12, Integer r13, String r14, Integer r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
                String r2 = null;
                if ((r18 & 1) == 0) goto L5;
                String r1 = null;
            L7:
                if ((r18 & 2) == 0) goto L9;
                List r3 = null;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Integer r4 = null;
            L15:
                if ((r18 & 8) == 0) goto L17;
                Integer r5 = null;
            L19:
                if ((r18 & 16) == 0) goto L21;
                String r6 = null;
            L23:
                if ((r18 & 32) == 0) goto L25;
                Integer r7 = null;
            L27:
                if ((r18 & 64) == 0) goto L29;
                String r8 = null;
            L31:
                if ((r18 & 128) != 0) goto L34;
                r2 = r17;
            L34:
                this(r1, r3, r4, r5, r6, r7, r8, r2);
                return;
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
                r1 = r10;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jv\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "", "uri", "", "urlList", "", "width", "", "height", "urlKey", "dataSize", "fileHash", "fileCs", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDataSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileCs", "()Ljava/lang/String;", "getFileHash", "getHeight", "getUri", "getUrlKey", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$AddrH265;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class AddrH265 {

            @SerializedName("data_size")
            private final Integer dataSize;

            @SerializedName("file_cs")
            private final String fileCs;

            @SerializedName("file_hash")
            private final String fileHash;

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_key")
            private final String urlKey;

            @SerializedName("url_list")
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public AddrH265() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ AddrH265 copy$default(AddrH265 r9, String r10, List r11, Integer r12, Integer r13, String r14, Integer r15, String r16, String r17, int r18, Object r19) {
                if ((r18 & 1) == 0) goto L5;
                String r2 = r9.uri;
            L7:
                if ((r18 & 2) == 0) goto L9;
                List r3 = r9.urlList;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Integer r4 = r9.width;
            L15:
                if ((r18 & 8) == 0) goto L17;
                Integer r5 = r9.height;
            L19:
                if ((r18 & 16) == 0) goto L21;
                String r6 = r9.urlKey;
            L23:
                if ((r18 & 32) == 0) goto L25;
                Integer r7 = r9.dataSize;
            L27:
                if ((r18 & 64) == 0) goto L29;
                String r8 = r9.fileHash;
            L31:
                if ((r18 & 128) == 0) goto L33;
                String r1 = r9.fileCs;
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

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final String component5() {
                return this.urlKey;
            }

            public final Integer component6() {
                return this.dataSize;
            }

            public final String component7() {
                return this.fileHash;
            }

            public final String component8() {
                return this.fileCs;
            }

            public final AddrH265 copy(String r11, List<String> r12, Integer r13, Integer r14, String r15, Integer r16, String r17, String r18) {
                return new AddrH265(r11, r12, r13, r14, r15, r16, r17, r18);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof AddrH265) == false) goto L22;
                AddrH265 r4 = (AddrH265) r3;
                if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.urlKey, r4.urlKey) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.dataSize, r4.dataSize) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.fileHash, r4.fileHash) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.fileCs, r4.fileCs) == true) goto L34;
                return false;
            L34:
                return true;
            L22:
                return false;
            }

            public int hashCode() {
                String r0 = this.uri;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<String> r4 = this.urlList;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.width;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.height;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                String r13 = this.urlKey;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                Integer r16 = this.dataSize;
                if (r16 == null) goto L25;
                int r17 = r16.hashCode();
            L26:
                int r18 = (r15 + r17) * 31;
                String r19 = this.fileHash;
                if (r19 == null) goto L29;
                int r20 = r19.hashCode();
            L30:
                int r21 = (r18 + r20) * 31;
                String r22 = this.fileCs;
                if (r22 == null) goto L34;
                r1 = r22.hashCode();
            L34:
                return r21 + r1;
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
                return "AddrH265(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ", urlKey=" + this.urlKey + ", dataSize=" + this.dataSize + ", fileHash=" + this.fileHash + ", fileCs=" + this.fileCs + ")";
            }

            public final Integer getDataSize() {
                return this.dataSize;
            }

            public final String getFileCs() {
                return this.fileCs;
            }

            public final String getFileHash() {
                return this.fileHash;
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final String getUrlKey() {
                return this.urlKey;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public AddrH265(String r1, List<String> r2, Integer r3, Integer r4, String r5, Integer r6, String r7, String r8) {
                this.uri = r1;
                this.urlList = r2;
                this.width = r3;
                this.height = r4;
                this.urlKey = r5;
                this.dataSize = r6;
                this.fileHash = r7;
                this.fileCs = r8;
            }

            public /* synthetic */ AddrH265(String r10, List r11, Integer r12, Integer r13, String r14, Integer r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
                String r2 = null;
                if ((r18 & 1) == 0) goto L5;
                String r1 = null;
            L7:
                if ((r18 & 2) == 0) goto L9;
                List r3 = null;
            L11:
                if ((r18 & 4) == 0) goto L13;
                Integer r4 = null;
            L15:
                if ((r18 & 8) == 0) goto L17;
                Integer r5 = null;
            L19:
                if ((r18 & 16) == 0) goto L21;
                String r6 = null;
            L23:
                if ((r18 & 32) == 0) goto L25;
                Integer r7 = null;
            L27:
                if ((r18 & 64) == 0) goto L29;
                String r8 = null;
            L31:
                if ((r18 & 128) != 0) goto L34;
                r2 = r17;
            L34:
                this(r1, r3, r4, r5, r6, r7, r8, r2);
                return;
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
                r1 = r10;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Video$Cover;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Cover {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_list")
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Cover() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Cover copy$default(Cover r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.uri;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.urlList;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.width;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.height;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final String component1() {
                return this.uri;
            }

            public final List<String> component2() {
                return this.urlList;
            }

            public final Integer component3() {
                return this.width;
            }

            public final Integer component4() {
                return this.height;
            }

            public final Cover copy(String r2, List<String> r3, Integer r4, Integer r5) {
                return new Cover(r2, r3, r4, r5);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Cover) == false) goto L14;
                Cover r4 = (Cover) r3;
                if (Intrinsics.areEqual(this.uri, r4.uri) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.urlList, r4.urlList) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.width, r4.width) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.height, r4.height) == true) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            public int hashCode() {
                String r0 = this.uri;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                List<String> r4 = this.urlList;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.width;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.height;
                if (r10 == null) goto L18;
                r1 = r10.hashCode();
            L18:
                return r9 + r1;
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
                return "Cover(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
            }

            public final Integer getHeight() {
                return this.height;
            }

            public final String getUri() {
                return this.uri;
            }

            public final List<String> getUrlList() {
                return this.urlList;
            }

            public final Integer getWidth() {
                return this.width;
            }

            public Cover(String r1, List<String> r2, Integer r3, Integer r4) {
                this.uri = r1;
                this.urlList = r2;
                this.width = r3;
                this.height = r4;
            }

            public /* synthetic */ Cover(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
                if ((r6 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = null;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = null;
            L12:
                if ((r6 & 8) == 0) goto L14;
                r5 = null;
            L14:
                this(r2, r3, r4, r5);
            }
        }

        public Video() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Video copy$default(Video r5, String r6, String r7, Integer r8, Cover r9, Addr r10, AddrH265 r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.id;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.itemId;
        L8:
            String r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.seconds;
        L11:
            Integer r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.cover;
        L14:
            Cover r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.addr;
        L17:
            Addr r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.addrH265;
        L20:
            AddrH265 r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.desc;
        L23:
            String r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.itemId;
        }

        public final Integer component3() {
            return this.seconds;
        }

        public final Cover component4() {
            return this.cover;
        }

        public final Addr component5() {
            return this.addr;
        }

        public final AddrH265 component6() {
            return this.addrH265;
        }

        public final String component7() {
            return this.desc;
        }

        public final Video copy(String r10, String r11, Integer r12, Cover r13, Addr r14, AddrH265 r15, String r16) {
            return new Video(r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Video) == false) goto L20;
            Video r4 = (Video) r3;
            if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.seconds, r4.seconds) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.addr, r4.addr) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.addrH265, r4.addrH265) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.desc, r4.desc) == true) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            String r0 = this.id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.itemId;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.seconds;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Cover r10 = this.cover;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Addr r13 = this.addr;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            AddrH265 r16 = this.addrH265;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.desc;
            if (r19 == null) goto L30;
            r1 = r19.hashCode();
        L30:
            return r18 + r1;
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
            return "Video(id=" + this.id + ", itemId=" + this.itemId + ", seconds=" + this.seconds + ", cover=" + this.cover + ", addr=" + this.addr + ", addrH265=" + this.addrH265 + ", desc=" + this.desc + ")";
        }

        public final Addr getAddr() {
            return this.addr;
        }

        public final AddrH265 getAddrH265() {
            return this.addrH265;
        }

        public final Cover getCover() {
            return this.cover;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getId() {
            return this.id;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final Integer getSeconds() {
            return this.seconds;
        }

        public Video(String r1, String r2, Integer r3, Cover r4, Addr r5, AddrH265 r6, String r7) {
            this.id = r1;
            this.itemId = r2;
            this.seconds = r3;
            this.cover = r4;
            this.addr = r5;
            this.addrH265 = r6;
            this.desc = r7;
        }

        public /* synthetic */ Video(String r7, String r8, Integer r9, Cover r10, Addr r11, AddrH265 r12, String r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L5;
            String r16 = null;
        L7:
            if ((r14 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r14 & 4) == 0) goto L13;
            Integer r2 = null;
        L15:
            if ((r14 & 8) == 0) goto L17;
            Cover r3 = null;
        L19:
            if ((r14 & 16) == 0) goto L21;
            Addr r4 = null;
        L23:
            if ((r14 & 32) == 0) goto L25;
            AddrH265 r5 = null;
        L27:
            if ((r14 & 64) == 0) goto L29;
            String r17 = null;
        L30:
            this(r16, r1, r2, r3, r4, r5, r17);
            return;
        L29:
            r17 = r13;
            goto L30
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r16 = r7;
            goto L7
        }
    }

    static {
        Companion = new Companion();
    }

    public VideoCardData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public final Object carryRCInfoWindVaneParams() {
        String r0 = this.windVaneHaveRcInfo;
        if (r0 == null) goto L5;
        return r0;
    L5:
        CommonData.Extra r1 = this.extra;
        if (r1 == null) goto L12;
        String r2 = r1.getRecommendInfo();
        if (r2 == null) goto L12;
        String r3 = ToolsKt.H(String.valueOf(this.windVaneParams), r2);
        this.windVaneHaveRcInfo = r3;
        return r3;
    L12:
        return String.valueOf(this.windVaneParams);
    }

    public final String rcPriorityFromProduct() {
        CommonData.Product r0 = this.product;
        if (r0 == null) goto L12;
        String r1 = r0.getRecommendInfo();
        if (r1 == null) goto L12;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return r1;
    L9:
        r2 = false;
    L12:
        CommonData.Extra r3 = this.extra;
        if (r3 == null) goto L17;
        String r4 = r3.getRecommendInfo();
        if (r4 == null) goto L19;
        return r4;
    L19:
        return null;
    L17:
        return null;
    }

    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final String getBtmCD() {
        return this.btmCD;
    }

    public final CommonData.CardCommon getCardCommon() {
        return this.cardCommon;
    }

    public final CommonData.CoinData getCoinData() {
        return this.coinData;
    }

    public final CommonData.ElementStyle getElementStyle() {
        return this.elementStyle;
    }

    public final CommonData.Extra getExtra() {
        return this.extra;
    }

    public final FavoriteVideoCardABValue getFavoriteVideoCardABValue() {
        return this.favoriteVideoCardABValue;
    }

    public final FavoriteVideoCardABValues getFavoriteVideoCardABValues() {
        return this.favoriteVideoCardABValues;
    }

    public final CommonData.Impression getImpression() {
        return this.impression;
    }

    public final FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final Companion.LiveHeader getLiveHeader() {
        return this.liveHeader;
    }

    public final CommonData.MarketingData getMarketingData() {
        return this.marketingData;
    }

    public final CommonData.Product getProduct() {
        return this.product;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Boolean getShowJustNowUI() {
        return this.showJustNowUI;
    }

    public final Integer getType() {
        return this.type;
    }

    public final CommonData.User getUser() {
        return this.user;
    }

    public final Video getVideo() {
        return this.video;
    }

    public final CommonData.WindVaneEventData getWindVaneData() {
        return this.windVaneData;
    }

    public final Object getWindVaneParams() {
        return this.windVaneParams;
    }

    public VideoCardData(Integer r3, CommonData.Product r4, CommonData.User r5, Video r6, Companion.LiveHeader r7, CommonData.Impression r8, CommonData.CardCommon r9, CommonData.Extra r10, String r11, CommonData.MarketingData r12, CommonData.CoinData r13, FavoriteVideoCardABValue r14, FavoriteVideoCardABValues r15, FavoriteItemStyle r16, Boolean r17, CommonData.WindVaneEventData r18, Object r19, CommonData.ElementStyle r20, String r21, String r22) {
        this.type = r3;
        this.product = r4;
        this.user = r5;
        this.video = r6;
        this.liveHeader = r7;
        this.impression = r8;
        this.cardCommon = r9;
        this.extra = r10;
        this.schema = r11;
        this.marketingData = r12;
        this.coinData = r13;
        this.favoriteVideoCardABValue = r14;
        this.favoriteVideoCardABValues = r15;
        this.itemStyle = r16;
        this.showJustNowUI = r17;
        this.windVaneData = r18;
        this.windVaneParams = r19;
        this.elementStyle = r20;
        this.accessibilityLabel = r21;
        this.btmCD = r22;
    }

    public /* synthetic */ VideoCardData(Integer r22, CommonData.Product r23, CommonData.User r24, Video r25, Companion.LiveHeader r26, CommonData.Impression r27, CommonData.CardCommon r28, CommonData.Extra r29, String r30, CommonData.MarketingData r31, CommonData.CoinData r32, FavoriteVideoCardABValue r33, FavoriteVideoCardABValues r34, FavoriteItemStyle r35, Boolean r36, CommonData.WindVaneEventData r37, Object r38, CommonData.ElementStyle r39, String r40, String r41, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r42 & 2) == 0) goto L9;
        CommonData.Product r3 = null;
    L11:
        if ((r42 & 4) == 0) goto L13;
        CommonData.User r4 = null;
    L15:
        if ((r42 & 8) == 0) goto L17;
        Video r5 = null;
    L19:
        if ((r42 & 16) == 0) goto L21;
        Companion.LiveHeader r6 = null;
    L23:
        if ((r42 & 32) == 0) goto L25;
        CommonData.Impression r7 = null;
    L27:
        if ((r42 & 64) == 0) goto L29;
        CommonData.CardCommon r8 = null;
    L31:
        if ((r42 & 128) == 0) goto L33;
        CommonData.Extra r9 = null;
    L35:
        if ((r42 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r42 & 512) == 0) goto L41;
        CommonData.MarketingData r11 = null;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        CommonData.CoinData r12 = null;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        FavoriteVideoCardABValue r13 = null;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        FavoriteVideoCardABValues r14 = null;
    L55:
        if ((r42 & 8192) == 0) goto L57;
        FavoriteItemStyle r15 = null;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        Boolean r2 = null;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        CommonData.WindVaneEventData r16 = null;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        Object r17 = null;
    L71:
        if ((r42 & 131072) == 0) goto L73;
        CommonData.ElementStyle r18 = null;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r42 & 524288) == 0) goto L81;
        String r0 = null;
    L82:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r0);
        return;
    L81:
        r0 = r41;
        goto L82
    L77:
        r19 = r40;
        goto L79
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r2 = r36;
        goto L63
    L57:
        r15 = r35;
        goto L59
    L53:
        r14 = r34;
        goto L55
    L49:
        r13 = r33;
        goto L51
    L45:
        r12 = r32;
        goto L47
    L41:
        r11 = r31;
        goto L43
    L37:
        r10 = r30;
        goto L39
    L33:
        r9 = r29;
        goto L35
    L29:
        r8 = r28;
        goto L31
    L25:
        r7 = r27;
        goto L27
    L21:
        r6 = r26;
        goto L23
    L17:
        r5 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }
}
