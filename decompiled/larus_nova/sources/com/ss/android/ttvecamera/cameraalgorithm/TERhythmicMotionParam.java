package com.ss.android.ttvecamera.cameraalgorithm;

/* JADX INFO: loaded from: classes38.dex */
public class TERhythmicMotionParam extends TECameraAlgorithmParam {
    public float[] cropList;
    public float maxAlpha;
    public float maxVelocity;

    public TERhythmicMotionParam() {
        this.cropList = new float[3];
        this.type = TECameraAlgorithmParam.TECameraAlgorithmType.TE_CAMERA_ALGORITHM_TYPE_RHYTHMIC_MOTION;
    }
}
