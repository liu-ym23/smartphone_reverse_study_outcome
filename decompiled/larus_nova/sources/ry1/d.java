package ry1;

import android.graphics.Rect;
import android.view.View;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final void a(View r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSizeStableHitRect");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        int r102 = MathKt.roundToInt(r100.getTranslationX());
        int r103 = MathKt.roundToInt(r100.getTranslationY());
        r101.set(r100.getLeft() + r102, r100.getTop() + r103, r100.getRight() + r102, r100.getBottom() + r103);
    }
}
