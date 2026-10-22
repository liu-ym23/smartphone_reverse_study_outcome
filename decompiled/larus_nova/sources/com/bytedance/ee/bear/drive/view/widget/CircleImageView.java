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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class CircleImageView extends ImageView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ImageView.ScaleType f225859u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Bitmap.Config f225860v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f225861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f225862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f225863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f225864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f225865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f225866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f225867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f225868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f225869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f225870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BitmapShader f225871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f225872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f225873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f225874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f225875o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorFilter f225876p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f225877q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f225878r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f225879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f225880t;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CircleImageView f225881a;

        public a(CircleImageView r100) {
            this.f225881a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Rect r102 = new Rect();
            this.f225881a.f225862b.roundOut(r102);
            r101.setRoundRect(r102, r102.width() / 2.0f);
        }
    }

    static {
        f225859u = ImageView.ScaleType.CENTER_CROP;
        f225860v = Bitmap.Config.ARGB_8888;
    }

    public final void a() {
        Bitmap r100 = null;
        if (this.f225880t == false) goto L5;
        this.f225870j = null;
    L20:
        b();
        return;
    L5:
        Drawable r101 = getDrawable();
        if (r101 != null) goto L9;
    L19:
        this.f225870j = r100;
        goto L20
    L9:
        if ((r101 instanceof BitmapDrawable) == false) goto L22;
        r100 = ((BitmapDrawable) r101).getBitmap();
        goto L19
    L22:
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L12:
        if ((r101 instanceof ColorDrawable) == false) goto L14;
        Bitmap r102 = Bitmap.createBitmap(2, 2, f225860v);     // Catch: Exception -> L17
    L15:
        Canvas r103 = new Canvas(r102);     // Catch: Exception -> L17
        r101.setBounds(0, 0, r103.getWidth(), r103.getHeight());     // Catch: Exception -> L17
        r101.draw(r103);     // Catch: Exception -> L17
        r100 = r102;
        goto L19
    L14:
        r102 = Bitmap.createBitmap(r101.getIntrinsicWidth(), r101.getIntrinsicHeight(), f225860v);     // Catch: Exception -> L17
        goto L15
    }

    public final void b() {
        if (this.f225877q == true) goto L7;
        this.f225878r = true;
        return;
    L7:
        if (getWidth() != 0) goto L12;
        if (getHeight() != 0) goto L12;
        return;
    L12:
        if (this.f225870j != null) goto L15;
        invalidate();
        return;
    L15:
        Bitmap r100 = this.f225870j;
        Shader.TileMode r101 = Shader.TileMode.CLAMP;
        this.f225871k = new BitmapShader(r100, r101, r101);
        this.f225864d.setAntiAlias(true);
        this.f225864d.setShader(this.f225871k);
        this.f225865e.setStyle(Paint.Style.STROKE);
        this.f225865e.setAntiAlias(true);
        this.f225865e.setColor(this.f225867g);
        this.f225865e.setStrokeWidth(this.f225868h);
        this.f225866f.setStyle(Paint.Style.FILL);
        this.f225866f.setAntiAlias(true);
        this.f225866f.setColor(this.f225869i);
        this.f225873m = this.f225870j.getHeight();
        this.f225872l = this.f225870j.getWidth();
        RectF r102 = this.f225862b;
        int r103 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r104 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r105 = Math.min(r103, r104);
        float r106 = getPaddingLeft() + ((r103 - r105) / 2.0f);
        float r107 = getPaddingTop() + ((r104 - r105) / 2.0f);
        float r108 = r105;
        r102.set(new RectF(r106, r107, r106 + r108, r108 + r107));
        this.f225875o = Math.min((this.f225862b.height() - this.f225868h) / 2.0f, (this.f225862b.width() - this.f225868h) / 2.0f);
        this.f225861a.set(this.f225862b);
        if (this.f225879s == true) goto L20;
        int r109 = this.f225868h;
        if (r109 <= 0) goto L20;
        float r110 = r109 - 1.0f;
        this.f225861a.inset(r110, r110);
    L20:
        this.f225874n = Math.min(this.f225861a.height() / 2.0f, this.f225861a.width() / 2.0f);
        this.f225864d.setColorFilter(this.f225876p);
        this.f225863c.set(null);
        float r111 = 0.0f;
        if ((this.f225872l * this.f225861a.height()) <= (this.f225861a.width() * this.f225873m)) goto L23;
        float r112 = this.f225861a.height() / this.f225873m;
        r111 = (this.f225861a.width() - (this.f225872l * r112)) * 0.5f;
        float r113 = 0.0f;
    L24:
        this.f225863c.setScale(r112, r112);
        Matrix r114 = this.f225863c;
        RectF r115 = this.f225861a;
        r114.postTranslate(((int) (r111 + 0.5f)) + r115.left, ((int) (r113 + 0.5f)) + r115.top);
        this.f225871k.setLocalMatrix(this.f225863c);
        invalidate();
        return;
    L23:
        r112 = this.f225861a.width() / this.f225872l;
        r113 = (this.f225861a.height() - (this.f225873m * r112)) * 0.5f;
        goto L24
    }

    public int getBorderColor() {
        return this.f225867g;
    }

    public int getBorderWidth() {
        return this.f225868h;
    }

    public int getCircleBackgroundColor() {
        return this.f225869i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f225876p;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f225859u;
    }

    public CircleImageView(Context r100) {
        super(r100);
        this.f225861a = new RectF();
        this.f225862b = new RectF();
        this.f225863c = new Matrix();
        this.f225864d = new Paint();
        this.f225865e = new Paint();
        this.f225866f = new Paint();
        this.f225867g = -16777216;
        this.f225868h = 0;
        this.f225869i = 0;
        super.setScaleType(f225859u);
        this.f225877q = true;
        setOutlineProvider(new a(this));
        if (this.f225878r == false) goto L6;
        b();
        this.f225878r = false;
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f225880t == false) goto L7;
        super.onDraw(r100);
        return;
    L7:
        if (this.f225870j != null) goto L10;
        return;
    L10:
        if (this.f225869i == 0) goto L12;
        r100.drawCircle(this.f225861a.centerX(), this.f225861a.centerY(), this.f225874n, this.f225866f);
    L12:
        r100.drawCircle(this.f225861a.centerX(), this.f225861a.centerY(), this.f225874n, this.f225864d);
        if (this.f225868h <= 0) goto L16;
        r100.drawCircle(this.f225862b.centerX(), this.f225862b.centerY(), this.f225875o, this.f225865e);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if ((Math.pow(r100.getX() - this.f225862b.centerX(), 2.0d) + Math.pow(r100.getY() - this.f225862b.centerY(), 2.0d)) > Math.pow(this.f225875o, 2.0d)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r100) == false) goto L10;
        return true;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r100) {
        if (r100 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(int r100) {
        if (r100 != this.f225867g) goto L5;
        return;
    L5:
        this.f225867g = r100;
        this.f225865e.setColor(r100);
        invalidate();
    }

    public void setBorderOverlay(boolean r100) {
        if (r100 != this.f225879s) goto L5;
        return;
    L5:
        this.f225879s = r100;
        b();
    }

    public void setBorderWidth(int r100) {
        if (r100 != this.f225868h) goto L5;
        return;
    L5:
        this.f225868h = r100;
        b();
    }

    public void setCircleBackgroundColor(int r100) {
        if (r100 != this.f225869i) goto L5;
        return;
    L5:
        this.f225869i = r100;
        this.f225866f.setColor(r100);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int r100) {
        setCircleBackgroundColor(getContext().getResources().getColor(r100));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r100) {
        if (r100 != this.f225876p) goto L5;
        return;
    L5:
        this.f225876p = r100;
        this.f225864d.setColorFilter(r100);
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r100) {
        if (this.f225880t != r100) goto L5;
        return;
    L5:
        this.f225880t = r100;
        a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        a();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        if (r100 != f225859u) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r100}));
    }

    public CircleImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225861a = new RectF();
        this.f225862b = new RectF();
        this.f225863c = new Matrix();
        this.f225864d = new Paint();
        this.f225865e = new Paint();
        this.f225866f = new Paint();
        this.f225867g = -16777216;
        this.f225868h = 0;
        this.f225869i = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.drive_civ_border_color, R.attr.drive_civ_border_overlay, R.attr.drive_civ_border_width, R.attr.drive_civ_circle_background_color}, r102, 0);
        this.f225868h = r103.getDimensionPixelSize(2, 0);
        this.f225867g = r103.getColor(0, -16777216);
        this.f225879s = r103.getBoolean(1, false);
        this.f225869i = r103.getColor(3, 0);
        r103.recycle();
        super.setScaleType(f225859u);
        this.f225877q = true;
        setOutlineProvider(new a(this));
        if (this.f225878r == false) goto L6;
        b();
        this.f225878r = false;
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b();
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        b();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        super.setPaddingRelative(r100, r101, r102, r103);
        b();
    }
}
