package com.ss.android.vesdk.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachSceneRecognitionResult extends VEScanResult {
    private int mErrCode;
    private float mProb;
    private VEBachSceneRecognitionParam.RECONGNITION_TYPE mType;

    public VEBachSceneRecognitionResult() {
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public float getProb() {
        return this.mProb;
    }

    public VEBachSceneRecognitionParam.RECONGNITION_TYPE getSceneType() {
        return this.mType;
    }

    public void setErrCode(int r100) {
        this.mErrCode = r100;
    }

    public void setProb(float r100) {
        this.mProb = r100;
    }

    public void setSceneType(int r100) {
        this.mType = VEBachSceneRecognitionParam.RECONGNITION_TYPE.values()[r100];
    }

    public void setSceneType(VEBachSceneRecognitionParam.RECONGNITION_TYPE r100) {
        this.mType = r100;
    }
}
