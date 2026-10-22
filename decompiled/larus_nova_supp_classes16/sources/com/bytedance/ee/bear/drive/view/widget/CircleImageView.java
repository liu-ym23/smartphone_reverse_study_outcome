package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CircleImageView extends ImageView {
    public static final ImageView.ScaleType u = null;
    public static final Bitmap.Config v = null;
    public final RectF a;
    public final RectF b;
    public final Matrix c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public int g;
    public int h;
    public int i;
    public Bitmap j;
    public BitmapShader k;
    public int l;
    public int m;
    public float n;
    public float o;
    public ColorFilter p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;

    public class a extends ViewOutlineProvider {
        public final /* synthetic */ CircleImageView a;

        public a(CircleImageView r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r3, Outline r4) {
            Rect r5 = new Rect();
            this.a.b.roundOut(r5);
            r4.setRoundRect(r5, r5.width() / 2.0f);
        }
    }

    static {
        u = ImageView.ScaleType.CENTER_CROP;
        v = Bitmap.Config.ARGB_8888;
    }

    public final void a() {
        Bitmap r1 = null;
        if (this.t == false) goto L5;
        this.j = null;
    L20:
        b();
        return;
    L5:
        Drawable r0 = getDrawable();
        if (r0 != null) goto L9;
    L19:
        this.j = r1;
        goto L20
    L9:
        if ((r0 instanceof BitmapDrawable) == false) goto L22;
        r1 = ((BitmapDrawable) r0).getBitmap();
        goto L19
    L22:
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L12:
        if ((r0 instanceof ColorDrawable) == false) goto L14;
        Bitmap r2 = Bitmap.createBitmap(2, 2, v);     // Catch: Exception -> L17
    L15:
        Canvas r3 = new Canvas(r2);     // Catch: Exception -> L17
        r0.setBounds(0, 0, r3.getWidth(), r3.getHeight());     // Catch: Exception -> L17
        r0.draw(r3);     // Catch: Exception -> L17
        r1 = r2;
        goto L19
    L14:
        r2 = Bitmap.createBitmap(r0.getIntrinsicWidth(), r0.getIntrinsicHeight(), v);     // Catch: Exception -> L17
        goto L15
    }

    public final void b() {
        if (this.q == true) goto L7;
        this.r = true;
        return;
    L7:
        if (getWidth() != 0) goto L12;
        if (getHeight() != 0) goto L12;
        return;
    L12:
        if (this.j != null) goto L15;
        invalidate();
        return;
    L15:
        Bitmap r2 = this.j;
        Shader.TileMode r3 = Shader.TileMode.CLAMP;
        this.k = new BitmapShader(r2, r3, r3);
        this.d.setAntiAlias(true);
        this.d.setShader(this.k);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setColor(this.g);
        this.e.setStrokeWidth(this.h);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.f.setColor(this.i);
        this.m = this.j.getHeight();
        this.l = this.j.getWidth();
        RectF r0 = this.b;
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = Math.min(r1, r4);
        float r6 = getPaddingLeft() + ((r1 - r5) / 2.0f);
        float r7 = getPaddingTop() + ((r4 - r5) / 2.0f);
        float r8 = r5;
        r0.set(new RectF(r6, r7, r6 + r8, r8 + r7));
        this.o = Math.min((this.b.height() - this.h) / 2.0f, (this.b.width() - this.h) / 2.0f);
        this.a.set(this.b);
        if (this.s == true) goto L20;
        int r9 = this.h;
        if (r9 <= 0) goto L20;
        float r10 = r9 - 1.0f;
        this.a.inset(r10, r10);
    L20:
        this.n = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
        this.d.setColorFilter(this.p);
        this.c.set(null);
        float r11 = 0.0f;
        if ((this.l * this.a.height()) <= (this.a.width() * this.m)) goto L23;
        float r12 = this.a.height() / this.m;
        r11 = (this.a.width() - (this.l * r12)) * 0.5f;
        float r13 = 0.0f;
    L24:
        this.c.setScale(r12, r12);
        Matrix r14 = this.c;
        RectF r16 = this.a;
        r14.postTranslate(((int) (r11 + 0.5f)) + r16.left, ((int) (r13 + 0.5f)) + r16.top);
        this.k.setLocalMatrix(this.c);
        invalidate();
        return;
    L23:
        r12 = this.a.width() / this.l;
        r13 = (this.a.height() - (this.m * r12)) * 0.5f;
        goto L24
    }

    public int getBorderColor() {
        return this.g;
    }

    public int getBorderWidth() {
        return this.h;
    }

    public int getCircleBackgroundColor() {
        return this.i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.p;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return u;
    }

    public CircleImageView(Context r2) {
        super(r2);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = -16777216;
        this.h = 0;
        this.i = 0;
        super.setScaleType(u);
        this.q = true;
        setOutlineProvider(new a(this));
        if (this.r == false) goto L6;
        b();
        this.r = false;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r5) {
        if (this.t == false) goto L7;
        super.onDraw(r5);
        return;
    L7:
        if (this.j != null) goto L10;
        return;
    L10:
        if (this.i == 0) goto L12;
        r5.drawCircle(this.a.centerX(), this.a.centerY(), this.n, this.f);
    L12:
        r5.drawCircle(this.a.centerX(), this.a.centerY(), this.n, this.d);
        if (this.h <= 0) goto L16;
        r5.drawCircle(this.b.centerX(), this.b.centerY(), this.o, this.e);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if ((Math.pow(r8.getX() - this.b.centerX(), 2.0d) + Math.pow(r8.getY() - this.b.centerY(), 2.0d)) > Math.pow(this.o, 2.0d)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r8) == false) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r2) {
        if (r2 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(int r2) {
        if (r2 != this.g) goto L5;
        return;
    L5:
        this.g = r2;
        this.e.setColor(r2);
        invalidate();
    }

    public void setBorderOverlay(boolean r2) {
        if (r2 != this.s) goto L5;
        return;
    L5:
        this.s = r2;
        b();
    }

    public void setBorderWidth(int r2) {
        if (r2 != this.h) goto L5;
        return;
    L5:
        this.h = r2;
        b();
    }

    public void setCircleBackgroundColor(int r2) {
        if (r2 != this.i) goto L5;
        return;
    L5:
        this.i = r2;
        this.f.setColor(r2);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int r2) {
        setCircleBackgroundColor(getContext().getResources().getColor(r2));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r2) {
        if (r2 != this.p) goto L5;
        return;
    L5:
        this.p = r2;
        this.d.setColorFilter(r2);
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r2) {
        if (this.t != r2) goto L5;
        return;
    L5:
        this.t = r2;
        a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r1) {
        super.setImageBitmap(r1);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(r1);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r1) {
        super.setImageResource(r1);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r1) {
        super.setImageURI(r1);
        a();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r4) {
        if (r4 != u) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r4}));
    }

    public CircleImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CircleImageView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = -16777216;
        this.h = 0;
        this.i = 0;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130969837, 2130969838, 2130969839, 2130969840}, r6, 0);
        this.h = r7.getDimensionPixelSize(2, 0);
        this.g = r7.getColor(0, -16777216);
        this.s = r7.getBoolean(1, false);
        this.i = r7.getColor(3, 0);
        r7.recycle();
        super.setScaleType(u);
        this.q = true;
        setOutlineProvider(new a(this));
        if (this.r == false) goto L6;
        b();
        this.r = false;
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b();
    }

    @Override // android.view.View
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        b();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
        b();
    }
}
