package qfc;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;

/* JADX INFO: loaded from: classes38.dex */
public final class w {
    public static final int C = 0;
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public final float A;
    public float B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f532818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f532819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f532820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f532821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f532822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f532823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RectF f532824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f532825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f532826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f532827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f532828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f532829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f532830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f532831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f532832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f532833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f532834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f532835r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f532836s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f532837t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f532838u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bitmap f532839v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Canvas f532840w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f532841x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RectF f532842y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f532843z;

    public interface a {
        void a(float r100, float r101);

        void b();

        void c(RectF r100);
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {
        public static RectF a(boolean r100, RectF r101, float r102) {
            if (r100 == false) goto L10;
            float r103 = r101.width() * r102;
            if (r101.height() <= r103) goto L6;
            float r104 = r101.left;
            float r105 = (r101.top + (r101.height() / 2.0f)) - (r103 / 2.0f);
            float r106 = r101.right;
            float r107 = r103 + r105;
        L8:
            return new RectF(r104, r105, r106, r107);
        L6:
            float r108 = r101.height() / r102;
            r104 = (r101.left + (r101.width() / 2.0f)) - (r108 / 2.0f);
            r105 = r101.top;
            float r109 = r101.bottom;
            r106 = r108 + r104;
            r107 = r109;
            goto L8
        L10:
            return new RectF(r101);
        }
    }

    public interface f {
    }

    static {
        C = com.ss.android.photoeditor.util.d.b(4);
        D = com.ss.android.photoeditor.util.d.b(40);
        E = com.ss.android.photoeditor.util.d.b(90);
        F = com.ss.android.photoeditor.util.d.b(20);
    }

    public final RectF e() {
        float r100 = this.f532827j.width() / this.f532827j.height();
        float r101 = this.f532829l.width();
        float r102 = this.f532829l.height();
        float r103 = r101 / r102;
        PointF r104 = new PointF(this.f532829l.centerX(), this.f532829l.centerY());
        if (r100 <= r103) goto L5;
        r102 = r101 / r100;
    L6:
        RectF r105 = new RectF();
        float r106 = r104.x;
        float r107 = r101 / 2.0f;
        r105.left = r106 - r107;
        r105.right = r106 + r107;
        float r108 = r104.y;
        float r109 = r102 / 2.0f;
        r105.top = r108 - r109;
        r105.bottom = r108 + r109;
        return r105;
    L5:
        r101 = r102 * r100;
        goto L6
    }

    public final void h() {
        if (this.f532819b != null) goto L5;
        this.f532819b = new RectF();
    L5:
        RectF r100 = this.f532819b;
        RectF r101 = this.f532827j;
        float r102 = r101.left;
        int r103 = F;
        float r104 = r101.top;
        r100.set(r102 - r103, r104 - r103, r102 + r103, r104 + r103);
        if (this.f532820c != null) goto L8;
        this.f532820c = new RectF();
    L8:
        RectF r105 = this.f532820c;
        RectF r106 = this.f532827j;
        float r107 = r106.right;
        float r108 = r106.top;
        r105.set(r107 - r103, r108 - r103, r107 + r103, r108 + r103);
        if (this.f532821d != null) goto L11;
        this.f532821d = new RectF();
    L11:
        RectF r109 = this.f532821d;
        RectF r110 = this.f532827j;
        float r111 = r110.left;
        float r112 = r110.bottom;
        r109.set(r111 - r103, r112 - r103, r111 + r103, r112 + r103);
        if (this.f532822e != null) goto L14;
        this.f532822e = new RectF();
    L14:
        RectF r113 = this.f532822e;
        RectF r114 = this.f532827j;
        float r115 = r114.right;
        float r116 = r114.bottom;
        r113.set(r115 - r103, r116 - r103, r115 + r103, r116 + r103);
        if (this.f532823f != null) goto L17;
        this.f532823f = new RectF();
    L17:
        RectF r117 = this.f532823f;
        RectF r118 = this.f532827j;
        float r119 = r118.left + r103;
        float r120 = r118.top;
        r117.set(r119, r120 - r103, r118.right - r103, r120 + r103);
        if (this.f532824g != null) goto L20;
        this.f532824g = new RectF();
    L20:
        RectF r121 = this.f532824g;
        RectF r122 = this.f532827j;
        float r123 = r122.left;
        r121.set(r123 - r103, r122.top + r103, r123 + r103, r122.bottom - r103);
        if (this.f532825h != null) goto L23;
        this.f532825h = new RectF();
    L23:
        RectF r124 = this.f532825h;
        RectF r125 = this.f532827j;
        float r126 = r125.left + r103;
        float r127 = r125.bottom;
        r124.set(r126, r127 - r103, r125.right - r103, r127 + r103);
        if (this.f532826i != null) goto L26;
        this.f532826i = new RectF();
    L26:
        RectF r128 = this.f532826i;
        RectF r129 = this.f532827j;
        float r130 = r129.right;
        r128.set(r130 - r103, r129.top + r103, r130 + r103, r129.bottom - r103);
    }

    public static void b(w r100) {
        RectF r101 = r100.e();
        RectF r102 = new RectF(r100.f532827j);
        RectF r103 = new RectF();
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r104.addUpdateListener(new p(r100, r103, r101, r102));
        r104.addListener(new q(r100));
        r104.start();
    }

