package tfc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes38.dex */
public final class g {
    public static Bitmap a(Bitmap r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        Bitmap r102 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        int r104 = 45;
        float r105 = 45;
        int r106 = (int) Math.ceil(r100 / r105);
        int r107 = (int) Math.ceil(r101 / r105);
        Paint r108 = new Paint();
        r108.setAntiAlias(true);
        int r111 = 0;
    L7:
        if (r111 >= r106) goto L34;
        int r112 = r104 * r111;
        int r113 = 0;
    L9:
        if (r113 >= r107) goto L33;
        int r114 = r104 * r113;
        int r115 = r112 + 45;
        if (r115 < r100) goto L13;
        r115 = r100 - 1;
    L13:
        int r116 = r114 + 45;
        if (r116 < r101) goto L16;
        r116 = r101 - 1;
    L16:
        int r109 = r110.getWidth();
        if (r112 <= 0) goto L23;
        if (r112 < r109) goto L24;
        int r117 = r109 - 1;
        if (r117 < 0) goto L23;
        r112 = r117;
    L24:
        int r118 = r110.getHeight();
        if (r114 <= 0) goto L31;
        if (r114 < r118) goto L32;
        r114 = r118 - 1;
        if (r114 < 0) goto L31;
    L32:
        int r119 = r110.getPixel(r112, r114);
        Rect r120 = new Rect(r112, r114, r115, r116);
        r108.setColor(r119);
        r103.drawRect(r120, r108);
        r113 = r113 + 1;
        r104 = 45;
    L31:
        r114 = 0;
    L23:
        r112 = 0;
        goto L24
    L33:
        r111 = r111 + 1;
        r104 = 45;
        goto L7
    L34:
        r103.save();
        return r102;
    }
}
