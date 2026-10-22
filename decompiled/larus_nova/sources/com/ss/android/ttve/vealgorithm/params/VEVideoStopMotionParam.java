package com.ss.android.ttve.vealgorithm.params;

/* JADX INFO: loaded from: classes38.dex */
public class VEVideoStopMotionParam extends VEAlgorithmParam {
    public int compileHeight;
    public int compileWidth;
    public String graphPath;
    public int interval;
    public String saveDir;
    public int startTime;
    public String videoPath;

    public VEVideoStopMotionParam() {
        this.compileWidth = 0;
        this.compileHeight = 0;
        this.type = VEAlgorithmType.VEAlgorithmTypeVideoStopMotionFrame;
    }
}
