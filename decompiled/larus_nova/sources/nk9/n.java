package nk9;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.view.View;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f519505a = null;

    public n() {
    }

    static {
        f519505a = new int[2];
        new Matrix();
    }

    public static void b(View r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        int[] r102 = f519505a;
        r100.getLocationOnScreen(r102);
        int r103 = r102[0];
        r101.set(r103, r102[1], r100.getWidth() + r103, r102[1] + r100.getHeight());
    }

    public static float c(Pair r100, Pair r101) {
        Object r102 = r100.getFirst();
        boolean r103 = false;
        if (((Number) r102).intValue() <= ((Number) r101.getFirst()).intValue()) goto L5;
        boolean r104 = true;
    L6:
        Object r105 = null;
        if (r104 == true) goto L10;
        r102 = null;
    L10:
        Integer r106 = (Integer) r102;
        if (r106 == null) goto L13;
        int r107 = r106.intValue();
    L14:
        Object r108 = r100.getSecond();
        if (((Number) r108).intValue() >= ((Number) r101.getSecond()).intValue()) goto L17;
        r103 = true;
    L17:
        if (r103 == false) goto L19;
        r105 = r108;
    L19:
        Integer r109 = (Integer) r105;
        if (r109 == null) goto L22;
        int r110 = r109.intValue();
    L24:
        return (r110 - r107) / (((Number) r100.getSecond()).intValue() - ((Number) r100.getFirst()).intValue());
    L22:
        r110 = ((Number) r101.getSecond()).intValue();
        goto L24
    L13:
        r107 = ((Number) r101.getFirst()).intValue();
        goto L14
    L5:
        r104 = false;
        goto L6
    }

    public static Range d(Pair r100, Pair r101) {
        int r102 = ((Number) r101.getFirst()).intValue();
        int r103 = ((Number) r100.getSecond()).intValue();
        float r104 = 0.0f;
        Float r105 = Float.valueOf(0.0f);
        if (r102 < r103) goto L7;
        return new Range(r105, r105);
    L7:
        if (((Number) r101.getSecond()).intValue() <= ((Number) r100.getFirst()).intValue()) goto L9;
        float r106 = ((Number) r100.getSecond()).intValue() - ((Number) r100.getFirst()).intValue();
        if (((Number) r100.getFirst()).intValue() >= ((Number) r101.getFirst()).intValue()) goto L15;
        r104 = (((Number) r101.getFirst()).intValue() - ((Number) r100.getFirst()).intValue()) / r106;
    L15:
        if (((Number) r100.getSecond()).intValue() > ((Number) r101.getSecond()).intValue()) goto L17;
        float r107 = 1.0f;
    L19:
        return new Range(Float.valueOf(Math.min(r104, r107)), Float.valueOf(Math.max(r104, r107)));
    L17:
        r107 = (r106 - (((Number) r100.getSecond()).intValue() - ((Number) r101.getSecond()).intValue())) / r106;
        goto L19
    L9:
        return new Range(r105, r105);
    }

    public static void a(Rect r100, float r101, float r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        int r105 = r100.width();
        int r106 = r100.height();
        int r107 = r100.left;
        int r108 = r100.top;
        float r109 = r107;
        float r110 = r105;
        r100.left = MathKt.roundToInt((r101 * r110) + r109);
        float r111 = r108;
        float r112 = r106;
        r100.top = MathKt.roundToInt((r102 * r112) + r111);
        r100.right = MathKt.roundToInt(r109 + (r103 * r110));
        r100.bottom = MathKt.roundToInt(r111 + (r104 * r112));
    }
}
