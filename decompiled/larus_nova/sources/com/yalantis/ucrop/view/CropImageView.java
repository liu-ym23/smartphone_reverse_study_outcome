package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.yalantis.ucrop.task.BitmapCropTask;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import sqc.c;
import vqc.f;

/* JADX INFO: loaded from: classes41.dex */
public class CropImageView extends TransformImageView {
    public long A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f464442p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Matrix f464443q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f464444r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f464445s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f464446t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f464447u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f464448v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f464449w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f464450x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f464451y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f464452z;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<CropImageView> f464453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f464454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f464455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f464456d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f464457e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f464458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f464459g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f464460h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f464461i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f464462j;

        public final void a() {
            CropImageView r100 = this.f464453a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            float r101 = Math.min(this.f464454b, System.currentTimeMillis() - this.f464455c);
            float r102 = this.f464458f;
            long r103 = this.f464454b;
            float r104 = (r101 / r103) - 1.0f;
            float r105 = (r102 * (((r104 * r104) * r104) + 1.0f)) + 0.0f;
            float r106 = (r101 / r103) - 1.0f;
            float r107 = (this.f464459g * (((r106 * r106) * r106) + 1.0f)) + 0.0f;
            float r108 = r101 / (r103 / 2.0f);
            float r109 = this.f464461i / 2.0f;
            if (r108 >= 1.0f) goto L8;
            float r110 = ((r109 * r108) * r108) * r108;
        L9:
            float r111 = r110 + 0.0f;
            if (r101 >= r103) goto L18;
            float[] r112 = r100.f464501b;
            r100.p(r105 - (r112[0] - this.f464456d), r107 - (r112[1] - this.f464457e));
            if (this.f464462j == true) goto L15;
            r100.w(this.f464460h + r111, r100.f464442p.centerX(), r100.f464442p.centerY());
        L15:
            if (r100.u(r100.f464500a) == true) goto L19;
            r100.post(this);
            return;
        L19:
            return;
        L18:
            return;
        L8:
            float r113 = r108 - 2.0f;
            r110 = r109 * (((r113 * r113) * r113) + 2.0f);
            goto L9
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

        public a(CropImageView r100, long r101, float r102, float r103, float r104, float r105, float r106, float r110, boolean r111) {
            this.f464453a = new WeakReference(r100);
            this.f464454b = r101;
            this.f464455c = System.currentTimeMillis();
            this.f464456d = r102;
            this.f464457e = r103;
            this.f464458f = r104;
            this.f464459g = r105;
            this.f464460h = r106;
            this.f464461i = r110;
            this.f464462j = r111;
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<CropImageView> f464463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f464464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f464465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f464466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f464467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f464468f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f464469g;

        public final void a() {
            CropImageView r100 = this.f464463a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            float r101 = Math.min(this.f464464b, System.currentTimeMillis() - this.f464465c);
            float r102 = this.f464467e;
            long r103 = this.f464464b;
            float r104 = r101 / (r103 / 2.0f);
            float r105 = r102 / 2.0f;
            if (r104 >= 1.0f) goto L8;
            float r106 = ((r105 * r104) * r104) * r104;
        L9:
            float r107 = r106 + 0.0f;
            if (r101 >= r103) goto L12;
            r100.w(this.f464466d + r107, this.f464468f, this.f464469g);
            r100.post(this);
            return;
        L12:
            r100.setImageToWrapCropBounds(true);
            return;
        L8:
            float r108 = r104 - 2.0f;
            r106 = r105 * (((r108 * r108) * r108) + 2.0f);
            goto L9
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

        public b(GestureCropImageView r100, float r101, float r102, float r103, float r104) {
            this.f464463a = new WeakReference(r100);
            this.f464465c = System.currentTimeMillis();
            this.f464464b = 200;
            this.f464466d = r101;
            this.f464467e = r102;
            this.f464468f = r103;
            this.f464469g = r104;
        }
    }

    public final void s() {
        removeCallbacks(this.f464447u);
        removeCallbacks(this.f464448v);
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public final void m() {
        super.m();
        Drawable r100 = getDrawable();
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = r100.getIntrinsicWidth();
        float r102 = r100.getIntrinsicHeight();
        if (this.f464444r != 0.0f) goto L8;
        this.f464444r = r101 / r102;
    L8:
        int r103 = this.f464504e;
        float r104 = r103;
        float r105 = this.f464444r;
        int r106 = (int) (r104 / r105);
        int r107 = this.f464505f;
        if (r106 <= r107) goto L11;
        float r108 = r107;
        int r109 = (int) (r105 * r108);
        int r110 = (r103 - r109) / 2;
        this.f464442p.set(r110, 0.0f, r109 + r110, r108);
    L12:
        r(r101, r102);
        float r111 = this.f464442p.width();
        float r112 = this.f464442p.height();
        float r113 = Math.max(this.f464442p.width() / r101, this.f464442p.height() / r102);
        RectF r114 = this.f464442p;
        float r115 = ((r111 - (r101 * r113)) / 2.0f) + r114.left;
        float r116 = ((r112 - (r102 * r113)) / 2.0f) + r114.top;
        this.f464503d.reset();
        this.f464503d.postScale(r113, r113);
        this.f464503d.postTranslate(r115, r116);
        setImageMatrix(this.f464503d);
        c r117 = this.f464446t;
        if (r117 == null) goto L15;
        ((wqc.a) r117).f560782a.f464517b.setTargetAspectRatio(this.f464444r);
    L15:
        TransformImageView.b r118 = this.f464506g;
        if (r118 == null) goto L19;
        r118.c(getCurrentScale());
        this.f464506g.d(getCurrentAngle());
        return;
    L19:
        return;
    L11:
        int r119 = (r107 - r106) / 2;
        this.f464442p.set(0.0f, r119, r104, r106 + r119);
        goto L12
    }

    public c getCropBoundsChangeListener() {
        return this.f464446t;
    }

    public float getMaxScale() {
        return this.f464449w;
    }

    public float getMinScale() {
        return this.f464450x;
    }

    public float getTargetAspectRatio() {
        return this.f464444r;
    }

    public CropImageView(Context r100) {
        this(r100, null);
    }

    public void setCropBoundsChangeListener(c r100) {
        this.f464446t = r100;
    }

    public void setCropRect(RectF r100) {
        this.f464444r = r100.width() / r100.height();
        this.f464442p.set(r100.left - getPaddingLeft(), r100.top - getPaddingTop(), r100.right - getPaddingRight(), r100.bottom - getPaddingBottom());
        Drawable r101 = getDrawable();
        if (r101 == null) goto L6;
        r(r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
    L6:
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean r210) {
        if (this.f464510k == true) goto L5;
        return;
    L5:
        if (u(this.f464500a) == true) goto L33;
        float[] r100 = this.f464501b;
        float r101 = r100[0];
        float r102 = r100[1];
        float r103 = getCurrentScale();
        float r104 = this.f464442p.centerX() - r101;
        float r105 = this.f464442p.centerY() - r102;
        this.f464443q.reset();
        this.f464443q.setTranslate(r104, r105);
        float[] r106 = this.f464500a;
        float[] r107 = Arrays.copyOf(r106, r106.length);
        this.f464443q.mapPoints(r107);
        boolean r110 = u(r107);
        if (r110 == false) goto L25;
        this.f464443q.reset();
        this.f464443q.setRotate(-getCurrentAngle());
        float[] r108 = this.f464500a;
        float[] r109 = Arrays.copyOf(r108, r108.length);
        float[] r111 = f.a(this.f464442p);
        this.f464443q.mapPoints(r109);
        this.f464443q.mapPoints(r111);
        RectF r112 = f.b(r109);
        RectF r113 = f.b(r111);
        float r114 = r112.left - r113.left;
        float r115 = r112.top - r113.top;
        float r116 = r112.right - r113.right;
        float r117 = r112.bottom - r113.bottom;
        float[] r118 = new float[4];
        if (r114 > 0.0f) goto L12;
        r114 = 0.0f;
    L12:
        r118[0] = r114;
        if (r115 > 0.0f) goto L16;
        r115 = 0.0f;
    L16:
        r118[1] = r115;
        if (r116 < 0.0f) goto L20;
        r116 = 0.0f;
    L20:
        r118[2] = r116;
        if (r117 < 0.0f) goto L24;
        r117 = 0.0f;
    L24:
        r118[3] = r117;
        this.f464443q.reset();
        this.f464443q.setRotate(getCurrentAngle());
        this.f464443q.mapPoints(r118);
        float r119 = -(r118[0] + r118[2]);
        float r120 = -(r118[1] + r118[3]);
        float r121 = r103;
        float r122 = 0.0f;
    L26:
        if (r210 == false) goto L28;
        a r123 = new a(this, this.A, r101, r102, r119, r120, r121, r122, r110);
        this.f464447u = r123;
        post(r123);
        return;
    L28:
        p(r119, r120);
        if (r110 != 0) goto L35;
        w(r121 + r122, this.f464442p.centerX(), this.f464442p.centerY());
        return;
    L35:
        return;
    L25:
        RectF r124 = new RectF(this.f464442p);
        this.f464443q.reset();
        this.f464443q.setRotate(getCurrentAngle());
        this.f464443q.mapRect(r124);
        float[] r125 = this.f464500a;
        r121 = r103;
        float[] r126 = {(float) Math.sqrt(Math.pow(r125[0] - r125[2], 2.0d) + Math.pow(r125[1] - r125[3], 2.0d)), (float) Math.sqrt(Math.pow(r125[2] - r125[4], 2.0d) + Math.pow(r125[3] - r125[5], 2.0d))};
        r119 = r104;
        r122 = (Math.max(r124.width() / r126[0], r124.height() / r126[1]) * r121) - r121;
        r120 = r105;
        goto L26
    }

    public void setImageToWrapCropBoundsAnimDuration(long r100) {
        if (r100 <= 0) goto L7;
        this.A = r100;
        return;
    L7:
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int r100) {
        this.f464451y = r100;
    }

    public void setMaxResultImageSizeY(int r100) {
        this.f464452z = r100;
    }

    public void setMaxScale(float r100) {
        this.f464449w = r100;
    }

    public void setMaxScaleMultiplier(float r100) {
        this.f464445s = r100;
    }

    public void setMinScale(float r100) {
        this.f464450x = r100;
    }

    public void setTargetAspectRatio(float r100) {
        Drawable r101 = getDrawable();
        if (r101 != null) goto L7;
        this.f464444r = r100;
        return;
    L7:
        if (r100 != 0.0f) goto L9;
        this.f464444r = r101.getIntrinsicWidth() / r101.getIntrinsicHeight();
    L10:
        c r102 = this.f464446t;
        if (r102 == null) goto L14;
        ((wqc.a) r102).f560782a.f464517b.setTargetAspectRatio(this.f464444r);
        return;
    L14:
        return;
    L9:
        this.f464444r = r100;
        goto L10
    }

    public final boolean u(float[] r100) {
        this.f464443q.reset();
        this.f464443q.setRotate(-getCurrentAngle());
        float[] r101 = Arrays.copyOf(r100, r100.length);
        this.f464443q.mapPoints(r101);
        float[] r102 = f.a(this.f464442p);
        this.f464443q.mapPoints(r102);
        return f.b(r101).contains(f.b(r102));
    }

    public final void v(float r100) {
        n(r100, this.f464442p.centerX(), this.f464442p.centerY());
    }

    public final void x(float r100) {
        float r101 = this.f464442p.centerX();
        float r102 = this.f464442p.centerY();
        if (r100 < getMinScale()) goto L6;
        o(r100 / getCurrentScale(), r101, r102);
        return;
    }

    public CropImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void r(float r100, float r101) {
        float r102 = Math.min(Math.min(this.f464442p.width() / r100, this.f464442p.width() / r101), Math.min(this.f464442p.height() / r101, this.f464442p.height() / r100));
        this.f464450x = r102;
        this.f464449w = r102 * this.f464445s;
    }

    public CropImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f464442p = new RectF();
        this.f464443q = new Matrix();
        this.f464445s = 10.0f;
        this.f464448v = null;
        this.f464451y = 0;
        this.f464452z = 0;
        this.A = 500;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void o(float r100, float r101, float r102) {
        if (r100 <= 1.0f) goto L8;
        if ((getCurrentScale() * r100) > getMaxScale()) goto L8;
        super.o(r100, r101, r102);
        return;
    L8:
        if (r100 < 1.0f) goto L10;
        return;
    L10:
        if ((getCurrentScale() * r100) < getMinScale()) goto L15;
        super.o(r100, r101, r102);
        return;
    }

    public final void t(Bitmap.CompressFormat r110, int r111, sqc.a r112) {
        s();
        setImageToWrapCropBounds(false);
        tqc.c r100 = new tqc.c(this.f464442p, f.b(this.f464500a), getCurrentScale(), getCurrentAngle());
        tqc.a r101 = new tqc.a(this.f464451y, this.f464452z, r110, r111, getImageInputPath(), getImageOutputPath(), getExifInfo());
        new BitmapCropTask(getViewBitmap(), r100, r101, r112).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void w(float r100, float r101, float r102) {
        if (r100 > getMaxScale()) goto L6;
        o(r100 / getCurrentScale(), r101, r102);
        return;
    }
}
