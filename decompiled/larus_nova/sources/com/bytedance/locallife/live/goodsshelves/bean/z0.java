package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/z0;", "", "", "priceType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "currencySign", "getCurrencySign", "", "amount", "Ljava/lang/Float;", "getAmount", "()Ljava/lang/Float;", "longText", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("amount")
    private final Float amount;

    @SerializedName("currency_sign")
    private final String currencySign;

    @SerializedName("long_text")
    private final String longText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRICE_TYPE)
    private final String priceType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.priceType, r101.priceType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currencySign, r101.currencySign) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.longText, r101.longText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.priceType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.currencySign;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.amount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.longText;
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
        return "ProductPriceSaveAmountExpressionData(priceType=" + this.priceType + ", currencySign=" + this.currencySign + ", amount=" + this.amount + ", longText=" + this.longText + ')';
    }

    public z0() {
        this.priceType = null;
        this.currencySign = null;
        this.amount = null;
        this.longText = null;
    }

    public final String a() {
        return this.longText;
    }

    public final String b() {
        return this.priceType;
    }
}
