package dj4;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.creativex.mediaimport.widget.gesture.scale.Vector2D;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f468925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f468926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MotionEvent f468927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MotionEvent f468928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Vector2D f468929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f468930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f468931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f468932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f468933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f468934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f468935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f468936l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f468937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f468938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f468939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f468940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f468941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f468942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f468943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f468944t;

    public static final class a {
    }

    public interface b {
        void a(View r100, i r101);

        boolean b(View r100, i r101);

        boolean c(View r100, i r101);
    }

    static {
    }

    public final void b() {
        MotionEvent r100 = this.f468927c;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.recycle();
        this.f468927c = null;
    L5:
        MotionEvent r101 = this.f468928d;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.recycle();
        this.f468928d = null;
    L8:
        this.f468926b = false;
        this.f468942r = -1;
        this.f468943s = -1;
        this.f468941q = false;
    }

    public i(d r100) {
        Intrinsics.checkNotNullParameter(r100, "mListener");
        this.f468925a = r100;
        this.f468929e = new Vector2D();
    }

    public final void c(View r110, MotionEvent r111) {
        MotionEvent r100 = this.f468928d;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.recycle();
    L5:
        this.f468928d = MotionEvent.obtain(r111);
        this.f468936l = -1.0f;
        this.f468937m = -1.0f;
        this.f468938n = -1.0f;
        this.f468929e.set(0.0f, 0.0f);
        MotionEvent r101 = this.f468927c;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.findPointerIndex(this.f468942r);
        int r103 = r101.findPointerIndex(this.f468943s);
        int r104 = r111.findPointerIndex(this.f468942r);
        int r105 = r111.findPointerIndex(this.f468943s);
        if (r102 < 0) goto L13;
        if (r103 < 0) goto L13;
        if (r104 < 0) goto L13;
        if (r105 < 0) goto L13;
        float r112 = r101.getX(r102);
        float r106 = r101.getY(r102);
        float r107 = r101.getX(r103);
        float r108 = r101.getY(r103);
        float r109 = r111.getX(r104);
        float r113 = r111.getY(r104);
        float r114 = r111.getX(r105);
        float r115 = r107 - r112;
        float r116 = r114 - r109;
        float r117 = r111.getY(r105) - r113;
        this.f468929e.set(r116, r117);
        this.f468932h = r115;
        this.f468933i = r108 - r106;
        this.f468934j = r116;
        this.f468935k = r117;
        this.f468930f = r109 + (r116 * 0.5f);
        this.f468931g = r113 + (r117 * 0.5f);
        r111.getEventTime();
        r101.getEventTime();
        this.f468939o = r111.getPressure(r104) + r111.getPressure(r105);
        this.f468940p = r101.getPressure(r102) + r101.getPressure(r103);
        return;
    L13:
        this.f468941q = true;
        new Throwable();
        if (this.f468926b == false) goto L17;
        this.f468925a.a(r110, this);
        return;
    }

    public static int a(MotionEvent r100, int r101, int r102) {
        int r103 = r100.getPointerCount();
        int r104 = r100.findPointerIndex(r101);
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L8;
        if (r105 == r102) goto L7;
        if (r105 == r104) goto L7;
        return r105;
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        return -1;
    }
}
