package com.obric.livecard.api.entity;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Deprecated(message = "新版本废弃自定义字体")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/livecard/api/entity/TextIconStyle;", "", "backgroundColor", "", "textSize", "", "textColor", "textLightColor", "fontWeight", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getFontWeight", "setFontWeight", "getTextColor", "setTextColor", "getTextLightColor", "setTextLightColor", "getTextSize", "()I", "setTextSize", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextIconStyle {
    private String backgroundColor;
    private String fontWeight;
    private String textColor;
    private String textLightColor;
    private int textSize;

    public static /* synthetic */ TextIconStyle copy$default(TextIconStyle r100, String r101, int r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.textSize;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.textColor;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.textLightColor;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.fontWeight;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final int component2() {
        return this.textSize;
    }

    public final String component3() {
        return this.textColor;
    }

    public final String component4() {
        return this.textLightColor;
    }

    public final String component5() {
        return this.fontWeight;
    }

    public final TextIconStyle copy(String r100, int r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "backgroundColor");
        Intrinsics.checkNotNullParameter(r110, "textColor");
        return new TextIconStyle(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextIconStyle) == true) goto L8;
        return false;
    L8:
        TextIconStyle r101 = (TextIconStyle) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (this.textSize == r101.textSize) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textLightColor, r101.textLightColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.backgroundColor.hashCode() * 31) + this.textSize) * 31) + this.textColor.hashCode()) * 31;
        String r101 = this.textLightColor;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.fontWeight;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "TextIconStyle(backgroundColor=" + this.backgroundColor + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextLightColor() {
        return this.textLightColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final void setBackgroundColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.backgroundColor = r100;
    }

    public final void setFontWeight(String r100) {
        this.fontWeight = r100;
    }

    public final void setTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.textColor = r100;
    }

    public final void setTextLightColor(String r100) {
        this.textLightColor = r100;
    }

    public final void setTextSize(int r100) {
        this.textSize = r100;
    }

    public TextIconStyle(String r100, int r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "backgroundColor");
        Intrinsics.checkNotNullParameter(r102, "textColor");
        this.backgroundColor = r100;
        this.textSize = r101;
        this.textColor = r102;
        this.textLightColor = r103;
        this.fontWeight = r104;
    }

    public /* synthetic */ TextIconStyle(String r100, int r101, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        String r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
