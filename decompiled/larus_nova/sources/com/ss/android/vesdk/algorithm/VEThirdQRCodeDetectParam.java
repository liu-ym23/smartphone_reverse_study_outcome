package com.ss.android.vesdk.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VEThirdQRCodeDetectParam extends VEBachAlgorithmParam {
    public long codeType;
    public int detectFrameRate;
    public boolean isMultiCode;

    public VEThirdQRCodeDetectParam() {
        super(16, "ThirdQRDetect", false);
        this.detectFrameRate = 10;
        this.codeType = 1;
        this.isMultiCode = false;
    }
}
