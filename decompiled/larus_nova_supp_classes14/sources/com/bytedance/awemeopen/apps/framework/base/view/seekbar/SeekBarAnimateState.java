package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.animation.ArgbEvaluator;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.animation.Interpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SeekBarAnimateState {
    public static final Lazy<h> p = null;
    public static final SeekBarAnimateState q = null;
    public static final SeekBarAnimateState r = null;
    public static final SeekBarAnimateState s = null;
    public static final SeekBarAnimateState t = null;
    public static final SeekBarAnimateState u = null;
    public static final SeekBarAnimateState v = null;
    public static final SeekBarAnimateState w = null;
    public static final Lazy<ArgbEvaluator> x = null;
    public final float a;
    public final float b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final float k;
    public final boolean l;
    public final Interpolator m;
    public final String n;
    public final boolean o;

    public static final class a {
        public a() {
        }
    }

    public SeekBarAnimateState() {
        this(0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, false, 32767);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SeekBarAnimateState) == true) goto L8;
        return false;
    L8:
        SeekBarAnimateState r9 = (SeekBarAnimateState) r8;
        if (Float.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r9.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Float.compare(this.k, r9.k) == 0) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L53;
        return false;
    L53:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        int r0 = ((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31;
        long r1 = this.c;
        int r2 = (((((((((((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + Float.floatToIntBits(this.k)) * 31;
        boolean r3 = this.l;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L5;
        r5 = 1;
    L5:
        int r6 = (((r2 + r5) * 31) + this.m.hashCode()) * 31;
        String r7 = this.n;
        if (r7 != null) goto L8;
        int r8 = 0;
    L9:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.o;
        if (r10 == true) goto L14;
        r4 = r10;
    L14:
        return r9 + r4;
    L8:
        r8 = r7.hashCode();
        goto L9
    }

    public final String toString() {
        return "SeekBarAnimateState(animateProgress=" + this.a + ", globalAlpha=" + this.b + ", duration=" + this.c + ", marginHorizontal=" + this.d + ", barHeight=" + this.e + ", progressAlpha=" + this.f + ", backgroundColor=" + this.g + ", thumbAlpha=" + this.h + ", thumbWidth=" + this.i + ", thumbHeight=" + this.j + ", translationY=" + this.k + ", needStroke=" + this.l + ", interpolator=" + this.m + ", aid=" + this.n + ", isLoadingState=" + this.o + ')';
    }

    static {
        new a();
        p = LazyKt.lazy(SeekBarAnimateState$Companion$defaultInterpolator$2.INSTANCE);
        q = new SeekBarAnimateState(0.0f, 0.0f, 0, 0, 0, 0, 0, 87, 0, 0, 0.0f, false, 32639);
        float r1 = 12;
        float r2 = 6;
        SeekBarAnimateState r0 = new SeekBarAnimateState(0.0f, 0.0f, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r1, a(Resources.getSystem()))), 255, 872415231, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r2, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r2, a(Resources.getSystem()))), 0.0f, false, 31887);
        r = r0;
        float r15 = 8;
        float r14 = 28;
        SeekBarAnimateState r3 = new SeekBarAnimateState(0.0f, 0.0f, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r14, a(Resources.getSystem()))), 204, -13092808, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 24, a(Resources.getSystem()))), 0.0f, false, 31879);
        s = r3;
        float r4 = 50;
        t = b(r0, MathKt.roundToInt(TypedValue.applyDimension(1, r4, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), 31975);
        u = b(r0, MathKt.roundToInt(TypedValue.applyDimension(1, r4, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), 31975);
        float r5 = 16;
        v = b(r3, MathKt.roundToInt(TypedValue.applyDimension(1, r4, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r5, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r1, a(Resources.getSystem()))), 31975);
        w = new SeekBarAnimateState(0.0f, 1.0f, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 10, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r14, a(Resources.getSystem()))), 204, 872415231, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r15, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r5, a(Resources.getSystem()))), TypedValue.applyDimension(1, -6, a(Resources.getSystem())), true, 28805);
        x = LazyKt.lazy(SeekBarAnimateState$Companion$argbEvaluator$2.INSTANCE);
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static SeekBarAnimateState b(SeekBarAnimateState r21, int r22, int r23, int r24, int r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        float r5 = r21.a;
    L7:
        if ((r26 & 2) == 0) goto L9;
        float r6 = r21.b;
    L11:
        if ((r26 & 4) == 0) goto L13;
        long r7 = r21.c;
    L15:
        if ((r26 & 8) == 0) goto L17;
        int r9 = r21.d;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r10 = r21.e;
    L23:
        if ((r26 & 32) == 0) goto L25;
        int r11 = r21.f;
    L27:
        if ((r26 & 64) == 0) goto L29;
        int r12 = r21.g;
    L31:
        if ((r26 & 128) == 0) goto L33;
        int r13 = r21.h;
    L35:
        if ((r26 & 256) == 0) goto L37;
        int r14 = r21.i;
    L39:
        if ((r26 & 512) == 0) goto L41;
        int r15 = r21.j;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        float r16 = r21.k;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        boolean r17 = r21.l;
    L51:
        if ((r26 & 4096) == 0) goto L53;
        Interpolator r2 = r21.m;
    L55:
        if ((r26 & 8192) == 0) goto L57;
        String r19 = r21.n;
    L59:
        if ((r26 & 16384) == 0) goto L61;
        boolean r20 = r21.o;
    L62:
        r21.getClass();
        Intrinsics.checkNotNullParameter(r2, "interpolator");
        return new SeekBarAnimateState(r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r2, r19, r20);
    L61:
        r20 = false;
        goto L62
    L57:
        r19 = null;
        goto L59
    L53:
        r2 = null;
        goto L55
    L49:
        r17 = false;
        goto L51
    L45:
        r16 = 0.0f;
        goto L47
    L41:
        r15 = r25;
        goto L43
    L37:
        r14 = r24;
        goto L39
    L33:
        r13 = 0;
        goto L35
    L29:
        r12 = 0;
        goto L31
    L25:
        r11 = 0;
        goto L27
    L21:
        r10 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r7 = 0;
        goto L15
    L9:
        r6 = 0.0f;
        goto L11
    L5:
        r5 = 0.0f;
        goto L7
    }

    public SeekBarAnimateState(float r21, float r22, long r23, int r25, int r26, int r27, int r28, int r29, int r30, int r31, float r32, boolean r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        float r4 = 1.0f;
    L7:
        if ((r34 & 2) == 0) goto L9;
        float r5 = 1.0f;
    L11:
        if ((r34 & 4) == 0) goto L13;
        long r6 = 400;
    L15:
        if ((r34 & 8) == 0) goto L17;
        int r8 = 0;
    L19:
        if ((r34 & 16) == 0) goto L21;
        int r9 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, a(Resources.getSystem())));
    L23:
        if ((r34 & 32) == 0) goto L25;
        int r10 = 51;
    L27:
        if ((r34 & 64) == 0) goto L29;
        int r11 = 352321535;
    L31:
        if ((r34 & 128) == 0) goto L33;
        int r12 = 255;
    L35:
        if ((r34 & 256) == 0) goto L37;
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, a(Resources.getSystem())));
    L39:
        if ((r34 & 512) == 0) goto L41;
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, a(Resources.getSystem())));
    L43:
        if ((r34 & 1024) == 0) goto L45;
        float r15 = 0.0f;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        boolean r16 = false;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        h r0 = (h) p.getValue();
    L54:
        this(r4, r5, r6, r8, r9, r10, r11, r12, r1, r14, r15, r16, r0, null, false);
        return;
    L53:
        r0 = null;
        goto L54
    L49:
        r16 = r33;
        goto L51
    L45:
        r15 = r32;
        goto L47
    L41:
        r14 = r31;
        goto L43
    L37:
        r1 = r30;
        goto L39
    L33:
        r12 = r29;
        goto L35
    L29:
        r11 = r28;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r5 = r22;
        goto L11
    L5:
        r4 = r21;
        goto L7
    }

    public SeekBarAnimateState(float r5, float r6, long r7, int r9, int r10, int r11, int r12, int r13, int r14, int r15, float r16, boolean r17, Interpolator r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "interpolator");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
    }
}
