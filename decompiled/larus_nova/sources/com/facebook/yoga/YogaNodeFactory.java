package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public abstract class YogaNodeFactory {
    public YogaNodeFactory() {
    }

    public static YogaNode create() {
        return new YogaNodeJNIFinalizer();
    }

    public static YogaNode create(YogaConfig r100) {
        return new YogaNodeJNIFinalizer(r100);
    }
}
