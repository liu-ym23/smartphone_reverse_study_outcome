package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEMakeupOpacityAlgoParams extends VEBaseAlgorithmParam {
    private float femaleOpacity;
    private float maleOpacity;
    private String path;

    public VEMakeupOpacityAlgoParams() {
        super(21, "MakeupOpacity", false);
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString("Path", this.path);
        r100.setFloat("MaleOpacity", this.maleOpacity);
        r100.setFloat("FemaleOpacity", this.femaleOpacity);
        return r100;
    }

    public float getFemaleOpacity() {
        return this.femaleOpacity;
    }

    public float getMaleOpacity() {
        return this.maleOpacity;
    }

    public String getPath() {
        return this.path;
    }

    public void setFemaleOpacity(float r100) {
        this.femaleOpacity = r100;
    }

    public void setMaleOpacity(float r100) {
        this.maleOpacity = r100;
    }

    public void setPath(String r100) {
        this.path = r100;
    }
}
