package com.bytedance.ee.bear.scaleimageview;

import android.graphics.PointF;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class ImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }

    public ImageViewState(float r100, PointF r101, int r102) {
        this.scale = r100;
        this.centerX = r101.x;
        this.centerY = r101.y;
        this.orientation = r102;
    }
}
