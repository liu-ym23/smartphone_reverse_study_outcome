package sma;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.Build;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Paint f542592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Paint f542593b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Matrix f542594c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinearGradient f542595d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LinearGradient f542596e = null;

    static {
        PorterDuffXfermode r100 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        f542592a = new Paint();
        Paint r101 = new Paint();
        r101.setXfermode(r100);
        f542593b = r101;
        f542594c = new Matrix();
        f542595d = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, -1, 16777215, Shader.TileMode.CLAMP);
        f542596e = new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, 16777215, -1, Shader.TileMode.CLAMP);
    }

    public static Paint a(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "sourcePaint");
        Paint r101 = f542592a;
        r101.reset();
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r100.getBlendMode() == null) goto L8;
        r101.setBlendMode(r100.getBlendMode());
    L10:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L16;
        return null;
    L16:
        return r101;
    L8:
        if (r100.getXfermode() == null) goto L11;
        r101.setXfermode(r100.getXfermode());
        goto L10
    L11:
        r102 = false;
        goto L12
    }

    public static void b(Canvas r110, float r111, float r112, Paint r113, Paint r210, c r211, float r212, float r213, float r214, float r215, float r216, float r217, Function1 r218, BlendMode r219, Xfermode r310) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r210, "paint");
        Intrinsics.checkNotNullParameter(r211, "cache");
        Intrinsics.checkNotNullParameter(r218, "blurMaskFilterProvider");
        if (r215 > r214) goto L5;
        return;
    L5:
        int r114 = r110.saveLayer(r111, 0.0f, r112, r216, r113);
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r100 < 29) goto L9;
        r210.setBlendMode(null);     // Catch: Throwable -> L15
    L9:
        r210.setXfermode(null);     // Catch: Throwable -> L15
        r210.setMaskFilter((MaskFilter) r218.invoke(Float.valueOf(r217)));     // Catch: Throwable -> L15
        r110.clipRect(r214, 0.0f, r215, r216);     // Catch: Throwable -> L15
        char[] r101 = r211.f542599c;     // Catch: Throwable -> L15
        r110.drawText(r101, 0, r101.length, r212, r213, r210);     // Catch: Throwable -> L15
        r110.restoreToCount(r114);
        if (r100 < 29) goto L13;
        r210.setBlendMode(r219);
    L13:
        r210.setXfermode(r310);
        return;
    L15:
        th = move-exception;
        r110.restoreToCount(r114);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        r210.setBlendMode(r219);
    L19:
        r210.setXfermode(r310);
        throw th;
    }
}
