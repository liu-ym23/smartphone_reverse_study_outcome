package zj6;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final Rect a(View r100, int[] r101) {
        int r102 = r101[0];
        int r103 = r101[1];
        int r104 = r100.getWidth();
        int r105 = r100.getHeight();
        int[] r106 = new int[2];
        r100.getLocationOnScreen(r106);
        int r107 = r106[0];
        int r108 = r106[1];
        Rect r109 = new Rect(r107, r108, r104 + r107, r105 + r108);
        r109.height();
        int r110 = r109.width();
        int[] r111 = {r109.centerX(), r109.centerY()};
        int r112 = r109.left;
        Rect r113 = new Rect();
        int r114 = (int) (r110 * (r103 / r102));
        int r115 = r111[1];
        int r116 = r114 / 2;
        r113.set(r112, r115 - r116, r110 + r112, r115 + r116);
        return r113;
    }
}
