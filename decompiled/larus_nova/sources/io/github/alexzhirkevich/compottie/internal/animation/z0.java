package io.github.alexzhirkevich.compottie.internal.animation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public abstract class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f491211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f491212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f491213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f491214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f491215e;

    public abstract x A();

    public x B() {
        return null;
    }

    public x C() {
        return null;
    }

    public x D() {
        return null;
    }

    public abstract f1 E();

    public abstract x F();

    public abstract x G();

    public boolean e(prc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return false;
    }

    public abstract f1 f();

    public abstract x y();

    public abstract f1 z();

    public z0() {
        this.f491211a = Matrix.m5077constructorimpl$default(null, 1, null);
        this.f491212b = Matrix.m5077constructorimpl$default(null, 1, null);
        this.f491213c = Matrix.m5077constructorimpl$default(null, 1, null);
        this.f491214d = Matrix.m5077constructorimpl$default(null, 1, null);
        this.f491215e = new float[9];
    }

    public final float[] H(prc.f r210) {
        Intrinsics.checkNotNullParameter(r210, "state");
        fsc.a.a(this.f491211a);
        if (e(r210) == true) goto L5;
        Offset r100 = z().b(r210);
        long r101 = r100.m4592unboximpl();
        fsc.a.f(this.f491211a, Float.intBitsToFloat((int) (r101 >> 32)), Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax)));
        long r102 = r100.m4592unboximpl();
        Float r110 = null;
        float r111 = 0.0f;
        if (r210.f530403m.h() == true) goto L9;
        Float r103 = A().b(r210);
        if (r103.floatValue() != 0.0f) goto L19;
        boolean r104 = true;
    L21:
        if ((!r104) == true) goto L24;
        r103 = null;
    L24:
        Float r105 = r103;
        if (r105 == null) goto L27;
        fsc.a.d(this.f491211a, r105.floatValue());
    L27:
        x r106 = B();
        if (r106 == null) goto L33;
        float[] r107 = this.f491211a;
        float r108 = r106.b(r210).floatValue();
        Intrinsics.checkNotNullParameter(r107, "$this$preRotateX");
        if (Math.abs(r108) < Float.MIN_VALUE) goto L33;
        float[] r112 = fsc.a.f478742b;
        fsc.a.a(r112);
        Matrix.m5089rotateXimpl(r112, r108);
        fsc.a.c(r107, r112);
    L33:
        x r109 = C();
        if (r109 == null) goto L39;
        float[] r113 = this.f491211a;
        float r114 = r109.b(r210).floatValue();
        Intrinsics.checkNotNullParameter(r113, "$this$preRotateY");
        if (Math.abs(r114) < Float.MIN_VALUE) goto L39;
        float[] r115 = fsc.a.f478742b;
        fsc.a.a(r115);
        Matrix.m5090rotateYimpl(r115, r114);
        fsc.a.c(r113, r115);
    L39:
        x r116 = D();
        if (r116 == null) goto L45;
        float[] r117 = this.f491211a;
        float r118 = r116.b(r210).floatValue();
        Intrinsics.checkNotNullParameter(r117, "$this$preRotateZ");
        if (Math.abs(r118) < Float.MIN_VALUE) goto L45;
        float[] r119 = fsc.a.f478742b;
        fsc.a.a(r119);
        Matrix.m5091rotateZimpl(r119, r118);
        fsc.a.c(r117, r119);
    L45:
        Float r120 = F().b(r210);
        if (r120.floatValue() != 0.0f) goto L48;
        boolean r121 = true;
    L50:
        if ((!r121) == false) goto L52;
        r110 = r120;
    L52:
        Float r122 = r110;
        if (r122 == null) goto L70;
        float r123 = r122.floatValue();
        float r124 = G().b(r210).floatValue();
        if (r124 != 0.0f) goto L57;
        boolean r125 = true;
    L59:
        if (r125 == true) goto L62;
        r111 = (float) Math.cos(((-r124) + 90) * fsc.b.f478744a);
    L62:
        if (r124 != 0.0f) goto L64;
        boolean r126 = true;
    L66:
        if (r126 == false) goto L68;
        float r127 = 1.0f;
    L69:
        float r128 = (float) Math.tan(r123 * fsc.b.f478744a);
        ArraysKt.fill$default(this.f491215e, 0.0f, 0, 0, 6, null);
        float[] r129 = this.f491215e;
        r129[0] = r111;
        r129[1] = r127;
        float r130 = -r127;
        r129[3] = r130;
        r129[4] = r111;
        r129[8] = 1.0f;
        fsc.a.g(this.f491212b, r129);
        ArraysKt.fill$default(this.f491215e, 0.0f, 0, 0, 6, null);
        float[] r131 = this.f491215e;
        r131[0] = 1.0f;
        r131[3] = r128;
        r131[4] = 1.0f;
        r131[8] = 1.0f;
        fsc.a.g(this.f491213c, r131);
        ArraysKt.fill$default(this.f491215e, 0.0f, 0, 0, 6, null);
        float[] r132 = this.f491215e;
        r132[0] = r111;
        r132[1] = r130;
        r132[3] = r127;
        r132[4] = r111;
        r132[8] = 1.0f;
        fsc.a.g(this.f491214d, r132);
        fsc.a.c(this.f491213c, this.f491212b);
        fsc.a.c(this.f491214d, this.f491213c);
        fsc.a.c(this.f491211a, this.f491214d);
        goto L70
    L68:
        r127 = (float) Math.sin(((-r124) + 90) * fsc.b.f478744a);
        goto L69
    L64:
        r126 = false;
        goto L66
    L57:
        r125 = false;
    L70:
        f1 r133 = E();
        List<Float> r134 = h1.f491056a;
        Intrinsics.checkNotNullParameter(r133, "<this>");
        Intrinsics.checkNotNullParameter(r210, "state");
        long r135 = Offset.m4577divtuRUvjQ(r133.b(r210).m4592unboximpl(), 100.0f);
        fsc.a.e(this.f491211a, Float.intBitsToFloat((int) (r135 >> 32)), Float.intBitsToFloat((int) (r135 & BodyPartID.bodyIdMax)));
        long r136 = f().b(r210).m4592unboximpl();
        fsc.a.f(this.f491211a, -Float.intBitsToFloat((int) (r136 >> 32)), -Float.intBitsToFloat((int) (r136 & BodyPartID.bodyIdMax)));
        return this.f491211a;
    L48:
        r121 = false;
        goto L50
    L19:
        r104 = false;
        goto L21
    L9:
        if (Offset.m4579equalsimpl0(r102, Offset.Companion.m4598getZeroF1C5BW0()) == true) goto L27;
        float r137 = Float.intBitsToFloat((int) (r102 >> 32));
        float r138 = Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax));
        float r139 = r210.f530394d + 0.1f;
        f1 r140 = z();
        float r141 = r210.f530394d;
        r210.f530394d = r139;     // Catch: Throwable -> L13
        long r142 = r140.b(r210).m4592unboximpl();     // Catch: Throwable -> L13
        r210.f530394d = r141;
        fsc.a.d(this.f491211a, ((float) Math.atan2(Float.intBitsToFloat((int) (r142 & BodyPartID.bodyIdMax)) - r138, Float.intBitsToFloat((int) (r142 >> 32)) - r137)) / fsc.b.f478744a);
    L13:
        th = move-exception;
        r210.f530394d = r141;
        throw th;
    L5:
        return this.f491211a;
    }
}
