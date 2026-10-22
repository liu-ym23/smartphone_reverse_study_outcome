package com.facebook.webpsupport;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes23.dex */
public class WebPEncoder {
    public static final int SPEED_BALANCED = 3;
    public static final int SPEED_BEST_QUALITY = 6;
    public static final int SPEED_FAST = 1;
    public static final int SPEED_FASTEST = 0;
    private static boolean sInitialized;

    public WebPEncoder() {
    }

    public static native boolean nativeEncodeBitmapToWebP(Bitmap r100, int r101, FileOutputStream r102);

    public static native boolean nativeEncodeBitmapToWebPWithSpeed(Bitmap r100, int r101, int r102, FileOutputStream r103);

    public static native boolean nativeEncodeBitmapToWebPWithSpeedAndThreads(Bitmap r100, int r101, int r102, boolean r103, boolean r104, FileOutputStream r105);

    public static native boolean nativeEncodeLosslessBitmapToWebPWithSpeed(Bitmap r100, int r101, boolean r102, boolean r103, FileOutputStream r104);

    static {
        StaticWebpNativeLoader.ensure();     // Catch: UnsatisfiedLinkError -> L4
        sInitialized = true;     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        sInitialized = false;
    }

    public static boolean isWebPEncoderAvailable() {
        return sInitialized;
    }

    public static boolean encodeLosslessBitmapToWebP(Bitmap r100, FileOutputStream r101) throws RuntimeException, IllegalArgumentException {
        return encodeLosslessBitmapToWebPWithSpeed(r100, 3, r101);
    }

    public static boolean encodeBitmapToWebP(Bitmap r100, int r101, FileOutputStream r102) throws RuntimeException, IllegalArgumentException {
        return encodeBitmapToWebPWithSpeed(r100, r101, 3, r102);
    }

    public static boolean encodeLosslessBitmapToWebPWithSpeed(Bitmap r100, int r101, FileOutputStream r102) throws RuntimeException, IllegalArgumentException {
        return encodeLosslessBitmapToWebPWithSpeed(r100, r101, false, false, r102);
    }

    public static boolean encodeBitmapToWebPWithSpeed(Bitmap r100, int r101, int r102, FileOutputStream r103) throws RuntimeException, IllegalArgumentException {
        return encodeBitmapToWebPWithSpeed(r100, r101, r102, false, false, r103);
    }

    public static boolean encodeLosslessBitmapToWebPWithSpeed(Bitmap r100, int r101, boolean r102, boolean r103, FileOutputStream r104) throws RuntimeException, IllegalArgumentException {
        if (sInitialized == false) goto L18;
        if (r100 == null) goto L16;
        if (r104 == null) goto L14;
        if (r101 < 0) goto L12;
        if (r101 > 6) goto L12;
        return nativeEncodeLosslessBitmapToWebPWithSpeed(r100, r101, r102, r103, r104);
    L12:
        throw new IllegalArgumentException("Speed must be between 0 and 6");
    L14:
        throw new IllegalArgumentException("OutputStream cannot be null");
    L16:
        throw new IllegalArgumentException("Bitmap cannot be null");
    L18:
        throw new RuntimeException("WebPEncoder not available");
    }

    public static boolean encodeBitmapToWebPWithSpeed(Bitmap r100, int r101, int r102, boolean r103, boolean r104, FileOutputStream r105) throws RuntimeException, IllegalArgumentException {
        if (sInitialized == false) goto L23;
        if (r100 == null) goto L21;
        if (r105 == null) goto L19;
        if (r101 < 0) goto L17;
        if (r101 > 100) goto L17;
        if (r102 < 0) goto L15;
        if (r102 > 6) goto L15;
        return nativeEncodeBitmapToWebPWithSpeedAndThreads(r100, r101, r102, r103, r104, r105);
    L15:
        throw new IllegalArgumentException("Speed must be between 0 and 6");
    L17:
        throw new IllegalArgumentException("Quality must be between 0 and 100");
    L19:
        throw new IllegalArgumentException("OutputStream cannot be null");
    L21:
        throw new IllegalArgumentException("Bitmap cannot be null");
    L23:
        throw new RuntimeException("WebPEncoder not available");
    }
}
