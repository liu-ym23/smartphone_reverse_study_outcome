package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceDetectExtParam extends VEBaseAlgorithmParam {
    private int dectectIntervalTime;
    private boolean imageMode;
    private boolean useFastModel;

    public VEFaceDetectExtParam() {
        super(0, "FaceDetect", false);
        this.dectectIntervalTime = 30;
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt(VideoThumbInfo.KEY_INTERVAL, getDectectIntervalTime());
        r100.setBool("is image mode", isImageMode());
        r100.setBool("is fast mode", isUseFastModel());
        return r100;
    }

    public int getDectectIntervalTime() {
        return this.dectectIntervalTime;
    }

    public boolean isImageMode() {
        return this.imageMode;
    }

    public boolean isUseFastModel() {
        return this.useFastModel;
    }

    public void setDectectIntervalTime(int r100) {
        this.dectectIntervalTime = r100;
    }

    public void setImageMode(boolean r100) {
        this.imageMode = r100;
    }

    public void setUseFastModel(boolean r100) {
        this.useFastModel = r100;
    }

    public VEFaceDetectExtParam(int r100, String r101, boolean r102) {
        super(r100, r101, r102);
        this.dectectIntervalTime = 30;
    }
}
