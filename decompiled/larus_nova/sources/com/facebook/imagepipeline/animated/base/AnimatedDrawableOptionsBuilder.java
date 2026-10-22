package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes23.dex */
public class AnimatedDrawableOptionsBuilder {
    private boolean mAllowPrefetching;
    private boolean mEnableDebugging;
    private boolean mForceKeepAllFramesInMemory;
    private int mMaximumBytes;

    public AnimatedDrawableOptions build() {
        return new AnimatedDrawableOptions(this);
    }

    public AnimatedDrawableOptionsBuilder() {
        this.mAllowPrefetching = true;
        this.mMaximumBytes = -1;
    }

    public boolean getAllowPrefetching() {
        return this.mAllowPrefetching;
    }

    public boolean getEnableDebugging() {
        return this.mEnableDebugging;
    }

    public boolean getForceKeepAllFramesInMemory() {
        return this.mForceKeepAllFramesInMemory;
    }

    public int getMaximumBytes() {
        return this.mMaximumBytes;
    }

    public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean r100) {
        this.mAllowPrefetching = r100;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean r100) {
        this.mEnableDebugging = r100;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean r100) {
        this.mForceKeepAllFramesInMemory = r100;
        return this;
    }

    public AnimatedDrawableOptionsBuilder setMaximumBytes(int r100) {
        this.mMaximumBytes = r100;
        return this;
    }
}
