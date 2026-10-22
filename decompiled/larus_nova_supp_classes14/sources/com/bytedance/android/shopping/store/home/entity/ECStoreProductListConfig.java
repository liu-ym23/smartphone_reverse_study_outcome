package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b5\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bD\u0010ER$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00102\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR$\u0010>\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R$\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\b¨\u0006H"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreProductListConfig;", "Ljava/io/Serializable;", "", "materialId", "Ljava/lang/String;", "getMaterialId", "()Ljava/lang/String;", "setMaterialId", "(Ljava/lang/String;)V", "", "goodsType", "Ljava/lang/Long;", "getGoodsType", "()Ljava/lang/Long;", "setGoodsType", "(Ljava/lang/Long;)V", "sortType", "getSortType", "setSortType", "", "sort", "Ljava/lang/Integer;", "getSort", "()Ljava/lang/Integer;", "setSort", "(Ljava/lang/Integer;)V", "keyWord", "getKeyWord", "setKeyWord", "cursor", "getCursor", "setCursor", "size", "getSize", "setSize", "tmpId", "getTmpId", "setTmpId", "token", "getToken", "setToken", "passThroughApi", "getPassThroughApi", "setPassThroughApi", "entrances", "getEntrances", "setEntrances", "customIds", "getCustomIds", "setCustomIds", "customIdType", "getCustomIdType", "setCustomIdType", "selectParams", "getSelectParams", "setSelectParams", "clickProducts", "getClickProducts", "setClickProducts", "shuffleProductIds", "getShuffleProductIds", "setShuffleProductIds", "pickType", "getPickType", "setPickType", "tabVisitHis", "getTabVisitHis", "setTabVisitHis", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreProductListConfig implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("click_products")
    private String clickProducts;

    @SerializedName("cursor")
    private Long cursor;

    @SerializedName("custom_id_type")
    private Integer customIdType;

    @SerializedName("custom_ids")
    private String customIds;

    @SerializedName("entrances")
    private String entrances;

    @SerializedName("goods_type")
    private Long goodsType;

    @SerializedName("key_word")
    private String keyWord;

    @SerializedName("material_id")
    private String materialId;

    @SerializedName("pass_through_api")
    private String passThroughApi;

    @SerializedName("pick_type")
    private Integer pickType;

    @SerializedName("select_params")
    private String selectParams;

    @SerializedName("shuffle_product_ids")
    private String shuffleProductIds;

    @SerializedName("size")
    private Long size;

    @SerializedName("sort")
    private Integer sort;

    @SerializedName("sort_type")
    private Long sortType;

    @SerializedName("tab_visit_his")
    private String tabVisitHis;

    @SerializedName("tmp_id")
    private String tmpId;

    @SerializedName("token")
    private String token;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreProductListConfig() {
        this.tabVisitHis = "";
    }

    public final String getClickProducts() {
        return this.clickProducts;
    }

    public final Long getCursor() {
        return this.cursor;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getEntrances() {
        return this.entrances;
    }

    public final Long getGoodsType() {
        return this.goodsType;
    }

    public final String getKeyWord() {
        return this.keyWord;
    }

    public final String getMaterialId() {
        return this.materialId;
    }

    public final String getPassThroughApi() {
        return this.passThroughApi;
    }

    public final Integer getPickType() {
        return this.pickType;
    }

    public final String getSelectParams() {
        return this.selectParams;
    }

    public final String getShuffleProductIds() {
        return this.shuffleProductIds;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Integer getSort() {
        return this.sort;
    }

    public final Long getSortType() {
        return this.sortType;
    }

    public final String getTabVisitHis() {
        return this.tabVisitHis;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setClickProducts(String r1) {
        this.clickProducts = r1;
    }

    public final void setCursor(Long r1) {
        this.cursor = r1;
    }

    public final void setCustomIdType(Integer r1) {
        this.customIdType = r1;
    }

    public final void setCustomIds(String r1) {
        this.customIds = r1;
    }

    public final void setEntrances(String r1) {
        this.entrances = r1;
    }

    public final void setGoodsType(Long r1) {
        this.goodsType = r1;
    }

    public final void setKeyWord(String r1) {
        this.keyWord = r1;
    }

    public final void setMaterialId(String r1) {
        this.materialId = r1;
    }

    public final void setPassThroughApi(String r1) {
        this.passThroughApi = r1;
    }

    public final void setPickType(Integer r1) {
        this.pickType = r1;
    }

    public final void setSelectParams(String r1) {
        this.selectParams = r1;
    }

    public final void setShuffleProductIds(String r1) {
        this.shuffleProductIds = r1;
    }

    public final void setSize(Long r1) {
        this.size = r1;
    }

    public final void setSort(Integer r1) {
        this.sort = r1;
    }

    public final void setSortType(Long r1) {
        this.sortType = r1;
    }

    public final void setTabVisitHis(String r1) {
        this.tabVisitHis = r1;
    }

    public final void setTmpId(String r1) {
        this.tmpId = r1;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }
}
