package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lm93/t;", "", "", "a", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "type", "minPrice", "getMinPrice", "maxPrice", "getMaxPrice", "marketPrice", "getMarketPrice", "", "typeText", "Ljava/lang/String;", "getTypeText", "()Ljava/lang/String;", "originalPrice", "getOriginalPrice", "showPrice", "getShowPrice", "showPriceType", "getShowPriceType", "showSkuId", "getShowSkuId", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {
    public final Long a;

    @SerializedName("market_price")
    private final Long marketPrice;

    @SerializedName("max_price")
    private final Long maxPrice;

    @SerializedName("min_price")
    private final Long minPrice;

    @SerializedName("original_price")
    private final Long originalPrice;

    @SerializedName("show_price")
    private final Long showPrice;

    @SerializedName("show_price_type")
    private final String showPriceType;

    @SerializedName("show_sku_id")
    private final String showSkuId;

    @SerializedName("type_text")
    private final String typeText;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t) == false) goto L24;
        t r4 = (t) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.minPrice, r4.minPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxPrice, r4.maxPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marketPrice, r4.marketPrice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.typeText, r4.typeText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.originalPrice, r4.originalPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showPrice, r4.showPrice) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.showPriceType, r4.showPriceType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.showSkuId, r4.showSkuId) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.minPrice;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.maxPrice;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.marketPrice;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.typeText;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.originalPrice;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.showPrice;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.showPriceType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.showSkuId;
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
        return "NewerPrice(type=" + this.a + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", marketPrice=" + this.marketPrice + ", typeText=" + this.typeText + ", originalPrice=" + this.originalPrice + ", showPrice=" + this.showPrice + ", showPriceType=" + this.showPriceType + ", showSkuId=" + this.showSkuId + ")";
    }

    public t() {
        this.a = null;
        this.minPrice = null;
        this.maxPrice = null;
        this.marketPrice = null;
        this.typeText = null;
        this.originalPrice = null;
        this.showPrice = null;
        this.showPriceType = null;
        this.showSkuId = null;
    }

    public final Long getType() {
        return this.a;
    }
}
