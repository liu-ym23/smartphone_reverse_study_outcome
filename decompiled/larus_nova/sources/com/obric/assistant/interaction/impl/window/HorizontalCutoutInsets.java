package com.obric.assistant.interaction.impl.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/HorizontalCutoutInsets;", "", "left", "", "right", "<init>", "(II)V", "getLeft", "()I", "getRight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalCutoutInsets {
    private final int left;
    private final int right;

    public HorizontalCutoutInsets() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ HorizontalCutoutInsets copy$default(HorizontalCutoutInsets r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.right;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.right;
    }

    public final HorizontalCutoutInsets copy(int r100, int r101) {
        return new HorizontalCutoutInsets(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HorizontalCutoutInsets) == true) goto L8;
        return false;
    L8:
        HorizontalCutoutInsets r101 = (HorizontalCutoutInsets) r100;
        if (this.left == r101.left) goto L12;
        return false;
    L12:
        if (this.right == r101.right) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.left * 31) + this.right;
    }

    public String toString() {
        return "HorizontalCutoutInsets(left=" + this.left + ", right=" + this.right + ')';
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public HorizontalCutoutInsets(int r100, int r101) {
        this.left = r100;
        this.right = r101;
    }

    public /* synthetic */ HorizontalCutoutInsets(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
