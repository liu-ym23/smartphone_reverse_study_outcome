package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YogaConfigJNIBase extends YogaConfig {
    private YogaLogger mLogger;
    long mNativePointer;

    @Override // com.facebook.yoga.YogaConfig
    public YogaErrata getErrata() {
        return YogaErrata.fromInt(YogaNative.jni_YGConfigGetErrataJNI(this.mNativePointer));
    }

    public YogaConfigJNIBase() {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    @Override // com.facebook.yoga.YogaConfig
    public YogaLogger getLogger() {
        return this.mLogger;
    }

    @Override // com.facebook.yoga.YogaConfig
    public long getNativePointer() {
        return this.mNativePointer;
    }

    private YogaConfigJNIBase(long r100) {
        if (r100 == 0) goto L7;
        this.mNativePointer = r100;
        return;
    L7:
        throw new IllegalStateException("Failed to allocate native memory");
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setErrata(YogaErrata r100) {
        YogaNative.jni_YGConfigSetErrataJNI(this.mNativePointer, r100.intValue());
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setLogger(YogaLogger r100) {
        this.mLogger = r100;
        YogaNative.jni_YGConfigSetLoggerJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setPointScaleFactor(float r100) {
        YogaNative.jni_YGConfigSetPointScaleFactorJNI(this.mNativePointer, r100);
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setUseWebDefaults(boolean r100) {
        YogaNative.jni_YGConfigSetUseWebDefaultsJNI(this.mNativePointer, r100);
    }

    public YogaConfigJNIBase(boolean r100) {
        this(YogaNative.jni_YGConfigNewJNI());
    }

    @Override // com.facebook.yoga.YogaConfig
    public void setExperimentalFeatureEnabled(YogaExperimentalFeature r100, boolean r101) {
        YogaNative.jni_YGConfigSetExperimentalFeatureEnabledJNI(this.mNativePointer, r100.intValue(), r101);
    }
}
