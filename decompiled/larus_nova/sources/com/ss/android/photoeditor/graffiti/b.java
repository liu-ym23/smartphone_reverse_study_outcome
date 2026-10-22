package com.ss.android.photoeditor.graffiti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import com.ss.android.lark.log.Log;
import pfc.f;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f449218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f449219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f449220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f449221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f449222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f449223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f449224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f449225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f449226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Canvas f449227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Canvas f449228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f449229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f449230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f449231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f449232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f449233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f449234q;

    public static class a extends f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Path f449235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f449236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC5437b f449237e;

        @Override // pfc.f.a
        public final f.b c(f.b r100) {
            return r100;
        }

        @Override // pfc.f.a
        public final Bitmap d() {
            RectF r100 = ((com.ss.android.photoeditor.graffiti.a) this.f449237e).a();
            Bitmap r101 = Bitmap.createBitmap((int) r100.width(), (int) r100.height(), Bitmap.Config.ARGB_4444);
            new Canvas(r101).drawPath(this.f449235c, this.f449236d);
            return r101;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return ((com.ss.android.photoeditor.graffiti.a) this.f449237e).a();
        }

        @Override // pfc.f.a
        public final RectF f() {
            return new RectF(((e) ((com.ss.android.photoeditor.graffiti.a) this.f449237e).f449217a.f449220c).f449244a.getLocation());
        }

        public a(Path r100, Paint r101, com.ss.android.photoeditor.graffiti.a r102) {
            this.f449236d = new Paint(r101);
            this.f449235c = r100;
            this.f449237e = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.photoeditor.graffiti.b$b, reason: collision with other inner class name */
    public interface InterfaceC5437b {
    }

    public interface c {
    }

    public interface d {
    }

    public final void a() {
        Canvas r100 = this.f449229l;
        if (r100 == null) goto L21;
        boolean r101 = false;
        r100.drawColor(0, PorterDuff.Mode.CLEAR);
        Bitmap r102 = this.f449225h;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L13;
        this.f449229l.drawBitmap(this.f449225h, 0.0f, 0.0f, null);
    L13:
        Bitmap r104 = this.f449224g;
        if (r104 != null) goto L16;
    L18:
        if (r101 == false) goto L22;
        Canvas r105 = this.f449229l;
        Bitmap r106 = this.f449224g;
        Matrix r107 = new Matrix();
        RectF r108 = b();
        RectF r109 = ((e) this.f449220c).f449244a.getLocation();
        RectF r110 = c();
        float r111 = r108.width() / r109.width();
        float r112 = r110.left - (r109.left * r111);
        float r113 = r110.top - (r109.top * r111);
        r107.postScale(r111, r111);
        r107.postTranslate(r112, r113);
        r105.drawBitmap(r106, r107, null);
        return;
    L22:
        return;
    L16:
        if (r104.isRecycled() == true) goto L18;
        r101 = true;
        goto L18
    L7:
        if (r102.isRecycled() == true) goto L9;
        r103 = true;
        goto L11
    }

    public final RectF b() {
        GraffitiView r100 = ((e) this.f449220c).f449244a;
        int r101 = GraffitiView.f449199n;
        return r100.n();
    }

    public final RectF c() {
        return new RectF(0.0f, 0.0f, ((e) this.f449220c).f449244a.getWidth(), ((e) this.f449220c).f449244a.getHeight());
    }

    public final void d() {
        int r100 = ((e) this.f449220c).f449244a.getWidth();
        int r101 = ((e) this.f449220c).f449244a.getHeight();
        Log.i("GraffitiDrawHelper", "initTouchBitmapAndCanvas, width:" + r100 + ", height:" + r101);
        if (r100 == 0) goto L8;
        if (r101 == 0) goto L8;
        this.f449224g = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_4444);
        this.f449228k = new Canvas(this.f449224g);
        return;
    L8:
        Log.i("GraffitiDrawHelper", "width or height is 0, " + c().toShortString());
    }

    public final void e(Bitmap r100) {
        RectF r101 = b();
        if (r101.width() > 0.0f) goto L5;
    L15:
        Log.e("GraffitiDrawHelper", "setResultBitmap, imageRect not initialized");
        return;
    L5:
        if (r101.height() <= 0.0f) goto L15;
        int r102 = (int) r101.width();
        int r103 = (int) r101.height();
        Log.i("GraffitiDrawHelper", "setResultBitmap, width:" + r102 + ",height:" + r103);
        Bitmap r104 = this.f449225h;
        if (r104 == r100) goto L10;
        com.ss.android.photoeditor.util.b.e(r104);
    L10:
        this.f449225h = Bitmap.createScaledBitmap(r100, r102, r103, true);
        this.f449227j = new Canvas(this.f449225h);
        Canvas r105 = this.f449228k;
        if (r105 == null) goto L13;
        r105.drawColor(0, PorterDuff.Mode.CLEAR);
    L13:
        ((com.ss.android.photoeditor.graffiti.d) this.f449219b).a(this.f449225h);
    }

    public b(Context r100, com.ss.android.photoeditor.graffiti.d r101, e r102) {
        this.f449218a = false;
        this.f449234q = false;
        this.f449233p = r100;
        this.f449219b = r101;
        this.f449220c = r102;
        this.f449231n = 30;
        Paint r103 = new Paint();
        this.f449230m = r103;
        r103.setColor(this.f449232o);
        this.f449230m.setStyle(Paint.Style.STROKE);
        this.f449230m.setAntiAlias(true);
        this.f449230m.setFilterBitmap(true);
        this.f449230m.setPathEffect(new CornerPathEffect(10.0f));
        this.f449230m.setStrokeWidth(this.f449231n);
        this.f449230m.setStrokeJoin(Paint.Join.ROUND);
        this.f449230m.setStrokeCap(Paint.Cap.ROUND);
        d();
        this.f449223f = new Path();
        RectF r104 = b();
        RectF r105 = r102.f449244a.getLocation();
        if (r104.width() > 0.0f) goto L5;
    L8:
        Log.e("GraffitiDrawHelper", "imageRect width or height <= 0, " + r104 + r105);
        return;
    L5:
        if (r104.height() <= 0.0f) goto L8;
        this.f449225h = Bitmap.createBitmap((int) r104.width(), (int) r104.height(), Bitmap.Config.ARGB_4444);
        this.f449227j = new Canvas(this.f449225h);
        this.f449226i = Bitmap.createBitmap((int) r104.width(), (int) r104.height(), Bitmap.Config.ARGB_4444);
        this.f449229l = new Canvas(this.f449226i);
    }
}
