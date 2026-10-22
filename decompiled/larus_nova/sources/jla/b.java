package jla;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import jla.b;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b<T extends b<T>> implements jla.a.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C6454b f499571m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f499572n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f499573o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f499574p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final f f499575q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f499576r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f499577s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f499578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f499579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f499580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f499581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jla.c f499582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f499583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f499584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f499585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f499586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f499587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<i> f499588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<j> f499589l;

    public class a extends k {
        public a() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getAlpha();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setAlpha(r101);
        }
    }

    /* JADX INFO: renamed from: jla.b$b, reason: collision with other inner class name */
    public class C6454b extends k {
        public C6454b() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getTranslationY();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setTranslationY(r101);
        }
    }

    public class c extends k {
        public c() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getScaleX();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setScaleX(r101);
        }
    }

    public class d extends k {
        public d() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getScaleY();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setScaleY(r101);
        }
    }

    public class e extends k {
        public e() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getRotation();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setRotation(r101);
        }
    }

    public class f extends k {
        public f() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getRotationX();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setRotationX(r101);
        }
    }

    public class g extends k {
        public g() {
        }

        @Override // jla.c
        public final float a(View r100) {
            return r100.getRotationY();
        }

        @Override // jla.c
        public final void b(View r100, float r101) {
            r100.setRotationY(r101);
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f499590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f499591b;

        public h() {
        }
    }

    public interface i {
        void a(b r100, boolean r101);
    }

    public interface j {
        void a(b r100, float r101, float r102);
    }

    public static abstract class k extends jla.c<View> {
        public k() {
        }
    }

    static {
        f499571m = new C6454b();
        f499572n = new c();
        f499573o = new d();
        f499574p = new e();
        f499575q = new f();
        f499576r = new g();
        f499577s = new a();
    }

    public final void a(boolean r100) {
        int r101 = 0;
        this.f499583f = false;
        ThreadLocal<jla.a> r102 = jla.a.f499559g;
        if (r102.get() != null) goto L5;
        r102.set(new jla.a());
    L5:
        jla.a r103 = r102.get();
        r103.f499560a.remove(this);
        int r104 = r103.f499561b.indexOf(this);
        if (r104 < 0) goto L8;
        ListProtector.set(r103.f499561b, r104, null);
        r103.f499565f = true;
    L8:
        this.f499586i = 0;
        this.f499580c = false;
    L10:
        if (r101 >= this.f499588k.size()) goto L15;
        if (ListProtector.get(this.f499588k, r101) == null) goto L14;
        ((i) ListProtector.get(this.f499588k, r101)).a(this, r100);
    L14:
        r101 = r101 + 1;
        goto L10
    L15:
        ArrayList<i> r105 = this.f499588k;
        int r106 = r105.size();
    L16:
        r106 = r106 - 1;
        if (r106 < 0) goto L21;
        if (ListProtector.get(r105, r106) != null) goto L16;
        ListProtector.remove(r105, r106);
        goto L16
    }

    public final void b(float r100) {
        this.f499582e.b(this.f499581d, r100);
        int r101 = 0;
    L4:
        if (r101 >= this.f499589l.size()) goto L9;
        if (ListProtector.get(this.f499589l, r101) == null) goto L8;
        ((j) ListProtector.get(this.f499589l, r101)).a(this, this.f499579b, this.f499578a);
    L8:
        r101 = r101 + 1;
        goto L4
    L9:
        ArrayList<j> r102 = this.f499589l;
        int r103 = r102.size();
    L10:
        r103 = r103 - 1;
        if (r103 < 0) goto L15;
        if (ListProtector.get(r102, r103) != null) goto L10;
        ListProtector.remove(r102, r103);
        goto L10
    }

    @Override // jla.a.b
    public final boolean doAnimationFrame(long r210) {
        long r100 = this.f499586i;
        if (r100 != 0) goto L6;
        this.f499586i = r210;
        b(this.f499579b);
        return false;
    L6:
        long r110 = r210 - r100;
        this.f499586i = r210;
        jla.d r101 = (jla.d) this;
        boolean r102 = true;
        if (r101.f499594v == false) goto L13;
        float r103 = r101.f499593u;
        if (r103 == Float.MAX_VALUE) goto L11;
        r101.f499592t.f499603i = r103;
        r101.f499593u = Float.MAX_VALUE;
    L11:
        r101.f499579b = (float) r101.f499592t.f499603i;
        r101.f499578a = 0.0f;
        r101.f499594v = false;
    L25:
        float r104 = Math.min(this.f499579b, this.f499584g);
        this.f499579b = r104;
        float r105 = Math.max(r104, this.f499585h);
        this.f499579b = r105;
        b(r105);
        if (r102 == false) goto L28;
        a(false);
    L28:
        return r102;
    L13:
        if (r101.f499593u == Float.MAX_VALUE) goto L15;
        jla.e r111 = r101.f499592t;
        double r106 = r111.f499603i;
        long r211 = r110 / 2;
        h r107 = r111.a(r101.f499579b, r101.f499578a, r211);
        jla.e r108 = r101.f499592t;
        r108.f499603i = r101.f499593u;
        r101.f499593u = Float.MAX_VALUE;
        h r109 = r108.a(r107.f499590a, r107.f499591b, r211);
        r101.f499579b = r109.f499590a;
        r101.f499578a = r109.f499591b;
    L16:
        float r112 = Math.max(r101.f499579b, r101.f499585h);
        r101.f499579b = r112;
        float r113 = Math.min(r112, r101.f499584g);
        r101.f499579b = r113;
        float r114 = r101.f499578a;
        jla.e r115 = r101.f499592t;
        r115.getClass();
        if (Math.abs(r114) < r115.f499599e) goto L19;
    L21:
        boolean r116 = false;
    L22:
        if (r116 == false) goto L24;
        r101.f499579b = (float) r101.f499592t.f499603i;
        r101.f499578a = 0.0f;
        goto L25
    L24:
        r102 = false;
        goto L25
    L19:
        if (Math.abs(r113 - ((float) r115.f499603i)) >= r115.f499598d) goto L21;
        r116 = true;
        goto L22
    L15:
        h r117 = r101.f499592t.a(r101.f499579b, r101.f499578a, r110);
        r101.f499579b = r117.f499590a;
        r101.f499578a = r117.f499591b;
        goto L16
    }

    public <K> b(K r100, jla.c<K> r101) {
        this.f499578a = 0.0f;
        this.f499579b = Float.MAX_VALUE;
        this.f499580c = false;
        this.f499583f = false;
        this.f499584g = Float.MAX_VALUE;
        this.f499585h = -3.4028235E38f;
        this.f499586i = 0;
        this.f499588k = new ArrayList();
        this.f499589l = new ArrayList();
        this.f499581d = r100;
        this.f499582e = r101;
        if (r101 != f499574p) goto L5;
    L19:
        this.f499587j = 0.1f;
        return;
    L5:
        if (r101 == f499575q) goto L19;
        if (r101 == f499576r) goto L19;
        if (r101 != f499577s) goto L13;
        this.f499587j = 0.00390625f;
        return;
    L13:
        if (r101 != f499572n) goto L15;
    L18:
        this.f499587j = 0.00390625f;
        return;
    L15:
        if (r101 == f499573o) goto L18;
        this.f499587j = 1.0f;
    }
}
