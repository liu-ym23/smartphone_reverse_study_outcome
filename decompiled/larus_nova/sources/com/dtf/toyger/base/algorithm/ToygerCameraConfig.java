package com.dtf.toyger.base.algorithm;

import android.graphics.Rect;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerCameraConfig {
    public float[] color2depthExtrin;
    public float[] colorIntrin;
    public float[] depthIntrin;
    public boolean isAligned;
    public boolean isMirror;
    public Rect roiRect;

    public String toString() {
        return "ToygerCameraConfig{colorIntrin=" + Arrays.toString(this.colorIntrin) + ", depthIntrin=" + Arrays.toString(this.depthIntrin) + ", color2depthExtrin=" + Arrays.toString(this.color2depthExtrin) + ", roiRect=" + this.roiRect + ", isAligned=" + this.isAligned + '}';
    }

    public ToygerCameraConfig() {
        this.colorIntrin = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.depthIntrin = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.color2depthExtrin = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.roiRect = new Rect(0, 0, 0, 0);
        this.isAligned = true;
        this.isMirror = false;
    }

    public ToygerCameraConfig(float[] r100, float[] r101, float[] r102, Rect r103, boolean r104, boolean r105) {
        this.colorIntrin = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.depthIntrin = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        this.color2depthExtrin = new float[]{-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f, -1.0f};
        new Rect(0, 0, 0, 0);
        this.colorIntrin = r100;
        this.depthIntrin = r101;
        this.color2depthExtrin = r102;
        this.roiRect = r103;
        this.isAligned = r104;
        this.isMirror = r105;
    }
}
