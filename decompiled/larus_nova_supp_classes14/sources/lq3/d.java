package lq3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Llq3/d;", "", "", "couponMetaId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "promotionId", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("coupon_meta_id")
    private final String couponMetaId;

    @SerializedName("promotion_id")
    private final String promotionId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L10;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.couponMetaId, r4.couponMetaId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r4.promotionId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.couponMetaId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.promotionId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SceneParamFansCoupon(couponMetaId=" + this.couponMetaId + ", promotionId=" + this.promotionId + ")";
    }

    public final String a() {
        return this.couponMetaId;
    }

    public final String b() {
        return this.promotionId;
    }

    public d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "couponMetaId");
        Intrinsics.checkNotNullParameter(r3, "promotionId");
        this.couponMetaId = r2;
        this.promotionId = r3;
    }
}
