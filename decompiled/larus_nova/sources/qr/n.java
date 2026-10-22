package qr;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lqr/n;", "", "", "productId", "Ljava/lang/Long;", "getProductId", "()Ljava/lang/Long;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("product_id")
    private final Long productId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.productId, ((n) r100).productId) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.productId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LiveMsgPromotionFlush(productId=" + this.productId + ")";
    }

    public n() {
        this.productId = null;
    }
}
