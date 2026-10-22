package jv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Ljv6/j;", "", "", "couponAmount", "Ljava/lang/Long;", "getCouponAmount", "()Ljava/lang/Long;", "couponId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "couponType", "b", "drawStartTime", "getDrawStartTime", "fullAmount", "getFullAmount", "drawEndTime", "getDrawEndTime", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("coupon_amount")
    private final Long couponAmount;

    @SerializedName("coupon_id")
    private final Long couponId;

    @SerializedName("coupon_period_type")
    private final Long couponType;

    @SerializedName("draw_end_time")
    private final Long drawEndTime;

    @SerializedName("draw_start_time")
    private final Long drawStartTime;

    @SerializedName("full_amount")
    private final Long fullAmount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.couponAmount, r101.couponAmount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponId, r101.couponId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.couponType, r101.couponType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.drawStartTime, r101.drawStartTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fullAmount, r101.fullAmount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.drawEndTime, r101.drawEndTime) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.couponAmount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.couponId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.couponType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.drawStartTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.fullAmount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.drawEndTime;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareCouponInfo(couponAmount=" + this.couponAmount + ", couponId=" + this.couponId + ", couponType=" + this.couponType + ", drawStartTime=" + this.drawStartTime + ", fullAmount=" + this.fullAmount + ", drawEndTime=" + this.drawEndTime + ')';
    }

    public j() {
        this.couponAmount = 0L;
        this.couponId = 0L;
        this.couponType = 0L;
        this.drawStartTime = 0L;
        this.fullAmount = 0L;
        this.drawEndTime = 0L;
    }

    public final Long a() {
        return this.couponId;
    }

    public final Long b() {
        return this.couponType;
    }
}
