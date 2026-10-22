package dj3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldj3/a;", "", "", "couponMetaId", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "errorCode", "getErrorCode", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("coupon_meta_id")
    private final Long couponMetaId;

    @SerializedName("error_code")
    private final Long errorCode;

    @SerializedName("error_msg")
    private final String errorMsg;

    @SerializedName("coupon_id")
    private final List<Long> list;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.couponMetaId, r4.couponMetaId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.list, r4.list) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.errorCode, r4.errorCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMsg, r4.errorMsg) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.couponMetaId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<Long> r4 = this.list;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.errorCode;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.errorMsg;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ApplyCouponMetaRespItem(couponMetaId=" + this.couponMetaId + ", list=" + this.list + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }

    public a() {
        this.couponMetaId = null;
        this.list = null;
        this.errorCode = null;
        this.errorMsg = null;
    }

    public final Long a() {
        return this.couponMetaId;
    }
}
