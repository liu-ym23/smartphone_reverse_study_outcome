package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageResizeOptionStrategy {
    private static ImageResizeOptionStrategy sStrategy;

    public ImageResizeOptionStrategy() {
    }

    public abstract ResizeOptions getResizeConfig(Uri r100, int r101, int r102, int r103, int r104, boolean r105, ImageFormat r106);

    public static ImageResizeOptionStrategy getStrategy() {
        return sStrategy;
    }

    public static void setStrategy(ImageResizeOptionStrategy r100) {
        sStrategy = r100;
    }
}
