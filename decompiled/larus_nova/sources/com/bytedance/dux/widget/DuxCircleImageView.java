package com.bytedance.dux.widget;

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
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public class DuxCircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ImageView.ScaleType f205893v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Bitmap.Config f205894w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f205895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f205896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f205897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f205898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f205899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f205900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f205901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f205905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f205906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f205907m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f205908n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorFilter f205909o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f205910p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f205911q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f205912r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f205913s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f205914t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f205915u;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxCircleImageView f205916a;

        public a(DuxCircleImageView r100) {
            this.f205916a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (this.f205916a.f205914t == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r100, r101);
            return;
        L5:
            Rect r102 = new Rect();
            this.f205916a.f205896b.roundOut(r102);
            r101.setRoundRect(r102, r102.width() / 2.0f);
        }
    }

    public final void init() {
        this.f205910p = true;
        super.setScaleType(f205893v);
        this.f205898d.setAntiAlias(true);
        this.f205898d.setDither(true);
        this.f205898d.setFilterBitmap(true);
        this.f205898d.setAlpha(this.f205904j);
        this.f205898d.setColorFilter(this.f205909o);
        this.f205899e.setStyle(Paint.Style.STROKE);
        this.f205899e.setAntiAlias(true);
        this.f205899e.setColor(this.f205901g);
        this.f205899e.setStrokeWidth(this.f205902h);
        this.f205900f.setStyle(Paint.Style.FILL);
        this.f205900f.setAntiAlias(true);
        this.f205900f.setColor(this.f205903i);
        setOutlineProvider(new a(this));
    }

    static {
        f205893v = ImageView.ScaleType.CENTER_CROP;
        f205894w = Bitmap.Config.ARGB_8888;
    }

    public final void l() {
        RectF r100 = this.f205896b;
        int r101 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r102 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r103 = Math.min(r101, r102);
        float r104 = getPaddingLeft() + ((r101 - r103) / 2.0f);
        float r105 = getPaddingTop() + ((r102 - r103) / 2.0f);
        float r106 = r103;
        r100.set(new RectF(r104, r105, r104 + r106, r106 + r105));
        this.f205908n = Math.min((this.f205896b.height() - this.f205902h) / 2.0f, (this.f205896b.width() - this.f205902h) / 2.0f);
        RectF r107 = this.f205895a;
        int r108 = getWidth() - (this.f205915u * 2);
        int r109 = getHeight() - (this.f205915u * 2);
        int r110 = Math.min(r109, r108);
        float r111 = this.f205915u;
        float r112 = ((r108 - r110) / 2.0f) + r111;
        float r113 = r111 + ((r109 - r110) / 2.0f);
        float r114 = r110;
        r107.set(new RectF(r112, r113, r112 + r114, r114 + r113));
        if (this.f205913s == true) goto L7;
        int r115 = this.f205902h;
        if (r115 <= 0) goto L7;
        this.f205895a.inset(r115 - 1.0f, r115 - 1.0f);
    L7:
        this.f205907m = Math.min(this.f205895a.height() / 2.0f, this.f205895a.width() / 2.0f);
        m();
    }

    public final void m() {
        if (this.f205905k != null) goto L5;
        return;
    L5:
        this.f205897c.set(null);
        int r100 = this.f205905k.getHeight();
        float r101 = this.f205905k.getWidth();
        float r102 = r100;
        float r103 = 0.0f;
        if ((this.f205895a.height() * r101) <= (this.f205895a.width() * r102)) goto L8;
        float r104 = this.f205895a.height() / r102;
        r103 = (this.f205895a.width() - (r101 * r104)) * 0.5f;
        float r105 = 0.0f;
    L9:
        this.f205897c.setScale(r104, r104);
        Matrix r106 = this.f205897c;
        RectF r107 = this.f205895a;
        r106.postTranslate(((int) (r103 + 0.5f)) + r107.left, ((int) (r105 + 0.5f)) + r107.top);
        this.f205911q = true;
        return;
    L8:
        r104 = this.f205895a.width() / r101;
        r105 = (this.f205895a.height() - (r102 * r104)) * 0.5f;
        goto L9
    }

    public final void j() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L6;
    L4:
        Bitmap r101 = null;
    L16:
        this.f205905k = r101;
        if (r101 != null) goto L19;
    L21:
        this.f205906l = null;
    L23:
        if (this.f205910p == true) goto L26;
        return;
    L26:
        if (this.f205905k == null) goto L28;
        m();
        return;
    L28:
        this.f205898d.setShader(null);
        return;
    L19:
        if (r101.isMutable() == false) goto L21;
        this.f205906l = new Canvas(this.f205905k);
        goto L23
    L6:
        if ((r100 instanceof BitmapDrawable) == false) goto L30;
        r101 = ((BitmapDrawable) r100).getBitmap();
        goto L16
    L30:
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L9:
        if ((r100 instanceof ColorDrawable) == false) goto L11;
        Bitmap r102 = Bitmap.createBitmap(2, 2, f205894w);     // Catch: Exception -> L14
    L12:
        Canvas r103 = new Canvas(r102);     // Catch: Exception -> L14
        r100.setBounds(0, 0, r103.getWidth(), r103.getHeight());     // Catch: Exception -> L14
        r100.draw(r103);     // Catch: Exception -> L14
        r101 = r102;
        goto L16
    L11:
        r102 = Bitmap.createBitmap(r100.getIntrinsicWidth(), r100.getIntrinsicHeight(), f205894w);     // Catch: Exception -> L14
        goto L12
    }

    public int getBorderColor() {
        return this.f205901g;
    }

    public int getBorderWidth() {
        return this.f205902h;
    }

    public int getCircleBackgroundColor() {
        return this.f205903i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f205909o;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.f205904j;
    }

    public DuxCircleImageView(Context r100) {
        super(r100);
        this.f205895a = new RectF();
        this.f205896b = new RectF();
        this.f205897c = new Matrix();
        this.f205898d = new Paint();
        this.f205899e = new Paint();
        this.f205900f = new Paint();
        this.f205901g = -16777216;
        this.f205902h = 0;
        this.f205903i = 0;
        this.f205904j = 255;
        init();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        this.f205912r = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f205914t == false) goto L7;
        super.onDraw(r100);
        return;
    L7:
        if (this.f205903i == 0) goto L10;
        r100.drawCircle(this.f205896b.centerX(), this.f205896b.centerY(), this.f205908n, this.f205900f);
    L10:
        if (this.f205905k == null) goto L21;
        if (this.f205912r == false) goto L17;
        if (this.f205906l == null) goto L17;
        this.f205912r = false;
        Drawable r101 = getDrawable();
        r101.setBounds(0, 0, this.f205906l.getWidth(), this.f205906l.getHeight());
        r101.draw(this.f205906l);
    L17:
        if (this.f205911q == false) goto L19;
        this.f205911q = false;
        Bitmap r102 = this.f205905k;
        Shader.TileMode r103 = Shader.TileMode.CLAMP;
        BitmapShader r104 = new BitmapShader(r102, r103, r103);
        r104.setLocalMatrix(this.f205897c);
        this.f205898d.setShader(r104);
    L19:
        r100.drawCircle(this.f205895a.centerX(), this.f205895a.centerY(), this.f205907m, this.f205898d);
    L21:
        if (this.f205902h <= 0) goto L24;
        r100.drawCircle(this.f205896b.centerX(), this.f205896b.centerY(), this.f205908n, this.f205899e);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f205914t == true) goto L5;
        float r100 = r110.getX();
        float r101 = r110.getY();
        if (this.f205896b.isEmpty() == false) goto L10;
    L11:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L15;
        return false;
    L15:
        if (super.onTouchEvent(r110) == false) goto L19;
        return true;
    L19:
        return false;
    L10:
        if ((Math.pow(r100 - this.f205896b.centerX(), 2.0d) + Math.pow(r101 - this.f205896b.centerY(), 2.0d)) <= Math.pow(this.f205908n, 2.0d)) goto L11;
        r102 = false;
        goto L13
    L5:
        return super.onTouchEvent(r110);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean r100) {
        if (r100 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("adjustViewBounds not supported.");
    }

    public void setBorderColor(int r100) {
        if (r100 != this.f205901g) goto L5;
        return;
    L5:
        this.f205901g = r100;
        this.f205899e.setColor(r100);
        invalidate();
    }

    public void setBorderOverlay(boolean r100) {
        if (r100 != this.f205913s) goto L5;
        return;
    L5:
        this.f205913s = r100;
        l();
        invalidate();
    }

    public void setBorderWidth(int r100) {
        if (r100 != this.f205902h) goto L5;
        return;
    L5:
        this.f205902h = r100;
        this.f205899e.setStrokeWidth(r100);
        l();
        invalidate();
    }

    public void setCircleBackgroundColor(int r100) {
        if (r100 != this.f205903i) goto L5;
        return;
    L5:
        this.f205903i = r100;
        this.f205900f.setColor(r100);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int r100) {
        setCircleBackgroundColor(getContext().getResources().getColor(r100));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r100) {
        if (r100 != this.f205909o) goto L5;
        return;
    L5:
        this.f205909o = r100;
        if (this.f205910p == false) goto L9;
        this.f205898d.setColorFilter(r100);
        invalidate();
        return;
    }

    public void setContentPadding(int r100) {
        this.f205915u = r100;
        l();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r100) {
        if (r100 != this.f205914t) goto L5;
        return;
    L5:
        this.f205914t = r100;
        if (r100 == false) goto L8;
        this.f205905k = null;
        this.f205906l = null;
        this.f205898d.setShader(null);
    L9:
        invalidate();
        return;
    L8:
        j();
        goto L9
    }

    @Override // android.widget.ImageView
    public void setImageAlpha(int r100) {
        int r101 = r100 & 255;
        if (r101 != this.f205904j) goto L5;
        return;
    L5:
        this.f205904j = r101;
        if (this.f205910p == false) goto L9;
        this.f205898d.setAlpha(r101);
        invalidate();
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        j();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        j();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
        j();
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        j();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        if (r100 != f205893v) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r100}));
    }

    public DuxCircleImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public DuxCircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f205895a = new RectF();
        this.f205896b = new RectF();
        this.f205897c = new Matrix();
        this.f205898d = new Paint();
        this.f205899e = new Paint();
        this.f205900f = new Paint();
        this.f205901g = -16777216;
        this.f205902h = 0;
        this.f205903i = 0;
        this.f205904j = 255;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.dux_civ_border_color, R.attr.dux_civ_border_overlay, R.attr.dux_civ_border_width, R.attr.dux_civ_circle_background_color}, r102, 0);
        this.f205902h = r103.getDimensionPixelSize(2, 0);
        this.f205901g = r103.getColor(0, -16777216);
        this.f205913s = r103.getBoolean(1, false);
        this.f205903i = r103.getColor(3, 0);
        r103.recycle();
        init();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        l();
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
        l();
        invalidate();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        super.setPaddingRelative(r100, r101, r102, r103);
        l();
        invalidate();
    }
}
