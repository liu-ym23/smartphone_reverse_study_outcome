package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010?\u001a\u0004\u0018\u00010\rHÆ\u0003J\u009e\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020FHÖ\u0001J\u0006\u0010G\u001a\u00020HJ\t\u0010I\u001a\u00020\rHÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001a¨\u0006J"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;", "", "fontSize", "", "fontWeight", "Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "headingGap", "paragraphGap", "mediaBlockMarginTop", "mediaBlockMarginBottom", "itemGap", "lineHeight", "backgroundColor", "", "foregroundColor", "docPadding", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "paragraphPadding", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getDocPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setDocPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getFontSize", "()Ljava/lang/Float;", "setFontSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFontWeight", "()Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "setFontWeight", "(Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;)V", "getForegroundColor", "setForegroundColor", "getHeadingGap", "setHeadingGap", "getItemGap", "setItemGap", "getLineHeight", "setLineHeight", "getMediaBlockMarginBottom", "setMediaBlockMarginBottom", "getMediaBlockMarginTop", "setMediaBlockMarginTop", "getParagraphGap", "setParagraphGap", "getParagraphPadding", "setParagraphPadding", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/DocumentConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/DocumentConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DocumentConfig {
    private String backgroundColor;
    private EdgeInsets docPadding;
    private Float fontSize;
    private FontWeight fontWeight;
    private String foregroundColor;
    private Float headingGap;
    private Float itemGap;
    private Float lineHeight;
    private Float mediaBlockMarginBottom;
    private Float mediaBlockMarginTop;
    private Float paragraphGap;
    private EdgeInsets paragraphPadding;

    public static /* synthetic */ DocumentConfig copy$default(DocumentConfig r110, Float r111, FontWeight r112, Float r113, Float r114, Float r115, Float r116, Float r210, Float r211, String r212, String r213, EdgeInsets r214, EdgeInsets r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        Float r100 = r110.fontSize;
    L7:
        if ((r216 & 2) == 0) goto L9;
        FontWeight r101 = r110.fontWeight;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Float r102 = r110.headingGap;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Float r103 = r110.paragraphGap;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Float r104 = r110.mediaBlockMarginTop;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Float r105 = r110.mediaBlockMarginBottom;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Float r106 = r110.itemGap;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Float r107 = r110.lineHeight;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.backgroundColor;
    L39:
        if ((r216 & 512) == 0) goto L41;
        String r118 = r110.foregroundColor;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        EdgeInsets r119 = r110.docPadding;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        EdgeInsets r108 = r110.paragraphPadding;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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

    public final String component10() {
        return this.foregroundColor;
    }

    public final EdgeInsets component11() {
        return this.docPadding;
    }

    public final EdgeInsets component12() {
        return this.paragraphPadding;
    }

    public final FontWeight component2() {
        return this.fontWeight;
    }

    public final Float component3() {
        return this.headingGap;
    }

    public final Float component4() {
        return this.paragraphGap;
    }

    public final Float component5() {
        return this.mediaBlockMarginTop;
    }

    public final Float component6() {
        return this.mediaBlockMarginBottom;
    }

    public final Float component7() {
        return this.itemGap;
    }

    public final Float component8() {
        return this.lineHeight;
    }

    public final String component9() {
        return this.backgroundColor;
    }

    public final DocumentConfig copy(Float r110, FontWeight r111, Float r112, Float r113, Float r114, Float r210, Float r211, Float r212, String r213, String r214, EdgeInsets r215, EdgeInsets r216) {
        return new DocumentConfig(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocumentConfig) == true) goto L8;
        return false;
    L8:
        DocumentConfig r101 = (DocumentConfig) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontWeight == r101.fontWeight) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headingGap, r101.headingGap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.paragraphGap, r101.paragraphGap) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediaBlockMarginTop, r101.mediaBlockMarginTop) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaBlockMarginBottom, r101.mediaBlockMarginBottom) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemGap, r101.itemGap) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lineHeight, r101.lineHeight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.foregroundColor, r101.foregroundColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.docPadding, r101.docPadding) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.paragraphPadding, r101.paragraphPadding) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        Float r100 = this.fontSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FontWeight r104 = this.fontWeight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.headingGap;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.paragraphGap;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.mediaBlockMarginTop;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.mediaBlockMarginBottom;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.itemGap;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.lineHeight;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.backgroundColor;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.foregroundColor;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        EdgeInsets r131 = this.docPadding;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        EdgeInsets r134 = this.paragraphPadding;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
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
        return "DocumentConfig(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", headingGap=" + this.headingGap + ", paragraphGap=" + this.paragraphGap + ", mediaBlockMarginTop=" + this.mediaBlockMarginTop + ", mediaBlockMarginBottom=" + this.mediaBlockMarginBottom + ", itemGap=" + this.itemGap + ", lineHeight=" + this.lineHeight + ", backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", docPadding=" + this.docPadding + ", paragraphPadding=" + this.paragraphPadding + ')';
    }

    public final lark_markdown_render.proto.DocumentConfig into() {
        Float r100 = this.fontSize;
        FontWeight r101 = this.fontWeight;
        if (r101 == null) goto L5;
        lark_markdown_render.proto.FontWeight r102 = r101.into();
    L6:
        Float r103 = this.headingGap;
        Float r104 = this.paragraphGap;
        Float r105 = this.mediaBlockMarginTop;
        Float r106 = this.mediaBlockMarginBottom;
        Float r107 = this.itemGap;
        Float r108 = this.lineHeight;
        String r110 = this.backgroundColor;
        String r111 = this.foregroundColor;
        EdgeInsets r109 = this.docPadding;
        if (r109 == null) goto L9;
        lark_markdown_render.proto.EdgeInsets r112 = r109.into();
    L10:
        EdgeInsets r113 = this.paragraphPadding;
        if (r113 == null) goto L13;
        lark_markdown_render.proto.EdgeInsets r114 = r113.into();
    L15:
        return new lark_markdown_render.proto.DocumentConfig(r100, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r114);
    L13:
        r114 = null;
        goto L15
    L9:
        r112 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final EdgeInsets getDocPadding() {
        return this.docPadding;
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    public final Float getHeadingGap() {
        return this.headingGap;
    }

    public final Float getItemGap() {
        return this.itemGap;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final Float getMediaBlockMarginBottom() {
        return this.mediaBlockMarginBottom;
    }

    public final Float getMediaBlockMarginTop() {
        return this.mediaBlockMarginTop;
    }

    public final Float getParagraphGap() {
        return this.paragraphGap;
    }

    public final EdgeInsets getParagraphPadding() {
        return this.paragraphPadding;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setDocPadding(EdgeInsets r100) {
        this.docPadding = r100;
    }

    public final void setFontSize(Float r100) {
        this.fontSize = r100;
    }

    public final void setFontWeight(FontWeight r100) {
        this.fontWeight = r100;
    }

    public final void setForegroundColor(String r100) {
        this.foregroundColor = r100;
    }

    public final void setHeadingGap(Float r100) {
        this.headingGap = r100;
    }

    public final void setItemGap(Float r100) {
        this.itemGap = r100;
    }

    public final void setLineHeight(Float r100) {
        this.lineHeight = r100;
    }

    public final void setMediaBlockMarginBottom(Float r100) {
        this.mediaBlockMarginBottom = r100;
    }

    public final void setMediaBlockMarginTop(Float r100) {
        this.mediaBlockMarginTop = r100;
    }

    public final void setParagraphGap(Float r100) {
        this.paragraphGap = r100;
    }

    public final void setParagraphPadding(EdgeInsets r100) {
        this.paragraphPadding = r100;
    }

    public DocumentConfig(Float r100, FontWeight r101, Float r102, Float r103, Float r104, Float r105, Float r106, Float r107, String r108, String r110, EdgeInsets r111, EdgeInsets r112) {
        this.fontSize = r100;
        this.fontWeight = r101;
        this.headingGap = r102;
        this.paragraphGap = r103;
        this.mediaBlockMarginTop = r104;
        this.mediaBlockMarginBottom = r105;
        this.itemGap = r106;
        this.lineHeight = r107;
        this.backgroundColor = r108;
        this.foregroundColor = r110;
        this.docPadding = r111;
        this.paragraphPadding = r112;
    }
}
