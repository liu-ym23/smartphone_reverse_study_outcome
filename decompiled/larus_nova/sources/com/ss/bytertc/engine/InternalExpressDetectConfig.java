package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.VideoEffectExpressionConfig;

/* JADX INFO: loaded from: classes40.dex */
public class InternalExpressDetectConfig {
    public boolean enableAgeDetect;
    public boolean enableAttractivenessDetect;
    public boolean enableEmotionDetect;
    public boolean enableGenderDetect;
    public boolean enableHappinessDetect;

    public boolean enableAgeDetect() {
        return this.enableAgeDetect;
    }

    public boolean enableAttractivenessDetect() {
        return this.enableAttractivenessDetect;
    }

    public boolean enableEmotionDetect() {
        return this.enableEmotionDetect;
    }

    public boolean enableGenderDetect() {
        return this.enableGenderDetect;
    }

    public boolean enableHappinessDetect() {
        return this.enableHappinessDetect;
    }

    public InternalExpressDetectConfig(VideoEffectExpressionConfig r100) {
        this.enableAgeDetect = false;
        this.enableGenderDetect = false;
        this.enableEmotionDetect = false;
        this.enableAttractivenessDetect = false;
        this.enableHappinessDetect = false;
        this.enableAgeDetect = r100.enableAgeDetect;
        this.enableGenderDetect = r100.enableGenderDetect;
        this.enableEmotionDetect = r100.enableEmotionDetect;
        this.enableAttractivenessDetect = r100.enableAttractivenessDetect;
        this.enableHappinessDetect = r100.enableHappinessDetect;
    }
}
