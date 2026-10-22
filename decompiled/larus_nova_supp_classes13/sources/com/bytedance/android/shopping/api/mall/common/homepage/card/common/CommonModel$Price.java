package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003JE\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019¨\u0006!"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price", "", "", "component1", "component2", "component3", "component4", "component5", "component6", "kind", "integers", "decimals", "unit", "above", "label", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKind", "()Ljava/lang/String;", "getIntegers", "getDecimals", "getUnit", "getAbove", "getLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$Price {
    private final String above;
    private final String decimals;
    private final String integers;
    private final String kind;
    private final String label;
    private final String unit;

    public static /* synthetic */ CommonModel$Price copy$default(CommonModel$Price r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.kind;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.integers;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.decimals;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.unit;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.above;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.label;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.kind;
    }

    public final String component2() {
        return this.integers;
    }

    public final String component3() {
        return this.decimals;
    }

    public final String component4() {
        return this.unit;
    }

    public final String component5() {
        return this.above;
    }

    public final String component6() {
        return this.label;
    }

    public final CommonModel$Price copy(String r9, String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "kind");
        Intrinsics.checkNotNullParameter(r10, "integers");
        Intrinsics.checkNotNullParameter(r11, "decimals");
        Intrinsics.checkNotNullParameter(r12, "unit");
        Intrinsics.checkNotNullParameter(r13, "above");
        Intrinsics.checkNotNullParameter(r14, "label");
        return new CommonModel$Price(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonModel$Price) == false) goto L18;
        CommonModel$Price r4 = (CommonModel$Price) r3;
        if (Intrinsics.areEqual(this.kind, r4.kind) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.integers, r4.integers) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.decimals, r4.decimals) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unit, r4.unit) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.above, r4.above) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.label, r4.label) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r0 = this.kind;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.integers;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.decimals;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.unit;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.above;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.label;
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
        return "Price(kind=" + this.kind + ", integers=" + this.integers + ", decimals=" + this.decimals + ", unit=" + this.unit + ", above=" + this.above + ", label=" + this.label + ")";
    }

    public final String getAbove() {
        return this.above;
    }

    public final String getDecimals() {
        return this.decimals;
    }

    public final String getIntegers() {
        return this.integers;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUnit() {
        return this.unit;
    }

    public CommonModel$Price(String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        Intrinsics.checkNotNullParameter(r3, "integers");
        Intrinsics.checkNotNullParameter(r4, "decimals");
        Intrinsics.checkNotNullParameter(r5, "unit");
        Intrinsics.checkNotNullParameter(r6, "above");
        Intrinsics.checkNotNullParameter(r7, "label");
        this.kind = r2;
        this.integers = r3;
        this.decimals = r4;
        this.unit = r5;
        this.above = r6;
        this.label = r7;
    }
}
