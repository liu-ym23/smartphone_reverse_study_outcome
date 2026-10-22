package fsc;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f478741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f478742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f478743c = null;

    static {
        f478741a = Matrix.m5077constructorimpl$default(null, 1, null);
        f478742b = Matrix.m5077constructorimpl$default(null, 1, null);
        f478743c = Matrix.m5077constructorimpl$default(null, 1, null);
        float r100 = 1;
        double r101 = 2.0f;
        float r102 = r100 / ((float) Math.sqrt(r101));
        float r103 = r100 / ((float) Math.sqrt(r101));
        Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    }

    public static final void a(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$fastReset");
        b(r100, f478743c);
    }

    public static final void b(float[] r100, float[] r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$fastSetFrom");
        Intrinsics.checkNotNullParameter(r101, "other");
        ArraysKt.copyInto$default(r101, r100, 0, 0, 0, 14, null);
    }

    public static final void c(float[] r100, float[] r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$preConcat");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (MatrixKt.m5102isIdentity58bKbWc(r101) == false) goto L6;
        return;
    L6:
        if (MatrixKt.m5102isIdentity58bKbWc(r100) == false) goto L9;
        b(r100, r101);
        return;
    L9:
        float[] r102 = f478741a;
        b(r102, r101);
        Matrix.m5096timesAssign58bKbWc(r102, r100);
        b(r100, r102);
    }

    public static final void d(float[] r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$preRotate");
        if (Math.abs(r101) >= Float.MIN_VALUE) goto L5;
        return;
    L5:
        Matrix.m5091rotateZimpl(r100, r101);
    }

    public static final void g(float[] r100, float[] r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setValues");
        Intrinsics.checkNotNullParameter(r101, "values");
        r100[0] = r101[0];
        r100[4] = r101[1];
        r100[12] = r101[2];
        r100[1] = r101[3];
        r100[5] = r101[4];
        r100[13] = r101[5];
        r100[3] = r101[6];
        r100[7] = r101[7];
        r100[15] = r101[8];
    }

    public static final void e(float[] r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$preScale");
        boolean r103 = true;
        if (r101 != 1.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L13:
        Matrix.m5093scaleimpl$default(r100, r101, r102, 0.0f, 4, null);
        return;
    L8:
        if (r102 == 1.0f) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static final void f(float[] r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$preTranslate");
        if (Math.abs(r101) < Float.MIN_VALUE) goto L5;
    L7:
        Matrix.m5099translateimpl$default(r100, r101, r102, 0.0f, 4, null);
        return;
    L5:
        if (Math.abs(r102) >= Float.MIN_VALUE) goto L7;
    }
}
