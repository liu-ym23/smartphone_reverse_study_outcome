package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.heif.HeicSROptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ImageDecodeOptions {
    private static final ImageDecodeOptions DEFAULTS = null;
    public boolean animatedHeifIndividualCacheEnabled;
    public Bitmap.Config bitmapConfig;

    @Nullable
    public final BitmapTransformation bitmapTransformation;

    @Nullable
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;

    @Nullable
    public final Object decodeContext;
    public final boolean decodePreviewFrame;
    public final boolean forceStaticImage;
    public boolean forceUseARGB8888;
    public HeicSROptions heicSROptions;
    public boolean isSelectBitmapConfig;
    public final int minDecodeIntervalMs;
    public boolean optSrWhenHeicDecode;
    public final int preDecodeFrameCount;

    @Nullable
    public final Rect regionToDecode;
    public final boolean transformToSRGB;
    public final boolean useLastFrameForPreview;
    public final boolean useSmartCrop;

    public String toOptKeyString() {
        return String.format(null, "%b-%s-%s-%s-%b-%b-%s", new Object[]{Boolean.valueOf(this.forceStaticImage), this.bitmapConfig.name(), this.bitmapTransformation, this.regionToDecode, Boolean.valueOf(this.animatedHeifIndividualCacheEnabled), Boolean.valueOf(this.optSrWhenHeicDecode), this.heicSROptions});
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        return new ImageDecodeOptionsBuilder();
    }

    public int hashCode() {
        int r100 = ((((((((((((this.minDecodeIntervalMs * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0)) * 31) + (this.transformToSRGB ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31;
        ImageDecoder r101 = this.customImageDecoder;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        BitmapTransformation r105 = this.bitmapTransformation;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Object r108 = this.decodeContext;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((((r107 + r109) * 31) + (this.isSelectBitmapConfig ? 1 : 0)) * 31) + (this.useSmartCrop ? 1 : 0)) * 31;
        Rect r111 = this.regionToDecode;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (((((r110 + r112) * 31) + (this.animatedHeifIndividualCacheEnabled ? 1 : 0)) * 31) + (this.optSrWhenHeicDecode ? 1 : 0)) * 31;
        HeicSROptions r114 = this.heicSROptions;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%b-%s-%s-%s-%s-%b-%b-%s-%b-%b-%s", new Object[]{Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), Boolean.valueOf(this.transformToSRGB), this.bitmapConfig.name(), this.customImageDecoder, this.bitmapTransformation, this.decodeContext, Boolean.valueOf(this.isSelectBitmapConfig), Boolean.valueOf(this.useSmartCrop), this.regionToDecode, Boolean.valueOf(this.animatedHeifIndividualCacheEnabled), Boolean.valueOf(this.optSrWhenHeicDecode), this.heicSROptions});
    }

    static {
        DEFAULTS = newBuilder().build();
    }

    public static ImageDecodeOptions defaults() {
        return DEFAULTS;
    }

    public ImageDecodeOptions(ImageDecodeOptionsBuilder r100) {
        this.minDecodeIntervalMs = r100.getMinDecodeIntervalMs();
        this.decodePreviewFrame = r100.getDecodePreviewFrame();
        this.preDecodeFrameCount = r100.getPreDecodeFrameCount();
        this.useLastFrameForPreview = r100.getUseLastFrameForPreview();
        this.decodeAllFrames = r100.getDecodeAllFrames();
        this.forceStaticImage = r100.getForceStaticImage();
        this.bitmapConfig = r100.getBitmapConfig();
        this.forceUseARGB8888 = r100.isForceUseARGB8888();
        this.customImageDecoder = r100.getCustomImageDecoder();
        this.transformToSRGB = r100.getTransformToSRGB();
        this.bitmapTransformation = r100.getBitmapTransformation();
        this.decodeContext = r100.getDecodeContext();
        this.isSelectBitmapConfig = r100.isSelectBitmapConfig();
        this.useSmartCrop = r100.isUseSmartCrop();
        this.regionToDecode = r100.getRegionToDecode();
        this.animatedHeifIndividualCacheEnabled = r100.isAnimatedHeifIndividualCacheEnabled();
        this.optSrWhenHeicDecode = r100.isOptSrWhenHeicDecode();
        this.heicSROptions = r100.getHeicSROptions();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L62:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L62;
        ImageDecodeOptions r101 = (ImageDecodeOptions) r100;
        if (this.decodePreviewFrame == r101.decodePreviewFrame) goto L14;
        return false;
    L14:
        if (this.useLastFrameForPreview == r101.useLastFrameForPreview) goto L17;
        return false;
    L17:
        if (this.decodeAllFrames == r101.decodeAllFrames) goto L20;
        return false;
    L20:
        if (this.forceStaticImage == r101.forceStaticImage) goto L23;
        return false;
    L23:
        if (this.transformToSRGB == r101.transformToSRGB) goto L26;
        return false;
    L26:
        if (this.bitmapConfig == r101.bitmapConfig) goto L29;
        return false;
    L29:
        if (this.customImageDecoder == r101.customImageDecoder) goto L32;
        return false;
    L32:
        if (this.bitmapTransformation == r101.bitmapTransformation) goto L35;
        return false;
    L35:
        if (this.decodeContext == r101.decodeContext) goto L38;
        return false;
    L38:
        if (this.isSelectBitmapConfig == r101.isSelectBitmapConfig) goto L41;
        return false;
    L41:
        if (this.useSmartCrop == r101.useSmartCrop) goto L44;
        return false;
    L44:
        if (this.animatedHeifIndividualCacheEnabled == r101.animatedHeifIndividualCacheEnabled) goto L47;
        return false;
    L47:
        if (this.optSrWhenHeicDecode == r101.optSrWhenHeicDecode) goto L50;
        return false;
    L50:
        if (this.heicSROptions == r101.heicSROptions) goto L52;
        return false;
    L52:
        Rect r102 = this.regionToDecode;
        if (r102 != null) goto L55;
    L56:
        Rect r103 = r101.regionToDecode;
        if (r103 != null) goto L59;
    L61:
        return true;
    L59:
        if (r103.equals(this.regionToDecode) == true) goto L61;
    L60:
        return false;
    L55:
        if (r102.equals(r101.regionToDecode) == false) goto L60;
        goto L56
    }
}
