package gt8;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.view.crop.ImageCropView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class o {
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public RectF A;
    public final boolean B;
    public final float C;
    public float D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f482639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f482640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f482641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f482642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f482643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f482644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f482645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f482646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f482647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f482648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RectF f482649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f482650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f482651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f482652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RectF f482653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RectF f482654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RectF f482655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RectF f482656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f482657s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f482658t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f482659u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f482660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f482661w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap f482662x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Canvas f482663y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f482664z;

    public static final class a {
    }

    public interface b {
        void a(float r100, float r101);

        void b();

        void c(RectF r100);
    }

    public interface c {
        z a();
    }

    public interface d {
        void a();

        void b(RectF r100);
    }

    public interface e {
        void a();

        void b(RectF r100);

        void c(RectF r100);

        void d();
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f482665a = 0;

        static {
        }

        public static RectF a(boolean r100, RectF r101, float r102) {
            Intrinsics.checkNotNullParameter(r101, "imageRect");
            if (r100 == false) goto L10;
            float r103 = r101.width() * r102;
            if (r101.height() <= r103) goto L7;
            float r104 = r101.left;
            float r105 = 2;
            float r106 = (r101.top + (r101.height() / r105)) - (r103 / r105);
            float r107 = r101.right;
            float r108 = r103 + r106;
        L11:
            return new RectF(r104, r106, r107, r108);
        L7:
            float r109 = r101.height() / r102;
            float r110 = 2;
            r104 = (r101.left + (r101.width() / r110)) - (r109 / r110);
            r106 = r101.top;
            float r111 = r101.bottom;
            r107 = r109 + r104;
            r108 = r111;
            goto L11
        L10:
            return new RectF(r101);
        }
    }

    public interface g {
        void a();

        int getViewHeight();

        int getViewWidth();
    }

    static {
        E = c7.b(4);
        F = c7.b(40);
        G = c7.b(90);
        H = c7.b(20);
    }

    public final RectF f() {
        float r100 = this.f482655q.width() / this.f482655q.height();
        float r101 = this.f482639a.width();
        float r102 = this.f482639a.height();
        float r103 = r101 / r102;
        PointF r104 = new PointF(this.f482639a.centerX(), this.f482639a.centerY());
        if (r100 <= r103) goto L5;
        r102 = r101 / r100;
    L6:
        RectF r105 = new RectF();
        float r106 = r104.x;
        float r107 = 2;
        float r108 = r101 / r107;
        r105.left = r106 - r108;
        r105.right = r106 + r108;
        float r109 = r104.y;
        float r110 = r102 / r107;
        r105.top = r109 - r110;
        r105.bottom = r109 + r110;
        return r105;
    L5:
        r101 = r102 * r100;
        goto L6
    }

    public final void i() {
        RectF r100 = this.f482655q;
        float r101 = r100.left;
        int r102 = H;
        float r103 = r100.top;
        this.f482647i = new RectF(r101 - r102, r103 - r102, r101 + r102, r103 + r102);
        RectF r104 = this.f482655q;
        float r105 = r104.right;
        float r106 = r104.top;
        this.f482648j = new RectF(r105 - r102, r106 - r102, r105 + r102, r106 + r102);
        RectF r107 = this.f482655q;
        float r108 = r107.left;
        float r109 = r107.bottom;
        this.f482649k = new RectF(r108 - r102, r109 - r102, r108 + r102, r109 + r102);
        RectF r110 = this.f482655q;
        float r111 = r110.right;
        float r112 = r110.bottom;
        this.f482650l = new RectF(r111 - r102, r112 - r102, r111 + r102, r112 + r102);
        RectF r113 = this.f482655q;
        float r114 = r113.left + r102;
        float r115 = r113.top;
        this.f482651m = new RectF(r114, r115 - r102, r113.right - r102, r115 + r102);
        RectF r116 = this.f482655q;
        float r117 = r116.left;
        this.f482652n = new RectF(r117 - r102, r116.top + r102, r117 + r102, r116.bottom - r102);
        RectF r118 = this.f482655q;
        float r119 = r118.left + r102;
        float r120 = r118.bottom;
        this.f482653o = new RectF(r119, r120 - r102, r118.right - r102, r120 + r102);
        RectF r121 = this.f482655q;
        float r122 = r121.right;
        this.f482654p = new RectF(r122 - r102, r121.top + r102, r122 + r102, r121.bottom - r102);
    }

    public static final void b(final o r100) {
        final RectF r101 = r100.f();
        final RectF r102 = new RectF(r100.f482655q);
        final RectF r103 = new RectF();
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r104.addUpdateListener(new m(r100, r103, r101, r102));
        r104.addListener(new y(r100));
        r104.start();
    }

    public final void c(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        if (this.f482661w == true) goto L5;
        r100.clipRect(this.f482655q, Region.Op.DIFFERENCE);
        r100.drawColor(this.f482659u);
    L5:
        this.f482663y.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f482657s.setAntiAlias(true);
        this.f482657s.setColor(-1);
        this.f482657s.setStyle(Paint.Style.STROKE);
        this.f482657s.setStrokeWidth(c7.b(2));
        if (this.f482661w == false) goto L8;
        this.f482663y.drawRect(this.f482656r, this.f482657s);
        d(this.f482663y, this.f482656r);
        e(this.f482663y, this.f482656r);
        r100.rotate(this.f482664z, this.f482655q.centerX(), this.f482655q.centerY());
    L9:
        r100.drawBitmap(this.f482662x, 0.0f, 0.0f, null);
        r100.restore();
        return;
    L8:
        this.f482663y.drawRect(this.f482655q, this.f482657s);
        e(this.f482663y, this.f482655q);
        d(this.f482663y, this.f482655q);
        goto L9
    }

    public final void h(RectF r100) {
        Intrinsics.checkNotNull(r100);
        float r101 = r100.centerX();
        float r102 = r100.centerY();
        float r103 = RangesKt.coerceAtMost(this.f482639a.height() / r100.height(), this.f482639a.width() / r100.width());
        r100.left = (int) (((r100.left - r101) * r103) + r101);
        r100.right = (int) (((r100.right - r101) * r103) + r101);
        r100.top = (int) (((r100.top - r102) * r103) + r102);
        r100.bottom = (int) (((r100.bottom - r102) * r103) + r102);
    }

    public static final void a(final o r100, RectF r101) {
        r100.getClass();
        final RectF r102 = new RectF();
        final RectF r103 = new RectF(r100.f482655q);
        final RectF r104 = new RectF(r101);
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r105.addUpdateListener(new n(r100, r102, r104, r103));
        r105.addListener(new t(r100));
        r105.start();
    }

    public final void d(Canvas r100, RectF r110) {
        this.f482657s.setStyle(Paint.Style.FILL);
        float r101 = r110.left;
        int r102 = E;
        float r103 = r101 - r102;
        float r104 = r110.top - r102;
        int r105 = F;
        r100.drawRect(new RectF(r103, r104, r105 + r103, r102 + r104), this.f482657s);
        r100.drawRect(new RectF(r103, r104, r102 + r103, r105 + r104), this.f482657s);
        float r106 = r110.right - (r105 - r102);
        float r107 = r110.top - r102;
        r100.drawRect(new RectF(r106, r107, r105 + r106, r102 + r107), this.f482657s);
        r100.drawRect(new RectF((r105 - r102) + r106, r107, r106 + r105, r105 + r107), this.f482657s);
        float r108 = r110.left - r102;
        float r109 = r110.bottom - (r105 - r102);
        r100.drawRect(new RectF(r108, r109, r102 + r108, r105 + r109), this.f482657s);
        r100.drawRect(new RectF(r108, (r105 - r102) + r109, r105 + r108, r109 + r105), this.f482657s);
        float r111 = r110.right;
        float r112 = r110.bottom - (r105 - r102);
        r100.drawRect(new RectF(r111, r112, r102 + r111, r105 + r112), this.f482657s);
        r100.drawRect(new RectF(r111 - (r105 - r102), (r105 - r102) + r112, r111 + r102, r112 + r105), this.f482657s);
        float r113 = r110.left - r102;
        float r114 = 2;
        float r115 = ((r110.top + r110.bottom) / r114) - (r105 / 2);
        r100.drawRect(new RectF(r113, r115, r102 + r113, r105 + r115), this.f482657s);
        float r116 = ((r110.left + r110.right) / r114) - (r105 / 2);
        float r117 = r110.top - r102;
        r100.drawRect(new RectF(r116, r117, r105 + r116, r102 + r117), this.f482657s);
        float r118 = r110.right;
        float r119 = ((r110.top + r110.bottom) / r114) - (r105 / 2);
        r100.drawRect(new RectF(r118, r119, r102 + r118, r105 + r119), this.f482657s);
        float r120 = ((r110.left + r110.right) / r114) - (r105 / 2);
        float r121 = r110.bottom;
        r100.drawRect(new RectF(r120, r121, r105 + r120, r102 + r121), this.f482657s);
    }

    public final void e(Canvas r110, RectF r210) {
        float r100 = r210.bottom;
        float r101 = r210.top;
        float r102 = r210.right;
        float r103 = r210.left;
        float r104 = (r100 - r101) / 3.0f;
        r110.drawLine(r103, r101 + r104, r102, r101 + r104, this.f482658t);
        float r111 = r210.left;
        float r105 = r210.top;
        float r106 = 2;
        float r107 = r104 * r106;
        r110.drawLine(r111, r105 + r107, r210.right, r105 + r107, this.f482658t);
        float r108 = r210.left;
        float r112 = (r102 - r103) / 3.0f;
        r110.drawLine(r108 + r112, r210.top, r108 + r112, r210.bottom, this.f482658t);
        float r109 = r210.left;
        float r113 = r112 * r106;
        r110.drawLine(r109 + r113, r210.top, r109 + r113, r210.bottom, this.f482658t);
    }

    public static void g(PointF r100, float r101, float r110, float r111) {
        double r102 = r111 * 0.017453292f;
        float r112 = (float) (((((double) (r100.x - r101)) * Math.cos(r102)) - (((double) (r100.y - r110)) * Math.sin(r102))) + ((double) r101));
        float r103 = (float) (((((double) (r100.x - r101)) * Math.sin(r102)) + (((double) (r100.y - r110)) * Math.cos(r102))) + ((double) r110));
        r100.x = r112;
        r100.y = r103;
    }

    public o(RectF r100, z r101, com.larus.bmhome.view.crop.a.d r102, com.larus.bmhome.view.crop.a.e r103, com.larus.bmhome.view.crop.a.f r104, com.larus.bmhome.view.crop.a.g r105) {
        Intrinsics.checkNotNullParameter(r100, "mImageRect");
        Intrinsics.checkNotNullParameter(r101, "mAvailableRegion");
        Intrinsics.checkNotNullParameter(r102, "mViewDependency");
        Intrinsics.checkNotNullParameter(r103, "mClipRegionChangeListener");
        Intrinsics.checkNotNullParameter(r104, "mTransitionListener");
        Intrinsics.checkNotNullParameter(r105, "mPhotoLocationProvider");
        this.f482639a = r100;
        this.f482640b = r101;
        this.f482641c = r102;
        this.f482642d = r103;
        this.f482643e = r104;
        this.f482644f = r105;
        this.f482647i = new RectF();
        this.f482648j = new RectF();
        this.f482649k = new RectF();
        this.f482650l = new RectF();
        this.f482651m = new RectF();
        this.f482652n = new RectF();
        this.f482653o = new RectF();
        this.f482654p = new RectF();
        this.f482655q = new RectF();
        this.f482656r = new RectF();
        this.f482659u = ColorProtector.parseColor("#8C000000");
        float r106 = 0.42666668f;
        this.C = 0.42666668f;
        ImageCropView r107 = r102.f316903a;
        boolean r108 = r107.f316895m;
        this.B = r108;
        float r109 = r107.f316896n;
        if (r109 <= 0.0f) goto L5;
        r106 = r109;
    L5:
        this.C = r106;
        int r110 = 1;
        if (r108 == false) goto L8;
        this.D = G * r106;
        this.f482655q = f.a(true, r100, r106);
    L9:
        this.A = new RectF(this.f482655q);
        this.f482657s = new Paint();
        Paint r111 = new Paint();
        this.f482658t = r111;
        r111.setColor(ColorProtector.parseColor("#99FFFFFF"));
        r111.setAntiAlias(true);
        r111.setStrokeWidth(c7.b(1));
        r111.setPathEffect(new DashPathEffect(new float[]{4.0f, 4.0f}, 0.0f));
        if (r102.getViewWidth() > 0) goto L12;
        int r112 = 1;
    L14:
        if (r102.getViewHeight() <= 0) goto L17;
        r110 = r102.getViewHeight();
    L17:
        this.f482662x = Bitmap.createBitmap(r112, r110, Bitmap.Config.ARGB_8888);
        this.f482663y = new Canvas(this.f482662x);
        i();
        return;
    L12:
        r112 = r102.getViewWidth();
        goto L14
    L8:
        this.D = G;
        this.f482655q = f.a(false, r100, r106);
        goto L9
    }
}
