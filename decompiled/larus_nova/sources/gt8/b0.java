package gt8;

import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f482589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f482590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f482591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PointF f482592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PointF f482593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f482594f;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e(PointF r100, float r101, float r102, float r103);

        void f();

        void g();

        void onTransformStart();
    }

    static {
    }

    public b0(c r100) {
        Intrinsics.checkNotNullParameter(r100, "touchCallback");
        this.f482589a = r100;
    }

    public final void a(MotionEvent r100) {
        a0 r101 = this.f482591c;
        if (r101 != null) goto L5;
        this.f482591c = new a0(r100.getX(), r100.getY(), r100.getX(1), r100.getY(1));
        return;
    L5:
        if (r101 == null) goto L9;
        float r102 = r100.getX();
        float r103 = r100.getY();
        float r104 = r100.getX(1);
        float r105 = r100.getY(1);
        PointF r106 = r101.f482585a;
        r106.x = r102;
        r106.y = r103;
        PointF r107 = r101.f482586b;
        r107.x = r104;
        r107.y = r105;
        PointF r108 = r101.f482587c;
        float r109 = 2;
        r108.x = (r106.x + r104) / r109;
        r108.y = (r106.y + r105) / r109;
        return;
    }
}
