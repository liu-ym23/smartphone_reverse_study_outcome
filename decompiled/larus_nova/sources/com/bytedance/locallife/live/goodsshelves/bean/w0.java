package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/w0;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/y0;", "priceExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/y0;", "c", "()Lcom/bytedance/locallife/live/goodsshelves/bean/y0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/x0;", "priceDiffExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/x0;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/x0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/r0;", "discountExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/r0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/r0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("discount_expression")
    private final r0 discountExpression;

    @SerializedName("price_diff_expression")
    private final x0 priceDiffExpression;

    @SerializedName("price_expression")
    private final y0 priceExpression;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.priceExpression, r101.priceExpression) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.priceDiffExpression, r101.priceDiffExpression) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.discountExpression, r101.discountExpression) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        y0 r100 = this.priceExpression;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        x0 r104 = this.priceDiffExpression;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        r0 r107 = this.discountExpression;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProductPriceCalculationExpressionData(priceExpression=" + this.priceExpression + ", priceDiffExpression=" + this.priceDiffExpression + ", discountExpression=" + this.discountExpression + ')';
    }

    public w0() {
        this.priceExpression = null;
        this.priceDiffExpression = null;
        this.discountExpression = null;
    }

    public final r0 a() {
        return this.discountExpression;
    }

    public final x0 b() {
        return this.priceDiffExpression;
    }

    public final y0 c() {
        return this.priceExpression;
    }
}
