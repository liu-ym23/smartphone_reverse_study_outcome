package com.facebook.imageutils;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public class JfifUtil {
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;

    private static boolean isSOFn(int r100) {
        switch(r100) {
            case 192: goto L5;
            case 193: goto L5;
            case 194: goto L5;
            case 195: goto L5;
            case 196: goto L3;
            case 197: goto L5;
            case 198: goto L5;
            case 199: goto L5;
            case 200: goto L3;
            case 201: goto L5;
            case 202: goto L5;
            case 203: goto L5;
            case 204: goto L3;
            case 205: goto L5;
            case 206: goto L5;
            case 207: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public static int transformStandarExifOrientationForAvif(int r100) {
        if (r100 == 0) goto L15;
        if (r100 != 1) goto L6;
        return 8;
    L6:
        if (r100 == 2) goto L12;
        if (r100 == 3) goto L10;
        return 0;
    L10:
        return 6;
    L12:
        return 3;
    L15:
        return 1;
    }

    private JfifUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int r100) {
        return TiffUtil.getAutoRotateAngleFromOrientation(r100);
    }

    public static int getExifOrientationFromAutoRotateAngle(int r100) {
        return TiffUtil.getExifOrientationFromAutoRotateAngle(r100);
    }

    public static int getOrientation(InputStream r100) {
        int r101 = moveToAPP1EXIF(r100);     // Catch: IOException -> L8
        if (r101 != 0) goto L6;
        return 0;
    L6:
        return TiffUtil.readOrientationFromTIFF(r100, r101);
    L8:
        return 0;
    }

    private static int moveToAPP1EXIF(InputStream r100) throws IOException {
        if (moveToMarker(r100, 225) == false) goto L10;
        int r101 = StreamProcessor.readPackedInt(r100, 2, false) - 2;
        if (r101 <= 6) goto L10;
        int r102 = StreamProcessor.readPackedInt(r100, 4, false);
        int r103 = StreamProcessor.readPackedInt(r100, 2, false);
        int r104 = (r101 - 4) - 2;
        if (r102 != 1165519206) goto L10;
        if (r103 != 0) goto L10;
        return r104;
    L10:
        return 0;
    }

    public static int transformFromClockWiseToAntiClockWise(int r100) {
        return Math.abs(360 - r100) % 360;
    }

    public static int getOrientation(byte[] r100) {
        return getOrientation(new ByteArrayInputStream(r100));
    }

    public static boolean moveToMarker(InputStream r100, int r101) throws IOException {
        Preconditions.checkNotNull(r100);
    L4:
        if (StreamProcessor.readPackedInt(r100, 1, false) != 255) goto L25;
        int r102 = 255;
    L6:
        if (r102 != 255) goto L9;
        r102 = StreamProcessor.readPackedInt(r100, 1, false);
        goto L6
    L9:
        if (r101 == 192) goto L11;
    L13:
        if (r102 == r101) goto L14;
        if (r102 == 216) goto L4;
        if (r102 == 1) goto L4;
        if (r102 == 217) goto L25;
        if (r102 == 218) goto L25;
        r100.skip(StreamProcessor.readPackedInt(r100, 2, false) - 2);
        goto L4
    L14:
        return true;
    L11:
        if (isSOFn(r102) == false) goto L13;
        return true;
    L25:
        return false;
    }
}
