package yd3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lyd3/n;", "", "", "price", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "", "pricePrefix", "Ljava/lang/String;", "getPricePrefix", "()Ljava/lang/String;", "marketPrice", "getMarketPrice", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("market_price")
    private final String marketPrice;

    @SerializedName("price")
    private final Long price;

    @SerializedName("price_prefix")
    private final String pricePrefix;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L12;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pricePrefix, r4.pricePrefix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.marketPrice, r4.marketPrice) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.price;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.pricePrefix;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.marketPrice;
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
        return "PriceInfo(price=" + this.price + ", pricePrefix=" + this.pricePrefix + ", marketPrice=" + this.marketPrice + ")";
    }

    public n() {
        this.price = null;
        this.pricePrefix = null;
        this.marketPrice = null;
    }

    public final Long a() {
        return this.price;
    }
}
