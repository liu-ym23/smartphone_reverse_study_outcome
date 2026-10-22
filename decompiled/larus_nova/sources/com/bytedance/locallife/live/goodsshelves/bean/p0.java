package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/p0;", "", "", "prefixTextColor", "Ljava/lang/String;", "getPrefixTextColor", "()Ljava/lang/String;", "", "prefixTextSize", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "currencyTextColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "currencyTextSize", "b", "valueTextColor", "f", "valueTextSize", ce.f26391f, "suffixTextColor", "d", "suffixTextSize", "e", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("currency_text_color")
    private final String currencyTextColor;

    @SerializedName("currency_text_size")
    private final Float currencyTextSize;

    @SerializedName("prefix_text_color")
    private final String prefixTextColor;

    @SerializedName("prefix_text_size")
    private final Float prefixTextSize;

    @SerializedName("suffix_text_color")
    private final String suffixTextColor;

    @SerializedName("suffix_text_size")
    private final Float suffixTextSize;

    @SerializedName("value_text_color")
    private final String valueTextColor;

    @SerializedName("value_text_size")
    private final Float valueTextSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.prefixTextColor, r101.prefixTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prefixTextSize, r101.prefixTextSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currencyTextColor, r101.currencyTextColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.currencyTextSize, r101.currencyTextSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.valueTextColor, r101.valueTextColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.valueTextSize, r101.valueTextSize) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.suffixTextColor, r101.suffixTextColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.suffixTextSize, r101.suffixTextSize) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.prefixTextColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.prefixTextSize;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.currencyTextColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.currencyTextSize;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.valueTextColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.valueTextSize;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.suffixTextColor;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.suffixTextSize;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "PriceStyle(prefixTextColor=" + this.prefixTextColor + ", prefixTextSize=" + this.prefixTextSize + ", currencyTextColor=" + this.currencyTextColor + ", currencyTextSize=" + this.currencyTextSize + ", valueTextColor=" + this.valueTextColor + ", valueTextSize=" + this.valueTextSize + ", suffixTextColor=" + this.suffixTextColor + ", suffixTextSize=" + this.suffixTextSize + ')';
    }

    public p0() {
        this.prefixTextColor = null;
        this.prefixTextSize = null;
        this.currencyTextColor = null;
        this.currencyTextSize = null;
        this.valueTextColor = null;
        this.valueTextSize = null;
        this.suffixTextColor = null;
        this.suffixTextSize = null;
    }

    public final String a() {
        return this.currencyTextColor;
    }

    public final Float b() {
        return this.currencyTextSize;
    }

    public final Float c() {
        return this.prefixTextSize;
    }

    public final String d() {
        return this.suffixTextColor;
    }

    public final Float e() {
        return this.suffixTextSize;
    }

    public final String f() {
        return this.valueTextColor;
    }

    public final Float g() {
        return this.valueTextSize;
    }
}
