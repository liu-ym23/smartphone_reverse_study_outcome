package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import androidx.compose.material3.MenuKt;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MatrixExt {
    private static final float[] sTemp = null;

    static {
        sTemp = new float[16];
    }

    private MatrixExt() {
    }

    public static void preVerticalFlip(float[] r4, float r5) {
        normalize(r4, MenuKt.ClosedAlphaTarget, r5);
        Matrix.scaleM(r4, 0, 1.0f, -1.0f, 1.0f);
        denormalize(r4, MenuKt.ClosedAlphaTarget, r5);
    }

    public static String toString(float[] r4, int r5) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", new Object[]{Float.valueOf(r4[r5]), Float.valueOf(r4[r5 + 4]), Float.valueOf(r4[r5 + 8]), Float.valueOf(r4[r5 + 12]), Float.valueOf(r4[r5 + 1]), Float.valueOf(r4[r5 + 5]), Float.valueOf(r4[r5 + 9]), Float.valueOf(r4[r5 + 13]), Float.valueOf(r4[r5 + 2]), Float.valueOf(r4[r5 + 6]), Float.valueOf(r4[r5 + 10]), Float.valueOf(r4[r5 + 14]), Float.valueOf(r4[r5 + 3]), Float.valueOf(r4[r5 + 7]), Float.valueOf(r4[r5 + 11]), Float.valueOf(r4[r5 + 15])});
    }

    private static void denormalize(float[] r2, float r3, float r4) {
        Matrix.translateM(r2, 0, -r3, -r4, MenuKt.ClosedAlphaTarget);
    }

    private static void normalize(float[] r2, float r3, float r4) {
        Matrix.translateM(r2, 0, r3, r4, MenuKt.ClosedAlphaTarget);
    }

    public static void postRotate(float[] r7, float r8, float r9, float r10) {
        float[] r6 = sTemp;
        monitor-enter(r6);
        Matrix.setIdentityM(r6, 0);     // Catch: Throwable -> L8
        normalize(r6, r9, r10);     // Catch: Throwable -> L8
        Matrix.rotateM(r6, 0, r8, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f);     // Catch: Throwable -> L8
        denormalize(r6, r9, r10);     // Catch: Throwable -> L8
        Matrix.multiplyMM(r7, 0, r6, 0, r7, 0);     // Catch: Throwable -> L8
        monitor-exit(r6);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void preRotate(float[] r6, float r7, float r8, float r9) {
        normalize(r6, r8, r9);
        Matrix.rotateM(r6, 0, r7, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f);
        denormalize(r6, r8, r9);
    }

    public static void setRotate(float[] r1, float r2, float r3, float r4) {
        Matrix.setIdentityM(r1, 0);
        preRotate(r1, r2, r3, r4);
    }
}
