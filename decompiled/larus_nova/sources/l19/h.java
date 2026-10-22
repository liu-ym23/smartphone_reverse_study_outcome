package l19;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final Rect a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        if ((r110 instanceof GenericDraweeView) == false) goto L5;
        GenericDraweeView r100 = (GenericDraweeView) r110;
    L7:
        if (r100 == null) goto L11;
        GenericDraweeHierarchy r101 = r100.getHierarchy();
        if (r101 == null) goto L11;
        RectF r102 = new RectF();
        r101.getActualImageBounds(r102);
        int r103 = (int) r102.width();
        int r104 = (int) r102.height();
    L12:
        if (r104 == 0) goto L14;
        if (r103 == 0) goto L14;
    L15:
        int[] r105 = {r103, r104};
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r105, "photoWidthHeight");
        int r106 = r105[0];
        int r107 = r105[1];
        Intrinsics.checkNotNullParameter(r110, "view");
        int[] r108 = new int[2];
        int r109 = r110.getWidth();
        int r111 = r110.getHeight();
        r110.getLocationOnScreen(r108);
        int[] r112 = {r108[0] + (r109 / 2), r108[1] + (r111 / 2)};
        Rect r113 = new Rect();
        float r114 = r106;
        float r115 = r107;
        float r116 = r114 / r115;
        float r117 = r109;
        float r118 = r111;
        if ((r117 / r118) >= r116) goto L18;
        int r119 = r112[0];
        int r120 = ((int) (r118 * r116)) / 2;
        int r121 = r108[1];
        r113.set(r119 - r120, r121, r119 + r120, r111 + r121);
    L19:
        return r113;
    L18:
        int r122 = r108[0];
        int r123 = r112[1];
        int r124 = ((int) (r117 * (r115 / r114))) / 2;
        r113.set(r122, r123 - r124, r109 + r122, r123 + r124);
    L14:
        r103 = r110.getWidth();
        r104 = r110.getHeight();
    L11:
        r103 = 0;
        r104 = 0;
        goto L12
    L5:
        r100 = null;
        goto L7
    }
}
