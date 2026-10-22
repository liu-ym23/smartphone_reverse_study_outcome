package com.bytedance.locallife.live.goodsshelves.bean;

import androidx.core.provider.FontsContractCompat;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/n0;", "", "", "textColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "textSize", "Ljava/lang/Float;", "d", "()Ljava/lang/Float;", "fontWeight", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "prefixContentPaddingLeft", "Ljava/lang/Integer;", "getPrefixContentPaddingLeft", "()Ljava/lang/Integer;", "Lcom/bytedance/locallife/live/goodsshelves/bean/o0;", "prefixImage", "Lcom/bytedance/locallife/live/goodsshelves/bean/o0;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/o0;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final Float fontWeight;

    @SerializedName("prefix_content_padding_left")
    private final Integer prefixContentPaddingLeft;

    @SerializedName("prefix_image")
    private final o0 prefixImage;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("text_size")
    private final Float textSize;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textSize, r101.textSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prefixContentPaddingLeft, r101.prefixContentPaddingLeft) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prefixImage, r101.prefixImage) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.textColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.textSize;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.fontWeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.prefixContentPaddingLeft;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        o0 r113 = this.prefixImage;
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
        return "OtherPriceStyle(textColor=" + this.textColor + ", textSize=" + this.textSize + ", fontWeight=" + this.fontWeight + ", prefixContentPaddingLeft=" + this.prefixContentPaddingLeft + ", prefixImage=" + this.prefixImage + ')';
    }

    public n0() {
        this.textColor = null;
        this.textSize = null;
        this.fontWeight = null;
        this.prefixContentPaddingLeft = null;
        this.prefixImage = null;
    }

    public final Float a() {
        return this.fontWeight;
    }

    public final o0 b() {
        return this.prefixImage;
    }

    public final String c() {
        return this.textColor;
    }

    public final Float d() {
        return this.textSize;
    }
}
