package l95;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static Bitmap a(Bitmap r6, b r7, int r8) {
        Matrix r0 = new Matrix();
        switch(r8) {
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
        r0.setRotate(-90.0f);
        goto L13
    L6:
        r0.setRotate(-90.0f);
        r0.postScale(-1.0f, 1.0f);
        goto L13
    L7:
        r0.setRotate(90.0f);
        goto L13
    L8:
        r0.setRotate(90.0f);
        r0.postScale(-1.0f, 1.0f);
        goto L13
    L9:
        r0.setRotate(180.0f);
        r0.postScale(-1.0f, 1.0f);
        goto L13
    L10:
        r0.setRotate(180.0f);
        goto L13
    L11:
        r0.setScale(-1.0f, 1.0f);
    L13:
        if (r0.isIdentity() == false) goto L15;
        return r6;
    L15:
        RectF r9 = new RectF(0.0f, 0.0f, r6.getWidth(), r6.getHeight());
        r0.mapRect(r9);
        int r1 = Math.round(r9.width());
        int r2 = Math.round(r9.height());
        if (r6.getConfig() == null) goto L18;
        Bitmap.Config r3 = r6.getConfig();
    L19:
        Bitmap r10 = r7.get(r1, r2, r3);
        if (r10 != null) goto L22;
        r10 = Bitmap.createBitmap(r1, r2, r3);
    L22:
        r0.postTranslate(-r9.left, -r9.top);
        new Canvas(r10).drawBitmap(r6, r0, new Paint(6));
        return r10;
    L18:
        r3 = Bitmap.Config.ARGB_8888;
        goto L19
    }
}
