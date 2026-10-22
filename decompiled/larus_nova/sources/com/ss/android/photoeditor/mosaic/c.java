package com.ss.android.photoeditor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.photoeditor.util.d;
import pfc.f;
import tfc.g;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends AbstractMosaicStrategy {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f449330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f449331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bitmap f449332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Canvas f449333r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f449334s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f449335t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f449336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f449337v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f449338w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f449339x;

    public static class a extends f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f449340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f449341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RectF f449342e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Path f449343f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Paint f449344g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Bitmap f449345h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final b f449346i;

        @Override // pfc.f.a
        public final f.b c(f.b r100) {
            return r100;
        }

        @Override // pfc.f.a
        public final Bitmap d() {
            this.f449344g.setXfermode(null);
            Bitmap r100 = Bitmap.createBitmap((int) this.f449342e.width(), (int) this.f449342e.height(), Bitmap.Config.ARGB_4444);
            Canvas r101 = new Canvas(r100);
            Bitmap r102 = Bitmap.createBitmap((int) this.f449342e.width(), (int) this.f449342e.height(), Bitmap.Config.ARGB_4444);
            Canvas r103 = new Canvas(r102);
            this.f449344g.setColor(FakePickerAvatarCreator.BLUE);
            r103.drawPath(this.f449343f, this.f449344g);
            Matrix r104 = new Matrix();
            float r105 = this.f449341d.width() / this.f449345h.getWidth();
            r104.postScale(r105, r105);
            RectF r106 = this.f449341d;
            float r107 = r106.left;
            RectF r108 = this.f449342e;
            r104.postTranslate(r107 - r108.left, r106.top - r108.top);
            r101.drawBitmap(this.f449345h, r104, null);
            this.f449344g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            r101.drawBitmap(r102, 0.0f, 0.0f, this.f449344g);
            this.f449344g.setXfermode(null);
            return r100;
        }

        @Override // pfc.f.a
        public final void k() {
            b r100 = this.f449346i;
            if (r100 == null) goto L6;
            r100.a(this);
            return;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return this.f449342e;
        }

        @Override // pfc.f.a
        public final RectF f() {
            return this.f449341d;
        }

        @Override // pfc.f.a
        public final boolean g() {
            return this.f449340c;
        }

        public a(RectF r100, RectF r101, Path r102, Paint r103, Bitmap r104, tfc.c r105) {
            this.f449340c = true;
            this.f449341d = new RectF(r100);
            this.f449342e = new RectF(r101);
            this.f449343f = new Path(r102);
            this.f449344g = new Paint(r103);
            this.f449345h = r104;
            this.f449346i = r105;
        }
    }

    public interface b {
        void a(a r100);
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void c() {
        this.f449246b = Bitmap.createBitmap((int) this.f449249e.width(), (int) this.f449249e.height(), Bitmap.Config.ARGB_4444);
        this.f449247c = new Canvas(this.f449246b);
        this.f449332q = Bitmap.createBitmap((int) this.f449249e.width(), (int) this.f449249e.height(), Bitmap.Config.ARGB_4444);
        this.f449333r = new Canvas(this.f449332q);
        Matrix r100 = new Matrix();
        r100.setScale(this.f449249e.width() / this.f449245a.getWidth(), this.f449249e.height() / this.f449245a.getHeight());
        Bitmap r101 = this.f449245a;
        Bitmap r102 = Bitmap.createBitmap(r101, 0, 0, r101.getWidth(), this.f449245a.getHeight(), r100, true);
        this.f449331p = r102;
        this.f449331p = g.a(r102);
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void a() {
        super.a();
        com.ss.android.photoeditor.util.b.e(this.f449330o);
    }

    public c(Context r100) {
        super(r100);
        this.f449336u = d.b(50);
        this.f449339x = false;
        this.f449335t = new Path();
        this.f449334s = new Paint();
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void b(MotionEvent r110) {
        if (this.f449245a != null) goto L5;
        return;
    L5:
        if (this.f449246b == null) goto L34;
        int r100 = r110.getAction();
        if (r100 != 0) goto L10;
        this.f449339x = false;
        this.f449337v = r110.getX();
        this.f449338w = r110.getY();
        this.f449335t.reset();
        this.f449335t.moveTo(r110.getX(), r110.getY());
        return;
    L10:
        if (r100 == 1) goto L25;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L25;
        return;
    L17:
        if (this.f449339x == false) goto L19;
    L20:
        this.f449339x = true;
        this.f449335t.lineTo(r110.getX(), r110.getY());
        if (this.f449330o != null) goto L23;
        this.f449330o = Bitmap.createBitmap((int) this.f449251g.width(), (int) this.f449251g.height(), Bitmap.Config.ARGB_4444);
    L23:
        this.f449334s.reset();
        this.f449334s.setStyle(Paint.Style.STROKE);
        this.f449334s.setAntiAlias(true);
        this.f449334s.setPathEffect(new CornerPathEffect(10.0f));
        this.f449334s.setStrokeWidth(this.f449336u);
        this.f449334s.setStrokeJoin(Paint.Join.ROUND);
        this.f449334s.setStrokeCap(Paint.Cap.ROUND);
        Canvas r111 = new Canvas(this.f449330o);
        r111.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f449334s.setColor(FakePickerAvatarCreator.BLUE);
        r111.drawPath(this.f449335t, this.f449334s);
        this.f449247c.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f449333r.drawColor(0, PorterDuff.Mode.CLEAR);
        float r112 = this.f449249e.width() / this.f449250f.width();
        RectF r101 = this.f449250f;
        float r102 = (0.0f - r101.left) * r112;
        float r103 = (0.0f - r101.top) * r112;
        this.f449255k.reset();
        this.f449255k.postScale(r112, r112);
        this.f449255k.postTranslate(r102, r103);
        this.f449333r.drawBitmap(this.f449330o, this.f449255k, this.f449334s);
        this.f449247c.drawBitmap(this.f449331p, 0.0f, 0.0f, null);
        this.f449334s.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f449247c.drawBitmap(this.f449332q, 0.0f, 0.0f, this.f449334s);
        this.f449334s.setXfermode(null);
        this.f449256l.a(this.f449246b, true);
        return;
    L19:
        if (pfc.a.a(this.f449257m, this.f449337v, this.f449338w, r110.getX(), r110.getY()) == true) goto L20;
        return;
    L25:
        if (this.f449339x == false) goto L32;
        f.i().a(new a(this.f449250f, new RectF(0.0f, 0.0f, (int) this.f449251g.width(), (int) this.f449251g.height()), this.f449335t, this.f449334s, this.f449331p, null));
        return;
    L32:
        return;
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void d(int r100) {
        this.f449336u = r100;
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void e(Bitmap r100) {
        this.f449245a = r100;
    }
}
