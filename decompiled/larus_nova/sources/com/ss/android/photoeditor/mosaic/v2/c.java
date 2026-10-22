package com.ss.android.photoeditor.mosaic.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy;
import com.ss.android.photoeditor.util.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pfc.f;
import tfc.g;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends AbstractMosaicStrategy {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f449401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f449402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bitmap f449403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Canvas f449404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f449405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f449406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float[] f449407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float[] f449408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AbstractMosaicStrategy.Effect f449409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f449410x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f449411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f449412z;

    public static class a extends f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f449413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AbstractMosaicStrategy.SelectionMode f449414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f449415e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f449416f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final RectF f449417g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RectF f449418h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Path f449419i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Paint f449420j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Bitmap f449421k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final com.ss.android.photoeditor.mosaic.v2.a f449422l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public tfc.a f449423m;

        @Override // pfc.f.a
        public final f.b c(f.b r100) {
            return r100;
        }

        @Override // pfc.f.a
        public final Bitmap d() {
            this.f449420j.setXfermode(null);
            Bitmap r100 = Bitmap.createBitmap((int) this.f449418h.width(), (int) this.f449418h.height(), Bitmap.Config.ARGB_4444);
            Canvas r101 = new Canvas(r100);
            Bitmap r102 = Bitmap.createBitmap((int) this.f449418h.width(), (int) this.f449418h.height(), Bitmap.Config.ARGB_4444);
            Canvas r103 = new Canvas(r102);
            this.f449420j.setColor(FakePickerAvatarCreator.BLUE);
            AbstractMosaicStrategy.SelectionMode r104 = this.f449414d;
            if (r104 != AbstractMosaicStrategy.SelectionMode.PATH) goto L6;
            r103.drawPath(this.f449419i, this.f449420j);
        L8:
            Matrix r105 = new Matrix();
            float r106 = this.f449417g.width() / this.f449421k.getWidth();
            r105.postScale(r106, r106);
            RectF r107 = this.f449417g;
            float r108 = r107.left;
            RectF r109 = this.f449418h;
            r105.postTranslate(r108 - r109.left, r107.top - r109.top);
            r101.drawBitmap(this.f449421k, r105, null);
            this.f449420j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            r101.drawBitmap(r102, 0.0f, 0.0f, this.f449420j);
            this.f449420j.setXfermode(null);
            return r100;
        L6:
            if (r104 != AbstractMosaicStrategy.SelectionMode.RECT) goto L8;
            r103.drawRect(Math.min(this.f449415e[0], this.f449416f[0]), Math.min(this.f449415e[1], this.f449416f[1]), Math.max(this.f449415e[0], this.f449416f[0]), Math.max(this.f449415e[1], this.f449416f[1]), this.f449420j);
            goto L8
        }

        @Override // pfc.f.a
        public final boolean i() {
            if (this.f449414d != AbstractMosaicStrategy.SelectionMode.PATH) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // pfc.f.a
        public final void k() {
            tfc.a r100 = this.f449423m;
            MosaicViewV2.d r101 = (MosaicViewV2.d) this.f449422l;
            if (r100 != r101.f449395c.f449376m) goto L5;
            r101.f(null);
        L5:
            tfc.a r102 = this.f449423m;
            if (r102 == null) goto L9;
            MosaicViewV2.d r103 = (MosaicViewV2.d) this.f449422l;
            r103.d(r102);
            r103.a();
            return;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return this.f449418h;
        }

        @Override // pfc.f.a
        public final RectF f() {
            return this.f449417g;
        }

        @Override // pfc.f.a
        public final boolean g() {
            return this.f449413c;
        }

        public a(RectF r100, RectF r101, Path r102, Paint r103, Bitmap r104, AbstractMosaicStrategy.SelectionMode r105, com.ss.android.photoeditor.mosaic.v2.a r110) {
            this.f449413c = true;
            float[] r106 = new float[2];
            this.f449415e = r106;
            float[] r107 = new float[2];
            this.f449416f = r107;
            this.f449417g = new RectF(r100);
            this.f449418h = new RectF(r101);
            this.f449419i = new Path(r102);
            this.f449420j = new Paint(r103);
            this.f449421k = r104;
            this.f449414d = r105;
            this.f449422l = r110;
            if (r105 != AbstractMosaicStrategy.SelectionMode.RECT) goto L6;
            PathMeasure r108 = new PathMeasure(r102, false);
            float r109 = r108.getLength();
            r108.getPosTan(0.0f, r106, null);
            r108.getPosTan(r109, r107, null);
            return;
        }
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void c() {
        this.f449246b = Bitmap.createBitmap((int) this.f449249e.width(), (int) this.f449249e.height(), Bitmap.Config.ARGB_4444);
        this.f449247c = new Canvas(this.f449246b);
        this.f449403q = Bitmap.createBitmap((int) this.f449249e.width(), (int) this.f449249e.height(), Bitmap.Config.ARGB_4444);
        this.f449404r = new Canvas(this.f449403q);
        g();
        this.f449258n = true;
    }

    public final void g() {
        Matrix r100 = new Matrix();
        r100.setScale(this.f449249e.width() / this.f449245a.getWidth(), this.f449249e.height() / this.f449245a.getHeight());
        Bitmap r101 = this.f449245a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L40;
        Bitmap r102 = this.f449245a;
        Bitmap r103 = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), this.f449245a.getHeight(), r100, true);
        this.f449402p = r103;
        if (this.f449409w != AbstractMosaicStrategy.Effect.GAUSSIAN_BLUR) goto L13;
        Context r104 = this.f449257m;
        if (r103 != null) goto L11;
        Bitmap r105 = null;
    L12:
        this.f449402p = r105;
    L14:
        Bitmap r106 = this.f449402p;
        List<ufc.b> r107 = this.f449253i;
        if (r107 != null) goto L17;
        return;
    L17:
        if (r107.isEmpty() == true) goto L42;
        Canvas r108 = new Canvas(r106);
        Path r109 = new Path();
        Paint r110 = new Paint();
        r110.setStyle(Paint.Style.FILL);
        r110.setColor(-65536);
        Bitmap r111 = Bitmap.createBitmap(r106);
        Canvas r112 = new Canvas(r111);
        r112.drawColor(0, PorterDuff.Mode.CLEAR);
        int r113 = r112.getWidth();
        int r114 = r112.getHeight();
        Iterator<ufc.b> r115 = r107.iterator();
    L21:
        if (r115.hasNext() == false) goto L30;
        ufc.b r116 = r115.next();
        r109.reset();
        Iterator<PointF> r117 = r116.f549979a.iterator();
    L24:
        if (r117.hasNext() == false) goto L29;
        PointF r118 = r117.next();
        if (r109.isEmpty() == true) goto L27;
        r109.lineTo(r113 * r118.x, r114 * r118.y);
        goto L24
    L27:
        r109.moveTo(r113 * r118.x, r114 * r118.y);
        goto L24
    L29:
        r109.close();
        r112.drawPath(r109, r110);
        goto L21
    L30:
        r110.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r108.drawBitmap(r111, 0.0f, 0.0f, r110);
        return;
    L42:
        return;
    L11:
        Bitmap r119 = Bitmap.createBitmap(r103.getWidth(), r103.getHeight(), Bitmap.Config.ARGB_8888);
        RenderScript r120 = RenderScript.create(r104);
        Allocation r121 = Allocation.createFromBitmap(r120, r103);
        Allocation r122 = Allocation.createTyped(r120, r121.getType());
        ScriptIntrinsicBlur r123 = ScriptIntrinsicBlur.create(r120, Element.U8_4(r120));
        r123.setRadius(25.0f);
        r123.setInput(r121);
        r123.forEach(r122);
        r122.copyTo(r119);
        r105 = r119;
        goto L12
    L13:
        this.f449402p = g.a(r103);
        goto L14
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void a() {
        super.a();
        com.ss.android.photoeditor.util.b.e(this.f449401o);
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void b(MotionEvent r110) {
        if (this.f449245a != null) goto L5;
        return;
    L5:
        if (this.f449246b == null) goto L83;
        int r100 = r110.getAction();
        if (r100 == 0) goto L61;
        if (r100 == 1) goto L30;
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L30;
        return;
    L16:
        if (this.A == false) goto L18;
    L19:
        this.A = true;
        this.f449406t.lineTo(r110.getX(), r110.getY());
        this.f449408v[0] = r110.getX();
        this.f449408v[1] = r110.getY();
        h(false);
        if (this.f449252h != AbstractMosaicStrategy.SelectionMode.RECT) goto L71;
        com.ss.android.photoeditor.mosaic.v2.a r111 = this.f449248d;
        float[] r101 = this.f449407u;
        float[] r102 = this.f449408v;
        MosaicViewV2.d r112 = (MosaicViewV2.d) r111;
        float r103 = r112.f449395c.f449372i.width() / r112.f449395c.f449381r.width();
        tfc.a r104 = r112.f449394b;
        if (r104 != null) goto L24;
        r112.f449394b = new tfc.a(r112.f449395c, r112.b(r101[0]), r112.c(r101[1]), r112.b(r102[0]), r112.c(r102[1]), r103);
    L25:
        tfc.a r105 = r112.f449394b;
        if (r105.f545813q == true) goto L28;
        r105.f545813q = true;
    L28:
        r112.f(r105);
        r112.f449393a = true;
        r112.a();
        return;
    L24:
        r104.a(r112.b(r101[0]), r112.c(r101[1]), r112.b(r102[0]), r112.c(r102[1]), r103);
        goto L25
    L71:
        return;
    L18:
        if (pfc.a.a(this.f449257m, this.f449411y, this.f449412z, r110.getX(), r110.getY()) == true) goto L19;
        return;
    L30:
        if (this.A == false) goto L41;
        h(true);
        a r113 = new a(this.f449250f, new RectF(0.0f, 0.0f, (int) this.f449251g.width(), (int) this.f449251g.height()), this.f449406t, this.f449405s, this.f449402p, this.f449252h, this.f449248d);
        com.ss.android.photoeditor.mosaic.v2.a r106 = this.f449248d;
        if (r106 == null) goto L73;
        MosaicViewV2.d r107 = (MosaicViewV2.d) r106;
        if (r113.i() == true) goto L39;
        tfc.a r108 = new tfc.a(r107.f449395c, r107.b(r113.f449415e[0]), r107.c(r113.f449415e[1]), r107.b(r113.f449416f[0]), r107.c(r113.f449416f[1]), r107.f449395c.f449372i.width() / r107.f449395c.f449381r.width());
        r113.f449423m = r108;
        ((ArrayList) r107.f449395c.f449378o).add(r108);
        ((HashMap) r107.f449395c.f449377n).put(r108, r113);
        if (r108.f545813q == true) goto L38;
        r108.f545813q = true;
    L38:
        r107.f449393a = true;
        r107.f(r108);
        r107.a();
        r107.f449394b = null;
    L39:
        f.i().a(r113);
        return;
    L73:
        return;
    L41:
        if (this.B == false) goto L47;
        float r109 = r110.getX();
        float r114 = r110.getY();
        MosaicViewV2.d r115 = (MosaicViewV2.d) this.f449248d;
        tfc.a r116 = r115.f449395c.f449376m;
        if (r116 != null) goto L45;
        return;
    L45:
        if (r115.e(r116, r109, r114) == false) goto L76;
        MosaicViewV2.d r117 = (MosaicViewV2.d) this.f449248d;
        r117.d(r116);
        r117.f(null);
        r117.a();
        return;
    L76:
        return;
    L47:
        tfc.a r118 = ((MosaicViewV2.d) this.f449248d).f449395c.f449376m;
        float r119 = r110.getX();
        float r120 = r110.getY();
        MosaicViewV2.d r121 = (MosaicViewV2.d) this.f449248d;
        float r122 = r121.b(r119);
        float r123 = r121.c(r120);
        int r124 = ((ArrayList) r121.f449395c.f449378o).size() - 1;
    L48:
        if (r124 < 0) goto L53;
        tfc.a r125 = (tfc.a) ListProtector.get(r121.f449395c.f449378o, r124);
        r125.getClass();
        RectF r126 = new RectF();
        Path r127 = new Path();
        PointF r128 = r125.f545797a;
        r127.moveTo(r128.x, r128.y);
        PointF r129 = r125.f545798b;
        r127.lineTo(r129.x, r129.y);
        PointF r130 = r125.f545799c;
        r127.lineTo(r130.x, r130.y);
        PointF r131 = r125.f545800d;
        r127.lineTo(r131.x, r131.y);
        r127.close();
        r127.computeBounds(r126, true);
        Region r132 = new Region();
        r132.setPath(r127, new Region((int) r126.left, (int) r126.top, (int) r126.right, (int) r126.bottom));
        if (r132.contains((int) r122, (int) r123) == true) goto L54;
        r124 = r124 - 1;
    L54:
        if (r125 == null) goto L59;
        MosaicViewV2.d r133 = (MosaicViewV2.d) this.f449248d;
        r133.getClass();
        if (r125.f545813q == true) goto L58;
        r125.f545813q = true;
    L58:
        r133.f449393a = true;
        r133.f(r125);
        r133.a();
        return;
    L59:
        if (r118 == null) goto L79;
        MosaicViewV2.d r134 = (MosaicViewV2.d) this.f449248d;
        r134.f(null);
        r134.a();
        return;
    L79:
        return;
    L53:
        r125 = null;
        goto L54
    L61:
        this.A = false;
        this.f449411y = r110.getX();
        this.f449412z = r110.getY();
        this.f449406t.reset();
        this.f449406t.moveTo(r110.getX(), r110.getY());
        this.f449407u[0] = r110.getX();
        this.f449407u[1] = r110.getY();
        this.f449408v[0] = r110.getX();
        this.f449408v[1] = r110.getY();
        this.B = false;
        MosaicViewV2.d r135 = (MosaicViewV2.d) this.f449248d;
        tfc.a r136 = r135.f449395c.f449376m;
        if (r136 != null) goto L64;
        return;
    L64:
        if (r135.e(r136, r110.getX(), r110.getY()) == false) goto L82;
        this.B = true;
        return;
    L82:
        return;
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void d(int r100) {
        this.f449410x = r100;
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void e(Bitmap r100) {
        this.f449245a = r100;
    }

    @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy
    public final void f(List<ufc.b> r100) {
        super.f(r100);
        if (this.f449258n == false) goto L6;
        g();
        return;
    }

    public final void h(boolean r110) {
        if (this.f449401o != null) goto L5;
        this.f449401o = Bitmap.createBitmap((int) this.f449251g.width(), (int) this.f449251g.height(), Bitmap.Config.ARGB_4444);
    L5:
        this.f449405s.reset();
        AbstractMosaicStrategy.SelectionMode r100 = this.f449252h;
        AbstractMosaicStrategy.SelectionMode r101 = AbstractMosaicStrategy.SelectionMode.PATH;
        if (r100 != r101) goto L8;
        this.f449405s.setStyle(Paint.Style.STROKE);
        this.f449405s.setPathEffect(new CornerPathEffect(10.0f));
        this.f449405s.setStrokeWidth(this.f449410x);
        this.f449405s.setStrokeJoin(Paint.Join.ROUND);
        this.f449405s.setStrokeCap(Paint.Cap.ROUND);
    L9:
        this.f449405s.setAntiAlias(true);
        Canvas r102 = new Canvas(this.f449401o);
        r102.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f449405s.setColor(FakePickerAvatarCreator.BLUE);
        AbstractMosaicStrategy.SelectionMode r103 = this.f449252h;
        if (r103 != r101) goto L13;
        r102.drawPath(this.f449406t, this.f449405s);
    L15:
        this.f449247c.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f449404r.drawColor(0, PorterDuff.Mode.CLEAR);
        float r104 = this.f449249e.width() / this.f449250f.width();
        RectF r105 = this.f449250f;
        float r106 = (0.0f - r105.left) * r104;
        float r107 = (0.0f - r105.top) * r104;
        this.f449255k.reset();
        this.f449255k.postScale(r104, r104);
        this.f449255k.postTranslate(r106, r107);
        this.f449404r.drawBitmap(this.f449401o, this.f449255k, this.f449405s);
        this.f449247c.drawBitmap(this.f449402p, 0.0f, 0.0f, null);
        this.f449405s.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f449247c.drawBitmap(this.f449403q, 0.0f, 0.0f, this.f449405s);
        this.f449405s.setXfermode(null);
        this.f449256l.a(this.f449246b, r110);
        return;
    L13:
        if (r103 != AbstractMosaicStrategy.SelectionMode.RECT) goto L15;
        r102.drawRect(Math.min(this.f449407u[0], this.f449408v[0]), Math.min(this.f449407u[1], this.f449408v[1]), Math.max(this.f449407u[0], this.f449408v[0]), Math.max(this.f449407u[1], this.f449408v[1]), this.f449405s);
        goto L15
    L8:
        this.f449405s.setStyle(Paint.Style.FILL_AND_STROKE);
        goto L9
    }

    public c(Context r100, AbstractMosaicStrategy.Effect r101) {
        super(r100);
        this.f449410x = d.b(50);
        this.A = false;
        this.B = false;
        this.f449406t = new Path();
        this.f449407u = new float[2];
        this.f449408v = new float[2];
        this.f449405s = new Paint();
        this.f449252h = AbstractMosaicStrategy.SelectionMode.RECT;
        this.f449409w = r101;
    }
}
