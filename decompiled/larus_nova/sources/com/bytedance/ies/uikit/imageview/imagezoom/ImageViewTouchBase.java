package com.bytedance.ies.uikit.imageview.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public class ImageViewTouchBase extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f56.a f248983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f248984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f248985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f248986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f248987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f248988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f248989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Matrix f248990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f248991i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f248992j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f248993k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f248994l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f248995m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f248996n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f248997o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f248998p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f248999q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f249000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f249001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Matrix f249002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f249003d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouchBase f249004e;

        @Override // java.lang.Runnable
        public final void run() {
            this.f249004e.n(this.f249000a, this.f249001b, this.f249002c, this.f249003d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ImageViewTouchBase r100, Drawable r101, boolean r102, Matrix r103, float r104) {
            this.f249004e = r100;
            this.f249000a = r101;
            this.f249001b = r102;
            this.f249002c = r103;
            this.f249003d = r104;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f249005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f249006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f249007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f249008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f249009e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f249010f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ImageViewTouchBase f249011g;

        public final void a() {
            float r100 = Math.min(this.f249005a, System.currentTimeMillis() - this.f249006b);
            f56.a r101 = this.f249011g.f248983a;
            double r102 = this.f249007c;
            double r103 = this.f249005a;
            r101.getClass();
            double r104 = ((double) r100) / (r103 / 2.0d);
            double r105 = r102 / 2.0d;
            if (r104 >= 1.0d) goto L5;
            double r106 = ((r105 * r104) * r104) * r104;
        L6:
            this.f249011g.p(this.f249008d + ((float) (r106 + AudioStats.AUDIO_AMPLITUDE_NONE)), this.f249009e, this.f249010f);
            if (r100 >= this.f249005a) goto L9;
            this.f249011g.f248986d.post(this);
            return;
        L9:
            ImageViewTouchBase r107 = this.f249011g;
            if (r107.f248999q == false) goto L13;
            r107.f248999q = false;
            return;
        L13:
            r107.f248999q = true;
            r107.l(r107.getScale());
            this.f249011g.b();
            return;
        L5:
            double r108 = r104 - 2.0d;
            r106 = r105 * (((r108 * r108) * r108) + 2.0d);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ImageViewTouchBase r100, float r101, long r102, float r103, float r104, float r105, float r106) {
            this.f249011g = r100;
            this.f249005a = r101;
            this.f249006b = r102;
            this.f249007c = r103;
            this.f249008d = r104;
            this.f249009e = r105;
            this.f249010f = r106;
        }
    }

    public interface c {
    }

    @Override // android.view.View
    public float getRotation() {
        return 0.0f;
    }

    public void j() {
    }

    public void k(float r100) {
    }

    public void l(float r100) {
    }

    public void setOnBitmapChangedListener(c r100) {
    }

    public RectF getBitmapRect() {
        return c(this.f248985c);
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.f248985c);
    }

    public Matrix getImageViewMatrix() {
        Matrix r100 = this.f248985c;
        this.f248990h.set(this.f248984b);
        this.f248990h.postConcat(r100);
        return this.f248990h;
    }

    public float getMaxZoom() {
        if (this.f248988f >= 1.0f) goto L6;
        this.f248988f = i();
    L6:
        return this.f248988f;
    }

    public float getMinZoom() {
        if (this.f248989g >= 0.0f) goto L6;
        this.f248989g = 1.0f;
    L6:
        return this.f248989g;
    }

    public float getScale() {
        this.f248985c.getValues(this.f248991i);
        return this.f248991i[0];
    }

    public void h() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void b() {
        if (getDrawable() != null) goto L5;
        return;
    L5:
        RectF r100 = d(this.f248985c);
        float r101 = r100.left;
        if (r101 == 0.0f) goto L8;
    L9:
        float r102 = r100.top;
        this.f248985c.postTranslate(r101, r102);
        setImageMatrix(getImageViewMatrix());
        return;
    L8:
        if (r100.top != 0.0f) goto L9;
    }

    public final float i() {
        Drawable r100 = getDrawable();
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        return Math.max(r100.getIntrinsicWidth() / this.f248992j, r100.getIntrinsicHeight() / this.f248993k) * 4.0f;
    }

    public ImageViewTouchBase(Context r100) {
        super(r100);
        this.f248983a = new f56.a();
        this.f248984b = new Matrix();
        this.f248985c = new Matrix();
        this.f248986d = new Handler();
        this.f248987e = null;
        this.f248989g = -1.0f;
        this.f248990h = new Matrix();
        this.f248991i = new float[9];
        this.f248992j = -1;
        this.f248993k = -1;
        this.f248994l = false;
        this.f248995m = false;
        this.f248996n = new RectF();
        this.f248997o = new RectF();
        this.f248998p = new RectF();
        h();
    }

    public final RectF c(Matrix r100) {
        Drawable r101 = getDrawable();
        this.f248990h.set(this.f248984b);
        this.f248990h.postConcat(r100);
        Matrix r102 = this.f248990h;
        if (r101 == null) goto L5;
        this.f248996n.set(0.0f, 0.0f, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
    L6:
        r102.mapRect(this.f248996n);
        return this.f248996n;
    L5:
        this.f248996n.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L6
    }

    public final RectF d(Matrix r100) {
        if (getDrawable() == null) goto L5;
        this.f248997o.set(0.0f, 0.0f, 0.0f, 0.0f);
        RectF r101 = c(r100);
        float r102 = r101.height();
        float r103 = r101.width();
        float r104 = getHeight();
        if (r102 >= r104) goto L9;
        float r105 = (r104 - r102) / 2.0f;
        float r106 = r101.top;
    L15:
        float r107 = r105 - r106;
    L17:
        float r108 = getWidth();
        if (r103 >= r108) goto L20;
        r108 = (r108 - r103) / 2.0f;
        float r109 = r101.left;
    L25:
        float r110 = r108 - r109;
    L27:
        this.f248997o.set(r110, r107, 0.0f, 0.0f);
        return this.f248997o;
    L20:
        float r111 = r101.left;
        if (r111 <= 0.0f) goto L23;
        r110 = -r111;
        goto L27
    L23:
        r109 = r101.right;
        if (r109 < r108) goto L25;
        r110 = 0.0f;
        goto L27
    L9:
        float r112 = r101.top;
        if (r112 <= 0.0f) goto L13;
        r107 = -r112;
        goto L17
    L13:
        if (r101.bottom >= r104) goto L16;
        r105 = getHeight();
        r106 = r101.bottom;
        goto L15
    L16:
        r107 = 0.0f;
        goto L17
    L5:
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setFitToScreen(boolean r100) {
        if (r100 == this.f248995m) goto L6;
        this.f248995m = r100;
        requestLayout();
        return;
    }

    public void setFitToWidth(boolean r100) {
        if (r100 == this.f248994l) goto L6;
        this.f248994l = r100;
        requestLayout();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        if (r100 == null) goto L5;
        n(new g56.a(r100), true, null, -1.0f);
        return;
    L5:
        n(null, true, null, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        n(r100, true, null, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r100) {
        setImageDrawable(getContext().getResources().getDrawable(r100));
    }

    public void setMinZoom(float r100) {
        this.f248989g = r100;
    }

    public ImageViewTouchBase(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f248983a = new f56.a();
        this.f248984b = new Matrix();
        this.f248985c = new Matrix();
        this.f248986d = new Handler();
        this.f248987e = null;
        this.f248989g = -1.0f;
        this.f248990h = new Matrix();
        this.f248991i = new float[9];
        this.f248992j = -1;
        this.f248993k = -1;
        this.f248994l = false;
        this.f248995m = false;
        this.f248996n = new RectF();
        this.f248997o = new RectF();
        this.f248998p = new RectF();
        h();
    }

    public final void e(Drawable r100, Matrix r101) {
        float r102 = getWidth();
        float r103 = getHeight();
        float r104 = r100.getIntrinsicWidth();
        float r105 = r100.getIntrinsicHeight();
        r101.reset();
        if (r104 <= r102) goto L5;
    L8:
        float r106 = Math.min(Math.min(r102 / r104, 2.0f), Math.min(r103 / r105, 2.0f));
        r101.postScale(r106, r106);
        r101.postTranslate((r102 - (r104 * r106)) / 2.0f, (r103 - (r105 * r106)) / 2.0f);
        return;
    L5:
        if (r105 > r103) goto L8;
        r101.postTranslate((r102 - r104) / 2.0f, (r103 - r105) / 2.0f);
    }

    public final void f(Drawable r100, Matrix r101) {
        float r102 = getWidth();
        float r103 = getHeight();
        float r104 = r100.getIntrinsicWidth();
        float r105 = r100.getIntrinsicHeight();
        r101.reset();
        float r106 = Math.min(Math.min(r102 / r104, 2.5f), Math.min(r103 / r105, 2.5f));
        r101.postScale(r106, r106);
        r101.postTranslate((r102 - (r104 * r106)) / 2.0f, (r103 - (r105 * r106)) / 2.0f);
    }

    public final void m(double r100, double r101) {
        RectF r102 = getBitmapRect();
        this.f248998p.set((float) r100, (float) r101, 0.0f, 0.0f);
        o(r102, this.f248998p);
        RectF r103 = this.f248998p;
        float r104 = r103.left;
        float r105 = r103.top;
        this.f248985c.postTranslate(r104, r105);
        setImageMatrix(getImageViewMatrix());
        b();
    }

    public final void o(RectF r100, RectF r101) {
        float r102 = getWidth();
        float r103 = getHeight();
        if (r100.top < 0.0f) goto L8;
        if (r100.bottom > r103) goto L8;
        r101.top = 0.0f;
    L8:
        if (r100.left >= 0.0f) goto L10;
    L12:
        float r104 = r100.top;
        if ((r101.top + r104) >= 0.0f) goto L15;
    L17:
        float r105 = r100.bottom;
        float r106 = r103 - 0.0f;
        if ((r101.top + r105) <= r106) goto L20;
    L22:
        float r107 = r100.left;
        if ((r101.left + r107) < 0.0f) goto L25;
        r101.left = (int) (0.0f - r107);
    L25:
        float r108 = r100.right;
        float r109 = r102 - 0.0f;
        if ((r101.left + r108) > r109) goto L29;
        r101.left = (int) (r109 - r108);
        return;
    L29:
        return;
    L20:
        if (r100.top >= 0.0f) goto L22;
        r101.top = (int) (r106 - r105);
        goto L22
    L15:
        if (r100.bottom <= r103) goto L17;
        r101.top = (int) (0.0f - r104);
        goto L17
    L10:
        if (r100.right > r102) goto L12;
        r101.left = 0.0f;
        goto L12
    }

    public final void g(Drawable r100, Matrix r101, float[] r102) {
        float r103 = getWidth();
        float r104 = r100.getIntrinsicWidth();
        r101.reset();
        float r105 = Math.min(r103 / r104, 2.5f);
        r101.postScale(r105, r105);
        r101.postTranslate((r103 - (r104 * r105)) / 2.0f, 0.0f);
        if (r105 <= 1.0f) goto L5;
        r102[0] = 1.0f / r105;
        return;
    L5:
        r102[0] = 1.0f;
    }

    public final void p(float r100, float r101, float r102) {
        float r103 = this.f248988f;
        if (r100 <= r103) goto L5;
        r100 = r103;
    L5:
        float r104 = r100 / getScale();
        this.f248985c.postScale(r104, r104, r101, r102);
        setImageMatrix(getImageViewMatrix());
        k(getScale());
        b();
    }

    public void a(Drawable r100, boolean r101, Matrix r102, float r103) {
        if (r100 != null) goto L4;
        this.f248984b.reset();
        super.setImageDrawable(null);
    L12:
        if (r101 == false) goto L16;
        this.f248985c.reset();
        if (r102 == null) goto L16;
        this.f248985c = new Matrix(r102);
    L16:
        setImageMatrix(getImageViewMatrix());
        if (r103 >= 1.0f) goto L19;
        this.f248988f = i();
    L20:
        j();
        return;
    L19:
        this.f248988f = r103;
        goto L20
    L4:
        if (this.f248994l == false) goto L7;
        float[] r104 = new float[1];
        g(r100, this.f248984b, r104);
        setMinZoom(r104[0]);
    L10:
        super.setImageDrawable(r100);
        goto L12
    L7:
        if (this.f248995m == false) goto L9;
        f(r100, this.f248984b);
        this.f248984b.getValues(this.f248991i);
        setMinZoom(this.f248991i[0]);
        goto L10
    L9:
        e(r100, this.f248984b);
        setMinZoom(getMinZoom());
        goto L10
    }

    public final void n(Drawable r100, boolean r101, Matrix r110, float r111) {
        if (getWidth() > 0) goto L6;
        this.f248987e = new a(this, r100, r101, r110, r111);
        return;
    L6:
        a(r100, r101, r110, r111);
    }

    public final void q(float r110, float r111, float r112, float r113) {
        if (r110 <= getMaxZoom()) goto L5;
        r110 = getMaxZoom();
    L5:
        long r100 = System.currentTimeMillis();
        float r101 = getScale();
        float r102 = r110 - r101;
        Matrix r103 = new Matrix(this.f248985c);
        r103.postScale(r110, r110, r111, r112);
        RectF r104 = d(r103);
        float r105 = r111 + (r104.left * r110);
        float r106 = r112 + (r104.top * r110);
        this.f248986d.post(new b(this, r113, r100, r102, r101, r105, r106));
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f248992j = r103 - r101;
        this.f248993k = r104 - r102;
        a r105 = this.f248987e;
        if (r105 == null) goto L6;
        this.f248987e = null;
        r105.run();
    L6:
        if (getDrawable() == null) goto L16;
        float r106 = 1.0f;
        if (this.f248994l == false) goto L11;
        float[] r107 = new float[1];
        g(getDrawable(), this.f248984b, r107);
        setMinZoom(r107[0]);
    L14:
        setImageMatrix(getImageViewMatrix());
        p(r106, getWidth() / 2.0f, getHeight() / 2.0f);
        return;
    L11:
        if (this.f248995m == false) goto L13;
        f(getDrawable(), this.f248984b);
        setMinZoom(1.0f);
        r106 = getMinZoom();
        goto L14
    L13:
        e(getDrawable(), this.f248984b);
        setMinZoom(getMinZoom());
        r106 = getMinZoom();
        goto L14
    }
}
