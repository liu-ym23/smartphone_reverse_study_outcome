package com.ss.android.vesdk.faceinfo;

import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes40.dex */
public class Skeleton {
    private int ID;
    private PointF[] points;
    private RectF rect;

    public Skeleton() {
    }

    public int getID() {
        return this.ID;
    }

    public PointF[] getPoints() {
        return this.points;
    }

    public RectF getRect() {
        return this.rect;
    }

    public void setID(int r100) {
        this.ID = r100;
    }

    public void setPoints(PointF[] r100) {
        this.points = r100;
    }

    public void setRect(RectF r100) {
        this.rect = r100;
    }
}
