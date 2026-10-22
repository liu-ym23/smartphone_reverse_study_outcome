package com.dtf.toyger.base.algorithm;

import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerConfig {
    public ToygerCameraConfig cameraConfig;
    public ToygerCommonConfig commonConfig;
    public ToygerLivenessConfig livenessConfig;
    public ToygerQualityConfig qualityConfig;

    public boolean enableMouthLiveness() {
        ToygerLivenessConfig r100 = this.livenessConfig;
        if (r100 == null) goto L13;
        String r101 = r100.livenessCombinations;
        if (r101 != null) goto L7;
    L8:
        String r102 = this.livenessConfig.retryLivenessCombinations;
        if (r102 == null) goto L13;
        if (r102.contains(ToygerFaceAlgorithmConfig.ZFACE_LIPMOVEMENT_LIVENESS) == false) goto L13;
    L12:
        return true;
    L7:
        if (r101.contains(ToygerFaceAlgorithmConfig.ZFACE_LIPMOVEMENT_LIVENESS) == true) goto L12;
    L13:
        return false;
    }

    public boolean enableQualityConfig() {
        ToygerLivenessConfig r100 = this.livenessConfig;
        if (r100 == null) goto L9;
        String r101 = r100.detectCombinations;
        if (r101 == null) goto L9;
        if (r101.contains(ToygerFaceAlgorithmConfig.ZFACE_QUALITY_DETECT) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public ToygerConfig() {
        this.qualityConfig = new ToygerQualityConfig();
        this.livenessConfig = new ToygerLivenessConfig();
        this.cameraConfig = new ToygerCameraConfig();
        this.commonConfig = new ToygerCommonConfig();
    }

    public ToygerConfig(ToygerQualityConfig r100, ToygerLivenessConfig r101, ToygerCameraConfig r102) {
        this.qualityConfig = r100;
        this.livenessConfig = r101;
        this.cameraConfig = r102;
    }
}
