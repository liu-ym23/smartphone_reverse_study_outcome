package com.ss.android.vesdk.clipparam;

import com.ss.android.vesdk.VEListener;

/* JADX INFO: loaded from: classes40.dex */
public class VEAICutOutClipParam {
    public int archerStrategy;
    public VEListener.q listener;
    public String mModelPath;
    public String mWorkSpace;
    public String originPicForMask;
    public int trimIn;
    public int trimOut;

    public String toString() {
        return "VEAICutOutClipParam{trimIn=" + this.trimIn + ", maskPath='" + this.mWorkSpace + "', mModelPath='" + this.mModelPath + "', trimOut='" + this.trimOut + "', archerStrategy='" + this.archerStrategy + "', originPicForMask='" + this.originPicForMask + "'}";
    }

    public VEAICutOutClipParam() {
        this.trimIn = 0;
        this.trimOut = 0;
        this.mWorkSpace = "";
        this.mModelPath = "";
        this.archerStrategy = -1;
        this.originPicForMask = "";
    }
}
