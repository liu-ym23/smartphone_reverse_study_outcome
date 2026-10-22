package com.obric.oui.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f400285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f400286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f400287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f400288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f400289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f400290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f400292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f400293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f400294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable[] f400295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayerDrawable f400296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f400297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f400298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f400299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f400300p;

    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterView f400301a;

        public a(ImageFilterView r100) {
            this.f400301a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            int r102 = this.f400301a.getWidth();
            int r103 = this.f400301a.getHeight();
            r101.setRoundRect(0, 0, r102, r103, (Math.min(r102, r103) * this.f400301a.f400290f) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageFilterView f400302a;

        public b(ImageFilterView r100) {
            this.f400302a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            r101.setRoundRect(0, 0, this.f400302a.getWidth(), this.f400302a.getHeight(), this.f400302a.f400291g);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f400303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ColorMatrix f400304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ColorMatrix f400305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f400306d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f400307e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f400308f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f400309g;

        public c() {
            this.f400303a = new float[20];
            this.f400304b = new ColorMatrix();
            this.f400305c = new ColorMatrix();
            this.f400306d = 1.0f;
            this.f400307e = 1.0f;
            this.f400308f = 1.0f;
            this.f400309g = 1.0f;
        }

        public final void a(ImageView r210) {
            this.f400304b.reset();
            float r100 = this.f400307e;
            boolean r211 = true;
            if (r100 == 1.0f) goto L5;
            float r212 = 1.0f - r100;
            float r213 = 0.2999f * r212;
            float r214 = 0.587f * r212;
            float r215 = r212 * 0.114f;
            float[] r101 = this.f400303a;
            r101[0] = r213 + r100;
            r101[1] = r214;
            r101[2] = r215;
            r101[3] = 0.0f;
            r101[4] = 0.0f;
            r101[5] = r213;
            r101[6] = r214 + r100;
            r101[7] = r215;
            r101[8] = 0.0f;
            r101[9] = 0.0f;
            r101[10] = r213;
            r101[11] = r214;
            r101[12] = r215 + r100;
            r101[13] = 0.0f;
            r101[14] = 0.0f;
            r101[15] = 0.0f;
            r101[16] = 0.0f;
            r101[17] = 0.0f;
            float r102 = 1.0f;
            r101[18] = 1.0f;
            r101[19] = 0.0f;
            this.f400304b.set(r101);
            boolean r103 = true;
        L6:
            float r104 = this.f400308f;
            if (r104 == r102) goto L9;
            this.f400305c.setScale(r104, r104, r104, r102);
            this.f400304b.postConcat(this.f400305c);
            r103 = true;
        L9:
            float r105 = this.f400309g;
            if (r105 != r102) goto L12;
        L26:
            float r106 = this.f400306d;
            if (r106 == 1.0f) goto L29;
            float[] r107 = this.f400303a;
            r107[0] = r106;
            r107[1] = 0.0f;
            r107[2] = 0.0f;
            r107[3] = 0.0f;
            r107[4] = 0.0f;
            r107[5] = 0.0f;
            r107[6] = r106;
            r107[7] = 0.0f;
            r107[8] = 0.0f;
            r107[9] = 0.0f;
            r107[10] = 0.0f;
            r107[11] = 0.0f;
            r107[12] = r106;
            r107[13] = 0.0f;
            r107[14] = 0.0f;
            r107[15] = 0.0f;
            r107[16] = 0.0f;
            r107[17] = 0.0f;
            r107[18] = 1.0f;
            r107[19] = 0.0f;
            this.f400305c.set(r107);
            this.f400304b.postConcat(this.f400305c);
        L30:
            if (r211 == false) goto L32;
            r210.setColorFilter(new ColorMatrixColorFilter(this.f400304b));
            return;
        L32:
            r210.clearColorFilter();
            return;
        L29:
            r211 = r103;
            goto L30
        L12:
            if (r105 > 0.0f) goto L14;
            r105 = 0.01f;
        L14:
            float r108 = (5000.0f / r105) / 100.0f;
            if (r108 <= 66.0f) goto L17;
            double r109 = r108 - 60.0f;
            float r110 = ((float) Math.pow(r109, -0.13320475816726685d)) * 329.69873f;
            float r111 = ((float) Math.pow(r109, 0.07551485300064087d)) * 288.12216f;
        L19:
            if (r108 < 66.0f) goto L21;
            float r112 = 255.0f;
        L25:
            float r113 = Math.min(255.0f, Math.max(r110, 0.0f));
            float r114 = Math.min(255.0f, Math.max(r111, 0.0f));
            float r115 = Math.min(255.0f, Math.max(r112, 0.0f));
            float r116 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float r117 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float r118 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float r119 = Math.min(255.0f, Math.max(r116, 0.0f));
            float r120 = r115 / Math.min(255.0f, Math.max(r117, 0.0f));
            float[] r121 = this.f400303a;
            r121[0] = r113 / r118;
            r121[1] = 0.0f;
            r121[2] = 0.0f;
            r121[3] = 0.0f;
            r121[4] = 0.0f;
            r121[5] = 0.0f;
            r121[6] = r114 / r119;
            r121[7] = 0.0f;
            r121[8] = 0.0f;
            r121[9] = 0.0f;
            r121[10] = 0.0f;
            r121[11] = 0.0f;
            r121[12] = r120;
            r121[13] = 0.0f;
            r121[14] = 0.0f;
            r121[15] = 0.0f;
            r121[16] = 0.0f;
            r121[17] = 0.0f;
            r121[18] = 1.0f;
            r121[19] = 0.0f;
            this.f400305c.set(r121);
            this.f400304b.postConcat(this.f400305c);
            r103 = true;
            goto L26
        L21:
            if (r108 <= 19.0f) goto L23;
            r112 = (((float) Math.log(r108 - 10.0f)) * 138.51773f) - 305.0448f;
            goto L25
        L23:
            r112 = 0.0f;
            goto L25
        L17:
            r111 = (((float) Math.log(r108)) * 99.4708f) - 161.11957f;
            r110 = 255.0f;
            goto L19
        L5:
            r102 = 1.0f;
            r103 = false;
            goto L6
        }
    }

    public float getBrightness() {
        return this.f400285a.f400306d;
    }

    public float getContrast() {
        return this.f400285a.f400308f;
    }

    public float getSaturation() {
        return this.f400285a.f400307e;
    }

    public float getWarmth() {
        return this.f400285a.f400309g;
    }

    public final void j() {
        if (Float.isNaN(this.f400297m) == true) goto L5;
    L11:
        float r100 = 0.0f;
        if (Float.isNaN(this.f400297m) == false) goto L14;
        float r101 = 0.0f;
    L16:
        if (Float.isNaN(this.f400298n) == false) goto L18;
        float r102 = 0.0f;
    L20:
        if (Float.isNaN(this.f400299o) == false) goto L22;
        float r103 = 1.0f;
    L24:
        if (Float.isNaN(this.f400300p) == true) goto L27;
        r100 = this.f400300p;
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
        r103 = this.f400299o;
        goto L24
    L18:
        r102 = this.f400298n;
        goto L20
    L14:
        r101 = this.f400297m;
        goto L16
    L5:
        if (Float.isNaN(this.f400298n) == false) goto L11;
        if (Float.isNaN(this.f400299o) == false) goto L11;
        if (Float.isNaN(this.f400300p) == false) goto L11;
    }

    public final void l() {
        if (Float.isNaN(this.f400297m) == true) goto L5;
    L12:
        j();
        return;
    L5:
        if (Float.isNaN(this.f400298n) == false) goto L12;
        if (Float.isNaN(this.f400299o) == false) goto L12;
        if (Float.isNaN(this.f400300p) == false) goto L12;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public float getCrossfade() {
        return this.f400289e;
    }

    public float getImagePanX() {
        return this.f400297m;
    }

    public float getImagePanY() {
        return this.f400298n;
    }

    public float getImageRotate() {
        return this.f400300p;
    }

    public float getImageZoom() {
        return this.f400299o;
    }

    public float getRound() {
        return this.f400291g;
    }

    public float getRoundPercent() {
        return this.f400290f;
    }

    public ImageFilterView(Context r100) {
        super(r100);
        this.f400285a = new c();
        this.f400286b = true;
        this.f400287c = null;
        this.f400288d = null;
        this.f400289e = 0.0f;
        this.f400290f = 0.0f;
        this.f400291g = Float.NaN;
        this.f400295k = new Drawable[2];
        this.f400297m = Float.NaN;
        this.f400298n = Float.NaN;
        this.f400299o = Float.NaN;
        this.f400300p = Float.NaN;
    }

    private void setOverlay(boolean r100) {
        this.f400286b = r100;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
    }

    public void setAltImageDrawable(Drawable r100) {
        Drawable r101 = r100.mutate();
        this.f400287c = r101;
        Drawable[] r102 = this.f400295k;
        r102[0] = this.f400288d;
        r102[1] = r101;
        LayerDrawable r103 = new LayerDrawable(this.f400295k);
        this.f400296l = r103;
        super.setImageDrawable(r103);
        setCrossfade(this.f400289e);
    }

    public void setAltImageResource(int r100) {
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
        this.f400287c = r101;
        setAltImageDrawable(r101);
    }

    public void setBrightness(float r100) {
        c r101 = this.f400285a;
        r101.f400306d = r100;
        r101.a(this);
    }

    public void setContrast(float r100) {
        c r101 = this.f400285a;
        r101.f400308f = r100;
        r101.a(this);
    }

    public void setCrossfade(float r100) {
        this.f400289e = r100;
        if (this.f400295k != null) goto L5;
        return;
    L5:
        if (this.f400286b == true) goto L7;
        this.f400296l.getDrawable(0).setAlpha((int) ((1.0f - this.f400289e) * 255.0f));
    L7:
        this.f400296l.getDrawable(1).setAlpha((int) (this.f400289e * 255.0f));
        super.setImageDrawable(this.f400296l);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        if (this.f400287c == null) goto L6;
        if (r100 == null) goto L6;
        Drawable r101 = r100.mutate();
        this.f400288d = r101;
        Drawable[] r102 = this.f400295k;
        r102[0] = r101;
        r102[1] = this.f400287c;
        LayerDrawable r103 = new LayerDrawable(this.f400295k);
        this.f400296l = r103;
        super.setImageDrawable(r103);
        setCrossfade(this.f400289e);
        return;
    L6:
        super.setImageDrawable(r100);
    }

    public void setImagePanX(float r100) {
        this.f400297m = r100;
        l();
    }

    public void setImagePanY(float r100) {
        this.f400298n = r100;
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r100) {
        if (this.f400287c == null) goto L5;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100).mutate();
        this.f400288d = r101;
        Drawable[] r102 = this.f400295k;
        r102[0] = r101;
        r102[1] = this.f400287c;
        LayerDrawable r103 = new LayerDrawable(this.f400295k);
        this.f400296l = r103;
        super.setImageDrawable(r103);
        setCrossfade(this.f400289e);
        return;
    L5:
        super.setImageResource(r100);
    }

    public void setImageRotate(float r100) {
        this.f400300p = r100;
        l();
    }

    public void setImageZoom(float r100) {
        this.f400299o = r100;
        l();
    }

    public void setRound(float r100) {
        if (Float.isNaN(r100) == false) goto L7;
        this.f400291g = r100;
        float r101 = this.f400290f;
        this.f400290f = -1.0f;
        setRoundPercent(r101);
        return;
    L7:
        if (this.f400291g == r100) goto L9;
        boolean r102 = true;
    L10:
        this.f400291g = r100;
        if (r100 != 0.0f) goto L13;
        setClipToOutline(false);
    L23:
        if (r102 == false) goto L26;
        invalidateOutline();
        return;
    L26:
        return;
    L13:
        if (this.f400292h != null) goto L16;
        this.f400292h = new Path();
    L16:
        if (this.f400294j != null) goto L19;
        this.f400294j = new RectF();
    L19:
        if (this.f400293i != null) goto L21;
        b r103 = new b(this);
        this.f400293i = r103;
        setOutlineProvider(r103);
    L21:
        setClipToOutline(true);
        this.f400294j.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f400292h.reset();
        Path r104 = this.f400292h;
        RectF r105 = this.f400294j;
        float r106 = this.f400291g;
        r104.addRoundRect(r105, r106, r106, Path.Direction.CW);
        goto L23
    L9:
        r102 = false;
        goto L10
    }

    public void setRoundPercent(float r100) {
        if (this.f400290f == r100) goto L5;
        boolean r101 = true;
    L6:
        this.f400290f = r100;
        if (r100 != 0.0f) goto L9;
        setClipToOutline(false);
    L19:
        if (r101 == false) goto L22;
        invalidateOutline();
        return;
    L22:
        return;
    L9:
        if (this.f400292h != null) goto L12;
        this.f400292h = new Path();
    L12:
        if (this.f400294j != null) goto L15;
        this.f400294j = new RectF();
    L15:
        if (this.f400293i != null) goto L17;
        a r102 = new a(this);
        this.f400293i = r102;
        setOutlineProvider(r102);
    L17:
        setClipToOutline(true);
        int r103 = getWidth();
        int r104 = getHeight();
        float r105 = (Math.min(r103, r104) * this.f400290f) / 2.0f;
        this.f400294j.set(0.0f, 0.0f, r103, r104);
        this.f400292h.reset();
        this.f400292h.addRoundRect(this.f400294j, r105, r105, Path.Direction.CW);
        goto L19
    L5:
        r101 = false;
        goto L6
    }

    public void setSaturation(float r100) {
        c r101 = this.f400285a;
        r101.f400307e = r100;
        r101.a(this);
    }

    public void setWarmth(float r100) {
        c r101 = this.f400285a;
        r101.f400309g = r100;
        r101.a(this);
    }

    public ImageFilterView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400285a = new c();
        this.f400286b = true;
        this.f400287c = null;
        this.f400288d = null;
        this.f400289e = 0.0f;
        this.f400290f = 0.0f;
        this.f400291g = Float.NaN;
        this.f400295k = new Drawable[2];
        this.f400297m = Float.NaN;
        this.f400298n = Float.NaN;
        this.f400299o = Float.NaN;
        this.f400300p = Float.NaN;
        init(r100, r101);
    }

    public final void init(Context r100, AttributeSet r101) {
        if (r101 == null) goto L67;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.altSrc, R.attr.blendSrc, R.attr.brightness, R.attr.contrast, R.attr.crossfade, R.attr.imagePanX, R.attr.imagePanY, R.attr.imageRotate, R.attr.imageZoom, R.attr.overlay, R.attr.round, R.attr.roundPercent, R.attr.saturation, R.attr.warmth});
        int r103 = r102.getIndexCount();
        this.f400287c = r102.getDrawable(0);
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L42;
        int r105 = r102.getIndex(r104);
        if (r105 != 4) goto L9;
        this.f400289e = r102.getFloat(r105, 0.0f);
    L41:
        r104 = r104 + 1;
        goto L4
    L9:
        if (r105 != 13) goto L12;
        setWarmth(r102.getFloat(r105, 0.0f));
        goto L41
    L12:
        if (r105 != 12) goto L15;
        setSaturation(r102.getFloat(r105, 0.0f));
        goto L41
    L15:
        if (r105 != 3) goto L18;
        setContrast(r102.getFloat(r105, 0.0f));
        goto L41
    L18:
        if (r105 != 2) goto L21;
        setBrightness(r102.getFloat(r105, 0.0f));
        goto L41
    L21:
        if (r105 != 10) goto L24;
        setRound(r102.getDimension(r105, 0.0f));
        goto L41
    L24:
        if (r105 != 11) goto L27;
        setRoundPercent(r102.getFloat(r105, 0.0f));
        goto L41
    L27:
        if (r105 != 9) goto L30;
        setOverlay(r102.getBoolean(r105, this.f400286b));
        goto L41
    L30:
        if (r105 != 5) goto L33;
        setImagePanX(r102.getFloat(r105, this.f400297m));
        goto L41
    L33:
        if (r105 != 6) goto L36;
        setImagePanY(r102.getFloat(r105, this.f400298n));
        goto L41
    L36:
        if (r105 != 7) goto L39;
        setImageRotate(r102.getFloat(r105, this.f400300p));
        goto L41
    L39:
        if (r105 != 8) goto L41;
        setImageZoom(r102.getFloat(r105, this.f400299o));
        goto L41
    L42:
        r102.recycle();
        Drawable r106 = getDrawable();
        this.f400288d = r106;
        if (this.f400287c == null) goto L49;
        if (r106 == null) goto L49;
        Drawable[] r107 = this.f400295k;
        Drawable r108 = getDrawable().mutate();
        this.f400288d = r108;
        r107[0] = r108;
        this.f400295k[1] = this.f400287c.mutate();
        LayerDrawable r109 = new LayerDrawable(this.f400295k);
        this.f400296l = r109;
        r109.getDrawable(1).setAlpha((int) (this.f400289e * 255.0f));
        if (this.f400286b == true) goto L48;
        this.f400296l.getDrawable(0).setAlpha((int) ((1.0f - this.f400289e) * 255.0f));
    L48:
        super.setImageDrawable(this.f400296l);
        return;
    L49:
        Drawable r110 = getDrawable();
        this.f400288d = r110;
        if (r110 == null) goto L69;
        Drawable[] r111 = this.f400295k;
        Drawable r112 = r110.mutate();
        this.f400288d = r112;
        r111[0] = r112;
        return;
    L69:
        return;
    }

    public ImageFilterView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400285a = new c();
        this.f400286b = true;
        this.f400287c = null;
        this.f400288d = null;
        this.f400289e = 0.0f;
        this.f400290f = 0.0f;
        this.f400291g = Float.NaN;
        this.f400295k = new Drawable[2];
        this.f400297m = Float.NaN;
        this.f400298n = Float.NaN;
        this.f400299o = Float.NaN;
        this.f400300p = Float.NaN;
        init(r100, r101);
    }

    @Override // android.view.View
    public final void layout(int r100, int r101, int r102, int r103) {
        super.layout(r100, r101, r102, r103);
        j();
    }
}
