package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/Coupon;", "Ljava/io/Serializable;", "()V", "couponAmount", "", "getCouponAmount", "()Ljava/lang/String;", "setCouponAmount", "(Ljava/lang/String;)V", "couponText", "getCouponText", "setCouponText", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Coupon implements Serializable {

    @SerializedName("coupon_amount")
    private String couponAmount;

    @SerializedName("coupon_text")
    private String couponText;

    public Coupon() {
    }

    public final String getCouponAmount() {
        return this.couponAmount;
    }

    public final String getCouponText() {
        return this.couponText;
    }

    public final void setCouponAmount(String r100) {
        this.couponAmount = r100;
    }

    public final void setCouponText(String r100) {
        this.couponText = r100;
    }
}
