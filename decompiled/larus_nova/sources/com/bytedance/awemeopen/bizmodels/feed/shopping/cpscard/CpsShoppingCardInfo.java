package com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/CpsShoppingCardInfo;", "Ljava/io/Serializable;", "()V", "deepLink", "", "getDeepLink", "()Ljava/lang/String;", "setDeepLink", "(Ljava/lang/String;)V", "productDetail", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/ProductDetail;", "getProductDetail", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/ProductDetail;", "setProductDetail", "(Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/ProductDetail;)V", "productDetailStringType", "getProductDetailStringType$ao_biz_models_release", "setProductDetailStringType$ao_biz_models_release", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CpsShoppingCardInfo implements Serializable {

    @SerializedName(ComplianceResult.JsonKey.MARKET_DEEP_LINK)
    private String deepLink;
    private ProductDetail productDetail;

    @SerializedName(a.VALUE_PRODUCT_DETAIL)
    private String productDetailStringType;

    public CpsShoppingCardInfo() {
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final ProductDetail getProductDetail() {
        return this.productDetail;
    }

    public final String getProductDetailStringType$ao_biz_models_release() {
        return this.productDetailStringType;
    }

    public final void setDeepLink(String r100) {
        this.deepLink = r100;
    }

    public final void setProductDetail(ProductDetail r100) {
        this.productDetail = r100;
    }

    public final void setProductDetailStringType$ao_biz_models_release(String r100) {
        this.productDetailStringType = r100;
    }
}
