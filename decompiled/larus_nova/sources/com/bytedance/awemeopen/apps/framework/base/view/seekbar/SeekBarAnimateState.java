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

/* JADX INFO: loaded from: classes14.dex */
public final class SeekBarAnimateState {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy<h> f193619p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final SeekBarAnimateState f193620q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final SeekBarAnimateState f193621r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final SeekBarAnimateState f193622s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final SeekBarAnimateState f193623t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final SeekBarAnimateState f193624u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final SeekBarAnimateState f193625v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final SeekBarAnimateState f193626w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy<ArgbEvaluator> f193627x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f193628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f193629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f193630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f193631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f193632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f193633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f193634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f193635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f193636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f193637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f193638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f193639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Interpolator f193640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f193641n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f193642o;

    public static final class a {
        public a() {
        }
    }

    public SeekBarAnimateState() {
        this(0.0f, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, false, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SeekBarAnimateState) == true) goto L8;
        return false;
    L8:
        SeekBarAnimateState r101 = (SeekBarAnimateState) r100;
        if (Float.compare(this.f193628a, r101.f193628a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f193629b, r101.f193629b) == 0) goto L15;
        return false;
    L15:
        if (this.f193630c == r101.f193630c) goto L18;
        return false;
    L18:
        if (this.f193631d == r101.f193631d) goto L21;
        return false;
    L21:
        if (this.f193632e == r101.f193632e) goto L24;
        return false;
    L24:
        if (this.f193633f == r101.f193633f) goto L27;
        return false;
    L27:
        if (this.f193634g == r101.f193634g) goto L30;
        return false;
    L30:
        if (this.f193635h == r101.f193635h) goto L33;
        return false;
    L33:
        if (this.f193636i == r101.f193636i) goto L36;
        return false;
    L36:
        if (this.f193637j == r101.f193637j) goto L39;
        return false;
    L39:
        if (Float.compare(this.f193638k, r101.f193638k) == 0) goto L42;
        return false;
    L42:
        if (this.f193639l == r101.f193639l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f193640m, r101.f193640m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f193641n, r101.f193641n) == true) goto L51;
        return false;
    L51:
        if (this.f193642o == r101.f193642o) goto L53;
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
        int r100 = ((Float.floatToIntBits(this.f193628a) * 31) + Float.floatToIntBits(this.f193629b)) * 31;
        long r101 = this.f193630c;
        int r102 = (((((((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f193631d) * 31) + this.f193632e) * 31) + this.f193633f) * 31) + this.f193634g) * 31) + this.f193635h) * 31) + this.f193636i) * 31) + this.f193637j) * 31) + Float.floatToIntBits(this.f193638k)) * 31;
        boolean r103 = this.f193639l;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L5;
        r105 = 1;
    L5:
        int r106 = (((r102 + r105) * 31) + this.f193640m.hashCode()) * 31;
        String r107 = this.f193641n;
        if (r107 != null) goto L8;
        int r108 = 0;
    L9:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f193642o;
        if (r110 == true) goto L14;
        r104 = r110;
    L14:
        return r109 + r104;
    L8:
        r108 = r107.hashCode();
        goto L9
    }

    public final String toString() {
        return "SeekBarAnimateState(animateProgress=" + this.f193628a + ", globalAlpha=" + this.f193629b + ", duration=" + this.f193630c + ", marginHorizontal=" + this.f193631d + ", barHeight=" + this.f193632e + ", progressAlpha=" + this.f193633f + ", backgroundColor=" + this.f193634g + ", thumbAlpha=" + this.f193635h + ", thumbWidth=" + this.f193636i + ", thumbHeight=" + this.f193637j + ", translationY=" + this.f193638k + ", needStroke=" + this.f193639l + ", interpolator=" + this.f193640m + ", aid=" + this.f193641n + ", isLoadingState=" + this.f193642o + ')';
    }

    static {
        new a();
        f193619p = LazyKt.lazy(SeekBarAnimateState$Companion$defaultInterpolator$2.INSTANCE);
        f193620q = new SeekBarAnimateState(0.0f, 0.0f, 0, 0, 0, 0, 0, 87, 0, 0, 0.0f, false, 32639);
        float r100 = 12;
        float r101 = 6;
        SeekBarAnimateState r102 = new SeekBarAnimateState(0.0f, 0.0f, 0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), 255, 872415231, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), 0.0f, false, 31887);
        f193621r = r102;
        float r110 = 8;
        float r111 = 28;
        SeekBarAnimateState r103 = new SeekBarAnimateState(0.0f, 0.0f, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111, a(Resources.getSystem()))), 204, -13092808, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 24, a(Resources.getSystem()))), 0.0f, false, 31879);
        f193622s = r103;
        float r104 = 50;
        f193623t = b(r102, MathKt.roundToInt(TypedValue.applyDimension(1, r104, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), 31975);
        f193624u = b(r102, MathKt.roundToInt(TypedValue.applyDimension(1, r104, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), 31975);
        float r105 = 16;
        f193625v = b(r103, MathKt.roundToInt(TypedValue.applyDimension(1, r104, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r105, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), 31975);
        f193626w = new SeekBarAnimateState(0.0f, 1.0f, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 10, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r111, a(Resources.getSystem()))), 204, 872415231, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r110, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r105, a(Resources.getSystem()))), TypedValue.applyDimension(1, -6, a(Resources.getSystem())), true, 28805);
        f193627x = LazyKt.lazy(SeekBarAnimateState$Companion$argbEvaluator$2.INSTANCE);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static SeekBarAnimateState b(SeekBarAnimateState r210, int r211, int r212, int r213, int r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        float r100 = r210.f193628a;
    L7:
        if ((r215 & 2) == 0) goto L9;
        float r101 = r210.f193629b;
    L11:
        if ((r215 & 4) == 0) goto L13;
        long r102 = r210.f193630c;
    L15:
        if ((r215 & 8) == 0) goto L17;
        int r103 = r210.f193631d;
    L19:
        if ((r215 & 16) == 0) goto L21;
        int r110 = r210.f193632e;
    L23:
        if ((r215 & 32) == 0) goto L25;
        int r111 = r210.f193633f;
    L27:
        if ((r215 & 64) == 0) goto L29;
        int r112 = r210.f193634g;
    L31:
        if ((r215 & 128) == 0) goto L33;
        int r113 = r210.f193635h;
    L35:
        if ((r215 & 256) == 0) goto L37;
        int r114 = r210.f193636i;
    L39:
        if ((r215 & 512) == 0) goto L41;
        int r115 = r210.f193637j;
    L43:
        if ((r215 & 1024) == 0) goto L45;
        float r116 = r210.f193638k;
    L47:
        if ((r215 & 2048) == 0) goto L49;
        boolean r117 = r210.f193639l;
    L51:
        if ((r215 & 4096) == 0) goto L53;
        Interpolator r104 = r210.f193640m;
    L55:
        if ((r215 & 8192) == 0) goto L57;
        String r118 = r210.f193641n;
    L59:
        if ((r215 & 16384) == 0) goto L61;
        boolean r216 = r210.f193642o;
    L62:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r104, "interpolator");
        return new SeekBarAnimateState(r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r104, r118, r216);
    L61:
        r216 = false;
        goto L62
    L57:
        r118 = null;
        goto L59
    L53:
        r104 = null;
        goto L55
    L49:
        r117 = false;
        goto L51
    L45:
        r116 = 0.0f;
        goto L47
    L41:
        r115 = r214;
        goto L43
    L37:
        r114 = r213;
        goto L39
    L33:
        r113 = 0;
        goto L35
    L29:
        r112 = 0;
        goto L31
    L25:
        r111 = 0;
        goto L27
    L21:
        r110 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r101 = 0.0f;
        goto L11
    L5:
        r100 = 0.0f;
        goto L7
    }

    public SeekBarAnimateState(float r210, float r211, long r212, int r213, int r214, int r215, int r216, int r217, int r310, int r311, float r312, boolean r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        float r100 = 1.0f;
    L7:
        if ((r314 & 2) == 0) goto L9;
        float r101 = 1.0f;
    L11:
        if ((r314 & 4) == 0) goto L13;
        long r102 = 400;
    L15:
        if ((r314 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r314 & 16) == 0) goto L21;
        int r104 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, a(Resources.getSystem())));
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r110 = 51;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r111 = 352321535;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r112 = 255;
    L35:
        if ((r314 & 256) == 0) goto L37;
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, a(Resources.getSystem())));
    L39:
        if ((r314 & 512) == 0) goto L41;
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, a(Resources.getSystem())));
    L43:
        if ((r314 & 1024) == 0) goto L45;
        float r114 = 0.0f;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        boolean r115 = false;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        h r106 = f193619p.getValue();
    L54:
        this(r100, r101, r102, r103, r104, r110, r111, r112, r105, r113, r114, r115, r106, null, false);
        return;
    L53:
        r106 = null;
        goto L54
    L49:
        r115 = r313;
        goto L51
    L45:
        r114 = r312;
        goto L47
    L41:
        r113 = r311;
        goto L43
    L37:
        r105 = r310;
        goto L39
    L33:
        r112 = r217;
        goto L35
    L29:
        r111 = r216;
        goto L31
    L25:
        r110 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public SeekBarAnimateState(float r100, float r101, long r102, int r103, int r110, int r111, int r112, int r113, int r114, int r115, float r116, boolean r117, Interpolator r118, String r119, boolean r210) {
        Intrinsics.checkNotNullParameter(r118, "interpolator");
        this.f193628a = r100;
        this.f193629b = r101;
        this.f193630c = r102;
        this.f193631d = r103;
        this.f193632e = r110;
        this.f193633f = r111;
        this.f193634g = r112;
        this.f193635h = r113;
        this.f193636i = r114;
        this.f193637j = r115;
        this.f193638k = r116;
        this.f193639l = r117;
        this.f193640m = r118;
        this.f193641n = r119;
        this.f193642o = r210;
    }
}
