package com.ss.android.photoeditor.mosaic.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pfc.f;
import pfc.g;

/* JADX INFO: loaded from: classes38.dex */
public class MosaicViewV2 extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f449364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f449365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractMosaicStrategy f449366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f449367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f449368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Canvas f449369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f449370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Canvas f449371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f449372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public vfc.a f449373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f449374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f449375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public tfc.a f449376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<tfc.a, com.ss.android.photoeditor.mosaic.v2.c.a> f449377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<tfc.a> f449378o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f449379p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f449380q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RectF f449381r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Matrix f449382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public g f449383t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RectF f449384u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f449385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f449386w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f449387x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f449388y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f.a f449389z;

    public class a implements AbstractMosaicStrategy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MosaicViewV2 f449390a;

        public a(MosaicViewV2 r100) {
            this.f449390a = r100;
        }

        @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy.a
        public final void a(Bitmap r100, boolean r101) {
            MosaicViewV2 r102 = this.f449390a;
            if (r102.f449370g != null) goto L5;
            r102.f449370g = Bitmap.createBitmap(r102.f449368e);
            MosaicViewV2 r103 = this.f449390a;
            r103.f449371h = new Canvas(this.f449390a.f449370g);
        L5:
            this.f449390a.f449371h.drawColor(0, PorterDuff.Mode.CLEAR);
            if (r101 == false) goto L8;
            this.f449390a.f449369f.drawBitmap(r100, new Rect(0, 0, r100.getWidth(), r100.getHeight()), new Rect(0, 0, this.f449390a.f449368e.getWidth(), this.f449390a.f449368e.getHeight()), null);
        L9:
            this.f449390a.invalidate();
            return;
        L8:
            this.f449390a.f449371h.drawBitmap(r100, new Rect(0, 0, r100.getWidth(), r100.getHeight()), new Rect(0, 0, this.f449390a.f449370g.getWidth(), this.f449390a.f449370g.getHeight()), null);
            goto L9
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f449391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MosaicViewV2 f449392b;

        public final void a() {
            MosaicViewV2 r100 = this.f449392b;
            r100.f449384u.set(r100.getImageRect());
            MosaicViewV2 r101 = this.f449392b;
            r101.f449381r.set(r101.f449384u);
            MosaicViewV2 r102 = this.f449392b;
            r102.f449372i = new RectF(0.0f, 0.0f, this.f449392b.f449384u.width(), this.f449392b.f449384u.height());
            MosaicViewV2 r103 = this.f449392b;
            r103.f449374k = Bitmap.createBitmap((int) r103.f449372i.width(), (int) this.f449392b.f449372i.height(), Bitmap.Config.ARGB_4444);
            MosaicViewV2 r104 = this.f449392b;
            r104.f449375l = new Canvas(this.f449392b.f449374k);
            MosaicViewV2 r105 = this.f449392b;
            r105.f449368e = Bitmap.createScaledBitmap(this.f449391a, (int) r105.f449384u.width(), (int) this.f449392b.f449384u.height(), true);
            MosaicViewV2 r106 = this.f449392b;
            r106.f449369f = new Canvas(this.f449392b.f449368e);
            MosaicViewV2 r107 = this.f449392b;
            r107.f449370g = Bitmap.createBitmap(r107.f449368e);
            MosaicViewV2 r108 = this.f449392b;
            r108.f449371h = new Canvas(this.f449392b.f449370g);
            MosaicViewV2 r109 = this.f449392b;
            r109.setStrategy(r109.f449366c);
            MosaicViewV2.j(this.f449392b);
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

        public b(MosaicViewV2 r100, Bitmap r101) {
            this.f449392b = r100;
            this.f449391a = r101;
        }
    }

    public interface c {
    }

    public class d implements com.ss.android.photoeditor.mosaic.v2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f449393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public tfc.a f449394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MosaicViewV2 f449395c;

        public final d a() {
            if (this.f449393a == false) goto L5;
            this.f449395c.l();
        L5:
            this.f449393a = false;
            this.f449395c.invalidate();
            return this;
        }

        public d(MosaicViewV2 r100) {
            this.f449395c = r100;
            this.f449393a = false;
        }

        public final float b(float r100) {
            MosaicViewV2 r101 = this.f449395c;
            return (r100 - r101.f449381r.left) * (r101.f449372i.width() / this.f449395c.f449381r.width());
        }

        public final float c(float r100) {
            MosaicViewV2 r101 = this.f449395c;
            return (r100 - r101.f449381r.top) * (r101.f449372i.height() / this.f449395c.f449381r.height());
        }

        public final d d(tfc.a r100) {
            if (r100 == null) goto L20;
            ((ArrayList) this.f449395c.f449378o).remove(r100);
            if (((HashMap) this.f449395c.f449377n).containsKey(r100) == false) goto L17;
            com.ss.android.photoeditor.mosaic.v2.c.a r101 = (com.ss.android.photoeditor.mosaic.v2.c.a) ((HashMap) this.f449395c.f449377n).get(r100);
            if (r101 == null) goto L16;
            r101.f449413c = false;
            f r102 = f.i();
            r102.getClass();
            if (r101.i() == true) goto L15;
            int r103 = ((ArrayList) r102.f529050b).indexOf(r101);
            if (r103 < 0) goto L15;
        L13:
            if (r103 >= ((ArrayList) r102.f529050b).size()) goto L15;
            ((f.a) ListProtector.get(r102.f529050b, r103)).f529057b = null;
            r103 = r103 + 1;
        L15:
            f.b r104 = f.i().e();
            this.f449395c.o(r104);
        L16:
            ((HashMap) this.f449395c.f449377n).remove(r100);
        L17:
            MosaicViewV2 r105 = this.f449395c;
            if (r105.f449376m != r100) goto L20;
            this.f449393a = true;
            r105.f449376m = null;
        L20:
            return this;
        }

        public final d f(tfc.a r100) {
            MosaicViewV2 r101 = this.f449395c;
            tfc.a r102 = r101.f449376m;
            if (r100 == r102) goto L10;
            this.f449393a = true;
            if (r102 != null) goto L7;
        L9:
            r101.f449376m = r100;
            goto L10
        L7:
            if (r102.f545813q == false) goto L9;
            r102.f545813q = false;
        L10:
            return this;
        }

        public final boolean e(tfc.a r100, float r101, float r102) {
            float r103 = b(r101);
            float r104 = c(r102);
            float r105 = r100.f545802f * 10.0f;
            return new RectF(r100.f545797a.x - com.ss.android.photoeditor.util.d.a(r105), r100.f545797a.y - com.ss.android.photoeditor.util.d.a(r105), r100.f545797a.x + com.ss.android.photoeditor.util.d.a(r105), r100.f545797a.y + com.ss.android.photoeditor.util.d.a(r105)).contains(r103, r104);
        }
    }

    public RectF getImageRect() {
        RectF r100 = new RectF();
        float r101 = getDrawable().getIntrinsicWidth();
        float r102 = getDrawable().getIntrinsicHeight();
        float r103 = getWidth();
        float r104 = getHeight();
        Matrix r105 = getImageMatrix();
        r105.getValues(this.f449387x);
        float[] r106 = this.f449387x;
        float r107 = r106[0];
        r105.getValues(r106);
        int r108 = (int) (r101 * r107);
        int r109 = (int) (r102 * this.f449387x[4]);
        if (Math.abs(r108 - r103) >= 3.0f) goto L10;
        if (r109 > 0) goto L7;
        r109 = 1;
    L7:
        if (r103 > 0.0f) goto L9;
        r103 = 1.0f;
    L9:
        float r110 = r109;
        float r111 = (r104 - r110) / 2.0f;
        r100.set(0.0f, (int) r111, (int) r103, (int) (r111 + r110));
    L16:
        return r100;
    L10:
        if (r108 > 0) goto L13;
        r108 = 1;
    L13:
        if (r104 > 0.0f) goto L15;
        r104 = 1.0f;
    L15:
        float r112 = r108;
        float r113 = (r103 - r112) / 2.0f;
        r100.set((int) r113, 0.0f, (int) (r113 + r112), (int) r104);
        goto L16
    }

    public final void init() {
        setBackgroundColor(-16777216);
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f449382s = new Matrix();
        this.f449379p = new d(this);
        this.f449378o = new ArrayList();
        this.f449377n = new HashMap();
        this.f449372i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.f449381r = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public final void l() {
        if (this.f449374k != null) goto L5;
        this.f449374k = Bitmap.createBitmap(this.f449368e);
        this.f449375l = new Canvas(this.f449374k);
    L5:
        int r100 = 0;
        this.f449375l.drawColor(0, PorterDuff.Mode.CLEAR);
        tfc.a r101 = this.f449376m;
        if (r101 == null) goto L19;
        Canvas r102 = this.f449375l;
        if (r101.f545813q == false) goto L20;
        r102.save();
        PointF r103 = r101.f545805i;
        float r104 = r103.x;
        float r105 = r101.f545811o;
        float r106 = r101.f545802f;
        float r107 = r105 * r106;
        float r108 = r103.y;
        float r109 = r101.f545812p * r106;
        RectF r110 = new RectF(r104 - r107, r108 - r109, r104 + r107, r108 + r109);
        r101.f545808l.setAntiAlias(true);
        r101.f545808l.setColor(-1);
        r101.f545808l.setStyle(Paint.Style.STROKE);
        float r111 = (com.ss.android.photoeditor.util.d.a(4.0f) * r101.f545802f) * r101.f545803g;
        r101.f545808l.setStrokeWidth(r111);
        float r112 = r101.f545804h;
        PointF r113 = r101.f545805i;
        r102.rotate(r112, r113.x, r113.y);
        r102.drawRoundRect(r110, com.ss.android.photoeditor.util.d.b(1), com.ss.android.photoeditor.util.d.b(1), r101.f545808l);
        r101.f545808l.setStrokeWidth(0.25f);
        r101.f545808l.setColor(r101.f545810n);
        float r114 = r111 / 2.0f;
        r102.drawRoundRect(new RectF(r110.left - r114, r110.top - r114, r110.right + r114, r110.bottom + r114), com.ss.android.photoeditor.util.d.b(1), com.ss.android.photoeditor.util.d.b(1), r101.f545808l);
        r102.drawRoundRect(new RectF(r110.left + r114, r110.top + r114, r110.right - r114, r110.bottom - r114), com.ss.android.photoeditor.util.d.b(1), com.ss.android.photoeditor.util.d.b(1), r101.f545808l);
        r102.restore();
    L11:
        if (r100 >= 7) goto L14;
        PointF r115 = r101.f545805i;
        float r116 = r115.x;
        float r117 = tfc.a.f545795s[r100] * r101.f545811o;
        float r118 = r101.f545802f;
        float r119 = r116 + (r117 * r118);
        float r120 = r115.y + ((tfc.a.f545796t[r100] * r101.f545812p) * r118);
        r102.save();
        r101.f545806j.reset();
        r101.f545806j.setAntiAlias(true);
        r101.f545806j.setStyle(Paint.Style.FILL);
        r101.f545806j.setColor(-1);
        float r121 = r101.f545804h;
        PointF r122 = r101.f545805i;
        r102.rotate(r121, r122.x, r122.y);
        r102.drawCircle(r119, r120, (com.ss.android.photoeditor.util.d.b(7) * r101.f545802f) * r101.f545803g, r101.f545806j);
        r101.f545806j.setColor(r101.f545809m);
        r102.drawCircle(r119, r120, (com.ss.android.photoeditor.util.d.b(4) * r101.f545802f) * r101.f545803g, r101.f545806j);
        r101.f545806j.setStyle(Paint.Style.STROKE);
        r101.f545806j.setColor(r101.f545810n);
        r101.f545806j.setStrokeWidth(0.25f);
        r102.drawCircle(r119, r120, (com.ss.android.photoeditor.util.d.b(7) * r101.f545802f) * r101.f545803g, r101.f545806j);
        r102.restore();
        r100 = r100 + 1;
        goto L11
    L14:
        if (r101.f545801e == null) goto L21;
        r101.f545807k.setAntiAlias(true);
        r101.f545807k.setFilterBitmap(true);
        Bitmap r123 = r101.f545801e;
        PointF r124 = r101.f545805i;
        float r125 = r124.x;
        float r126 = r101.f545811o;
        float r127 = r101.f545802f;
        float r128 = r125 - (r126 * r127);
        float r129 = r124.y - (r101.f545812p * r127);
        float r130 = com.ss.android.photoeditor.util.d.a((r101.f545802f * 24.0f) * r101.f545803g) / r123.getWidth();
        float r131 = com.ss.android.photoeditor.util.d.a((r101.f545802f * 24.0f) * r101.f545803g) / 2.0f;
        float r132 = com.ss.android.photoeditor.util.d.a((r101.f545802f * 24.0f) * r101.f545803g) / 2.0f;
        r101.f545814r.reset();
        r101.f545814r.postScale(r130, r130);
        r101.f545814r.postTranslate(r128 - r131, r129 - r132);
        Matrix r133 = r101.f545814r;
        float r134 = r101.f545804h;
        PointF r135 = r101.f545805i;
        r133.postRotate(r134, r135.x, r135.y);
        r102.drawBitmap(r123, r101.f545814r, r101.f545807k);
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void n() {
        RectF r100 = this.f449364a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f449365b == true) goto L7;
        g r101 = this.f449383t;
        RectF r102 = new RectF(this.f449364a);
        RectF r103 = this.f449384u;
        r101.f529070f.b(r102, r103, 250);
        this.f449364a = null;
        return;
    L7:
        this.f449381r.set(r100);
        this.f449364a = null;
    }

    private Bitmap getStrategyBaseBmp() {
        f.b r100 = f.i().d();
        RectF r101 = new RectF(r100.f529059b);
        RectF r102 = new RectF(r100.f529058a);
        float r103 = r100.f529062e.getWidth() / r101.width();
        com.ss.android.photoeditor.util.b.f(r101, 0.0f, 0.0f, r103, r103);
        com.ss.android.photoeditor.util.b.f(r102, 0.0f, 0.0f, r103, r103);
        Bitmap r104 = Bitmap.createBitmap((int) r102.width(), (int) r102.height(), Bitmap.Config.ARGB_4444);
        new Canvas(r104).drawBitmap(r100.f529062e, r101.left - r102.left, r101.top - r102.top, null);
        Matrix r110 = new Matrix();
        r110.postRotate(r100.f529060c);
        return Bitmap.createBitmap(r104, 0, 0, r104.getWidth(), r104.getHeight(), r110, true);
    }

    public RectF getLocation() {
        return this.f449381r;
    }

    public MosaicViewV2(Context r100) {
        super(r100);
        this.f449387x = new float[9];
        this.f449388y = new a(this);
        init();
    }

    public static void j(MosaicViewV2 r110) {
        r110.getClass();
        f.b r100 = f.i().d();
        RectF r101 = new RectF(r100.f529058a);
        RectF r102 = new RectF(r100.f529059b);
        RectF r103 = new RectF(0.0f, 0.0f, r110.f449384u.width(), r110.f449384u.height());
        int r104 = r100.f529060c;
        RectF r105 = new RectF(r110.f449373j.f554632a);
        RectF r106 = new RectF(r110.f449373j.f554633b);
        RectF r107 = new RectF(r110.f449373j.f554635d);
        vfc.a r108 = r110.f449373j;
        int r109 = r108.f554634c;
        r108.f554632a = new RectF(r101);
        vfc.a r111 = r110.f449373j;
        r111.f554633b = new RectF(r102);
        vfc.a r112 = r110.f449373j;
        r112.f554634c = r104;
        r112.f554635d = new RectF(r103);
        if (((r109 / 90) % 2) != 0) goto L5;
        float r113 = r105.width();
        float r114 = r107.width();
    L6:
        float r115 = r113 / r114;
        com.ss.android.photoeditor.util.b.f(r107, 0.0f, 0.0f, r115, r115);
        r110.q(r115);
        int r116 = -r109;
        com.ss.android.photoeditor.util.b.d(r107, r116, 0.0f, 0.0f);
        r110.p(r116);
        float r117 = r105.centerX() - r107.centerX();
        float r118 = r105.centerY() - r107.centerY();
        r107.offset(r117, r118);
        r110.m(r117, r118);
        float r119 = r102.width() / r106.width();
        com.ss.android.photoeditor.util.b.f(r105, 0.0f, 0.0f, r119, r119);
        com.ss.android.photoeditor.util.b.f(r106, 0.0f, 0.0f, r119, r119);
        r110.q(r119);
        float r120 = r102.left - r106.left;
        float r121 = r102.top - r106.top;
        r105.offset(r120, r121);
        r106.offset(r120, r121);
        r110.m(r120, r121);
        if (((r104 / 90) % 2) != 0) goto L9;
        float r122 = r103.width();
        float r123 = r101.width();
    L10:
        float r124 = r122 / r123;
        com.ss.android.photoeditor.util.b.f(r101, 0.0f, 0.0f, r124, r124);
        com.ss.android.photoeditor.util.b.f(r105, 0.0f, 0.0f, r124, r124);
        r110.q(r124);
        com.ss.android.photoeditor.util.b.d(r101, r104, 0.0f, 0.0f);
        com.ss.android.photoeditor.util.b.d(r105, r104, 0.0f, 0.0f);
        r110.p(r104);
        float r125 = r103.centerX() - r101.centerX();
        float r126 = r103.centerY() - r101.centerY();
        r101.offset(r125, r126);
        r105.offset(r125, r126);
        r110.m(r125, r126);
        r110.l();
        return;
    L9:
        r122 = r103.height();
        r123 = r101.width();
        goto L10
    L5:
        r113 = r105.height();
        r114 = r107.width();
        goto L6
    }

    public final void o(f.b r100) {
        Bitmap r101 = f.i().h();
        setImageBitmap(r101);
        if (r100.f529061d == false) goto L5;
        com.ss.android.photoeditor.util.c.a(this, new b(this, r101));
        invalidate();
        return;
    L5:
        this.f449368e = Bitmap.createScaledBitmap(r101, (int) this.f449384u.width(), (int) this.f449384u.height(), true);
        this.f449369f = new Canvas(this.f449368e);
        this.f449370g = Bitmap.createBitmap(this.f449368e);
        this.f449371h = new Canvas(this.f449370g);
        setStrategy(this.f449366c);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawColor(-16777216);
        com.ss.android.photoeditor.util.b.g(this.f449382s, this.f449368e, this.f449381r);
        r100.drawBitmap(this.f449368e, this.f449382s, null);
        Bitmap r101 = this.f449370g;
        if (r101 == null) goto L5;
        r100.drawBitmap(r101, this.f449382s, null);
    L5:
        Bitmap r102 = this.f449374k;
        if (r102 == null) goto L9;
        r100.drawBitmap(r102, this.f449382s, null);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f449385v == false) goto L32;
        this.f449383t.a(r100);
        c r101 = this.f449386w;
        if (r101 == null) goto L32;
        com.ss.android.photoeditor.mosaic.v2.b r102 = (com.ss.android.photoeditor.mosaic.v2.b) r101;
        if (r100.getPointerCount() != 1) goto L32;
        int r103 = r100.getAction();
        if (r103 == 0) goto L31;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L32;
        r102.f449396a = false;
        r102.f449400e.f449359k.b();
        goto L32
    L19:
        if (r102.f449399d == false) goto L21;
    L22:
        r102.f449399d = true;
        r102.f449396a = true;
        r102.f449400e.f449359k.a();
        goto L32
    L21:
        if (pfc.a.a(r102.f449400e.getContext(), r102.f449397b, r102.f449398c, r100.getX(), r100.getY()) == false) goto L32;
    L24:
        if (r102.f449396a == false) goto L26;
        r102.f449400e.f449359k.b();
        r102.f449396a = false;
        goto L32
    L26:
        pfc.c r104 = r102.f449400e.f449359k;
        if (r104.f529038b == false) goto L29;
        r104.a();
    L30:
        f r105 = f.i();
        RectF r106 = r102.f449400e.f449353e.getLocation();
        float r107 = r100.getX();
        float r108 = r100.getY();
        r105.getClass();
        f.b(r106, r107, r108);
        goto L32
    L29:
        r104.b();
        goto L30
    L31:
        r102.f449396a = false;
        r102.f449399d = false;
        r102.f449397b = r100.getX();
        r102.f449398c = r100.getY();
    L32:
        return true;
    }

    public final void p(int r100) {
        Iterator r101 = ((ArrayList) this.f449378o).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        tfc.a r102 = (tfc.a) r101.next();
        com.ss.android.photoeditor.util.b.c(r102.f545805i, 0.0f, 0.0f, r100);
        r102.f545804h += r100;
        r102.b();
        goto L4
    }

    public final void q(float r100) {
        Iterator r101 = ((ArrayList) this.f449378o).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((tfc.a) r101.next()).update(0.0f, 0.0f, r100);
        goto L4
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        this.f449367d = r100;
        AbstractMosaicStrategy r101 = this.f449366c;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public void setMotionEventListener(c r100) {
        this.f449386w = r100;
    }

    public void setPaintSize(int r100) {
        this.f449380q = r100;
        AbstractMosaicStrategy r101 = this.f449366c;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public void setStrategy(AbstractMosaicStrategy r100) {
        this.f449366c = r100;
        r100.f449249e = this.f449384u;
        r100.f449248d = this.f449379p;
        r100.f449256l = this.f449388y;
        r100.e(getStrategyBaseBmp());
        this.f449366c.d(this.f449380q);
        AbstractMosaicStrategy r101 = this.f449366c;
        r101.f449250f = this.f449381r;
        r101.f449251g = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f449366c.c();
    }

    public MosaicViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449387x = new float[9];
        this.f449388y = new a(this);
        init();
    }

    public final void m(float r100, float r101) {
        Iterator r102 = ((ArrayList) this.f449378o).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        tfc.a r103 = (tfc.a) r102.next();
        PointF r104 = r103.f545805i;
        r103.update(r104.x + r100, r104.y + r101, r103.f545804h, r103.f545802f);
        goto L4
    }

    public MosaicViewV2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449387x = new float[9];
        this.f449388y = new a(this);
        init();
    }
}
