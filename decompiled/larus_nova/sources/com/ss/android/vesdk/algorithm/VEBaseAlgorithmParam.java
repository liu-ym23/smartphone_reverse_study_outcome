package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEBaseAlgorithmParam implements IVEAlgorithmParam {
    private String mAlgorithmName;
    private int mAlgorithmType;
    private boolean mForInit;

    public VEBaseAlgorithmParam() {
        this.mForInit = false;
    }

    public TEBundle getBundle() {
        TEBundle r100 = TEBundle.obtain();
        r100.setInt("AlgorithmType", this.mAlgorithmType);
        r100.setString("AlgorithmName", this.mAlgorithmName);
        r100.setBool("ForInit", this.mForInit);
        r100.setBool("for init", this.mForInit);
        return r100;
    }

    public String getAlgorithmName() {
        return this.mAlgorithmName;
    }

    public int getAlgorithmType() {
        return this.mAlgorithmType;
    }

    public boolean getForInit() {
        return this.mForInit;
    }

    @Override // com.ss.android.vesdk.algorithm.IVEAlgorithmParam
    public IVEAlgorithmParam.Usage getUsage() {
        return IVEAlgorithmParam.Usage.DEFAULT;
    }

    public void setAlgorithmName(String r100) {
        this.mAlgorithmName = r100;
    }

    public void setAlgorithmType(int r100) {
        this.mAlgorithmType = r100;
    }

    public void setForInit(boolean r100) {
        this.mForInit = r100;
    }

    public VEBaseAlgorithmParam(int r100, String r101, boolean r102) {
        this.mAlgorithmType = r100;
        this.mAlgorithmName = r101;
        this.mForInit = r102;
    }
}
