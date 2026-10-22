package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopCartInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "Lsj3/n;", "bottomLabel", "Lsj3/n;", "getBottomLabel", "()Lsj3/n;", "setBottomLabel", "(Lsj3/n;)V", "slideLabel", "getSlideLabel", "setSlideLabel", "productImg", "getProductImg", "setProductImg", "", "cartSchema", "Ljava/lang/String;", "getCartSchema", "()Ljava/lang/String;", "setCartSchema", "(Ljava/lang/String;)V", "Lcom/bytedance/android/shopping/store/home/entity/CartCtrlInfo;", "cartCtrlInfo", "Lcom/bytedance/android/shopping/store/home/entity/CartCtrlInfo;", "getCartCtrlInfo", "()Lcom/bytedance/android/shopping/store/home/entity/CartCtrlInfo;", "setCartCtrlInfo", "(Lcom/bytedance/android/shopping/store/home/entity/CartCtrlInfo;)V", "", "bizExtra", "Ljava/util/Map;", "getBizExtra", "()Ljava/util/Map;", "setBizExtra", "(Ljava/util/Map;)V", "logExtra", "getLogExtra", "setLogExtra", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopCartInfo implements Serializable {

    @SerializedName("biz_extra")
    private Map<String, String> bizExtra;

    @SerializedName("bottom_label")
    private sj3.n bottomLabel;

    @SerializedName("ctrl")
    private CartCtrlInfo cartCtrlInfo;

    @SerializedName("cart_schema")
    private String cartSchema;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("product_img")
    private ECUrlModel productImg;

    @SerializedName("slide_label")
    private sj3.n slideLabel;

    public ECShopCartInfo() {
    }

    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }

    public final sj3.n getBottomLabel() {
        return this.bottomLabel;
    }

    public final CartCtrlInfo getCartCtrlInfo() {
        return this.cartCtrlInfo;
    }

    public final String getCartSchema() {
        return this.cartSchema;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final ECUrlModel getProductImg() {
        return this.productImg;
    }

    public final sj3.n getSlideLabel() {
        return this.slideLabel;
    }

    public final void setBizExtra(Map<String, String> r1) {
        this.bizExtra = r1;
    }

    public final void setBottomLabel(sj3.n r1) {
        this.bottomLabel = r1;
    }

    public final void setCartCtrlInfo(CartCtrlInfo r1) {
        this.cartCtrlInfo = r1;
    }

    public final void setCartSchema(String r1) {
        this.cartSchema = r1;
    }

    public final void setIcon(ECUrlModel r1) {
        this.icon = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setProductImg(ECUrlModel r1) {
        this.productImg = r1;
    }

    public final void setSlideLabel(sj3.n r1) {
        this.slideLabel = r1;
    }
}
