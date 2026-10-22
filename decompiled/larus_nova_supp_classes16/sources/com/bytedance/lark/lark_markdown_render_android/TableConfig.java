package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0092\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\u0006\u0010@\u001a\u00020AJ\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018¨\u0006C"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;", "", "headerBackgroundColor", "", "cellBackgroundColor", "tableBorderColor", "tableFontSize", "", "tableLineHeight", "cellMinWidth", "cellMaxWidth", "tableBorderWidth", "tableBorderRadius", "cellPadding", "cellPaddingInsets", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getCellBackgroundColor", "()Ljava/lang/String;", "setCellBackgroundColor", "(Ljava/lang/String;)V", "getCellMaxWidth", "()Ljava/lang/Float;", "setCellMaxWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCellMinWidth", "setCellMinWidth", "getCellPadding", "setCellPadding", "getCellPaddingInsets", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setCellPaddingInsets", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "getTableBorderColor", "setTableBorderColor", "getTableBorderRadius", "setTableBorderRadius", "getTableBorderWidth", "setTableBorderWidth", "getTableFontSize", "setTableFontSize", "getTableLineHeight", "setTableLineHeight", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/TableConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/TableConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TableConfig {
    private String cellBackgroundColor;
    private Float cellMaxWidth;
    private Float cellMinWidth;
    private Float cellPadding;
    private EdgeInsets cellPaddingInsets;
    private String headerBackgroundColor;
    private String tableBorderColor;
    private Float tableBorderRadius;
    private Float tableBorderWidth;
    private Float tableFontSize;
    private Float tableLineHeight;

    public static /* synthetic */ TableConfig copy$default(TableConfig r12, String r13, String r14, String r16, Float r17, Float r18, Float r19, Float r110, Float r20, Float r21, Float r22, EdgeInsets r23, int r24, Object r26) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.headerBackgroundColor;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.cellBackgroundColor;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.tableBorderColor;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Float r5 = r12.tableFontSize;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Float r6 = r12.tableLineHeight;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Float r7 = r12.cellMinWidth;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Float r8 = r12.cellMaxWidth;
    L31:
        if ((r24 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        Float r9 = r12.tableBorderWidth;
    L35:
        if ((r24 & 256) == 0) goto L37;
        Float r10 = r12.tableBorderRadius;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Float r11 = r12.cellPadding;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        EdgeInsets r1 = r12.cellPaddingInsets;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r110;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.headerBackgroundColor;
    }

    public final Float component10() {
        return this.cellPadding;
    }

    public final EdgeInsets component11() {
        return this.cellPaddingInsets;
    }

    public final String component2() {
        return this.cellBackgroundColor;
    }

    public final String component3() {
        return this.tableBorderColor;
    }

    public final Float component4() {
        return this.tableFontSize;
    }

    public final Float component5() {
        return this.tableLineHeight;
    }

    public final Float component6() {
        return this.cellMinWidth;
    }

    public final Float component7() {
        return this.cellMaxWidth;
    }

    public final Float component8() {
        return this.tableBorderWidth;
    }

    public final Float component9() {
        return this.tableBorderRadius;
    }

    public final TableConfig copy(String r14, String r16, String r17, Float r18, Float r19, Float r110, Float r20, Float r21, Float r22, Float r23, EdgeInsets r24) {
        return new TableConfig(r14, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TableConfig) == true) goto L8;
        return false;
    L8:
        TableConfig r6 = (TableConfig) r5;
        if (Intrinsics.areEqual(this.headerBackgroundColor, r6.headerBackgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cellBackgroundColor, r6.cellBackgroundColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tableBorderColor, r6.tableBorderColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tableFontSize, r6.tableFontSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tableLineHeight, r6.tableLineHeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cellMinWidth, r6.cellMinWidth) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cellMaxWidth, r6.cellMaxWidth) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tableBorderWidth, r6.tableBorderWidth) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tableBorderRadius, r6.tableBorderRadius) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cellPadding, r6.cellPadding) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.cellPaddingInsets, r6.cellPaddingInsets) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r0 = this.headerBackgroundColor;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.cellBackgroundColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.tableBorderColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.tableFontSize;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.tableLineHeight;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        Float r17 = this.cellMinWidth;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.cellMaxWidth;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Float r23 = this.tableBorderWidth;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r26 = (r22 + r24) * 31;
        Float r27 = this.tableBorderRadius;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        Float r30 = this.cellPadding;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        EdgeInsets r33 = this.cellPaddingInsets;
        if (r33 == null) goto L47;
        r1 = r33.hashCode();
    L47:
        return r32 + r1;
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
        return "TableConfig(headerBackgroundColor=" + this.headerBackgroundColor + ", cellBackgroundColor=" + this.cellBackgroundColor + ", tableBorderColor=" + this.tableBorderColor + ", tableFontSize=" + this.tableFontSize + ", tableLineHeight=" + this.tableLineHeight + ", cellMinWidth=" + this.cellMinWidth + ", cellMaxWidth=" + this.cellMaxWidth + ", tableBorderWidth=" + this.tableBorderWidth + ", tableBorderRadius=" + this.tableBorderRadius + ", cellPadding=" + this.cellPadding + ", cellPaddingInsets=" + this.cellPaddingInsets + ')';
    }

    public final lark_markdown_render.proto.TableConfig into() {
        String r1 = this.headerBackgroundColor;
        String r2 = this.cellBackgroundColor;
        String r3 = this.tableBorderColor;
        Float r4 = this.tableFontSize;
        Float r5 = this.tableLineHeight;
        Float r6 = this.cellMinWidth;
        Float r7 = this.cellMaxWidth;
        Float r8 = this.tableBorderWidth;
        Float r9 = this.tableBorderRadius;
        Float r10 = this.cellPadding;
        EdgeInsets r0 = this.cellPaddingInsets;
        if (r0 == null) goto L5;
        lark_markdown_render.proto.EdgeInsets r11 = r0.into();
    L7:
        return new lark_markdown_render.proto.TableConfig(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L5:
        r11 = null;
        goto L7
    }

    public final String getCellBackgroundColor() {
        return this.cellBackgroundColor;
    }

    public final Float getCellMaxWidth() {
        return this.cellMaxWidth;
    }

    public final Float getCellMinWidth() {
        return this.cellMinWidth;
    }

    public final Float getCellPadding() {
        return this.cellPadding;
    }

    public final EdgeInsets getCellPaddingInsets() {
        return this.cellPaddingInsets;
    }

    public final String getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    public final String getTableBorderColor() {
        return this.tableBorderColor;
    }

    public final Float getTableBorderRadius() {
        return this.tableBorderRadius;
    }

    public final Float getTableBorderWidth() {
        return this.tableBorderWidth;
    }

    public final Float getTableFontSize() {
        return this.tableFontSize;
    }

    public final Float getTableLineHeight() {
        return this.tableLineHeight;
    }

    public final void setCellBackgroundColor(String r1) {
        this.cellBackgroundColor = r1;
    }

    public final void setCellMaxWidth(Float r1) {
        this.cellMaxWidth = r1;
    }

    public final void setCellMinWidth(Float r1) {
        this.cellMinWidth = r1;
    }

    public final void setCellPadding(Float r1) {
        this.cellPadding = r1;
    }

    public final void setCellPaddingInsets(EdgeInsets r1) {
        this.cellPaddingInsets = r1;
    }

    public final void setHeaderBackgroundColor(String r1) {
        this.headerBackgroundColor = r1;
    }

    public final void setTableBorderColor(String r1) {
        this.tableBorderColor = r1;
    }

    public final void setTableBorderRadius(Float r1) {
        this.tableBorderRadius = r1;
    }

    public final void setTableBorderWidth(Float r1) {
        this.tableBorderWidth = r1;
    }

    public final void setTableFontSize(Float r1) {
        this.tableFontSize = r1;
    }

    public final void setTableLineHeight(Float r1) {
        this.tableLineHeight = r1;
    }

    public TableConfig(String r1, String r2, String r3, Float r4, Float r5, Float r6, Float r7, Float r8, Float r9, Float r10, EdgeInsets r11) {
        this.headerBackgroundColor = r1;
        this.cellBackgroundColor = r2;
        this.tableBorderColor = r3;
        this.tableFontSize = r4;
        this.tableLineHeight = r5;
        this.cellMinWidth = r6;
        this.cellMaxWidth = r7;
        this.tableBorderWidth = r8;
        this.tableBorderRadius = r9;
        this.cellPadding = r10;
        this.cellPaddingInsets = r11;
    }
}
