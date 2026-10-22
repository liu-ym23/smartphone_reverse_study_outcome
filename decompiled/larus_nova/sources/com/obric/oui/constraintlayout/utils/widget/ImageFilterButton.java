package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageFilterView.c f400267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f400268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f400269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f400270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f400271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewOutlineProvider f400272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f400273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable[] f400274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LayerDrawable f400275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f400276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f400277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f400278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f400281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400282p;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterButton f400283a;

        public a(ImageFilterButton r100) {
            this.f400283a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            int r102 = this.f400283a.getWidth();
            int r103 = this.f400283a.getHeight();
            r101.setRoundRect(0, 0, r102, r103, (Math.min(r102, r103) * this.f400283a.f400269c) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterButton f400284a;

        public b(ImageFilterButton r100) {
            this.f400284a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, this.f400284a.getWidth(), this.f400284a.getHeight(), this.f400284a.f400270d);
        }
    }

    public final void a() {
        if (Float.isNaN(this.f400279m) == true) goto L5;
    L11:
        float r100 = 0.0f;
        if (Float.isNaN(this.f400279m) == false) goto L14;
        float r101 = 0.0f;
    L16:
        if (Float.isNaN(this.f400280n) == false) goto L18;
        float r102 = 0.0f;
    L20:
        if (Float.isNaN(this.f400281o) == false) goto L22;
        float r103 = 1.0f;
    L24:
        if (Float.isNaN(this.f400282p) == true) goto L27;
        r100 = this.f400282p;
    L27:
        Matrix r104 = new Matrix();
        r104.reset();
        float r105 = getDrawable().getIntrinsicWidth();
        float r106 = getDrawable().getIntrinsicHeight();
        float r107 = getWidth();
        float r108 = getHeight();
        if ((r105 * r108) >= (r106 * r107)) goto L30;
        float r109 = r107 / r105;
    L31:
        float r110 = r103 * r109;
        r104.postScale(r110, r110);
        float r111 = r105 * r110;
        float r112 = r110 * r106;
        r104.postTranslate((((r101 * (r107 - r111)) + r107) - r111) * 0.5f, (((r102 * (r108 - r112)) + r108) - r112) * 0.5f);
        r104.postRotate(r100, r107 / 2.0f, r108 / 2.0f);
        setImageMatrix(r104);
        setScaleType(ImageView.ScaleType.MATRIX);
        return;
    L30:
        r109 = r108 / r106;
        goto L31
    L22:
        r103 = this.f400281o;
        goto L24
    L18:
        r102 = this.f400280n;
        goto L20
    L14:
        r101 = this.f400279m;
        goto L16
    L5:
        if (Float.isNaN(this.f400280n) == false) goto L11;
        if (Float.isNaN(this.f400281o) == false) goto L11;
        if (Float.isNaN(this.f400282p) == false) goto L11;
    }

    public final void b() {
        if (Float.isNaN(this.f400279m) == true) goto L5;
    L12:
        a();
        return;
    L5:
        if (Float.isNaN(this.f400280n) == false) goto L12;
        if (Float.isNaN(this.f400281o) == false) goto L12;
        if (Float.isNaN(this.f400282p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public float getContrast() {
        return this.f400267a.f400308f;
    }

    public float getSaturation() {
        return this.f400267a.f400307e;
    }

    public float getWarmth() {
        return this.f400267a.f400309g;
    }

    public float getCrossfade() {
        return this.f400268b;
    }

    public float getImagePanX() {
        return this.f400279m;
    }

    public float getImagePanY() {
        return this.f400280n;
    }

    public float getImageRotate() {
        return this.f400282p;
    }

    public float getImageZoom() {
        return this.f400281o;
    }

    public float getRound() {
        return this.f400270d;
    }

    public float getRoundPercent() {
        return this.f400269c;
    }

    public ImageFilterButton(Context r100) {
        super(r100);
        this.f400267a = new ImageFilterView.c();
        this.f400268b = 0.0f;
        this.f400269c = 0.0f;
        this.f400270d = Float.NaN;
        this.f400274h = new Drawable[2];
        this.f400276j = true;
        this.f400277k = null;
        this.f400278l = null;
        this.f400279m = Float.NaN;
        this.f400280n = Float.NaN;
        this.f400281o = Float.NaN;
        this.f400282p = Float.NaN;
        init(r100, null);
    }

    private void setOverlay(boolean r100) {
        this.f400276j = r100;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    public void setAltImageResource(int r100) {
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100).mutate();
        this.f400277k = r101;
        Drawable[] r102 = this.f400274h;
        r102[0] = this.f400278l;
        r102[1] = r101;
        LayerDrawable r103 = new LayerDrawable(this.f400274h);
        this.f400275i = r103;
        super.setImageDrawable(r103);
        setCrossfade(this.f400268b);
    }

    public void setBrightness(float r100) {
        ImageFilterView.c r101 = this.f400267a;
        r101.f400306d = r100;
        r101.a(this);
    }

    public void setContrast(float r100) {
        ImageFilterView.c r101 = this.f400267a;
        r101.f400308f = r100;
        r101.a(this);
    }

    public void setCrossfade(float r100) {
        this.f400268b = r100;
        if (this.f400274h != null) goto L5;
        return;
    L5:
        if (this.f400276j == true) goto L7;
        this.f400275i.getDrawable(0).setAlpha((int) ((1.0f - this.f400268b) * 255.0f));
    L7:
        this.f400275i.getDrawable(1).setAlpha((int) (this.f400268b * 255.0f));
        super.setImageDrawable(this.f400275i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        if (this.f400277k == null) goto L6;
        if (r100 == null) goto L6;
        Drawable r101 = r100.mutate();
        this.f400278l = r101;
        Drawable[] r102 = this.f400274h;
        r102[0] = r101;
        r102[1] = this.f400277k;
        LayerDrawable r103 = new LayerDrawable(this.f400274h);
        this.f400275i = r103;
        super.setImageDrawable(r103);
        setCrossfade(this.f400268b);
        return;
    L6:
        super.setImageDrawable(r100);
    }

    public void setImagePanX(float r100) {
        this.f400279m = r100;
        b();
    }

    public void setImagePanY(float r100) {
        this.f400280n = r100;
        b();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int r100) {
        if (this.f400277k == null) goto L5;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100).mutate();
        this.f400278l = r101;
        Drawable[] r102 = this.f400274h;
        r102[0] = r101;
        r102[1] = this.f400277k;
        LayerDrawable r103 = new LayerDrawable(this.f400274h);
        this.f400275i = r103;
        super.setImageDrawable(r103);
        setCrossfade(this.f400268b);
        return;
    L5:
        super.setImageResource(r100);
    }

    public void setImageRotate(float r100) {
        this.f400282p = r100;
        b();
    }

    public void setImageZoom(float r100) {
        this.f400281o = r100;
        b();
    }

    public void setRound(float r100) {
        if (Float.isNaN(r100) == false) goto L7;
        this.f400270d = r100;
        float r101 = this.f400269c;
        this.f400269c = -1.0f;
        setRoundPercent(r101);
        return;
    L7:
        if (this.f400270d == r100) goto L9;
        boolean r102 = true;
    L10:
        this.f400270d = r100;
        if (r100 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r102 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f400271e != null) goto L16;
        this.f400271e = new Path();
    L16:
        if (this.f400273g != null) goto L19;
        this.f400273g = new RectF();
    L19:
        if (this.f400272f != null) goto L21;
        b r103 = new b(this);
        this.f400272f = r103;
        setOutlineProvider(r103);
    L21:
        setClipToOutline(true);
        this.f400273g.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f400271e.reset();
        Path r104 = this.f400271e;
        RectF r105 = this.f400273g;
        float r106 = this.f400270d;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        goto L23
    L9:
        r102 = false;
        goto L10
    }

    public void setRoundPercent(float r100) {
        if (this.f400269c == r100) goto L5;
        boolean r101 = true;
    L6:
        this.f400269c = r100;
        if (r100 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r101 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f400271e != null) goto L12;
        this.f400271e = new Path();
    L12:
        if (this.f400273g != null) goto L15;
        this.f400273g = new RectF();
    L15:
        if (this.f400272f != null) goto L17;
        a r102 = new a(this);
        this.f400272f = r102;
        setOutlineProvider(r102);
    L17:
        setClipToOutline(true);
        int r103 = getWidth();
        int r104 = getHeight();
        float r105 = (Math.min(r103, r104) * this.f400269c) / 2.0f;
        this.f400273g.set(0.0f, 0.0f, r103, r104);
        this.f400271e.reset();
        this.f400271e.addRoundRect(this.f400273g, r105, r105, Path.Direction.CW);
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public void setSaturation(float r100) {
        ImageFilterView.c r101 = this.f400267a;
        r101.f400307e = r100;
        r101.a(this);
    }

    public void setWarmth(float r100) {
        ImageFilterView.c r101 = this.f400267a;
        r101.f400309g = r100;
        r101.a(this);
    }

    public ImageFilterButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400267a = new ImageFilterView.c();
        this.f400268b = 0.0f;
        this.f400269c = 0.0f;
        this.f400270d = Float.NaN;
        this.f400274h = new Drawable[2];
        this.f400276j = true;
        this.f400277k = null;
        this.f400278l = null;
        this.f400279m = Float.NaN;
        this.f400280n = Float.NaN;
        this.f400281o = Float.NaN;
        this.f400282p = Float.NaN;
        init(r100, r101);
    }

    public final void init(Context r100, AttributeSet r101) {
        setPadding(0, 0, 0, 0);
        if (r101 == null) goto L64;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.altSrc, R.attr.blendSrc, R.attr.brightness, R.attr.contrast, R.attr.crossfade, R.attr.imagePanX, R.attr.imagePanY, R.attr.imageRotate, R.attr.imageZoom, R.attr.overlay, R.attr.round, R.attr.roundPercent, R.attr.saturation, R.attr.warmth});
        int r103 = r102.getIndexCount();
        this.f400277k = r102.getDrawable(0);
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L40;
        int r105 = r102.getIndex(r104);
        if (r105 != 4) goto L10;
        this.f400268b = r102.getFloat(r105, 0.0f);
    L39:
        r104 = r104 + 1;
        goto L5
    L10:
        if (r105 != 13) goto L13;
        setWarmth(r102.getFloat(r105, 0.0f));
        goto L39
    L13:
        if (r105 != 12) goto L16;
        setSaturation(r102.getFloat(r105, 0.0f));
        goto L39
    L16:
        if (r105 != 3) goto L19;
        setContrast(r102.getFloat(r105, 0.0f));
        goto L39
    L19:
        if (r105 != 10) goto L22;
        setRound(r102.getDimension(r105, 0.0f));
        goto L39
    L22:
        if (r105 != 11) goto L25;
        setRoundPercent(r102.getFloat(r105, 0.0f));
        goto L39
    L25:
        if (r105 != 9) goto L28;
        setOverlay(r102.getBoolean(r105, this.f400276j));
        goto L39
    L28:
        if (r105 != 5) goto L31;
        setImagePanX(r102.getFloat(r105, this.f400279m));
        goto L39
    L31:
        if (r105 != 6) goto L34;
        setImagePanY(r102.getFloat(r105, this.f400280n));
        goto L39
    L34:
        if (r105 != 7) goto L37;
        setImageRotate(r102.getFloat(r105, this.f400282p));
        goto L39
    L37:
        if (r105 != 8) goto L39;
        setImageZoom(r102.getFloat(r105, this.f400281o));
        goto L39
    L40:
        r102.recycle();
        Drawable r106 = getDrawable();
        this.f400278l = r106;
        if (this.f400277k == null) goto L47;
        if (r106 == null) goto L47;
        Drawable[] r107 = this.f400274h;
        Drawable r108 = getDrawable().mutate();
        this.f400278l = r108;
        r107[0] = r108;
        this.f400274h[1] = this.f400277k.mutate();
        LayerDrawable r109 = new LayerDrawable(this.f400274h);
        this.f400275i = r109;
        r109.getDrawable(1).setAlpha((int) (this.f400268b * 255.0f));
        if (this.f400276j == true) goto L46;
        this.f400275i.getDrawable(0).setAlpha((int) ((1.0f - this.f400268b) * 255.0f));
    L46:
        super.setImageDrawable(this.f400275i);
        return;
    L47:
        Drawable r110 = getDrawable();
        this.f400278l = r110;
        if (r110 == null) goto L66;
        Drawable[] r111 = this.f400274h;
        Drawable r112 = r110.mutate();
        this.f400278l = r112;
        r111[0] = r112;
        return;
    L66:
        return;
    }

    public ImageFilterButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400267a = new ImageFilterView.c();
        this.f400268b = 0.0f;
        this.f400269c = 0.0f;
        this.f400270d = Float.NaN;
        this.f400274h = new Drawable[2];
        this.f400276j = true;
        this.f400277k = null;
        this.f400278l = null;
        this.f400279m = Float.NaN;
        this.f400280n = Float.NaN;
        this.f400281o = Float.NaN;
        this.f400282p = Float.NaN;
        init(r100, r101);
    }

    @Override // android.view.View
    public final void layout(int r100, int r101, int r102, int r103) {
        super.layout(r100, r101, r102, r103);
        a();
    }
}
