package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ViewPorts {
    private static float flipX(float r0, float r1) {
        return (r1 + r1) - r0;
    }

    private static float flipY(float r0, float r1) {
        return (r1 + r1) - r0;
    }

    private static boolean shouldMirrorStartAndEnd(boolean r1, int r2) {
        boolean r0 = true;
        if (r2 == 1) goto L7;
        r0 = false;
    L7:
        return r1 ^ r0;
    }

    private ViewPorts() {
    }

    private static RectF flipHorizontally(RectF r4, float r5) {
        return new RectF(flipX(r4.right, r5), r4.top, flipX(r4.left, r5), r4.bottom);
    }

    private static RectF flipVertically(RectF r4, float r5) {
        return new RectF(r4.left, flipY(r4.bottom, r5), r4.right, flipY(r4.top, r5));
    }

    private static RectF correctStartOrEnd(boolean r6, int r7, RectF r8, RectF r9) {
        boolean r0 = true;
        if (r7 != 0) goto L6;
        if (r6 == true) goto L6;
        boolean r2 = true;
    L8:
        if (r7 != 90) goto L11;
        if (r6 == false) goto L11;
        boolean r4 = true;
    L12:
        if (r2 == true) goto L58;
        if (r4 == true) goto L58;
        if (r7 != 0) goto L18;
        if (r6 == false) goto L18;
        boolean r3 = true;
    L20:
        if (r7 != 270) goto L23;
        if (r6 == true) goto L23;
        boolean r5 = true;
    L24:
        if (r3 == true) goto L57;
        if (r5 == true) goto L57;
        if (r7 != 90) goto L30;
        if (r6 == true) goto L30;
        boolean r10 = true;
    L32:
        if (r7 != 180) goto L35;
        if (r6 == false) goto L35;
        boolean r11 = true;
    L36:
        if (r10 == true) goto L55;
        if (r11 == true) goto L55;
        if (r7 != 180) goto L42;
        if (r6 == true) goto L42;
        boolean r12 = true;
    L43:
        if (r7 != 270) goto L46;
        if (r6 == false) goto L46;
    L47:
        if (r12 == true) goto L53;
        if (r0 == true) goto L53;
        throw new IllegalArgumentException("Invalid argument: mirrored " + r6 + " rotation " + r7);
    L53:
        return flipHorizontally(flipVertically(r9, r8.centerY()), r8.centerX());
    L46:
        r0 = false;
    L42:
        r12 = false;
    L55:
        return flipVertically(r9, r8.centerY());
    L35:
        r11 = false;
    L30:
        r10 = false;
    L57:
        return flipHorizontally(r9, r8.centerX());
    L23:
        r5 = false;
    L18:
        r3 = false;
    L58:
        return r9;
    L11:
        r4 = false;
    L6:
        r2 = false;
        goto L8
    }

    public static RectF getScaledRect(RectF r4, Rational r5, int r6, boolean r7, int r8, int r9) {
        if (r6 != 3) goto L5;
        return r4;
    L5:
        Matrix r0 = new Matrix();
        RectF r1 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r5.getNumerator(), r5.getDenominator());
        if (r6 != 0) goto L8;
        r0.setRectToRect(r1, r4, Matrix.ScaleToFit.START);
    L16:
        RectF r10 = new RectF();
        r0.mapRect(r10, r1);
        return correctStartOrEnd(shouldMirrorStartAndEnd(r7, r8), r9, r4, r10);
    L8:
        if (r6 != 1) goto L10;
        r0.setRectToRect(r1, r4, Matrix.ScaleToFit.CENTER);
        goto L16
    L10:
        if (r6 != 2) goto L13;
        r0.setRectToRect(r1, r4, Matrix.ScaleToFit.END);
        goto L16
    L13:
        throw new IllegalStateException("Unexpected scale type: " + r6);
    }

    public static Map<UseCase, Rect> calculateViewPortRects(Rect r8, boolean r9, Rational r10, int r11, int r12, int r13, Map<UseCase, StreamSpec> r14) {
        if (r8.width() > 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF r1 = new RectF(r8);
        HashMap r2 = new HashMap();
        RectF r3 = new RectF(r8);
        Iterator<Map.Entry<UseCase, StreamSpec>> r15 = r14.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        Map.Entry<UseCase, StreamSpec> r16 = r15.next();
        Matrix r4 = new Matrix();
        RectF r5 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r16.getValue().getResolution().getWidth(), r16.getValue().getResolution().getHeight());
        r4.setRectToRect(r5, r1, Matrix.ScaleToFit.CENTER);
        r2.put(r16.getKey(), r4);
        RectF r17 = new RectF();
        r4.mapRect(r17, r5);
        r3.intersect(r17);
        goto L10
    L12:
        RectF r18 = getScaledRect(r3, ImageUtil.getRotatedAspectRatio(r11, r10), r12, r9, r13, r11);
        HashMap r19 = new HashMap();
        RectF r110 = new RectF();
        Matrix r111 = new Matrix();
        Iterator r112 = r2.entrySet().iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        Map.Entry r113 = (Map.Entry) r112.next();
        ((Matrix) r113.getValue()).invert(r111);
        r111.mapRect(r110, r18);
        Rect r114 = new Rect();
        r110.round(r114);
        r19.put((UseCase) r113.getKey(), r114);
        goto L14
    L16:
        return r19;
    L5:
        if (r8.height() <= 0) goto L7;
        r0 = true;
        goto L8
    }
}
