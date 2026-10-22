package com.ss.android.vesdk.clipparam;

/* JADX INFO: loaded from: classes40.dex */
public class VEClipParam {
    public int clipIndex;
    public int clipRotate;
    public int clipType;
    public String path;
    public int seqIn;
    public int seqOut;
    public double speed;
    public int trimIn;
    public int trimOut;

    public VEClipParam() {
    }

    public String toString() {
        return "VEClipParam: clipType=" + this.clipType + "path=" + this.path + " trimIn=" + this.trimIn + " trimOut:=" + this.trimOut + " speed=" + this.speed + " clipRotate=" + this.clipRotate;
    }
}
