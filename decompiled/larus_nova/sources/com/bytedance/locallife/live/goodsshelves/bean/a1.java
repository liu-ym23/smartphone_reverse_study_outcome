package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/a1;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/w0;", "priceCalculationExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/w0;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/w0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/u0;", "marketingExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/u0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/goodsshelves/bean/u0;", "Lcom/bytedance/locallife/live/goodsshelves/bean/t0;", "productExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/t0;", "c", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t0;", "", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("marketing_expression")
    private final u0 marketingExpression;

    @SerializedName("price_calculation_expression")
    private final w0 priceCalculationExpression;

    @SerializedName("product_expression")
    private final t0 productExpression;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a1) == true) goto L8;
        return false;
    L8:
        a1 r101 = (a1) r100;
        if (Intrinsics.areEqual(this.priceCalculationExpression, r101.priceCalculationExpression) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marketingExpression, r101.marketingExpression) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productExpression, r101.productExpression) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        w0 r100 = this.priceCalculationExpression;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        u0 r104 = this.marketingExpression;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        t0 r107 = this.productExpression;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.trackParams;
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
        return "SingleProductExpressionData(priceCalculationExpression=" + this.priceCalculationExpression + ", marketingExpression=" + this.marketingExpression + ", productExpression=" + this.productExpression + ", trackParams=" + this.trackParams + ')';
    }

    public a1() {
        this.priceCalculationExpression = null;
        this.marketingExpression = null;
        this.productExpression = null;
        this.trackParams = null;
    }

    public final u0 a() {
        return this.marketingExpression;
    }

    public final w0 b() {
        return this.priceCalculationExpression;
    }

    public final t0 c() {
        return this.productExpression;
    }
}
