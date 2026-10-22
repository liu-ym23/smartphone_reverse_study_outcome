package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/p0;", "priceStyle", "Lcom/bytedance/locallife/live/goodsshelves/bean/p0;", "c", "()Lcom/bytedance/locallife/live/goodsshelves/bean/p0;", "", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/n0;", "secondPriceStyle", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "thirdPriceStyle", "e", "Lcom/bytedance/locallife/live/goodsshelves/bean/m0;", "marketingToolGeneralStyle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "marketingToolStyle", "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class l0 implements Comparable<l0> {

    @SerializedName("marketing_tool_general_style")
    private final Map<String, m0> marketingToolGeneralStyle;

    @SerializedName("marketing_tool_style")
    private final Map<String, m0> marketingToolStyle;

    @SerializedName("price_style")
    private final p0 priceStyle;

    @SerializedName("second_price_style")
    private final Map<String, n0> secondPriceStyle;

    @SerializedName("third_price_style")
    private final Map<String, n0> thirdPriceStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.priceStyle, r101.priceStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondPriceStyle, r101.secondPriceStyle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.thirdPriceStyle, r101.thirdPriceStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marketingToolGeneralStyle, r101.marketingToolGeneralStyle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.marketingToolStyle, r101.marketingToolStyle) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        p0 r100 = this.priceStyle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, n0> r104 = this.secondPriceStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, n0> r107 = this.thirdPriceStyle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, m0> r110 = this.marketingToolGeneralStyle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, m0> r113 = this.marketingToolStyle;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "MarketingFEConfigData(priceStyle=" + this.priceStyle + ", secondPriceStyle=" + this.secondPriceStyle + ", thirdPriceStyle=" + this.thirdPriceStyle + ", marketingToolGeneralStyle=" + this.marketingToolGeneralStyle + ", marketingToolStyle=" + this.marketingToolStyle + ')';
    }

    public l0() {
        this.priceStyle = null;
        this.secondPriceStyle = null;
        this.thirdPriceStyle = null;
        this.marketingToolGeneralStyle = null;
        this.marketingToolStyle = null;
    }

    public final Map<String, m0> a() {
        return this.marketingToolGeneralStyle;
    }

    public final Map<String, m0> b() {
        return this.marketingToolStyle;
    }

    public final p0 c() {
        return this.priceStyle;
    }

    public final Map<String, n0> d() {
        return this.secondPriceStyle;
    }

    public final Map<String, n0> e() {
        return this.thirdPriceStyle;
    }

    @Override // java.lang.Comparable
    public final int compareTo(l0 r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return -1;
    }
}
