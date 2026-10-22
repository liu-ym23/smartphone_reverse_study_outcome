package com.bytedance.android.shopping.store.home.presenter;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/SlideHintConfig;", "Ljava/io/Serializable;", "()V", "productShowNum", "", "getProductShowNum", "()Ljava/lang/Integer;", "setProductShowNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "productTotalNum", "getProductTotalNum", "setProductTotalNum", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlideHintConfig implements Serializable {

    @SerializedName("product_show_num")
    private Integer productShowNum;

    @SerializedName("product_total_num")
    private Integer productTotalNum;

    public SlideHintConfig() {
    }

    public final Integer getProductShowNum() {
        return this.productShowNum;
    }

    public final Integer getProductTotalNum() {
        return this.productTotalNum;
    }

    public final void setProductShowNum(Integer r1) {
        this.productShowNum = r1;
    }

    public final void setProductTotalNum(Integer r1) {
        this.productTotalNum = r1;
    }
}
