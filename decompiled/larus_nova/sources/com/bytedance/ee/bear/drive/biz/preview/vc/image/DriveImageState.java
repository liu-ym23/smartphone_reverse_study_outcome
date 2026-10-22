package com.bytedance.ee.bear.drive.biz.preview.vc.image;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setOffsetX(float r100) {
        this.offsetX = r100;
    }

    public void setOffsetY(float r100) {
        this.offsetY = r100;
    }

    public void setRotate(float r100) {
        this.rotate = r100;
    }

    public void setScale(float r100) {
        this.scale = r100;
    }
}
