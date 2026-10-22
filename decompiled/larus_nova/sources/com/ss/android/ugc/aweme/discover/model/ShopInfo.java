package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR,\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR \u00107\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010=\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR \u0010@\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR \u0010C\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR \u0010F\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR \u0010I\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ShopInfo;", "Ljava/io/Serializable;", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "enterShopIconColor", "Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "getEnterShopIconColor", "()Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;", "setEnterShopIconColor", "(Lcom/ss/android/ugc/aweme/discover/model/ColorConfig;)V", "enterShopLeftIcon", "Lcom/ss/android/ugc/aweme/discover/model/PicConfig;", "getEnterShopLeftIcon", "()Lcom/ss/android/ugc/aweme/discover/model/PicConfig;", "setEnterShopLeftIcon", "(Lcom/ss/android/ugc/aweme/discover/model/PicConfig;)V", "enterShopLowestPrice", "getEnterShopLowestPrice", "setEnterShopLowestPrice", "enterShopText", "getEnterShopText", "setEnterShopText", "enterShopTextColor", "getEnterShopTextColor", "setEnterShopTextColor", "extraInfoMap", "", "", "getExtraInfoMap", "()Ljava/util/Map;", "setExtraInfoMap", "(Ljava/util/Map;)V", "isBgHidden", "", "()Ljava/lang/Boolean;", "setBgHidden", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "jumpType", "", "getJumpType", "()I", "setJumpType", "(I)V", "schema", "getSchema", "setSchema", "shopId", "getShopId", "setShopId", "shopLogo", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getShopLogo", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setShopLogo", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "shopName", "getShopName", "setShopName", "shopNameBackgroundColor", "getShopNameBackgroundColor", "setShopNameBackgroundColor", "shopNameColor", "getShopNameColor", "setShopNameColor", "storeId", "getStoreId", "setStoreId", "tag", "getTag", "setTag", "uiStyle", "getUiStyle", "()Ljava/lang/Integer;", "setUiStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopInfo implements Serializable {

    @SerializedName("author_id")
    private String authorId;

    @SerializedName("enter_shop_icon_color")
    private ColorConfig enterShopIconColor;

    @SerializedName("enter_shop_left_icon")
    private PicConfig enterShopLeftIcon;

    @SerializedName("enter_shop_lowest_price")
    private String enterShopLowestPrice;

    @SerializedName("enter_shop_text")
    private String enterShopText;

    @SerializedName("enter_shop_text_color")
    private ColorConfig enterShopTextColor;

    @SerializedName("extra_info_map")
    private Map<String, ? extends Object> extraInfoMap;

    @SerializedName("is_bg_hidden")
    private Boolean isBgHidden;

    @SerializedName("jump_type")
    private int jumpType;

    @SerializedName("schema")
    private String schema;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shop_logo")
    private UrlModel shopLogo;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("shop_name_background_color")
    private String shopNameBackgroundColor;

    @SerializedName("shop_name_color")
    private String shopNameColor;

    @SerializedName("store_id")
    private String storeId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("ui_style")
    private Integer uiStyle;

    public ShopInfo() {
        this.uiStyle = 0;
        this.isBgHidden = Boolean.FALSE;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final ColorConfig getEnterShopIconColor() {
        return this.enterShopIconColor;
    }

    public final PicConfig getEnterShopLeftIcon() {
        return this.enterShopLeftIcon;
    }

    public final String getEnterShopLowestPrice() {
        return this.enterShopLowestPrice;
    }

    public final String getEnterShopText() {
        return this.enterShopText;
    }

    public final ColorConfig getEnterShopTextColor() {
        return this.enterShopTextColor;
    }

    public final Map<String, Object> getExtraInfoMap() {
        return this.extraInfoMap;
    }

    public final int getJumpType() {
        return this.jumpType;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final UrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final String getShopNameBackgroundColor() {
        return this.shopNameBackgroundColor;
    }

    public final String getShopNameColor() {
        return this.shopNameColor;
    }

    public final String getStoreId() {
        return this.storeId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final Integer getUiStyle() {
        return this.uiStyle;
    }

    public final Boolean isBgHidden() {
        return this.isBgHidden;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setBgHidden(Boolean r100) {
        this.isBgHidden = r100;
    }

    public final void setEnterShopIconColor(ColorConfig r100) {
        this.enterShopIconColor = r100;
    }

    public final void setEnterShopLeftIcon(PicConfig r100) {
        this.enterShopLeftIcon = r100;
    }

    public final void setEnterShopLowestPrice(String r100) {
        this.enterShopLowestPrice = r100;
    }

    public final void setEnterShopText(String r100) {
        this.enterShopText = r100;
    }

    public final void setEnterShopTextColor(ColorConfig r100) {
        this.enterShopTextColor = r100;
    }

    public final void setExtraInfoMap(Map<String, ? extends Object> r100) {
        this.extraInfoMap = r100;
    }

    public final void setJumpType(int r100) {
        this.jumpType = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShopLogo(UrlModel r100) {
        this.shopLogo = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }

    public final void setShopNameBackgroundColor(String r100) {
        this.shopNameBackgroundColor = r100;
    }

    public final void setShopNameColor(String r100) {
        this.shopNameColor = r100;
    }

    public final void setStoreId(String r100) {
        this.storeId = r100;
    }

    public final void setTag(String r100) {
        this.tag = r100;
    }

    public final void setUiStyle(Integer r100) {
        this.uiStyle = r100;
    }
}
