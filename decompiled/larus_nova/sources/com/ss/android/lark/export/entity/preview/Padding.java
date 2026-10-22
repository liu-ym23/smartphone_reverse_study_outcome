package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Padding;", "Ljava/io/Serializable;", "top", "", "right", "bottom", "left", "<init>", "(FFFF)V", "getTop", "()F", "getRight", "getBottom", "getLeft", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Padding implements Serializable {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public static /* synthetic */ Padding copy$default(Padding r100, float r101, float r102, float r103, float r104, int r105, Object r106) {
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

    public final float component1() {
        return this.top;
    }

    public final float component2() {
        return this.right;
    }

    public final float component3() {
        return this.bottom;
    }

    public final float component4() {
        return this.left;
    }

    public final Padding copy(float r100, float r101, float r102, float r103) {
        return new Padding(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Padding) == true) goto L8;
        return false;
    L8:
        Padding r101 = (Padding) r100;
        if (Float.compare(this.top, r101.top) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.right, r101.right) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.bottom, r101.bottom) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.left, r101.left) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.top) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + Float.floatToIntBits(this.left);
    }

    public String toString() {
        return "Padding(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public Padding(float r100, float r101, float r102, float r103) {
        this.top = r100;
        this.right = r101;
        this.bottom = r102;
        this.left = r103;
    }
}
