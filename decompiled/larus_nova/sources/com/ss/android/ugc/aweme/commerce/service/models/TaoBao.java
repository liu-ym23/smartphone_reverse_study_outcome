package com.ss.android.ugc.aweme.commerce.service.models;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/commerce/service/models/TaoBao;", "Ljava/io/Serializable;", AnchorBenefitToast.TYPE_COUPON, "Lcom/ss/android/ugc/aweme/commerce/service/models/TaobaoCouponInfo;", "(Lcom/ss/android/ugc/aweme/commerce/service/models/TaobaoCouponInfo;)V", "getCoupon", "()Lcom/ss/android/ugc/aweme/commerce/service/models/TaobaoCouponInfo;", "setCoupon", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaoBao implements Serializable {

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private TaobaoCouponInfo coupon;

    public static /* synthetic */ TaoBao copy$default(TaoBao r100, TaobaoCouponInfo r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.coupon;
    L6:
        return r100.copy(r101);
    }

    public final TaobaoCouponInfo component1() {
        return this.coupon;
    }

    public final TaoBao copy(TaobaoCouponInfo r100) {
        return new TaoBao(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaoBao) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.coupon, ((TaoBao) r100).coupon) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        TaobaoCouponInfo r100 = this.coupon;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "TaoBao(coupon=" + this.coupon + ')';
    }

    public final TaobaoCouponInfo getCoupon() {
        return this.coupon;
    }

    public TaoBao(TaobaoCouponInfo r100) {
        this.coupon = r100;
    }

    public final void setCoupon(TaobaoCouponInfo r100) {
        this.coupon = r100;
    }
}
