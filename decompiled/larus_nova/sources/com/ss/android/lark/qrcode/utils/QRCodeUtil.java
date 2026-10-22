package com.ss.android.lark.qrcode.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.lark.biz.core.api.ErrorCorrectionLevel;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;
import com.ss.android.lark.qrcode.zxing.EncodeHintType;
import d2c.b;
import f2c.a;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes37.dex */
public class QRCodeUtil {
    public QRCodeUtil() {
    }

    public static Point getScreenResolution(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r102 = new Point();
        r101.getSize(r102);
        return r102;
    }

    private static b updateBitMatrix(b r110, int r111) {
        int r100 = r111 * 2;
        int r101 = r110.f466581a;
        int r102 = r110.f466582b;
        int r103 = -1;
        int r104 = -1;
        int r105 = 0;
    L4:
        if (r105 >= r110.f466582b) goto L35;
        int r106 = 0;
    L6:
        int r107 = r110.f466583c;
        if (r106 >= r107) goto L33;
        int r108 = r110.f466584d[(r107 * r105) + r106];
        if (r108 == 0) goto L32;
        if (r105 >= r102) goto L12;
        r102 = r105;
    L12:
        if (r105 <= r104) goto L14;
        r104 = r105;
    L14:
        int r109 = r106 * 32;
        if (r109 >= r101) goto L24;
        int r112 = 0;
    L18:
        if ((r108 << (31 - r112)) != 0) goto L20;
        r112 = r112 + 1;
        goto L18
    L20:
        int r113 = r112 + r109;
        if (r113 >= r101) goto L24;
        r101 = r113;
    L24:
        if ((r109 + 31) <= r103) goto L32;
        int r114 = 31;
    L27:
        if ((r108 >>> r114) != 0) goto L29;
        r114 = r114 - 1;
        goto L27
    L29:
        int r115 = r109 + r114;
        if (r115 <= r103) goto L32;
        r103 = r115;
    L32:
        r106 = r106 + 1;
        goto L6
    L33:
        r105 = r105 + 1;
        goto L4
    L35:
        if (r103 < r101) goto L39;
        if (r104 < r102) goto L39;
        int[] r116 = {r101, r102, (r103 - r101) + 1, (r104 - r102) + 1};
    L40:
        int r117 = r116[2] + r100;
        int r118 = r116[3] + r100;
        b r119 = new b(r117, r118);
        int r120 = r119.f466584d.length;
        int r121 = 0;
    L41:
        if (r121 >= r120) goto L43;
        r119.f466584d[r121] = 0;
        r121 = r121 + 1;
        goto L41
    L43:
        int r122 = r111;
    L45:
        if (r122 >= (r117 - r111)) goto L54;
        int r123 = r111;
    L48:
        if (r123 >= (r118 - r111)) goto L53;
        if (r110.a((r122 - r111) + r116[0], (r123 - r111) + r116[1]) == false) goto L52;
        int r124 = (r119.f466583c * r123) + (r122 / 32);
        int[] r125 = r119.f466584d;
        r125[r124] = r125[r124] | (1 << (r122 & 31));
    L52:
        r123 = r123 + 1;
        goto L48
    L53:
        r122 = r122 + 1;
        goto L45
    L54:
        return r119;
    L39:
        r116 = null;
        goto L40
    }

    private static Bitmap createBitmap(int r100, int r110, int[] r111) {
        Bitmap r101 = Bitmap.createBitmap(r100, r110, Bitmap.Config.ARGB_8888);
        r101.setPixels(r111, 0, r100, 0, 0, r100, r110);
        return r101;
    }

    private static Bitmap parseBitmapFromBitMatrix(b r100, int r110, int r111) {
        int r101 = r100.f466581a;
        int r102 = r100.f466582b;
        int[] r103 = new int[r101 * r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L13;
        int r105 = r104 * r101;
        int r106 = 0;
    L5:
        if (r106 >= r101) goto L11;
        int r107 = r105 + r106;
        if (r100.a(r106, r104) == false) goto L9;
        int r108 = r110;
    L10:
        r103[r107] = r108;
        r106 = r106 + 1;
        goto L5
    L9:
        r108 = r111;
        goto L10
    L11:
        r104 = r104 + 1;
        goto L3
    L13:
        return createBitmap(r101, r102, r103);
    }

    public static Bitmap encode(String r100, int r101, int r102, int r103) {
        return encode(r100, r101, r102, r103, ErrorCorrectionLevel.L);
    }

    public static Bitmap encode(String r100, int r101, int r102, int r103, ErrorCorrectionLevel r104) {
        EnumMap r105 = new EnumMap(EncodeHintType.class);
        r105.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        r105.put(EncodeHintType.ERROR_CORRECTION, r104);
        return parseBitmapFromBitMatrix(updateBitMatrix(a.a(r100, BarcodeFormat.QR_CODE, r101, r102, r105), r103), -16777216, -1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
