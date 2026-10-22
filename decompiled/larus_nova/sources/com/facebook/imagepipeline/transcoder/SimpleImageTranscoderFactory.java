package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes23.dex */
public class SimpleImageTranscoderFactory implements ImageTranscoderFactory {
    private final int mMaxBitmapSize;

    public SimpleImageTranscoderFactory(int r100) {
        this.mMaxBitmapSize = r100;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat r100, boolean r101) {
        return new SimpleImageTranscoder(r101, this.mMaxBitmapSize);
    }
}
