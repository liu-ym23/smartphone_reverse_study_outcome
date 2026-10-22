package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.obric.oui.constraintlayout.motion.widget.c;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public class MotionLabel extends View implements c {
    public float A;
    public float B;
    public Drawable C;
    public Matrix D;
    public Bitmap E;
    public BitmapShader F;
    public Matrix G;
    public float H;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f400328J;
    public float K;
    public final Paint L;
    public int M;
    public Rect N;
    public Paint O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f400329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f400330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f400333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f400334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewOutlineProvider f400336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f400337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f400338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f400339k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f400340l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f400341m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400342n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f400343o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f400344p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f400345q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f400346r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f400347s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f400348t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f400349u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f400350v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f400351w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f400352x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f400353y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f400354z;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLabel f400355a;

        public a(MotionLabel r100) {
            this.f400355a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            int r102 = this.f400355a.getWidth();
            int r103 = this.f400355a.getHeight();
            r101.setRoundRect(0, 0, r102, r103, (Math.min(r102, r103) * this.f400355a.f400334f) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MotionLabel f400356a;

        public b(MotionLabel r100) {
            this.f400356a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, this.f400356a.getWidth(), this.f400356a.getHeight(), this.f400356a.f400335g);
        }
    }

    private float getHorizontalOffset() {
        if (Float.isNaN(this.f400339k) == false) goto L5;
        float r100 = 1.0f;
    L6:
        TextPaint r101 = this.f400329a;
        String r102 = this.f400343o;
        float r103 = r100 * r101.measureText(r102, 0, r102.length());
        if (Float.isNaN(this.A) == false) goto L9;
        float r104 = getMeasuredWidth();
    L11:
        return ((((r104 - getPaddingLeft()) - getPaddingRight()) - r103) * (this.f400328J + 1.0f)) / 2.0f;
    L9:
        r104 = this.A;
        goto L11
    L5:
        r100 = this.f400338j / this.f400339k;
        goto L6
    }

    private float getVerticalOffset() {
        if (Float.isNaN(this.f400339k) == false) goto L5;
        float r100 = 1.0f;
    L6:
        Paint.FontMetrics r101 = this.f400329a.getFontMetrics();
        if (Float.isNaN(this.B) == false) goto L9;
        float r102 = getMeasuredHeight();
    L10:
        float r103 = (r102 - getPaddingTop()) - getPaddingBottom();
        float r104 = r101.descent;
        float r105 = r101.ascent;
        return (((r103 - ((r104 - r105) * r100)) * (1.0f - this.K)) / 2.0f) - (r100 * r105);
    L9:
        r102 = this.B;
        goto L10
    L5:
        r100 = this.f400338j / this.f400339k;
        goto L6
    }

    public final void d() {
        float r100 = 0.0f;
        if (Float.isNaN(this.Q) == false) goto L5;
        float r101 = 0.0f;
    L7:
        if (Float.isNaN(this.R) == false) goto L9;
        float r102 = 0.0f;
    L11:
        if (Float.isNaN(this.S) == false) goto L13;
        float r103 = 1.0f;
    L15:
        if (Float.isNaN(this.T) == true) goto L18;
        r100 = this.T;
    L18:
        this.G.reset();
        float r104 = this.E.getWidth();
        float r105 = this.E.getHeight();
        if (Float.isNaN(this.I) == false) goto L21;
        float r106 = this.A;
    L23:
        if (Float.isNaN(this.H) == false) goto L25;
        float r107 = this.B;
    L27:
        if ((r104 * r107) >= (r105 * r106)) goto L29;
        float r108 = r106 / r104;
    L30:
        float r109 = r103 * r108;
        this.G.postScale(r109, r109);
        float r110 = r104 * r109;
        float r111 = r106 - r110;
        float r112 = r109 * r105;
        float r113 = r107 - r112;
        if (Float.isNaN(this.H) == true) goto L34;
        r113 = this.H / 2.0f;
    L34:
        if (Float.isNaN(this.I) == true) goto L36;
        r111 = this.I / 2.0f;
    L36:
        float r114 = (((r102 * r113) + r107) - r112) * 0.5f;
        this.G.postTranslate((((r101 * r111) + r106) - r110) * 0.5f, r114);
        this.G.postRotate(r100, r106 / 2.0f, r107 / 2.0f);
        this.F.setLocalMatrix(this.G);
        return;
    L29:
        r108 = r107 / r105;
        goto L30
    L25:
        r107 = this.H;
        goto L27
    L21:
        r106 = this.I;
        goto L23
    L13:
        r103 = this.S;
        goto L15
    L9:
        r102 = this.R;
        goto L11
    L5:
        r101 = this.Q;
        goto L7
    }

    public Typeface getTypeface() {
        return this.f400329a.getTypeface();
    }

    public float getRound() {
        return this.f400335g;
    }

    public float getRoundPercent() {
        return this.f400334f;
    }

    public float getScaleFromTextSize() {
        return this.f400339k;
    }

    public float getTextBackgroundPanX() {
        return this.Q;
    }

    public float getTextBackgroundPanY() {
        return this.R;
    }

    public float getTextBackgroundRotate() {
        return this.T;
    }

    public float getTextBackgroundZoom() {
        return this.S;
    }

    public int getTextOutlineColor() {
        return this.f400332d;
    }

    public float getTextPanX() {
        return this.f400328J;
    }

    public float getTextPanY() {
        return this.K;
    }

    public float getTextureHeight() {
        return this.H;
    }

    public float getTextureWidth() {
        return this.I;
    }

    public MotionLabel(Context r100) {
        super(r100);
        this.f400329a = new TextPaint();
        this.f400330b = new Path();
        this.f400331c = 65535;
        this.f400332d = 65535;
        this.f400333e = false;
        this.f400334f = 0.0f;
        this.f400335g = Float.NaN;
        this.f400338j = 48.0f;
        this.f400339k = Float.NaN;
        this.f400342n = 0.0f;
        this.f400343o = "Hello World";
        this.f400344p = true;
        this.f400345q = new Rect();
        this.f400346r = 1;
        this.f400347s = 1;
        this.f400348t = 1;
        this.f400349u = 1;
        this.f400351w = 8388659;
        this.f400352x = 0;
        this.f400353y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.f400328J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        c(r100, null);
    }

    private void setUpTheme(Context r100) {
        TypedValue r101 = new TypedValue();
        r100.getTheme().resolveAttribute(R.attr.colorPrimary, r101, true);
        TextPaint r102 = this.f400329a;
        int r103 = r101.data;
        this.f400331c = r103;
        r102.setColor(r103);
    }

    public final void b(float r110) {
        if (this.f400333e == false) goto L5;
    L7:
        this.f400330b.reset();
        String r100 = this.f400343o;
        int r101 = r100.length();
        this.f400329a.getTextBounds(r100, 0, r101, this.f400345q);
        this.f400329a.getTextPath(r100, 0, r101, 0.0f, 0.0f, this.f400330b);
        if (r110 == 1.0f) goto L10;
        com.obric.oui.constraintlayout.motion.widget.a.a();
        Matrix r102 = new Matrix();
        r102.postScale(r110, r110);
        this.f400330b.transform(r102);
    L10:
        Rect r111 = this.f400345q;
        r111.right--;
        r111.left++;
        r111.bottom++;
        r111.top--;
        RectF r112 = new RectF();
        r112.bottom = getHeight();
        r112.right = getWidth();
        this.f400344p = false;
        return;
    L5:
        if (r110 != 1.0f) goto L7;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        if (Float.isNaN(this.f400339k) == false) goto L5;
        float r101 = 1.0f;
    L6:
        super.onDraw(r100);
        if (this.f400333e == true) goto L13;
        if (r101 != 1.0f) goto L13;
        float r102 = this.f400346r + getHorizontalOffset();
        r100.drawText(this.f400343o, this.f400354z + r102, this.f400348t + getVerticalOffset(), this.f400329a);
        return;
    L13:
        if (this.f400344p == false) goto L16;
        b(r101);
    L16:
        if (this.D != null) goto L19;
        this.D = new Matrix();
    L19:
        if (this.f400333e == false) goto L28;
        this.L.set(this.f400329a);
        this.D.reset();
        float r103 = this.f400346r + getHorizontalOffset();
        float r104 = this.f400348t + getVerticalOffset();
        this.D.postTranslate(r103, r104);
        this.D.preScale(r101, r101);
        this.f400330b.transform(this.D);
        if (this.F == null) goto L23;
        this.f400329a.setFilterBitmap(true);
        this.f400329a.setShader(this.F);
    L24:
        this.f400329a.setStyle(Paint.Style.FILL);
        this.f400329a.setStrokeWidth(this.f400342n);
        r100.drawPath(this.f400330b, this.f400329a);
        if (this.F == null) goto L27;
        this.f400329a.setShader(null);
    L27:
        this.f400329a.setColor(this.f400332d);
        this.f400329a.setStyle(Paint.Style.STROKE);
        this.f400329a.setStrokeWidth(this.f400342n);
        r100.drawPath(this.f400330b, this.f400329a);
        this.D.reset();
        this.D.postTranslate(-r103, -r104);
        this.f400330b.transform(this.D);
        this.f400329a.set(this.L);
        return;
    L23:
        this.f400329a.setColor(this.f400331c);
        goto L24
    L28:
        float r105 = this.f400346r + getHorizontalOffset();
        float r106 = this.f400348t + getVerticalOffset();
        this.D.reset();
        this.D.preTranslate(r105, r106);
        this.f400330b.transform(this.D);
        this.f400329a.setColor(this.f400331c);
        this.f400329a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f400329a.setStrokeWidth(this.f400342n);
        r100.drawPath(this.f400330b, this.f400329a);
        this.D.reset();
        this.D.preTranslate(-r105, -r106);
        this.f400330b.transform(this.D);
        return;
    L5:
        r101 = this.f400338j / this.f400339k;
        goto L6
    }

    public void setGravity(int r100) {
        if ((r100 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 0) goto L6;
        r100 = r100 | GravityCompat.START;
    L6:
        if ((r100 & 112) != 0) goto L9;
        r100 = r100 | 48;
    L9:
        if (r100 == this.f400351w) goto L11;
        invalidate();
    L11:
        this.f400351w = r100;
        int r101 = r100 & 112;
        if (r101 != 48) goto L14;
        this.K = -1.0f;
    L18:
        int r102 = r100 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r102 != 3) goto L21;
    L27:
        this.f400328J = -1.0f;
        return;
    L21:
        if (r102 == 5) goto L26;
        if (r102 == 8388611) goto L27;
        if (r102 == 8388613) goto L26;
        this.f400328J = 0.0f;
        return;
    L26:
        this.f400328J = 1.0f;
        return;
    L14:
        if (r101 == 80) goto L16;
        this.K = 0.0f;
        goto L18
    L16:
        this.K = 1.0f;
        goto L18
    }

    public void setRound(float r100) {
        if (Float.isNaN(r100) == false) goto L7;
        this.f400335g = r100;
        float r101 = this.f400334f;
        this.f400334f = -1.0f;
        setRoundPercent(r101);
        return;
    L7:
        if (this.f400335g == r100) goto L9;
        boolean r102 = true;
    L10:
        this.f400335g = r100;
        if (r100 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r102 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f400330b != null) goto L16;
        this.f400330b = new Path();
    L16:
        if (this.f400337i != null) goto L19;
        this.f400337i = new RectF();
    L19:
        if (this.f400336h != null) goto L21;
        b r103 = new b(this);
        this.f400336h = r103;
        setOutlineProvider(r103);
    L21:
        setClipToOutline(true);
        this.f400337i.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f400330b.reset();
        Path r104 = this.f400330b;
        RectF r105 = this.f400337i;
        float r106 = this.f400335g;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        goto L23
    L9:
        r102 = false;
        goto L10
    }

    public void setRoundPercent(float r100) {
        if (this.f400334f == r100) goto L5;
        boolean r101 = true;
    L6:
        this.f400334f = r100;
        if (r100 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r101 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f400330b != null) goto L12;
        this.f400330b = new Path();
    L12:
        if (this.f400337i != null) goto L15;
        this.f400337i = new RectF();
    L15:
        if (this.f400336h != null) goto L17;
        a r102 = new a(this);
        this.f400336h = r102;
        setOutlineProvider(r102);
    L17:
        setClipToOutline(true);
        int r103 = getWidth();
        int r104 = getHeight();
        float r105 = (Math.min(r103, r104) * this.f400334f) / 2.0f;
        this.f400337i.set(0.0f, 0.0f, r103, r104);
        this.f400330b.reset();
        this.f400330b.addRoundRect(this.f400337i, r105, r105, Path.Direction.CW);
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public void setScaleFromTextSize(float r100) {
        this.f400339k = r100;
    }

    public void setText(CharSequence r100) {
        this.f400343o = r100.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float r100) {
        this.Q = r100;
        d();
        invalidate();
    }

    public void setTextBackgroundPanY(float r100) {
        this.R = r100;
        d();
        invalidate();
    }

    public void setTextBackgroundRotate(float r100) {
        this.T = r100;
        d();
        invalidate();
    }

    public void setTextBackgroundZoom(float r100) {
        this.S = r100;
        d();
        invalidate();
    }

    public void setTextFillColor(int r100) {
        this.f400331c = r100;
        invalidate();
    }

    public void setTextOutlineColor(int r100) {
        this.f400332d = r100;
        this.f400333e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float r100) {
        this.f400342n = r100;
        this.f400333e = true;
        if (Float.isNaN(r100) == false) goto L5;
        this.f400342n = 1.0f;
        this.f400333e = false;
    L5:
        invalidate();
    }

    public void setTextPanX(float r100) {
        this.f400328J = r100;
        invalidate();
    }

    public void setTextPanY(float r100) {
        this.K = r100;
        invalidate();
    }

    public void setTextSize(float r100) {
        this.f400338j = r100;
        TextPaint r101 = this.f400329a;
        if (Float.isNaN(this.f400339k) == true) goto L6;
        r100 = this.f400339k;
    L6:
        r101.setTextSize(r100);
        if (Float.isNaN(this.f400339k) == false) goto L9;
        float r102 = 1.0f;
    L10:
        b(r102);
        requestLayout();
        invalidate();
        return;
    L9:
        r102 = this.f400338j / this.f400339k;
        goto L10
    }

    public void setTextureHeight(float r100) {
        this.H = r100;
        d();
        invalidate();
    }

    public void setTextureWidth(float r100) {
        this.I = r100;
        d();
        invalidate();
    }

    public void setTypeface(Typeface r100) {
        if (Objects.equals(this.f400329a.getTypeface(), r100) == true) goto L6;
        this.f400329a.setTypeface(r100);
        return;
    }

    public MotionLabel(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400329a = new TextPaint();
        this.f400330b = new Path();
        this.f400331c = 65535;
        this.f400332d = 65535;
        this.f400333e = false;
        this.f400334f = 0.0f;
        this.f400335g = Float.NaN;
        this.f400338j = 48.0f;
        this.f400339k = Float.NaN;
        this.f400342n = 0.0f;
        this.f400343o = "Hello World";
        this.f400344p = true;
        this.f400345q = new Rect();
        this.f400346r = 1;
        this.f400347s = 1;
        this.f400348t = 1;
        this.f400349u = 1;
        this.f400351w = 8388659;
        this.f400352x = 0;
        this.f400353y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.f400328J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        c(r100, r101);
    }

    public final void c(Context r110, AttributeSet r111) {
        setUpTheme(r110);
        boolean r100 = false;
        if (r111 == null) goto L73;
        TypedArray r112 = getContext().obtainStyledAttributes(r111, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.gravity, android.R.attr.text, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.autoSizeTextType, R.attr.borderRound, R.attr.borderRoundPercent, R.attr.scaleFromTextSize, R.attr.textBackground, R.attr.textBackgroundPanX, R.attr.textBackgroundPanY, R.attr.textBackgroundRotate, R.attr.textBackgroundZoom, R.attr.textOutlineColor, R.attr.textOutlineThickness, R.attr.textPanX, R.attr.textPanY, R.attr.textureBlurFactor, R.attr.textureEffect, R.attr.textureHeight, R.attr.textureWidth});
        int r101 = r112.getIndexCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L71;
        int r103 = r112.getIndex(r102);
        if (r103 != 5) goto L10;
        setText(r112.getText(r103));
    L70:
        r102 = r102 + 1;
        goto L5
    L10:
        if (r103 != 7) goto L13;
        this.f400350v = r112.getString(r103);
        goto L70
    L13:
        if (r103 != 11) goto L15;
        this.f400339k = r112.getDimensionPixelSize(r103, (int) this.f400339k);
        goto L70
    L15:
        if (r103 != 0) goto L17;
        this.f400338j = r112.getDimensionPixelSize(r103, (int) this.f400338j);
        goto L70
    L17:
        if (r103 != 2) goto L19;
        this.f400340l = r112.getInt(r103, this.f400340l);
        goto L70
    L19:
        if (r103 != 1) goto L21;
        this.f400341m = r112.getInt(r103, this.f400341m);
        goto L70
    L21:
        if (r103 != 3) goto L24;
        this.f400331c = r112.getColor(r103, this.f400331c);
        goto L70
    L24:
        if (r103 != 9) goto L27;
        float r104 = r112.getDimension(r103, this.f400335g);
        this.f400335g = r104;
        setRound(r104);
        goto L70
    L27:
        if (r103 != 10) goto L29;
        float r105 = r112.getFloat(r103, this.f400334f);
        this.f400334f = r105;
        setRoundPercent(r105);
        goto L70
    L29:
        if (r103 != 4) goto L32;
        setGravity(r112.getInt(r103, -1));
        goto L70
    L32:
        if (r103 != 8) goto L35;
        this.f400352x = r112.getInt(r103, 0);
        goto L70
    L35:
        if (r103 != 17) goto L38;
        this.f400332d = r112.getInt(r103, this.f400332d);
        this.f400333e = true;
        goto L70
    L38:
        if (r103 != 18) goto L41;
        this.f400342n = r112.getDimension(r103, this.f400342n);
        this.f400333e = true;
        goto L70
    L41:
        if (r103 != 12) goto L44;
        this.C = r112.getDrawable(r103);
        this.f400333e = true;
        goto L70
    L44:
        if (r103 != 13) goto L47;
        this.Q = r112.getFloat(r103, this.Q);
        goto L70
    L47:
        if (r103 != 14) goto L50;
        this.R = r112.getFloat(r103, this.R);
        goto L70
    L50:
        if (r103 != 19) goto L53;
        this.f400328J = r112.getFloat(r103, this.f400328J);
        goto L70
    L53:
        if (r103 != 20) goto L56;
        this.K = r112.getFloat(r103, this.K);
        goto L70
    L56:
        if (r103 != 15) goto L59;
        this.T = r112.getFloat(r103, this.T);
        goto L70
    L59:
        if (r103 != 16) goto L62;
        this.S = r112.getFloat(r103, this.S);
        goto L70
    L62:
        if (r103 != 23) goto L65;
        this.H = r112.getDimension(r103, this.H);
        goto L70
    L65:
        if (r103 != 24) goto L68;
        this.I = r112.getDimension(r103, this.I);
        goto L70
    L68:
        if (r103 != 22) goto L70;
        this.M = r112.getInt(r103, this.M);
        goto L70
    L71:
        r112.recycle();
    L73:
        if (this.C == null) goto L103;
        this.G = new Matrix();
        int r113 = this.C.getIntrinsicWidth();
        int r106 = this.C.getIntrinsicHeight();
        if (r113 > 0) goto L82;
        r113 = getWidth();
        if (r113 != 0) goto L82;
        if (Float.isNaN(this.I) == false) goto L81;
        r113 = 128;
        goto L82
    L81:
        r113 = (int) this.I;
    L82:
        if (r106 > 0) goto L90;
        r106 = getHeight();
        if (r106 != 0) goto L90;
        if (Float.isNaN(this.H) == false) goto L88;
        r106 = 128;
        goto L90
    L88:
        r106 = (int) this.H;
    L90:
        if (this.M == 0) goto L92;
        r113 = r113 / 2;
        r106 = r106 / 2;
    L92:
        this.E = Bitmap.createBitmap(r113, r106, Bitmap.Config.ARGB_8888);
        Canvas r114 = new Canvas(this.E);
        this.C.setBounds(0, 0, r114.getWidth(), r114.getHeight());
        this.C.setFilterBitmap(true);
        this.C.draw(r114);
        if (this.M == 0) goto L102;
        Bitmap r115 = this.E;
        int r107 = r115.getWidth() / 2;
        int r108 = r115.getHeight() / 2;
        Bitmap r116 = Bitmap.createScaledBitmap(r115, r107, r108, true);
        int r109 = 0;
    L95:
        if (r109 >= 4) goto L101;
        if (r107 < 32) goto L101;
        if (r108 < 32) goto L101;
        r107 = r107 / 2;
        r108 = r108 / 2;
        r116 = Bitmap.createScaledBitmap(r116, r107, r108, true);
        r109 = r109 + 1;
    L101:
        this.E = r116;
    L102:
        Bitmap r117 = this.E;
        Shader.TileMode r118 = Shader.TileMode.REPEAT;
        this.F = new BitmapShader(r117, r118, r118);
    L103:
        this.f400346r = getPaddingLeft();
        this.f400347s = getPaddingRight();
        this.f400348t = getPaddingTop();
        this.f400349u = getPaddingBottom();
        String r119 = this.f400350v;
        int r120 = this.f400341m;
        int r121 = this.f400340l;
        if (r119 == null) goto L108;
        Typeface r122 = Typeface.create(r119, r121);
        if (r122 == null) goto L109;
        setTypeface(r122);
    L133:
        this.f400329a.setColor(this.f400331c);
        this.f400329a.setStrokeWidth(this.f400342n);
        this.f400329a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f400329a.setFlags(128);
        setTextSize(this.f400338j);
        this.f400329a.setAntiAlias(true);
        return;
    L109:
        if (r120 == 1) goto L115;
        if (r120 == 2) goto L114;
        if (r120 != 3) goto L116;
        r122 = Typeface.MONOSPACE;
    L116:
        float r123 = 0.0f;
        if (r121 <= 0) goto L132;
        if (r122 != null) goto L120;
        Typeface r124 = Typeface.defaultFromStyle(r121);
    L121:
        setTypeface(r124);
        if (r124 == null) goto L124;
        int r125 = r124.getStyle();
    L125:
        int r126 = (~r125) & r121;
        TextPaint r127 = this.f400329a;
        if ((r126 & 1) == 0) goto L128;
        r100 = true;
    L128:
        r127.setFakeBoldText(r100);
        TextPaint r128 = this.f400329a;
        if ((r126 & 2) == 0) goto L131;
        r123 = -0.25f;
    L131:
        r128.setTextSkewX(r123);
        goto L133
    L124:
        r125 = 0;
        goto L125
    L120:
        r124 = Typeface.create(r122, r121);
        goto L121
    L132:
        this.f400329a.setFakeBoldText(false);
        this.f400329a.setTextSkewX(0.0f);
        setTypeface(r122);
        goto L133
    L114:
        r122 = Typeface.SERIF;
        goto L116
    L115:
        r122 = Typeface.SANS_SERIF;
        goto L116
    L108:
        r122 = null;
        goto L109
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = View.MeasureSpec.getMode(r100);
        int r102 = View.MeasureSpec.getMode(r110);
        int r103 = View.MeasureSpec.getSize(r100);
        int r111 = View.MeasureSpec.getSize(r110);
        this.f400353y = false;
        this.f400346r = getPaddingLeft();
        this.f400347s = getPaddingRight();
        this.f400348t = getPaddingTop();
        this.f400349u = getPaddingBottom();
        if (r101 != 1073741824) goto L9;
        if (r102 != 1073741824) goto L9;
        if (this.f400352x == 0) goto L18;
        this.f400353y = true;
    L18:
        setMeasuredDimension(r103, r111);
        return;
    L9:
        TextPaint r104 = this.f400329a;
        String r105 = this.f400343o;
        r104.getTextBounds(r105, 0, r105.length(), this.f400345q);
        if (r101 == 1073741824) goto L12;
        r103 = (int) (this.f400345q.width() + 0.99999f);
    L12:
        r103 = r103 + (this.f400346r + this.f400347s);
        if (r102 == 1073741824) goto L18;
        int r106 = (int) (this.f400329a.getFontMetricsInt(null) + 0.99999f);
        if (r102 != Integer.MIN_VALUE) goto L17;
        r106 = Math.min(r111, r106);
    L17:
        r111 = (this.f400348t + this.f400349u) + r106;
        goto L18
    }

    public MotionLabel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400329a = new TextPaint();
        this.f400330b = new Path();
        this.f400331c = 65535;
        this.f400332d = 65535;
        this.f400333e = false;
        this.f400334f = 0.0f;
        this.f400335g = Float.NaN;
        this.f400338j = 48.0f;
        this.f400339k = Float.NaN;
        this.f400342n = 0.0f;
        this.f400343o = "Hello World";
        this.f400344p = true;
        this.f400345q = new Rect();
        this.f400346r = 1;
        this.f400347s = 1;
        this.f400348t = 1;
        this.f400349u = 1;
        this.f400351w = 8388659;
        this.f400352x = 0;
        this.f400353y = false;
        this.H = Float.NaN;
        this.I = Float.NaN;
        this.f400328J = 0.0f;
        this.K = 0.0f;
        this.L = new Paint();
        this.M = 0;
        this.Q = Float.NaN;
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = Float.NaN;
        c(r100, r101);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.c
    public final void a(float r100, float r101, float r102, float r110) {
        int r103 = (int) (r100 + 0.5f);
        this.f400354z = r100 - r103;
        int r104 = (int) (r102 + 0.5f);
        int r105 = r104 - r103;
        int r106 = (int) (r110 + 0.5f);
        int r107 = (int) (0.5f + r101);
        int r108 = r106 - r107;
        float r109 = r102 - r100;
        this.A = r109;
        float r111 = r110 - r101;
        this.B = r111;
        if (this.G == null) goto L7;
        this.A = r109;
        this.B = r111;
        d();
    L7:
        if (getMeasuredHeight() == r108) goto L9;
    L12:
        measure(View.MeasureSpec.makeMeasureSpec(r105, 1073741824), View.MeasureSpec.makeMeasureSpec(r108, 1073741824));
        super.layout(r103, r107, r104, r106);
    L14:
        if (this.f400353y == true) goto L16;
        return;
    L16:
        if (this.N != null) goto L18;
        this.O = new Paint();
        this.N = new Rect();
        this.O.set(this.f400329a);
        this.P = this.O.getTextSize();
    L18:
        this.A = r109;
        this.B = r111;
        Paint r112 = this.O;
        String r113 = this.f400343o;
        r112.getTextBounds(r113, 0, r113.length(), this.N);
        int r114 = this.N.width();
        float r115 = this.N.height() * 1.3f;
        float r116 = (r109 - this.f400347s) - this.f400346r;
        float r117 = (r111 - this.f400349u) - this.f400348t;
        float r118 = r114;
        if ((r118 * r117) <= (r115 * r116)) goto L21;
        this.f400329a.setTextSize((this.P * r116) / r118);
    L23:
        if (this.f400333e == true) goto L27;
        if (Float.isNaN(this.f400339k) == false) goto L27;
        return;
    L27:
        if (Float.isNaN(this.f400339k) == false) goto L29;
        float r119 = 1.0f;
    L30:
        b(r119);
        return;
    L29:
        r119 = this.f400338j / this.f400339k;
        goto L30
    L21:
        this.f400329a.setTextSize((this.P * r117) / r115);
        goto L23
    L9:
        if (getMeasuredWidth() != r105) goto L12;
        super.layout(r103, r107, r104, r106);
        goto L14
    }

    @Override // android.view.View
    public final void layout(int r100, int r110, int r111, int r112) {
        super.layout(r100, r110, r111, r112);
        boolean r101 = Float.isNaN(this.f400339k);
        if (r101 == false) goto L5;
        float r102 = 1.0f;
    L6:
        this.A = r111 - r100;
        this.B = r112 - r110;
        if (this.f400353y == false) goto L22;
        if (this.N != null) goto L11;
        this.O = new Paint();
        this.N = new Rect();
        this.O.set(this.f400329a);
        this.P = this.O.getTextSize();
    L11:
        Paint r103 = this.O;
        String r104 = this.f400343o;
        r103.getTextBounds(r104, 0, r104.length(), this.N);
        int r105 = this.N.width();
        int r106 = (int) (this.N.height() * 1.3f);
        float r107 = (this.A - this.f400347s) - this.f400346r;
        float r108 = (this.B - this.f400349u) - this.f400348t;
        if (r101 == false) goto L17;
        float r109 = r105;
        float r113 = r106;
        if ((r109 * r108) <= (r113 * r107)) goto L16;
        this.f400329a.setTextSize((this.P * r107) / r109);
        goto L22
    L16:
        this.f400329a.setTextSize((this.P * r108) / r113);
        goto L22
    L17:
        float r114 = r105;
        float r115 = r106;
        if ((r114 * r108) <= (r115 * r107)) goto L20;
        r102 = r107 / r114;
        goto L22
    L20:
        r102 = r108 / r115;
    L22:
        if (this.f400333e == true) goto L24;
        if (r101 == false) goto L24;
        return;
    L24:
        float r116 = r100;
        float r117 = r110;
        float r118 = r111;
        float r119 = r112;
        if (this.G == null) goto L28;
        this.A = r118 - r116;
        this.B = r119 - r117;
        d();
    L28:
        b(r102);
        return;
    L5:
        r102 = this.f400338j / this.f400339k;
        goto L6
    }
}
