package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lm93/p;", "", "", "productPreInfo", "Ljava/lang/String;", "getProductPreInfo", "()Ljava/lang/String;", "purchaseStatus", "getPurchaseStatus", "recReasons", "getRecReasons", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("product_pre_info")
    private final String productPreInfo;

    @SerializedName("purchase_status")
    private final String purchaseStatus;

    @SerializedName("rec_reasons")
    private final String recReasons;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L12;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.productPreInfo, r4.productPreInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.purchaseStatus, r4.purchaseStatus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.recReasons, r4.recReasons) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.productPreInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.purchaseStatus;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.recReasons;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "NewerExtra(productPreInfo=" + this.productPreInfo + ", purchaseStatus=" + this.purchaseStatus + ", recReasons=" + this.recReasons + ")";
    }

    public p() {
        this.productPreInfo = null;
        this.purchaseStatus = null;
        this.recReasons = null;
    }
}
