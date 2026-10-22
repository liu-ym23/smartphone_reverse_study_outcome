package com.ss.android.lark.widget.table.newrefactor;

import android.text.Layout;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u000204H\u0016J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003Js\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010+\"\u0004\b.\u0010-¨\u0006@"}, d2 = {"Lcom/ss/android/lark/widget/table/newrefactor/TableCellData;", "Ljava/io/Serializable;", "contentLayout", "Landroid/text/Layout;", "verticalAlign", "Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "horizontalAlign", "Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "cellWidth", "", "rowIndex", "columnIndex", "rowSpanOccupied", "columnSpanOccupied", "isLastRow", "", "isLastColumn", "<init>", "(Landroid/text/Layout;Lcom/ss/android/lark/widget/table/entity/VerticalAlign;Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;IIIIIZZ)V", "getContentLayout", "()Landroid/text/Layout;", "setContentLayout", "(Landroid/text/Layout;)V", "getVerticalAlign", "()Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "setVerticalAlign", "(Lcom/ss/android/lark/widget/table/entity/VerticalAlign;)V", "getHorizontalAlign", "()Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "setHorizontalAlign", "(Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;)V", "getCellWidth", "()I", "setCellWidth", "(I)V", "getRowIndex", "setRowIndex", "getColumnIndex", "setColumnIndex", "getRowSpanOccupied", "setRowSpanOccupied", "getColumnSpanOccupied", "setColumnSpanOccupied", "()Z", "setLastRow", "(Z)V", "setLastColumn", "equals", "other", "", "hashCode", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableCellData implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Layout f448900a;
    private int cellWidth;
    private int columnIndex;
    private int columnSpanOccupied;
    private HorizontalAlign horizontalAlign;
    private boolean isLastColumn;
    private boolean isLastRow;
    private int rowIndex;
    private int rowSpanOccupied;
    private VerticalAlign verticalAlign;

    public static /* synthetic */ TableCellData copy$default(TableCellData r110, Layout r111, VerticalAlign r112, HorizontalAlign r113, int r114, int r115, int r116, int r117, int r118, boolean r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Layout r100 = r110.f448900a;
    L7:
        if ((r212 & 2) == 0) goto L9;
        VerticalAlign r101 = r110.verticalAlign;
    L11:
        if ((r212 & 4) == 0) goto L13;
        HorizontalAlign r102 = r110.horizontalAlign;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.cellWidth;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.rowIndex;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.columnIndex;
    L27:
        if ((r212 & 64) == 0) goto L29;
        int r106 = r110.rowSpanOccupied;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r107 = r110.columnSpanOccupied;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r119 = r110.isLastRow;
    L39:
        if ((r212 & 512) == 0) goto L41;
        boolean r108 = r110.isLastColumn;
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

    public final Layout component1() {
        return this.f448900a;
    }

    public final boolean component10() {
        return this.isLastColumn;
    }

    public final VerticalAlign component2() {
        return this.verticalAlign;
    }

    public final HorizontalAlign component3() {
        return this.horizontalAlign;
    }

    public final int component4() {
        return this.cellWidth;
    }

    public final int component5() {
        return this.rowIndex;
    }

    public final int component6() {
        return this.columnIndex;
    }

    public final int component7() {
        return this.rowSpanOccupied;
    }

    public final int component8() {
        return this.columnSpanOccupied;
    }

    public final boolean component9() {
        return this.isLastRow;
    }

    public final TableCellData copy(Layout r110, VerticalAlign r111, HorizontalAlign r112, int r113, int r114, int r115, int r116, int r210, boolean r211, boolean r212) {
        return new TableCellData(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public int hashCode() {
        Layout r100 = this.f448900a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VerticalAlign r104 = this.verticalAlign;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HorizontalAlign r107 = this.horizontalAlign;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (((((((((((r106 + r101) * 31) + this.cellWidth) * 31) + this.rowIndex) * 31) + this.columnIndex) * 31) + this.rowSpanOccupied) * 31) + this.columnSpanOccupied) * 31;
        int r109 = 1231;
        if (this.isLastRow == false) goto L16;
        int r110 = 1231;
    L17:
        int r111 = (r108 + r110) * 31;
        if (this.isLastColumn == true) goto L22;
        r109 = 1237;
    L22:
        return r111 + r109;
    L16:
        r110 = 1237;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TableCellData(contentLayout=" + this.f448900a + ", verticalAlign=" + this.verticalAlign + ", horizontalAlign=" + this.horizontalAlign + ", cellWidth=" + this.cellWidth + ", rowIndex=" + this.rowIndex + ", columnIndex=" + this.columnIndex + ", rowSpanOccupied=" + this.rowSpanOccupied + ", columnSpanOccupied=" + this.columnSpanOccupied + ", isLastRow=" + this.isLastRow + ", isLastColumn=" + this.isLastColumn + ')';
    }

    public final int getCellWidth() {
        return this.cellWidth;
    }

    public final int getColumnIndex() {
        return this.columnIndex;
    }

    public final int getColumnSpanOccupied() {
        return this.columnSpanOccupied;
    }

    public final Layout getContentLayout() {
        return this.f448900a;
    }

    public final HorizontalAlign getHorizontalAlign() {
        return this.horizontalAlign;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final int getRowSpanOccupied() {
        return this.rowSpanOccupied;
    }

    public final VerticalAlign getVerticalAlign() {
        return this.verticalAlign;
    }

    public final boolean isLastColumn() {
        return this.isLastColumn;
    }

    public final boolean isLastRow() {
        return this.isLastRow;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TableCellData.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.table.newrefactor.TableCellData");
        TableCellData r102 = (TableCellData) r100;
        if (Intrinsics.areEqual(this.f448900a, r102.f448900a) == true) goto L16;
        return false;
    L16:
        if (this.verticalAlign == r102.verticalAlign) goto L19;
        return false;
    L19:
        if (this.horizontalAlign == r102.horizontalAlign) goto L22;
        return false;
    L22:
        if (this.cellWidth == r102.cellWidth) goto L25;
        return false;
    L25:
        if (this.rowIndex == r102.rowIndex) goto L28;
        return false;
    L28:
        if (this.columnIndex == r102.columnIndex) goto L31;
        return false;
    L31:
        if (this.rowSpanOccupied == r102.rowSpanOccupied) goto L34;
        return false;
    L34:
        if (this.columnSpanOccupied == r102.columnSpanOccupied) goto L37;
        return false;
    L37:
        if (this.isLastRow == r102.isLastRow) goto L40;
        return false;
    L40:
        if (this.isLastColumn == r102.isLastColumn) goto L42;
        return false;
    L42:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCellWidth(int r100) {
        this.cellWidth = r100;
    }

    public final void setColumnIndex(int r100) {
        this.columnIndex = r100;
    }

    public final void setColumnSpanOccupied(int r100) {
        this.columnSpanOccupied = r100;
    }

    public final void setContentLayout(Layout r100) {
        this.f448900a = r100;
    }

    public final void setHorizontalAlign(HorizontalAlign r100) {
        this.horizontalAlign = r100;
    }

    public final void setLastColumn(boolean r100) {
        this.isLastColumn = r100;
    }

    public final void setLastRow(boolean r100) {
        this.isLastRow = r100;
    }

    public final void setRowIndex(int r100) {
        this.rowIndex = r100;
    }

    public final void setRowSpanOccupied(int r100) {
        this.rowSpanOccupied = r100;
    }

    public final void setVerticalAlign(VerticalAlign r100) {
        this.verticalAlign = r100;
    }

    public TableCellData(Layout r100, VerticalAlign r101, HorizontalAlign r102, int r103, int r104, int r105, int r106, int r107, boolean r108, boolean r110) {
        this.f448900a = r100;
        this.verticalAlign = r101;
        this.horizontalAlign = r102;
        this.cellWidth = r103;
        this.rowIndex = r104;
        this.columnIndex = r105;
        this.rowSpanOccupied = r106;
        this.columnSpanOccupied = r107;
        this.isLastRow = r108;
        this.isLastColumn = r110;
    }

    public /* synthetic */ TableCellData(Layout r110, VerticalAlign r111, HorizontalAlign r112, int r113, int r114, int r115, int r116, int r210, boolean r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 2) == 0) goto L5;
        VerticalAlign r100 = VerticalAlign.VERTICAL_ALIGN_TOP;
    L7:
        if ((r213 & 4) == 0) goto L9;
        HorizontalAlign r101 = HorizontalAlign.HORIZONTAL_ALIGN_LEFT;
    L10:
        this(r110, r100, r101, r113, r114, r115, r116, r210, r211, r212);
        return;
    L9:
        r101 = r112;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
