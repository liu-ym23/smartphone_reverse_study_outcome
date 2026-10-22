package com.relax.runtime.gen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006&"}, d2 = {"Lcom/relax/runtime/gen/BoundingClientRect;", "", "width", "", "height", "left", "top", "right", "bottom", "(DDDDDD)V", "getBottom", "()D", "setBottom", "(D)V", "getHeight", "setHeight", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BoundingClientRect {
    private double bottom;
    private double height;
    private double left;
    private double right;
    private double top;
    private double width;

    public static /* synthetic */ BoundingClientRect copy$default(BoundingClientRect r110, double r111, double r112, double r113, double r210, double r211, double r212, int r213, Object r214) {
        if ((r213 & 1) == 0) goto L5;
        double r100 = r110.width;
    L7:
        if ((r213 & 2) == 0) goto L9;
        double r101 = r110.height;
    L11:
        if ((r213 & 4) == 0) goto L13;
        double r102 = r110.left;
    L15:
        if ((r213 & 8) == 0) goto L17;
        double r103 = r110.top;
    L19:
        if ((r213 & 16) == 0) goto L21;
        double r104 = r110.right;
    L23:
        if ((r213 & 32) == 0) goto L25;
        double r114 = r110.bottom;
    L27:
        return r110.copy(r100, r101, r102, r103, r104, r114);
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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

    public final double component1() {
        return this.width;
    }

    public final double component2() {
        return this.height;
    }

    public final double component3() {
        return this.left;
    }

    public final double component4() {
        return this.top;
    }

    public final double component5() {
        return this.right;
    }

    public final double component6() {
        return this.bottom;
    }

    public final BoundingClientRect copy(double r110, double r111, double r112, double r210, double r211, double r212) {
        return new BoundingClientRect(r110, r111, r112, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BoundingClientRect) == true) goto L8;
        return false;
    L8:
        BoundingClientRect r101 = (BoundingClientRect) r100;
        if (Intrinsics.areEqual(Double.valueOf(this.width), Double.valueOf(r101.width)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Double.valueOf(this.height), Double.valueOf(r101.height)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Double.valueOf(this.left), Double.valueOf(r101.left)) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Double.valueOf(this.top), Double.valueOf(r101.top)) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Double.valueOf(this.right), Double.valueOf(r101.right)) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(Double.valueOf(this.bottom), Double.valueOf(r101.bottom)) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.width);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.height);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.left);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.top);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.right);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.bottom);
        return r109 + ((int) (r110 ^ (r110 >>> 32)));
    }

    public String toString() {
        return "BoundingClientRect(width=" + this.width + ", height=" + this.height + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }

    public final double getBottom() {
        return this.bottom;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getLeft() {
        return this.left;
    }

    public final double getRight() {
        return this.right;
    }

    public final double getTop() {
        return this.top;
    }

    public final double getWidth() {
        return this.width;
    }

    public final void setBottom(double r100) {
        this.bottom = r100;
    }

    public final void setHeight(double r100) {
        this.height = r100;
    }

    public final void setLeft(double r100) {
        this.left = r100;
    }

    public final void setRight(double r100) {
        this.right = r100;
    }

    public final void setTop(double r100) {
        this.top = r100;
    }

    public final void setWidth(double r100) {
        this.width = r100;
    }

    public BoundingClientRect(double r100, double r101, double r102, double r103, double r104, double r110) {
        this.width = r100;
        this.height = r101;
        this.left = r102;
        this.top = r103;
        this.right = r104;
        this.bottom = r110;
    }
}