    public final void g(RectF r100) {
        float r101 = r100.centerX();
        float r102 = r100.centerY();
        float r103 = Math.min(this.f532829l.height() / r100.height(), this.f532829l.width() / r100.width());
        r100.left = (int) (((r100.left - r101) * r103) + r101);
        r100.right = (int) (((r100.right - r101) * r103) + r101);
        r100.top = (int) (((r100.top - r102) * r103) + r102);
        r100.bottom = (int) (((r100.bottom - r102) * r103) + r102);
    }

    public static void a(w r100, RectF r101) {
        r100.getClass();
        RectF r102 = new RectF();
        RectF r103 = new RectF(r100.f532827j);
        RectF r104 = new RectF(r101);
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r105.addUpdateListener(new n(r100, r102, r104, r103));
        r105.addListener(new o(r100));
        r105.start();
    }

    public final void c(Canvas r100, RectF r110) {
        this.f532835r.setStyle(Paint.Style.FILL);
        this.f532835r.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        float r101 = r110.left;
        int r102 = C;
        float r103 = r101 - r102;
        float r104 = r110.top - r102;
        int r105 = D;
        r100.drawRect(new RectF(r103, r104, r105 + r103, r102 + r104), this.f532835r);
        r100.drawRect(new RectF(r103, r104, r102 + r103, r105 + r104), this.f532835r);
        float r106 = r110.right - (r105 - r102);
        float r107 = r110.top - r102;
        r100.drawRect(new RectF(r106, r107, r105 + r106, r102 + r107), this.f532835r);
        r100.drawRect(new RectF((r105 - r102) + r106, r107, r106 + r105, r105 + r107), this.f532835r);
        float r108 = r110.left - r102;
        float r109 = r110.bottom - (r105 - r102);
        r100.drawRect(new RectF(r108, r109, r102 + r108, r105 + r109), this.f532835r);
        r100.drawRect(new RectF(r108, (r105 - r102) + r109, r105 + r108, r109 + r105), this.f532835r);
        float r111 = r110.right;
        float r112 = r110.bottom - (r105 - r102);
        r100.drawRect(new RectF(r111, r112, r102 + r111, r105 + r112), this.f532835r);
        r100.drawRect(new RectF(r111 - (r105 - r102), (r105 - r102) + r112, r111 + r102, r112 + r105), this.f532835r);
    }

    public final void d(Canvas r110, RectF r210) {
        float r100 = r210.bottom;
        float r101 = r210.top;
        float r102 = r210.right;
        float r103 = r210.left;
        float r104 = (r100 - r101) / 3.0f;
        r110.drawLine(r103, r101 + r104, r102, r101 + r104, this.f532836s);
        float r111 = r210.left;
        float r105 = r210.top;
        float r106 = r104 * 2.0f;
        r110.drawLine(r111, r105 + r106, r210.right, r105 + r106, this.f532836s);
        float r107 = r210.left;
        float r112 = (r102 - r103) / 3.0f;
        r110.drawLine(r107 + r112, r210.top, r107 + r112, r210.bottom, this.f532836s);
        float r108 = r210.left;
        float r113 = r112 * 2.0f;
        r110.drawLine(r108 + r113, r210.top, r108 + r113, r210.bottom, this.f532836s);
    }

    public static void f(PointF r100, float r101, float r110, float r111) {
        double r102 = r111 * 0.017453292f;
        float r112 = (float) (((((double) (r100.x - r101)) * Math.cos(r102)) - (((double) (r100.y - r110)) * Math.sin(r102))) + ((double) r101));
        float r103 = (float) (((((double) (r100.x - r101)) * Math.sin(r102)) + (((double) (r100.y - r110)) * Math.cos(r102))) + ((double) r110));
        r100.x = r112;
        r100.y = r103;
    }

    public w(RectF r100, y r101, x.d r102, x.e r110, x.f r111, x.g r112) {
        this.f532837t = false;
        this.f532838u = false;
        this.f532843z = false;
        float r103 = 0.42666668f;
        this.A = 0.42666668f;
        this.f532831n = r102;
        PhotoClipView r104 = r102.f532849a.f532845b;
        boolean r105 = r104.f449185n;
        this.f532843z = r105;
        float r106 = r104.f449186o;
        if (r106 <= 0.0f) goto L5;
        r103 = r106;
    L5:
        this.A = r103;
        this.f532829l = r100;
        int r107 = 1;
        if (r105 == false) goto L8;
        this.B = E * r103;
        this.f532827j = e.a(true, r100, r103);
    L9:
        this.f532842y = new RectF(this.f532827j);
        this.f532832o = r110;
        this.f532833p = r111;
        this.f532834q = r112;
        this.f532828k = r101;
        this.f532835r = new Paint();
        Paint r108 = new Paint();
        this.f532836s = r108;
        r108.setColor(ColorProtector.parseColor("#99FFFFFF"));
        r108.setAntiAlias(true);
        r108.setStrokeWidth(com.ss.android.photoeditor.util.d.b(1));
        r108.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        if (r102.f532849a.f532845b.getWidth() > 0) goto L12;
        int r109 = 1;
    L14:
        if (r102.f532849a.f532845b.getHeight() <= 0) goto L17;
        r107 = r102.f532849a.f532845b.getHeight();
    L17:
        this.f532839v = Bitmap.createBitmap(r109, r107, Bitmap.Config.ARGB_8888);
        this.f532840w = new Canvas(this.f532839v);
        h();
        return;
    L12:
        r109 = r102.f532849a.f532845b.getWidth();
        goto L14
    L8:
        this.B = E;
        this.f532827j = e.a(false, r100, r103);
        goto L9
    }
}
