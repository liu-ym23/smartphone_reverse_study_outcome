package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l93.b;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001:\u0003XYZBå\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010K\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jî\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010T\u001a\u0004\u0018\u00010\u0003J\t\u0010U\u001a\u00020\bHÖ\u0001J\u0006\u0010V\u001a\u00020RJ\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b8\u00100\"\u0004\b9\u0010:R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010=¨\u0006["}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "", "productId", "", "cover", "coverWhiteBg", "title", "sales", "", "price", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "brandName", "campaignInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;", "shopId", "link", "shop", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;", "extra", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "recommendInfo", "tags", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/TagInfo;", "type", "wysiwygParam", "extraInfo", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "getBrandName", "()Ljava/lang/String;", "getCampaignInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;", "getCover", "()Ljava/lang/Object;", "getCoverWhiteBg", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "getLink", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "getProductId", "getRecommendInfo", "getSales", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShop", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;", "getShopId", "getTags", "()Ljava/util/List;", "getTitle", "getType", "setType", "(Ljava/lang/Integer;)V", "getWysiwygParam", "setWysiwygParam", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/CampaignInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Shop;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct;", "equals", "", "other", "getCoverUrl", "hashCode", "productIsActivity", "toString", "Extra", "ProductExtraActivityType", "SecKillProductCampaignType", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECProductStruct {

    @SerializedName("brand_name")
    private final String brandName;

    @SerializedName("campaign_info")
    private final CampaignInfo campaignInfo;

    @SerializedName("cover")
    private final Object cover;

    @SerializedName("cover_white_bg")
    private final Object coverWhiteBg;

    @SerializedName("extra")
    private final Extra extra;
    private Map<String, String> extraInfo;

    @SerializedName("link")
    private final String link;

    @SerializedName("price")
    private final PriceStruct price;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName("recommend_info")
    private final String recommendInfo;

    @SerializedName("sales")
    private final Integer sales;

    @SerializedName("shop")
    private final Shop shop;

    @SerializedName("shop_id")
    private final String shopId;

    @SerializedName("tags")
    private final List<TagInfo> tags;

    @SerializedName("title")
    private final String title;
    private Integer type;
    private String wysiwygParam;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "", "useNewChannel", "", "resourceId", "", "mallCategoryChannelFirstVertical", "mallCategoryChannelThirdVertical", "productActivityType", "nYuanMPiece", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getMallCategoryChannelFirstVertical", "()Ljava/lang/String;", "getMallCategoryChannelThirdVertical", "getNYuanMPiece", "getProductActivityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResourceId", "getUseNewChannel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$Extra;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName("mall_category_channel_first_vertical")
        private final String mallCategoryChannelFirstVertical;

        @SerializedName("mall_category_channel_third_vertical")
        private final String mallCategoryChannelThirdVertical;

        @SerializedName("n_yuan_m_piece")
        private final String nYuanMPiece;

        @SerializedName("product_activity_type")
        private final Integer productActivityType;

        @SerializedName("resource_id")
        private final String resourceId;

        @SerializedName("use_new_channel")
        private final Integer useNewChannel;

        public Extra() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Extra copy$default(Extra r4, Integer r5, String r6, String r7, String r8, Integer r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.useNewChannel;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.resourceId;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.mallCategoryChannelFirstVertical;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.mallCategoryChannelThirdVertical;
        L14:
            String r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.productActivityType;
        L17:
            Integer r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.nYuanMPiece;
        L20:
            Integer r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final Integer component1() {
            return this.useNewChannel;
        }

        public final String component2() {
            return this.resourceId;
        }

        public final String component3() {
            return this.mallCategoryChannelFirstVertical;
        }

        public final String component4() {
            return this.mallCategoryChannelThirdVertical;
        }

        public final Integer component5() {
            return this.productActivityType;
        }

        public final String component6() {
            return this.nYuanMPiece;
        }

        public final Extra copy(Integer r9, String r10, String r11, String r12, Integer r13, String r14) {
            return new Extra(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Extra) == false) goto L18;
            Extra r4 = (Extra) r3;
            if (Intrinsics.areEqual(this.useNewChannel, r4.useNewChannel) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.resourceId, r4.resourceId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.mallCategoryChannelFirstVertical, r4.mallCategoryChannelFirstVertical) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.mallCategoryChannelThirdVertical, r4.mallCategoryChannelThirdVertical) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.productActivityType, r4.productActivityType) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.nYuanMPiece, r4.nYuanMPiece) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            Integer r0 = this.useNewChannel;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.resourceId;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.mallCategoryChannelFirstVertical;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.mallCategoryChannelThirdVertical;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            Integer r13 = this.productActivityType;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.nYuanMPiece;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
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
            return "Extra(useNewChannel=" + this.useNewChannel + ", resourceId=" + this.resourceId + ", mallCategoryChannelFirstVertical=" + this.mallCategoryChannelFirstVertical + ", mallCategoryChannelThirdVertical=" + this.mallCategoryChannelThirdVertical + ", productActivityType=" + this.productActivityType + ", nYuanMPiece=" + this.nYuanMPiece + ")";
        }

        public final String getMallCategoryChannelFirstVertical() {
            return this.mallCategoryChannelFirstVertical;
        }

        public final String getMallCategoryChannelThirdVertical() {
            return this.mallCategoryChannelThirdVertical;
        }

        public final String getNYuanMPiece() {
            return this.nYuanMPiece;
        }

        public final Integer getProductActivityType() {
            return this.productActivityType;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Integer getUseNewChannel() {
            return this.useNewChannel;
        }

        public Extra(Integer r1, String r2, String r3, String r4, Integer r5, String r6) {
            this.useNewChannel = r1;
            this.resourceId = r2;
            this.mallCategoryChannelFirstVertical = r3;
            this.mallCategoryChannelThirdVertical = r4;
            this.productActivityType = r5;
            this.nYuanMPiece = r6;
        }

        public /* synthetic */ Extra(Integer r6, String r7, String r8, String r9, Integer r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L5;
            Integer r14 = null;
        L7:
            if ((r12 & 2) == 0) goto L9;
            String r1 = null;
        L11:
            if ((r12 & 4) == 0) goto L13;
            String r2 = null;
        L15:
            if ((r12 & 8) == 0) goto L17;
            String r3 = null;
        L19:
            if ((r12 & 16) == 0) goto L21;
            Integer r4 = null;
        L23:
            if ((r12 & 32) == 0) goto L25;
            String r15 = null;
        L26:
            this(r14, r1, r2, r3, r4, r15);
            return;
        L25:
            r15 = r11;
            goto L26
        L21:
            r4 = r10;
            goto L23
        L17:
            r3 = r9;
            goto L19
        L13:
            r2 = r8;
            goto L15
        L9:
            r1 = r7;
            goto L11
        L5:
            r14 = r6;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$ProductExtraActivityType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL_PRODUCT", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ProductExtraActivityType extends Enum<ProductExtraActivityType> {
        private static final /* synthetic */ ProductExtraActivityType[] $VALUES = null;
        public static final ProductExtraActivityType NORMAL_PRODUCT = null;
        private final int value;

        static {
            ProductExtraActivityType r1 = new ProductExtraActivityType("NORMAL_PRODUCT", 0, 0);
            NORMAL_PRODUCT = r1;
            $VALUES = new ProductExtraActivityType[]{r1};
        }

        public static ProductExtraActivityType valueOf(String r1) {
            return (ProductExtraActivityType) a.a(ProductExtraActivityType.class, r1);
        }

        public static ProductExtraActivityType[] values() {
            return (ProductExtraActivityType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private ProductExtraActivityType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ECProductStruct$SecKillProductCampaignType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SECKILL", "PREORDER", "DRAW", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SecKillProductCampaignType extends Enum<SecKillProductCampaignType> {
        private static final /* synthetic */ SecKillProductCampaignType[] $VALUES = null;
        public static final SecKillProductCampaignType DRAW = null;
        public static final SecKillProductCampaignType PREORDER = null;
        public static final SecKillProductCampaignType SECKILL = null;
        private final int value;

        static {
            SecKillProductCampaignType r2 = new SecKillProductCampaignType("SECKILL", 0, 1);
            SECKILL = r2;
            SecKillProductCampaignType r3 = new SecKillProductCampaignType("PREORDER", 1, 2);
            PREORDER = r3;
            SecKillProductCampaignType r4 = new SecKillProductCampaignType("DRAW", 2, 3);
            DRAW = r4;
            $VALUES = new SecKillProductCampaignType[]{r2, r3, r4};
        }

        public static SecKillProductCampaignType valueOf(String r1) {
            return (SecKillProductCampaignType) a.a(SecKillProductCampaignType.class, r1);
        }

        public static SecKillProductCampaignType[] values() {
            return (SecKillProductCampaignType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private SecKillProductCampaignType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ECProductStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECProductStruct copy$default(ECProductStruct r17, String r18, Object r19, Object r20, String r21, Integer r22, PriceStruct r23, String r24, CampaignInfo r25, String r26, String r27, Shop r28, Extra r29, String r30, List r31, Integer r32, String r33, Map r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = r17.productId;
    L7:
        if ((r35 & 2) == 0) goto L9;
        Object r3 = r17.cover;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Object r4 = r17.coverWhiteBg;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r5 = r17.title;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Integer r6 = r17.sales;
    L23:
        if ((r35 & 32) == 0) goto L25;
        PriceStruct r7 = r17.price;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r8 = r17.brandName;
    L31:
        if ((r35 & 128) == 0) goto L33;
        CampaignInfo r9 = r17.campaignInfo;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r10 = r17.shopId;
    L39:
        if ((r35 & 512) == 0) goto L41;
        String r11 = r17.link;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        Shop r12 = r17.shop;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        Extra r13 = r17.extra;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        String r14 = r17.recommendInfo;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        List r15 = r17.tags;
    L58:
        List r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        Integer r16 = r17.type;
    L62:
        Integer r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        String r110 = r17.wysiwygParam;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        Map r1 = r17.extraInfo;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
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
        return this.productId;
    }

    public final String component10() {
        return this.link;
    }

    public final Shop component11() {
        return this.shop;
    }

    public final Extra component12() {
        return this.extra;
    }

    public final String component13() {
        return this.recommendInfo;
    }

    public final List<TagInfo> component14() {
        return this.tags;
    }

    public final Integer component15() {
        return this.type;
    }

    public final String component16() {
        return this.wysiwygParam;
    }

    public final Map<String, String> component17() {
        return this.extraInfo;
    }

    public final Object component2() {
        return this.cover;
    }

    public final Object component3() {
        return this.coverWhiteBg;
    }

    public final String component4() {
        return this.title;
    }

    public final Integer component5() {
        return this.sales;
    }

    public final PriceStruct component6() {
        return this.price;
    }

    public final String component7() {
        return this.brandName;
    }

    public final CampaignInfo component8() {
        return this.campaignInfo;
    }

    public final String component9() {
        return this.shopId;
    }

    public final ECProductStruct copy(String r20, Object r21, Object r22, String r23, Integer r24, PriceStruct r25, String r26, CampaignInfo r27, String r28, String r29, Shop r30, Extra r31, String r32, List<TagInfo> r33, Integer r34, String r35, Map<String, String> r36) {
        return new ECProductStruct(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECProductStruct) == false) goto L40;
        ECProductStruct r4 = (ECProductStruct) r3;
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverWhiteBg, r4.coverWhiteBg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sales, r4.sales) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.brandName, r4.brandName) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.campaignInfo, r4.campaignInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.link, r4.link) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shop, r4.shop) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.recommendInfo, r4.recommendInfo) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.tags, r4.tags) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.wysiwygParam, r4.wysiwygParam) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.extraInfo, r4.extraInfo) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public int hashCode() {
        String r0 = this.productId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.cover;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.coverWhiteBg;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.title;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.sales;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        PriceStruct r16 = this.price;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.brandName;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        CampaignInfo r22 = this.campaignInfo;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.shopId;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.link;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Shop r31 = this.shop;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Extra r34 = this.extra;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.recommendInfo;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        List<TagInfo> r40 = this.tags;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Integer r43 = this.type;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.wysiwygParam;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Map<String, String> r49 = this.extraInfo;
        if (r49 == null) goto L70;
        r1 = r49.hashCode();
    L70:
        return r48 + r1;
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
        return "ECProductStruct(productId=" + this.productId + ", cover=" + this.cover + ", coverWhiteBg=" + this.coverWhiteBg + ", title=" + this.title + ", sales=" + this.sales + ", price=" + this.price + ", brandName=" + this.brandName + ", campaignInfo=" + this.campaignInfo + ", shopId=" + this.shopId + ", link=" + this.link + ", shop=" + this.shop + ", extra=" + this.extra + ", recommendInfo=" + this.recommendInfo + ", tags=" + this.tags + ", type=" + this.type + ", wysiwygParam=" + this.wysiwygParam + ", extraInfo=" + this.extraInfo + ")";
    }

    public final String getCoverUrl() {
        String r0 = b.a(this.coverWhiteBg);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        return r0;
    L11:
        String r2 = b.a(this.cover);
        if (r2 != null) goto L14;
    L15:
        r1 = true;
    L16:
        if (r1 == true) goto L18;
        return r2;
    L18:
        return null;
    L14:
        if (r2.length() != 0) goto L16;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean productIsActivity() {
        Extra r0 = this.extra;
        if (r0 == null) goto L5;
        Integer r1 = r0.getProductActivityType();
    L6:
        if (r1 == null) goto L13;
        Integer r2 = this.extra.getProductActivityType();
        int r3 = ProductExtraActivityType.NORMAL_PRODUCT.getValue();
        if (r2 != null) goto L11;
    L12:
        return true;
    L11:
        if (r2.intValue() != r3) goto L12;
    L13:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final CampaignInfo getCampaignInfo() {
        return this.campaignInfo;
    }

    public final Object getCover() {
        return this.cover;
    }

    public final Object getCoverWhiteBg() {
        return this.coverWhiteBg;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final String getLink() {
        return this.link;
    }

    public final PriceStruct getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final Integer getSales() {
        return this.sales;
    }

    public final Shop getShop() {
        return this.shop;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final List<TagInfo> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getWysiwygParam() {
        return this.wysiwygParam;
    }

    public final void setExtraInfo(Map<String, String> r1) {
        this.extraInfo = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }

    public final void setWysiwygParam(String r1) {
        this.wysiwygParam = r1;
    }

    public ECProductStruct(String r3, Object r4, Object r5, String r6, Integer r7, PriceStruct r8, String r9, CampaignInfo r10, String r11, String r12, Shop r13, Extra r14, String r15, List<TagInfo> r16, Integer r17, String r18, Map<String, String> r19) {
        this.productId = r3;
        this.cover = r4;
        this.coverWhiteBg = r5;
        this.title = r6;
        this.sales = r7;
        this.price = r8;
        this.brandName = r9;
        this.campaignInfo = r10;
        this.shopId = r11;
        this.link = r12;
        this.shop = r13;
        this.extra = r14;
        this.recommendInfo = r15;
        this.tags = r16;
        this.type = r17;
        this.wysiwygParam = r18;
        this.extraInfo = r19;
    }

    public /* synthetic */ ECProductStruct(String r19, Object r20, Object r21, String r22, Integer r23, PriceStruct r24, String r25, CampaignInfo r26, String r27, String r28, Shop r29, Extra r30, String r31, List r32, Integer r33, String r34, Map r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        Object r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Object r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        PriceStruct r7 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        CampaignInfo r9 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        Shop r12 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        Extra r13 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        List r15 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        Integer r2 = null;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        String r16 = null;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        Map r0 = null;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r2 = r33;
        goto L63
    L57:
        r15 = r32;
        goto L59
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
