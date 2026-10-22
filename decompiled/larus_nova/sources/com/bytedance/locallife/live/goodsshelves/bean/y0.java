package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/y0;", "", "", "currencySign", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "finalPrice", FaceService.girlLabel, "b", "()F", "finalPriceSpecialText", "e", "finalPricePrefix", "d", "finalPricePostfix", "c", "Lcom/bytedance/locallife/live/goodsshelves/bean/z0;", "secondPrice", "Lcom/bytedance/locallife/live/goodsshelves/bean/z0;", "f", "()Lcom/bytedance/locallife/live/goodsshelves/bean/z0;", "thirdPrice", ce.f26391f, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("currency_sign")
    private final String currencySign;

    @SerializedName("final_price")
    private final float finalPrice;

    @SerializedName("final_price_postfix")
    private final String finalPricePostfix;

    @SerializedName("final_price_prefix")
    private final String finalPricePrefix;

    @SerializedName("final_price_special_text")
    private final String finalPriceSpecialText;

    @SerializedName("second_price")
    private final z0 secondPrice;

    @SerializedName("third_price")
    private final z0 thirdPrice;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.currencySign, r101.currencySign) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.finalPrice, r101.finalPrice) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.finalPriceSpecialText, r101.finalPriceSpecialText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.finalPricePrefix, r101.finalPricePrefix) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.finalPricePostfix, r101.finalPricePostfix) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.secondPrice, r101.secondPrice) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.thirdPrice, r101.thirdPrice) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.currencySign;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + Float.floatToIntBits(this.finalPrice)) * 31;
        String r104 = this.finalPriceSpecialText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.finalPricePrefix;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.finalPricePostfix;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        z0 r113 = this.secondPrice;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        z0 r116 = this.thirdPrice;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ProductPriceExpressionData(currencySign=" + this.currencySign + ", finalPrice=" + this.finalPrice + ", finalPriceSpecialText=" + this.finalPriceSpecialText + ", finalPricePrefix=" + this.finalPricePrefix + ", finalPricePostfix=" + this.finalPricePostfix + ", secondPrice=" + this.secondPrice + ", thirdPrice=" + this.thirdPrice + ')';
    }

    public y0() {
        this.currencySign = null;
        this.finalPrice = 0.0f;
        this.finalPriceSpecialText = null;
        this.finalPricePrefix = null;
        this.finalPricePostfix = null;
        this.secondPrice = null;
        this.thirdPrice = null;
    }

    public final String a() {
        return this.currencySign;
    }

    public final float b() {
        return this.finalPrice;
    }

    public final String c() {
        return this.finalPricePostfix;
    }

    public final String d() {
        return this.finalPricePrefix;
    }

    public final String e() {
        return this.finalPriceSpecialText;
    }

    public final z0 f() {
        return this.secondPrice;
    }

    public final z0 g() {
        return this.thirdPrice;
    }
}
