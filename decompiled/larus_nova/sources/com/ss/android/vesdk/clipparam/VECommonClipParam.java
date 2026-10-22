package com.ss.android.vesdk.clipparam;

import com.ss.android.vesdk.ROTATE_DEGREE;

/* JADX INFO: loaded from: classes40.dex */
public class VECommonClipParam {
    public String mp4DecryptionKey;
    public String path;
    public int seqIn;
    public int seqOut;
    public double speed;
    public int trimIn;
    public int trimOut;
    public int videoClipRotate;

    public String toString() {
        return "VECommonClip{trimIn=" + this.trimIn + ", trimOut=" + this.trimOut + ", path='" + this.path + "', mp4DecryptionKey='" + this.mp4DecryptionKey + "', speed=" + this.speed + ", seqIn=" + this.seqIn + ", seqOut=" + this.seqOut + ", videoClipRotate=" + this.videoClipRotate + '}';
    }

    public VECommonClipParam() {
        this.trimIn = -1;
        this.trimOut = -1;
        this.speed = 1.0d;
        this.seqIn = -1;
        this.seqOut = -1;
        this.videoClipRotate = ROTATE_DEGREE.ROTATE_NONE.ordinal();
    }
}
