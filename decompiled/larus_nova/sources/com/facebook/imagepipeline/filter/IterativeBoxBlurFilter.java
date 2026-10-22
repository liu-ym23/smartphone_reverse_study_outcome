package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes23.dex */
public abstract class IterativeBoxBlurFilter {
    private static final String TAG = "IterativeBoxBlurFilter";

    public IterativeBoxBlurFilter() {
    }

    private static int bound(int r100, int r101, int r102) {
        if (r100 < r101) goto L7;
        if (r100 > r102) goto L6;
        return r100;
    L6:
        return r102;
    L7:
        return r101;
    }

    public static void boxBlurBitmapInPlace(Bitmap r100, int r101, int r102) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkArgument(r100.isMutable());
        if (r100.getHeight() > BitmapUtil.MAX_BITMAP_SIZE) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r100.getWidth() > BitmapUtil.MAX_BITMAP_SIZE) goto L9;
        boolean r104 = true;
    L10:
        Preconditions.checkArgument(r104);
        if (r102 > 0) goto L13;
    L15:
        boolean r105 = false;
    L16:
        Preconditions.checkArgument(r105);
        if (r101 <= 0) goto L19;
        boolean r106 = true;
    L20:
        Preconditions.checkArgument(r106);
        fastBoxBlur(r100, r101, r102);     // Catch: OutOfMemoryError -> L23
        return;
    L23:
        e = move-exception;
        FLog.e(TAG, String.format(null, "OOM: %d iterations on %dx%d with %d radius", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100.getWidth()), Integer.valueOf(r100.getHeight()), Integer.valueOf(r102)}));
        throw e;
    L19:
        r106 = false;
        goto L20
    L13:
        if (r102 > 25) goto L15;
        r105 = true;
        goto L16
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    private static void fastBoxBlur(Bitmap r110, int r111, int r112) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        int[] r113 = new int[r100 * r101];
        r110.getPixels(r113, 0, r100, 0, 0, r100, r101);
        int r102 = r112 + 1;
        int r103 = r102 + r112;
        int[] r114 = new int[r103 * 256];
        int r104 = 1;
    L3:
        int r115 = 0;
        if (r104 > 255) goto L8;
    L5:
        if (r115 >= r103) goto L7;
        r114[r102] = r104;
        r102 = r102 + 1;
        r115 = r115 + 1;
        goto L5
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        int[] r116 = new int[Math.max(r100, r101)];
        int r117 = 0;
    L9:
        if (r117 >= r111) goto L20;
        int r105 = 0;
    L11:
        if (r105 >= r101) goto L13;
        internalHorizontalBlur(r113, r116, r100, r105, r103, r114);
        System.arraycopy(r116, 0, r113, r105 * r100, r100);
        r105 = r105 + 1;
        goto L11
    L13:
        int r106 = 0;
    L14:
        if (r106 >= r100) goto L19;
        int r118 = r106;
        internalVerticalBlur(r113, r116, r100, r101, r106, r103, r114);
        int r107 = r118;
        int r108 = 0;
    L16:
        if (r108 >= r101) goto L18;
        r113[r107] = r116[r108];
        r107 = r107 + r100;
        r108 = r108 + 1;
        goto L16
    L18:
        r106 = r118 + 1;
        goto L14
    L19:
        r117 = r117 + 1;
        goto L9
    L20:
        r110.setPixels(r113, 0, r100, 0, 0, r100, r101);
    }

    private static void internalHorizontalBlur(int[] r110, int[] r111, int r112, int r113, int r114, int[] r115) {
        int r100 = r112 * r113;
        int r116 = ((r113 + 1) * r112) - 1;
        int r101 = r114 >> 1;
        int r102 = -r101;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r102 >= (r112 + r101)) goto L9;
        int r107 = r110[bound(r100 + r102, r100, r116)];
        r103 = r103 + ((r107 >> 16) & 255);
        r104 = r104 + ((r107 >> 8) & 255);
        r105 = r105 + (r107 & 255);
        r106 = r106 + (r107 >>> 24);
        if (r102 < r101) goto L8;
        r111[r102 - r101] = (((r115[r106] << 24) | (r115[r103] << 16)) | (r115[r104] << 8)) | r115[r105];
        int r108 = r110[bound((r102 - (r114 - 1)) + r100, r100, r116)];
        r103 = r103 - ((r108 >> 16) & 255);
        r104 = r104 - ((r108 >> 8) & 255);
        r105 = r105 - (r108 & 255);
        r106 = r106 - (r108 >>> 24);
    L8:
        r102 = r102 + 1;
        goto L4
    }

    private static void internalVerticalBlur(int[] r100, int[] r110, int r111, int r112, int r113, int r114, int[] r115) {
        int r116 = ((r112 - 1) * r111) + r113;
        int r101 = (r114 >> 1) * r111;
        int r117 = (r114 - 1) * r111;
        int r102 = r113 - r101;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r102 > (r116 + r101)) goto L9;
        int r108 = r100[bound(r102, r113, r116)];
        r103 = r103 + ((r108 >> 16) & 255);
        r104 = r104 + ((r108 >> 8) & 255);
        r105 = r105 + (r108 & 255);
        r106 = r106 + (r108 >>> 24);
        if ((r102 - r101) < r113) goto L8;
        r110[r107] = (((r115[r106] << 24) | (r115[r103] << 16)) | (r115[r104] << 8)) | r115[r105];
        r107 = r107 + 1;
        int r109 = r100[bound(r102 - r117, r113, r116)];
        r103 = r103 - ((r109 >> 16) & 255);
        r104 = r104 - ((r109 >> 8) & 255);
        r105 = r105 - (r109 & 255);
        r106 = r106 - (r109 >>> 24);
    L8:
        r102 = r102 + r111;
        goto L4
    }
}
