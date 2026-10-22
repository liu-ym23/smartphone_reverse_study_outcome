package com.bytedance.android.shopping.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/dto/TaoBao;", "Ljava/io/Serializable;", "coupon", "Lcom/bytedance/android/shopping/dto/TaobaoCouponInfo;", "(Lcom/bytedance/android/shopping/dto/TaobaoCouponInfo;)V", "getCoupon", "()Lcom/bytedance/android/shopping/dto/TaobaoCouponInfo;", "setCoupon", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TaoBao implements Serializable {

    @SerializedName("coupon")
    private TaobaoCouponInfo coupon;

    public static /* synthetic */ TaoBao copy$default(TaoBao r0, TaobaoCouponInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.coupon;
    L6:
        return r0.copy(r1);
    }

    public final TaobaoCouponInfo component1() {
        return this.coupon;
    }

    public final TaoBao copy(TaobaoCouponInfo r2) {
        return new TaoBao(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof TaoBao) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.coupon, ((TaoBao) r2).coupon) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        TaobaoCouponInfo r0 = this.coupon;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "TaoBao(coupon=" + this.coupon + ")";
    }

    public final TaobaoCouponInfo getCoupon() {
        return this.coupon;
    }

    public TaoBao(TaobaoCouponInfo r1) {
        this.coupon = r1;
    }

    public final void setCoupon(TaobaoCouponInfo r1) {
        this.coupon = r1;
    }
}
