package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/r0;", "", "", "discountType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "discountText", "getDiscountText", "discountLongText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "discountSuffixText", "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("discount_long_text")
    private final String discountLongText;

    @SerializedName("discount_suffix_text")
    private final String discountSuffixText;

    @SerializedName("discount_text")
    private final String discountText;

    @SerializedName("discount_type")
    private final String discountType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.discountType, r101.discountType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.discountText, r101.discountText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.discountLongText, r101.discountLongText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountSuffixText, r101.discountSuffixText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.discountType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.discountText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.discountLongText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.discountSuffixText;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProductDiscountExpressionData(discountType=" + this.discountType + ", discountText=" + this.discountText + ", discountLongText=" + this.discountLongText + ", discountSuffixText=" + this.discountSuffixText + ')';
    }

    public r0() {
        this.discountType = null;
        this.discountText = null;
        this.discountLongText = null;
        this.discountSuffixText = null;
    }

    public final String a() {
        return this.discountLongText;
    }

    public final String b() {
        return this.discountSuffixText;
    }

    public final String c() {
        return this.discountType;
    }
}
