package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J~\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\u0006\u0010>\u001a\u00020?J\t\u0010@\u001a\u00020\nHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001f¨\u0006A"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;", "", "fontSize", "", "fontStyle", "Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "lineHeight", "horizontalMargin", "horizontalInnerMargin", "backgroundColor", "", "foregroundColor", "borderColor", "borderWidth", "borderRadius", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;Ljava/lang/Float;FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FF)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBorderColor", "setBorderColor", "getBorderRadius", "()F", "setBorderRadius", "(F)V", "getBorderWidth", "setBorderWidth", "getFontSize", "()Ljava/lang/Float;", "setFontSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFontStyle", "()Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "setFontStyle", "(Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;)V", "getForegroundColor", "setForegroundColor", "getHorizontalInnerMargin", "setHorizontalInnerMargin", "getHorizontalMargin", "setHorizontalMargin", "getLineHeight", "setLineHeight", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;Ljava/lang/Float;FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FF)Lcom/bytedance/lark/lark_markdown_render_android/InlineCodeConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/InlineCodeConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InlineCodeConfig {
    private String backgroundColor;
    private String borderColor;
    private float borderRadius;
    private float borderWidth;
    private Float fontSize;
    private FontStyle fontStyle;
    private String foregroundColor;
    private float horizontalInnerMargin;
    private float horizontalMargin;
    private Float lineHeight;

    public static /* synthetic */ InlineCodeConfig copy$default(InlineCodeConfig r110, Float r111, FontStyle r112, Float r113, float r114, float r115, String r116, String r117, String r118, float r210, float r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Float r100 = r110.fontSize;
    L7:
        if ((r212 & 2) == 0) goto L9;
        FontStyle r101 = r110.fontStyle;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Float r102 = r110.lineHeight;
    L15:
        if ((r212 & 8) == 0) goto L17;
        float r103 = r110.horizontalMargin;
    L19:
        if ((r212 & 16) == 0) goto L21;
        float r104 = r110.horizontalInnerMargin;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.backgroundColor;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.foregroundColor;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.borderColor;
    L35:
        if ((r212 & 256) == 0) goto L37;
        float r119 = r110.borderWidth;
    L39:
        if ((r212 & 512) == 0) goto L41;
        float r108 = r110.borderRadius;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Float component1() {
        return this.fontSize;
    }

    public final float component10() {
        return this.borderRadius;
    }

    public final FontStyle component2() {
        return this.fontStyle;
    }

    public final Float component3() {
        return this.lineHeight;
    }

    public final float component4() {
        return this.horizontalMargin;
    }

    public final float component5() {
        return this.horizontalInnerMargin;
    }

    public final String component6() {
        return this.backgroundColor;
    }

    public final String component7() {
        return this.foregroundColor;
    }

    public final String component8() {
        return this.borderColor;
    }

    public final float component9() {
        return this.borderWidth;
    }

    public final InlineCodeConfig copy(Float r110, FontStyle r111, Float r112, float r113, float r114, String r115, String r116, String r210, float r211, float r212) {
        return new InlineCodeConfig(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InlineCodeConfig) == true) goto L8;
        return false;
    L8:
        InlineCodeConfig r101 = (InlineCodeConfig) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontStyle == r101.fontStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineHeight, r101.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.horizontalMargin, r101.horizontalMargin) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.horizontalInnerMargin, r101.horizontalInnerMargin) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.foregroundColor, r101.foregroundColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L33;
        return false;
    L33:
        if (Float.compare(this.borderWidth, r101.borderWidth) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.borderRadius, r101.borderRadius) == 0) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Float r100 = this.fontSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FontStyle r104 = this.fontStyle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.lineHeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + Float.floatToIntBits(this.horizontalMargin)) * 31) + Float.floatToIntBits(this.horizontalInnerMargin)) * 31;
        String r110 = this.backgroundColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.foregroundColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.borderColor;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((((r115 + r101) * 31) + Float.floatToIntBits(this.borderWidth)) * 31) + Float.floatToIntBits(this.borderRadius);
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

    public String toString() {
        return "InlineCodeConfig(fontSize=" + this.fontSize + ", fontStyle=" + this.fontStyle + ", lineHeight=" + this.lineHeight + ", horizontalMargin=" + this.horizontalMargin + ", horizontalInnerMargin=" + this.horizontalInnerMargin + ", backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", borderRadius=" + this.borderRadius + ')';
    }

    public final lark_markdown_render.proto.InlineCodeConfig into() {
        Float r100 = this.fontSize;
        FontStyle r101 = this.fontStyle;
        if (r101 == null) goto L5;
        lark_markdown_render.proto.FontStyle r102 = r101.into();
    L7:
        return new lark_markdown_render.proto.InlineCodeConfig(r100, r102, this.lineHeight, Float.valueOf(this.horizontalMargin), Float.valueOf(this.horizontalInnerMargin), this.backgroundColor, this.foregroundColor, this.borderColor, Float.valueOf(this.borderWidth), Float.valueOf(this.borderRadius));
    L5:
        r102 = null;
        goto L7
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    public final float getHorizontalInnerMargin() {
        return this.horizontalInnerMargin;
    }

    public final float getHorizontalMargin() {
        return this.horizontalMargin;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setBorderColor(String r100) {
        this.borderColor = r100;
    }

    public final void setBorderRadius(float r100) {
        this.borderRadius = r100;
    }

    public final void setBorderWidth(float r100) {
        this.borderWidth = r100;
    }

    public final void setFontSize(Float r100) {
        this.fontSize = r100;
    }

    public final void setFontStyle(FontStyle r100) {
        this.fontStyle = r100;
    }

    public final void setForegroundColor(String r100) {
        this.foregroundColor = r100;
    }

    public final void setHorizontalInnerMargin(float r100) {
        this.horizontalInnerMargin = r100;
    }

    public final void setHorizontalMargin(float r100) {
        this.horizontalMargin = r100;
    }

    public final void setLineHeight(Float r100) {
        this.lineHeight = r100;
    }

    public InlineCodeConfig(Float r100, FontStyle r101, Float r102, float r103, float r104, String r105, String r106, String r107, float r108, float r110) {
        this.fontSize = r100;
        this.fontStyle = r101;
        this.lineHeight = r102;
        this.horizontalMargin = r103;
        this.horizontalInnerMargin = r104;
        this.backgroundColor = r105;
        this.foregroundColor = r106;
        this.borderColor = r107;
        this.borderWidth = r108;
        this.borderRadius = r110;
    }
}
