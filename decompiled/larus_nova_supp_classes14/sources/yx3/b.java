package yx3;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.CustomizedUISeekBar;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SeekBarDrawerPriority;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SeekBarState;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.d;
import com.bytedance.awemeopen.infra.util.o;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends com.bytedance.awemeopen.apps.framework.base.view.seekbar.a {
    public static final int w = 0;
    public final CustomizedUISeekBar a;
    public final Bitmap b;
    public final Bitmap c;
    public final Rect d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public int l;
    public int m;
    public int n;
    public double o;
    public final RectF p;
    public final Path q;
    public final long r;
    public long s;
    public long t;
    public ValueAnimator u;
    public boolean v;

    public static final class a {
    }

    static {
        Resources r1 = Resources.getSystem();
        w = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.a
    public final boolean a() {
        if (this.v == true) goto L5;
    L11:
        return false;
    L5:
        if (this.a.getState() == SeekBarState.State.DRAGGING) goto L11;
        if (this.b == null) goto L11;
        if (this.c == null) goto L11;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.a
    public final int c() {
        return SeekBarDrawerPriority.BUFFER_BLOCK.ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(CustomizedUISeekBar r11) {
        Intrinsics.checkNotNullParameter(r11, "seekBar");
        super(r11);
        this.a = r11;
        Drawable r0 = AppCompatResources.getDrawable(r11.getContext(), 2131231405);
        Drawable r1 = AppCompatResources.getDrawable(r11.getContext(), 2131231406);
        Bitmap r4 = null;
        if (r0 == null) goto L5;
        String r6 = o.a;
        int r7 = o.a(r11.getContext());
        Resources r8 = Resources.getSystem();
        int r9 = r7 - MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())));
        Resources r10 = Resources.getSystem();
        Bitmap r2 = d.a(r0, r9, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()))));
    L6:
        this.b = r2;
        if (r1 == null) goto L9;
        String r3 = o.a;
        int r12 = o.a(r11.getContext());
        Resources r5 = Resources.getSystem();
        int r13 = r12 - MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
        Resources r14 = Resources.getSystem();
        r4 = d.a(r1, r13, MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()))));
    L9:
        this.c = r4;
        this.d = new Rect();
        this.k = 1.0f;
        this.p = new RectF();
        this.q = new Path();
        this.r = 1500;
        this.s = 700;
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.a
    public final void b(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        this.i = this.a.getWidth();
        this.j = this.a.getHeight();
        this.e = this.a.getPaddingLeft();
        this.f = this.a.getPaddingTop();
        this.g = this.a.getPaddingRight();
        this.h = this.a.getPaddingBottom();
        this.l = (this.i - this.e) - this.g;
        float r0 = (this.a.getProgress() * 1.0f) / this.a.getMax();
        this.k = r0;
        int r1 = (int) (this.l * r0);
        this.m = r1;
        if (r1 <= w) goto L5;
        boolean r2 = false;
    L7:
        if (r2 == false) goto L17;
        Bitmap r3 = this.c;
        if (r3 != null) goto L11;
        return;
    L11:
        if (this.t != 0) goto L13;
        this.t = System.currentTimeMillis();
        return;
    L13:
        double r7 = (System.currentTimeMillis() - this.t) / this.r;
        this.o = r7;
        int r4 = this.l;
        this.n = (int) ((((double) 2) * r7) * ((double) r4));
        if (r7 < 1.0d) goto L16;
        this.n = r4 * 2;
        this.t = System.currentTimeMillis();
    L16:
        int r5 = this.n + this.e;
        this.d.set(r5 - this.l, this.f, r5, this.j - this.h);
        this.p.set(this.e, this.f, this.i - this.g, this.j - this.h);
        this.q.reset();
        Path r6 = this.q;
        RectF r8 = this.p;
        float r9 = ((this.j - this.f) - this.h) / 2.0f;
        r6.addRoundRect(r8, r9, r9, Path.Direction.CW);
        r15.save();
        r15.clipPath(this.q);
        r15.drawBitmap(r3, null, this.d, null);
        r15.restore();
        return;
    L17:
        Bitmap r10 = this.b;
        if (r10 != null) goto L20;
        return;
    L20:
        if (this.t != 0) goto L22;
        this.t = System.currentTimeMillis();
        return;
    L22:
        long r11 = System.currentTimeMillis();
        if (this.k <= 0.5d) goto L25;
        this.s = 900;
    L26:
        double r12 = (r11 - this.t) / this.s;
        this.o = r12;
        double r13 = (((double) 1) - Math.cos(r12 * 3.141592653589793d)) / ((double) 2);
        int r14 = this.m;
        this.n = (int) (r13 * ((double) r14));
        if (this.o < 1.0d) goto L29;
        this.n = r14;
        this.t = System.currentTimeMillis();
    L29:
        int r16 = this.n;
        int r17 = this.e;
        this.d.set(r17, this.f, r16 + r17, this.j - this.h);
        this.p.set(this.e, this.f, this.i - this.g, this.j - this.h);
        this.q.reset();
        Path r18 = this.q;
        RectF r19 = this.p;
        float r20 = ((this.j - this.f) - this.h) / 2.0f;
        r18.addRoundRect(r19, r20, r20, Path.Direction.CW);
        r15.save();
        r15.clipPath(this.q);
        r15.drawBitmap(r10, null, this.d, null);
        r15.restore();
        return;
    L25:
        this.s = 700;
        goto L26
    L5:
        r2 = true;
        goto L7
    }

    public final void d(boolean r3) {
        this.v = r3;
        if (r3 == false) goto L8;
        ValueAnimator r4 = this.u;
        if (r4 == null) goto L7;
        r4.cancel();
    L7:
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r5.setDuration(1000);
        r5.setInterpolator(new LinearInterpolator());
        r5.setRepeatMode(1);
        r5.setRepeatCount(-1);
        r5.addUpdateListener(new yx3.a(this));
        this.u = r5;
        r5.start();
        this.t = 0;
        this.a.invalidate();
        return;
    L8:
        ValueAnimator r6 = this.u;
        if (r6 == null) goto L11;
        r6.cancel();
    L11:
        this.u = null;
        this.a.invalidate();
    }
}
