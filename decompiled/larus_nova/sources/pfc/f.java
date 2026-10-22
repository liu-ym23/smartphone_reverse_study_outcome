package pfc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.text.TextEditorDrawView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile f f529047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f529048i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f529049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f529050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f529051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f529052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap f529053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f529054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f529055g;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Matrix f529056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f529057b;

        public a() {
        }

        public void a() {
        }

        public void b(Canvas r100) {
        }

        public abstract b c(b r100);

        public abstract Bitmap d();

        public abstract RectF e();

        public abstract RectF f();

        public boolean g() {
            return true;
        }

        public boolean h(PointF r100, RectF r101) {
            return false;
        }

        public boolean i() {
            return !(this instanceof TextEditorDrawView.g);
        }

        public boolean j() {
            return false;
        }

        public void k() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f529058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RectF f529059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f529060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f529061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f529062e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f529063f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Canvas f529064g;

        public b(b r100) {
            this.f529062e = r100.f529062e;
            this.f529058a = new RectF(r100.f529058a);
            this.f529059b = new RectF(r100.f529059b);
            this.f529060c = r100.f529060c;
            this.f529061d = r100.f529061d;
            this.f529063f = Bitmap.createBitmap(r100.f529063f);
            this.f529064g = new Canvas(this.f529063f);
        }

        public final void a(a r100) {
            if (f.f529048i == true) goto L8;
            if (r100.g() == true) goto L8;
            return;
        L8:
            if (r100.f529056a == null) goto L10;
            long r101 = System.currentTimeMillis();
            Canvas r102 = this.f529064g;
            Paint r103 = new Paint();
            r103.setAntiAlias(true);
            r103.setFilterBitmap(true);
            r102.drawBitmap(r100.d(), r100.f529056a, r103);
            Log.i("EditActionManager", "apply : draw to parent use = " + (System.currentTimeMillis() - r101));
        L10:
            r100.b(this.f529064g);
        }

        public b(Bitmap r100, RectF r101, RectF r102) {
            this.f529062e = r100;
            this.f529058a = new RectF(r101);
            this.f529059b = new RectF(r102);
            this.f529060c = 0;
            this.f529061d = false;
            this.f529063f = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
            this.f529064g = new Canvas(this.f529063f);
        }
    }

    public interface c {
    }

    public static f i() {
        if (f529047h != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f529047h != null) goto L9;
        f529047h = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f529047h;
    }

    public final b e() {
        Bitmap r100 = this.f529053e;
        if (r100 != null) goto L5;
        r100 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        n.f529087a.e();
    L5:
        RectF r101 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        return new b(r100, r101, r101);
    }

    public final a f() {
        if (this.f529049a.size() <= 0) goto L6;
        ArrayList<a> r100 = this.f529049a;
        return (a) ListProtector.get(r100, r100.size() - 1);
    L6:
        return null;
    }

    public final int g() {
        int r100 = ((ArrayList) this.f529051c).size() - 1;
    L3:
        if (r100 < 0) goto L8;
        if (((a) ListProtector.get(this.f529051c, r100)).f529057b != null) goto L6;
        r100 = r100 - 1;
        goto L3
    L6:
        return r100;
    L8:
        return -1;
    }

    public final a k() {
        if (this.f529049a.size() <= 0) goto L11;
        ArrayList<a> r100 = this.f529049a;
        a r101 = (a) ListProtector.get(r100, r100.size() - 1);
        if (r101.i() == true) goto L7;
        ((ArrayList) this.f529050b).remove(r101);
        ArrayList<a> r102 = this.f529049a;
        ListProtector.remove(r102, r102.size() - 1);
        r101.k();
    L12:
        c r103 = this.f529052d;
        if (r103 == null) goto L18;
        p r104 = (p) r103;
        if ((this.f529049a.size() - this.f529055g) > 0) goto L17;
        r104.f529092a.f529110l.setEnabled(false);
        goto L18
    L17:
        r104.f529092a.f529110l.setEnabled(true);
    L18:
        return r101;
    L7:
        if (((ArrayList) this.f529051c).size() <= this.f529055g) goto L11;
        ((ArrayList) this.f529051c).remove(r101);
        ArrayList<a> r105 = this.f529049a;
        ListProtector.remove(r105, r105.size() - 1);
        r101.k();
    L11:
        r101 = null;
        goto L12
    }

    public f() {
        this.f529055g = 0;
        this.f529054f = new Handler(Looper.getMainLooper());
        this.f529055g = 0;
        this.f529049a = new ArrayList();
        this.f529051c = new ArrayList();
        this.f529050b = new ArrayList();
        n.f529087a.i("call <init>");
    }

    public final b c() {
        int r100 = g();
        int r101 = -1;
        if (r100 != (-1)) goto L5;
        b r102 = e();
    L6:
        int r103 = r100 + 1;
        long r104 = System.currentTimeMillis();
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r103 >= ((ArrayList) this.f529051c).size()) goto L10;
        r106 = r106 + 1;
        r102.a((a) ListProtector.get(this.f529051c, r103));
        r103 = r103 + 1;
        goto L8
    L10:
        Log.i("EditActionManager", "For times = " + r106 + ", time = " + (System.currentTimeMillis() - r104));
        if (((ArrayList) this.f529050b).size() == 0) goto L27;
        long r107 = System.currentTimeMillis();
        int r108 = ((ArrayList) this.f529050b).size() - 1;
    L15:
        if (r108 < 0) goto L20;
        if (((a) ListProtector.get(this.f529050b, r108)).f529057b != null) goto L18;
        r108 = r108 - 1;
        goto L15
    L18:
        b r110 = ((a) ListProtector.get(this.f529050b, r108)).f529057b;
    L21:
        if (r110 == null) goto L23;
        r102.f529064g.drawBitmap(r110.f529063f, 0.0f, 0.0f, null);
        r101 = r108;
    L23:
        r101 = r101 + 1;
        if (r101 >= ((ArrayList) this.f529050b).size()) goto L26;
        r105 = r105 + 1;
        r102.a((a) ListProtector.get(this.f529050b, r101));
        goto L23
    L26:
        Log.i("EditActionManager", "For times = " + r105 + ", time = " + (System.currentTimeMillis() - r107));
        goto L27
    L20:
        r110 = null;
    L27:
        Iterator<a> r109 = this.f529049a.iterator();
    L29:
        if (r109.hasNext() == false) goto L31;
        a r111 = r109.next();
        r102.getClass();
        r102 = r111.c(r102);
        goto L29
    L31:
        return r102;
    L5:
        r102 = new b(((a) ListProtector.get(this.f529051c, r100)).f529057b);
        goto L6
    }

    public final b d() {
        b r100 = e();
        Iterator<a> r101 = this.f529049a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = r101.next();
        r100.getClass();
        r100 = r102.c(r100);
        goto L4
    L6:
        return r100;
    }

    public final Bitmap h() {
        b r100 = c();
        RectF r101 = new RectF(r100.f529058a);
        RectF r102 = new RectF(r100.f529059b);
        Bitmap r103 = r100.f529063f;
        Bitmap r104 = Bitmap.createBitmap(r103.getWidth(), r103.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        r105.drawBitmap(r100.f529062e, 0.0f, 0.0f, null);
        r105.drawBitmap(r103, 0.0f, 0.0f, null);
        float r106 = r104.getWidth() / r102.width();
        com.ss.android.photoeditor.util.b.f(r101, 0.0f, 0.0f, r106, r106);
        com.ss.android.photoeditor.util.b.f(r102, 0.0f, 0.0f, r106, r106);
        Bitmap r107 = Bitmap.createBitmap(Math.max((int) r101.width(), 1), Math.max((int) r101.height(), 1), Bitmap.Config.ARGB_8888);
        Canvas r108 = new Canvas(r107);
        Matrix r109 = new Matrix();
        r109.postTranslate(r102.left - r101.left, r102.top - r101.top);
        r108.drawBitmap(r104, r109, null);
        float r110 = r100.f529060c;
        if (r110 == 0.0f) goto L5;
        r109.reset();
        r109.postRotate(r110);
        r107 = Bitmap.createBitmap(r107, 0, 0, r107.getWidth(), r107.getHeight(), r109, true);
        r109.reset();
    L5:
        if (r107 == null) goto L7;
        Log.i("EditActionManager", "resultBitmap, width:" + r107.getWidth() + ", height:" + r107.getHeight());
    L7:
        return r107;
    }

    public final void a(a r100) {
        this.f529049a.add(r100);
        b r101 = i().d();
        if (r100.e() == null) goto L13;
        if (r100.f() == null) goto L13;
        RectF r102 = new RectF(r100.e());
        RectF r103 = new RectF(r100.f());
        RectF r104 = new RectF(r101.f529058a);
        RectF r105 = new RectF(r101.f529059b);
        float r106 = r101.f529063f.getWidth() / r105.width();
        com.ss.android.photoeditor.util.b.f(r105, 0.0f, 0.0f, r106, r106);
        com.ss.android.photoeditor.util.b.f(r104, 0.0f, 0.0f, r106, r106);
        float r107 = -r105.left;
        float r108 = -r105.top;
        r105.offset(r107, r108);
        r104.offset(r107, r108);
        if (((r101.f529060c / 90) % 2) != 0) goto L10;
        float r109 = r104.width();
        float r110 = r103.width();
    L11:
        float r111 = r109 / r110;
        com.ss.android.photoeditor.util.b.f(r103, 0.0f, 0.0f, r111, r111);
        com.ss.android.photoeditor.util.b.f(r102, 0.0f, 0.0f, r111, r111);
        float r112 = r104.centerX() - r103.centerX();
        float r113 = r104.centerY() - r103.centerY();
        r102.offset(r112, r113);
        r103.offset(r112, r113);
        r100.f529056a = new Matrix();
        float r114 = r102.width() / r100.e().width();
        r100.f529056a.postScale(r114, r114);
        r100.f529056a.postTranslate(r102.left, r102.top);
        r100.f529056a.postRotate(-r101.f529060c, r104.centerX(), r104.centerY());
        goto L13
    L10:
        r109 = r104.height();
        r110 = r103.width();
    L13:
        if (r100.i() == true) goto L15;
        ((ArrayList) this.f529050b).add(r100);
    L30:
        c r115 = this.f529052d;
        if (r115 == null) goto L41;
        p r116 = (p) r115;
        if ((this.f529049a.size() - this.f529055g) > 0) goto L35;
        r116.f529092a.f529110l.setEnabled(false);
        return;
    L35:
        r116.f529092a.f529110l.setEnabled(true);
        return;
    L41:
        return;
    L15:
        if ((((ArrayList) this.f529051c).size() - this.f529055g) <= 80) goto L25;
        b r117 = null;
        int r118 = 0;
    L18:
        if (r118 >= ((ArrayList) this.f529051c).size()) goto L25;
        a r119 = (a) ListProtector.get(this.f529051c, r118);
        b r120 = r119.f529057b;
        if (r120 == null) goto L24;
        if (r117 != null) goto L23;
        r120.f529062e = null;
        r120.f529063f = null;
        r119.f529057b = null;
        r117 = r120;
        goto L24
    L23:
        this.f529055g = r118 + 1;
    L24:
        r118 = r118 + 1;
    L25:
        ((ArrayList) this.f529051c).add(r100);
        if ((((ArrayList) this.f529051c).size() % 4) != 0) goto L30;
        this.f529054f.post(new e(this, r100));
        goto L30
    }

    public final boolean j(a r100) {
        int r101 = -1;
        if (r100 == null) goto L9;
        int r102 = this.f529049a.indexOf(r100);
        if (r102 != (-1)) goto L8;
        return true;
    L8:
        r101 = r102;
    L9:
        b r103 = e();
        int r104 = r101 + 1;
    L11:
        if (r104 >= this.f529049a.size()) goto L14;
        a r105 = (a) ListProtector.get(this.f529049a, r104);
        r103.getClass();
        r103 = r105.c(r103);
        r104 = r104 + 1;
        goto L11
    L14:
        return r103.f529061d;
    }

    public static void b(RectF r100, float r101, float r102) {
        RectF r103 = new RectF(r100);
        b r104 = i().d();
        PointF r105 = new PointF(r101, r102);
        RectF r106 = new RectF(r104.f529058a);
        RectF r107 = new RectF(r104.f529059b);
        if (((r104.f529060c / 90) % 2) != 0) goto L5;
        float r108 = r106.width();
        float r109 = r103.width();
    L6:
        float r110 = r108 / r109;
        com.ss.android.photoeditor.util.b.f(r103, 0.0f, 0.0f, r110, r110);
        r105.x *= r110;
        r105.y *= r110;
        com.ss.android.photoeditor.util.b.d(r103, -r104.f529060c, 0.0f, 0.0f);
        com.ss.android.photoeditor.util.b.c(r105, 0.0f, 0.0f, -r104.f529060c);
        float r111 = r106.centerX() - r103.centerX();
        float r112 = r106.centerY() - r103.centerY();
        r103.offset(r111, r112);
        float r113 = r105.x + r111;
        float r114 = r105.y + r112;
        r105.x = r113 - r107.left;
        r105.y = r114 - r107.top;
        RectF r115 = new RectF(0.0f, 0.0f, r107.width(), r107.height());
        ArrayList<a> r116 = i().f529049a;
        int r117 = r116.size() - 1;
    L7:
        if (r117 < 0) goto L19;
        a r118 = (a) ListProtector.get(r116, r117);
        if (r118.j() == false) goto L13;
        if (r118.h(r105, r115) == false) goto L13;
        r118.a();
        return;
    L13:
        r117 = r117 - 1;
        goto L7
    L19:
        return;
    L5:
        r108 = r106.height();
        r109 = r103.width();
        goto L6
    }
}
