package com.facebook.net;

import android.net.Uri;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ImageBlurhashStrategy {
    public static ImageBlurhashStrategy DEFAULT;
    private static ImageBlurhashStrategy sStrategy;

    public ImageBlurhashStrategy() {
    }

    public abstract boolean isUseBlurhash(Uri r100, long r101);

    static {
        ImageBlurhashStrategy r100 = new AnonymousClass1();
        DEFAULT = r100;
        sStrategy = r100;
    }

    public static ImageBlurhashStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageBlurhashStrategy r100) {
        sStrategy = r100;
    }
}
