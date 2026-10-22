package com.obric.livecard.api.entity;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003Jh\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001d\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R&\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006<"}, d2 = {"Lcom/obric/livecard/api/entity/Text;", "", "text", "", "textSize", "", "textColor", "textLightColor", "fontWeight", "maskedText", "lineHeight", "color", "Lcom/obric/livecard/api/entity/ColorToken;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "getFontWeight$annotations", "()V", "getFontWeight", "()Ljava/lang/String;", "setFontWeight", "(Ljava/lang/String;)V", "getLineHeight$annotations", "getLineHeight", "()Ljava/lang/Integer;", "setLineHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaskedText", "setMaskedText", "getText", "setText", "getTextColor$annotations", "getTextColor", "setTextColor", "getTextLightColor$annotations", "getTextLightColor", "setTextLightColor", "getTextSize$annotations", "getTextSize", "()I", "setTextSize", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/livecard/api/entity/Text;", "equals", "", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Text {
    private ColorToken color;
    private String fontWeight;
    private Integer lineHeight;
    private String maskedText;
    private String text;
    private String textColor;
    private String textLightColor;
    private int textSize;

    public static /* synthetic */ Text copy$default(Text r100, String r110, int r111, String r112, String r113, String r114, String r115, Integer r116, ColorToken r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.text;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.textSize;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.textColor;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.textLightColor;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.fontWeight;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.maskedText;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = r100.lineHeight;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ColorToken r108 = r100.color;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @Deprecated(message = "新版本废弃自定义字体")
    public static /* synthetic */ void getFontWeight$annotations() {
    }

    @Deprecated(message = "新版本废弃自定义字体")
    public static /* synthetic */ void getLineHeight$annotations() {
    }

    @Deprecated(message = "请使用colorToken")
    public static /* synthetic */ void getTextColor$annotations() {
    }

    @Deprecated(message = "请使用colorToken")
    public static /* synthetic */ void getTextLightColor$annotations() {
    }

    @Deprecated(message = "新版本废弃自定义字体")
    public static /* synthetic */ void getTextSize$annotations() {
    }

    public final String component1() {
        return this.text;
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

    public final String component6() {
        return this.maskedText;
    }

    public final Integer component7() {
        return this.lineHeight;
    }

    public final ColorToken component8() {
        return this.color;
    }

    public final Text copy(String r110, int r111, String r112, String r113, String r114, String r115, Integer r116, ColorToken r117) {
        Intrinsics.checkNotNullParameter(r110, "text");
        Intrinsics.checkNotNullParameter(r112, "textColor");
        return new Text(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Text) == true) goto L8;
        return false;
    L8:
        Text r101 = (Text) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
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
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maskedText, r101.maskedText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.lineHeight, r101.lineHeight) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.text.hashCode() * 31) + this.textSize) * 31) + this.textColor.hashCode()) * 31;
        String r101 = this.textLightColor;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.fontWeight;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.maskedText;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.lineHeight;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        ColorToken r114 = this.color;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "Text(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ", maskedText=" + this.maskedText + ", lineHeight=" + this.lineHeight + ", color=" + this.color + ')';
    }

    public final ColorToken getColor() {
        return this.color;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    public final String getMaskedText() {
        return this.maskedText;
    }

    public final String getText() {
        return this.text;
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

    public final void setColor(ColorToken r100) {
        this.color = r100;
    }

    public final void setFontWeight(String r100) {
        this.fontWeight = r100;
    }

    public final void setLineHeight(Integer r100) {
        this.lineHeight = r100;
    }

    public final void setMaskedText(String r100) {
        this.maskedText = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
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

    public Text(String r100, int r101, String r102, String r103, String r104, String r105, Integer r106, ColorToken r107) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r102, "textColor");
        this.text = r100;
        this.textSize = r101;
        this.textColor = r102;
        this.textLightColor = r103;
        this.fontWeight = r104;
        this.maskedText = r105;
        this.lineHeight = r106;
        this.color = r107;
    }

    public /* synthetic */ Text(String r100, int r110, String r111, String r112, String r113, String r114, Integer r115, ColorToken r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 2) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r117 & 4) == 0) goto L9;
        String r102 = "";
    L10:
        ColorToken r103 = null;
        if ((r117 & 8) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r117 & 64) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r117 & 128) != 0) goto L30;
        r103 = r116;
    L30:
        this(r100, r101, r102, r104, r105, r106, r107, r103);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
