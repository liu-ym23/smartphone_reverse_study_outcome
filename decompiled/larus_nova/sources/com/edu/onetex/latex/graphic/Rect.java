package com.edu.onetex.latex.graphic;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/edu/onetex/latex/graphic/Rect;", "", "x", "", "y", "w", "h", "(FFFF)V", "getH", "()F", "setH", "(F)V", "getW", "setW", "getX", "setX", "getY", "setY", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class Rect {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f273701h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f273702w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f273703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f273704y;

    public final float getH() {
        return this.f273701h;
    }

    public final float getW() {
        return this.f273702w;
    }

    public final float getX() {
        return this.f273703x;
    }

    public final float getY() {
        return this.f273704y;
    }

    public final void setH(float r100) {
        this.f273701h = r100;
    }

    public final void setW(float r100) {
        this.f273702w = r100;
    }

    public final void setX(float r100) {
        this.f273703x = r100;
    }

    public final void setY(float r100) {
        this.f273704y = r100;
    }

    public Rect(float r100, float r101, float r102, float r103) {
        this.f273703x = r100;
        this.f273704y = r101;
        this.f273702w = r102;
        this.f273701h = r103;
    }
}
