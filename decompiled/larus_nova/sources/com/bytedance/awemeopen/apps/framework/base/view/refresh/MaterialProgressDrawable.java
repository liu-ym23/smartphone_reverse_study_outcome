package com.bytedance.awemeopen.apps.framework.base.view.refresh;

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

/* JADX INFO: loaded from: classes14.dex */
public final class MaterialProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Interpolator f193380k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f193381l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f193382m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f193383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f193384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f193385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Resources f193386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f193387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f193388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f193389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f193390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f193391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f193392j;

    @Retention(RetentionPolicy.CLASS)
    public @interface ProgressDrawableSize {
    }

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialProgressDrawable f193393a;

        public a(MaterialProgressDrawable r100) {
            this.f193393a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f193393a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f193393a.unscheduleSelf(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f193393a.scheduleSelf(r101, r102);
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
        public final RectF f193394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f193395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f193396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f193397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f193398e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f193399f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f193400g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f193401h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f193402i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f193403j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f193404k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f193405l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f193406m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f193407n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f193408o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Path f193409p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f193410q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f193411r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f193412s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f193413t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f193414u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Paint f193415v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f193416w;

        public final void a() {
            this.f193397d.invalidateDrawable(null);
        }

        public c(a r100) {
            this.f193394a = new RectF();
            Paint r101 = new Paint();
            this.f193395b = r101;
            Paint r102 = new Paint();
            this.f193396c = r102;
            this.f193398e = 0.0f;
            this.f193399f = 0.0f;
            this.f193400g = 0.0f;
            this.f193401h = 5.0f;
            this.f193402i = 2.5f;
            this.f193415v = new Paint();
            this.f193397d = r100;
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
        f193380k = new LinearInterpolator();
        f193381l = new b();
        f193382m = new d();
        new AccelerateDecelerateInterpolator();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f193384b.f193414u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f193391i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f193390h;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f193383a;
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
        this.f193388f.reset();
        c r100 = this.f193384b;
        float r101 = r100.f193398e;
        r100.f193405l = r101;
        float r102 = r100.f193399f;
        r100.f193406m = r102;
        r100.f193407n = r100.f193400g;
        if (r102 == r101) goto L5;
        this.f193392j = true;
        this.f193388f.setDuration(666);
        this.f193387e.startAnimation(this.f193388f);
        return;
    L5:
        r100.f193404k = 0;
        r100.f193405l = 0.0f;
        r100.f193406m = 0.0f;
        r100.f193407n = 0.0f;
        r100.f193398e = 0.0f;
        r100.a();
        r100.f193399f = 0.0f;
        r100.a();
        r100.f193400g = 0.0f;
        r100.a();
        this.f193388f.setDuration(1333);
        this.f193387e.startAnimation(this.f193388f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f193387e.clearAnimation();
        this.f193385c = 0.0f;
        invalidateSelf();
        c r100 = this.f193384b;
        if (r100.f193408o == false) goto L5;
        r100.f193408o = false;
        r100.a();
    L5:
        c r101 = this.f193384b;
        r101.f193404k = 0;
        r101.f193405l = 0.0f;
        r101.f193406m = 0.0f;
        r101.f193407n = 0.0f;
        r101.f193398e = 0.0f;
        r101.a();
        r101.f193399f = 0.0f;
        r101.a();
        r101.f193400g = 0.0f;
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
        r110.rotate(this.f193385c, r100.exactCenterX(), r100.exactCenterY());
        c r102 = this.f193384b;
        RectF r103 = r102.f193394a;
        r103.set(r100);
        float r104 = r102.f193402i;
        r103.inset(r104, r104);
        float r105 = r102.f193398e;
        float r106 = r102.f193400g;
        float r107 = (r105 + r106) * 360.0f;
        float r111 = ((r102.f193399f + r106) * 360.0f) - r107;
        r102.f193395b.setColor(r102.f193403j[r102.f193404k]);
        r110.drawArc(r103, r107, r111, false, r102.f193395b);
        if (r102.f193408o == false) goto L10;
        Path r108 = r102.f193409p;
        if (r108 != null) goto L7;
        Path r109 = new Path();
        r102.f193409p = r109;
        r109.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r112 = (((int) r102.f193402i) / 2) * r102.f193410q;
        float r113 = (float) ((r102.f193411r * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterX()));
        float r114 = (float) ((r102.f193411r * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterY()));
        r102.f193409p.moveTo(0.0f, 0.0f);
        r102.f193409p.lineTo(r102.f193412s * r102.f193410q, 0.0f);
        Path r115 = r102.f193409p;
        float r116 = r102.f193412s;
        float r117 = r102.f193410q;
        r115.lineTo((r116 * r117) / 2.0f, r102.f193413t * r117);
        r102.f193409p.offset(r113 - r112, r114);
        r102.f193409p.close();
        r102.f193396c.setColor(r102.f193403j[r102.f193404k]);
        r110.rotate((r107 + r111) - 5.0f, r100.exactCenterX(), r100.exactCenterY());
        r110.drawPath(r102.f193409p, r102.f193396c);
        goto L10
    L7:
        r108.reset();
    L10:
        if (r102.f193414u >= 255) goto L12;
        r102.f193415v.setColor(r102.f193416w);
        r102.f193415v.setAlpha(255 - r102.f193414u);
        r110.drawCircle(r100.exactCenterX(), r100.exactCenterY(), r100.width() / 2, r102.f193415v);
    L12:
        r110.restoreToCount(r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f193384b.f193414u = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        c r101 = this.f193384b;
        r101.f193395b.setColorFilter(r100);
        r101.a();
    }

    public MaterialProgressDrawable(Context r100, View r101) {
        this.f193383a = new ArrayList();
        a r102 = new a(this);
        this.f193387e = r101;
        this.f193386d = r100.getResources();
        c r103 = new c(r102);
        this.f193384b = r103;
        r103.f193403j = new int[]{-16777216};
        r103.f193404k = 0;
        b(1);
        p r104 = new p(this, r103);
        r104.setRepeatCount(-1);
        r104.setRepeatMode(1);
        r104.setInterpolator(f193380k);
        r104.setAnimationListener(new q(this, r103));
        this.f193388f = r104;
    }

    public final void a(double r100, double r101, double r102, double r110, float r111, float r112) {
        c r103 = this.f193384b;
        Resources r104 = this.f193386d;
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        double r106 = r105;
        this.f193390h = r100 * r106;
        this.f193391i = r101 * r106;
        float r107 = ((float) r110) * r105;
        r103.f193401h = r107;
        r103.f193395b.setStrokeWidth(r107);
        r103.a();
        r103.f193411r = r102 * r106;
        r103.f193404k = 0;
        r103.f193412s = (int) (r111 * r105);
        r103.f193413t = (int) (r112 * r105);
        float r108 = Math.min((int) this.f193390h, (int) this.f193391i);
        double r109 = r103.f193411r;
        if (r109 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r113 = Math.ceil(r103.f193401h / 2.0f);
    L9:
        r103.f193402i = (float) r113;
        return;
    L5:
        if (r108 < 0.0f) goto L8;
        r113 = ((double) (r108 / 2.0f)) - r109;
        goto L9
    }
}
