package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.math.RoundingMode;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\rJ$\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003J \u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0003H\u0002J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "", "type", "", "minPrice", "", "maxPrice", "marketPrice", "typeText", "", "originalPrice", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)V", "getMarketPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMaxPrice", "getMinPrice", "getOriginalPrice", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTypeText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/PriceStruct;", "equals", "", "other", "getPrice", "getPromoPrice", "showTenThous", "integerLenLimit", "format", "getRealFormat", "price", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriceStruct {

    @SerializedName("market_price")
    private final Double marketPrice;

    @SerializedName("max_price")
    private final Double maxPrice;

    @SerializedName("min_price")
    private final Double minPrice;

    @SerializedName("original_price")
    private final Double originalPrice;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("type_text")
    private final String typeText;

    public PriceStruct() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PriceStruct copy$default(PriceStruct r4, Integer r5, Double r6, Double r7, Double r8, String r9, Double r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.type;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.minPrice;
    L8:
        Double r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.maxPrice;
    L11:
        Double r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.marketPrice;
    L14:
        Double r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.typeText;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.originalPrice;
    L20:
        Integer r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Integer component1() {
        return this.type;
    }

    public final Double component2() {
        return this.minPrice;
    }

    public final Double component3() {
        return this.maxPrice;
    }

    public final Double component4() {
        return this.marketPrice;
    }

    public final String component5() {
        return this.typeText;
    }

    public final Double component6() {
        return this.originalPrice;
    }

    public final PriceStruct copy(Integer r9, Double r10, Double r11, Double r12, String r13, Double r14) {
        return new PriceStruct(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PriceStruct) == false) goto L18;
        PriceStruct r4 = (PriceStruct) r3;
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
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
        if (Intrinsics.areEqual(this.originalPrice, r4.originalPrice) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.type;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Double r4 = this.minPrice;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.maxPrice;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.marketPrice;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.typeText;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Double r16 = this.originalPrice;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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

    public String toString() {
        return "PriceStruct(type=" + this.type + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", marketPrice=" + this.marketPrice + ", typeText=" + this.typeText + ", originalPrice=" + this.originalPrice + ")";
    }

    private final Double getPrice() {
        Double r0 = this.minPrice;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.marketPrice;
    }

    public final Double getMarketPrice() {
        return this.marketPrice;
    }

    public final Double getMaxPrice() {
        return this.maxPrice;
    }

    public final Double getMinPrice() {
        return this.minPrice;
    }

    public final Double getOriginalPrice() {
        return this.originalPrice;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getTypeText() {
        return this.typeText;
    }

    private final int getRealFormat(int r5, double r6, int r8) {
        if (((int) (r6 / ((double) 1000000))) <= Math.pow(10.0d, r5 + 1)) goto L6;
        return 0;
    L6:
        return r8;
    }

    public final String getPromoPrice(boolean r9, int r10, int r11) {
        Double r0 = getPrice();
        if (r0 == null) goto L12;
        double r1 = r0.doubleValue();
        NumberFormat r2 = NumberFormat.getNumberInstance();
        r2.setGroupingUsed(false);
        r2.setRoundingMode(RoundingMode.DOWN);
        double r3 = r1 / ((double) 100);
        if (r3 >= 0.1d) goto L7;
        r2.setMaximumFractionDigits(2);
        return r2.format(r1);
    L7:
        double r5 = 1000000;
        if (r1 < r5) goto L11;
        if (r9 == false) goto L11;
        double r4 = r1 / r5;
        r2.setMaximumFractionDigits(getRealFormat(r10, r4, r11));
        return r2.format(r4) + 19975;
    L11:
        r2.setMaximumFractionDigits(getRealFormat(r10, r3, r11));
        return r2.format(r3);
    L12:
        return "0.0";
    }

    public PriceStruct(Integer r1, Double r2, Double r3, Double r4, String r5, Double r6) {
        this.type = r1;
        this.minPrice = r2;
        this.maxPrice = r3;
        this.marketPrice = r4;
        this.typeText = r5;
        this.originalPrice = r6;
    }

    public static /* synthetic */ String getPromoPrice$default(PriceStruct r1, boolean r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 4;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = 2;
    L12:
        return r1.getPromoPrice(r2, r3, r4);
    }

    public /* synthetic */ PriceStruct(Integer r6, Double r7, Double r8, Double r9, String r10, Double r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Integer r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        Double r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Double r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Double r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Double r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
