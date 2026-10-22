package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;

/* JADX INFO: loaded from: classes23.dex */
public class NativeJpegTranscoderFactory implements ImageTranscoderFactory {
    private final int mMaxBitmapSize;
    private final boolean mUseDownSamplingRatio;

    public NativeJpegTranscoderFactory(int r100, boolean r101) {
        this.mMaxBitmapSize = r100;
        this.mUseDownSamplingRatio = r101;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat r100, boolean r101) {
        if (r100 == DefaultImageFormats.JPEG) goto L7;
        return null;
    L7:
        return new NativeJpegTranscoder(r101, this.mMaxBitmapSize, this.mUseDownSamplingRatio);
    }
}
