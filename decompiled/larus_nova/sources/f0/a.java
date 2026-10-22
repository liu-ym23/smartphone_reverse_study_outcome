package f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static Bitmap a(Bitmap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Matrix r101 = new Matrix();
        r101.setRotate(90, r100.getWidth() / 2.0f, r100.getHeight() / 2.0f);
        float r102 = r100.getHeight();
        float[] r103 = new float[9];
        r101.getValues(r103);
        r101.postTranslate(r102 - r103[2], 0.0f - r103[5]);
        Bitmap r104 = Bitmap.createBitmap(r100.getHeight(), r100.getWidth(), Bitmap.Config.ARGB_8888);
        new Canvas(r104).drawBitmap(r100, r101, new Paint());
        return r104;
    }

    public static float b(MotionEvent r100) {
        float r101 = r100.getX(0) - r100.getX(1);
        float r102 = r100.getY(0) - r100.getY(1);
        return (float) Math.sqrt((r101 * r101) + (r102 * r102));
    }

    public static Point e(Context r100) {
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r102 = new Point();
        r101.getSize(r102);
        return r102;
    }

    public static boolean f(Context r100) {
        Point r101 = e(r100);
        if (r101.y <= r101.x) goto L5;
        return true;
    L5:
        return false;
    }

    public static void h(Rect r100) {
        r100.centerX();
        r100.centerY();
        r100.width();
        r100.height();
        int r101 = r100.width() / 2;
        int r102 = r100.height() / 2;
    }

    public static int d(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static Bitmap g(Bitmap r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), r100.getConfig());
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        r104.setColorFilter(new PorterDuffColorFilter(r101, PorterDuff.Mode.SRC_IN));
        r103.drawBitmap(r100, 0.0f, 0.0f, r104);
        return r102;
    }

    public static Rect c(float r100, float r101, float r102, int r103, int r104, int r105, int r106) {
        int r107 = (int) ((r103 * r100) / 2.0f);
        int r108 = (int) ((r104 * r100) / 2.0f);
        int r109 = (int) (((r101 / r105) * 2000.0f) - 1000.0f);
        int r110 = (int) (((r102 / r106) * 2000.0f) - 1000.0f);
        RectF r111 = new RectF(Math.min(Math.max(r109 - r107, -1000), 1000), Math.min(Math.max(r110 - r108, -1000), 1000), Math.min(Math.max(r109 + r107, -1000), 1000), Math.min(Math.max(r110 + r108, -1000), 1000));
        return new Rect(Math.round(r111.left), Math.round(r111.top), Math.round(r111.right), Math.round(r111.bottom));
    }
}
