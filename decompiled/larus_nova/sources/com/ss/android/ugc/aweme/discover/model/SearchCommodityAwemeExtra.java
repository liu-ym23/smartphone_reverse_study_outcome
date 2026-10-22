package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.feed.model.search.SearchCommodityTagInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010'\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR \u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR \u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR \u0010;\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010A\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR&\u0010D\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR \u0010G\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR \u0010L\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR&\u0010R\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000fR\u001c\u0010V\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0006\"\u0004\bX\u0010\bR \u0010Y\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0006\"\u0004\b[\u0010\b¨\u0006\\"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAwemeExtra;", "Ljava/io/Serializable;", "()V", "displayText", "", "getDisplayText", "()Ljava/lang/String;", "setDisplayText", "(Ljava/lang/String;)V", "elasticImages", "", "Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAwemeExtraImage;", "getElasticImages", "()Ljava/util/List;", "setElasticImages", "(Ljava/util/List;)V", "enhancedDisplay", "", "getEnhancedDisplay", "()Ljava/lang/Boolean;", "setEnhancedDisplay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mainImageTag", "Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;", "getMainImageTag", "()Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;", "setMainImageTag", "(Lcom/ss/android/ugc/aweme/discover/model/MainImageTag;)V", "originPrice", "getOriginPrice", "setOriginPrice", "price", "", "getPrice", "()Ljava/lang/Integer;", "setPrice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "priceStyle", "getPriceStyle", "()I", "setPriceStyle", "(I)V", "priceText", "Lcom/ss/android/ugc/aweme/discover/model/PriceText;", "getPriceText", "()Lcom/ss/android/ugc/aweme/discover/model/PriceText;", "setPriceText", "(Lcom/ss/android/ugc/aweme/discover/model/PriceText;)V", "productId", "getProductId", "setProductId", "saleIcon", "getSaleIcon", "setSaleIcon", "saleText", "getSaleText", "setSaleText", "salesV2", "Lcom/ss/android/ugc/aweme/discover/model/TextWithProperty;", "getSalesV2", "()Lcom/ss/android/ugc/aweme/discover/model/TextWithProperty;", "setSalesV2", "(Lcom/ss/android/ugc/aweme/discover/model/TextWithProperty;)V", "sellOutTip", "getSellOutTip", "setSellOutTip", "sellPoints", "getSellPoints", "setSellPoints", "statusIcon", "getStatusIcon", "()Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAwemeExtraImage;", "setStatusIcon", "(Lcom/ss/android/ugc/aweme/discover/model/SearchCommodityAwemeExtraImage;)V", "strongPricePrefix", "Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "getStrongPricePrefix", "()Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "setStrongPricePrefix", "(Lcom/ss/android/ugc/aweme/discover/model/CommonText;)V", "tagInfos", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "getTagInfos", "setTagInfos", "tagInfosJson", "getTagInfosJson", "setTagInfosJson", "title", "getTitle", d.f25925o, "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityAwemeExtra implements Serializable {

    @SerializedName("display_text")
    private String displayText;

    @SerializedName("elastic_images")
    private List<SearchCommodityAwemeExtraImage> elasticImages;

    @SerializedName("enhanced_display")
    private Boolean enhancedDisplay;

    @SerializedName("main_image_tag")
    private MainImageTag mainImageTag;

    @SerializedName("origin_price_str")
    private String originPrice;

    @SerializedName("price")
    private Integer price;

    @SerializedName("price_style")
    private int priceStyle;

    @SerializedName("text_price")
    private PriceText priceText;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("sale_icon")
    private String saleIcon;

    @SerializedName("sale_text")
    private String saleText;

    @SerializedName("sales_v2")
    private TextWithProperty salesV2;

    @SerializedName("sell_out_tip")
    private String sellOutTip;

    @SerializedName("sell_points")
    private List<TextWithProperty> sellPoints;

    @SerializedName("status_icon")
    private SearchCommodityAwemeExtraImage statusIcon;

    @SerializedName("strong_price_prefix")
    private CommonText strongPricePrefix;

    @SerializedName("tag_infos")
    private List<SearchCommodityTagInfo> tagInfos;
    private String tagInfosJson;

    @SerializedName("title")
    private String title;

    public SearchCommodityAwemeExtra() {
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final List<SearchCommodityAwemeExtraImage> getElasticImages() {
        return this.elasticImages;
    }

    public final Boolean getEnhancedDisplay() {
        return this.enhancedDisplay;
    }

    public final MainImageTag getMainImageTag() {
        return this.mainImageTag;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final int getPriceStyle() {
        return this.priceStyle;
    }

    public final PriceText getPriceText() {
        return this.priceText;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSaleIcon() {
        return this.saleIcon;
    }

    public final String getSaleText() {
        return this.saleText;
    }

    public final TextWithProperty getSalesV2() {
        return this.salesV2;
    }

    public final String getSellOutTip() {
        return this.sellOutTip;
    }

    public final List<TextWithProperty> getSellPoints() {
        return this.sellPoints;
    }

    public final SearchCommodityAwemeExtraImage getStatusIcon() {
        return this.statusIcon;
    }

    public final CommonText getStrongPricePrefix() {
        return this.strongPricePrefix;
    }

    public final List<SearchCommodityTagInfo> getTagInfos() {
        return this.tagInfos;
    }

    public final String getTagInfosJson() {
        return this.tagInfosJson;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setDisplayText(String r100) {
        this.displayText = r100;
    }

    public final void setElasticImages(List<SearchCommodityAwemeExtraImage> r100) {
        this.elasticImages = r100;
    }

    public final void setEnhancedDisplay(Boolean r100) {
        this.enhancedDisplay = r100;
    }

    public final void setMainImageTag(MainImageTag r100) {
        this.mainImageTag = r100;
    }

    public final void setOriginPrice(String r100) {
        this.originPrice = r100;
    }

    public final void setPrice(Integer r100) {
        this.price = r100;
    }

    public final void setPriceStyle(int r100) {
        this.priceStyle = r100;
    }

    public final void setPriceText(PriceText r100) {
        this.priceText = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setSaleIcon(String r100) {
        this.saleIcon = r100;
    }

    public final void setSaleText(String r100) {
        this.saleText = r100;
    }

    public final void setSalesV2(TextWithProperty r100) {
        this.salesV2 = r100;
    }

    public final void setSellOutTip(String r100) {
        this.sellOutTip = r100;
    }

    public final void setSellPoints(List<TextWithProperty> r100) {
        this.sellPoints = r100;
    }

    public final void setStatusIcon(SearchCommodityAwemeExtraImage r100) {
        this.statusIcon = r100;
    }

    public final void setStrongPricePrefix(CommonText r100) {
        this.strongPricePrefix = r100;
    }

    public final void setTagInfos(List<SearchCommodityTagInfo> r100) {
        this.tagInfos = r100;
    }

    public final void setTagInfosJson(String r100) {
        this.tagInfosJson = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
