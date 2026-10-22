package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YogaConfigFactory {
    public YogaConfigFactory() {
    }

    public static YogaConfig create() {
        return new YogaConfigJNIFinalizer();
    }
}
