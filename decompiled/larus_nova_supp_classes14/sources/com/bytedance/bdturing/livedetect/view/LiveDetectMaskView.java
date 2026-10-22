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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LiveDetectMaskView extends View {
    public int a;
    public int b;
    public Paint c;
    public Rect d;
    public float e;
    public float f;
    public float g;
    public ArrayList<Float> h;
    public Paint i;
    public ValueAnimator j;
    public int[] k;
    public int l;
    public final int m;
    public final int n;
    public SweepGradient o;
    public RectF p;
    public Matrix q;
    public int r;
    public Paint s;
    public int t;
    public b u;
    public Rect v;
    public Paint w;
    public boolean x;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LiveDetectMaskView a;

        public a(LiveDetectMaskView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            float r6 = r5.getAnimatedFraction();
            LiveDetectMaskView r0 = this.a;
            Matrix r1 = r0.q;
            if (r1 == null) goto L7;
            Rect r2 = r0.d;
            if (r2 == null) goto L7;
            r1.setRotate(((r6 * 360.0f) + 90.0f) % 360.0f, r2.centerX(), this.a.d.centerY());
        L7:
            this.a.postInvalidate();
        }
    }

    public interface b {
        void a(Rect r1);
    }

    public final void a() {
        this.r = 2;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.j = r0;
        r0.setDuration(1600);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(1);
        Interpolator r1 = PathInterpolatorCompat.create(0.55f, 0.15f, 0.45f, 0.85f);
        this.j.setInterpolator(r1);
        this.j.addUpdateListener(new a(this));
        this.j.start();
    }

    private int getScreenWidth() {
        Resources r0 = getResources();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
        return Math.min(r1.widthPixels, r1.heightPixels);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.j;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public ArrayList<Float> getBoxRectInfo() {
        return this.h;
    }

    public LiveDetectMaskView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        super.onDraw(r11);
        r11.drawColor(this.l);
        r11.drawCircle(this.d.centerX(), this.d.centerY(), (this.d.width() * 1.0f) / 2.0f, this.c);
        if (this.r != 3) goto L7;
        this.s.setShader(null);
        this.s.setColor(this.t);
        r11.drawArc(this.p, 0.0f, 360.0f, false, this.s);
    L7:
        if (this.j == null) goto L15;
        if (this.r == 3) goto L15;
        if (this.o != null) goto L13;
        this.o = new SweepGradient(this.d.centerX(), this.d.centerY(), this.k, null);
        this.q = new Matrix();
        this.i.setShader(this.o);
    L13:
        this.o.setLocalMatrix(this.q);
        r11.drawArc(this.p, 0.0f, 360.0f, false, this.i);
    L15:
        if (this.x == false) goto L18;
        r11.drawRect(((Float) ListProtector.get(this.h, 0)).floatValue() * this.a, ((Float) ListProtector.get(this.h, 1)).floatValue() * this.b, ((Float) ListProtector.get(this.h, 2)).floatValue() * this.a, ((Float) ListProtector.get(this.h, 3)).floatValue() * this.b, this.w);
        return;
    }

    public void setBoxStateListener(b r1) {
        this.u = r1;
    }

    public void setDebugMode(boolean r1) {
        this.x = r1;
        if (r1 == false) goto L5;
        String r2 = "#59ffffff";
    L6:
        this.l = ColorProtector.parseColor(r2);
        return;
    L5:
        r2 = "#ffffff";
        goto L6
    }

    public LiveDetectMaskView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LiveDetectMaskView(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.g = 0.0f;
        int r9 = ColorProtector.parseColor("#CCFFFFFF");
        this.m = r9;
        this.n = ColorProtector.parseColor("#4DFFFFFF");
        this.r = 1;
        TypedArray r10 = getContext().obtainStyledAttributes(r7, new int[]{2130969082, 2130969083, 2130969084});
        float r2 = 0.6f;
        float r3 = r10.getFloat(2, 0.6f);
        this.e = r3;
        if (r3 <= 0.0f) goto L5;
        r2 = r3;
    L5:
        this.e = r2;
        float r4 = 1.0f;
        float r5 = r10.getFloat(1, 1.0f);
        this.f = r5;
        if (r5 <= 0.0f) goto L8;
        r4 = r5;
    L8:
        this.f = r4;
        this.g = r10.getFloat(0, 0.15f);
        r10.recycle();
        Paint r11 = new Paint();
        this.c = r11;
        r11.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.c.setColor(r9);
        setLayerType(1, null);
        Paint r12 = new Paint();
        this.i = r12;
        r12.setAntiAlias(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(10.0f);
        this.i.setStrokeCap(Paint.Cap.ROUND);
        int r13 = ColorProtector.parseColor("#001664FF");
        int r14 = ColorProtector.parseColor("#ff1664FF");
        if (this.x == false) goto L11;
        String r15 = "#59ffffff";
    L12:
        this.l = ColorProtector.parseColor(r15);
        this.k = new int[]{r13, r14};
        Paint r16 = new Paint();
        this.s = r16;
        r16.setAntiAlias(true);
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(10.0f);
        this.s.setStrokeCap(Paint.Cap.ROUND);
        ColorProtector.parseColor("#99000000");
        ColorProtector.parseColor("#00000000");
        this.t = ColorProtector.parseColor("#309256");
        Paint r17 = new Paint();
        this.w = r17;
        r17.setAntiAlias(true);
        this.w.setStyle(Paint.Style.STROKE);
        this.w.setStrokeWidth(3.0f);
        this.w.setColor(-65536);
        return;
    L11:
        r15 = "#ffffff";
        goto L12
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        if (r4 <= 0) goto L23;
        if (r5 > 0) goto L6;
        return;
    L6:
        if (this.a == r4) goto L8;
    L9:
        this.a = r4;
        this.b = r5;
        int r8 = (int) (this.a * Math.max(Math.min(0.9f, this.e / ((r4 * 1.0f) / getScreenWidth())), this.e));
        int r9 = (int) (r8 / this.f);
        Rect r10 = new Rect();
        this.d = r10;
        int r0 = this.a;
        int r1 = (r0 - r8) / 2;
        r10.left = r1;
        int r2 = (int) (r0 * this.g);
        r10.top = r2;
        r10.right = r1 + r8;
        r10.bottom = r2 + r9;
        int r11 = (int) (((r10.width() * 1.0f) / 2.0f) * 0.2f);
        ArrayList<Float> r12 = new ArrayList(4);
        this.h = r12;
        r12.add(Float.valueOf(((this.d.left + r11) * 1.0f) / this.a));
        this.h.add(Float.valueOf((this.d.top * 1.0f) / this.b));
        this.h.add(Float.valueOf(((this.d.right - r11) * 1.0f) / this.a));
        this.h.add(Float.valueOf((this.d.bottom * 1.0f) / this.b));
        Rect r13 = this.d;
        this.p = new RectF(r13.left - 10.0f, r13.top - 10.0f, r13.right + 10.0f, r13.bottom + 10.0f);
        this.v = new Rect();
        ViewParent r14 = getParent();
        if (r14 == null) goto L12;
        r14 = r14.getParent();
    L12:
        if (r14 != null) goto L14;
    L16:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) getLayoutParams();
    L17:
        Rect r16 = this.v;
        int r17 = r15.topMargin;
        Rect r18 = this.d;
        int r19 = r17 + r18.top;
        r16.top = r19;
        r16.left = r18.left;
        r16.right = r18.right;
        r16.bottom = r19 + r18.height();
        Rect r20 = this.v;
        if (r20 == null) goto L26;
        b r21 = this.u;
        if (r21 == null) goto L27;
        r21.a(r20);
        return;
    L27:
        return;
    L26:
        return;
    L14:
        if ((r14 instanceof LiveDetectView) == false) goto L16;
        r15 = (ViewGroup.MarginLayoutParams) ((ViewGroup) r14).getLayoutParams();
        goto L17
    L8:
        if (this.b != r5) goto L9;
        return;
    }
}
