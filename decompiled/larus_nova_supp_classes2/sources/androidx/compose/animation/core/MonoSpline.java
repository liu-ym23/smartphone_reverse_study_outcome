package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011J \u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "<init>", "([F[[FF)V", "timePoints", "values", "[[F", "tangents", "slopeTemp", "makeFloatArray", "a", "", "b", "(II)[[F", "getPos", "t", "j", "", "v", "Landroidx/compose/animation/core/AnimationVector;", "index", "getSlope", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MonoSpline {
    public static final int $stable = 8;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    private final void getSlope(float r14, float[] r15) {
        int r1 = 0;
        int r0 = this.values[0].length;
        float[] r2 = this.timePoints;
        int r3 = r2.length;
        float r4 = r2[0];
        int r5 = r3 - 1;
        float r6 = r2[r5];
        if (r14 >= r4) goto L6;
        r14 = r4;
    L6:
        if (r14 > r6) goto L10;
        r6 = r14;
    L10:
        if (r15.length >= r0) goto L12;
        return;
    L12:
        int r16 = 0;
    L13:
        if (r16 >= r5) goto L20;
        float[] r7 = this.timePoints;
        int r8 = r16 + 1;
        float r9 = r7[r8];
        if (r6 <= r9) goto L16;
        r16 = r8;
        goto L13
    L16:
        float r10 = r7[r16];
        float r11 = r9 - r10;
        float r12 = (r6 - r10) / r11;
    L17:
        if (r1 >= r0) goto L24;
        float[][] r13 = this.values;
        float r17 = r13[r16][r1];
        float r18 = r13[r8][r1];
        float[][] r19 = this.tangents;
        r15[r1] = MonoSplineKt.hermiteDifferential(r11, r12, r17, r18, r19[r16][r1], r19[r8][r1]) / r11;
        r1 = r1 + 1;
        goto L17
    L24:
        return;
    }

    private final float[][] makeFloatArray(int r4, int r5) {
        float[][] r0 = new float[r4][];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0[r1] = new float[r5];
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public final float getPos(float r19, int r20) {
        float[][] r2 = this.values;
        float[][] r3 = this.tangents;
        float[] r4 = this.timePoints;
        int r5 = r4.length;
        if (r19 > r4[0]) goto L5;
        int r7 = 0;
    L9:
        if (r7 == (-1)) goto L12;
        float r6 = r2[r7][r20];
        float r8 = r4[r7];
        return r6 + ((r19 - r8) * getSlope(r8, r20));
    L12:
        int r9 = r5 - 1;
        int r10 = 0;
    L13:
        if (r10 >= r9) goto L26;
        float[] r11 = this.timePoints;
        float r12 = r11[r10];
        if (r19 != r12) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == true) goto L20;
        int r14 = r10 + 1;
        float r15 = r11[r14];
        if (r19 < r15) goto L23;
        r10 = r14;
        goto L13
    L23:
        float r16 = r15 - r12;
        return MonoSplineKt.hermiteInterpolate(r16, (r19 - r12) / r16, r2[r10][r20], r2[r14][r20], r3[r10][r20], r3[r14][r20]);
    L20:
        return r2[r10][r20];
    L17:
        r13 = false;
        goto L18
    L26:
        return MenuKt.ClosedAlphaTarget;
    L5:
        r7 = r5 - 1;
        if (r19 >= r4[r7]) goto L9;
        r7 = -1;
        goto L9
    }

    private final float getSlope(float r14, int r15) {
        float[] r0 = this.timePoints;
        float[][] r1 = this.values;
        float[][] r2 = this.tangents;
        int r3 = r0.length;
        int r4 = 0;
        float r5 = r0[0];
        int r6 = r3 - 1;
        float r7 = r0[r6];
        if (r14 >= r5) goto L6;
        r14 = r5;
    L6:
        if (r14 > r7) goto L9;
        r7 = r14;
    L9:
        if (r4 >= r6) goto L15;
        int r16 = r4 + 1;
        float r8 = r0[r16];
        if (r7 <= r8) goto L12;
        r4 = r16;
        goto L9
    L12:
        float r9 = r1[r4][r15];
        float r10 = r1[r16][r15];
        float r11 = r2[r4][r15];
        float r12 = r2[r16][r15];
        float r17 = r0[r4];
        float r13 = r8 - r17;
        return MonoSplineKt.hermiteDifferential(r13, (r7 - r17) / r13, r9, r10, r11, r12) / r13;
    L15:
        return MenuKt.ClosedAlphaTarget;
    }

    public MonoSpline(float[] r19, float[][] r20, float r21) {
        int r3 = r19.length;
        int r5 = r20[0].length;
        this.slopeTemp = new float[r5];
        int r6 = r3 - 1;
        float[][] r7 = makeFloatArray(r6, r5);
        float[][] r8 = makeFloatArray(r3, r5);
        int r9 = 0;
    L3:
        if (r9 >= r5) goto L13;
        int r10 = 0;
    L5:
        if (r10 >= r6) goto L11;
        int r11 = r10 + 1;
        float r12 = r19[r11] - r19[r10];
        float[] r13 = r7[r10];
        float r14 = (r20[r11][r9] - r20[r10][r9]) / r12;
        r13[r9] = r14;
        if (r10 != 0) goto L9;
        r8[r10][r9] = r14;
    L10:
        r10 = r11;
        goto L5
    L9:
        r8[r10][r9] = (r7[r10 - 1][r9] + r14) * 0.5f;
        goto L10
    L11:
        r8[r6][r9] = r7[r3 - 2][r9];
        r9 = r9 + 1;
        goto L3
    L13:
        if (Float.isNaN(r21) == true) goto L17;
        int r15 = 0;
    L15:
        if (r15 >= r5) goto L17;
        float[] r16 = r7[r3 - 2];
        float r17 = r16[r15] * (1 - r21);
        float[] r18 = r7[0];
        float r110 = r17 + (r18[r15] * r21);
        r18[r15] = r110;
        r16[r15] = r110;
        r8[r6][r15] = r110;
        r8[0][r15] = r110;
        r15 = r15 + 1;
    L17:
        int r4 = 0;
    L18:
        if (r4 >= r6) goto L32;
        int r22 = 0;
    L20:
        if (r22 >= r5) goto L31;
        float r111 = r7[r4][r22];
        if (r111 != MenuKt.ClosedAlphaTarget) goto L24;
        boolean r112 = true;
    L25:
        if (r112 == false) goto L27;
        r8[r4][r22] = 0.0f;
        r8[r4 + 1][r22] = 0.0f;
        int r113 = r5;
    L30:
        r22 = r22 + 1;
        r5 = r113;
        goto L20
    L27:
        float r114 = r8[r4][r22] / r111;
        int r115 = r4 + 1;
        float r116 = r8[r115][r22] / r111;
        r113 = r5;
        float r23 = (float) Math.hypot(r114, r116);
        if (r23 <= 9.0d) goto L30;
        float r24 = 3.0f / r23;
        float[] r25 = r8[r4];
        float[] r117 = r7[r4];
        r25[r22] = (r114 * r24) * r117[r22];
        r8[r115][r22] = (r24 * r116) * r117[r22];
        goto L30
    L24:
        r112 = false;
        goto L25
    L31:
        r4 = r4 + 1;
        goto L18
    L32:
        this.timePoints = r19;
        this.values = r20;
        this.tangents = r8;
    }

    public final void getPos(float r18, AnimationVector r19, int r20) {
        float[] r2 = this.timePoints;
        int r3 = r2.length;
        int r5 = 0;
        int r4 = this.values[0].length;
        if (r18 > r2[0]) goto L5;
        int r6 = 0;
    L9:
        if (r6 == (-1)) goto L14;
        getSlope(r2[r6], this.slopeTemp);
    L11:
        if (r5 >= r4) goto L13;
        r19.set$animation_core(r5, this.values[r6][r5] + ((r18 - this.timePoints[r6]) * this.slopeTemp[r5]));
        r5 = r5 + 1;
        goto L11
    L13:
        return;
    L14:
        int r7 = r3 - 1;
        int r8 = r20;
    L15:
        if (r8 >= r7) goto L31;
        float[] r9 = this.timePoints;
        float r10 = r9[r8];
        if (r18 != r10) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == true) goto L21;
        int r12 = r8 + 1;
        float r13 = r9[r12];
        if (r18 < r13) goto L26;
        r8 = r12;
        goto L15
    L26:
        float r14 = r13 - r10;
        float r15 = (r18 - r10) / r14;
    L27:
        if (r5 >= r4) goto L29;
        float[][] r16 = this.values;
        float r17 = r16[r8][r5];
        float r110 = r16[r12][r5];
        float[][] r21 = this.tangents;
        r19.set$animation_core(r5, MonoSplineKt.hermiteInterpolate(r14, r15, r17, r110, r21[r8][r5], r21[r12][r5]));
        r5 = r5 + 1;
        goto L27
    L29:
        return;
    L21:
        if (r5 >= r4) goto L23;
        r19.set$animation_core(r5, this.values[r8][r5]);
        r5 = r5 + 1;
        goto L21
    L23:
        return;
    L19:
        r11 = false;
        goto L20
    L31:
        return;
    L5:
        r6 = r3 - 1;
        if (r18 >= r2[r6]) goto L9;
        r6 = -1;
        goto L9
    }

    public final void getSlope(float r18, AnimationVector r19, int r20) {
        float[] r2 = this.timePoints;
        float[][] r3 = this.values;
        float[][] r4 = this.tangents;
        int r5 = r2.length;
        int r6 = 0;
        int r7 = r3[0].length;
        if (r18 > r2[0]) goto L5;
        int r8 = 0;
    L9:
        if (r8 == (-1)) goto L16;
        float[] r9 = r4[r8];
        if (r9.length >= r7) goto L13;
        return;
    L13:
        if (r6 >= r7) goto L15;
        r19.set$animation_core(r6, r9[r6]);
        r6 = r6 + 1;
        goto L13
    L15:
        return;
    L16:
        int r10 = r5 - 1;
        int r11 = r20;
    L17:
        if (r11 >= r10) goto L24;
        int r12 = r11 + 1;
        float r13 = r2[r12];
        if (r18 <= r13) goto L20;
        r11 = r12;
        goto L17
    L20:
        float r14 = r2[r11];
        float r15 = r13 - r14;
        float r16 = (r18 - r14) / r15;
    L21:
        if (r6 >= r7) goto L29;
        r19.set$animation_core(r6, MonoSplineKt.hermiteDifferential(r15, r16, r3[r11][r6], r3[r12][r6], r4[r11][r6], r4[r12][r6]) / r15);
        r6 = r6 + 1;
        goto L21
    L29:
        return;
    L24:
        return;
    L5:
        r8 = r5 - 1;
        if (r18 >= r2[r8]) goto L9;
        r8 = -1;
        goto L9
    }

    public static /* synthetic */ void getPos$default(MonoSpline r0, float r1, AnimationVector r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.getPos(r1, r2, r3);
    }

    public static /* synthetic */ void getSlope$default(MonoSpline r0, float r1, AnimationVector r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.getSlope(r1, r2, r3);
    }
}
