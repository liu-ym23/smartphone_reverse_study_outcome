package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes23.dex */
public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    private static final float INTERVAL_ROUNDING = 0.33333334f;

    private DownsampleUtil() {
    }

    public static int ratioToSampleSizeJPEG(float r100) {
        if (r100 <= 0.6666667f) goto L6;
        return 1;
    L6:
        int r101 = 2;
    L7:
        int r102 = r101 * 2;
        double r103 = 1.0d / ((double) r102);
        if ((r103 + (0.3333333432674408d * r103)) <= r100) goto L9;
        r101 = r102;
        goto L7
    L9:
        return r101;
    }

    public static int roundToPowerOfTwo(int r100) {
        int r101 = 1;
    L3:
        if (r101 >= r100) goto L4;
        r101 = r101 * 2;
        goto L3
    L4:
        return r101;
    }

    public static int ratioToSampleSize(float r100) {
        if (r100 <= 0.6666667f) goto L5;
        return 1;
    L5:
        int r101 = 2;
    L6:
        double r102 = r101;
        if (((1.0d / r102) + ((1.0d / (Math.pow(r102, 2.0d) - r102)) * 0.3333333432674408d)) <= r100) goto L9;
        r101 = r101 + 1;
        goto L6
    L9:
        return r101 - 1;
    }

    private static int getRotationAngle(RotationOptions r100, EncodedImage r101) {
        boolean r102 = false;
        if (r100.useImageMetadata() == true) goto L5;
        return 0;
    L5:
        int r103 = r101.getRotationAngle();
        if (r103 != 0) goto L8;
    L13:
        r102 = true;
    L14:
        Preconditions.checkArgument(r102);
        return r103;
    L8:
        if (r103 == 90) goto L13;
        if (r103 == 180) goto L13;
        if (r103 != 270) goto L14;
        goto L13
    }

    public static float determineDownsampleRatio(RotationOptions r100, ResizeOptions r101, EncodedImage r102) {
        Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(r102));
        if (r101 != null) goto L5;
        return 1.0f;
    L5:
        if (r101.height > 0) goto L7;
        return 1.0f;
    L7:
        if (r101.width > 0) goto L9;
        return 1.0f;
    L9:
        if (r102.getWidth() != 0) goto L11;
        return 1.0f;
    L11:
        if (r102.getHeight() == 0) goto L33;
        int r103 = getRotationAngle(r100, r102);
        if (r103 != 90) goto L16;
    L19:
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        int r105 = r102.getHeight();
    L23:
        if (r104 == false) goto L25;
        int r106 = r102.getWidth();
    L26:
        float r107 = r101.width / r105;
        float r108 = r101.height / r106;
        float r109 = Math.max(r107, r108);
        FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", new Object[]{Integer.valueOf(r101.width), Integer.valueOf(r101.height), Integer.valueOf(r105), Integer.valueOf(r106), Float.valueOf(r107), Float.valueOf(r108), Float.valueOf(r109)});
        return r109;
    L25:
        r106 = r102.getHeight();
        goto L26
    L22:
        r105 = r102.getWidth();
        goto L23
    L16:
        if (r103 == 270) goto L19;
        r104 = false;
        goto L20
    L33:
        return 1.0f;
    }

    public static int determineSampleSize(RotationOptions r100, ResizeOptions r101, EncodedImage r102, int r103) {
        if (EncodedImage.isMetaDataAvailable(r102) == true) goto L6;
        return 1;
    L6:
        float r104 = determineDownsampleRatio(r100, r101, r102);
        if (r102.getImageFormat() != DefaultImageFormats.JPEG) goto L9;
        int r105 = ratioToSampleSizeJPEG(r104);
    L10:
        int r106 = Math.max(r102.getHeight(), r102.getWidth());
        if (r101 == null) goto L13;
        float r107 = r101.maxBitmapSize;
    L15:
        if ((r106 / r105) <= r107) goto L20;
        if (r102.getImageFormat() == DefaultImageFormats.JPEG) goto L18;
        r105 = r105 + 1;
        goto L15
    L18:
        r105 = r105 * 2;
        goto L15
    L20:
        return r105;
    L13:
        r107 = r103;
        goto L15
    L9:
        r105 = ratioToSampleSize(r104);
        goto L10
    }
}
