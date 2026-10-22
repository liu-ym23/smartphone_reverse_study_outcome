package com.ss.android.vesdk.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceDetectCropResult extends VEScanResult {
    private float mBoyProb;
    private int mSkinTone;

    public VEFaceDetectCropResult() {
    }

    public float getBoyProb() {
        return this.mBoyProb;
    }

    public int getSkinTone() {
        return this.mSkinTone;
    }

    public void setBoyProb(float r100) {
        this.mBoyProb = r100;
    }

    public void setSkinTone(int r100) {
        this.mSkinTone = r100;
    }
}
