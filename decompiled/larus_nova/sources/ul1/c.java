package ul1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static int a(float r100, float r101) {
        int r102 = Math.round(r100 * 1000000.0f);
        int r103 = Math.round(r101 * 1000000.0f);
        if (r102 <= r103) goto L6;
        return 1;
    L6:
        if (r102 >= r103) goto L9;
        return -1;
    L9:
        return 0;
    }

    public static int b(Context r100, float r101) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (a(0.0f, r101) == 0) goto L10;
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    L10:
        return 0;
    }

    public static Rect e(String r100, float r101) {
        Paint r102 = new Paint();
        Rect r103 = new Rect();
        r102.setTextSize(r101);
        r102.getTextBounds(r100, 0, r100.length(), r103);
        r102.reset();
        return r103;
    }

    public static Bitmap c(int r100, int r110, Drawable r111) {
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if ((r111 instanceof BitmapDrawable) == false) goto L11;
        Bitmap r101 = ((BitmapDrawable) r111).getBitmap();     // Catch: Exception -> L13
        if (r101 == null) goto L11;
        if (r101.getHeight() <= 0) goto L11;
        Matrix r102 = new Matrix();     // Catch: Exception -> L13
        r102.postScale((r100 * 1.0f) / r101.getWidth(), (r110 * 1.0f) / r101.getHeight());     // Catch: Exception -> L13
        return Bitmap.createBitmap(r101, 0, 0, r101.getWidth(), r101.getHeight(), r102, true);
    L11:
        Bitmap r103 = Bitmap.createBitmap(r100, r110, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L13
        Canvas r104 = new Canvas(r103);     // Catch: Exception -> L13
        r111.setBounds(0, 0, r104.getWidth(), r104.getHeight());     // Catch: Exception -> L13
        r111.draw(r104);     // Catch: Exception -> L13
        return r103;
    }

    public static Bitmap d(Context r100, int r101, int r102, int r103) {
        if (r100 == null) goto L10;
        if (r101 <= 0) goto L10;
        if (r102 <= 0) goto L10;
        if (r103 == 0) goto L10;
        return c(r101, r102, r100.getResources().getDrawable(r103, null));
    L10:
        return null;
    }
}
