package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes23.dex */
public abstract class MemoryCacheLookupListener {
    private static MemoryCacheLookupListener sListener;

    public MemoryCacheLookupListener() {
    }

    public abstract void onMemoryCacheHit(ImageRequest r100, Object r101, CloseableReference<CloseableImage> r102);

    public abstract void onMemoryCacheLookupStart(ImageRequest r100, Object r101);

    public abstract void onMemoryCacheMiss(ImageRequest r100, Object r101);

    public static MemoryCacheLookupListener getStrategy() {
        return sListener;
    }

    public static void setListener(MemoryCacheLookupListener r100) {
        sListener = r100;
    }
}
