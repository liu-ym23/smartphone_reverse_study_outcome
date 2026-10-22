package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/relax/relaxframework/ScrollViewEventScrollDetail;", "", "deltaX", "", "deltaY", "scrollLeft", "scrollTop", "scrollHeight", "scrollWidth", "(DDDDDD)V", "getDeltaX", "()D", "setDeltaX", "(D)V", "getDeltaY", "setDeltaY", "getScrollHeight", "setScrollHeight", "getScrollLeft", "setScrollLeft", "getScrollTop", "setScrollTop", "getScrollWidth", "setScrollWidth", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScrollViewEventScrollDetail {
    private double deltaX;
    private double deltaY;
    private double scrollHeight;
    private double scrollLeft;
    private double scrollTop;
    private double scrollWidth;

    public final double getDeltaX() {
        return this.deltaX;
    }

    public final double getDeltaY() {
        return this.deltaY;
    }

    public final double getScrollHeight() {
        return this.scrollHeight;
    }

    public final double getScrollLeft() {
        return this.scrollLeft;
    }

    public final double getScrollTop() {
        return this.scrollTop;
    }

    public final double getScrollWidth() {
        return this.scrollWidth;
    }

    public final void setDeltaX(double r100) {
        this.deltaX = r100;
    }

    public final void setDeltaY(double r100) {
        this.deltaY = r100;
    }

    public final void setScrollHeight(double r100) {
        this.scrollHeight = r100;
    }

    public final void setScrollLeft(double r100) {
        this.scrollLeft = r100;
    }

    public final void setScrollTop(double r100) {
        this.scrollTop = r100;
    }

    public final void setScrollWidth(double r100) {
        this.scrollWidth = r100;
    }

    public ScrollViewEventScrollDetail(double r100, double r101, double r102, double r103, double r104, double r110) {
        this.deltaX = r100;
        this.deltaY = r101;
        this.scrollLeft = r102;
        this.scrollTop = r103;
        this.scrollHeight = r104;
        this.scrollWidth = r110;
    }
}
