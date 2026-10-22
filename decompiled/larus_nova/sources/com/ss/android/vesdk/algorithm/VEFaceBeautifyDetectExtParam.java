package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceBeautifyDetectExtParam extends VEBaseAlgorithmParam {
    public static final int BEAUTIFY_IN_HP_SHOTSCRREN = 2;
    public static final int BEAUTIFY_IN_SHOTSCREEN = 0;
    public static final int BEAUTIFY_IN_TAKEPICTURE = 1;
    public boolean algoDebug;
    public boolean algoDespeckleReserve;
    public boolean alogDespeckle;
    public int position;

    public @interface BeautifyPlace {
    }

    public VEFaceBeautifyDetectExtParam() {
        super(17, "FaceBeautify", false);
        this.position = -1;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("BeautifyPlace", this.position);
        r100.setBool("AlgoDebug", this.algoDebug);
        r100.setBool("AlgoDespeckle", this.alogDespeckle);
        r100.setBool("AlgoDespeckleReserve", this.algoDespeckleReserve);
        return r100;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isAlgoDebug() {
        return this.algoDebug;
    }

    public boolean isAlgoDespeckleReserve() {
        return this.algoDespeckleReserve;
    }

    public boolean isAlogDespeckle() {
        return this.alogDespeckle;
    }

    public void setAlgoDebug(boolean r100) {
        this.algoDebug = r100;
    }

    public void setAlgoDespeckleReserve(boolean r100) {
        this.algoDespeckleReserve = r100;
    }

    public void setAlogDespeckle(boolean r100) {
        this.alogDespeckle = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }
}
