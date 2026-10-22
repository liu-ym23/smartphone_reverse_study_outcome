package gt8;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f482596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f482597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f482598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f482599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f482600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC6065d f482601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PointF f482602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b0 f482603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f482604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f482605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f482606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f482607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f482608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f482609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final gt8.e f482610o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f f482611p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final g f482612q;

    public static final class a {
    }

    public interface b {
        void a(MotionEvent r100);

        int getType();
    }

    public interface c {
        void a();

        void b();

        void c(RectF r100, RectF r101, float r102);

        void d(z r100);

        void e();

        void f(RectF r100);
    }

    /* JADX INFO: renamed from: gt8.d$d, reason: collision with other inner class name */
    public interface InterfaceC6065d {
        boolean a(MotionEvent r100);

        void onTouchEvent(MotionEvent r100);
    }

    public interface e {
        RectF a();

        RectF b();
    }

    static {
    }

    public static void a(RectF r100, RectF r101) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        Intrinsics.checkNotNullParameter(r101, "screen");
        float r102 = r100.centerX();
        float r103 = r100.centerY();
        float r104 = RangesKt.coerceAtMost(r101.height() / r100.height(), r101.width() / r100.width());
        r100.left = (int) (((r100.left - r102) * r104) + r102);
        r100.right = (int) (((r100.right - r102) * r104) + r102);
        r100.top = (int) (((r100.top - r103) * r104) + r103);
        r100.bottom = (int) (((r100.bottom - r103) * r104) + r103);
    }

    public d(RectF r100, z r101, RectF r102, com.larus.bmhome.view.crop.a.C4118a r103, com.larus.bmhome.view.crop.a.b r104, com.larus.bmhome.view.crop.a.c r105) {
        Intrinsics.checkNotNullParameter(r100, "mImageRect");
        Intrinsics.checkNotNullParameter(r101, "mImageShowLocationHelper");
        Intrinsics.checkNotNullParameter(r102, "referenceLocation");
        Intrinsics.checkNotNullParameter(r103, "onActionCallback");
        Intrinsics.checkNotNullParameter(r104, "dependency");
        Intrinsics.checkNotNullParameter(r105, "unInterceptMotionEventCallback");
        this.f482596a = r100;
        this.f482597b = r101;
        this.f482598c = r102;
        this.f482599d = r103;
        this.f482600e = r104;
        this.f482601f = r105;
        this.f482602g = new PointF();
        this.f482607l = r101.e() * 0.4f;
        this.f482608m = r101.e() * 10.0f;
        this.f482610o = new gt8.e(this);
        this.f482611p = new f(this);
        this.f482612q = new g(this);
        this.f482606k = true;
        this.f482604i = new j(new gt8.b(this));
        this.f482603h = new b0(new gt8.c(this));
    }
}
