package uh3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Luh3/b;", "", "", "skuId", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "", "price", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "priceHeader", "e", "discountPrice", "b", "discountPriceHeader", "c", "regularPrice", "g", "Luh3/a;", "additionModulesData", "Luh3/a;", "a", "()Luh3/a;", "productActivityType", "f", "upfrontPresell", "i", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("addition_modules_data")
    private final a additionModulesData;

    @SerializedName("discount_price")
    private final Long discountPrice;

    @SerializedName("discount_price_header")
    private final String discountPriceHeader;

    @SerializedName("price")
    private final Long price;

    @SerializedName("price_header")
    private final String priceHeader;

    @SerializedName("product_activity_type")
    private final String productActivityType;

    @SerializedName("regular_price")
    private final Long regularPrice;

    @SerializedName("sku_id")
    private final String skuId;

    @SerializedName("upfront_presell")
    private final String upfrontPresell;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L24;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.skuId, r4.skuId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceHeader, r4.priceHeader) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.discountPrice, r4.discountPrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.discountPriceHeader, r4.discountPriceHeader) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.regularPrice, r4.regularPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.additionModulesData, r4.additionModulesData) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productActivityType, r4.productActivityType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.upfrontPresell, r4.upfrontPresell) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r0 = this.skuId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.price;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.priceHeader;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.discountPrice;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.discountPriceHeader;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.regularPrice;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        a r19 = this.additionModulesData;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.productActivityType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.upfrontPresell;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "SkuItem(skuId=" + this.skuId + ", price=" + this.price + ", priceHeader=" + this.priceHeader + ", discountPrice=" + this.discountPrice + ", discountPriceHeader=" + this.discountPriceHeader + ", regularPrice=" + this.regularPrice + ", additionModulesData=" + this.additionModulesData + ", productActivityType=" + this.productActivityType + ", upfrontPresell=" + this.upfrontPresell + ")";
    }

    public b() {
        this.skuId = null;
        this.price = null;
        this.priceHeader = null;
        this.discountPrice = null;
        this.discountPriceHeader = null;
        this.regularPrice = null;
        this.additionModulesData = null;
        this.productActivityType = null;
        this.upfrontPresell = null;
    }

    public final a a() {
        return this.additionModulesData;
    }

    public final Long b() {
        return this.discountPrice;
    }

    public final String c() {
        return this.discountPriceHeader;
    }

    public final Long d() {
        return this.price;
    }

    public final String e() {
        return this.priceHeader;
    }

    public final String f() {
        return this.productActivityType;
    }

    public final Long g() {
        return this.regularPrice;
    }

    public final String h() {
        return this.skuId;
    }

    public final String i() {
        return this.upfrontPresell;
    }
}
