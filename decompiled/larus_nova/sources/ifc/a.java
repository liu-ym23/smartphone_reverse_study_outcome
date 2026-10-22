package ifc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static Bitmap b(Bitmap r100) {
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        if (r101 != r102) goto L5;
        return r100;
    L5:
        int r103 = Math.min(r101, r102);
        return Bitmap.createBitmap(r100, (r101 - r103) / 2, (r102 - r103) / 2, r103, r103);
    }

    public static Bitmap a(Bitmap r100, float r101) {
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        Rect r105 = new Rect(0, 0, r100.getWidth(), r100.getHeight());
        RectF r106 = new RectF(r105);
        r103.drawARGB(0, 0, 0, 0);
        r103.drawRoundRect(r106, r101, r101, r104);
        r104.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r100, r105, r105, r104);
        return r102;
    }

    public static Bitmap c(Bitmap r100, int r101, float r102) {
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        if (r103 > r101) goto L7;
        if (r104 > r101) goto L7;
        Bitmap r105 = r100;
    L8:
        Bitmap r106 = Bitmap.createBitmap(r103, r104, Bitmap.Config.ARGB_8888);
        Canvas r107 = new Canvas(r106);
        Paint r108 = new Paint(1);
        r107.drawRoundRect(new RectF(0.0f, 0.0f, r103, r104), r102, r102, r108);
        r108.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r107.drawBitmap(r105, 0.0f, 0.0f, r108);
        r100.recycle();
        r105.recycle();
        return r106;
    L7:
        float r109 = r101 / Math.max(r103, r104);
        r105 = Bitmap.createScaledBitmap(r100, (int) (r103 * r109), (int) (r104 * r109), true);
        r103 = r105.getWidth();
        r104 = r105.getHeight();
        goto L8
    }

    public static Bitmap d(Bitmap r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        Matrix r105 = new Matrix();
        r105.postScale(r101 / r103, r102 / r104);
        return Bitmap.createBitmap(r100, 0, 0, r103, r104, r105, true);
    }
}
