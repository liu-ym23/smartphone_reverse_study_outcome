package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/relax/relaxframework/LayoutEventDetail;", "", "top", "", "bottom", "left", "right", "width", "height", "(DDDDDD)V", "getBottom", "()D", "setBottom", "(D)V", "getHeight", "setHeight", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "getWidth", "setWidth", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutEventDetail {
    private double bottom;
    private double height;
    private double left;
    private double right;
    private double top;
    private double width;

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

    public LayoutEventDetail(double r100, double r101, double r102, double r103, double r104, double r110) {
        this.top = r100;
        this.bottom = r101;
        this.left = r102;
        this.right = r103;
        this.width = r104;
        this.height = r110;
    }
}
