package com.bytedance.map.api.collision;

import android.graphics.Point;
import android.graphics.Rect;
import tb2.c;

/* JADX INFO: loaded from: classes21.dex */
public class Boundary {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f265482id;
    private int mBottom;
    private int mLeft;
    private int mRight;
    private int mTop;

    public Boundary() {
    }

    public Boundary copy() {
        Boundary r100 = new Boundary();
        r100.mBottom = this.mBottom;
        r100.mRight = this.mRight;
        r100.mTop = this.mTop;
        r100.mLeft = this.mLeft;
        r100.f265482id = this.f265482id;
        return r100;
    }

    public String toString() {
        return this.mLeft + c.DEFAULT_TEXT + this.mRight + c.DEFAULT_TEXT + this.mBottom + c.DEFAULT_TEXT + this.mTop + " " + this.f265482id;
    }

    private int calculateOverlapArea(Boundary r100) {
        Rect r101 = new Rect(this.mLeft, this.mTop, this.mRight, this.mBottom);
        r101.intersect(new Rect(r100.mLeft, r100.mTop, r100.mRight, r100.mBottom));
        return r101.height() * r101.width();
    }

    public boolean isIntersect(Boundary r100, float r101) {
        int r102 = this.mRight;
        int r103 = r100.mLeft;
        if (r102 < r103) goto L16;
        int r104 = this.mLeft;
        int r105 = r100.mRight;
        if (r104 > r105) goto L16;
        int r106 = this.mTop;
        int r107 = r100.mBottom;
        if (r106 > r107) goto L16;
        int r108 = this.mBottom;
        int r109 = r100.mTop;
        if (r108 < r109) goto L16;
        if (calculateOverlapArea(r100) >= (((r107 - r109) * (r105 - r103)) * r101)) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    public void initWithCenterAndSize(Point r100, int r101, int r102, String r103) {
        int r104 = r100.x;
        int r105 = r101 / 2;
        this.mLeft = r104 - r105;
        int r106 = r100.y;
        int r107 = r102 / 2;
        this.mTop = r106 - r107;
        this.mRight = r104 + r105;
        this.mBottom = r106 + r107;
        this.f265482id = r103;
    }
}
