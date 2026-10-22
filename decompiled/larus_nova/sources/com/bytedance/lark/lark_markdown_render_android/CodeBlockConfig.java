package com.bytedance.lark.lark_markdown_render_android;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJª\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\u0006\u0010K\u001a\u00020LJ\t\u0010M\u001a\u00020\bHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001d¨\u0006N"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "", "fontSize", "", "fontStyle", "Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "lineHeight", "captionColor", "", "backgroundColor", "headerHeight", "copySize", "headerBackgroundColor", "borderRadius", "borderWidth", "borderColor", GXTemplateKey.FLEXBOX_PADDING, "headerPadding", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBorderColor", "setBorderColor", "getBorderRadius", "()Ljava/lang/Float;", "setBorderRadius", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getBorderWidth", "setBorderWidth", "getCaptionColor", "setCaptionColor", "getCopySize", "setCopySize", "getFontSize", "setFontSize", "getFontStyle", "()Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;", "setFontStyle", "(Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;)V", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "getHeaderHeight", "setHeaderHeight", "getHeaderPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setHeaderPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getLineHeight", "setLineHeight", "getPadding", "setPadding", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontStyle;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/CodeBlockConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/CodeBlockConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public static /* synthetic */ CodeBlockConfig copy$default(CodeBlockConfig r110, Float r111, FontStyle r112, Float r113, String r114, String r115, Float r210, Float r211, String r212, Float r213, Float r214, String r215, Float r216, EdgeInsets r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        Float r100 = r110.fontSize;
    L7:
        if ((r218 & 2) == 0) goto L9;
        FontStyle r101 = r110.fontStyle;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Float r102 = r110.lineHeight;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.captionColor;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.backgroundColor;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Float r105 = r110.headerHeight;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Float r106 = r110.copySize;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.headerBackgroundColor;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Float r116 = r110.borderRadius;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Float r117 = r110.borderWidth;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        String r118 = r110.borderColor;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Float r119 = r110.padding;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        EdgeInsets r108 = r110.headerPadding;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final CodeBlockConfig copy(Float r110, FontStyle r111, Float r112, String r113, String r210, Float r211, Float r212, String r213, Float r214, Float r215, String r216, Float r217, EdgeInsets r218) {
        return new CodeBlockConfig(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeBlockConfig) == true) goto L8;
        return false;
    L8:
        CodeBlockConfig r101 = (CodeBlockConfig) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontStyle == r101.fontStyle) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineHeight, r101.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.captionColor, r101.captionColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headerHeight, r101.headerHeight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.copySize, r101.copySize) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.headerBackgroundColor, r101.headerBackgroundColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.borderWidth, r101.borderWidth) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.headerPadding, r101.headerPadding) == true) goto L47;
        return false;
    L47:
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
        int r109 = (r106 + r108) * 31;
        String r110 = this.captionColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.backgroundColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.headerHeight;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.copySize;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.headerBackgroundColor;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Float r125 = this.borderRadius;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Float r128 = this.borderWidth;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.borderColor;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Float r134 = this.padding;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        EdgeInsets r137 = this.headerPadding;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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

    public String toString() {
        return "CodeBlockConfig(fontSize=" + this.fontSize + ", fontStyle=" + this.fontStyle + ", lineHeight=" + this.lineHeight + ", captionColor=" + this.captionColor + ", backgroundColor=" + this.backgroundColor + ", headerHeight=" + this.headerHeight + ", copySize=" + this.copySize + ", headerBackgroundColor=" + this.headerBackgroundColor + ", borderRadius=" + this.borderRadius + ", borderWidth=" + this.borderWidth + ", borderColor=" + this.borderColor + ", padding=" + this.padding + ", headerPadding=" + this.headerPadding + ')';
    }

    public final lark_markdown_render.proto.CodeBlockConfig into() {
        Float r100 = this.fontSize;
        FontStyle r101 = this.fontStyle;
        if (r101 == null) goto L5;
        lark_markdown_render.proto.FontStyle r102 = r101.into();
    L6:
        Float r103 = this.lineHeight;
        String r104 = this.captionColor;
        String r105 = this.backgroundColor;
        Float r106 = this.headerHeight;
        Float r107 = this.copySize;
        String r110 = this.headerBackgroundColor;
        Float r111 = this.borderRadius;
        Float r112 = this.borderWidth;
        String r113 = this.borderColor;
        Float r114 = this.padding;
        EdgeInsets r108 = this.headerPadding;
        if (r108 == null) goto L9;
        lark_markdown_render.proto.EdgeInsets r115 = r108.into();
    L11:
        return new lark_markdown_render.proto.CodeBlockConfig(r100, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115);
    L9:
        r115 = null;
        goto L11
    L5:
        r102 = null;
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

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setBorderColor(String r100) {
        this.borderColor = r100;
    }

    public final void setBorderRadius(Float r100) {
        this.borderRadius = r100;
    }

    public final void setBorderWidth(Float r100) {
        this.borderWidth = r100;
    }

    public final void setCaptionColor(String r100) {
        this.captionColor = r100;
    }

    public final void setCopySize(Float r100) {
        this.copySize = r100;
    }

    public final void setFontSize(Float r100) {
        this.fontSize = r100;
    }

    public final void setFontStyle(FontStyle r100) {
        this.fontStyle = r100;
    }

    public final void setHeaderBackgroundColor(String r100) {
        this.headerBackgroundColor = r100;
    }

    public final void setHeaderHeight(Float r100) {
        this.headerHeight = r100;
    }

    public final void setHeaderPadding(EdgeInsets r100) {
        this.headerPadding = r100;
    }

    public final void setLineHeight(Float r100) {
        this.lineHeight = r100;
    }

    public final void setPadding(Float r100) {
        this.padding = r100;
    }

    public CodeBlockConfig(Float r100, FontStyle r101, Float r102, String r103, String r104, Float r105, Float r106, String r107, Float r108, Float r110, String r111, Float r112, EdgeInsets r113) {
        this.fontSize = r100;
        this.fontStyle = r101;
        this.lineHeight = r102;
        this.captionColor = r103;
        this.backgroundColor = r104;
        this.headerHeight = r105;
        this.copySize = r106;
        this.headerBackgroundColor = r107;
        this.borderRadius = r108;
        this.borderWidth = r110;
        this.borderColor = r111;
        this.padding = r112;
        this.headerPadding = r113;
    }
}
