package com.bytedance.android.shopping.sku.outer.business.anchor;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/anchor/b;", "", "", "upfrontPresell", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "isUnderStock", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class b {

    @SerializedName("is_under_stock")
    private final String isUnderStock;

    @SerializedName("upfront_presell")
    private final String upfrontPresell;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.upfrontPresell, r4.upfrontPresell) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isUnderStock, r4.isUnderStock) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.upfrontPresell;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.isUnderStock;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuOpenDetailParams(upfrontPresell=" + this.upfrontPresell + ", isUnderStock=" + this.isUnderStock + ")";
    }

    public b() {
        this.upfrontPresell = null;
        this.isUnderStock = null;
    }

    public final String a() {
        return this.upfrontPresell;
    }

    public final String b() {
        return this.isUnderStock;
    }
}
