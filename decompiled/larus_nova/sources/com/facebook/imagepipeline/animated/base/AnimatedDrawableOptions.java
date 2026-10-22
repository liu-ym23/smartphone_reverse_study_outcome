package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableOptions {
    public static AnimatedDrawableOptions DEFAULTS;
    public final boolean allowPrefetching;
    public final boolean enableDebugging;
    public final boolean forceKeepAllFramesInMemory;
    public final int maximumBytes;

    public static AnimatedDrawableOptionsBuilder newBuilder() {
        return new AnimatedDrawableOptionsBuilder();
    }

    static {
        DEFAULTS = newBuilder().build();
    }

    public AnimatedDrawableOptions(AnimatedDrawableOptionsBuilder r100) {
        this.forceKeepAllFramesInMemory = r100.getForceKeepAllFramesInMemory();
        this.allowPrefetching = r100.getAllowPrefetching();
        this.maximumBytes = r100.getMaximumBytes();
        this.enableDebugging = r100.getEnableDebugging();
    }
}
