package com.ss.android.lark.inline.ai.ui.richtext.selection;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/selection/Position;", "Ljava/io/Serializable;", "left", "", "top", "right", "bottom", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getLeft", "()Ljava/lang/Float;", "setLeft", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "toString", "", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/ss/android/lark/inline/ai/ui/richtext/selection/Position;", "equals", "", "other", "", "hashCode", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Position implements Serializable {
    private Float bottom;
    private Float left;
    private Float right;
    private Float top;

    public Position() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Position copy$default(Position r100, Float r101, Float r102, Float r103, Float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.top;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.right;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottom;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Float component1() {
        return this.left;
    }

    public final Float component2() {
        return this.top;
    }

    public final Float component3() {
        return this.right;
    }

    public final Float component4() {
        return this.bottom;
    }

    public final Position copy(Float r100, Float r101, Float r102, Float r103) {
        return new Position(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Position) == true) goto L8;
        return false;
    L8:
        Position r101 = (Position) r100;
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Float r100 = this.left;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.top;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.right;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.bottom;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "Position(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }

    public final Float getBottom() {
        return this.bottom;
    }

    public final Float getLeft() {
        return this.left;
    }

    public final Float getRight() {
        return this.right;
    }

    public final Float getTop() {
        return this.top;
    }

    public final void setBottom(Float r100) {
        this.bottom = r100;
    }

    public final void setLeft(Float r100) {
        this.left = r100;
    }

    public final void setRight(Float r100) {
        this.right = r100;
    }

    public final void setTop(Float r100) {
        this.top = r100;
    }

    public Position(Float r100, Float r101, Float r102, Float r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }

    public /* synthetic */ Position(Float r100, Float r101, Float r102, Float r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
