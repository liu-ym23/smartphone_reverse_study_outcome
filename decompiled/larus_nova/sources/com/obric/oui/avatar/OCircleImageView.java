package com.obric.oui.avatar;

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

/* JADX INFO: loaded from: classes6.dex */
public class OCircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ImageView.ScaleType f398766v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Bitmap.Config f398767w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f398768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f398769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f398770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f398771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f398772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f398773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f398774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f398775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f398776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f398777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f398778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f398779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f398780m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f398781n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorFilter f398782o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f398783p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f398784q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f398785r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f398786s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f398787t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f398788u;

    /* JADX INFO: loaded from: classes21.dex */
    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCircleImageView f398789a;

        public a(OCircleImageView r100) {
            this.f398789a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (this.f398789a.f398787t == false) goto L5;
            ViewOutlineProvider.BACKGROUND.getOutline(r100, r101);
            return;
        L5:
            Rect r102 = new Rect();
            this.f398789a.f398769b.roundOut(r102);
            r101.setRoundRect(r102, r102.width() / 2.0f);
        }
    }

    public final void init() {
        this.f398783p = true;
        super.setScaleType(f398766v);
        this.f398771d.setAntiAlias(true);
        this.f398771d.setDither(true);
        this.f398771d.setFilterBitmap(true);
        this.f398771d.setAlpha(this.f398777j);
        this.f398771d.setColorFilter(this.f398782o);
        this.f398772e.setStyle(Paint.Style.STROKE);
        this.f398772e.setAntiAlias(true);
        this.f398772e.setColor(this.f398774g);
        this.f398772e.setStrokeWidth(this.f398775h);
        this.f398773f.setStyle(Paint.Style.FILL);
        this.f398773f.setAntiAlias(true);
        this.f398773f.setColor(this.f398776i);
        setOutlineProvider(new a(this));
    }

    static {
        f398766v = ImageView.ScaleType.CENTER_CROP;
        f398767w = Bitmap.Config.ARGB_8888;
    }

    public final void l() {
        RectF r100 = this.f398769b;
        int r101 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r102 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r103 = Math.min(r101, r102);
        float r104 = getPaddingLeft() + ((r101 - r103) / 2.0f);
        float r105 = getPaddingTop() + ((r102 - r103) / 2.0f);
        float r106 = r103;
        r100.set(new RectF(r104, r105, r104 + r106, r106 + r105));
        this.f398781n = Math.min((this.f398769b.height() - this.f398775h) / 2.0f, (this.f398769b.width() - this.f398775h) / 2.0f);
        RectF r107 = this.f398768a;
        int r108 = getWidth() - (this.f398788u * 2);
        int r109 = getHeight() - (this.f398788u * 2);
        int r110 = Math.min(r109, r108);
        float r111 = this.f398788u;
        float r112 = ((r108 - r110) / 2.0f) + r111;
        float r113 = r111 + ((r109 - r110) / 2.0f);
        float r114 = r110;
        r107.set(new RectF(r112, r113, r112 + r114, r114 + r113));
        if (this.f398786s == true) goto L7;
        int r115 = this.f398775h;
        if (r115 <= 0) goto L7;
        this.f398768a.inset(r115 - 1.0f, r115 - 1.0f);
    L7:
        this.f398780m = Math.min(this.f398768a.height() / 2.0f, this.f398768a.width() / 2.0f);
        m();
    }

    public final void m() {
        if (this.f398778k != null) goto L5;
        return;
    L5:
        this.f398770c.set(null);
        int r100 = this.f398778k.getHeight();
        float r101 = this.f398778k.getWidth();
        float r102 = r100;
        float r103 = 0.0f;
        if ((this.f398768a.height() * r101) <= (this.f398768a.width() * r102)) goto L8;
        float r104 = this.f398768a.height() / r102;
        r103 = (this.f398768a.width() - (r101 * r104)) * 0.5f;
        float r105 = 0.0f;
    L9:
        this.f398770c.setScale(r104, r104);
        Matrix r106 = this.f398770c;
        RectF r107 = this.f398768a;
        r106.postTranslate(((int) (r103 + 0.5f)) + r107.left, ((int) (r105 + 0.5f)) + r107.top);
        this.f398784q = true;
        return;
    L8:
        r104 = this.f398768a.width() / r101;
        r105 = (this.f398768a.height() - (r102 * r104)) * 0.5f;
        goto L9
    }

    public final void j() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L6;
    L4:
        Bitmap r101 = null;
    L16:
        this.f398778k = r101;
        if (r101 != null) goto L19;
    L21:
        this.f398779l = null;
    L23:
        if (this.f398783p == true) goto L26;
        return;
    L26:
        if (this.f398778k == null) goto L28;
        m();
        return;
    L28:
        this.f398771d.setShader(null);
        return;
    L19:
        if (r101.isMutable() == false) goto L21;
        this.f398779l = new Canvas(this.f398778k);
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
        Bitmap r102 = Bitmap.createBitmap(2, 2, f398767w);     // Catch: Exception -> L14
    L12:
        Canvas r103 = new Canvas(r102);     // Catch: Exception -> L14
        r100.setBounds(0, 0, r103.getWidth(), r103.getHeight());     // Catch: Exception -> L14
        r100.draw(r103);     // Catch: Exception -> L14
        r101 = r102;
        goto L16
    L11:
        r102 = Bitmap.createBitmap(r100.getIntrinsicWidth(), r100.getIntrinsicHeight(), f398767w);     // Catch: Exception -> L14
        goto L12
    }

    public int getBorderColor() {
        return this.f398774g;
    }

    public int getBorderWidth() {
        return this.f398775h;
    }

    public int getCircleBackgroundColor() {
        return this.f398776i;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.f398782o;
    }

    @Override // android.widget.ImageView
    public int getImageAlpha() {
        return this.f398777j;
    }

    public OCircleImageView(Context r100) {
        super(r100);
        this.f398768a = new RectF();
        this.f398769b = new RectF();
        this.f398770c = new Matrix();
        this.f398771d = new Paint();
        this.f398772e = new Paint();
        this.f398773f = new Paint();
        this.f398774g = -16777216;
        this.f398775h = 0;
        this.f398776i = 0;
        this.f398777j = 255;
        init();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        this.f398785r = true;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f398787t == false) goto L7;
        super.onDraw(r100);
        return;
    L7:
        if (this.f398776i == 0) goto L10;
        r100.drawCircle(this.f398769b.centerX(), this.f398769b.centerY(), this.f398781n, this.f398773f);
    L10:
        if (this.f398778k == null) goto L21;
        if (this.f398785r == false) goto L17;
        if (this.f398779l == null) goto L17;
        this.f398785r = false;
        Drawable r101 = getDrawable();
        r101.setBounds(0, 0, this.f398779l.getWidth(), this.f398779l.getHeight());
        r101.draw(this.f398779l);
    L17:
        if (this.f398784q == false) goto L19;
        this.f398784q = false;
        Bitmap r102 = this.f398778k;
        Shader.TileMode r103 = Shader.TileMode.CLAMP;
        BitmapShader r104 = new BitmapShader(r102, r103, r103);
        r104.setLocalMatrix(this.f398770c);
        this.f398771d.setShader(r104);
    L19:
        r100.drawCircle(this.f398768a.centerX(), this.f398768a.centerY(), this.f398780m, this.f398771d);
    L21:
        if (this.f398775h <= 0) goto L24;
        r100.drawCircle(this.f398769b.centerX(), this.f398769b.centerY(), this.f398781n, this.f398772e);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (this.f398787t == true) goto L5;
        float r100 = r110.getX();
        float r101 = r110.getY();
        if (this.f398769b.isEmpty() == false) goto L10;
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
        if ((Math.pow(r100 - this.f398769b.centerX(), 2.0d) + Math.pow(r101 - this.f398769b.centerY(), 2.0d)) <= Math.pow(this.f398781n, 2.0d)) goto L11;
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
        if (r100 != this.f398774g) goto L5;
        return;
    L5:
        this.f398774g = r100;
        this.f398772e.setColor(r100);
        invalidate();
    }

    public void setBorderOverlay(boolean r100) {
        if (r100 != this.f398786s) goto L5;
        return;
    L5:
        this.f398786s = r100;
        l();
        invalidate();
    }

    public void setBorderWidth(int r100) {
        if (r100 != this.f398775h) goto L5;
        return;
    L5:
        this.f398775h = r100;
        this.f398772e.setStrokeWidth(r100);
        l();
        invalidate();
    }

    public void setCircleBackgroundColor(int r100) {
        if (r100 != this.f398776i) goto L5;
        return;
    L5:
        this.f398776i = r100;
        this.f398773f.setColor(r100);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int r100) {
        setCircleBackgroundColor(getContext().getResources().getColor(r100));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter r100) {
        if (r100 != this.f398782o) goto L5;
        return;
    L5:
        this.f398782o = r100;
        if (this.f398783p == false) goto L9;
        this.f398771d.setColorFilter(r100);
        invalidate();
        return;
    }

    public void setContentPadding(int r100) {
        this.f398788u = r100;
        l();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean r100) {
        if (r100 != this.f398787t) goto L5;
        return;
    L5:
        this.f398787t = r100;
        if (r100 == false) goto L8;
        this.f398778k = null;
        this.f398779l = null;
        this.f398771d.setShader(null);
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
        if (r101 != this.f398777j) goto L5;
        return;
    L5:
        this.f398777j = r101;
        if (this.f398783p == false) goto L9;
        this.f398771d.setAlpha(r101);
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
        if (r100 != f398766v) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{r100}));
    }

    public OCircleImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public OCircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f398768a = new RectF();
        this.f398769b = new RectF();
        this.f398770c = new Matrix();
        this.f398771d = new Paint();
        this.f398772e = new Paint();
        this.f398773f = new Paint();
        this.f398774g = -16777216;
        this.f398775h = 0;
        this.f398776i = 0;
        this.f398777j = 255;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.o_civ_border_color, R.attr.o_civ_border_overlay, R.attr.o_civ_border_width, R.attr.o_civ_circle_background_color}, r102, 0);
        this.f398775h = r103.getDimensionPixelSize(2, 0);
        this.f398774g = r103.getColor(0, -16777216);
        this.f398786s = r103.getBoolean(1, false);
        this.f398776i = r103.getColor(3, 0);
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
