package sh2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsh2/b;", "", "", "promotionId", "J", "getPromotionId", "()J", "productId", "getProductId", "explainTime", "getExplainTime", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("explain_time")
    private final long explainTime;

    @SerializedName("product_id")
    private final long productId;

    @SerializedName("promotion_id")
    private final long promotionId;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L12;
        b r7 = (b) r6;
        if (this.promotionId == r7.promotionId) goto L8;
        return false;
    L8:
        if (this.productId == r7.productId) goto L10;
        return false;
    L10:
        if (this.explainTime == r7.explainTime) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.promotionId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.productId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.explainTime;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "IntroPopProductInfo(promotionId=" + this.promotionId + ", productId=" + this.productId + ", explainTime=" + this.explainTime + ")";
    }

    public b() {
        this(0, 0, 0);
    }

    public b(long r1, long r3, long r5) {
        this.promotionId = r1;
        this.productId = r3;
        this.explainTime = r5;
    }
}
