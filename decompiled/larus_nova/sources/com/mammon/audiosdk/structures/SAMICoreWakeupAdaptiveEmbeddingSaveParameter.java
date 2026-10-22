package com.mammon.audiosdk.structures;

/* JADX INFO: loaded from: classes32.dex */
public class SAMICoreWakeupAdaptiveEmbeddingSaveParameter {
    public int save;
    public String wkrId;

    public SAMICoreWakeupAdaptiveEmbeddingSaveParameter() {
        this("", 1);
    }

    public SAMICoreWakeupAdaptiveEmbeddingSaveParameter(long r100, int r101) {
        this(String.valueOf(r100), r101);
    }

    public SAMICoreWakeupAdaptiveEmbeddingSaveParameter(String r100, int r101) {
        this.wkrId = r100;
        this.save = r101;
    }
}
