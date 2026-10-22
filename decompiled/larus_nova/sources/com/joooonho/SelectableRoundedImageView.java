package com.joooonho;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes23.dex */
public class SelectableRoundedImageView extends ImageView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ImageView.ScaleType[] f278536i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f278537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView.ScaleType f278538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f278539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f278540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f278541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f278542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f278543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f278544h;

    public static class a extends Drawable {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final /* synthetic */ int f278545r = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f278546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f278547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f278548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f278549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f278550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Paint f278551f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Paint f278552g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final BitmapShader f278553h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float[] f278554i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f278555j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f278556k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f278557l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ColorStateList f278558m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ImageView.ScaleType f278559n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Path f278560o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Bitmap f278561p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f278562q;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            Bitmap r100 = this.f278561p;
            if (r100 != null) goto L5;
        L10:
            return -3;
        L5:
            if (r100.hasAlpha() == true) goto L10;
            if (this.f278551f.getAlpha() < 255) goto L10;
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isStateful() {
            return this.f278558m.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.f278550e;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.f278549d;
        }

        public final void a(Canvas r100) {
            float[] r101 = new float[9];
            r100.getMatrix().getValues(r101);
            float r102 = r101[0];
            float r103 = r101[4];
            float r104 = r101[2];
            float r105 = r101[5];
            float r106 = this.f278546a.width();
            float r107 = this.f278546a.width();
            float r108 = this.f278557l;
            float r109 = r106 / ((r107 + r108) + r108);
            float r110 = this.f278546a.height();
            float r111 = this.f278546a.height();
            float r112 = this.f278557l;
            float r113 = r110 / ((r111 + r112) + r112);
            r100.scale(r109, r113);
            ImageView.ScaleType r114 = ImageView.ScaleType.FIT_START;
            ImageView.ScaleType r115 = this.f278559n;
            if (r114 != r115) goto L5;
        L20:
            float r116 = this.f278557l;
            r100.translate(r116, r116);
            return;
        L5:
            if (ImageView.ScaleType.FIT_END == r115) goto L20;
            if (ImageView.ScaleType.FIT_XY == r115) goto L20;
            if (ImageView.ScaleType.FIT_CENTER == r115) goto L20;
            if (ImageView.ScaleType.CENTER_INSIDE == r115) goto L20;
            if (ImageView.ScaleType.MATRIX == r115) goto L20;
            if (ImageView.ScaleType.CENTER != r115) goto L18;
        L19:
            r100.translate((-r104) / (r109 * r102), (-r105) / (r113 * r103));
            RectF r117 = this.f278546a;
            float r118 = r117.left;
            float r119 = this.f278557l;
            r100.translate(-(r118 - r119), -(r117.top - r119));
            return;
        L18:
            if (ImageView.ScaleType.CENTER_CROP == r115) goto L19;
        }

        public final void b(Matrix r100) {
            float[] r101 = new float[9];
            r100.getValues(r101);
            int r102 = 0;
        L3:
            float[] r103 = this.f278554i;
            if (r102 >= r103.length) goto L6;
            r103[r102] = r103[r102] / r101[0];
            r102 = r102 + 1;
            goto L3
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            r100.save();
            if (this.f278562q == true) goto L37;
            Rect r101 = r100.getClipBounds();
            Matrix r102 = r100.getMatrix();
            ImageView.ScaleType r103 = ImageView.ScaleType.CENTER;
            ImageView.ScaleType r104 = this.f278559n;
            if (r103 != r104) goto L8;
            this.f278546a.set(r101);
        L27:
            if (this.f278557l <= 0.0f) goto L35;
            float[] r105 = new float[9];
            r100.getMatrix().getValues(r105);
            int r106 = 0;
            float r107 = r105[0];
            float r108 = this.f278546a.width() * r107;
            float r109 = (this.f278557l * this.f278546a.width()) / (r108 - (this.f278557l * 2.0f));
            this.f278557l = r109;
            this.f278552g.setStrokeWidth(r109);
            this.f278547b.set(this.f278546a);
            RectF r110 = this.f278547b;
            float r111 = (-this.f278557l) / 2.0f;
            r110.inset(r111, r111);
        L29:
            float[] r112 = this.f278554i;
            if (r106 >= r112.length) goto L35;
            float r113 = r112[r106];
            if (r113 <= 0.0f) goto L34;
            this.f278555j[r106] = r113;
            r112[r106] = r112[r106] - this.f278557l;
        L34:
            r106 = r106 + 1;
        L35:
            this.f278562q = true;
            goto L37
        L8:
            if (ImageView.ScaleType.CENTER_CROP != r104) goto L11;
            b(r102);
            this.f278546a.set(r101);
            goto L27
        L11:
            if (ImageView.ScaleType.FIT_XY != r104) goto L14;
            Matrix r114 = new Matrix();
            r114.setRectToRect(this.f278548c, new RectF(r101), Matrix.ScaleToFit.FILL);
            this.f278553h.setLocalMatrix(r114);
            this.f278546a.set(r101);
            goto L27
        L14:
            if (ImageView.ScaleType.FIT_START != r104) goto L16;
        L25:
            b(r102);
            this.f278546a.set(this.f278548c);
            goto L27
        L16:
            if (ImageView.ScaleType.FIT_END == r104) goto L25;
            if (ImageView.ScaleType.FIT_CENTER == r104) goto L25;
            if (ImageView.ScaleType.CENTER_INSIDE == r104) goto L25;
            if (ImageView.ScaleType.MATRIX != r104) goto L27;
            b(r102);
            this.f278546a.set(this.f278548c);
        L37:
            if (this.f278556k == false) goto L43;
            if (this.f278557l <= 0.0f) goto L41;
            a(r100);
            this.f278560o.addOval(this.f278546a, Path.Direction.CW);
            r100.drawPath(this.f278560o, this.f278551f);
            this.f278560o.reset();
            this.f278560o.addOval(this.f278547b, Path.Direction.CW);
            r100.drawPath(this.f278560o, this.f278552g);
        L46:
            r100.restore();
            return;
        L41:
            this.f278560o.addOval(this.f278546a, Path.Direction.CW);
            r100.drawPath(this.f278560o, this.f278551f);
            goto L46
        L43:
            if (this.f278557l <= 0.0f) goto L45;
            a(r100);
            this.f278560o.addRoundRect(this.f278546a, this.f278554i, Path.Direction.CW);
            r100.drawPath(this.f278560o, this.f278551f);
            this.f278560o.reset();
            this.f278560o.addRoundRect(this.f278547b, this.f278555j, Path.Direction.CW);
            r100.drawPath(this.f278560o, this.f278552g);
            goto L46
        L45:
            this.f278560o.addRoundRect(this.f278546a, this.f278554i, Path.Direction.CW);
            r100.drawPath(this.f278560o, this.f278551f);
            goto L46
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean onStateChange(int[] r100) {
            int r101 = this.f278558m.getColorForState(r100, 0);
            if (this.f278552g.getColor() == r101) goto L7;
            this.f278552g.setColor(r101);
            return true;
        L7:
            return super.onStateChange(r100);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r100) {
            this.f278551f.setAlpha(r100);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r100) {
            this.f278551f.setColorFilter(r100);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setDither(boolean r100) {
            this.f278551f.setDither(r100);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setFilterBitmap(boolean r100) {
            this.f278551f.setFilterBitmap(r100);
            invalidateSelf();
        }

        public a(Bitmap r100, Resources r101) {
            this.f278546a = new RectF();
            this.f278547b = new RectF();
            RectF r102 = new RectF();
            this.f278548c = r102;
            this.f278554i = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f278555j = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.f278556k = false;
            this.f278557l = 0.0f;
            this.f278558m = ColorStateList.valueOf(-16777216);
            this.f278559n = ImageView.ScaleType.FIT_CENTER;
            this.f278560o = new Path();
            this.f278562q = false;
            this.f278561p = r100;
            Shader.TileMode r103 = Shader.TileMode.CLAMP;
            BitmapShader r104 = new BitmapShader(r100, r103, r103);
            this.f278553h = r104;
            if (r100 == null) goto L5;
            this.f278549d = r100.getScaledWidth(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
            this.f278550e = r100.getScaledHeight(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
        L6:
            r102.set(0.0f, 0.0f, this.f278549d, this.f278550e);
            Paint r105 = new Paint(1);
            this.f278551f = r105;
            r105.setStyle(Paint.Style.FILL);
            r105.setShader(r104);
            Paint r106 = new Paint(1);
            this.f278552g = r106;
            r106.setStyle(Paint.Style.STROKE);
            r106.setColor(this.f278558m.getColorForState(getState(), -16777216));
            r106.setStrokeWidth(this.f278557l);
            return;
        L5:
            this.f278550e = -1;
            this.f278549d = -1;
            goto L6
        }

        public static Drawable c(Drawable r100, Resources r101) {
            if (r100 != null) goto L4;
            return r100;
        L4:
            if ((r100 instanceof a) == false) goto L6;
            return r100;
        L6:
            int r102 = 0;
            if ((r100 instanceof LayerDrawable) == false) goto L13;
            LayerDrawable r103 = (LayerDrawable) r100;
            int r104 = r103.getNumberOfLayers();
        L9:
            if (r102 >= r104) goto L11;
            Drawable r105 = r103.getDrawable(r102);
            r103.setDrawableByLayerId(r103.getId(r102), c(r105, r101));
            r102 = r102 + 1;
            goto L9
        L11:
            return r103;
        L13:
            if ((r100 instanceof BitmapDrawable) == false) goto L15;
            Bitmap r106 = ((BitmapDrawable) r100).getBitmap();
        L20:
            if (r106 != null) goto L22;
            return r100;
        L22:
            return new a(r106, r101);
        L15:
            int r107 = Math.max(r100.getIntrinsicWidth(), 2);
            int r108 = Math.max(r100.getIntrinsicHeight(), 2);
            r106 = Bitmap.createBitmap(r107, r108, Bitmap.Config.ARGB_8888);     // Catch: IllegalArgumentException -> L18
            Canvas r109 = new Canvas(r106);     // Catch: IllegalArgumentException -> L18
            r100.setBounds(0, 0, r109.getWidth(), r109.getHeight());     // Catch: IllegalArgumentException -> L18
            r100.draw(r109);     // Catch: IllegalArgumentException -> L18
        L18:
            e = move-exception;
            e.printStackTrace();
            r106 = null;
            goto L20
        }
    }

    static {
        f278536i = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public final void a() {
        Drawable r100 = this.f278543g;
        if (r100 != null) goto L5;
        return;
    L5:
        a r101 = (a) r100;
        ImageView.ScaleType r102 = this.f278538b;
        if (r102 != null) goto L8;
        r101.getClass();
    L9:
        a r103 = (a) this.f278543g;
        float[] r104 = this.f278544h;
        r103.getClass();
        if (r104 != null) goto L13;
    L18:
        a r105 = (a) this.f278543g;
        float r106 = this.f278540d;
        r105.f278557l = r106;
        r105.f278552g.setStrokeWidth(r106);
        a r107 = (a) this.f278543g;
        ColorStateList r108 = this.f278541e;
        if (r108 != null) goto L21;
        r107.f278557l = 0.0f;
        r107.f278558m = ColorStateList.valueOf(0);
        r107.f278552g.setColor(0);
    L22:
        a r109 = (a) this.f278543g;
        r109.f278556k = this.f278542f;
        return;
    L21:
        r107.f278558m = r108;
        r107.f278552g.setColor(r108.getColorForState(r107.getState(), -16777216));
        goto L22
    L13:
        if (r104.length != 8) goto L25;
        int r110 = 0;
    L16:
        if (r110 >= r104.length) goto L18;
        r103.f278554i[r110] = r104[r110];
        r110 = r110 + 1;
        goto L16
    L25:
        throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
    L8:
        r101.f278559n = r102;
        goto L9
    }

    public int getBorderColor() {
        return this.f278541e.getDefaultColor();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public ColorStateList getBorderColors() {
        return this.f278541e;
    }

    public float getBorderWidth() {
        return this.f278540d;
    }

    public float getCornerRadius() {
        return this.f278539c;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f278538b;
    }

    public SelectableRoundedImageView(Context r100) {
        super(r100);
        this.f278537a = 0;
        this.f278538b = ImageView.ScaleType.FIT_CENTER;
        this.f278539c = 0.0f;
        this.f278540d = 0.0f;
        this.f278541e = ColorStateList.valueOf(-16777216);
        this.f278542f = false;
        this.f278544h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void setBorderColor(ColorStateList r100) {
        if (this.f278541e.equals(r100) == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        r100 = ColorStateList.valueOf(-16777216);
    L8:
        this.f278541e = r100;
        a();
        if (this.f278540d <= 0.0f) goto L12;
        invalidate();
        return;
    }

    public void setBorderWidthDP(float r100) {
        Resources r101 = getResources();
        float r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100;
        if (this.f278540d != r102) goto L5;
        return;
    L5:
        this.f278540d = r102;
        a();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        this.f278537a = 0;
        Resources r101 = getResources();
        if (r100 == null) goto L5;
        a r102 = new a(r100, r101);
    L6:
        this.f278543g = r102;
        super.setImageDrawable(r102);
        a();
        return;
    L5:
        int r103 = a.f278545r;
        r102 = null;
        goto L6
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        this.f278537a = 0;
        Drawable r101 = a.c(r100, getResources());
        this.f278543g = r101;
        super.setImageDrawable(r101);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        if (this.f278537a == r100) goto L17;
        this.f278537a = r100;
        Resources r101 = getResources();
        Drawable r102 = null;
        if (r101 == null) goto L13;
        int r103 = this.f278537a;
        if (r103 != 0) goto L15;
    L12:
        r102 = a.c(r102, getResources());
        goto L13
    L15:
        r102 = r101.getDrawable(r103);     // Catch: Resources.NotFoundException -> L11
    L11:
        this.f278537a = 0;
    L13:
        this.f278543g = r102;
        super.setImageDrawable(r102);
        a();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r100) {
        super.setImageURI(r100);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean r100) {
        this.f278542f = r100;
        a();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r100) {
        super.setScaleType(r100);
        this.f278538b = r100;
        a();
    }

    public void setBorderColor(int r100) {
        setBorderColor(ColorStateList.valueOf(r100));
    }

    public SelectableRoundedImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SelectableRoundedImageView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f278537a = 0;
        this.f278538b = ImageView.ScaleType.FIT_CENTER;
        this.f278539c = 0.0f;
        this.f278540d = 0.0f;
        this.f278541e = ColorStateList.valueOf(-16777216);
        this.f278542f = false;
        this.f278544h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.scaleType, com.larus.nova.R.attr.sriv_border_color, com.larus.nova.R.attr.sriv_border_width, com.larus.nova.R.attr.sriv_left_bottom_corner_radius, com.larus.nova.R.attr.sriv_left_top_corner_radius, com.larus.nova.R.attr.sriv_oval, com.larus.nova.R.attr.sriv_right_bottom_corner_radius, com.larus.nova.R.attr.sriv_right_top_corner_radius}, r112, 0);
        int r114 = r113.getInt(0, -1);
        if (r114 < 0) goto L5;
        setScaleType(f278536i[r114]);
    L5:
        float r115 = r113.getDimensionPixelSize(4, 0);
        this.f278539c = r115;
        float r100 = r113.getDimensionPixelSize(7, 0);
        float r101 = r113.getDimensionPixelSize(3, 0);
        float r102 = r113.getDimensionPixelSize(6, 0);
        if (r115 < 0.0f) goto L23;
        if (r100 < 0.0f) goto L23;
        if (r101 < 0.0f) goto L23;
        if (r102 < 0.0f) goto L23;
        this.f278544h = new float[]{r115, r115, r100, r100, r102, r102, r101, r101};
        float r116 = r113.getDimensionPixelSize(2, 0);
        this.f278540d = r116;
        if (r116 < 0.0f) goto L21;
        ColorStateList r117 = r113.getColorStateList(1);
        this.f278541e = r117;
        if (r117 != null) goto L18;
        this.f278541e = ColorStateList.valueOf(-16777216);
    L18:
        this.f278542f = r113.getBoolean(5, false);
        r113.recycle();
        a();
        return;
    L21:
        throw new IllegalArgumentException("border width cannot be negative.");
    L23:
        throw new IllegalArgumentException("radius values cannot be negative.");
    }
}
