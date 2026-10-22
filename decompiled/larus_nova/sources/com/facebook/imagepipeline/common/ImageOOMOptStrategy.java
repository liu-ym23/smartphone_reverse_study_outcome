package com.facebook.imagepipeline.common;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ImageOOMOptStrategy {
    public static ImageOOMOptStrategy FRESCO_DEFAULT_STRATEGY;
    private static ImageOOMOptStrategy sStrategy;

    public ImageOOMOptStrategy() {
    }

    public abstract boolean isEnableAnimatedOOMOpt();

    public boolean isEnableOOMOpt() {
        return true;
    }

    public abstract boolean isEnablePostProcessorOOMOpt();

    public abstract void optMemoryWhenAnimatedOOM();

    public abstract void optMemoryWhenOOM();

    public abstract void optMemoryWhenPostProcessorOOM();

    static {
        FRESCO_DEFAULT_STRATEGY = new AnonymousClass1();
    }

    public static ImageOOMOptStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageOOMOptStrategy r100) {
        sStrategy = r100;
    }
}
