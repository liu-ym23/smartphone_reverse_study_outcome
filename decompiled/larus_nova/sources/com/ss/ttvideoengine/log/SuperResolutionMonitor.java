package com.ss.ttvideoengine.log;

/* JADX INFO: loaded from: classes34.dex */
public class SuperResolutionMonitor {
    private static final String TAG = "SuperResolutionMonitor";
    private int mEnableBmf;
    private float mProccessSuccessRate;
    private float mProcessorAverageCostTime;
    private int mSrAlgorithm;
    private int mSrScaleType;

    public float getHeightFactor() {
        int r100 = this.mSrAlgorithm;
        if (r100 != 0) goto L5;
        return 2.0f;
    L5:
        switch(r100) {
            case 4: goto L35;
            case 5: goto L29;
            case 6: goto L38;
            case 7: goto L29;
            case 8: goto L24;
            case 9: goto L24;
            case 10: goto L24;
            case 11: goto L24;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L34;
        };
    L7:
        int r101 = this.mSrScaleType;
        if (r101 != 4) goto L11;
        return 1.1f;
    L11:
        if (r101 != 8) goto L14;
        return 1.2f;
    L14:
        if (r101 != 16) goto L17;
        return 1.3f;
    L17:
        if (r101 != 32) goto L19;
        return 1.4f;
    L19:
        if (r101 == 1) goto L35;
        if (r101 != 2) goto L34;
        return 2.0f;
    L24:
        int r102 = this.mSrScaleType;
        if (r102 == 0) goto L45;
        if (r102 != 1) goto L34;
    L45:
        return 2.0f;
    L29:
        int r103 = this.mSrScaleType;
        if (r103 == 0) goto L46;
        if (r103 != 1) goto L34;
    L46:
        return 2.0f;
    L35:
        return 1.5f;
    L34:
        return 0.0f;
    L38:
        return 2.0f;
    }

    public float getWidthFactor() {
        int r100 = this.mSrAlgorithm;
        if (r100 != 0) goto L5;
        return 2.0f;
    L5:
        switch(r100) {
            case 4: goto L35;
            case 5: goto L29;
            case 6: goto L38;
            case 7: goto L29;
            case 8: goto L24;
            case 9: goto L24;
            case 10: goto L24;
            case 11: goto L24;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L34;
        };
    L7:
        int r101 = this.mSrScaleType;
        if (r101 != 4) goto L11;
        return 1.1f;
    L11:
        if (r101 != 8) goto L14;
        return 1.2f;
    L14:
        if (r101 != 16) goto L17;
        return 1.3f;
    L17:
        if (r101 != 32) goto L19;
        return 1.4f;
    L19:
        if (r101 == 1) goto L35;
        if (r101 != 2) goto L34;
        return 2.0f;
    L24:
        int r102 = this.mSrScaleType;
        if (r102 == 0) goto L45;
        if (r102 != 1) goto L34;
    L45:
        return 2.0f;
    L29:
        int r103 = this.mSrScaleType;
        if (r103 == 0) goto L46;
        if (r103 != 1) goto L34;
    L46:
        return 2.0f;
    L35:
        return 1.5f;
    L34:
        return 0.0f;
    L38:
        return 2.0f;
    }

    public SuperResolutionMonitor() {
        this.mSrAlgorithm = Integer.MIN_VALUE;
        this.mEnableBmf = 0;
        this.mProccessSuccessRate = Float.MIN_VALUE;
        this.mProcessorAverageCostTime = Float.MIN_VALUE;
        this.mSrScaleType = Integer.MIN_VALUE;
    }

    public int getEnableBmf() {
        return this.mEnableBmf;
    }

    public float getProccessSuccessRate() {
        return this.mProccessSuccessRate;
    }

    public float getProcessorAverageCostTime() {
        return this.mProcessorAverageCostTime;
    }

    public int getSrAlgorithm() {
        return this.mSrAlgorithm;
    }

    public void setAlgorithm(int r100) {
        this.mSrAlgorithm = r100;
    }

    public void setEnableBmf(int r100) {
        this.mEnableBmf = r100;
    }

    public void setProccessSuccessRate(float r100) {
        this.mProccessSuccessRate = r100;
    }

    public void setProcessorAverageCostTime(float r100) {
        this.mProcessorAverageCostTime = r100;
    }

    public void setSrScaleType(int r100) {
        this.mSrScaleType = r100;
    }
}
