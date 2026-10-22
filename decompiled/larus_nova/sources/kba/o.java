package kba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class o extends View {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float[] f502326s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float[] f502327t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final PathInterpolator f502328u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final PathInterpolator f502329v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f502330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f502331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f502332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[][] f502333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f502334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f502335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f502336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f502337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f502338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f502339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f502340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f502341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f502342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f502343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayDeque<Float> f502344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AnimatorSet f502345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatorSet f502346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f502347r;

    public static final class a {
    }

    public final void e() {
        this.f502339j = false;
        this.f502347r.cancel();
        this.f502344o.clear();
        AnimatorSet r100 = this.f502345p;
        this.f502345p = null;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        AnimatorSet r101 = this.f502346q;
        this.f502346q = null;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f502343n = false;
        this.f502340k = false;
        this.f502341l = 0;
        this.f502342m = 0.0f;
        this.f502332c = 0;
        this.f502331b = 0.0f;
        this.f502334e = 0.0f;
        this.f502335f = 0.0f;
        this.f502336g = 0.0f;
        this.f502337h = 0.0f;
        this.f502338i = 0.0f;
        invalidate();
    }

    static {
        f502326s = new float[]{5.5f, 9.8f, 14.2f, 3.7f, 19.5f};
        f502327t = new float[]{1.0f, 0.8f, 0.6f, 0.7f, 0.4f};
        f502328u = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        f502329v = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
    }

    public final void a() {
        float[][] r100 = this.f502333d;
        if (r100.length != 5) goto L16;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        boolean r103 = true;
        if (r102 >= r101) goto L14;
        if (r100[r102].length == 36) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L12;
        r102 = r102 + 1;
        goto L5
    L12:
        r103 = false;
    L14:
        if (r103 == false) goto L16;
        return;
    L16:
        float[][] r104 = new float[5][];
        int r105 = 0;
    L17:
        if (r105 >= 5) goto L19;
        r104[r105] = new float[36];
        r105 = r105 + 1;
        goto L17
    L19:
        this.f502333d = r104;
        int r106 = 0;
    L20:
        if (r106 >= 5) goto L25;
        int r107 = 0;
    L22:
        if (r107 >= 36) goto L24;
        this.f502333d[r106][r107] = Random.Default.nextFloat() * 6.2831855f;
        r107 = r107 + 1;
        goto L22
    L24:
        r106 = r106 + 1;
        goto L20
    }

    public final void c() {
        if (this.f502339j == true) goto L5;
        return;
    L5:
        if (this.f502346q == null) goto L7;
        return;
    L7:
        if (this.f502344o.isEmpty() == true) goto L13;
        float r100 = this.f502344o.removeFirst().floatValue();
        AnimatorSet r101 = new AnimatorSet();
        float r102 = this.f502334e;
        PathInterpolator r110 = f502328u;
        r101.playTogether(new Animator[]{g(r102, r100, 300, r110, new f(this)), g(this.f502335f, 0.0f, 300, r110, new g(this)), g(this.f502336g, 0.0f, 300, r110, new h(this))});
        r101.addListener(new p(this));
        r101.start();
        this.f502346q = r101;
        return;
    }

    public final void d() {
        if (this.f502339j == true) goto L5;
        return;
    L5:
        if (this.f502343n == true) goto L7;
        return;
    L7:
        if (isAttachedToWindow() == true) goto L9;
        return;
    L9:
        if (getWidth() > 0) goto L11;
        return;
    L11:
        if (getHeight() <= 0) goto L25;
        this.f502343n = false;
        AnimatorSet r100 = this.f502345p;
        this.f502345p = null;
        if (r100 == null) goto L16;
        r100.cancel();
    L16:
        AnimatorSet r101 = this.f502346q;
        this.f502346q = null;
        if (r101 == null) goto L19;
        r101.cancel();
    L19:
        this.f502334e = 0.0f;
        this.f502335f = 0.0f;
        this.f502336g = 0.0f;
        this.f502337h = 0.0f;
        this.f502338i = 0.0f;
        invalidate();
        PathInterpolator r102 = f502329v;
        ValueAnimator r103 = g(0.0f, 1.0f, 700, r102, new j(this));
        ValueAnimator r104 = g(0.0f, 1.0f, 700, r102, new k(this));
        ValueAnimator r105 = g(0.0f, 1.0f, 350, f502328u, new l(this));
        ValueAnimator r106 = g(0.0f, 1.0f, 1000, r102, new m(this));
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(new Animator[]{r103, r104, r105, r106});
        r107.addListener(new q(this));
        r107.start();
        this.f502345p = r107;
        return;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f502339j == true) goto L5;
        return;
    L5:
        if (isAttachedToWindow() == true) goto L7;
    L9:
        d();
        return;
    L7:
        if (this.f502347r.isRunning() == true) goto L9;
        this.f502347r.start();
        goto L9
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    public o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        r101.setColor(-1);
        this.f502330a = r101;
        this.f502333d = new float[0][];
        this.f502344o = new ArrayDeque();
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(1000);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new i(this));
        this.f502347r = r102;
        setImportantForAccessibility(2);
        setVisibility(4);
    }

    public final void b(boolean r100) {
        if (this.f502339j == true) goto L9;
        this.f502339j = true;
        this.f502340k = false;
        this.f502341l = SystemClock.uptimeMillis();
        this.f502342m = 0.0f;
        this.f502344o.clear();
        a();
        if (isAttachedToWindow() == false) goto L9;
        if (this.f502347r.isRunning() == true) goto L9;
        this.f502347r.start();
    L9:
        if (r100 == false) goto L11;
        this.f502343n = true;
    L11:
        d();
    }

    public final void f(float r100) {
        this.f502344o.addLast(Float.valueOf(r100));
        if (this.f502343n == false) goto L5;
        return;
    L5:
        if (this.f502345p != null) goto L14;
        AnimatorSet r101 = this.f502346q;
        if (r101 != null) goto L10;
        c();
        return;
    L10:
        r101.cancel();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        float r100 = getWidth();
        float r101 = getHeight();
        float r110 = 0.0f;
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        if (r101 <= 0.0f) goto L40;
        a();
        Resources r102 = getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        float r104 = 2.4f * r103;
        float r105 = 3.6f * r103;
        float r106 = 7.0f * r103;
        float r107 = 24.0f * r103;
        float r108 = r103 * 1.0f;
        float r109 = 60.0f * r103;
        float r111 = r103 * 6.0f;
        float r112 = 36;
        float r113 = 35;
        float r114 = (r112 * r104) + (r113 * r105);
        if (r114 > r100) goto L10;
    L12:
        float r115 = r104;
        float r116 = r109;
        float r117 = Math.min(1.0f, r101 / Math.max(1.0E-4f, r107));
        float r118 = r106 * r117;
        float r119 = r107 * r117;
        float r120 = r111 * r117;
        float r121 = r108 * r117;
        float r211 = r115 + r105;
        float r122 = (r112 * r115) + (r113 * r105);
        float r123 = (r100 - r122) * 0.5f;
        float r212 = r101 * 0.5f;
        int r124 = 0;
    L14:
        if (r124 >= 36) goto L41;
        int r125 = r124 + 1;
        if (this.f502334e <= r110) goto L22;
        int r126 = r125 - 1;
        int r127 = 0;
        float r128 = 0.0f;
        float r213 = 0.0f;
    L19:
        if (r127 >= 5) goto L21;
        float r129 = f502327t[r127];
        r213 = r213 + (((float) Math.sin((this.f502331b * f502326s[r127]) + this.f502333d[r127][r126])) * r129);
        r128 = r128 + r129;
        r127 = r127 + 1;
        goto L19
    L21:
        float r130 = (((((r119 - r118) * (((float) Math.pow(((RangesKt.coerceIn(1.7f * r213, -r128, r128) / r128) * 0.5f) + 0.5f, 1.6f)) * (((-0.5f) * (Math.abs((r126 / 35.0f) - 0.5f) * 2.0f)) + 1.0f))) + r118) - r118) * this.f502334e) + r118;
    L24:
        if (this.f502335f <= 0.0f) goto L26;
        float r131 = Math.abs(((r125 - 1) / 35.0f) - 0.5f) * 2.0f;
        float r132 = Math.max(0.075f, 0.001f);
        float r133 = RangesKt.coerceIn(((((this.f502336g * (r132 + 1.0f)) - r131) / r132) + 1.0f) * 0.5f, 0.0f, 1.0f);
        r130 = r130 + ((r120 - r130) * (((r133 * r133) * (3.0f - (r133 * 2.0f))) * this.f502335f));
    L26:
        r110 = 0.0f;
        if (this.f502337h <= 0.0f) goto L34;
        float r134 = r125 - 1;
        float r135 = (r134 * r211) + (r115 / 2.0f);
        float r136 = r122 / 2.0f;
        float r214 = r116 / 2.0f;
        float r137 = this.f502338i * (r136 + r214);
        float r138 = Math.min(Math.abs(r135 - (r136 - r137)), Math.abs(r135 - (r136 + r137)));
        if (r138 < r214) goto L31;
        float r139 = r118;
    L32:
        r130 = r130 + ((Math.max(r130, r139) - r130) * this.f502337h);
        goto L34
    L31:
        r139 = ((r119 - r118) * (((((float) Math.cos((r138 / r214) * 3.1415927f)) + 1.0f) / 2.0f) * (((-1.0f) * (Math.abs((r134 / 35.0f) - 0.5f) * 2.0f)) + 1.0f))) + r118;
    L34:
        float r140 = r123 + (r124 * r211);
        float r141 = RangesKt.coerceIn(r130, r118, r119) * 0.5f;
        r210.drawRoundRect(r140, r212 - r141, r140 + r115, r212 + r141, r121, r121, this.f502330a);
        r124 = r125;
        r119 = r119;
        r118 = r118;
        goto L14
    L22:
        r130 = r118;
        goto L24
    L41:
        return;
    L10:
        if (r114 <= 0.0f) goto L12;
        float r142 = r100 / r114;
        r104 = r104 * r142;
        r105 = r105 * r142;
        r108 = r108 * r142;
        r109 = r109 * r142;
        goto L12
    }

    public final void setAmplitude(float r100) {
        if (this.f502339j == true) goto L5;
        return;
    L5:
        long r101 = SystemClock.uptimeMillis();
        float r102 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (this.f502340k == true) goto L9;
        this.f502340k = true;
        this.f502341l = r101;
        this.f502342m = 0.0f;
        f(r102);
        return;
    L9:
        float r103 = Math.max(this.f502342m, r102);
        this.f502342m = r103;
        if ((r101 - this.f502341l) >= 400) goto L12;
        return;
    L12:
        this.f502342m = 0.0f;
        this.f502341l = r101;
        f(r103);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d();
    }

    public final ValueAnimator g(float r100, float r101, long r102, TimeInterpolator r103, final Function1<? super Float, Unit> r104) {
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r100, r101});
        r105.setDuration(r102);
        r105.setInterpolator(r103);
        r105.addUpdateListener(new n(r104, this));
        return r105;
    }
}
