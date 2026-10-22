package uz2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f552181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Bitmap f552182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f552183c = 0.0f;

    public static final class a {
    }

    static {
        f552181a = Bitmap.Config.ARGB_8888;
        f552183c = 0.1f;
    }

    public static b a(View r100) throws Exception, Error {
        Intrinsics.checkNotNullParameter(r100, "view");
        b r101 = new b();
        float r102 = r100.getWidth();
        float r103 = f552183c;
        int r104 = (int) ((r102 * r103) + 0.5f);
        int r105 = (int) ((r100.getHeight() * r103) + 0.5f);
        if (r104 <= 0) goto L5;
        if (r105 <= 0) goto L5;
    L6:
        Bitmap r106 = f552182b;
        if (r106 == null) goto L15;
        Intrinsics.checkNotNull(r106);
        if (r106.isRecycled() == true) goto L15;
        Bitmap r107 = f552182b;
        Intrinsics.checkNotNull(r107);
        if (r107.getWidth() != r104) goto L15;
        Bitmap r108 = f552182b;
        Intrinsics.checkNotNull(r108);
        if (r108.getHeight() != r105) goto L15;
        Bitmap r109 = f552182b;
        boolean r110 = false;
    L16:
        if (r109 != null) goto L18;
        Resources r111 = r100.getContext().getResources();
        r109 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()), r104, r105, f552181a);
    L18:
        if (r109 == null) goto L27;
        Canvas r112 = new Canvas(r109);
        r112.scale(r103, r103);
        r100.computeScroll();
        r112.translate(-r100.getScrollX(), -r100.getScrollY());
        r100.draw(r112);
        if (r110 == false) goto L26;
        Bitmap r113 = f552182b;
        if (r113 == null) goto L26;
        Intrinsics.checkNotNull(r113);
        if (r113.isRecycled() == true) goto L26;
        Bitmap r114 = f552182b;
        Intrinsics.checkNotNull(r114);
        r114.recycle();
    L26:
        f552182b = r109;
    L27:
        r101.f552178a = r109;
        return r101;
    L15:
        r110 = true;
        r109 = null;
    L5:
        r104 = r100.getWidth();
        r105 = r100.getHeight();
        goto L6
    }
}
