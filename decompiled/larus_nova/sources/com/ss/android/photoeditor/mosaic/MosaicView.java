package com.ss.android.photoeditor.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import pfc.f;
import pfc.g;

/* JADX INFO: loaded from: classes38.dex */
public class MosaicView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f449286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f449287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractMosaicStrategy f449288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f449289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f449290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Canvas f449291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f449293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Matrix f449294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f449295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f449296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f449297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f449298m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f449299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f449300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f.a f449301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f449302q;

    public class a implements AbstractMosaicStrategy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MosaicView f449303a;

        public a(MosaicView r100) {
            this.f449303a = r100;
        }

        @Override // com.ss.android.photoeditor.mosaic.AbstractMosaicStrategy.a
        public final void a(Bitmap r100, boolean r101) {
            this.f449303a.f449291f.drawBitmap(r100, new Rect(0, 0, r100.getWidth(), r100.getHeight()), new Rect(0, 0, this.f449303a.f449290e.getWidth(), this.f449303a.f449290e.getHeight()), null);
            this.f449303a.invalidate();
        }
    }

    public interface b {
    }

    public RectF getImageRect() {
        RectF r100 = new RectF();
        float r101 = getDrawable().getIntrinsicWidth();
        float r102 = getDrawable().getIntrinsicHeight();
        float r103 = getWidth();
        float r104 = getHeight();
        Matrix r105 = getImageMatrix();
        r105.getValues(this.f449299n);
        float[] r106 = this.f449299n;
        float r107 = r106[0];
        r105.getValues(r106);
        int r108 = (int) (r101 * r107);
        int r109 = (int) (r102 * this.f449299n[4]);
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
        this.f449294i = new Matrix();
    }

    public final void l() {
        RectF r100 = this.f449286a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f449287b == true) goto L7;
        g r101 = this.f449295j;
        RectF r102 = new RectF(this.f449286a);
        RectF r103 = this.f449296k;
        r101.f529070f.b(r102, r103, 250);
        this.f449286a = null;
        return;
    L7:
        this.f449293h.set(r100);
        this.f449286a = null;
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

    public final void m() {
        Bitmap r100 = f.i().h();
        setImageBitmap(r100);
        this.f449290e = j(r100);
        this.f449291f = new Canvas(this.f449290e);
        setStrategy(this.f449288c);
        invalidate();
    }

    public RectF getLocation() {
        return this.f449293h;
    }

    public MosaicView(Context r100) {
        super(r100);
        this.f449299n = new float[9];
        this.f449300o = new a(this);
        this.f449302q = false;
        init();
    }

    public final Bitmap j(Bitmap r100) {
        if (this.f449302q == false) goto L5;
        int r101 = r100.getWidth();
    L7:
        if (this.f449302q == false) goto L9;
        int r102 = r100.getHeight();
    L11:
        return Bitmap.createScaledBitmap(r100, r101, r102, true);
    L9:
        r102 = (int) this.f449296k.height();
        goto L11
    L5:
        r101 = (int) this.f449296k.width();
        goto L7
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawColor(-16777216);
        com.ss.android.photoeditor.util.b.g(this.f449294i, this.f449290e, this.f449293h);
        r100.drawBitmap(this.f449290e, this.f449294i, null);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f449297l == false) goto L32;
        this.f449295j.a(r100);
        b r101 = this.f449298m;
        if (r101 == null) goto L32;
        com.ss.android.photoeditor.mosaic.b r102 = (com.ss.android.photoeditor.mosaic.b) r101;
        if (r100.getPointerCount() != 1) goto L32;
        int r103 = r100.getAction();
        if (r103 == 0) goto L31;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L32;
        r102.f449325a = false;
        r102.f449329e.f449280q.b();
        goto L32
    L19:
        if (r102.f449328d == false) goto L21;
    L22:
        r102.f449328d = true;
        r102.f449325a = true;
        r102.f449329e.f449280q.a();
        goto L32
    L21:
        if (pfc.a.a(r102.f449329e.getContext(), r102.f449326b, r102.f449327c, r100.getX(), r100.getY()) == false) goto L32;
    L24:
        if (r102.f449325a == false) goto L26;
        r102.f449329e.f449280q.b();
        r102.f449325a = false;
        goto L32
    L26:
        pfc.c r104 = r102.f449329e.f449280q;
        if (r104.f529038b == false) goto L29;
        r104.a();
    L30:
        f r105 = f.i();
        RectF r106 = r102.f449329e.f449270g.getLocation();
        float r107 = r100.getX();
        float r108 = r100.getY();
        r105.getClass();
        f.b(r106, r107, r108);
        goto L32
    L29:
        r104.b();
        goto L30
    L31:
        r102.f449325a = false;
        r102.f449328d = false;
        r102.f449326b = r100.getX();
        r102.f449327c = r100.getY();
    L32:
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        this.f449289d = r100;
        AbstractMosaicStrategy r101 = this.f449288c;
        if (r101 == null) goto L6;
        r101.e(r100);
        return;
    }

    public void setLongImageZoomEnabled(boolean r100) {
        this.f449302q = r100;
    }

    public void setMotionEventListener(b r100) {
        this.f449298m = r100;
    }

    public void setPaintSize(int r100) {
        this.f449292g = r100;
        AbstractMosaicStrategy r101 = this.f449288c;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public void setStrategy(AbstractMosaicStrategy r100) {
        this.f449288c = r100;
        r100.f449249e = this.f449296k;
        r100.f449256l = this.f449300o;
        r100.e(getStrategyBaseBmp());
        this.f449288c.d(this.f449292g);
        AbstractMosaicStrategy r101 = this.f449288c;
        r101.f449250f = this.f449293h;
        r101.f449251g = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.f449288c.c();
    }

    public MosaicView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449299n = new float[9];
        this.f449300o = new a(this);
        this.f449302q = false;
        init();
    }

    public MosaicView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449299n = new float[9];
        this.f449300o = new a(this);
        this.f449302q = false;
        init();
    }
}
