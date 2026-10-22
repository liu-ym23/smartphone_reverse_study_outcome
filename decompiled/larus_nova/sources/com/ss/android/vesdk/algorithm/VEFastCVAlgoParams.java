package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEFastCVAlgoParams extends VEBaseAlgorithmParam {
    public static final int FLAG_ALG_LANCZOS = 0;
    public static final int FLAG_NONE = -1;
    private int flag;

    public @interface VEFastCVFlag {
    }

    public VEFastCVAlgoParams() {
        super(20, "FastCV", false);
        this.flag = -1;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("FastCVFlag", this.flag);
        return r100;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int r100) {
        this.flag = r100;
    }
}
