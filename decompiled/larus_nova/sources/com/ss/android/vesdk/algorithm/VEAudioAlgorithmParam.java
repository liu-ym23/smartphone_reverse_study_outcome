package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioAlgorithmParam extends VEBaseAlgorithmParam {
    public static final String AUDIO_MIC_DETECT_DELAY_NAME = "audio mic detect delay";
    public static final String AUDIO_MIC_LOUDNESS_DETECT_ALGORITHM = "audio mic loudness detect";
    private String modelPath;

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString("modelPath", this.modelPath);
        return r100;
    }

    public VEAudioAlgorithmParam() {
    }

    public String getModelPath() {
        return this.modelPath;
    }

    public VEAudioAlgorithmParam(String r100, String r101) {
        super(100, r100, false);
        this.modelPath = r101;
    }
}
