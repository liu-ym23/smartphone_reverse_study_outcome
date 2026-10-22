package com.ss.ttvideoengine.strategrycenter;

/* JADX INFO: loaded from: classes35.dex */
public class StrategyKeys {
    public static int mInteractionBlockDurationNonPreloaded = 800;
    public static int mInteractionBlockDurationPreloaded = 400;

    public StrategyKeys() {
    }

    public static void setIntValue(int r100, int r101) {
        if (r100 != 120) goto L5;
        mInteractionBlockDurationPreloaded = r101;
        return;
    L5:
        if (r100 != 121) goto L11;
        mInteractionBlockDurationNonPreloaded = r101;
        return;
    }
}
