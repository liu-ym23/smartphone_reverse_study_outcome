package ej4;

import android.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f472872a = 0;

    static {
    }

    public static float a(Matrix r100) {
        Intrinsics.checkNotNullParameter(r100, "matrix");
        float[] r101 = new float[9];
        r100.getValues(r101);
        float r102 = r101[0];
        float r103 = r101[3];
        return (float) Math.sqrt((r102 * r102) + (r103 * r103));
    }
}
