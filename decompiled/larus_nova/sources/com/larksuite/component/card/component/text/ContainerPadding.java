package com.larksuite.component.card.component.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/card/component/text/ContainerPadding;", "", "top", "", "right", "bottom", "left", "<init>", "(IIII)V", "getTop", "()I", "getRight", "getBottom", "getLeft", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContainerPadding {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public ContainerPadding() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ContainerPadding copy$default(ContainerPadding r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.top;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.right;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bottom;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.left;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.top;
    }

    public final int component2() {
        return this.right;
    }

    public final int component3() {
        return this.bottom;
    }

    public final int component4() {
        return this.left;
    }

    public final ContainerPadding copy(int r100, int r101, int r102, int r103) {
        return new ContainerPadding(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContainerPadding) == true) goto L8;
        return false;
    L8:
        ContainerPadding r101 = (ContainerPadding) r100;
        if (this.top == r101.top) goto L12;
        return false;
    L12:
        if (this.right == r101.right) goto L15;
        return false;
    L15:
        if (this.bottom == r101.bottom) goto L18;
        return false;
    L18:
        if (this.left == r101.left) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.top * 31) + this.right) * 31) + this.bottom) * 31) + this.left;
    }

    public String toString() {
        return "ContainerPadding(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public ContainerPadding(int r100, int r101, int r102, int r103) {
        this.top = r100;
        this.right = r101;
        this.bottom = r102;
        this.left = r103;
    }

    public /* synthetic */ ContainerPadding(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
