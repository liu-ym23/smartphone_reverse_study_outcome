package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.heif.HeicSROptions;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImageDecodeOptionsBuilder {
    private boolean isSelectBitmapConfig;
    private boolean mAnimatedHeifIndividualCacheEnabled;
    private Bitmap.Config mBitmapConfig;

    @Nullable
    private BitmapTransformation mBitmapTransformation;

    @Nullable
    private ImageDecoder mCustomImageDecoder;
    private boolean mDecodeAllFrames;

    @Nullable
    private Object mDecodeContext;
    private boolean mDecodePreviewFrame;
    private boolean mForceStaticImage;
    private boolean mForceUseARGB8888;
    public HeicSROptions mHeicSROptions;
    private int mMinDecodeIntervalMs;
    public boolean mOptSrWhenHeicDecode;
    private int mPreDecodeFrameCount;

    @Nullable
    private Rect mRegionToDecode;
    private boolean mTransformToSRGB;
    private boolean mUseLastFrameForPreview;
    private boolean mUseSmartCrop;

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }

    public ImageDecodeOptionsBuilder() {
        this.mMinDecodeIntervalMs = 100;
        this.mPreDecodeFrameCount = AnimatedFactoryProvider.getDefaultPreDecodeCount();
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.mForceUseARGB8888 = false;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    @Nullable
    public ImageDecoder getCustomImageDecoder() {
        return this.mCustomImageDecoder;
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    @Nullable
    public Object getDecodeContext() {
        return this.mDecodeContext;
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getForceStaticImage() {
        return this.mForceStaticImage;
    }

    public HeicSROptions getHeicSROptions() {
        return this.mHeicSROptions;
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    public int getPreDecodeFrameCount() {
        return this.mPreDecodeFrameCount;
    }

    @Nullable
    public Rect getRegionToDecode() {
        return this.mRegionToDecode;
    }

    public boolean getTransformToSRGB() {
        return this.mTransformToSRGB;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public boolean isAnimatedHeifIndividualCacheEnabled() {
        return this.mAnimatedHeifIndividualCacheEnabled;
    }

    public boolean isForceUseARGB8888() {
        return this.mForceUseARGB8888;
    }

    public boolean isOptSrWhenHeicDecode() {
        return this.mOptSrWhenHeicDecode;
    }

    public boolean isSelectBitmapConfig() {
        return this.isSelectBitmapConfig;
    }

    public boolean isUseSmartCrop() {
        return this.mUseSmartCrop;
    }

    public ImageDecodeOptionsBuilder setAnimatedHeifIndividualCacheEnabled(boolean r100) {
        this.mAnimatedHeifIndividualCacheEnabled = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setBitmapConfig(Bitmap.Config r100) {
        this.mBitmapConfig = r100;
        this.isSelectBitmapConfig = true;
        return this;
    }

    public ImageDecodeOptionsBuilder setBitmapTransformation(@Nullable BitmapTransformation r100) {
        this.mBitmapTransformation = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setCustomImageDecoder(@Nullable ImageDecoder r100) {
        this.mCustomImageDecoder = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean r100) {
        this.mDecodeAllFrames = r100;
        return this;
    }

    public void setDecodeContext(@Nullable Object r100) {
        this.mDecodeContext = r100;
    }

    public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean r100) {
        this.mDecodePreviewFrame = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setForceStaticImage(boolean r100) {
        this.mForceStaticImage = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setForceUseARGB8888(boolean r100) {
        this.mForceUseARGB8888 = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions r100) {
        this.mMinDecodeIntervalMs = r100.minDecodeIntervalMs;
        this.mDecodePreviewFrame = r100.decodePreviewFrame;
        this.mPreDecodeFrameCount = r100.preDecodeFrameCount;
        this.mUseLastFrameForPreview = r100.useLastFrameForPreview;
        this.mDecodeAllFrames = r100.decodeAllFrames;
        this.mForceStaticImage = r100.forceStaticImage;
        this.mBitmapConfig = r100.bitmapConfig;
        this.mForceUseARGB8888 = r100.forceUseARGB8888;
        this.mCustomImageDecoder = r100.customImageDecoder;
        this.mTransformToSRGB = r100.transformToSRGB;
        this.mBitmapTransformation = r100.bitmapTransformation;
        this.mDecodeContext = r100.decodeContext;
        this.isSelectBitmapConfig = r100.isSelectBitmapConfig;
        this.mUseSmartCrop = r100.useSmartCrop;
        this.mRegionToDecode = r100.regionToDecode;
        this.mAnimatedHeifIndividualCacheEnabled = r100.animatedHeifIndividualCacheEnabled;
        this.mOptSrWhenHeicDecode = r100.optSrWhenHeicDecode;
        this.mHeicSROptions = r100.heicSROptions;
        return this;
    }

    public ImageDecodeOptionsBuilder setHeicSROptions(HeicSROptions r100) {
        this.mHeicSROptions = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int r100) {
        this.mMinDecodeIntervalMs = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setOptSrWhenHeicDecode(boolean r100) {
        this.mOptSrWhenHeicDecode = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setPreDecodeFrameCount(int r100) {
        this.mPreDecodeFrameCount = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setRegionToDecode(@Nullable Rect r100) {
        this.mRegionToDecode = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setTransformToSRGB(boolean r100) {
        this.mTransformToSRGB = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean r100) {
        this.mUseLastFrameForPreview = r100;
        return this;
    }

    public ImageDecodeOptionsBuilder setUseSmartCrop(boolean r100) {
        this.mUseSmartCrop = r100;
        return this;
    }
}
