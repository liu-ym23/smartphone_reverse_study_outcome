package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final class VEReactSettings {
    private String mReactAudioPath;
    private float[] mReactInitalReagion;
    private float[] mReactPosMarginPercent;
    private String mReactVideoPath;

    public String getReactAudioPath() {
        return this.mReactAudioPath;
    }

    public String getReactVideoPath() {
        return this.mReactVideoPath;
    }

    public float[] getReactionInitalRegion() {
        return this.mReactInitalReagion;
    }

    public float[] getReactionPosMargin() {
        return this.mReactPosMarginPercent;
    }

    public VEReactSettings(String r100, String r101, float[] r102) {
        this(r100, r101, r102, new float[]{0.0f, 0.0f, 0.5f, 0.5f});
    }

    public VEReactSettings(String r100, String r101, float[] r102, float[] r103) {
        this.mReactVideoPath = r100;
        this.mReactAudioPath = r101;
        this.mReactPosMarginPercent = r102;
        this.mReactInitalReagion = r103;
    }
}
