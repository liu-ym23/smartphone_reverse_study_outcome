package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapCounterConfig {
    public static final int DEFAULT_MAX_BITMAP_COUNT = 384;
    private int mMaxBitmapCount;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.BitmapCounterConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int mMaxBitmapCount;

        public BitmapCounterConfig build() {
            return new BitmapCounterConfig(this);
        }

        private Builder() {
            this.mMaxBitmapCount = 384;
        }

        public int getMaxBitmapCount() {
            return this.mMaxBitmapCount;
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public Builder setMaxBitmapCount(int r100) {
            this.mMaxBitmapCount = r100;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getMaxBitmapCount() {
        return this.mMaxBitmapCount;
    }

    public BitmapCounterConfig(Builder r100) {
        this.mMaxBitmapCount = 384;
        this.mMaxBitmapCount = r100.getMaxBitmapCount();
    }

    public void setMaxBitmapCount(int r100) {
        this.mMaxBitmapCount = r100;
    }
}
