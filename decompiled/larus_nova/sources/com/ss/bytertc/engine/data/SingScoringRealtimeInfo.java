package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class SingScoringRealtimeInfo {
    public int averageScore;
    public int currentPosition;
    public int sentenceIndex;
    public int sentenceScore;
    public int standardPitch;
    public int totalScore;
    public int userPitch;

    public String toString() {
        return "SingScoringRealtimeInfo{currentPosition='" + this.currentPosition + "'userPitch='" + this.userPitch + "'standardPitch='" + this.standardPitch + "'sentenceIndex='" + this.sentenceIndex + "'sentenceScore='" + this.sentenceScore + "'totalScore='" + this.totalScore + "'averageScore='" + this.averageScore + "'}";
    }

    public SingScoringRealtimeInfo(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.currentPosition = r100;
        this.userPitch = r101;
        this.standardPitch = r102;
        this.sentenceIndex = r103;
        this.sentenceScore = r104;
        this.totalScore = r105;
        this.averageScore = r106;
    }

    private static SingScoringRealtimeInfo create(int r100, int r110, int r111, int r112, int r113, int r114, int r115) {
        return new SingScoringRealtimeInfo(r100, r110, r111, r112, r113, r114, r115);
    }
}
