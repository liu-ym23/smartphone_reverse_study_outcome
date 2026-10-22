package pfc;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f529117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f529118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f529119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PointF f529120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PointF f529121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f529122f;

    public static abstract class a {
        public a() {
        }

        public abstract void a();

        public abstract void b(PointF r100, float r101, float r102, float r103);

        public void c() {
        }
    }

    public w(a r100) {
        this.f529122f = false;
        this.f529117a = r100;
    }

    public final void a(MotionEvent r110) {
        int r100 = r110.getPointerCount();
        int r101 = r110.getAction() & 255;
        if (r101 != 0) goto L5;
        this.f529117a.getClass();
        return;
    L5:
        if (r101 != 1) goto L7;
        this.f529119c = null;
        this.f529118b = null;
        this.f529117a.getClass();
        this.f529117a.a();
        return;
    L7:
        if (r101 == 2) goto L19;
        if (r101 != 5) goto L11;
        this.f529118b = new m(r110.getX(), r110.getY(), r110.getX(1), r110.getY(1));
        b(r110);
        this.f529120d = this.f529118b.f529086c;
        this.f529117a.getClass();
        if (this.f529122f == true) goto L17;
        this.f529117a.c();
        this.f529122f = true;
    L17:
        Log.d("DoublePActionHandler", "ACTION_POINTER_DOWN");
        return;
    L11:
        if (r101 != 6) goto L49;
        Log.d("DoublePActionHandler", "ACTION_POINTER_UP");
        this.f529117a.getClass();
        return;
    L49:
        return;
    L19:
        if (this.f529122f == true) goto L21;
        this.f529122f = true;
        this.f529117a.c();
    L21:
        float r102 = 0.0f;
        float r103 = 1.0f;
        if (r100 == 1) goto L24;
        if (r100 != 2) goto L40;
        this.f529121e = null;
        b(r110);
        if (this.f529118b != null) goto L32;
        m r104 = new m(r110.getX(), r110.getY(), r110.getX(1), r110.getY(1));
        this.f529118b = r104;
        this.f529120d = r104.f529086c;
    L32:
        Log.d("DoublePActionHandler", "ACTION_MOVE");
        m r111 = this.f529118b;
        m r105 = this.f529119c;
        r111.getClass();
        r103 = r105.a() / r111.a();
        m r112 = this.f529118b;
        m r106 = this.f529119c;
        PointF r107 = r112.f529084a;
        float r108 = r107.x;
        PointF r109 = r106.f529084a;
        float r113 = r109.x;
        PointF r114 = r112.f529085b;
        float r115 = r114.x;
        PointF r116 = r106.f529085b;
        float r117 = r116.x;
        if (((r108 - r113) * (r115 - r117)) < 0.0f) goto L35;
        float r118 = ((r113 - r108) + (r117 - r115)) / 2.0f;
    L36:
        float r119 = r107.y;
        float r120 = r109.y;
        float r121 = r114.y;
        float r122 = r116.y;
        if (((r119 - r120) * (r121 - r122)) < 0.0f) goto L39;
        r102 = ((r120 - r119) + (r122 - r121)) / 2.0f;
    L39:
        r112.d(r106);
        float r123 = r102;
        r102 = r118;
    L41:
        this.f529117a.b(this.f529120d, r103, r102, r123);
        this.f529117a.getClass();
        return;
    L35:
        r118 = 0.0f;
        goto L36
    L40:
        r123 = 0.0f;
        goto L41
    L24:
        if (this.f529121e != null) goto L26;
        PointF r124 = new PointF();
        this.f529121e = r124;
        r124.x = r110.getX();
        PointF r125 = this.f529121e;
        r125.y = r110.getY();
        float r126 = 0.0f;
    L27:
        this.f529118b = null;
        float r127 = r102;
        r102 = r126;
        r123 = r127;
        goto L41
    L26:
        float r128 = r110.getX() - this.f529121e.x;
        float r129 = r110.getY();
        PointF r130 = this.f529121e;
        float r131 = r129 - r130.y;
        r130.x = r110.getX();
        PointF r132 = this.f529121e;
        r132.y = r110.getY();
        r126 = r128;
        r102 = r131;
        goto L27
    }

    public final void b(MotionEvent r100) {
        m r101 = this.f529119c;
        if (r101 != null) goto L5;
        this.f529119c = new m(r100.getX(), r100.getY(), r100.getX(1), r100.getY(1));
        return;
    L5:
        r101.c(r100.getX(), r100.getY(), r100.getX(1), r100.getY(1));
    }
}
