package com.bytedance.android.shopping.api.mall.common.homepage.card.live;

import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b>\b\u0007\u0018\u00002\u00020\u0001:\u0005cdefgBÕ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010/J\b\u0010a\u001a\u0004\u0018\u00010\u0001J\b\u0010b\u001a\u0004\u0018\u00010\u0013R\u0018\u0010-\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010+\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u0010.\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0018\u0010,\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u001a\u0010'\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b;\u00106R\u0018\u0010)\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b\u0018\u00106R\u0018\u0010&\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u00101R\u0018\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\"\u0010(\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bL\u00106\"\u0004\bM\u0010NR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bO\u00106R\u0018\u0010!\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00101R\u001a\u0010\"\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bT\u00106R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010Y\u001a\u0004\bW\u0010XR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0010\u0010^\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`¨\u0006h"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData;", "", "type", "", "live", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "store", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;", "impression", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "cardCommon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "schema", "", "marketIngData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "isAd", "", "favoriteLiveCardABValue", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "favoriteLiveCardABValues", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "needShowAdTagUI", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "playIcon", "showJustNowUI", "windVaneData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneParams", "isInstantRecCard", "disableVane", "needAnimation", "elementStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "btmCD", "descIcon", "accessibilityLabel", "cardMute", "(Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getBtmCD", "getCardCommon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CardCommon;", "getCardMute", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getDescIcon", "getDisableVane", "getElementStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Extra;", "getFavoriteLiveCardABValue", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "getFavoriteLiveCardABValues", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "getImpression", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Impression;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "getLive", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "getMarketIngData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "getNeedAnimation", "setNeedAnimation", "(Ljava/lang/Boolean;)V", "getNeedShowAdTagUI", "getPlayIcon", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Product;", "getSchema", "getShowJustNowUI", "getStore", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$Store;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$User;", "getWindVaneData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "windVaneHaveRcInfo", "getWindVaneParams", "()Ljava/lang/Object;", "carryRCInfoWindVaneParams", "rcPriorityFromProduct", "FavoriteItemStyle", "FavoriteLiveCardABValue", "FavoriteLiveCardABValues", "Live", "TTFavoriteLiveCardABParam", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCardData {

    @SerializedName("accessibility_label")
    private final String accessibilityLabel;

    @SerializedName("btm_cd")
    private final String btmCD;

    @SerializedName("card_common")
    private final CommonData.CardCommon cardCommon;

    @SerializedName("card_mute")
    private final Boolean cardMute;

    @SerializedName("gold_coin_info")
    private final CommonData.CoinData coinData;

    @SerializedName("desc_icon")
    private final String descIcon;

    @SerializedName("disable_vane")
    private final Boolean disableVane;

    @SerializedName("element_style")
    private final CommonData.ElementStyle elementStyle;

    @SerializedName("extra")
    private final CommonData.Extra extra;

    @SerializedName("ab_value")
    private final FavoriteLiveCardABValue favoriteLiveCardABValue;

    @SerializedName("ab_values")
    private final FavoriteLiveCardABValues favoriteLiveCardABValues;

    @SerializedName("impression")
    private final CommonData.Impression impression;

    @SerializedName("is_ad")
    private final Boolean isAd;

    @SerializedName("is_instant_rec_card")
    private final String isInstantRecCard;

    @SerializedName("item_style")
    private final FavoriteItemStyle itemStyle;

    @SerializedName("live")
    private final Live live;

    @SerializedName("marketing_data")
    private final CommonData.MarketingData marketIngData;

    @SerializedName("need_animation")
    private Boolean needAnimation;

    @SerializedName("need_show_ad_tag_ui")
    private final Boolean needShowAdTagUI;

    @SerializedName("play_icon")
    private final String playIcon;

    @SerializedName("product")
    private final CommonData.Product product;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("show_just_now_ui")
    private final Boolean showJustNowUI;

    @SerializedName("store")
    private final CommonData.Store store;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("user")
    private final CommonData.User user;

    @SerializedName("wind_vane_data")
    private final CommonData.WindVaneEventData windVaneData;
    private String windVaneHaveRcInfo;

    @SerializedName("wind_vane_params")
    private final Object windVaneParams;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "", "itemCornerRadius", "", "itemThemeColor", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getItemCornerRadius", "()Ljava/lang/Double;", "setItemCornerRadius", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getItemThemeColor", "()Ljava/lang/String;", "setItemThemeColor", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "", "feedUIStyle", "", "feedCardScale", "", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "getFeedCardScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeedUIStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValue;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteLiveCardABValue {

        @SerializedName("feed_card_scale")
        private final Float feedCardScale;

        @SerializedName("feed_ui_style")
        private final Integer feedUIStyle;

        /* JADX WARN: Multi-variable type inference failed */
        public FavoriteLiveCardABValue() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FavoriteLiveCardABValue copy$default(FavoriteLiveCardABValue r0, Integer r1, Float r2, int r3, Object r4) {
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

        public final FavoriteLiveCardABValue copy(Integer r2, Float r3) {
            return new FavoriteLiveCardABValue(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof FavoriteLiveCardABValue) == false) goto L10;
            FavoriteLiveCardABValue r4 = (FavoriteLiveCardABValue) r3;
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
            return "FavoriteLiveCardABValue(feedUIStyle=" + this.feedUIStyle + ", feedCardScale=" + this.feedCardScale + ")";
        }

        public final Float getFeedCardScale() {
            return this.feedCardScale;
        }

        public final Integer getFeedUIStyle() {
            return this.feedUIStyle;
        }

        public FavoriteLiveCardABValue(Integer r1, Float r2) {
            this.feedUIStyle = r1;
            this.feedCardScale = r2;
        }

        public /* synthetic */ FavoriteLiveCardABValue(Integer r2, Float r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b#\n\u0002\u0010$\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0086\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000bHÖ\u0001J\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000104J\t\u00105\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "", "newPadding", "", "highValue", "uiCompact", "useSameHeight", "", "liveCardChangeCover", "liveCardEnlargePlayArea", "coinLabelStyle", "", "ttABParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "showPeopleNewIcon", "appendHeight", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Boolean;Ljava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHighValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLiveCardChangeCover", "getLiveCardEnlargePlayArea", "getNewPadding", "getShowPeopleNewIcon", "getTtABParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "getUiCompact", "getUseSameHeight", "()Ljava/lang/String;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;Ljava/lang/Boolean;Ljava/lang/Double;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteLiveCardABValues;", "equals", "other", "hashCode", "toMap", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FavoriteLiveCardABValues {

        @SerializedName("live_video_height_v2_append")
        private final Double appendHeight;

        @SerializedName("coin_label_style")
        private final Integer coinLabelStyle;

        @SerializedName("high_value")
        private final Boolean highValue;

        @SerializedName("live_card_change_cover")
        private final Boolean liveCardChangeCover;

        @SerializedName("live_card_enlarge_play_area")
        private final Boolean liveCardEnlargePlayArea;

        @SerializedName("new_padding")
        private final Boolean newPadding;

        @SerializedName("live_card_show_people_new_icon")
        private final Boolean showPeopleNewIcon;

        @SerializedName("toutiao_ab_param")
        private final TTFavoriteLiveCardABParam ttABParam;

        @SerializedName("is_ui_compact")
        private final Boolean uiCompact;

        @SerializedName("use_same_height")
        private final String useSameHeight;

        public FavoriteLiveCardABValues() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public static /* synthetic */ FavoriteLiveCardABValues copy$default(FavoriteLiveCardABValues r11, Boolean r12, Boolean r13, Boolean r14, String r15, Boolean r16, Boolean r17, Integer r18, TTFavoriteLiveCardABParam r19, Boolean r20, Double r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            Boolean r2 = r11.newPadding;
        L7:
            if ((r22 & 2) == 0) goto L9;
            Boolean r3 = r11.highValue;
        L11:
            if ((r22 & 4) == 0) goto L13;
            Boolean r4 = r11.uiCompact;
        L15:
            if ((r22 & 8) == 0) goto L17;
            String r5 = r11.useSameHeight;
        L19:
            if ((r22 & 16) == 0) goto L21;
            Boolean r6 = r11.liveCardChangeCover;
        L23:
            if ((r22 & 32) == 0) goto L25;
            Boolean r7 = r11.liveCardEnlargePlayArea;
        L27:
            if ((r22 & 64) == 0) goto L29;
            Integer r8 = r11.coinLabelStyle;
        L31:
            if ((r22 & 128) == 0) goto L33;
            TTFavoriteLiveCardABParam r9 = r11.ttABParam;
        L35:
            if ((r22 & 256) == 0) goto L37;
            Boolean r10 = r11.showPeopleNewIcon;
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

        public final Boolean component1() {
            return this.newPadding;
        }

        public final Double component10() {
            return this.appendHeight;
        }

        public final Boolean component2() {
            return this.highValue;
        }

        public final Boolean component3() {
            return this.uiCompact;
        }

        public final String component4() {
            return this.useSameHeight;
        }

        public final Boolean component5() {
            return this.liveCardChangeCover;
        }

        public final Boolean component6() {
            return this.liveCardEnlargePlayArea;
        }

        public final Integer component7() {
            return this.coinLabelStyle;
        }

        public final TTFavoriteLiveCardABParam component8() {
            return this.ttABParam;
        }

        public final Boolean component9() {
            return this.showPeopleNewIcon;
        }

        public final FavoriteLiveCardABValues copy(Boolean r13, Boolean r14, Boolean r15, String r16, Boolean r17, Boolean r18, Integer r19, TTFavoriteLiveCardABParam r20, Boolean r21, Double r22) {
            return new FavoriteLiveCardABValues(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof FavoriteLiveCardABValues) == false) goto L26;
            FavoriteLiveCardABValues r4 = (FavoriteLiveCardABValues) r3;
            if (Intrinsics.areEqual(this.newPadding, r4.newPadding) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.highValue, r4.highValue) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.uiCompact, r4.uiCompact) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.useSameHeight, r4.useSameHeight) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.liveCardChangeCover, r4.liveCardChangeCover) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.liveCardEnlargePlayArea, r4.liveCardEnlargePlayArea) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.coinLabelStyle, r4.coinLabelStyle) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.ttABParam, r4.ttABParam) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.showPeopleNewIcon, r4.showPeopleNewIcon) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.appendHeight, r4.appendHeight) == true) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        public int hashCode() {
            Boolean r0 = this.newPadding;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.highValue;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Boolean r7 = this.uiCompact;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.useSameHeight;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Boolean r13 = this.liveCardChangeCover;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Boolean r16 = this.liveCardEnlargePlayArea;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            Integer r19 = this.coinLabelStyle;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            TTFavoriteLiveCardABParam r22 = this.ttABParam;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            Boolean r25 = this.showPeopleNewIcon;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            Double r28 = this.appendHeight;
            if (r28 == null) goto L42;
            r1 = r28.hashCode();
        L42:
            return r27 + r1;
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

        public final Map<String, Object> toMap() {
            Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("new_padding", this.newPadding), TuplesKt.to("high_value", this.highValue), TuplesKt.to("is_ui_compact", this.uiCompact), TuplesKt.to("use_same_height", this.useSameHeight)});
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
            return "FavoriteLiveCardABValues(newPadding=" + this.newPadding + ", highValue=" + this.highValue + ", uiCompact=" + this.uiCompact + ", useSameHeight=" + this.useSameHeight + ", liveCardChangeCover=" + this.liveCardChangeCover + ", liveCardEnlargePlayArea=" + this.liveCardEnlargePlayArea + ", coinLabelStyle=" + this.coinLabelStyle + ", ttABParam=" + this.ttABParam + ", showPeopleNewIcon=" + this.showPeopleNewIcon + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final Integer getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final Boolean getHighValue() {
            return this.highValue;
        }

        public final Boolean getLiveCardChangeCover() {
            return this.liveCardChangeCover;
        }

        public final Boolean getLiveCardEnlargePlayArea() {
            return this.liveCardEnlargePlayArea;
        }

        public final Boolean getNewPadding() {
            return this.newPadding;
        }

        public final Boolean getShowPeopleNewIcon() {
            return this.showPeopleNewIcon;
        }

        public final TTFavoriteLiveCardABParam getTtABParam() {
            return this.ttABParam;
        }

        public final Boolean getUiCompact() {
            return this.uiCompact;
        }

        public final String getUseSameHeight() {
            return this.useSameHeight;
        }

        public FavoriteLiveCardABValues(Boolean r1, Boolean r2, Boolean r3, String r4, Boolean r5, Boolean r6, Integer r7, TTFavoriteLiveCardABParam r8, Boolean r9, Double r10) {
            this.newPadding = r1;
            this.highValue = r2;
            this.uiCompact = r3;
            this.useSameHeight = r4;
            this.liveCardChangeCover = r5;
            this.liveCardEnlargePlayArea = r6;
            this.coinLabelStyle = r7;
            this.ttABParam = r8;
            this.showPeopleNewIcon = r9;
            this.appendHeight = r10;
        }

        public /* synthetic */ FavoriteLiveCardABValues(Boolean r12, Boolean r13, Boolean r14, String r15, Boolean r16, Boolean r17, Integer r18, TTFavoriteLiveCardABParam r19, Boolean r20, Double r21, int r22, DefaultConstructorMarker r23) {
            if ((r22 & 1) == 0) goto L5;
            Boolean r1 = Boolean.FALSE;
        L7:
            if ((r22 & 2) == 0) goto L9;
            Boolean r2 = Boolean.FALSE;
        L11:
            if ((r22 & 4) == 0) goto L13;
            Boolean r3 = Boolean.FALSE;
        L14:
            Double r5 = null;
            if ((r22 & 8) == 0) goto L17;
            String r4 = null;
        L19:
            if ((r22 & 16) == 0) goto L21;
            Boolean r6 = Boolean.FALSE;
        L23:
            if ((r22 & 32) == 0) goto L25;
            Boolean r7 = Boolean.FALSE;
        L27:
            if ((r22 & 64) == 0) goto L29;
            Integer r8 = null;
        L31:
            if ((r22 & 128) == 0) goto L33;
            TTFavoriteLiveCardABParam r9 = null;
        L35:
            if ((r22 & 256) == 0) goto L37;
            Boolean r10 = Boolean.FALSE;
        L39:
            if ((r22 & 512) != 0) goto L42;
            r5 = r21;
        L42:
            this(r1, r2, r3, r4, r6, r7, r8, r9, r10, r5);
            return;
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
            r4 = r15;
            goto L19
        L13:
            r3 = r14;
            goto L14
        L9:
            r2 = r13;
            goto L11
        L5:
            r1 = r12;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001:\u0007klmnopqBÍ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010N\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010P\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0013\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0015HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u000eHÆ\u0003JÖ\u0002\u0010d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\u0007HÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0018\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010'R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b:\u00104R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b>\u00104R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010'R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\bC\u00104R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\bD\u00104R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010'R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010@R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010'R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\bH\u00104R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010'¨\u0006r"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "", "uid", "", "secUid", "roomId", "status", "", "number", "numberStr", "cover", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "title", "avatar", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "nickName", "productCount", "totalNumber", "followStatus", "streamData", "relationTags", "", "liveDescription", "platformTextActivity", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;", "tags", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag;", "isGuessInstant", "arriveTimePoint", "showProductImage", "feedLiveRecReasonType", "feedLiveRecReasonContent", "descText", "hotAtmosphere", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;", "decorationParam", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;)V", "getArriveTimePoint", "()Ljava/lang/String;", "getAvatar", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "getCover", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "getDecorationParam", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;", "setDecorationParam", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;)V", "getDescText", "getFeedLiveRecReasonContent", "getFeedLiveRecReasonType", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHotAtmosphere", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;", "getLiveDescription", "getNickName", "getNumber", "getNumberStr", "getPlatformTextActivity", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;", "getProductCount", "getRelationTags", "()Ljava/util/List;", "getRoomId", "getSecUid", "getShowProductImage", "getStatus", "getStreamData", "getTags", "getTitle", "getTotalNumber", "getUid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live;", "equals", "", "other", "hashCode", "toString", "Avatar", "Cover", "DecorationParam", "HotAtmosphere", "Link", "PlatformTextActivity", "Tag", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Live {

        @SerializedName("arrive_time_point")
        private final String arriveTimePoint;

        @SerializedName("avatar")
        private final Avatar avatar;

        @SerializedName("cover")
        private final Cover cover;

        @SerializedName("decoration_param")
        private DecorationParam decorationParam;

        @SerializedName("desc_text")
        private final String descText;

        @SerializedName("feed_live_rec_reason_content")
        private final String feedLiveRecReasonContent;

        @SerializedName("feed_live_rec_reason_type")
        private final String feedLiveRecReasonType;

        @SerializedName(PdpOpenThirdParam.KEY_FOLLOW_STATUS)
        private final Integer followStatus;

        @SerializedName("hot_atmosphere")
        private final HotAtmosphere hotAtmosphere;

        @SerializedName("is_guess_instant")
        private final String isGuessInstant;

        @SerializedName("live_description")
        private final String liveDescription;

        @SerializedName("nick_name")
        private final String nickName;

        @SerializedName("number")
        private final Integer number;

        @SerializedName("number_str")
        private final String numberStr;

        @SerializedName("platform_text_activity")
        private final PlatformTextActivity platformTextActivity;

        @SerializedName("product_count")
        private final Integer productCount;

        @SerializedName("relation_tags")
        private final List<String> relationTags;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("sec_uid")
        private final String secUid;

        @SerializedName("feed_live_cover_show_product_image")
        private final Integer showProductImage;

        @SerializedName("status")
        private final Integer status;

        @SerializedName("stream_data")
        private final String streamData;

        @SerializedName("tags")
        private final List<Tag> tags;

        @SerializedName("title")
        private final String title;

        @SerializedName("total_number")
        private final Integer totalNumber;

        @SerializedName("uid")
        private final String uid;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Avatar;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Avatar {

            @SerializedName("height")
            private final Integer height;

            @SerializedName("uri")
            private final String uri;

            @SerializedName("url_list")
            private final List<String> urlList;

            @SerializedName("width")
            private final Integer width;

            public Avatar() {
                this(null, null, null, null, 15, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Avatar copy$default(Avatar r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
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

            public final Avatar copy(String r2, List<String> r3, Integer r4, Integer r5) {
                return new Avatar(r2, r3, r4, r5);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Avatar) == false) goto L14;
                Avatar r4 = (Avatar) r3;
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
                return "Avatar(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
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

            public Avatar(String r1, List<String> r2, Integer r3, Integer r4) {
                this.uri = r1;
                this.urlList = r2;
                this.width = r3;
                this.height = r4;
            }

            public /* synthetic */ Avatar(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Cover;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$DecorationParam;", "", "animationUrl", "", "(Ljava/lang/String;)V", "getAnimationUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class DecorationParam {

            @SerializedName("animation_url")
            private final String animationUrl;

            public DecorationParam() {
                String r0 = null;
                this(r0, 1, r0);
            }

            public static /* synthetic */ DecorationParam copy$default(DecorationParam r0, String r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.animationUrl;
            L6:
                return r0.copy(r1);
            }

            public final String component1() {
                return this.animationUrl;
            }

            public final DecorationParam copy(String r2) {
                return new DecorationParam(r2);
            }

            public boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof DecorationParam) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.animationUrl, ((DecorationParam) r2).animationUrl) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                String r0 = this.animationUrl;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public String toString() {
                return "DecorationParam(animationUrl=" + this.animationUrl + ")";
            }

            public final String getAnimationUrl() {
                return this.animationUrl;
            }

            public DecorationParam(String r1) {
                this.animationUrl = r1;
            }

            public /* synthetic */ DecorationParam(String r1, int r2, DefaultConstructorMarker r3) {
                if ((r2 & 1) == 0) goto L5;
                r1 = null;
            L5:
                this(r1);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$HotAtmosphere;", "", "icon", "", "saleDesc", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getSaleDesc", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class HotAtmosphere {

            @SerializedName("icon")
            private final String icon;

            @SerializedName("sale_num")
            private final String saleDesc;

            public HotAtmosphere() {
                String r0 = null;
                this(r0, r0, 3, r0);
            }

            public static /* synthetic */ HotAtmosphere copy$default(HotAtmosphere r0, String r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.icon;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.saleDesc;
            L9:
                return r0.copy(r1, r2);
            }

            public final String component1() {
                return this.icon;
            }

            public final String component2() {
                return this.saleDesc;
            }

            public final HotAtmosphere copy(String r2, String r3) {
                return new HotAtmosphere(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof HotAtmosphere) == false) goto L10;
                HotAtmosphere r4 = (HotAtmosphere) r3;
                if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.saleDesc, r4.saleDesc) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r0 = this.icon;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.saleDesc;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "HotAtmosphere(icon=" + this.icon + ", saleDesc=" + this.saleDesc + ")";
            }

            public final String getIcon() {
                return this.icon;
            }

            public final String getSaleDesc() {
                return this.saleDesc;
            }

            public HotAtmosphere(String r1, String r2) {
                this.icon = r1;
                this.saleDesc = r2;
            }

            public /* synthetic */ HotAtmosphere(String r2, String r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Link;", "", "live", "", "liveWithProduct", "(Ljava/lang/String;Ljava/lang/String;)V", "getLive", "()Ljava/lang/String;", "getLiveWithProduct", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Link {

            @SerializedName("live")
            private final String live;

            @SerializedName("live_with_product")
            private final String liveWithProduct;

            public Link() {
                String r0 = null;
                this(r0, r0, 3, r0);
            }

            public static /* synthetic */ Link copy$default(Link r0, String r1, String r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.live;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.liveWithProduct;
            L9:
                return r0.copy(r1, r2);
            }

            public final String component1() {
                return this.live;
            }

            public final String component2() {
                return this.liveWithProduct;
            }

            public final Link copy(String r2, String r3) {
                return new Link(r2, r3);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Link) == false) goto L10;
                Link r4 = (Link) r3;
                if (Intrinsics.areEqual(this.live, r4.live) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.liveWithProduct, r4.liveWithProduct) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public int hashCode() {
                String r0 = this.live;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.liveWithProduct;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "Link(live=" + this.live + ", liveWithProduct=" + this.liveWithProduct + ")";
            }

            public final String getLive() {
                return this.live;
            }

            public final String getLiveWithProduct() {
                return this.liveWithProduct;
            }

            public Link(String r1, String r2) {
                this.live = r1;
                this.liveWithProduct = r2;
            }

            public /* synthetic */ Link(String r2, String r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 1) == 0) goto L6;
                r2 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r3 = null;
            L8:
                this(r2, r3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$PlatformTextActivity;", "", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class PlatformTextActivity {
            public PlatformTextActivity() {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001 BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag;", "", "type", "", "content", "", "icon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "endTime", "leftSeconds", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "getEndTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "getLeftSeconds", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag;", "equals", "", "other", "hashCode", "toString", "Icon", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Tag {

            @SerializedName("content")
            private final String content;

            @SerializedName("end_time")
            private final Integer endTime;

            @SerializedName("icon")
            private final Icon icon;

            @SerializedName("left_seconds")
            private final Integer leftSeconds;

            @SerializedName("type")
            private final Integer type;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "", "uri", "", "urlList", "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$Live$Tag$Icon;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class Icon {

                @SerializedName("height")
                private final Integer height;

                @SerializedName("uri")
                private final String uri;

                @SerializedName("url_list")
                private final List<String> urlList;

                @SerializedName("width")
                private final Integer width;

                public Icon() {
                    this(null, null, null, null, 15, null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Icon copy$default(Icon r0, String r1, List r2, Integer r3, Integer r4, int r5, Object r6) {
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

                public final Icon copy(String r2, List<String> r3, Integer r4, Integer r5) {
                    return new Icon(r2, r3, r4, r5);
                }

                public boolean equals(Object r3) {
                    if (this != r3) goto L4;
                    return true;
                L4:
                    if ((r3 instanceof Icon) == false) goto L14;
                    Icon r4 = (Icon) r3;
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
                    return "Icon(uri=" + this.uri + ", urlList=" + this.urlList + ", width=" + this.width + ", height=" + this.height + ")";
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

                public Icon(String r1, List<String> r2, Integer r3, Integer r4) {
                    this.uri = r1;
                    this.urlList = r2;
                    this.width = r3;
                    this.height = r4;
                }

                public /* synthetic */ Icon(String r2, List r3, Integer r4, Integer r5, int r6, DefaultConstructorMarker r7) {
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

            public Tag() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ Tag copy$default(Tag r3, Integer r4, String r5, Icon r6, Integer r7, Integer r8, int r9, Object r10) {
                if ((r9 & 1) == 0) goto L6;
                r4 = r3.type;
            L6:
                if ((r9 & 2) == 0) goto L8;
                r5 = r3.content;
            L8:
                String r11 = r5;
                if ((r9 & 4) == 0) goto L11;
                r6 = r3.icon;
            L11:
                Icon r0 = r6;
                if ((r9 & 8) == 0) goto L14;
                r7 = r3.endTime;
            L14:
                Integer r1 = r7;
                if ((r9 & 16) == 0) goto L17;
                r8 = r3.leftSeconds;
            L17:
                Integer r12 = r4;
                return r3.copy(r12, r11, r0, r1, r8);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.content;
            }

            public final Icon component3() {
                return this.icon;
            }

            public final Integer component4() {
                return this.endTime;
            }

            public final Integer component5() {
                return this.leftSeconds;
            }

            public final Tag copy(Integer r8, String r9, Icon r10, Integer r11, Integer r12) {
                return new Tag(r8, r9, r10, r11, r12);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Tag) == false) goto L16;
                Tag r4 = (Tag) r3;
                if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.content, r4.content) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.endTime, r4.endTime) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.leftSeconds, r4.leftSeconds) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                Integer r0 = this.type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.content;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Icon r7 = this.icon;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.endTime;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                Integer r13 = this.leftSeconds;
                if (r13 == null) goto L22;
                r1 = r13.hashCode();
            L22:
                return r12 + r1;
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
                return "Tag(type=" + this.type + ", content=" + this.content + ", icon=" + this.icon + ", endTime=" + this.endTime + ", leftSeconds=" + this.leftSeconds + ")";
            }

            public final String getContent() {
                return this.content;
            }

            public final Integer getEndTime() {
                return this.endTime;
            }

            public final Icon getIcon() {
                return this.icon;
            }

            public final Integer getLeftSeconds() {
                return this.leftSeconds;
            }

            public final Integer getType() {
                return this.type;
            }

            public Tag(Integer r1, String r2, Icon r3, Integer r4, Integer r5) {
                this.type = r1;
                this.content = r2;
                this.icon = r3;
                this.endTime = r4;
                this.leftSeconds = r5;
            }

            public /* synthetic */ Tag(Integer r5, String r6, Icon r7, Integer r8, Integer r9, int r10, DefaultConstructorMarker r11) {
                if ((r10 & 1) == 0) goto L5;
                Integer r12 = null;
            L7:
                if ((r10 & 2) == 0) goto L9;
                String r1 = null;
            L11:
                if ((r10 & 4) == 0) goto L13;
                Icon r2 = null;
            L15:
                if ((r10 & 8) == 0) goto L17;
                Integer r3 = null;
            L19:
                if ((r10 & 16) == 0) goto L21;
                Integer r13 = null;
            L22:
                this(r12, r1, r2, r3, r13);
                return;
            L21:
                r13 = r9;
                goto L22
            L17:
                r3 = r8;
                goto L19
            L13:
                r2 = r7;
                goto L15
            L9:
                r1 = r6;
                goto L11
            L5:
                r12 = r5;
                goto L7
            }
        }

        public Live() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Live copy$default(Live r17, String r18, String r19, String r20, Integer r21, Integer r22, String r23, Cover r24, String r25, Avatar r26, String r27, Integer r28, Integer r29, Integer r30, String r31, List r32, String r33, PlatformTextActivity r34, List r35, String r36, String r37, Integer r38, String r39, String r40, String r41, HotAtmosphere r42, DecorationParam r43, int r44, Object r45) {
            if ((r44 & 1) == 0) goto L5;
            String r2 = r17.uid;
        L7:
            if ((r44 & 2) == 0) goto L9;
            String r3 = r17.secUid;
        L11:
            if ((r44 & 4) == 0) goto L13;
            String r4 = r17.roomId;
        L15:
            if ((r44 & 8) == 0) goto L17;
            Integer r5 = r17.status;
        L19:
            if ((r44 & 16) == 0) goto L21;
            Integer r6 = r17.number;
        L23:
            if ((r44 & 32) == 0) goto L25;
            String r7 = r17.numberStr;
        L27:
            if ((r44 & 64) == 0) goto L29;
            Cover r8 = r17.cover;
        L31:
            if ((r44 & 128) == 0) goto L33;
            String r9 = r17.title;
        L35:
            if ((r44 & 256) == 0) goto L37;
            Avatar r10 = r17.avatar;
        L39:
            if ((r44 & 512) == 0) goto L41;
            String r11 = r17.nickName;
        L43:
            if ((r44 & 1024) == 0) goto L45;
            Integer r12 = r17.productCount;
        L47:
            if ((r44 & 2048) == 0) goto L49;
            Integer r13 = r17.totalNumber;
        L51:
            if ((r44 & 4096) == 0) goto L53;
            Integer r14 = r17.followStatus;
        L55:
            if ((r44 & 8192) == 0) goto L57;
            String r15 = r17.streamData;
        L58:
            String r310 = r15;
            if ((r44 & 16384) == 0) goto L61;
            List r16 = r17.relationTags;
        L62:
            List r311 = r16;
            if ((r44 & 32768) == 0) goto L65;
            String r110 = r17.liveDescription;
        L66:
            String r312 = r110;
            if ((r44 & 65536) == 0) goto L69;
            PlatformTextActivity r111 = r17.platformTextActivity;
        L70:
            PlatformTextActivity r313 = r111;
            if ((r44 & 131072) == 0) goto L73;
            List r112 = r17.tags;
        L74:
            List r314 = r112;
            if ((r44 & 262144) == 0) goto L77;
            String r113 = r17.isGuessInstant;
        L78:
            String r315 = r113;
            if ((r44 & 524288) == 0) goto L81;
            String r114 = r17.arriveTimePoint;
        L82:
            String r316 = r114;
            if ((r44 & 1048576) == 0) goto L85;
            Integer r115 = r17.showProductImage;
        L86:
            Integer r317 = r115;
            if ((r44 & 2097152) == 0) goto L89;
            String r116 = r17.feedLiveRecReasonType;
        L90:
            String r318 = r116;
            if ((r44 & 4194304) == 0) goto L93;
            String r117 = r17.feedLiveRecReasonContent;
        L94:
            String r46 = r117;
            if ((r44 & 8388608) == 0) goto L97;
            String r118 = r17.descText;
        L98:
            String r47 = r118;
            if ((r44 & 16777216) == 0) goto L101;
            HotAtmosphere r119 = r17.hotAtmosphere;
        L103:
            if ((r44 & 33554432) == 0) goto L105;
            DecorationParam r1 = r17.decorationParam;
        L107:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r46, r47, r119, r1);
        L105:
            r1 = r43;
            goto L107
        L101:
            r119 = r42;
            goto L103
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

        public final String component1() {
            return this.uid;
        }

        public final String component10() {
            return this.nickName;
        }

        public final Integer component11() {
            return this.productCount;
        }

        public final Integer component12() {
            return this.totalNumber;
        }

        public final Integer component13() {
            return this.followStatus;
        }

        public final String component14() {
            return this.streamData;
        }

        public final List<String> component15() {
            return this.relationTags;
        }

        public final String component16() {
            return this.liveDescription;
        }

        public final PlatformTextActivity component17() {
            return this.platformTextActivity;
        }

        public final List<Tag> component18() {
            return this.tags;
        }

        public final String component19() {
            return this.isGuessInstant;
        }

        public final String component2() {
            return this.secUid;
        }

        public final String component20() {
            return this.arriveTimePoint;
        }

        public final Integer component21() {
            return this.showProductImage;
        }

        public final String component22() {
            return this.feedLiveRecReasonType;
        }

        public final String component23() {
            return this.feedLiveRecReasonContent;
        }

        public final String component24() {
            return this.descText;
        }

        public final HotAtmosphere component25() {
            return this.hotAtmosphere;
        }

        public final DecorationParam component26() {
            return this.decorationParam;
        }

        public final String component3() {
            return this.roomId;
        }

        public final Integer component4() {
            return this.status;
        }

        public final Integer component5() {
            return this.number;
        }

        public final String component6() {
            return this.numberStr;
        }

        public final Cover component7() {
            return this.cover;
        }

        public final String component8() {
            return this.title;
        }

        public final Avatar component9() {
            return this.avatar;
        }

        public final Live copy(String r29, String r30, String r31, Integer r32, Integer r33, String r34, Cover r35, String r36, Avatar r37, String r38, Integer r39, Integer r40, Integer r41, String r42, List<String> r43, String r44, PlatformTextActivity r45, List<Tag> r46, String r47, String r48, Integer r49, String r50, String r51, String r52, HotAtmosphere r53, DecorationParam r54) {
            return new Live(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Live) == false) goto L58;
            Live r4 = (Live) r3;
            if (Intrinsics.areEqual(this.uid, r4.uid) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.status, r4.status) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.number, r4.number) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.numberStr, r4.numberStr) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.title, r4.title) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.productCount, r4.productCount) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.totalNumber, r4.totalNumber) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.streamData, r4.streamData) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.relationTags, r4.relationTags) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.liveDescription, r4.liveDescription) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.platformTextActivity, r4.platformTextActivity) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.tags, r4.tags) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.isGuessInstant, r4.isGuessInstant) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.arriveTimePoint, r4.arriveTimePoint) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.showProductImage, r4.showProductImage) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.feedLiveRecReasonType, r4.feedLiveRecReasonType) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.feedLiveRecReasonContent, r4.feedLiveRecReasonContent) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.descText, r4.descText) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.hotAtmosphere, r4.hotAtmosphere) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.decorationParam, r4.decorationParam) == true) goto L88;
            return false;
        L88:
            return true;
        L58:
            return false;
        }

        public int hashCode() {
            String r0 = this.uid;
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
            String r7 = this.roomId;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.status;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.number;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.numberStr;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            Cover r19 = this.cover;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.title;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            Avatar r25 = this.avatar;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            String r28 = this.nickName;
            if (r28 == null) goto L41;
            int r29 = r28.hashCode();
        L42:
            int r30 = (r27 + r29) * 31;
            Integer r31 = this.productCount;
            if (r31 == null) goto L45;
            int r32 = r31.hashCode();
        L46:
            int r33 = (r30 + r32) * 31;
            Integer r34 = this.totalNumber;
            if (r34 == null) goto L49;
            int r35 = r34.hashCode();
        L50:
            int r36 = (r33 + r35) * 31;
            Integer r37 = this.followStatus;
            if (r37 == null) goto L53;
            int r38 = r37.hashCode();
        L54:
            int r39 = (r36 + r38) * 31;
            String r40 = this.streamData;
            if (r40 == null) goto L57;
            int r41 = r40.hashCode();
        L58:
            int r42 = (r39 + r41) * 31;
            List<String> r43 = this.relationTags;
            if (r43 == null) goto L61;
            int r44 = r43.hashCode();
        L62:
            int r45 = (r42 + r44) * 31;
            String r46 = this.liveDescription;
            if (r46 == null) goto L65;
            int r47 = r46.hashCode();
        L66:
            int r48 = (r45 + r47) * 31;
            PlatformTextActivity r49 = this.platformTextActivity;
            if (r49 == null) goto L69;
            int r50 = r49.hashCode();
        L70:
            int r51 = (r48 + r50) * 31;
            List<Tag> r52 = this.tags;
            if (r52 == null) goto L73;
            int r53 = r52.hashCode();
        L74:
            int r54 = (r51 + r53) * 31;
            String r55 = this.isGuessInstant;
            if (r55 == null) goto L77;
            int r56 = r55.hashCode();
        L78:
            int r57 = (r54 + r56) * 31;
            String r58 = this.arriveTimePoint;
            if (r58 == null) goto L81;
            int r59 = r58.hashCode();
        L82:
            int r60 = (r57 + r59) * 31;
            Integer r61 = this.showProductImage;
            if (r61 == null) goto L85;
            int r62 = r61.hashCode();
        L86:
            int r63 = (r60 + r62) * 31;
            String r64 = this.feedLiveRecReasonType;
            if (r64 == null) goto L89;
            int r65 = r64.hashCode();
        L90:
            int r66 = (r63 + r65) * 31;
            String r67 = this.feedLiveRecReasonContent;
            if (r67 == null) goto L93;
            int r68 = r67.hashCode();
        L94:
            int r69 = (r66 + r68) * 31;
            String r70 = this.descText;
            if (r70 == null) goto L97;
            int r71 = r70.hashCode();
        L98:
            int r72 = (r69 + r71) * 31;
            HotAtmosphere r73 = this.hotAtmosphere;
            if (r73 == null) goto L101;
            int r74 = r73.hashCode();
        L102:
            int r75 = (r72 + r74) * 31;
            DecorationParam r76 = this.decorationParam;
            if (r76 == null) goto L106;
            r1 = r76.hashCode();
        L106:
            return r75 + r1;
        L101:
            r74 = 0;
            goto L102
        L97:
            r71 = 0;
            goto L98
        L93:
            r68 = 0;
            goto L94
        L89:
            r65 = 0;
            goto L90
        L85:
            r62 = 0;
            goto L86
        L81:
            r59 = 0;
            goto L82
        L77:
            r56 = 0;
            goto L78
        L73:
            r53 = 0;
            goto L74
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
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
            return "Live(uid=" + this.uid + ", secUid=" + this.secUid + ", roomId=" + this.roomId + ", status=" + this.status + ", number=" + this.number + ", numberStr=" + this.numberStr + ", cover=" + this.cover + ", title=" + this.title + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ", productCount=" + this.productCount + ", totalNumber=" + this.totalNumber + ", followStatus=" + this.followStatus + ", streamData=" + this.streamData + ", relationTags=" + this.relationTags + ", liveDescription=" + this.liveDescription + ", platformTextActivity=" + this.platformTextActivity + ", tags=" + this.tags + ", isGuessInstant=" + this.isGuessInstant + ", arriveTimePoint=" + this.arriveTimePoint + ", showProductImage=" + this.showProductImage + ", feedLiveRecReasonType=" + this.feedLiveRecReasonType + ", feedLiveRecReasonContent=" + this.feedLiveRecReasonContent + ", descText=" + this.descText + ", hotAtmosphere=" + this.hotAtmosphere + ", decorationParam=" + this.decorationParam + ")";
        }

        public final String getArriveTimePoint() {
            return this.arriveTimePoint;
        }

        public final Avatar getAvatar() {
            return this.avatar;
        }

        public final Cover getCover() {
            return this.cover;
        }

        public final DecorationParam getDecorationParam() {
            return this.decorationParam;
        }

        public final String getDescText() {
            return this.descText;
        }

        public final String getFeedLiveRecReasonContent() {
            return this.feedLiveRecReasonContent;
        }

        public final String getFeedLiveRecReasonType() {
            return this.feedLiveRecReasonType;
        }

        public final Integer getFollowStatus() {
            return this.followStatus;
        }

        public final HotAtmosphere getHotAtmosphere() {
            return this.hotAtmosphere;
        }

        public final String getLiveDescription() {
            return this.liveDescription;
        }

        public final String getNickName() {
            return this.nickName;
        }

        public final Integer getNumber() {
            return this.number;
        }

        public final String getNumberStr() {
            return this.numberStr;
        }

        public final PlatformTextActivity getPlatformTextActivity() {
            return this.platformTextActivity;
        }

        public final Integer getProductCount() {
            return this.productCount;
        }

        public final List<String> getRelationTags() {
            return this.relationTags;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final String getSecUid() {
            return this.secUid;
        }

        public final Integer getShowProductImage() {
            return this.showProductImage;
        }

        public final Integer getStatus() {
            return this.status;
        }

        public final String getStreamData() {
            return this.streamData;
        }

        public final List<Tag> getTags() {
            return this.tags;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getTotalNumber() {
            return this.totalNumber;
        }

        public final String getUid() {
            return this.uid;
        }

        public final String isGuessInstant() {
            return this.isGuessInstant;
        }

        public final void setDecorationParam(DecorationParam r1) {
            this.decorationParam = r1;
        }

        public Live(String r3, String r4, String r5, Integer r6, Integer r7, String r8, Cover r9, String r10, Avatar r11, String r12, Integer r13, Integer r14, Integer r15, String r16, List<String> r17, String r18, PlatformTextActivity r19, List<Tag> r20, String r21, String r22, Integer r23, String r24, String r25, String r26, HotAtmosphere r27, DecorationParam r28) {
            this.uid = r3;
            this.secUid = r4;
            this.roomId = r5;
            this.status = r6;
            this.number = r7;
            this.numberStr = r8;
            this.cover = r9;
            this.title = r10;
            this.avatar = r11;
            this.nickName = r12;
            this.productCount = r13;
            this.totalNumber = r14;
            this.followStatus = r15;
            this.streamData = r16;
            this.relationTags = r17;
            this.liveDescription = r18;
            this.platformTextActivity = r19;
            this.tags = r20;
            this.isGuessInstant = r21;
            this.arriveTimePoint = r22;
            this.showProductImage = r23;
            this.feedLiveRecReasonType = r24;
            this.feedLiveRecReasonContent = r25;
            this.descText = r26;
            this.hotAtmosphere = r27;
            this.decorationParam = r28;
        }

        public /* synthetic */ Live(String r28, String r29, String r30, Integer r31, Integer r32, String r33, Cover r34, String r35, Avatar r36, String r37, Integer r38, Integer r39, Integer r40, String r41, List r42, String r43, PlatformTextActivity r44, List r45, String r46, String r47, Integer r48, String r49, String r50, String r51, HotAtmosphere r52, DecorationParam r53, int r54, DefaultConstructorMarker r55) {
            if ((r54 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r54 & 2) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r54 & 4) == 0) goto L13;
            String r4 = null;
        L15:
            if ((r54 & 8) == 0) goto L17;
            Integer r5 = null;
        L19:
            if ((r54 & 16) == 0) goto L21;
            Integer r6 = null;
        L23:
            if ((r54 & 32) == 0) goto L25;
            String r7 = null;
        L27:
            if ((r54 & 64) == 0) goto L29;
            Cover r8 = null;
        L31:
            if ((r54 & 128) == 0) goto L33;
            String r9 = null;
        L35:
            if ((r54 & 256) == 0) goto L37;
            Avatar r10 = null;
        L39:
            if ((r54 & 512) == 0) goto L41;
            String r11 = null;
        L43:
            if ((r54 & 1024) == 0) goto L45;
            Integer r12 = null;
        L47:
            if ((r54 & 2048) == 0) goto L49;
            Integer r13 = null;
        L51:
            if ((r54 & 4096) == 0) goto L53;
            Integer r14 = null;
        L55:
            if ((r54 & 8192) == 0) goto L57;
            String r15 = null;
        L59:
            if ((r54 & 16384) == 0) goto L61;
            List r2 = null;
        L63:
            if ((r54 & 32768) == 0) goto L65;
            String r16 = null;
        L67:
            if ((r54 & 65536) == 0) goto L69;
            PlatformTextActivity r17 = null;
        L71:
            if ((r54 & 131072) == 0) goto L73;
            List r18 = null;
        L75:
            if ((r54 & 262144) == 0) goto L77;
            String r19 = null;
        L79:
            if ((r54 & 524288) == 0) goto L81;
            String r20 = null;
        L83:
            if ((r54 & 1048576) == 0) goto L85;
            Integer r21 = null;
        L87:
            if ((r54 & 2097152) == 0) goto L89;
            String r22 = null;
        L91:
            if ((r54 & 4194304) == 0) goto L93;
            String r23 = null;
        L95:
            if ((r54 & 8388608) == 0) goto L97;
            String r24 = null;
        L99:
            if ((r54 & 16777216) == 0) goto L101;
            HotAtmosphere r25 = null;
        L103:
            if ((r54 & 33554432) == 0) goto L105;
            DecorationParam r0 = null;
        L106:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r0);
            return;
        L105:
            r0 = r53;
            goto L106
        L101:
            r25 = r52;
            goto L103
        L97:
            r24 = r51;
            goto L99
        L93:
            r23 = r50;
            goto L95
        L89:
            r22 = r49;
            goto L91
        L85:
            r21 = r48;
            goto L87
        L81:
            r20 = r47;
            goto L83
        L77:
            r19 = r46;
            goto L79
        L73:
            r18 = r45;
            goto L75
        L69:
            r17 = r44;
            goto L71
        L65:
            r16 = r43;
            goto L67
        L61:
            r2 = r42;
            goto L63
        L57:
            r15 = r41;
            goto L59
        L53:
            r14 = r40;
            goto L55
        L49:
            r13 = r39;
            goto L51
        L45:
            r12 = r38;
            goto L47
        L41:
            r11 = r37;
            goto L43
        L37:
            r10 = r36;
            goto L39
        L33:
            r9 = r35;
            goto L35
        L29:
            r8 = r34;
            goto L31
        L25:
            r7 = r33;
            goto L27
        L21:
            r6 = r32;
            goto L23
        L17:
            r5 = r31;
            goto L19
        L13:
            r4 = r30;
            goto L15
        L9:
            r3 = r29;
            goto L11
        L5:
            r1 = r28;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$TTFavoriteLiveCardABParam;", "", "optGroup", "", "taskExpGroup", "(Ljava/lang/String;Ljava/lang/String;)V", "getOptGroup", "()Ljava/lang/String;", "getTaskExpGroup", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTFavoriteLiveCardABParam {

        @SerializedName("live_card_opt_group")
        private final String optGroup;

        @SerializedName("task_tab_show_exp_group")
        private final String taskExpGroup;

        public TTFavoriteLiveCardABParam() {
            String r0 = null;
            this(r0, r0, 3, r0);
        }

        public static /* synthetic */ TTFavoriteLiveCardABParam copy$default(TTFavoriteLiveCardABParam r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.optGroup;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.taskExpGroup;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.optGroup;
        }

        public final String component2() {
            return this.taskExpGroup;
        }

        public final TTFavoriteLiveCardABParam copy(String r2, String r3) {
            return new TTFavoriteLiveCardABParam(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof TTFavoriteLiveCardABParam) == false) goto L10;
            TTFavoriteLiveCardABParam r4 = (TTFavoriteLiveCardABParam) r3;
            if (Intrinsics.areEqual(this.optGroup, r4.optGroup) == true) goto L8;
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
            String r0 = this.optGroup;
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
            return "TTFavoriteLiveCardABParam(optGroup=" + this.optGroup + ", taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getOptGroup() {
            return this.optGroup;
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public TTFavoriteLiveCardABParam(String r1, String r2) {
            this.optGroup = r1;
            this.taskExpGroup = r2;
        }

        public /* synthetic */ TTFavoriteLiveCardABParam(String r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    public LiveCardData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435455, null);
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

    public final Boolean getCardMute() {
        return this.cardMute;
    }

    public final CommonData.CoinData getCoinData() {
        return this.coinData;
    }

    public final String getDescIcon() {
        return this.descIcon;
    }

    public final Boolean getDisableVane() {
        return this.disableVane;
    }

    public final CommonData.ElementStyle getElementStyle() {
        return this.elementStyle;
    }

    public final CommonData.Extra getExtra() {
        return this.extra;
    }

    public final FavoriteLiveCardABValue getFavoriteLiveCardABValue() {
        return this.favoriteLiveCardABValue;
    }

    public final FavoriteLiveCardABValues getFavoriteLiveCardABValues() {
        return this.favoriteLiveCardABValues;
    }

    public final CommonData.Impression getImpression() {
        return this.impression;
    }

    public final FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final Live getLive() {
        return this.live;
    }

    public final CommonData.MarketingData getMarketIngData() {
        return this.marketIngData;
    }

    public final Boolean getNeedAnimation() {
        return this.needAnimation;
    }

    public final Boolean getNeedShowAdTagUI() {
        return this.needShowAdTagUI;
    }

    public final String getPlayIcon() {
        return this.playIcon;
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

    public final CommonData.Store getStore() {
        return this.store;
    }

    public final Integer getType() {
        return this.type;
    }

    public final CommonData.User getUser() {
        return this.user;
    }

    public final CommonData.WindVaneEventData getWindVaneData() {
        return this.windVaneData;
    }

    public final Object getWindVaneParams() {
        return this.windVaneParams;
    }

    public final Boolean isAd() {
        return this.isAd;
    }

    public final String isInstantRecCard() {
        return this.isInstantRecCard;
    }

    public final void setNeedAnimation(Boolean r1) {
        this.needAnimation = r1;
    }

    public LiveCardData(Integer r3, Live r4, CommonData.Product r5, CommonData.User r6, CommonData.Store r7, CommonData.Impression r8, CommonData.CardCommon r9, CommonData.Extra r10, String r11, CommonData.MarketingData r12, CommonData.CoinData r13, Boolean r14, FavoriteLiveCardABValue r15, FavoriteLiveCardABValues r16, Boolean r17, FavoriteItemStyle r18, String r19, Boolean r20, CommonData.WindVaneEventData r21, Object r22, String r23, Boolean r24, Boolean r25, CommonData.ElementStyle r26, String r27, String r28, String r29, Boolean r30) {
        this.type = r3;
        this.live = r4;
        this.product = r5;
        this.user = r6;
        this.store = r7;
        this.impression = r8;
        this.cardCommon = r9;
        this.extra = r10;
        this.schema = r11;
        this.marketIngData = r12;
        this.coinData = r13;
        this.isAd = r14;
        this.favoriteLiveCardABValue = r15;
        this.favoriteLiveCardABValues = r16;
        this.needShowAdTagUI = r17;
        this.itemStyle = r18;
        this.playIcon = r19;
        this.showJustNowUI = r20;
        this.windVaneData = r21;
        this.windVaneParams = r22;
        this.isInstantRecCard = r23;
        this.disableVane = r24;
        this.needAnimation = r25;
        this.elementStyle = r26;
        this.btmCD = r27;
        this.descIcon = r28;
        this.accessibilityLabel = r29;
        this.cardMute = r30;
    }

    public /* synthetic */ LiveCardData(Integer r30, Live r31, CommonData.Product r32, CommonData.User r33, CommonData.Store r34, CommonData.Impression r35, CommonData.CardCommon r36, CommonData.Extra r37, String r38, CommonData.MarketingData r39, CommonData.CoinData r40, Boolean r41, FavoriteLiveCardABValue r42, FavoriteLiveCardABValues r43, Boolean r44, FavoriteItemStyle r45, String r46, Boolean r47, CommonData.WindVaneEventData r48, Object r49, String r50, Boolean r51, Boolean r52, CommonData.ElementStyle r53, String r54, String r55, String r56, Boolean r57, int r58, DefaultConstructorMarker r59) {
        if ((r58 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r58 & 2) == 0) goto L9;
        Live r3 = null;
    L11:
        if ((r58 & 4) == 0) goto L13;
        CommonData.Product r4 = null;
    L15:
        if ((r58 & 8) == 0) goto L17;
        CommonData.User r5 = null;
    L19:
        if ((r58 & 16) == 0) goto L21;
        CommonData.Store r6 = null;
    L23:
        if ((r58 & 32) == 0) goto L25;
        CommonData.Impression r7 = null;
    L27:
        if ((r58 & 64) == 0) goto L29;
        CommonData.CardCommon r8 = null;
    L31:
        if ((r58 & 128) == 0) goto L33;
        CommonData.Extra r9 = null;
    L35:
        if ((r58 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r58 & 512) == 0) goto L41;
        CommonData.MarketingData r11 = null;
    L43:
        if ((r58 & 1024) == 0) goto L45;
        CommonData.CoinData r12 = null;
    L47:
        if ((r58 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r58 & 4096) == 0) goto L53;
        FavoriteLiveCardABValue r14 = null;
    L55:
        if ((r58 & 8192) == 0) goto L57;
        FavoriteLiveCardABValues r15 = null;
    L59:
        if ((r58 & 16384) == 0) goto L61;
        Boolean r2 = null;
    L63:
        if ((r58 & 32768) == 0) goto L65;
        FavoriteItemStyle r16 = null;
    L67:
        if ((r58 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r58 & 131072) == 0) goto L73;
        Boolean r18 = null;
    L75:
        if ((r58 & 262144) == 0) goto L77;
        CommonData.WindVaneEventData r19 = null;
    L79:
        if ((r58 & 524288) == 0) goto L81;
        Object r20 = null;
    L83:
        if ((r58 & 1048576) == 0) goto L85;
        String r21 = null;
    L87:
        if ((r58 & 2097152) == 0) goto L89;
        Boolean r22 = null;
    L91:
        if ((r58 & 4194304) == 0) goto L93;
        Boolean r23 = null;
    L95:
        if ((r58 & 8388608) == 0) goto L97;
        CommonData.ElementStyle r24 = null;
    L99:
        if ((r58 & 16777216) == 0) goto L101;
        String r25 = null;
    L103:
        if ((r58 & 33554432) == 0) goto L105;
        String r26 = null;
    L107:
        if ((r58 & 67108864) == 0) goto L109;
        String r27 = null;
    L111:
        if ((r58 & 134217728) == 0) goto L113;
        Boolean r0 = null;
    L114:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r0);
        return;
    L113:
        r0 = r57;
        goto L114
    L109:
        r27 = r56;
        goto L111
    L105:
        r26 = r55;
        goto L107
    L101:
        r25 = r54;
        goto L103
    L97:
        r24 = r53;
        goto L99
    L93:
        r23 = r52;
        goto L95
    L89:
        r22 = r51;
        goto L91
    L85:
        r21 = r50;
        goto L87
    L81:
        r20 = r49;
        goto L83
    L77:
        r19 = r48;
        goto L79
    L73:
        r18 = r47;
        goto L75
    L69:
        r17 = r46;
        goto L71
    L65:
        r16 = r45;
        goto L67
    L61:
        r2 = r44;
        goto L63
    L57:
        r15 = r43;
        goto L59
    L53:
        r14 = r42;
        goto L55
    L49:
        r13 = r41;
        goto L51
    L45:
        r12 = r40;
        goto L47
    L41:
        r11 = r39;
        goto L43
    L37:
        r10 = r38;
        goto L39
    L33:
        r9 = r37;
        goto L35
    L29:
        r8 = r36;
        goto L31
    L25:
        r7 = r35;
        goto L27
    L21:
        r6 = r34;
        goto L23
    L17:
        r5 = r33;
        goto L19
    L13:
        r4 = r32;
        goto L15
    L9:
        r3 = r31;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }
}
