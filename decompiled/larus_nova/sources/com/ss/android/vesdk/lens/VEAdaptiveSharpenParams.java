package com.ss.android.vesdk.lens;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEAdaptiveSharpenParams extends VEBaseRecorderLensParams {
    public float amount;
    public int diffImgSmoothEnable;
    public float edgeWeightGamma;
    public int initDelayFrameCnt;
    public float overRatio;
    public int powerLevelPara;
    public int processDelayFrameCnt;
    public int sceneMode;

    public VEAdaptiveSharpenParams() {
        this.sceneMode = 3;
        this.amount = -1.0f;
        this.overRatio = -1.0f;
        this.edgeWeightGamma = -1.0f;
        this.diffImgSmoothEnable = -1;
        this.powerLevelPara = 4;
        this.initDelayFrameCnt = 0;
        this.processDelayFrameCnt = 0;
        this.algorithmFlag = 24;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("SceneMode", this.sceneMode);
        r100.setFloat("Amount", this.amount);
        r100.setFloat("OverRatio", this.overRatio);
        r100.setFloat("EdgeWeightGamma", this.edgeWeightGamma);
        r100.setInt("DiffImgSmoothEnable", this.diffImgSmoothEnable);
        r100.setInt("PowerLevelPara", this.powerLevelPara);
        r100.setInt("InitDelayFrameCnt", this.initDelayFrameCnt);
        r100.setInt("ProcessDelayFrameCnt", this.processDelayFrameCnt);
        return r100;
    }
}
