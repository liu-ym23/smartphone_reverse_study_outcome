package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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

    public static /* synthetic */ TableConfig copy$default(TableConfig r110, String r111, String r112, String r113, Float r114, Float r115, Float r116, Float r117, Float r210, Float r211, Float r212, EdgeInsets r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.headerBackgroundColor;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.cellBackgroundColor;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.tableBorderColor;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Float r103 = r110.tableFontSize;
    L19:
        if ((r214 & 16) == 0) goto L21;
        Float r104 = r110.tableLineHeight;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Float r105 = r110.cellMinWidth;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Float r106 = r110.cellMaxWidth;
    L31:
        if ((r214 & 128) == 0) goto L33;
        Float r107 = r110.tableBorderWidth;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Float r118 = r110.tableBorderRadius;
    L39:
        if ((r214 & 512) == 0) goto L41;
        Float r119 = r110.cellPadding;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        EdgeInsets r108 = r110.cellPaddingInsets;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final TableConfig copy(String r110, String r111, String r112, Float r113, Float r114, Float r115, Float r210, Float r211, Float r212, Float r213, EdgeInsets r214) {
        return new TableConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TableConfig) == true) goto L8;
        return false;
    L8:
        TableConfig r101 = (TableConfig) r100;
        if (Intrinsics.areEqual(this.headerBackgroundColor, r101.headerBackgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cellBackgroundColor, r101.cellBackgroundColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tableBorderColor, r101.tableBorderColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tableFontSize, r101.tableFontSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tableLineHeight, r101.tableLineHeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cellMinWidth, r101.cellMinWidth) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cellMaxWidth, r101.cellMaxWidth) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tableBorderWidth, r101.tableBorderWidth) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tableBorderRadius, r101.tableBorderRadius) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cellPadding, r101.cellPadding) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.cellPaddingInsets, r101.cellPaddingInsets) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.headerBackgroundColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.cellBackgroundColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tableBorderColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.tableFontSize;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.tableLineHeight;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.cellMinWidth;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.cellMaxWidth;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.tableBorderWidth;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Float r125 = this.tableBorderRadius;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Float r128 = this.cellPadding;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        EdgeInsets r131 = this.cellPaddingInsets;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "TableConfig(headerBackgroundColor=" + this.headerBackgroundColor + ", cellBackgroundColor=" + this.cellBackgroundColor + ", tableBorderColor=" + this.tableBorderColor + ", tableFontSize=" + this.tableFontSize + ", tableLineHeight=" + this.tableLineHeight + ", cellMinWidth=" + this.cellMinWidth + ", cellMaxWidth=" + this.cellMaxWidth + ", tableBorderWidth=" + this.tableBorderWidth + ", tableBorderRadius=" + this.tableBorderRadius + ", cellPadding=" + this.cellPadding + ", cellPaddingInsets=" + this.cellPaddingInsets + ')';
    }

    public final lark_markdown_render.proto.TableConfig into() {
        String r100 = this.headerBackgroundColor;
        String r101 = this.cellBackgroundColor;
        String r102 = this.tableBorderColor;
        Float r103 = this.tableFontSize;
        Float r104 = this.tableLineHeight;
        Float r105 = this.cellMinWidth;
        Float r106 = this.cellMaxWidth;
        Float r107 = this.tableBorderWidth;
        Float r108 = this.tableBorderRadius;
        Float r110 = this.cellPadding;
        EdgeInsets r109 = this.cellPaddingInsets;
        if (r109 == null) goto L5;
        lark_markdown_render.proto.EdgeInsets r111 = r109.into();
    L7:
        return new lark_markdown_render.proto.TableConfig(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    L5:
        r111 = null;
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

    public final void setCellBackgroundColor(String r100) {
        this.cellBackgroundColor = r100;
    }

    public final void setCellMaxWidth(Float r100) {
        this.cellMaxWidth = r100;
    }

    public final void setCellMinWidth(Float r100) {
        this.cellMinWidth = r100;
    }

    public final void setCellPadding(Float r100) {
        this.cellPadding = r100;
    }

    public final void setCellPaddingInsets(EdgeInsets r100) {
        this.cellPaddingInsets = r100;
    }

    public final void setHeaderBackgroundColor(String r100) {
        this.headerBackgroundColor = r100;
    }

    public final void setTableBorderColor(String r100) {
        this.tableBorderColor = r100;
    }

    public final void setTableBorderRadius(Float r100) {
        this.tableBorderRadius = r100;
    }

    public final void setTableBorderWidth(Float r100) {
        this.tableBorderWidth = r100;
    }

    public final void setTableFontSize(Float r100) {
        this.tableFontSize = r100;
    }

    public final void setTableLineHeight(Float r100) {
        this.tableLineHeight = r100;
    }

    public TableConfig(String r100, String r101, String r102, Float r103, Float r104, Float r105, Float r106, Float r107, Float r108, Float r110, EdgeInsets r111) {
        this.headerBackgroundColor = r100;
        this.cellBackgroundColor = r101;
        this.tableBorderColor = r102;
        this.tableFontSize = r103;
        this.tableLineHeight = r104;
        this.cellMinWidth = r105;
        this.cellMaxWidth = r106;
        this.tableBorderWidth = r107;
        this.tableBorderRadius = r108;
        this.cellPadding = r110;
        this.cellPaddingInsets = r111;
    }
}
