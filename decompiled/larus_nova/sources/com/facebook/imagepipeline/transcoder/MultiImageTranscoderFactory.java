package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {

    @Nullable
    private final Integer mImageTranscoderType;
    private final int mMaxBitmapSize;

    @Nullable
    private final ImageTranscoderFactory mPrimaryImageTranscoderFactory;
    private final boolean mUseDownSamplingRatio;

    @Nullable
    private ImageTranscoder getCustomImageTranscoder(ImageFormat r100, boolean r101) {
        ImageTranscoderFactory r102 = this.mPrimaryImageTranscoderFactory;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.createImageTranscoder(r100, r101);
    }

    @Nullable
    private ImageTranscoder getImageTranscoderWithType(ImageFormat r100, boolean r101) {
        Integer r102 = this.mImageTranscoderType;
        if (r102 != null) goto L6;
        return null;
    L6:
        int r103 = r102.intValue();
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L13;
        return getSimpleImageTranscoder(r100, r101);
    L13:
        throw new IllegalArgumentException("Invalid ImageTranscoderType");
    L15:
        return getNativeImageTranscoder(r100, r101);
    }

    @Nullable
    private ImageTranscoder getNativeImageTranscoder(ImageFormat r100, boolean r101) {
        return new NativeJpegTranscoderFactory(this.mMaxBitmapSize, this.mUseDownSamplingRatio).createImageTranscoder(r100, r101);
    }

    private ImageTranscoder getSimpleImageTranscoder(ImageFormat r100, boolean r101) {
        return new SimpleImageTranscoderFactory(this.mMaxBitmapSize).createImageTranscoder(r100, r101);
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat r100, boolean r101) {
        ImageTranscoder r102 = getCustomImageTranscoder(r100, r101);
        if (r102 != null) goto L5;
        r102 = getImageTranscoderWithType(r100, r101);
    L5:
        if (r102 != null) goto L7;
        r102 = getNativeImageTranscoder(r100, r101);
    L7:
        if (r102 == null) goto L9;
        return r102;
    L9:
        return getSimpleImageTranscoder(r100, r101);
    }

    public MultiImageTranscoderFactory(int r100, boolean r101, @Nullable ImageTranscoderFactory r102, @Nullable Integer r103) {
        this.mMaxBitmapSize = r100;
        this.mUseDownSamplingRatio = r101;
        this.mPrimaryImageTranscoderFactory = r102;
        this.mImageTranscoderType = r103;
    }
}
