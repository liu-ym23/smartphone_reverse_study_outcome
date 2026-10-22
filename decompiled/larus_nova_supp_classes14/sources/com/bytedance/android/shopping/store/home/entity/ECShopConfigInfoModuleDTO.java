package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.store.common.floatelement.StoreCartEntryConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\"\u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00104\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\"\u00107\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b8\u0010*\"\u0004\b9\u0010,R \u0010:\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR \u0010=\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u000eR \u0010@\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\f\"\u0004\bB\u0010\u000eR\"\u0010C\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,R \u0010F\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\f\"\u0004\bH\u0010\u000eR \u0010I\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\f\"\u0004\bK\u0010\u000eR \u0010L\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006R"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopConfigInfoModuleDTO;", "Ljava/io/Serializable;", "()V", "cartEntryConfig", "Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;", "getCartEntryConfig", "()Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;", "setCartEntryConfig", "(Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;)V", "customServiceEntry", "", "getCustomServiceEntry", "()Ljava/lang/String;", "setCustomServiceEntry", "(Ljava/lang/String;)V", "customServiceEntryInfo", "Lcom/bytedance/android/shopping/store/home/entity/ServiceEntryInfo;", "getCustomServiceEntryInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ServiceEntryInfo;", "setCustomServiceEntryInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ServiceEntryInfo;)V", "displaySearch", "", "getDisplaySearch", "()Z", "setDisplaySearch", "(Z)V", "displayShopWindowEntry", "getDisplayShopWindowEntry", "setDisplayShopWindowEntry", "hideLiveInfo", "getHideLiveInfo", "()Ljava/lang/Boolean;", "setHideLiveInfo", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hideStoreDetailEntry", "getHideStoreDetailEntry", "setHideStoreDetailEntry", "liveStyle", "", "getLiveStyle", "()Ljava/lang/Integer;", "setLiveStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "moreEntryInfo", "Lcom/bytedance/android/shopping/store/home/entity/MoreEntryInfo;", "getMoreEntryInfo", "()Lcom/bytedance/android/shopping/store/home/entity/MoreEntryInfo;", "setMoreEntryInfo", "(Lcom/bytedance/android/shopping/store/home/entity/MoreEntryInfo;)V", "orderUrl", "getOrderUrl", "setOrderUrl", "productCount", "getProductCount", "setProductCount", "redirectSchema", "getRedirectSchema", "setRedirectSchema", "redpacketEntrance", "getRedpacketEntrance", "setRedpacketEntrance", "searchHint", "getSearchHint", "setSearchHint", "shopWindowProductCount", "getShopWindowProductCount", "setShopWindowProductCount", "shopWindowUrl", "getShopWindowUrl", "setShopWindowUrl", "storeDetailUrl", "getStoreDetailUrl", "setStoreDetailUrl", "topSearchInfo", "Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;", "getTopSearchInfo", "()Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;", "setTopSearchInfo", "(Lcom/bytedance/android/shopping/store/home/entity/ECTopSearchInfo;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopConfigInfoModuleDTO implements Serializable {

    @SerializedName("cart_entry_info")
    private StoreCartEntryConfig cartEntryConfig;

    @SerializedName("service_entry")
    private String customServiceEntry;

    @SerializedName("service_entry_info")
    private ServiceEntryInfo customServiceEntryInfo;

    @SerializedName("show_search")
    private boolean displaySearch;

    @SerializedName("product_shop_entry")
    private boolean displayShopWindowEntry;

    @SerializedName("hide_live_info")
    private Boolean hideLiveInfo;

    @SerializedName("hide_detail_entry")
    private boolean hideStoreDetailEntry;

    @SerializedName("live_style")
    private Integer liveStyle;

    @SerializedName("more_entrances")
    private MoreEntryInfo moreEntryInfo;

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

    @SerializedName("store_detail_url")
    private String storeDetailUrl;

    @SerializedName("top_search_info")
    private ECTopSearchInfo topSearchInfo;

    public ECShopConfigInfoModuleDTO() {
    }

    public final StoreCartEntryConfig getCartEntryConfig() {
        return this.cartEntryConfig;
    }

    public final String getCustomServiceEntry() {
        return this.customServiceEntry;
    }

    public final ServiceEntryInfo getCustomServiceEntryInfo() {
        return this.customServiceEntryInfo;
    }

    public final boolean getDisplaySearch() {
        return this.displaySearch;
    }

    public final boolean getDisplayShopWindowEntry() {
        return this.displayShopWindowEntry;
    }

    public final Boolean getHideLiveInfo() {
        return this.hideLiveInfo;
    }

    public final boolean getHideStoreDetailEntry() {
        return this.hideStoreDetailEntry;
    }

    public final Integer getLiveStyle() {
        return this.liveStyle;
    }

    public final MoreEntryInfo getMoreEntryInfo() {
        return this.moreEntryInfo;
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

    public final void setCustomServiceEntryInfo(ServiceEntryInfo r1) {
        this.customServiceEntryInfo = r1;
    }

    public final void setDisplaySearch(boolean r1) {
        this.displaySearch = r1;
    }

    public final void setDisplayShopWindowEntry(boolean r1) {
        this.displayShopWindowEntry = r1;
    }

    public final void setHideLiveInfo(Boolean r1) {
        this.hideLiveInfo = r1;
    }

    public final void setHideStoreDetailEntry(boolean r1) {
        this.hideStoreDetailEntry = r1;
    }

    public final void setLiveStyle(Integer r1) {
        this.liveStyle = r1;
    }

    public final void setMoreEntryInfo(MoreEntryInfo r1) {
        this.moreEntryInfo = r1;
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

    public final void setStoreDetailUrl(String r1) {
        this.storeDetailUrl = r1;
    }

    public final void setTopSearchInfo(ECTopSearchInfo r1) {
        this.topSearchInfo = r1;
    }
}
