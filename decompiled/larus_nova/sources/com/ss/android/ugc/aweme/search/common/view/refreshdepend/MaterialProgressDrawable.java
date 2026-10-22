package com.ss.android.ugc.aweme.search.common.view.refreshdepend;

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
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Interpolator f452383l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f452384m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f452385n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f452386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Ring f452387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f452388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Resources f452389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f452390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animation f452391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f452392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f452393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f452394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f452395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable.Callback f452396k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public static class Ring {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f452402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f452403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f452404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f452405d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f452406e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f452407f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f452408g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f452409h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f452410i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int[] f452411j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f452412k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f452413l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f452414m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f452415n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f452416o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Path f452417p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f452418q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f452419r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f452420s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f452421t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f452422u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Paint f452423v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f452424w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f452425x;

        public final void a() {
            this.f452405d.invalidateDrawable(null);
        }

        public Ring(Drawable.Callback r100) {
            this.f452402a = new RectF();
            Paint r101 = new Paint();
            this.f452403b = r101;
            Paint r102 = new Paint();
            this.f452404c = r102;
            this.f452406e = 0.0f;
            this.f452407f = 0.0f;
            this.f452408g = 0.0f;
            this.f452409h = 5.0f;
            this.f452410i = 2.5f;
            this.f452423v = new Paint(1);
            this.f452405d = r100;
            r101.setStrokeCap(Paint.Cap.SQUARE);
            r101.setAntiAlias(true);
            r101.setStyle(Paint.Style.STROKE);
            r102.setStyle(Paint.Style.FILL);
            r102.setAntiAlias(true);
        }

        public final void b(int r100) {
            this.f452412k = r100;
            this.f452425x = this.f452411j[r100];
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    static {
        f452383l = new LinearInterpolator();
        f452384m = new FastOutSlowInInterpolator();
        f452385n = new int[]{-16777216};
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f452387b.f452422u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f452394i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f452393h;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f452386a;
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
        this.f452391f.reset();
        Ring r100 = this.f452387b;
        float r101 = r100.f452406e;
        r100.f452413l = r101;
        float r102 = r100.f452407f;
        r100.f452414m = r102;
        r100.f452415n = r100.f452408g;
        if (r102 == r101) goto L5;
        this.f452395j = true;
        this.f452391f.setDuration(666);
        this.f452390e.startAnimation(this.f452391f);
        return;
    L5:
        r100.b(0);
        Ring r103 = this.f452387b;
        r103.f452413l = 0.0f;
        r103.f452414m = 0.0f;
        r103.f452415n = 0.0f;
        r103.f452406e = 0.0f;
        r103.a();
        r103.f452407f = 0.0f;
        r103.a();
        r103.f452408g = 0.0f;
        r103.a();
        this.f452391f.setDuration(1332);
        this.f452390e.startAnimation(this.f452391f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f452390e.clearAnimation();
        this.f452388c = 0.0f;
        invalidateSelf();
        Ring r100 = this.f452387b;
        if (r100.f452416o == false) goto L5;
        r100.f452416o = false;
        r100.a();
    L5:
        this.f452387b.b(0);
        Ring r101 = this.f452387b;
        r101.f452413l = 0.0f;
        r101.f452414m = 0.0f;
        r101.f452415n = 0.0f;
        r101.f452406e = 0.0f;
        r101.a();
        r101.f452407f = 0.0f;
        r101.a();
        r101.f452408g = 0.0f;
        r101.a();
    }

    public final void a(float r100) {
        Ring r101 = this.f452387b;
        if (r100 == r101.f452418q) goto L6;
        r101.f452418q = r100;
        r101.a();
        return;
    }

    public final void b(int r100) {
        this.f452387b.f452424w = r100;
    }

    public final void c(int... r100) {
        Ring r101 = this.f452387b;
        r101.f452411j = r100;
        r101.b(0);
        this.f452387b.b(0);
    }

    public final void d(float r100) {
        Ring r101 = this.f452387b;
        r101.f452408g = r100;
        r101.a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Rect r100 = getBounds();
        int r101 = r110.save();
        r110.rotate(this.f452388c, r100.exactCenterX(), r100.exactCenterY());
        Ring r102 = this.f452387b;
        RectF r103 = r102.f452402a;
        r103.set(r100);
        float r104 = r102.f452410i;
        r103.inset(r104, r104);
        float r105 = r102.f452406e;
        float r106 = r102.f452408g;
        float r107 = (r105 + r106) * 360.0f;
        float r111 = ((r102.f452407f + r106) * 360.0f) - r107;
        r102.f452403b.setColor(r102.f452425x);
        r110.drawArc(r103, r107, r111, false, r102.f452403b);
        if (r102.f452416o == false) goto L10;
        Path r108 = r102.f452417p;
        if (r108 != null) goto L7;
        Path r109 = new Path();
        r102.f452417p = r109;
        r109.setFillType(Path.FillType.EVEN_ODD);
    L8:
        float r112 = (((int) r102.f452410i) / 2) * r102.f452418q;
        float r113 = (float) ((r102.f452419r * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterX()));
        float r114 = (float) ((r102.f452419r * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r100.exactCenterY()));
        r102.f452417p.moveTo(0.0f, 0.0f);
        r102.f452417p.lineTo(r102.f452420s * r102.f452418q, 0.0f);
        Path r115 = r102.f452417p;
        float r116 = r102.f452420s;
        float r117 = r102.f452418q;
        r115.lineTo((r116 * r117) / 2.0f, r102.f452421t * r117);
        r102.f452417p.offset(r113 - r112, r114);
        r102.f452417p.close();
        r102.f452404c.setColor(r102.f452425x);
        r110.rotate((r107 + r111) - 5.0f, r100.exactCenterX(), r100.exactCenterY());
        r110.drawPath(r102.f452417p, r102.f452404c);
        goto L10
    L7:
        r108.reset();
    L10:
        if (r102.f452422u >= 255) goto L12;
        r102.f452423v.setColor(r102.f452424w);
        r102.f452423v.setAlpha(255 - r102.f452422u);
        r110.drawCircle(r100.exactCenterX(), r100.exactCenterY(), r100.width() / 2, r102.f452423v);
    L12:
        r110.restoreToCount(r101);
    }

    public final void f(float r100) {
        Ring r101 = this.f452387b;
        r101.f452406e = 0.0f;
        r101.a();
        Ring r102 = this.f452387b;
        r102.f452407f = r100;
        r102.a();
    }

    public final void g(boolean r100) {
        Ring r101 = this.f452387b;
        if (r101.f452416o == r100) goto L6;
        r101.f452416o = r100;
        r101.a();
        return;
    }

    public final void i(int r210) {
        if (r210 != 0) goto L4;
        e(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        return;
    L4:
        e(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f452387b.f452422u = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        Ring r101 = this.f452387b;
        r101.f452403b.setColorFilter(r100);
        r101.a();
    }

    public MaterialProgressDrawable(Context r100, View r101) {
        this.f452386a = new ArrayList();
        Drawable.Callback r102 = new AnonymousClass3(this);
        this.f452396k = r102;
        this.f452390e = r101;
        this.f452389d = r100.getResources();
        final Ring r103 = new Ring(r102);
        this.f452387b = r103;
        r103.f452411j = f452385n;
        r103.b(0);
        i(1);
        Animation r104 = new AnonymousClass1(this, r103);
        r104.setRepeatCount(-1);
        r104.setRepeatMode(1);
        r104.setInterpolator(f452383l);
        r104.setAnimationListener(new AnonymousClass2(this, r103));
        this.f452391f = r104;
    }

    public static void h(float r100, Ring r101) {
        if (r100 <= 0.75f) goto L6;
        float r102 = (r100 - 0.75f) / 0.25f;
        int[] r103 = r101.f452411j;
        int r104 = r101.f452412k;
        int r105 = r103[r104];
        int r106 = r103[(r104 + 1) % r103.length];
        int r107 = (r105 >> 24) & 255;
        int r108 = (r105 >> 16) & 255;
        int r109 = (r105 >> 8) & 255;
        int r110 = r105 & 255;
        r101.f452425x = ((((r107 + ((int) ((((r106 >> 24) & 255) - r107) * r102))) << 24) | ((r108 + ((int) ((((r106 >> 16) & 255) - r108) * r102))) << 16)) | ((r109 + ((int) ((((r106 >> 8) & 255) - r109) * r102))) << 8)) | (r110 + ((int) (r102 * ((r106 & 255) - r110))));
        return;
    }

    public final void e(double r100, double r101, double r102, double r110, float r111, float r112) {
        Ring r103 = this.f452387b;
        Resources r104 = this.f452389d;
        float r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density;
        double r106 = r105;
        this.f452393h = r100 * r106;
        this.f452394i = r101 * r106;
        float r107 = ((float) r110) * r105;
        r103.f452409h = r107;
        r103.f452403b.setStrokeWidth(r107);
        r103.a();
        r103.f452419r = r102 * r106;
        r103.b(0);
        r103.f452420s = (int) (r111 * r105);
        r103.f452421t = (int) (r112 * r105);
        float r108 = Math.min((int) this.f452393h, (int) this.f452394i);
        double r109 = r103.f452419r;
        if (r109 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r113 = Math.ceil(r103.f452409h / 2.0f);
    L9:
        r103.f452410i = (float) r113;
        return;
    L5:
        if (r108 < 0.0f) goto L8;
        r113 = ((double) (r108 / 2.0f)) - r109;
        goto L9
    }
}
