package j0;

import android.view.animation.Interpolator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public abstract class a<K, A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<InterfaceC6374a> f496745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f496746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<K> f496747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<? extends v0.a<K>> f496748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f496749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v0.c<A> f496750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v0.a<K> f496751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public A f496752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f496753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f496754j;

    /* JADX INFO: renamed from: j0.a$a, reason: collision with other inner class name */
    public interface InterfaceC6374a {
        void a();
    }

    public static final class b<T> implements c<T> {
        @Override // j0.a.c
        public final boolean b(float r100) {
            return false;
        }

        @Override // j0.a.c
        public final float c() {
            return 1.0f;
        }

        @Override // j0.a.c
        public final float e() {
            return 0.0f;
        }

        @Override // j0.a.c
        public final boolean isEmpty() {
            return true;
        }

        @Override // j0.a.c
        public final v0.a<T> d() {
            throw new IllegalStateException("not implemented");
        }

        public b() {
        }

        @Override // j0.a.c
        public final boolean a(float r100) {
            throw new IllegalStateException("not implemented");
        }
    }

    public interface c<T> {
        boolean a(float r100);

        boolean b(float r100);

        float c();

        v0.a<T> d();

        float e();

        boolean isEmpty();
    }

    public static final class d<T> implements c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<? extends v0.a<T>> f496755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public v0.a<T> f496756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public v0.a<T> f496757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f496758d;

        @Override // j0.a.c
        public final boolean isEmpty() {
            return false;
        }

        @Override // j0.a.c
        public final float c() {
            List<? extends v0.a<T>> r100 = this.f496755a;
            return ((v0.a) ListProtector.get(r100, r100.size() - 1)).b();
        }

        @Override // j0.a.c
        public final float e() {
            return ((v0.a) ListProtector.get(this.f496755a, 0)).c();
        }

        @Override // j0.a.c
        public final v0.a<T> d() {
            return this.f496756b;
        }

        public d(List<? extends v0.a<T>> r100) {
            this.f496757c = null;
            this.f496758d = -1.0f;
            this.f496755a = r100;
            this.f496756b = f(0.0f);
        }

        @Override // j0.a.c
        public final boolean a(float r100) {
            v0.a<T> r101 = this.f496757c;
            v0.a<T> r102 = this.f496756b;
            if (r101 == r102) goto L5;
        L8:
            this.f496757c = r102;
            this.f496758d = r100;
            return false;
        L5:
            if (this.f496758d != r100) goto L8;
            return true;
        }

        @Override // j0.a.c
        public final boolean b(float r100) {
            if (this.f496756b.a(r100) == true) goto L5;
            this.f496756b = f(r100);
            return true;
        L5:
            if (this.f496756b.f552277d != null) goto L7;
            boolean r101 = true;
        L9:
            return !r101;
        L7:
            r101 = false;
            goto L9
        }

        public final v0.a<T> f(float r100) {
            List<? extends v0.a<T>> r101 = this.f496755a;
            v0.a<T> r102 = (v0.a) ListProtector.get(r101, r101.size() - 1);
            if (r100 < r102.c()) goto L5;
            return r102;
        L5:
            int r103 = this.f496755a.size() - 2;
        L6:
            if (r103 < 1) goto L15;
            v0.a<T> r104 = (v0.a) ListProtector.get(this.f496755a, r103);
            if (this.f496756b == r104) goto L13;
            if (r104.a(r100) == false) goto L13;
            return r104;
        L13:
            r103 = r103 - 1;
            goto L6
        L15:
            return (v0.a) ListProtector.get(this.f496755a, 0);
        }
    }

    public static final class e<T> implements c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v0.a<T> f496759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f496760b;

        @Override // j0.a.c
        public final boolean isEmpty() {
            return false;
        }

        @Override // j0.a.c
        public final float c() {
            return this.f496759a.b();
        }

        @Override // j0.a.c
        public final float e() {
            return this.f496759a.c();
        }

        @Override // j0.a.c
        public final v0.a<T> d() {
            return this.f496759a;
        }

        public e(List<? extends v0.a<T>> r100) {
            this.f496760b = -1.0f;
            this.f496759a = (v0.a) ListProtector.get(r100, 0);
        }

        @Override // j0.a.c
        public final boolean a(float r100) {
            if (this.f496760b != r100) goto L6;
            return true;
        L6:
            this.f496760b = r100;
            return false;
        }

        @Override // j0.a.c
        public final boolean b(float r100) {
            if (this.f496759a.f552277d != null) goto L5;
            boolean r101 = true;
        L7:
            return !r101;
        L5:
            r101 = false;
            goto L7
        }
    }

    public abstract A h(v0.a<K> r100, float r101);

    public void i() {
        int r100 = 0;
    L4:
        if (r100 >= ((ArrayList) this.f496745a).size()) goto L6;
        ((InterfaceC6374a) ListProtector.get(this.f496745a, r100)).a();
        r100 = r100 + 1;
        goto L4
    }

    public final v0.a<K> b() {
        if (r0.c.a.f535397a == false) goto L8;
        c<K> r100 = this.f496747c;
        if (r100 == null) goto L8;
        return r100.d();
    L8:
        v0.a<K> r101 = this.f496751g;
        if (r101 != null) goto L11;
    L14:
        List<? extends v0.a<K>> r102 = this.f496748d;
        v0.a<K> r103 = (v0.a) ListProtector.get(r102, r102.size() - 1);
        if (this.f496749e >= r103.c()) goto L22;
        int r104 = this.f496748d.size() - 1;
    L17:
        if (r104 < 0) goto L22;
        r103 = (v0.a) ListProtector.get(this.f496748d, r104);
        if (r103.a(this.f496749e) == true) goto L22;
        r104 = r104 - 1;
    L22:
        this.f496751g = r103;
        return r103;
    L11:
        if (r101.a(this.f496749e) == false) goto L14;
        return this.f496751g;
    }

    public float c() {
        if (r0.c.a.f535397a == false) goto L12;
        c<K> r100 = this.f496747c;
        if (r100 == null) goto L12;
        if (this.f496754j != (-1.0f)) goto L10;
        this.f496754j = r100.c();
    L10:
        return this.f496754j;
    L12:
        if (this.f496748d.isEmpty() == false) goto L14;
        return 1.0f;
    L14:
        List<? extends v0.a<K>> r101 = this.f496748d;
        return ((v0.a) ListProtector.get(r101, r101.size() - 1)).b();
    }

    public final float e() {
        if (this.f496746b == false) goto L5;
        return 0.0f;
    L5:
        v0.a<K> r100 = b();
        if (r100.f552277d != null) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return 0.0f;
    L12:
        return (this.f496749e - r100.c()) / (r100.b() - r100.c());
    L8:
        r101 = false;
        goto L9
    }

    public final float f() {
        if (r0.c.a.f535397a == false) goto L12;
        c<K> r100 = this.f496747c;
        if (r100 == null) goto L12;
        if (this.f496753i != (-1.0f)) goto L10;
        this.f496753i = r100.e();
    L10:
        return this.f496753i;
    L12:
        if (this.f496748d.isEmpty() == false) goto L15;
        return 0.0f;
    L15:
        return ((v0.a) ListProtector.get(this.f496748d, 0)).c();
    }

    public A g() {
        if (r0.c.a.f535397a == false) goto L15;
        if (this.f496747c == null) goto L15;
        float r100 = d();
        if (this.f496750f == null) goto L9;
    L12:
        A r101 = h(b(), r100);
        this.f496752h = r101;
        return r101;
    L9:
        if (this.f496747c.a(r100) == false) goto L12;
        return this.f496752h;
    L15:
        return h(b(), d());
    }

    public final float d() {
        Interpolator r100 = b().f552277d;
        if (r100 != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return 0.0f;
    L10:
        return r100.getInterpolation(e());
    L5:
        r101 = false;
        goto L6
    }

    public a(List<? extends v0.a<K>> r100) {
        this.f496745a = new ArrayList();
        this.f496746b = false;
        this.f496749e = 0.0f;
        this.f496752h = null;
        this.f496753i = -1.0f;
        this.f496754j = -1.0f;
        this.f496748d = r100;
        if (r0.c.a.f535397a == true) goto L5;
        return;
    L5:
        if (r100.isEmpty() == false) goto L8;
        c<K> r101 = new b();
    L12:
        this.f496747c = r101;
        return;
    L8:
        if (r100.size() != 1) goto L10;
        c<K> r102 = new e(r100);
    L11:
        r101 = r102;
        goto L12
    L10:
        r102 = new d(r100);
        goto L11
    }

    public final void a(InterfaceC6374a r100) {
        ((ArrayList) this.f496745a).add(r100);
    }

    public void j(float r100) {
        if (r0.c.a.f535397a == false) goto L10;
        c<K> r101 = this.f496747c;
        if (r101 == null) goto L10;
        if (r101.isEmpty() == false) goto L10;
        return;
    L10:
        if (r100 >= f()) goto L13;
        r100 = f();
    L16:
        if (r100 != this.f496749e) goto L18;
        return;
    L18:
        this.f496749e = r100;
        if (r0.c.a.f535397a == false) goto L25;
        c<K> r102 = this.f496747c;
        if (r102 == null) goto L25;
        if (r102.b(r100) == true) goto L25;
        return;
    L25:
        i();
        return;
    L13:
        if (r100 <= c()) goto L16;
        r100 = c();
        goto L16
    }

    public final void k(v0.c<A> r100) {
        v0.c<A> r101 = this.f496750f;
        if (r101 == null) goto L5;
        r101.getClass();
    L5:
        this.f496750f = r100;
    }
}
