package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes40.dex */
public class c extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f461530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f461531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f461532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f461533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f461534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f461535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f461536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bitmap f461537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f461538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f461539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f461540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointF f461541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PointF f461542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f461543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f461544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Rect f461545p;

    private void a() {
    }

    private void b() {
        if (this.f461537h != null) goto L5;
        return;
    L5:
        float r100 = this.f461545p.width();
        float r101 = this.f461545p.height();
        float[] r102 = new float[9];
        this.f461532c.getValues(r102);
        float r103 = r102[2];
        float r104 = r102[5];
        float r105 = r102[0];
        float r110 = this.f461535f;
        if (r105 <= r110) goto L8;
        float r111 = r110 / r105;
        this.f461544o = r111;
        Matrix r106 = this.f461532c;
        PointF r107 = this.f461542m;
        r106.postScale(r111, r111, r107.x, r107.y);
        setImageMatrix(this.f461532c);
        float r108 = this.f461544o;
        float r109 = 1.0f / r108;
        float r112 = 1.0f / r108;
        PointF r113 = this.f461542m;
        Animation r114 = new ScaleAnimation(r109, 1.0f, r112, 1.0f, r113.x, r113.y);
    L27:
        if (r114 == null) goto L30;
        this.f461538i = true;
        r114.setDuration(300);
        startAnimation(r114);
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this), "nect/avatar/c"));
        return;
    L30:
        return;
    L8:
        float r115 = this.f461536g;
        if (r105 >= r115) goto L11;
        float r116 = r115 / r105;
        this.f461544o = r116;
        Matrix r117 = this.f461532c;
        PointF r118 = this.f461542m;
        r117.postScale(r116, r116, r118.x, r118.y);
        float r119 = this.f461544o;
        PointF r120 = this.f461542m;
        r114 = new ScaleAnimation(1.0f, r119, 1.0f, r119, r120.x, r120.y);
        goto L27
    L11:
        float r121 = this.f461537h.getWidth() * r105;
        float r122 = this.f461537h.getHeight() * r105;
        Rect r123 = this.f461545p;
        int r124 = r123.left;
        float r125 = r124 - r103;
        int r126 = r123.top;
        float r127 = r126 - r104;
        if (r125 >= 0.0f) goto L14;
        r103 = r124;
        boolean r128 = true;
    L16:
        if (r127 >= 0.0f) goto L18;
        r104 = r126;
        r128 = true;
    L18:
        float r129 = r122 - r127;
        if ((r121 - r125) >= r100) goto L22;
        r103 = r124 - (r121 - r100);
        r128 = true;
    L22:
        if (r129 >= r101) goto L24;
        r104 = r126 - (r122 - r101);
        r128 = true;
    L24:
        if (r128 == false) goto L26;
        float r130 = r102[2] - r103;
        float r131 = r102[5] - r104;
        r102[2] = r103;
        r102[5] = r104;
        this.f461532c.setValues(r102);
        setImageMatrix(this.f461532c);
        r114 = new TranslateAnimation(r130, 0.0f, r131, 0.0f);
        goto L27
    L26:
        setImageMatrix(this.f461532c);
        r114 = null;
        goto L27
    L14:
        r128 = false;
        goto L16
    }

    private void c() {
        if (this.f461537h != null) goto L5;
        return;
    L5:
        float[] r100 = {r1, 0.0f, this.f461539j, 0.0f, r1, r2, 0.0f, 0.0f, 0.0f};
        this.f461532c.getValues(r100);
        float r101 = Math.max(this.f461545p.width() / this.f461537h.getWidth(), this.f461545p.height() / this.f461537h.getHeight());
        this.f461539j = this.f461545p.left - (((this.f461537h.getWidth() * r101) - this.f461545p.width()) / 2.0f);
        float r102 = this.f461545p.top - (((this.f461537h.getHeight() * r101) - this.f461545p.height()) / 2.0f);
        this.f461540k = r102;
        this.f461532c.setValues(r100);
        float r103 = Math.min(2048.0f / this.f461537h.getWidth(), 2048.0f / this.f461537h.getHeight());
        this.f461535f = r103;
        this.f461536g = r101;
        if (r103 >= r101) goto L8;
        this.f461535f = r101;
    L8:
        setImageMatrix(this.f461532c);
    }

    public c(Context r100) {
        super(r100);
        this.f461532c = new Matrix();
        this.f461533d = new Matrix();
        this.f461534e = 0;
        this.f461535f = 1.0f;
        this.f461536g = 1.0f;
        this.f461538i = false;
        this.f461530a = "TouchView";
        this.f461541l = new PointF();
        this.f461542m = new PointF();
        this.f461543n = 1.0f;
        this.f461544o = 0.0f;
        this.f461531b = false;
        Rect r101 = new Rect();
        this.f461545p = r101;
        getDrawingRect(r101);
        a();
    }

    private void a(PointF r100) {
        if (this.f461537h != null) goto L5;
        return;
    L5:
        float[] r101 = new float[9];
        this.f461532c.getValues(r101);
        float r102 = r101[2];
        float r103 = r101[5];
        float r104 = r101[0];
        float r105 = this.f461537h.getWidth() * r104;
        float r106 = this.f461537h.getHeight() * r104;
        Rect r107 = this.f461545p;
        float r108 = r107.left - r102;
        float r109 = 1.0f;
        if (r108 > 1.0f) goto L8;
        r108 = 1.0f;
    L8:
        float r110 = (r102 + r105) - r107.right;
        if (r110 > 1.0f) goto L11;
        r110 = 1.0f;
    L11:
        float r111 = (r107.width() * r108) / (r110 + r108);
        Rect r112 = this.f461545p;
        float r113 = r111 + r112.left;
        float r114 = r112.top - r103;
        float r115 = (r103 + r106) - r112.bottom;
        if (r114 > 1.0f) goto L15;
        r114 = 1.0f;
    L15:
        if (r115 <= 1.0f) goto L18;
        r109 = r115;
    L18:
        r100.set(r113, ((r112.height() * r114) / (r109 + r114)) + this.f461545p.top);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.f461538i == false) goto L5;
        return true;
    L5:
        int r101 = r100.getAction() & 255;
        if (r101 == 0) goto L27;
        if (r101 != 1) goto L9;
    L26:
        b();
        this.f461534e = 0;
    L28:
        this.f461531b = true;
        return true;
    L9:
        if (r101 != 2) goto L11;
        int r102 = this.f461534e;
        if (r102 != 1) goto L21;
        this.f461532c.set(this.f461533d);
        float r103 = r100.getX() - this.f461541l.x;
        float r104 = r100.getY() - this.f461541l.y;
        this.f461532c.postTranslate(r103, r104);
        setImageMatrix(this.f461532c);
        goto L28
    L21:
        if (r102 != 2) goto L28;
        Matrix r105 = this.f461532c;
        r105.set(r105);
        float r106 = a(r100);
        if (r106 <= 10.0f) goto L25;
        this.f461532c.set(this.f461533d);
        float r107 = r106 / this.f461543n;
        Matrix r108 = this.f461532c;
        PointF r109 = this.f461542m;
        r108.postScale(r107, r107, r109.x, r109.y);
    L25:
        setImageMatrix(this.f461532c);
        goto L28
    L11:
        if (r101 != 5) goto L13;
        float r110 = a(r100);
        this.f461543n = r110;
        if (r110 <= 10.0f) goto L28;
        this.f461533d.set(this.f461532c);
        a(this.f461542m);
        this.f461534e = 2;
        goto L28
    L13:
        if (r101 == 6) goto L26;
    L27:
        this.f461532c.set(getImageMatrix());
        this.f461533d.set(this.f461532c);
        this.f461541l.set(r100.getX(), r100.getY());
        this.f461534e = 1;
        goto L28
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        this.f461537h = r100;
        if (r100 == null) goto L6;
        this.f461537h = r100;
        return;
    }

    private float a(MotionEvent r100) {
        if (r100.getPointerCount() >= 2) goto L6;
        return 0.0f;
    L6:
        float r101 = r100.getX(0) - r100.getX(1);
        float r102 = r100.getY(0) - r100.getY(1);
        return (float) Math.sqrt((r101 * r101) + (r102 * r102));
    }

    public void a(Rect r100) {
        this.f461545p = r100;
        if (this.f461537h == null) goto L6;
        c();
        return;
    }

    public static /* synthetic */ void a(c r100) {
        r100.b();
    }

    public static /* synthetic */ boolean a(c r100, boolean r101) {
        r100.f461538i = r101;
        return r101;
    }
}
