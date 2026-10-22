package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJª\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\u0006\u0010K\u001a\u00020LJ\t\u0010M\u001a\u00020\bHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001d¨\u0006N"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "", "fontSize", "", "fontStyle", "Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "lineHeight", "captionColor", "", "backgroundColor", "headerHeight", "copySize", "headerBackgroundColor", "borderRadius", "borderWidth", "borderColor", "padding", "headerPadding", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBorderColor", "setBorderColor", "getBorderRadius", "()Ljava/lang/Float;", "setBorderRadius", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getBorderWidth", "setBorderWidth", "getCaptionColor", "setCaptionColor", "getCopySize", "setCopySize", "getFontSize", "setFontSize", "getFontStyle", "()Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "setFontStyle", "(Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;)V", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "getHeaderHeight", "setHeaderHeight", "getHeaderPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setHeaderPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getLineHeight", "setLineHeight", "getPadding", "setPadding", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/CodeBlockConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CodeBlockConfig {
    private String backgroundColor;
    private String borderColor;
    private Float borderRadius;
    private Float borderWidth;
    private String captionColor;
    private Float copySize;
    private Float fontSize;
    private FontStyle fontStyle;
    private String headerBackgroundColor;
    private Float headerHeight;
    private EdgeInsets headerPadding;
    private Float lineHeight;
    private Float padding;

    public static /* synthetic */ CodeBlockConfig copy$default(CodeBlockConfig r14, Float r16, FontStyle r17, Float r18, String r19, String r110, Float r20, Float r21, String r22, Float r23, Float r24, String r26, Float r27, EdgeInsets r28, int r29, Object r210) {
        if ((r29 & 1) == 0) goto L5;
        Float r2 = r14.fontSize;
    L7:
        if ((r29 & 2) == 0) goto L9;
        FontStyle r3 = r14.fontStyle;
    L11:
        if ((r29 & 4) == 0) goto L13;
        Float r4 = r14.lineHeight;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r5 = r14.captionColor;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r6 = r14.backgroundColor;
    L23:
        if ((r29 & 32) == 0) goto L25;
        Float r7 = r14.headerHeight;
    L27:
        if ((r29 & 64) == 0) goto L29;
        Float r8 = r14.copySize;
    L31:
        if ((r29 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        String r9 = r14.headerBackgroundColor;
    L35:
        if ((r29 & 256) == 0) goto L37;
        Float r10 = r14.borderRadius;
    L39:
        if ((r29 & 512) == 0) goto L41;
        Float r11 = r14.borderWidth;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        String r12 = r14.borderColor;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        Float r13 = r14.padding;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        EdgeInsets r1 = r14.headerPadding;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r110;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final Float component1() {
        return this.fontSize;
    }

    public final Float component10() {
        return this.borderWidth;
    }

    public final String component11() {
        return this.borderColor;
    }

    public final Float component12() {
        return this.padding;
    }

    public final EdgeInsets component13() {
        return this.headerPadding;
    }

    public final FontStyle component2() {
        return this.fontStyle;
    }

    public final Float component3() {
        return this.lineHeight;
    }

    public final String component4() {
        return this.captionColor;
    }

    public final String component5() {
        return this.backgroundColor;
    }

    public final Float component6() {
        return this.headerHeight;
    }

    public final Float component7() {
        return this.copySize;
    }

    public final String component8() {
        return this.headerBackgroundColor;
    }

    public final Float component9() {
        return this.borderRadius;
    }

    public final CodeBlockConfig copy(Float r16, FontStyle r17, Float r18, String r19, String r20, Float r21, Float r22, String r23, Float r24, Float r26, String r27, Float r28, EdgeInsets r29) {
        return new CodeBlockConfig(r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CodeBlockConfig) == true) goto L8;
        return false;
    L8:
        CodeBlockConfig r6 = (CodeBlockConfig) r5;
        if (Intrinsics.areEqual(this.fontSize, r6.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontStyle == r6.fontStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineHeight, r6.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.captionColor, r6.captionColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headerHeight, r6.headerHeight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.copySize, r6.copySize) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.headerBackgroundColor, r6.headerBackgroundColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.borderRadius, r6.borderRadius) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.borderWidth, r6.borderWidth) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.borderColor, r6.borderColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.padding, r6.padding) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.headerPadding, r6.headerPadding) == true) goto L47;
        return false;
    L47:
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
        int r9 = (r6 + r8) * 31;
        String r10 = this.captionColor;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.backgroundColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        Float r17 = this.headerHeight;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.copySize;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.headerBackgroundColor;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r26 = (r22 + r24) * 31;
        Float r27 = this.borderRadius;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        Float r30 = this.borderWidth;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.borderColor;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r36 = (r32 + r34) * 31;
        Float r37 = this.padding;
        if (r37 != null) goto L49;
        int r38 = 0;
    L50:
        int r39 = (r36 + r38) * 31;
        EdgeInsets r40 = this.headerPadding;
        if (r40 == null) goto L55;
        r1 = r40.hashCode();
    L55:
        return r39 + r1;
    L49:
        r38 = r37.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
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
        return "CodeBlockConfig(fontSize=" + this.fontSize + ", fontStyle=" + this.fontStyle + ", lineHeight=" + this.lineHeight + ", captionColor=" + this.captionColor + ", backgroundColor=" + this.backgroundColor + ", headerHeight=" + this.headerHeight + ", copySize=" + this.copySize + ", headerBackgroundColor=" + this.headerBackgroundColor + ", borderRadius=" + this.borderRadius + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", padding=" + this.padding + ", headerPadding=" + this.headerPadding + ')';
    }

    public final lark_markdown_render.proto.CodeBlockConfig into() {
        Float r2 = this.fontSize;
        FontStyle r1 = this.fontStyle;
        if (r1 == null) goto L5;
        lark_markdown_render.proto.FontStyle r4 = r1.into();
    L6:
        Float r5 = this.lineHeight;
        String r6 = this.captionColor;
        String r7 = this.backgroundColor;
        Float r8 = this.headerHeight;
        Float r9 = this.copySize;
        String r10 = this.headerBackgroundColor;
        Float r11 = this.borderRadius;
        Float r12 = this.borderWidth;
        String r13 = this.borderColor;
        Float r14 = this.padding;
        EdgeInsets r3 = this.headerPadding;
        if (r3 == null) goto L9;
        lark_markdown_render.proto.EdgeInsets r16 = r3.into();
    L11:
        return new lark_markdown_render.proto.CodeBlockConfig(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16);
    L9:
        r16 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final Float getBorderRadius() {
        return this.borderRadius;
    }

    public final Float getBorderWidth() {
        return this.borderWidth;
    }

    public final String getCaptionColor() {
        return this.captionColor;
    }

    public final Float getCopySize() {
        return this.copySize;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    public final String getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    public final Float getHeaderHeight() {
        return this.headerHeight;
    }

    public final EdgeInsets getHeaderPadding() {
        return this.headerPadding;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final Float getPadding() {
        return this.padding;
    }

    public final void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public final void setBorderColor(String r1) {
        this.borderColor = r1;
    }

    public final void setBorderRadius(Float r1) {
        this.borderRadius = r1;
    }

    public final void setBorderWidth(Float r1) {
        this.borderWidth = r1;
    }

    public final void setCaptionColor(String r1) {
        this.captionColor = r1;
    }

    public final void setCopySize(Float r1) {
        this.copySize = r1;
    }

    public final void setFontSize(Float r1) {
        this.fontSize = r1;
    }

    public final void setFontStyle(FontStyle r1) {
        this.fontStyle = r1;
    }

    public final void setHeaderBackgroundColor(String r1) {
        this.headerBackgroundColor = r1;
    }

    public final void setHeaderHeight(Float r1) {
        this.headerHeight = r1;
    }

    public final void setHeaderPadding(EdgeInsets r1) {
        this.headerPadding = r1;
    }

    public final void setLineHeight(Float r1) {
        this.lineHeight = r1;
    }

    public final void setPadding(Float r1) {
        this.padding = r1;
    }

    public CodeBlockConfig(Float r1, FontStyle r2, Float r3, String r4, String r5, Float r6, Float r7, String r8, Float r9, Float r10, String r11, Float r12, EdgeInsets r13) {
        this.fontSize = r1;
        this.fontStyle = r2;
        this.lineHeight = r3;
        this.captionColor = r4;
        this.backgroundColor = r5;
        this.headerHeight = r6;
        this.copySize = r7;
        this.headerBackgroundColor = r8;
        this.borderRadius = r9;
        this.borderWidth = r10;
        this.borderColor = r11;
        this.padding = r12;
        this.headerPadding = r13;
    }
}
