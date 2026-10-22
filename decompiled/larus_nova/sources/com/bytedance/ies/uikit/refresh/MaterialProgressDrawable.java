package com.bytedance.ies.uikit.refresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class MaterialProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Interpolator f249137k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f249138l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f249139m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f249140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f249141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f249142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Resources f249143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f249144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ies.uikit.refresh.a f249145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f249146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f249147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f249148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f249149j;

    @Retention(RetentionPolicy.CLASS)
    public @interface ProgressDrawableSize {
    }

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialProgressDrawable f249150a;

        public a(MaterialProgressDrawable r100) {
            this.f249150a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f249150a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f249150a.unscheduleSelf(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f249150a.scheduleSelf(r101, r102);
        }
    }

    public static class b extends AccelerateDecelerateInterpolator {
        public b() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return super.getInterpolation(Math.max(0.0f, (r100 - 0.5f) * 2.0f));
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f249151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f249152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f249153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f249154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f249155e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f249156f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f249157g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f249158h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f249159i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f249160j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f249161k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f249162l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f249163m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f249164n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f249165o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Path f249166p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f249167q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f249168r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f249169s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f249170t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f249171u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Paint f249172v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f249173w;

        public final void a() {
            this.f249154d.invalidateDrawable(null);
        }

        public c(a r100) {
            this.f249151a = new RectF();
            Paint r101 = new Paint();
            this.f249152b = r101;
            Paint r102 = new Paint();
            this.f249153c = r102;
            this.f249155e = 0.0f;
            this.f249156f = 0.0f;
            this.f249157g = 0.0f;
            this.f249158h = 5.0f;
            this.f249159i = 2.5f;
            this.f249172v = new Paint();
            this.f249154d = r100;
            r101.setStrokeCap(Paint.Cap.SQUARE);
            r101.setAntiAlias(true);
            r101.setStyle(Paint.Style.STROKE);
            r102.setStyle(Paint.Style.FILL);
            r102.setAntiAlias(true);
        }
    }

    public static class d extends AccelerateDecelerateInterpolator {
        public d() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return super.getInterpolation(Math.min(1.0f, r100 * 2.0f));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    static {
        f249137k = new LinearInterpolator();
        f249138l = new b();
        f249139m = new d();
        new AccelerateDecelerateInterpolator();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f249141b.f249171u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f249148i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f249147h;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f249140a;
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        Animation r103 = (Animation) ListProtector.get(r100, r102);
        if (r103.hasStarted() == false) goto L10;
        if (r103.hasEnded() == true) goto L10;
        return true;
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f249145f.reset();
        c r100 = this.f249141b;
        float r101 = r100.f249155e;
        r100.f249162l = r101;
        float r102 = r100.f249156f;
        r100.f249163m = r102;
        r100.f249164n = r100.f249157g;
        if (r102 == r101) goto L5;
        this.f249149j = true;
        this.f249145f.setDuration(666);
        this.f249144e.startAnimation(this.f249145f);
        return;
    L5:
        r100.f249161k = 0;
        r100.f249162l = 0.0f;
        r100.f249163m = 0.0f;
        r100.f249164n = 0.0f;
        r100.f249155e = 0.0f;
        r100.a();
        r100.f249156f = 0.0f;
        r100.a();
        r100.f249157g = 0.0f;
        r100.a();
        this.f249145f.setDuration(1333);
        this.f249144e.startAnimation(this.f249145f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f249144e.clearAnimation();
        this.f249142c = 0.0f;
        invalidateSelf();
        c r100 = this.f249141b;
        if (r100.f249165o == false) goto L5;
        r100.f249165o = false;
        r100.a();
    L5:
        c r101 = this.f249141b;
        r101.f249161k = 0;
        r101.f249162l = 0.0f;
        r101.f249163m = 0.0f;
        r101.f249164n = 0.0f;
        r101.f249155e = 0.0f;
        r101.a();
        r101.f249156f = 0.0f;
        r101.a();
        r101.f249157g = 0.0f;
        r101.a();
    }

    public final void b(int r210) {
        if (r210 != 0) goto L4;
        a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        return;
    L4:
        a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r110.save();
        r110.rotate(this.f249142c, r100.exactCenterX(), r100.exactCenterY());
        c r102 = this.f249141b;
        RectF r103 = r102.f249151a;
        r103.set(r100);
        float r104 = r102.f249159i;
        r103.inset(r104, r104);
        float r105 = r102.f249155e;
        float r106 = r102.f249157g;
        float r107 = (r105 + r106) * 360.0f;
        float r111 = ((r102.f249156f + r106) * 360.0f) - r107;
        r102.f249152b.setColor(r102.f249160j[r102.f249161k]);
        r110.drawArc(r103, r107, r111, false, r102.f249152b);
        if (r102.f249165o == false) goto L10;
        Path r108 = r102.f249166p;
        if (r108 != null) goto L7;
        Path r109 = new Path();
        r102.f249166p = r109;
        r109.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r112 = (((int) r102.f249159i) / 2) * r102.f249167q;
        float r113 = (float) ((r102.f249168r * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterX()));
        float r114 = (float) ((r102.f249168r * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterY()));
        r102.f249166p.moveTo(0.0f, 0.0f);
        r102.f249166p.lineTo(r102.f249169s * r102.f249167q, 0.0f);
        Path r115 = r102.f249166p;
        float r116 = r102.f249169s;
        float r117 = r102.f249167q;
        r115.lineTo((r116 * r117) / 2.0f, r102.f249170t * r117);
        r102.f249166p.offset(r113 - r112, r114);
        r102.f249166p.close();
        r102.f249153c.setColor(r102.f249160j[r102.f249161k]);
        r110.rotate((r107 + r111) - 5.0f, r100.exactCenterX(), r100.exactCenterY());
        r110.drawPath(r102.f249166p, r102.f249153c);
        goto L10
    L7:
        r108.reset();
    L10:
        if (r102.f249171u >= 255) goto L12;
        r102.f249172v.setColor(r102.f249173w);
        r102.f249172v.setAlpha(255 - r102.f249171u);
        r110.drawCircle(r100.exactCenterX(), r100.exactCenterY(), r100.width() / 2, r102.f249172v);
    L12:
        r110.restoreToCount(r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f249141b.f249171u = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        c r101 = this.f249141b;
        r101.f249152b.setColorFilter(r100);
        r101.a();
    }

    public MaterialProgressDrawable(Context r100, View r101) {
        this.f249140a = new ArrayList();
        a r102 = new a(this);
        this.f249144e = r101;
        this.f249143d = r100.getResources();
        c r103 = new c(r102);
        this.f249141b = r103;
        r103.f249160j = new int[]{-16777216};
        r103.f249161k = 0;
        b(1);
        com.bytedance.ies.uikit.refresh.a r104 = new com.bytedance.ies.uikit.refresh.a(this, r103);
        r104.setRepeatCount(-1);
        r104.setRepeatMode(1);
        r104.setInterpolator(f249137k);
        r104.setAnimationListener(new com.bytedance.ies.uikit.refresh.b(this, r103));
        this.f249145f = r104;
    }

    public final void a(double r100, double r101, double r102, double r110, float r111, float r112) {
        c r103 = this.f249141b;
        Resources r104 = this.f249143d;
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        double r106 = r105;
        this.f249147h = r100 * r106;
        this.f249148i = r101 * r106;
        float r107 = ((float) r110) * r105;
        r103.f249158h = r107;
        r103.f249152b.setStrokeWidth(r107);
        r103.a();
        r103.f249168r = r102 * r106;
        r103.f249161k = 0;
        r103.f249169s = (int) (r111 * r105);
        r103.f249170t = (int) (r112 * r105);
        float r108 = Math.min((int) this.f249147h, (int) this.f249148i);
        double r109 = r103.f249168r;
        if (r109 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r113 = Math.ceil(r103.f249158h / 2.0f);
    L9:
        r103.f249159i = (float) r113;
        return;
    L5:
        if (r108 < 0.0f) goto L8;
        r113 = ((double) (r108 / 2.0f)) - r109;
        goto L9
    }
}
