package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public static /* synthetic */ InlineCodeConfig copy$default(InlineCodeConfig r11, Float r12, FontStyle r13, Float r14, float r16, float r17, String r18, String r19, String r110, float r20, float r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        Float r2 = r11.fontSize;
    L7:
        if ((r22 & 2) == 0) goto L9;
        FontStyle r3 = r11.fontStyle;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Float r4 = r11.lineHeight;
    L15:
        if ((r22 & 8) == 0) goto L17;
        float r5 = r11.horizontalMargin;
    L19:
        if ((r22 & 16) == 0) goto L21;
        float r6 = r11.horizontalInnerMargin;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.backgroundColor;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.foregroundColor;
    L31:
        if ((r22 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        String r9 = r11.borderColor;
    L35:
        if ((r22 & 256) == 0) goto L37;
        float r10 = r11.borderWidth;
    L39:
        if ((r22 & 512) == 0) goto L41;
        float r1 = r11.borderRadius;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r110;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
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

    public final InlineCodeConfig copy(Float r13, FontStyle r14, Float r16, float r17, float r18, String r19, String r110, String r20, float r21, float r22) {
        return new InlineCodeConfig(r13, r14, r16, r17, r18, r19, r110, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InlineCodeConfig) == true) goto L8;
        return false;
    L8:
        InlineCodeConfig r6 = (InlineCodeConfig) r5;
        if (Intrinsics.areEqual(this.fontSize, r6.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontStyle == r6.fontStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineHeight, r6.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.horizontalMargin, r6.horizontalMargin) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.horizontalInnerMargin, r6.horizontalInnerMargin) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.foregroundColor, r6.foregroundColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.borderColor, r6.borderColor) == true) goto L33;
        return false;
    L33:
        if (Float.compare(this.borderWidth, r6.borderWidth) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.borderRadius, r6.borderRadius) == 0) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Float r0 = this.fontSize;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        FontStyle r4 = this.fontStyle;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.lineHeight;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + Float.floatToIntBits(this.horizontalMargin)) * 31) + Float.floatToIntBits(this.horizontalInnerMargin)) * 31;
        String r10 = this.backgroundColor;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.foregroundColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        String r17 = this.borderColor;
        if (r17 == null) goto L27;
        r1 = r17.hashCode();
    L27:
        return ((((r16 + r1) * 31) + Float.floatToIntBits(this.borderWidth)) * 31) + Float.floatToIntBits(this.borderRadius);
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InlineCodeConfig(fontSize=" + this.fontSize + ", fontStyle=" + this.fontStyle + ", lineHeight=" + this.lineHeight + ", horizontalMargin=" + this.horizontalMargin + ", horizontalInnerMargin=" + this.horizontalInnerMargin + ", backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", borderRadius=" + this.borderRadius + ')';
    }

    public final lark_markdown_render.proto.InlineCodeConfig into() {
        Float r1 = this.fontSize;
        FontStyle r0 = this.fontStyle;
        if (r0 == null) goto L5;
        lark_markdown_render.proto.FontStyle r2 = r0.into();
    L7:
        return new lark_markdown_render.proto.InlineCodeConfig(r1, r2, this.lineHeight, Float.valueOf(this.horizontalMargin), Float.valueOf(this.horizontalInnerMargin), this.backgroundColor, this.foregroundColor, this.borderColor, Float.valueOf(this.borderWidth), Float.valueOf(this.borderRadius));
    L5:
        r2 = null;
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

    public final void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public final void setBorderColor(String r1) {
        this.borderColor = r1;
    }

    public final void setBorderRadius(float r1) {
        this.borderRadius = r1;
    }

    public final void setBorderWidth(float r1) {
        this.borderWidth = r1;
    }

    public final void setFontSize(Float r1) {
        this.fontSize = r1;
    }

    public final void setFontStyle(FontStyle r1) {
        this.fontStyle = r1;
    }

    public final void setForegroundColor(String r1) {
        this.foregroundColor = r1;
    }

    public final void setHorizontalInnerMargin(float r1) {
        this.horizontalInnerMargin = r1;
    }

    public final void setHorizontalMargin(float r1) {
        this.horizontalMargin = r1;
    }

    public final void setLineHeight(Float r1) {
        this.lineHeight = r1;
    }

    public InlineCodeConfig(Float r1, FontStyle r2, Float r3, float r4, float r5, String r6, String r7, String r8, float r9, float r10) {
        this.fontSize = r1;
        this.fontStyle = r2;
        this.lineHeight = r3;
        this.horizontalMargin = r4;
        this.horizontalInnerMargin = r5;
        this.backgroundColor = r6;
        this.foregroundColor = r7;
        this.borderColor = r8;
        this.borderWidth = r9;
        this.borderRadius = r10;
    }
}
