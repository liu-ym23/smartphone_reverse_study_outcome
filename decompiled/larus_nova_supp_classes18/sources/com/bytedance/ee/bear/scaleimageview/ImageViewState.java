package com.bytedance.ee.bear.scaleimageview;

import android.graphics.PointF;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public ImageViewState(float r1, PointF r2, int r3) {
        this.scale = r1;
        this.centerX = r2.x;
        this.centerY = r2.y;
        this.orientation = r3;
    }
}
