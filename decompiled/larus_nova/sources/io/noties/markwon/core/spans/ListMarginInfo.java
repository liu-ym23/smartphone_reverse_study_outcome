package io.noties.markwon.core.spans;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/core/spans/ListMarginInfo;", "", "dotDiameter", "", "bulletDotOffset", "listMargin", "(III)V", "getBulletDotOffset", "()I", "getDotDiameter", "getListMargin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class ListMarginInfo {
    private final int bulletDotOffset;
    private final int dotDiameter;
    private final int listMargin;

    public static /* synthetic */ ListMarginInfo copy$default(ListMarginInfo r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.dotDiameter;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bulletDotOffset;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.listMargin;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.dotDiameter;
    }

    public final int component2() {
        return this.bulletDotOffset;
    }

    public final int component3() {
        return this.listMargin;
    }

    public final ListMarginInfo copy(int r100, int r101, int r102) {
        return new ListMarginInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L23:
        return true;
    L5:
        if ((r100 instanceof ListMarginInfo) == false) goto L22;
        ListMarginInfo r101 = (ListMarginInfo) r100;
        if (this.dotDiameter != r101.dotDiameter) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L22;
        if (this.bulletDotOffset != r101.bulletDotOffset) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L22;
        if (this.listMargin != r101.listMargin) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L22:
        return false;
    }

    public int hashCode() {
        return (((this.dotDiameter * 31) + this.bulletDotOffset) * 31) + this.listMargin;
    }

    public String toString() {
        return "ListMarginInfo(dotDiameter=" + this.dotDiameter + ", bulletDotOffset=" + this.bulletDotOffset + ", listMargin=" + this.listMargin + ")";
    }

    public final int getBulletDotOffset() {
        return this.bulletDotOffset;
    }

    public final int getDotDiameter() {
        return this.dotDiameter;
    }

    public final int getListMargin() {
        return this.listMargin;
    }

    public ListMarginInfo(int r100, int r101, int r102) {
        this.dotDiameter = r100;
        this.bulletDotOffset = r101;
        this.listMargin = r102;
    }
}
