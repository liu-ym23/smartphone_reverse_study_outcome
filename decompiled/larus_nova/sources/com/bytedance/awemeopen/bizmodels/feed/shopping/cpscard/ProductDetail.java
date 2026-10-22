package com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\"\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R \u0010+\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u001e\u00103\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R \u00106\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/¨\u00069"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/ProductDetail;", "", "()V", "availableCoupons", "", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/Coupon;", "getAvailableCoupons", "()Ljava/util/List;", "setAvailableCoupons", "(Ljava/util/List;)V", "commentNum", "", "getCommentNum", "()Ljava/lang/Integer;", "setCommentNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "commodityActivityId", "getCommodityActivityId", "setCommodityActivityId", "couponPrice", "", "getCouponPrice", "()Ljava/lang/Long;", "setCouponPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "imgUrls", "", "getImgUrls", "setImgUrls", "inStock", "", "getInStock", "()Ljava/lang/Boolean;", "setInStock", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isAssured", "setAssured", "price", "getPrice", "setPrice", "productId", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", SalesInfoStruct.SALES, "getSales", "setSales", "shopName", "getShopName", "setShopName", "title", "getTitle", d.f25925o, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProductDetail {

    @SerializedName("available_coupons")
    private List<Coupon> availableCoupons;

    @SerializedName(a.KEY_COMMENT_NUM)
    private Integer commentNum;

    @SerializedName("activity_id")
    private Integer commodityActivityId;

    @SerializedName("coupon_price")
    private Long couponPrice;

    @SerializedName("imgs")
    private List<String> imgUrls;

    @SerializedName("in_stock")
    private Boolean inStock;

    @SerializedName("is_assured")
    private Boolean isAssured;

    @SerializedName("price")
    private Long price;

    @SerializedName("product_id")
    private String productId;

    @SerializedName(SalesInfoStruct.SALES)
    private Integer sales;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("title")
    private String title;

    public ProductDetail() {
        this.shopName = "";
    }

    public final List<Coupon> getAvailableCoupons() {
        return this.availableCoupons;
    }

    public final Integer getCommentNum() {
        return this.commentNum;
    }

    public final Integer getCommodityActivityId() {
        return this.commodityActivityId;
    }

    public final Long getCouponPrice() {
        return this.couponPrice;
    }

    public final List<String> getImgUrls() {
        return this.imgUrls;
    }

    public final Boolean getInStock() {
        return this.inStock;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Integer getSales() {
        return this.sales;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isAssured() {
        return this.isAssured;
    }

    public final void setAssured(Boolean r100) {
        this.isAssured = r100;
    }

    public final void setAvailableCoupons(List<Coupon> r100) {
        this.availableCoupons = r100;
    }

    public final void setCommentNum(Integer r100) {
        this.commentNum = r100;
    }

    public final void setCommodityActivityId(Integer r100) {
        this.commodityActivityId = r100;
    }

    public final void setCouponPrice(Long r100) {
        this.couponPrice = r100;
    }

    public final void setImgUrls(List<String> r100) {
        this.imgUrls = r100;
    }

    public final void setInStock(Boolean r100) {
        this.inStock = r100;
    }

    public final void setPrice(Long r100) {
        this.price = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setSales(Integer r100) {
        this.sales = r100;
    }

    public final void setShopName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shopName = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
