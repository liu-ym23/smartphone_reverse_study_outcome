package com.ss.android.photoeditor.crop_rotate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.util.c;
import com.ss.android.photoeditor.util.d;
import pfc.f;
import qfc.j;
import qfc.w;
import qfc.x;
import qfc.y;

/* JADX INFO: loaded from: classes38.dex */
public class PhotoClipView extends AppCompatImageView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f449171p = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f449172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f449173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f449174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f449175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f449176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public qfc.a f449177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f449178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f449179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f449180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f449181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f449182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y f449183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f449184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f449185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f449186o;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f.b f449187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PhotoClipView f449188b;

        public final void a() {
            PhotoClipView r100 = this.f449188b;
            r100.f449180i.set(PhotoClipView.l(r100));
            RectF r101 = this.f449188b.f449180i;
            com.ss.android.photoeditor.util.b.d(r101, this.f449187a.f529060c, r101.centerX(), this.f449188b.f449180i.centerY());
            PhotoClipView r102 = this.f449188b;
            qfc.a r103 = r102.f449177f;
            RectF r104 = r102.f449180i;
            RectF r105 = PhotoClipView.j(r102);
            r103.getClass();
            qfc.a.a(r104, r105);
            RectF r106 = new RectF(this.f449187a.f529058a);
            RectF r107 = new RectF(this.f449187a.f529059b);
            com.ss.android.photoeditor.util.b.d(r106, this.f449187a.f529060c, 0.0f, 0.0f);
            com.ss.android.photoeditor.util.b.d(r107, this.f449187a.f529060c, 0.0f, 0.0f);
            RectF r108 = new RectF(r106);
            this.f449188b.f449175d.g(r108);
            float r109 = r108.width() / r106.width();
            com.ss.android.photoeditor.util.b.f(r106, 0.0f, 0.0f, r109, r109);
            com.ss.android.photoeditor.util.b.f(r107, 0.0f, 0.0f, r109, r109);
            float r110 = this.f449188b.f449180i.centerX() - r106.centerX();
            float r111 = this.f449188b.f449180i.centerY() - r106.centerY();
            r107.offset(r110, r111);
            r106.offset(r110, r111);
            com.ss.android.photoeditor.util.b.d(r107, -this.f449187a.f529060c, r107.centerX(), r107.centerY());
            int r112 = this.f449187a.f529060c;
            PointF r113 = new PointF(r107.centerX(), r107.centerY());
            RectF r114 = new RectF(r107);
            y r115 = this.f449188b.f449183l;
            r115.getClass();
            r115.f532854a.set(r114);
            r115.f532856c.set(r113);
            r115.f532855b = r112;
            y.a r116 = r115.f532858e;
            if (r116 == null) goto L5;
            ((j.a) r116).f532797a.f532796e = true;
        L5:
            w r117 = this.f449188b.f449175d;
            r117.f532827j.set(r106);
            float r118 = r117.f532829l.centerX() - r117.f532827j.centerX();
            float r119 = r117.f532829l.centerY() - r117.f532827j.centerY();
            r117.f532827j.offset(r118, r119);
            if (((x.d) r117.f532831n).f532849a.f532845b.getWidth() > 0) goto L8;
            int r120 = 1;
        L10:
            if (((x.d) r117.f532831n).f532849a.f532845b.getHeight() > 0) goto L12;
            int r121 = 1;
        L13:
            r117.f532839v = Bitmap.createBitmap(r120, r121, Bitmap.Config.ARGB_8888);
            r117.f532840w = new Canvas(r117.f532839v);
            r117.h();
            this.f449188b.f449176e.set(r106);
            PhotoClipView r122 = this.f449188b;
            if (r122.f449173b == null) goto L17;
            r122.f449172a = true;
            RectF r123 = new RectF(r122.f449173b);
            RectF r124 = new RectF(r122.f449176e);
            RectF r125 = new RectF(r122.f449183l.a());
            float r126 = r123.width() / r124.width();
            com.ss.android.photoeditor.util.b.f(r124, 0.0f, 0.0f, r126, r126);
            com.ss.android.photoeditor.util.b.f(r125, 0.0f, 0.0f, r126, r126);
            r125.offset(r123.centerX() - r124.centerX(), r123.centerY() - r124.centerY());
            qfc.a r127 = r122.f449177f;
            RectF r128 = new RectF(r122.f449183l.a());
            r127.f532767i.b(r125, r128, 250);
            r122.f449173b = null;
            return;
        L17:
            return;
        L12:
            r121 = ((x.d) r117.f532831n).f532849a.f532845b.getHeight();
            goto L13
        L8:
            r120 = ((x.d) r117.f532831n).f532849a.f532845b.getWidth();
            goto L10
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

        public a(PhotoClipView r100, f.b r101) {
            this.f449188b = r100;
            this.f449187a = r101;
        }
    }

    public static class b extends f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f449189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RectF f449190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RectF f449191e;

        @Override // pfc.f.a
        public final Bitmap d() {
            return null;
        }

        @Override // pfc.f.a
        public final RectF e() {
            return null;
        }

        @Override // pfc.f.a
        public final RectF f() {
            return null;
        }

        public final String toString() {
            return "ClipAndRotateEditAction : " + this.f449191e.toString();
        }

        @Override // pfc.f.a
        public final f.b c(f.b r100) {
            r100.f529061d = true;
            r100.f529060c = this.f449189c;
            r100.f529058a = this.f449191e;
            r100.f529059b = this.f449190d;
            Log.d("ClipAndRotateEditAction", "show= " + this.f449191e);
            return r100;
        }

        public b(RectF r100, RectF r101, int r102) {
            this.f449189c = r102;
            RectF r103 = new RectF(r100);
            this.f449190d = r103;
            RectF r104 = new RectF(r101);
            this.f449191e = r104;
            int r105 = -r102;
            com.ss.android.photoeditor.util.b.d(r103, r105, 0.0f, 0.0f);
            com.ss.android.photoeditor.util.b.d(r104, r105, 0.0f, 0.0f);
        }
    }

    static {
        f449171p = d.b(90);
    }

    private RectF getScreenShowRegion() {
        RectF r100 = new RectF();
        r100.left = d.a(20.5f);
        r100.right = getWidth() - d.a(20.5f);
        r100.top = d.a(26.5f);
        r100.bottom = getHeight() - d.a(26.5f);
        return r100;
    }

    public RectF getClipRect() {
        w r100 = this.f449175d;
        if (r100 == null) goto L7;
        return new RectF(r100.f532827j);
    L7:
        return this.f449173b;
    }

    public RectF getPhotoImitationRect() {
        return this.f449183l.a();
    }

    public int getTotalRotateAngle() {
        return this.f449183l.f532855b;
    }

    public final void m() {
        if (this.f449178g != null) goto L5;
        return;
    L5:
        f.b r100 = f.i().c();
        Bitmap r101 = Bitmap.createBitmap(r100.f529062e);
        new Canvas(r101).drawBitmap(r100.f529063f, 0.0f, 0.0f, null);
        setImageBitmap(r101);
        this.f449178g.f532792a = r101;
        c.a(this, new a(this, r100));
        invalidate();
    }

    public RectF getClipImitationRect() {
        return this.f449176e;
    }

    public PhotoClipView(Context r100) {
        super(r100);
        new Paint();
        this.f449181j = new float[9];
        this.f449184m = false;
        this.f449185n = false;
        this.f449186o = -1.0f;
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public static /* synthetic */ RectF j(PhotoClipView r100) {
        return r100.getScreenShowRegion();
    }

    public static RectF l(PhotoClipView r100) {
        r100.getClass();
        RectF r101 = new RectF();
        float r102 = r100.getDrawable().getIntrinsicWidth();
        float r103 = r100.getDrawable().getIntrinsicHeight();
        float r104 = r100.getWidth();
        float r105 = r100.getHeight();
        Log.d("PhotoClipView", "imageRect imageWidth:viewWidth " + r102 + ":" + r104);
        Matrix r106 = r100.getImageMatrix();
        r106.getValues(r100.f449181j);
        float[] r107 = r100.f449181j;
        float r108 = r107[0];
        r106.getValues(r107);
        int r109 = (int) (r103 * r100.f449181j[4]);
        float r110 = (int) (r102 * r108);
        if (Math.abs(r110 - r104) >= 3.0f) goto L5;
        float r111 = r109;
        float r112 = (r105 - r111) / 2.0f;
        r101.set(0.0f, (int) r112, (int) r104, (int) (r112 + r111));
    L6:
        float r113 = r101.centerX();
        float r114 = r101.centerY();
        float r115 = Math.min(((r101.height() - d.b(26)) - d.b(26)) / r101.height(), ((r101.width() - d.b(20)) - d.b(20)) / r101.width());
        r101.left = (int) (((r101.left - r113) * r115) + r113);
        r101.right = (int) (((r101.right - r113) * r115) + r113);
        r101.top = (int) (((r101.top - r114) * r115) + r114);
        r101.bottom = (int) (((r101.bottom - r114) * r115) + r114);
        return r101;
    L5:
        float r116 = (r104 - r110) / 2.0f;
        r101.set((int) r116, 0.0f, (int) (r116 + r110), (int) r105);
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        r110.drawColor(-16777216);
        j r100 = this.f449178g;
        Bitmap r101 = r100.f532792a;
        r100.f532794c.reset();
        j.b r102 = r100.f532795d;
        if (r102.f532798a == 0.0f) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L11;
    L12:
        float r104 = r100.f532793b.f532854a.width() / r100.f532792a.getWidth();
        float r105 = r100.f532793b.f532854a.height() / r100.f532792a.getHeight();
        Log.i("DrawHelper", "scaleX = " + r104 + " ， scaleY = " + r105);
        j.b r106 = r100.f532795d;
        r106.f532798a = r104;
        r106.f532799b = r105;
        r100.f532796e = false;
    L13:
        y r107 = r100.f532793b;
        float r108 = r107.f532856c.x - (r107.f532854a.width() / 2.0f);
        y r109 = r100.f532793b;
        float r111 = r109.f532856c.y - (r109.f532854a.height() / 2.0f);
        Log.i("DrawHelper", "size width = " + r100.f532793b.f532854a.width() + " , height = " + r100.f532793b.f532854a.height());
        Log.i("DrawHelper", "dx = " + r108 + " , dy = " + r111 + "centerX = " + r100.f532793b.f532856c.x);
        Matrix r112 = r100.f532794c;
        j.b r113 = r100.f532795d;
        r112.postScale(r113.f532798a, r113.f532799b);
        r100.f532794c.postTranslate(r108, r111);
        Matrix r114 = r100.f532794c;
        y r115 = r100.f532793b;
        float r116 = r115.f532855b;
        PointF r117 = r115.f532856c;
        r114.postRotate(r116, r117.x, r117.y);
        r110.drawBitmap(r101, r100.f532794c, null);
        if (this.f449172a == true) goto L21;
        w r118 = this.f449175d;
        r118.getClass();
        r110.save();
        r118.f532840w.drawColor(0, PorterDuff.Mode.CLEAR);
        r118.f532835r.setAntiAlias(true);
        r118.f532835r.setColor(-1);
        r118.f532835r.setStyle(Paint.Style.STROKE);
        r118.f532835r.setStrokeWidth(d.b(2));
        r118.f532835r.setShadowLayer(d.b(2), 0.0f, 0.0f, ColorProtector.parseColor("#99000000"));
        if (r118.f532838u == false) goto L18;
        r118.f532840w.drawRect(r118.f532830m, r118.f532835r);
        r118.c(r118.f532840w, r118.f532830m);
        r118.d(r118.f532840w, r118.f532830m);
        r110.rotate(r118.f532841x, r118.f532827j.centerX(), r118.f532827j.centerY());
    L19:
        r110.drawBitmap(r118.f532839v, 0.0f, 0.0f, null);
        r110.restore();
        return;
    L18:
        r118.f532840w.drawRect(r118.f532827j, r118.f532835r);
        r118.d(r118.f532840w, r118.f532827j);
        r118.c(r118.f532840w, r118.f532827j);
        goto L19
    L21:
        return;
    L11:
        if (r100.f532796e == false) goto L13;
    L5:
        if (r102.f532799b != 0.0f) goto L7;
        r103 = true;
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f449182k == true) goto L5;
    L63:
        return true;
    L5:
        if (this.f449184m == true) goto L63;
        qfc.a r101 = this.f449177f;
        if (r101.f532769k == false) goto L63;
        qfc.a.d r102 = r101.f532768j;
        qfc.a.d r103 = null;
        if (r102 != null) goto L48;
        if (r100.getPointerCount() != 1) goto L42;
        w r104 = ((x.c) r101.f532765g).f532848a.f532845b.f449175d;
        float r105 = r100.getX();
        float r106 = r100.getY();
        if (r104.f532819b.contains(r105, r106) == false) goto L17;
    L36:
        boolean r107 = true;
    L38:
        if (r107 == false) goto L40;
        r103 = r101.f532775q;
    L44:
        r101.f532768j = r103;
        if (r103 == null) goto L57;
        r103.a(r100);
    L57:
        if (r100.getAction() != 3) goto L59;
    L62:
        r101.f532772n = false;
        goto L63
    L59:
        if (r100.getAction() == 1) goto L62;
        r101.f532772n = true;
        goto L63
    L40:
        r103 = r101.f532774p;
        goto L44
    L17:
        if (r104.f532820c.contains(r105, r106) == true) goto L36;
        if (r104.f532821d.contains(r105, r106) == true) goto L36;
        if (r104.f532822e.contains(r105, r106) == true) goto L36;
        if (r104.f532823f.contains(r105, r106) == true) goto L36;
        if (r104.f532824g.contains(r105, r106) == true) goto L36;
        if (r104.f532825h.contains(r105, r106) == true) goto L36;
        if (r104.f532826i.contains(r105, r106) == true) goto L36;
        r107 = false;
        goto L38
    L42:
        if (r100.getPointerCount() != 2) goto L44;
        r103 = r101.f532773o;
        goto L44
    L48:
        if (r102.getType() == 1) goto L50;
    L52:
        r101.f532768j.a(r100);
    L54:
        if (r100.getAction() != 1) goto L57;
        r101.f532768j = null;
        goto L57
    L50:
        if (r100.getPointerCount() != 2) goto L52;
        MotionEvent r108 = MotionEvent.obtain(r100);
        r108.setAction(3);
        r101.f532768j.a(r108);
        r108.recycle();
        qfc.a.C7324a r109 = r101.f532773o;
        r101.f532768j = r109;
        r109.a(r100);
        goto L54
    }

    public void setCustomClipRatio(float r100) {
        this.f449186o = r100;
    }

    public void setIfFixClipRatio(boolean r100) {
        this.f449185n = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        this.f449174c = r100;
    }

    public void setPreLocation(RectF r100) {
        this.f449173b = r100;
    }

    public PhotoClipView(Context r100, AttributeSet r101) {
        super(r100, r101);
        new Paint();
        this.f449181j = new float[9];
        this.f449184m = false;
        this.f449185n = false;
        this.f449186o = -1.0f;
    }

    public PhotoClipView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        new Paint();
        this.f449181j = new float[9];
        this.f449184m = false;
        this.f449185n = false;
        this.f449186o = -1.0f;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int r100, int r101, int r102, int r103) {
        boolean r104 = super.setFrame(r100, r101, r102, r103);
        if (r104 == false) goto L5;
        m();
    L5:
        return r104;
    }
}
