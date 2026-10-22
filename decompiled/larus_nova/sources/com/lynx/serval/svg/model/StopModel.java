package com.lynx.serval.svg.model;

/* JADX INFO: loaded from: classes32.dex */
public class StopModel {
    public long mColor;
    public float mOffset;
    public float mStopOpacity;

    public String toString() {
        return "StopModel{mOffset=" + this.mOffset + ", mColor=" + this.mColor + ", mStopOpacity=" + this.mStopOpacity + '}';
    }

    public StopModel(float r100, long r101, float r102) {
        this.mOffset = r100;
        this.mColor = r101;
        this.mStopOpacity = r102;
    }
}
