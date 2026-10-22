package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.util.Pair;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ImageRequestDiskCacheStrategy {
    private static ImageRequestDiskCacheStrategy sStrategy;

    public ImageRequestDiskCacheStrategy() {
    }

    public abstract Pair<Integer, String> getCustomDiskCache(Uri r100, int r101, String r102);

    public static ImageRequestDiskCacheStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageRequestDiskCacheStrategy r100) {
        sStrategy = r100;
    }
}
