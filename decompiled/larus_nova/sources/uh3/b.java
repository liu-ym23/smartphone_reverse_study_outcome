package uh3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Luh3/b;", "", "", "skuId", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "", "price", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "priceHeader", "e", "discountPrice", "b", "discountPriceHeader", "c", "regularPrice", ce.f26391f, "Luh3/a;", "additionModulesData", "Luh3/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Luh3/a;", "productActivityType", "f", "upfrontPresell", RXScreenCaptureService.KEY_INDEX, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ACTIVITY_TYPE)
    private final String productActivityType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    private final Long regularPrice;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL)
    private final String upfrontPresell;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceHeader, r101.priceHeader) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.discountPriceHeader, r101.discountPriceHeader) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.regularPrice, r101.regularPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.additionModulesData, r101.additionModulesData) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.productActivityType, r101.productActivityType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.upfrontPresell, r101.upfrontPresell) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.skuId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.price;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.priceHeader;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.discountPrice;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.discountPriceHeader;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.regularPrice;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        a r119 = this.additionModulesData;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.productActivityType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.upfrontPresell;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
