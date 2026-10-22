package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.DownsampleUtil;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class SimpleImageTranscoder implements ImageTranscoder {
    private static final String TAG = "SimpleImageTranscoder";
    private final int mMaxBitmapSize;
    private final boolean mResizingEnabled;

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return TAG;
    }

    private static Bitmap.CompressFormat getOutputFormat(@Nullable ImageFormat r100) {
        if (r100 != null) goto L6;
        return Bitmap.CompressFormat.JPEG;
    L6:
        if (r100 != DefaultImageFormats.JPEG) goto L10;
        return Bitmap.CompressFormat.JPEG;
    L10:
        if (r100 != DefaultImageFormats.PNG) goto L14;
        return Bitmap.CompressFormat.PNG;
    L14:
        if (DefaultImageFormats.isStaticWebpFormat(r100) == false) goto L18;
        return Bitmap.CompressFormat.WEBP;
    L18:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat r100) {
        if (r100 != DefaultImageFormats.JPEG) goto L5;
        return true;
    L5:
        return false;
    }

    public SimpleImageTranscoder(boolean r100, int r101) {
        this.mResizingEnabled = r100;
        this.mMaxBitmapSize = r101;
    }

    private int getSampleSize(EncodedImage r100, RotationOptions r101, @Nullable ResizeOptions r102) {
        if (this.mResizingEnabled == true) goto L6;
        return 1;
    L6:
        return DownsampleUtil.determineSampleSize(r101, r102, r100, this.mMaxBitmapSize);
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage r100, @Nullable RotationOptions r101, @Nullable ResizeOptions r102) {
        if (r101 != null) goto L5;
        r101 = RotationOptions.autoRotate();
    L5:
        if (this.mResizingEnabled == true) goto L7;
    L9:
        return false;
    L7:
        if (DownsampleUtil.determineSampleSize(r101, r102, r100, this.mMaxBitmapSize) <= 1) goto L9;
        return true;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage r110, OutputStream r210, @Nullable RotationOptions r211, @Nullable ResizeOptions r212, @Nullable ImageFormat r213, @Nullable Integer r214) {
        if (r214 != null) goto L5;
        Integer r100 = 85;
    L6:
        if (r211 != null) goto L8;
        RotationOptions r101 = RotationOptions.autoRotate();
    L9:
        int r102 = getSampleSize(r110, r101, r212);
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inSampleSize = r102;
        Bitmap r104 = BitmapFactory.decodeStream(r110.getInputStream(), null, r103);     // Catch: OutOfMemoryError -> L38
        if (r104 != null) goto L14;
        FLog.e(TAG, "Couldn't decode the EncodedImage InputStream ! ");
        return new ImageTranscodeResult(2);
    L14:
        Matrix r111 = JpegTranscoderUtils.getTransformationMatrix(r110, r101);
        if (r111 != null) goto L46;
        Bitmap r105 = r104;
    L43:
        r105.compress(getOutputFormat(r213), r100.intValue(), r210);     // Catch: Throwable -> L30 OutOfMemoryError -> L32
        int r106 = 1;
        if (r102 <= 1) goto L27;
        r106 = 0;
    L27:
        ImageTranscodeResult r107 = new ImageTranscodeResult(r106);     // Catch: Throwable -> L30 OutOfMemoryError -> L32
        r105.recycle();
        r104.recycle();
        return r107;
    L32:
        OutOfMemoryError e100 = e;
    L33:
        FLog.e(TAG, "Out-Of-Memory during transcode", e100);     // Catch: Throwable -> L30
        ImageTranscodeResult r108 = new ImageTranscodeResult(2);     // Catch: Throwable -> L30
        r105.recycle();
        r104.recycle();
        return r108;
    L30:
        Throwable th10 = th;
    L36:
        r105.recycle();
        r104.recycle();
        throw th10;
    L46:
        r105 = Bitmap.createBitmap(r104, 0, 0, r104.getWidth(), r104.getHeight(), r111, false);     // Catch: Throwable -> L19 OutOfMemoryError -> L21
        goto L43
    L21:
        e100 = e;
        r105 = r104;
    L19:
        th10 = th;
        r105 = r104;
    L38:
        e = move-exception;
        FLog.e(TAG, "Out-Of-Memory during transcode", e);
        return new ImageTranscodeResult(2);
    L8:
        r101 = r211;
        goto L9
    L5:
        r100 = r214;
        goto L6
    }
}
