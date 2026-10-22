package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public static /* synthetic */ DocumentConfig copy$default(DocumentConfig r13, Float r14, FontWeight r16, Float r17, Float r18, Float r19, Float r110, Float r20, Float r21, String r22, String r23, EdgeInsets r24, EdgeInsets r26, int r27, Object r28) {
        if ((r27 & 1) == 0) goto L5;
        Float r2 = r13.fontSize;
    L7:
        if ((r27 & 2) == 0) goto L9;
        FontWeight r3 = r13.fontWeight;
    L11:
        if ((r27 & 4) == 0) goto L13;
        Float r4 = r13.headingGap;
    L15:
        if ((r27 & 8) == 0) goto L17;
        Float r5 = r13.paragraphGap;
    L19:
        if ((r27 & 16) == 0) goto L21;
        Float r6 = r13.mediaBlockMarginTop;
    L23:
        if ((r27 & 32) == 0) goto L25;
        Float r7 = r13.mediaBlockMarginBottom;
    L27:
        if ((r27 & 64) == 0) goto L29;
        Float r8 = r13.itemGap;
    L31:
        if ((r27 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        Float r9 = r13.lineHeight;
    L35:
        if ((r27 & 256) == 0) goto L37;
        String r10 = r13.backgroundColor;
    L39:
        if ((r27 & 512) == 0) goto L41;
        String r11 = r13.foregroundColor;
    L43:
        if ((r27 & 1024) == 0) goto L45;
        EdgeInsets r12 = r13.docPadding;
    L47:
        if ((r27 & 2048) == 0) goto L49;
        EdgeInsets r1 = r13.paragraphPadding;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r26;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r110;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r14;
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

    public final DocumentConfig copy(Float r16, FontWeight r17, Float r18, Float r19, Float r110, Float r20, Float r21, Float r22, String r23, String r24, EdgeInsets r26, EdgeInsets r27) {
        return new DocumentConfig(r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r26, r27);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocumentConfig) == true) goto L8;
        return false;
    L8:
        DocumentConfig r6 = (DocumentConfig) r5;
        if (Intrinsics.areEqual(this.fontSize, r6.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontWeight == r6.fontWeight) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headingGap, r6.headingGap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.paragraphGap, r6.paragraphGap) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediaBlockMarginTop, r6.mediaBlockMarginTop) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaBlockMarginBottom, r6.mediaBlockMarginBottom) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemGap, r6.itemGap) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lineHeight, r6.lineHeight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.foregroundColor, r6.foregroundColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.docPadding, r6.docPadding) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.paragraphPadding, r6.paragraphPadding) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        Float r0 = this.fontSize;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        FontWeight r4 = this.fontWeight;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.headingGap;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.paragraphGap;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.mediaBlockMarginTop;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        Float r17 = this.mediaBlockMarginBottom;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.itemGap;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Float r23 = this.lineHeight;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r26 = (r22 + r24) * 31;
        String r27 = this.backgroundColor;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        String r30 = this.foregroundColor;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        EdgeInsets r33 = this.docPadding;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r36 = (r32 + r34) * 31;
        EdgeInsets r37 = this.paragraphPadding;
        if (r37 == null) goto L51;
        r1 = r37.hashCode();
    L51:
        return r36 + r1;
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
        return "DocumentConfig(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", headingGap=" + this.headingGap + ", paragraphGap=" + this.paragraphGap + ", mediaBlockMarginTop=" + this.mediaBlockMarginTop + ", mediaBlockMarginBottom=" + this.mediaBlockMarginBottom + ", itemGap=" + this.itemGap + ", lineHeight=" + this.lineHeight + ", backgroundColor=" + this.backgroundColor + ", foregroundColor=" + this.foregroundColor + ", docPadding=" + this.docPadding + ", paragraphPadding=" + this.paragraphPadding + ')';
    }

    public final lark_markdown_render.proto.DocumentConfig into() {
        Float r1 = this.fontSize;
        FontWeight r0 = this.fontWeight;
        if (r0 == null) goto L5;
        lark_markdown_render.proto.FontWeight r3 = r0.into();
    L6:
        Float r4 = this.headingGap;
        Float r5 = this.paragraphGap;
        Float r6 = this.mediaBlockMarginTop;
        Float r7 = this.mediaBlockMarginBottom;
        Float r8 = this.itemGap;
        Float r9 = this.lineHeight;
        String r10 = this.backgroundColor;
        String r11 = this.foregroundColor;
        EdgeInsets r2 = this.docPadding;
        if (r2 == null) goto L9;
        lark_markdown_render.proto.EdgeInsets r12 = r2.into();
    L10:
        EdgeInsets r13 = this.paragraphPadding;
        if (r13 == null) goto L13;
        lark_markdown_render.proto.EdgeInsets r14 = r13.into();
    L15:
        return new lark_markdown_render.proto.DocumentConfig(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14);
    L13:
        r14 = null;
        goto L15
    L9:
        r12 = null;
        goto L10
    L5:
        r3 = null;
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

    public final void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public final void setDocPadding(EdgeInsets r1) {
        this.docPadding = r1;
    }

    public final void setFontSize(Float r1) {
        this.fontSize = r1;
    }

    public final void setFontWeight(FontWeight r1) {
        this.fontWeight = r1;
    }

    public final void setForegroundColor(String r1) {
        this.foregroundColor = r1;
    }

    public final void setHeadingGap(Float r1) {
        this.headingGap = r1;
    }

    public final void setItemGap(Float r1) {
        this.itemGap = r1;
    }

    public final void setLineHeight(Float r1) {
        this.lineHeight = r1;
    }

    public final void setMediaBlockMarginBottom(Float r1) {
        this.mediaBlockMarginBottom = r1;
    }

    public final void setMediaBlockMarginTop(Float r1) {
        this.mediaBlockMarginTop = r1;
    }

    public final void setParagraphGap(Float r1) {
        this.paragraphGap = r1;
    }

    public final void setParagraphPadding(EdgeInsets r1) {
        this.paragraphPadding = r1;
    }

    public DocumentConfig(Float r1, FontWeight r2, Float r3, Float r4, Float r5, Float r6, Float r7, Float r8, String r9, String r10, EdgeInsets r11, EdgeInsets r12) {
        this.fontSize = r1;
        this.fontWeight = r2;
        this.headingGap = r3;
        this.paragraphGap = r4;
        this.mediaBlockMarginTop = r5;
        this.mediaBlockMarginBottom = r6;
        this.itemGap = r7;
        this.lineHeight = r8;
        this.backgroundColor = r9;
        this.foregroundColor = r10;
        this.docPadding = r11;
        this.paragraphPadding = r12;
    }
}
