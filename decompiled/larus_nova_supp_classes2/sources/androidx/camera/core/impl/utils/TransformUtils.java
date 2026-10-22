package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TransformUtils {
    public static final RectF NORMALIZED_RECT = null;

    static {
        NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);
    }

    private TransformUtils() {
    }

    public static Matrix getNormalizedToBuffer(RectF r3) {
        Matrix r0 = new Matrix();
        r0.setRectToRect(NORMALIZED_RECT, r3, Matrix.ScaleToFit.FILL);
        return r0;
    }

    public static int getRotationDegrees(Matrix r4) {
        float[] r0 = new float[9];
        r4.getValues(r0);
        return within360((int) Math.round(Math.atan2(r0[3], r0[0]) * 57.29577951308232d));
    }

    public static boolean is90or270(int r3) {
        if (r3 != 90) goto L5;
        return true;
    L5:
        if (r3 == 270) goto L18;
        if (r3 != 0) goto L9;
        return false;
    L9:
        if (r3 != 180) goto L12;
        return false;
    L12:
        throw new IllegalArgumentException("Invalid rotation degrees: " + r3);
    L18:
        return true;
    }

    public static boolean isMirrored(Matrix r6) {
        float[] r0 = {MenuKt.ClosedAlphaTarget, 1.0f, 1.0f, MenuKt.ClosedAlphaTarget};
        r6.mapVectors(r0);
        if (calculateSignedAngle(r0[0], r0[1], r0[2], r0[3]) <= MenuKt.ClosedAlphaTarget) goto L6;
        return true;
    L6:
        return false;
    }

    public static Size rectToSize(Rect r2) {
        return new Size(r2.width(), r2.height());
    }

    public static String rectToString(Rect r4) {
        return String.format(Locale.US, "%s(%dx%d)", new Object[]{r4, Integer.valueOf(r4.width()), Integer.valueOf(r4.height())});
    }

    public static float[] rectToVertices(RectF r5) {
        float r1 = r5.left;
        float r2 = r5.top;
        float r3 = r5.right;
        float r6 = r5.bottom;
        return new float[]{r1, r2, r3, r2, r3, r6, r1, r6};
    }

    public static Size reverseSize(Size r2) {
        return new Size(r2.getHeight(), r2.getWidth());
    }

    public static SizeF reverseSizeF(SizeF r2) {
        return new SizeF(r2.getHeight(), r2.getWidth());
    }

    public static Rect sizeToRect(Size r1) {
        return sizeToRect(r1, 0, 0);
    }

    public static RectF sizeToRectF(Size r1) {
        return sizeToRectF(r1, 0, 0);
    }

    public static float[] sizeToVertices(Size r4) {
        return new float[]{MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r4.getWidth(), MenuKt.ClosedAlphaTarget, r4.getWidth(), r4.getHeight(), MenuKt.ClosedAlphaTarget, r4.getHeight()};
    }

    public static RectF verticesToRect(float[] r14) {
        return new RectF(min(r14[0], r14[2], r14[4], r14[6]), min(r14[1], r14[3], r14[5], r14[7]), max(r14[0], r14[2], r14[4], r14[6]), max(r14[1], r14[3], r14[5], r14[7]));
    }

    public static int within360(int r0) {
        return ((r0 % 360) + 360) % 360;
    }

    public static Matrix getNormalizedToBuffer(Rect r1) {
        return getNormalizedToBuffer(new RectF(r1));
    }

    public static Size getRotatedSize(Rect r0, int r1) {
        return rotateSize(rectToSize(r0), r1);
    }

    public static boolean hasCropping(Rect r2, Size r3) {
        if (r2.left == 0) goto L5;
    L12:
        return true;
    L5:
        if (r2.top != 0) goto L12;
        if (r2.width() != r3.getWidth()) goto L12;
        if (r2.height() != r3.getHeight()) goto L12;
        return false;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size r1, Size r2) {
        return isAspectRatioMatchingWithRoundingError(r1, false, r2, false);
    }

    public static RectF rotateRect(RectF r3, int r4) {
        if ((r4 % 90) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Invalid rotation degrees: " + r4);
        if (is90or270(within360(r4)) == true) goto L9;
        return r3;
    L9:
        return new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r3.height(), r3.width());
    L5:
        r0 = false;
        goto L6
    }

    public static Size rotateSize(Size r3, int r4) {
        if ((r4 % 90) != 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Invalid rotation degrees: " + r4);
        if (is90or270(within360(r4)) == true) goto L9;
        return r3;
    L9:
        return reverseSize(r3);
    L5:
        r0 = false;
        goto L6
    }

    public static Matrix updateSensorToBufferTransform(Matrix r1, Rect r2) {
        Matrix r0 = new Matrix(r1);
        r0.postTranslate(-r2.left, -r2.top);
        return r0;
    }

    public static Matrix getExifTransform(int r9, int r10, int r11) {
        Matrix r0 = new Matrix();
        float r12 = r10;
        float r13 = r11;
        RectF r1 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r12, r13);
        RectF r3 = NORMALIZED_RECT;
        r0.setRectToRect(r1, r3, Matrix.ScaleToFit.FILL);
        boolean r6 = true;
        switch(r9) {
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L12;
        };
    L5:
        r0.postRotate(270.0f);
    L13:
        if (r6 == false) goto L15;
        r1 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r13, r12);
    L15:
        Matrix r14 = new Matrix();
        r14.setRectToRect(r3, r1, Matrix.ScaleToFit.FILL);
        r0.postConcat(r14);
        return r0;
    L6:
        r0.postScale(-1.0f, 1.0f);
        r0.postRotate(90.0f);
        goto L13
    L7:
        r0.postRotate(90.0f);
        goto L13
    L8:
        r0.postScale(-1.0f, 1.0f);
        r0.postRotate(270.0f);
        goto L13
    L9:
        r0.postScale(1.0f, -1.0f);
        goto L12
    L10:
        r0.postRotate(180.0f);
        goto L12
    L11:
        r0.postScale(-1.0f, 1.0f);
    L12:
        r6 = false;
        goto L13
    }

    public static Matrix getRectToRect(RectF r1, RectF r2, int r3) {
        return getRectToRect(r1, r2, r3, false);
    }

    public static Rect sizeToRect(Size r2, int r3, int r4) {
        return new Rect(r3, r4, r2.getWidth() + r3, r2.getHeight() + r4);
    }

    public static RectF sizeToRectF(Size r4, int r5, int r6) {
        return new RectF(r5, r6, r5 + r4.getWidth(), r6 + r4.getHeight());
    }

    public static float calculateSignedAngle(float r4, float r5, float r6, float r7) {
        float r0 = (r4 * r6) + (r5 * r7);
        float r1 = (r4 * r7) - (r5 * r6);
        double r8 = Math.sqrt((r4 * r4) + (r5 * r5)) * Math.sqrt((r6 * r6) + (r7 * r7));
        return (float) Math.toDegrees(Math.atan2(((double) r1) / r8, ((double) r0) / r8));
    }

    public static Matrix getRectToRect(RectF r3, RectF r4, int r5, boolean r6) {
        Matrix r0 = new Matrix();
        r0.setRectToRect(r3, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        r0.postRotate(r5);
        if (r6 == false) goto L5;
        r0.postScale(-1.0f, 1.0f);
    L5:
        r0.postConcat(getNormalizedToBuffer(r4));
        return r0;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size r3, boolean r4, Size r5, boolean r6) {
        if (r4 == false) goto L5;
        float r7 = r3.getWidth() / r3.getHeight();
        float r8 = r7;
    L6:
        if (r6 == false) goto L8;
        float r9 = r5.getWidth() / r5.getHeight();
        float r10 = r9;
    L10:
        if (r7 >= r9) goto L12;
    L14:
        return false;
    L12:
        if (r10 < r8) goto L14;
        return true;
    L8:
        float r11 = (r5.getWidth() + 1.0f) / (r5.getHeight() - 1.0f);
        r9 = (r5.getWidth() - 1.0f) / (r5.getHeight() + 1.0f);
        r10 = r11;
        goto L10
    L5:
        r7 = (r3.getWidth() + 1.0f) / (r3.getHeight() - 1.0f);
        r8 = (r3.getWidth() - 1.0f) / (r3.getHeight() + 1.0f);
        goto L6
    }

    public static float max(float r0, float r1, float r2, float r3) {
        return Math.max(Math.max(r0, r1), Math.max(r2, r3));
    }

    public static float min(float r0, float r1, float r2, float r3) {
        return Math.min(Math.min(r0, r1), Math.min(r2, r3));
    }
}
