package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
class TiffUtil {
    private static final Class<?> TAG = null;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    /* JADX INFO: renamed from: com.facebook.imageutils.TiffUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class TiffHeader {
        int byteOrder;
        int firstIfdOffset;
        boolean isLittleEndian;

        private TiffHeader() {
        }

        public /* synthetic */ TiffHeader(AnonymousClass1 r100) {
            this();
        }
    }

    public TiffUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int r100) {
        if (r100 != 3) goto L5;
        return 180;
    L5:
        if (r100 != 6) goto L7;
        return 90;
    L7:
        if (r100 == 8) goto L10;
        return 0;
    L10:
        return 270;
    }

    public static int getExifOrientationFromAutoRotateAngle(int r100) {
        if (r100 != 0) goto L4;
        return 1;
    L4:
        if (r100 != 90) goto L6;
        return 6;
    L6:
        if (r100 != 180) goto L8;
        return 3;
    L8:
        if (r100 == 270) goto L11;
        return 0;
    L11:
        return 8;
    }

    static {
        TAG = TiffUtil.class;
    }

    public static int readOrientationFromTIFF(InputStream r100, int r101) throws IOException {
        TiffHeader r102 = new TiffHeader(null);
        int r103 = readTiffHeader(r100, r101, r102);
        int r104 = r102.firstIfdOffset - 8;
        if (r103 == 0) goto L8;
        if (r104 > r103) goto L10;
        r100.skip(r104);
        return getOrientationFromTiffEntry(r100, moveToTiffEntryWithTag(r100, r103 - r104, r102.isLittleEndian, 274), r102.isLittleEndian);
    L10:
        return 0;
    L8:
        return 0;
    }

    private static int getOrientationFromTiffEntry(InputStream r100, int r101, boolean r102) throws IOException {
        if (r101 >= 10) goto L6;
        return 0;
    L6:
        if (StreamProcessor.readPackedInt(r100, 2, r102) == 3) goto L9;
        return 0;
    L9:
        if (StreamProcessor.readPackedInt(r100, 4, r102) == 1) goto L11;
        return 0;
    L11:
        int r103 = StreamProcessor.readPackedInt(r100, 2, r102);
        StreamProcessor.readPackedInt(r100, 2, r102);
        return r103;
    }

    private static int readTiffHeader(InputStream r100, int r101, TiffHeader r102) throws IOException {
        if (r101 > 8) goto L5;
        return 0;
    L5:
        int r103 = StreamProcessor.readPackedInt(r100, 4, false);
        r102.byteOrder = r103;
        int r104 = r101 - 4;
        if (r103 != 1229531648) goto L8;
    L11:
        if (r103 != 1229531648) goto L13;
        boolean r105 = true;
    L14:
        r102.isLittleEndian = r105;
        int r106 = StreamProcessor.readPackedInt(r100, 4, r105);
        r102.firstIfdOffset = r106;
        int r107 = r104 - 4;
        if (r106 >= 8) goto L17;
    L20:
        FLog.e(TAG, "Invalid offset");
        return 0;
    L17:
        if ((r106 - 8) > r107) goto L20;
        return r107;
    L13:
        r105 = false;
        goto L14
    L8:
        if (r103 == 1296891946) goto L11;
        FLog.e(TAG, "Invalid TIFF header");
        return 0;
    }

    private static int moveToTiffEntryWithTag(InputStream r100, int r101, boolean r102, int r103) throws IOException {
        if (r101 >= 14) goto L5;
        return 0;
    L5:
        int r104 = StreamProcessor.readPackedInt(r100, 2, r102);
        int r105 = r101 - 2;
    L6:
        int r106 = r104 - 1;
        if (r104 <= 0) goto L14;
        if (r105 < 12) goto L14;
        int r107 = r105 - 2;
        if (StreamProcessor.readPackedInt(r100, 2, r102) == r103) goto L12;
        r100.skip(10);
        r105 = r107 - 10;
        r104 = r106;
        goto L6
    L12:
        return r107;
    L14:
        return 0;
    }
}
