package k40;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes45.dex */
public final class f {
    public static final h b(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pos");
        return new h(r100.left, r100.top);
    }

    public static final g c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rawPos");
        return new g(r100.getRawX(), r100.getRawY());
    }

    public static final g g(h r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toVec2f");
        return new g(r100.a().intValue(), r100.b().intValue());
    }

    public static final float a(g r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r101, "b");
        g r102 = e(r101, r100);
        float r103 = r102.a().floatValue();
        float r104 = r102.b().floatValue();
        return (float) Math.sqrt((r103 * r103) + (r104 * r104));
    }

    public static final void d(View r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSizeStableHitRect");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        int r102 = MathKt.roundToInt(r100.getTranslationX());
        int r103 = MathKt.roundToInt(r100.getTranslationY());
        r101.set(r100.getLeft() + r102, r100.getTop() + r103, r100.getRight() + r102, r100.getBottom() + r103);
    }

    public static final g e(g r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$minus");
        Intrinsics.checkNotNullParameter(r101, "rhs");
        return new g(r100.a().floatValue() - r101.a().floatValue(), r100.b().floatValue() - r101.b().floatValue());
    }

    public static final h f(h r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$minus");
        Intrinsics.checkNotNullParameter(r101, "rhs");
        return new h(r100.a().intValue() - r101.a().intValue(), r100.b().intValue() - r101.b().intValue());
    }
}
