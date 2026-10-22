package com.ss.android.ttve.nativePort;

import android.graphics.Bitmap;
import com.ss.android.medialib.camera.ImageFrame;

/* JADX INFO: loaded from: classes38.dex */
public class TEJpegUtils {
    public TEJpegUtils() {
    }

    public static native void compressToJPEG(Bitmap r100, int r101, String r102);

    public static native void compressToJPEG2(byte[] r100, int r101, int r102, int r103, String r104);

    public static native ImageFrame decompressJPEG(String r100, int r101);

    static {
        TECodecNativeLibsLoader.d();
    }

    public static int calBestSampleSize(int r100, int r101, int r102, int r103) {
        if (r100 <= 0) goto L13;
        if (r101 <= 0) goto L15;
        if (r102 <= 0) goto L16;
        if (r103 <= 0) goto L17;
        if (r102 <= r103) goto L9;
        r103 = r102;
        r102 = r103;
    L9:
        if (r100 <= r101) goto L12;
        int r104 = r103;
        r103 = r102;
        r102 = r104;
    L12:
        return Math.max((int) Math.ceil(r100 / r102), (int) Math.ceil(r101 / r103));
    L17:
        return -1;
    L16:
        return -1;
    L15:
        return -1;
    L13:
        return -1;
    }

    public static int calBestSampleSize2(int r100, int r101, int r102, int r103) {
        if (r100 <= 0) goto L17;
        if (r101 <= 0) goto L17;
        if (r102 <= 0) goto L17;
        if (r103 <= 0) goto L17;
        if (r102 <= r103) goto L10;
        r103 = r102;
        r102 = r103;
    L10:
        if (r100 <= r101) goto L12;
        int r104 = r103;
        r103 = r102;
        r102 = r104;
    L12:
        int r105 = Math.max((int) Math.floor(r100 / r102), (int) Math.floor(r101 / r103));
        if (r105 >= 2) goto L16;
        return -1;
    L16:
        return (int) Math.pow(2.0d, (int) Math.floor(Math.log(r105) / Math.log(2.0d)));
    L17:
        return -1;
    }
}
