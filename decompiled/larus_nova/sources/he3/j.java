package he3;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lhe3/j;", "", "", "couponValidityPeriod", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/google/gson/JsonElement;", "popupInfo", "Lcom/google/gson/JsonElement;", "c", "()Lcom/google/gson/JsonElement;", "Lhe3/i;", "extra", "Lhe3/i;", "b", "()Lhe3/i;", "Lhe3/m2;", "toast", "Lhe3/m2;", "d", "()Lhe3/m2;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("coupon_validity_period")
    private final String couponValidityPeriod;

    @SerializedName("extra")
    private final i extra;

    @SerializedName("popup")
    private final JsonElement popupInfo;

    @SerializedName("toast")
    private final m2 toast;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L14;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.couponValidityPeriod, r101.couponValidityPeriod) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popupInfo, r101.popupInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.couponValidityPeriod;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonElement r104 = this.popupInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.extra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        m2 r110 = this.toast;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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
