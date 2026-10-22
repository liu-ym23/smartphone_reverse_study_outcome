package he3;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/j;", "", "", "couponValidityPeriod", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lcom/google/gson/JsonElement;", "popupInfo", "Lcom/google/gson/JsonElement;", "c", "()Lcom/google/gson/JsonElement;", "Lhe3/i;", "extra", "Lhe3/i;", "b", "()Lhe3/i;", "Lhe3/m2;", "toast", "Lhe3/m2;", "d", "()Lhe3/m2;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("coupon_validity_period")
    private final String couponValidityPeriod;

    @SerializedName("extra")
    private final i extra;

    @SerializedName("popup")
    private final JsonElement popupInfo;

    @SerializedName("toast")
    private final m2 toast;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L14;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.couponValidityPeriod, r4.couponValidityPeriod) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popupInfo, r4.popupInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toast, r4.toast) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.couponValidityPeriod;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        JsonElement r4 = this.popupInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        i r7 = this.extra;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        m2 r10 = this.toast;
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
        return "DeepFeedCouponApplyResp(couponValidityPeriod=" + this.couponValidityPeriod + ", popupInfo=" + this.popupInfo + ", extra=" + this.extra + ", toast=" + this.toast + ")";
    }

    public j() {
        this.couponValidityPeriod = null;
        this.popupInfo = null;
        this.extra = null;
        this.toast = null;
    }

    public final String a() {
        return this.couponValidityPeriod;
    }

    public final i b() {
        return this.extra;
    }

    public final JsonElement c() {
        return this.popupInfo;
    }

    public final m2 d() {
        return this.toast;
    }
}
