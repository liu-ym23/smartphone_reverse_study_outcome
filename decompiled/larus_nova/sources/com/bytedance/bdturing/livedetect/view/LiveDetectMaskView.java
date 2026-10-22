package com.bytedance.bdturing.livedetect.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes14.dex */
public class LiveDetectMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f201941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f201942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f201943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f201944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f201945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f201946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f201947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<Float> f201948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f201949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f201950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f201951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f201952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f201953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f201954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SweepGradient f201955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RectF f201956p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Matrix f201957q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f201958r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f201959s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f201960t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f201961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Rect f201962v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Paint f201963w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f201964x;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDetectMaskView f201965a;

        public a(LiveDetectMaskView r100) {
            this.f201965a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            LiveDetectMaskView r102 = this.f201965a;
            Matrix r103 = r102.f201957q;
            if (r103 == null) goto L7;
            Rect r104 = r102.f201944d;
            if (r104 == null) goto L7;
            r103.setRotate(((r101 * 360.0f) + 90.0f) % 360.0f, r104.centerX(), this.f201965a.f201944d.centerY());
        L7:
            this.f201965a.postInvalidate();
        }
    }

    public interface b {
        void a(Rect r100);
    }

    public final void a() {
        this.f201958r = 2;
        ValueAnimator r100 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f201950j = r100;
        r100.setDuration(1600);
        this.f201950j.setRepeatCount(-1);
        this.f201950j.setRepeatMode(1);
        Interpolator r101 = PathInterpolatorCompat.create(0.55f, 0.15f, 0.45f, 0.85f);
        this.f201950j.setInterpolator(r101);
        this.f201950j.addUpdateListener(new a(this));
        this.f201950j.start();
    }

    private int getScreenWidth() {
        Resources r100 = getResources();
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        return Math.min(r101.widthPixels, r101.heightPixels);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f201950j;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public ArrayList<Float> getBoxRectInfo() {
        return this.f201948h;
    }

    public LiveDetectMaskView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        r110.drawColor(this.f201952l);
        r110.drawCircle(this.f201944d.centerX(), this.f201944d.centerY(), (this.f201944d.width() * 1.0f) / 2.0f, this.f201943c);
        if (this.f201958r != 3) goto L7;
        this.f201959s.setShader(null);
        this.f201959s.setColor(this.f201960t);
        r110.drawArc(this.f201956p, 0.0f, 360.0f, false, this.f201959s);
    L7:
        if (this.f201950j == null) goto L15;
        if (this.f201958r == 3) goto L15;
        if (this.f201955o != null) goto L13;
        this.f201955o = new SweepGradient(this.f201944d.centerX(), this.f201944d.centerY(), this.f201951k, null);
        this.f201957q = new Matrix();
        this.f201949i.setShader(this.f201955o);
    L13:
        this.f201955o.setLocalMatrix(this.f201957q);
        r110.drawArc(this.f201956p, 0.0f, 360.0f, false, this.f201949i);
    L15:
        if (this.f201964x == false) goto L18;
        r110.drawRect(((Float) ListProtector.get(this.f201948h, 0)).floatValue() * this.f201941a, ((Float) ListProtector.get(this.f201948h, 1)).floatValue() * this.f201942b, ((Float) ListProtector.get(this.f201948h, 2)).floatValue() * this.f201941a, ((Float) ListProtector.get(this.f201948h, 3)).floatValue() * this.f201942b, this.f201963w);
        return;
    }

    public void setBoxStateListener(b r100) {
        this.f201961u = r100;
    }

    public void setDebugMode(boolean r100) {
        this.f201964x = r100;
        if (r100 == false) goto L5;
        String r101 = "#59ffffff";
    L6:
        this.f201952l = ColorProtector.parseColor(r101);
        return;
    L5:
        r101 = "#ffffff";
        goto L6
    }

    public LiveDetectMaskView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveDetectMaskView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f201947g = 0.0f;
        int r103 = ColorProtector.parseColor("#CCFFFFFF");
        this.f201953m = r103;
        this.f201954n = ColorProtector.parseColor("#4DFFFFFF");
        this.f201958r = 1;
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.box_top_margin_ratio, R.attr.box_width_height_ratio, R.attr.box_width_ratio});
        float r105 = 0.6f;
        float r106 = r104.getFloat(2, 0.6f);
        this.f201945e = r106;
        if (r106 <= 0.0f) goto L5;
        r105 = r106;
    L5:
        this.f201945e = r105;
        float r107 = 1.0f;
        float r108 = r104.getFloat(1, 1.0f);
        this.f201946f = r108;
        if (r108 <= 0.0f) goto L8;
        r107 = r108;
    L8:
        this.f201946f = r107;
        this.f201947g = r104.getFloat(0, 0.15f);
        r104.recycle();
        Paint r109 = new Paint();
        this.f201943c = r109;
        r109.setAntiAlias(true);
        this.f201943c.setStyle(Paint.Style.FILL);
        this.f201943c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f201943c.setColor(r103);
        setLayerType(1, null);
        Paint r110 = new Paint();
        this.f201949i = r110;
        r110.setAntiAlias(true);
        this.f201949i.setStyle(Paint.Style.STROKE);
        this.f201949i.setStrokeWidth(10.0f);
        this.f201949i.setStrokeCap(Paint.Cap.ROUND);
        int r111 = ColorProtector.parseColor("#001664FF");
        int r112 = ColorProtector.parseColor("#ff1664FF");
        if (this.f201964x == false) goto L11;
        String r113 = "#59ffffff";
    L12:
        this.f201952l = ColorProtector.parseColor(r113);
        this.f201951k = new int[]{r111, r112};
        Paint r114 = new Paint();
        this.f201959s = r114;
        r114.setAntiAlias(true);
        this.f201959s.setStyle(Paint.Style.STROKE);
        this.f201959s.setStrokeWidth(10.0f);
        this.f201959s.setStrokeCap(Paint.Cap.ROUND);
        ColorProtector.parseColor("#99000000");
        ColorProtector.parseColor("#00000000");
        this.f201960t = ColorProtector.parseColor("#309256");
        Paint r115 = new Paint();
        this.f201963w = r115;
        r115.setAntiAlias(true);
        this.f201963w.setStyle(Paint.Style.STROKE);
        this.f201963w.setStrokeWidth(3.0f);
        this.f201963w.setColor(-65536);
        return;
    L11:
        r113 = "#ffffff";
        goto L12
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 <= 0) goto L23;
        if (r101 > 0) goto L6;
        return;
    L6:
        if (this.f201941a == r100) goto L8;
    L9:
        this.f201941a = r100;
        this.f201942b = r101;
        int r104 = (int) (this.f201941a * Math.max(Math.min(0.9f, this.f201945e / ((r100 * 1.0f) / getScreenWidth())), this.f201945e));
        int r105 = (int) (r104 / this.f201946f);
        Rect r106 = new Rect();
        this.f201944d = r106;
        int r107 = this.f201941a;
        int r108 = (r107 - r104) / 2;
        r106.left = r108;
        int r109 = (int) (r107 * this.f201947g);
        r106.top = r109;
        r106.right = r108 + r104;
        r106.bottom = r109 + r105;
        int r110 = (int) (((r106.width() * 1.0f) / 2.0f) * 0.2f);
        ArrayList<Float> r111 = new ArrayList(4);
        this.f201948h = r111;
        r111.add(Float.valueOf(((this.f201944d.left + r110) * 1.0f) / this.f201941a));
        this.f201948h.add(Float.valueOf((this.f201944d.top * 1.0f) / this.f201942b));
        this.f201948h.add(Float.valueOf(((this.f201944d.right - r110) * 1.0f) / this.f201941a));
        this.f201948h.add(Float.valueOf((this.f201944d.bottom * 1.0f) / this.f201942b));
        Rect r112 = this.f201944d;
        this.f201956p = new RectF(r112.left - 10.0f, r112.top - 10.0f, r112.right + 10.0f, r112.bottom + 10.0f);
        this.f201962v = new Rect();
        ViewParent r113 = getParent();
        if (r113 == null) goto L12;
        r113 = r113.getParent();
    L12:
        if (r113 != null) goto L14;
    L16:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) getLayoutParams();
    L17:
        Rect r115 = this.f201962v;
        int r116 = r114.topMargin;
        Rect r117 = this.f201944d;
        int r118 = r116 + r117.top;
        r115.top = r118;
        r115.left = r117.left;
        r115.right = r117.right;
        r115.bottom = r118 + r117.height();
        Rect r119 = this.f201962v;
        if (r119 == null) goto L26;
        b r120 = this.f201961u;
        if (r120 == null) goto L27;
        r120.a(r119);
        return;
    L27:
        return;
    L26:
        return;
    L14:
        if ((r113 instanceof LiveDetectView) == false) goto L16;
        r114 = (ViewGroup.MarginLayoutParams) ((ViewGroup) r113).getLayoutParams();
        goto L17
    L8:
        if (this.f201942b != r101) goto L9;
        return;
    }
}
