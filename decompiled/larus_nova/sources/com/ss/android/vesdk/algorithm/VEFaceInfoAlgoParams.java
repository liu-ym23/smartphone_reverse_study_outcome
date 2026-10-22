package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceInfoAlgoParams extends VEFaceDetectExtParam {
    public static final int EYEBROW = 2;
    public static final int EYEINFO = 1;
    public static final int IRIS = 8;
    public static final int LIP = 4;
    public static final int NONE = 0;
    private int faceExtInfoFlag;

    public VEFaceInfoAlgoParams() {
        super(19, "FaceInfo", false);
        this.faceExtInfoFlag = 0;
    }

    @Override // com.ss.android.vesdk.algorithm.VEFaceDetectExtParam, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("FaceExtInfoFlag", this.faceExtInfoFlag);
        return r100;
    }

    public int getFaceExtInfoFlag() {
        return this.faceExtInfoFlag;
    }

    public void setFaceExtInfoFlag(int r100) {
        this.faceExtInfoFlag = r100;
    }
}
