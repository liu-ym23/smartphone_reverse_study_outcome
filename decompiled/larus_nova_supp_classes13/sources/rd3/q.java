package rd3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lrd3/q;", "", "", "availableAmount", "Ljava/lang/String;", "getAvailableAmount", "()Ljava/lang/String;", "Lkotlin/ULong;", "earliestAvailableExpiredTime", "J", "getEarliestAvailableExpiredTime-s-VKNKU", "()J", "serverTime", "getServerTime-s-VKNKU", "Lrd3/r;", "clickToast", "Lrd3/r;", "getClickToast", "()Lrd3/r;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("available_amount")
    private final String availableAmount;

    @SerializedName("click_toast")
    private final r clickToast;

    @SerializedName("earliest_available_expired_time")
    private final long earliestAvailableExpiredTime;

    @SerializedName("server_time")
    private final long serverTime;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof q) == false) goto L14;
        q r7 = (q) r6;
        if (Intrinsics.areEqual(this.availableAmount, r7.availableAmount) == true) goto L8;
        return false;
    L8:
        if (this.earliestAvailableExpiredTime == r7.earliestAvailableExpiredTime) goto L10;
        return false;
    L10:
        if (this.serverTime == r7.serverTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clickToast, r7.clickToast) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.availableAmount;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.earliestAvailableExpiredTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.serverTime;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        r r7 = this.clickToast;
        if (r7 == null) goto L10;
        r1 = r7.hashCode();
    L10:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RedPacketBanner(availableAmount=" + this.availableAmount + ", earliestAvailableExpiredTime=" + ULong.toString-impl(this.earliestAvailableExpiredTime) + ", serverTime=" + ULong.toString-impl(this.serverTime) + ", clickToast=" + this.clickToast + ")";
    }
}
