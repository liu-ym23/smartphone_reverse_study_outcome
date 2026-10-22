package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalExpressDetectInfo {
    public float age;
    public float angryScore;
    public float arousal;
    public float attractive;
    public float boyProb;
    public float happyScore;
    public float sadScore;
    public float surpriseScore;
    public float valence;

    public InternalExpressDetectInfo(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
        this.age = r100;
        this.boyProb = r101;
        this.attractive = r102;
        this.happyScore = r103;
        this.sadScore = r104;
        this.angryScore = r105;
        this.surpriseScore = r106;
        this.arousal = r107;
        this.valence = r108;
    }

    private static InternalExpressDetectInfo create(float r110, float r111, float r112, float r113, float r114, float r115, float r116, float r117, float r118) {
        return new InternalExpressDetectInfo(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
