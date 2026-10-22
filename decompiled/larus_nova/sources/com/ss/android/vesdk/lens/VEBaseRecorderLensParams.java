package com.ss.android.vesdk.lens;

import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.algorithm.IVEAlgorithmParam;
import com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam;

/* JADX INFO: loaded from: classes40.dex */
public class VEBaseRecorderLensParams extends VEBaseAlgorithmParam {
    public int algorithmFlag;
    public boolean enable;
    public Object resultCallback;

    public VEBaseRecorderLensParams() {
        super(24, "LensAlgorithm", false);
        this.enable = true;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("Usage", getUsage().ordinal());
        r100.setInt("Flag", this.algorithmFlag);
        r100.setBool("Enable", this.enable);
        r100.setBool("EnableResult", true);
        return r100;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam, com.ss.android.vesdk.algorithm.IVEAlgorithmParam
    public IVEAlgorithmParam.Usage getUsage() {
        return IVEAlgorithmParam.Usage.LENS;
    }
}
