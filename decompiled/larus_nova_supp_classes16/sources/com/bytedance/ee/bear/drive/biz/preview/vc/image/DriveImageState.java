package com.bytedance.ee.bear.drive.biz.preview.vc.image;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveImageState implements NonProguard {
    private float offsetX;
    private float offsetY;
    private float rotate;
    private float scale;

    public DriveImageState() {
    }

    public String toString() {
        return "DriveImageState{offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", rotate=" + this.rotate + ", scale=" + this.scale + '}';
    }

    public float getOffsetX() {
        return this.offsetX;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public float getRotate() {
        return this.rotate;
    }

    public float getScale() {
        return this.scale;
    }

    public void setOffsetX(float r1) {
        this.offsetX = r1;
    }

    public void setOffsetY(float r1) {
        this.offsetY = r1;
    }

    public void setRotate(float r1) {
        this.rotate = r1;
    }

    public void setScale(float r1) {
        this.scale = r1;
    }
}
