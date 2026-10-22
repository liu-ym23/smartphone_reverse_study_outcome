package com.bytedance.android.shopping.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BubbleLayout extends LinearLayout {
    public static int s;
    public static int t;
    public static int u;
    public static float v;
    public static float w;
    public static float x;
    public static int y;
    public static int z;
    public Paint a;
    public final Path b;
    public final Path c;
    public RectF d;
    public float e;
    public float f;
    public final Path g;
    public RectF h;
    public int i;
    public Matrix j;
    public Bitmap k;
    public Canvas l;
    public int m;
    public int n;
    public final float o;
    public int p;
    public boolean q;
    public boolean r;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BubbleOrientation {
    }

    public float getBubbleOffset() {
        float r0 = Math.max(this.o, x);
        int r1 = this.p;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r0, this.e - x);
    L18:
        return Math.min(r0, this.f - x);
    L19:
        return Math.min(r0, this.f - x);
    L15:
        return Math.min(r0, this.e - x);
    }

    public final void a() {
        clearAnimation();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        r0.setDuration(100);
        r0.start();
        r0.addUpdateListener(new a());
    }

    public BubbleLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r13) {
        if (this.k != null) goto L8;
        Bitmap r0 = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.k = r0;
        if (r0.getDensity() == r13.getDensity()) goto L7;
        this.k.setDensity(r13.getDensity());
    L7:
        this.l = new Canvas(this.k);
    L8:
        float r1 = this.e;
        float r2 = this.f;
        float r3 = Math.max(this.o, x);
        float r4 = Math.min(r3, r2 - x);
        Matrix r5 = new Matrix();
        this.j = new Matrix();
        int r6 = this.p;
        if (r6 != 0) goto L11;
        r1 = Math.min(r3, r1 - x);
        r5.postRotate(90.0f);
        this.j.postRotate(90.0f);
        Matrix r7 = this.j;
        int r8 = this.i;
        r7.postTranslate(((r8 * 3) / 2) + r1, r8 + 0.0f);
        setPadding(0, s, 0, 0);
        setGravity(17);
        this.d = new RectF(0.0f, s, this.e, this.f);
        r2 = 0.0f;
    L20:
        RectF r9 = this.d;
        float r10 = r9.left;
        float r11 = (this.i * 3) / 2;
        r9.left = r10 + r11;
        r9.top += r11;
        r9.right += r11;
        r9.bottom += r11;
        RectF r12 = new RectF();
        this.h = r12;
        RectF r14 = this.d;
        float r15 = r14.left;
        int r16 = this.i;
        float r17 = r16 / 2;
        r12.left = r15 - r17;
        r12.top = r14.top - r17;
        r12.right = r14.right + r17;
        r12.bottom = r14.bottom + r17;
        float r18 = (r16 * 3) / 2;
        r5.postTranslate(r1 + r18, r2 + r18);
        this.a.setColor(this.n);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.i);
        if (this.q == false) goto L23;
        this.b.reset();
        Path r19 = this.b;
        RectF r20 = this.h;
        float r21 = w;
        int r22 = this.i;
        r19.addRoundRect(r20, (r22 / 2) + r21, r21 + (r22 / 2), Path.Direction.CW);
        this.b.addPath(this.g, this.j);
        this.l.drawPath(this.b, this.a);
    L23:
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.a.setColor(this.m);
        this.a.setStyle(Paint.Style.FILL);
        this.b.reset();
        Path r23 = this.b;
        RectF r24 = this.d;
        float r25 = w;
        r23.addRoundRect(r24, r25, r25, Path.Direction.CW);
        this.b.addPath(this.c, r5);
        this.l.drawPath(this.b, this.a);
        this.a.setXfermode(null);
        r13.drawBitmap(this.k, 0.0f, 0.0f, null);
        return;
    L11:
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 == 3) goto L15;
        r2 = r4;
    L18:
        r1 = 0.0f;
        goto L20
    L15:
        r1 = Math.min(r3, r1 - x);
        r5.postRotate(270.0f);
        this.j.postRotate(270.0f);
        Matrix r26 = this.j;
        int r27 = this.i;
        r26.postTranslate(((r27 * 3) / 2) + r1, (r27 * 2) + r2);
        setPadding(0, 0, 0, s);
        setGravity(17);
        this.d = new RectF(0.0f, 0.0f, this.e, this.f - s);
        goto L20
    L16:
        r2 = Math.min(r3, r2 - x);
        r5.postRotate(180.0f);
        this.j.postRotate(180.0f);
        Matrix r28 = this.j;
        int r29 = this.i;
        r28.postTranslate((r29 * 2) + r1, ((r29 * 3) / 2) + r2);
        setPadding(0, 0, s, 0);
        setGravity(17);
        this.d = new RectF(0.0f, 0.0f, this.e - s, this.f);
        goto L20
    L17:
        float r30 = Math.min(r3, r2 - x);
        setPadding(s, 0, 0, 0);
        setGravity(17);
        Matrix r31 = this.j;
        int r32 = this.i;
        r31.postTranslate(r32 + 0.0f, ((r32 * 3) / 2) + r30);
        this.d = new RectF(s, 0.0f, this.e, this.f);
        r2 = r30;
        goto L18
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L13;
        if (r0 != 3) goto L19;
        if (this.r == false) goto L19;
        a();
    L19:
        return super.onTouchEvent(r4);
    L13:
        if (this.r == false) goto L19;
        a();
        goto L19
    L16:
        if (this.r == false) goto L19;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.5f});
        r1.setDuration(100);
        r1.start();
        r1.addUpdateListener(new a());
        goto L19
    }

    public void setBgColor(int r1) {
        this.m = r1;
    }

    public void setBorderColor(int r1) {
        this.n = r1;
    }

    public void setBubbleOrientation(int r1) {
        this.p = r1;
    }

    public void setNeedPath(boolean r1) {
        this.q = r1;
    }

    public void setNeedPressFade(boolean r1) {
        this.r = r1;
    }

    public BubbleLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static float b(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        if ((getChildAt(0) instanceof TextView) == false) goto L5;
        TextView r0 = (TextView) getChildAt(0);
    L6:
        int r1 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r2 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        if (r0 == null) goto L9;
        int r3 = (((int) r0.getPaint().measureText(r0.getText().toString())) + r0.getPaddingLeft()) + r0.getPaddingRight();
    L10:
        int r4 = this.p;
        if (r4 != 2) goto L13;
    L19:
        int r5 = y;
        if (r3 <= r5) goto L22;
        r5 = (t * 2) + r3;
    L22:
        int r6 = r5 + s;
        int r11 = z;
    L23:
        int r12 = this.i;
        int r13 = r6 + (r12 * 3);
        int r14 = r11 + (r12 * 3);
        if (r1 != Integer.MIN_VALUE) goto L27;
        if (r2 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r13, r14);
    L31:
        this.e = getMeasuredWidth() - (this.i * 3);
        this.f = getMeasuredHeight() - (this.i * 3);
        return;
    L27:
        if (r1 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r13, r10);
        goto L31
    L29:
        if (r2 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r9, r14);
        goto L31
    L13:
        if (r4 == 1) goto L19;
        r6 = y;
        if (r3 <= r6) goto L18;
        r6 = (t * 2) + r3;
    L18:
        r11 = z;
        goto L23
    L9:
        r3 = getMeasuredWidth();
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public BubbleLayout(Context r9, AttributeSet r10, int r11) {
        super(r9, r10, r11);
        this.a = null;
        this.b = new Path();
        Path r12 = new Path();
        this.c = r12;
        Path r13 = new Path();
        this.g = r13;
        this.o = 0.75f;
        this.p = 1;
        this.q = true;
        int r1 = (int) b(r9, 0.5f);
        this.i = r1;
        if (r1 >= 2) goto L5;
        this.i = 2;
    L5:
        s = (int) b(r9, 7.0f);
        t = (int) b(r9, 10.0f);
        u = (int) b(r9, 6.0f);
        v = 2.0f;
        w = b(r9, 6.0f);
        x = s + u;
        y = (int) b(r9, 50.0f);
        z = (int) b(r9, 46.0f);
        Paint r2 = new Paint();
        this.a = r2;
        r2.setStyle(Paint.Style.FILL);
        this.a.setStrokeCap(Paint.Cap.BUTT);
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(v);
        this.a.setStrokeJoin(Paint.Join.MITER);
        this.m = r9.getResources().getColor(2131105693);
        this.n = ColorProtector.parseColor("#1DFFFFFF");
        this.a.setColor(this.m);
        setLayerType(1, this.a);
        r12.moveTo(0.0f, 0.0f);
        int r0 = s;
        r12.lineTo(r0, -r0);
        float r3 = s;
        r12.lineTo(r3, r3);
        r12.close();
        r13.moveTo(0.0f, 0.0f);
        r13.lineTo((float) (((double) s) + (((double) this.i) * Math.sqrt(2.0d))), (float) (((double) (-s)) - (((double) this.i) * Math.sqrt(2.0d))));
        r13.lineTo((float) (((double) s) + (((double) this.i) * Math.sqrt(2.0d))), (float) (((double) s) + (((double) this.i) * Math.sqrt(2.0d))));
        r13.close();
        setBackgroundColor(0);
        setClipChildren(false);
    }
}
