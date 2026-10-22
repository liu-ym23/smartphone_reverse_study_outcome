package jx6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Ljx6/t;", "", "", "actualPrice", "I", "getActualPrice", "()I", "", "canShowDiscount", "Z", "getCanShowDiscount", "()Z", "canShowOriginPrice", "getCanShowOriginPrice", "", "discountPriceInfo", "Ljava/lang/String;", "getDiscountPriceInfo", "()Ljava/lang/String;", "originPrice", "getOriginPrice", "skuPostTicketPrice", "getSkuPostTicketPrice", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("actualPrice")
    private final int actualPrice;

    @SerializedName("canShowDiscount")
    private final boolean canShowDiscount;

    @SerializedName("canShowOriginPrice")
    private final boolean canShowOriginPrice;

    @SerializedName("discountPriceInfo")
    private final String discountPriceInfo;

    @SerializedName("originPrice")
    private final int originPrice;

    @SerializedName("skuPostTicketPrice")
    private final int skuPostTicketPrice;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.actualPrice == r101.actualPrice) goto L12;
        return false;
    L12:
        if (this.canShowDiscount == r101.canShowDiscount) goto L15;
        return false;
    L15:
        if (this.canShowOriginPrice == r101.canShowOriginPrice) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPriceInfo, r101.discountPriceInfo) == true) goto L21;
        return false;
    L21:
        if (this.originPrice == r101.originPrice) goto L24;
        return false;
    L24:
        if (this.skuPostTicketPrice == r101.skuPostTicketPrice) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.actualPrice * 31;
        int r101 = 1231;
        if (this.canShowDiscount == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.canShowOriginPrice == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.discountPriceInfo;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return ((((r104 + r106) * 31) + this.originPrice) * 31) + this.skuPostTicketPrice;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PriceInfo(actualPrice=" + this.actualPrice + ", canShowDiscount=" + this.canShowDiscount + ", canShowOriginPrice=" + this.canShowOriginPrice + ", discountPriceInfo=" + this.discountPriceInfo + ", originPrice=" + this.originPrice + ", skuPostTicketPrice=" + this.skuPostTicketPrice + ')';
    }

    public t() {
        this.actualPrice = 0;
        this.canShowDiscount = false;
        this.canShowOriginPrice = false;
        this.discountPriceInfo = null;
        this.originPrice = 0;
        this.skuPostTicketPrice = 0;
    }
}
