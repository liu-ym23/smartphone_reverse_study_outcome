package dj3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldj3/j;", "", "", "Ldj3/b;", "productInfo", "Ljava/util/List;", "getProductInfo", "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("product_info")
    private final List<b> productInfo;

    public j() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.productInfo, ((j) r2).productInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<b> r0 = this.productInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ProductAppointInfoReq(productInfo=" + this.productInfo + ")";
    }

    public j(List<b> r1) {
        this.productInfo = r1;
    }
}
