package com.ss.android.lark.widget.table.entity;

import android.text.Layout;
import com.ss.android.lark.widget.span.SpanInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002-.B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0012J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006/"}, d2 = {"Lcom/ss/android/lark/widget/table/entity/TableInfo;", "Lcom/ss/android/lark/widget/span/SpanInfo;", "columnSpan", "", "rowSpan", "columnInfo", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/widget/table/entity/Column;", "tableRowPropertyMap", "Ljava/util/HashMap;", "Lcom/ss/android/lark/widget/table/entity/TableInfo$TableRowPropertyWrapper;", "Lkotlin/collections/HashMap;", "tableCellPropertyMap", "Lcom/ss/android/lark/widget/table/entity/TableInfo$TableCellPropertyWrapper;", "tableRootId", "", "<init>", "(IILjava/util/LinkedList;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;)V", "()V", "getColumnSpan", "()I", "setColumnSpan", "(I)V", "getRowSpan", "setRowSpan", "getColumnInfo", "()Ljava/util/LinkedList;", "setColumnInfo", "(Ljava/util/LinkedList;)V", "getTableRowPropertyMap", "()Ljava/util/HashMap;", "setTableRowPropertyMap", "(Ljava/util/HashMap;)V", "getTableCellPropertyMap", "setTableCellPropertyMap", "getTableRootId", "()Ljava/lang/String;", "setTableRootId", "(Ljava/lang/String;)V", "equals", "", "other", "", "hashCode", "toString", "TableRowPropertyWrapper", "TableCellPropertyWrapper", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableInfo extends SpanInfo {
    private LinkedList<Column> columnInfo;
    private int columnSpan;
    private int rowSpan;
    private HashMap<Integer, TableCellPropertyWrapper> tableCellPropertyMap;
    private String tableRootId;
    private HashMap<Integer, TableRowPropertyWrapper> tableRowPropertyMap;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020.H\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006/"}, d2 = {"Lcom/ss/android/lark/widget/table/entity/TableInfo$TableCellPropertyWrapper;", "Ljava/io/Serializable;", "columnSpanOccupied", "", "rowSpanOccupied", "horizontalAlign", "Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "verticalAlign", "Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "columnWidth", "isMerged", "", "layout", "Landroid/text/Layout;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;Lcom/ss/android/lark/widget/table/entity/VerticalAlign;Ljava/lang/Integer;ZLandroid/text/Layout;)V", "()V", "getColumnSpanOccupied", "()Ljava/lang/Integer;", "setColumnSpanOccupied", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRowSpanOccupied", "setRowSpanOccupied", "getHorizontalAlign", "()Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "setHorizontalAlign", "(Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;)V", "getVerticalAlign", "()Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "setVerticalAlign", "(Lcom/ss/android/lark/widget/table/entity/VerticalAlign;)V", "getColumnWidth", "setColumnWidth", "()Z", "setMerged", "(Z)V", "getLayout", "()Landroid/text/Layout;", "setLayout", "(Landroid/text/Layout;)V", "equals", "other", "", "hashCode", "toString", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TableCellPropertyWrapper implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Layout f448897a;
        private Integer columnSpanOccupied;
        private Integer columnWidth;
        private HorizontalAlign horizontalAlign;
        private boolean isMerged;
        private Integer rowSpanOccupied;
        private VerticalAlign verticalAlign;

        public TableCellPropertyWrapper() {
            this(null, null, null, null, null, false, null);
        }

        public int hashCode() {
            Integer r100 = this.columnSpanOccupied;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.intValue();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.rowSpanOccupied;
            if (r104 == null) goto L9;
            int r105 = r104.intValue();
        L10:
            int r106 = (r103 + r105) * 31;
            HorizontalAlign r107 = this.horizontalAlign;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            VerticalAlign r110 = this.verticalAlign;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.columnWidth;
            if (r113 == null) goto L21;
            int r114 = r113.intValue();
        L22:
            int r115 = (r112 + r114) * 31;
            if (this.isMerged == false) goto L25;
            int r116 = 1231;
        L26:
            int r117 = (r115 + r116) * 31;
            Layout r118 = this.f448897a;
            if (r118 == null) goto L30;
            r101 = r118.hashCode();
        L30:
            return r117 + r101;
        L25:
            r116 = 1237;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "TableCellPropertyWrapper(columnSpanOccupied=" + this.columnSpanOccupied + ", rowSpanOccupied=" + this.rowSpanOccupied + ", horizontalAlign=" + this.horizontalAlign + ", verticalAlign=" + this.verticalAlign + ", columnWidth=" + this.columnWidth + ", isMerged=" + this.isMerged + ", layout=" + this.f448897a + ')';
        }

        public final Integer getColumnSpanOccupied() {
            return this.columnSpanOccupied;
        }

        public final Integer getColumnWidth() {
            return this.columnWidth;
        }

        public final HorizontalAlign getHorizontalAlign() {
            return this.horizontalAlign;
        }

        public final Layout getLayout() {
            return this.f448897a;
        }

        public final Integer getRowSpanOccupied() {
            return this.rowSpanOccupied;
        }

        public final VerticalAlign getVerticalAlign() {
            return this.verticalAlign;
        }

        public final boolean isMerged() {
            return this.isMerged;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(TableCellPropertyWrapper.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.table.entity.TableInfo.TableCellPropertyWrapper");
            TableCellPropertyWrapper r102 = (TableCellPropertyWrapper) r100;
            if (Intrinsics.areEqual(this.columnSpanOccupied, r102.columnSpanOccupied) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.rowSpanOccupied, r102.rowSpanOccupied) == true) goto L19;
            return false;
        L19:
            if (this.horizontalAlign == r102.horizontalAlign) goto L22;
            return false;
        L22:
            if (this.verticalAlign == r102.verticalAlign) goto L25;
            return false;
        L25:
            if (Intrinsics.areEqual(this.columnWidth, r102.columnWidth) == true) goto L28;
            return false;
        L28:
            if (this.isMerged == r102.isMerged) goto L31;
            return false;
        L31:
            if (Intrinsics.areEqual(this.f448897a, r102.f448897a) == true) goto L33;
            return false;
        L33:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public final void setColumnSpanOccupied(Integer r100) {
            this.columnSpanOccupied = r100;
        }

        public final void setColumnWidth(Integer r100) {
            this.columnWidth = r100;
        }

        public final void setHorizontalAlign(HorizontalAlign r100) {
            this.horizontalAlign = r100;
        }

        public final void setLayout(Layout r100) {
            this.f448897a = r100;
        }

        public final void setMerged(boolean r100) {
            this.isMerged = r100;
        }

        public final void setRowSpanOccupied(Integer r100) {
            this.rowSpanOccupied = r100;
        }

        public final void setVerticalAlign(VerticalAlign r100) {
            this.verticalAlign = r100;
        }

        public TableCellPropertyWrapper(Integer r100, Integer r101, HorizontalAlign r102, VerticalAlign r103, Integer r104, boolean r105, Layout r106) {
            this.columnSpanOccupied = r100;
            this.rowSpanOccupied = r101;
            this.horizontalAlign = r102;
            this.verticalAlign = r103;
            this.columnWidth = r104;
            this.isMerged = r105;
            this.f448897a = r106;
        }

        public /* synthetic */ TableCellPropertyWrapper(Integer r110, Integer r111, HorizontalAlign r112, VerticalAlign r113, Integer r114, boolean r115, Layout r116, int r117, DefaultConstructorMarker r118) {
            if ((r117 & 1) == 0) goto L5;
            Integer r100 = 0;
        L7:
            if ((r117 & 2) == 0) goto L9;
            Integer r101 = 0;
        L11:
            if ((r117 & 4) == 0) goto L13;
            HorizontalAlign r102 = HorizontalAlign.HORIZONTAL_ALIGN_LEFT;
        L15:
            if ((r117 & 8) == 0) goto L17;
            VerticalAlign r103 = VerticalAlign.VERTICAL_ALIGN_TOP;
        L19:
            if ((r117 & 16) == 0) goto L21;
            Integer r104 = 0;
        L22:
            this(r100, r101, r102, r103, r104, r115, r116);
            return;
        L21:
            r104 = r114;
            goto L22
        L17:
            r103 = r113;
            goto L19
        L13:
            r102 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\t\b\u0016¢\u0006\u0004\b\b\u0010\nJ\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/widget/table/entity/TableInfo$TableRowPropertyWrapper;", "Ljava/io/Serializable;", "horizontalAlign", "Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "verticalAlign", "Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "isHeader", "", "<init>", "(Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;Lcom/ss/android/lark/widget/table/entity/VerticalAlign;Z)V", "()V", "getHorizontalAlign", "()Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "setHorizontalAlign", "(Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;)V", "getVerticalAlign", "()Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "setVerticalAlign", "(Lcom/ss/android/lark/widget/table/entity/VerticalAlign;)V", "()Z", "setHeader", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TableRowPropertyWrapper implements Serializable {
        private HorizontalAlign horizontalAlign;
        private boolean isHeader;
        private VerticalAlign verticalAlign;

        public TableRowPropertyWrapper() {
            this(null, null, false);
        }

        public int hashCode() {
            HorizontalAlign r100 = this.horizontalAlign;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            VerticalAlign r104 = this.verticalAlign;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            if (this.isHeader == false) goto L12;
            int r106 = 1231;
        L14:
            return r105 + r106;
        L12:
            r106 = 1237;
            goto L14
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "TableRowPropertyWrapper(horizontalAlign=" + this.horizontalAlign + ", verticalAlign=" + this.verticalAlign + ", isHeader=" + this.isHeader + ')';
        }

        public final HorizontalAlign getHorizontalAlign() {
            return this.horizontalAlign;
        }

        public final VerticalAlign getVerticalAlign() {
            return this.verticalAlign;
        }

        public final boolean isHeader() {
            return this.isHeader;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(TableRowPropertyWrapper.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.table.entity.TableInfo.TableRowPropertyWrapper");
            TableRowPropertyWrapper r102 = (TableRowPropertyWrapper) r100;
            if (this.horizontalAlign == r102.horizontalAlign) goto L16;
            return false;
        L16:
            if (this.verticalAlign == r102.verticalAlign) goto L19;
            return false;
        L19:
            if (this.isHeader == r102.isHeader) goto L21;
            return false;
        L21:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public final void setHeader(boolean r100) {
            this.isHeader = r100;
        }

        public final void setHorizontalAlign(HorizontalAlign r100) {
            this.horizontalAlign = r100;
        }

        public final void setVerticalAlign(VerticalAlign r100) {
            this.verticalAlign = r100;
        }

        public TableRowPropertyWrapper(HorizontalAlign r100, VerticalAlign r101, boolean r102) {
            this.horizontalAlign = r100;
            this.verticalAlign = r101;
            this.isHeader = r102;
        }

        public /* synthetic */ TableRowPropertyWrapper(HorizontalAlign r100, VerticalAlign r101, boolean r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = HorizontalAlign.HORIZONTAL_ALIGN_LEFT;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r101 = VerticalAlign.VERTICAL_ALIGN_TOP;
        L8:
            this(r100, r101, r102);
        }
    }

    public TableInfo() {
        this(0, 0, null, null, null, "");
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public String toString() {
        return "TableInfo(columnSpan=" + this.columnSpan + ", rowSpan=" + this.rowSpan + ", columnInfo=" + this.columnInfo + ", tableRowPropertyMap=" + this.tableRowPropertyMap + ", tableCellPropertyMap=" + this.tableCellPropertyMap + ", tableRootId='" + this.tableRootId + "')";
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        int r100 = ((((super.hashCode() * 31) + this.columnSpan) * 31) + this.rowSpan) * 31;
        LinkedList<Column> r101 = this.columnInfo;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        HashMap<Integer, TableRowPropertyWrapper> r105 = this.tableRowPropertyMap;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        HashMap<Integer, TableCellPropertyWrapper> r108 = this.tableCellPropertyMap;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.tableRootId;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final LinkedList<Column> getColumnInfo() {
        return this.columnInfo;
    }

    public final int getColumnSpan() {
        return this.columnSpan;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }

    public final HashMap<Integer, TableCellPropertyWrapper> getTableCellPropertyMap() {
        return this.tableCellPropertyMap;
    }

    public final String getTableRootId() {
        return this.tableRootId;
    }

    public final HashMap<Integer, TableRowPropertyWrapper> getTableRowPropertyMap() {
        return this.tableRowPropertyMap;
    }

    @Override // com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TableInfo.class, r101) == true) goto L13;
        return false;
    L13:
        if (super.equals(r100) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.table.entity.TableInfo");
        TableInfo r102 = (TableInfo) r100;
        if (this.columnSpan == r102.columnSpan) goto L19;
        return false;
    L19:
        if (this.rowSpan == r102.rowSpan) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.columnInfo, r102.columnInfo) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.tableRowPropertyMap, r102.tableRowPropertyMap) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.tableCellPropertyMap, r102.tableCellPropertyMap) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.tableRootId, r102.tableRootId) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setColumnInfo(LinkedList<Column> r100) {
        this.columnInfo = r100;
    }

    public final void setColumnSpan(int r100) {
        this.columnSpan = r100;
    }

    public final void setRowSpan(int r100) {
        this.rowSpan = r100;
    }

    public final void setTableCellPropertyMap(HashMap<Integer, TableCellPropertyWrapper> r100) {
        this.tableCellPropertyMap = r100;
    }

    public final void setTableRootId(String r100) {
        this.tableRootId = r100;
    }

    public final void setTableRowPropertyMap(HashMap<Integer, TableRowPropertyWrapper> r100) {
        this.tableRowPropertyMap = r100;
    }

    public TableInfo(int r100, int r101, LinkedList<Column> r102, HashMap<Integer, TableRowPropertyWrapper> r103, HashMap<Integer, TableCellPropertyWrapper> r104, String r105) {
        this.columnSpan = r100;
        this.rowSpan = r101;
        this.columnInfo = r102;
        this.tableRowPropertyMap = r103;
        this.tableCellPropertyMap = r104;
        this.tableRootId = r105;
    }

    public /* synthetic */ TableInfo(int r100, int r101, LinkedList r110, HashMap r111, HashMap r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = "";
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
