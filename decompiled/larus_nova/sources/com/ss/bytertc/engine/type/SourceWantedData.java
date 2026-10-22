package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalSourceWantedData;

/* JADX INFO: loaded from: classes40.dex */
public class SourceWantedData {
    public int frameRate;
    public int height;
    public int width;

    public SourceWantedData() {
    }

    public String toString() {
        return "SourceWantedData{width='" + this.width + "', height='" + this.height + "', frameRate='" + this.frameRate + "'}";
    }

    public SourceWantedData(InternalSourceWantedData r100) {
        this.width = r100.width;
        this.height = r100.height;
        this.frameRate = r100.frameRate;
    }
}
