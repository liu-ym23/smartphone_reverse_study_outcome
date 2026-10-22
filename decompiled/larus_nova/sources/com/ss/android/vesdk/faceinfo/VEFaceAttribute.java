package com.ss.android.vesdk.faceinfo;

import com.ss.android.ttve.nativePort.e;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceAttribute {
    public static final int EXPRESSION_NUM = 7;
    float age;
    float angryScore;
    float arousal;
    float attractive;
    float blurScore;
    float boyProb;
    float[] expProbs;
    int expType;
    float happyScore;
    float illumination;
    float lipstickProb;
    float maskProb;
    float mustacheProb;
    private e parcelWrapper;
    float quality;
    float realFaceProb;
    float sadScore;
    float surpriseScore;
    float valence;
    float wearGlassProb;
    float wearHatProb;
    float wearSunglassProb;

    public VEFaceAttribute() {
    }

    public static int getExpressionNum() {
        return 7;
    }

    public void readFromParcel() {
        e r100 = this.parcelWrapper;
        if (r100 != null) goto L5;
        return;
    L5:
        this.age = r100.b();
        this.boyProb = this.parcelWrapper.b();
        this.attractive = this.parcelWrapper.b();
        this.happyScore = this.parcelWrapper.b();
        this.expType = this.parcelWrapper.c();
        e r101 = this.parcelWrapper;
        r101.getClass();
        float[] r102 = new float[7];
        int r103 = 0;
    L6:
        if (r103 >= 7) goto L8;
        r102[r103] = r101.b();
        r103 = r103 + 1;
        goto L6
    L8:
        this.expProbs = r102;
        this.realFaceProb = this.parcelWrapper.b();
        this.quality = this.parcelWrapper.b();
        this.arousal = this.parcelWrapper.b();
        this.valence = this.parcelWrapper.b();
        this.sadScore = this.parcelWrapper.b();
        this.angryScore = this.parcelWrapper.b();
        this.surpriseScore = this.parcelWrapper.b();
        this.maskProb = this.parcelWrapper.b();
        this.wearHatProb = this.parcelWrapper.b();
        this.mustacheProb = this.parcelWrapper.b();
        this.lipstickProb = this.parcelWrapper.b();
        this.wearGlassProb = this.parcelWrapper.b();
        this.wearSunglassProb = this.parcelWrapper.b();
        this.blurScore = this.parcelWrapper.b();
        this.illumination = this.parcelWrapper.b();
    }

    public float getAge() {
        return this.age;
    }

    public float getAngryScore() {
        return this.angryScore;
    }

    public float getArousal() {
        return this.arousal;
    }

    public float getAttractive() {
        return this.attractive;
    }

    public float getBlurScore() {
        return this.blurScore;
    }

    public float getBoyProb() {
        return this.boyProb;
    }

    public float[] getExpProbs() {
        return this.expProbs;
    }

    public int getExpType() {
        return this.expType;
    }

    public float getHappyScore() {
        return this.happyScore;
    }

    public float getIllumination() {
        return this.illumination;
    }

    public float getLipstickProb() {
        return this.lipstickProb;
    }

    public float getMaskProb() {
        return this.maskProb;
    }

    public float getMustacheProb() {
        return this.mustacheProb;
    }

    public float getQuality() {
        return this.quality;
    }

    public float getRealFaceProb() {
        return this.realFaceProb;
    }

    public float getSadScore() {
        return this.sadScore;
    }

    public float getSurpriseScore() {
        return this.surpriseScore;
    }

    public float getValence() {
        return this.valence;
    }

    public float getWearGlassProb() {
        return this.wearGlassProb;
    }

    public float getWearHatProb() {
        return this.wearHatProb;
    }

    public float getWearSunglassProb() {
        return this.wearSunglassProb;
    }

    public void setAge(float r100) {
        this.age = r100;
    }

    public void setAngryScore(float r100) {
        this.angryScore = r100;
    }

    public void setArousal(float r100) {
        this.arousal = r100;
    }

    public void setAttractive(float r100) {
        this.attractive = r100;
    }

    public void setBlurScore(float r100) {
        this.blurScore = r100;
    }

    public void setBoyProb(float r100) {
        this.boyProb = r100;
    }

    public void setExpProbs(float[] r100) {
        this.expProbs = r100;
    }

    public void setExpType(int r100) {
        this.expType = r100;
    }

    public void setHappyScore(float r100) {
        this.happyScore = r100;
    }

    public void setIllumination(float r100) {
        this.illumination = r100;
    }

    public void setLipstickProb(float r100) {
        this.lipstickProb = r100;
    }

    public void setMaskProb(float r100) {
        this.maskProb = r100;
    }

    public void setMustacheProb(float r100) {
        this.mustacheProb = r100;
    }

    public void setParcelWrapper(e r100) {
        this.parcelWrapper = r100;
    }

    public void setQuality(float r100) {
        this.quality = r100;
    }

    public void setRealFaceProb(float r100) {
        this.realFaceProb = r100;
    }

    public void setSadScore(float r100) {
        this.sadScore = r100;
    }

    public void setSurpriseScore(float r100) {
        this.surpriseScore = r100;
    }

    public void setValence(float r100) {
        this.valence = r100;
    }

    public void setWearGlassProb(float r100) {
        this.wearGlassProb = r100;
    }

    public void setWearHatProb(float r100) {
        this.wearHatProb = r100;
    }

    public void setWearSunglassProb(float r100) {
        this.wearSunglassProb = r100;
    }
}
