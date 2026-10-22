package com.ss.android.vesdk.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VEHandDetectExtParam {
    private int handDetectMaxNum;
    private int handLowPowerMode;
    private VEHandModelType mode;

    public VEHandDetectExtParam() {
    }

    public int getHandDetectMaxNum() {
        return this.handDetectMaxNum;
    }

    public int getHandLowPowerMode() {
        return this.handLowPowerMode;
    }

    public VEHandModelType getMode() {
        return this.mode;
    }

    public void setHandDetectMaxNum(int r100) {
        this.handDetectMaxNum = r100;
    }

    public void setHandLowPowerMode(int r100) {
        this.handLowPowerMode = r100;
    }

    public void setMode(VEHandModelType r100) {
        this.mode = r100;
    }
}
