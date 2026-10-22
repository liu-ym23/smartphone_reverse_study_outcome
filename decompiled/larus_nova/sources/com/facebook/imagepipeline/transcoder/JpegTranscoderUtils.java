package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class JpegTranscoderUtils {
    public static final int DEFAULT_JPEG_QUALITY = 85;
    private static final int FULL_ROUND = 360;
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = null;
    public static final int MAX_QUALITY = 100;
    public static final int MAX_SCALE_NUMERATOR = 16;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SCALE_NUMERATOR = 1;
    public static final int SCALE_DENOMINATOR = 8;

    static {
        INVERTED_EXIF_ORIENTATIONS = ImmutableList.of(new Integer[]{2, 7, 4, 5});
    }

    public JpegTranscoderUtils() {
    }

    public static boolean isExifOrientationAllowed(int r100) {
        switch(r100) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static int roundNumerator(float r100, float r101) {
        return (int) (r101 + (r100 * 8.0f));
    }

    public static int calculateDownsampleNumerator(int r100) {
        return Math.max(1, 8 / r100);
    }

    private static int extractOrientationFromMetadata(EncodedImage r100) {
        int r101 = r100.getRotationAngle();
        if (r101 == 90) goto L11;
        if (r101 == 180) goto L11;
        if (r101 == 270) goto L11;
        return 0;
    L11:
        return r100.getRotationAngle();
    }

    @Nullable
    private static Matrix getTransformationMatrixFromInvertedExif(int r100) {
        Matrix r101 = new Matrix();
        if (r100 != 2) goto L5;
        r101.setScale(-1.0f, 1.0f);
    L16:
        return r101;
    L5:
        if (r100 != 7) goto L7;
        r101.setRotate(-90.0f);
        r101.postScale(-1.0f, 1.0f);
        goto L16
    L7:
        if (r100 != 4) goto L9;
        r101.setRotate(180.0f);
        r101.postScale(-1.0f, 1.0f);
        goto L16
    L9:
        if (r100 == 5) goto L12;
        return null;
    L12:
        r101.setRotate(90.0f);
        r101.postScale(-1.0f, 1.0f);
        goto L16
    }

    public static boolean isRotationAngleAllowed(int r100) {
        if (r100 >= 0) goto L4;
    L8:
        return false;
    L4:
        if (r100 > 270) goto L8;
        if ((r100 % 90) != 0) goto L8;
        return true;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions r100, EncodedImage r101) {
        int r102 = r101.getExifOrientation();
        ImmutableList<Integer> r103 = INVERTED_EXIF_ORIENTATIONS;
        int r104 = r103.indexOf(Integer.valueOf(r102));
        if (r104 < 0) goto L11;
        if (r100.useImageMetadata() == true) goto L7;
        int r105 = r100.getForcedAngle();
    L9:
        return r103.get((r104 + (r105 / 90)) % r103.size()).intValue();
    L7:
        r105 = 0;
        goto L9
    L11:
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int getRotationAngle(RotationOptions r100, EncodedImage r101) {
        if (r100.rotationEnabled() == true) goto L6;
        return 0;
    L6:
        int r102 = extractOrientationFromMetadata(r101);
        if (r100.useImageMetadata() == false) goto L10;
        return r102;
    L10:
        return (r102 + r100.getForcedAngle()) % 360;
    }

    @Nullable
    public static Matrix getTransformationMatrix(EncodedImage r100, RotationOptions r101) {
        if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(r100.getExifOrientation())) == true) goto L10;
        int r102 = getRotationAngle(r101, r100);
        if (r102 == 0) goto L8;
        Matrix r103 = new Matrix();
        r103.setRotate(r102);
        return r103;
    L8:
        return null;
    L10:
        return getTransformationMatrixFromInvertedExif(getForceRotatedInvertedExifOrientation(r101, r100));
    }

    public static float determineResizeRatio(ResizeOptions r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return 1.0f;
    L5:
        float r103 = r101;
        float r104 = r102;
        float r105 = Math.max(r100.width / r103, r100.height / r104);
        float r106 = r103 * r105;
        float r107 = r100.maxBitmapSize;
        if (r106 <= r107) goto L9;
        r105 = r107 / r103;
    L9:
        if ((r104 * r105) > r107) goto L11;
        return r105;
    L11:
        return r107 / r104;
    }

    public static int getSoftwareNumerator(RotationOptions r100, @Nullable ResizeOptions r101, EncodedImage r102, boolean r103) {
        if (r103 == true) goto L5;
        return 8;
    L5:
        if (r101 != null) goto L7;
        return 8;
    L7:
        int r104 = getRotationAngle(r100, r102);
        boolean r105 = false;
        if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(r102.getExifOrientation())) == false) goto L10;
        int r106 = getForceRotatedInvertedExifOrientation(r100, r102);
    L12:
        if (r104 != 90) goto L14;
    L19:
        r105 = true;
    L20:
        if (r105 == false) goto L22;
        int r107 = r102.getHeight();
    L23:
        if (r105 == false) goto L25;
        int r108 = r102.getWidth();
    L26:
        int r109 = roundNumerator(determineResizeRatio(r101, r107, r108), r101.roundUpFraction);
        if (r109 <= 8) goto L29;
        return 8;
    L29:
        if (r109 >= 1) goto L32;
        return 1;
    L32:
        return r109;
    L25:
        r108 = r102.getHeight();
        goto L26
    L22:
        r107 = r102.getWidth();
        goto L23
    L14:
        if (r104 == 270) goto L19;
        if (r106 == 5) goto L19;
        if (r106 != 7) goto L20;
    L10:
        r106 = 0;
        goto L12
    }
}
