package vdc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends Drawable implements Animatable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Interpolator f554271l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f554272m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f554273n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Interpolator f554274o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Animation> f554275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f554276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f554277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f554278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vdc.d f554279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f554280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f554281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f554282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vdc.b f554283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f554284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ShapeDrawable f554285k;

    /* JADX INFO: renamed from: vdc.a$a, reason: collision with other inner class name */
    public class C7987a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f554286a;

        public C7987a(a r100) {
            this.f554286a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            this.f554286a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            this.f554286a.unscheduleSelf(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            this.f554286a.scheduleSelf(r101, r102);
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

    public class c extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f554287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f554288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f554289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f554290d;

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public final void draw(Canvas r100, Paint r101) {
            float r102 = this.f554290d.getBounds().width() / 2;
            float r103 = this.f554290d.getBounds().height() / 2;
            r100.drawCircle(r102, r103, (this.f554289c / 2) + this.f554287a, this.f554288b);
            r100.drawCircle(r102, r103, this.f554289c / 2, r101);
        }

        public c(a r100, int r110, int r111) {
            this.f554290d = r100;
            Paint r101 = new Paint();
            this.f554288b = r101;
            this.f554287a = r110;
            this.f554289c = r111;
            float r102 = r111 / 2;
            r101.setShader(new RadialGradient(r102, r102, r110, new int[]{1023410176, 0}, null, Shader.TileMode.CLAMP));
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f554291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f554292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f554293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable.Callback f554294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f554295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f554296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f554297g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f554298h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f554299i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f554300j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int[] f554301k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f554302l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f554303m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f554304n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f554305o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f554306p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Path f554307q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f554308r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public double f554309s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f554310t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f554311u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f554312v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f554313w;

        public final void a() {
            this.f554294d.invalidateDrawable(null);
        }

        public d(C7987a r100) {
            this.f554291a = new RectF();
            Paint r101 = new Paint();
            this.f554292b = r101;
            Paint r102 = new Paint();
            this.f554293c = r102;
            Paint r103 = new Paint();
            this.f554295e = r103;
            this.f554296f = 0.0f;
            this.f554297g = 0.0f;
            this.f554298h = 0.0f;
            this.f554299i = 5.0f;
            this.f554300j = 2.5f;
            this.f554294d = r100;
            r101.setStrokeCap(Paint.Cap.SQUARE);
            r101.setAntiAlias(true);
            r101.setStyle(Paint.Style.STROKE);
            r102.setStyle(Paint.Style.FILL);
            r102.setAntiAlias(true);
            r103.setAntiAlias(true);
        }
    }

    public static class e extends AccelerateDecelerateInterpolator {
        public e() {
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
        f554271l = new LinearInterpolator();
        f554272m = new b();
        f554273n = new e();
        f554274o = new AccelerateDecelerateInterpolator();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f554276b.f554312v;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f554282h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f554281g;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList<Animation> r100 = this.f554275a;
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
        this.f554279e.reset();
        d r100 = this.f554276b;
        float r101 = r100.f554296f;
        r100.f554303m = r101;
        float r102 = r100.f554297g;
        r100.f554304n = r102;
        r100.f554305o = r100.f554298h;
        if (r102 == r101) goto L5;
        this.f554278d.startAnimation(this.f554283i);
        return;
    L5:
        r100.f554302l = 0;
        r100.f554303m = 0.0f;
        r100.f554304n = 0.0f;
        r100.f554305o = 0.0f;
        r100.f554296f = 0.0f;
        r100.a();
        r100.f554297g = 0.0f;
        r100.a();
        r100.f554298h = 0.0f;
        r100.a();
        this.f554278d.startAnimation(this.f554279e);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f554278d.clearAnimation();
        this.f554277c = 0.0f;
        invalidateSelf();
        d r100 = this.f554276b;
        if (r100.f554306p == false) goto L5;
        r100.f554306p = false;
        r100.a();
    L5:
        d r101 = this.f554276b;
        r101.f554302l = 0;
        r101.f554303m = 0.0f;
        r101.f554304n = 0.0f;
        r101.f554305o = 0.0f;
        r101.f554296f = 0.0f;
        r101.a();
        r101.f554297g = 0.0f;
        r101.a();
        r101.f554298h = 0.0f;
        r101.a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        ShapeDrawable r100 = this.f554285k;
        if (r100 == null) goto L5;
        r100.getPaint().setColor(this.f554284j);
        this.f554285k.draw(r110);
    L5:
        Rect r101 = getBounds();
        int r102 = r110.save();
        r110.rotate(this.f554277c, r101.exactCenterX(), r101.exactCenterY());
        d r103 = this.f554276b;
        r103.f554295e.setColor(r103.f554313w);
        r103.f554295e.setAlpha(r103.f554312v);
        r110.drawCircle(r101.exactCenterX(), r101.exactCenterY(), r101.width() / 2, r103.f554295e);
        RectF r104 = r103.f554291a;
        r104.set(r101);
        float r105 = r103.f554300j;
        r104.inset(r105, r105);
        float r106 = r103.f554296f;
        float r107 = r103.f554298h;
        float r108 = (r106 + r107) * 360.0f;
        float r109 = ((r103.f554297g + r107) * 360.0f) - r108;
        r103.f554292b.setColor(r103.f554301k[r103.f554302l]);
        r103.f554292b.setAlpha(r103.f554312v);
        r110.drawArc(r104, r108, r109, false, r103.f554292b);
        if (r103.f554306p == false) goto L12;
        Path r111 = r103.f554307q;
        if (r111 != null) goto L10;
        Path r112 = new Path();
        r103.f554307q = r112;
        r112.setFillType(Path.FillType.EVEN_ODD);
    L11:
        float r113 = (((int) r103.f554300j) / 2) * r103.f554308r;
        float r114 = (float) ((r103.f554309s * Math.cos(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r101.exactCenterX()));
        float r115 = (float) ((r103.f554309s * Math.sin(AudioStats.AUDIO_AMPLITUDE_NONE)) + ((double) r101.exactCenterY()));
        r103.f554307q.moveTo(0.0f, 0.0f);
        r103.f554307q.lineTo(r103.f554310t * r103.f554308r, 0.0f);
        Path r116 = r103.f554307q;
        float r117 = r103.f554310t;
        float r118 = r103.f554308r;
        r116.lineTo((r117 * r118) / 2.0f, r103.f554311u * r118);
        r103.f554307q.offset(r114 - r113, r115);
        r103.f554307q.close();
        r103.f554293c.setColor(r103.f554301k[r103.f554302l]);
        r103.f554293c.setAlpha(r103.f554312v);
        r110.rotate((r108 + r109) - 5.0f, r101.exactCenterX(), r101.exactCenterY());
        r110.drawPath(r103.f554307q, r103.f554293c);
        goto L12
    L10:
        r111.reset();
    L12:
        r110.restoreToCount(r102);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f554276b.f554312v = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        d r101 = this.f554276b;
        r101.f554292b.setColorFilter(r100);
        r101.a();
    }

    public a(Context r100, View r110) {
        this.f554275a = new ArrayList();
        C7987a r101 = new C7987a(this);
        this.f554278d = r110;
        Resources r102 = r100.getResources();
        d r103 = new d(r101);
        this.f554276b = r103;
        r103.f554301k = new int[]{-3591113, -13149199, -536002, -13327536};
        r103.f554302l = 0;
        float r104 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        double r105 = r104;
        double r106 = 40.0d * r105;
        this.f554281g = r106;
        this.f554282h = r106;
        float r107 = ((float) 2.5d) * r104;
        r103.f554299i = r107;
        r103.f554292b.setStrokeWidth(r107);
        r103.a();
        r103.f554309s = r105 * 8.75d;
        r103.f554302l = 0;
        r103.f554310t = (int) (10.0f * r104);
        r103.f554311u = (int) (r104 * 5.0f);
        float r108 = Math.min((int) this.f554281g, (int) this.f554282h);
        double r109 = r103.f554309s;
        if (r109 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L8:
        double r111 = Math.ceil(r103.f554299i / 2.0f);
    L9:
        r103.f554300j = (float) r111;
        double r112 = this.f554281g;
        xdc.a.b(r110.getContext());
        int r113 = xdc.a.a(1.75f);
        int r114 = xdc.a.a(0.0f);
        int r115 = xdc.a.a(3.5f);
        ShapeDrawable r116 = new ShapeDrawable(new c(this, r115, (int) r112));
        this.f554285k = r116;
        r110.setLayerType(1, r116.getPaint());
        this.f554285k.getPaint().setShadowLayer(r115, r114, r113, 503316480);
        vdc.b r117 = new vdc.b(r103);
        r117.setInterpolator(f554274o);
        r117.setDuration(666);
        r117.setAnimationListener(new vdc.c(this, r103));
        vdc.d r118 = new vdc.d(this, r103);
        r118.setRepeatCount(-1);
        r118.setRepeatMode(1);
        r118.setInterpolator(f554271l);
        r118.setDuration(1333);
        r118.setAnimationListener(new vdc.e(this, r103));
        this.f554283i = r117;
        this.f554279e = r118;
        return;
    L5:
        if (r108 < 0.0f) goto L8;
        r111 = ((double) (r108 / 2.0f)) - r109;
        goto L9
    }
}
