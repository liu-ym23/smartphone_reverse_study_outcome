package ak5;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public final j a;
    public final h b;
    public final o c;
    public final CopyOnWriteArrayList<y> d;

    public static class a {
        public final CopyOnWriteArrayList<y> a;
        public j.a b;
        public h c;
        public okhttp3.h d;
        public boolean e;
        public long f;
        public Interceptor g;
        public int h;

        public final i a() {
            j.a r0 = this.b;
            x.j = r0.a;
            if ((r0 instanceof j.c) == false) goto L5;
            boolean r2 = this.e;
            ((j.c) r0).b = r2;
        L5:
            o r1 = new o(this.h);
            r1.c = this.g;
            r1.b = this.f;
            r1.e = this.d;
            return new i(r0, this.c, r1, this.a);
        }

        public a() {
            this.a = new CopyOnWriteArrayList();
            this.b = new j.c();
        }

        public final void b(int r2) {
            if (r2 != 4) goto L6;
            this.b = new j.d();
            return;
        L6:
            if (r2 != 5) goto L9;
            this.b = new j.e();
            return;
        L9:
            if (r2 != 2) goto L12;
            this.b = new j.f();
            return;
        L12:
            if (r2 != 6) goto L14;
            this.b = new j.b();
            return;
        L14:
            this.b = new j.c();
        }
    }

    public i(j r2, h r3, o r4, List<y> r5) {
        CopyOnWriteArrayList<y> r0 = new CopyOnWriteArrayList();
        this.d = r0;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        r0.addAll(r5);
    }
}
