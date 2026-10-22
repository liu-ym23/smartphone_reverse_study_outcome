package com.dtf.toyger.base.algorithm;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerLivenessConfig {
    public float batLivenessThreshold;
    public boolean checkFaceBeforeNanocut;
    public String collection;
    public String detectCombinations;
    public float dragonflyMax;
    public float dragonflyMin;
    public int dragonflyRetryLimit;
    public boolean enableSonar;
    public float eye_blink_threshold;
    public float eye_occlusion_threshold;
    public boolean fppPreProcess;
    public float geminiMax;
    public float geminiMin;
    public float lipMotion;
    public String livenessCombinations;
    public String photinus_colours;
    public String retryLivenessCombinations;

    public ToygerLivenessConfig() {
        this.batLivenessThreshold = 0.5f;
        this.dragonflyMin = 0.0f;
        this.dragonflyMax = 0.5f;
        this.geminiMin = 0.0f;
        this.geminiMax = 0.0f;
        this.eye_occlusion_threshold = 0.8f;
        this.eye_blink_threshold = 0.2f;
        this.fppPreProcess = false;
        this.checkFaceBeforeNanocut = false;
        this.enableSonar = false;
        this.dragonflyRetryLimit = 0;
        this.lipMotion = 0.15f;
        this.photinus_colours = "";
    }

    public ToygerLivenessConfig(String r100, float r101, float r102, float r103, float r104, float r105, boolean r106, boolean r107, float r110) {
        this.eye_occlusion_threshold = 0.8f;
        this.eye_blink_threshold = 0.2f;
        this.enableSonar = false;
        this.dragonflyRetryLimit = 0;
        this.photinus_colours = "";
        this.livenessCombinations = r100;
        this.batLivenessThreshold = r101;
        this.dragonflyMin = r102;
        this.dragonflyMax = r103;
        this.geminiMin = r104;
        this.geminiMax = r105;
        this.fppPreProcess = r106;
        this.checkFaceBeforeNanocut = r107;
        this.lipMotion = r110;
    }
}
