package qfc;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f532759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f532760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f532761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f532762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f532763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f532764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f532765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final pfc.w f532766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final pfc.b f532767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f532768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f532769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f532770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f532771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f532772n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C7324a f532773o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f532774p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f532775q;

    /* JADX INFO: renamed from: qfc.a$a, reason: collision with other inner class name */
    public class C7324a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532776a;

        @Override // qfc.a.d
        public int getType() {
            return 2;
        }

        public C7324a(a r100) {
            this.f532776a = r100;
        }

        @Override // qfc.a.d
        public final void a(MotionEvent r100) {
            this.f532776a.f532766h.a(r100);
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532777a;

        @Override // qfc.a.d
        public int getType() {
            return 1;
        }

        public b(a r100) {
            this.f532777a = r100;
        }

        @Override // qfc.a.d
        public final void a(MotionEvent r100) {
            a r101 = this.f532777a;
            RectF r102 = r101.f532761c;
            int r103 = r100.getAction();
            if (r103 != 0) goto L5;
            r101.f532760b = new PointF(r100.getX(), r100.getY());
            return;
        L5:
            if (r103 != 1) goto L7;
            Log.d("ActionHelper", "handleSingleTouchEvent ACTION_UP");
            if (r101.f532767i.a(r101.f532762d.a(), r101.f532761c) == true) goto L19;
            ((x.a) r101.f532763e).f532846a.f532845b.f449172a = false;
            return;
        L19:
            return;
        L7:
            if (r103 == 2) goto L10;
            return;
        L10:
            if (r101.f532760b != null) goto L12;
            r101.f532760b = new PointF(r100.getX(), r100.getY());
        L12:
            float r104 = r100.getX() - r101.f532760b.x;
            float r105 = r100.getY();
            PointF r106 = r101.f532760b;
            float r107 = r105 - r106.y;
            r106.set(r100.getX(), r100.getY());
            e r108 = r101.f532763e;
            y r109 = r101.f532762d;
            r109.f532856c.offset(r104, r107);
            ((x.a) r108).a(r109);
        }
    }

    public class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532778a;

        @Override // qfc.a.d
        public int getType() {
            return 0;
        }

        public c(a r100) {
            this.f532778a = r100;
        }

        @Override // qfc.a.d
        public final void a(MotionEvent r100) {
            w r101 = ((x.c) this.f532778a.f532765g).f532848a.f532845b.f449175d;
            r101.getClass();
            float r102 = r100.getX();
            float r103 = r100.getY();
            y r104 = r101.f532828k;
            if (r104.b() == false) goto L5;
            float r105 = r104.f532856c.x;
            float r106 = r104.f532854a.height();
        L6:
            float r107 = Math.min(r105 + (r106 / 2.0f), ((x.d) r101.f532831n).f532849a.f532845b.getWidth());
            y r108 = r101.f532828k;
            if (r108.b() == false) goto L9;
            float r109 = r108.f532856c.x;
            float r110 = r108.f532854a.height();
        L10:
            float r111 = Math.max(r109 - (r110 / 2.0f), 0.0f);
            if (r102 <= r107) goto L14;
            r102 = r107;
        L16:
            y r112 = r101.f532828k;
            if (r112.b() == false) goto L19;
            float r113 = r112.f532856c.y;
            float r114 = r112.f532854a.width();
        L20:
            float r115 = Math.min(r113 + (r114 / 2.0f), ((x.d) r101.f532831n).f532849a.f532845b.getHeight());
            y r116 = r101.f532828k;
            if (r116.b() == false) goto L23;
            float r117 = r116.f532856c.y;
            float r118 = r116.f532854a.width();
        L24:
            float r119 = Math.max(r117 - (r118 / 2.0f), 0.0f);
            if (r103 <= r115) goto L28;
            r103 = r115;
        L30:
            int r120 = r100.getAction();
            if (r120 == 0) goto L70;
            boolean r121 = true;
            if (r120 != 1) goto L35;
            RectF r122 = r101.e();
            RectF r123 = new RectF(r101.f532827j);
            if (Math.abs(r122.width() - r123.width()) >= 0.001f) goto L43;
            boolean r124 = true;
        L44:
            if (r124 == false) goto L46;
        L63:
            if (r121 == true) goto L67;
            w.a r125 = r101.f532818a;
            if (r125 == null) goto L118;
            r125.c(r101.f532842y);
        L118:
            ((x.d) r101.f532831n).f532849a.f532845b.invalidate();
            return;
        L67:
            w.c r126 = r101.f532832o;
            ((x.e) r126).f532850a.f532845b.f449176e.set(r101.f532827j);
            w.a r127 = r101.f532818a;
            if (r127 == null) goto L118;
            r127.b();
            goto L118
        L46:
            if (Math.abs(r122.height() - r123.height()) >= 0.001f) goto L48;
            boolean r128 = true;
        L49:
            if (r128 == true) goto L63;
            float r129 = ((x.g) r101.f532834q).f532853a.f532845b.f449183l.e() / r101.f532829l.width();
            y r130 = ((x.g) r101.f532834q).f532853a.f532845b.f449183l;
            if (r130.b() == false) goto L54;
            float r131 = r130.f532854a.width();
        L56:
            if (Math.max(r129, r131 / r101.f532829l.height()) < 3.0f) goto L63;
            if (r101.f532827j.width() >= r101.f532842y.width()) goto L60;
        L62:
            r121 = false;
            goto L63
        L60:
            if (r101.f532827j.height() < r101.f532842y.height()) goto L62;
        L54:
            r131 = r130.f532854a.height();
            goto L56
        L48:
            r128 = false;
            goto L49
        L43:
            r124 = false;
            goto L44
        L35:
            if (r120 != 2) goto L118;
            w.a r132 = r101.f532818a;
            if (r132 == null) goto L118;
            r132.a(r102, r103);
            goto L118
        L70:
            r101.f532842y = new RectF(r101.f532827j);
            if (r101.f532819b.contains(r102, r103) == true) goto L93;
            if (r101.f532820c.contains(r102, r103) == true) goto L93;
            if (r101.f532821d.contains(r102, r103) == true) goto L93;
            if (r101.f532822e.contains(r102, r103) == true) goto L93;
            if (r101.f532823f.contains(r102, r103) == true) goto L93;
            if (r101.f532824g.contains(r102, r103) == true) goto L93;
            if (r101.f532825h.contains(r102, r103) == true) goto L93;
            r101.f532826i.contains(r102, r103);
        L93:
            if (r101.f532819b.contains(r102, r103) == false) goto L96;
            w.a r133 = new r(r101);
        L117:
            r101.f532818a = r133;
            goto L118
        L96:
            if (r101.f532820c.contains(r102, r103) == false) goto L99;
            r133 = new s(r101);
            goto L117
        L99:
            if (r101.f532821d.contains(r102, r103) == false) goto L102;
            r133 = new t(r101);
            goto L117
        L102:
            if (r101.f532822e.contains(r102, r103) == false) goto L105;
            r133 = new u(r101);
            goto L117
        L105:
            if (r101.f532823f.contains(r102, r103) == false) goto L108;
            r133 = new v(r101);
            goto L117
        L108:
            if (r101.f532824g.contains(r102, r103) == false) goto L111;
            r133 = new l(r101);
            goto L117
        L111:
            if (r101.f532825h.contains(r102, r103) == false) goto L114;
            r133 = new k(r101);
            goto L117
        L114:
            if (r101.f532826i.contains(r102, r103) == false) goto L116;
            r133 = new m(r101);
            goto L117
        L116:
            r133 = null;
            goto L117
        L28:
            if (r103 >= r119) goto L30;
            r103 = r119;
            goto L30
        L23:
            r117 = r116.f532856c.y;
            r118 = r116.f532854a.height();
            goto L24
        L19:
            r113 = r112.f532856c.y;
            r114 = r112.f532854a.height();
            goto L20
        L14:
            if (r102 >= r111) goto L16;
            r102 = r111;
            goto L16
        L9:
            r109 = r108.f532856c.x;
            r110 = r108.f532854a.width();
            goto L10
        L5:
            r105 = r104.f532856c.x;
            r106 = r104.f532854a.width();
            goto L6
        }
    }

    public interface d {
        void a(MotionEvent r100);

        int getType();
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public static void a(RectF r100, RectF r101) {
        float r102 = r100.centerX();
        float r103 = r100.centerY();
        float r104 = Math.min(r101.height() / r100.height(), r101.width() / r100.width());
        r100.left = (int) (((r100.left - r102) * r104) + r102);
        r100.right = (int) (((r100.right - r102) * r104) + r102);
        r100.top = (int) (((r100.top - r103) * r104) + r103);
        r100.bottom = (int) (((r100.bottom - r103) * r104) + r103);
    }

    public a(RectF r100, y r101, RectF r102, x.a r103, x.b r104, x.c r105) {
        this.f532772n = false;
        this.f532773o = new C7324a(this);
        this.f532774p = new b(this);
        this.f532775q = new c(this);
        this.f532763e = r103;
        this.f532759a = r100;
        this.f532762d = r101;
        this.f532764f = r104;
        this.f532765g = r105;
        this.f532761c = r102;
        this.f532770l = r101.e() * 0.4f;
        this.f532771m = r101.e() * 2.5f;
        this.f532769k = true;
        this.f532767i = new pfc.b(new qfc.b(this));
        this.f532766h = new pfc.w(new qfc.c(this));
    }
}
