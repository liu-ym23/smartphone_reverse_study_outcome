package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class NativeJpegTranscoder implements ImageTranscoder {
    public static final String TAG = "NativeJpegTranscoder";
    private int mMaxBitmapSize;
    private boolean mResizingEnabled;
    private boolean mUseDownsamplingRatio;

    private static native void nativeTranscodeJpeg(InputStream r100, OutputStream r101, int r102, int r103, int r104) throws IOException;

    private static native void nativeTranscodeJpegWithExifOrientation(InputStream r100, OutputStream r101, int r102, int r103, int r104) throws IOException;

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return TAG;
    }

    static {
        ImagePipelineNativeLoader.load();
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat r100) {
        if (r100 != DefaultImageFormats.JPEG) goto L5;
        return true;
    L5:
        return false;
    }

    public NativeJpegTranscoder(boolean r100, int r101, boolean r102) {
        this.mResizingEnabled = r100;
        this.mMaxBitmapSize = r101;
        this.mUseDownsamplingRatio = r102;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage r100, @Nullable RotationOptions r101, @Nullable ResizeOptions r102) {
        if (r101 != null) goto L5;
        r101 = RotationOptions.autoRotate();
    L5:
        if (JpegTranscoderUtils.getSoftwareNumerator(r101, r102, r100, this.mResizingEnabled) >= 8) goto L7;
        return true;
    L7:
        return false;
    }

    public static void transcodeJpeg(InputStream r100, OutputStream r101, int r102, int r103, int r104) throws IOException {
        boolean r105 = false;
        if (r103 < 1) goto L5;
        boolean r106 = true;
    L6:
        Preconditions.checkArgument(r106);
        if (r103 > 16) goto L9;
        boolean r107 = true;
    L10:
        Preconditions.checkArgument(r107);
        if (r104 < 0) goto L13;
        boolean r108 = true;
    L14:
        Preconditions.checkArgument(r108);
        if (r104 > 100) goto L17;
        boolean r109 = true;
    L18:
        Preconditions.checkArgument(r109);
        Preconditions.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(r102));
        if (r103 != 8) goto L21;
        if (r102 != 0) goto L21;
    L22:
        Preconditions.checkArgument(r105, "no transformation requested");
        nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(r100), (OutputStream) Preconditions.checkNotNull(r101), r102, r103, r104);
        return;
    L21:
        r105 = true;
        goto L22
    L17:
        r109 = false;
        goto L18
    L13:
        r108 = false;
        goto L14
    L9:
        r107 = false;
        goto L10
    L5:
        r106 = false;
        goto L6
    }

    public static void transcodeJpegWithExifOrientation(InputStream r100, OutputStream r101, int r102, int r103, int r104) throws IOException {
        boolean r105 = false;
        if (r103 < 1) goto L5;
        boolean r106 = true;
    L6:
        Preconditions.checkArgument(r106);
        if (r103 > 16) goto L9;
        boolean r107 = true;
    L10:
        Preconditions.checkArgument(r107);
        if (r104 < 0) goto L13;
        boolean r108 = true;
    L14:
        Preconditions.checkArgument(r108);
        if (r104 > 100) goto L17;
        boolean r109 = true;
    L18:
        Preconditions.checkArgument(r109);
        Preconditions.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(r102));
        if (r103 != 8) goto L21;
        if (r102 != 1) goto L21;
    L22:
        Preconditions.checkArgument(r105, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(r100), (OutputStream) Preconditions.checkNotNull(r101), r102, r103, r104);
        return;
    L21:
        r105 = true;
        goto L22
    L17:
        r109 = false;
        goto L18
    L13:
        r108 = false;
        goto L14
    L9:
        r107 = false;
        goto L10
    L5:
        r106 = false;
        goto L6
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage r100, OutputStream r101, @Nullable RotationOptions r102, @Nullable ResizeOptions r103, @Nullable ImageFormat r104, @Nullable Integer r105) throws IOException {
        if (r105 != null) goto L4;
        r105 = 85;
    L4:
        if (r102 != null) goto L6;
        r102 = RotationOptions.autoRotate();
    L6:
        int r106 = DownsampleUtil.determineSampleSize(r102, r103, r100, this.mMaxBitmapSize);
        int r107 = JpegTranscoderUtils.getSoftwareNumerator(r102, r103, r100, this.mResizingEnabled);     // Catch: Throwable -> L20
        int r108 = JpegTranscoderUtils.calculateDownsampleNumerator(r106);     // Catch: Throwable -> L20
        if (this.mUseDownsamplingRatio == false) goto L10;
        r107 = r108;
    L10:
        InputStream r109 = r100.getInputStream();     // Catch: Throwable -> L20
        if (JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(r100.getExifOrientation())) == false) goto L13;
        transcodeJpegWithExifOrientation(r109, r101, JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(r102, r100), r107, r105.intValue());     // Catch: Throwable -> L20
    L14:
        Closeables.closeQuietly(r109);
        int r110 = 1;
        if (r106 == 1) goto L19;
        r110 = 0;
    L19:
        return new ImageTranscodeResult(r110);
    L13:
        transcodeJpeg(r109, r101, JpegTranscoderUtils.getRotationAngle(r102, r100), r107, r105.intValue());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Closeables.closeQuietly(null);
        throw th;
    }
}
