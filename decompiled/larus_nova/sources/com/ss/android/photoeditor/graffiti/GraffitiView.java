package com.ss.android.photoeditor.graffiti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.log.Log;
import pfc.f;
import pfc.g;

/* JADX INFO: loaded from: classes38.dex */
public class GraffitiView extends AppCompatImageView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f449199n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f449200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f449201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f449202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f449203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f449204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f449205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f449207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f449208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f449209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f449210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f449211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f.a f449212m;

    public interface a {
    }

    private Matrix getDrawMatrix() {
        Matrix r100 = new Matrix();
        com.ss.android.photoeditor.util.b.g(r100, this.f449204e, getLocation());
        return r100;
    }

    public RectF getLocation() {
        return new RectF(n());
    }

    public final void j() {
        Log.i("GraffitiView", "initHelper");
        this.f449209j = new b(getContext(), new d(this), new e(this));
        this.f449208i = new g(n(), getLocation(), new rfc.e(this), new rfc.f(this));
    }

    public final void m() {
        if (this.f449201b == null) goto L10;
        RectF r100 = n();
        if (this.f449202c == true) goto L7;
        Log.i("GraffitiView", "ignoring previous location: " + l(this.f449201b));
        g r101 = this.f449208i;
        r101.f529070f.b(new RectF(this.f449201b), r100, 250);
    L8:
        this.f449201b = null;
        return;
    L7:
        Log.i("GraffitiView", "animating with previous location: " + l(this.f449201b));
        goto L8
    }

    public final RectF n() {
        RectF r100 = new RectF();
        float r101 = getDrawable().getIntrinsicWidth();
        float r102 = getDrawable().getIntrinsicHeight();
        float r103 = getWidth();
        float r104 = getHeight();
        Matrix r105 = getImageMatrix();
        r105.getValues(this.f449205f);
        float[] r106 = this.f449205f;
        float r107 = r106[0];
        r105.getValues(r106);
        float r108 = this.f449205f[4];
        int r109 = (int) (r101 * r107);
        this.f449206g = r109;
        this.f449207h = (int) (r102 * r108);
        if (Math.abs(r109 - r103) >= 3.0f) goto L5;
        float r110 = this.f449207h;
        float r111 = (r104 - r110) / 2.0f;
        r100.set(0.0f, (int) r111, (int) r103, (int) (r111 + r110));
    L6:
        return r100;
    L5:
        float r112 = this.f449206g;
        float r113 = (r103 - r112) / 2.0f;
        r100.set((int) r113, 0.0f, (int) (r113 + r112), (int) r104);
        goto L6
    }

    public GraffitiView(Context r100) {
        super(r100);
        this.f449205f = new float[9];
    }

    public static String l(RectF r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return "left:" + r100.left + ",right:" + r100.right + ",top:" + r100.top + ",bottom:" + r100.bottom;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawColor(-16777216);
        Bitmap r101 = this.f449204e;
        if (r101 == null) goto L7;
        r100.drawBitmap(r101, getDrawMatrix(), null);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f449210k == false) goto L32;
        this.f449208i.a(r100);
        a r101 = this.f449211l;
        if (r101 == null) goto L32;
        c r102 = (c) r101;
        if (r100.getPointerCount() != 1) goto L32;
        int r103 = r100.getAction();
        if (r103 == 0) goto L31;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L32;
        r102.f449238a = false;
        r102.f449242e.f449197f.b();
        goto L32
    L19:
        if (r102.f449241d == false) goto L21;
    L22:
        r102.f449238a = true;
        r102.f449241d = true;
        r102.f449242e.f449197f.a();
        goto L32
    L21:
        if (pfc.a.a(r102.f449242e.getContext(), r102.f449239b, r102.f449240c, r100.getX(), r100.getY()) == false) goto L32;
    L24:
        if (r102.f449238a == false) goto L26;
        r102.f449242e.f449197f.b();
        r102.f449238a = false;
        goto L32
    L26:
        pfc.c r104 = r102.f449242e.f449197f;
        if (r104.f529038b == false) goto L29;
        r104.a();
    L30:
        f r105 = f.i();
        RectF r106 = r102.f449242e.f449192a.getLocation();
        float r107 = r100.getX();
        float r108 = r100.getY();
        r105.getClass();
        f.b(r106, r107, r108);
        goto L32
    L29:
        r104.b();
        goto L30
    L31:
        r102.f449238a = false;
        r102.f449241d = false;
        r102.f449239b = r100.getX();
        r102.f449240c = r100.getY();
    L32:
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        Log.i("GraffitiView", "setImageBitmap");
        this.f449203d = r100;
        this.f449204e = r100;
        super.setImageBitmap(r100);
    }

    public void setMotionEventListener(a r100) {
        this.f449211l = r100;
    }

    public void setPaintColor(int r100) {
        if (this.f449209j != null) goto L5;
        j();
    L5:
        b r101 = this.f449209j;
        r101.f449232o = r100;
        r101.f449230m.setColor(r100);
    }

    public void setPaintSize(int r100) {
        b r101 = this.f449209j;
        r101.f449231n = r100;
        r101.f449230m.setStrokeWidth(r100);
    }

    public GraffitiView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f449205f = new float[9];
    }

    public GraffitiView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f449205f = new float[9];
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int r100, int r101, int r102, int r103) {
        boolean r104 = super.setFrame(r100, r101, r102, r103);
        if (r104 == false) goto L15;
        b r105 = this.f449209j;
        if (r105 == null) goto L15;
        r105.d();
        Bitmap r106 = r105.f449225h;
        if (r106 != null) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == false) goto L14;
        r105.e(r105.f449225h);
    L14:
        RectF r108 = r105.b();
        r105.f449226i = Bitmap.createBitmap((int) r108.width(), (int) r108.height(), Bitmap.Config.ARGB_4444);
        r105.f449229l = new Canvas(r105.f449226i);
        r105.a();
        goto L15
    L9:
        if (r106.isRecycled() == true) goto L11;
        r107 = true;
    L15:
        return r104;
    }
}
