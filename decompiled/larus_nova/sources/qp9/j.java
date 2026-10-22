package qp9;

import android.view.MotionEvent;
import android.view.View;
import com.larus.photopicker.v2.impl.others.scale.Vector2D;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f534397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f534398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MotionEvent f534399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MotionEvent f534400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Vector2D f534401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f534402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f534403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f534404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f534405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f534406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f534407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f534408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f534409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f534410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f534411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f534412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f534413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f534414r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f534415s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f534416t;

    public static final class a {
    }

    public interface b {
        boolean a(View r100, j r101);

        boolean b(View r100, j r101);

        void c(View r100, j r101);
    }

    static {
    }

    public final void b() {
        MotionEvent r100 = this.f534399c;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.recycle();
        this.f534399c = null;
    L5:
        MotionEvent r101 = this.f534400d;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.recycle();
        this.f534400d = null;
    L8:
        this.f534398b = false;
        this.f534414r = -1;
        this.f534415s = -1;
        this.f534413q = false;
    }

    public j(g r100) {
        Intrinsics.checkNotNullParameter(r100, "mListener");
        this.f534397a = r100;
        this.f534401e = new Vector2D();
    }

    public final void c(View r110, MotionEvent r111) {
        MotionEvent r100 = this.f534400d;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        r100.recycle();
    L5:
        this.f534400d = MotionEvent.obtain(r111);
        this.f534408l = -1.0f;
        this.f534409m = -1.0f;
        this.f534410n = -1.0f;
        this.f534401e.set(0.0f, 0.0f);
        MotionEvent r101 = this.f534399c;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.findPointerIndex(this.f534414r);
        int r103 = r101.findPointerIndex(this.f534415s);
        int r104 = r111.findPointerIndex(this.f534414r);
        int r105 = r111.findPointerIndex(this.f534415s);
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
        this.f534401e.set(r116, r117);
        this.f534404h = r115;
        this.f534405i = r108 - r106;
        this.f534406j = r116;
        this.f534407k = r117;
        this.f534402f = r109 + (r116 * 0.5f);
        this.f534403g = r113 + (r117 * 0.5f);
        r111.getEventTime();
        r101.getEventTime();
        this.f534411o = r111.getPressure(r104) + r111.getPressure(r105);
        this.f534412p = r101.getPressure(r102) + r101.getPressure(r103);
        return;
    L13:
        this.f534413q = true;
        new Throwable();
        if (this.f534398b == false) goto L17;
        this.f534397a.c(r110, this);
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
