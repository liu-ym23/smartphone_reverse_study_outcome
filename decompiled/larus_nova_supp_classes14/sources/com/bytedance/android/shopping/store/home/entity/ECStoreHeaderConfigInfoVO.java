package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001e\u00104\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\"\u00107\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010=\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010\u0014R\u001e\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010\u0014R \u0010C\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\f\"\u0004\bE\u0010\u000eR\"\u0010F\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\bG\u0010-\"\u0004\bH\u0010/R \u0010I\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\f\"\u0004\bK\u0010\u000eR \u0010L\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR \u0010O\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\f\"\u0004\bQ\u0010\u000eR\"\u0010R\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\bS\u0010-\"\u0004\bT\u0010/R \u0010U\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u001e\u0010X\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0012\"\u0004\bZ\u0010\u0014R\u001e\u0010[\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0012\"\u0004\b]\u0010\u0014R \u0010^\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\f\"\u0004\b`\u0010\u000eR \u0010a\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006g"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreHeaderConfigInfoVO;", "Ljava/io/Serializable;", "()V", "cartEntryConfig", "Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;", "getCartEntryConfig", "()Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;", "setCartEntryConfig", "(Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;)V", "customServiceEntry", "", "getCustomServiceEntry", "()Ljava/lang/String;", "setCustomServiceEntry", "(Ljava/lang/String;)V", "displaySearch", "", "getDisplaySearch", "()Z", "setDisplaySearch", "(Z)V", "displayShopWindowEntry", "getDisplayShopWindowEntry", "setDisplayShopWindowEntry", "entranceInformation", "Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;", "getEntranceInformation", "()Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;", "setEntranceInformation", "(Lcom/bytedance/android/shopping/store/home/entity/EntranceInformation;)V", "fansInfo", "Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "getFansInfo", "()Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "setFansInfo", "(Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;)V", "followGiftConfig", "Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "getFollowGiftConfig", "()Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "setFollowGiftConfig", "(Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)V", "followIconType", "", "getFollowIconType", "()Ljava/lang/Integer;", "setFollowIconType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "followStatus", "getFollowStatus", "setFollowStatus", "hideFollowBtn", "getHideFollowBtn", "setHideFollowBtn", "hideLiveInfo", "getHideLiveInfo", "()Ljava/lang/Boolean;", "setHideLiveInfo", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hideReputation", "getHideReputation", "setHideReputation", "hideStoreDetailEntry", "getHideStoreDetailEntry", "setHideStoreDetailEntry", "orderUrl", "getOrderUrl", "setOrderUrl", "productCount", "getProductCount", "setProductCount", "redirectSchema", "getRedirectSchema", "setRedirectSchema", "redpacketEntrance", "getRedpacketEntrance", "setRedpacketEntrance", "searchHint", "getSearchHint", "setSearchHint", "shopWindowProductCount", "getShopWindowProductCount", "setShopWindowProductCount", "shopWindowUrl", "getShopWindowUrl", "setShopWindowUrl", "showInfoColumn", "getShowInfoColumn", "setShowInfoColumn", "showSales", "getShowSales", "setShowSales", "storeDetailUrl", "getStoreDetailUrl", "setStoreDetailUrl", "topSearchInfo", "Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;", "getTopSearchInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;", "setTopSearchInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHeaderConfigInfoVO implements Serializable {

    @SerializedName("cart_entry_info")
    private StoreCartEntryConfig cartEntryConfig;

    @SerializedName("service_entry")
    private String customServiceEntry;

    @SerializedName("show_search")
    private boolean displaySearch;

    @SerializedName("product_shop_entry")
    private boolean displayShopWindowEntry;

    @SerializedName("entrance_information")
    private EntranceInformation entranceInformation;

    @SerializedName("fans_info")
    private FansClubInfo fansInfo;

    @SerializedName("follow_config")
    private StoreFollowGiftConfig followGiftConfig;

    @SerializedName("follow_icon_type")
    private Integer followIconType;

    @SerializedName("follow_status")
    private Integer followStatus;

    @SerializedName("hide_follow_button")
    private boolean hideFollowBtn;

    @SerializedName("hide_live_info")
    private Boolean hideLiveInfo;

    @SerializedName("hide_reputation")
    private boolean hideReputation;

    @SerializedName("hide_detail_entry")
    private boolean hideStoreDetailEntry;

    @SerializedName("order_url")
    private String orderUrl;

    @SerializedName("product_count")
    private Integer productCount;

    @SerializedName("redirect_schema")
    private String redirectSchema;

    @SerializedName("redpacket_entrance")
    private String redpacketEntrance;

    @SerializedName("search_hint")
    private String searchHint;

    @SerializedName("shop_product_count")
    private Integer shopWindowProductCount;

    @SerializedName("shop_url")
    private String shopWindowUrl;

    @SerializedName("show_info_column")
    private boolean showInfoColumn;

    @SerializedName("show_sales")
    private boolean showSales;

    @SerializedName("store_detail_url")
    private String storeDetailUrl;

    @SerializedName("top_search_info")
    private ECTopSearchInfo topSearchInfo;

    public ECStoreHeaderConfigInfoVO() {
        this.showSales = true;
    }

    public final StoreCartEntryConfig getCartEntryConfig() {
        return this.cartEntryConfig;
    }

    public final String getCustomServiceEntry() {
        return this.customServiceEntry;
    }

    public final boolean getDisplaySearch() {
        return this.displaySearch;
    }

    public final boolean getDisplayShopWindowEntry() {
        return this.displayShopWindowEntry;
    }

    public final EntranceInformation getEntranceInformation() {
        return this.entranceInformation;
    }

    public final FansClubInfo getFansInfo() {
        return this.fansInfo;
    }

    public final StoreFollowGiftConfig getFollowGiftConfig() {
        return this.followGiftConfig;
    }

    public final Integer getFollowIconType() {
        return this.followIconType;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getHideFollowBtn() {
        return this.hideFollowBtn;
    }

    public final Boolean getHideLiveInfo() {
        return this.hideLiveInfo;
    }

    public final boolean getHideReputation() {
        return this.hideReputation;
    }

    public final boolean getHideStoreDetailEntry() {
        return this.hideStoreDetailEntry;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final Integer getProductCount() {
        return this.productCount;
    }

    public final String getRedirectSchema() {
        return this.redirectSchema;
    }

    public final String getRedpacketEntrance() {
        return this.redpacketEntrance;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final Integer getShopWindowProductCount() {
        return this.shopWindowProductCount;
    }

    public final String getShopWindowUrl() {
        return this.shopWindowUrl;
    }

    public final boolean getShowInfoColumn() {
        return this.showInfoColumn;
    }

    public final boolean getShowSales() {
        return this.showSales;
    }

    public final String getStoreDetailUrl() {
        return this.storeDetailUrl;
    }

    public final ECTopSearchInfo getTopSearchInfo() {
        return this.topSearchInfo;
    }

    public final void setCartEntryConfig(StoreCartEntryConfig r1) {
        this.cartEntryConfig = r1;
    }

    public final void setCustomServiceEntry(String r1) {
        this.customServiceEntry = r1;
    }

    public final void setDisplaySearch(boolean r1) {
        this.displaySearch = r1;
    }

    public final void setDisplayShopWindowEntry(boolean r1) {
        this.displayShopWindowEntry = r1;
    }

    public final void setEntranceInformation(EntranceInformation r1) {
        this.entranceInformation = r1;
    }

    public final void setFansInfo(FansClubInfo r1) {
        this.fansInfo = r1;
    }

    public final void setFollowGiftConfig(StoreFollowGiftConfig r1) {
        this.followGiftConfig = r1;
    }

    public final void setFollowIconType(Integer r1) {
        this.followIconType = r1;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setHideFollowBtn(boolean r1) {
        this.hideFollowBtn = r1;
    }

    public final void setHideLiveInfo(Boolean r1) {
        this.hideLiveInfo = r1;
    }

    public final void setHideReputation(boolean r1) {
        this.hideReputation = r1;
    }

    public final void setHideStoreDetailEntry(boolean r1) {
        this.hideStoreDetailEntry = r1;
    }

    public final void setOrderUrl(String r1) {
        this.orderUrl = r1;
    }

    public final void setProductCount(Integer r1) {
        this.productCount = r1;
    }

    public final void setRedirectSchema(String r1) {
        this.redirectSchema = r1;
    }

    public final void setRedpacketEntrance(String r1) {
        this.redpacketEntrance = r1;
    }

    public final void setSearchHint(String r1) {
        this.searchHint = r1;
    }

    public final void setShopWindowProductCount(Integer r1) {
        this.shopWindowProductCount = r1;
    }

    public final void setShopWindowUrl(String r1) {
        this.shopWindowUrl = r1;
    }

    public final void setShowInfoColumn(boolean r1) {
        this.showInfoColumn = r1;
    }

    public final void setShowSales(boolean r1) {
        this.showSales = r1;
    }

    public final void setStoreDetailUrl(String r1) {
        this.storeDetailUrl = r1;
    }

    public final void setTopSearchInfo(ECTopSearchInfo r1) {
        this.topSearchInfo = r1;
    }
}
