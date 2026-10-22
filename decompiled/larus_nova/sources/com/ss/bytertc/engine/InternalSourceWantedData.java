package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalSourceWantedData {
    public int frameRate;
    public int height;
    public int width;

    public String toString() {
        return "InternalSourceWantedData{width='" + this.width + "', height='" + this.height + "', frameRate='" + this.frameRate + "'}";
    }

    public InternalSourceWantedData(int r100, int r101, int r102) {
        this.width = r100;
        this.height = r101;
        this.frameRate = r102;
    }

    private static InternalSourceWantedData create(int r100, int r101, int r102) {
        return new InternalSourceWantedData(r100, r101, r102);
    }
}
