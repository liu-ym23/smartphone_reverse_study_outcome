package nlb;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.LogSafetyTools;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static Bitmap.Config a(g r100) {
        ImageUtils.ImageType r101 = r100.f519581g;
        if (r101 != null) goto L5;
    L10:
        Bitmap.Config r102 = Bitmap.Config.ARGB_8888;
    L11:
        Log.i("LargeImageHelper", "getBitmapConfig, path=" + LogSafetyTools.a(r100.f519575a.getRealPath()) + ", bitmapConfig=" + r102);
        return r102;
    L5:
        if (r101 == ImageUtils.ImageType.TYPE_UNKNOWN) goto L10;
        if (ImageUtils.f(r101) == true) goto L10;
        r102 = null;
        goto L11
    }

    public static int f(View r100) {
        if (ImageWidgetFG.a() == false) goto L17;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        int r102 = DeviceUtils.getScreenHeight(LarkContext.getApplication());
        if (r101 == null) goto L9;
        int r103 = r101.height;
        if (r103 <= 0) goto L9;
        return r103;
    L9:
        int r104 = r100.getMeasuredHeight();
        if (r104 <= 0) goto L14;
        if (r104 <= r102) goto L13;
        Log.w("LargeImageHelper", "View measured height: " + r104 + ", larger than screen height: " + r102);
    L13:
        return r104;
    L14:
        Log.w("LargeImageHelper", "getViewHeight / Use screen height: " + r102);
        return r102;
    L17:
        return DeviceUtils.getScreenHeight(LarkContext.getApplication());
    }

    public static int g(View r100) {
        if (ImageWidgetFG.a() == false) goto L17;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        int r102 = DeviceUtils.getScreenWidth(LarkContext.getApplication());
        if (r101 == null) goto L9;
        int r103 = r101.width;
        if (r103 <= 0) goto L9;
        return r103;
    L9:
        int r104 = r100.getMeasuredWidth();
        if (r104 <= 0) goto L14;
        if (r104 <= r102) goto L13;
        Log.w("LargeImageHelper", "View measured width: " + r104 + ", larger than screen width: " + r102);
    L13:
        return r104;
    L14:
        Log.w("LargeImageHelper", "getViewWidth / Use screen width: " + r102);
        return r102;
    L17:
        return DeviceUtils.getScreenWidth(LarkContext.getApplication());
    }

    public static int[] e(SubsamplingScaleImageView r110, g r111) {
        if (ImageUtils.f(r111.f519581g) == false) goto L20;
        int[] r100 = new int[2];
        int r101 = r111.f519579e;
        int r112 = r111.f519580f;
        if (h(r110, r101, r112) == false) goto L18;
        Pair r102 = new Pair(Integer.valueOf(r101), Integer.valueOf(r112));
        float r113 = Math.max(((Integer) r102.first).intValue(), ((Integer) r102.second).intValue());
        float r103 = Math.min(((Integer) r102.first).intValue(), ((Integer) r102.second).intValue());
        int r104 = g(r110) * 2;
        int r114 = f(r110) * 2;
        float r105 = Math.max(r104, r114);
        float r106 = Math.min(r104, r114);
        if ((r113 * r103) <= (r105 * r106)) goto L14;
        if (r105 <= 0.0f) goto L14;
        if (r106 <= 0.0f) goto L14;
        float r107 = Math.max(Math.max(r113 / r105, r103 / r106), 1.0f);
        r113 = r113 / r107;
        r103 = r103 / r107;
    L14:
        if (((Integer) r102.first).intValue() <= ((Integer) r102.second).intValue()) goto L16;
        Pair r108 = new Pair(Integer.valueOf((int) r113), Integer.valueOf((int) r103));
    L17:
        Log.i("LargeImageHelper", "scaleResolution, from " + r102 + ", to " + r108 + ", max " + new Pair(Integer.valueOf(r104), Integer.valueOf(r114)));
        r100[0] = ((Integer) r108.first).intValue();
        r100[1] = ((Integer) r108.second).intValue();
    L19:
        return r100;
    L16:
        r108 = new Pair(Integer.valueOf((int) r103), Integer.valueOf((int) r113));
        goto L17
    L18:
        r100[0] = r101;
        r100[1] = r112;
        goto L19
    L20:
        int[] r109 = new int[2];
        int r115 = r111.f519579e;
        int r116 = r111.f519580f;
        int r117 = g(r110);
        int r118 = f(r110);
        if (r116 >= r118) goto L24;
        if (r115 >= r117) goto L24;
        r109[0] = r115;
        r109[1] = r116;
    L28:
        int r119 = r109[0];
        if (r119 <= (r117 / 2)) goto L34;
        int r120 = r109[1];
        if (r120 <= (r118 / 4)) goto L34;
        r109[0] = r119 / 2;
        r109[1] = r120 / 2;
    L34:
        if (r109[0] > 0) goto L37;
        r109[0] = r117;
    L37:
        if (r109[1] > 0) goto L39;
        r109[1] = r118;
    L39:
        return r109;
    L24:
        float r121 = r115 / r116;
        float r122 = r118 * r121;
        float r123 = r117;
        if (r122 <= r123) goto L27;
        r109[0] = r117;
        r109[1] = (int) (r123 / r121);
        goto L28
    L27:
        r109[1] = r118;
        r109[0] = (int) r122;
        goto L28
    }

    public static boolean h(View r100, int r101, int r102) {
        if ((((long) r101) * ((long) r102)) <= ((((long) g(r100)) * 4) * ((long) f(r100)))) goto L5;
    L8:
        boolean r103 = true;
    L9:
        Log.i("LargeImageHelper", "isTooLargeImage:" + r103);
        return r103;
    L5:
        if (Math.max(r101, r102) >= 4096) goto L8;
        r103 = false;
        goto L9
    }

    public static void i(SubsamplingScaleImageView r100, g r101, Bitmap r102) {
        Uri r103 = Uri.fromFile(r101.f519575a.toFile());
        if (r103 == null) goto L20;
        qlb.a r104 = new qlb.a(r103);
        int r105 = r101.f519579e;
        int r106 = r101.f519580f;
        r104.f533830e = r105;
        r104.f533831f = r106;
        Rect r107 = r104.f533832g;
        if (r107 == null) goto L7;
        r104.f533829d = true;
        r104.f533830e = r107.width();
        r104.f533831f = r104.f533832g.height();
    L7:
        r104.f533829d = h(r100, r101.f519579e, r101.f519580f);
        com.ss.android.lark.imagewidget.largeimage.transform.b r108 = r101.f519578d;
        if (r108 == null) goto L12;
        Rect r109 = r108.f426682a;
        if (r109 == null) goto L12;
        r104.f533832g = r109;
        r104.f533829d = true;
        r104.f533830e = r109.width();
        r104.f533831f = r104.f533832g.height();
    L12:
        if (r102 == null) goto L17;
        qlb.a r110 = qlb.a.a(r102);
        if (ImageUtils.f(r101.f519581g) == false) goto L16;
        Log.i("LargeImageHelper", "heif only show preview source");
        r100.setImage(r110);
        return;
    L16:
        r100.K(r104, r110);
        return;
    L17:
        r100.setImage(r104);
        return;
    L20:
        throw new NullPointerException("Uri must not be null");
    }

    public static float b(int r100, int r101, int r102, int r103) {
        float r104 = d(r100, r101, r102, r103);
        if (r102 < r100) goto L7;
        if (r103 < r101) goto L7;
        float r105 = 1.0f;
    L9:
        return r104 * Math.max(r105, 2.5f);
    L7:
        r105 = Math.max(r100 / r102, r101 / r103);
        goto L9
    }

    public static float c(int r100, int r101, int r102, int r103) {
        if (r100 == 0) goto L13;
        if (r101 == 0) goto L13;
        if (r102 < r100) goto L12;
        if (r103 < r101) goto L12;
        return Math.max(Math.max(r102 / r100, r103 / r101), b(r100, r101, r102, r103) * 2.0f);
    L12:
        return b(r100, r101, r102, r103) + 2.0f;
    L13:
        return 2.0f;
    }

    public static float d(int r100, int r101, int r102, int r103) {
        Log.i("LargeImageHelper", "getMinScale, newW:" + r100 + ",newH:" + r101 + ",bitmapW:" + r102 + ",bitmapH:" + r103);
        if (r100 <= 0) goto L13;
        if (r101 <= 0) goto L13;
        if (r102 <= 0) goto L13;
        if (r103 <= 0) goto L13;
        float r104 = (r100 * 1.0f) / r102;
        float r105 = (r101 * 1.0f) / r103;
        if ((r103 / r102) <= 3) goto L12;
        return Math.max(r104, r105);
    L12:
        return Math.min(r104, r105);
    L13:
        return 1.0f;
    }
}
