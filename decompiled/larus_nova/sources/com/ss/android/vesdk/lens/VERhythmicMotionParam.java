package com.ss.android.vesdk.lens;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VERhythmicMotionParam extends VEBaseRecorderLensParams {
    public float[] cropList;
    public float maxAlpha;
    public float maxVelocity;

    public VERhythmicMotionParam() {
        this.cropList = new float[3];
        this.algorithmFlag = 29;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setFloatArray("CropList", this.cropList);
        r100.setFloat("MaxAlpha", this.maxAlpha);
        r100.setFloat("MaxVelocity", this.maxVelocity);
        return r100;
    }
}
