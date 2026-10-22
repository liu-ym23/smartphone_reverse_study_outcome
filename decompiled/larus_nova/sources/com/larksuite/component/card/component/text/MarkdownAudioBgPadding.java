package com.larksuite.component.card.component.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/card/component/text/MarkdownAudioBgPadding;", "", "top", "", "right", "bottom", "left", "<init>", "(IIII)V", "getTop", "()I", "setTop", "(I)V", "getRight", "setRight", "getBottom", "setBottom", "getLeft", "setLeft", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownAudioBgPadding {
    private int bottom;
    private int left;
    private int right;
    private int top;

    public MarkdownAudioBgPadding() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ MarkdownAudioBgPadding copy$default(MarkdownAudioBgPadding r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
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

    public final MarkdownAudioBgPadding copy(int r100, int r101, int r102, int r103) {
        return new MarkdownAudioBgPadding(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarkdownAudioBgPadding) == true) goto L8;
        return false;
    L8:
        MarkdownAudioBgPadding r101 = (MarkdownAudioBgPadding) r100;
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
        return "MarkdownAudioBgPadding(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
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

    public final void setBottom(int r100) {
        this.bottom = r100;
    }

    public final void setLeft(int r100) {
        this.left = r100;
    }

    public final void setRight(int r100) {
        this.right = r100;
    }

    public final void setTop(int r100) {
        this.top = r100;
    }

    public MarkdownAudioBgPadding(int r100, int r101, int r102, int r103) {
        this.top = r100;
        this.right = r101;
        this.bottom = r102;
        this.left = r103;
    }

    public /* synthetic */ MarkdownAudioBgPadding(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
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
