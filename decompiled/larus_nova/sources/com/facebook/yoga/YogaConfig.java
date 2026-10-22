package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YogaConfig {
    public static int SPACING_TYPE = 1;

    public YogaConfig() {
    }

    public abstract YogaErrata getErrata();

    public abstract YogaLogger getLogger();

    public abstract long getNativePointer();

    public abstract void setErrata(YogaErrata r100);

    public abstract void setExperimentalFeatureEnabled(YogaExperimentalFeature r100, boolean r101);

    public abstract void setLogger(YogaLogger r100);

    public abstract void setPointScaleFactor(float r100);

    public abstract void setUseWebDefaults(boolean r100);
}
