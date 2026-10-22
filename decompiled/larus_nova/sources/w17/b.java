package w17;

import com.android.ttcjpaysdk.base.service.annotation.constants.Constants;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<e, w17.a> f557918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C8060b f557919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C8060b f557920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f557921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f557922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<e, e> f557923g;

    public class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f557924a;

        @Override // w17.d
        public final void a() {
        }

        public a(b r100) {
            this.f557924a = r100;
        }

        @Override // w17.d
        public final void f(e r100) {
            this.f557924a.f557920d.a(3);
        }

        @Override // w17.d
        public final void g(e r100) {
            this.f557924a.f557920d.a(2);
        }

        @Override // w17.d
        public final void h(e r100) {
            this.f557924a.f557920d.a(142);
        }

        @Override // w17.d
        public final void i(e r100) {
            this.f557924a.f557920d.a(4);
        }

        @Override // w17.d
        public final void l(e r100) {
            this.f557924a.f557920d.a(6);
        }

        @Override // w17.d
        public final void m(e r100) {
            this.f557924a.f557920d.a(8);
        }

        @Override // w17.d
        public final void b(int r100, e r101) {
            this.f557924a.f557920d.a(1);
        }

        @Override // w17.d
        public final void d(int r100, e r101) {
            this.f557924a.f557920d.a(254);
        }

        @Override // w17.d
        public final void e(e r100, e r101, byte[] r102) {
            this.f557924a.f557920d.a(33);
        }

        @Override // w17.d
        public final void j(e r100, int r101, e r102, byte[] r103) {
            this.f557924a.f557920d.a(34);
        }

        @Override // w17.d
        public final void k(int r100, e r101, int r102, int r103) {
            this.f557924a.f557920d.a(35);
        }

        @Override // w17.d
        public final void c(e r100, int r101, e r102, e r103, int r104, c[] r105, c[] r106) {
            this.f557924a.f557920d.a(32);
            w17.a r107 = new w17.a(r100, r102, r106);
            this.f557924a.f557918b.put(r100, r107);
        }
    }

    /* JADX INFO: renamed from: w17.b$b, reason: collision with other inner class name */
    public class C8060b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<Integer, Long> f557925a;

        public final String toString() {
            StringBuilder r100 = new StringBuilder("[");
            Iterator<Integer> r101 = this.f557925a.keySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            int r102 = r101.next().intValue();
            r100.append(String.format("k=%x v=%d,", new Object[]{Integer.valueOf(r102), this.f557925a.get(Integer.valueOf(r102))}));
            goto L4
        L6:
            r100.append("]");
            return r100.toString();
        }

        public C8060b() {
            this.f557925a = new HashMap();
        }

        public final void a(int r100) {
            Long r101 = this.f557925a.get(Integer.valueOf(r100));
            if (r101 != null) goto L5;
            r101 = 0L;
        L5:
            this.f557925a.put(Integer.valueOf(r100), Long.valueOf(r101.longValue() + 1));
        }
    }

    public b() {
        super(null);
        this.f557918b = new HashMap();
        this.f557919c = new C8060b();
        this.f557920d = new C8060b();
        this.f557921e = null;
        this.f557922f = null;
        this.f557923g = null;
        this.f557923g = new HashMap();
    }

    @Override // w17.g
    public final void b(String r100, int r101, long r102) {
    }

    @Override // w17.g
    public final void e(e r100, e r101, e r102, e r103, int r104, int r105, int r106, long r107) {
    }

    @Override // w17.g
    public final void f(int r100, int r101, e[] r102, int r103, long r104) {
    }

    @Override // w17.g
    public final void h(int r100, int r101, long r102, byte[] r103) {
    }

    @Override // w17.g
    public final void a() {
        r17.c.b("mRecord=" + this.f557919c, new Object[0]);
        r17.c.b("mHeapRecord=" + this.f557920d, new Object[0]);
        r17.c.b("mClassDump size=" + this.f557918b.size(), new Object[0]);
        r17.c.b("mActivityStringId=" + this.f557921e + " mActivityClassObjectId=" + this.f557922f, new Object[0]);
    }

    @Override // w17.g
    public final d c(int r100, int r101, long r102) {
        this.f557919c.a(28);
        return new a(this);
    L5:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // w17.g
    public final void g(e r100, String r101, int r102, long r103) {
        this.f557919c.a(1);
        if (this.f557921e == null) goto L5;
        return;
    L5:
        if (Constants.CJPAY_ACTIVITY.equals(r101) == false) goto L9;
        this.f557921e = r100;
        r17.c.b("find activity string id=" + this.f557921e, new Object[0]);
        this.f557922f = this.f557923g.get(this.f557921e);
        r17.c.b("find activity from cache object id=" + this.f557922f + " cache size=" + this.f557923g.size(), new Object[0]);
        this.f557923g.clear();
        return;
    }

    @Override // w17.g
    public final void d(int r100, e r101, int r102, e r103, int r104, long r105) {
        this.f557919c.a(2);
        e r106 = this.f557921e;
        if (r106 != null) goto L5;
        this.f557923g.put(r103, r101);
        return;
    L5:
        if (r106.equals(r103) == false) goto L9;
        this.f557922f = r101;
        r17.c.b("find activity object id=" + this.f557922f, new Object[0]);
        return;
    }
}
