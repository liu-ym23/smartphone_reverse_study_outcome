package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

/* JADX INFO: loaded from: classes23.dex */
public interface ThumbnailProducer<T> extends Producer<T> {
    boolean canProvideImageForSize(ResizeOptions r100);
}
