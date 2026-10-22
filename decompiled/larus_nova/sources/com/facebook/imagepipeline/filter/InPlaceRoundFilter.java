package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes23.dex */
public final class InPlaceRoundFilter {
    private InPlaceRoundFilter() {
    }

    public static void roundBitmapInPlace(Bitmap r210) {
        Preconditions.checkNotNull(r210);
        int r100 = r210.getWidth();
        int r101 = r210.getHeight();
        int r110 = Math.min(r100, r101) / 2;
        int r111 = r100 / 2;
        int r112 = r101 / 2;
        if (r110 != 0) goto L6;
        return;
    L6:
        if (r110 < 1) goto L8;
        boolean r102 = true;
    L9:
        Preconditions.checkArgument(r102);
        if (r100 > 0) goto L12;
    L14:
        boolean r103 = false;
    L15:
        Preconditions.checkArgument(r103);
        if (r101 > 0) goto L18;
    L20:
        boolean r104 = false;
    L21:
        Preconditions.checkArgument(r104);
        if (r111 <= 0) goto L25;
        if (r111 >= r100) goto L25;
        boolean r105 = true;
    L26:
        Preconditions.checkArgument(r105);
        if (r112 <= 0) goto L30;
        if (r112 >= r101) goto L30;
        boolean r106 = true;
    L31:
        Preconditions.checkArgument(r106);
        int[] r113 = new int[r100 * r101];
        r210.getPixels(r113, 0, r100, 0, 0, r100, r101);
        int r107 = r110 - 1;
        int r108 = r111 + r107;
        int r109 = r112 + r107;
        int r114 = r112 - r107;
        if ((r111 - r107) < 0) goto L37;
        if (r114 < 0) goto L37;
        if (r108 >= r100) goto L37;
        if (r109 >= r101) goto L37;
        boolean r115 = true;
    L38:
        Preconditions.checkArgument(r115);
        int r116 = (-r110) * 2;
        int[] r117 = new int[r100];
        int r118 = r116 + 1;
        int r119 = 0;
        int r120 = 1;
        int r121 = 1;
    L39:
        if (r107 < r119) goto L55;
        int r122 = r111 + r107;
        int r123 = r111 - r107;
        int r124 = r111 + r119;
        r110 = r110;
        int r125 = r111 - r119;
        int r126 = r112 + r107;
        int r127 = r112 - r107;
        int r128 = r111;
        int r129 = r112 + r119;
        int r211 = r112 - r119;
        if (r107 < 0) goto L47;
        if (r124 >= r100) goto L47;
        if (r125 < 0) goto L47;
        if (r129 >= r101) goto L47;
        if (r211 < 0) goto L47;
        boolean r212 = true;
    L48:
        Preconditions.checkArgument(r212);
        int r130 = r129 * r100;
        int r213 = r101;
        int r131 = r100 * r211;
        int r214 = r112;
        int r132 = r100 * r126;
        r116 = r116;
        int r133 = r100 * r127;
        int r134 = r120;
        System.arraycopy(r117, 0, r113, r130, r123);
        System.arraycopy(r117, 0, r113, r131, r123);
        System.arraycopy(r117, 0, r113, r132, r125);
        System.arraycopy(r117, 0, r113, r133, r125);
        int r135 = r100 - r122;
        System.arraycopy(r117, 0, r113, r130 + r122, r135);
        System.arraycopy(r117, 0, r113, r131 + r122, r135);
        int r136 = r100 - r124;
        System.arraycopy(r117, 0, r113, r132 + r124, r136);
        System.arraycopy(r117, 0, r113, r133 + r124, r136);
        if (r118 > 0) goto L51;
        r119 = r119 + 1;
        r121 = r121 + 2;
        r118 = r118 + r121;
    L51:
        if (r118 <= 0) goto L53;
        r107 = r107 - 1;
        r120 = r134 + 2;
        r118 = r118 + (r120 + r116);
    L54:
        r111 = r128;
        r112 = r214;
        r101 = r213;
        goto L39
    L53:
        r120 = r134;
    L47:
        r212 = false;
        goto L48
    L55:
        int r215 = r101;
        int r137 = r110;
        int r216 = r112;
        int r138 = r216 - r137;
    L56:
        if (r138 < 0) goto L58;
        System.arraycopy(r117, 0, r113, r138 * r100, r100);
        r138 = r138 - 1;
        goto L56
    L58:
        int r139 = r216 + r137;
    L59:
        if (r139 >= r215) goto L61;
        System.arraycopy(r117, 0, r113, r139 * r100, r100);
        r139 = r139 + 1;
        goto L59
    L61:
        r210.setPixels(r113, 0, r100, 0, 0, r100, r215);
        return;
    L37:
        r115 = false;
    L30:
        r106 = false;
    L25:
        r105 = false;
        goto L26
    L18:
        if (r101 > BitmapUtil.MAX_BITMAP_SIZE) goto L20;
        r104 = true;
        goto L21
    L12:
        if (r100 > BitmapUtil.MAX_BITMAP_SIZE) goto L14;
        r103 = true;
        goto L15
    L8:
        r102 = false;
        goto L9
    }
}
