package com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/cpscard/Coupon;", "", "()V", "discountDesc", "", "getDiscountDesc", "()Ljava/lang/String;", "setDiscountDesc", "(Ljava/lang/String;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Coupon {

    @SerializedName("discount_desc")
    private String discountDesc;

    public Coupon() {
        this.discountDesc = "";
    }

    public final String getDiscountDesc() {
        return this.discountDesc;
    }

    public final void setDiscountDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.discountDesc = r100;
    }
}
