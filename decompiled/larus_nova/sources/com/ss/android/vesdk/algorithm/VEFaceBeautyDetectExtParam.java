package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceBeautyDetectExtParam extends VEBaseAlgorithmParam {
    private boolean useV3Model;

    public VEFaceBeautyDetectExtParam() {
        super(18, "FaceBeauty", false);
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setBool("UseV3Model", this.useV3Model);
        return r100;
    }

    public boolean isUseV3Model() {
        return this.useV3Model;
    }

    public void setUseV3Model(boolean r100) {
        this.useV3Model = r100;
    }
}
