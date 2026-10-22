package l95;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static Bitmap a(Bitmap r100, b r101, int r102) {
        Matrix r103 = new Matrix();
        switch(r102) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L13;
        };
    L5:
        r103.setRotate(-90.0f);
        goto L13
    L6:
        r103.setRotate(-90.0f);
        r103.postScale(-1.0f, 1.0f);
        goto L13
    L7:
        r103.setRotate(90.0f);
        goto L13
    L8:
        r103.setRotate(90.0f);
        r103.postScale(-1.0f, 1.0f);
        goto L13
    L9:
        r103.setRotate(180.0f);
        r103.postScale(-1.0f, 1.0f);
        goto L13
    L10:
        r103.setRotate(180.0f);
        goto L13
    L11:
        r103.setScale(-1.0f, 1.0f);
    L13:
        if (r103.isIdentity() == false) goto L15;
        return r100;
    L15:
        RectF r104 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        r103.mapRect(r104);
        int r105 = Math.round(r104.width());
        int r106 = Math.round(r104.height());
        if (r100.getConfig() == null) goto L18;
        Bitmap.Config r107 = r100.getConfig();
    L19:
        Bitmap r108 = r101.get(r105, r106, r107);
        if (r108 != null) goto L22;
        r108 = Bitmap.createBitmap(r105, r106, r107);
    L22:
        r103.postTranslate(-r104.left, -r104.top);
        new Canvas(r108).drawBitmap(r100, r103, new Paint(6));
        return r108;
    L18:
        r107 = Bitmap.Config.ARGB_8888;
        goto L19
    }
}
