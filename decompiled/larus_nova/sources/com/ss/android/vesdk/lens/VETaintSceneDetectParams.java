package com.ss.android.vesdk.lens;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VETaintSceneDetectParams extends VEBaseRecorderLensParams {
    public int backendType;
    public int detectFrequency;
    public int detectRepeatNum;
    public String kernelBinPath;
    public String modelPath;
    public int numThread;

    public VETaintSceneDetectParams() {
        this.detectFrequency = 3;
        this.backendType = 0;
        this.numThread = 2;
        this.detectRepeatNum = 1;
        this.algorithmFlag = 21;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("DetectFrequency", this.detectFrequency);
        r100.setString("ModelPath", this.modelPath);
        r100.setString("KernelBinPath", this.kernelBinPath);
        r100.setInt("BackendType", this.backendType);
        r100.setInt("NumThread", this.numThread);
        r100.setInt("DetectRepeatNum", this.detectRepeatNum);
        return r100;
    }
}
