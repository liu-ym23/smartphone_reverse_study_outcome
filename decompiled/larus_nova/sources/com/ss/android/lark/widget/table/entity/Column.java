package com.ss.android.lark.widget.table.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J<\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/widget/table/entity/Column;", "Ljava/io/Serializable;", "width", "", "horizontalAlign", "Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "verticalAlign", "Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "isHeader", "", "<init>", "(Ljava/lang/Integer;Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;Lcom/ss/android/lark/widget/table/entity/VerticalAlign;Z)V", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHorizontalAlign", "()Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;", "getVerticalAlign", "()Lcom/ss/android/lark/widget/table/entity/VerticalAlign;", "()Z", "equals", "other", "", "hashCode", "toString", "", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/ss/android/lark/widget/table/entity/HorizontalAlign;Lcom/ss/android/lark/widget/table/entity/VerticalAlign;Z)Lcom/ss/android/lark/widget/table/entity/Column;", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Column implements Serializable {
    private final HorizontalAlign horizontalAlign;
    private final boolean isHeader;
    private final VerticalAlign verticalAlign;
    private final Integer width;

    public static /* synthetic */ Column copy$default(Column r100, Integer r101, HorizontalAlign r102, VerticalAlign r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.horizontalAlign;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.verticalAlign;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isHeader;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.width;
    }

    public final HorizontalAlign component2() {
        return this.horizontalAlign;
    }

    public final VerticalAlign component3() {
        return this.verticalAlign;
    }

    public final boolean component4() {
        return this.isHeader;
    }

    public final Column copy(Integer r100, HorizontalAlign r101, VerticalAlign r102, boolean r103) {
        return new Column(r100, r101, r102, r103);
    }

    public int hashCode() {
        Integer r100 = this.width;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = r102 * 31;
        HorizontalAlign r104 = this.horizontalAlign;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        VerticalAlign r107 = this.verticalAlign;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        if (this.isHeader == false) goto L16;
        int r109 = 1231;
    L18:
        return r108 + r109;
    L16:
        r109 = 1237;
        goto L18
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Column(width=" + this.width + ", horizontalAlign=" + this.horizontalAlign + ", verticalAlign=" + this.verticalAlign + ", isHeader=" + this.isHeader + ')';
    }

    public final HorizontalAlign getHorizontalAlign() {
        return this.horizontalAlign;
    }

    public final VerticalAlign getVerticalAlign() {
        return this.verticalAlign;
    }

    public final Integer getWidth() {
        return this.width;
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
        if (Intrinsics.areEqual(Column.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.table.entity.Column");
        Column r102 = (Column) r100;
        if (Intrinsics.areEqual(this.width, r102.width) == true) goto L16;
        return false;
    L16:
        if (this.horizontalAlign == r102.horizontalAlign) goto L19;
        return false;
    L19:
        if (this.verticalAlign == r102.verticalAlign) goto L22;
        return false;
    L22:
        if (this.isHeader == r102.isHeader) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public Column(Integer r100, HorizontalAlign r101, VerticalAlign r102, boolean r103) {
        this.width = r100;
        this.horizontalAlign = r101;
        this.verticalAlign = r102;
        this.isHeader = r103;
    }

    public /* synthetic */ Column(Integer r100, HorizontalAlign r101, VerticalAlign r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, r101, r102, r103);
    }
}
