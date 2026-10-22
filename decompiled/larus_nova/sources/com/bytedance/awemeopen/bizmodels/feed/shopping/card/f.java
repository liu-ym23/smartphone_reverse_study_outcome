package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/f;", "", "", "picText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/d;", "discountLabels", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "priceLabel", "c", "priceSuffix", "d", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class f {

    @SerializedName("discount_labels")
    private final List<d> discountLabels;

    @SerializedName("pic_text")
    private final String picText;

    @SerializedName("price_label")
    private final String priceLabel;

    @SerializedName("price_suffix")
    private final String priceSuffix;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.picText, r101.picText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.discountLabels, r101.discountLabels) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.priceLabel, r101.priceLabel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.priceSuffix, r101.priceSuffix) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.picText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<d> r104 = this.discountLabels;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.priceLabel;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.priceSuffix;
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
        return "MultiProCardContent(picText=" + this.picText + ", discountLabels=" + this.discountLabels + ", priceLabel=" + this.priceLabel + ", priceSuffix=" + this.priceSuffix + ')';
    }

    public f() {
        this.picText = null;
        this.discountLabels = null;
        this.priceLabel = null;
        this.priceSuffix = null;
    }

    public final List<d> a() {
        return this.discountLabels;
    }

    public final String b() {
        return this.picText;
    }

    public final String c() {
        return this.priceLabel;
    }

    public final String d() {
        return this.priceSuffix;
    }
}
