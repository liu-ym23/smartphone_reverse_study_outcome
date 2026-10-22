package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/ThirdCoupon;", "Ljava/io/Serializable;", "()V", "coupons", "", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/Coupon;", "getCoupons", "()Ljava/util/List;", "setCoupons", "(Ljava/util/List;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThirdCoupon implements Serializable {

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private List<Coupon> coupons;

    public ThirdCoupon() {
    }

    public final List<Coupon> getCoupons() {
        return this.coupons;
    }

    public final void setCoupons(List<Coupon> r100) {
        this.coupons = r100;
    }
}
