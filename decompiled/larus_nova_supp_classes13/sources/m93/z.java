package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lm93/z;", "", "promoLight", "Ljava/lang/Object;", "getPromoLight", "()Ljava/lang/Object;", "promoDark", "getPromoDark", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("promo_dark")
    private final Object promoDark;

    @SerializedName("promo_light")
    private final Object promoLight;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z) == false) goto L10;
        z r4 = (z) r3;
        if (Intrinsics.areEqual(this.promoLight, r4.promoLight) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promoDark, r4.promoDark) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Object r0 = this.promoLight;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.promoDark;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "Theme(promoLight=" + this.promoLight + ", promoDark=" + this.promoDark + ")";
    }

    public z() {
        this.promoLight = null;
        this.promoDark = null;
    }
}
